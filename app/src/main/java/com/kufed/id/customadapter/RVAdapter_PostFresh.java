package com.kufed.id.customadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kufed.id.activity.Detail_Product;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.rowdata.Rowdata_PostFresh;

import java.text.NumberFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 6/21/16.
 */
public class RVAdapter_PostFresh extends RecyclerView.Adapter<RVAdapter_PostFresh.ViewHolder> {
    private Context context;
    private List<PojoPostFresh.Post> data;

    public RVAdapter_PostFresh(Context context, List<PojoPostFresh.Post> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PojoPostFresh.Post item = data.get(position);

//        Glide.with(context).load(item.getNormalImagePath()).asBitmap().into(holder.img);
        Glide.with(context).load("https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/2010-1465207439-full.jpg").asBitmap().into(holder.img);
        holder.tv_name.setText(item.getPostTitle());
        holder.tv_user.setText(item.getBrandName());

        NumberFormat nf = NumberFormat.getNumberInstance();
        String cPrice = nf.format(item.getProduct().getSellingPrice());
        holder.tv_price.setText("IDR " + cPrice);

        holder.wrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail_Product.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post_fresh, null);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.img)ImageView img;
        @Bind(R.id.tv_name)KufedTextView tv_name;
        @Bind(R.id.tv_price)KufedTextView tv_price;
        @Bind(R.id.tv_user)KufedTextView tv_user;
        @Bind(R.id.wrapper)View wrapper;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
