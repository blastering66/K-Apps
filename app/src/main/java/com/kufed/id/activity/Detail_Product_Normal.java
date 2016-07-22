package com.kufed.id.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.kufed.id.customadapter.RVAdapter_Detail_Like;
import com.kufed.id.customadapter.RVAdapter_Detail_RelatedItem;
import com.kufed.id.customview.KufedLikeImageView;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.customview.KufedTextViewProductTitle;
import com.kufed.id.fragment.Fragment_VP_Image;
import com.kufed.id.pojo.PojoLikedPost;
import com.kufed.id.pojo.PojoPostInfo;
import com.kufed.id.pojo.PojoPostLikes;
import com.kufed.id.pojo.PojoWishlistPost;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.rowdata.Rowdata_Detail_Likes;
import com.kufed.id.rowdata.Rowdata_Detail_RelatedItem;
import com.kufed.id.rowdata.Rowdata_Detail_SolybyStore;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;
import com.pixelcan.inkpageindicator.InkPageIndicator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 6/22/16.
 */
public class Detail_Product_Normal extends AppCompatActivity implements NestedScrollView.OnScrollChangeListener{
    Rest_Adapter adapter;
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
    String access_token, post_id, post_url, post_title;

    @Bind(R.id.tv_name)KufedTextViewProductTitle tv_name;
    @Bind(R.id.tv_brand)KufedTextView tv_brand;
    @Bind(R.id.tv_user)KufedTextView tv_user;
    @Bind(R.id.tv_selling_price)KufedTextView tv_selling_price;
    @Bind(R.id.tv_desc)KufedTextView tv_desc;
    @Bind(R.id.img_like)KufedLikeImageView img_like;
    @Bind(R.id.img_wishlist)ImageView img_wishlist;

    @OnClick(R.id.img_share) public void sharePost(){
        if(post_title != null && post_url != null){
            click_share(post_title, post_url);
        }

    }

    @OnClick(R.id.img_like)public void likePost(){
        click_like(post_id, img_like);
    }

    @OnClick(R.id.img_wishlist) public void addWishlist(){
        click_wishlist(post_id, img_wishlist);

    }

    @Bind(R.id.btn_readmore)Button btn_readmore;
    @OnClick(R.id.btn_readmore)public void clickReadMore(){
        if(tv_desc.getMaxLines() == 100){
            btn_readmore.setText("Read More");
            tv_desc.setMaxLines(3);
        }else{
            btn_readmore.setText("Read Less");
            tv_desc.setMaxLines(100);
        }

    }

    Toolbar toolbar;
    KufedTextView tv_title;
    @Bind(R.id.wrapper_likes)View wrapper_likes;
    @Bind(R.id.line_likes)View line_likes;
    @Bind(R.id.nestedscrollview)NestedScrollView nestedscrollview;
    @Bind(R.id.collapsingtoolbar)CollapsingToolbarLayout collapsingtoolbar;
    @Bind(R.id.appbar)AppBarLayout appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else{
            View decodView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decodView.setSystemUiVisibility(uiOptions);
        }
        setContentView(R.layout.activity_detail_product_normal);
        ButterKnife.bind(this);

        nestedscrollview.setOnScrollChangeListener(this);

        final String title_ = getIntent().getStringExtra(Param_Collection.EXTRA_POST_PRODUCT_TITLE);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            private boolean isShow = false;
            int scrollRangge = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRangge == -1) {
                    scrollRangge = appbar.getTotalScrollRange();
                }
                if (scrollRangge + verticalOffset == 0) {
                    collapsingtoolbar.setTitle(title_);
                    tv_name.setVisibility(View.INVISIBLE);
                    tv_name.setAlpha(1.0f);
                    tv_name.animate().setDuration(500)
                            .alpha(0.0f);
                    isShow = true;
                } else if (isShow) {
                    collapsingtoolbar.setTitle("");
                    tv_name.setVisibility(View.VISIBLE);
                    tv_name.setAlpha(0.0f);
                    tv_name.animate().setDuration(500)
                            .alpha(1.0f);
                    isShow = false;
                }

            }
        });

//        setContentView(R.layout.activity_main_menu);
//        get_Likes();
//        get_SoldByStore();
//        get_RelatedItems();
//        get_Top3Comments();

        //Statis
        iniView();
