package com.kufed.id.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

import com.kufed.id.pojo.PojoAccessToken;
import com.kufed.id.pojo.PojoCheckoutFee;
import com.kufed.id.pojo.PojoCheckoutGet;
import com.kufed.id.pojo.PojoCheckoutSubmit;
import com.kufed.id.pojo.PojoFriendAdded;
import com.kufed.id.pojo.PojoFriendRequests;
import com.kufed.id.pojo.PojoGETProfile;
import com.kufed.id.pojo.PojoLikedPost;
import com.kufed.id.pojo.PojoLoginFB;
import com.kufed.id.pojo.PojoNotifFollowing;
import com.kufed.id.pojo.PojoNotifYou;
import com.kufed.id.pojo.PojoPostFresh;
import com.kufed.id.pojo.PojoPostInfo;
import com.kufed.id.pojo.PojoPostLikes;
import com.kufed.id.pojo.PojoPostTrending;
import com.kufed.id.pojo.PojoResponseAddCart;
import com.kufed.id.pojo.PojoResponseAddressList;
import com.kufed.id.pojo.PojoResponseCartList;
import com.kufed.id.pojo.PojoResponseCategories;
import com.kufed.id.pojo.PojoResponseRegister;
import com.kufed.id.pojo.PojoResultSearch;
import com.kufed.id.pojo.PojoWishlistPost;

//import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by macbook on 6/1/16.
 */
