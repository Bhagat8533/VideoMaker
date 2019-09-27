package com.introvd.template.p414ui.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;

/* renamed from: com.introvd.template.ui.dialog.i */
public final class C8966i {

    /* renamed from: com.introvd.template.ui.dialog.i$a */
    public enum C8968a {
        POSITIVE,
        NEUTRAL,
        NEGATIVE
    }

    /* renamed from: com.introvd.template.ui.dialog.i$b */
    public enum C8969b {
        LIGHT,
        DARK
    }

    /* renamed from: a */
    public static int m26326a(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getColor(0, i2);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private static int m26327a(C8972k kVar) {
        switch (kVar) {
            case CENTER:
                return 1;
            case END:
                return 2;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public static C8972k m26328a(Context context, int i, C8972k kVar) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            switch (obtainStyledAttributes.getInt(0, m26327a(kVar))) {
                case 1:
                    C8972k kVar2 = C8972k.CENTER;
                    obtainStyledAttributes.recycle();
                    return kVar2;
                case 2:
                    C8972k kVar3 = C8972k.END;
                    obtainStyledAttributes.recycle();
                    return kVar3;
                default:
                    return C8972k.START;
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public static void m26329a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    /* renamed from: b */
    private static Drawable m26330b(Context context, int i, Drawable drawable) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
            if (drawable2 == null && drawable != null) {
                drawable2 = drawable;
            }
            return drawable2;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    public static boolean m26331b(Context context, int i, boolean z) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getBoolean(0, z);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: dz */
    public static boolean m26332dz(int i) {
        return 1.0d - ((((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d)) / 255.0d) >= 0.5d;
    }

    /* renamed from: e */
    public static int m26333e(int i, float f) {
        return Color.argb(Math.round(((float) Color.alpha(i)) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    /* renamed from: r */
    public static int m26334r(Context context, int i) {
        return m26326a(context, i, 0);
    }

    /* renamed from: t */
    public static String m26335t(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return (String) typedValue.string;
    }

    /* renamed from: u */
    public static Drawable m26336u(Context context, int i) {
        return m26330b(context, i, (Drawable) null);
    }
}
