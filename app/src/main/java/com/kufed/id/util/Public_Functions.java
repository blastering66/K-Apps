package com.kufed.id.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.kufed.id.activity.BuildConfig;
import com.kufed.id.activity.MainMenu;
import com.kufed.id.pojo.PojoAccessToken;
import com.kufed.id.rest.Rest_Adapter;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import id.co.veritrans.sdk.coreflow.core.SdkCoreFlowBuilder;
import id.co.veritrans.sdk.coreflow.core.VeritransSDK;
//import retrofit.GsonConverterFactory;
//import retrofit.Response;
import retrofit.RestAdapter;
//import retrofit.RxJavaCallAdapterFactory;
import retrofit.android.AndroidLog;
import retrofit.converter.GsonConverter;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/1/16.
 */
public class Public_Functions {

    public static Rest_Adapter initRetrofit(){
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(270, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(270, TimeUnit.SECONDS);

//        RestAdapter retrofit_test = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
//                .baseUrl(Param_Collection.BASE_URL).build();
//        Rest_Adapter adapter = retrofit_test.create(Rest_Adapter.class);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter()).create();

        RestAdapter adapter_ = new RestAdapter.Builder()
//                .setClient(okHttpClient)
                .setEndpoint(Param_Collection.BASE_URL).setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("=NETWORK="))
                .build();
        Rest_Adapter adapter = adapter_.create(Rest_Adapter.class);
        return adapter;
    }


}
