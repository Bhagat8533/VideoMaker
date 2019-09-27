package com.introvd.template.camera.p233ui.view.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.seekbar.DraggableSeekBar */
public class DraggableSeekBar extends View {

    /* renamed from: AA */
    private Path f3444AA = new Path();
    private String[] bWQ = {"0s", "1s", "2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s", "10s"};
    private String[] bWR = null;
    private Float[] bWS;
    private int caD = 1308622847;
    private int caE = mo26322U(44.0f);
    private int caF = mo26322U(48.0f);
    private int caG = mo26322U(52.0f);
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
    private Paint caS = new Paint(1);
    private Paint caT = new Paint(1);
    private Paint caU = new Paint(1);
    private int caV = 0;
    private int caW;
    public C5200a caX;
    private PathEffect caY;
    private NinePatchDrawable caZ;
    private NinePatchDrawable cba;
    private boolean cbb = false;
    private int cbc = -13421773;
    private boolean cbd;
    private boolean cbe = true;
    private boolean cbf;
    private int cbg = -1;
    private int mHeight;
    private int mPadding;
    private Paint mPaint = new Paint(1);
    private int mWidth;

    /* renamed from: com.introvd.template.camera.ui.view.seekbar.DraggableSeekBar$a */
    public interface C5200a {
        /* renamed from: a */
        void mo26346a(DraggableSeekBar draggableSeekBar);

        /* renamed from: b */
        void mo26347b(DraggableSeekBar draggableSeekBar);

        /* renamed from: iD */
        void mo26348iD(int i);
    }

    public DraggableSeekBar(Context context) {
        super(context);
        init();
    }

    public DraggableSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DraggableSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* renamed from: V */
    private void m14183V(float f) {
        this.caV = (int) (((f - ((float) this.mPadding)) / this.caR) + 0.5f);
    }

