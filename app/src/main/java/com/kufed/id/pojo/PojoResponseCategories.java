package com.kufed.id.pojo;

/**
 * Created by macbook on 6/18/16.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoResponseCategories {
    @SerializedName("time")
    @Expose
    private Double time;
    @SerializedName("environment")
    @Expose
    private String environment;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * @return The time
     */
    public Double getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(Double time) {
        this.time = time;
    }

    /**
     * @return The environment
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * @param environment The environment
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * @return The status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return The data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(Data data) {
        this.data = data;
    }

    public class Status {

        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("description")
        @Expose
        private String description;

        /**
         * @return The code
         */
        public Integer getCode() {
            return code;
        }

        /**
         * @param code The code
         */
        public void setCode(Integer code) {
            this.code = code;
        }

        /**
         * @return The description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description The description
         */
        public void setDescription(String description) {
            this.description = description;
        }
    }

    public class Data {

        @SerializedName("last_modified")
        @Expose
        private String lastModified;
        @SerializedName("categories")
        @Expose
        private List<Category> categories = new ArrayList<Category>();

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

        /**
         *
         * @return
         * The categories
         */
        public List<Category> getCategories() {
            return categories;
        }

        /**
         *
         * @param categories
         * The categories
         */
        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

    }

    public class Category {

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
}
