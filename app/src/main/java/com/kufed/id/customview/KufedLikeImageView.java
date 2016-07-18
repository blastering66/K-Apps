package com.kufed.id.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by macbook on 7/18/16.
 */
public class KufedLikeImageView extends ImageView {
    private boolean isSelected;

    public KufedLikeImageView(Context context) {
        super(context);
    }

    public KufedLikeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KufedLikeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
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
