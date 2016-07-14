package com.kufed.id.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by macbook on 7/11/16.
 */
public class PojoPostInfo {

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

    public class Product {

        @SerializedName("product_id")
        @Expose
        private Integer productId;
        @SerializedName("product_title")
        @Expose
        private String productTitle;
        @SerializedName("product_description")
        @Expose
        private String productDescription;
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
        @SerializedName("attributes")
        @Expose
        private List<Object> attributes = new ArrayList<Object>();

        /**
         *
         * @return
         * The productId
         */
        public Integer getProductId() {
            return productId;
        }

        /**
         *
         * @param productId
         * The product_id
         */
        public void setProductId(Integer productId) {
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
         * The productDescription
         */
        public String getProductDescription() {
            return productDescription;
        }

        /**
         *
         * @param productDescription
         * The product_description
         */
        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        /**
         *
         * @return
         * The sellingPrice
         */
        public Integer getSellingPrice() {
            return sellingPrice;
        }

        /**
         *
         * @param sellingPrice
         * The selling_price
         */
        public void setSellingPrice(Integer sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        /**
         *
         * @return
         * The originalPrice
         */
        public Integer getOriginalPrice() {
            return originalPrice;
        }

        /**
         *
         * @param originalPrice
         * The original_price
         */
        public void setOriginalPrice(Integer originalPrice) {
            this.originalPrice = originalPrice;
        }

        /**
         *
         * @return
         * The discountPrice
         */
        public Integer getDiscountPrice() {
            return discountPrice;
        }

        /**
         *
         * @param discountPrice
         * The discount_price
         */
        public void setDiscountPrice(Integer discountPrice) {
            this.discountPrice = discountPrice;
        }

        /**
         *
         * @return
         * The discountName
         */
        public String getDiscountName() {
            return discountName;
        }

        /**
         *
         * @param discountName
         * The discount_name
         */
        public void setDiscountName(String discountName) {
            this.discountName = discountName;
        }

        /**
         *
         * @return
         * The promoId
         */
        public Integer getPromoId() {
            return promoId;
        }

        /**
         *
         * @param promoId
         * The promo_id
         */
        public void setPromoId(Integer promoId) {
            this.promoId = promoId;
        }

        /**
         *
         * @return
         * The attributes
         */
        public List<Object> getAttributes() {
            return attributes;
        }

        /**
         *
         * @param attributes
         * The attributes
         */
        public void setAttributes(List<Object> attributes) {
            this.attributes = attributes;
        }

    }

    public class Related {

        @SerializedName("post_id")
        @Expose
        private String postId;
        @SerializedName("small_image_path")
        @Expose
        private String smallImagePath;
        @SerializedName("product_id")
        @Expose
        private String productId;
        @SerializedName("product_title")
        @Expose
        private String productTitle;
        @SerializedName("stock_current")
        @Expose
        private String stockCurrent;
        @SerializedName("selling_price")
        @Expose
        private String sellingPrice;

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
         * The stockCurrent
         */
        public String getStockCurrent() {
            return stockCurrent;
        }

        /**
         *
         * @param stockCurrent
         * The stock_current
         */
        public void setStockCurrent(String stockCurrent) {
            this.stockCurrent = stockCurrent;
        }

        /**
         *
         * @return
         * The sellingPrice
         */
        public String getSellingPrice() {
            return sellingPrice;
        }

        /**
         *
         * @param sellingPrice
         * The selling_price
         */
        public void setSellingPrice(String sellingPrice) {
            this.sellingPrice = sellingPrice;
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

    public class Variation {

        @SerializedName("product_id")
        @Expose
        private String productId;
        @SerializedName("product_title")
        @Expose
        private String productTitle;
        @SerializedName("brand_name")
        @Expose
        private String brandName;
        @SerializedName("variation")
        @Expose
        private List<Variation_> variation = new ArrayList<Variation_>();

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
         * The brandName
         */
        public String getBrandName() {
            return brandName;
        }

        /**
         *
         * @param brandName
         * The brand_name
         */
        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        /**
         *
         * @return
         * The variation
         */
        public List<Variation_> getVariation() {
            return variation;
        }

        /**
         *
         * @param variation
         * The variation
         */
        public void setVariation(List<Variation_> variation) {
            this.variation = variation;
        }

    }

    public class Variation_ {

        @SerializedName("variation_name")
        @Expose
        private String variationName;
        @SerializedName("variation_id")
        @Expose
        private String variationId;
        @SerializedName("selling_price")
        @Expose
        private String sellingPrice;
        @SerializedName("stock_current")
        @Expose
        private Integer stockCurrent;
        @SerializedName("size")
        @Expose
        private String size;
        @SerializedName("color_name")
        @Expose
        private String colorName;
        @SerializedName("color_rgb")
        @Expose
        private String colorRgb;

        /**
         *
         * @return
         * The variationName
         */
        public String getVariationName() {
            return variationName;
        }

        /**
         *
         * @param variationName
         * The variation_name
         */
        public void setVariationName(String variationName) {
            this.variationName = variationName;
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
         * The sellingPrice
         */
        public String getSellingPrice() {
            return sellingPrice;
        }

        /**
         *
         * @param sellingPrice
         * The selling_price
         */
        public void setSellingPrice(String sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        /**
         *
         * @return
         * The stockCurrent
         */
        public Integer getStockCurrent() {
            return stockCurrent;
        }

        /**
         *
         * @param stockCurrent
         * The stock_current
         */
        public void setStockCurrent(Integer stockCurrent) {
            this.stockCurrent = stockCurrent;
        }

        /**
         *
         * @return
         * The size
         */
        public String getSize() {
            return size;
        }

        /**
         *
         * @param size
         * The size
         */
        public void setSize(String size) {
            this.size = size;
        }

        /**
         *
         * @return
         * The colorName
         */
        public String getColorName() {
            return colorName;
        }

        /**
         *
         * @param colorName
         * The color_name
         */
        public void setColorName(String colorName) {
            this.colorName = colorName;
        }

        /**
         *
         * @return
         * The colorRgb
         */
        public String getColorRgb() {
            return colorRgb;
        }

        /**
         *
         * @param colorRgb
         * The color_rgb
         */
        public void setColorRgb(String colorRgb) {
            this.colorRgb = colorRgb;
        }

    }

    public class Comments {

        @SerializedName("is_more")
        @Expose
        private Boolean isMore;
        @SerializedName("count")
        @Expose
        private String count;
        @SerializedName("rows")
        @Expose
        private List<Object> rows = new ArrayList<Object>();

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

        /**
         *
         * @return
         * The rows
         */
        public List<Object> getRows() {
            return rows;
        }

        /**
         *
         * @param rows
         * The rows
         */
        public void setRows(List<Object> rows) {
            this.rows = rows;
        }

    }

    public class Data {

        @SerializedName("post_id")
        @Expose
        private Integer postId;
        @SerializedName("post_title")
        @Expose
        private String postTitle;
        @SerializedName("post_content")
        @Expose
        private String postContent;
        @SerializedName("normal_image_path")
        @Expose
        private String normalImagePath;
        @SerializedName("full_image_path")
        @Expose
        private String fullImagePath;
        @SerializedName("thumb_image_path")
        @Expose
        private String thumbImagePath;
        @SerializedName("small_image_path")
        @Expose
        private String smallImagePath;
        @SerializedName("post_date")
        @Expose
        private String postDate;
        @SerializedName("show_detail_shop")
        @Expose
        private String showDetailShop;
        @SerializedName("likes_count")
        @Expose
        private Integer likesCount;
        @SerializedName("comments_count")
        @Expose
        private Integer commentsCount;
        @SerializedName("shares_count")
        @Expose
        private String sharesCount;
        @SerializedName("is_international")
        @Expose
        private String isInternational;
        @SerializedName("note_international")
        @Expose
        private Object noteInternational;
        @SerializedName("vendor_id")
        @Expose
        private String vendorId;
        @SerializedName("vendor_name")
        @Expose
        private String vendorName;
        @SerializedName("brand_id")
        @Expose
        private String brandId;
        @SerializedName("brand_name")
        @Expose
        private String brandName;
        @SerializedName("subcategory_id")
        @Expose
        private String subcategoryId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
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
        @SerializedName("images")
        @Expose
        private List<Image> images = new ArrayList<Image>();
        @SerializedName("comments")
        @Expose
        private Comments comments;
        @SerializedName("variation")
        @Expose
        private Variation variation;
        @SerializedName("related")
        @Expose
        private List<Related> related = new ArrayList<Related>();

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
         *
         * @return
         * The postId
         */
        public Integer getPostId() {
            return postId;
        }

        /**
         *
         * @param postId
         * The post_id
         */
        public void setPostId(Integer postId) {
            this.postId = postId;
        }

        /**
         *
         * @return
         * The postTitle
         */
        public String getPostTitle() {
            return postTitle;
        }

        /**
         *
         * @param postTitle
         * The post_title
         */
        public void setPostTitle(String postTitle) {
            this.postTitle = postTitle;
        }

        /**
         *
         * @return
         * The postContent
         */
        public String getPostContent() {
            return postContent;
        }

        /**
         *
         * @param postContent
         * The post_content
         */
        public void setPostContent(String postContent) {
            this.postContent = postContent;
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
         * The fullImagePath
         */
        public String getFullImagePath() {
            return fullImagePath;
        }

        /**
         *
         * @param fullImagePath
         * The full_image_path
         */
        public void setFullImagePath(String fullImagePath) {
            this.fullImagePath = fullImagePath;
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
         * The postDate
         */
        public String getPostDate() {
            return postDate;
        }

        /**
         *
         * @param postDate
         * The post_date
         */
        public void setPostDate(String postDate) {
            this.postDate = postDate;
        }

        /**
         *
         * @return
         * The showDetailShop
         */
        public String getShowDetailShop() {
            return showDetailShop;
        }

        /**
         *
         * @param showDetailShop
         * The show_detail_shop
         */
        public void setShowDetailShop(String showDetailShop) {
            this.showDetailShop = showDetailShop;
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
         * The commentsCount
         */
        public Integer getCommentsCount() {
            return commentsCount;
        }

        /**
         *
         * @param commentsCount
         * The comments_count
         */
        public void setCommentsCount(Integer commentsCount) {
            this.commentsCount = commentsCount;
        }

        /**
         *
         * @return
         * The sharesCount
         */
        public String getSharesCount() {
            return sharesCount;
        }

        /**
         *
         * @param sharesCount
         * The shares_count
         */
        public void setSharesCount(String sharesCount) {
            this.sharesCount = sharesCount;
        }

        /**
         *
         * @return
         * The isInternational
         */
        public String getIsInternational() {
            return isInternational;
        }

        /**
         *
         * @param isInternational
         * The is_international
         */
        public void setIsInternational(String isInternational) {
            this.isInternational = isInternational;
        }

        /**
         *
         * @return
         * The noteInternational
         */
        public Object getNoteInternational() {
            return noteInternational;
        }

        /**
         *
         * @param noteInternational
         * The note_international
         */
        public void setNoteInternational(Object noteInternational) {
            this.noteInternational = noteInternational;
        }

        /**
         *
         * @return
         * The vendorId
         */
        public String getVendorId() {
            return vendorId;
        }

        /**
         *
         * @param vendorId
         * The vendor_id
         */
        public void setVendorId(String vendorId) {
            this.vendorId = vendorId;
        }

        /**
         *
         * @return
         * The vendorName
         */
        public String getVendorName() {
            return vendorName;
        }

        /**
         *
         * @param vendorName
         * The vendor_name
         */
        public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
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
         * The brandName
         */
        public String getBrandName() {
            return brandName;
        }

        /**
         *
         * @param brandName
         * The brand_name
         */
        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        /**
         *
         * @return
         * The subcategoryId
         */
        public String getSubcategoryId() {
            return subcategoryId;
        }

        /**
         *
         * @param subcategoryId
         * The subcategory_id
         */
        public void setSubcategoryId(String subcategoryId) {
            this.subcategoryId = subcategoryId;
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
         * The isLiked
         */
        public Boolean getIsLiked() {
            return isLiked;
        }

        /**
         *
         * @param isLiked
         * The is_liked
         */
        public void setIsLiked(Boolean isLiked) {
            this.isLiked = isLiked;
        }

        /**
         *
         * @return
         * The isAddedToWishlist
         */
        public Boolean getIsAddedToWishlist() {
            return isAddedToWishlist;
        }

        /**
         *
         * @param isAddedToWishlist
         * The is_added_to_wishlist
         */
        public void setIsAddedToWishlist(Boolean isAddedToWishlist) {
            this.isAddedToWishlist = isAddedToWishlist;
        }

        /**
         *
         * @return
         * The product
         */
        public Product getProduct() {
            return product;
        }

        /**
         *
         * @param product
         * The product
         */
        public void setProduct(Product product) {
            this.product = product;
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

        /**
         *
         * @return
         * The images
         */
        public List<Image> getImages() {
            return images;
        }

        /**
         *
         * @param images
         * The images
         */
        public void setImages(List<Image> images) {
            this.images = images;
        }

        /**
         *
         * @return
         * The comments
         */
        public Comments getComments() {
            return comments;
        }

        /**
         *
         * @param comments
         * The comments
         */
        public void setComments(Comments comments) {
            this.comments = comments;
        }

        /**
         *
         * @return
         * The variation
         */
        public Variation getVariation() {
            return variation;
        }

        /**
         *
         * @param variation
         * The variation
         */
        public void setVariation(Variation variation) {
            this.variation = variation;
        }

        /**
         *
         * @return
         * The related
         */
        public List<Related> getRelated() {
            return related;
        }

        /**
         *
         * @param related
         * The related
         */
        public void setRelated(List<Related> related) {
            this.related = related;
        }

    }

    public class Image {

        @SerializedName("normal_image_path")
        @Expose
        private String normalImagePath;
        @SerializedName("full_image_path")
        @Expose
        private String fullImagePath;
        @SerializedName("attribute")
        @Expose
        private String attribute;

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
         * The fullImagePath
         */
        public String getFullImagePath() {
            return fullImagePath;
        }

        /**
         *
         * @param fullImagePath
         * The full_image_path
         */
        public void setFullImagePath(String fullImagePath) {
            this.fullImagePath = fullImagePath;
        }

        /**
         *
         * @return
         * The attribute
         */
        public String getAttribute() {
            return attribute;
        }

        /**
         *
         * @param attribute
         * The attribute
         */
        public void setAttribute(String attribute) {
            this.attribute = attribute;
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
