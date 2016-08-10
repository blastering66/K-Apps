package com.kufed.id.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.kufed.id.customadapter.RVAdapter_CartList;
import com.kufed.id.customview.KufedButton;
import com.kufed.id.customview.KufedTextViewTitle;
import com.kufed.id.pojo.PojoResponseCartList;
import com.kufed.id.pojo.PojoResponseCheckout;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import java.text.NumberFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
//import org.greenrobot.eventbus.Subscribe;
//import id.co.veritrans.sdk.coreflow.core.Constants;
//import id.co.veritrans.sdk.coreflow.core.LocalDataHandler;
//import id.co.veritrans.sdk.coreflow.core.SdkCoreFlowBuilder;
//import id.co.veritrans.sdk.coreflow.core.VeritransSDK;
//import id.co.veritrans.sdk.coreflow.eventbus.bus.VeritransBusProvider;
//import id.co.veritrans.sdk.coreflow.eventbus.callback.GetAuthenticationBusCallback;
//import id.co.veritrans.sdk.coreflow.eventbus.callback.TransactionBusCallback;
//import id.co.veritrans.sdk.coreflow.eventbus.callback.TransactionFinishedCallback;
//import id.co.veritrans.sdk.coreflow.eventbus.events.AuthenticationEvent;
//import id.co.veritrans.sdk.coreflow.eventbus.events.GeneralErrorEvent;
//import id.co.veritrans.sdk.coreflow.eventbus.events.NetworkUnavailableEvent;
//import id.co.veritrans.sdk.coreflow.eventbus.events.TransactionFailedEvent;
//import id.co.veritrans.sdk.coreflow.eventbus.events.TransactionFinishedEvent;
//import id.co.veritrans.sdk.coreflow.eventbus.events.TransactionSuccessEvent;
//import id.co.veritrans.sdk.uiflow.PaymentMethods;
import id.co.veritrans.android.api.VTDirect;
import id.co.veritrans.android.api.VTInterface.ITokenCallback;
import id.co.veritrans.android.api.VTModel.VTCardDetails;
import id.co.veritrans.android.api.VTModel.VTToken;
import id.co.veritrans.android.api.VTUtil.VTConfig;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 8/2/16.
 */
public class Detail_Cart extends AppCompatActivity {
    @Bind(R.id.rv)
    RecyclerView rv;
    @Bind(R.id.btn_checkout)
    KufedButton btn_checkout;
    @Bind(R.id.btn_continue)
    KufedButton btn_continue;
    String result, access_token;
    SharedPreferences spf;
    Rest_Adapter adapter;
    List<PojoResponseCartList.Detail> data_cart;
    @Bind(R.id.tv_total)
    KufedTextViewTitle tv_total;

    private String authTokenVeritrans;
    //    private VeritransSDK veritransSDK;
    RVAdapter_CartList layoutAdapter;
//
//    @OnClick(R.id.btn_checkout)
//    public void checkout() {
//        if (veritransSDK == null) initSDKVeritrans();
//        VeritransSDK.getVeritransSDK().getAuthenticationToken();
//    }

    private KufedButton mBtnCheckout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Register Veritrans Instance
//        VeritransBusProvider.getInstance().register(this);
        setContentView(R.layout.activity_detail_cart);
        ButterKnife.bind(this);


//        KufedButton btn_test = (KufedButton) findViewById(R.id.btn_checkout);
//        btn_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (veritransSDK == null) initSDKVeritrans();
//                VeritransSDK.getVeritransSDK().getAuthenticationToken();
////                Intent intent = new Intent(getApplicationContext(), Checkout_OnePage.class);
////                startActivity(intent);
//            }
//        });

//        initSDK(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setBackground(ContextCompat.getDrawable(MainMenu.this, R.drawable.bg_actionbar_gradient));
//        toolbar.setBackgroundColor(ContextCompat.getColor(MainMenu.this, android.R.color.black));
        setSupportActionBar(toolbar);

        LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());
        View view = mInflater.inflate(R.layout.layout_custom_toolbar_title, null);

        KufedTextViewTitle tv_title = (KufedTextViewTitle) view.findViewById(R.id.tv_title_custom);
        tv_title.setText("CART");
        toolbar.removeAllViews();
        toolbar.setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.addView(view);

        spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

        initComponent();
        getCartList();
    }

    private void initComponent() {
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        layoutAdapter = new RVAdapter_CartList(getApplicationContext(), adapter, access_token);
        rv.setAdapter(layoutAdapter);

        mBtnCheckout = (KufedButton) findViewById(R.id.btn_checkout);
        mBtnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payment();
            }
        });
    }

    private void payment() {
        
        VTConfig.CLIENT_KEY = Param_Collection.VT_CLIENT;
        VTConfig.VT_IsProduction = false;

        VTCardDetails cardDetails = new VTCardDetails();
        cardDetails.setCard_number("4811111111111114");
        cardDetails.setCard_cvv("123");
        cardDetails.setCard_exp_month(01);
        cardDetails.setCard_exp_year(2020);
        cardDetails.setGross_amount("30000");
        cardDetails.setSecure(true);

        VTDirect vtDirect = new VTDirect();
        vtDirect.setCard_details(cardDetails);

        vtDirect.getToken(new ITokenCallback() {
            @Override
            public void onSuccess(VTToken vtToken) {
                Log.e("token", vtToken.getToken_id());
            }

            @Override
            public void onError(Exception e) {
                Log.e("token", e.getMessage().toString());
            }
        });
    }

    private void initSDKVeritrans() {
        //Initial VeritransSDK


    }

    private void getCartList() {
        adapter = Public_Functions.initRetrofit();
        Observable<PojoResponseCartList> observable = adapter.get_cart_list(access_token);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoResponseCartList>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error CartList", e.getMessage().toString());
                        Toast.makeText(getApplicationContext(), "Failed get Cart List, Reason = " +
                                e.getMessage().toString(), Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onNext(PojoResponseCartList pojoResponseCartList) {
                        if (pojoResponseCartList.getStatus().getCode() == 200) {
                            if (pojoResponseCartList.getData().getCart().getDetail().size() > 0) {

                                layoutAdapter.addAll(pojoResponseCartList.getData().getCart().getDetail());
                                try {
                                    NumberFormat nf = NumberFormat.getNumberInstance();
                                    String cPrice = nf.format(pojoResponseCartList.getData().getCart().getTotalPrice());
                                    tv_total.setText("IDR " + cPrice);

                                } catch (NullPointerException e) {
                                    tv_total.setText("IDR ");
                                }

                            }
                        }
                    }
                });

    }

}
