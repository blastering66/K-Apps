package com.kufed.id.pojo;

/**
 * Created by macbook on 6/1/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoAccessToken {
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

    public class Status {

        @SerializedName("error_messages")
        @Expose
        private String error_messages;

        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("description")
        @Expose
        private String description;

        public String getError_messages() {
            return error_messages;
        }

        public void setError_messages(String error_messages) {
            this.error_messages = error_messages;
        }

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

    public class Data {

        @SerializedName("access_token")
        @Expose
        private String accessToken;
        @SerializedName("token_type")
        @Expose
        private String tokenType;
        @SerializedName("expires_in")
        @Expose
        private Integer expiresIn;
        @SerializedName("refresh_token")
        @Expose
        private String refreshToken;

        /**
         * @return The accessToken
         */
        public String getAccessToken() {
            return accessToken;
        }

        /**
         * @param accessToken The access_token
         */
        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        /**
         * @return The tokenType
         */
        public String getTokenType() {
            return tokenType;
        }

        /**
         * @param tokenType The token_type
         */
        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        /**
         * @return The expiresIn
         */
        public Integer getExpiresIn() {
            return expiresIn;
        }

        /**
         * @param expiresIn The expires_in
         */
        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }

        /**
         * @return The refreshToken
         */
        public String getRefreshToken() {
            return refreshToken;
        }

        /**
         * @param refreshToken The refresh_token
         */
        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
    }

}