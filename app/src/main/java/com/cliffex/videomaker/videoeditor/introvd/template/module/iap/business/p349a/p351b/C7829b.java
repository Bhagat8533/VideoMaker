package com.introvd.template.module.iap.business.p349a.p351b;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.introvd.template.module.iap.business.a.b.b */
public class C7829b {
    @SerializedName("effective")
    private int dSg;
    private String endTime;
    @SerializedName("vipType")
    private final String goodsId;

    public String aCH() {
        return this.goodsId;
    }

    public String aCK() {
        return this.endTime;
    }

    public boolean isValid() {
        return this.dSg == 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DomesticPurchase{goodsId='");
        sb.append(this.goodsId);
        sb.append('\'');
        sb.append(", endTime='");
        sb.append(this.endTime);
        sb.append('\'');
        sb.append(", validFlag=");
        sb.append(this.dSg);
        sb.append('}');
        return sb.toString();
    }
}
