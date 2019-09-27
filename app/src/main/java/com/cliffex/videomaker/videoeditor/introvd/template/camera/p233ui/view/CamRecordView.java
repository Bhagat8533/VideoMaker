package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.introvd.template.camera.p233ui.view.indicator.C5189a;
import com.introvd.template.camera.p233ui.view.indicator.C5195b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.CamRecordView */
public class CamRecordView extends View {
    int bWX;
    C5195b bWY;
    int mIndicatorColor;
    Paint mPaint;

    public CamRecordView(Context context) {
        super(context);
        m14012c(null, 0);
    }

    public CamRecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14012c(attributeSet, 0);
    }

    public CamRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14012c(attributeSet, i);
    }

    /* renamed from: Yd */
    private void m14011Yd() {
        if (this.bWX == 28) {
            this.bWY = new C5189a();
        }
        this.bWY.mo26309cq(this);
    }

    /* renamed from: c */
    private void m14012c(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AVLoadingIndicatorView);
        this.bWX = obtainStyledAttributes.getInt(R.styleable.AVLoadingIndicatorView_indicator, 28);
        this.mIndicatorColor = obtainStyledAttributes.getColor(R.styleable.AVLoadingIndicatorView_indicator_color, -1);
        obtainStyledAttributes.recycle();
        this.mPaint = new Paint();
        this.mPaint.setColor(this.mIndicatorColor);
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setAntiAlias(true);
        m14011Yd();
    }

    /* renamed from: cc */
    private int m14013cc(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: Ye */
    public void mo26135Ye() {
        this.bWY.mo26306WV();
    }

    /* renamed from: Yf */
    public void mo26136Yf() {
        this.bWY.mo26296Yf();
    }

    /* renamed from: Yg */
    public void mo26137Yg() {
        this.bWY.mo26297Yg();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo26137Yg();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mo26143q(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        mo26135Ye();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m14013cc(C4583d.m11670O(getContext(), 80), i), m14013cc(C4583d.m11670O(getContext(), 80), i2));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public void mo26143q(Canvas canvas) {
        this.bWY.draw(canvas, this.mPaint);
    }

    public void setGradientColor(int i, int i2) {
        ((C5189a) this.bWY).setGradientColor(i, i2);
        invalidate();
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 8 || i == 4) {
                mo26137Yg();
            } else {
                mo26136Yf();
            }
        }
    }
}
