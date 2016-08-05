package com.kufed.id.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kufed.id.activity.R;
import com.kufed.id.customadapter.RVAdapter_PostFresh;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.rowdata.Rowdata_PostFresh;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
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
public class Fragment_Home extends Fragment implements OnMoreListener, SwipeRefreshLayout.OnRefreshListener{
//    @Bind(R.id.rv)
//    RecyclerView rv;

    @Bind(R.id.srv)
    SuperRecyclerView rv;
    RecyclerView.Adapter layoutAdapter;
    RecyclerView.LayoutManager layoutManager;
    Rest_Adapter adapter;
    List<PojoPostFresh.Post> data, data_temp;
    SharedPreferences spf;
    String access_token;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View v = LayoutInflater.from(getActivity()).inflate(R.layout.layout_rv_bg_white, null);
        v = LayoutInflater.from(getActivity()).inflate(R.layout.layout_rv_loadmore, null);
        ButterKnife.bind(this, v);

        initView(v);
        rv.setOnMoreListener(this);
        rv.setupMoreListener(this, 1);
        rv.setRefreshListener(this);
        rv.setRefreshingColorResources(android.R.color.holo_orange_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_red_light);

        return v;
    }

    private void initView(View v){
        adapter = Public_Functions.initRetrofit();
        spf = getActivity().getSharedPreferences(Param_Collection.SPF_NAME, Context.MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

        get_fresh_post(v);

    }

    @Override
    public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {
//        data_temp2 = new ArrayList<PojoPostFresh.Post>();
//        for(int i=10; i < 20; i++){
//            data_temp2.add(data.get(i));
//        }
        int index_data_visible = data_temp.size();
        if(index_data_visible != data.size()){
            data_temp.add(data.get(index_data_visible + 1));
            layoutAdapter.notifyDataSetChanged();
        }else{
            rv.hideMoreProgress();
        }
    }

    @Override
    public void onRefresh() {
        get_fresh_post(v);
    }

    private void get_fresh_post(final View v){
        Observable<PojoPostFresh> observable = adapter.get_post_fresh(access_token, 0, 30);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoPostFresh>() {
                    @Override
                    public void onCompleted() {
                        //test
                        data_temp = new ArrayList<PojoPostFresh.Post>();
                        for(int i=0; i < 2; i++){
                            data_temp.add(data.get(i));
                        }

//                        layoutAdapter = new RVAdapter_PostFresh(getActivity(), data, adapter, access_token);
                        layoutAdapter = new RVAdapter_PostFresh(getActivity(), data_temp, adapter, access_token);
                        layoutManager = new GridLayoutManager(getActivity(), 1);
                        rv.setLayoutManager(layoutManager);
                        rv.setAdapter(layoutAdapter);
                        rv.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("kufed", "error");
                        Snackbar snackbar = Snackbar.make(v, "Loading Failed", Snackbar.LENGTH_LONG);
                        snackbar.show();

                    }

                    @Override
                    public void onNext(PojoPostFresh pojoPostFresh) {

                        if(pojoPostFresh.getData().getPosts().size() > 0){
                            data = pojoPostFresh.getData().getPosts();
                        }
                    }
                });
    }
}
