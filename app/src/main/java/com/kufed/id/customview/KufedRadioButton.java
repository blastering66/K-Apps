package com.kufed.id.customview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.kufed.id.util.Font;

/**
 * Created by macbook on 6/8/16.
 */
public class KufedRadioButton extends AppCompatRadioButton{
    Context context;

    public KufedRadioButton(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public KufedRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public KufedRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        if (!isInEditMode()) {
//            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/alte_haas_grotesk_bold.ttf");
            int textColor = Color.parseColor("#ffffff");
            setSupportButtonTintList(ColorStateList.valueOf(textColor));
            setTypeface(Font.setTypeface_Regular(context));
        }
    }
}
