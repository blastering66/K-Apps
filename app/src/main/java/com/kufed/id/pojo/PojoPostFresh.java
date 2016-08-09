package com.kufed.id.pojo;

/**
 * Created by macbook on 6/1/16.
 */
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoPostFresh {

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

    public class Post {

        @SerializedName("post_id")
        @Expose
        private Integer postId;
        @SerializedName("post_content")
        @Expose
        private String postContent;
        @SerializedName("post_title")
        @Expose
        private String postTitle;
        @SerializedName("full_image_path")
        @Expose
        private String fullImagePath;
        @SerializedName("normal_image_path")
        @Expose
        private String normalImagePath;
        @SerializedName("thumb_image_path")
        @Expose
        private String thumbImagePath;
        @SerializedName("small_image_path")
        @Expose
        private String smallImagePath;
        @SerializedName("post_date")
        @Expose
        private String postDate;
        @SerializedName("post_type")
        @Expose
        private String postType;
        @SerializedName("home")
        @Expose
        private String home;
        @SerializedName("likes_count")
        @Expose
        private Integer likesCount;
        @SerializedName("comments_count")
        @Expose
        private Integer commentsCount;
        @SerializedName("brand_name")
        @Expose
        private String brandName;
        @SerializedName("stock_current")
        @Expose
        private String stockCurrent;
        @SerializedName("color_name")
        @Expose
        private String colorName;
        @SerializedName("is_liked")
        @Expose
        private Boolean isLiked;
        @SerializedName("is_added_to_wishlist")
        @Expose
        private Boolean isAddedToWishlist;
        @SerializedName("product")
        @Expose
        private Product product;
        @SerializedName("member")
        @Expose
        private Member member;
        @SerializedName("post_url")
        @Expose
        private String postUrl;

        public String getPostUrl() {
            return postUrl;
        }

        public void setPostUrl(String postUrl) {
            this.postUrl = postUrl;
        }

        /**
         * @return The postId
         */
        public Integer getPostId() {
            return postId;
        }

        /**
         * @param postId The post_id
         */
        public void setPostId(Integer postId) {
            this.postId = postId;
        }

        /**
         * @return The postContent
         */
        public String getPostContent() {
            return postContent;
        }

        /**
         * @param postContent The post_content
         */
        public void setPostContent(String postContent) {
            this.postContent = postContent;
        }

        /**
         * @return The postTitle
         */
        public String getPostTitle() {
            return postTitle;
        }

        /**
         * @param postTitle The post_title
         */
        public void setPostTitle(String postTitle) {
            this.postTitle = postTitle;
        }

        /**
         * @return The fullImagePath
         */
        public String getFullImagePath() {
            return fullImagePath;
        }

        /**
         * @param fullImagePath The full_image_path
         */
        public void setFullImagePath(String fullImagePath) {
            this.fullImagePath = fullImagePath;
        }

        /**
         * @return The normalImagePath
         */
        public String getNormalImagePath() {
            return normalImagePath;
        }

        /**
         * @param normalImagePath The normal_image_path
         */
        public void setNormalImagePath(String normalImagePath) {
            this.normalImagePath = normalImagePath;
        }

        /**
         * @return The thumbImagePath
         */
        public String getThumbImagePath() {
            return thumbImagePath;
        }

        /**
         * @param thumbImagePath The thumb_image_path
         */
        public void setThumbImagePath(String thumbImagePath) {
            this.thumbImagePath = thumbImagePath;
        }

        /**
         * @return The smallImagePath
         */
        public String getSmallImagePath() {
            return smallImagePath;
        }

        /**
         * @param smallImagePath The small_image_path
         */
        public void setSmallImagePath(String smallImagePath) {
            this.smallImagePath = smallImagePath;
        }

        /**
         * @return The postDate
         */
        public String getPostDate() {
            return postDate;
        }

        /**
         * @param postDate The post_date
         */
        public void setPostDate(String postDate) {
            this.postDate = postDate;
        }

        /**
         * @return The postType
         */
        public String getPostType() {
            return postType;
        }

        /**
         * @param postType The post_type
         */
        public void setPostType(String postType) {
            this.postType = postType;
        }

        /**
         * @return The home
         */
        public String getHome() {
            return home;
        }

        /**
         * @param home The home
         */
        public void setHome(String home) {
            this.home = home;
        }

        /**
         * @return The likesCount
         */
        public Integer getLikesCount() {
            return likesCount;
        }

        /**
         * @param likesCount The likes_count
         */
        public void setLikesCount(Integer likesCount) {
            this.likesCount = likesCount;
        }

        /**
         * @return The commentsCount
         */
        public Integer getCommentsCount() {
            return commentsCount;
        }

        /**
         * @param commentsCount The comments_count
         */
        public void setCommentsCount(Integer commentsCount) {
            this.commentsCount = commentsCount;
        }

        /**
         * @return The brandName
         */
        public String getBrandName() {
            return brandName;
        }

        /**
         * @param brandName The brand_name
         */
        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        /**
         * @return The stockCurrent
         */
        public String getStockCurrent() {
            return stockCurrent;
        }

        /**
         * @param stockCurrent The stock_current
         */
        public void setStockCurrent(String stockCurrent) {
            this.stockCurrent = stockCurrent;
        }

        /**
         * @return The colorName
         */
        public String getColorName() {
            return colorName;
        }

        /**
         * @param colorName The color_name
         */
        public void setColorName(String colorName) {
            this.colorName = colorName;
        }

        /**
         * @return The isLiked
         */
        public Boolean getIsLiked() {
            return isLiked;
        }

        /**
         * @param isLiked The is_liked
         */
        public void setIsLiked(Boolean isLiked) {
            this.isLiked = isLiked;
        }

        /**
         * @return The isAddedToWishlist
         */
        public Boolean getIsAddedToWishlist() {
            return isAddedToWishlist;
        }

        /**
         * @param isAddedToWishlist The is_added_to_wishlist
         */
        public void setIsAddedToWishlist(Boolean isAddedToWishlist) {
            this.isAddedToWishlist = isAddedToWishlist;
        }

        /**
         * @return The product
         */
        public Product getProduct() {
            return product;
        }

        /**
         * @param product The product
         */
        public void setProduct(Product product) {
            this.product = product;
        }

        /**
         * @return The member
         */
        public Member getMember() {
            return member;
        }

        /**
         * @param member The member
         */
        public void setMember(Member member) {
            this.member = member;
        }

    }

    public class Product {

        @SerializedName("product_id")
        @Expose
        private Integer productId;
        @SerializedName("product_title")
        @Expose
        private String productTitle;
        @SerializedName("selling_price")
        @Expose
        private Integer sellingPrice;
        @SerializedName("original_price")
        @Expose
        private Integer originalPrice;
        @SerializedName("discount_price")
        @Expose
        private Integer discountPrice;
        @SerializedName("discount_name")
        @Expose
        private String discountName;
        @SerializedName("promo_id")
        @Expose
        private Integer promoId;

        /**
         * @return The productId
         */
        public Integer getProductId() {
            return productId;
        }

        /**
         * @param productId The product_id
         */
        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        /**
         * @return The productTitle
         */
        public String getProductTitle() {
            return productTitle;
        }

        /**
         * @param productTitle The product_title
         */
        public void setProductTitle(String productTitle) {
            this.productTitle = productTitle;
        }

        /**
         * @return The sellingPrice
         */
        public Integer getSellingPrice() {
            return sellingPrice;
        }

        /**
         * @param sellingPrice The selling_price
         */
        public void setSellingPrice(Integer sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        /**
         * @return The originalPrice
         */
        public Integer getOriginalPrice() {
            return originalPrice;
        }

        /**
         * @param originalPrice The original_price
         */
        public void setOriginalPrice(Integer originalPrice) {
            this.originalPrice = originalPrice;
        }

        /**
         * @return The discountPrice
         */
        public Integer getDiscountPrice() {
            return discountPrice;
        }

        /**
         * @param discountPrice The discount_price
         */
        public void setDiscountPrice(Integer discountPrice) {
            this.discountPrice = discountPrice;
        }

        /**
         * @return The discountName
         */
        public String getDiscountName() {
            return discountName;
        }

        /**
         * @param discountName The discount_name
         */
        public void setDiscountName(String discountName) {
            this.discountName = discountName;
        }

        /**
         * @return The promoId
         */
        public Integer getPromoId() {
            return promoId;
        }

        /**
         * @param promoId The promo_id
         */
        public void setPromoId(Integer promoId) {
            this.promoId = promoId;
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


        public class Data {

            @SerializedName("is_more")
            @Expose
            private Boolean isMore;
            @SerializedName("posts")
            @Expose
            private List<Post> posts = new ArrayList<Post>();

            /**
             * @return The isMore
             */
            public Boolean getIsMore() {
                return isMore;
            }

            /**
             * @param isMore The is_more
             */
            public void setIsMore(Boolean isMore) {
                this.isMore = isMore;
            }

            /**
             * @return The posts
             */
            public List<Post> getPosts() {
                return posts;
            }

            /**
             * @param posts The posts
             */
            public void setPosts(List<Post> posts) {
                this.posts = posts;
            }

        }

    }

    public class Data {

        @SerializedName("is_more")
        @Expose
        private Boolean isMore;
        @SerializedName("posts")
        @Expose
        private List<Post> posts = new ArrayList<Post>();

        /**
         *
         * @return
         * The isMore
         */
        public Boolean getIsMore() {
            return isMore;
        }

        /**
         *
         * @param isMore
         * The is_more
         */
        public void setIsMore(Boolean isMore) {
            this.isMore = isMore;
        }

        /**
         *
         * @return
         * The posts
         */
        public List<Post> getPosts() {
            return posts;
        }

        /**
         *
         * @param posts
         * The posts
         */
        public void setPosts(List<Post> posts) {
            this.posts = posts;
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
}