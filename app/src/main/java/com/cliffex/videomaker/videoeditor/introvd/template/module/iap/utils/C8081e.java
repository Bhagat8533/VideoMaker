package com.introvd.template.module.iap.utils;

import android.text.TextUtils;
import com.p131c.p132a.p135c.C2575a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.introvd.template.module.iap.utils.e */
public class C8081e {
    private static final Pattern dVX = Pattern.compile("P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);

    /* renamed from: lW */
    public static int m23450lW(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Matcher matcher = dVX.matcher(str);
        if (matcher.lookingAt()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            String group4 = matcher.group(4);
            i = (m23454ma(group) * 365) + (m23454ma(group2) * 30) + (m23454ma(group3) * 7) + m23454ma(group4);
        }
        return i;
    }

    /* renamed from: lX */
    public static int m23451lX(String str) {
        return m23450lW(str) / 7;
    }

    /* renamed from: lY */
    public static int m23452lY(String str) {
        return m23450lW(str) / 30;
    }

    /* renamed from: lZ */
    public static int m23453lZ(String str) {
        return m23450lW(str) / 365;
    }

    /* renamed from: ma */
    private static int m23454ma(String str) {
        return C2575a.parseInt(str);
    }
}
