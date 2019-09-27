package com.introvd.template.editor.widget.scalerotate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;

/* renamed from: com.introvd.template.editor.widget.scalerotate.b */
public class C7070b {
    private static final String TAG = "b";
    private static float cvm;
    private static float cvn;
    private static float cvo;
    private static float cvp;
    private static final float cvq = ((float) C4583d.m11671P(35.0f));
    private Matrix bWZ;
    private Path bXb;
    private Paint bXc;
    private View btV;
    private Drawable cvA;
    private Drawable cvB;
    private boolean cvC;
    private Drawable cvD;
    private Drawable cvE;
    private int cvF;
    private int cvG;
    private BitmapDrawable cvH;
    private int cvI;
    private boolean cvJ;
    private boolean cvK;
    private boolean cvL;
    private boolean cvM;
    private final float[] cvN;
    private boolean cvO;
    private boolean cvP;
    private Paint cvQ;
    private Paint cvR;
    private int cvS;
    private int cvT;
    private boolean cvU;
    private float cvt;
    private RectF cvv;
    private RectF cvw;
    private boolean cvx;
    private Drawable cvy;
    private Drawable cvz;
    private int cwg;
    private C7071a drE = C7071a.Center;
    private C7074d drF;
    private C7073c drG;
    private C7072b drH;
    private boolean drI;
    private boolean drJ;
    private Drawable drK;
    private Drawable drL;
    private Drawable drM;
    private int drN;
    private int drO;
    private boolean drP;
    private int drQ;
    private boolean drR;
    private float drS;
    private float drT;
    private int drU;
    private boolean isAnimOn;
    private boolean isHorFlip;
    private boolean isVerFlip;
    private Matrix mMatrix;
    private int mOutlineEllipse;
    private int mOutlineStrokeColor;
    private int mPadding;
    private float mRotation;
    private boolean mSelected;

    /* renamed from: com.introvd.template.editor.widget.scalerotate.b$a */
    public enum C7071a {
        Top,
        Bottom,
        Right,
        Left,
        Center
    }

    /* renamed from: com.introvd.template.editor.widget.scalerotate.b$b */
    public enum C7072b {
        None,
        Move,
        Grow,
        Pointer_Grow,
        Rotate,
        LeftStretch,
        BottomStretch,
        RightStretch,
        TopStretch
    }

    /* renamed from: com.introvd.template.editor.widget.scalerotate.b$c */
    public interface C7073c {
        /* renamed from: a */
        void mo28375a(RectF rectF, float f, int i);

        void aiH();

        /* renamed from: mj */
        void mo28377mj(int i);
    }

    /* renamed from: com.introvd.template.editor.widget.scalerotate.b$d */
    public interface C7074d {
        void aan();

        void aiI();

        void aiJ();

        /* renamed from: cv */
        int mo28381cv(int i, int i2);

        /* renamed from: cw */
        void mo28382cw(int i, int i2);

        /* renamed from: eg */
        void mo28383eg(boolean z);

        /* renamed from: ff */
        void mo28384ff(boolean z);
    }

    public C7070b(View view) {
        float f = 1.0f;
        this.cvt = 1.0f;
        this.cvx = false;
        this.isAnimOn = false;
        this.cvA = null;
        this.cvB = null;
        this.isVerFlip = false;
        this.isHorFlip = false;
        this.cvC = false;
        this.drI = false;
        this.drJ = false;
        this.drK = null;
        this.cvK = false;
        this.cvL = true;
        this.drP = false;
        this.cvM = true;
        this.mRotation = 0.0f;
        this.bWZ = new Matrix();
        this.cvN = new float[]{0.0f, 0.0f};
        this.cvO = true;
        this.cvP = true;
        this.bXb = new Path();
        this.cvS = 1711276032;
        this.cvT = 1722131877;
        this.mOutlineEllipse = 0;
        this.mPadding = 0;
        this.drQ = -1;
        this.cvU = true;
        this.drR = false;
        this.drS = 0.0f;
        this.drT = 0.0f;
        this.drU = 255;
        this.btV = view;
        if (Constants.getDeviceDensity() >= 1.5f) {
            f = 2.0f;
        }
        cvm = ((float) view.getWidth()) * f;
        cvn = ((float) view.getHeight()) * f;
    }

    /* renamed from: J */
    private boolean m20686J(float f, float f2) {
        RectF rectF = new RectF(this.cvw);
        rectF.offset(f, f2);
        return rectF.left < 0.0f || rectF.right > ((float) this.btV.getWidth()) || rectF.top < 0.0f || rectF.bottom > ((float) this.btV.getHeight());
    }

    /* renamed from: P */
    private void m20687P(Canvas canvas) {
        RectF rectF = new RectF(this.cvv);
        int i = (int) rectF.right;
        int i2 = (int) rectF.top;
        if (this.drK != null) {
            this.drK.setBounds(i - this.drN, i2 - this.drO, i + this.drN, i2 + this.drO);
            this.drK.draw(canvas);
        }
    }

    /* renamed from: a */
    private float m20688a(float f, float f2, int i) {
        float[] fArr = {this.cvv.centerX(), this.cvv.centerY()};
        float[] fArr2 = i == 512 ? new float[]{this.cvv.right, this.cvv.centerY()} : i == 128 ? new float[]{this.cvv.left, this.cvv.centerY()} : i == 1024 ? new float[]{this.cvv.centerX(), this.cvv.top} : new float[]{this.cvv.centerX(), this.cvv.bottom};
        float[] fArr3 = {f, f2};
        Matrix matrix = new Matrix();
        matrix.postRotate(-this.mRotation);
        matrix.mapPoints(fArr3);
        float f3 = fArr3[0];
        float f4 = fArr3[1];
        float[] fArr4 = i == 512 ? new float[]{this.cvv.right + f3, this.cvv.centerY() + f4} : i == 128 ? new float[]{this.cvv.left + f3, this.cvv.centerY() + f4} : i == 1024 ? new float[]{this.cvv.centerX() + f3, this.cvv.top + f4} : new float[]{this.cvv.centerX() + f3, this.cvv.bottom + f4};
        return (float) (C7064a.m20677d(fArr, fArr4) - C7064a.m20677d(fArr, fArr2));
    }

