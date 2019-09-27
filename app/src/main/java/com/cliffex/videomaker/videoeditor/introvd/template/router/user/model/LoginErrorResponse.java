package com.introvd.template.router.user.model;

import android.support.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class LoginErrorResponse {
    @SerializedName("errorCode")
    public int errorCode;
    public String errorMsg;

    public LoginErrorResponse(int i) {
        this.errorCode = i;
    }
}
