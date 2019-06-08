package com.dealermela.listing_and_detail.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.dealermela.R;
import com.dealermela.listing_and_detail.activity.FilterAct;
import com.dealermela.listing_and_detail.model.FilterItem;
import com.dealermela.util.AppLogger;

import java.util.List;

import static com.dealermela.listing_and_detail.activity.FilterAct.mapFilter;
import static com.dealermela.listing_and_detail.activity.FilterAct.paramKey;
import static com.dealermela.listing_and_detail.activity.FilterAct.selectFilter;

public class FilterRecyclerAdapter extends RecyclerView.Adapter<FilterRecyclerAdapter.ViewHolder> {

    private final Activity activity;
    private final List<FilterItem.OptionDatum> itemArrayList;
    private int selectFlag = 0;

    public FilterRecyclerAdapter(Activity activity, List<FilterItem.OptionDatum> itemArrayList) {
        super();
        this.activity = activity;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.act_filter_item_recycler, viewGroup, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {

//        AppLogger.e("fliter arraylist", "-------------" + arrayListFilter);
        AppLogger.e("mapFilter", "-------------" + mapFilter);
        holder.radioFilter.setText(itemArrayList.get(i).getLabel());

        if (selectFlag == 0) {
            if (mapFilter.isEmpty()) {
                if (itemArrayList.get(i).isSelected()) {
                    holder.radioFilter.setChecked(true);
                } else {
                    holder.radioFilter.setChecked(false);
                }
            } else {
                String key = mapFilter.get(paramKey);

                assert key != null;
                if (key.equalsIgnoreCase(itemArrayList.get(i).getValue())) {
                    holder.radioFilter.setChecked(true);
                    itemArrayList.get(i).setSelected(true);
                } else {
                    holder.radioFilter.setChecked(false);
                    itemArrayList.get(i).setSelected(false);
                }

            }

        } else {
            if (itemArrayList.get(i).isSelected()) {
                holder.radioFilter.setChecked(true);
            } else {
                holder.radioFilter.setChecked(false);
            }
        }

    }


    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        final RadioButton radioFilter;

        ViewHolder(View itemView) {
            super(itemView);
            radioFilter = itemView.findViewById(R.id.radioFilter);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {

            selectFlag = 1;
            int pos = getAdapterPosition();

            if (itemArrayList.get(pos).isSelected()) {
                for (int i = 0; i < itemArrayList.size(); i++) {
                    FilterItem.OptionDatum optionDatum = itemArrayList.get(i);


                    optionDatum.setSelected(false);
//
                    mapFilter.put(paramKey, "");
                    selectFilter.put(paramKey, "");
                    ((FilterAct) activity).bindSelectFilter();

                }
                notifyDataSetChanged();
            } else {
                for (int i = 0; i < itemArrayList.size(); i++) {
                    FilterItem.OptionDatum optionDatum = itemArrayList.get(i);
                    if (i != pos) {

                        optionDatum.setSelected(false);
//                    arrayListFilter.remove(itemArrayList.get(i).getValue());

                        //arrayListFilter.remove(itemArrayList.get(getAdapterPosition()).getValue());

                    } else {
                        optionDatum.setSelected(true);
//                    arrayListFilter.add(itemArrayList.get(i).getValue());
                        mapFilter.put(paramKey, itemArrayList.get(i).getValue());
                        selectFilter.put(paramKey, itemArrayList.get(i).getLabel());
                        ((FilterAct) activity).bindSelectFilter();
//                    arrayListFilter.add(itemArrayList.get(getAdapterPosition()).getValue());
                    }
                }
                notifyDataSetChanged();
            }


        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }


    }


}
