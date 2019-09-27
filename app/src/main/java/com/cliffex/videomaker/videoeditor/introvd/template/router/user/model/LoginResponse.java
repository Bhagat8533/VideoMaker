package com.introvd.template.router.user.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;

public class LoginResponse {

    /* renamed from: b */
    public String f3576b;

    /* renamed from: c */
    public CBean f3577c;

    /* renamed from: d */
    public DBean f3578d;

    /* renamed from: e */
    public EBean f3579e;
    @SerializedName("g")
    public HashMap<String, Integer> invite;
    @SerializedName("f")
    public List<String> permissionList;
    @SerializedName("a")
    public TokenBean tokenBean;

    public static class CBean {

        /* renamed from: a */
        public String f3580a;
    }

    public static class DBean {

        /* renamed from: a */
        public String f3581a;

        /* renamed from: b */
        public String f3582b;

        /* renamed from: c */
        public String f3583c;

        /* renamed from: d */
        public String f3584d;

        /* renamed from: e */
        public String f3585e;

        /* renamed from: f */
        public String f3586f;
    }

    public static class EBean {

        /* renamed from: a */
        public String f3587a;
    }

    public static class TokenBean {
        @SerializedName("a")
        public String token;
        @SerializedName("b")
        public int tokenExpireTime;
    }
}