    /* renamed from: a */
    private float m20689a(float f, boolean z) {
        float f2 = z ? 0.2f : 5.0f;
        if (f > 0.0f) {
            if (Math.abs(f) >= f2 && Math.abs(f - 360.0f) >= f2) {
                if (Math.abs(f - 180.0f) < f2) {
                    return 180.0f;
                }
                if (Math.abs(f - 90.0f) < f2) {
                    return 90.0f;
                }
                if (Math.abs(f - 270.0f) < f2) {
                    return 270.0f;
                }
                return f;
            }
        } else if (f >= 0.0f) {
            return f;
        } else {
            if (Math.abs(f) >= f2 && Math.abs(360.0f + f) >= f2) {
                if (Math.abs(180.0f + f) < f2) {
                    return -180.0f;
                }
                if (Math.abs(90.0f + f) < f2) {
                    return -90.0f;
                }
                if (Math.abs(270.0f + f) < f2) {
                    return -270.0f;
                }
                return f;
            }
        }
        return 0.0f;
    }

    /* renamed from: a */
    private void m20690a(Canvas canvas, RectF rectF) {
        int i = (int) rectF.left;
        int i2 = (int) rectF.right;
        int i3 = (int) rectF.top;
        int i4 = (int) rectF.bottom;
        int i5 = (int) ((rectF.top + rectF.bottom) / 2.0f);
        int i6 = (int) ((rectF.left + rectF.right) / 2.0f);
        if (!(this.cvy == null || this.cvz == null)) {
            if (!acO()) {
                if (C4580b.m11666qi()) {
                    this.cvz.setBounds(i - this.cvF, i3 - this.cvG, this.cvF + i, this.cvG + i3);
                } else {
                    this.cvz.setBounds(i2 - this.cvF, i3 - this.cvG, this.cvF + i2, this.cvG + i3);
                }
                this.cvz.draw(canvas);
            } else if (isAnimOn()) {
                if (C4580b.m11666qi()) {
                    this.cvy.setBounds(i - this.cvF, i3 - this.cvG, this.cvF + i, this.cvG + i3);
                } else {
                    this.cvy.setBounds(i2 - this.cvF, i3 - this.cvG, this.cvF + i2, this.cvG + i3);
                }
                this.cvy.draw(canvas);
            } else {
                if (C4580b.m11666qi()) {
                    this.cvz.setBounds(i - this.cvF, i3 - this.cvG, this.cvF + i, this.cvG + i3);
                } else {
                    this.cvz.setBounds(i2 - this.cvF, i3 - this.cvG, this.cvF + i2, this.cvG + i3);
                }
                this.cvz.draw(canvas);
            }
        }
        if (this.cvD != null) {
            if (C4580b.m11666qi()) {
                this.cvD.setBounds(i - this.cvF, i4 - this.cvG, this.cvF + i, this.cvG + i4);
            } else {
                this.cvD.setBounds(i2 - this.cvF, i4 - this.cvG, this.cvF + i2, this.cvG + i4);
            }
            this.cvD.draw(canvas);
        }
        if (!(this.cvB == null || this.cvA == null)) {
            if (isVerFlip() ^ isHorFlip()) {
                if (C4580b.m11666qi()) {
                    this.cvB.setBounds(i2 - this.cvF, i4 - this.cvG, this.cvF + i2, this.cvG + i4);
                } else {
                    this.cvB.setBounds(i - this.cvF, i4 - this.cvG, this.cvF + i, this.cvG + i4);
                }
                this.cvB.draw(canvas);
            } else {
                if (C4580b.m11666qi()) {
                    this.cvA.setBounds(i2 - this.cvF, i4 - this.cvG, this.cvF + i2, this.cvG + i4);
                } else {
                    this.cvA.setBounds(i - this.cvF, i4 - this.cvG, this.cvF + i, this.cvG + i4);
                }
                this.cvA.draw(canvas);
            }
        }
        if (this.cvE != null && this.cvL) {
            if (C4580b.m11666qi()) {
                this.cvE.setBounds(i2 - this.cvF, i3 - this.cvG, this.cvF + i2, this.cvG + i3);
            } else {
                this.cvE.setBounds(i - this.cvF, i3 - this.cvG, this.cvF + i, this.cvG + i3);
            }
            this.cvE.draw(canvas);
        }
        if (this.drL != null && this.drP) {
            if (C4580b.m11666qi()) {
                this.drL.setBounds(i - this.cvF, i3 - this.cvG, this.cvF + i, this.cvG + i3);
            } else {
                this.drL.setBounds(i2 - this.cvF, i3 - this.cvG, this.cvF + i2, this.cvG + i3);
            }
            this.drL.draw(canvas);
        }
        if (this.drM != null) {
            if (C4580b.m11666qi()) {
                this.drM.setBounds(i2 - this.cvF, i5 - this.cvG, this.cvF + i2, this.cvG + i5);
            } else {
                this.drM.setBounds(i - this.cvF, i5 - this.cvG, this.cvF + i, this.cvG + i5);
            }
            this.drM.draw(canvas);
            if (C4580b.m11666qi()) {
                this.drM.setBounds(i - this.cvF, i5 - this.cvG, i + this.cvF, i5 + this.cvG);
            } else {
                this.drM.setBounds(i2 - this.cvF, i5 - this.cvG, i2 + this.cvF, i5 + this.cvG);
            }
            this.drM.draw(canvas);
        }
        if (this.drM != null) {
            this.drM.setBounds(i6 - this.cvF, i4 - this.cvG, this.cvF + i6, i4 + this.cvG);
            this.drM.draw(canvas);
            this.drM.setBounds(i6 - this.cvF, i3 - this.cvG, i6 + this.cvF, i3 + this.cvG);
            this.drM.draw(canvas);
        }
    }

