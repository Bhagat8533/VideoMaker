package com.introvd.template.module.iap.p361c;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.introvd.template.module.iap.c.c */
public class C8044c {
    @SerializedName("eventCurrency")
    public String dRW;
    @SerializedName("signedData")
    public final String dWq;
    @SerializedName("afRevenue")
    public String dWr;
    @SerializedName("advertisingId")
    public String dWs;
    @SerializedName("appsflyerId")
    public String dWt;
    @SerializedName("signature")
    public final String signature;

    public C8044c(String str, String str2) {
        this.signature = str;
        this.dWq = str2;
    }
}