//        getPostInfo("910");
        getPostInfo(post_id);

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
        adapter = Public_Functions.initRetrofit();

        Observable<PojoPostInfo> observable = adapter.get_post_info(post_id, access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<PojoPostInfo>() {

            String title_product_name;

            @Override
            public void onCompleted() {
//                LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());
//                View view = mInflater.inflate(R.layout.layout_custom_toolbar_title_detail, null);
//                tv_title = (KufedTextView)view.findViewById(R.id.tv_title_custom);
//                tv_title.setText(title_product_name);
//                toolbar.removeAllViews();;
//                toolbar.addView(view);
                Log.e("", "");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("", "");
                Toast.makeText(getApplicationContext(), "Get Info Error", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNext(PojoPostInfo pojoPostInfo) {

//                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//                toolbar.setTitle(pojoPostInfo.getData().getProduct().getProductTitle());
//                setSupportActionBar(toolbar);

                title_product_name = pojoPostInfo.getData().getProduct().getProductTitle();

                tv_name.setText(pojoPostInfo.getData().getProduct().getProductTitle());
                tv_brand.setText(pojoPostInfo.getData().getBrandName());
                tv_user.setText(pojoPostInfo.getData().getMember().getMemberUsername());

                NumberFormat numberFormat = NumberFormat.getNumberInstance();
                String selling_price = numberFormat.format(pojoPostInfo.getData().getProduct().getSellingPrice());

                tv_selling_price.setText("IDR " + selling_price);
                tv_desc.setText(Html.fromHtml(pojoPostInfo.getData().getProduct().getProductDescription()));


                post_title = pojoPostInfo.getData().getPostTitle();
                post_url = pojoPostInfo.getData().getPostUrl();

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

                            layoutAdapter_Likes = new RVAdapter_Detail_Like(Detail_Product_Normal.this, data_likes);
                            layoutManager_Likes = new LinearLayoutManager(Detail_Product_Normal.this, LinearLayoutManager.HORIZONTAL, false);
                            layoutAdapter_Likes.notifyDataSetChanged();
                            rv_likes.setAdapter(layoutAdapter_Likes);
                            rv_likes.setLayoutManager(layoutManager_Likes);

                        }
                    });

                } else {
                    wrapper_likes.setVisibility(View.GONE);
                    line_likes.setVisibility(View.GONE);

                }

                //GET Related Item
                if (pojoPostInfo.getData().getRelated().size() > 0) {
                    data_relateditem = new ArrayList<>();

                    for (PojoPostInfo.Related element : pojoPostInfo.getData().getRelated()) {
                        data_relateditem.add(new Rowdata_Detail_RelatedItem(element.getPostId(),
                                element.getSmallImagePath()));

                    }

                    layoutAdapter_RelatedItem = new RVAdapter_Detail_RelatedItem(getApplicationContext(), data_relateditem);
                    layoutManager_RelatedItem = new LinearLayoutManager(Detail_Product_Normal.this, LinearLayoutManager.HORIZONTAL, false);
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

    private void initActionBarCustom(){
        LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());
        View view = mInflater.inflate(R.layout.layout_custom_toolbar_title_detail, null);
        tv_title = (KufedTextView)view.findViewById(R.id.tv_title_custom);
//        tv_title.setText("FEATURED");
        toolbar.removeAllViews();;
        toolbar.addView(view);

    }

    private void iniView() {
        spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");

        post_id = getIntent().getStringExtra(Param_Collection.EXTRA_POST_ID);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setPadding(0,toolbar.getHeight(), 0,0);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void click_wishlist(String id, final ImageView img){
        Observable<PojoWishlistPost> observable = adapter.wishlist_post(id, access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoWishlistPost>() {
                    private boolean isSukses=false;
                    @Override
                    public void onCompleted() {
                        Log.e("", "");
                        if(isSukses) {
                            img.setImageResource(R.drawable.img_like_icon_after);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "");
                        img.setImageResource(R.drawable.img_like_icon_after);
                    }

                    @Override
                    public void onNext(PojoWishlistPost pojoWishlistPost) {
                        Log.e("", "");
                        if(pojoWishlistPost.getStatus().getCode() == 200){
                            isSukses = true;
                        }

                    }
                });

    }



    private void click_like(String id, final ImageView img){
        Observable<PojoLikedPost> observable = adapter.like_post(id, access_token);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoLikedPost>() {
                    private boolean isSukses=false;
                    @Override
                    public void onCompleted() {
                        Log.e("", "");
                        if(isSukses) {
                            img.setImageResource(R.drawable.img_like_icon_after);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "");
                        img.setImageResource(R.drawable.img_like_icon_after);
                    }

                    @Override
                    public void onNext(PojoLikedPost pojoLikedPost) {
                        Log.e("", "");
                        if(pojoLikedPost.getStatus().getCode() == 200){
                            isSukses = true;
                        }

                    }
                });

    }

    private void click_share(String title, String post_url){
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, title);
        share.putExtra(Intent.EXTRA_TEXT, post_url);

        startActivity(Intent.createChooser(share, "Share link!"));

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

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

        Log.e("Scrolview scrolled", String.valueOf(scrollY));

        if(scrollY > 63){

        }

    }
}
