package com.kufed.id.customview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.kufed.id.activity.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by macbook on 7/14/16.
 */
public class KufedDialogCategoryHome_Test extends Dialog {
    @Bind(R.id.wrapper_cat_featured) View wrapper_featured;
    @Bind(R.id.wrapper_cat_trending)View wrapper_trending;
    @Bind(R.id.wrapper_cat_recomendation) View wrapper_recom;
    @Bind(R.id.wrapper_cat_following) View wrapper_following;

    @Bind(R.id.cat_check_featured)ImageView img_featured;
    @Bind(R.id.cat_check_trending)ImageView img_trending;
    @Bind(R.id.cat_check_recomendation)ImageView img_recom;
    @Bind(R.id.cat_check_following)ImageView img_following;

    @OnClick(R.id.wrapper_cat_featured) public void clickFeature(){

    }
    @OnClick(R.id.wrapper_cat_trending) public void clickTrending(){

    }

    public KufedDialogCategoryHome_Test(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ButterKnife.bind(this);
        setContentView(R.layout.layout_dialog_cat_home);
        setCanceledOnTouchOutside(true);

        WindowManager.LayoutParams param = getWindow().getAttributes();
        param.gravity = Gravity.TOP;



//        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//        alertDialog.setTitle(" ");
//        alertDialog.setMessage("");
//        alertDialog.setIcon(R.drawable.ic_menu_camera);
//        alertDialog.show();
    }
}
