package com.kufed.id.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.kufed.id.customadapter.RVAdapter_Add_User;
import com.kufed.id.customview.KufedTextViewTitle;
import com.kufed.id.customview.SimpleDividerItemDecoration;
import com.kufed.id.pojo.PojoFriendRequests;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.rowdata.RowData_UserToAdd;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 7/21/16.
 */
public class NotificationActivity_AddMember extends AppCompatActivity {
    @Bind(R.id.srv)
    SuperRecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter layoutAdapter;
    RecyclerView.ItemDecoration layoutDecoration;
    SharedPreferences spf;
    List<PojoFriendRequests.Friend> data;
    @Bind(R.id.tv_title_custom)KufedTextViewTitle tv_title_custom;
    @BindDrawable(R.drawable.line_divider)
    Drawable drawableLine;

    String access_token;
    int id;
    @OnClick(R.id.img_back)public void back(){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_addmember);
        ButterKnife.bind(this);
        tv_title_custom.setText("ACTIVITY");

        spf = getSharedPreferences(Param_Collection.SPF_NAME, Context.MODE_PRIVATE);
        id = spf.getInt(Param_Collection.SPF_USER_ID,0);
//        id = "335288";
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

        String url = getIntent().getStringExtra("url");
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");



        get_friend_requests();
    }

    private void get_friend_requests(){

        final Rest_Adapter adapter = Public_Functions.initRetrofit();
        Observable<PojoFriendRequests> observable = adapter.notif_get_friend_requests(id, access_token);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoFriendRequests>() {
                    private boolean isSuskes = false;
                    @Override
                    public void onCompleted() {
                        if(isSuskes){
                            layoutManager = new GridLayoutManager(getApplicationContext(), 1);
                            layoutAdapter = new RVAdapter_Add_User(getApplicationContext(), data, adapter, access_token);
                            layoutDecoration = new SimpleDividerItemDecoration(drawableLine);
                            rv.addItemDecoration(layoutDecoration);
                            rv.setLayoutManager(layoutManager);
                            rv.setAdapter(layoutAdapter);
                        }else{
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ERROR", e.getMessage().toString());

                    }

                    @Override
                    public void onNext(PojoFriendRequests pojoFriendRequests) {
                        if(pojoFriendRequests.getStatus().getCode() == 200){
                            if(pojoFriendRequests.getData().getFriends().size() > 0){
                                data = pojoFriendRequests.getData().getFriends();
                                isSuskes = true;
                            }
                        }

                    }
                });

    }
}
