package com.introvd.template.module.p339c;

import android.content.Context;
import android.util.DisplayMetrics;
import com.introvd.template.module.iap.C8048e;

/* renamed from: com.introvd.template.module.c.a */
public class C7689a {
    private static DisplayMetrics aAo;

    static {
        init();
    }

    /* renamed from: P */
    public static int m22595P(float f) {
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

    /* renamed from: aQ */
    public static float m22596aQ(float f) {
        return aAz().density * f;
    }

    /* renamed from: aR */
    public static int m22597aR(float f) {
        return (int) (m22596aQ(f) + 0.5f);
    }

    /* renamed from: aS */
    public static int m22598aS(float f) {
        return (int) ((f / aAz().scaledDensity) + 0.5f);
    }

    /* renamed from: ii */
    public static int m22599ii(int i) {
        return (int) (m22596aQ((float) i) + 0.5f);
    }

    private static void init() {
        Context context = C8048e.aBe().getContext();
        if (context != null) {
            aAo = context.getResources().getDisplayMetrics();
        }
    }
}