    /* renamed from: aB */
    private float m20691aB(float f) {
        float f2 = f % 360.0f;
        return f2 < -180.0f ? f2 + 360.0f : f2 > 180.0f ? f2 - 360.0f : f2;
    }

    private Rect acJ() {
        RectF rectF = new RectF(this.cvw);
        rectF.inset((float) (-this.mPadding), (float) (-this.mPadding));
        this.bWZ.mapRect(rectF);
        Rect rect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        rect.inset((-this.cvF) * 2, (-this.cvG) * 2);
        return rect;
    }

    private RectF acK() {
        return new RectF(this.cvv.left, this.cvv.top, this.cvv.right, this.cvv.bottom);
    }

    private void acL() {
        this.bXc.setColor((!acM() || this.drH == C7072b.None) ? this.mOutlineStrokeColor : this.cvI);
        this.cvQ.setColor(this.drH != C7072b.None ? this.cvI : -1);
        this.cvR.setColor(this.drH == C7072b.None ? this.cvS : this.cvT);
    }

    private boolean acM() {
        return this.mRotation == 0.0f || this.mRotation == 90.0f || this.mRotation == 180.0f || this.mRotation == 270.0f;
    }

    /* renamed from: cl */
    private float m20692cl(int i, int i2) {
        float f = 1.0f;
        if (cvm == 0.0f || cvn == 0.0f) {
            return 1.0f;
        }
        float f2 = (float) i;
        if (f2 > cvm || ((float) i2) > cvn) {
            float f3 = cvm / f2;
            float f4 = cvn / ((float) i2);
            f = f3 < f4 ? f3 : f4;
        }
        return f;
    }

    /* renamed from: e */
    private void m20693e(float f, int i) {
        RectF rectF = new RectF(this.cvw);
        if (i == 128) {
            rectF.left -= f;
        } else if (i == 512) {
            rectF.right += f;
        } else if (i == 1024) {
            rectF.top -= f;
        } else if (i == 256) {
            rectF.bottom += f;
        }
        RectF a = mo31062a(this.mMatrix, rectF);
        if ((a.height() < this.cvw.height() || a.width() < this.cvw.width()) && (a.height() < cvp || a.width() < cvo)) {
            rectF.set(this.cvw);
        }
        if (f > 0.0f && (a.width() >= cvm || a.height() >= cvn)) {
            rectF.set(this.cvw);
        }
        this.cvw.set(rectF);
        mo31113qf(i);
        this.btV.invalidate();
    }

    private void init() {
        this.mOutlineStrokeColor = -6238720;
        this.cvI = -1;
        this.bXc = new Paint(1);
        this.bXc.setStrokeWidth(C7689a.m22596aQ(1.0f));
        this.bXc.setStyle(Style.STROKE);
        this.bXc.setColor(this.mOutlineStrokeColor);
        this.bXc.setPathEffect(new DashPathEffect(new float[]{6.0f, 6.0f}, 0.0f));
        this.cvQ = new Paint(1);
        this.cvQ.setStrokeWidth(C7689a.m22596aQ(1.0f));
        this.cvQ.setStyle(Style.STROKE);
        this.cvQ.setColor(this.mOutlineStrokeColor);
        this.cvR = new Paint(1);
        this.cvR.setStyle(Style.FILL);
        this.cvR.setColor(this.cvS);
        mo31065a(C7072b.None);
    }

    /* renamed from: j */
    private void m20694j(float f, float f2, float f3, float f4) {
        float[] fArr = {this.cvv.centerX(), this.cvv.centerY()};
        float[] fArr2 = C4580b.m11666qi() ? new float[]{this.cvv.left, this.cvv.bottom} : new float[]{this.cvv.right, this.cvv.bottom};
        float[] fArr3 = {f, f2};
        double c = C7064a.m20675c(fArr2, fArr);
        double c2 = C7064a.m20675c(fArr3, fArr);
        if (this.cvJ) {
            float[] fArr4 = {f3, f4};
            Matrix matrix = new Matrix();
            matrix.postRotate(-this.mRotation);
            matrix.mapPoints(fArr4);
            float width = fArr4[0] * (this.cvw.width() / this.cvv.width());
            float height = fArr4[1] * (this.cvw.height() / this.cvv.height());
            float d = (float) (C7064a.m20677d(fArr, C4580b.m11666qi() ? new float[]{this.cvv.left + width, this.cvv.bottom + height} : new float[]{this.cvv.right + width, this.cvv.bottom + height}) - C7064a.m20677d(fArr, fArr2));
            this.mRotation = -((float) (c2 - c));
            this.mRotation = m20691aB(m20689a(this.mRotation, false));
            acL();
            mo31082ag(d);
            return;
        }
        this.mRotation = m20691aB(-((float) (c2 - c)));
    }

    /* renamed from: w */
    private void m20695w(float f, float f2) {
        RectF rectF = new RectF(this.cvw);
        if (this.drE == C7071a.Center) {
            rectF.inset(-f, -f2);
        } else if (this.drE == C7071a.Top) {
            rectF.inset(-f, 0.0f);
            rectF.bottom += 2.0f * f2;
        } else {
            rectF.inset(-f, 0.0f);
            rectF.top -= 2.0f * f2;
        }
        RectF a = mo31062a(this.mMatrix, rectF);
        if ((a.height() < this.cvw.height() || a.width() < this.cvw.width()) && (a.height() < cvp || a.width() < cvo)) {
            rectF.set(this.cvw);
        }
        if (f > 0.0f && f2 > 0.0f && (a.width() >= cvm || a.height() >= cvn)) {
            rectF.set(this.cvw);
        }
        this.cvw.set(rectF);
        invalidate();
        this.btV.invalidate();
    }

