package com.kufed.id.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kufed.id.customadapter.RVAdapter_Search;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.customview.KufedTextViewTitle;
import com.kufed.id.pojo.PojoResultSearch;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 7/13/16.
 */
public class SearchResultsActivity extends AppCompatActivity{
    @Bind(R.id.rv)RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter layoutAdapter;
    List<PojoResultSearch.Datum> data;
    String result, access_token;
    SharedPreferences spf;
    Toolbar toolbar;
    @OnClick(R.id.img_back) public void click_back(){
       finish();
    }
    @Bind(R.id.tv_title_custom)KufedTextViewTitle tv_title_custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        ButterKnife.bind(this);

        result = getIntent().getStringExtra("CatId");
        tv_title_custom.setText("Result for " + result);
        spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

        Rest_Adapter adapter = Public_Functions.initRetrofit();
        Observable<PojoResultSearch> observable = adapter.search_product(result, access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<PojoResultSearch>() {
            @Override
            public void onCompleted() {
                layoutManager = new GridLayoutManager(getApplicationContext(), 2);
                layoutAdapter = new RVAdapter_Search(getApplicationContext(), data);
                rv.setAdapter(layoutAdapter);
                rv.setLayoutManager(layoutManager);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("ERROR", e.getMessage().toString());

            }

            @Override
            public void onNext(PojoResultSearch pojoResultSearch) {
                if(pojoResultSearch.getStatus().getCode() == 200 && pojoResultSearch.getData().size() > 0){
                    data = pojoResultSearch.getData();
                }

            }
        });


    }
}
