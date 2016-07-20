package com.kufed.id.pojo;

/**
 * Created by macbook on 7/19/16.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoResultSearch {

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
    private List<Datum> data = new ArrayList<Datum>();

    /**
     *
     * @return
     * The time
     */
    public Double getTime() {
        return time;
    }

    /**
     *
     * @param time
     * The time
     */
    public void setTime(Double time) {
        this.time = time;
    }

    /**
     *
     * @return
     * The environment
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     *
     * @param environment
     * The environment
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     *
     * @return
     * The status
     */
    public Status getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Datum> data) {
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
         *
         * @return
         * The code
         */
        public Integer getCode() {
            return code;
        }

        /**
         *
         * @param code
         * The code
         */
        public void setCode(Integer code) {
            this.code = code;
        }

        /**
         *
         * @return
         * The description
         */
        public String getDescription() {
            return description;
        }

        /**
         *
         * @param description
         * The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

    }

    public class Datum {

        @SerializedName("post_id")
        @Expose
        private String postId;
        @SerializedName("product_id")
        @Expose
        private String productId;
        @SerializedName("product_title")
        @Expose
        private String productTitle;
        @SerializedName("product_url")
        @Expose
        private String productUrl;
        @SerializedName("brand_id")
        @Expose
        private String brandId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("normal_image_path")
        @Expose
        private String normalImagePath;
        @SerializedName("thumb_image_path")
        @Expose
        private String thumbImagePath;
        @SerializedName("post_thumb_image")
        @Expose
        private String postThumbImage;
        @SerializedName("post_normal_image")
        @Expose
        private String postNormalImage;

        /**
         *
         * @return
         * The postId
         */
        public String getPostId() {
            return postId;
        }

        /**
         *
         * @param postId
         * The post_id
         */
        public void setPostId(String postId) {
            this.postId = postId;
        }

        /**
         *
         * @return
         * The productId
         */
        public String getProductId() {
            return productId;
        }

        /**
         *
         * @param productId
         * The product_id
         */
        public void setProductId(String productId) {
            this.productId = productId;
        }

        /**
         *
         * @return
         * The productTitle
         */
        public String getProductTitle() {
            return productTitle;
        }

        /**
         *
         * @param productTitle
         * The product_title
         */
        public void setProductTitle(String productTitle) {
            this.productTitle = productTitle;
        }

        /**
         *
         * @return
         * The productUrl
         */
        public String getProductUrl() {
            return productUrl;
        }

        /**
         *
         * @param productUrl
         * The product_url
         */
        public void setProductUrl(String productUrl) {
            this.productUrl = productUrl;
        }

        /**
         *
         * @return
         * The brandId
         */
        public String getBrandId() {
            return brandId;
        }

        /**
         *
         * @param brandId
         * The brand_id
         */
        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        /**
         *
         * @return
         * The categoryId
         */
        public String getCategoryId() {
            return categoryId;
        }

        /**
         *
         * @param categoryId
         * The category_id
         */
        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        /**
         *
         * @return
         * The normalImagePath
         */
        public String getNormalImagePath() {
            return normalImagePath;
        }

        /**
         *
         * @param normalImagePath
         * The normal_image_path
         */
        public void setNormalImagePath(String normalImagePath) {
            this.normalImagePath = normalImagePath;
        }

        /**
         *
         * @return
         * The thumbImagePath
         */
        public String getThumbImagePath() {
            return thumbImagePath;
        }

        /**
         *
         * @param thumbImagePath
         * The thumb_image_path
         */
        public void setThumbImagePath(String thumbImagePath) {
            this.thumbImagePath = thumbImagePath;
        }

        /**
         *
         * @return
         * The postThumbImage
         */
        public String getPostThumbImage() {
            return postThumbImage;
        }

        /**
         *
         * @param postThumbImage
         * The post_thumb_image
         */
        public void setPostThumbImage(String postThumbImage) {
            this.postThumbImage = postThumbImage;
        }

        /**
         *
         * @return
         * The postNormalImage
         */
        public String getPostNormalImage() {
            return postNormalImage;
        }

        /**
         *
         * @param postNormalImage
         * The post_normal_image
         */
        public void setPostNormalImage(String postNormalImage) {
            this.postNormalImage = postNormalImage;
        }

    }
}
