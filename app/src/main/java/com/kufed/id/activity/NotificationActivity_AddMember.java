package com.kufed.id.activity;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kufed.id.customadapter.RVAdapter_Add_User;
import com.kufed.id.customview.KufedTextViewTitle;
import com.kufed.id.customview.SimpleDividerItemDecoration;
import com.kufed.id.rowdata.RowData_UserToAdd;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.ButterKnife;

/**
 * Created by macbook on 7/21/16.
 */
public class NotificationActivity_AddMember extends AppCompatActivity {
    @Bind(R.id.srv)
    SuperRecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter layoutAdapter;
    RecyclerView.ItemDecoration layoutDecoration;
    SharedPreferences spf;
    List<RowData_UserToAdd> data;
    @Bind(R.id.tv_title_custom)KufedTextViewTitle tv_title_custom;
    @BindDrawable(R.drawable.line_divider)
    Drawable drawableLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_addmember);
        ButterKnife.bind(this);
        tv_title_custom.setText("ACTIVITY");

        String url = getIntent().getStringExtra("url");
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        data = new ArrayList<>();
        data.add(new RowData_UserToAdd(url, username, password, false));

        layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        layoutAdapter = new RVAdapter_Add_User(getApplicationContext(), data);
        layoutDecoration = new SimpleDividerItemDecoration(drawableLine);
        rv.addItemDecoration(layoutDecoration);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(layoutAdapter);
    }
}
