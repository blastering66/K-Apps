package com.kufed.id.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.kufed.id.fragment.Fragment_VP_Image;
import com.pixelcan.inkpageindicator.InkPageIndicator;

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
    PagerAdapter pagerAdapter;

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


    private void iniView(){
        pagerAdapter = new Image_Product_Adapter(getSupportFragmentManager());
        vp.setAdapter(pagerAdapter);
        indicator.setViewPager(vp);
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
