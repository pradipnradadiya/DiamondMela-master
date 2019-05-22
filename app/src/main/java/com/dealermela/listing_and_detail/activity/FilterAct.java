package com.dealermela.listing_and_detail.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dealermela.DealerMelaBaseActivity;
import com.dealermela.R;
import com.dealermela.listing_and_detail.adapter.FilterRecyclerAdapter;
import com.dealermela.listing_and_detail.adapter.FilterTitleListAdapter;
import com.dealermela.listing_and_detail.model.FilterItem;
import com.dealermela.retrofit.APIClient;
import com.dealermela.retrofit.ApiInterface;
import com.dealermela.util.AppConstants;
import com.dealermela.util.AppLogger;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilterAct extends DealerMelaBaseActivity implements View.OnClickListener {
    private ListView listViewFilter;
    private FilterTitleListAdapter adapter;
    private FilterRecyclerAdapter filterRecyclerAdapter;
    private RecyclerView recycleViewFilterData;
    private LinearLayoutManager linearLayoutManager;
    private List<FilterItem.Datum> filterItems = new ArrayList<>();
    private EditText edText;
    private ImageView imgBack;
    private TextView tvReset;
    private Button btnApply;
    //    public static ArrayList<String> arrayListFilter = new ArrayList<>();
    public static HashMap<String, String> mapFilter = new HashMap<String, String>();
    public static HashMap<String, String> selectFilter = new HashMap<String, String>();
    public static String paramKey;
    public static int filterFlag = 0;
    private ProgressBar progressBarFilter;
    private HorizontalScrollView hsView;
    private GridLayout linContainer;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.act_filter;
    }

    @Override
    public void init() {
        Gson gson=new Gson();
        Intent intent = getIntent();

        Type listType = new TypeToken<List<FilterItem.Datum>>(){}.getType();
        filterItems= gson.fromJson(intent.getStringExtra(AppConstants.NAME), listType);


    }

    @Override
    public void initView() {
        imgBack = findViewById(R.id.imgBack);
        tvReset = findViewById(R.id.tvReset);
        listViewFilter = findViewById(R.id.listViewFilter);
        recycleViewFilterData = findViewById(R.id.recycleViewFilterData);
        edText = findViewById(R.id.edText);
        btnApply = findViewById(R.id.btnApply);
        progressBarFilter = findViewById(R.id.progressBarFilter);
        linContainer = findViewById(R.id.linContainer);
        hsView = findViewById(R.id.hsView);
        btnApply.setEnabled(false);
        progressBarFilter.setVisibility(View.GONE);
    }

    @Override
    public void postInitView() {
        linearLayoutManager = new LinearLayoutManager(FilterAct.this);
        recycleViewFilterData.setLayoutManager(linearLayoutManager);


        if (mapFilter.isEmpty()){

        }else{
            bindSelectFilter();
        }

    }

    @Override
    public void addListener() {
        imgBack.setOnClickListener(this);
        tvReset.setOnClickListener(this);
        btnApply.setOnClickListener(this);

        listViewFilter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.selectedPosition = position;
                adapter.notifyDataSetChanged();

                if (adapter.items.get(position).getOption_type().equalsIgnoreCase("text")) {
                    edText.setVisibility(View.VISIBLE);
                    recycleViewFilterData.setVisibility(View.GONE);
                    paramKey = filterItems.get(position).getOptionName();
                    if (mapFilter.containsKey(paramKey)) {
                        //key exists
                        String key = mapFilter.get(paramKey);
                        edText.setText(key);
                    } else {
                        //key does not exists
                        mapFilter.put(paramKey, "");
                        selectFilter.put(paramKey, "");

                    }


                } else {

                    edText.setVisibility(View.GONE);
                    recycleViewFilterData.setVisibility(View.VISIBLE);

                    paramKey = filterItems.get(position).getOptionName();
                    if (mapFilter.containsKey(paramKey)) {
                        //key exists
                    } else {
                        //key does not exists
                        mapFilter.put(paramKey, "");
                    }
                    filterRecyclerAdapter = new FilterRecyclerAdapter(FilterAct.this, filterItems.get(position).getOptionData());
                    recycleViewFilterData.setAdapter(filterRecyclerAdapter);

                }

            }
        });

        edText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mapFilter.put(paramKey, edText.getText().toString());
                selectFilter.put(paramKey, edText.getText().toString());

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public void loadData() {
//        setFilter();
        adapter = new FilterTitleListAdapter(FilterAct.this, filterItems);
        listViewFilter.setAdapter(adapter);
        tvReset.setEnabled(true);

        paramKey = filterItems.get(0).getOptionName();

        if (mapFilter.containsKey(paramKey)) {
            //key exists
        } else {
            //key does not exists
            mapFilter.put(paramKey, "");
            selectFilter.put(paramKey, "");
        }

        filterRecyclerAdapter = new FilterRecyclerAdapter(FilterAct.this, filterItems.get(0).getOptionData());
        recycleViewFilterData.setAdapter(filterRecyclerAdapter);

        btnApply.setEnabled(true);

    }

    public void setFilter() {
        progressBarFilter.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);
        Call<FilterItem> callApi = apiInterface.setFilter();
        callApi.enqueue(new Callback<FilterItem>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<FilterItem> call, @NonNull Response<FilterItem> response) {
                AppLogger.e(AppConstants.RESPONSE, "--------------" + response.body());
                assert response.body() != null;
                progressBarFilter.setVisibility(View.GONE);
                if (response.body().getStatus().equalsIgnoreCase(AppConstants.STATUS_CODE_SUCCESS)) {

                    filterItems.addAll(response.body().getData());
                    adapter = new FilterTitleListAdapter(FilterAct.this, response.body().getData());
                    listViewFilter.setAdapter(adapter);
                    tvReset.setEnabled(true);

                    paramKey = filterItems.get(0).getOptionName();

                    if (mapFilter.containsKey(paramKey)) {
                        //key exists
                    } else {
                        //key does not exists
                        mapFilter.put(paramKey, "");
                        selectFilter.put(paramKey, "");
                    }

                    filterRecyclerAdapter = new FilterRecyclerAdapter(FilterAct.this, filterItems.get(0).getOptionData());
                    recycleViewFilterData.setAdapter(filterRecyclerAdapter);

                    btnApply.setEnabled(true);

                }

            }

            @Override
            public void onFailure(@NonNull Call<FilterItem> call, @NonNull Throwable t) {
                progressBarFilter.setVisibility(View.GONE);
            }

        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvReset:
                mapFilter.clear();
                selectFilter.clear();
                bindSelectFilter();
                adapter = new FilterTitleListAdapter(FilterAct.this, filterItems);
                listViewFilter.setAdapter(adapter);

                paramKey = filterItems.get(0).getOptionName();
                filterRecyclerAdapter = new FilterRecyclerAdapter(FilterAct.this, filterItems.get(0).getOptionData());
                recycleViewFilterData.setAdapter(filterRecyclerAdapter);
                edText.setText("");

                break;

            case R.id.imgBack:
                filterFlag = 0;
                finish();
                break;

            case R.id.btnApply:
                /*for (Object key : mapFilter.keySet()) {
                    String value = mapFilter.get(key);

                    AppLogger.e("key", "--------" + key);
                    AppLogger.e("Value", "--------" + value);
                }*/

                if (mapFilter.isEmpty()) {
                    filterFlag = 0;
                } else {
                    filterFlag = 1;
                }
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        filterFlag = 0;
//        finish();
    }

    //add horizontal slide image
    public void bindSelectFilter() {
        linContainer.removeAllViews();
        View imageLayout;
        TextView tvSelectFilterName;
        ImageView imgClose;

        // Iterating keys using keySet()
        Set<String> filters = selectFilter.keySet();
        for(final String fil : filters) {

            if (!Objects.requireNonNull(selectFilter.get(fil)).equalsIgnoreCase("")){
                imageLayout = getLayoutInflater().inflate(R.layout.item_bind_select_filter, null);
                imgClose = imageLayout.findViewById(R.id.imgClose);
                tvSelectFilterName = imageLayout.findViewById(R.id.tvSelectFilterName);

                tvSelectFilterName.setText(selectFilter.get(fil));
                imgClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectFilter.put(fil,"");
                        mapFilter.put(fil,"");
                        bindSelectFilter();
                    }
                });
                System.out.println("Key : "  + fil + "\t\t" +
                        "Value : "  + selectFilter.get(fil));
                linContainer.addView(imageLayout);
            }

        }









        /*for (int i = 0; i < mapFilter.size(); i++) {
            imageLayout = getLayoutInflater().inflate(R.layout.item_bind_select_filter, null);
            imgClose = imageLayout.findViewById(R.id.imgClose);
            tvSelectFilterName = imageLayout.findViewById(R.id.tvSelectFilterName);

            imgClose.setOnClickListener(
                    onChagePageClickListener(i)
            );
            tvSelectFilterName.setText(String.valueOf(i));
            linContainer.addView(imageLayout);
        }*/
    }

    //horizontal slide image click
    private View.OnClickListener onChagePageClickListener(final int i) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

}
