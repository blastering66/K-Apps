package com.kufed.id.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

import com.kufed.id.pojo.PojoAccessToken;
import com.kufed.id.pojo.PojoGETProfile;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.pojo.PojoPostInfo;
import com.kufed.id.pojo.PojoPostLikes;
import com.kufed.id.pojo.PojoResponseCategories;
import com.kufed.id.pojo.PojoResponseRegister;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by macbook on 6/1/16.
 */
public interface Rest_Adapter {


    @FormUrlEncoded
    @POST("access_token")
    Observable<PojoAccessToken> access_token(
            @Field("grant_type") String grant_type,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret
    );

    @FormUrlEncoded
    @POST("access_token")
    Observable<PojoAccessToken> refresh_access_token(
            @Field("grant_type") String grant_type,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret,
            @Field("refresh_token") String refresh_token
    );

    @FormUrlEncoded
    @POST("access_token")
    Observable<PojoAccessToken> access_token_with_login(
            @Field("grant_type") String grant_type,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret,
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("profile/me/info?")
    Observable<PojoGETProfile> get_profile(
            @Query("access_token") String access_token
    );

    @GET("posts/fresh?")
    Observable<PojoPostFresh> get_post_fresh(
            @Query("access_token") String access_token
    );

    @GET("posts/{id}/info?")
    Observable<PojoPostInfo> get_post_info(
            @Path("id") String id,
            @Query("access_token") String access_token
    );

    @GET("posts/{id}/likes?")
    Observable<PojoPostLikes> get_post_likes(
            @Path("id") String id,
            @Query("access_token") String access_token
    );

    @GET("/product/category?")
    Observable<PojoResponseCategories> get_categories(
            @Query("access_token") String access_token
    );

    @FormUrlEncoded
    @POST("account/register")
    Observable<PojoResponseRegister> register(
            @Field("access_token") String access_token,
            @Field("email") String email,
            @Field("password") String password,
//            @Field("gender") String gender,
            @Field("complete_name") String complete_name,
            @Field("birth_date") String birth_date,
            @Field("username") String username
//            @Field("phone") String phone,
//            @Field("questions") String questions
    );

    //NOTE
    //Pojo Blum dibuat
    @FormUrlEncoded
    @POST("/posts/{id}/like")
    Observable<PojoResponseRegister> like_post(
            @Path("id") String id,
            @Field("access_token") String access_token
    );

    //NOTE
    //Pojo Blum dibuat
    @FormUrlEncoded
    @POST("/profile/{id}/follow")
    Observable<PojoResponseRegister> follow_profile(
            @Path("id") String id,
            @Field("access_token") String access_token
    );

    //NOTE
    //Pojo Blum dibuat
    @FormUrlEncoded
    @POST("/profile/{id}/follow")
    Observable<PojoResponseRegister> unfollow_profile(
            @Path("id") String id,
            @Field("access_token") String access_token
    );

    //NOTE
    //Pojo Blum dibuat
    @FormUrlEncoded
    @POST("/posts/{id}/comments")
    Observable<PojoResponseRegister> comment_post(
            @Path("id") String id,
            @Field("comment") String comment,
            @Field("access_token") String access_token
    );
}
