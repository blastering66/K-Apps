package com.kufed.id.customadapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.kufed.id.activity.Detail_Product;
import com.kufed.id.activity.ListLikedPost;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedLikeImageView;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.pojo.PojoNotifFollowing;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.pojo.PojoResponseRegister;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.util.Param_Collection;
import com.pkmmte.view.CircularImageView;

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
    public static final int NOTIF_TYPE_FOLLOWMEMBER= 2;

    private Context context;
    private Rest_Adapter adapter;
    private String access_token;
    private List<PojoNotifFollowing.Datum> data;

    public RVAdapter_NotifFollowing(Context context, List<PojoNotifFollowing.Datum> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        PojoNotifFollowing.Datum item = data.get(position);
        switch (getItemViewType(position)) {
            case NOTIF_TYPE_LIKEDPOST:
                Target<Bitmap> target_member = new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.img_member.setImageBitmap(resource);
                    }
                };

                Target<Bitmap> target_post = new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.img_target_post.setImageBitmap(resource);
                    }
                };

                Glide.with(context).load(item.getContent().getMember().getImage()).asBitmap().into(target_member);
                Glide.with(context).load(item.getContent().getPost().getImage()).asBitmap().into(target_post);
                String text_ = item.getText().toString().replace("[", "");
                text_ = text_.replace("]","");
                holder.tv.setText(text_);

                break;

            case NOTIF_TYPE_FOLLOWMEMBER:
                Target<Bitmap> target_member_ = new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.img_member.setImageBitmap(resource);
                    }
                };

                Target<Bitmap> target_follow = new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.img_target_member.setImageBitmap(resource);
                    }
                };

                Glide.with(context).load(item.getContent().getMember().getImage()).asBitmap().into(target_member_);
                Glide.with(context).load(item.getContent().getReceiver_image()).asBitmap().into(target_follow);
                String text__ = item.getText().toString().replace("[", "");
                text__ = text__.replace("]","");
                holder.tv.setText(text__);
                break;

        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_noti, null);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;

        switch (viewType){
            case NOTIF_TYPE_LIKEDPOST:
                View view_likepost = LayoutInflater.from(context).inflate(R.layout.item_notif_likepost, null);
                ViewHolder viewHolder_likepost = new ViewHolder(view_likepost);
                return viewHolder_likepost;
            case NOTIF_TYPE_FOLLOWMEMBER:
                View view_followmember = LayoutInflater.from(context).inflate(R.layout.item_notif_followmemver, null);
                ViewHolder viewHolder_followmember = new ViewHolder(view_followmember);
                return viewHolder_followmember;
        }
        return null;
    }


    @Override
    public int getItemViewType(int position) {
        String tipe = data.get(position).getActivity();
        if(tipe.equals("likePost")){
            return NOTIF_TYPE_LIKEDPOST;
        }else if(tipe.equals("followMember")){
            return NOTIF_TYPE_FOLLOWMEMBER;
        }
        return NOTIF_TYPE_LIKEDPOST;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @Nullable
        @Bind(R.id.img_target_member)CircularImageView img_target_member;
        @Nullable
        @Bind(R.id.img_target_post)ImageView img_target_post;
        @Bind(R.id.img_member)ImageView img_member;
        @Bind(R.id.tv)KufedTextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
