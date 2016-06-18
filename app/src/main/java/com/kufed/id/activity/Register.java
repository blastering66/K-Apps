package com.kufed.id.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import com.wdullaer.materialdatetimepicker.Utils;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.kufed.id.customview.KufedEditText;
import com.kufed.id.customview.KufedRadioButton;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.pojo.PojoResponseRegister;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import java.util.Calendar;

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
public class Register extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    String _ed_username, _birthday, _ed_fullname, _ed_password,_ed_password_retype, _ed_email, access_token;
    @Bind(R.id.video_kufed)VideoView video_view;
    @Bind(R.id.tv_birthday)
    KufedTextView tv_birthday;
    @OnClick(R.id.btn_back) public void back(){
        finish();
    }
    @OnClick(R.id.btn_signup) public void signup(){
        _ed_username = ed_username.getText().toString();
        _ed_fullname = ed_fullname.getText().toString();
        _ed_email = ed_email.getText().toString();
        _ed_password = ed_password.getText().toString();
        _ed_password_retype = ed_password_retype.getText().toString();

        if(_ed_password.equals(_ed_password_retype)){
            if(!_ed_username.equals("") && !_ed_fullname.equals("") && !_ed_email.equals("")
                    && !_ed_password.equals("")){
                Rest_Adapter adapter = Public_Functions.initRetrofit();
                Observable<PojoResponseRegister> observable = adapter.register(access_token,
                        _ed_email, _ed_password,_ed_fullname, _birthday, _ed_username);

                observable.subscribeOn(Schedulers.newThread()).
                        observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<PojoResponseRegister>() {
                            @Override
                            public void onCompleted() {
                                Log.e("Test", "test");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("Test", "test");
                            }

                            @Override
                            public void onNext(PojoResponseRegister pojoResponseRegister) {
                                Log.e("Test", "test");

                            }
                        });


            }else{
                Toast.makeText(getApplicationContext(), "Please fill all field", Toast.LENGTH_LONG).show();
            }
        }else{
            ed_password_retype.setError("Password did not match");
        }




    }

    @Bind(R.id.ed_username)KufedEditText ed_username;
    @Bind(R.id.ed_fullname)KufedEditText ed_fullname;
    @Bind(R.id.ed_phone)KufedEditText ed_phone;
    @Bind(R.id.ed_email)KufedEditText ed_email;
    @Bind(R.id.ed_password)KufedEditText ed_password;
    @Bind(R.id.ed_password_retype)KufedEditText ed_password_retype;
//    @Bind(R.id.ed_username)KufedEditText ed_birthday;
    @Bind(R.id.radio_male)KufedRadioButton radio_male;
    @Bind(R.id.radio_female)KufedRadioButton radio_female;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Param_Collection.REQ_CODE_FROM_REGISTER_FORGOT && resultCode == RESULT_OK){
            setResult(RESULT_OK);
            finish();
        }
    }

    private void initView(){
        video_view.setVideoURI(Uri.parse("android.resource://com.kufed.id.activity/" + R.raw.vid_kufed_opening));
        video_view.setVisibility(View.VISIBLE);
        video_view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        video_view.setDrawingCacheEnabled(true);


        tv_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c_now = Calendar.getInstance();
                DatePickerDialog dialog = new DatePickerDialog().newInstance(Register.this,
                        c_now.get(Calendar.YEAR),
                        c_now.get(Calendar.MONTH),
                        c_now.get(Calendar.DAY_OF_MONTH));

                dialog.show(getFragmentManager(), "DatePickerDialog");
            }
        });


    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String bulan;
        String tgl;
        if(String.valueOf(monthOfYear).length() == 1){
            bulan = "0" + String.valueOf(monthOfYear);
        }else{
            bulan =  String.valueOf(monthOfYear);
        }

        if(String.valueOf(dayOfMonth).length() == 1){
            tgl = "0" + String.valueOf(dayOfMonth);
        }else{
            tgl = String.valueOf(dayOfMonth);
        }
        _birthday = String.valueOf(year) + "/" + bulan + "/" + tgl;
        Log.e("Date Picked", _birthday);
        tv_birthday.setText(_birthday);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        initView();

    }
}
