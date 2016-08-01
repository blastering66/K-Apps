package com.kufed.id.customadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kufed.id.activity.Detail_Product_Normal;
import com.kufed.id.activity.R;
import com.kufed.id.rowdata.Rowdata_Detail_RelatedItem;
import com.kufed.id.util.Param_Collection;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 6/28/16.
 */
public class RVAdapter_Detail_RelatedItem extends RecyclerView.Adapter<RVAdapter_Detail_RelatedItem.Viewholder>{
    private Context context;
    private List<Rowdata_Detail_RelatedItem> data;

    public RVAdapter_Detail_RelatedItem(Context context, List<Rowdata_Detail_RelatedItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_related_item, null);
        Viewholder viewholder =new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, final int position) {
        final Rowdata_Detail_RelatedItem item = data.get(position);
        Glide.with(context).load(item.getUrl_photo()).asBitmap().into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail_Product_Normal.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Param_Collection.EXTRA_POST_ID, data.get(position).getId_userpost());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        @Bind(R.id.img)ImageView img;

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
