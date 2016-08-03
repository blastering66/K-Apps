package com.kufed.id.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.kufed.id.customview.KufedTextViewTitle;
import com.kufed.id.fragment.Fragment_Notification_Following;
import com.kufed.id.fragment.Fragment_Notification_You;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by macbook on 8/3/16.
 */
public class Checkout extends AppCompatActivity implements MaterialTabListener {
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

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabHost.setSelectedNavigationItem(position);
            }
        });

        tabHost.addTab(tabHost.newTab().setText("FOLLOWING").setTabListener(this));
        tabHost.addTab(tabHost.newTab().setText("YOU").setTabListener(this));


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
                    return new Fragment_Notification_Following();
                case 1:
                    return new Fragment_Notification_You();
                case 2:
                    return new Fragment_Notification_Following();

                default:
                    return new Fragment_Notification_Following();
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
                    return "FOLLOWING";
                case 1:
                    return "YOU";
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
