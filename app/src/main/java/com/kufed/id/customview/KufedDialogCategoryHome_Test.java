package com.kufed.id.customview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.kufed.id.activity.R;

/**
 * Created by macbook on 7/14/16.
 */
public class KufedDialogCategoryHome_Test extends Dialog {

    public KufedDialogCategoryHome_Test(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
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
