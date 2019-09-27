package com.introvd.template.editor.clipedit.paramadjust.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.introvd.template.p203b.C4583d;

public class ParamAdjustBar extends View {
    private int bWG;
    private RectF bcc;
    private int cAa;
    private boolean cAb;
    private RectF czQ;
    private RectF czR;
    private int czS;
    private float czT;
    private float czU;
    private float czV;
    private float czW;
    private int czX;
    private int czY;
    private C5717a czZ;
    private int mHeight;
    private Paint mPaint;
    private int mPos;
    private int mProgress;
    private int mWidth;

    /* renamed from: qZ */
    private float f3481qZ;

    /* renamed from: ra */
    private float f3482ra;

    /* renamed from: com.introvd.template.editor.clipedit.paramadjust.view.ParamAdjustBar$a */
    public interface C5717a {
        /* renamed from: iD */
        void mo27944iD(int i);

        /* renamed from: lh */
        void mo27945lh(int i);
    }

    public ParamAdjustBar(Context context) {
        this(context, null);
    }

    public ParamAdjustBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ParamAdjustBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint(1);
        this.bcc = new RectF();
        this.czQ = new RectF();
        this.czR = new RectF();
        this.czS = -41453;
        this.czT = C4583d.dpToPixel(getContext(), 2.0f);
        this.czU = C4583d.dpToPixel(getContext(), 15.0f);
        this.czV = C4583d.dpToPixel(getContext(), 1.5f);
        this.czW = C4583d.dpToPixel(getContext(), 7.5f);
        this.mPos = 0;
        this.mProgress = 50;
        this.bWG = 100;
        this.czX = 0;
        this.cAb = true;
    }

    /* renamed from: a */
    private boolean m15838a(RectF rectF, float f, float f2) {
        return rectF != null && rectF.contains(f, f2);
    }

    private int getCursorColor() {
        if (this.cAa == 50) {
            if (this.mProgress == (this.czX + this.bWG) / 2) {
                return -855638017;
            }
        } else if (this.cAa == 0 && this.mProgress == 0) {
            return -855638017;
        }
        return this.czS;
    }

    /* renamed from: lg */
    private void m15839lg(int i) {
        int i2 = (int) (((float) this.mWidth) - (this.czU * 2.0f));
        float f = (float) i;
        if (f < this.czU) {
            this.mPos = (int) this.czU;
        } else if (f > ((float) this.mWidth) - this.czU) {
            this.mPos = (int) (((float) this.mWidth) - this.czU);
        } else if (Math.abs(i - (this.mWidth / 2)) < (i2 * 2) / (this.bWG - this.czX)) {
            this.mPos = this.mWidth / 2;
        } else {
            this.mPos = i;
        }
        this.mProgress = (((int) (((float) this.mPos) - this.czU)) * (this.bWG - this.czX)) / i2;
    }

    /* renamed from: x */
    private void m15840x(Canvas canvas) {
        if (this.cAa == 50) {
            int i = ((this.czX + this.bWG) / 2) + this.czY;
            if (this.mProgress < ((this.czX + this.bWG) / 2) - this.czY || this.mProgress > i) {
                this.mPaint.setColor(this.czS);
                this.mPaint.setStyle(Style.FILL);
                if (this.mPos < this.mWidth / 2) {
                    this.bcc.right = (float) (this.mWidth / 2);
                    this.bcc.left = ((float) this.mPos) + this.czW;
                } else {
                    this.bcc.left = (float) (this.mWidth / 2);
                    this.bcc.right = ((float) this.mPos) - this.czW;
                }
                canvas.save();
                canvas.drawRoundRect(this.bcc, 2.0f, 2.0f, this.mPaint);
                canvas.restore();
            }
        } else if (this.cAa == 0 && this.mProgress > this.czY) {
            this.mPaint.setColor(this.czS);
            this.mPaint.setStyle(Style.FILL);
            this.bcc.left = this.czU;
            this.bcc.right = ((float) this.mPos) - this.czW;
            canvas.save();
            canvas.drawRoundRect(this.bcc, 2.0f, 2.0f, this.mPaint);
            canvas.restore();
        }
    }

    /* renamed from: y */
    private void m15841y(Canvas canvas) {
        this.mPaint.setColor(getCursorColor());
        this.mPaint.setStrokeWidth(this.czV);
        this.mPaint.setStyle(Style.STROKE);
        canvas.save();
        canvas.drawCircle((float) this.mPos, (float) (this.mHeight / 2), this.czW, this.mPaint);
        canvas.restore();
        this.mPaint.setColor(-16777216);
        this.mPaint.setStyle(Style.FILL);
        canvas.save();
        canvas.drawCircle((float) this.mPos, (float) (this.mHeight / 2), this.czW - this.czV, this.mPaint);
        canvas.restore();
        this.czQ.left = ((float) this.mPos) - (this.czW * 2.0f);
        this.czQ.top = 0.0f;
        this.czQ.right = ((float) this.mPos) + (this.czW * 2.0f);
        this.czQ.bottom = (float) this.mHeight;
    }

    /* renamed from: z */
    private void m15842z(Canvas canvas) {
        this.mPaint.setColor(869849304);
        this.mPaint.setStrokeWidth(this.czT);
        float f = this.czT / 2.0f;
        this.bcc.left = this.czU;
        this.bcc.top = ((float) (this.mHeight / 2)) - f;
        this.bcc.right = ((float) this.mWidth) - this.czU;
        this.bcc.bottom = this.bcc.top + f;
        this.mPaint.setStyle(Style.FILL);
        canvas.save();
        canvas.drawRoundRect(this.bcc, f, f, this.mPaint);
        canvas.restore();
    }

    public int getProgress() {
        return this.mProgress;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m15842z(canvas);
        m15841y(canvas);
        m15840x(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mHeight = getMeasuredHeight();
        this.mWidth = getMeasuredWidth();
        this.czR.left = 0.0f;
        this.czR.top = 0.0f;
        this.czR.right = (float) this.mWidth;
        this.czR.bottom = (float) this.mHeight;
        setProgress(this.mProgress);
        this.czY = (int) ((((float) (this.bWG - this.czX)) * this.czW) / (((float) this.mWidth) - (this.czU * 2.0f)));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f3481qZ = motionEvent.getX();
                this.f3482ra = motionEvent.getY();
                this.cAb = true;
                if (!m15838a(this.czQ, this.f3481qZ, this.f3482ra)) {
                    this.cAb = false;
                    return false;
                }
                break;
            case 1:
            case 3:
                if (this.czZ != null) {
                    this.czZ.mo27945lh(this.mProgress);
                    break;
                }
                break;
            case 2:
                motionEvent.getX();
                motionEvent.getY();
                if (this.cAb) {
                    m15839lg((int) motionEvent.getX());
                    postInvalidate();
                    if (this.czZ != null) {
                        this.czZ.mo27944iD(this.mProgress);
                        break;
                    }
                } else {
                    return false;
                }
                break;
        }
        return true;
    }

    public void setAdjustBarListener(C5717a aVar) {
        this.czZ = aVar;
    }

    public void setProgress(int i) {
        this.mProgress = i;
        this.mPos = (int) (((((float) this.mProgress) * (((float) this.mWidth) - (this.czU * 2.0f))) / ((float) (this.bWG - this.czX))) + this.czU);
    }

    public void setReferenceF(int i) {
        this.cAa = i;
    }
}
