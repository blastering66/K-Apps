package com.kufed.id.activity;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.kufed.id.customadapter.RVAdapter_Slider;
import com.kufed.id.customview.KufedDialogCategoryHome;
import com.kufed.id.customview.KufedDialogCategoryHome_Test;
import com.kufed.id.customview.KufedTextView;
import com.kufed.id.fragment.Fragment_Home;
import com.kufed.id.fragment.Fragment_Shop_Categories;
import com.kufed.id.util.Param_Collection;
import com.pkmmte.view.CircularImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RVAdapter_Slider.onSliderItemSelectedListener,
        SearchView.OnQueryTextListener{
    @Bind(R.id.rv_content_slider)RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter layoutAdapter;
    Toolbar toolbar;
    KufedTextView tv_title;
    SearchView searchView;
    SharedPreferences spf;
    @Bind(R.id.img_profile_user)CircularImageView img_profile_user;
    @Bind(R.id.tv_fullname_user)KufedTextView tv_fullname_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ButterKnife.bind(this);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setBackground(ContextCompat.getDrawable(MainMenu.this, R.drawable.bg_actionbar_gradient));
//        toolbar.setBackgroundColor(ContextCompat.getColor(MainMenu.this, android.R.color.black));
        setSupportActionBar(toolbar);

        LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());
        View view = mInflater.inflate(R.layout.layout_custom_toolbar, null);
        tv_title = (KufedTextView)view.findViewById(R.id.tv_title_custom);
        tv_title.setText("FEATURED");

        tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), KufedDialogCategoryHome.class));
                KufedDialogCategoryHome_Test dialog = new KufedDialogCategoryHome_Test(MainMenu.this);
                dialog.show();
            }
        });
        toolbar.removeAllViews();
        toolbar.addView(view);

        spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);

        Target<Bitmap> target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                img_profile_user.setImageBitmap(resource);
            }
        };

        Glide.with(getApplicationContext()).load(spf.getString(Param_Collection.SPF_USER_IMG_PROFILE, "")).asBitmap().into(target);
        tv_fullname_user.setText(spf.getString(Param_Collection.SPF_USER_FULLNAME, "User Name"));

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

        if(savedInstanceState == null){
            Fragment fragment_fresh = new Fragment_Home();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment_fresh).commit();
        }
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
//        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager)MainMenu.this.getSystemService(Context.SEARCH_SERVICE);
        if(searchItem != null){
            searchView = (SearchView)searchItem.getActionView();
        }

        if(searchView != null){
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainMenu.this.getComponentName()));

        }

        searchView.setOnQueryTextListener(this);

//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        searchView.setOnQueryTextListener(this);
//
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(
//                new ComponentName(this, MainMenu.class)));
//        searchView.setIconifiedByDefault(false);

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
                Fragment fragment_fresh = new Fragment_Home();
                fm.beginTransaction().replace(R.id.frame_container,fragment_fresh).commit();
                drawer.closeDrawer(GravityCompat.START);
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
            case 7:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainMenu.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure want to Logout ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences spf = getSharedPreferences(Param_Collection.SPF_NAME, MODE_PRIVATE);
                        spf.edit().clear().commit();
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

                break;
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (!searchView.isIconified()) {
            searchView.setIconified(false);
        }

        Intent intent_search = new Intent(getApplicationContext(), SearchResultsActivity.class);
        intent_search.putExtra("FetchType", "ItemSearch");
        intent_search.putExtra("CatId", query);
        startActivity(intent_search);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
