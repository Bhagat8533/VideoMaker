package com.introvd.template.component.videofetcher.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

/* renamed from: com.introvd.template.component.videofetcher.view.e */
public class C5507e {
    private int cmQ;
    private Drawable cmR;
    private float cmS;
    private Point cmT;
    private int layerType;

    /* renamed from: mQ */
    private final Rect f3464mQ;

    /* renamed from: oS */
    private float f3465oS;
    private final Paint paint;
    private int rippleColor;
    private View targetView;

    private void aaH() {
        if (VERSION.SDK_INT > 17) {
            return;
        }
        if (this.cmS != 0.0f) {
            this.layerType = this.targetView.getLayerType();
            this.targetView.setLayerType(1, null);
            return;
        }
        this.targetView.setLayerType(this.layerType, null);
    }

    public void draw(Canvas canvas) {
        if (this.cmS != 0.0f) {
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), this.cmS, this.cmS, Direction.CW);
            canvas.clipPath(path);
        }
        canvas.drawCircle((float) this.cmT.x, (float) this.cmT.y, this.f3465oS, this.paint);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f3464mQ.set(0, 0, i, i2);
        this.cmR.setBounds(this.f3464mQ);
    }

    public void setRippleColor(int i) {
        this.rippleColor = i;
        this.paint.setColor(i);
        this.paint.setAlpha(this.cmQ);
        this.targetView.invalidate();
    }

    public void setRippleRoundedCorners(int i) {
        this.cmS = (float) i;
        aaH();
    }
}
