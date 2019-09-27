package com.introvd.template.editor.widget.seekbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import com.introvd.template.editor.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class IndicatorSeekBar extends View {

    /* renamed from: CY */
    private Rect f3529CY;
    /* access modifiers changed from: private */

    /* renamed from: Lb */
    public float f3530Lb;
    private TextPaint aeI;
    private Drawable aeg;
    private int cbc;
    private boolean cgr;
    private Paint dtB;
    private C7079c dtC;
    private float dtD;
    /* access modifiers changed from: private */
    public float dtE;
    private float dtF;
    private float dtG;
    private boolean dtH;
    private C7080d dtI;
    private int dtJ;
    private float dtK;
    private float dtL;
    private float dtM;
    private float dtN;
    private boolean dtO;
    private int dtP;
    private boolean dtQ;
    private boolean dtR;
    private boolean dtS;
    /* access modifiers changed from: private */
    public float[] dtT;
    private boolean dtU;
    private boolean dtV;
    private boolean dtW;
    private int dtX;
    private String[] dtY;
    private float[] dtZ;
    private int duA;
    private boolean duB;
    private RectF duC;
    private RectF duD;
    private int duE;
    private int duF;
    private int duG;
    private int duH;
    private int[] duI;
    private boolean duJ;
    private float duK;
    private float duL;
    private Bitmap duM;
    private int duN;
    private int duO;
    private Bitmap duP;
    private int duQ;
    private boolean duR;
    private float duS;
    private int duT;
    private boolean duU;
    private boolean duV;
    private float[] dua;
    private float dub;
    private int duc;
    private Typeface dud;
    private int due;
    private int duf;
    private int dug;
    private CharSequence[] duh;
    /* access modifiers changed from: private */
    public C7078b dui;
    /* access modifiers changed from: private */
    public boolean duj;
    private int duk;
    private View dul;
    private View dum;
    private int dun;
    private String duo;
    private float[] dup;
    private int duq;
    private int dur;
    private int dus;
    private float dut;
    private Bitmap duu;
    private Bitmap duv;
    private Drawable duw;
    private int dux;
    private boolean duy;
    private boolean duz;

    /* renamed from: kA */
    private int f3531kA;

    /* renamed from: kB */
    private int f3532kB;

    /* renamed from: kC */
    private int f3533kC;
    private Context mContext;
    private int mIndicatorColor;

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dtF = -1.0f;
        this.dtG = -1.0f;
        this.dtP = 1;
        this.mContext = context;
        m20762c(this.mContext, attributeSet);
        avb();
    }

    IndicatorSeekBar(C7077a aVar) {
        super(aVar.context);
        this.dtF = -1.0f;
        this.dtG = -1.0f;
        this.dtP = 1;
        this.mContext = aVar.context;
        int b = C7081e.m20784b(this.mContext, 16.0f);
        setPadding(b, getPaddingTop(), b, getPaddingBottom());
        m20752a(aVar);
        avb();
    }

    /* renamed from: M */
    private void m20741M(MotionEvent motionEvent) {
        m20753aE(m20754aF(m20755aG(m20743N(motionEvent))));
        setSeekListener(true);
        invalidate();
        avq();
    }

    /* renamed from: M */
    private boolean m20742M(float f, float f2) {
        if (this.dtF == -1.0f) {
            this.dtF = (float) C7081e.m20784b(this.mContext, 5.0f);
        }
        return ((f > (((float) this.f3531kA) - (this.dtF * 2.0f)) ? 1 : (f == (((float) this.f3531kA) - (this.dtF * 2.0f)) ? 0 : -1)) >= 0 && (f > (((float) (this.dtJ - this.f3533kC)) + (this.dtF * 2.0f)) ? 1 : (f == (((float) (this.dtJ - this.f3533kC)) + (this.dtF * 2.0f)) ? 0 : -1)) <= 0) && ((f2 > ((this.duC.top - this.duL) - this.dtF) ? 1 : (f2 == ((this.duC.top - this.duL) - this.dtF) ? 0 : -1)) >= 0 && (f2 > ((this.duC.top + this.duL) + this.dtF) ? 1 : (f2 == ((this.duC.top + this.duL) + this.dtF) ? 0 : -1)) <= 0);
    }

    /* renamed from: N */
    private float m20743N(MotionEvent motionEvent) {
        return motionEvent.getX() < ((float) this.f3531kA) ? (float) this.f3531kA : motionEvent.getX() > ((float) (this.dtJ - this.f3533kC)) ? (float) (this.dtJ - this.f3533kC) : motionEvent.getX();
    }

    /* renamed from: Q */
    private void m20744Q(Canvas canvas) {
        if (this.duJ) {
            int i = this.duq - 1 > 0 ? this.duq - 1 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.dtU) {
                    this.dtB.setColor(this.duI[(i - i2) - 1]);
                } else {
                    this.dtB.setColor(this.duI[i2]);
                }
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                int i3 = (((float) i2) > thumbPosOnTickFloat ? 1 : (((float) i2) == thumbPosOnTickFloat ? 0 : -1));
                if (i3 < 0) {
                    int i4 = i2 + 1;
                    if (thumbPosOnTickFloat < ((float) i4)) {
                        float thumbCenterX = getThumbCenterX();
                        this.dtB.setStrokeWidth((float) getLeftSideTrackSize());
                        canvas.drawLine(this.dup[i2], this.duC.top, thumbCenterX, this.duC.bottom, this.dtB);
                        this.dtB.setStrokeWidth((float) getRightSideTrackSize());
                        canvas.drawLine(thumbCenterX, this.duC.top, this.dup[i4], this.duC.bottom, this.dtB);
                    }
                }
                if (i3 < 0) {
                    this.dtB.setStrokeWidth((float) getLeftSideTrackSize());
                } else {
                    this.dtB.setStrokeWidth((float) getRightSideTrackSize());
                }
                canvas.drawLine(this.dup[i2], this.duC.top, this.dup[i2 + 1], this.duC.bottom, this.dtB);
            }
            return;
        }
        this.dtB.setColor(this.duH);
        this.dtB.setStrokeWidth((float) this.duF);
        canvas.drawLine(this.duC.left, this.duC.top, this.duC.right, this.duC.bottom, this.dtB);
        this.dtB.setColor(this.duG);
        this.dtB.setStrokeWidth((float) this.duE);
        canvas.drawLine(this.duD.left, this.duD.top, this.duD.right, this.duD.bottom, this.dtB);
    }

    /* renamed from: R */
    private void m20745R(Canvas canvas) {
        if (this.dtY != null) {
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            for (int i = 0; i < this.dtY.length; i++) {
                if (!this.dtW || i == 0 || i == this.dtY.length - 1) {
                    if (i == getThumbPosOnTick() && ((float) i) == thumbPosOnTickFloat) {
                        this.aeI.setColor(this.dug);
                    } else if (((float) i) < thumbPosOnTickFloat) {
                        this.aeI.setColor(getLeftSideTickTextsColor());
                    } else {
                        this.aeI.setColor(getRightSideTickTextsColor());
                    }
                    int length = this.dtU ? (this.dtY.length - i) - 1 : i;
                    if (i == 0) {
                        canvas.drawText(this.dtY[length], this.dua[i] + (this.dtZ[length] / 2.0f), this.dub, this.aeI);
                    } else if (i == this.dtY.length - 1) {
                        canvas.drawText(this.dtY[length], this.dua[i] - (this.dtZ[length] / 2.0f), this.dub, this.aeI);
                    } else {
                        canvas.drawText(this.dtY[length], this.dua[i], this.dub, this.aeI);
                    }
                }
            }
        }
    }

    /* renamed from: S */
    private void m20746S(Canvas canvas) {
        if (!this.duU) {
            float thumbCenterX = getThumbCenterX();
            if (this.aeg != null) {
                if (this.duM == null || this.duP == null) {
                    avn();
                }
                if (this.duM == null || this.duP == null) {
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                }
                this.dtB.setAlpha(255);
                if (this.cgr) {
                    canvas.drawBitmap(this.duP, thumbCenterX - (((float) this.duP.getWidth()) / 2.0f), this.duC.top - (((float) this.duP.getHeight()) / 2.0f), this.dtB);
                } else {
                    canvas.drawBitmap(this.duM, thumbCenterX - (((float) this.duM.getWidth()) / 2.0f), this.duC.top - (((float) this.duM.getHeight()) / 2.0f), this.dtB);
                }
            } else {
                if (this.cgr) {
                    this.dtB.setColor(this.duQ);
                } else {
                    this.dtB.setColor(this.duN);
                }
                canvas.drawCircle(thumbCenterX, this.duC.top, this.cgr ? this.duL : this.duK, this.dtB);
            }
        }
    }

    /* renamed from: T */
    private void m20747T(Canvas canvas) {
        if (this.duR && (!this.dtV || this.duq <= 2)) {
            this.aeI.setColor(this.duT);
            canvas.drawText(m20757aI(this.f3530Lb), getThumbCenterX(), this.duS, this.aeI);
        }
    }

    /* renamed from: a */
    private void m20749a(int i, Typeface typeface) {
        switch (i) {
            case 0:
                this.dud = Typeface.DEFAULT;
                return;
            case 1:
                this.dud = Typeface.MONOSPACE;
                return;
            case 2:
                this.dud = Typeface.SANS_SERIF;
                return;
            case 3:
                this.dud = Typeface.SERIF;
                return;
            default:
                if (typeface == null) {
                    this.dud = Typeface.DEFAULT;
                    return;
                } else {
                    this.dud = typeface;
                    return;
                }
        }
    }

    /* renamed from: a */
    private void m20750a(ColorStateList colorStateList, int i) {
        Field[] declaredFields;
        if (colorStateList == null) {
            this.duN = i;
            this.duQ = this.duN;
            return;
        }
        int[][] iArr = null;
        try {
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr != null && iArr2 != null) {
                if (iArr.length == 1) {
                    this.duN = iArr2[0];
                    this.duQ = this.duN;
                } else if (iArr.length == 2) {
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        int[] iArr3 = iArr[i2];
                        if (iArr3.length == 0) {
                            this.duQ = iArr2[i2];
                        } else if (iArr3[0] == 16842919) {
                            this.duN = iArr2[i2];
                        } else {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    /* renamed from: a */
    private void m20752a(C7077a aVar) {
        this.dtM = aVar.dsz;
        this.dtN = aVar.dsA;
        this.f3530Lb = aVar.aoZ;
        this.dtO = aVar.dsB;
        this.duq = aVar.dtd;
        this.dtS = aVar.dsC;
        this.dtU = aVar.dsD;
        this.dtQ = aVar.dsE;
        this.dtH = aVar.dsG;
        this.dtR = aVar.dsF;
        this.dun = aVar.dsH;
        this.mIndicatorColor = aVar.dsI;
        this.cbc = aVar.dsJ;
        this.duk = aVar.dsK;
        this.dul = aVar.dsL;
        this.dum = aVar.dsM;
        this.duE = aVar.dsN;
        this.duG = aVar.dsO;
        this.duF = aVar.dsP;
        this.duH = aVar.dsQ;
        this.duB = aVar.dsR;
        this.duO = aVar.diJ;
        this.aeg = aVar.dsW;
        this.duT = aVar.dsS;
        m20750a(aVar.dsV, aVar.dsU);
        this.duR = aVar.dsT;
        this.dux = aVar.dte;
        this.duA = aVar.dtg;
        this.duw = aVar.dth;
        this.duy = aVar.dti;
        this.duz = aVar.dtj;
        m20760b(aVar.dtk, aVar.dtf);
        this.dtV = aVar.dsX;
        this.duc = aVar.dsZ;
        this.duh = aVar.dta;
        this.dud = aVar.dtb;
        m20763c(aVar.dtc, aVar.dsY);
    }

    /* access modifiers changed from: private */
    /* renamed from: aE */
    public void m20753aE(float f) {
        if (this.dtU) {
            this.duD.right = ((float) this.f3531kA) + (this.dtK * (1.0f - ((f - this.dtN) / getAmplitude())));
            this.duC.left = this.duD.right;
            return;
        }
        this.duC.right = (((f - this.dtN) * this.dtK) / getAmplitude()) + ((float) this.f3531kA);
        this.duD.left = this.duC.right;
    }

    /* renamed from: aF */
    private float m20754aF(float f) {
        this.dtE = this.f3530Lb;
        this.f3530Lb = this.dtN + ((getAmplitude() * (f - ((float) this.f3531kA))) / this.dtK);
        return this.f3530Lb;
    }

    /* renamed from: aG */
    private float m20755aG(float f) {
        if (this.duq > 2 && !this.dtS) {
            f = ((float) this.f3531kA) + (this.dtL * ((float) Math.round((f - ((float) this.f3531kA)) / this.dtL)));
        }
        return this.dtU ? (this.dtK - f) + ((float) (this.f3531kA * 2)) : f;
    }

    /* renamed from: aH */
    private boolean m20756aH(float f) {
        m20753aE(this.f3530Lb);
        float f2 = this.dtU ? this.duD.right : this.duC.right;
        return f2 - (((float) this.duO) / 2.0f) <= f && f <= f2 + (((float) this.duO) / 2.0f);
    }

    /* renamed from: aI */
    private String m20757aI(float f) {
        return this.dtO ? String.valueOf(BigDecimal.valueOf((double) f).setScale(this.dtP, 4).floatValue()) : String.valueOf(Math.round(f));
    }

    private void avb() {
        ave();
        if (this.duE > this.duF) {
            this.duE = this.duF;
        }
        if (this.aeg == null) {
            this.duK = ((float) this.duO) / 2.0f;
            this.duL = this.duK * 1.2f;
        } else {
            this.duK = ((float) Math.min(C7081e.m20784b(this.mContext, 30.0f), this.duO)) / 2.0f;
            this.duL = this.duK;
        }
        if (this.duw == null) {
            this.dut = ((float) this.duA) / 2.0f;
        } else {
            this.dut = ((float) Math.min(C7081e.m20784b(this.mContext, 30.0f), this.duA)) / 2.0f;
        }
        this.dtD = Math.max(this.duL, this.dut) * 2.0f;
        avf();
        avg();
        this.dtE = this.f3530Lb;
        avc();
        this.duC = new RectF();
        this.duD = new RectF();
        avd();
        avr();
    }

    private void avc() {
        if (this.duq < 0 || this.duq > 50) {
            StringBuilder sb = new StringBuilder();
            sb.append("the Argument: TICK COUNT must be limited between (0-50), Now is ");
            sb.append(this.duq);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.duq != 0) {
            this.dup = new float[this.duq];
            if (this.dtV) {
                this.dua = new float[this.duq];
                this.dtZ = new float[this.duq];
            }
            this.dtT = new float[this.duq];
            for (int i = 0; i < this.dtT.length; i++) {
                float[] fArr = this.dtT;
                float f = this.dtN;
                float f2 = ((float) i) * (this.dtM - this.dtN);
                int i2 = 1;
                if (this.duq - 1 > 0) {
                    i2 = this.duq - 1;
                }
                fArr[i] = f + (f2 / ((float) i2));
            }
        }
    }

    private void avd() {
        if (!this.dtH) {
            int b = C7081e.m20784b(this.mContext, 16.0f);
            if (getPaddingLeft() == 0) {
                setPadding(b, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            if (getPaddingRight() == 0) {
                setPadding(getPaddingLeft(), getPaddingTop(), b, getPaddingBottom());
            }
        }
    }

    private void ave() {
        if (this.dtM >= this.dtN) {
            if (this.f3530Lb < this.dtN) {
                this.f3530Lb = this.dtN;
            }
            if (this.f3530Lb > this.dtM) {
                this.f3530Lb = this.dtM;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
    }

    private void avf() {
        if (this.dtB == null) {
            this.dtB = new Paint();
        }
        if (this.duB) {
            this.dtB.setStrokeCap(Cap.ROUND);
        }
        this.dtB.setAntiAlias(true);
        if (this.duE > this.duF) {
            this.duF = this.duE;
        }
    }

    private void avg() {
        if (avh()) {
            avi();
            this.aeI.setTypeface(this.dud);
            this.aeI.getTextBounds("j", 0, 1, this.f3529CY);
            this.dtX = this.f3529CY.height() + C7081e.m20784b(this.mContext, 3.0f);
        }
    }

    private boolean avh() {
        return this.duR || (this.duq != 0 && this.dtV);
    }

    private void avi() {
        if (this.aeI == null) {
            this.aeI = new TextPaint();
            this.aeI.setAntiAlias(true);
            this.aeI.setTextAlign(Align.CENTER);
            this.aeI.setTextSize((float) this.duc);
        }
        if (this.f3529CY == null) {
            this.f3529CY = new Rect();
        }
    }

    private void avj() {
        this.dtJ = getMeasuredWidth();
        if (VERSION.SDK_INT < 17) {
            this.f3531kA = getPaddingLeft();
            this.f3533kC = getPaddingRight();
        } else {
            this.f3531kA = getPaddingStart();
            this.f3533kC = getPaddingEnd();
        }
        this.f3532kB = getPaddingTop();
        this.dtK = (float) ((this.dtJ - this.f3531kA) - this.f3533kC);
        float f = this.dtK;
        int i = 1;
        if (this.duq - 1 > 0) {
            i = this.duq - 1;
        }
        this.dtL = f / ((float) i);
    }

    private void avk() {
        avm();
        if (avh()) {
            this.aeI.getTextBounds("j", 0, 1, this.f3529CY);
            this.dub = ((float) this.f3532kB) + this.dtD + ((float) Math.round(((float) this.f3529CY.height()) - this.aeI.descent())) + ((float) C7081e.m20784b(this.mContext, 3.0f));
            this.duS = this.dub;
        }
        if (this.dup != null) {
            avl();
            if (this.duq > 2) {
                this.f3530Lb = this.dtT[getClosestIndex()];
                this.dtE = this.f3530Lb;
            }
            m20753aE(this.f3530Lb);
        }
    }

    private void avl() {
        if (this.duq != 0) {
            if (this.dtV) {
                this.dtY = new String[this.duq];
            }
            for (int i = 0; i < this.dup.length; i++) {
                if (this.dtV) {
                    this.dtY[i] = m20772ql(i);
                    this.aeI.getTextBounds(this.dtY[i], 0, this.dtY[i].length(), this.f3529CY);
                    this.dtZ[i] = (float) this.f3529CY.width();
                    this.dua[i] = ((float) this.f3531kA) + (this.dtL * ((float) i));
                }
                this.dup[i] = ((float) this.f3531kA) + (this.dtL * ((float) i));
            }
        }
    }

    private void avm() {
        if (this.dtU) {
            this.duD.left = (float) this.f3531kA;
            this.duD.top = ((float) this.f3532kB) + this.duL;
            this.duD.right = ((float) this.f3531kA) + (this.dtK * (1.0f - ((this.f3530Lb - this.dtN) / getAmplitude())));
            this.duD.bottom = this.duD.top;
            this.duC.left = this.duD.right;
            this.duC.top = this.duD.top;
            this.duC.right = (float) (this.dtJ - this.f3533kC);
            this.duC.bottom = this.duD.bottom;
            return;
        }
        this.duC.left = (float) this.f3531kA;
        this.duC.top = ((float) this.f3532kB) + this.duL;
        this.duC.right = (((this.f3530Lb - this.dtN) * this.dtK) / getAmplitude()) + ((float) this.f3531kA);
        this.duC.bottom = this.duC.top;
        this.duD.left = this.duC.right;
        this.duD.top = this.duC.bottom;
        this.duD.right = (float) (this.dtJ - this.f3533kC);
        this.duD.bottom = this.duC.bottom;
    }

    private void avn() {
        if (this.aeg != null) {
            if (this.aeg instanceof BitmapDrawable) {
                this.duM = m20765d(this.aeg, true);
                this.duP = this.duM;
            } else if (this.aeg instanceof StateListDrawable) {
                try {
                    StateListDrawable stateListDrawable = (StateListDrawable) this.aeg;
                    Class cls = stateListDrawable.getClass();
                    int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
                    if (intValue == 2) {
                        Method method = cls.getMethod("getStateSet", new Class[]{Integer.TYPE});
                        Method method2 = cls.getMethod("getStateDrawable", new Class[]{Integer.TYPE});
                        for (int i = 0; i < intValue; i++) {
                            int[] iArr = (int[]) method.invoke(stateListDrawable, new Object[]{Integer.valueOf(i)});
                            if (iArr.length <= 0) {
                                this.duM = m20765d((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i)}), true);
                            } else if (iArr[0] == 16842919) {
                                this.duP = m20765d((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i)}), true);
                            } else {
                                throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                    }
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Something wrong happened when parsing thumb selector drawable.");
                    sb.append(e.getMessage());
                    throw new RuntimeException(sb.toString());
                }
            } else {
                throw new IllegalArgumentException("Nonsupport this drawable's type for custom thumb drawable!");
            }
        }
    }

    private void avo() {
        if (this.duw instanceof BitmapDrawable) {
            this.duu = m20765d(this.duw, false);
            this.duv = this.duu;
        } else if (this.duw instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) this.duw;
            try {
                Class cls = stateListDrawable.getClass();
                int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
                if (intValue == 2) {
                    Method method = cls.getMethod("getStateSet", new Class[]{Integer.TYPE});
                    Method method2 = cls.getMethod("getStateDrawable", new Class[]{Integer.TYPE});
                    for (int i = 0; i < intValue; i++) {
                        int[] iArr = (int[]) method.invoke(stateListDrawable, new Object[]{Integer.valueOf(i)});
                        if (iArr.length <= 0) {
                            this.duu = m20765d((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i)}), false);
                        } else if (iArr[0] == 16842913) {
                            this.duv = m20765d((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i)}), false);
                        } else {
                            throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Something wrong happened when parsing TickMarks selector drawable.");
                sb.append(e.getMessage());
                throw new RuntimeException(sb.toString());
            }
        } else {
            throw new IllegalArgumentException("Nonsupport this drawable's type for custom TickMarks drawable!");
        }
    }

    private boolean avp() {
        boolean z = false;
        if (this.dtO) {
            if (this.dtE != this.f3530Lb) {
                z = true;
            }
            return z;
        }
        if (Math.round(this.dtE) != Math.round(this.f3530Lb)) {
            z = true;
        }
        return z;
    }

    private void avq() {
        if (this.duj) {
            avs();
        } else if (this.dui != null) {
            this.dui.auY();
            if (this.dui.isShowing()) {
                this.dui.update(getThumbCenterX());
            } else {
                this.dui.mo31171aD(getThumbCenterX());
            }
        }
    }

    private void avr() {
        if (this.dun != 0 && this.dui == null) {
            C7078b bVar = new C7078b(this.mContext, this, this.mIndicatorColor, this.dun, this.duk, this.cbc, this.dul, this.dum);
            this.dui = bVar;
            this.dul = this.dui.auZ();
        }
    }

    /* access modifiers changed from: private */
    public void avs() {
        int i;
        if (this.duj && this.dui != null) {
            this.dui.mo31177iX(getIndicatorTextString());
            int i2 = 0;
            this.dul.measure(0, 0);
            int measuredWidth = this.dul.getMeasuredWidth();
            float thumbCenterX = getThumbCenterX();
            if (this.dtG == -1.0f) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    this.dtG = (float) displayMetrics.widthPixels;
                }
            }
            float f = (float) (measuredWidth / 2);
            if (f + thumbCenterX > ((float) this.dtJ)) {
                i2 = this.dtJ - measuredWidth;
                i = (int) ((thumbCenterX - ((float) i2)) - f);
            } else if (thumbCenterX - f < 0.0f) {
                i = -((int) (f - thumbCenterX));
            } else {
                i2 = (int) (getThumbCenterX() - f);
                i = 0;
            }
            this.dui.mo31179qj(i2);
            this.dui.mo31180qk(i);
        }
    }

    private boolean avt() {
        if (this.duq < 3 || !this.dtS || !this.duV) {
            return false;
        }
        final int closestIndex = getClosestIndex();
        final float f = this.f3530Lb;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, Math.abs(f - this.dtT[closestIndex])});
        ofFloat.start();
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IndicatorSeekBar.this.dtE = IndicatorSeekBar.this.f3530Lb;
                if (f - IndicatorSeekBar.this.dtT[closestIndex] > 0.0f) {
                    IndicatorSeekBar.this.f3530Lb = f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } else {
                    IndicatorSeekBar.this.f3530Lb = f + ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
                IndicatorSeekBar.this.m20753aE(IndicatorSeekBar.this.f3530Lb);
                IndicatorSeekBar.this.setSeekListener(false);
                if (IndicatorSeekBar.this.dui != null && IndicatorSeekBar.this.duj) {
                    IndicatorSeekBar.this.dui.ava();
                    IndicatorSeekBar.this.avs();
                }
                IndicatorSeekBar.this.invalidate();
            }
        });
        return true;
    }

    /* renamed from: b */
    private int m20759b(Drawable drawable, int i) {
        return Math.round(((((float) i) * 1.0f) * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth()));
    }

    /* renamed from: b */
    private void m20760b(ColorStateList colorStateList, int i) {
        Field[] declaredFields;
        if (colorStateList == null) {
            this.dus = i;
            this.dur = this.dus;
            return;
        }
        int[][] iArr = null;
        try {
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr != null && iArr2 != null) {
                if (iArr.length == 1) {
                    this.dus = iArr2[0];
                    this.dur = this.dus;
                } else if (iArr.length == 2) {
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        int[] iArr3 = iArr[i2];
                        if (iArr3.length == 0) {
                            this.dur = iArr2[i2];
                        } else if (iArr3[0] == 16842913) {
                            this.dus = iArr2[i2];
                        } else {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Something wrong happened when parsing thumb selector color.");
            sb.append(e.getMessage());
            throw new RuntimeException(sb.toString());
        }
    }

    /* renamed from: c */
    private void m20762c(Context context, AttributeSet attributeSet) {
        C7077a aVar = new C7077a(context);
        if (attributeSet == null) {
            m20752a(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorSeekBar);
        this.dtM = obtainStyledAttributes.getFloat(R.styleable.IndicatorSeekBar_isb_max, aVar.dsz);
        this.dtN = obtainStyledAttributes.getFloat(R.styleable.IndicatorSeekBar_isb_min, aVar.dsA);
        this.f3530Lb = obtainStyledAttributes.getFloat(R.styleable.IndicatorSeekBar_isb_progress, aVar.aoZ);
        this.dtO = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_progress_value_float, aVar.dsB);
        this.dtQ = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_user_seekable, aVar.dsE);
        this.dtH = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_clear_default_padding, aVar.dsG);
        this.dtR = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_only_thumb_draggable, aVar.dsF);
        this.dtS = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_seek_smoothly, aVar.dsC);
        this.dtU = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_r2l, aVar.dsD);
        this.duE = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_track_background_size, aVar.dsN);
        this.duF = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_track_progress_size, aVar.dsP);
        this.duG = obtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_track_background_color, aVar.dsO);
        this.duH = obtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_track_progress_color, aVar.dsQ);
        this.duB = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_track_rounded_corners, aVar.dsR);
        this.duO = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_thumb_size, aVar.diJ);
        this.aeg = obtainStyledAttributes.getDrawable(R.styleable.IndicatorSeekBar_isb_thumb_drawable);
        this.duV = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        m20750a(obtainStyledAttributes.getColorStateList(R.styleable.IndicatorSeekBar_isb_thumb_color), aVar.dsU);
        this.duR = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_show_thumb_text, aVar.dsT);
        this.duT = obtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_thumb_text_color, aVar.dsS);
        this.duq = obtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_ticks_count, aVar.dtd);
        this.dux = obtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_show_tick_marks_type, aVar.dte);
        this.duA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_tick_marks_size, aVar.dtg);
        m20760b(obtainStyledAttributes.getColorStateList(R.styleable.IndicatorSeekBar_isb_tick_marks_color), aVar.dtf);
        this.duw = obtainStyledAttributes.getDrawable(R.styleable.IndicatorSeekBar_isb_tick_marks_drawable);
        this.duz = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.dtj);
        this.duy = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.dti);
        this.dtV = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_show_tick_texts, aVar.dsX);
        this.duc = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_tick_texts_size, aVar.dsZ);
        m20763c(obtainStyledAttributes.getColorStateList(R.styleable.IndicatorSeekBar_isb_tick_texts_color), aVar.dsY);
        this.duh = obtainStyledAttributes.getTextArray(R.styleable.IndicatorSeekBar_isb_tick_texts_array);
        m20749a(obtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.dtb);
        this.dun = obtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_show_indicator, aVar.dsH);
        this.mIndicatorColor = obtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_indicator_color, aVar.dsI);
        this.duk = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_indicator_text_size, aVar.dsK);
        this.cbc = obtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_indicator_text_color, aVar.dsJ);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.dul = View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.dum = View.inflate(this.mContext, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: c */
    private void m20763c(ColorStateList colorStateList, int i) {
        Field[] declaredFields;
        if (colorStateList == null) {
            this.duf = i;
            this.due = this.duf;
            this.dug = this.duf;
            return;
        }
        int[][] iArr = null;
        try {
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr != null && iArr2 != null) {
                if (iArr.length == 1) {
                    this.duf = iArr2[0];
                    this.due = this.duf;
                    this.dug = this.duf;
                } else if (iArr.length == 3) {
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        int[] iArr3 = iArr[i2];
                        if (iArr3.length == 0) {
                            this.duf = iArr2[i2];
                        } else {
                            int i3 = iArr3[0];
                            if (i3 == 16842913) {
                                this.due = iArr2[i2];
                            } else if (i3 == 16843623) {
                                this.dug = iArr2[i2];
                            } else {
                                throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    /* renamed from: d */
    private Bitmap m20765d(Drawable drawable, boolean z) {
        int i;
        if (drawable == null) {
            return null;
        }
        int b = C7081e.m20784b(this.mContext, 30.0f);
        if (drawable.getIntrinsicWidth() > b) {
            int i2 = z ? this.duO : this.duA;
            i = m20759b(drawable, i2);
            if (i2 > b) {
                i = m20759b(drawable, b);
            } else {
                b = i2;
            }
        } else {
            b = drawable.getIntrinsicWidth();
            i = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(b, i, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private float getAmplitude() {
        if (this.dtM - this.dtN > 0.0f) {
            return this.dtM - this.dtN;
        }
        return 1.0f;
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.dtM - this.dtN);
        int i = 0;
        for (int i2 = 0; i2 < this.dtT.length; i2++) {
            float abs2 = Math.abs(this.dtT[i2] - this.f3530Lb);
            if (abs2 <= abs) {
                i = i2;
                abs = abs2;
            }
        }
        return i;
    }

    private int getLeftSideTickColor() {
        return this.dtU ? this.dur : this.dus;
    }

    private int getLeftSideTickTextsColor() {
        return this.dtU ? this.duf : this.due;
    }

    private int getLeftSideTrackSize() {
        return this.dtU ? this.duE : this.duF;
    }

    private int getRightSideTickColor() {
        return this.dtU ? this.dus : this.dur;
    }

    private int getRightSideTickTextsColor() {
        return this.dtU ? this.due : this.duf;
    }

    private int getRightSideTrackSize() {
        return this.dtU ? this.duF : this.duE;
    }

    private float getThumbCenterX() {
        return this.dtU ? this.duD.right : this.duC.right;
    }

    private int getThumbPosOnTick() {
        if (this.duq != 0) {
            return Math.round((getThumbCenterX() - ((float) this.f3531kA)) / this.dtL);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.duq != 0) {
            return (getThumbCenterX() - ((float) this.f3531kA)) / this.dtL;
        }
        return 0.0f;
    }

    /* renamed from: hN */
    private C7080d m20770hN(boolean z) {
        if (this.dtI == null) {
            this.dtI = new C7080d(this);
        }
        this.dtI.progress = getProgress();
        this.dtI.dva = getProgressFloat();
        this.dtI.dvb = z;
        if (this.duq > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.dtV && this.dtY != null) {
                this.dtI.dvc = this.dtY[thumbPosOnTick];
            }
            if (this.dtU) {
                this.dtI.thumbPosition = (this.duq - thumbPosOnTick) - 1;
            } else {
                this.dtI.thumbPosition = thumbPosOnTick;
            }
        }
        return this.dtI;
    }

    /* renamed from: i */
    private void m20771i(Canvas canvas) {
        if (this.duq != 0 && (this.dux != 0 || this.duw != null)) {
            float thumbCenterX = getThumbCenterX();
            for (int i = 0; i < this.dup.length; i++) {
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if ((!this.duz || thumbCenterX < this.dup[i]) && ((!this.duy || !(i == 0 || i == this.dup.length - 1)) && (i != getThumbPosOnTick() || this.duq <= 2 || this.dtS))) {
                    int i2 = (((float) i) > thumbPosOnTickFloat ? 1 : (((float) i) == thumbPosOnTickFloat ? 0 : -1));
                    if (i2 <= 0) {
                        this.dtB.setColor(getLeftSideTickColor());
                    } else {
                        this.dtB.setColor(getRightSideTickColor());
                    }
                    if (this.duw != null) {
                        if (this.duv == null || this.duu == null) {
                            avo();
                        }
                        if (this.duv == null || this.duu == null) {
                            throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
                        } else if (i2 <= 0) {
                            canvas.drawBitmap(this.duv, this.dup[i] - (((float) this.duu.getWidth()) / 2.0f), this.duC.top - (((float) this.duu.getHeight()) / 2.0f), this.dtB);
                        } else {
                            canvas.drawBitmap(this.duu, this.dup[i] - (((float) this.duu.getWidth()) / 2.0f), this.duC.top - (((float) this.duu.getHeight()) / 2.0f), this.dtB);
                        }
                    } else if (this.dux == 1) {
                        canvas.drawCircle(this.dup[i], this.duC.top, this.dut, this.dtB);
                    } else if (this.dux == 3) {
                        float b = (float) C7081e.m20784b(this.mContext, 1.0f);
                        float leftSideTrackSize = (thumbCenterX >= this.dup[i] ? (float) getLeftSideTrackSize() : (float) getRightSideTrackSize()) / 2.0f;
                        canvas.drawRect(this.dup[i] - b, this.duC.top - leftSideTrackSize, this.dup[i] + b, this.duC.top + leftSideTrackSize, this.dtB);
                    } else if (this.dux == 2) {
                        canvas.drawRect(this.dup[i] - (((float) this.duA) / 2.0f), this.duC.top - (((float) this.duA) / 2.0f), this.dup[i] + (((float) this.duA) / 2.0f), this.duC.top + (((float) this.duA) / 2.0f), this.dtB);
                    }
                }
            }
        }
    }

    /* renamed from: ql */
    private String m20772ql(int i) {
        return this.duh == null ? m20757aI(this.dtT[i]) : i < this.duh.length ? String.valueOf(this.duh[i]) : "";
    }

    /* access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.dtC != null && avp()) {
            this.dtC.mo27916a(m20770hN(z));
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 3) {
            switch (action) {
                case 0:
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                    break;
            }
        }
        parent.requestDisallowInterceptTouchEvent(false);
        return super.dispatchTouchEvent(motionEvent);
    }

    public C7078b getIndicator() {
        return this.dui;
    }

    /* access modifiers changed from: 0000 */
    public View getIndicatorContentView() {
        return this.dul;
    }

    /* access modifiers changed from: 0000 */
    public String getIndicatorTextString() {
        if (this.duo == null || !this.duo.contains("${TICK_TEXT}")) {
            if (this.duo != null && this.duo.contains("${PROGRESS}")) {
                return this.duo.replace("${PROGRESS}", m20757aI(this.f3530Lb));
            }
        } else if (this.duq > 2 && this.dtY != null) {
            return this.duo.replace("${TICK_TEXT}", this.dtY[getThumbPosOnTick()]);
        }
        return m20757aI(this.f3530Lb);
    }

    public float getMax() {
        return this.dtM;
    }

    public float getMin() {
        return this.dtN;
    }

    public C7079c getOnSeekChangeListener() {
        return this.dtC;
    }

    public int getProgress() {
        return Math.round(this.f3530Lb);
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf((double) this.f3530Lb).setScale(this.dtP, 4).floatValue();
    }

    public int getTickCount() {
        return this.duq;
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        m20744Q(canvas);
        m20771i(canvas);
        m20745R(canvas);
        m20746S(canvas);
        m20747T(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(resolveSize(C7081e.m20784b(this.mContext, 170.0f), i), Math.round(this.dtD + ((float) getPaddingTop()) + ((float) getPaddingBottom())) + this.dtX);
        avj();
        avk();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setProgress(bundle.getFloat("isb_progress"));
            super.onRestoreInstanceState(bundle.getParcelable("isb_instance_state"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("isb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("isb_progress", this.f3530Lb);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new Runnable() {
            public void run() {
                IndicatorSeekBar.this.requestLayout();
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.dtQ || !isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                performClick();
                float x = motionEvent.getX();
                if (m20742M(x, motionEvent.getY())) {
                    if (this.dtR && !m20756aH(x)) {
                        return false;
                    }
                    this.cgr = true;
                    if (this.dtC != null) {
                        this.dtC.mo27915a(this);
                    }
                    m20741M(motionEvent);
                    return true;
                }
                break;
            case 1:
            case 3:
                this.cgr = false;
                if (this.dtC != null) {
                    this.dtC.mo27917b(this);
                }
                if (!avt()) {
                    invalidate();
                }
                if (this.dui != null) {
                    this.dui.hide();
                    break;
                }
                break;
            case 2:
                m20741M(motionEvent);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void setDecimalScale(int i) {
        this.dtP = i;
    }

    public void setEnabled(boolean z) {
        if (z != isEnabled()) {
            super.setEnabled(z);
            if (isEnabled()) {
                setAlpha(1.0f);
                if (this.duj) {
                    this.dul.setAlpha(1.0f);
                }
            } else {
                setAlpha(0.3f);
                if (this.duj) {
                    this.dul.setAlpha(0.3f);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setIndicatorStayAlways(boolean z) {
        this.duj = z;
    }

    public void setIndicatorTextFormat(String str) {
        this.duo = str;
        avl();
        avs();
    }

    public synchronized void setMax(float f) {
        this.dtM = Math.max(this.dtN, f);
        ave();
        avc();
        avk();
        invalidate();
        avs();
    }

    public synchronized void setMin(float f) {
        this.dtN = Math.min(this.dtM, f);
        ave();
        avc();
        avk();
        invalidate();
        avs();
    }

    public void setOnSeekChangeListener(C7079c cVar) {
        this.dtC = cVar;
    }

    public synchronized void setProgress(float f) {
        this.dtE = this.f3530Lb;
        if (f < this.dtN) {
            f = this.dtN;
        } else if (f > this.dtM) {
            f = this.dtM;
        }
        this.f3530Lb = f;
        if (this.duq > 2) {
            this.f3530Lb = this.dtT[getClosestIndex()];
        }
        setSeekListener(false);
        m20753aE(this.f3530Lb);
        postInvalidate();
        avs();
    }

    public void setR2L(boolean z) {
        this.dtU = z;
        requestLayout();
        invalidate();
        avs();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.duV = z;
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.aeg = null;
            this.duM = null;
            this.duP = null;
        } else {
            this.aeg = drawable;
            this.duK = ((float) Math.min(C7081e.m20784b(this.mContext, 30.0f), this.duO)) / 2.0f;
            this.duL = this.duK;
            this.dtD = Math.max(this.duL, this.dut) * 2.0f;
            avn();
        }
        requestLayout();
        invalidate();
    }

    public synchronized void setTickCount(int i) {
        if (this.duq < 0 || this.duq > 50) {
            StringBuilder sb = new StringBuilder();
            sb.append("the Argument: TICK COUNT must be limited between (0-50), Now is ");
            sb.append(this.duq);
            throw new IllegalArgumentException(sb.toString());
        }
        this.duq = i;
        avc();
        avl();
        avj();
        avk();
        invalidate();
        avs();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.duw = null;
            this.duu = null;
            this.duv = null;
        } else {
            this.duw = drawable;
            this.dut = ((float) Math.min(C7081e.m20784b(this.mContext, 30.0f), this.duA)) / 2.0f;
            this.dtD = Math.max(this.duL, this.dut) * 2.0f;
            avo();
        }
        invalidate();
    }

    public void setUserSeekAble(boolean z) {
        this.dtQ = z;
    }
}
