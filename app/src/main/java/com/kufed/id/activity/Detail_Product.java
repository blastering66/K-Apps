package com.kufed.id.activity;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
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
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.kufed.id.customadapter.RVAdapter_Detail_Comments;
import com.kufed.id.customadapter.RVAdapter_Detail_Like;
import com.kufed.id.customadapter.RVAdapter_Detail_RelatedItem;
import com.kufed.id.customadapter.RVAdapter_Detail_SoldByStore;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.fragment.Fragment_VP_Image;
import com.kufed.id.pojo.PojoPostInfo;
import com.kufed.id.pojo.PojoPostLikes;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.rowdata.Rowdata_Detail_Likes;
import com.kufed.id.rowdata.Rowdata_Detail_RelatedItem;
import com.kufed.id.rowdata.Rowdata_Detail_SolybyStore;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;
import com.pixelcan.inkpageindicator.InkPageIndicator;
import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/22/16.
 */
public class Detail_Product extends AppCompatActivity {
    @Bind(R.id.vp)
    ViewPager vp;
    @Bind(R.id.indicator)
    InkPageIndicator indicator;
    List<String> data_image_vp;
    List<Rowdata_Detail_Likes> data_likes;
    List<Rowdata_Detail_SolybyStore> data_soldbystore;
    List<Rowdata_Detail_RelatedItem> data_relateditem;
    PagerAdapter pagerAdapter;

    @Bind(R.id.rv_likes)
    RecyclerView rv_likes;
    RecyclerView.Adapter layoutAdapter_Likes;
    RecyclerView.LayoutManager layoutManager_Likes;

    @Bind(R.id.rv_related_item)
    RecyclerView rv_related_item;
    RecyclerView.Adapter layoutAdapter_RelatedItem;
    RecyclerView.LayoutManager layoutManager_RelatedItem;

    SharedPreferences spf;
    String access_token, post_id;

    @Bind(R.id.tv_name)KufedTextView tv_name;
    @Bind(R.id.tv_brand)KufedTextView tv_brand;
    @Bind(R.id.tv_user)KufedTextView tv_user;
    @Bind(R.id.tv_price)KufedTextView tv_price;
    @Bind(R.id.tv_desc)KufedTextView tv_desc;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        ButterKnife.bind(this);
//        setContentView(R.layout.activity_main_menu);
//        get_Likes();
//        get_SoldByStore();
//        get_RelatedItems();
//        get_Top3Comments();

        iniView();

        //Statis
        getPostInfo("910");
//        getPostInfo(post_id);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getPostInfo(final String post_id) {
        final Rest_Adapter adapter = Public_Functions.initRetrofit();

