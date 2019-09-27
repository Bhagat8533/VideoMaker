package com.introvd.template.module.iap;

/* renamed from: com.introvd.template.module.iap.b */
public class C7717b {
    /* renamed from: ks */
    public static String m22629ks(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("iap.template.");
        sb.append(str);
        return sb.toString().toLowerCase();
    }

    /* renamed from: kt */
    public static String m22630kt(String str) {
        return str.substring(str.lastIndexOf(".") + 1, str.length()).toLowerCase();
    }
}
