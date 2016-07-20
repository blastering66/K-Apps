package com.kufed.id.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.kufed.id.customview.KufedButton;
import com.kufed.id.pojo.PojoAccessToken;
import com.kufed.id.pojo.PojoGETProfile;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Font;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Splashscreen extends AppCompatActivity {
    SharedPreferences spf;
    Rest_Adapter adapter;

    @Bind(R.id.wrapper)View wrapper;

    @Bind(R.id.video_kufed)
    VideoView video_view;

    @Bind(R.id.btn_login)
    KufedButton btn_login;
    @Bind(R.id.btn_register)
    KufedButton btn_register;
    @OnClick(R.id.btn_login) public void login(){
        startActivityForResult(new Intent(getApplicationContext(), Login.class), Param_Collection.REQ_CODE_FROM_LOGIN);
    }
    @OnClick(R.id.btn_exit) public void exit(){
        finish();
    }

    @OnClick(R.id.btn_register) public void register() {
        startActivityForResult(new Intent(getApplicationContext(), Register.class), Param_Collection.REQ_CODE_FROM_REGISTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Param_Collection.REQ_CODE_FROM_LOGIN && resultCode == RESULT_OK){
            finish();
            startActivity(new Intent(getApplicationContext(), MainMenu.class));
        }

        if(requestCode == Param_Collection.REQ_CODE_FROM_REGISTER && resultCode == RESULT_OK){
            startActivityForResult(new Intent(getApplicationContext(), MainMenu.class), Param_Collection.REQ_CODE_FROM_LOGIN);
        }
    }

    private void initView(){
        ButterKnife.bind(this);
//        getSupportActionBar().hide();

        showHashKey();

        spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);

        video_view.setVideoURI(Uri.parse("android.resource://com.kufed.id.activity/" + R.raw.vid_kufed_opening));
        video_view.setVisibility(View.VISIBLE);
        video_view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        video_view.setDrawingCacheEnabled(true);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        initView();

        boolean logged = spf.getBoolean(Param_Collection.SPF_LOGGED, false);
        if(logged){
            wrapper.setVisibility(View.GONE);
            refreshAccessToken();
        }else{
            getAccessToken();
        }

//        getAccessTokenWithLogin("ibnuaaa","vvIH9kssl72Cvjo2Jf9EzA==");

    }

    private void getAccessToken(){
        adapter = Public_Functions.initRetrofit();

        Observable<PojoAccessToken> observable =
                adapter.access_token(Param_Collection.GRANT_TYPE_TOKENONLY, Param_Collection.CLIENT_ID, Param_Collection.CLIENT_SECRET);

        observable.subscribeOn(
                Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<PojoAccessToken>() {
                    String access_token, token_refresh = "";

                    @Override
                    public void onCompleted() {
                        Log.e("Token = ", access_token);
                        Log.e("Token Refresh = ", token_refresh);
//                        getPostFresh(access_token);
                        spf.edit().putString(Param_Collection.ACCESS_TOKEN, access_token).commit();
                        spf.edit().putString(Param_Collection.ACCESS_TOKEN_REFRESH, token_refresh).commit();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("OnError", "");
                        if(!e.getMessage().isEmpty()){
                            Toast.makeText(getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onNext(PojoAccessToken pojoAccessToken) {
                        Log.e("OnNext", "Berhasil");
                        if (!pojoAccessToken.getData().getAccessToken().isEmpty()) {
                            access_token = pojoAccessToken.getData().getAccessToken();
                            token_refresh = pojoAccessToken.getData().getRefreshToken();
                        }

                    }
                });

    }

    private void refreshAccessToken(){
        adapter = Public_Functions.initRetrofit();

        String access_token_refresh = spf.getString(Param_Collection.ACCESS_TOKEN_REFRESH, "");
        Log.e("Token Refresh = ", access_token_refresh);

        Observable<PojoAccessToken> observable =
                adapter.refresh_access_token(Param_Collection.GRANT_TYPE_TOKEN_REFRESH, Param_Collection.CLIENT_ID,
                        Param_Collection.CLIENT_SECRET, access_token_refresh);

        observable.subscribeOn(
                Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<PojoAccessToken>() {
                    String access_token, token_refresh = "";

                    @Override
                    public void onCompleted() {
                        Log.e("Token NEW = ", access_token);
                        Log.e("Token Refresh NEW= ", token_refresh);
//                        getPostFresh(access_token);
                        spf.edit().putString(Param_Collection.ACCESS_TOKEN, access_token).commit();
                        spf.edit().putString(Param_Collection.ACCESS_TOKEN_REFRESH, token_refresh).commit();
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        finish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("OnError", "");
                        if (!e.getMessage().isEmpty()) {
                            Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onNext(PojoAccessToken pojoAccessToken) {
                        Log.e("OnNext", "Berhasil");
                        if (!pojoAccessToken.getData().getAccessToken().isEmpty()) {
                            access_token = pojoAccessToken.getData().getAccessToken();
                            token_refresh = pojoAccessToken.getData().getRefreshToken();
                        }

                    }
                });

    }

    private void showHashKey()
    {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.kufed.id.activity",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash FB:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

    }

}
