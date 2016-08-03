package com.kufed.id.pojo;

/**
 * Created by macbook on 8/3/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class PojoResponseCartList {
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

    public class Cart {

        @SerializedName("messages")
        @Expose
        private String messages;
        @SerializedName("total_price")
        @Expose
        private Integer totalPrice;
        @SerializedName("original_total_price")
        @Expose
        private Integer originalTotalPrice;
        @SerializedName("promo")
        @Expose
        private List<Object> promo = new ArrayList<Object>();
        @SerializedName("detail")
        @Expose
        private List<Detail> detail = new ArrayList<Detail>();

        /**
         *
         * @return
         * The messages
         */
        public String getMessages() {
            return messages;
        }

        /**
         *
         * @param messages
         * The messages
         */
        public void setMessages(String messages) {
            this.messages = messages;
        }

        /**
         *
         * @return
         * The totalPrice
         */
        public Integer getTotalPrice() {
            return totalPrice;
        }

        /**
         *
         * @param totalPrice
         * The total_price
         */
        public void setTotalPrice(Integer totalPrice) {
            this.totalPrice = totalPrice;
        }

        /**
         *
         * @return
         * The originalTotalPrice
         */
        public Integer getOriginalTotalPrice() {
            return originalTotalPrice;
        }

        /**
         *
         * @param originalTotalPrice
         * The original_total_price
         */
        public void setOriginalTotalPrice(Integer originalTotalPrice) {
            this.originalTotalPrice = originalTotalPrice;
        }

        /**
         *
         * @return
         * The promo
         */
        public List<Object> getPromo() {
            return promo;
        }

        /**
         *
         * @param promo
         * The promo
         */
        public void setPromo(List<Object> promo) {
            this.promo = promo;
        }

        /**
         *
         * @return
         * The detail
         */
        public List<Detail> getDetail() {
            return detail;
        }

        /**
         *
         * @param detail
         * The detail
         */
        public void setDetail(List<Detail> detail) {
            this.detail = detail;
        }

    }

    public class Data {

        @SerializedName("cart_id")
        @Expose
        private String cartId;
        @SerializedName("cart")
        @Expose
        private Cart cart;

        /**
         *
         * @return
         * The cartId
         */
        public String getCartId() {
            return cartId;
        }

        /**
         *
         * @param cartId
         * The cart_id
         */
        public void setCartId(String cartId) {
            this.cartId = cartId;
        }

        /**
         *
         * @return
         * The cart
         */
        public Cart getCart() {
            return cart;
        }

        /**
         *
         * @param cart
         * The cart
         */
        public void setCart(Cart cart) {
            this.cart = cart;
        }

    }

    public class Detail {

        @SerializedName("product")
        @Expose
        private Product product;
        @SerializedName("prices")
        @Expose
        private Prices prices;
        @SerializedName("is_promo")
        @Expose
        private Boolean isPromo;
        @SerializedName("is_running_low")
        @Expose
        private Boolean isRunningLow;

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
         * The prices
         */
        public Prices getPrices() {
            return prices;
        }

        /**
         *
         * @param prices
         * The prices
         */
        public void setPrices(Prices prices) {
            this.prices = prices;
        }

        /**
         *
         * @return
         * The isPromo
         */
        public Boolean getIsPromo() {
            return isPromo;
        }

        /**
         *
         * @param isPromo
         * The is_promo
         */
        public void setIsPromo(Boolean isPromo) {
            this.isPromo = isPromo;
        }

        /**
         *
         * @return
         * The isRunningLow
         */
        public Boolean getIsRunningLow() {
            return isRunningLow;
        }

        /**
         *
         * @param isRunningLow
         * The is_running_low
         */
        public void setIsRunningLow(Boolean isRunningLow) {
            this.isRunningLow = isRunningLow;
        }

    }

    public class Prices {

        @SerializedName("promo_id")
        @Expose
        private Integer promoId;
        @SerializedName("selling_price")
        @Expose
        private String sellingPrice;
        @SerializedName("original_price")
        @Expose
        private Integer originalPrice;
        @SerializedName("discount_price")
        @Expose
        private Integer discountPrice;
        @SerializedName("discount_name")
        @Expose
        private String discountName;
        @SerializedName("subtotal")
        @Expose
        private Integer subtotal;
        @SerializedName("quantity")
        @Expose
        private String quantity;

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
         * The subtotal
         */
        public Integer getSubtotal() {
            return subtotal;
        }

        /**
         *
         * @param subtotal
         * The subtotal
         */
        public void setSubtotal(Integer subtotal) {
            this.subtotal = subtotal;
        }

        /**
         *
         * @return
         * The quantity
         */
        public String getQuantity() {
            return quantity;
        }

        /**
         *
         * @param quantity
         * The quantity
         */
        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

    }

    public class Product {

        @SerializedName("brand_id")
        @Expose
        private String brandId;
        @SerializedName("brand_name")
        @Expose
        private String brandName;
        @SerializedName("variation_id")
        @Expose
        private String variationId;
        @SerializedName("variation_name")
        @Expose
        private String variationName;
        @SerializedName("vendor_id")
        @Expose
        private String vendorId;
        @SerializedName("stock_type")
        @Expose
        private String stockType;
        @SerializedName("package_weight")
        @Expose
        private String packageWeight;
        @SerializedName("product_id")
        @Expose
        private String productId;
        @SerializedName("is_international")
        @Expose
        private String isInternational;
        @SerializedName("note_international")
        @Expose
        private String noteInternational;
        @SerializedName("product_url")
        @Expose
        private String productUrl;
        @SerializedName("product_title")
        @Expose
        private String productTitle;
        @SerializedName("color_name")
        @Expose
        private String colorName;
        @SerializedName("color_rgb")
        @Expose
        private String colorRgb;
        @SerializedName("city_id")
        @Expose
        private String cityId;
        @SerializedName("size")
        @Expose
        private String size;
        @SerializedName("main_image")
        @Expose
        private String mainImage;
        @SerializedName("post_id")
        @Expose
        private String postId;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("available_quantity")
        @Expose
        private Integer availableQuantity;

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
         * The stockType
         */
        public String getStockType() {
            return stockType;
        }

        /**
         *
         * @param stockType
         * The stock_type
         */
        public void setStockType(String stockType) {
            this.stockType = stockType;
        }

        /**
         *
         * @return
         * The packageWeight
         */
        public String getPackageWeight() {
            return packageWeight;
        }

        /**
         *
         * @param packageWeight
         * The package_weight
         */
        public void setPackageWeight(String packageWeight) {
            this.packageWeight = packageWeight;
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
        public String getNoteInternational() {
            return noteInternational;
        }

        /**
         *
         * @param noteInternational
         * The note_international
         */
        public void setNoteInternational(String noteInternational) {
            this.noteInternational = noteInternational;
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

        /**
         *
         * @return
         * The cityId
         */
        public String getCityId() {
            return cityId;
        }

        /**
         *
         * @param cityId
         * The city_id
         */
        public void setCityId(String cityId) {
            this.cityId = cityId;
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
         * The mainImage
         */
        public String getMainImage() {
            return mainImage;
        }

        /**
         *
         * @param mainImage
         * The main_image
         */
        public void setMainImage(String mainImage) {
            this.mainImage = mainImage;
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
         * The image
         */
        public String getImage() {
            return image;
        }

        /**
         *
         * @param image
         * The image
         */
        public void setImage(String image) {
            this.image = image;
        }

        /**
         *
         * @return
         * The availableQuantity
         */
        public Integer getAvailableQuantity() {
            return availableQuantity;
        }

        /**
         *
         * @param availableQuantity
         * The available_quantity
         */
        public void setAvailableQuantity(Integer availableQuantity) {
            this.availableQuantity = availableQuantity;
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
