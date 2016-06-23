package com.kufed.id.util;

import com.kufed.id.rest.Rest_Adapter;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by macbook on 6/1/16.
 */
public class Public_Functions {

    public static Rest_Adapter initRetrofit(){
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(270, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(270, TimeUnit.SECONDS);

        Retrofit retrofit_test = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
                .baseUrl(Param_Collection.BASE_URL).build();
        Rest_Adapter adapter = retrofit_test.create(Rest_Adapter.class);
        return adapter;
    }
}
