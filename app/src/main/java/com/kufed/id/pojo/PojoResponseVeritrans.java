package com.kufed.id.pojo;

/**
 * Created by macbook on 8/11/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoResponseVeritrans {

    @SerializedName("status_code")
    @Expose
    private String statusCode;
    @SerializedName("status_message")
    @Expose
    private String statusMessage;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     *
     * @return
     * The statusCode
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     *
     * @param statusCode
     * The status_code
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     *
     * @return
     * The statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     *
     * @param statusMessage
     * The status_message
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

}
