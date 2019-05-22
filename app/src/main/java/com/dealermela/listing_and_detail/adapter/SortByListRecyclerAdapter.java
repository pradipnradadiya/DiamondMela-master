package com.dealermela.listing_and_detail.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dealermela.R;
import com.dealermela.listing_and_detail.activity.FilterAct;
import com.dealermela.listing_and_detail.activity.ListAct;
import com.dealermela.listing_and_detail.activity.ProductDetailAct;
import com.dealermela.listing_and_detail.model.FilterItem;

import java.util.List;


public class SortByListRecyclerAdapter extends RecyclerView.Adapter<SortByListRecyclerAdapter.ViewHolder> {

    private final Activity activity;
    private final List<FilterItem.SortBy> itemArrayList;

    public SortByListRecyclerAdapter(Activity activity, List<FilterItem.SortBy> itemArrayList) {
        super();
        this.activity = activity;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.act_list_item_sort_by, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        holder.tvSortTitle.setText(itemArrayList.get(i).getLabel());
    }

    @Override
    public int getItemCount() {

        return itemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        final TextView tvSortTitle;
        ViewHolder(View itemView) {
            super(itemView);
            tvSortTitle=itemView.findViewById(R.id.tvSortTitle);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ((ListAct)activity).sortValueGetAndDialogClose(itemArrayList.get(getAdapterPosition()).getValue());
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }


    }

}
