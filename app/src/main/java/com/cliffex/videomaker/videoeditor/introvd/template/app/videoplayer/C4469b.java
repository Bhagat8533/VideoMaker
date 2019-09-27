package com.introvd.template.app.videoplayer;

import android.graphics.Rect;
import android.view.View;

/* renamed from: com.introvd.template.app.videoplayer.b */
public class C4469b {
    /* renamed from: g */
    public static float m11340g(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect2 = new Rect(iArr[0], iArr[1], iArr[0] + view.getMeasuredWidth(), iArr[1] + view.getMeasuredHeight());
        if (rect.contains(rect2)) {
            return rect2.centerY() > rect.centerY() ? 2.0f - ((((float) (rect2.centerY() - rect.centerY())) * 1.0f) / ((float) rect.centerY())) : ((((float) rect2.centerY()) * 1.0f) / ((float) rect.centerY())) + 1.0f;
        }
        if (rect2.top < rect.top) {
            return (((float) (rect2.bottom - rect.top)) * 1.0f) / ((float) rect2.height());
        }
        if (rect2.bottom > rect.bottom) {
            return (((float) (rect.bottom - rect2.top)) * 1.0f) / ((float) rect2.height());
        }
        return 0.0f;
    }
}
