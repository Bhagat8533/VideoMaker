package com.introvd.template.editor.advance;

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
import android.view.MotionEvent;
import android.view.View;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.editor.widget.scalerotate.C7064a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.editor.EditorRouter;

/* renamed from: com.introvd.template.editor.advance.j */
public class C5605j {
    private static final String TAG = "j";
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
    private C5606a cvr = C5606a.Center;
    private C5608c cvs;
    private float cvt;
    private C5607b cvu;
    private RectF cvv;
    private RectF cvw;
    private boolean cvx;
    private Drawable cvy;
    private Drawable cvz;
    private boolean isAnimOn;
    private boolean isHorFlip;
    private boolean isVerFlip;
    private Matrix mMatrix;
    private int mOutlineEllipse;
    private int mOutlineStrokeColor;
    private int mPadding;
    private float mRotation;
    private boolean mSelected;

    /* renamed from: com.introvd.template.editor.advance.j$a */
    public enum C5606a {
        Top,
        Bottom,
        Center
    }

    /* renamed from: com.introvd.template.editor.advance.j$b */
    public enum C5607b {
        None,
        Move,
        Grow,
        Pointer_Grow,
        Rotate
    }

    /* renamed from: com.introvd.template.editor.advance.j$c */
    public interface C5608c {
        void aan();

        /* renamed from: eg */
        void mo27599eg(boolean z);
    }

