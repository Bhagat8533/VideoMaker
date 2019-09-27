package com.introvd.template.module.iap.business;

import android.util.SparseArray;

/* renamed from: com.introvd.template.module.iap.business.a */
public class C7824a {
    private static final SparseArray<String> dPg = new SparseArray<>();

    static {
        dPg.put(5, "vip_month");
        dPg.put(6, "vip_year");
        dPg.put(7, "vip_normal");
        dPg.put(8, "vip_subscription");
    }

    /* renamed from: si */
    public static String m22802si(int i) {
        return (String) dPg.get(i);
    }
}
