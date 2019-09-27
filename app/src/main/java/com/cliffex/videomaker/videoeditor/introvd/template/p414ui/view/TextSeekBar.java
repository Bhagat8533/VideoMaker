package com.introvd.template.p414ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.introvd.template.p203b.C4580b;

/* renamed from: com.introvd.template.ui.view.TextSeekBar */
public class TextSeekBar extends View {

    /* renamed from: AA */
    private Path f3631AA = new Path();
    private String[] bWQ = {"0s", "1s", "2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s", "10s"};
    private int caD = -9408400;
    private float caH;
    private int caI;
    private int caJ;
    private int caK = 2;
    private int caL;
    private int caM = 1;
    private int caN = 2;
    private int caO;
    private int caP;
    private int caQ;
    private float caR;
    private Paint caT = new Paint(1);
    private int caV = 0;
    private int caW;
    private PathEffect caY;
    private boolean ezG = true;
    public C8983a ezH;
    private int mHeight;
    private int mPadding;
    private Paint mPaint = new Paint(1);
    private int mWidth;

    /* renamed from: com.introvd.template.ui.view.TextSeekBar$a */
    public interface C8983a {
        /* renamed from: a */
        void mo26415a(TextSeekBar textSeekBar);

        /* renamed from: b */
        void mo26416b(TextSeekBar textSeekBar);

        /* renamed from: iD */
        void mo26417iD(int i);
    }

    public TextSeekBar(Context context) {
        super(context);
        init();
    }

    public TextSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TextSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* renamed from: V */
    private void m26370V(float f) {
        this.caV = (int) (((f - ((float) this.mPadding)) / this.caR) + 0.5f);
    }

