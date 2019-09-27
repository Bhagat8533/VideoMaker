package com.introvd.template.module.iap.business.coupon;

import android.content.Context;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.coupon.i */
public final class C7868i {
    static {
        C7858e.m22915a(null);
    }

    /* renamed from: bZ */
    private static boolean m22932bZ(Context context, String str) {
        if (!C7869j.m22934lc(str)) {
            return false;
        }
        return CouponShowActivity.m22880a(context, str, C7858e.m22922kY(str));
    }

    /* renamed from: gp */
    public static boolean m22933gp(Context context) {
        List<String> aCk = C7858e.aCk();
        boolean z = false;
        if (C7858e.isEmpty()) {
            C7869j.clear();
            return false;
        }
        for (String bZ : aCk) {
            z = m22932bZ(context, bZ);
            if (z) {
                break;
            }
        }
        return z;
    }
}
