package com.kufed.id.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kufed.id.activity.R;
import com.kufed.id.customadapter.RVAdapter_PostFresh;
import com.kufed.id.customadapter.RVAdapter_PostTrending;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.pojo.PojoPostTrending;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/17/16.
 */
public class Fragment_Trending extends Fragment {
    @Bind(R.id.rv)
    RecyclerView rv;
    RecyclerView.Adapter layoutAdapter;
    RecyclerView.LayoutManager layoutManager;
    Rest_Adapter adapter;
    List<PojoPostTrending.Post> data;
    SharedPreferences spf;
    String access_token;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.layout_rv_bg_white, null);
        ButterKnife.bind(this, v);

        initView(v);


        return v;
    }

    private void initView(View v){
        adapter = Public_Functions.initRetrofit();
        spf = getActivity().getSharedPreferences(Param_Collection.SPF_NAME, Context.MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

        get_trending_post( v);

    }

    private void get_trending_post(final View v){
        Observable<PojoPostTrending> observable = adapter.get_post_trending(access_token);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoPostTrending>() {
                    @Override
                    public void onCompleted() {
                        layoutAdapter = new RVAdapter_PostTrending(getActivity(), data, adapter, access_token);
                        layoutManager = new GridLayoutManager(getActivity(), 1);
                        rv.setLayoutManager(layoutManager);
                        rv.setAdapter(layoutAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("kufed", "error");
                        Snackbar snackbar = Snackbar.make(v, "Loading Failed", Snackbar.LENGTH_LONG);
                        snackbar.show();

                    }

                    @Override
                    public void onNext(PojoPostTrending pojoPostTrending) {

                        if(pojoPostTrending.getData().getPosts().size() > 0){
                            data = pojoPostTrending.getData().getPosts();
                        }
                    }
                });
    }
}
