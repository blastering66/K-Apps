package com.kufed.id.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.kufed.id.customview.KufedTextViewTitle;
import com.kufed.id.fragment.Fragment_Checkout_Payment;
import com.kufed.id.fragment.Fragment_Checkout_Review;
import com.kufed.id.fragment.Fragment_Checkout_Shipping;

import butterknife.Bind;
import butterknife.ButterKnife;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by macbook on 8/3/16.
 */
public class Checkout_OnePage extends AppCompatActivity implements MaterialTabListener {
    @Bind(R.id.tabhost)
    MaterialTabHost tabHost;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    ViewPagerAdapter adapter;
//    @OnClick(R.id.img_back) public void click_back(){
//        finish();
//    }
//    @Bind(R.id.tv_title_custom)KufedTextViewTitle tv_title_custom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        ButterKnife.bind(this);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setBackground(ContextCompat.getDrawable(MainMenu.this, R.drawable.bg_actionbar_gradient));
//        toolbar.setBackgroundColor(ContextCompat.getColor(MainMenu.this, android.R.color.black));
        setSupportActionBar(toolbar);

        LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());
        View view = mInflater.inflate(R.layout.layout_custom_toolbar_title, null);

        KufedTextViewTitle tv_title = (KufedTextViewTitle)view.findViewById(R.id.tv_title_custom);
        tv_title.setText("CHECKOUT");
        toolbar.removeAllViews();
        toolbar.setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.addView(view);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
//                tabHost.setSelectedNavigationItem(position);
            }
        });

        tabHost.addTab(tabHost.newTab().setText("SHIPPING").setTabListener(this));
        tabHost.addTab(tabHost.newTab().setText("PAYMENT").setTabListener(this));
        tabHost.addTab(tabHost.newTab().setText("REVIEW").setTabListener(this));


    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
        viewpager.setAdapter(adapter);
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabSelected(MaterialTab tab) {
        viewpager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        public Fragment getItem(int num) {
            switch (num) {
                case 0:
                    return new Fragment_Checkout_Shipping();
                case 1:
                    return new Fragment_Checkout_Payment();
                case 2:
                    return new Fragment_Checkout_Review();

                default:
                    return new Fragment_Checkout_Shipping();
            }

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SHIPPING";
                case 1:
                    return "PAYMENT";
                case 2:
                    return "REVIEW";
                default:
                    return "";

            }

        }
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
}
