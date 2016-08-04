package com.kufed.id.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.kufed.id.activity.R;
import com.kufed.id.pojo.PojoResponseAddressList;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import butterknife.ButterKnife;
import butterknife.OnClick;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 8/4/16.
 */
public class Fragment_Checkout_Shipping extends Fragment {
    SharedPreferences spf;
    String access_token;
    int shipping_address_id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        spf = getActivity().getSharedPreferences(Param_Collection.SPF_NAME, Context.MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");
//        getAddressInfo();

    }


    public void getAddressInfo(){
        Rest_Adapter adapter = Public_Functions.initRetrofit();
        Observable<PojoResponseAddressList> observable = adapter.get_address_list(access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoResponseAddressList>() {
                    @Override
                    public void onCompleted() {
                        Log.e("","");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("","");
                    }

                    @Override
                    public void onNext(PojoResponseAddressList pojoResponseAddressList) {
                        Log.e("","");
                        if(pojoResponseAddressList.getStatus().getCode() == 0 && pojoResponseAddressList.getData().getAddresses().size() > 0){
                            shipping_address_id = pojoResponseAddressList.getData().getAddresses().get(0).getId();
                        }

                    }
                });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =LayoutInflater.from(getActivity()).inflate(R.layout.layout_shipping, null);
        try{
            ButterKnife.bind(this, view);
        }catch (IllegalStateException e){

        }catch (RuntimeException e){

        }catch (Exception e){

        }

        return view;
    }

    @OnClick(R.id.btn) public void submitDataShipping(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.viewpager, new Fragment_Checkout_Payment()).addToBackStack(null).commit();

        MaterialTabHost tabHost = (MaterialTabHost)getActivity().findViewById(R.id.tabhost);
        tabHost.setSelectedNavigationItem(1);
    }
}
