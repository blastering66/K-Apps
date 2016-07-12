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
import com.kufed.id.rowdata.Rowdata_Detail_Likes;
import com.pkmmte.view.CircularImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 6/28/16.
 */
public class RVAdapter_Detail_Like  extends RecyclerView.Adapter<RVAdapter_Detail_Like.Viewholder>{
    private Context context;
    private List<Rowdata_Detail_Likes> data;

    public RVAdapter_Detail_Like(Context context, List<Rowdata_Detail_Likes> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_likes, null);
        Viewholder viewholder =new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(final Viewholder holder, int position) {
        final Rowdata_Detail_Likes item = data.get(position);

        Target<Bitmap> target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                holder.img.setImageBitmap(resource);
            }
        };

        Glide.with(context).load(item.getUrl_photo()).asBitmap().into(target);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        @Bind(R.id.img)CircularImageView img;

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
