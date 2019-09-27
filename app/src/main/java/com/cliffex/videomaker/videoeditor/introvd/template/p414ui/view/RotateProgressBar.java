package com.introvd.template.p414ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* renamed from: com.introvd.template.ui.view.RotateProgressBar */
public class RotateProgressBar extends ProgressBar {
    protected int cbA = 0;
    protected int ezi = 200;
    protected int ezj = 21;

    public RotateProgressBar(Context context) {
        super(context);
    }

    public RotateProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RotateProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        int i = this.cbA;
        if (i == 0) {
            canvas.rotate(0.0f);
            canvas.translate(0.0f, 0.0f);
        } else if (i == 90) {
            canvas.rotate(-90.0f);
            canvas.translate((float) (-getHeight()), 0.0f);
        } else if (i == 180) {
            canvas.rotate(180.0f);
            canvas.translate((float) (-getWidth()), (float) (-getHeight()));
        } else if (i == 270) {
            canvas.rotate(90.0f);
            canvas.translate(0.0f, (float) (-getWidth()));
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.cbA == 90 || this.cbA == 270) {
            super.onSizeChanged(i2, i, i4, i3);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    public void setBarParams(int i, int i2) {
        this.ezi = i;
        this.ezj = i2;
    }

    public void setDegree(int i) {
        this.cbA = i;
    }

    public synchronized void setProgress(int i) {
        super.setProgress(i);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        invalidate();
    }
}
