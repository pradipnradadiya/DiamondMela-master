package com.dealermela.inventary.activity;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.dealermela.DealerMelaBaseActivity;
import com.dealermela.R;
import com.dealermela.interfaces.RecyclerViewClickListener;
import com.dealermela.inventary.adapter.InventoryInvoiceAdapter;
import com.dealermela.inventary.model.InventoryInvoiceItem;
import com.dealermela.retrofit.APIClientLaravel;
import com.dealermela.retrofit.ApiInterface;
import com.dealermela.util.AppConstants;
import com.dealermela.util.AppLogger;

import java.util.ArrayList;
import java.util.Objects;

import static com.dealermela.home.activity.MainActivity.customerId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvoiceListAct extends DealerMelaBaseActivity {
    //page count
    private int page_count = 1;
    private RecyclerView recycleViewInvoiceList;
    private ArrayList<InventoryInvoiceItem.Datum> invoiceList = new ArrayList<>();
    private InventoryInvoiceAdapter inventoryInvoiceAdapter;
    boolean isLoading = false;
    private ProgressBar progressBar;
    private ConstraintLayout constraintNoData;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.act_invoice_list;
    }

    @Override
    public void init() {
        bindToolBar("Invoice List");
    }

    @Override
    public void initView() {
        constraintNoData = findViewById(R.id.constraintNoData);
        recycleViewInvoiceList = findViewById(R.id.recycleViewInvoiceList);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void postInitView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(InvoiceListAct.this);
        recycleViewInvoiceList.setLayoutManager(linearLayoutManager);
        inventoryInvoiceAdapter = new InventoryInvoiceAdapter(InvoiceListAct.this, invoiceList, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
            }

            @Override
            public void onLongClick(View view, int position) {
            }

            @Override
            public void onItemCheck(View view, int position) {
            }

            @Override
            public void onItemUnCheck(View view, int position) {
            }

        });
        recycleViewInvoiceList.setAdapter(inventoryInvoiceAdapter);
    }

    @Override
    public void addListener() {
        recycleViewInvoiceList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == invoiceList.size() - 1) {
                        //bottom of list!
                        page_count++;
                        getInvoiceList("complete", "");
                        isLoading = true;
                    }
                }
            }
        });
    }

    @Override
    public void loadData() {
        getInvoiceList("complete", "");
    }

    private void getInvoiceList(String invoiceStatus, String searchValue) {
        if (page_count != 1) {
            invoiceList.add(null);
            inventoryInvoiceAdapter.notifyItemInserted(invoiceList.size() - 1);
        }
        ApiInterface apiInterface = APIClientLaravel.getClient().create(ApiInterface.class);
        AppLogger.e("customerId", "-------" + customerId);
        Call<InventoryInvoiceItem> callApi = apiInterface.getInvoiseList(String.valueOf(page_count), invoiceStatus, searchValue, customerId);
        callApi.enqueue(new Callback<InventoryInvoiceItem>() {
            @Override
            public void onResponse(@NonNull Call<InventoryInvoiceItem> call, @NonNull Response<InventoryInvoiceItem> response) {
                AppLogger.e("response", "----------" + Objects.requireNonNull(response.body()).getStatus());
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equalsIgnoreCase(AppConstants.STATUS_CODE_SUCCESS)) {
                        if (page_count != 1) {
                            invoiceList.remove(invoiceList.size() - 1);
                            int scrollPosition = invoiceList.size();
                            inventoryInvoiceAdapter.notifyItemRemoved(scrollPosition);
                        }
                        invoiceList.addAll(response.body().getData());
                        inventoryInvoiceAdapter.notifyDataSetChanged();
                        isLoading = false;
                        progressBar.setVisibility(View.INVISIBLE);
                        constraintNoData.setVisibility(View.GONE);
                    } else if (response.body().getStatus().equalsIgnoreCase(AppConstants.STATUS_CODE_FAIL)) {
                        if (page_count != 1) {
                            invoiceList.remove(invoiceList.size() - 1);
                            int scrollPosition = invoiceList.size();
                            inventoryInvoiceAdapter.notifyItemRemoved(scrollPosition);
                        }else{
                            constraintNoData.setVisibility(View.VISIBLE);
                        }
                    } else {
                        progressBar.setVisibility(View.INVISIBLE);
                        if (!invoiceList.isEmpty()) {
                            constraintNoData.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<InventoryInvoiceItem> call, @NonNull Throwable t) {
                AppLogger.e("error", t.getMessage());
            }
        });
    }
}
