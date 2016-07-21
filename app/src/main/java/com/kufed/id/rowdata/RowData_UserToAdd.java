package com.kufed.id.rowdata;

/**
 * Created by macbook on 7/21/16.
 */
public class RowData_UserToAdd {
    private String url, username, fullname;
    private boolean isApproved;

    public RowData_UserToAdd(String url, String username, String fullname, boolean isApproved) {
        this.url = url;
        this.username = username;
        this.fullname = fullname;
        this.isApproved = isApproved;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
}
