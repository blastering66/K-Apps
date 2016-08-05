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

import com.kufed.id.util.Param_Collection;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 8/5/16.
 */
public class Activity_Webview extends AppCompatActivity {
    private WebView webview;
    private String url, cToken, cBank, cTotalDonasi;
    private SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_webview);

        getSupportActionBar().hide();

        sp = getSharedPreferences(Param_Collection.SPF_NAME, Context.MODE_PRIVATE);
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
                //SEND TOKEN
//                new AsyncTask_SendToken().execute();
            } else if (url.startsWith(Param_Collection.getPaymentApiUrl() + "/redirect/") || url.contains("3dsecure")) {
                /* Do nothing */
            }
        }
    }

//    private class AsyncTask_SendToken extends AsyncTask<Void, Void, Void> {
//        private String cCode, cCode_Insert, cCode_Message, cCode_Charge = "";
//        private boolean success;
//        @Override
//        protected Void doInBackground(Void... voids) {
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpPost httpPost = new HttpPost(ParameterCollections.URL_SEND_TOKEN);
//            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//            try {
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.KIND_TOKEN,
//                        cToken));
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.KIND_BANK,
//                        cBank));
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.JSON_CHARGE_PROGRAM_ID,
//                        sp.getString(ParameterCollections.SH_PROGRAM_ID, "")));
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.JSON_CHARGE_USER_ID,
//                        sp.getString(ParameterCollections.SH_USER_ID, "0")));
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.JSON_CHARGE_FACULTY,
//                        sp.getString(ParameterCollections.SH_NAMA_FAKULTAS, "")));
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.JSON_CHARGE_PUBLISHED,
//                        sp.getString(ParameterCollections.SH_PUBLISHED, "Yes")));
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.JSON_CHARGE_NAME,
//                        sp.getString(ParameterCollections.SH_NAMA_DONATUR, "")));
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.JSON_CHARGE_AMOUNT,
//                        cTotalDonasi));
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.JSON_CHARGE_DESC,
//                        sp.getString(ParameterCollections.SH_DONASI_DESC, "")));
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.JSON_CHARGE_EMAIL,
//                        sp.getString(ParameterCollections.SH_EMAIL_DONATUR, "")));
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.JSON_CHARGE_PHONE,
//                        sp.getString(ParameterCollections.SH_PHONE_DONATUR, "")));
//                if (sp.getBoolean(ParameterCollections.SH_LOGGED, false)) {
//                    nameValuePairs.add(new BasicNameValuePair(ParameterCollections.SH_USER_PHOTO, ""
//                    ));
//                } else {
//                    nameValuePairs.add(new BasicNameValuePair(ParameterCollections.URL_IMG_PROFILE, ""
//                    ));
//                }
//                nameValuePairs.add(new BasicNameValuePair(ParameterCollections.JSON_CHARGE_PROGRAM_NAME,
//                        sp.getString(ParameterCollections.SH_NAMA_PROGRAM, "")));
//                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                HttpResponse response = httpClient.execute(httpPost);
//                String jsonResponse = EntityUtils.toString(response.getEntity()).toString();
//                Log.e("VtLog response", jsonResponse);
//                JSONObject json_result = new JSONObject(jsonResponse);
//                cCode = json_result.getString(ParameterCollections.JSON_CHARGE_STATUS);
//                if (cCode.equals("success")) {
//                    //berhasil
//                    JSONObject json_body = json_result.getJSONObject(ParameterCollections.JSON_CHARGE_BODY);
//                    cCode_Charge = json_body.getString(ParameterCollections.JSON_CHARGE_STATUS_CODE);
//                    if (cCode_Charge.equals("200")) {
//                        //success
//                        success = true;
//                    } else if (cCode_Charge.equals("201")) {
//                        //pending
//                        success = false;
//                    }
//                }
//            } catch (JSONException e) {
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//        @Override
//        protected void onPostExecute(Void result) {
//            // TODO Auto-generated method stub
//            super.onPostExecute(result);
//            if (success) {
//                Toast.makeText(getApplicationContext(), "Donasi Berhasil", Toast.LENGTH_LONG).show();
//                startActivity(new Intent(getApplicationContext(), Activity_Selesai_KartuKredit.class));
//                finish();
//            } else {
//                Toast.makeText(getApplicationContext(), "Donasi Gagal", Toast.LENGTH_LONG).show();
//            }
//        }
//    }
}
