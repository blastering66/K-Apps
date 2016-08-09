package com.kufed.id.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.kufed.id.customview.KufedDialogProgress;
import com.kufed.id.customview.KufedEditText;
import com.kufed.id.pojo.PojoAccessToken;
import com.kufed.id.pojo.PojoGETProfile;
import com.kufed.id.pojo.PojoLoginFB;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Font;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

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

    private KufedDialogProgress pDialog;

    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private AccessToken accessToken;
    private LoginResult loginResult;
    String access_token, token_refresh = "";

    @OnClick(R.id.btn_login_fb) public void login_FB(){
        LoginManager.getInstance().logInWithReadPermissions(Login.this, Arrays.asList("public_profile", "email"));

    }

    @OnClick(R.id.btn_back)
    public void back() {
        finish();
    }

    @OnClick(R.id.btn_login)
    public void login() {
        if (!ed_username.getText().toString().equals("") && !ed_password.getText().toString().equals("")) {

            //        getAccessTokenWithLogin("ibnuaaa","vvIH9kssl72Cvjo2Jf9EzA==");

            pDialog = new KufedDialogProgress();
            pDialog.setMessage("Login");
            pDialog.show(getSupportFragmentManager(),"");

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

                    String message = "";
                    boolean isSukses = false;


                    @Override
                    public void onCompleted() {
                        pDialog.dismiss();
                        if(isSukses){
                            Log.e("LOGIN ", "Token NEW= " + access_token);
                            Log.e("LOGIN ", "Token Refresh NEW= " + token_refresh);
                            spf.edit().putString(Param_Collection.ACCESS_TOKEN, access_token).commit();
                            spf.edit().putString(Param_Collection.ACCESS_TOKEN_REFRESH, token_refresh).commit();

                            getProfile(access_token);

                        }else{
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        }

//                        getPostFresh(access_token);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("OnError", "");

                        pDialog.dismiss();
                    }

                    @Override
                    public void onNext(PojoAccessToken pojoAccessToken) {
                        Log.e("OnNext", pojoAccessToken.toString());
                        String code_status = pojoAccessToken.getStatus().getCode().toString();
                        if(code_status.equals("200")){
                            access_token = pojoAccessToken.getData().getAccessToken();
                            token_refresh= pojoAccessToken.getData().getRefreshToken();
                            isSukses = true;
                        }else if(code_status.equals("422")){
                            message = pojoAccessToken.getStatus().getError_messages().toString();
                        }else{
                            message = pojoAccessToken.getStatus().getError_messages().toString();
                        }


                    }
                });

    }

    private void getAccessTokenWithFacebookLogin(String facebook_id) {
        adapter = Public_Functions.initRetrofit();
        Observable<PojoLoginFB> observable =
                adapter.access_token_with_facebook_login(access_token, facebook_id);

        observable.subscribeOn(
                Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<PojoLoginFB>() {
                    String access_token_new = "";
                    String message = "";
                    boolean isSukses = false;


                    @Override
                    public void onCompleted() {
                        Log.e("OnComplete", "");
                        if(isSukses){
                            spf.edit().putString(Param_Collection.ACCESS_TOKEN, access_token_new).commit();
                            getProfile(access_token_new);

                        }else{
//                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                            pDialog.dismiss();
                            if(message.contains("Password")){
                                ed_password.setError(message);
                            }else{
                                ed_username.setError(message);
                            }

                        }

//                        getPostFresh(access_token);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("OnError", "");

                    }

                    @Override
                    public void onNext(PojoLoginFB pojoAccessToken) {
                        Log.e("OnNext", pojoAccessToken.toString());
                        String code_status = pojoAccessToken.getStatus().getCode().toString();
                        if(code_status.equals("200")){
                            access_token_new = pojoAccessToken.getData().getAccessToken();
                            isSukses = true;
                        }else if(code_status.equals("422")){
//                            message = pojoAccessToken.getStatus().getError_messages().toString();
                            message = "Something Wrong";
                        }else{
//                            message = pojoAccessToken.getStatus().getError_messages().toString();
                            message = "Something Wrong";
                        }


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

                        pDialog.dismiss();
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
                        spf.edit().putInt(Param_Collection.SPF_USER_ID, pojoPostFresh.getData().getInfo().getMemberId()).commit();
                    }
                });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
//        getSupportActionBar().hide();
        initView();
        initFBLogin();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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

    private void initFBLogin(){
        callbackManager = CallbackManager.Factory.create();
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken = AccessToken.getCurrentAccessToken();
            }
        };

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            private LoginResult jsonResult;
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e("login fb sukses", loginResult.toString());

                jsonResult = loginResult;

                GraphRequest graphRequest = GraphRequest.newMeRequest(jsonResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
//                        user_id = user.optString("id");
//                        user_fullname = user.optString("name");
//                        user_email = user.optString("email");
//                        user_gender = user.optString("gender");

                        try{
                            JSONObject obj_pic = object.getJSONObject("picture");
                            JSONObject obj_data = object.getJSONObject("data");
                            String user_photo = obj_data.optString("url");
                        }catch (JSONException e){

                        }

//                        spf.edit().putString(ParameterCollections.SPF_USER_PHOTO_URL,"").commit();
//                        Log.e("fb response = ", user_fullname + " , " + user_email + ", " + user_foto);
//
//                        if(bool_fb_login){
//                            // API cek ke DB apa sdh terdaftar email by facebooknya
//
//                        }else{
//                            Intent intent = new Intent(getApplicationContext(), RegisterForm.class);
//                            intent.putExtra("register_fb", true);
//                            intent.putExtra("name", user_fullname);
//                            intent.putExtra("email", user_email);
//                            intent.putExtra("url_foto", user_foto);
//                            startActivity(intent);
//                            finish();
//                        }
                    }
                });

                final Bundle b = new Bundle();
                b.putString("fields", "name,email,gender,picture.type(large)");
                graphRequest.setParameters(b);
                graphRequest.executeAsync();

            }

            @Override
            public void onCancel() {
                Log.e("canceled", "");
            }

            @Override
            public void onError(FacebookException error) {
                Log.e("error", error.getMessage().toString());
            }
        });
    }
}
