package com.kufed.id.rowdata;

/**
 * Created by macbook on 6/28/16.
 */
public class Rowdata_Detail_Likes {
    private String id_user;
    private String url_photo;

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    private String name_user;

    public Rowdata_Detail_Likes(String id_user, String url_photo) {
        this.id_user = id_user;
        this.url_photo = url_photo;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }
}
