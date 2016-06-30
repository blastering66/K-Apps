package com.kufed.id.customadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.rowdata.Rowdata_Detail_Likes;
import com.pkmmte.view.CircularImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 6/28/16.
 */
public class RVAdapter_Detail_Comments extends RecyclerView.Adapter<RVAdapter_Detail_Comments.Viewholder>{
    private Context context;
    private String user_name, user_url_photo, user_date_comment, user_comment;
    private String user_name_2, user_url_photo_2, user_date_comment_2, user_comment_2;
    private String user_name_3, user_url_photo_3, user_date_comment_3, user_comment_3;

    public RVAdapter_Detail_Comments(Context context, String user_name, String user_url_photo, String user_date_comment, String user_comment,
                                     String user_name_2, String user_url_photo_2, String user_date_comment_2, String user_comment_2,
                                     String user_name_3, String user_url_photo_3, String user_date_comment_3, String user_comment_3) {
        this.context = context;
        this.user_name = user_name;
        this.user_url_photo = user_url_photo;
        this.user_date_comment = user_date_comment;
        this.user_comment = user_comment;
        this.user_name_2 = user_name_2;
        this.user_url_photo_2 = user_url_photo_2;
        this.user_date_comment_2 = user_date_comment_2;
        this.user_comment_2 = user_comment_2;
        this.user_name_3 = user_name_3;
        this.user_url_photo_3 = user_url_photo_3;
        this.user_date_comment_3 = user_date_comment_3;
        this.user_comment_3 = user_comment_3;
    }

    public RVAdapter_Detail_Comments(Context context) {

        this.context = context;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_comments, null);
        Viewholder viewholder =new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        Glide.with(context).load(user_url_photo).asBitmap().into(holder.img);
        Glide.with(context).load(user_url_photo_2).asBitmap().into(holder.img_2);
        Glide.with(context).load(user_url_photo_3).asBitmap().into(holder.img_3);

        holder.tv_user.setText(user_name);
        holder.tv_date.setText(user_date_comment);
        holder.tv_comment.setText(user_comment);

        holder.tv_user_2.setText(user_name_2);
        holder.tv_date_2.setText(user_date_comment_2);
        holder.tv_comment_2.setText(user_comment_2);

        holder.tv_user_3.setText(user_name_3);
        holder.tv_date_3.setText(user_date_comment_3);
        holder.tv_comment_3.setText(user_comment_3);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        @Bind(R.id.img)CircularImageView img;
        @Bind(R.id.tv_user)KufedTextView tv_user;
        @Bind(R.id.tv_date)KufedTextView tv_date;
        @Bind(R.id.tv_comment)KufedTextView tv_comment;

        @Bind(R.id.img_2)CircularImageView img_2;
        @Bind(R.id.tv_user_2)KufedTextView tv_user_2;
        @Bind(R.id.tv_date_2)KufedTextView tv_date_2;
        @Bind(R.id.tv_comment_2)KufedTextView tv_comment_2;

        @Bind(R.id.img_3)CircularImageView img_3;
        @Bind(R.id.tv_user_3)KufedTextView tv_user_3;
        @Bind(R.id.tv_date_3)KufedTextView tv_date_3;
        @Bind(R.id.tv_comment_3)KufedTextView tv_comment_3;

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
