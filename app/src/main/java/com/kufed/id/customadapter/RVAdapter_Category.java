package com.kufed.id.customadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.kufed.id.activity.Category_ListItem;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.rowdata.Rowdata_Category;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 6/18/16.
 */
public class RVAdapter_Category extends RecyclerView.Adapter<RVAdapter_Category.Viewholder> {
    private Context context;
    private List<Rowdata_Category > rowdata;

    public RVAdapter_Category(Context context, List<Rowdata_Category > rowdata){
        this.context =context;
        this.rowdata = rowdata;
    }

    @Override
    public int getItemCount() {
        return rowdata.size();
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shop_category, null);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        final Rowdata_Category data = rowdata.get(position);

        Glide.with(context).load(data.getCategoryThumbPath()).asBitmap().into(holder.img);
        holder.tv.setText(data.getCategoryName());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Category_ListItem.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id", data.getCategoryId());
                intent.putExtra("category_name", data.getCategoryName());
                context.startActivity(intent);
            }
        });
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        @Bind(R.id.img)ImageView img;
        @Bind(R.id.tv)KufedTextView tv;

        public Viewholder(View itemView) {
            super(itemView);
//            ButterKnife.bind(context, itemView);
            try {
                ButterKnife.bind(this, itemView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