    public C5605j(View view) {
        float f = 1.0f;
        this.cvt = 1.0f;
        this.cvx = false;
        this.isAnimOn = false;
        this.cvA = null;
        this.cvB = null;
        this.isVerFlip = false;
        this.isHorFlip = false;
        this.cvC = false;
        this.btV = null;
        this.cvK = false;
        this.cvL = true;
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
        this.cvU = true;
        this.btV = view;
        if (Constants.getDeviceDensity() >= 1.5f) {
            f = 2.0f;
        }
        cvm = ((float) view.getWidth()) * f;
        cvn = ((float) view.getHeight()) * f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        if (java.lang.Math.abs(270.0f + r7) < r8) goto L_0x003f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float m15356a(float r7, boolean r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x0006
            r8 = 1045220557(0x3e4ccccd, float:0.2)
            goto L_0x0008
        L_0x0006:
            r8 = 1084227584(0x40a00000, float:5.0)
        L_0x0008:
            r0 = 1135869952(0x43b40000, float:360.0)
            r1 = 1132920832(0x43870000, float:270.0)
            r2 = 1119092736(0x42b40000, float:90.0)
            r3 = 1127481344(0x43340000, float:180.0)
            r4 = 0
            int r5 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x004f
            float r5 = java.lang.Math.abs(r7)
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x004d
            float r0 = r7 - r0
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0028
            goto L_0x004d
        L_0x0028:
            float r0 = r7 - r3
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0035
        L_0x0032:
            r1 = 1127481344(0x43340000, float:180.0)
            goto L_0x0086
        L_0x0035:
            float r0 = r7 - r2
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0042
        L_0x003f:
            r1 = 1119092736(0x42b40000, float:90.0)
            goto L_0x0086
        L_0x0042:
            float r0 = r7 - r1
            float r0 = java.lang.Math.abs(r0)
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0085
            goto L_0x0086
        L_0x004d:
            r1 = 0
            goto L_0x0086
        L_0x004f:
            int r5 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x0085
            float r5 = java.lang.Math.abs(r7)
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x004d
            float r0 = r0 + r7
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0065
            goto L_0x004d
        L_0x0065:
            float r0 = r7 + r3
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            goto L_0x0032
        L_0x0070:
            float r0 = r7 + r2
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x007b
            goto L_0x0086
        L_0x007b:
            float r1 = r1 + r7
            float r0 = java.lang.Math.abs(r1)
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0085
            goto L_0x003f
        L_0x0085:
            r1 = r7
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.C5605j.m15356a(float, boolean):float");
    }

    /* renamed from: a */
    private void m15357a(Canvas canvas, RectF rectF) {
        int i = (int) rectF.left;
        int i2 = (int) rectF.right;
        int i3 = (int) rectF.top;
        int i4 = (int) rectF.bottom;
        if (!(this.cvy == null || this.cvz == null)) {
            if (!acO()) {
                this.cvz.setBounds(i - this.cvF, i3 - this.cvG, this.cvF + i, this.cvG + i3);
                this.cvz.draw(canvas);
            } else if (isAnimOn()) {
                this.cvy.setBounds(i - this.cvF, i3 - this.cvG, this.cvF + i, this.cvG + i3);
                this.cvy.draw(canvas);
            } else {
                this.cvz.setBounds(i - this.cvF, i3 - this.cvG, this.cvF + i, this.cvG + i3);
                this.cvz.draw(canvas);
            }
        }
        if (this.cvD != null) {
            if (C4580b.m11666qi()) {
                this.cvD.setBounds(i - this.cvF, i4 - this.cvG, this.cvF + i, i4 + this.cvG);
            } else {
                this.cvD.setBounds(i2 - this.cvF, i4 - this.cvG, this.cvF + i2, i4 + this.cvG);
            }
            this.cvD.draw(canvas);
        }
        if (!(this.cvB == null || this.cvA == null)) {
            if (isVerFlip() ^ isHorFlip()) {
                if (C4580b.m11666qi()) {
                    this.cvB.setBounds(i2 - this.cvF, i3 - this.cvG, this.cvF + i2, this.cvG + i3);
                } else {
                    this.cvB.setBounds(i - this.cvF, i3 - this.cvG, this.cvF + i, this.cvG + i3);
                }
                this.cvB.draw(canvas);
            } else {
                if (C4580b.m11666qi()) {
                    this.cvA.setBounds(i2 - this.cvF, i3 - this.cvG, this.cvF + i2, this.cvG + i3);
                } else {
                    this.cvA.setBounds(i - this.cvF, i3 - this.cvG, this.cvF + i, this.cvG + i3);
                }
                this.cvA.draw(canvas);
            }
        }
        if (this.cvE != null && this.cvL) {
            if (C4580b.m11666qi()) {
                this.cvE.setBounds(i - this.cvF, i3 - this.cvG, i + this.cvF, i3 + this.cvG);
            } else {
                this.cvE.setBounds(i2 - this.cvF, i3 - this.cvG, i2 + this.cvF, i3 + this.cvG);
            }
            this.cvE.draw(canvas);
        }
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
        this.bXc.setColor((!acM() || this.cvu == C5607b.None) ? this.mOutlineStrokeColor : this.cvI);
        this.cvQ.setColor(this.cvu != C5607b.None ? this.cvI : -1);
        this.cvR.setColor(this.cvu == C5607b.None ? this.cvS : this.cvT);
    }

    private boolean acM() {
        return this.mRotation == 0.0f || this.mRotation == 90.0f || this.mRotation == 180.0f || this.mRotation == 270.0f;
    }

    /* renamed from: cl */
    private float m15358cl(int i, int i2) {
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

    private void init() {
        this.mOutlineStrokeColor = -6238720;
        this.cvI = -1;
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{8.0f, 8.0f}, 1.0f);
        this.bXc = new Paint(1);
        this.bXc.setStrokeWidth(1.0f);
        this.bXc.setStyle(Style.STROKE);
        this.bXc.setColor(this.mOutlineStrokeColor);
        this.bXc.setPathEffect(dashPathEffect);
        DashPathEffect dashPathEffect2 = new DashPathEffect(new float[]{6.0f, 6.0f}, 1.0f);
        this.cvQ = new Paint(1);
        this.cvQ.setStrokeWidth(2.0f);
        this.cvQ.setStyle(Style.STROKE);
        this.cvQ.setColor(this.mOutlineStrokeColor);
        this.cvQ.setPathEffect(dashPathEffect2);
        this.cvR = new Paint(1);
        this.cvR.setStyle(Style.FILL);
        this.cvR.setColor(this.cvS);
        mo27549a(C5607b.None);
    }

    /* renamed from: j */
    private void m15359j(float f, float f2, float f3, float f4) {
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
            this.mRotation = m15356a(this.mRotation, false);
            acL();
            mo27566ag(d);
            return;
        }
        this.mRotation = -((float) (c2 - c));
    }

