package com.introvd.template.p203b;

import android.content.Context;
import android.util.TypedValue;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.Constants;

/* renamed from: com.introvd.template.b.d */
public class C4583d {
    private static float bKM = -1.0f;

    /* renamed from: O */
    public static int m11670O(Context context, int i) {
        return (int) (dpToPixel(context, (float) i) + 0.5f);
    }

    /* renamed from: P */
    public static int m11671P(float f) {
        return (int) (((double) (f * Constants.getDeviceDensity())) + 0.5d);
    }

    /* renamed from: a */
    public static int m11672a(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
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

    /* renamed from: ii */
    public static int m11673ii(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, VivaBaseApplication.m8749FZ().getResources().getDisplayMetrics());
    }
}
