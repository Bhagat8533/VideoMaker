package com.introvd.template.module.iap.utils;

import android.graphics.Paint;
import android.widget.TextView;
import com.introvd.template.module.p339c.C7689a;

/* renamed from: com.introvd.template.module.iap.utils.a */
public final class C8073a {
    /* renamed from: a */
    private static float m23429a(Paint paint, float f, String str, int i) {
        paint.setTextSize(f);
        return ((float) i) > paint.measureText(str) ? f : m23429a(paint, f - 1.0f, str, i);
    }

    /* renamed from: h */
    public static int m23430h(TextView textView) {
        String charSequence = textView.getText().toString();
        Paint paint = new Paint();
        float textSize = textView.getTextSize();
        int measuredWidth = textView.getMeasuredWidth() - (textView.getPaddingLeft() + textView.getPaddingRight());
        return measuredWidth <= 0 ? C7689a.m22598aS(textSize) : C7689a.m22598aS(m23429a(paint, textSize, charSequence, measuredWidth));
    }
}
