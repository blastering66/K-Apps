package com.kufed.id.customview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.kufed.id.util.Font;

/**
 * Created by macbook on 6/8/16.
 */
public class KufedEditText extends EditText{
    Context context;

    public KufedEditText(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public KufedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public KufedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        if (!isInEditMode()) {
//            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/alte_haas_grotesk_bold.ttf");
            setTypeface(Font.setTypeface_Frutiger_Italic(context));
        }
    }
}
