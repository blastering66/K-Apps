package com.kufed.id.pojo;

/**
 * Created by macbook on 7/19/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoWishlistPost {

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
    public Data getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
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

    public class Data {

        @SerializedName("wishlist_id")
        @Expose
        private String wishlistId;
        @SerializedName("count")
        @Expose
        private String count;

        /**
         *
         * @return
         * The wishlistId
         */
        public String getWishlistId() {
            return wishlistId;
        }

        /**
         *
         * @param wishlistId
         * The wishlist_id
         */
        public void setWishlistId(String wishlistId) {
            this.wishlistId = wishlistId;
        }

        /**
         *
         * @return
         * The count
         */
        public String getCount() {
            return count;
        }

        /**
         *
         * @param count
         * The count
         */
        public void setCount(String count) {
            this.count = count;
        }

    }
}
