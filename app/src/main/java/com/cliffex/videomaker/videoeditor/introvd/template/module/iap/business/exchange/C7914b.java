package com.introvd.template.module.iap.business.exchange;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.exchange.b */
public class C7914b {
    public String code;
    @SerializedName("data")
    public List<C7915a> dSz;
    public String message;

    /* renamed from: com.introvd.template.module.iap.business.exchange.b$a */
    public static class C7915a {
        @SerializedName("exchangeDays")
        public int days;
        @SerializedName("exchangeType")
        public int type;
    }
}
