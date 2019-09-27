package com.introvd.template.editor.widget.seekbar;

import android.content.Context;
import android.util.TypedValue;

/* renamed from: com.introvd.template.editor.widget.seekbar.e */
public class C7081e {
    /* renamed from: b */
    public static int m20784b(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    /* renamed from: c */
    public static int m20785c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
