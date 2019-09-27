package com.introvd.template.component.videofetcher.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/* renamed from: com.introvd.template.component.videofetcher.utils.d */
public class C5486d {
    private static float bKM = -1.0f;
    private static MSize cmx;

    /* renamed from: O */
    public static int m14894O(Context context, int i) {
        return (int) (dpToPixel(context, (float) i) + 0.5f);
    }

    public static float dpToPixel(Context context, float f) {
        if (bKM < 0.0f && context != null) {
            bKM = context.getResources().getDisplayMetrics().density;
        }
        return bKM * f;
    }

    /* renamed from: el */
    public static MSize m14895el(Context context) {
        if (cmx != null) {
            return cmx;
        }
        if (context == null) {
            C5489g.m14902d("ruomiz", "ctx = null ScreenSize : (0,0)");
            return new MSize(0, 0);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.heightPixels;
        if (C5497k.m14920em(context)) {
            i -= C5499m.getStatusBarHeight(context);
        }
        cmx = new MSize(displayMetrics.widthPixels, i);
        StringBuilder sb = new StringBuilder();
        sb.append("ScreenSize Init : ");
        sb.append(cmx);
        C5489g.m14902d("ruomiz", sb.toString());
        return cmx;
    }
}
