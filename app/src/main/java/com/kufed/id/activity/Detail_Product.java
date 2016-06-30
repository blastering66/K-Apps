package com.kufed.id.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.kufed.id.customadapter.RVAdapter_Detail_Comments;
import com.kufed.id.customadapter.RVAdapter_Detail_Like;
import com.kufed.id.customadapter.RVAdapter_Detail_RelatedItem;
import com.kufed.id.customadapter.RVAdapter_Detail_SoldByStore;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.fragment.Fragment_VP_Image;
import com.kufed.id.rowdata.Rowdata_Detail_Likes;
import com.kufed.id.rowdata.Rowdata_Detail_RelatedItem;
import com.kufed.id.rowdata.Rowdata_Detail_SolybyStore;
import com.pixelcan.inkpageindicator.InkPageIndicator;
import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macbook on 6/22/16.
 */
public class Detail_Product extends AppCompatActivity {
    @Bind(R.id.vp)ViewPager vp;
    @Bind(R.id.indicator)InkPageIndicator indicator;
    List<String> data_image_vp;
    List<Rowdata_Detail_Likes> data_likes;
    List<Rowdata_Detail_SolybyStore> data_soldbystore;
    List<Rowdata_Detail_RelatedItem> data_relateditem;
    PagerAdapter pagerAdapter;

    @Bind(R.id.rv_likes)RecyclerView rv_likes;
    RecyclerView.Adapter  layoutAdapter_Likes;
    RecyclerView.LayoutManager layoutManager_Likes;

    private String user_name, user_url_photo, user_date_comment, user_comment;
    private String user_name_2, user_url_photo_2, user_date_comment_2, user_comment_2;
    private String user_name_3, user_url_photo_3, user_date_comment_3, user_comment_3;
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

    @Bind(R.id.rv_soldby_store)RecyclerView rv_soldby_store;
    RecyclerView.Adapter  layoutAdapter_SoldBy;
    RecyclerView.LayoutManager layoutManager_SoldBy;

    @Bind(R.id.rv_related_item)RecyclerView rv_related_item;
    RecyclerView.Adapter  layoutAdapter_RelatedItem;
    RecyclerView.LayoutManager layoutManager_RelatedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        ButterKnife.bind(this);
//        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Sushicko Teddy Bear");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getVP_ImageGallery();
        get_Likes();
        get_SoldByStore();
        get_RelatedItems();
        get_Top3Comments();
        iniView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getVP_ImageGallery(){
        data_image_vp = new ArrayList<>();
        data_image_vp.add("https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/944-1460963003-full.jpg");
        data_image_vp.add("https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/724-1460013150-full.jpg");
        data_image_vp.add("https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/2713-1466595679-full.jpg");
    }

    private void get_Likes(){
        data_likes = new ArrayList<>();
        data_likes.add(new Rowdata_Detail_Likes("","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKogXO9XLXuccnetXAhfPDeI-bUwteBgZLjLKjnmaEq6QrKTHK"));
        data_likes.add(new Rowdata_Detail_Likes("","https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTW9B4x49k6sHr1KcOgWWMSCaeU6Mb83sCa9pJtJQF4eIfyEt3t"));
        data_likes.add(new Rowdata_Detail_Likes("","https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRtsqdRmoxwbpW401GR2ZcVSqWHbfM1jnDjMepPsWmgQSHg9n_u0w"));
        data_likes.add(new Rowdata_Detail_Likes("","https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ3jU1it6fzAxrvxUuVp2DrgBbc2Kk3lFWMVEDxORT3IiZaj01uFg"));
        data_likes.add(new Rowdata_Detail_Likes("","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKogXO9XLXuccnetXAhfPDeI-bUwteBgZLjLKjnmaEq6QrKTHK"));
        data_likes.add(new Rowdata_Detail_Likes("","https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTW9B4x49k6sHr1KcOgWWMSCaeU6Mb83sCa9pJtJQF4eIfyEt3t"));
        data_likes.add(new Rowdata_Detail_Likes("","https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRtsqdRmoxwbpW401GR2ZcVSqWHbfM1jnDjMepPsWmgQSHg9n_u0w"));
        data_likes.add(new Rowdata_Detail_Likes("","https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ3jU1it6fzAxrvxUuVp2DrgBbc2Kk3lFWMVEDxORT3IiZaj01uFg"));
    }

