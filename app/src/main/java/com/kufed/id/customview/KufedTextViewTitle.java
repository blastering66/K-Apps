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
public class KufedTextViewTitle extends TextView{
    Context context;

    public KufedTextViewTitle(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public KufedTextViewTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public KufedTextViewTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/alte_haas_grotesk_bold.ttf");
            setTypeface(Font.setTypeface_Regular(context));

            if (Build.VERSION.SDK_INT >= 21) {
                setLetterSpacing(0.1f);
            }else{

            }

        }
    }
}
