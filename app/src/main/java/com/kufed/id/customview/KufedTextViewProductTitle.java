package com.kufed.id.customview;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import com.kufed.id.util.Font;

/**
 * Created by macbook on 6/8/16.
 */
public class KufedTextViewProductTitle extends TextView{
    Context context;

    public KufedTextViewProductTitle(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public KufedTextViewProductTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public KufedTextViewProductTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(Font.setTypeface_Oswald_Bold(context));

            if (Build.VERSION.SDK_INT >= 21) {

            }else{

            }
//            setLetterSpacing(0.2f);
        }
    }
}
