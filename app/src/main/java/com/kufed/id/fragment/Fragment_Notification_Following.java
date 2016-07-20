package com.kufed.id.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kufed.id.activity.R;
import com.kufed.id.customadapter.RVAdapter_NotifFollowing;
import com.kufed.id.customview.SimpleDividerItemDecoration;
import com.kufed.id.pojo.PojoNotifFollowing;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/17/16.
 */
public class Fragment_Notification_Following extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    @Bind(R.id.srv)
    SuperRecyclerView rv;
    RecyclerView.Adapter layoutAdapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemDecoration layoutDecoration;
    SharedPreferences spf;
    Context context;
    List<PojoNotifFollowing.Datum> data;
    String access_token;
    int id;

    @BindDrawable(R.drawable.line_divider) Drawable drawableDecoration;

    @Override
    public void onRefresh() {
        getProfileActivity_Following();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_rv_loadmore, null);
        ButterKnife.bind(this, view);
        spf = getActivity().getSharedPreferences(Param_Collection.SPF_NAME, Context.MODE_PRIVATE);
        id = spf.getInt(Param_Collection.SPF_USER_ID, 0);
//        id = "335288";
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");
        rv.setRefreshListener(this);
        rv.setRefreshingColorResources(android.R.color.holo_orange_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_red_light);
        getProfileActivity_Following();

        return view;
    }

    private void getProfileActivity_Following(){
        final Rest_Adapter adapter = Public_Functions.initRetrofit();

        Observable<PojoNotifFollowing> observable = adapter.notif_following(id, access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoNotifFollowing>() {
                    @Override
                    public void onCompleted() {
                        layoutAdapter = new RVAdapter_NotifFollowing(getContext(), data);
                        layoutManager = new GridLayoutManager(getContext(), 1);
//                        Drawable drawableDecoration = ContextCompat.getDrawable(context, R.drawable.line_divider);
                        layoutDecoration = new SimpleDividerItemDecoration(drawableDecoration);

                        rv.setAdapter(layoutAdapter);
                        rv.setLayoutManager(layoutManager);
                        rv.addItemDecoration(layoutDecoration);
                        rv.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "");
                        rv.hideProgress();
                    }

                    @Override
                    public void onNext(PojoNotifFollowing pojoNotifFollowing) {
                        if(pojoNotifFollowing.getStatus().getCode() == 200){
                            if(pojoNotifFollowing.getData().size() > 0){
                                data = pojoNotifFollowing.getData();
                            }
                        }

                    }
                });
    }
}
