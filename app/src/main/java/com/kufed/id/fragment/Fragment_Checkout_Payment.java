package com.kufed.id.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kufed.id.activity.R;

import butterknife.ButterKnife;

/**
 * Created by macbook on 8/4/16.
 */
public class Fragment_Checkout_Payment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_payment, null);
        try{
            ButterKnife.bind(this, view);
        }catch (IllegalStateException e){

        }catch (RuntimeException e){

        }catch (Exception e){

        }

//        FragmentManager fm = getChildFragmentManager();
//        fm.beginTransaction().replace(R.id.frame_container,new Fragment_Checkout_Payment_Choose())
//                .addToBackStack(null).commit();
        return view;
    }

}
