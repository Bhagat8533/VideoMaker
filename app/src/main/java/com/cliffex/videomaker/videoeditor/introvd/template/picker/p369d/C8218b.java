package com.introvd.template.picker.p369d;

import android.content.Context;
import android.util.DisplayMetrics;

/* renamed from: com.introvd.template.picker.d.b */
public class C8218b {
    private static DisplayMetrics aAo;

    /* renamed from: O */
    public static int m23732O(Context context, int i) {
        return (int) (dpToPixel(context, (float) i) + 0.5f);
    }

    public static float dpToPixel(Context context, float f) {
        if (context == null) {
            return 0.0f;
        }
        return m23734gx(context).density * f;
    }

    /* renamed from: gH */
    public static DisplayMetrics m23733gH(Context context) {
        return context == null ? new DisplayMetrics() : m23734gx(context);
    }

    /* renamed from: gx */
    private static DisplayMetrics m23734gx(Context context) {
        if (aAo == null) {
            if (context == null) {
                aAo = new DisplayMetrics();
            } else {
                aAo = context.getResources().getDisplayMetrics();
            }
        }
        return aAo;
    }

    public static void init(Context context) {
        if (context != null) {
            aAo = context.getResources().getDisplayMetrics();
        }
    }
}