    private void get_Top3Comments(){
        user_name = "Song Jihyo";
        user_url_photo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKogXO9XLXuccnetXAhfPDeI-bUwteBgZLjLKjnmaEq6QrKTHK";
        user_date_comment = "1 Hour ago";
        user_comment = "This is Sample Message that crossed over in tow lines and goes on";

        user_name_2 = "Jeon Somi";
        user_url_photo_2 = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTW9B4x49k6sHr1KcOgWWMSCaeU6Mb83sCa9pJtJQF4eIfyEt3t";
        user_date_comment_2 = "2 Days ago";
        user_comment_2 = "This is Sample Message that crossed over in tow lines and goes on";

        user_name_3 = "Bang Minah";
        user_url_photo_3 = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ3jU1it6fzAxrvxUuVp2DrgBbc2Kk3lFWMVEDxORT3IiZaj01uFg";
        user_date_comment_3 = "1 Week ago";
        user_comment_3 = "This is Sample Message that crossed over in tow lines and goes on";

        Glide.with(getApplicationContext()).load(user_url_photo).asBitmap().into(img);
        Glide.with(getApplicationContext()).load(user_url_photo_2).asBitmap().into(img_2);
        Glide.with(getApplicationContext()).load(user_url_photo_3).asBitmap().into(img_3);

        tv_user.setText(user_name);
        tv_date.setText(user_date_comment);
        tv_comment.setText(user_comment);

        tv_user_2.setText(user_name_2);
        tv_date_2.setText(user_date_comment_2);
        tv_comment_2.setText(user_comment_2);

        tv_user_3.setText(user_name_3);
        tv_date_3.setText(user_date_comment_3);
        tv_comment_3.setText(user_comment_3);
    }

    private void get_SoldByStore(){
        data_soldbystore = new ArrayList<>();
        data_soldbystore.add(new Rowdata_Detail_SolybyStore("","https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/944-1460963003-full.jpg"));
        data_soldbystore.add(new Rowdata_Detail_SolybyStore("","https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/724-1460013150-full.jpg"));
        data_soldbystore.add(new Rowdata_Detail_SolybyStore("","https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/2713-1466595679-full.jpg"));
        data_soldbystore.add(new Rowdata_Detail_SolybyStore("","https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/944-1460963003-full.jpg"));

    }

    private void get_RelatedItems(){
        data_relateditem= new ArrayList<>();
        data_relateditem.add(new Rowdata_Detail_RelatedItem("","https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/944-1460963003-full.jpg"));
        data_relateditem.add(new Rowdata_Detail_RelatedItem("","https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/724-1460013150-full.jpg"));
        data_relateditem.add(new Rowdata_Detail_RelatedItem("","https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/2713-1466595679-full.jpg"));
        data_relateditem.add(new Rowdata_Detail_RelatedItem("","https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/944-1460963003-full.jpg"));
        data_relateditem.add(new Rowdata_Detail_RelatedItem("","https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/724-1460013150-full.jpg"));

    }

    private void iniView(){
        pagerAdapter = new Image_Product_Adapter(getSupportFragmentManager());
        vp.setAdapter(pagerAdapter);
        indicator.setViewPager(vp);

        layoutAdapter_Likes = new RVAdapter_Detail_Like(Detail_Product.this, data_likes);


        layoutAdapter_SoldBy = new RVAdapter_Detail_SoldByStore(getApplicationContext(), data_soldbystore);
        layoutAdapter_RelatedItem = new RVAdapter_Detail_RelatedItem(getApplicationContext(),data_relateditem);

        layoutManager_Likes = new LinearLayoutManager(Detail_Product.this, LinearLayoutManager.HORIZONTAL,false);
        layoutManager_SoldBy = new LinearLayoutManager(Detail_Product.this, LinearLayoutManager.HORIZONTAL,false);
        layoutManager_RelatedItem = new LinearLayoutManager(Detail_Product.this,LinearLayoutManager.HORIZONTAL,false);

        rv_likes.setAdapter(layoutAdapter_Likes);
        rv_likes.setLayoutManager(layoutManager_Likes);

        rv_related_item.setAdapter(layoutAdapter_RelatedItem);
        rv_related_item.setLayoutManager(layoutManager_RelatedItem);

        rv_soldby_store.setAdapter(layoutAdapter_SoldBy);
        rv_soldby_store.setLayoutManager(layoutManager_SoldBy);
    }
    private class Image_Product_Adapter extends FragmentStatePagerAdapter{

        public Image_Product_Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return Fragment_VP_Image.create(data_image_vp.get(position));
        }

        @Override
        public int getCount() {
            return data_image_vp.size();
        }
    }
}
