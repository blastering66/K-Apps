package com.kufed.id.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.kufed.id.pojo.PojoResponseVeritrans;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 8/5/16.
 */
public class Activity_Webview extends AppCompatActivity {
    private WebView webview;
    private String url, cToken, cBank, cTotalDonasi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_webview);

        url = getIntent().getStringExtra("url");
        cToken = getIntent().getStringExtra("token");
        cBank = getIntent().getStringExtra("bank");
        cTotalDonasi = getIntent().getStringExtra("total");

        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_UP:
                        if (!v.hasFocus()) {
                            v.requestFocus();
                        }
                        break;
                }
                return false;
            }
        });
        webview.setWebViewClient(new VtWebViewClient(cToken, cTotalDonasi));
        webview.loadUrl(url);
    }

    private class VtWebViewClient extends WebViewClient {

        String token;
        String price;

        public VtWebViewClient(String token, String price) {
            this.token = token;
            this.price = price;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.e("VtLog", url);
            if (url.startsWith(Param_Collection.getPaymentApiUrl() + "/callback/")) {
                Rest_Adapter adapter = Public_Functions.initRetrofit_VeritransCallback(url);
                Observable<PojoResponseVeritrans> observable = adapter.get_response_veritrans();
                observable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<PojoResponseVeritrans>() {
                            private boolean isSukses;
                            @Override
                            public void onCompleted() {

                                if(isSukses){
                                    setResult(RESULT_OK);
                                    finish();
                                }else{
                                    setResult(RESULT_CANCELED);
                                    finish();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                setResult(RESULT_CANCELED);
                                finish();
                            }

                            @Override
                            public void onNext(PojoResponseVeritrans pojoResponseVeritrans) {
                                if(pojoResponseVeritrans.getStatusCode().equals("200")){
                                    isSukses = true;
                                }

                            }
                        });

            } else if (url.startsWith(Param_Collection.getPaymentApiUrl() + "/redirect/") || url.contains("3dsecure")) {
                /* Do nothing */
            }

        }
    }
}
