package com.introvd.template.sdk.utils;

import android.content.Context;
import com.introvd.template.sdk.p383c.C8398b;

/* renamed from: com.introvd.template.sdk.utils.b */
public class C8500b {
    private static float bKM = -1.0f;

    /* renamed from: O */
    public static int m24590O(Context context, int i) {
        return (int) (dpToPixel(context, (float) i) + 0.5f);
    }

    /* renamed from: P */
    public static int m24591P(float f) {
        return (int) (((double) (f * C8398b.ecV)) + 0.5d);
    }

    public static int dpFloatToPixel(Context context, float f) {
        return (int) (dpToPixel(context, f) + 0.5f);
    }

    public static float dpToPixel(Context context, float f) {
        if (bKM < 0.0f && context != null) {
            bKM = context.getResources().getDisplayMetrics().density;
        }
        return bKM * f;
    }
}
