package com.kufed.id.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by macbook on 7/13/16.
 */
public class SearchResultsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rv_bg_white);

        String result = getIntent().getStringExtra("CatId");
        Toast.makeText(getApplicationContext(), "RESULT" + result, Toast.LENGTH_LONG).show();



    }
}
