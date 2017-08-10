package com.feedme.feedme.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;

import com.feedme.feedme.R;

public class ButtonStyled extends AppCompatButton {
    private static final String TAG = "ButtonStyled";

    public ButtonStyled(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StyledFont, 0, 0);
        String customFont = ta.getString(R.styleable.StyledFont_family);
        String baseFont = ta.getString(R.styleable.StyledFont_weight);
        init(context, customFont, baseFont);
    }

    private boolean init(Context context, String customFont, String baseFont) {
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(context.getAssets(), "fonts/" + customFont + "-" + baseFont + ".ttf");
        } catch (Exception e) {
            Log.e(TAG, "Could not get typeface: " + e.getMessage());
            return false;
        }
        setTypeface(tf);
        return true;
    }
}