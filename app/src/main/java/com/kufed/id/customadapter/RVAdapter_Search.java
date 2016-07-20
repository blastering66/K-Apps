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
import com.kufed.id.pojo.PojoResultSearch;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 7/19/16.
 */
public class RVAdapter_Search extends RecyclerView.Adapter<RVAdapter_Search.ViewHolder>{
    private Context context;
    private List<PojoResultSearch.Datum> data;

    public RVAdapter_Search(Context context, List<PojoResultSearch.Datum> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final PojoResultSearch.Datum item = data.get(position);


        Target<Bitmap> target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                holder.img.setImageBitmap(resource);

            }
        };

        Glide.with(context).load(item.getPostNormalImage()).asBitmap().into(target);
        holder.tv.setText(item.getProductTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product_searchresult, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.img)ImageView img;
        @Bind(R.id.tv)KufedTextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
