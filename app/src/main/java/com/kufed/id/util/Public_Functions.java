package com.kufed.id.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.kufed.id.activity.BuildConfig;
import com.kufed.id.activity.MainMenu;
import com.kufed.id.pojo.PojoAccessToken;
import com.kufed.id.rest.Rest_Adapter;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import id.co.veritrans.sdk.coreflow.core.SdkCoreFlowBuilder;
import id.co.veritrans.sdk.coreflow.core.VeritransSDK;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
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

        Retrofit retrofit_test = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
                .baseUrl(Param_Collection.BASE_URL).build();
        Rest_Adapter adapter = retrofit_test.create(Rest_Adapter.class);
        return adapter;
    }

    public static String refreshAccessToken(Rest_Adapter adapter,Context ctx,String access_token_before){

        Call<PojoAccessToken> call = adapter.call_refresh_access_token(Param_Collection.GRANT_TYPE_TOKENONLY, Param_Collection.CLIENT_ID,
                Param_Collection.CLIENT_SECRET, access_token_before);

        try{
            Response<PojoAccessToken> response_token =  call.execute();
            if(response_token.isSuccess()){
                if(response_token.body() != null){
                    SharedPreferences spf = ctx.getSharedPreferences(Param_Collection.SPF_NAME, Context.MODE_PRIVATE);
                    spf.edit().putString(Param_Collection.ACCESS_TOKEN, response_token.body().getData().getAccessToken())
                            .commit();
                    return response_token.body().getData().getAccessToken();
                }else{
                    return "";
                }
            }else{
                return "";
            }
        }catch (IOException e){
            return "";

        }

    }
}
