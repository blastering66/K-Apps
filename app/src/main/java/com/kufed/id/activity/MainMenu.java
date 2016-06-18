package com.kufed.id.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kufed.id.customadapter.RVAdapter_Slider;
import com.kufed.id.fragment.Fragment_Shop_Categories;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RVAdapter_Slider.onSliderItemSelectedListener {
    @Bind(R.id.rv_content_slider)RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter layoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setBackground(ContextCompat.getDrawable(MainMenu.this, R.drawable.bg_actionbar_gradient));
        toolbar.setBackgroundColor(Color.BLACK);
        toolbar.setTitle("Kufed");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        layoutAdapter = new RVAdapter_Slider(MainMenu.this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(layoutAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onChangeFragmentContentPosition(int position) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        FragmentManager fm = getSupportFragmentManager();

        switch (position){
            case 0:
                break;
            case 1:
//                Fragment fragment_cam = new Fragment_Camera();
//                fm.beginTransaction().replace(R.id.frame_container,fragment_cam).commit();
                startActivity(new Intent(getApplicationContext(), CameraCapture.class));
                drawer.closeDrawer(GravityCompat.START);
                break;
            case 2:
                Fragment fragment_shop = new Fragment_Shop_Categories();
                fm.beginTransaction().replace(R.id.frame_container,fragment_shop).commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
    }
}
