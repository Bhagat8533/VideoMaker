package com.introvd.template.module.p326ad.p328b;

import android.text.TextUtils;
import com.introvd.template.common.LogUtils;
import java.util.HashMap;

/* renamed from: com.introvd.template.module.ad.b.c */
public final class C7593c {
    private static final HashMap<String, String> dMz = new HashMap<>();

    /* renamed from: b */
    public static void m22383b(String str, String str2, String... strArr) {
        dMz.put(m22385d(str2, strArr), str);
    }

    /* renamed from: c */
    public static String m22384c(String str, String... strArr) {
        String str2 = (String) dMz.get(m22385d(str, strArr));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("    ");
        sb.append(str2);
        LogUtils.m14222e("EventGlobalLogHelper", sb.toString());
        return TextUtils.isEmpty(str2) ? "unknown" : str2;
    }

    /* renamed from: d */
    static String m22385d(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        for (String append : strArr) {
            sb.append(append);
        }
        return sb.toString();
    }
}
