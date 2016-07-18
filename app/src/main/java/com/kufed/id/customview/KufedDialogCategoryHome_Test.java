package com.kufed.id.customview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.kufed.id.activity.R;
import com.kufed.id.util.Param_Collection;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by macbook on 7/14/16.
 */
public class KufedDialogCategoryHome_Test extends Dialog {
    public static int POSITION_FEATURED = 0;
    public static int POSITION_TRENDING = 1;
    public static int POSITION_RECOMEN = 2;
    public static int POSITION_FOLLOWING = 3;
    public static int POSITION_UNCHANGED = 9;
    SharedPreferences spf;

    private Context context;
    private Activity activity;
    @Bind(R.id.wrapper_cat_featured) RelativeLayout wrapper_featured;
    @Bind(R.id.wrapper_cat_trending)RelativeLayout wrapper_trending;
    @Bind(R.id.wrapper_cat_recomendation)
    RelativeLayout wrapper_recom;
    @Bind(R.id.wrapper_cat_following) RelativeLayout wrapper_following;

    @Bind(R.id.cat_check_featured)ImageView img_featured;
    @Bind(R.id.cat_check_trending)ImageView img_trending;
    @Bind(R.id.cat_check_recomendation)ImageView img_recom;
    @Bind(R.id.cat_check_following)ImageView img_following;

    @OnClick(R.id.wrapper_cat_featured) public void clickFeature(){
        spf.edit().putInt(Param_Collection.SPF_SELECTED_CATEGORY_MENU, POSITION_FEATURED).commit();
        dismiss();

    }
    @OnClick(R.id.wrapper_cat_trending) public void clickTrending(){
        spf.edit().putInt(Param_Collection.SPF_SELECTED_CATEGORY_MENU, POSITION_TRENDING).commit();
        dismiss();

    }
    @OnClick(R.id.wrapper_cat_recomendation) public void clickRecom(){
        spf.edit().putInt(Param_Collection.SPF_SELECTED_CATEGORY_MENU, POSITION_RECOMEN).commit();
        dismiss();

    }
    @OnClick(R.id.wrapper_cat_following) public void clickFollowing(){
        spf.edit().putInt(Param_Collection.SPF_SELECTED_CATEGORY_MENU, POSITION_FOLLOWING).commit();
        dismiss();

    }

    public KufedDialogCategoryHome_Test(Context context, Activity activity) {
        super(context);
        this.context = context;
        this.activity = activity;
    }

    @Override
    public void onBackPressed() {
        spf.edit().putInt(Param_Collection.SPF_SELECTED_CATEGORY_MENU, POSITION_UNCHANGED).commit();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        setContentView(R.layout.layout_dialog_cat_home);
        ButterKnife.bind(this);
        setCanceledOnTouchOutside(true);
        setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                spf.edit().putInt(Param_Collection.SPF_SELECTED_CATEGORY_MENU, POSITION_UNCHANGED).commit();
            }
        });

        spf = context.getSharedPreferences(Param_Collection.SPF_NAME, Context.MODE_PRIVATE);

        WindowManager.LayoutParams param = getWindow().getAttributes();
        param.gravity = Gravity.TOP;

        int selected_category = spf.getInt(Param_Collection.SPF_SELECTED_CATEGORY_MENU, 0);
        switch (selected_category){
            case 0:
                img_featured.setVisibility(View.VISIBLE);
                img_trending.setVisibility(View.GONE);
                img_recom.setVisibility(View.GONE);
                img_following.setVisibility(View.GONE);
                break;
            case 1:
                img_featured.setVisibility(View.GONE);
                img_trending.setVisibility(View.VISIBLE);
                img_recom.setVisibility(View.GONE);
                img_following.setVisibility(View.GONE);
                break;
            case 2:
                img_featured.setVisibility(View.GONE);
                img_trending.setVisibility(View.GONE);
                img_recom.setVisibility(View.VISIBLE);
                img_following.setVisibility(View.GONE);
                break;
            case 3:
                img_featured.setVisibility(View.GONE);
                img_trending.setVisibility(View.GONE);
                img_recom.setVisibility(View.VISIBLE);
                img_following.setVisibility(View.GONE);
                break;
        }

//        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//        alertDialog.setTitle(" ");
//        alertDialog.setMessage("");
//        alertDialog.setIcon(R.drawable.ic_menu_camera);
//        alertDialog.show();
    }
}
