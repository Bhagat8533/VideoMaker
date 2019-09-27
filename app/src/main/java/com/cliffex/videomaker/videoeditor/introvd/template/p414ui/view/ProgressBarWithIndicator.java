package com.introvd.template.p414ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.introvd.template.p203b.C4580b;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.view.ProgressBarWithIndicator */
public class ProgressBarWithIndicator extends ProgressBar {
    private Bitmap eyC;
    private int eyD = -1;
    private float eyE = 10.0f;
    private Paint mPaint;
    private int mTxtColor = -1;

    public ProgressBarWithIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26363f(context.obtainStyledAttributes(attributeSet, C10122R.styleable.ProgressBarWithIndicator));
        aNa();
    }

    private void aNa() {
        int i;
        int i2 = 0;
        if (this.eyC != null) {
            i2 = this.eyC.getWidth() / 2;
            i = this.eyC.getHeight();
        } else {
            i = 0;
        }
        int max = Math.max(getPaddingTop(), i);
        if (VERSION.SDK_INT >= 17) {
            setPaddingRelative(Math.max(getPStart(), i2), max, Math.max(getPEnd(), i2), getPaddingBottom());
        } else {
            setPadding(Math.max(getPStart(), i2), max, Math.max(getPEnd(), i2), getPaddingBottom());
        }
    }

    /* renamed from: f */
    private void m26363f(TypedArray typedArray) {
        this.mTxtColor = typedArray.getColor(C10122R.styleable.ProgressBarWithIndicator_progress_text_color, this.mTxtColor);
        this.eyE = typedArray.getDimension(C10122R.styleable.ProgressBarWithIndicator_progress_text_size, this.eyE);
        int resourceId = typedArray.getResourceId(C10122R.styleable.ProgressBarWithIndicator_indicator_src, C10122R.C10123drawable.v5_xiaoying_ve_basic_tool_bubble);
        if (resourceId > 0) {
            this.eyC = BitmapFactory.decodeResource(getResources(), resourceId);
        }
        typedArray.recycle();
        this.eyD = (getWidth() - getPStart()) - getPEnd();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.mTxtColor);
        this.mPaint.setTextSize(this.eyE);
    }

    private int getDrawableStartPos() {
        int width = this.eyC.getWidth() / 2;
        if (this.eyD <= 0) {
            this.eyD = (getWidth() - getPStart()) - getPEnd();
        }
        return (((this.eyD * (C4580b.m11666qi() ? getMax() - getProgress() : getProgress())) / getMax()) + getPStart()) - width;
    }

    private int getDrawableTopPos() {
        return 0;
    }

    private int getPEnd() {
        return VERSION.SDK_INT >= 17 ? getPaddingEnd() : getPaddingRight();
    }

    private int getPStart() {
        return VERSION.SDK_INT >= 17 ? getPaddingStart() : getPaddingLeft();
    }

    private int getTextTopPos() {
        return (int) ((((float) ((this.eyC.getHeight() * 10) / 13)) - (this.eyE / 2.0f)) + ((float) getDrawableTopPos()));
    }

    /* renamed from: qY */
    private int m26364qY(String str) {
        return (int) (((float) getDrawableStartPos()) + ((((float) this.eyC.getWidth()) - this.mPaint.measureText(str)) / 2.0f));
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawBitmap(this.eyC, (float) getDrawableStartPos(), (float) getDrawableTopPos(), this.mPaint);
        StringBuilder sb = new StringBuilder();
        sb.append(getProgress());
        sb.append("%");
        String sb2 = sb.toString();
        canvas.drawText(sb2, (float) m26364qY(sb2), (float) getTextTopPos(), this.mPaint);
        canvas.restore();
    }

    public synchronized void setProgress(int i) {
        invalidate();
        super.setProgress(i);
    }
}