    /* renamed from: w */
    private void m15360w(float f, float f2) {
        RectF rectF = new RectF(this.cvw);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("getDisplayRect6 supportRect:");
        sb.append(rectF.width());
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append(rectF.height());
        LogUtils.m14223i(str, sb.toString());
        if (this.cvr == C5606a.Center) {
            rectF.inset(-f, -f2);
        } else if (this.cvr == C5606a.Top) {
            rectF.inset(-f, 0.0f);
            rectF.bottom += 2.0f * f2;
        } else {
            rectF.inset(-f, 0.0f);
            rectF.top -= 2.0f * f2;
        }
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getDisplayRect7 supportRect:");
        sb2.append(rectF.width());
        sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb2.append(rectF.height());
        LogUtils.m14223i(str2, sb2.toString());
        RectF a = mo27546a(this.mMatrix, rectF);
        if ((a.height() < this.cvw.height() || a.width() < this.cvw.width()) && (a.height() < cvp || a.width() < cvo)) {
            rectF.set(this.cvw);
        }
        if (f > 0.0f && f2 > 0.0f && (a.width() >= cvm || a.height() >= cvn)) {
            rectF.set(this.cvw);
        }
        String str3 = TAG;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("getDisplayRect3 supportRect:");
        sb3.append(rectF.width());
        sb3.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb3.append(rectF.height());
        LogUtils.m14223i(str3, sb3.toString());
        String str4 = TAG;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("getDisplayRect4 supportRect:");
        sb4.append(this.cvw.width());
        sb4.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb4.append(this.cvw.height());
        LogUtils.m14223i(str4, sb4.toString());
        this.cvw.set(rectF);
        invalidate();
        this.btV.invalidate();
    }

