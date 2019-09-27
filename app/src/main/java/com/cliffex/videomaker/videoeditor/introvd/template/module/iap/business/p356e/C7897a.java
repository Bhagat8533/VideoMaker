package com.introvd.template.module.iap.business.p356e;

import android.text.TextUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.router.user.UserServiceProxy;
import java.util.HashMap;

/* renamed from: com.introvd.template.module.iap.business.e.a */
public final class C7897a {
    private static final HashMap<String, String> dMz = new HashMap<>();

    public static void aDf() {
        if (!C8048e.aBe().isInChina() || UserServiceProxy.isLogin()) {
            m23022b("click", "iap_restore_click", new String[0]);
        }
    }

    /* renamed from: b */
    public static void m23022b(String str, String str2, String... strArr) {
        dMz.put(m23025d(str2, strArr), str);
    }

    /* renamed from: c */
    public static String m23023c(String str, String str2, String... strArr) {
        String str3 = (String) dMz.get(m23025d(str, strArr));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("    ");
        sb.append(str3);
        LogUtils.m14222e("EventGlobalLogHelperIAP", sb.toString());
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    /* renamed from: c */
    public static String m23024c(String str, String... strArr) {
        return m23023c(str, "unknown", strArr);
    }

    /* renamed from: d */
    static String m23025d(String str, String... strArr) {
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

    /* renamed from: f */
    public static String m23026f(String str, String... strArr) {
        return (String) dMz.remove(m23025d(str, strArr));
    }

    /* renamed from: g */
    public static String m23027g(String str, String... strArr) {
        String str2 = (String) dMz.remove(m23025d(str, strArr));
        return TextUtils.isEmpty(str2) ? "unknown" : str2;
    }
}
