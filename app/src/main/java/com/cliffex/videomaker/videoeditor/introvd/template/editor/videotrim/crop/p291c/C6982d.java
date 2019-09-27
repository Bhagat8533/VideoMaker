package com.introvd.template.editor.videotrim.crop.p291c;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.introvd.template.editor.R;

/* renamed from: com.introvd.template.editor.videotrim.crop.c.d */
public class C6982d {
    /* renamed from: f */
    public static Paint m20416f(Resources resources) {
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(resources.getDimension(R.dimen.border_thickness));
        paint.setColor(resources.getColor(R.color.border));
        return paint;
    }

    /* renamed from: g */
    public static Paint m20417g(Resources resources) {
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(resources.getDimension(R.dimen.guideline_thickness));
        paint.setColor(resources.getColor(R.color.guideline));
        return paint;
    }

    /* renamed from: h */
    public static Paint m20418h(Resources resources) {
        Paint paint = new Paint();
        paint.setStyle(Style.FILL);
        paint.setColor(resources.getColor(R.color.surrounding_area));
        return paint;
    }

    /* renamed from: i */
    public static Paint m20419i(Resources resources) {
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(resources.getDimension(R.dimen.corner_thickness));
        paint.setColor(-1);
        return paint;
    }
}
