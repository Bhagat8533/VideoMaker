package com.introvd.template.sdk.utils;

import android.graphics.Rect;
import android.graphics.RectF;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.sdk.utils.q */
public class C8562q {
    /* renamed from: a */
    public static Rect m25042a(RectF rectF, int i, int i2) {
        if (rectF == null || i <= 0 || i2 <= 0) {
            return null;
        }
        Rect rect = new Rect();
        rect.left = m25044b(rectF.left, i, 10000);
        rect.top = m25044b(rectF.top, i2, 10000);
        rect.right = m25044b(rectF.right, i, 10000);
        rect.bottom = m25044b(rectF.bottom, i2, 10000);
        return rect;
    }

    /* renamed from: a */
    public static QRect m25043a(QRect qRect, int i, int i2, int i3) {
        if (qRect == null) {
            return null;
        }
        QRect qRect2 = new QRect();
        if (i == 90) {
            qRect2.set(i2 - qRect.bottom, qRect.left, i3 - qRect.top, qRect.right);
        } else if (i == 180) {
            qRect2.set(i2 - qRect.right, i3 - qRect.bottom, i2 - qRect.left, i3 - qRect.top);
        } else if (i != 270) {
            qRect2.set(qRect.left, qRect.top, qRect.right, qRect.bottom);
        } else {
            qRect2.set(qRect.top, i2 - qRect.right, qRect.bottom, i2 - qRect.left);
        }
        return qRect2;
    }

    /* renamed from: b */
    public static int m25044b(float f, int i, int i2) {
        if (i == 0) {
            return 0;
        }
        return Math.round((f * ((float) i2)) / ((float) i));
    }
}
