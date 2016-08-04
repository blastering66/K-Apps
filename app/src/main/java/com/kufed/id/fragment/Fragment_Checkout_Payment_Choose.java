package com.kufed.id.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kufed.id.activity.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by macbook on 8/4/16.
 */
public class Fragment_Checkout_Payment_Choose extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_choose_payment, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.wrapper_bank_transfer)public void choose_transfer(){

    }

    @OnClick(R.id.wrapper_bank_cc)public void choose_cc(){

    }
}
