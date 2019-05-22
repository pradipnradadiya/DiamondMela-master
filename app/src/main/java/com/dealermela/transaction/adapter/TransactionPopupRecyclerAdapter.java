package com.dealermela.transaction.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dealermela.R;
import com.dealermela.authentication.myaccount.model.BankResponse;
import com.dealermela.transaction.model.TransactionItem;
import com.dealermela.util.AppConstants;

import java.util.List;

public class TransactionPopupRecyclerAdapter extends RecyclerView.Adapter<TransactionPopupRecyclerAdapter.ViewHolder> {

    private final Activity activity;
    private final List<TransactionItem.OrderItem> itemArrayList;


    public TransactionPopupRecyclerAdapter(Activity activity, List<TransactionItem.OrderItem> itemArrayList) {
        super();
        this.activity = activity;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.act_transaction_item_dialog_popup_sub_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int i) {
        holder.tvOrderNo.setText(itemArrayList.get(i).getProductIncrementId());
        holder.tvName.setText(itemArrayList.get(i).getProductName());
        holder.tvSku.setText(itemArrayList.get(i).getProductSku());
        holder.tvStoneQuality.setText(itemArrayList.get(i).getProductStonequality()+"("+itemArrayList.get(i).getProductStoneweight()+")");
        holder.tvMetalWeight.setText(itemArrayList.get(i).getProductMetalweight());
        holder.tvPrice.setText(itemArrayList.get(i).getProductPrice());

    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        final TextView tvOrderNo, tvName, tvSku, tvStoneQuality, tvMetalWeight, tvPrice;

        ViewHolder(View itemView) {
            super(itemView);
            tvOrderNo = itemView.findViewById(R.id.tvOrderNo);
            tvName = itemView.findViewById(R.id.tvName);
            tvSku = itemView.findViewById(R.id.tvSku);
            tvStoneQuality = itemView.findViewById(R.id.tvStoneQuality);
            tvMetalWeight = itemView.findViewById(R.id.tvMetalWeight);
            tvPrice = itemView.findViewById(R.id.tvPrice);
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
