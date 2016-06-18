package com.kufed.id.pojo;

/**
 * Created by macbook on 6/1/16.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoGETProfile {
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

        @SerializedName("info")
        @Expose
        private Info info;
        @SerializedName("liked_posts")
        @Expose
        private List<LikedPost> likedPosts = new ArrayList<LikedPost>();

        /**
         *
         * @return
         * The info
         */
        public Info getInfo() {
            return info;
        }

        /**
         *
         * @param info
         * The info
         */
        public void setInfo(Info info) {
            this.info = info;
        }

        /**
         *
         * @return
         * The likedPosts
         */
        public List<LikedPost> getLikedPosts() {
            return likedPosts;
        }

        /**
         *
         * @param likedPosts
         * The liked_posts
         */
        public void setLikedPosts(List<LikedPost> likedPosts) {
            this.likedPosts = likedPosts;
        }

    }

    public class Info {

        @SerializedName("member_id")
        @Expose
        private Integer memberId;
        @SerializedName("member_username")
        @Expose
        private String memberUsername;
        @SerializedName("member_complete_name")
        @Expose
        private String memberCompleteName;
        @SerializedName("member_biography")
        @Expose
        private String memberBiography;
        @SerializedName("member_gender")
        @Expose
        private String memberGender;
        @SerializedName("member_birth_date")
        @Expose
        private String memberBirthDate;
        @SerializedName("member_website")
        @Expose
        private Object memberWebsite;
        @SerializedName("member_email")
        @Expose
        private String memberEmail;
        @SerializedName("member_phone")
        @Expose
        private String memberPhone;
        @SerializedName("is_verified")
        @Expose
        private Boolean isVerified;
        @SerializedName("followers_count")
        @Expose
        private Integer followersCount;
        @SerializedName("followings_count")
        @Expose
        private Integer followingsCount;
        @SerializedName("friends_count")
        @Expose
        private String friendsCount;
        @SerializedName("likes_count")
        @Expose
        private Integer likesCount;
        @SerializedName("wishlists_count")
        @Expose
        private Integer wishlistsCount;
        @SerializedName("shares_count")
        @Expose
        private Integer sharesCount;
        @SerializedName("cover_path")
        @Expose
        private String coverPath;
        @SerializedName("picture_thumb_path")
        @Expose
        private String pictureThumbPath;
        @SerializedName("store_credits")
        @Expose
        private Object storeCredits;
        @SerializedName("added_posts_count")
        @Expose
        private Integer addedPostsCount;
        @SerializedName("liked_posts_count")
        @Expose
        private String likedPostsCount;
        @SerializedName("is_following")
        @Expose
        private Boolean isFollowing;
        @SerializedName("is_friend")
        @Expose
        private Boolean isFriend;
        @SerializedName("is_requested_friend")
        @Expose
        private Boolean isRequestedFriend;

        /**
         *
         * @return
         * The memberId
         */
        public Integer getMemberId() {
            return memberId;
        }

        /**
         *
         * @param memberId
         * The member_id
         */
        public void setMemberId(Integer memberId) {
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
         * The memberBiography
         */
        public String getMemberBiography() {
            return memberBiography;
        }

        /**
         *
         * @param memberBiography
         * The member_biography
         */
        public void setMemberBiography(String memberBiography) {
            this.memberBiography = memberBiography;
        }

        /**
         *
         * @return
         * The memberGender
         */
        public String getMemberGender() {
            return memberGender;
        }

        /**
         *
         * @param memberGender
         * The member_gender
         */
        public void setMemberGender(String memberGender) {
            this.memberGender = memberGender;
        }

        /**
         *
         * @return
         * The memberBirthDate
         */
        public String getMemberBirthDate() {
            return memberBirthDate;
        }

        /**
         *
         * @param memberBirthDate
         * The member_birth_date
         */
        public void setMemberBirthDate(String memberBirthDate) {
            this.memberBirthDate = memberBirthDate;
        }

        /**
         *
         * @return
         * The memberWebsite
         */
        public Object getMemberWebsite() {
            return memberWebsite;
        }

        /**
         *
         * @param memberWebsite
         * The member_website
         */
        public void setMemberWebsite(Object memberWebsite) {
            this.memberWebsite = memberWebsite;
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
         * The memberPhone
         */
        public String getMemberPhone() {
            return memberPhone;
        }

        /**
         *
         * @param memberPhone
         * The member_phone
         */
        public void setMemberPhone(String memberPhone) {
            this.memberPhone = memberPhone;
        }

        /**
         *
         * @return
         * The isVerified
         */
        public Boolean getIsVerified() {
            return isVerified;
        }

        /**
         *
         * @param isVerified
         * The is_verified
         */
        public void setIsVerified(Boolean isVerified) {
            this.isVerified = isVerified;
        }

        /**
         *
         * @return
         * The followersCount
         */
        public Integer getFollowersCount() {
            return followersCount;
        }

        /**
         *
         * @param followersCount
         * The followers_count
         */
        public void setFollowersCount(Integer followersCount) {
            this.followersCount = followersCount;
        }

        /**
         *
         * @return
         * The followingsCount
         */
        public Integer getFollowingsCount() {
            return followingsCount;
        }

        /**
         *
         * @param followingsCount
         * The followings_count
         */
        public void setFollowingsCount(Integer followingsCount) {
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

        /**
         *
         * @return
         * The likesCount
         */
        public Integer getLikesCount() {
            return likesCount;
        }

        /**
         *
         * @param likesCount
         * The likes_count
         */
        public void setLikesCount(Integer likesCount) {
            this.likesCount = likesCount;
        }

        /**
         *
         * @return
         * The wishlistsCount
         */
        public Integer getWishlistsCount() {
            return wishlistsCount;
        }

        /**
         *
         * @param wishlistsCount
         * The wishlists_count
         */
        public void setWishlistsCount(Integer wishlistsCount) {
            this.wishlistsCount = wishlistsCount;
        }

        /**
         *
         * @return
         * The sharesCount
         */
        public Integer getSharesCount() {
            return sharesCount;
        }

        /**
         *
         * @param sharesCount
         * The shares_count
         */
        public void setSharesCount(Integer sharesCount) {
            this.sharesCount = sharesCount;
        }

        /**
         *
         * @return
         * The coverPath
         */
        public String getCoverPath() {
            return coverPath;
        }

        /**
         *
         * @param coverPath
         * The cover_path
         */
        public void setCoverPath(String coverPath) {
            this.coverPath = coverPath;
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
         * The storeCredits
         */
        public Object getStoreCredits() {
            return storeCredits;
        }

        /**
         *
         * @param storeCredits
         * The store_credits
         */
        public void setStoreCredits(Object storeCredits) {
            this.storeCredits = storeCredits;
        }

        /**
         *
         * @return
         * The addedPostsCount
         */
        public Integer getAddedPostsCount() {
            return addedPostsCount;
        }

        /**
         *
         * @param addedPostsCount
         * The added_posts_count
         */
        public void setAddedPostsCount(Integer addedPostsCount) {
            this.addedPostsCount = addedPostsCount;
        }

        /**
         *
         * @return
         * The likedPostsCount
         */
        public String getLikedPostsCount() {
            return likedPostsCount;
        }

        /**
         *
         * @param likedPostsCount
         * The liked_posts_count
         */
        public void setLikedPostsCount(String likedPostsCount) {
            this.likedPostsCount = likedPostsCount;
        }

        /**
         *
         * @return
         * The isFollowing
         */
        public Boolean getIsFollowing() {
            return isFollowing;
        }

        /**
         *
         * @param isFollowing
         * The is_following
         */
        public void setIsFollowing(Boolean isFollowing) {
            this.isFollowing = isFollowing;
        }

        /**
         *
         * @return
         * The isFriend
         */
        public Boolean getIsFriend() {
            return isFriend;
        }

        /**
         *
         * @param isFriend
         * The is_friend
         */
        public void setIsFriend(Boolean isFriend) {
            this.isFriend = isFriend;
        }

        /**
         *
         * @return
         * The isRequestedFriend
         */
        public Boolean getIsRequestedFriend() {
            return isRequestedFriend;
        }

        /**
         *
         * @param isRequestedFriend
         * The is_requested_friend
         */
        public void setIsRequestedFriend(Boolean isRequestedFriend) {
            this.isRequestedFriend = isRequestedFriend;
        }

    }

    public class LikedPost {

        @SerializedName("thumb_image_path")
        @Expose
        private String thumbImagePath;
        @SerializedName("post_id")
        @Expose
        private String postId;
        @SerializedName("post_like_id")
        @Expose
        private String postLikeId;
        @SerializedName("small_image_path")
        @Expose
        private String smallImagePath;
        @SerializedName("product_title")
        @Expose
        private String productTitle;
        @SerializedName("likes_count")
        @Expose
        private String likesCount;

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
         * The postLikeId
         */
        public String getPostLikeId() {
            return postLikeId;
        }

        /**
         *
         * @param postLikeId
         * The post_like_id
         */
        public void setPostLikeId(String postLikeId) {
            this.postLikeId = postLikeId;
        }

        /**
         *
         * @return
         * The smallImagePath
         */
        public String getSmallImagePath() {
            return smallImagePath;
        }

        /**
         *
         * @param smallImagePath
         * The small_image_path
         */
        public void setSmallImagePath(String smallImagePath) {
            this.smallImagePath = smallImagePath;
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
         * The likesCount
         */
        public String getLikesCount() {
            return likesCount;
        }

        /**
         *
         * @param likesCount
         * The likes_count
         */
        public void setLikesCount(String likesCount) {
            this.likesCount = likesCount;
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
}