    /* renamed from: W */
    private float m26371W(float f) {
        float f2;
        float f3 = 0.0f;
        if (this.caN == 2) {
            f2 = ((float) this.mPadding) + (((float) this.caM) * this.caR);
            f3 = (float) (this.mWidth - this.mPadding);
        } else if (this.caN == 1) {
            f2 = (float) this.mPadding;
            f3 = ((float) (this.mWidth - this.mPadding)) - (((float) this.caM) * this.caR);
        } else {
            f2 = 0.0f;
        }
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* renamed from: YM */
    private void m26372YM() {
        if (this.caN == 2) {
            this.caW = (this.mHeight / 2) + (this.caI / 2);
        } else if (this.caN == 1) {
            this.caW = (this.mHeight / 2) - (this.caJ / 2);
        }
    }

    /* renamed from: YN */
    private void m26373YN() {
        float f = (((float) this.caI) / 11.0f) * 2.0f;
        float f2 = f / 2.0f;
        this.caY = new DashPathEffect(new float[]{f, f2, f, f2, f}, 0.0f);
    }

    /* renamed from: YO */
    private void m26374YO() {
        this.caQ = (this.mWidth - (this.mPadding * 2)) / (this.bWQ.length - 1);
        this.caR = ((float) (this.mWidth - (this.mPadding * 2))) / ((float) ((this.bWQ.length - 1) * this.caK));
    }

    /* renamed from: a */
    private void m26375a(Canvas canvas, float f, float f2, float f3, float f4) {
        this.caT.setStyle(Style.STROKE);
        this.f3631AA.reset();
        this.f3631AA.moveTo(f, f2);
        this.f3631AA.lineTo(f3, f4);
        this.caT.setPathEffect(this.caY);
        canvas.drawPath(this.f3631AA, this.caT);
    }

    /* renamed from: d */
    public static int m26376d(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: g */
    private void m26377g(String[] strArr) {
        for (int i = 0; i <= (strArr.length / 2) - 1; i++) {
            String str = strArr[i];
            strArr[i] = strArr[(strArr.length - i) - 1];
            strArr[(strArr.length - i) - 1] = str;
        }
    }

    private void init() {
        this.ezG = C4580b.m11666qi();
        this.caH = (float) m26376d(getContext(), 12.0f);
        this.mPadding = m26376d(getContext(), 32.0f);
        this.caI = m26376d(getContext(), 9.0f);
        this.caJ = m26376d(getContext(), 4.0f);
        this.caO = m26376d(getContext(), 20.0f);
        this.caK = 2;
        this.caP = m26376d(getContext(), 1.0f);
        this.caL = m26376d(getContext(), 9.0f);
        this.caT.setColor(this.caD);
        this.caT.setStrokeWidth((float) this.caP);
        this.caV = this.caM;
        m26373YN();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0083  */
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m26378r(android.graphics.Canvas r22) {
        /*
            r21 = this;
            r6 = r21
            int r0 = r6.caW
            float r3 = (float) r0
            int r0 = r6.caW
            float r5 = (float) r0
            int r0 = r6.caW
            float r9 = (float) r0
            int r0 = r6.caW
            float r11 = (float) r0
            int r0 = r6.caN
            r1 = 0
            r13 = 1
            r14 = 2
            if (r0 != r14) goto L_0x0039
            int r0 = r6.mPadding
            float r0 = (float) r0
            int r1 = r6.mPadding
            float r1 = (float) r1
            float r2 = r6.caR
            int r4 = r6.caM
            float r4 = (float) r4
            float r2 = r2 * r4
            float r1 = r1 + r2
            int r2 = r6.mPadding
            float r2 = (float) r2
            float r4 = r6.caR
            int r7 = r6.caM
            float r7 = (float) r7
            float r4 = r4 * r7
            float r2 = r2 + r4
            int r4 = r6.mWidth
            int r7 = r6.mPadding
            int r4 = r4 - r7
            float r4 = (float) r4
        L_0x0034:
            r8 = r2
            r10 = r4
            r2 = r0
            r4 = r1
            goto L_0x0067
        L_0x0039:
            int r0 = r6.caN
            if (r0 != r13) goto L_0x0063
            int r0 = r6.mWidth
            int r1 = r6.mPadding
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.mWidth
            int r2 = r6.mPadding
            int r1 = r1 - r2
            float r1 = (float) r1
            int r2 = r6.caM
            float r2 = (float) r2
            float r4 = r6.caR
            float r2 = r2 * r4
            float r1 = r1 - r2
            int r2 = r6.mPadding
            float r2 = (float) r2
            int r4 = r6.mWidth
            int r7 = r6.mPadding
            int r4 = r4 - r7
            float r4 = (float) r4
            int r7 = r6.caM
            float r7 = (float) r7
            float r8 = r6.caR
            float r7 = r7 * r8
            float r4 = r4 - r7
            goto L_0x0034
        L_0x0063:
            r2 = 0
            r4 = 0
            r8 = 0
            r10 = 0
        L_0x0067:
            r0 = r21
            r1 = r22
            r0.m26375a(r1, r2, r3, r4, r5)
            android.graphics.Paint r12 = r6.mPaint
            r7 = r22
            r7.drawLine(r8, r9, r10, r11, r12)
            java.lang.String[] r0 = r6.bWQ
            int r0 = r0.length
            int r0 = r0 - r13
            int r1 = r6.caK
            int r0 = r0 * r1
            int r7 = r0 + 1
            r0 = 0
            r8 = 0
        L_0x0081:
            if (r8 >= r7) goto L_0x0120
            int r0 = r6.mPadding
            float r0 = (float) r0
            float r1 = r6.caR
            float r2 = (float) r8
            float r1 = r1 * r2
            float r16 = r0 + r1
            int r0 = r6.caW
            int r1 = r6.caJ
            int r1 = r1 / r14
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.mPadding
            float r1 = (float) r1
            float r3 = r6.caR
            float r3 = r3 * r2
            float r18 = r1 + r3
            int r1 = r6.caW
            int r2 = r6.caJ
            int r2 = r2 / r14
            int r1 = r1 + r2
            float r1 = (float) r1
            if (r8 == 0) goto L_0x00b2
            int r2 = r6.caK
            int r2 = r8 % r2
            if (r2 != 0) goto L_0x00ad
            goto L_0x00b2
        L_0x00ad:
            r17 = r0
            r19 = r1
            goto L_0x00c1
        L_0x00b2:
            int r0 = r6.caW
            int r1 = r6.caI
            int r1 = r1 / r14
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.caW
            int r2 = r6.caI
            int r2 = r2 / r14
            int r1 = r1 + r2
            float r1 = (float) r1
            goto L_0x00ad
        L_0x00c1:
            int r0 = r6.caN
            if (r0 != r14) goto L_0x00ee
            int r0 = r6.caM
            float r0 = (float) r0
            float r1 = r6.caR
            float r0 = r0 * r1
            int r1 = r6.mPadding
            float r1 = (float) r1
            float r0 = r0 + r1
            int r0 = (r16 > r0 ? 1 : (r16 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00e4
            r0 = r21
            r1 = r22
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r0.m26375a(r1, r2, r3, r4, r5)
            goto L_0x011c
        L_0x00e4:
            android.graphics.Paint r0 = r6.mPaint
            r15 = r22
            r20 = r0
            r15.drawLine(r16, r17, r18, r19, r20)
            goto L_0x011c
        L_0x00ee:
            int r0 = r6.caN
            if (r0 != r13) goto L_0x011c
            int r0 = r6.mPadding
            float r0 = (float) r0
            int r1 = r6.caM
            int r1 = r7 - r1
            float r1 = (float) r1
            float r2 = r6.caR
            float r1 = r1 * r2
            float r0 = r0 + r1
            int r0 = (r16 > r0 ? 1 : (r16 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x010d
            android.graphics.Paint r0 = r6.mPaint
            r15 = r22
            r20 = r0
            r15.drawLine(r16, r17, r18, r19, r20)
            goto L_0x011c
        L_0x010d:
            r0 = r21
            r1 = r22
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r0.m26375a(r1, r2, r3, r4, r5)
        L_0x011c:
            int r8 = r8 + 1
            goto L_0x0081
        L_0x0120:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p414ui.view.TextSeekBar.m26378r(android.graphics.Canvas):void");
    }

    /* renamed from: s */
    private void m26379s(Canvas canvas) {
        int i = 0;
        if (this.caN == 2) {
            while (i < this.bWQ.length) {
                canvas.drawText(this.bWQ[i], ((float) (this.mPadding + (this.caQ * i))) - (this.mPaint.measureText(this.bWQ[i]) / 2.0f), (float) (this.caW - this.caO), this.mPaint);
                i++;
            }
        } else if (this.caN == 1) {
            while (i < this.bWQ.length) {
                float f = this.mPaint.getFontMetrics().top;
                float f2 = (float) ((this.mWidth - this.mPadding) - (this.caQ * i));
                float f3 = (float) (this.caW + this.caO);
                canvas.save();
                canvas.rotate(90.0f, (float) ((this.mWidth - this.mPadding) - (this.caQ * i)), ((float) (this.caW + this.caO)) + (f / 3.0f));
                canvas.drawText(this.bWQ[i], f2, f3, this.mPaint);
                canvas.restore();
                i++;
            }
        }
    }

    public int getPosition() {
        return this.ezG ? this.caN == 2 ? ((this.bWQ.length - 1) * this.caK) - this.caV : this.caV : this.caN == 2 ? this.caV : ((this.bWQ.length - 1) * this.caK) - this.caV;
    }

    public int getmDefaultColor() {
        return this.caD;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.caD);
        this.mPaint.setStrokeWidth((float) this.caP);
        this.mPaint.setTextSize(this.caH);
        canvas.save();
        m26379s(canvas);
        canvas.restore();
        canvas.save();
        m26378r(canvas);
        canvas.restore();
        this.mPaint.setColor(-1);
        canvas.save();
        canvas.drawCircle((((float) this.caV) * this.caR) + ((float) this.mPadding), (float) this.caW, (float) this.caL, this.mPaint);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mHeight = getMeasuredHeight();
        this.mWidth = getMeasuredWidth();
        m26374YO();
        m26372YM();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                m26370V(m26371W(motionEvent.getX()));
                postInvalidate();
                if (this.ezH != null) {
                    this.ezH.mo26415a(this);
                    break;
                }
                break;
            case 1:
            case 3:
                m26370V(m26371W(motionEvent.getX()));
                postInvalidate();
                if (this.ezH != null) {
                    this.ezH.mo26416b(this);
                    break;
                }
                break;
            case 2:
                m26370V(m26371W(motionEvent.getX()));
                postInvalidate();
                if (this.ezH != null) {
                    this.ezH.mo26417iD(getPosition());
                    break;
                }
                break;
        }
        return true;
    }

    public void setDashLinesCount(int i) {
        this.caM = i;
        if (this.caN == 2) {
            this.caV = this.caM;
        } else {
            this.caV = ((this.bWQ.length - 1) * this.caK) - this.caM;
        }
        postInvalidate();
    }

    public void setLargeLineHeight(int i) {
        this.caI = m26376d(getContext(), (float) i);
        m26373YN();
        postInvalidate();
    }

    public void setLittleLineHeight(int i) {
        this.caJ = m26376d(getContext(), (float) i);
    }

    public void setOnTextSeekbarChangeListener(C8983a aVar) {
        this.ezH = aVar;
    }

    public void setPadding(int i) {
        this.mPadding = m26376d(getContext(), (float) i);
        m26374YO();
        postInvalidate();
    }

    public void setPostion(int i) {
        if (this.ezG) {
            if (this.caN == 2) {
                this.caV = ((this.bWQ.length - 1) * this.caK) - i;
            } else {
                this.caV = i;
            }
        } else if (this.caN == 2) {
            this.caV = i;
        } else {
            this.caV = ((this.bWQ.length - 1) * this.caK) - i;
        }
    }

    public void setRadius(int i) {
        this.caL = m26376d(getContext(), (float) i);
    }

    public void setScreenOrientation(int i) {
        this.caN = i;
        this.caV = ((this.bWQ.length - 1) * this.caK) - this.caV;
        m26372YM();
        postInvalidate();
    }

    public void setSubsectionNum(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.caK = i;
        m26374YO();
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.caH = (float) m26376d(getContext(), (float) i);
    }

    public void setmDefaultColor(int i) {
        this.caD = i;
    }

    public void setmTxtArr(String[] strArr) {
        this.bWQ = strArr;
        if (this.ezG) {
            m26377g(this.bWQ);
        }
        m26374YO();
        postInvalidate();
    }
}
