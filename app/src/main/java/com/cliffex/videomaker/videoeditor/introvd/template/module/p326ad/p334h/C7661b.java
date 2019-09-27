package com.introvd.template.module.p326ad.p334h;

import android.content.Context;
import android.util.DisplayMetrics;
import com.introvd.template.module.p326ad.C7678j;

/* renamed from: com.introvd.template.module.ad.h.b */
public class C7661b {
    private static DisplayMetrics aAo;

    static {
        init();
    }

    /* renamed from: P */
    public static int m22483P(float f) {
        return (int) (((double) (f * aAz().density)) + 0.5d);
    }

    public static DisplayMetrics aAz() {
        if (aAo == null) {
            init();
        }
        if (aAo == null) {
            aAo = new DisplayMetrics();
        }
        return aAo;
    }

    private static void init() {
        Context context = C7678j.aAd().getContext();
        if (context != null) {
            aAo = context.getResources().getDisplayMetrics();
        }
    }
}
