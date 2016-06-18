package com.kufed.id.customadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kufed.id.activity.Category_ListItem;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedTextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 6/18/16.
 */
public class RVAdapter_ListProduct extends RecyclerView.Adapter<RVAdapter_ListProduct.ViewHolder>{
    private Context context;

    public RVAdapter_ListProduct(Context context){
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product_by_category, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQxX8d57ehjqdXdB4eGpm5d9W_4czpfc-3wKVlZ4pfGQ1U08ZMhgA").asBitmap().into(holder.img);
        holder.tv.setText("Sashiko Teddy Bear");
        holder.tv_price.setText("IDR 850k");

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, Category_ListItem.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("id","");
//                intent.putExtra("category_name",item);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.img)ImageView img;
        @Bind(R.id.tv)KufedTextView tv;
        @Bind(R.id.tv_price)KufedTextView tv_price;

        public ViewHolder(View view){
            super(view);
            try {
                ButterKnife.bind(this, view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