    /* renamed from: w */
    private void m20696w(Canvas canvas) {
        this.bXb.reset();
        RectF acI = acI();
        Paint paint = this.bXc;
        if (this.cvU) {
            this.bXb.addRect(acI, Direction.CW);
        } else {
            this.bXb.addRoundRect(acI, (float) this.mOutlineEllipse, (float) this.mOutlineEllipse, Direction.CW);
            paint = this.cvQ;
        }
        if (this.cvP) {
            canvas.drawPath(this.bXb, this.cvR);
        }
        if (this.cvO) {
            canvas.drawPath(this.bXb, paint);
        }
        if (this.cvU) {
            m20690a(canvas, acI);
        }
    }

    /* renamed from: E */
    public void mo31054E(int i, int i2, int i3) {
        if (i != -1) {
            if (i2 != 0 || i3 != 0) {
                mo31059I((float) i2, (float) i3);
            }
        }
    }

    /* renamed from: E */
    public void mo31055E(Drawable drawable) {
        this.cvA = drawable;
    }

    /* renamed from: F */
    public void mo31056F(Drawable drawable) {
        this.cvB = drawable;
    }

    /* renamed from: G */
    public void mo31057G(Drawable drawable) {
        this.drK = drawable;
        if (this.drK != null) {
            this.drN = this.drK.getIntrinsicWidth() / 2;
            this.drO = this.drK.getIntrinsicHeight() / 2;
        }
    }

