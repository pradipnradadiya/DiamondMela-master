package com.dealermela.utility;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class DmlEditText extends android.support.v7.widget.AppCompatEditText {
    public DmlEditText(Context context) {
        super(context);
        setFont();
    }

    public DmlEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }

    public DmlEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_regular.ttf");
        setTypeface(font, Typeface.NORMAL);

    }

}
