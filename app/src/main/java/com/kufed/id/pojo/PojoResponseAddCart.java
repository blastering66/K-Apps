package com.kufed.id.pojo;

/**
 * Created by macbook on 8/3/16.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoResponseAddCart {

    @SerializedName("time")
    @Expose
    private Double time;
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

    public class Datum {

        @SerializedName("post_id")
        @Expose
        private String postId;
        @SerializedName("variation_id")
        @Expose
        private String variationId;
        @SerializedName("cart_detail_id")
        @Expose
        private String cartDetailId;
        @SerializedName("is_inquiry")
        @Expose
        private Boolean isInquiry;

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
         * The variationId
         */
        public String getVariationId() {
            return variationId;
        }

        /**
         *
         * @param variationId
         * The variation_id
         */
        public void setVariationId(String variationId) {
            this.variationId = variationId;
        }

        /**
         *
         * @return
         * The cartDetailId
         */
        public String getCartDetailId() {
            return cartDetailId;
        }

        /**
         *
         * @param cartDetailId
         * The cart_detail_id
         */
        public void setCartDetailId(String cartDetailId) {
            this.cartDetailId = cartDetailId;
        }

        /**
         *
         * @return
         * The isInquiry
         */
        public Boolean getIsInquiry() {
            return isInquiry;
        }

        /**
         *
         * @param isInquiry
         * The is_inquiry
         */
        public void setIsInquiry(Boolean isInquiry) {
            this.isInquiry = isInquiry;
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
