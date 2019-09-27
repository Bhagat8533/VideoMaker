package com.introvd.template.apicore;

import android.text.TextUtils;

/* renamed from: com.introvd.template.apicore.b */
public class C3624b {
    private static volatile C3624b bhf;
    private String bcO;
    private String bdc;
    private String bhg;
    private String bhh;
    private long bhi;
    private String bhj;
    private long bhk;
    private String bhl;
    private String bhm;
    public String countryCode = "";
    private String deviceId;
    private String userId;

    /* renamed from: GC */
    public static C3624b m8865GC() {
        if (bhf == null) {
            synchronized (C3625c.class) {
                if (bhf == null) {
                    bhf = new C3624b();
                }
            }
        }
        return bhf;
    }

    /* renamed from: EI */
    public String mo22940EI() {
        return TextUtils.isEmpty(this.bcO) ? "2" : this.bcO;
    }

    /* renamed from: EJ */
    public String mo22941EJ() {
        return this.bdc;
    }

    /* renamed from: GD */
    public String mo22942GD() {
        return this.bhg;
    }

    /* renamed from: GE */
    public void mo22943GE() {
        this.userId = null;
        this.bhj = null;
        this.bhk = 0;
    }

    /* renamed from: GF */
    public void mo22944GF() {
        this.deviceId = null;
        this.bhh = null;
        this.bhi = 0;
    }

    /* renamed from: GG */
    public String mo22945GG() {
        return this.bhl;
    }

    /* renamed from: GH */
    public String mo22946GH() {
        return this.bhm;
    }

    @Deprecated
    /* renamed from: cB */
    public void mo22947cB(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.deviceId = str;
        }
    }

    /* renamed from: cC */
    public void mo22948cC(String str) {
        this.bcO = str;
    }

    /* renamed from: cD */
    public void mo22949cD(String str) {
        this.bdc = str;
    }

    /* renamed from: cU */
    public void mo22950cU(String str) {
        this.bhg = str;
    }

    @Deprecated
    /* renamed from: cV */
    public void mo22951cV(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bhh = str;
        }
    }

    /* renamed from: cW */
    public void mo22952cW(String str) {
        this.bhl = str;
    }

    /* renamed from: cX */
    public void mo22953cX(String str) {
        this.bhm = str;
    }

    @Deprecated
    public String getDeviceToken() {
        C3630h GR = C3627e.m8892GQ().mo22966GR();
        if (GR == null) {
            return null;
        }
        return GR.getDeviceToken();
    }

    @Deprecated
    public String getUserToken() {
        C3630h GR = C3627e.m8892GQ().mo22966GR();
        if (GR == null) {
            return null;
        }
        return GR.getUserToken();
    }
}