    /* renamed from: w */
    private void m15361w(Canvas canvas) {
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
            m15357a(canvas, acI);
        }
    }

    /* renamed from: D */
    public void mo27543D(Drawable drawable) {
        this.cvE = drawable;
    }

    /* renamed from: E */
    public void mo27544E(Drawable drawable) {
        this.cvA = drawable;
    }

    /* renamed from: F */
    public void mo27545F(Drawable drawable) {
        this.cvB = drawable;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public RectF mo27546a(Matrix matrix, RectF rectF) {
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
    /* renamed from: a */
    public void mo27547a(int i, MotionEvent motionEvent, float f, float f2) {
        int i2 = 1;
        if (i != 1) {
            this.cvN[0] = f;
            this.cvN[1] = f2;
            int measuredHeight = this.btV.getMeasuredHeight();
            int measuredWidth = this.btV.getMeasuredWidth();
            float width = f * (this.cvw.width() / this.cvv.width());
            float height = f2 * (this.cvw.height() / this.cvv.height());
            if (i == 64) {
                if (this.cvK) {
                    RectF acK = acK();
                    Matrix matrix = new Matrix();
                    matrix.postTranslate(width, height);
                    matrix.postRotate(-this.mRotation, acK.centerX(), acK.centerY());
                    RectF rectF = new RectF();
                    matrix.mapRect(rectF, acK);
                    if (width > 0.0f) {
                        float f3 = (float) measuredWidth;
                        if (rectF.centerX() + 10.0f + width > f3) {
                            width = (f3 - rectF.centerX()) - 10.0f;
                        }
                    } else if ((rectF.centerX() - 10.0f) + width < 0.0f) {
                        width = 10.0f - rectF.centerX();
                    }
                    if (height > 0.0f) {
                        float f4 = (float) measuredHeight;
                        if (rectF.centerY() + 10.0f + height > f4) {
                            height = (f4 - 10.0f) - rectF.centerY();
                        }
                    } else if ((rectF.centerY() - 10.0f) + height < 0.0f) {
                        height = 10.0f - rectF.centerY();
                    }
                }
                mo27597v(width, height);
            } else if (i == 32) {
                m15359j(motionEvent.getX(), motionEvent.getY(), this.cvN[0], this.cvN[1]);
                invalidate();
                this.btV.invalidate(acJ());
            } else {
                Matrix matrix2 = new Matrix();
                matrix2.postRotate(-this.mRotation);
                matrix2.mapPoints(this.cvN);
                float f5 = this.cvN[0];
                float f6 = this.cvN[1];
                int i3 = i & 6;
                int i4 = i & 24;
                if ((i & 2) != 0) {
                    i2 = -1;
                }
                mo27566ag(((float) i2) * width);
                invalidate();
                this.btV.invalidate(acJ());
            }
        }
    }

    /* renamed from: a */
    public void mo27548a(Matrix matrix, RectF rectF, boolean z) {
        init();
        this.mMatrix = new Matrix(matrix);
        this.mRotation = 0.0f;
        this.bWZ = new Matrix();
        this.cvw = rectF;
    }

    /* renamed from: a */
    public void mo27549a(C5607b bVar) {
        if (bVar != this.cvu) {
            this.cvu = bVar;
            acL();
            this.btV.invalidate();
        }
    }

    /* renamed from: a */
    public void mo27550a(C5608c cVar) {
        this.cvs = cVar;
    }

    /* access modifiers changed from: protected */
    public RectF acH() {
        return mo27546a(this.mMatrix, this.cvw);
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

    public C5607b acT() {
        return this.cvu;
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
    public void mo27566ag(float f) {
        m15360w(f, f / this.cvt);
    }

    /* renamed from: ah */
    public void mo27567ah(float f) {
        this.mRotation = m15356a(this.mRotation + f, true);
    }

    /* renamed from: ai */
    public void mo27568ai(float f) {
        this.cvt = f;
        cvp = (float) Math.sqrt((double) ((((float) (this.btV.getWidth() * this.btV.getHeight())) / 36.0f) / (1.0f + f)));
        cvo = cvp * f;
    }

    /* renamed from: ck */
    public boolean mo27569ck(int i, int i2) {
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
        m15361w(canvas);
        canvas.restoreToCount(save);
    }

    /* renamed from: ea */
    public void mo27572ea(boolean z) {
        this.cvx = z;
    }

    /* renamed from: eb */
    public void mo27573eb(boolean z) {
        this.cvJ = z;
    }

    /* renamed from: ec */
    public void mo27574ec(boolean z) {
        this.cvL = z;
    }

    /* renamed from: ed */
    public void mo27575ed(boolean z) {
        this.cvU = z;
    }

    /* renamed from: ee */
    public void mo27576ee(boolean z) {
        this.cvO = z;
    }

    /* renamed from: ef */
    public void mo27577ef(boolean z) {
        this.cvP = z;
    }

    public int getPadding() {
        return this.mPadding;
    }

    public void invalidate() {
        this.cvv = acH();
        this.bWZ.reset();
        this.bWZ.postTranslate(-this.cvv.centerX(), -this.cvv.centerY());
        this.bWZ.postRotate(this.mRotation);
        this.bWZ.postTranslate(this.cvv.centerX(), this.cvv.centerY());
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
    public void mo27583kR(int i) {
        this.mOutlineEllipse = i;
    }

    /* renamed from: kS */
    public void mo27584kS(int i) {
        this.mOutlineStrokeColor = i;
        this.bXc.setColor(this.mOutlineStrokeColor);
        this.bXc.setColor(this.cvu != C5607b.None ? this.cvI : this.mOutlineStrokeColor);
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
            float cl = m15358cl(bitmap.getWidth(), bitmap.getHeight());
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
        this.mRotation = f;
        acL();
    }

    public void setVerFlip(boolean z) {
        this.isVerFlip = z;
    }

    public void setmSelected(boolean z) {
        this.mSelected = z;
    }

    /* renamed from: t */
    public int mo27595t(float f, float f2) {
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
        if (!C4580b.m11666qi() ? !(Math.abs(acI.right - f3) >= f5 || Math.abs(acI.bottom - f4) >= f5) : !(Math.abs(acI.left - f3) >= f5 || Math.abs(acI.bottom - f4) >= f5)) {
            z = true;
        }
        if (z && z2 && z3) {
            i = 32;
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
        return i;
    }

    /* renamed from: u */
    public void mo27596u(float f, float f2) {
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
        boolean z4 = !C4580b.m11666qi() ? !(Math.abs(acI.left - f3) >= cvq || Math.abs(acI.top - f4) >= cvq) : !(Math.abs(acI.right - f3) >= cvq || Math.abs(acI.top - f4) >= cvq);
        if (this.cvM && this.cvA != null && this.cvB != null && z4 && z2 && z3 && this.cvs != null) {
            this.cvs.mo27599eg(isHorFlip() ^ isVerFlip());
        }
        if (!C4580b.m11666qi() ? Math.abs(acI.right - f3) >= cvq || Math.abs(acI.top - f4) >= cvq : Math.abs(acI.left - f3) >= cvq || Math.abs(acI.top - f4) >= cvq) {
            z = false;
        }
        if (this.cvL && this.cvE != null && z && z2 && z3 && this.cvs != null) {
            this.cvs.aan();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public void mo27597v(float f, float f2) {
        this.cvw.offset(f, f2);
        invalidate();
        this.btV.invalidate();
    }
}
