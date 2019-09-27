package com.introvd.template.module.iap.utils;

import android.text.TextUtils;

/* renamed from: com.introvd.template.module.iap.utils.c */
public class C8079c {
    /* renamed from: E */
    public static String m23444E(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("#");
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: lT */
    public static String m23445lT(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("#");
        if (split.length >= 2) {
            str = split[0];
        }
        return str;
    }

    /* renamed from: lU */
    public static String m23446lU(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        String[] split = str.split("#");
        String str2 = "0";
        if (split.length >= 2) {
            str2 = split[1];
        }
        return str2;
    }
}
