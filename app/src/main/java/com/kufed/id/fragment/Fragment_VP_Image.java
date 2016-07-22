package com.kufed.id.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.kufed.id.activity.R;

/**
 * Created by macbook on 6/23/16.
 */
public class Fragment_VP_Image extends Fragment {
    public static final String URL= "url";
    private String cUrl;

    public static Fragment_VP_Image create(String url_img){
        Fragment_VP_Image fragment = new Fragment_VP_Image();
        Bundle bundle= new Bundle();
        bundle.putString(URL, url_img);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cUrl = getArguments().getString(URL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_img_with_gradient, null);

        ImageView img = (ImageView)view.findViewById(R.id.img);
        Glide.with(getActivity()).load(cUrl).asBitmap().into(img);
        return view;
    }
}
