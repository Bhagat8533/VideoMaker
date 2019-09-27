package com.introvd.template.gallery.view.p315a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.TypedValue;

/* renamed from: com.introvd.template.gallery.view.a.b */
public class C7510b {
    /* renamed from: ge */
    public static Paint m22224ge(Context context) {
        float applyDimension = TypedValue.applyDimension(1, 3.0f, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#AAFFFFFF"));
        paint.setStrokeWidth(applyDimension);
        paint.setStyle(Style.STROKE);
        return paint;
    }

    /* renamed from: gf */
    public static Paint m22225gf(Context context) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#B0000000"));
        return paint;
    }
}
