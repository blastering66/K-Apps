package com.kufed.id.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.VideoView;

import com.kufed.id.customview.KufedEditText;
import com.kufed.id.pojo.PojoAccessToken;
import com.kufed.id.pojo.PojoGETProfile;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Font;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/6/16.
 */
public class Login extends AppCompatActivity {
    Rest_Adapter adapter;
    SharedPreferences spf;
    @Bind(R.id.video_kufed)
    VideoView video_view;

    @Bind(R.id.ed_username)
    KufedEditText ed_username;
    @Bind(R.id.ed_password)
    KufedEditText ed_password;

    @OnClick(R.id.btn_back)
    public void back() {
        finish();
    }

    @OnClick(R.id.btn_login)
    public void login() {
        if (!ed_username.getText().toString().equals("") && !ed_password.getText().toString().equals("")) {

            //        getAccessTokenWithLogin("ibnuaaa","vvIH9kssl72Cvjo2Jf9EzA==");
            getAccessTokenWithLogin(ed_username.getText().toString(), ed_password.getText().toString());

        } else {
            if(ed_username.getText().toString().isEmpty()){
                ed_username.setError("Please insert your username");
            }else{
                ed_password.setError("Please insert your password");
            }

        }

    }

    private void getAccessTokenWithLogin(String username, String password) {
        adapter = Public_Functions.initRetrofit();
        Observable<PojoAccessToken> observable =
                adapter.access_token_with_login(Param_Collection.GRANT_TYPE_WITH_PASSWORD, Param_Collection.CLIENT_ID, Param_Collection.CLIENT_SECRET,
                        username, password);

        observable.subscribeOn(
                Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<PojoAccessToken>() {
                    String access_token = "";

                    @Override
                    public void onCompleted() {
                        Log.e("OnComplete", "");
                        spf.edit().putString(Param_Collection.ACCESS_TOKEN, access_token).commit();
                        getProfile(access_token);
//                        getPostFresh(access_token);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("OnError", "");

                    }

                    @Override
                    public void onNext(PojoAccessToken pojoAccessToken) {
                        Log.e("OnNext", pojoAccessToken.toString());
                        access_token = pojoAccessToken.getData().getAccessToken();

                    }
                });

    }

    private void getProfile(String access_token) {
        Observable<PojoGETProfile> observable = adapter.get_profile(access_token);
        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoGETProfile>() {
                    @Override
                    public void onCompleted() {
                        Log.e("OnComplete", "");

                        setResult(RESULT_OK);
                        finish();
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("OnError", "");
                    }

                    @Override
                    public void onNext(PojoGETProfile pojoPostFresh) {
                        Log.e("OnNext", "");
                        spf.edit().putBoolean(Param_Collection.SPF_LOGGED, true).commit();
                        spf.edit().putString(Param_Collection.SPF_USER_FULLNAME, pojoPostFresh.getData().getInfo()
                                .getMemberCompleteName().toString()).commit();
                        spf.edit().putString(Param_Collection.SPF_USER_IMG_PROFILE, pojoPostFresh.getData().getInfo()
                                .getPictureThumbPath()).commit();
                    }
                });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        initView();
    }

    private void initView() {
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
}
