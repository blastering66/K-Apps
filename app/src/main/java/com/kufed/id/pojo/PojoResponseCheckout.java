package com.kufed.id.pojo;

/**
 * Created by macbook on 8/2/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PojoResponseCheckout {
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

    public class PriceList {

        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("amount")
        @Expose
        private Integer amount;

        /**
         *
         * @return
         * The text
         */
        public String getText() {
            return text;
        }

        /**
         *
         * @param text
         * The text
         */
        public void setText(String text) {
            this.text = text;
        }

        /**
         *
         * @return
         * The amount
         */
        public Integer getAmount() {
            return amount;
        }

        /**
         *
         * @param amount
         * The amount
         */
        public void setAmount(Integer amount) {
            this.amount = amount;
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

    public class ShippingMethod {

        @SerializedName("method_id")
        @Expose
        private String methodId;
        @SerializedName("method_code")
        @Expose
        private String methodCode;
        @SerializedName("method_name")
        @Expose
        private String methodName;
        @SerializedName("method_description")
        @Expose
        private String methodDescription;

        /**
         *
         * @return
         * The methodId
         */
        public String getMethodId() {
            return methodId;
        }

        /**
         *
         * @param methodId
         * The method_id
         */
        public void setMethodId(String methodId) {
            this.methodId = methodId;
        }

        /**
         *
         * @return
         * The methodCode
         */
        public String getMethodCode() {
            return methodCode;
        }

        /**
         *
         * @param methodCode
         * The method_code
         */
        public void setMethodCode(String methodCode) {
            this.methodCode = methodCode;
        }

        /**
         *
         * @return
         * The methodName
         */
        public String getMethodName() {
            return methodName;
        }

        /**
         *
         * @param methodName
         * The method_name
         */
        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        /**
         *
         * @return
         * The methodDescription
         */
        public String getMethodDescription() {
            return methodDescription;
        }

        /**
         *
         * @param methodDescription
         * The method_description
         */
        public void setMethodDescription(String methodDescription) {
            this.methodDescription = methodDescription;
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

    public class Address {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("address_label")
        @Expose
        private String addressLabel;
        @SerializedName("country_id")
        @Expose
        private Integer countryId;
        @SerializedName("country_name")
        @Expose
        private String countryName;
        @SerializedName("province_id")
        @Expose
        private Integer provinceId;
        @SerializedName("province_name")
        @Expose
        private String provinceName;
        @SerializedName("city_id")
        @Expose
        private Integer cityId;
        @SerializedName("city_name")
        @Expose
        private String cityName;
        @SerializedName("kecamatan_id")
        @Expose
        private String kecamatanId;
        @SerializedName("kecamatan_name")
        @Expose
        private String kecamatanName;
        @SerializedName("address_complete_name")
        @Expose
        private String addressCompleteName;
        @SerializedName("address_post_code")
        @Expose
        private String addressPostCode;
        @SerializedName("address_phone")
        @Expose
        private String addressPhone;
        @SerializedName("address_optional_phone")
        @Expose
        private String addressOptionalPhone;
        @SerializedName("address_detail")
        @Expose
        private String addressDetail;
        @SerializedName("is_primary")
        @Expose
        private Boolean isPrimary;
        @SerializedName("rate_id")
        @Expose
        private String rateId;

        /**
         *
         * @return
         * The id
         */
        public Integer getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The addressLabel
         */
        public String getAddressLabel() {
            return addressLabel;
        }

        /**
         *
         * @param addressLabel
         * The address_label
         */
        public void setAddressLabel(String addressLabel) {
            this.addressLabel = addressLabel;
        }

        /**
         *
         * @return
         * The countryId
         */
        public Integer getCountryId() {
            return countryId;
        }

        /**
         *
         * @param countryId
         * The country_id
         */
        public void setCountryId(Integer countryId) {
            this.countryId = countryId;
        }

        /**
         *
         * @return
         * The countryName
         */
        public String getCountryName() {
            return countryName;
        }

        /**
         *
         * @param countryName
         * The country_name
         */
        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        /**
         *
         * @return
         * The provinceId
         */
        public Integer getProvinceId() {
            return provinceId;
        }

        /**
         *
         * @param provinceId
         * The province_id
         */
        public void setProvinceId(Integer provinceId) {
            this.provinceId = provinceId;
        }

        /**
         *
         * @return
         * The provinceName
         */
        public String getProvinceName() {
            return provinceName;
        }

        /**
         *
         * @param provinceName
         * The province_name
         */
        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        /**
         *
         * @return
         * The cityId
         */
        public Integer getCityId() {
            return cityId;
        }

        /**
         *
         * @param cityId
         * The city_id
         */
        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        /**
         *
         * @return
         * The cityName
         */
        public String getCityName() {
            return cityName;
        }

        /**
         *
         * @param cityName
         * The city_name
         */
        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        /**
         *
         * @return
         * The kecamatanId
         */
        public String getKecamatanId() {
            return kecamatanId;
        }

        /**
         *
         * @param kecamatanId
         * The kecamatan_id
         */
        public void setKecamatanId(String kecamatanId) {
            this.kecamatanId = kecamatanId;
        }

        /**
         *
         * @return
         * The kecamatanName
         */
        public String getKecamatanName() {
            return kecamatanName;
        }

        /**
         *
         * @param kecamatanName
         * The kecamatan_name
         */
        public void setKecamatanName(String kecamatanName) {
            this.kecamatanName = kecamatanName;
        }

        /**
         *
         * @return
         * The addressCompleteName
         */
        public String getAddressCompleteName() {
            return addressCompleteName;
        }

        /**
         *
         * @param addressCompleteName
         * The address_complete_name
         */
        public void setAddressCompleteName(String addressCompleteName) {
            this.addressCompleteName = addressCompleteName;
        }

        /**
         *
         * @return
         * The addressPostCode
         */
        public String getAddressPostCode() {
            return addressPostCode;
        }

        /**
         *
         * @param addressPostCode
         * The address_post_code
         */
        public void setAddressPostCode(String addressPostCode) {
            this.addressPostCode = addressPostCode;
        }

        /**
         *
         * @return
         * The addressPhone
         */
        public String getAddressPhone() {
            return addressPhone;
        }

        /**
         *
         * @param addressPhone
         * The address_phone
         */
        public void setAddressPhone(String addressPhone) {
            this.addressPhone = addressPhone;
        }

        /**
         *
         * @return
         * The addressOptionalPhone
         */
        public String getAddressOptionalPhone() {
            return addressOptionalPhone;
        }

        /**
         *
         * @param addressOptionalPhone
         * The address_optional_phone
         */
        public void setAddressOptionalPhone(String addressOptionalPhone) {
            this.addressOptionalPhone = addressOptionalPhone;
        }

        /**
         *
         * @return
         * The addressDetail
         */
        public String getAddressDetail() {
            return addressDetail;
        }

        /**
         *
         * @param addressDetail
         * The address_detail
         */
        public void setAddressDetail(String addressDetail) {
            this.addressDetail = addressDetail;
        }

        /**
         *
         * @return
         * The isPrimary
         */
        public Boolean getIsPrimary() {
            return isPrimary;
        }

        /**
         *
         * @param isPrimary
         * The is_primary
         */
        public void setIsPrimary(Boolean isPrimary) {
            this.isPrimary = isPrimary;
        }

        /**
         *
         * @return
         * The rateId
         */
        public String getRateId() {
            return rateId;
        }

        /**
         *
         * @param rateId
         * The rate_id
         */
        public void setRateId(String rateId) {
            this.rateId = rateId;
        }

    }

    public class Bank {

        @SerializedName("bank_id")
        @Expose
        private String bankId;
        @SerializedName("bank_name")
        @Expose
        private String bankName;
        @SerializedName("bank_holder_name")
        @Expose
        private String bankHolderName;
        @SerializedName("bank_number")
        @Expose
        private String bankNumber;

        /**
         *
         * @return
         * The bankId
         */
        public String getBankId() {
            return bankId;
        }

        /**
         *
         * @param bankId
         * The bank_id
         */
        public void setBankId(String bankId) {
            this.bankId = bankId;
        }

        /**
         *
         * @return
         * The bankName
         */
        public String getBankName() {
            return bankName;
        }

        /**
         *
         * @param bankName
         * The bank_name
         */
        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        /**
         *
         * @return
         * The bankHolderName
         */
        public String getBankHolderName() {
            return bankHolderName;
        }

        /**
         *
         * @param bankHolderName
         * The bank_holder_name
         */
        public void setBankHolderName(String bankHolderName) {
            this.bankHolderName = bankHolderName;
        }

        /**
         *
         * @return
         * The bankNumber
         */
        public String getBankNumber() {
            return bankNumber;
        }

        /**
         *
         * @param bankNumber
         * The bank_number
         */
        public void setBankNumber(String bankNumber) {
            this.bankNumber = bankNumber;
        }

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
        @SerializedName("price_list")
        @Expose
        private List<PriceList> priceList = new ArrayList<PriceList>();
        @SerializedName("email_address")
        @Expose
        private String emailAddress;
        @SerializedName("address")
        @Expose
        private List<Address> address = new ArrayList<Address>();
        @SerializedName("shipping_method")
        @Expose
        private List<ShippingMethod> shippingMethod = new ArrayList<ShippingMethod>();
        @SerializedName("payment_method")
        @Expose
        private List<PaymentMethod> paymentMethod = new ArrayList<PaymentMethod>();

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

        /**
         *
         * @return
         * The priceList
         */
        public List<PriceList> getPriceList() {
            return priceList;
        }

        /**
         *
         * @param priceList
         * The price_list
         */
        public void setPriceList(List<PriceList> priceList) {
            this.priceList = priceList;
        }

        /**
         *
         * @return
         * The emailAddress
         */
        public String getEmailAddress() {
            return emailAddress;
        }

        /**
         *
         * @param emailAddress
         * The email_address
         */
        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        /**
         *
         * @return
         * The address
         */
        public List<Address> getAddress() {
            return address;
        }

        /**
         *
         * @param address
         * The address
         */
        public void setAddress(List<Address> address) {
            this.address = address;
        }

        /**
         *
         * @return
         * The shippingMethod
         */
        public List<ShippingMethod> getShippingMethod() {
            return shippingMethod;
        }

        /**
         *
         * @param shippingMethod
         * The shipping_method
         */
        public void setShippingMethod(List<ShippingMethod> shippingMethod) {
            this.shippingMethod = shippingMethod;
        }

        /**
         *
         * @return
         * The paymentMethod
         */
        public List<PaymentMethod> getPaymentMethod() {
            return paymentMethod;
        }

        /**
         *
         * @param paymentMethod
         * The payment_method
         */
        public void setPaymentMethod(List<PaymentMethod> paymentMethod) {
            this.paymentMethod = paymentMethod;
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

    public class Detail_ {

        @SerializedName("banks")
        @Expose
        private List<Bank> banks = new ArrayList<Bank>();

        /**
         *
         * @return
         * The banks
         */
        public List<Bank> getBanks() {
            return banks;
        }

        /**
         *
         * @param banks
         * The banks
         */
        public void setBanks(List<Bank> banks) {
            this.banks = banks;
        }

    }

    public class PaymentMethod {

        @SerializedName("method_id")
        @Expose
        private Integer methodId;
        @SerializedName("method_code")
        @Expose
        private String methodCode;
        @SerializedName("method_name")
        @Expose
        private String methodName;
        @SerializedName("method_description")
        @Expose
        private String methodDescription;
        @SerializedName("enable")
        @Expose
        private Boolean enable;
        @SerializedName("detail")
        @Expose
        private Detail_ detail;

        /**
         *
         * @return
         * The methodId
         */
        public Integer getMethodId() {
            return methodId;
        }

        /**
         *
         * @param methodId
         * The method_id
         */
        public void setMethodId(Integer methodId) {
            this.methodId = methodId;
        }

        /**
         *
         * @return
         * The methodCode
         */
        public String getMethodCode() {
            return methodCode;
        }

        /**
         *
         * @param methodCode
         * The method_code
         */
        public void setMethodCode(String methodCode) {
            this.methodCode = methodCode;
        }

        /**
         *
         * @return
         * The methodName
         */
        public String getMethodName() {
            return methodName;
        }

        /**
         *
         * @param methodName
         * The method_name
         */
        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        /**
         *
         * @return
         * The methodDescription
         */
        public String getMethodDescription() {
            return methodDescription;
        }

        /**
         *
         * @param methodDescription
         * The method_description
         */
        public void setMethodDescription(String methodDescription) {
            this.methodDescription = methodDescription;
        }

        /**
         *
         * @return
         * The enable
         */
        public Boolean getEnable() {
            return enable;
        }

        /**
         *
         * @param enable
         * The enable
         */
        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        /**
         *
         * @return
         * The detail
         */
        public Detail_ getDetail() {
            return detail;
        }

        /**
         *
         * @param detail
         * The detail
         */
        public void setDetail(Detail_ detail) {
            this.detail = detail;
        }

    }
}
