package com.kufed.id.rowdata;

/**
 * Created by macbook on 6/28/16.
 */
public class Rowdata_Detail_RelatedItem {
    private String id_userpost,url_photo;

    public Rowdata_Detail_RelatedItem(String id_user, String url_photo) {
        this.id_userpost = id_user;
        this.url_photo = url_photo;
    }

    public String getId_userpost() {
        return id_userpost;
    }

    public void setId_userpost(String id_userpost) {
        this.id_userpost = id_userpost;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }
}
