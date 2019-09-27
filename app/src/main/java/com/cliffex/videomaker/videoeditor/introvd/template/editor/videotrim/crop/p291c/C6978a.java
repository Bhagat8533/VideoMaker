package com.introvd.template.editor.videotrim.crop.p291c;

import android.graphics.RectF;

/* renamed from: com.introvd.template.editor.videotrim.crop.c.a */
public class C6978a {
    /* renamed from: G */
    public static float m20402G(float f, float f2) {
        return f2 * f;
    }

    /* renamed from: H */
    public static float m20403H(float f, float f2) {
        return f / f2;
    }

    /* renamed from: k */
    public static float m20404k(float f, float f2, float f3, float f4) {
        return (f3 - f) / (f4 - f2);
    }

    /* renamed from: k */
    public static float m20405k(RectF rectF) {
        return rectF.width() / rectF.height();
    }

    /* renamed from: l */
    public static float m20406l(float f, float f2, float f3, float f4) {
        return f2 - (f4 * (f3 - f));
    }

    /* renamed from: m */
    public static float m20407m(float f, float f2, float f3, float f4) {
        return f3 - ((f2 - f) / f4);
    }

    /* renamed from: n */
    public static float m20408n(float f, float f2, float f3, float f4) {
        return (f4 * (f3 - f2)) + f;
    }

    /* renamed from: o */
    public static float m20409o(float f, float f2, float f3, float f4) {
        return ((f3 - f) / f4) + f2;
    }
}