    /* renamed from: H */
    public void mo31058H(Drawable drawable) {
        this.cvE = drawable;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: I */
    public void mo31059I(float f, float f2) {
        if (this.cvw == null || this.cvv == null) {
            mo31130v(f, f2);
        } else {
            mo31130v(f * (this.cvw.width() / this.cvv.width()), f2 * (this.cvw.height() / this.cvv.height()));
        }
    }

    /* renamed from: I */
    public void mo31060I(Drawable drawable) {
        this.drL = drawable;
    }

    /* renamed from: K */
    public void mo31061K(float f, float f2) {
        float width = (f2 + ((1.0f - f2) * f)) * ((float) this.btV.getWidth()) * ((float) this.btV.getHeight());
        float sqrt = (float) Math.sqrt((double) (this.cvt * width));
        float sqrt2 = (float) Math.sqrt((double) (width / this.cvt));
        float centerX = this.cvw.centerX();
        float centerY = this.cvw.centerY();
        float f3 = sqrt / 2.0f;
        float f4 = centerX - f3;
        float f5 = centerX + f3;
        float f6 = sqrt2 / 2.0f;
        this.cvw.set(f4, centerY - f6, f5, centerY + f6);
        invalidate();
        this.btV.invalidate();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public RectF mo31062a(Matrix matrix, RectF rectF) {
        StringBuilder sb = new StringBuilder();
        sb.append("getDisplayRect1 supportRect:");
        sb.append(rectF);
        LogUtils.m14223i("TAG", sb.toString());
        RectF rectF2 = new RectF(rectF);
        matrix.mapRect(rectF2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getDisplayRect2 supportRect:");
        sb2.append(rectF2);
        LogUtils.m14223i("TAG", sb2.toString());
        return rectF2;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (java.lang.Math.abs(r10.drT) < 30.0f) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        if (java.lang.Math.abs(r10.drT) < 30.0f) goto L_0x003f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo31063a(int r11, android.view.MotionEvent r12, float r13, float r14) {
        /*
            r10 = this;
            r0 = 1
            if (r11 != r0) goto L_0x0004
            return
        L_0x0004:
            r1 = 64
            r2 = -1
            r3 = 0
            if (r11 != r1) goto L_0x0060
            int r4 = r10.drQ
            if (r4 == r2) goto L_0x0018
            float r4 = r10.drS
            float r4 = r4 + r13
            r10.drS = r4
            float r4 = r10.drT
            float r4 = r4 + r14
            r10.drT = r4
        L_0x0018:
            float r4 = r10.drS
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x0024
            float r4 = r10.drT
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x0060
        L_0x0024:
            int r4 = r10.drQ
            r5 = 1106247680(0x41f00000, float:30.0)
            if (r4 != 0) goto L_0x0041
            float r4 = r10.drS
            float r4 = java.lang.Math.abs(r4)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x0035
            r13 = 0
        L_0x0035:
            float r4 = r10.drT
            float r4 = java.lang.Math.abs(r4)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0060
        L_0x003f:
            r14 = 0
            goto L_0x0060
        L_0x0041:
            int r4 = r10.drQ
            if (r4 != r0) goto L_0x0050
            float r4 = r10.drT
            float r4 = java.lang.Math.abs(r4)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0060
            goto L_0x003f
        L_0x0050:
            int r4 = r10.drQ
            r6 = 2
            if (r4 != r6) goto L_0x0060
            float r4 = r10.drS
            float r4 = java.lang.Math.abs(r4)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0060
            r13 = 0
        L_0x0060:
            float[] r4 = r10.cvN
            r5 = 0
            r4[r5] = r13
            float[] r4 = r10.cvN
            r4[r0] = r14
            android.view.View r4 = r10.btV
            int r4 = r4.getMeasuredHeight()
            android.view.View r6 = r10.btV
            int r6 = r6.getMeasuredWidth()
            android.graphics.RectF r7 = r10.cvw
            float r7 = r7.width()
            android.graphics.RectF r8 = r10.cvv
            float r8 = r8.width()
            float r7 = r7 / r8
            float r7 = r7 * r13
            android.graphics.RectF r8 = r10.cvw
            float r8 = r8.height()
            android.graphics.RectF r9 = r10.cvv
            float r9 = r9.height()
            float r8 = r8 / r9
            float r8 = r8 * r14
            if (r11 != r1) goto L_0x0148
            com.introvd.template.editor.widget.scalerotate.b$d r12 = r10.drF
            if (r12 == 0) goto L_0x009e
            com.introvd.template.editor.widget.scalerotate.b$d r12 = r10.drF
            r12.mo28384ff(r0)
        L_0x009e:
            boolean r12 = r10.cvK
            if (r12 == 0) goto L_0x0115
            android.graphics.RectF r12 = r10.acK()
            android.graphics.Matrix r13 = new android.graphics.Matrix
            r13.<init>()
            r13.postTranslate(r7, r8)
            float r14 = r10.mRotation
            float r14 = -r14
            float r0 = r12.centerX()
            float r1 = r12.centerY()
            r13.postRotate(r14, r0, r1)
            android.graphics.RectF r14 = new android.graphics.RectF
            r14.<init>()
            r13.mapRect(r14, r12)
            r12 = 1092616192(0x41200000, float:10.0)
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x00dd
            float r13 = r14.centerX()
            float r13 = r13 + r12
            float r13 = r13 + r7
            float r0 = (float) r6
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r13 <= 0) goto L_0x00ee
            float r13 = r14.centerX()
            float r0 = r0 - r13
            float r0 = r0 - r12
            r7 = r0
            goto L_0x00ee
        L_0x00dd:
            float r13 = r14.centerX()
            float r13 = r13 - r12
            float r13 = r13 + r7
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x00ee
            float r13 = r14.centerX()
            float r13 = r12 - r13
            r7 = r13
        L_0x00ee:
            int r13 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x0105
            float r13 = r14.centerY()
            float r13 = r13 + r12
            float r13 = r13 + r8
            float r0 = (float) r4
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r13 <= 0) goto L_0x0115
            float r0 = r0 - r12
            float r12 = r14.centerY()
            float r8 = r0 - r12
            goto L_0x0115
        L_0x0105:
            float r13 = r14.centerY()
            float r13 = r13 - r12
            float r13 = r13 + r8
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x0115
            float r13 = r14.centerY()
            float r8 = r12 - r13
        L_0x0115:
            r10.mo31130v(r7, r8)
            com.introvd.template.editor.widget.scalerotate.b$d r12 = r10.drF
            if (r12 == 0) goto L_0x019c
            android.graphics.RectF r12 = r10.cvv
            float r12 = r12.centerX()
            int r12 = (int) r12
            android.graphics.RectF r13 = r10.cvv
            float r13 = r13.centerY()
            int r13 = (int) r13
            com.introvd.template.editor.widget.scalerotate.b$d r14 = r10.drF
            int r14 = r14.mo28381cv(r12, r13)
            if (r14 == r2) goto L_0x0136
            int r0 = r10.drQ
            if (r14 == r0) goto L_0x013f
        L_0x0136:
            com.introvd.template.editor.widget.scalerotate.b$d r0 = r10.drF
            r0.mo28382cw(r12, r13)
            r10.drS = r3
            r10.drT = r3
        L_0x013f:
            if (r14 != r2) goto L_0x0145
            r10.drS = r3
            r10.drT = r3
        L_0x0145:
            r10.drQ = r14
            goto L_0x019c
        L_0x0148:
            r1 = 32
            if (r11 != r1) goto L_0x016c
            float[] r13 = r10.cvN
            r13 = r13[r5]
            float[] r14 = r10.cvN
            r14 = r14[r0]
            float r0 = r12.getX()
            float r12 = r12.getY()
            r10.m20694j(r0, r12, r13, r14)
            r10.invalidate()
            android.view.View r12 = r10.btV
            android.graphics.Rect r13 = r10.acJ()
            r12.invalidate(r13)
            goto L_0x019c
        L_0x016c:
            r12 = 128(0x80, float:1.794E-43)
            if (r11 == r12) goto L_0x0195
            r12 = 256(0x100, float:3.59E-43)
            if (r11 == r12) goto L_0x0195
            r12 = 512(0x200, float:7.175E-43)
            if (r11 == r12) goto L_0x0195
            r12 = 1024(0x400, float:1.435E-42)
            if (r11 != r12) goto L_0x017d
            goto L_0x0195
        L_0x017d:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0182
            r0 = -1
        L_0x0182:
            float r12 = (float) r0
            float r12 = r12 * r7
            r10.mo31082ag(r12)
            r10.invalidate()
            android.view.View r12 = r10.btV
            android.graphics.Rect r13 = r10.acJ()
            r12.invalidate(r13)
            goto L_0x019c
        L_0x0195:
            float r12 = r10.m20688a(r13, r14, r11)
            r10.m20693e(r12, r11)
        L_0x019c:
            com.introvd.template.editor.widget.scalerotate.b$c r12 = r10.drG
            if (r12 == 0) goto L_0x01ab
            com.introvd.template.editor.widget.scalerotate.b$c r12 = r10.drG
            android.graphics.RectF r13 = r10.acI()
            float r14 = r10.mRotation
            r12.mo28375a(r13, r14, r11)
        L_0x01ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.widget.scalerotate.C7070b.mo31063a(int, android.view.MotionEvent, float, float):void");
    }

    /* renamed from: a */
    public void mo31064a(Matrix matrix, RectF rectF, boolean z) {
        init();
        this.mMatrix = new Matrix(matrix);
        this.mRotation = 0.0f;
        this.bWZ = new Matrix();
        this.cvw = rectF;
    }

    /* renamed from: a */
    public void mo31065a(C7072b bVar) {
        if (bVar != this.drH) {
            this.drH = bVar;
            acL();
            this.btV.invalidate();
        }
    }

    /* renamed from: a */
    public void mo31066a(C7073c cVar) {
        this.drG = cVar;
    }

    /* renamed from: a */
    public void mo31067a(C7074d dVar) {
        this.drF = dVar;
    }

    /* access modifiers changed from: protected */
    public RectF acH() {
        return mo31062a(this.mMatrix, this.cvw);
    }

    public RectF acI() {
        RectF rectF = new RectF(this.cvv);
        rectF.inset((float) (-this.mPadding), (float) (-this.mPadding));
        return rectF;
    }

    public BitmapDrawable acN() {
        return this.cvH;
    }

    public boolean acO() {
        return this.cvx;
    }

    public float acP() {
        this.mRotation = m20691aB(this.mRotation);
        return this.mRotation;
    }

    public int acQ() {
        return this.mOutlineEllipse;
    }

    public int acR() {
        return this.mOutlineStrokeColor;
    }

    public Paint acS() {
        return this.bXc;
    }

    public float acU() {
        return cvp;
    }

    public float acV() {
        return cvo;
    }

    public float acW() {
        return cvm;
    }

    public float acX() {
        return cvn;
    }

    public RectF acY() {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("getDrawRect mDrawRect=");
        sb.append(this.cvv);
        sb.append(";mCropRect");
        sb.append(this.cvw);
        LogUtils.m14223i(str, sb.toString());
        return this.cvv;
    }

    public boolean acZ() {
        return this.cvC;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ag */
    public void mo31082ag(float f) {
        m20695w(f, f / this.cvt);
    }

    /* renamed from: ah */
    public void mo31083ah(float f) {
        this.mRotation = m20691aB(m20689a(this.mRotation + f, true));
    }

    /* renamed from: ai */
    public void mo31084ai(float f) {
        this.cvt = f;
        cvp = (float) Math.sqrt((double) ((((float) (this.btV.getWidth() * this.btV.getHeight())) / 36.0f) / (1.0f + f)));
        cvo = cvp * f;
    }

    public C7072b auM() {
        return this.drH;
    }

    public boolean auN() {
        return this.cvL;
    }

    public boolean auO() {
        return this.drP;
    }

    public boolean auP() {
        return this.cvM;
    }

    public void auQ() {
        this.drT = 0.0f;
        this.drS = 0.0f;
        if (this.drF != null) {
            this.drF.mo28384ff(false);
        }
        if (this.drG != null) {
            this.drG.aiH();
        }
    }

    public float auR() {
        return ((float) this.drU) / 255.0f;
    }

    /* renamed from: ck */
    public boolean mo31091ck(int i, int i2) {
        RectF acI = acI();
        int i3 = (int) acI.left;
        int i4 = (int) acI.top;
        int i5 = (int) acI.right;
        int i6 = (int) acI.bottom;
        return new Rect(i3 - this.cvF, i4 - this.cvG, this.cvF + i3, this.cvG + i4).contains(i, i2) || new Rect(i5 - this.cvF, i4 - this.cvG, this.cvF + i5, i4 + this.cvG).contains(i, i2) || new Rect(i3 - this.cvF, i6 - this.cvG, i3 + this.cvF, this.cvG + i6).contains(i, i2) || new Rect(i5 - this.cvF, i6 - this.cvG, i5 + this.cvF, i6 + this.cvG).contains(i, i2);
    }

    public void dispose() {
        this.btV = null;
    }

    /* access modifiers changed from: protected */
    public void draw(Canvas canvas) {
        int save = canvas.save();
        canvas.concat(this.bWZ);
        if (this.cvH != null) {
            if (acZ()) {
                Matrix matrix = new Matrix();
                float f = 1.0f;
                float f2 = this.isHorFlip ? -1.0f : 1.0f;
                if (this.isVerFlip) {
                    f = -1.0f;
                }
                matrix.setScale(f2, f);
                float f3 = 0.0f;
                float width = this.isHorFlip ? (this.cvv.left * 2.0f) + this.cvv.width() : 0.0f;
                if (this.isVerFlip) {
                    f3 = (this.cvv.top * 2.0f) + this.cvv.height();
                }
                matrix.postTranslate(width, f3);
                canvas.save();
                canvas.concat(matrix);
                this.cvH.setBounds(new Rect((int) this.cvv.left, (int) this.cvv.top, (int) this.cvv.right, (int) this.cvv.bottom));
                this.cvH.draw(canvas);
                canvas.restore();
            } else {
                this.cvH.setBounds(new Rect((int) this.cvv.left, (int) this.cvv.top, (int) this.cvv.right, (int) this.cvv.bottom));
                this.cvH.setAlpha(this.drU);
                Bitmap bitmap = this.cvH.getBitmap();
                if (bitmap == null || bitmap.getByteCount() < 100000000) {
                    this.cvH.draw(canvas);
                } else {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("bitmap.getByteCount() = ");
                        sb.append(bitmap.getByteCount());
                        sb.append(", bitmap.getHeight() = ");
                        sb.append(bitmap.getHeight());
                        sb.append(", bitmap.getWidth() = ");
                        sb.append(bitmap.getWidth());
                        C5523b.logException(new C5526d(sb.toString()));
                    } catch (Exception unused) {
                    }
                    return;
                }
            }
        }
        if (this.drI) {
            m20687P(canvas);
        } else {
            m20696w(canvas);
        }
        canvas.restoreToCount(save);
    }

    /* renamed from: ea */
    public void mo31094ea(boolean z) {
        this.cvx = z;
    }

    /* renamed from: eb */
    public void mo31095eb(boolean z) {
        this.cvJ = z;
    }

    /* renamed from: ec */
    public void mo31096ec(boolean z) {
        this.cvL = z;
    }

    /* renamed from: ed */
    public void mo31097ed(boolean z) {
        this.cvU = z;
    }

    /* renamed from: ee */
    public void mo31098ee(boolean z) {
        this.cvO = z;
    }

    /* renamed from: ef */
    public void mo31099ef(boolean z) {
        this.cvP = z;
    }

    public RectF getDisplayRec() {
        if (this.cvv == null) {
            return null;
        }
        return mo31062a(this.bWZ, acI());
    }

    public int getPadding() {
        return this.mPadding;
    }

    /* renamed from: hH */
    public void mo31102hH(boolean z) {
        this.drP = z;
    }

    /* renamed from: hI */
    public void mo31103hI(boolean z) {
        this.cvL = z;
    }

    /* renamed from: hJ */
    public void mo31104hJ(boolean z) {
        this.drP = z;
    }

    /* renamed from: hK */
    public void mo31105hK(boolean z) {
        this.cvM = z;
    }

    /* renamed from: hL */
    public void mo31106hL(boolean z) {
        this.drI = z;
    }

    public void invalidate() {
        this.cvv = acH();
        float centerX = this.cvv.centerX();
        float centerY = this.cvv.centerY();
        this.bWZ.reset();
        this.bWZ.postTranslate(-centerX, -centerY);
        this.bWZ.postRotate(this.mRotation);
        this.bWZ.postTranslate(centerX, centerY);
    }

    public boolean isAnimOn() {
        return this.isAnimOn;
    }

    public boolean isHorFlip() {
        return this.isHorFlip;
    }

    public boolean isVerFlip() {
        return this.isVerFlip;
    }

    /* renamed from: kR */
    public void mo31111kR(int i) {
        this.mOutlineEllipse = i;
    }

    /* renamed from: kS */
    public void mo31112kS(int i) {
        this.mOutlineStrokeColor = i;
        this.bXc.setColor(this.mOutlineStrokeColor);
        this.bXc.setColor(this.drH != C7072b.None ? this.cvI : this.mOutlineStrokeColor);
    }

    /* renamed from: qf */
    public void mo31113qf(int i) {
        float f;
        float f2;
        if (this.cvv == null) {
            invalidate();
            return;
        }
        float centerX = this.cvv.centerX();
        float centerY = this.cvv.centerY();
        float width = this.cvw.width();
        float height = this.cvw.height();
        if (i == 512) {
            double d = (double) ((this.cvw.right - this.cvv.right) / 2.0f);
            f = (float) (((double) centerX) + (Math.cos(Math.toRadians((double) this.mRotation)) * d));
            f2 = (float) (((double) centerY) + (d * Math.sin(Math.toRadians((double) this.mRotation))));
        } else if (i == 128) {
            double d2 = (double) ((-(this.cvw.left - this.cvv.left)) / 2.0f);
            f = (float) (((double) centerX) - (Math.cos(Math.toRadians((double) this.mRotation)) * d2));
            f2 = (float) (((double) centerY) - (d2 * Math.sin(Math.toRadians((double) this.mRotation))));
        } else if (i == 1024) {
            double d3 = (double) ((-(this.cvw.top - this.cvv.top)) / 2.0f);
            f = (float) (((double) centerX) + (Math.sin(Math.toRadians((double) this.mRotation)) * d3));
            f2 = (float) (((double) centerY) - (d3 * Math.cos(Math.toRadians((double) this.mRotation))));
        } else {
            double d4 = (double) ((this.cvw.bottom - this.cvv.bottom) / 2.0f);
            f = (float) (((double) centerX) - (Math.sin(Math.toRadians((double) this.mRotation)) * d4));
            f2 = (float) (((double) centerY) + (d4 * Math.cos(Math.toRadians((double) this.mRotation))));
        }
        float f3 = f * 2.0f;
        float f4 = (f3 + width) / 2.0f;
        float f5 = (f3 - width) / 2.0f;
        float f6 = f2 * 2.0f;
        float f7 = (f6 + height) / 2.0f;
        this.cvv.set(f5, (f6 - height) / 2.0f, f4, f7);
        this.cvw.set(this.cvv);
        if (this.cvw.height() > 0.0f) {
            this.cvt = this.cvw.width() / this.cvw.height();
        }
        this.bWZ.reset();
        this.bWZ.postTranslate(-f, -f2);
        this.bWZ.postRotate(this.mRotation);
        this.bWZ.postTranslate(f, f2);
    }

    /* renamed from: qg */
    public void mo31114qg(int i) {
        this.cvI = i;
        this.bXc.setColor(this.cvI);
        this.bXc.setColor(this.drH != C7072b.None ? this.cvI : this.mOutlineStrokeColor);
    }

    /* renamed from: qh */
    public void mo31115qh(int i) {
        this.drU = i;
        this.btV.invalidate();
    }

    public void setAnchorAnimDrawable(Drawable drawable, Drawable drawable2) {
        this.cvy = drawable;
        this.cvz = drawable2;
    }

    public void setAnchorDrawable(Drawable drawable, Drawable drawable2) {
        this.cvD = drawable;
        this.cvE = drawable2;
        if (this.cvD != null) {
            this.cvF = this.cvD.getIntrinsicWidth() / 2;
            this.cvG = this.cvD.getIntrinsicHeight() / 2;
        }
    }

    public void setAnimOn(boolean z) {
        this.isAnimOn = z;
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            float cl = m20692cl(bitmap.getWidth(), bitmap.getHeight());
            if (cl != 1.0f) {
                Matrix matrix = new Matrix();
                matrix.postScale(cl, cl);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
            this.cvH = new BitmapDrawable(this.btV.getResources(), bitmap);
            return;
        }
        this.cvH = null;
    }

    public void setEnableFlip(boolean z) {
        this.cvC = z;
    }

    public void setHorFlip(boolean z) {
        this.isHorFlip = z;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setRotate(float f) {
        this.mRotation = m20691aB(f);
        acL();
    }

    public void setStretchDrawable(Drawable drawable) {
        this.drM = drawable;
        if (this.drM != null) {
            this.drR = true;
        } else {
            this.drR = false;
        }
    }

    public void setVerFlip(boolean z) {
        this.isVerFlip = z;
    }

    public void setViewPosition(Rect rect, float f) {
        if (rect != null) {
            this.cvw.set(rect);
            this.mRotation = m20691aB(f);
            invalidate();
            this.btV.invalidate();
        }
    }

    public void setmSelected(boolean z) {
        this.mSelected = z;
    }

    /* renamed from: t */
    public int mo31128t(float f, float f2) {
        int i;
        RectF acI = acI();
        boolean z = false;
        float[] fArr = {f, f2};
        Matrix matrix = new Matrix();
        matrix.postTranslate(-acI.centerX(), -acI.centerY());
        matrix.postRotate(-this.mRotation);
        matrix.postTranslate(acI.centerX(), acI.centerY());
        matrix.mapPoints(fArr);
        float f3 = fArr[0];
        float f4 = fArr[1];
        this.btV.invalidate();
        boolean z2 = f4 >= acI.top - cvq && f4 < acI.bottom + cvq;
        boolean z3 = f3 >= acI.left - cvq && f3 < acI.right + cvq;
        if (!this.cvJ) {
            i = (Math.abs(acI.left - f3) >= cvq || !z2) ? 1 : 3;
            if (Math.abs(acI.right - f3) < cvq && z2) {
                i |= 4;
            }
            if (Math.abs(acI.top - f4) < cvq && z3) {
                i |= 8;
            }
            if (Math.abs(acI.bottom - f4) < cvq && z3) {
                i |= 16;
            }
        } else {
            i = 1;
        }
        float f5 = cvq;
        if (f5 > acI.height() / 4.0f) {
            f5 = acI.height() / 4.0f;
            if (f5 < ((float) (this.cvF / 2))) {
                f5 = (float) (this.cvF / 2);
            }
        }
        if ((!C4580b.m11666qi() ? !(Math.abs(acI.right - f3) >= f5 || Math.abs(acI.bottom - f4) >= f5) : !(Math.abs(acI.left - f3) >= f5 || Math.abs(acI.bottom - f4) >= f5)) && z2 && z3 && !this.drI) {
            i = 32;
        }
        boolean z4 = Math.abs(acI.left - f3) < f5 && Math.abs(((acI.top + acI.bottom) / 2.0f) - f4) < f5;
        if (this.drM != null && z4 && z2 && z3) {
            i = 128;
        }
        boolean z5 = Math.abs(acI.right - f3) < f5 && Math.abs(((acI.top + acI.bottom) / 2.0f) - f4) < f5;
        if (this.drM != null && z5 && z2 && z3) {
            i = 512;
        }
        boolean z6 = Math.abs(((acI.left + acI.right) / 2.0f) - f3) < f5 && Math.abs(acI.bottom - f4) < f5;
        if (this.drM != null && z6 && z2 && z3) {
            i = 256;
        }
        if (Math.abs(((acI.left + acI.right) / 2.0f) - f3) < f5 && Math.abs(acI.top - f4) < f5) {
            z = true;
        }
        if (this.drM != null && z && z2 && z3) {
            i = 1024;
        }
        if (Math.abs(acI.left - f3) < f5 && Math.abs(acI.top - f4) < f5 && z2 && z3) {
            return i;
        }
        if (Math.abs(acI.right - f3) < f5 && Math.abs(acI.top - f4) < f5 && z2 && z3) {
            return i;
        }
        if (i == 1 && acI.contains((float) ((int) f3), (float) ((int) f4))) {
            i = 64;
        }
        this.cwg = i;
        return i;
    }

    /* renamed from: u */
    public void mo31129u(float f, float f2) {
        RectF acI = acI();
        boolean z = true;
        float[] fArr = {f, f2};
        Matrix matrix = new Matrix();
        matrix.postTranslate(-acI.centerX(), -acI.centerY());
        matrix.postRotate(-this.mRotation);
        matrix.postTranslate(acI.centerX(), acI.centerY());
        matrix.mapPoints(fArr);
        float f3 = fArr[0];
        float f4 = fArr[1];
        this.btV.invalidate();
        boolean z2 = f4 >= acI.top - cvq && f4 < acI.bottom + cvq;
        boolean z3 = f3 >= acI.left - cvq && f3 < acI.right + cvq;
        boolean z4 = !C4580b.m11666qi() ? !(Math.abs(acI.left - f3) >= cvq || Math.abs(acI.bottom - f4) >= cvq) : !(Math.abs(acI.right - f3) >= cvq || Math.abs(acI.bottom - f4) >= cvq);
        if (this.cvM && this.cvA != null && this.cvB != null && z4 && z2 && z3 && this.drF != null) {
            this.drF.mo28383eg(isHorFlip() ^ isVerFlip());
        }
        boolean z5 = !C4580b.m11666qi() ? !(Math.abs(acI.left - f3) >= cvq || Math.abs(acI.top - f4) >= cvq) : !(Math.abs(acI.right - f3) >= cvq || Math.abs(acI.top - f4) >= cvq);
        if (this.cvL && this.cvE != null && z5 && z2 && z3 && this.drF != null) {
            this.drF.aan();
        }
        boolean z6 = !C4580b.m11666qi() ? !(Math.abs(acI.right - f3) >= cvq || Math.abs(acI.top - f4) >= cvq) : !(Math.abs(acI.left - f3) >= cvq || Math.abs(acI.top - f4) >= cvq);
        if (this.drP && this.drL != null && z6 && z2 && z3 && this.drF != null) {
            this.drF.aiI();
        }
        if (Math.abs(acI.right - f3) >= cvq || Math.abs(acI.top - f4) >= cvq) {
            z = false;
        }
        if (this.drK != null && z && this.drF != null) {
            this.drF.aiJ();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public void mo31130v(float f, float f2) {
        if (!this.drJ || !m20686J(f, f2)) {
            this.cvw.offset(f, f2);
            invalidate();
            this.btV.invalidate();
        }
    }
}
