package com.dealermela.interfaces;

import android.view.View;

public interface RecyclerViewClickListener {
    void onClick(View view, int position);
    void onLongClick(View view, int position);
    void onItemCheck(View view, int position);
    void onItemUnCheck(View view, int position);
}
