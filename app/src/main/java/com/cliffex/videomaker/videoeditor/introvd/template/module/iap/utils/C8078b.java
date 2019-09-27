package com.introvd.template.module.iap.utils;

import android.text.TextUtils;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/* renamed from: com.introvd.template.module.iap.utils.b */
public final class C8078b {
    private static NumberFormat dVW;

    /* renamed from: a */
    public static BigDecimal m23439a(double d, double d2) {
        return new BigDecimal(d).multiply(new BigDecimal(d2)).setScale(2, 1);
    }

    /* renamed from: aP */
    public static String m23440aP(long j) {
        if (dVW == null) {
            dVW = NumberFormat.getCurrencyInstance(Locale.CHINA);
        }
        return m23443lS(dVW.format(m23439a((double) j, 0.01d).doubleValue()));
    }

    /* renamed from: b */
    public static String m23441b(double d, double d2) {
        BigDecimal scale = new BigDecimal(d).multiply(new BigDecimal(d2)).multiply(BigDecimal.valueOf(0.01d)).setScale(2, 1);
        return scale.compareTo(BigDecimal.ZERO) <= 0 ? "0" : m23443lS(scale.toString());
    }

    /* renamed from: j */
    public static String m23442j(double d) {
        BigDecimal a = m23439a(d, 0.01d);
        return a.compareTo(BigDecimal.ZERO) <= 0 ? "0" : m23443lS(a.toString());
    }

    /* renamed from: lS */
    public static String m23443lS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.replaceAll("0+?$", "").replaceAll("[.]$", "").trim();
    }
}
