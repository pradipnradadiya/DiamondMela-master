package com.dealermela.utility;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


public class DmlButtonSemiBold extends android.support.v7.widget.AppCompatButton {
    public DmlButtonSemiBold(Context context) {
        super(context);
        setFont();
    }

    public DmlButtonSemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }

    public DmlButtonSemiBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_semibold.ttf");
        setTypeface(font, Typeface.NORMAL);
    }

}
