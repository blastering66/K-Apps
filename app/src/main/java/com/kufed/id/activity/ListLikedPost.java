package com.kufed.id.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kufed.id.customadapter.RVAdapter_Detail_Like;
import com.kufed.id.pojo.PojoPostLikes;
import com.kufed.id.rest.Rest_Adapter;
import com.kufed.id.rowdata.Rowdata_Detail_Likes;
import com.kufed.id.util.Param_Collection;
import com.kufed.id.util.Public_Functions;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macbook on 7/14/16.
 */
public class ListLikedPost extends AppCompatActivity {
    List<Rowdata_Detail_Likes> data_likes;
    @Bind(R.id.rv)
    RecyclerView rv_likes;
    RecyclerView.Adapter layoutAdapter_Likes;
    RecyclerView.LayoutManager layoutManager_Likes;
    String post_id, access_token;
    SharedPreferences spf ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rv_bg_white);

        spf = getSharedPreferences(Param_Collection.ACCESS_TOKEN, MODE_PRIVATE);
        access_token = spf.getString(Param_Collection.ACCESS_TOKEN, "");
        post_id = getIntent().getStringExtra(Param_Collection.EXTRA_POST_ID);

        Rest_Adapter adapter = Public_Functions.initRetrofit();
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
                if(pojoPostLikes.getData().getLikes().size() > 0){
                    data_likes = new ArrayList<>();
                    for (PojoPostLikes.Like element : pojoPostLikes.getData().getLikes()) {
                        data_likes.add(new Rowdata_Detail_Likes(element.getMember().getMemberId(),
                                element.getMember().getPictureThumbPath()));

                    }

                    layoutAdapter_Likes = new RVAdapter_Detail_Like(ListLikedPost.this, data_likes);
                    layoutManager_Likes = new LinearLayoutManager(ListLikedPost.this, LinearLayoutManager.HORIZONTAL, false);
                    layoutAdapter_Likes.notifyDataSetChanged();
                    rv_likes.setAdapter(layoutAdapter_Likes);
                    rv_likes.setLayoutManager(layoutManager_Likes);
                }


            }
        });


    }

}