public interface Rest_Adapter {

//    @FormUrlEncoded
//    @POST("access_token")
//    Observable<PojoAccessToken> access_token(
//            @Field("grant_type") String grant_type,
//            @Field("client_id") String client_id,
//            @Field("client_secret") String client_secret
//    );
//
//    @FormUrlEncoded
//    @POST("access_token")
//    Observable<PojoAccessToken> refresh_access_token(
//            @Field("grant_type") String grant_type,
//            @Field("client_id") String client_id,
//            @Field("client_secret") String client_secret,
//            @Field("refresh_token") String refresh_token
//    );
//
//    @FormUrlEncoded
//    @POST("access_token")
//    Observable<PojoAccessToken> access_token_with_login(
//            @Field("grant_type") String grant_type,
//            @Field("client_id") String client_id,
//            @Field("client_secret") String client_secret,
//            @Field("username") String username,
//            @Field("password") String password
//    );
//
//    @FormUrlEncoded
//    @POST("account/facebook_login")
//    Observable<PojoLoginFB> access_token_with_facebook_login(
//            @Field("access_token") String access_token,
//            @Field("facebook_id") String facebook_id
//    );
//
//    @GET("profile/me/info?")
//    Observable<PojoGETProfile> get_profile(
//            @Query("access_token") String access_token
//    );
//
//    @GET("posts/fresh?")
//    Observable<PojoPostFresh> get_post_fresh(
//            @Query("access_token") String access_token,
//            @Query("start") int start,
//            @Query("limit") int limit
//    );
//
//    @GET("posts/trending?")
//    Observable<PojoPostTrending> get_post_trending(
//            @Query("access_token") String access_token
//    );
//
//    @GET("posts/recommed?")
//    Observable<PojoPostFresh> get_post_recommed(
//            @Query("access_token") String access_token
//    );
//
//    @GET("posts/following?")
//    Observable<PojoPostFresh> get_post_following(
//            @Query("access_token") String access_token
//    );
//
//    @GET("posts/{id}/info?")
//    Observable<PojoPostInfo> get_post_info(
//            @Path("id") String id,
//            @Query("access_token") String access_token
//    );
//
//    @GET("posts/{id}/likes?")
//    Observable<PojoPostLikes> get_post_likes(
//            @Path("id") String id,
//            @Query("access_token") String access_token
//    );
//
//    @GET("/product/category?")
//    Observable<PojoResponseCategories> get_categories(
//            @Query("access_token") String access_token
//    );
//
//    @FormUrlEncoded
//    @POST("account/register")
//    Observable<PojoResponseRegister> register(
//            @Field("access_token") String access_token,
//            @Field("email") String email,
//            @Field("password") String password,
////            @Field("gender") String gender,
//            @Field("complete_name") String complete_name,
//            @Field("birth_date") String birth_date,
//            @Field("username") String username
////            @Field("phone") String phone,
////            @Field("questions") String questions
//    );
//
//    //NOTE
//    //Pojo Blum dibuat
//    @FormUrlEncoded
//    @POST("/posts/{id}/like")
//    Observable<PojoLikedPost> like_post(
//            @Path("id") String id,
//            @Field("access_token") String access_token
//    );
//
//    @FormUrlEncoded
//    @POST("/cart/add")
//    Observable<PojoResponseAddCart> add_to_cart(
//            @Field("data") String data,
//            @Field("access_token") String access_token
//    );
//
//
//
//    //NOTE
//    //Pojo Blum dibuat
//    @FormUrlEncoded
//    @POST("/posts/{id}/add_wishlist")
//    Observable<PojoWishlistPost> wishlist_post(
//            @Path("id") String id,
//            @Field("access_token") String access_token
//    );
//
//    //NOTE
//    //Pojo Blum dibuat
//    @FormUrlEncoded
//    @POST("/profile/{id}/follow")
//    Observable<PojoResponseRegister> follow_profile(
//            @Path("id") String id,
//            @Field("access_token") String access_token
//    );
//
//    //NOTE
//    //Pojo Blum dibuat
//    @FormUrlEncoded
//    @POST("/profile/{id}/follow")
//    Observable<PojoResponseRegister> unfollow_profile(
//            @Path("id") String id,
//            @Field("access_token") String access_token
//    );
//
//    //NOTE
//    //Pojo Blum dibuat
//    @FormUrlEncoded
//    @POST("/member/{id}/approve")
//    Observable<PojoFriendAdded> approve_friend(
//            @Path("id") String id,
//            @Field("access_token") String access_token
//    );
//
//    @GET("/profile/{id}/public_activities")
//    Observable<PojoNotifFollowing> notif_following(
//            @Path("id") int id,
//            @Query("access_token") String access_token
//    );
//    @GET("/notification/get")
//    Observable<PojoNotifYou> notif_you(
//            @Query("access_token") String access_token
//    );
//
//    //NOTE
//    //Pojo Blum dibuat
//    @FormUrlEncoded
//    @POST("/posts/{id}/comments")
//    Observable<PojoResponseRegister> comment_post(
//            @Path("id") String id,
//            @Field("comment") String comment,
//            @Field("access_token") String access_token
//    );
//
//    @FormUrlEncoded
//    @POST("/checkout/submit")
//    Observable<PojoCheckoutSubmit> get_order_id(
//      @Field("access_token") String access_token,
//      @Field("shipping_address_id") String shipping_address_id,
//      @Field("payment_address_id") String payment_address_id,
//      @Field("shipping_provider_method_id") String shipping_provider_method_id,
//      @Field("payment_method_id") String payment_method_id,
//      @Field("payment_bank_id") String payment_bank_id,
//      @Field("cart") String cart,
//      @Field("is_gift") String is_gift,
//      @Field("gift_message") String gift_message
//    );
//
//    @GET("/product/search")
//    Observable<PojoResultSearch> search_product(
//            @Query("q") String query,
//            @Query("access_token") String access_token
//    );
//
//    @GET("/member/{id}/friendreq")
//    Observable<PojoFriendRequests> notif_get_friend_requests(
//            @Path("id") int id,
//            @Query("access_token") String access_token
//    );
//
//    @GET("/cart/list")
//    Observable<PojoResponseCartList> get_cart_list(
//            @Query("access_token") String access_token
//    );
//
//    @GET("/account/address/list")
//    Observable<PojoResponseAddressList> get_address_list(
//            @Query("access_token") String access_token
//    );
//
//    @GET("/checkout/fee")
//    Observable<PojoCheckoutFee> get_checkoutfee(
//            @Query("access_token") String access_token
//    );
//
//    @GET("/checkout/get")
//    Observable<PojoCheckoutGet> get_checkout_allinfo(
//            @Query("access_token") String access_token
//    );


    @FormUrlEncoded
    @POST("/access_token")
    Observable<PojoAccessToken> access_token(
            @Field("grant_type") String grant_type,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret
    );

