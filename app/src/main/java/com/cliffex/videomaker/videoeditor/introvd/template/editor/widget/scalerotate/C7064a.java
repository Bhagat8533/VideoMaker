package com.introvd.template.editor.widget.scalerotate;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.introvd.template.editor.widget.scalerotate.a */
public class C7064a {
    /* renamed from: a */
    public static double m20674a(float f, float f2, float f3, float f4, float f5) {
        double d;
        if (f == f3 && f2 == f4) {
            d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            double atan2 = Math.atan2((double) (f - f3), (double) (f2 - f4));
            if (f5 > 0.0f) {
                return (double) (f5 * ((float) Math.round(atan2 / ((double) f5))));
            }
            d = m20676d(m20678e(atan2));
        }
        return d;
    }

    /* renamed from: c */
    public static double m20675c(float[] fArr, float[] fArr2) {
        return m20674a(fArr[0], fArr[1], fArr2[0], fArr2[1], 0.0f);
    }

    /* renamed from: d */
    public static double m20676d(double d) {
        return d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (d % -360.0d) + 360.0d : d % 360.0d;
    }

    /* renamed from: d */
    public static double m20677d(float[] fArr, float[] fArr2) {
        return m20679q(fArr[0], fArr[1], fArr2[0], fArr2[1]);
    }

    /* renamed from: e */
    public static double m20678e(double d) {
        return d * 57.29577951308232d;
    }

    /* renamed from: q */
    public static double m20679q(float f, float f2, float f3, float f4) {
        return Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d));
    }
}
