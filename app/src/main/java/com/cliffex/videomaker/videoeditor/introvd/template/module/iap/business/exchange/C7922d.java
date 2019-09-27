package com.introvd.template.module.iap.business.exchange;

import com.p131c.p132a.p135c.C2575a;

/* renamed from: com.introvd.template.module.iap.business.exchange.d */
public class C7922d {
    public String code;
    public String message;

    public C7922d(String str, String str2) {
        this.code = str;
        this.message = str2;
    }

    public boolean aDa() {
        return C2575a.parseInt(this.code) == 0;
    }
}
