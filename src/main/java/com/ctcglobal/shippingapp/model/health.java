package com.ctcglobal.shippingapp.model;

import com.google.gson.annotations.SerializedName;

public class health {
    @SerializedName("App Status")
    private String status;

    public health (String status)
    {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
