package com.kufed.id.customview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.kufed.id.activity.R;

/**
 * Created by macbook on 7/14/16.
 */
public class KufedDialogCategoryHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_cat_home);

        getSupportActionBar().hide();
//        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//        alertDialog.setTitle(" ");
//        alertDialog.setMessage("");
//        alertDialog.setIcon(R.drawable.ic_menu_camera);
//        alertDialog.show();
    }
}