    @FormUrlEncoded
    @POST("/access_token")
    Observable<PojoAccessToken> refresh_access_token(
            @Field("grant_type") String grant_type,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret,
            @Field("refresh_token") String refresh_token
    );

    @FormUrlEncoded
    @POST("/access_token")
    Observable<PojoAccessToken> access_token_with_login(
            @Field("grant_type") String grant_type,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret,
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/account/facebook_login")
    Observable<PojoLoginFB> access_token_with_facebook_login(
            @Field("access_token") String access_token,
            @Field("facebook_id") String facebook_id
    );

    @GET("/profile/me/info")
    Observable<PojoGETProfile> get_profile(
            @Query("access_token") String access_token
    );

    @GET("/posts/fresh")
    Observable<PojoPostFresh> get_post_fresh(
            @Query("access_token") String access_token,
            @Query("start") int start,
            @Query("limit") int limit
    );

    @GET("/posts/trending")
    Observable<PojoPostTrending> get_post_trending(
            @Query("access_token") String access_token
    );

    @GET("/posts/recommed")
    Observable<PojoPostFresh> get_post_recommed(
            @Query("access_token") String access_token
    );

    @GET("/posts/following")
    Observable<PojoPostFresh> get_post_following(
            @Query("access_token") String access_token
    );

    @GET("/posts/{id}/info")
    Observable<PojoPostInfo> get_post_info(
            @Path("id") String id,
            @Query("access_token") String access_token
    );

    @GET("/posts/{id}/likes")
    Observable<PojoPostLikes> get_post_likes(
            @Path("id") String id,
            @Query("access_token") String access_token
    );

    @GET("/product/category")
    Observable<PojoResponseCategories> get_categories(
            @Query("access_token") String access_token
    );

    @FormUrlEncoded
    @POST("/account/register")
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
    Observable<PojoLikedPost> like_post(
            @Path("id") String id,
            @Field("access_token") String access_token
    );

    @FormUrlEncoded
    @POST("/cart/add")
    Observable<PojoResponseAddCart> add_to_cart(
            @Field("data") String data,
            @Field("access_token") String access_token
    );



    //NOTE
    //Pojo Blum dibuat
    @FormUrlEncoded
    @POST("/posts/{id}/add_wishlist")
    Observable<PojoWishlistPost> wishlist_post(
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
    @POST("/member/{id}/approve")
    Observable<PojoFriendAdded> approve_friend(
            @Path("id") String id,
            @Field("access_token") String access_token
    );

    @GET("/profile/{id}/public_activities")
    Observable<PojoNotifFollowing> notif_following(
            @Path("id") int id,
            @Query("access_token") String access_token
    );
    @GET("/notification/get")
    Observable<PojoNotifYou> notif_you(
            @Query("access_token") String access_token
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

    @FormUrlEncoded
    @POST("/checkout/submit")
    Observable<PojoCheckoutSubmit> get_order_id(
            @Field("access_token") String access_token,
            @Field("shipping_address_id") String shipping_address_id,
            @Field("payment_address_id") String payment_address_id,
            @Field("shipping_provider_method_id") String shipping_provider_method_id,
            @Field("payment_method_id") String payment_method_id,
            @Field("payment_bank_id") String payment_bank_id,
            @Field("cart") String cart,
            @Field("is_gift") String is_gift,
            @Field("gift_message") String gift_message
    );

    @GET("/product/search")
    Observable<PojoResultSearch> search_product(
            @Query("q") String query,
            @Query("access_token") String access_token
    );

    @GET("/member/{id}/friendreq")
    Observable<PojoFriendRequests> notif_get_friend_requests(
            @Path("id") int id,
            @Query("access_token") String access_token
    );

    @GET("/cart/list")
    Observable<PojoResponseCartList> get_cart_list(
            @Query("access_token") String access_token
    );

    @GET("/account/address/list")
    Observable<PojoResponseAddressList> get_address_list(
            @Query("access_token") String access_token
    );

    @GET("/checkout/fee")
    Observable<PojoCheckoutFee> get_checkoutfee(
            @Query("access_token") String access_token
    );

    @GET("/checkout/get")
    Observable<PojoCheckoutGet> get_checkout_allinfo(
            @Query("access_token") String access_token
    );
}
