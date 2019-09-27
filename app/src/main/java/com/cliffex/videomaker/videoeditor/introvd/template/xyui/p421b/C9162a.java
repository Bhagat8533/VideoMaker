package com.introvd.template.xyui.p421b;

import android.content.Context;
import android.util.DisplayMetrics;
import java.util.Locale;

/* renamed from: com.introvd.template.xyui.b.a */
public class C9162a {
    private static float bKM = -1.0f;
    public static boolean cfW = false;
    public static int dQd = 0;
    public static int eDQ = 0;
    public static float ecV = 1.0f;
    public static Locale mLocale = Locale.CHINESE;

    /* renamed from: O */
    public static int m26662O(Context context, int i) {
        return (int) (dpToPixel(context, (float) i) + 0.5f);
    }

    /* renamed from: P */
    public static int m26663P(float f) {
        return (int) (((double) (f * ecV)) + 0.5d);
    }

    public static float dpToPixel(Context context, float f) {
        if (bKM < 0.0f && context != null) {
            bKM = context.getResources().getDisplayMetrics().density;
        }
        return bKM * f;
    }

    public static void init(Context context, boolean z) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        dQd = displayMetrics.widthPixels;
        eDQ = displayMetrics.heightPixels;
        ecV = displayMetrics.density;
        mLocale = context.getResources().getConfiguration().locale;
        cfW = z;
    }
}
