package com.kufed.id.util;

/**
 * Created by macbook on 6/1/16.
 */
public class Param_Collection {
    public static String SPF_NAME=  "kufed_android";
    public static String SPF_LOGGED=  "kufed_android_logged";
    public static String SPF_USER_FULLNAME =  "kufed_android_fullname";
    public static String SPF_USER_IMG_PROFILE =  "kufed_android_img_profile";
    public static String SPF_USER_ID =  "kufed_android_id";
    public static String SPF_USERNAME =  "kufed_android_username";
    public static String SPF_USER_PASSWORD =  "kufed_android_password";

    public static String SPF_SELECTED_SLIDER_MENU=  "slider_selected";
    public static String SPF_SELECTED_CATEGORY_MENU=  "category_selected";

    public static String SPF_TOKEN=  "kufed_android_token";

    public static int REQ_CODE_FROM_LOGIN =10;
    public static int REQ_CODE_FROM_REGISTER =11;
    public static int REQ_CODE_FROM_REGISTER_FORGOT =12;

    public static String EXTRA_POST_ID=  "post_id";
    public static String EXTRA_POST_PRODUCT_TITLE=  "product_title";
    public static String URL_FOLDER_IMG = "/Kufed/temp/";

    //Internal
//    public static String BASE_URL=  "http://192.168.4.168:7070/";
//    public static String BASE_URL=  "http://capricorn.kliktoday.com/";
//    public static String BASE_URL=  "http://gemini.kliktoday.com/";
    public static String BASE_URL=  "http://kufed-load-balancer-api-2-351688991.ap-southeast-1.elb.amazonaws.com/";

    public static String ACCESS_TOKEN=  "kufed_token";
    public static String ACCESS_TOKEN_REFRESH=  "kufed_token_refresh";

    public static String GRANT_TYPE_TOKENONLY =  "client_credentials";
    public static String GRANT_TYPE_TOKEN_REFRESH =  "refresh_token";
    public static String GRANT_TYPE_WITH_PASSWORD =  "password";
//    public static String CLIENT_ID =  "ios";
    public static String CLIENT_ID =  "android";
//    public static String CLIENT_SECRET =  "$2a$11$DR2/MXBMrU/Z23bRxqU29Q==";
    public static String CLIENT_SECRET =  "$2a$11$eVXCqoxgZDu7aR3XhdtN6g==";
}
