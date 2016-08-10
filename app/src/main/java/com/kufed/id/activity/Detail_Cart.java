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

import org.greenrobot.eventbus.Subscribe;

import java.text.NumberFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.veritrans.sdk.coreflow.core.Constants;
import id.co.veritrans.sdk.coreflow.core.LocalDataHandler;
import id.co.veritrans.sdk.coreflow.core.SdkCoreFlowBuilder;
import id.co.veritrans.sdk.coreflow.core.VeritransSDK;
import id.co.veritrans.sdk.coreflow.eventbus.bus.VeritransBusProvider;
import id.co.veritrans.sdk.coreflow.eventbus.callback.GetAuthenticationBusCallback;
import id.co.veritrans.sdk.coreflow.eventbus.events.AuthenticationEvent;
import id.co.veritrans.sdk.coreflow.eventbus.events.GeneralErrorEvent;
import id.co.veritrans.sdk.coreflow.eventbus.events.NetworkUnavailableEvent;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 8/2/16.
 */
public class Detail_Cart extends AppCompatActivity implements GetAuthenticationBusCallback {
    @Bind(R.id.rv)RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter layoutAdapter;
    @Bind(R.id.btn_checkout)
    KufedButton btn_checkout;
    @Bind(R.id.btn_continue)
    KufedButton btn_continue;
    String result, access_token;
    SharedPreferences spf;
    Rest_Adapter adapter;
    List<PojoResponseCartList.Detail> data_cart;
    @Bind(R.id.tv_total)KufedTextViewTitle tv_total;
    @OnClick(R.id.btn_checkout)public void checkout(){
//        VeritransSDK.getVeritransSDK().getAuthenticationToken();
//        if(authTokenIsAvaillable) {
//            Intent intent = new Intent(getApplicationContext(), Checkout_OnePage.class);
//            startActivity(intent);
//        }else{
//            Toast.makeText(getApplicationContext(), "Token not availlable", Toast.LENGTH_LONG).show();
//        }
    };

    public void getToken(View view){
        VeritransSDK.getVeritransSDK().getAuthenticationToken();
        if(authTokenIsAvaillable) {
            Intent intent = new Intent(getApplicationContext(), Checkout_OnePage.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Token not availlable", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        VeritransBusProvider.getInstance().unregister(this);
        super.onDestroy();
    }

    private String authTokenVeritrans;
    private boolean authTokenIsAvaillable;
    private void refreshAuthenticationContainer() {
        if(VeritransSDK.getVeritransSDK().readAuthenticationToken()!=null
                && !VeritransSDK.getVeritransSDK().readAuthenticationToken().equals("")) {
            authTokenVeritrans = VeritransSDK.getVeritransSDK().readAuthenticationToken();
            authTokenIsAvaillable = true;
        }else{
            authTokenIsAvaillable = false;
        }
    }

    @Subscribe
    @Override
    public void onEvent(AuthenticationEvent authenticationEvent) {
        String auth = authenticationEvent.getResponse().getxAuth();
        LocalDataHandler.saveString(Constants.AUTH_TOKEN, auth);
        refreshAuthenticationContainer();
    }
    @Subscribe
    @Override
    public void onEvent(NetworkUnavailableEvent networkUnavailableEvent) {
        Toast.makeText(getApplicationContext(), networkUnavailableEvent.toString(), Toast.LENGTH_LONG).show();

    }
    @Subscribe
    @Override
    public void onEvent(GeneralErrorEvent generalErrorEvent) {
        Toast.makeText(getApplicationContext(), generalErrorEvent.getMessage().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Register Veritrans Instance
        VeritransBusProvider.getInstance().register(this);
        setContentView(R.layout.activity_detail_cart);
        ButterKnife.bind(this);

        KufedButton btn_test = (KufedButton)findViewById(R.id.btn_checkout);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VeritransSDK.getVeritransSDK().getAuthenticationToken();
            }
        });

        //Initial VeritransSDK
        initSDK(this);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setBackground(ContextCompat.getDrawable(MainMenu.this, R.drawable.bg_actionbar_gradient));
//        toolbar.setBackgroundColor(ContextCompat.getColor(MainMenu.this, android.R.color.black));
        setSupportActionBar(toolbar);

        LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());
        View view = mInflater.inflate(R.layout.layout_custom_toolbar_title, null);

        KufedTextViewTitle tv_title = (KufedTextViewTitle)view.findViewById(R.id.tv_title_custom);
        tv_title.setText("CART");
        toolbar.removeAllViews();
        toolbar.setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.addView(view);

        spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

        getCartList();
        refreshAuthenticationContainer();
    }

    private void getCartList(){
        adapter = Public_Functions.initRetrofit();
        Observable<PojoResponseCartList> observable = adapter.get_cart_list(access_token);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoResponseCartList>() {
                    private boolean isSukses = false;
                    @Override
                    public void onCompleted() {
                        if(isSukses){
                            layoutManager = new LinearLayoutManager(getApplicationContext());
                            layoutAdapter = new RVAdapter_CartList(getApplicationContext(),data_cart, adapter, access_token);

                            rv.setAdapter(layoutAdapter);
                            rv.setLayoutManager(layoutManager);

                        }else{
                            Toast.makeText(getApplicationContext(), "Failed get Cart List", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error CartList", e.getMessage().toString());
                        Toast.makeText(getApplicationContext(), "Failed get Cart List, Reason = "+
                        e.getMessage().toString(), Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onNext(PojoResponseCartList pojoResponseCartList) {
                        if(pojoResponseCartList.getStatus().getCode() == 200){
                            if(pojoResponseCartList.getData().getCart().getDetail().size() > 0){
                                data_cart = pojoResponseCartList.getData().getCart().getDetail();
                                isSukses = true;

                                try{
                                    NumberFormat nf = NumberFormat.getNumberInstance();
                                    String cPrice = nf.format(pojoResponseCartList.getData().getCart().getTotalPrice());
                                    tv_total.setText("IDR " + cPrice);

                                }catch (NullPointerException e){
                                    tv_total.setText("IDR ");
                                }

                            }
                        }
                    }
                });

    }

    public static void initSDK(Activity activity){
        VeritransSDK veritransSDK = new SdkCoreFlowBuilder(activity, BuildConfig.CLIENT_KEY,
                BuildConfig.BASE_URL)
                .enableLog(true)
//                .setDefaultText("open_sans_regular.ttf")
//                .setSemiBoldText("open_sans_regular.ttf")
//                .setBoldText("open_sans_regular.ttf")
                .setMerchantName("Kufed")
                .buildSDK();
    }
}
