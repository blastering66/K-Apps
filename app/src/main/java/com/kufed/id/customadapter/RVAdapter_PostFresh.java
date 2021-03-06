package com.kufed.id.customadapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kufed.id.activity.Detail_Cart;
import com.kufed.id.activity.Detail_Product;
import com.kufed.id.activity.Detail_Product_Normal;
import com.kufed.id.activity.ListLikedPost;
import com.kufed.id.activity.MainMenu;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedButton;
import com.kufed.id.customview.KufedLikeImageView;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.customview.KufedTextViewProductTitle;
import com.kufed.id.pojo.PojoAccessToken;
import com.kufed.id.pojo.PojoLikedPost;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.pojo.PojoResponseRegister;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.rowdata.Rowdata_PostFresh;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
//import retrofit.Call;
//import retrofit.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/21/16.
 */
public class RVAdapter_PostFresh extends RecyclerView.Adapter<RVAdapter_PostFresh.ViewHolder> {
    private Context context;
    private List<PojoPostFresh.Post> data;
    private Rest_Adapter adapter;
    private String access_token;

    public RVAdapter_PostFresh(Context context, List<PojoPostFresh.Post> data, Rest_Adapter adapter,
                               String access_token) {
        this.context = context;
        this.data = data;
        this.adapter = adapter;
        this.access_token =access_token;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final PojoPostFresh.Post item = data.get(position);

        Glide.with(context).load(item.getFullImagePath()).asBitmap().into(holder.img);
//        Glide.with(context).load("https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/2010-1465207439-full.jpg").asBitmap().into(holder.img);
//        holder.tv_name.setText(item.getPostTitle());
        try{
            holder.tv_name.setText(item.getProduct().getProductTitle());
        }catch (NullPointerException e){
            holder.tv_name.setText("Null");
        }
        try{
            holder.tv_user.setText(item.getBrandName());
        }catch (NullPointerException e){
            holder.tv_user.setText("Null");
        }

        try{
            NumberFormat nf = NumberFormat.getNumberInstance();
            String cPrice = nf.format(item.getProduct().getSellingPrice());
            holder.tv_price.setText("IDR " + cPrice);

        }catch (NullPointerException e){
            holder.tv_price.setText("Null");
        }

        holder.wrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
//                    Intent intent = new Intent(context, Detail_Product.class);
                    Intent intent = new Intent(context, Detail_Product_Normal.class);
                    intent.putExtra(Param_Collection.EXTRA_POST_ID, item.getPostId().toString());
                    intent.putExtra(Param_Collection.EXTRA_POST_PRODUCT_TITLE, item.getProduct().getProductTitle());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }catch (NullPointerException e){

                }catch (Exception e){

                }

            }
        });

        try{
            holder.tv_likes_counter.setText(item.getLikesCount().toString());
        }catch (NullPointerException e){
            holder.tv_likes_counter.setText("0");
        }

        holder.tv_likes_counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent_listliked = new Intent(context, ListLikedPost.class);
                    intent_listliked.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent_listliked.putExtra(Param_Collection.EXTRA_POST_ID, item.getPostId());
                    context.startActivity(intent_listliked);
                }catch (NullPointerException e){

                }catch (Exception e){

                }

            }
        });

        if(item.getIsLiked()){
            holder.img_like_imageview.setIsSelected(true);
            holder.img_like_imageview.setImageResource(R.drawable.img_like_icon_after);
        }else{
            holder.img_like_imageview.setIsSelected(false);
            holder.img_like_imageview.setImageResource(R.drawable.img_like_icon);
        }

        holder.img_like_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.img_like_imageview.isSelected()){
                    holder.img_like_imageview.setImageResource(R.drawable.img_like_icon);
                    holder.img_like_imageview.setIsSelected(false);
                    int counterLiked = item.getLikesCount();
                    holder.tv_likes_counter.setText(String.valueOf(counterLiked));
                }else{
                    holder.img_like_imageview.setImageResource(R.drawable.img_like_icon_after);
                    holder.img_like_imageview.setIsSelected(true);
                    int counterLiked = item.getLikesCount() + 1;
                    holder.tv_likes_counter.setText(String.valueOf(counterLiked));
                }
                click_like(item.getPostId().toString());

            }
        });

        holder.img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item.getPostUrl().toString() != null){
                    click_share(item.getProduct().getProductTitle(), item.getPostContent(), item.getPostUrl().toString());
                }

            }
        });
        holder.tv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item.getPostUrl().toString() != null){
                    click_share(item.getProduct().getProductTitle(), item.getPostContent(), item.getPostUrl().toString());
                }
            }
        });

        if(item.getStockCurrent().equals("0")){
            holder.btn_add_to_cart.setText("SOLD OUT");
        }
        holder.btn_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!item.getStockCurrent().equals("0")){
                    Intent intent_cart = new Intent(context, Detail_Cart.class);
                    intent_cart.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent_cart);
                }else{
                    Toast.makeText(context, R.string.toast_soldout, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void click_like(final String id){
        Observable<PojoLikedPost> observable = adapter.like_post(id, access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoLikedPost>() {
                    @Override
                    public void onCompleted() {
                        Log.e("", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "");
                    }

                    @Override
                    public void onNext(PojoLikedPost pojoLikedPost) {
                        Log.e("", "");

                    }
                });
    }


    private void click_like(String id, final ImageView img){
        Observable<PojoLikedPost> observable = adapter.like_post(id, access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoLikedPost>() {
                    @Override
                    public void onCompleted() {
                        Log.e("", "");
                        img.setImageResource(R.drawable.img_like_icon_after);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "");
                        img.setImageResource(R.drawable.img_like_icon_after);
                    }

                    @Override
                    public void onNext(PojoLikedPost pojoLikedPost) {
                        Log.e("", "");

                    }
                });

    }

    private void click_share(String title,String extra_text, String post_url){
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, title);
        share.putExtra(Intent.EXTRA_TEXT, post_url);

        context.startActivity(Intent.createChooser(share, "Share link!"));

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
        @Bind(R.id.tv_name)KufedTextViewProductTitle tv_name;
        @Bind(R.id.tv_price)KufedTextView tv_price;
        @Bind(R.id.tv_user)KufedTextView tv_user;
        @Bind(R.id.wrapper)View wrapper;
        @Bind(R.id.tv_likes_counter)KufedTextView tv_likes_counter;
        @Bind(R.id.img_like_imageview)KufedLikeImageView img_like_imageview;
        @Bind(R.id.img_share)ImageView img_share;
        @Bind(R.id.tv_share)KufedTextView tv_share;
        @Bind(R.id.btn_add_to_chart)KufedButton btn_add_to_cart;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
