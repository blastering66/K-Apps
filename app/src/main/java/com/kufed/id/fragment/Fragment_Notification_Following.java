package com.kufed.id.fragment;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kufed.id.activity.R;

/**
 * Created by macbook on 6/17/16.
 */
public class Fragment_Notification_Following extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_rv, null);
        view.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.mdtp_red));
        return view;
    }
}
