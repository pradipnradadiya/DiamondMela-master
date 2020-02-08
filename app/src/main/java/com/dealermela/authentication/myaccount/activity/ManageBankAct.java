package com.dealermela.authentication.myaccount.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dealermela.DealerMelaBaseActivity;
import com.dealermela.R;
import com.dealermela.authentication.myaccount.adapter.BankRecyclerAdapter;
import com.dealermela.authentication.myaccount.model.BankResponse;
import com.dealermela.retrofit.APIClient;
import com.dealermela.retrofit.ApiInterface;
import com.dealermela.util.AppConstants;
import com.dealermela.util.AppLogger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.dealermela.home.activity.MainActivity.customerId;

public class ManageBankAct extends DealerMelaBaseActivity {
    private RecyclerView recycleViewBankList;
    private BankRecyclerAdapter bankRecyclerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.act_manage_bank;
    }

    @Override
    public void init() {

    }

    @Override
    public void initView() {
        bindToolBar("Manage Bank");
        recycleViewBankList = findViewById(R.id.recycleViewBankList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ManageBankAct.this);
        recycleViewBankList.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void postInitView() {

    }

    @Override
    public void addListener() {

    }

    @Override
    public void loadData() {
        getBankList();
    }

    private void getBankList() {
        showProgressDialog(AppConstants.PLEASE_WAIT);
        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);
        Call<BankResponse> callApi = apiInterface.listBankDetail(customerId);
        callApi.enqueue(new Callback<BankResponse>() {
            @Override
            public void onResponse(@NonNull Call<BankResponse> call, @NonNull Response<BankResponse> response) {
                Log.e(AppConstants.RESPONSE, "-----------------" + response.body());
                assert response.body() != null;
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getData()!=null) {
                        bankRecyclerAdapter = new BankRecyclerAdapter(ManageBankAct.this, response.body().getData());
                        recycleViewBankList.setAdapter(bankRecyclerAdapter);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<BankResponse> call, @NonNull Throwable t) {
                AppLogger.e(TAG, "------------" + t.getMessage());
                hideProgressDialog();
            }

        });
    }


}
