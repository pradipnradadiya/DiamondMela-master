package com.dealermela.order.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dealermela.R;
import com.dealermela.order.activity.OrderDetailAct;
import com.dealermela.order.model.OrderDetailItem;
import com.dealermela.order.model.OrderItem;
import com.dealermela.util.AppConstants;
import com.dealermela.util.AppLogger;
import com.dealermela.util.CommonUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ViewHolder> {

    private final Activity activity;
    private final List<OrderDetailItem.OrderItem> itemArrayList;


    public OrderDetailAdapter(Activity activity, List<OrderDetailItem.OrderItem> itemArrayList) {
        super();
        this.activity = activity;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.act_order_detail_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        holder.tvProductName.setText(itemArrayList.get(i).getProductName());
        holder.tvSku.setText(Html.fromHtml("<b>" + "SKU : " + "</b> " + itemArrayList.get(i).getProductSku()));
        holder.tvMetalWeight.setText(Html.fromHtml("<b>" + "Metal Detail : " + "</b> " + itemArrayList.get(i).getProductMetalweight()));
        holder.tvStoneWeight.setText(Html.fromHtml("<b>" + "Stone Weight : " + "</b> " + itemArrayList.get(i).getProductStoneweight()));
        holder.tvStoneQuality.setText(Html.fromHtml("<b>" + "Product Type : " + "</b> " + itemArrayList.get(i).getProductType()));
        holder.tvQty.setText(Html.fromHtml("<b>" + "QTY : " + "</b> " + Math.round(Float.parseFloat(itemArrayList.get(i).getProduct_qty()))));
        holder.tvSubPrice.setText(CommonUtils.priceFormat(Float.parseFloat(itemArrayList.get(i).getProductPrice())));
        holder.tvPrice.setText(CommonUtils.priceFormat(Float.parseFloat(itemArrayList.get(i).getProductRawtotal())));
        holder.imgProduct.setImageURI(itemArrayList.get(i).getProductImg());
    }

    @Override
    public int getItemCount() {

        return itemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        final TextView tvProductName, tvSku, tvMetalWeight, tvStoneWeight, tvStoneQuality, tvQty, tvSubPrice, tvPrice;
        final SimpleDraweeView imgProduct;

        ViewHolder(View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvSku = itemView.findViewById(R.id.tvSku);
            tvMetalWeight = itemView.findViewById(R.id.tvMetalWeight);
            tvStoneWeight = itemView.findViewById(R.id.tvStoneWeight);
            tvStoneQuality = itemView.findViewById(R.id.tvStoneQuality);
            tvQty = itemView.findViewById(R.id.tvQty);
            tvSubPrice = itemView.findViewById(R.id.tvSubPrice);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }


    }


}
