package com.kufed.id.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.VideoView;

import com.kufed.id.customview.KufedEditText;
import com.kufed.id.pojo.PojoResponseRegister;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/7/16.
 */
public class ForgotPassword extends AppCompatActivity{
    @Bind(R.id.video_kufed)VideoView video_view;
    @Bind(R.id.scrollView)
    ScrollView scrollView;
    @OnClick(R.id.btn_back) public void back(){
        finish();
    }
    @Bind(R.id.spinner_q_1)Spinner spinner_q_1;
    @Bind(R.id.spinner_q_2)Spinner spinner_q_2;
    @Bind(R.id.spinner_q_3)Spinner spinner_q_3;

    @Bind(R.id.ed_answer_1)KufedEditText ed_answer_1;
    @Bind(R.id.ed_answer_2)KufedEditText ed_answer_2;
    @Bind(R.id.ed_answer_3)KufedEditText ed_answer_3;

    String _ed_username, _ed_fullname, _ed_phone, _ed_email, _ed_password, _gender, _birthday;
    int _question_id_1, _question_id_2, _question_id_3;
    String _question_id_1_answer, _question_id_2_answer, _question_id_3_answer;

    SharedPreferences spf;
    boolean getJsonSukess = false;
    String json_question= "";

    @OnClick(R.id.btn_submit) public void submit(){
        _question_id_1_answer = ed_answer_1.getText().toString();
        _question_id_2_answer = ed_answer_2.getText().toString();
        _question_id_3_answer = ed_answer_3.getText().toString();

        String access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

//        JSONObject jsonObject = new JSONObject();
        try{
            JSONArray jsonArray = new JSONArray();

            JSONObject jsonObject_01 = new JSONObject();
            jsonObject_01.put("answer",_question_id_1_answer);
            jsonObject_01.put("question_id",_question_id_1);
            jsonArray.put(jsonObject_01);

            JSONObject jsonObject_02 = new JSONObject();
            jsonObject_02.put("answer",_question_id_2_answer);
            jsonObject_02.put("question_id",_question_id_2);
            jsonArray.put(jsonObject_02);

            JSONObject jsonObject_03 = new JSONObject();
            jsonObject_03.put("answer",_question_id_3_answer);
            jsonObject_03.put("question_id",_question_id_3);
            jsonArray.put(jsonObject_03);

            getJsonSukess = true;

            json_question = jsonArray.toString();

        }catch (JSONException e){
            Log.e("error json", e.getMessage().toString());
        }

        Log.e("Result Q json", json_question);

        Rest_Adapter adapter = Public_Functions.initRetrofit();
//        Observable<PojoResponseRegister> observable = adapter.register(access_token,
//                _ed_email, _ed_password, _gender,_ed_fullname, _birthday, _ed_username, _ed_phone, json_question);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        initView();

    }

    private void initView(){
        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_item, getResources().getStringArray(R.array.forgot_question));
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item_black);

        spinner_q_1.setAdapter(arrayAdapter);
        spinner_q_2.setAdapter(arrayAdapter);
        spinner_q_3.setAdapter(arrayAdapter);

        spinner_q_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                _question_id_1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                _question_id_1 = 0;
            }
        });

        spinner_q_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                _question_id_2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                _question_id_2 = 0;
            }
        });

        spinner_q_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                _question_id_3 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                _question_id_3 = 0;
            }
        });

        _ed_username = getIntent().getStringExtra("ed_username");
        _ed_fullname = getIntent().getStringExtra("ed_fullname");
        _ed_phone = getIntent().getStringExtra("ed_phone");
        _ed_email = getIntent().getStringExtra("ed_email");
        _ed_password = getIntent().getStringExtra("ed_password");
        _gender = getIntent().getStringExtra("gender");

        spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);
    }
}
