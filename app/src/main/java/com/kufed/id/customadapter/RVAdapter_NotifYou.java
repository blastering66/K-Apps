package com.kufed.id.customadapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.kufed.id.activity.Detail_Product;
import com.kufed.id.activity.Detail_Product_Normal;
import com.kufed.id.activity.NotificationActivity_AddMember;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.fragment.Fragment_Trending;
import com.kufed.id.pojo.PojoNotifYou;
import com.kufed.id.util.Param_Collection;
import com.pkmmte.view.CircularImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 7/21/16.
 */
public class RVAdapter_NotifYou extends RecyclerView.Adapter<RVAdapter_NotifYou.ViewHolder> {
    private static final int NOTIF_TYPE_LIKEDPOST = 1;
    private static final int NOTIF_TYPE_FOLLOW_MEMBER = 2;
    private static final int NOTIF_TYPE_APPROVED_MEMBER = 3;
    private static final int NOTIF_TYPE_ADD_MEMBER = 4;

    private Context context;
    private List<PojoNotifYou.Datum> data;
    private  FragmentManager fm;

    public RVAdapter_NotifYou(Context context, List<PojoNotifYou.Datum> data, FragmentManager fm) {
        this.context = context;
        this.data = data;
        this.fm = fm;
    }

    @Override
    public int getItemViewType(int position) {
        String tipe = data.get(position).getActivity();
        if (tipe.equals("likePost")) {
            return NOTIF_TYPE_LIKEDPOST;
        } else if (tipe.equals("followMember")) {
            return NOTIF_TYPE_FOLLOW_MEMBER;
        } else if (tipe.equals("approveMember")) {
            return NOTIF_TYPE_APPROVED_MEMBER;
        } else if (tipe.equals("addMember")) {
            return NOTIF_TYPE_ADD_MEMBER;
        } else {
            return NOTIF_TYPE_LIKEDPOST;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case NOTIF_TYPE_LIKEDPOST:
                View view = LayoutInflater.from(context).inflate(R.layout.item_notif_you_likepost, null);
                ViewHolder v = new ViewHolder(view);
                return v;
            case NOTIF_TYPE_FOLLOW_MEMBER:
                View view_followmember = LayoutInflater.from(context).inflate(R.layout.item_notif_you_followmember, null);
                ViewHolder v_followmember = new ViewHolder(view_followmember);
                return v_followmember;
            case NOTIF_TYPE_APPROVED_MEMBER:
                View view_approvedmember = LayoutInflater.from(context).inflate(R.layout.item_notif_you_approvedmember, null);
                ViewHolder v_approvedmember = new ViewHolder(view_approvedmember);
                return v_approvedmember;
            case NOTIF_TYPE_ADD_MEMBER:
                View view_addmember = LayoutInflater.from(context).inflate(R.layout.item_notif_you_addmember, null);
                ViewHolder v_addmember = new ViewHolder(view_addmember);
                return v_addmember;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final PojoNotifYou.Datum item = data.get(position);
        switch (getItemViewType(position)) {
            case NOTIF_TYPE_LIKEDPOST:
                Target<Bitmap> target_likedpost_member = new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.img_member.setImageBitmap(resource);
                    }
                };
                Glide.with(context).load(item.getContent().getMember().getImage()).asBitmap().into(target_likedpost_member);

                Target<Bitmap> target_likedpost_target = new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.img_target_post.setImageBitmap(resource);
                    }
                };
                Glide.with(context).load(item.getContent().getThumbImagePath()).asBitmap().into(target_likedpost_target);
                holder.tv.setText(item.getText().get(0).toString());

                holder.wrapper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //                    Intent intent = new Intent(context, Detail_Product.class);
                        Intent intent = new Intent(context, Detail_Product_Normal.class);
                        intent.putExtra(Param_Collection.EXTRA_POST_ID, item.getContent().getPostId().toString());
                        intent.putExtra(Param_Collection.EXTRA_POST_PRODUCT_TITLE, item.getActivity());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });
                break;

            case NOTIF_TYPE_FOLLOW_MEMBER:
                Target<Bitmap> target_follow_img = new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.img.setImageBitmap(resource);
                    }
                };
                Glide.with(context).load(item.getContent().getMember().getImage()).asBitmap().into(target_follow_img);

                holder.tv.setText(item.getText().get(0).toString());
                break;
            case NOTIF_TYPE_APPROVED_MEMBER:
                Target<Bitmap> target_approved_img = new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.img.setImageBitmap(resource);
                    }
                };
                Glide.with(context).load(item.getContent().getMember().getImage()).asBitmap().into(target_approved_img);

                holder.tv.setText(item.getText().get(0).toString());
                break;
            case NOTIF_TYPE_ADD_MEMBER:
                Target<Bitmap> target_addmember_member = new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.img_member.setImageBitmap(resource);
                    }
                };

                Glide.with(context).load(item.getContent().getMember().getImage()).asBitmap().into(target_addmember_member);
                holder.tv.setText(item.getText().get(0).toString());

                holder.wrapper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        fm.beginTransaction().add(new Fragment_Trending(),"").addToBackStack("").commit();
                        Intent intent = new Intent(context, NotificationActivity_AddMember.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("url", item.getContent().getMember().getImage());
                        intent.putExtra("username", item.getContent().getMember().getUsername());
                        intent.putExtra("password", item.getContent().getMember().getCompleteName());
                        context.startActivity(intent);

                    }
                });

                break;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        @Bind(R.id.img_member)
        CircularImageView img_member;
        @Nullable
        @Bind(R.id.img)
        CircularImageView img;
        @Nullable
        @Bind(R.id.tv)
        KufedTextView tv;
        @Nullable
        @Bind(R.id.img_target_post)
        ImageView img_target_post;
        @Nullable
        @Bind(R.id.wrapper)
        View wrapper;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }
}
