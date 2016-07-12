package com.kufed.id.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Spinner;

import com.kufed.id.util.Font;

/**
 * Created by macbook on 6/8/16.
 */
public class KufedSpinner extends Spinner{
    Context context;

    public KufedSpinner(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public KufedSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public KufedSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        if (!isInEditMode()) {
        }
    }
}