    /* renamed from: W */
    private float m14184W(float f) {
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
    private void m14185YM() {
        if (this.caN == 2) {
            this.caW = (this.mHeight / 2) + (this.caI / 2);
        } else if (this.caN == 1) {
            this.caW = (this.mHeight / 2) - (this.caJ / 2);
        }
    }

    /* renamed from: YN */
    private void m14186YN() {
        float f = (((float) this.caI) / 11.0f) * 2.0f;
        float f2 = f / 2.0f;
        this.caY = new DashPathEffect(new float[]{f, f2, f, f2, f}, 0.0f);
    }

    /* renamed from: YO */
    private void m14187YO() {
        this.caQ = (this.mWidth - (this.mPadding * 2)) / (this.bWQ.length - 1);
        this.caR = ((float) (this.mWidth - (this.mPadding * 2))) / ((float) ((this.bWQ.length - 1) * this.caK));
    }

    /* renamed from: a */
    private void m14188a(Canvas canvas, float f, float f2, float f3, float f4) {
        this.caT.setStyle(Style.STROKE);
        this.f3444AA.reset();
        this.f3444AA.moveTo(f, f2);
        this.f3444AA.lineTo(f3, f4);
        this.caT.setPathEffect(this.caY);
        canvas.drawPath(this.f3444AA, this.caT);
    }

    /* renamed from: c */
    private void m14189c(Canvas canvas, int i) {
        if (i <= 3) {
            Rect rect = new Rect();
            rect.left = (int) (((((float) this.caV) * this.caR) + ((float) this.mPadding)) - ((float) (this.caE / 2)));
            rect.top = ((this.caW - this.caE) - (this.caL / 2)) - mo26322U(4.0f);
            rect.right = (int) ((((float) this.caV) * this.caR) + ((float) this.mPadding) + ((float) (this.caE / 2)));
            rect.bottom = (this.caW - (this.caL / 2)) - mo26322U(4.0f);
            this.cba.setBounds(rect);
            this.cba.draw(canvas);
        } else if (i <= 4) {
            Rect rect2 = new Rect();
            rect2.left = (int) (((((float) this.caV) * this.caR) + ((float) this.mPadding)) - ((float) (this.caF / 2)));
            rect2.top = ((this.caW - this.caE) - (this.caL / 2)) - mo26322U(4.0f);
            rect2.right = (int) ((((float) this.caV) * this.caR) + ((float) this.mPadding) + ((float) (this.caF / 2)));
            rect2.bottom = (this.caW - (this.caL / 2)) - mo26322U(4.0f);
            this.cba.setBounds(rect2);
            this.cba.draw(canvas);
        } else {
            Rect rect3 = new Rect();
            rect3.left = (int) (((((float) this.caV) * this.caR) + ((float) this.mPadding)) - ((float) (this.caG / 2)));
            rect3.top = ((this.caW - this.caE) - (this.caL / 2)) - mo26322U(4.0f);
            rect3.right = (int) ((((float) this.caV) * this.caR) + ((float) this.mPadding) + ((float) (this.caG / 2)));
            rect3.bottom = (this.caW - (this.caL / 2)) - mo26322U(4.0f);
            this.cba.setBounds(rect3);
            this.cba.draw(canvas);
        }
    }

    /* renamed from: g */
    private void m14190g(String[] strArr) {
        for (int i = 0; i <= (strArr.length / 2) - 1; i++) {
            String str = strArr[i];
            strArr[i] = strArr[(strArr.length - i) - 1];
            strArr[(strArr.length - i) - 1] = str;
        }
    }

    private float getTextTopPos() {
        return (float) (((this.caW - (this.caE / 2)) - (this.caL / 2)) - mo26322U(1.8f));
    }

    private void init() {
        this.cbb = C4580b.m11666qi();
        this.caH = (float) mo26322U(14.0f);
        this.mPadding = mo26322U(16.0f);
        this.caI = mo26322U(6.0f);
        this.caJ = 0;
        this.caO = mo26322U(28.0f);
        this.caK = 2;
        this.caP = mo26322U(1.0f);
        this.caL = mo26322U(10.0f);
        this.caT.setColor(this.caD);
        this.caT.setStrokeWidth((float) this.caP);
        this.caV = this.caM;
        this.caU.setAntiAlias(true);
        this.caU.setColor(this.cbc);
        this.caU.setTextSize((float) mo26322U(12.0f));
        this.caS.setColor(this.caD);
        this.caS.setStrokeWidth((float) this.caP);
        this.caS.setTextSize(this.caH);
        this.caZ = (NinePatchDrawable) getContext().getResources().getDrawable(R.drawable.xiaoying_cam_seek_bar_bubble);
        m14186YN();
    }

    /* renamed from: r */
    private void m14191r(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i;
        int i2;
        float f7 = (float) this.caW;
        float f8 = (float) this.caW;
        float f9 = (float) this.caW;
        float f10 = (float) this.caW;
        if (this.caN == 2) {
            f4 = ((float) this.mPadding) + (this.caR * ((float) this.caM));
            f3 = ((((float) this.caV) * this.caR) + ((float) this.mPadding)) - ((float) this.caL);
            f2 = (((float) this.caV) * this.caR) + ((float) this.mPadding) + ((float) this.caL);
            f = (float) (this.mWidth - this.mPadding);
            f6 = (float) this.mPadding;
            f5 = ((float) this.mPadding) + (this.caR * ((float) this.caM));
        } else if (this.caN == 1) {
            f4 = (float) this.mPadding;
            f3 = ((float) (this.mWidth - this.mPadding)) - (((float) this.caM) * this.caR);
            f2 = 0.0f;
            f = 0.0f;
            f5 = ((float) (this.mWidth - this.mPadding)) - (((float) this.caM) * this.caR);
            f6 = (float) (this.mWidth - this.mPadding);
        } else {
            f6 = 0.0f;
            f5 = 0.0f;
            f4 = 0.0f;
            f3 = 0.0f;
            f2 = 0.0f;
            f = 0.0f;
        }
        m14188a(canvas, f6, f7, f5, f8);
        int length = ((this.bWQ.length - 1) * this.caK) + 1;
        int i3 = -1;
        if (this.cbf) {
            this.caS.setColor(-1);
        } else {
            this.caS.setColor(this.caD);
        }
        if (this.cbb) {
            if (this.caN != 2 || this.caV == length - 1) {
                i = 2;
            } else {
                i = 2;
                canvas.drawLine(f2, f9, f, f10, this.caS);
            }
            if (this.caV != 0) {
                this.caS.setColor(this.caD);
                canvas.drawLine(f4, f9, f3, f10, this.caS);
            }
        } else {
            i = 2;
            if (this.caV != 0) {
                canvas.drawLine(f4, f9, f3, f10, this.caS);
            }
            if (this.caN == 2 && this.caV != length - 1) {
                this.caS.setColor(this.caD);
                canvas.drawLine(f2, f9, f, f10, this.caS);
            }
        }
        int i4 = 0;
        while (i4 < length) {
            if (i4 != this.caV) {
                float f11 = (float) i4;
                float f12 = ((float) this.mPadding) + (this.caR * f11);
                float f13 = (float) (this.caW - (this.caJ / i));
                float f14 = ((float) this.mPadding) + (this.caR * f11);
                float f15 = (float) (this.caW + (this.caJ / i));
                if (i4 == 0 || i4 % this.caK == 0) {
                    f13 = (float) (this.caW - (this.caI / i));
                    f15 = (float) (this.caW + (this.caI / i));
                }
                float f16 = f13;
                float f17 = f15;
                if (this.cbb) {
                    if (i4 < this.caV) {
                        this.caS.setColor(this.caD);
                    } else {
                        this.caS.setColor(i3);
                    }
                } else if (i4 < this.caV) {
                    this.caS.setColor(i3);
                } else {
                    this.caS.setColor(this.caD);
                }
                if (this.caN != i) {
                    i2 = length;
                    if (this.caN == 1) {
                        if (f12 < ((float) this.mPadding) + (((float) (i2 - this.caM)) * this.caR)) {
                            canvas.drawLine(f12, f16, f14, f17, this.caS);
                        } else {
                            m14188a(canvas, f12, f16, f14, f17);
                        }
                    }
                } else if (f12 < (((float) this.caM) * this.caR) + ((float) this.mPadding)) {
                    i2 = length;
                    m14188a(canvas, f12, f16, f14, f17);
                } else {
                    i2 = length;
                    canvas.drawLine(f12, f16, f14, f17, this.caS);
                }
            } else {
                i2 = length;
            }
            i4++;
            length = i2;
            i = 2;
            i3 = -1;
        }
    }

    /* renamed from: s */
    private void m14192s(Canvas canvas) {
        int i = 0;
        if (this.caN == 2) {
            while (i < this.bWQ.length) {
                canvas.drawText(this.bWQ[i], ((float) (this.mPadding + (this.caQ * i))) - (this.mPaint.measureText(this.bWQ[i]) / 2.0f), (float) (this.caW + this.caO), this.mPaint);
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

    /* renamed from: t */
    private float m14193t(String str, int i) {
        return i <= 3 ? (((((float) this.caV) * this.caR) + ((float) this.mPadding)) - ((float) (this.caE / 2))) + ((((float) this.caE) - this.caU.measureText(str)) / 2.0f) : i <= 4 ? (((((float) this.caV) * this.caR) + ((float) this.mPadding)) - ((float) (this.caF / 2))) + ((((float) this.caF) - this.caU.measureText(str)) / 2.0f) : (((((float) this.caV) * this.caR) + ((float) this.mPadding)) - ((float) (this.caG / 2))) + ((((float) this.caG) - this.caU.measureText(str)) / 2.0f);
    }

    /* renamed from: U */
    public int mo26322U(float f) {
        return (int) TypedValue.applyDimension(1, f, getContext().getResources().getDisplayMetrics());
    }

    /* renamed from: dC */
    public void mo26323dC(boolean z) {
        this.cbd = z;
        if (z) {
            this.cbg = -1;
        } else {
            this.cbg = -2130706433;
        }
    }

    public String getCurrValueTxt() {
        String str = "";
        return (this.bWR == null || this.bWR.length <= 0) ? str : this.bWR[getPosition()];
    }

    public int getPosition() {
        return this.cbb ? this.caN == 2 ? ((this.bWQ.length - 1) * this.caK) - this.caV : this.caV : this.caN == 2 ? this.caV : ((this.bWQ.length - 1) * this.caK) - this.caV;
    }

    public int getmDefaultColor() {
        return this.caD;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        String str;
        super.onDraw(canvas);
        this.mPaint.setColor(this.caD);
        this.mPaint.setStrokeWidth((float) this.caP);
        this.mPaint.setTextSize(this.caH);
        canvas.save();
        if (this.cbe) {
            m14192s(canvas);
            canvas.restore();
            canvas.save();
        }
        m14191r(canvas);
        canvas.restore();
        this.mPaint.setColor(this.cbg);
        canvas.save();
        canvas.drawCircle((((float) this.caV) * this.caR) + ((float) this.mPadding), (float) this.caW, (float) this.caL, this.mPaint);
        canvas.restore();
        if (this.cba != null) {
            canvas.save();
            if (this.cbd) {
                StringBuilder sb = new StringBuilder();
                sb.append(getCurrValueTxt());
                sb.append("x");
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getCurrValueTxt());
                sb2.append("");
                str = sb2.toString();
            }
            m14189c(canvas, str.length());
            canvas.drawText(str, m14193t(str, str.length()), getTextTopPos(), this.caU);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mHeight = getMeasuredHeight();
        this.mWidth = getMeasuredWidth();
        m14187YO();
        m14185YM();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                m14183V(m14184W(motionEvent.getX()));
                this.cba = this.caZ;
                this.cbf = true;
                postInvalidate();
                if (this.caX != null) {
                    if (!this.cbd) {
                        this.cbg = -1;
                    }
                    this.caX.mo26346a(this);
                    break;
                }
                break;
            case 1:
            case 3:
                m14183V(m14184W(motionEvent.getX()));
                this.cba = null;
                this.cbf = false;
                postInvalidate();
                if (this.caX != null) {
                    if (!this.cbd) {
                        this.cbg = -2130706433;
                    }
                    this.caX.mo26347b(this);
                    break;
                }
                break;
            case 2:
                m14183V(m14184W(motionEvent.getX()));
                this.cbf = true;
                postInvalidate();
                if (this.caX != null) {
                    this.caX.mo26348iD(getPosition());
                    break;
                }
                break;
        }
        return true;
    }

    public void setBubbleTxtArr(String[] strArr) {
        this.bWR = strArr;
    }

    public void setCircleColor(int i) {
        this.cbg = i;
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
        this.caI = mo26322U((float) i);
        m14186YN();
        postInvalidate();
    }

    public void setLittleLineHeight(int i) {
        this.caJ = mo26322U((float) i);
    }

    public void setOnTextSeekbarChangeListener(C5200a aVar) {
        this.caX = aVar;
    }

    public void setPadding(int i) {
        this.mPadding = mo26322U((float) i);
        m14187YO();
        postInvalidate();
    }

    public void setPostion(int i) {
        if (this.cbb) {
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
        this.caL = mo26322U((float) i);
    }

    public void setScaleValueVisibility(boolean z) {
        this.cbe = z;
    }

    public void setScreenOrientation(int i) {
        this.caN = i;
        this.caV = ((this.bWQ.length - 1) * this.caK) - this.caV;
        m14185YM();
        postInvalidate();
    }

    public void setSubsectionNum(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.caK = i;
        m14187YO();
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.caH = (float) mo26322U((float) i);
    }

    public void setValueArr(Float[] fArr) {
        this.bWS = fArr;
    }

    public void setmDefaultColor(int i) {
        this.caD = i;
    }

    public void setmTxtArr(String[] strArr) {
        this.bWQ = strArr;
        if (this.cbb) {
            m14190g(this.bWQ);
        }
        m14187YO();
        postInvalidate();
    }
}
