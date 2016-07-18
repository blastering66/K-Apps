package com.kufed.id.customadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kufed.id.activity.Detail_Product;
import com.kufed.id.activity.ListLikedPost;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.pojo.PojoResponseRegister;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;

import java.text.NumberFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/21/16.
 */
public class RVAdapter_NotifFollowing extends RecyclerView.Adapter<RVAdapter_NotifFollowing.ViewHolder> {
    public static final  int NOTIF_TYPE_LIKEDPOST= 1;
    public static final int NOTIF_TYPE_FOLLOWMEMBER= 1;

    private Context context;
    private Rest_Adapter adapter;
    private String access_token;

    public RVAdapter_NotifFollowing(Context context, Rest_Adapter adapter,
                                    String access_token) {
        this.context = context;
        this.adapter = adapter;
        this.access_token =access_token;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_noti, null);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
        switch (viewType){
            case NOTIF_TYPE_LIKEDPOST:
                break;
        }
        return null;
    }



    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.img_member)ImageView img_member;
        @Bind(R.id.img_target)ImageView img_target;
        @Bind(R.id.tv)KufedTextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
