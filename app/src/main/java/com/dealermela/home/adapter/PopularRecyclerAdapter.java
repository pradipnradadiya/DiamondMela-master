package com.dealermela.home.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dealermela.R;
import com.dealermela.home.model.PopularProductItem;
import com.dealermela.listing_and_detail.activity.ProductDetailAct;
import com.dealermela.listing_and_detail.model.ListingItem;
import com.dealermela.retrofit.APIClient;
import com.dealermela.retrofit.ApiInterface;
import com.dealermela.util.AppConstants;
import com.dealermela.util.AppLogger;
import com.dealermela.util.CommonUtils;
import com.google.gson.JsonObject;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.dealermela.home.activity.MainActivity.customerId;
import static com.dealermela.listing_and_detail.activity.FilterAct.filterFlag;

public class PopularRecyclerAdapter extends RecyclerView.Adapter<PopularRecyclerAdapter.ViewHolder> {

    private final Activity activity;
    private final List<PopularProductItem.ProductImg> itemArrayList;
    private KProgressHUD hud;

    public PopularRecyclerAdapter(Activity activity, List<PopularProductItem.ProductImg> itemArrayList) {
        super();
        this.activity = activity;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.act_popular_product_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        if (itemArrayList.get(i).getTypeId().equalsIgnoreCase("simple")) {
            if (Integer.parseInt(itemArrayList.get(i).getQty()) > 1) {
                holder.tvQty.setVisibility(View.VISIBLE);
                holder.tvQty.setText("QTY " + itemArrayList.get(i).getQty());
            } else {
                holder.tvQty.setVisibility(View.GONE);
            }
        } else {
            holder.tvQty.setVisibility(View.GONE);
        }


        if (itemArrayList.get(i).getStock().equalsIgnoreCase("0")) {
//            holder.tvSoldOut.setVisibility(View.VISIBLE);
            holder.tvSoldOut.setVisibility(View.GONE);
            holder.tvStockIn.setVisibility(View.GONE);
        } else if (itemArrayList.get(i).getStock().equalsIgnoreCase("1")) {
            holder.tvSoldOut.setVisibility(View.GONE);
            holder.tvStockIn.setVisibility(View.GONE);
//            holder.tvStockIn.setVisibility(View.VISIBLE);
        }

        holder.tvName.setText(itemArrayList.get(i).getName());
        String[] sku = itemArrayList.get(i).getSku().split(" ");

        AppLogger.e("sku", "------------" + itemArrayList.get(i).getSku());
        AppLogger.e("sku", "------------" + sku);
        StringBuilder stringBuilder = new StringBuilder();

        for (int j = 0; j <= sku.length - 1; j++) {

            if (j == 1) {
                stringBuilder.append(sku[j]);
                stringBuilder.append(" ");
            }

            /*if (j > 1) {
                stringBuilder.append(sku[j].charAt(0));
            }*/
        }

        float price = itemArrayList.get(i).getCustomPrice();
        holder.tvPrice.setText(CommonUtils.priceFormat(price));
        holder.tvSku.setText(sku[0]);

        holder.tvGold.setText(stringBuilder);

        Glide.with(activity)
                .load(AppConstants.IMAGE_URL + "catalog/product" + itemArrayList.get(i).getThumbnail())
                .apply(new RequestOptions().placeholder(R.drawable.dml_logo).error(R.drawable.dml_logo))
                .into(holder.imgProduct);


        if (itemArrayList.get(i).getDownload_flag() == 1) {
            holder.imgDownload.setEnabled(false);
        } else if (itemArrayList.get(i).getDownload_flag() == 0) {
            holder.imgDownload.setEnabled(true);
        }
        holder.imgDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadProduct(customerId, itemArrayList.get(i).getEntityId());
                itemArrayList.get(i).setDownload_flag(1);
                notifyItemChanged(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        final TextView tvQty;
        final TextView tvSoldOut;
        final TextView tvStockIn;
        final TextView tvName;
        final TextView tvPrice;
        final TextView tvSku;
        final TextView tvGold;
        final ImageView imgDownload;
        final ImageView imgProduct;

        ViewHolder(View itemView) {
            super(itemView);

            tvQty = itemView.findViewById(R.id.tvQty);
            tvStockIn = itemView.findViewById(R.id.tvStockIn);
            tvSoldOut = itemView.findViewById(R.id.tvSoldOut);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvSku = itemView.findViewById(R.id.tvSku);
            tvGold = itemView.findViewById(R.id.tvGold);
            imgDownload = itemView.findViewById(R.id.imgDownload);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, ProductDetailAct.class);
            intent.putExtra(AppConstants.NAME, itemArrayList.get(getAdapterPosition()).getEntityId());
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }


    }

    private void downloadProduct(String customerId, String productId) {
        //show progress
        hud = KProgressHUD.create(activity)
                .setCancellable(false)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);

        AppLogger.e("customerId", "--------" + customerId);
        AppLogger.e("productId", "--------" + productId);

        Call<JsonObject> callApi = apiInterface.downloadProduct(customerId, productId);
        callApi.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                assert response.body() != null;
                hud.dismiss();
                AppLogger.e(AppConstants.RESPONSE, "-----------" + response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body().toString());
                    if (jsonObject.getString("status").equalsIgnoreCase(AppConstants.STATUS_CODE_SUCCESS)) {
                        CommonUtils.showSuccessToast(activity, "Product added in download list");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                AppLogger.e("error", "-----------" + t.getMessage());
                hud.dismiss();
            }

        });

    }

}
