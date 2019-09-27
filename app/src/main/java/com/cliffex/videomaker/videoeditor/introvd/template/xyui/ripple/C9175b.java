package com.introvd.template.xyui.ripple;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;

/* renamed from: com.introvd.template.xyui.ripple.b */
public class C9175b {
    /* renamed from: N */
    public static Drawable m26701N(Drawable drawable) {
        int parseColor = Color.parseColor("#ffaaaaaa");
        if (VERSION.SDK_INT >= 21) {
            return new RippleDrawable(ColorStateList.valueOf(m26702a(parseColor, 0.2d)), drawable, drawable);
        }
        Drawable[] drawableArr = {drawable, new ColorDrawable(m26702a(parseColor, 0.2d))};
        Drawable[] drawableArr2 = {drawable, new ColorDrawable(m26702a(parseColor, 0.4d))};
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new LayerDrawable(drawableArr));
        stateListDrawable.addState(new int[]{16842908}, new LayerDrawable(drawableArr2));
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    /* renamed from: a */
    private static int m26702a(int i, double d) {
        return m26705d(i, d) ? m26703b(i, d) : m26704c(i, d);
    }

    /* renamed from: b */
    private static int m26703b(int i, double d) {
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        return Color.argb(Color.alpha(i), m26710g(red, d), m26710g(green, d), m26710g(blue, d));
    }

    /* renamed from: c */
    private static int m26704c(int i, double d) {
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        return Color.argb(Color.alpha(i), m26709f(red, d), m26709f(green, d), m26709f(blue, d));
    }

    /* renamed from: d */
    private static boolean m26705d(int i, double d) {
        return m26708e(Color.red(i), d) && m26708e(Color.green(i), d) && m26708e(Color.blue(i), d);
    }

    /* renamed from: dU */
    public static Drawable m26706dU(int i, int i2) {
        if (VERSION.SDK_INT < 21) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(m26702a(i, 0.2d)));
            stateListDrawable.addState(new int[]{16842908}, new ColorDrawable(m26702a(i, 0.4d)));
            stateListDrawable.addState(new int[0], new ColorDrawable(i));
            return stateListDrawable;
        }
        ColorStateList valueOf = ColorStateList.valueOf(m26702a(i, 0.2d));
        Drawable dV = m26707dV(i, i2);
        return new RippleDrawable(valueOf, dV, dV);
    }

    /* renamed from: dV */
    private static Drawable m26707dV(int i, int i2) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, (float) i2);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    /* renamed from: e */
    private static boolean m26708e(int i, double d) {
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        double d2 = (double) red;
        if (d2 + (d2 * d) < 255.0d) {
            double d3 = (double) green;
            if (d3 + (d3 * d) < 255.0d) {
                double d4 = (double) blue;
                if (d4 + (d * d4) < 255.0d) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    private static int m26709f(int i, double d) {
        double d2 = (double) i;
        return (int) Math.max(d2 - (d * d2), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    /* renamed from: g */
    private static int m26710g(int i, double d) {
        double d2 = (double) i;
        return (int) Math.min(d2 + (d * d2), 255.0d);
    }
}
