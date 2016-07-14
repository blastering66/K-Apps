package com.kufed.id.customadapter;

/**
 * Created by macbook on 6/17/16.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kufed.id.activity.R;
import com.kufed.id.util.Param_Collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class RVAdapter_Slider extends RecyclerView.Adapter<RVAdapter_Slider.ViewHolder>{
    private Context context;
    private onSliderItemSelectedListener listener;
    private SharedPreferences spf;
    private int posisi_selected_menu;

    public interface onSliderItemSelectedListener{
        public void onChangeFragmentContentPosition(int position);
    }

    public void selectedMenu(int position){
        Log.e("KLIK", "");

    }

    public RVAdapter_Slider(Context context, SharedPreferences spf) {
        this.context = context;
        this.spf = spf;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_slider_icon_txt, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        try{
            listener = (onSliderItemSelectedListener)context;
            posisi_selected_menu = spf.getInt(Param_Collection.SPF_SELECTED_SLIDER_MENU, 0);

            switch (position){
                case 0:
                    holder.img.setImageResource(R.drawable.img_home);
                    holder.tv.setText("Home");
//                    holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                    holder.wrapper.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.onChangeFragmentContentPosition(position);

                            if(posisi_selected_menu == position){
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                holder.img.setImageResource(R.drawable.img_home);
                            }else{
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.img.setImageResource(R.drawable.img_home_after);

                            }

                        }
                    });
                    break;
                case 1:
                    holder.img.setImageResource(R.drawable.img_camera);
                    holder.tv.setText("Camera");

                    holder.wrapper.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.onChangeFragmentContentPosition(position);

                            if(posisi_selected_menu == position){
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                holder.img.setImageResource(R.drawable.img_camera);
                            }else{
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.img.setImageResource(R.drawable.img_camera_after);
                            }
                        }
                    });

                    break;
                case 2:
                    holder.img.setImageResource(R.drawable.img_shop);
                    holder.tv.setText("Shop");
                    holder.wrapper.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.onChangeFragmentContentPosition(position);

                            if(posisi_selected_menu == position){
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                holder.img.setImageResource(R.drawable.img_shop);
                            }else{
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.img.setImageResource(R.drawable.img_shop_after);
                            }
                        }
                    });
                    break;
                case 3:
                    holder.img.setImageResource(R.drawable.img_notif);
                    holder.tv.setText("Notifications");
                    holder.wrapper.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.onChangeFragmentContentPosition(position);

                            if (posisi_selected_menu == position) {
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                holder.img.setImageResource(R.drawable.img_notif);
                            } else {
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.img.setImageResource(R.drawable.img_notif_after);
                            }
                        }
                    });
                    break;
                case 4:
                    holder.img.setVisibility(View.GONE);
                    holder.tv.setText("SETTINGS");
                    break;
                case 5:
                    holder.img.setVisibility(View.GONE);
                    holder.tv.setText("HELP");
                    break;
                case 6:
                    holder.img.setVisibility(View.GONE);
                    holder.tv.setText("TERMS AND CONDITION");
                    break;

                case 7:
                    holder.img.setVisibility(View.GONE);
                    holder.tv.setText("LOGOUT");
                    holder.tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.onChangeFragmentContentPosition(position);
                        }
                    });
                    break;
            }
        }catch (ClassCastException e){

        }



    }

    @Override
    public int getItemCount() {
        return 8;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public View wrapper;
        public ImageView img;
        public TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            wrapper = (View)itemView.findViewById(R.id.wrapper);
            img = (ImageView)itemView.findViewById(R.id.img);
            tv = (TextView)itemView.findViewById(R.id.tv);

        }
    }
}
