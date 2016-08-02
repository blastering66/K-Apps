package com.kufed.id.customadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;

import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.customview.KufedTextViewProductTitle;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.pojo.PojoResponseCheckout;
import com.kufed.id.rest.Rest_Adapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 8/2/16.
 */
public class RVAdapter_CartList extends RecyclerView.Adapter<RVAdapter_CartList.ViewHolder>{
    private Context context;
    private List<PojoResponseCheckout.Cart> data;
    private Rest_Adapter adapter;
    private String access_token;

    public RVAdapter_CartList(Context context, List<PojoResponseCheckout.Cart> data, Rest_Adapter adapter, String access_token) {
        this.context = context;
        this.data = data;
        this.adapter = adapter;
        this.access_token = access_token;
    }

    public RVAdapter_CartList(Context context, Rest_Adapter adapter, String access_token) {
        this.context = context;
        this.adapter = adapter;
        this.access_token = access_token;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_table_cart, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_brand_name.setText("Brand Name");
    }

    @Override
    public int getItemCount() {
//        return data.size();
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.img)ImageView img;
        @Bind(R.id.tv_brand_name)KufedTextView tv_brand_name;
        @Bind(R.id.tv_post_title)KufedTextView tv_post_title;
        @Bind(R.id.tv_variation)KufedTextView tv_variation;
        @Bind(R.id.tv_selling_price)KufedTextView tv_selling_price;
        @Bind(R.id.spinne_qty)Spinner spinne_qty;
        @Bind(R.id.tv_subtotal)KufedTextView tv_subtotal;
        @Bind(R.id.btn_delete)ImageView btn_delete;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
