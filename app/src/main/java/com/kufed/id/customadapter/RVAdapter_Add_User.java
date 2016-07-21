package com.kufed.id.customadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.rowdata.RowData_UserToAdd;
import com.kufed.id.rowdata.Rowdata_Detail_RelatedItem;
import com.pkmmte.view.CircularImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 6/28/16.
 */
public class RVAdapter_Add_User extends RecyclerView.Adapter<RVAdapter_Add_User.Viewholder>{
    private Context context;
    private List<RowData_UserToAdd> data;

    public RVAdapter_Add_User(Context context, List<RowData_UserToAdd> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_add_member, null);
        Viewholder viewholder =new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(final Viewholder holder, int position) {
        final RowData_UserToAdd item = data.get(position);
        Target<Bitmap> target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                holder.img.setImageBitmap(resource);
            }
        };
        Glide.with(context).load(item.getUrl()).asBitmap().into(target);
        holder.tv_user.setText(item.getUsername().toString());
        holder.tv_fullname_user.setText(item.getFullname().toString());
        holder.img_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        @Bind(R.id.img)CircularImageView img;
        @Bind(R.id.tv_user)KufedTextView tv_user;
        @Bind(R.id.tv_fullname_user)KufedTextView tv_fullname_user;
        @Bind(R.id.img_check)ImageView img_check;
        @Bind(R.id.img_cancel)ImageView img_cancel;

        public Viewholder(View itemView) {
            super(itemView);
            try {
                ButterKnife.bind(this, itemView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
