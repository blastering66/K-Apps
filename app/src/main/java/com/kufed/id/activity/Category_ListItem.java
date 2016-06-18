package com.kufed.id.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.kufed.id.customadapter.RVAdapter_ListProduct;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 6/18/16.
 */
public class Category_ListItem extends AppCompatActivity {
    @Bind(R.id.rv)RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter layoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rv_bg_white);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(getIntent().getStringExtra("category_name"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        layoutAdapter = new RVAdapter_ListProduct(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(layoutAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
