package com.introvd.template.router.user.model;

import android.support.annotation.Keep;

@Keep
public class UserBusinessInfo {
    public BusinessInfo backdrop;
    public BusinessInfo headBorder;
    public BusinessInfo starEffect;

    @Keep
    public static class BusinessInfo {
        public String expireTime;
        public String url;
    }
}
