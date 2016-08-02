package com.kufed.id.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kufed.id.customadapter.RVAdapter_CartList;
import com.kufed.id.customview.KufedButton;
import com.kufed.id.customview.KufedTextViewTitle;
import com.kufed.id.pojo.PojoResponseCheckout;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by macbook on 8/2/16.
 */
public class Detail_Cart extends AppCompatActivity {
    @Bind(R.id.rv)RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter layoutAdapter;
    @Bind(R.id.btn_checkout)
    KufedButton btn_checkout;
    @Bind(R.id.btn_continue)
    KufedButton btn_continue;
    String result, access_token;
    SharedPreferences spf;
    @OnClick(R.id.img_back) public void click_back(){
        finish();
    }
    @Bind(R.id.tv_title_custom)KufedTextViewTitle tv_title_custom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cart);
        ButterKnife.bind(this);

        tv_title_custom.setText("Detail Cart");
        spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

        Rest_Adapter rest_adapter = Public_Functions.initRetrofit();

        layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutAdapter = new RVAdapter_CartList(getApplicationContext(), rest_adapter, access_token);

        rv.setAdapter(layoutAdapter);
        rv.setLayoutManager(layoutManager);
    }
}
