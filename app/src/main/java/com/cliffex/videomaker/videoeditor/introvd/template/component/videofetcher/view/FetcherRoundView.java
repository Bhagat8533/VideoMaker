package com.introvd.template.component.videofetcher.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.p021v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.utils.C5486d;

public class FetcherRoundView extends View {
    private int caL;
    private Rect cmO;
    private String cmP;

    /* renamed from: ei */
    private int f3462ei;

    /* renamed from: ej */
    private int f3463ej;
    private Paint mPaint;
    private String mText;
    private int mTextSize;
    private int maxEms;

    public FetcherRoundView(Context context) {
        this(context, null);
    }

    public FetcherRoundView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FetcherRoundView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_ff5e13));
        this.mPaint.setAntiAlias(true);
        this.mText = getResources().getString(R.string.video_fetcher_str_download);
        this.mTextSize = C5486d.m14894O(getContext(), 14);
        int O = C5486d.m14894O(getContext(), 1);
        this.f3463ej = C5486d.m14894O(getContext(), 100);
        this.f3462ei = C5486d.m14894O(getContext(), 26);
        this.mPaint.setStrokeWidth((float) O);
        this.mPaint.setTextSize((float) this.mTextSize);
        this.cmO = new Rect();
        this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), this.cmO);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_ff5e13));
        this.mPaint.setStyle(Style.STROKE);
        canvas.drawRoundRect(new RectF(this.mPaint.getStrokeWidth(), this.mPaint.getStrokeWidth(), ((float) getMeasuredWidth()) - this.mPaint.getStrokeWidth(), ((float) getMeasuredHeight()) - this.mPaint.getStrokeWidth()), (float) this.caL, (float) this.caL, this.mPaint);
        FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
        int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + fontMetricsInt.top) / 2) - fontMetricsInt.top;
        this.mPaint.setStyle(Style.FILL);
        if (!TextUtils.isEmpty(this.cmP)) {
            Rect rect = new Rect();
            this.mPaint.getTextBounds(this.cmP, 0, this.cmP.length(), rect);
            canvas.drawText(this.cmP, (float) ((getMeasuredWidth() / 2) - (rect.width() / 2)), (float) measuredHeight, this.mPaint);
            return;
        }
        if (this.maxEms != 0) {
            this.mText = this.mText.substring(0, this.maxEms);
            this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), this.cmO);
        }
        canvas.drawText(this.mText, ((float) ((getMeasuredWidth() / 2) - (this.cmO.width() / 2))) - this.mPaint.getStrokeWidth(), (float) measuredHeight, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), this.cmO);
            float width = (float) this.cmO.width();
            float paddingLeft = (float) ((this.f3463ej - getPaddingLeft()) - getPaddingRight());
            if (width > paddingLeft) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.mText.length()) {
                        break;
                    } else if (this.mPaint.measureText(this.mText, 0, i3) > paddingLeft) {
                        this.maxEms = i3 - 1;
                        break;
                    } else {
                        i3++;
                    }
                }
                width = paddingLeft;
            }
            i = (int) (width + ((float) getPaddingLeft()) + ((float) getPaddingRight()));
        }
        if (mode2 != 1073741824) {
            this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), this.cmO);
            i2 = (int) (((float) this.cmO.height()) + ((float) getPaddingTop()) + ((float) getPaddingBottom()));
        }
        if (i2 < this.f3462ei) {
            i2 = this.f3462ei;
        }
        this.caL = Math.min(i, i2) / 2;
        setMeasuredDimension(i, i2);
    }

    public void setText(String str) {
        if (this.mText == null || !str.equals(this.mText)) {
            this.cmP = str;
        } else {
            this.cmP = null;
        }
        invalidate();
    }
}
