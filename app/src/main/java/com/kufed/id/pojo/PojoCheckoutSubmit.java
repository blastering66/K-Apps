package com.kufed.id.pojo;

/**
 * Created by macbook on 8/8/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoCheckoutSubmit {
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



    public class Data {

        @SerializedName("redirect")
        @Expose
        private Redirect redirect;
        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("return_payment2go")
        @Expose
        private String returnPayment2go;

        /**
         *
         * @return
         * The redirect
         */
        public Redirect getRedirect() {
            return redirect;
        }

        /**
         *
         * @param redirect
         * The redirect
         */
        public void setRedirect(Redirect redirect) {
            this.redirect = redirect;
        }

        /**
         *
         * @return
         * The orderId
         */
        public String getOrderId() {
            return orderId;
        }

        /**
         *
         * @param orderId
         * The order_id
         */
        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        /**
         *
         * @return
         * The returnPayment2go
         */
        public String getReturnPayment2go() {
            return returnPayment2go;
        }

        /**
         *
         * @param returnPayment2go
         * The return_payment2go
         */
        public void setReturnPayment2go(String returnPayment2go) {
            this.returnPayment2go = returnPayment2go;
        }

    }

    public class Redirect {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("hash")
        @Expose
        private String hash;

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         *
         * @return
         * The hash
         */
        public String getHash() {
            return hash;
        }

        /**
         *
         * @param hash
         * The hash
         */
        public void setHash(String hash) {
            this.hash = hash;
        }

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
}
