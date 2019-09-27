package com.introvd.template.editor.widget.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.introvd.template.p203b.C4583d;

public class ArrowView extends View {

    /* renamed from: AA */
    private final Path f3527AA;
    private final int mHeight;
    private final Paint mPaint;
    private final int mWidth;

    public ArrowView(Context context) {
        this(context, null);
    }

    public ArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWidth = C4583d.m11670O(context, 12);
        this.mHeight = C4583d.m11670O(context, 7);
        this.f3527AA = new Path();
        this.f3527AA.moveTo(0.0f, 0.0f);
        this.f3527AA.lineTo((float) this.mWidth, 0.0f);
        this.f3527AA.lineTo(((float) this.mWidth) / 2.0f, (float) this.mHeight);
        this.f3527AA.close();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawPath(this.f3527AA, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    /* access modifiers changed from: 0000 */
    public void setColor(int i) {
        this.mPaint.setColor(i);
        invalidate();
    }
}
