package com.kufed.id.customview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.kufed.id.activity.R;

/**
 * Created by macbook on 8/1/16.
 */
public class KufedTextViewSlider extends KufedTextView {
    private boolean isSelected=false;

    public KufedTextViewSlider(Context context) {
        super(context);
    }

    public KufedTextViewSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KufedTextViewSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;

    }

}