        Observable<PojoPostInfo> observable = adapter.get_post_info(post_id, access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<PojoPostInfo>() {
            @Override
            public void onCompleted() {
                Log.e("", "");
                Toast.makeText(getApplicationContext(), "TEST INFO SUCCESS", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("", "");
                Toast.makeText(getApplicationContext(), "TEST INFO ERROR", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNext(PojoPostInfo pojoPostInfo) {
                toolbar.setTitle(pojoPostInfo.getData().getProduct().getProductTitle());
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                tv_name.setText(pojoPostInfo.getData().getProduct().getProductTitle());
                tv_brand.setText(pojoPostInfo.getData().getBrandName());
                tv_user.setText(pojoPostInfo.getData().getMember().getMemberUsername());
//                tv_price.setText(pojoPostInfo.getData().getProduct().getSellingPrice());
                tv_desc.setText(Html.fromHtml(pojoPostInfo.getData().getProduct().getProductDescription()));

                //Get Image Post untuk Viewpager
                if (pojoPostInfo.getData().getImages().size() > 0) {

                    data_image_vp = new ArrayList<>();
//                    Iterator it = pojoPostInfo.getData().getImages().iterator();
//                    while (it.hasNext()){
//
//                    }
                    for (PojoPostInfo.Image element : pojoPostInfo.getData().getImages()) {
                        data_image_vp.add(element.getNormalImagePath());
                    }

//                    data_image_vp.add("https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/724-1460013150-full.jpg");
//                    data_image_vp.add("https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/2713-1466595679-full.jpg");
                    pagerAdapter = new Image_Product_Adapter(getSupportFragmentManager());
                    vp.setAdapter(pagerAdapter);
                    indicator.setViewPager(vp);
                } else {

                }

                //Get Count Likes
                if (pojoPostInfo.getData().getLikesCount() > 0) {
                    Observable<PojoPostLikes> observable_Likes = adapter.get_post_likes(post_id, access_token);
                    observable_Likes.subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<PojoPostLikes>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(PojoPostLikes pojoPostLikes) {
                            data_likes = new ArrayList<>();
                            for (PojoPostLikes.Like element : pojoPostLikes.getData().getLikes()) {
                                data_likes.add(new Rowdata_Detail_Likes(element.getMember().getMemberId(),
                                        element.getMember().getPictureThumbPath()));

                            }

                            layoutAdapter_Likes = new RVAdapter_Detail_Like(Detail_Product.this, data_likes);
                            layoutManager_Likes = new LinearLayoutManager(Detail_Product.this, LinearLayoutManager.HORIZONTAL, false);
                            layoutAdapter_Likes.notifyDataSetChanged();
                            rv_likes.setAdapter(layoutAdapter_Likes);
                            rv_likes.setLayoutManager(layoutManager_Likes);

                        }
                    });

                } else {

                }

                //GET Related Item
                if (pojoPostInfo.getData().getRelated().size() > 0) {
                    data_relateditem = new ArrayList<>();

                    for(PojoPostInfo.Related element :  pojoPostInfo.getData().getRelated()){
                        data_relateditem.add(new Rowdata_Detail_RelatedItem(element.getPostId(),
                                element.getSmallImagePath()));

                    }

                    layoutAdapter_RelatedItem = new RVAdapter_Detail_RelatedItem(getApplicationContext(), data_relateditem);
                    layoutManager_RelatedItem = new LinearLayoutManager(Detail_Product.this, LinearLayoutManager.HORIZONTAL, false);
                    rv_related_item.setAdapter(layoutAdapter_RelatedItem);
                    rv_related_item.setLayoutManager(layoutManager_RelatedItem);

                } else {


                }

            }
        });

    }

    private void get_Likes() {

    }

    //PENDING
    private void get_Top3Comments() {

    }

    //PENDING
    private void get_SoldByStore() {
//        data_soldbystore = new ArrayList<>();
//        data_soldbystore.add(new Rowdata_Detail_SolybyStore("", "https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/944-1460963003-full.jpg"));
//        data_soldbystore.add(new Rowdata_Detail_SolybyStore("", "https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/724-1460013150-full.jpg"));
//        data_soldbystore.add(new Rowdata_Detail_SolybyStore("", "https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/2713-1466595679-full.jpg"));
//        data_soldbystore.add(new Rowdata_Detail_SolybyStore("", "https://s3-ap-southeast-1.amazonaws.com/kufedcom/post/944-1460963003-full.jpg"));

    }

    private void get_RelatedItems() {


    }

    private void iniView() {
        spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

        post_id = getIntent().getStringExtra(Param_Collection.EXTRA_POST_ID);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

//        layoutAdapter_Likes = new RVAdapter_Detail_Like(Detail_Product.this, data_likes);
//        layoutAdapter_SoldBy = new RVAdapter_Detail_SoldByStore(getApplicationContext(), data_soldbystore);
//        layoutAdapter_RelatedItem = new RVAdapter_Detail_RelatedItem(getApplicationContext(), data_relateditem);
//
//        layoutManager_Likes = new LinearLayoutManager(Detail_Product.this, LinearLayoutManager.HORIZONTAL, false);
//        layoutManager_SoldBy = new LinearLayoutManager(Detail_Product.this, LinearLayoutManager.HORIZONTAL, false);
//        layoutManager_RelatedItem = new LinearLayoutManager(Detail_Product.this, LinearLayoutManager.HORIZONTAL, false);
//
//        rv_likes.setAdapter(layoutAdapter_Likes);
//        rv_likes.setLayoutManager(layoutManager_Likes);
//
//        rv_related_item.setAdapter(layoutAdapter_RelatedItem);
//        rv_related_item.setLayoutManager(layoutManager_RelatedItem);
//
//        rv_soldby_store.setAdapter(layoutAdapter_SoldBy);
//        rv_soldby_store.setLayoutManager(layoutManager_SoldBy);
    }

    private class Image_Product_Adapter extends FragmentStatePagerAdapter {

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
