package com.kufed.id.rowdata;

/**
 * Created by macbook on 6/18/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rowdata_Category {
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_url")
    @Expose
    private String categoryUrl;
    @SerializedName("category_thumb_path")
    @Expose
    private String categoryThumbPath;
    @SerializedName("last_modified")
    @Expose
    private String lastModified;

    /**
     *
     * @return
     * The categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     * The category_id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     * The categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     *
     * @param categoryName
     * The category_name
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     *
     * @return
     * The categoryUrl
     */
    public String getCategoryUrl() {
        return categoryUrl;
    }

    /**
     *
     * @param categoryUrl
     * The category_url
     */
    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    /**
     *
     * @return
     * The categoryThumbPath
     */
    public String getCategoryThumbPath() {
        return categoryThumbPath;
    }

    /**
     *
     * @param categoryThumbPath
     * The category_thumb_path
     */
    public void setCategoryThumbPath(String categoryThumbPath) {
        this.categoryThumbPath = categoryThumbPath;
    }

    /**
     *
     * @return
     * The lastModified
     */
    public String getLastModified() {
        return lastModified;
    }

    /**
     *
     * @param lastModified
     * The last_modified
     */
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
}
