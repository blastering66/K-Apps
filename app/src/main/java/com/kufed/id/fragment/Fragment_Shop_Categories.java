package com.kufed.id.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kufed.id.activity.R;
import com.kufed.id.customadapter.RVAdapter_Category;
import com.kufed.id.pojo.PojoResponseCategories;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.rowdata.Rowdata_Category;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/17/16.
 */
public class Fragment_Shop_Categories extends Fragment {
    RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter layoutAdapter;
    SharedPreferences spf;
    String access_token;
    List<Rowdata_Category> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_rv, null);

        rv = (RecyclerView) view.findViewById(R.id.rv);

        initView();

//        data = new ArrayList<>();
//        Rowdata_Category data1 = new Rowdata_Category();
//        data1.setCategoryName("Women");
//        data1.setCategoryThumbPath("https://s-media-cache-ak0.pinimg.com/564x/5d/74/be/5d74be3dbf10ba39a448020a1bb111e3.jpg");
//        data.add(data1);
//
//        Rowdata_Category data2 = new Rowdata_Category();
//        data2.setCategoryName("Men");
//        data2.setCategoryThumbPath("https://s-media-cache-ak0.pinimg.com/564x/5d/74/be/5d74be3dbf10ba39a448020a1bb111e3.jpg");
//        data.add(data2);
//
//        Rowdata_Category data3 = new Rowdata_Category();
//        data3.setCategoryName("Home & Living");
//        data3.setCategoryThumbPath("https://s-media-cache-ak0.pinimg.com/564x/5d/74/be/5d74be3dbf10ba39a448020a1bb111e3.jpg");
//        data.add(data3);


        return view;
    }

    private void initView() {
        spf = getActivity().getSharedPreferences(Param_Collection.SPF_NAME, Context.MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");
        getCategories();
    }

    private void getCategories() {
        Rest_Adapter adapter = Public_Functions.initRetrofit();

        Observable<PojoResponseCategories> observable = adapter.get_categories(access_token);

        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoResponseCategories>() {
                    private boolean isSukses = false;

                    @Override
                    public void onCompleted() {
                        if (isSukses) {
                            layoutManager = new GridLayoutManager(getActivity(), 1);
                            layoutAdapter = new RVAdapter_Category(getActivity(), data);
                            rv.setLayoutManager(layoutManager);
                            rv.setAdapter(layoutAdapter);
                        } else {
                            Toast.makeText(getActivity(), "Loading Categories Failed", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ERROR", "getCategories");

                    }

                    @Override
                    public void onNext(PojoResponseCategories pojoResponseCategories) {
                        data = new ArrayList<Rowdata_Category>();
                        if (pojoResponseCategories.getData().getCategories().size() > 0) {
                            for (int i = 0; i < pojoResponseCategories.getData().getCategories().size(); i++) {
                                Rowdata_Category item = new Rowdata_Category();
                                item.setCategoryId(pojoResponseCategories.getData().getCategories().get(i).getCategoryId());
                                item.setCategoryName(pojoResponseCategories.getData().getCategories().get(i).getCategoryName());
//                                item.setCategoryThumbPath(pojoResponseCategories.getData().getCategories().get(i).getCategoryThumbPath());
                                item.setCategoryThumbPath("http://s4.scoopwhoop.com/anj/rdc/844327839.jpg");
                                data.add(item);
                                isSukses = true;
                            }

                        }

                    }
                });
    }
}
