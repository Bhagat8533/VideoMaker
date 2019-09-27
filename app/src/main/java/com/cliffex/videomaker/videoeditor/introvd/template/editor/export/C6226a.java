package com.introvd.template.editor.export;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: com.introvd.template.editor.export.a */
class C6226a extends Drawable {
    private float aaW;
    private Paint cNY;
    private Paint cNZ;
    private float cOa;
    private boolean cOb;
    private Paint mPaint = new Paint();
    private int mProgress;
    private float mStrokeWidth;

    public C6226a(int i) {
        this.mPaint.setColor(-1);
        this.mPaint.setAlpha(33);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.cNY = new Paint();
        this.cNY.setColor(-1);
        this.cNY.setAntiAlias(true);
        this.cNY.setStyle(Style.STROKE);
        this.cNZ = new Paint();
        this.cNZ.setColor(-1);
        this.cNZ.setAntiAlias(true);
        this.cOa = (float) i;
        this.mProgress = 0;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((this.cOa / 2.0f) + this.mStrokeWidth, (this.cOa / 2.0f) + this.mStrokeWidth, this.aaW - this.mStrokeWidth, this.mPaint);
        if (this.cOb) {
            float f = (float) ((this.mProgress * 360) / 100);
            Canvas canvas2 = canvas;
            canvas2.drawArc(new RectF(this.mStrokeWidth + this.mStrokeWidth, this.mStrokeWidth + this.mStrokeWidth, this.cOa, this.cOa), 270.0f, f, false, this.cNY);
            double d = (double) (this.aaW - this.mStrokeWidth);
            double d2 = (((double) f) * 3.141592653589793d) / 180.0d;
            canvas.drawCircle(((float) (Math.sin(d2) * d)) + (this.cOa / 2.0f) + this.mStrokeWidth, ((float) (((double) (this.cOa / 2.0f)) - (d * Math.cos(d2)))) + this.mStrokeWidth, this.mStrokeWidth * 2.0f, this.cNZ);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setProgress(int i) {
        this.mProgress = i;
    }

    public void setRadius(float f) {
        this.aaW = f;
    }

    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        this.mPaint.setStrokeWidth(f);
        this.cNY.setStrokeWidth(f);
    }
}
