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
import com.kufed.id.customview.KufedTextViewSlider;
import com.kufed.id.util.Param_Collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class RVAdapter_Slider extends RecyclerView.Adapter<RVAdapter_Slider.ViewHolder>{
    private Context context;
    private onSliderItemSelectedListener listener;
    private SharedPreferences spf;
    private int posisi_selected_menu;
    private List<KufedTextViewSlider> title_objects;
    private List<ImageView> image_objects;

    public interface onSliderItemSelectedListener{
        public void onChangeFragmentContentPosition(int position);
    }


    public RVAdapter_Slider(Context context, SharedPreferences spf) {
        this.context = context;
        this.spf = spf;
        title_objects = new ArrayList<>();
        image_objects = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_slider_icon_txt, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        title_objects.add(holder.tv);
        image_objects.add(holder.img);

        title_objects.get(0).setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
        image_objects.get(0).setImageResource(R.drawable.img_home_after);

        try{
            listener = (onSliderItemSelectedListener)context;
            posisi_selected_menu = spf.getInt(Param_Collection.SPF_SELECTED_SLIDER_MENU, 0);

            switch (position){
                case 0:

                    holder.img.setImageResource(R.drawable.img_home);
                    holder.tv.setText("Home");
                    holder.wrapper.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.onChangeFragmentContentPosition(position);

                            if(holder.tv.isSelected()){
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                holder.img.setImageResource(R.drawable.img_home);
                                holder.tv.setIsSelected(false);

                            }else{
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.img.setImageResource(R.drawable.img_home_after);
                                holder.tv.setIsSelected(true);

//                                title_objects.get(0).setIsSelected(false);
//                                title_objects.get(0).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(1).setIsSelected(false);
                                title_objects.get(1).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(1).setImageResource(R.drawable.img_camera);

                                title_objects.get(2).setIsSelected(false);
                                title_objects.get(2).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(2).setImageResource(R.drawable.img_shop);

                                title_objects.get(3).setIsSelected(false);
                                title_objects.get(3).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(3).setImageResource(R.drawable.img_notif);

                                title_objects.get(4).setIsSelected(false);
                                title_objects.get(4).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(5).setIsSelected(false);
                                title_objects.get(5).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(6).setIsSelected(false);
                                title_objects.get(6).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
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
                            if(holder.tv.isSelected()){
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                holder.img.setImageResource(R.drawable.img_camera);
                                holder.tv.setIsSelected(false);
                            }else{
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.img.setImageResource(R.drawable.img_camera_after);
                                holder.tv.setIsSelected(true);

                                title_objects.get(0).setIsSelected(false);
                                title_objects.get(0).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(0).setImageResource(R.drawable.img_home);

//                                title_objects.get(1).setIsSelected(false);
//                                title_objects.get(1).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(2).setIsSelected(false);
                                title_objects.get(2).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(2).setImageResource(R.drawable.img_shop);

                                title_objects.get(3).setIsSelected(false);
                                title_objects.get(3).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(3).setImageResource(R.drawable.img_notif);

                                title_objects.get(4).setIsSelected(false);
                                title_objects.get(4).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(5).setIsSelected(false);
                                title_objects.get(5).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(6).setIsSelected(false);
                                title_objects.get(6).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
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
                            if(holder.tv.isSelected()){
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                holder.img.setImageResource(R.drawable.img_shop);
                                holder.tv.setIsSelected(false);
                            }else{
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.img.setImageResource(R.drawable.img_shop_after);
                                holder.tv.setIsSelected(true);

                                title_objects.get(0).setIsSelected(false);
                                title_objects.get(0).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(0).setImageResource(R.drawable.img_home);

                                title_objects.get(1).setIsSelected(false);
                                title_objects.get(1).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(1).setImageResource(R.drawable.img_camera);

//                                title_objects.get(2).setIsSelected(false);
//                                title_objects.get(2).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(3).setIsSelected(false);
                                title_objects.get(3).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(3).setImageResource(R.drawable.img_notif);

                                title_objects.get(4).setIsSelected(false);
                                title_objects.get(4).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(5).setIsSelected(false);
                                title_objects.get(5).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(6).setIsSelected(false);
                                title_objects.get(6).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
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
                            if(holder.tv.isSelected()){
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                holder.img.setImageResource(R.drawable.img_notif);
                                holder.tv.setIsSelected(false);
                            }else{
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.img.setImageResource(R.drawable.img_notif_after);
                                holder.tv.setIsSelected(true);

                                title_objects.get(0).setIsSelected(false);
                                title_objects.get(0).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(0).setImageResource(R.drawable.img_home);

                                title_objects.get(1).setIsSelected(false);
                                title_objects.get(1).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(1).setImageResource(R.drawable.img_camera);

                                title_objects.get(2).setIsSelected(false);
                                title_objects.get(2).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(2).setImageResource(R.drawable.img_shop);
//                                title_objects.get(3).setIsSelected(false);
//                                title_objects.get(3).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(4).setIsSelected(false);
                                title_objects.get(4).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(5).setIsSelected(false);
                                title_objects.get(5).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(6).setIsSelected(false);
                                title_objects.get(6).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                            }
                        }
                    });
                    break;
                case 4:
                    holder.img.setVisibility(View.GONE);
                    holder.tv.setText("SETTINGS");
                    holder.wrapper.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.onChangeFragmentContentPosition(position);
                            if(holder.tv.isSelected()){
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                holder.tv.setIsSelected(false);
                            }else{
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.tv.setIsSelected(true);

                                title_objects.get(0).setIsSelected(false);
                                title_objects.get(0).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(0).setImageResource(R.drawable.img_home);

                                title_objects.get(1).setIsSelected(false);
                                title_objects.get(1).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(1).setImageResource(R.drawable.img_camera);

                                title_objects.get(2).setIsSelected(false);
                                title_objects.get(2).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(2).setImageResource(R.drawable.img_shop);

                                title_objects.get(3).setIsSelected(false);
                                title_objects.get(3).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(3).setImageResource(R.drawable.img_notif);
//                                title_objects.get(4).setIsSelected(false);
//                                title_objects.get(4).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(5).setIsSelected(false);
                                title_objects.get(5).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(6).setIsSelected(false);
                                title_objects.get(6).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                            }
                        }
                    });
                    break;
                case 5:
                    holder.img.setVisibility(View.GONE);
                    holder.tv.setText("HELP");
                    holder.wrapper.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.onChangeFragmentContentPosition(position);
                            if(holder.tv.isSelected()){
                            }else{
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.tv.setIsSelected(true);

                                title_objects.get(0).setIsSelected(false);
                                title_objects.get(0).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(0).setImageResource(R.drawable.img_home);

                                title_objects.get(1).setIsSelected(false);
                                title_objects.get(1).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(1).setImageResource(R.drawable.img_camera);

                                title_objects.get(2).setIsSelected(false);
                                title_objects.get(2).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(2).setImageResource(R.drawable.img_shop);

                                title_objects.get(3).setIsSelected(false);
                                title_objects.get(3).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(3).setImageResource(R.drawable.img_notif);

                                title_objects.get(4).setIsSelected(false);
                                title_objects.get(4).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

//                                title_objects.get(5).setIsSelected(false);
//                                title_objects.get(5).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(6).setIsSelected(false);
                                title_objects.get(6).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                            }
                        }
                    });
                    break;
                case 6:
                    holder.img.setVisibility(View.GONE);
                    holder.tv.setText("TERMS AND CONDITION");
                    holder.wrapper.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.onChangeFragmentContentPosition(position);
                            if(holder.tv.isSelected()){

                            }else{
                                holder.tv.setTextColor(ContextCompat.getColor(context, R.color.tv_color_active));
                                holder.tv.setIsSelected(true);

                                title_objects.get(0).setIsSelected(false);
                                title_objects.get(0).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(0).setImageResource(R.drawable.img_home);

                                title_objects.get(1).setIsSelected(false);
                                title_objects.get(1).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(1).setImageResource(R.drawable.img_camera);

                                title_objects.get(2).setIsSelected(false);
                                title_objects.get(2).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(2).setImageResource(R.drawable.img_shop);

                                title_objects.get(3).setIsSelected(false);
                                title_objects.get(3).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
                                image_objects.get(3).setImageResource(R.drawable.img_notif);

                                title_objects.get(4).setIsSelected(false);
                                title_objects.get(4).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));

                                title_objects.get(5).setIsSelected(false);
                                title_objects.get(5).setTextColor(ContextCompat.getColor(context, R.color.tv_color_non_active));
//                                title_objects.get(6).setIsSelected(false);

                            }
                        }
                    });
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
        public KufedTextViewSlider tv;

        public ViewHolder(View itemView) {
            super(itemView);
            wrapper = (View)itemView.findViewById(R.id.wrapper);
            img = (ImageView)itemView.findViewById(R.id.img);
            tv = (KufedTextViewSlider)itemView.findViewById(R.id.tv);

        }
    }
}
