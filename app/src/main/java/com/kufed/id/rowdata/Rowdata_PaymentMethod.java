package com.kufed.id.rowdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by macbook on 8/5/16.
 */
public class Rowdata_PaymentMethod {
    @SerializedName("method_id")
    @Expose
    public Integer methodId;
    @SerializedName("method_code")
    @Expose
    public String methodCode;
    @SerializedName("method_name")
    @Expose
    public String methodName;
    @SerializedName("method_description")
    @Expose
    public String methodDescription;
    @SerializedName("enable")
    @Expose
    public Boolean enable;

    public Rowdata_PaymentMethod(Integer methodId, String methodCode, String methodName, String methodDescription, Boolean enable) {
        this.methodId = methodId;
        this.methodCode = methodCode;
        this.methodName = methodName;
        this.methodDescription = methodDescription;
        this.enable = enable;
    }
}
