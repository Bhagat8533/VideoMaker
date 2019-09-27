package com.introvd.template.editor.widget.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.introvd.template.p203b.C4583d;

public class CircleBubbleView extends View {

    /* renamed from: AA */
    private Path f3528AA;
    private int cbc;
    private float dtl;
    private float dtm;
    private float dtn;
    private float dto;
    private String dtp;
    private Context mContext;
    private int mIndicatorColor;
    private Paint mPaint;

    CircleBubbleView(Context context, float f, int i, int i2, String str) {
        super(context, null, 0);
        this.mContext = context;
        this.dtl = f;
        this.cbc = i;
        this.mIndicatorColor = i2;
        m20740eg(str);
    }

    private void auT() {
        this.f3528AA = new Path();
        this.f3528AA.arcTo(new RectF(0.0f, 0.0f, this.dtm, this.dtm), 135.0f, 270.0f);
        this.f3528AA.lineTo(this.dtm / 2.0f, this.dtn);
        this.f3528AA.close();
    }

    /* renamed from: eg */
    private void m20740eg(String str) {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setTextAlign(Align.CENTER);
        this.mPaint.setTextSize(this.dtl);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(str, 0, str.length(), rect);
        this.dtm = (float) (rect.width() + C4583d.m11670O(this.mContext, 4));
        float O = (float) C4583d.m11670O(this.mContext, 36);
        if (this.dtm < O) {
            this.dtm = O;
        }
        this.dto = (float) rect.height();
        this.dtn = this.dtm * 1.2f;
        auT();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mIndicatorColor);
        canvas.drawPath(this.f3528AA, this.mPaint);
        this.mPaint.setColor(this.cbc);
        canvas.drawText(this.dtp, this.dtm / 2.0f, (this.dtn / 2.0f) + (this.dto / 4.0f), this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.dtm, (int) this.dtn);
    }

    /* access modifiers changed from: 0000 */
    public void setProgress(String str) {
        this.dtp = str;
        invalidate();
    }
}
