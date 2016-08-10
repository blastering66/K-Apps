package com.kufed.id.customadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.customview.KufedTextViewProductTitle;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.pojo.PojoResponseCartList;
import com.kufed.id.pojo.PojoResponseCheckout;
import com.kufed.id.rest.Rest_Adapter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 8/2/16.
 */
public class RVAdapter_CartList extends RecyclerView.Adapter<RVAdapter_CartList.ViewHolder>{
    private Context context;
    private List<PojoResponseCartList.Detail> data;
    private Rest_Adapter adapter;
    private String access_token;

    public RVAdapter_CartList(Context context, Rest_Adapter adapter, String access_token) {
        this.context = context;
        this.adapter = adapter;
        this.access_token = access_token;
        this.data = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_table_cart, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        PojoResponseCartList.Detail item = data.get(position);

        holder.tv_brand_name.setText(item.getProduct().getVariationName());
        holder.tv_post_title.setText(item.getProduct().getBrandName());
        holder.tv_variation.setText("Color " + item.getProduct().getColorName() + " | Size " + item.getProduct().getSize());
        holder.tv_qty.setText("Qty :" + item.getPrices().getQuantity());

        try{
            NumberFormat nf = NumberFormat.getNumberInstance();
            String cPrice = nf.format(item.getPrices().getSubtotal());
            holder.tv_subtotal.setText("IDR " + cPrice);

        }catch (NullPointerException e){
            holder.tv_subtotal.setText("IDR ");
        }

        Target<Bitmap> target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                holder.img.setImageBitmap(resource);
            }
        };

        Glide.with(context).load(item.getProduct().getMainImage()).asBitmap().into(target);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.img)ImageView img;
        @Bind(R.id.tv_brand_name)KufedTextView tv_brand_name;
        @Bind(R.id.tv_post_title)KufedTextView tv_post_title;
        @Bind(R.id.tv_variation)KufedTextView tv_variation;
        @Bind(R.id.tv_qty)KufedTextView tv_qty;
        @Bind(R.id.tv_subtotal)KufedTextView tv_subtotal;
        @Bind(R.id.btn_delete)ImageView btn_delete;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void addAll(List<PojoResponseCartList.Detail> newData) {
        data.addAll(newData);
        notifyDataSetChanged();
    }
}
