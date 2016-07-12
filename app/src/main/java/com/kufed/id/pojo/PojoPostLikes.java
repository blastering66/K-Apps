package com.kufed.id.pojo;

/**
 * Created by macbook on 7/12/16.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoPostLikes {

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

    public class Member {

        @SerializedName("member_id")
        @Expose
        private String memberId;
        @SerializedName("member_username")
        @Expose
        private String memberUsername;
        @SerializedName("member_email")
        @Expose
        private String memberEmail;
        @SerializedName("member_complete_name")
        @Expose
        private String memberCompleteName;
        @SerializedName("picture_thumb_path")
        @Expose
        private String pictureThumbPath;
        @SerializedName("facebook_id")
        @Expose
        private Object facebookId;
        @SerializedName("followers_count")
        @Expose
        private String followersCount;
        @SerializedName("followings_count")
        @Expose
        private String followingsCount;
        @SerializedName("friends_count")
        @Expose
        private String friendsCount;

        /**
         *
         * @return
         * The memberId
         */
        public String getMemberId() {
            return memberId;
        }

        /**
         *
         * @param memberId
         * The member_id
         */
        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        /**
         *
         * @return
         * The memberUsername
         */
        public String getMemberUsername() {
            return memberUsername;
        }

        /**
         *
         * @param memberUsername
         * The member_username
         */
        public void setMemberUsername(String memberUsername) {
            this.memberUsername = memberUsername;
        }

        /**
         *
         * @return
         * The memberEmail
         */
        public String getMemberEmail() {
            return memberEmail;
        }

        /**
         *
         * @param memberEmail
         * The member_email
         */
        public void setMemberEmail(String memberEmail) {
            this.memberEmail = memberEmail;
        }

        /**
         *
         * @return
         * The memberCompleteName
         */
        public String getMemberCompleteName() {
            return memberCompleteName;
        }

        /**
         *
         * @param memberCompleteName
         * The member_complete_name
         */
        public void setMemberCompleteName(String memberCompleteName) {
            this.memberCompleteName = memberCompleteName;
        }

        /**
         *
         * @return
         * The pictureThumbPath
         */
        public String getPictureThumbPath() {
            return pictureThumbPath;
        }

        /**
         *
         * @param pictureThumbPath
         * The picture_thumb_path
         */
        public void setPictureThumbPath(String pictureThumbPath) {
            this.pictureThumbPath = pictureThumbPath;
        }

        /**
         *
         * @return
         * The facebookId
         */
        public Object getFacebookId() {
            return facebookId;
        }

        /**
         *
         * @param facebookId
         * The facebook_id
         */
        public void setFacebookId(Object facebookId) {
            this.facebookId = facebookId;
        }

        /**
         *
         * @return
         * The followersCount
         */
        public String getFollowersCount() {
            return followersCount;
        }

        /**
         *
         * @param followersCount
         * The followers_count
         */
        public void setFollowersCount(String followersCount) {
            this.followersCount = followersCount;
        }

        /**
         *
         * @return
         * The followingsCount
         */
        public String getFollowingsCount() {
            return followingsCount;
        }

        /**
         *
         * @param followingsCount
         * The followings_count
         */
        public void setFollowingsCount(String followingsCount) {
            this.followingsCount = followingsCount;
        }

        /**
         *
         * @return
         * The friendsCount
         */
        public String getFriendsCount() {
            return friendsCount;
        }

        /**
         *
         * @param friendsCount
         * The friends_count
         */
        public void setFriendsCount(String friendsCount) {
            this.friendsCount = friendsCount;
        }

    }

    public class Like {

        @SerializedName("member")
        @Expose
        private Member member;

        /**
         *
         * @return
         * The member
         */
        public Member getMember() {
            return member;
        }

        /**
         *
         * @param member
         * The member
         */
        public void setMember(Member member) {
            this.member = member;
        }

    }

    public class Data {

        @SerializedName("likes")
        @Expose
        private List<Like> likes = new ArrayList<Like>();

        /**
         *
         * @return
         * The likes
         */
        public List<Like> getLikes() {
            return likes;
        }

        /**
         *
         * @param likes
         * The likes
         */
        public void setLikes(List<Like> likes) {
            this.likes = likes;
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
