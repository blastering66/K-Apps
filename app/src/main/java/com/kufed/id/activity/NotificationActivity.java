package com.kufed.id.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import com.kufed.id.customview.KufedTextView;
import com.kufed.id.fragment.Fragment_Notification_Following;
import com.kufed.id.fragment.Fragment_Notification_You;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by macbook on 7/11/16.
 */
public class NotificationActivity extends AppCompatActivity implements MaterialTabListener {
    Toolbar toolbar;
    @Bind(R.id.tabhost)
    MaterialTabHost tabHost;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setBackground(ContextCompat.getDrawable(MainMenu.this, R.drawable.bg_actionbar_gradient));
        toolbar.setBackgroundColor(ContextCompat.getColor(NotificationActivity.this, android.R.color.black));
        toolbar.setTitle("Notification");
        setSupportActionBar(toolbar);

        LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());
        View view = mInflater.inflate(R.layout.layout_custom_toolbar_title, null);
        toolbar.removeAllViews();
        toolbar.addView(view);

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

                default:
                    return new Fragment_Notification_Following();
            }

        }

        @Override
        public int getCount() {
            return 2;
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
}
