package com.kufed.id.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kufed.id.activity.R;

/**
 * Created by macbook on 6/17/16.
 */
public class Fragment_Notification_You extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_rv_bg_white, null);
        return view;
    }
}
