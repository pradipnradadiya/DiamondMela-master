package com.dealermela.order.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dealermela.DealerMelaBaseActivity;
import com.dealermela.R;
import com.dealermela.authentication.myaccount.model.LoginResponse;
import com.dealermela.order.adapter.OrderDetailAdapter;
import com.dealermela.order.model.OrderDetailItem;
import com.dealermela.order.model.OrderItem;
import com.dealermela.retrofit.APIClient;
import com.dealermela.retrofit.ApiInterface;
import com.dealermela.util.AppConstants;
import com.dealermela.util.AppLogger;
import com.dealermela.util.CommonUtils;
import com.dealermela.util.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.dealermela.home.activity.MainActivity.customerId;

public class OrderDetailAct extends DealerMelaBaseActivity implements View.OnClickListener {

    private TextView tvOrderDate, tvBillingAddress, tvShippingAddress, tvShippingMethod, tvPaymentMethod, tvSubTotal, tvShippingCharge, tvTax, tvGrandTotal,tvOrderStatus;
    private RecyclerView recycleViewOrderList;
    private String orderId,status;
    private ProgressBar progressBar;
    private LinearLayout linCancel, linPrintOrder,linearLayout;
    private KProgressHUD hud;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void init() {
        orderId = getIntent().getStringExtra(AppConstants.ORDER_ID);
        status = getIntent().getStringExtra("status");
        AppLogger.e("order id", "------------" + orderId);

    }

    @Override
    public void initView() {
        bindToolBar("Order View");
        tvOrderDate = findViewById(R.id.tvOrderDate);
        tvBillingAddress = findViewById(R.id.tvBillingAddress);
        tvShippingAddress = findViewById(R.id.tvShippingAddress);
        tvShippingMethod = findViewById(R.id.tvShippingMethod);
        tvPaymentMethod = findViewById(R.id.tvPaymentMethod);
        tvSubTotal = findViewById(R.id.tvSubTotal);
        tvShippingCharge = findViewById(R.id.tvShippingCharge);
        tvTax = findViewById(R.id.tvTax);
        tvGrandTotal = findViewById(R.id.tvGrandTotal);
        recycleViewOrderList = findViewById(R.id.recycleViewOrderList);
        progressBar = findViewById(R.id.progressBar);
        linCancel = findViewById(R.id.linCancel);
        linPrintOrder = findViewById(R.id.linPrintOrder);
        linearLayout = findViewById(R.id.linearLayout);
        tvOrderStatus = findViewById(R.id.tvOrderStatus);
    }

    @Override
    public void postInitView() {
        if (status.equalsIgnoreCase("Pending")){
            linPrintOrder.setVisibility(View.GONE);
        }else if(status.equalsIgnoreCase("Complete")){
            linCancel.setVisibility(View.GONE);
        }else if(status.equalsIgnoreCase("Canceled")){
//            linPrintOrder.setVisibility(View.GONE);
//            linCancel.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);

        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderDetailAct.this);
        recycleViewOrderList.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void addListener() {
        linCancel.setOnClickListener(this);
        linPrintOrder.setOnClickListener(this);
    }

    @Override
    public void loadData() {
        getOrderDetail();
    }

    private void getOrderDetail() {
        progressBar.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);
        Call<OrderDetailItem> callApi = apiInterface.orderDetail(orderId);
        callApi.enqueue(new Callback<OrderDetailItem>() {
            @Override
            public void onResponse(@NonNull Call<OrderDetailItem> call, @NonNull Response<OrderDetailItem> response) {
                assert response.body() != null;

                AppLogger.e(AppConstants.RESPONSE, "----------" + response.body());
                if (response.body().getStatus().equalsIgnoreCase(AppConstants.STATUS_CODE_SUCCESS)) {
                    progressBar.setVisibility(View.GONE);
                    tvOrderDate.setText("ORDER DATE : " + response.body().getData().get(0).getOrder_date());
                    tvOrderStatus.setText("ORDER STATUS : " + status);
                    tvBillingAddress.setText(response.body().getData().get(0).getBillingAddress());
                    tvShippingAddress.setText(response.body().getData().get(0).getShiipingAddress());
                    tvPaymentMethod.setText(response.body().getData().get(0).getPaymentMethod());
                    tvShippingMethod.setText(Html.fromHtml(response.body().getData().get(0).getShippingDescription()));

                    tvSubTotal.setText(CommonUtils.priceFormat(Float.parseFloat(response.body().getData().get(0).getOrderSubtotal())));
                    tvShippingCharge.setText(CommonUtils.priceFormat(Float.parseFloat(response.body().getData().get(0).getOrderShippingamount())));
                    tvTax.setText(CommonUtils.priceFormat(Float.parseFloat(response.body().getData().get(0).getOderTaxamount())));

                    if (response.body().getData().get(0).getOrderGrandtotal()==null){

                    }else{
                        tvGrandTotal.setText(CommonUtils.priceFormat(Float.parseFloat(response.body().getData().get(0).getOrderGrandtotal())));
                    }


                    OrderDetailAdapter orderDetailAdapter = new OrderDetailAdapter(OrderDetailAct.this, response.body().getData().get(0).getOrderItem());
                    recycleViewOrderList.setAdapter(orderDetailAdapter);
                }

            }

            @Override
            public void onFailure(@NonNull Call<OrderDetailItem> call, @NonNull Throwable t) {
                AppLogger.e("error", "------------" + t.getMessage());

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linCancel:
                cancelOrder(orderId);
                break;

            case R.id.linPrintOrder:
                printOrder(orderId);
                break;
        }
    }


    private void cancelOrder(String orderId) {

        //show progress
        hud = KProgressHUD.create(OrderDetailAct.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait");

        hud.show();

        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);
        Call<JsonObject> callApi = apiInterface.cancelOrder(orderId);
        callApi.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                assert response.body() != null;
                AppLogger.e(AppConstants.RESPONSE, "---------" + response.body());
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().toString());
                        if (jsonObject.getString("status").equalsIgnoreCase(AppConstants.STATUS_CODE_SUCCESS)) {
                            hud.dismiss();
                            linCancel.setVisibility(View.GONE);

                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                        hud.dismiss();
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                AppLogger.e("error", "------------" + t.getMessage());

            }
        });
    }

    private void printOrder(String orderId) {
        LoginResponse loginResponse;
        SharedPreferences sharedPreferences = new SharedPreferences(OrderDetailAct.this);
        Gson gson = new Gson();
        loginResponse = gson.fromJson(sharedPreferences.getLoginData(), LoginResponse.class);
        //show progress
        hud = KProgressHUD.create(OrderDetailAct.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait");

        hud.show();

        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);
        Call<JsonObject> callApi = apiInterface.printOrder(orderId,customerId,loginResponse.getData().getGroupId());
        callApi.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                assert response.body() != null;
                AppLogger.e(AppConstants.RESPONSE, "---------" + response.body());
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().toString());
                        if (jsonObject.getString("status").equalsIgnoreCase(AppConstants.STATUS_CODE_SUCCESS)) {
                            hud.dismiss();
                            String pdfUrl = jsonObject.getString("pdf");
                            Intent intent = new Intent(OrderDetailAct.this, OrderPrintAct.class);
                            intent.putExtra(AppConstants.NAME, pdfUrl);
                            startNewActivityWithIntent(intent);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        hud.dismiss();
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                AppLogger.e("error", "------------" + t.getMessage());

            }
        });
    }
}
