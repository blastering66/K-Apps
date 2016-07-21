package com.kufed.id.pojo;

/**
 * Created by macbook on 7/21/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoUnfriended {
    @SerializedName("time")
    @Expose
    private Double time;
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



    public class Count {

        @SerializedName("total_friends")
        @Expose
        private Integer totalFriends;

        /**
         *
         * @return
         * The totalFriends
         */
        public Integer getTotalFriends() {
            return totalFriends;
        }

        /**
         *
         * @param totalFriends
         * The total_friends
         */
        public void setTotalFriends(Integer totalFriends) {
            this.totalFriends = totalFriends;
        }

    }

    public class Data {

        @SerializedName("profile_member_id")
        @Expose
        private String profileMemberId;
        @SerializedName("count")
        @Expose
        private Count count;

        /**
         *
         * @return
         * The profileMemberId
         */
        public String getProfileMemberId() {
            return profileMemberId;
        }

        /**
         *
         * @param profileMemberId
         * The profile_member_id
         */
        public void setProfileMemberId(String profileMemberId) {
            this.profileMemberId = profileMemberId;
        }

        /**
         *
         * @return
         * The count
         */
        public Count getCount() {
            return count;
        }

        /**
         *
         * @param count
         * The count
         */
        public void setCount(Count count) {
            this.count = count;
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
