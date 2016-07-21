package com.kufed.id.pojo;

/**
 * Created by macbook on 7/21/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PojoFriendRequests {

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

    public class Data {

        @SerializedName("current_page")
        @Expose
        private Integer currentPage;
        @SerializedName("total_pages")
        @Expose
        private Integer totalPages;
        @SerializedName("friends")
        @Expose
        private List<Friend> friends = new ArrayList<Friend>();

        /**
         *
         * @return
         * The currentPage
         */
        public Integer getCurrentPage() {
            return currentPage;
        }

        /**
         *
         * @param currentPage
         * The current_page
         */
        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        /**
         *
         * @return
         * The totalPages
         */
        public Integer getTotalPages() {
            return totalPages;
        }

        /**
         *
         * @param totalPages
         * The total_pages
         */
        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        /**
         *
         * @return
         * The friends
         */
        public List<Friend> getFriends() {
            return friends;
        }

        /**
         *
         * @param friends
         * The friends
         */
        public void setFriends(List<Friend> friends) {
            this.friends = friends;
        }

    }

    public class Friend {

        @SerializedName("friend_since")
        @Expose
        private String friendSince;
        @SerializedName("member")
        @Expose
        private Member member;

        /**
         *
         * @return
         * The friendSince
         */
        public String getFriendSince() {
            return friendSince;
        }

        /**
         *
         * @param friendSince
         * The friend_since
         */
        public void setFriendSince(String friendSince) {
            this.friendSince = friendSince;
        }

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
