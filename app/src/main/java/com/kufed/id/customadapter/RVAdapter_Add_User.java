package com.kufed.id.customadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.kufed.id.activity.R;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.pojo.PojoFriendAdded;
import com.kufed.id.pojo.PojoFriendRequests;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.rowdata.RowData_UserToAdd;
import com.kufed.id.rowdata.Rowdata_Detail_RelatedItem;
import com.kufed.id.util.Public_Functions;
import com.pkmmte.view.CircularImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/28/16.
 */
public class RVAdapter_Add_User extends RecyclerView.Adapter<RVAdapter_Add_User.Viewholder> {
    private Context context;
    private List<PojoFriendRequests.Friend> data;
    private Rest_Adapter adapter;
    private String access_token;

    public RVAdapter_Add_User(Context context, List<PojoFriendRequests.Friend> data, Rest_Adapter adapter,
                              String access_token) {
        this.context = context;
        this.data = data;
        this.adapter = adapter;
        this.access_token = access_token;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_add_member, null);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(final Viewholder holder, final int position) {
        final PojoFriendRequests.Friend item = data.get(position);
        Target<Bitmap> target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                holder.img.setImageBitmap(resource);
            }
        };
        Glide.with(context).load(item.getMember().getPictureThumbPath()).asBitmap().into(target);
        holder.tv_user.setText(item.getMember().getMemberUsername().toString());
        holder.tv_fullname_user.setText(item.getMember().getMemberCompleteName().toString());
        holder.img_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sementara
                holder.wrapper.setVisibility(View.GONE);
                data.remove(position);
                notifyDataSetChanged();

                Observable<PojoFriendAdded> observable = null;

//                Observable<PojoFriendAdded> observable = adapter.approve_friend(item.getMember().getMemberId(),
//                        access_token);


                observable.observeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<PojoFriendAdded>() {
                            private boolean isSukses = false;
                            private String message = "";

                            @Override
                            public void onCompleted() {
                                if (isSukses) {
                                    holder.wrapper.setVisibility(View.GONE);
                                } else {
                                    Toast.makeText(context, "Failed to Approve, reason = " +
                                            message, Toast.LENGTH_LONG).show();
                                }

                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(context, "Failed to Approve, reason = " +
                                        message, Toast.LENGTH_LONG).show();

                            }

                            @Override
                            public void onNext(PojoFriendAdded pojoFriendAdded) {
                                if (pojoFriendAdded.getStatus().getCode() == 200) {
                                    isSukses = true;
                                } else {
                                    message = pojoFriendAdded.getStatus().getDescription().toString();
                                }

                            }
                        });

            }
        });

        holder.img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Ignored"
                        , Toast.LENGTH_LONG).show();
                holder.wrapper.setVisibility(View.GONE);
                data.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        @Bind(R.id.wrapper)
        View wrapper;
        @Bind(R.id.img)
        CircularImageView img;
        @Bind(R.id.tv_user)
        KufedTextView tv_user;
        @Bind(R.id.tv_fullname_user)
        KufedTextView tv_fullname_user;
        @Bind(R.id.img_check)
        ImageView img_check;
        @Bind(R.id.img_cancel)
        ImageView img_cancel;

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
