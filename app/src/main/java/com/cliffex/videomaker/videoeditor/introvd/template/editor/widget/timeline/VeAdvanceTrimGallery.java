package com.introvd.template.editor.widget.timeline;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SpinnerAdapter;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.p203b.C4583d;
import p503cz.msebera.android.httpclient.HttpStatus;

public class VeAdvanceTrimGallery extends VeGallery {
    private static int dvw = C4583d.m11671P(3.0f);
    private static final int dwn = C4583d.m11671P(5.0f);
    private static int dwo = C4583d.m11671P(11.0f);
    public static int dxa = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    /* access modifiers changed from: private */
    public C7093b cDW;
    /* access modifiers changed from: private */
    public int cEe;
    /* access modifiers changed from: private */
    public int cEf;
    private boolean cGk;
    private boolean dnE;
    private Paint dnF;
    private String dnG;
    private String dnH;
    private int dvv;
    private final Drawable dwA;
    private final int dwB;
    private final int dwC;
    private boolean dwD;
    /* access modifiers changed from: private */
    public int dwE;
    private int dwF;
    private int dwG;
    /* access modifiers changed from: private */
    public int dwH;
    private boolean dwI;
    private float dwJ;
    private int dwK;
    /* access modifiers changed from: private */
    public int dwL;
    private int dwM;
    /* access modifiers changed from: private */
    public int dwN;
    /* access modifiers changed from: private */
    public int dwO;
    private boolean dwP;
    private boolean dwQ;
    private int dwR;
    private volatile boolean dwS;
    private boolean dwT;
    private int dwU;
    private int dwV;
    private int dwW;
    private int dwX;
    private C7092a dwY;
    private int dwZ;
    private Drawable dwp;
    private Drawable dwq;
    private Drawable dwr;
    private Drawable dws;
    private Drawable dwt;
    private Drawable dwu;
    private Drawable dwv;
    private Drawable dww;
    private Drawable dwx;
    private Drawable dwy;
    private Drawable dwz;
    public int dxb;
    public int dxc;
    private int dxd;
    private int dxe;
    private RectF dxf;
    private RectF dxg;
    private int dxh;
    private volatile boolean dxi;
    /* access modifiers changed from: private */
    public boolean dxj;
    /* access modifiers changed from: private */
    public boolean dxk;
    private boolean dxl;
    private boolean isSeeking;
    /* access modifiers changed from: private */
    public int mClipIndex;
    private Paint paint;

    /* renamed from: com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery$a */
    private class C7092a implements Runnable {
        private boolean dpr = false;
        private boolean dps = false;

        public C7092a() {
        }

        private void aus() {
            VeAdvanceTrimGallery.this.removeCallbacks(this);
        }

        /* renamed from: dF */
        public void mo31321dF(boolean z) {
            if (!VeAdvanceTrimGallery.this.avN()) {
                if (z != this.dpr || !this.dps) {
                    this.dpr = z;
                    aus();
                    this.dps = true;
                    VeAdvanceTrimGallery.this.postDelayed(this, 500);
                }
            }
        }

        public boolean isStarted() {
            return this.dps;
        }

        public void run() {
            int count = VeAdvanceTrimGallery.this.getCount();
            int pT = this.dpr ? VeAdvanceTrimGallery.this.mo31376pT(-10) : VeAdvanceTrimGallery.this.mo31376pT(10);
            if (pT != 0) {
                int i = -pT;
                boolean z = false;
                if (VeAdvanceTrimGallery.this.dwE == 1) {
                    VeAdvanceTrimGallery.this.dwN = VeAdvanceTrimGallery.this.dwN + i;
                    VeAdvanceTrimGallery.this.dwH = VeAdvanceTrimGallery.this.dwH + i;
                    if (VeAdvanceTrimGallery.this.dwN < 0) {
                        VeAdvanceTrimGallery.this.dwH = VeAdvanceTrimGallery.this.dwH + (-VeAdvanceTrimGallery.this.dwN);
                        VeAdvanceTrimGallery.this.dwN = 0;
                        stop();
                    } else if (VeAdvanceTrimGallery.this.dwN > VeAdvanceTrimGallery.this.dwO - 1) {
                        VeAdvanceTrimGallery.this.dwH = VeAdvanceTrimGallery.this.dwH + ((VeAdvanceTrimGallery.this.dwO - 1) - VeAdvanceTrimGallery.this.dwN);
                        VeAdvanceTrimGallery.this.dwN = VeAdvanceTrimGallery.this.dwO - 1;
                        stop();
                    }
                    VeAdvanceTrimGallery.this.cEe = VeAdvanceTrimGallery.this.mo31269dd(VeAdvanceTrimGallery.this.dwN, count);
                } else {
                    int maxTrimRange = VeAdvanceTrimGallery.this.getMaxTrimRange();
                    VeAdvanceTrimGallery.this.dwO = VeAdvanceTrimGallery.this.dwO + i;
                    VeAdvanceTrimGallery.this.dwH = VeAdvanceTrimGallery.this.dwH + i;
                    if (VeAdvanceTrimGallery.this.dwO > maxTrimRange) {
                        VeAdvanceTrimGallery.this.dwH = VeAdvanceTrimGallery.this.dwH + (maxTrimRange - VeAdvanceTrimGallery.this.dwO);
                        VeAdvanceTrimGallery.this.dwO = maxTrimRange;
                        stop();
                    } else if (VeAdvanceTrimGallery.this.dwO < VeAdvanceTrimGallery.this.dwN + 1) {
                        VeAdvanceTrimGallery.this.dwH = VeAdvanceTrimGallery.this.dwH + ((VeAdvanceTrimGallery.this.dwN + 1) - VeAdvanceTrimGallery.this.dwO);
                        VeAdvanceTrimGallery.this.dwO = VeAdvanceTrimGallery.this.dwN + 1;
                        stop();
                    }
                    VeAdvanceTrimGallery.this.cEf = VeAdvanceTrimGallery.this.mo31269dd(VeAdvanceTrimGallery.this.dwO, count);
                }
                if (VeAdvanceTrimGallery.this.dxk && VeAdvanceTrimGallery.this.cEf - VeAdvanceTrimGallery.this.cEe < VeAdvanceTrimGallery.dxa) {
                    stop();
                    int b = VeAdvanceTrimGallery.this.dwE == 1 ? VeAdvanceTrimGallery.this.dwN : VeAdvanceTrimGallery.this.dwO;
                    VeAdvanceTrimGallery.this.mo31282hR(true);
                    VeAdvanceTrimGallery.this.dwH = VeAdvanceTrimGallery.this.dwH + ((VeAdvanceTrimGallery.this.dwE == 1 ? VeAdvanceTrimGallery.this.dwN : VeAdvanceTrimGallery.this.dwO) - b);
                } else if (VeAdvanceTrimGallery.this.dxk || (VeAdvanceTrimGallery.this.dwN + VeAdvanceTrimGallery.this.dwL) - VeAdvanceTrimGallery.this.cEf >= VeAdvanceTrimGallery.dxa) {
                    VeAdvanceTrimGallery.this.dxj = false;
                } else {
                    stop();
                    int b2 = VeAdvanceTrimGallery.this.dwE == 1 ? VeAdvanceTrimGallery.this.dwN : VeAdvanceTrimGallery.this.dwO;
                    VeAdvanceTrimGallery.this.mo31283hS(true);
                    VeAdvanceTrimGallery.this.dwH = VeAdvanceTrimGallery.this.dwH + ((VeAdvanceTrimGallery.this.dwE == 1 ? VeAdvanceTrimGallery.this.dwN : VeAdvanceTrimGallery.this.dwO) - b2);
                }
                if (VeAdvanceTrimGallery.this.cDW != null) {
                    C7093b i2 = VeAdvanceTrimGallery.this.cDW;
                    int j = VeAdvanceTrimGallery.this.mClipIndex;
                    if (VeAdvanceTrimGallery.this.dwE == 1) {
                        z = true;
                    }
                    i2.mo28153b(j, z, VeAdvanceTrimGallery.this.dwE == 1 ? VeAdvanceTrimGallery.this.cEe : VeAdvanceTrimGallery.this.cEf);
                }
            } else {
                stop();
            }
            if (this.dps) {
                VeAdvanceTrimGallery.this.postDelayed(this, 50);
            }
        }

        public void stop() {
            if (this.dps) {
                this.dps = false;
                VeAdvanceTrimGallery.this.removeCallbacks(this);
            }
        }
    }

    /* renamed from: com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery$b */
    public interface C7093b {
        /* renamed from: a */
        void mo28151a(int i, boolean z, int i2);

        boolean agv();

        /* renamed from: b */
        void mo28153b(int i, boolean z, int i2);

        /* renamed from: c */
        void mo28154c(int i, boolean z, int i2);

        /* renamed from: e */
        boolean mo28155e(int i, KeyEvent keyEvent);

        /* renamed from: eL */
        void mo28156eL(boolean z);

        /* renamed from: f */
        boolean mo28157f(int i, KeyEvent keyEvent);

        /* renamed from: lJ */
        void mo28158lJ(int i);

        /* renamed from: lr */
        void mo28159lr(int i);

        /* renamed from: ls */
        void mo28160ls(int i);
    }

    public VeAdvanceTrimGallery(Context context) {
        super(context);
        this.dwp = null;
        this.dwq = null;
        this.dwr = null;
        this.dws = null;
        this.dwt = null;
        this.dwu = null;
        this.dwv = null;
        this.dww = null;
        this.dwx = null;
        this.dwy = null;
        this.dwz = null;
        this.dwA = getContext().getResources().getDrawable(R.drawable.editor_icon_timeline_bubble);
        this.dwB = R.color.color_333333;
        this.dwC = 12;
        this.dvv = R.color.white;
        this.dnF = new Paint();
        this.dwD = false;
        this.dwE = 0;
        this.dwF = 0;
        this.dwG = 0;
        this.dwH = 0;
        this.cDW = null;
        this.dwI = false;
        this.dwJ = 0.0f;
        this.dwK = 0;
        this.mClipIndex = 0;
        this.dwL = 0;
        this.dwM = 0;
        this.cEe = 0;
        this.dwN = 0;
        this.cEf = 0;
        this.dwO = 0;
        this.dwP = false;
        this.dwQ = false;
        this.isSeeking = false;
        this.dwR = -1;
        this.cGk = false;
        this.dwS = true;
        this.dwT = false;
        this.dwU = 120;
        this.dwV = 0;
        this.dwW = -16777216;
        this.dwX = HttpStatus.SC_NO_CONTENT;
        this.dwY = new C7092a();
        this.dwZ = -1;
        this.dxd = 0;
        this.dxe = 0;
        this.dxf = new RectF();
        this.dxg = new RectF();
        this.dxh = 0;
        this.dxi = false;
        this.paint = new Paint();
        this.dnG = null;
        this.dnH = null;
        this.dnE = false;
        this.dxj = false;
        this.dxk = true;
        this.dxl = true;
        this.dpn = true;
    }

    public VeAdvanceTrimGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwp = null;
        this.dwq = null;
        this.dwr = null;
        this.dws = null;
        this.dwt = null;
        this.dwu = null;
        this.dwv = null;
        this.dww = null;
        this.dwx = null;
        this.dwy = null;
        this.dwz = null;
        this.dwA = getContext().getResources().getDrawable(R.drawable.editor_icon_timeline_bubble);
        this.dwB = R.color.color_333333;
        this.dwC = 12;
        this.dvv = R.color.white;
        this.dnF = new Paint();
        this.dwD = false;
        this.dwE = 0;
        this.dwF = 0;
        this.dwG = 0;
        this.dwH = 0;
        this.cDW = null;
        this.dwI = false;
        this.dwJ = 0.0f;
        this.dwK = 0;
        this.mClipIndex = 0;
        this.dwL = 0;
        this.dwM = 0;
        this.cEe = 0;
        this.dwN = 0;
        this.cEf = 0;
        this.dwO = 0;
        this.dwP = false;
        this.dwQ = false;
        this.isSeeking = false;
        this.dwR = -1;
        this.cGk = false;
        this.dwS = true;
        this.dwT = false;
        this.dwU = 120;
        this.dwV = 0;
        this.dwW = -16777216;
        this.dwX = HttpStatus.SC_NO_CONTENT;
        this.dwY = new C7092a();
        this.dwZ = -1;
        this.dxd = 0;
        this.dxe = 0;
        this.dxf = new RectF();
        this.dxg = new RectF();
        this.dxh = 0;
        this.dxi = false;
        this.paint = new Paint();
        this.dnG = null;
        this.dnH = null;
        this.dnE = false;
        this.dxj = false;
        this.dxk = true;
        this.dxl = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VeTrimGallery);
        this.dwp = obtainStyledAttributes.getDrawable(R.styleable.VeTrimGallery_LeftTrimBar);
        this.dwq = obtainStyledAttributes.getDrawable(R.styleable.VeTrimGallery_RightTrimBar);
        obtainStyledAttributes.recycle();
        this.dpn = true;
    }

    public VeAdvanceTrimGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dwp = null;
        this.dwq = null;
        this.dwr = null;
        this.dws = null;
        this.dwt = null;
        this.dwu = null;
        this.dwv = null;
        this.dww = null;
        this.dwx = null;
        this.dwy = null;
        this.dwz = null;
        this.dwA = getContext().getResources().getDrawable(R.drawable.editor_icon_timeline_bubble);
        this.dwB = R.color.color_333333;
        this.dwC = 12;
        this.dvv = R.color.white;
        this.dnF = new Paint();
        this.dwD = false;
        this.dwE = 0;
        this.dwF = 0;
        this.dwG = 0;
        this.dwH = 0;
        this.cDW = null;
        this.dwI = false;
        this.dwJ = 0.0f;
        this.dwK = 0;
        this.mClipIndex = 0;
        this.dwL = 0;
        this.dwM = 0;
        this.cEe = 0;
        this.dwN = 0;
        this.cEf = 0;
        this.dwO = 0;
        this.dwP = false;
        this.dwQ = false;
        this.isSeeking = false;
        this.dwR = -1;
        this.cGk = false;
        this.dwS = true;
        this.dwT = false;
        this.dwU = 120;
        this.dwV = 0;
        this.dwW = -16777216;
        this.dwX = HttpStatus.SC_NO_CONTENT;
        this.dwY = new C7092a();
        this.dwZ = -1;
        this.dxd = 0;
        this.dxe = 0;
        this.dxf = new RectF();
        this.dxg = new RectF();
        this.dxh = 0;
        this.dxi = false;
        this.paint = new Paint();
        this.dnG = null;
        this.dnH = null;
        this.dnE = false;
        this.dxj = false;
        this.dxk = true;
        this.dxl = true;
        this.dpn = true;
    }

    /* renamed from: O */
    private boolean m20804O(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int leftBoundTrimPos = getLeftBoundTrimPos();
        int i = this.dwN - leftBoundTrimPos;
        int i2 = this.dwO - leftBoundTrimPos;
        if (Math.abs(x - i) - Math.abs(x - i2) > 0) {
            if (m20813a(x, y, i2, this.dwq)) {
                this.dwE = 2;
                this.dwS = false;
                return true;
            }
        } else if (m20813a(x, y, i, this.dwp)) {
            this.dwE = 1;
            this.dwS = true;
            return true;
        }
        this.dwE = 0;
        return false;
    }

    /* renamed from: P */
    private boolean m20805P(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            this.dwH = getLeftBoundTrimPos() + x;
            boolean z = this.dwH >= this.dwN - C4583d.m11671P(15.0f) && this.dwH <= this.dwO + C4583d.m11671P(15.0f);
            if (this.dxi || (this.dxk && z)) {
                this.dwZ = -1;
                this.dwF = x;
                this.dwG = x;
                this.isSeeking = true;
                int dd = mo31269dd(this.dwH, getCount());
                this.dwR = dd;
                invalidate();
                if (this.cDW != null) {
                    this.cDW.mo28158lJ(dd);
                }
                return true;
            } else if (this.dxk) {
                return false;
            } else {
                if (!(this.dwH < this.dwN - C4583d.m11671P(15.0f) || this.dwH > this.dwO + C4583d.m11671P(15.0f))) {
                    return false;
                }
                this.dwZ = -1;
                this.dwF = x;
                this.dwG = x;
                this.isSeeking = true;
                int dd2 = mo31269dd(this.dwH, getCount());
                if (this.dwH < this.dwN - C4583d.m11671P(15.0f)) {
                    this.dxl = true;
                } else {
                    this.dxl = false;
                    dd2 -= this.cEf - this.cEe;
                }
                this.dwR = dd2;
                invalidate();
                if (this.cDW != null) {
                    this.cDW.mo28158lJ(dd2);
                }
                return true;
            }
        } else {
            if (this.isSeeking) {
                int dd3 = mo31269dd((int) (motionEvent.getX() + ((float) getLeftBoundTrimPos())), getCount());
                if (!this.dxi) {
                    if (this.dxk) {
                        if (dd3 < this.cEe) {
                            dd3 = this.cEe;
                        }
                        if (dd3 > this.cEf) {
                            dd3 = this.cEf;
                        }
                    } else if (dd3 < this.cEe) {
                        this.dxl = true;
                    } else if (dd3 > this.cEf) {
                        this.dxl = false;
                    } else if (dd3 >= this.cEe && dd3 <= this.cEf) {
                        dd3 = this.dxl ? this.cEe : this.cEf;
                    }
                }
                this.dwR = dd3;
                if (motionEvent.getAction() == 2) {
                    if (this.cDW != null) {
                        this.cDW.mo28159lr(dd3);
                    }
                    invalidate();
                    return true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    if (this.cDW != null) {
                        this.cDW.mo28160ls(dd3);
                    }
                    this.isSeeking = false;
                    invalidate();
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    private void m20808a(Canvas canvas, int i, int i2) {
        int i3 = this.dwN - i;
        int i4 = this.dwO - i2;
        int height = (getHeight() - getChildWidth()) / 2;
        int childWidth = getChildWidth() + height;
        int i5 = this.dwE;
        int i6 = this.dwW;
        Rect rect = new Rect(i3, height, i4, childWidth);
        this.paint.setColor(i6);
        this.paint.setAlpha((int) (((float) this.dwX) * this.dwJ));
        canvas.save();
        canvas.drawRect(rect, this.paint);
        canvas.restore();
    }

    /* renamed from: a */
    private void m20809a(Canvas canvas, Drawable drawable, float f, float f2, String str) {
        if (drawable != null) {
            this.dnF.setAntiAlias(true);
            this.dnF.setTextSize((float) C4583d.dpFloatToPixel(getContext(), 12.0f));
            this.dnF.setColor(getResources().getColor(this.dwB));
            StringBuilder sb = new StringBuilder();
            sb.append("positionLeft ");
            sb.append(String.valueOf(f));
            sb.append("/");
            sb.append(f2);
            LogUtilsV2.m14227d(sb.toString());
            canvas.save();
            canvas.translate(f, f2);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.drawText(str, f + ((((float) drawable.getIntrinsicWidth()) - this.dnF.measureText(str)) / 2.0f), f2 + ((float) (((drawable.getIntrinsicHeight() * 10) / 13) - (C4583d.dpFloatToPixel(getContext(), 12.0f) / 2))), this.dnF);
            canvas.restore();
        }
    }

    /* renamed from: a */
    private void m20810a(Canvas canvas, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int leftBoundTrimPos = getLeftBoundTrimPos();
        int qw = mo31290qw(leftBoundTrimPos);
        canvas.save();
        Drawable drawable = z ? this.dww : this.dwv;
        if (avL() && this.dwz != null) {
            drawable = this.dwz;
        }
        if (this.dwN < leftBoundTrimPos && this.dwO > qw) {
            int i5 = qw - leftBoundTrimPos;
            canvas.translate(0.0f, (float) ((getHeight() - drawable.getIntrinsicHeight()) / 2));
            drawable.setBounds(0, 0, i5, drawable.getIntrinsicHeight());
            drawable.draw(canvas);
        } else if (this.dwN >= leftBoundTrimPos && this.dwO <= qw) {
            if (avJ()) {
                i4 = this.dwO - this.dwN;
                i3 = this.dwN - leftBoundTrimPos;
            } else {
                i4 = ((this.dwO - this.dwN) - 0) - 0;
                i3 = (this.dwN - leftBoundTrimPos) + 0;
            }
            int childWidth = getChildWidth();
            canvas.translate((float) i3, (float) ((getHeight() - childWidth) / 2));
            drawable.setBounds(0, 0, i4, childWidth);
            drawable.draw(canvas);
        } else if (this.dwN < leftBoundTrimPos && this.dwO <= qw) {
            int i6 = avJ() ? this.dwO - this.dwN : (this.dwO - leftBoundTrimPos) + 0;
            int childWidth2 = getChildWidth();
            canvas.translate(0.0f, (float) ((getHeight() - childWidth2) / 2));
            drawable.setBounds(0, 0, i6, childWidth2);
            drawable.draw(canvas);
        } else if (this.dwN >= leftBoundTrimPos && this.dwO > qw) {
            if (avJ()) {
                i2 = this.dwO - this.dwN;
                i = this.dwN - leftBoundTrimPos;
            } else {
                i2 = (this.dwO - leftBoundTrimPos) - 0;
                i = (this.dwN - leftBoundTrimPos) + 0;
            }
            int childWidth3 = getChildWidth();
            canvas.translate((float) i, (float) ((getHeight() - childWidth3) / 2));
            drawable.setBounds(0, 0, i2, childWidth3);
            drawable.draw(canvas);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m20811a(Canvas canvas, boolean z, float f, float f2) {
        if (z) {
            this.dnF.setAntiAlias(true);
            this.dnF.setColor(getResources().getColor(this.dvv));
            canvas.save();
            canvas.translate(f, f2);
            canvas.drawCircle(0.0f, 0.0f, (float) dvw, this.dnF);
            canvas.restore();
        }
    }

    /* renamed from: a */
    private void m20812a(Canvas canvas, boolean z, int i, int i2, int i3, Paint paint2) {
        StringBuilder sb = new StringBuilder();
        sb.append("mTrimLeftPos = ");
        sb.append(this.dwN);
        sb.append(", leftBoundTrimPos = ");
        sb.append(i3);
        LogUtilsV2.m14227d(sb.toString());
        if (this.dwN >= i3) {
            int i4 = this.dwN - i3;
            if (i4 < this.dxb) {
                i4 = this.dxb;
                this.dwN = this.dxb;
            }
            int height = (getHeight() - getChildWidth()) / 2;
            int childWidth = getChildWidth() + height;
            int i5 = this.dwE;
            int i6 = this.dwW;
            if (i3 < 0 && i < Math.abs(i3)) {
                i = Math.abs(i3);
            }
            boolean z2 = false;
            if (i4 > i) {
                Rect rect = new Rect(i, height, i4, childWidth);
                paint2.setColor(i6);
                if (this.dxk) {
                    paint2.setAlpha((int) (((float) this.dwX) * this.dwJ));
                } else {
                    paint2.setAlpha(0);
                }
                canvas.save();
                canvas.drawRect(rect, paint2);
                canvas.restore();
            }
            if (!isPlaying()) {
                boolean z3 = this.dwE == 1 || this.dwS;
                Drawable drawable = z3 ? this.dwr : this.dwp;
                if (drawable != null) {
                    if (!z) {
                        drawable = this.dwt;
                    }
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    if (avJ()) {
                        this.dxd = i4 - (intrinsicWidth / 2);
                    } else {
                        this.dxd = i4 - intrinsicWidth;
                    }
                    int childWidth2 = getChildWidth() + dwo;
                    int height2 = (getHeight() - childWidth2) / 2;
                    canvas.save();
                    canvas.translate((float) this.dxd, (float) height2);
                    int cJ = C6386d.m18374cJ(this);
                    this.dxf.left = (float) this.dxd;
                    this.dxf.top = (float) (((height2 * 3) / 4) + cJ);
                    this.dxf.right = (float) (this.dxd + intrinsicWidth);
                    this.dxf.bottom = (float) (height2 + childWidth2 + (height2 / 4) + cJ);
                    drawable.setBounds(0, 0, intrinsicWidth, childWidth2);
                    drawable.setAlpha(i2);
                    drawable.draw(canvas);
                    canvas.restore();
                    m20811a(canvas, z3, (float) (this.dxd + (intrinsicWidth / 2)), (float) (height2 - dwn));
                    if (z3 && this.dnE) {
                        z2 = true;
                    }
                    if (z2) {
                        Drawable drawable2 = this.dwA;
                        m20809a(canvas, drawable2, (float) (this.dxd - ((drawable2.getIntrinsicWidth() - intrinsicWidth) / 2)), 0.0f, this.dnG);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m20813a(int i, int i2, int i3, Drawable drawable) {
        int i4 = 0;
        if (drawable == null) {
            return false;
        }
        int height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - drawable.getIntrinsicHeight()) - 2;
        int intrinsicWidth = this.dwp.getIntrinsicWidth();
        if (this.dwU - intrinsicWidth > 0) {
            i4 = (this.dwU - intrinsicWidth) / 2;
        }
        int i5 = intrinsicWidth / 2;
        return new Rect((i3 - i5) - i4, (getPaddingTop() - 20) - height, i3 + i5 + i4, getPaddingTop() + this.dwp.getIntrinsicHeight() + 20 + height).contains(i, i2);
    }

    private boolean avI() {
        return this.dxb > 0 && this.dxc > 0;
    }

    /* renamed from: hQ */
    private void m20826hQ(boolean z) {
        if (this.cEf > 0 && this.cEe >= 0) {
            int i = this.cEf - this.cEe;
            if (z) {
                if ((i - dxa >= 10 && !this.dxj) || this.dwL <= dxa) {
                    this.dwP = false;
                } else if (!this.dwP || this.dwQ) {
                    this.dwP = true;
                    if (this.cDW != null) {
                        this.cDW.agv();
                    }
                }
            } else if (((this.cEe + (this.dwL - this.cEf)) - dxa >= 10 && !this.dxj) || this.dwL <= dxa) {
            } else {
                if (!this.dwP || this.dwQ) {
                    this.dwP = true;
                    if (this.cDW != null) {
                        this.cDW.agv();
                        return;
                    }
                    return;
                }
                this.dwP = false;
            }
        }
    }

    /* renamed from: hT */
    private void m20827hT(boolean z) {
        View view = (View) getParent();
        if (view != null && (view instanceof VeGallery)) {
            VeGallery veGallery = (VeGallery) view;
            int aM = veGallery.mo31325aM(this);
            int childLeftMostBounds = getChildLeftMostBounds() - this.dwV;
            int childCount = veGallery.getChildCount();
            int childRightMostBounds = getChildRightMostBounds() + this.dwV;
            if (aM > 0) {
                View childAt = veGallery.getChildAt(aM - 1);
                if (childAt != null) {
                    int right = childAt.getRight();
                    if (childLeftMostBounds > 0 || (childLeftMostBounds < 0 && right > 0)) {
                        for (int i = 0; i < aM; i++) {
                            View childAt2 = veGallery.getChildAt(i);
                            if (childAt2 != null) {
                                int left = childAt2.getLeft();
                                childAt2.offsetLeftAndRight(childLeftMostBounds - right);
                                int left2 = childAt2.getLeft();
                                if (z && this.dxp != null) {
                                    this.dxp.mo28167b(childAt2, left, left2, 1);
                                }
                            }
                        }
                    }
                }
            }
            if (aM < childCount - 1) {
                int i2 = aM + 1;
                View childAt3 = veGallery.getChildAt(i2);
                if (childAt3 != null) {
                    int left3 = childAt3.getLeft();
                    int width = veGallery.getWidth() - veGallery.getPaddingRight();
                    if (childRightMostBounds < width || (childRightMostBounds > width && left3 < width)) {
                        while (i2 < childCount) {
                            View childAt4 = veGallery.getChildAt(i2);
                            if (childAt4 != null) {
                                int left4 = childAt4.getLeft();
                                childAt4.offsetLeftAndRight(childRightMostBounds - left3);
                                int left5 = childAt4.getLeft();
                                if (z && this.dxp != null) {
                                    this.dxp.mo28167b(childAt4, left4, left5, 1);
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
            veGallery.aul();
            veGallery.aum();
        }
    }

    /* renamed from: B */
    public void mo31258B(boolean z, boolean z2) {
        this.dwI = z;
        if (z2) {
            this.dwJ = 0.0f;
            this.dwK = 1;
        } else {
            this.dwJ = 1.0f;
            this.dwK = -1;
        }
        invalidate();
    }

    /* renamed from: F */
    public int mo31259F(int i, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 0) {
            i3 = this.dwM;
        }
        int i4 = i % i3;
        int i5 = i2 - 1;
        int i6 = i5 * i3;
        int i7 = (this.dwL - 1) - i6;
        if (i > this.dwL - i7) {
            i4 = i - i6;
        }
        int i8 = i / i3;
        if (i8 > i5) {
            i8 = i5;
        }
        int i9 = i8 < i5 ? (this.doK * i4) / i3 : i7 == 0 ? (this.doK * i4) / i3 : (this.doK * i4) / i7;
        int firstVisiblePosition = ((i8 - getFirstVisiblePosition()) * this.doK) + i9;
        if (avI()) {
            firstVisiblePosition += Math.abs(getLeftLimitMoveOffset());
        }
        if (firstVisiblePosition < 0) {
            firstVisiblePosition = 0;
        }
        if (firstVisiblePosition > mo31289qv(i2)) {
            firstVisiblePosition = mo31289qv(i2);
        }
        return firstVisiblePosition;
    }

    /* renamed from: Q */
    public boolean mo31260Q(MotionEvent motionEvent) {
        int i;
        int i2;
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            this.dwZ = -1;
            this.dwF = x;
            this.dwG = x;
            if (m20804O(motionEvent)) {
                if (this.dwE == 1) {
                    this.dwH = this.dwN;
                } else {
                    this.dwH = this.dwO;
                }
                invalidate();
                if (this.dxp != null) {
                    this.dxp.afq();
                }
                if (this.cDW != null) {
                    C7093b bVar = this.cDW;
                    int i3 = this.mClipIndex;
                    if (this.dwE == 1) {
                        z = true;
                    }
                    bVar.mo28154c(i3, z, this.dwE == 1 ? this.cEe : this.cEf);
                }
                return true;
            }
        } else if (this.dwE > 0) {
            if (motionEvent.getAction() == 2) {
                int x2 = (int) (motionEvent.getX() - ((float) this.dwF));
                int leftBoundTrimPos = getLeftBoundTrimPos();
                int paddingLeft = getPaddingLeft();
                int width = getWidth() - getPaddingRight();
                int x3 = (int) motionEvent.getX();
                int count = getCount();
                if (this.dwE == 1) {
                    this.dwN = this.dwH + x2;
                    if (this.dwO - this.dwN < this.dxh) {
                        this.dwN = this.dwO - this.dxh;
                    }
                    if (this.dwN < 0) {
                        this.dwN = 0;
                    } else if (this.dwN > this.dwO - 1) {
                        this.dwN = this.dwO - 1;
                    }
                    this.cEe = mo31269dd(this.dwN, count);
                    if (this.dxk && this.cEf - this.cEe < dxa) {
                        this.dwY.stop();
                        mo31282hR(true);
                    } else if (!this.dxk && (this.cEe + this.dwL) - this.cEf < dxa) {
                        this.dwY.stop();
                        mo31283hS(true);
                    } else if (avI() && this.dwN < this.dxb) {
                        this.dwN = this.dxb;
                        this.cEe = mo31269dd(this.dwN, getCount());
                    } else if (!avI() || this.dwO <= this.dxc) {
                        this.dxj = false;
                        int i4 = this.dwN - leftBoundTrimPos;
                        if (this.dwq != null) {
                            int intrinsicWidth = this.dwp.getIntrinsicWidth();
                            if (avJ()) {
                                intrinsicWidth /= 2;
                            }
                            i2 = i4 - intrinsicWidth;
                        } else {
                            i2 = i4;
                        }
                        if (i4 >= width) {
                            if (!this.dwY.isStarted() && x3 > this.dwG) {
                                this.dwY.mo31321dF(true);
                            }
                        } else if (i2 <= paddingLeft) {
                            if (!this.dwY.isStarted() && x3 < this.dwG) {
                                this.dwY.mo31321dF(false);
                            }
                        } else if (this.dwY.isStarted()) {
                            this.dwY.stop();
                        }
                    } else {
                        this.dwO = this.dxc;
                        this.cEf = mo31269dd(this.dwO, getCount());
                    }
                } else if (this.dwE == 2) {
                    int maxTrimRange = getMaxTrimRange();
                    this.dwO = this.dwH + x2;
                    if (this.dwO - this.dwN < this.dxh) {
                        this.dwO = this.dwN + this.dxh;
                    }
                    if (this.dwO > maxTrimRange) {
                        this.dwO = maxTrimRange;
                    } else if (this.dwO < this.dwN + 1) {
                        this.dwO = this.dwN + 1;
                    }
                    this.cEf = mo31269dd(this.dwO, count);
                    if (this.dxk && this.cEf - this.cEe < dxa) {
                        this.dwY.stop();
                        mo31282hR(false);
                    } else if (!this.dxk && (this.cEe + this.dwL) - this.cEf < dxa) {
                        this.dwY.stop();
                        mo31283hS(false);
                    } else if (avI() && this.dwN < this.dxb) {
                        this.dwN = this.dxb;
                        this.cEe = mo31269dd(this.dwN, getCount());
                    } else if (!avI() || this.dwO <= this.dxc) {
                        this.dxj = false;
                        int i5 = this.dwO - leftBoundTrimPos;
                        if (this.dwq != null) {
                            int intrinsicWidth2 = this.dwq.getIntrinsicWidth();
                            if (avJ()) {
                                intrinsicWidth2 /= 2;
                            }
                            i = intrinsicWidth2 + i5;
                        } else {
                            i = i5;
                        }
                        if (i >= width) {
                            if (!this.dwY.isStarted() && x3 > this.dwG) {
                                this.dwY.mo31321dF(true);
                            }
                        } else if (i5 <= paddingLeft) {
                            if (!this.dwY.isStarted() && x3 < this.dwG) {
                                this.dwY.mo31321dF(false);
                            }
                        } else if (this.dwY.isStarted()) {
                            this.dwY.stop();
                        }
                    } else {
                        this.dwO = this.dxc;
                        this.cEf = mo31269dd(this.dwO, getCount());
                    }
                }
                if (this.cDW != null) {
                    C7093b bVar2 = this.cDW;
                    int i6 = this.mClipIndex;
                    if (this.dwE == 1) {
                        z = true;
                    }
                    bVar2.mo28153b(i6, z, this.dwE == 1 ? this.cEe : this.cEf);
                }
                m20826hQ(this.dxk);
                this.dwG = x3;
                invalidate();
                return true;
            } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.dwE > 0) {
                this.dwY.stop();
                if (this.cDW != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(">>>>>>>>>>>>>1 mTrimLeftValue:");
                    sb.append(this.cEe);
                    sb.append(";mTrimRightValue:");
                    sb.append(this.cEf);
                    LogUtilsV2.m14227d(sb.toString());
                    this.cDW.mo28151a(this.mClipIndex, this.dwE == 1, this.dwE == 1 ? this.cEe : this.cEf);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(">>>>>>>>>>>>>1 mTrimLeftValue:");
                    sb2.append(this.cEe);
                    sb2.append(";mTrimRightValue:");
                    sb2.append(this.cEf);
                    LogUtilsV2.m14227d(sb2.toString());
                }
                if (this.dxp != null) {
                    this.dxp.acC();
                }
                this.dwE = 0;
                invalidate();
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo31261a(Canvas canvas, int i, int i2, int i3, int i4, Paint paint2) {
        canvas.save();
        if (this.dwO <= i4) {
            int i5 = this.dwO - i3;
            int maxTrimRange = getMaxTrimRange() - i3;
            int height = (getHeight() - getChildWidth()) / 2;
            int childWidth = getChildWidth() + height;
            int i6 = i5 < i ? i : i5;
            if (maxTrimRange > getRight() - i) {
                maxTrimRange = getRight() - i;
            }
            if (maxTrimRange > i6) {
                int i7 = this.dwE;
                int i8 = this.dwW;
                Rect rect = new Rect(i6, height, maxTrimRange, childWidth);
                paint2.setColor(i8);
                paint2.setAlpha(0);
                canvas.drawRect(rect, paint2);
            }
            Drawable drawable = this.dwy;
            if (drawable != null) {
                this.dxe = i5;
                int P = C4583d.m11671P(56.0f);
                int height2 = (getHeight() - P) / 2;
                canvas.translate((float) this.dxe, (float) height2);
                int cJ = C6386d.m18374cJ(this);
                this.dxg.left = (float) this.dxe;
                this.dxg.top = (float) (((height2 * 3) / 4) + cJ);
                this.dxg.right = (float) (this.dxe + 1);
                this.dxg.bottom = (float) (height2 + P + (height2 / 4) + cJ);
                drawable.setBounds(0, 0, 1, P);
                drawable.setAlpha(i2);
                drawable.draw(canvas);
            }
        }
        canvas.restore();
    }

    /* renamed from: a */
    public void mo31262a(Canvas canvas, int i, int i2, int i3, Paint paint2) {
        canvas.save();
        if (this.dwN >= i3) {
            int i4 = this.dwN - i3;
            int height = (getHeight() - getChildWidth()) / 2;
            int childWidth = getChildWidth() + height;
            int i5 = this.dwE;
            int i6 = this.dwW;
            if (i3 < 0 && i < Math.abs(i3)) {
                i = Math.abs(i3);
            }
            if (i4 > i) {
                Rect rect = new Rect(i, height, i4, childWidth);
                paint2.setColor(i6);
                paint2.setAlpha(0);
                canvas.drawRect(rect, paint2);
            }
            Drawable drawable = this.dwy;
            if (drawable != null) {
                this.dxd = i4 - 1;
                int P = C4583d.m11671P(56.0f);
                int height2 = (getHeight() - P) / 2;
                canvas.translate((float) this.dxd, (float) height2);
                int cJ = C6386d.m18374cJ(this);
                this.dxf.left = (float) this.dxd;
                this.dxf.top = (float) (((height2 * 3) / 4) + cJ);
                this.dxf.right = (float) (this.dxd + 1);
                this.dxf.bottom = (float) (height2 + P + (height2 / 4) + cJ);
                drawable.setBounds(0, 0, 1, P);
                drawable.setAlpha(i2);
                drawable.draw(canvas);
            }
        }
        canvas.restore();
    }

    /* renamed from: a */
    public void mo31263a(Canvas canvas, int i, boolean z, int i2, int i3) {
        Drawable drawable = this.dwx;
        if (drawable != null && z) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int F = mo31259F(this.dwR, i, this.dwM);
            if (!this.dxi && this.dxk && F < this.dwN) {
                F = this.dwN;
            }
            int i4 = F - i3;
            this.dxd = i4 - (intrinsicWidth / 2);
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int height = (getHeight() - intrinsicHeight) / 2;
            canvas.save();
            canvas.translate((float) this.dxd, (float) height);
            StringBuilder sb = new StringBuilder();
            sb.append("mTrimLeftBarLeftMargin = ");
            sb.append(this.dxd);
            LogUtilsV2.m14227d(sb.toString());
            int cJ = C6386d.m18374cJ(this);
            this.dxf.left = (float) this.dxd;
            this.dxf.top = (float) (((height * 3) / 4) + cJ);
            this.dxf.right = (float) (this.dxd + intrinsicWidth);
            this.dxf.bottom = (float) (height + intrinsicHeight + (height / 4) + cJ);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.setAlpha(i2);
            drawable.draw(canvas);
            canvas.restore();
            if (this.dnE) {
                Drawable drawable2 = this.dwA;
                m20809a(canvas, drawable2, (float) (i4 - (drawable2.getIntrinsicWidth() / 2)), 0.0f, this.dnG);
            }
        }
    }

    /* renamed from: a */
    public void mo31264a(Canvas canvas, boolean z, int i, int i2, int i3, int i4, Paint paint2) {
        int i5;
        StringBuilder sb = new StringBuilder();
        sb.append("mTrimRightPos = ");
        sb.append(this.dwO);
        sb.append(", rightBoundTrimPos = ");
        sb.append(i4);
        LogUtilsV2.m14227d(sb.toString());
        if (this.dwO <= i4) {
            int i6 = this.dwO - i3;
            int maxTrimRange = getMaxTrimRange() - i3;
            if (!avI() || i6 <= this.dxc) {
                i5 = i6;
            } else {
                this.dwO = this.dxc;
                i5 = this.dxc;
            }
            int height = (getHeight() - getChildWidth()) / 2;
            int childWidth = getChildWidth() + height;
            int i7 = i5 < i ? i : i5;
            if (maxTrimRange > getRight() - i) {
                maxTrimRange = getRight() - i;
            }
            if (maxTrimRange > i7) {
                int i8 = this.dwE;
                int i9 = this.dwW;
                Rect rect = new Rect(i7, height, maxTrimRange, childWidth);
                paint2.setColor(i9);
                if (this.dxk) {
                    paint2.setAlpha((int) (((float) this.dwX) * this.dwJ));
                } else {
                    paint2.setAlpha(0);
                }
                canvas.save();
                canvas.drawRect(rect, paint2);
                canvas.restore();
            }
            if (!isPlaying()) {
                boolean z2 = this.dwE == 2 || !this.dwS;
                Drawable drawable = z2 ? this.dws : this.dwq;
                if (drawable != null) {
                    if (!z) {
                        drawable = this.dwu;
                    }
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    if (avJ()) {
                        i5 -= intrinsicWidth / 2;
                    }
                    this.dxe = i5;
                    int childWidth2 = getChildWidth() + dwo;
                    int height2 = (getHeight() - childWidth2) / 2;
                    canvas.save();
                    canvas.translate((float) this.dxe, (float) height2);
                    int cJ = C6386d.m18374cJ(this);
                    this.dxg.left = (float) this.dxe;
                    this.dxg.top = (float) (((height2 * 3) / 4) + cJ);
                    this.dxg.right = (float) (this.dxe + intrinsicWidth);
                    this.dxg.bottom = (float) (height2 + childWidth2 + (height2 / 4) + cJ);
                    drawable.setBounds(0, 0, intrinsicWidth, childWidth2);
                    drawable.setAlpha(i2);
                    drawable.draw(canvas);
                    canvas.restore();
                    m20811a(canvas, z2, (float) (this.dxe + (intrinsicWidth / 2)), (float) (height2 - dwn));
                    if (z2 && this.dnE) {
                        Drawable drawable2 = this.dwA;
                        m20809a(canvas, drawable2, (float) (this.dxe - ((drawable2.getIntrinsicWidth() - intrinsicWidth) / 2)), 0.0f, this.dnH);
                    }
                }
            }
        }
    }

    public boolean avJ() {
        return this.dwD;
    }

    public boolean avK() {
        return this.dwS;
    }

    public boolean avL() {
        return this.dxi;
    }

    public boolean avM() {
        return this.dwE == 1 || this.dwS;
    }

    /* renamed from: dd */
    public int mo31269dd(int i, int i2) {
        if (avI()) {
            i -= Math.abs(getLeftLimitMoveOffset());
        }
        int i3 = i2 - 1;
        int i4 = this.dwL - (this.dwM * i3);
        int i5 = i / this.doK;
        int i6 = i % this.doK;
        if (avI()) {
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                i5 += firstVisiblePosition;
            }
        }
        int i7 = this.dwM * i5;
        int i8 = i5 < i3 ? i7 + ((i6 * this.dwM) / this.doK) : i7 + ((i6 * i4) / this.doK);
        if (i8 >= this.dwL) {
            i8 = this.dwL - 1;
        }
        return i == getMaxTrimRange() ? this.dwL - 1 : i8;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchDraw(android.graphics.Canvas r20) {
        /*
            r19 = this;
            r8 = r19
            r9 = r20
            int r10 = r19.getCount()
            if (r10 != 0) goto L_0x000b
            return
        L_0x000b:
            super.dispatchDraw(r20)
            boolean r0 = r19.avL()
            r11 = 1065353216(0x3f800000, float:1.0)
            r12 = 1
            r13 = 0
            if (r0 != 0) goto L_0x00ce
            int r0 = r8.dwL
            int r1 = dxa
            if (r0 <= r1) goto L_0x0020
            r14 = 1
            goto L_0x0021
        L_0x0020:
            r14 = 0
        L_0x0021:
            boolean r0 = r8.dwI
            if (r0 == 0) goto L_0x0105
            int r7 = r19.getPaddingLeft()
            r0 = 255(0xff, float:3.57E-43)
            int r15 = r19.getLeftBoundTrimPos()
            int r16 = r8.mo31290qw(r15)
            int r1 = r8.dwK
            if (r1 == 0) goto L_0x0073
            int r1 = r8.dwK
            r2 = 1036831949(0x3dcccccd, float:0.1)
            if (r1 <= 0) goto L_0x004f
            float r1 = r8.dwJ
            float r1 = r1 + r2
            r8.dwJ = r1
            float r1 = r8.dwJ
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 < 0) goto L_0x0062
            r8.dwJ = r11
            r8.dwK = r13
        L_0x004d:
            r1 = 1
            goto L_0x0063
        L_0x004f:
            float r1 = r8.dwJ
            float r1 = r1 - r2
            r8.dwJ = r1
            float r1 = r8.dwJ
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0062
            r8.dwJ = r2
            r8.dwK = r13
            r8.dwI = r13
            goto L_0x004d
        L_0x0062:
            r1 = 0
        L_0x0063:
            float r0 = (float) r0
            float r2 = r8.dwJ
            float r0 = r0 * r2
            int r0 = (int) r0
            if (r1 != 0) goto L_0x006e
            r19.invalidate()
        L_0x006e:
            r17 = r0
            r18 = r1
            goto L_0x0077
        L_0x0073:
            r17 = 255(0xff, float:3.57E-43)
            r18 = 0
        L_0x0077:
            boolean r0 = r19.isPlaying()
            if (r0 != 0) goto L_0x0082
            r0 = r14 ^ 1
            r8.m20810a(r9, r0)
        L_0x0082:
            android.graphics.Paint r6 = r8.paint
            r0 = r19
            r1 = r20
            r2 = r14
            r3 = r7
            r4 = r17
            r5 = r15
            r0.m20812a(r1, r2, r3, r4, r5, r6)
            boolean r0 = r8.dxk
            if (r0 != 0) goto L_0x0097
            r8.m20808a(r9, r15, r15)
        L_0x0097:
            android.graphics.Paint r6 = r8.paint
            r0 = r19
            r1 = r20
            r2 = r14
            r3 = r7
            r4 = r17
            r5 = r15
            r7 = r6
            r6 = r16
            r0.mo31264a(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r19.isPlaying()
            if (r0 == 0) goto L_0x00ba
            r0 = r19
            r1 = r20
            r2 = r10
            r3 = r14
            r4 = r17
            r5 = r15
            r0.mo31263a(r1, r2, r3, r4, r5)
        L_0x00ba:
            if (r18 == 0) goto L_0x0105
            com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery$b r0 = r8.cDW
            if (r0 == 0) goto L_0x0105
            com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery$b r0 = r8.cDW
            float r1 = r8.dwJ
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 < 0) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r12 = 0
        L_0x00ca:
            r0.mo28156eL(r12)
            goto L_0x0105
        L_0x00ce:
            boolean r0 = r8.dwI
            if (r0 == 0) goto L_0x0105
            r8.dwJ = r11
            int r0 = r8.dwL
            int r1 = dxa
            if (r0 <= r1) goto L_0x00db
            goto L_0x00dc
        L_0x00db:
            r12 = 0
        L_0x00dc:
            int r6 = r19.getPaddingLeft()
            r7 = 255(0xff, float:3.57E-43)
            int r11 = r19.getLeftBoundTrimPos()
            int r13 = r8.mo31290qw(r11)
            android.graphics.Paint r5 = r8.paint
            r3 = 255(0xff, float:3.57E-43)
            r0 = r19
            r1 = r20
            r2 = r6
            r4 = r11
            r0.mo31262a(r1, r2, r3, r4, r5)
            android.graphics.Paint r14 = r8.paint
            r5 = r13
            r6 = r14
            r0.mo31261a(r1, r2, r3, r4, r5, r6)
            r2 = r10
            r3 = r12
            r4 = r7
            r5 = r11
            r0.mo31263a(r1, r2, r3, r4, r5)
        L_0x0105:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery.dispatchDraw(android.graphics.Canvas):void");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.dpl) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>>>>>>>>>>1 action:");
        sb.append(motionEvent.getAction());
        LogUtilsV2.m14227d(sb.toString());
        int action = motionEvent.getAction();
        if (action != 3) {
            switch (action) {
                case 0:
                    if (m20804O(motionEvent) || avL()) {
                        this.dnE = true;
                    }
                    LogUtilsV2.m14227d("touch down");
                    break;
                case 1:
                    break;
            }
        }
        this.dnE = false;
        LogUtilsV2.m14227d("touch up/cancel");
        if (!avL()) {
            if (!isPlaying()) {
                if (mo31260Q(motionEvent)) {
                    return true;
                }
            } else if (m20805P(motionEvent)) {
                return true;
            }
        } else if (m20805P(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getChildLeftMostBounds() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            return childAt.getLeft();
        }
        return 0;
    }

    public int getChildRightMostBounds() {
        View childAt = getChildAt(getChildCount() - 1);
        if (childAt != null) {
            return childAt.getRight();
        }
        return 0;
    }

    public int getClipIndex() {
        return this.mClipIndex;
    }

    public int getCurPlayPos() {
        return this.dwR;
    }

    public int getLeftBoundTrimPos() {
        if (avI()) {
            return 0;
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        View childAt = getChildAt(0);
        int i = firstVisiblePosition * this.doK;
        if (childAt != null) {
            i -= childAt.getLeft();
        }
        return i;
    }

    public int getMaxTrimRange() {
        return this.doK * getCount();
    }

    public int getTrimLeftValue() {
        return this.cEe;
    }

    public int getTrimRightValue() {
        return this.cEf;
    }

    public int getmTrimLeftPos() {
        return this.dwN;
    }

    public int getmTrimRightPos() {
        return this.dwO;
    }

    /* renamed from: hR */
    public void mo31282hR(boolean z) {
        if (this.cEf - this.cEe < dxa && this.dwM > 0) {
            int i = 1;
            this.dxj = true;
            int i2 = 0;
            if (dxa < this.dwL) {
                i2 = dxa / this.dwM;
            }
            int i3 = (i2 * this.doK) + ((this.doK * (dxa % this.dwM)) / this.dwM);
            int count = getCount();
            if (i3 != 0) {
                i = i3;
            }
            if (z) {
                int i4 = this.dwO - i;
                int dd = this.cEf - mo31269dd(i4, count);
                while (dd < dxa) {
                    i4--;
                    if (i4 >= 0) {
                        dd = this.cEf - mo31269dd(i4, count);
                        if (dd >= dxa) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.dwN = i4;
                this.cEe = mo31269dd(this.dwN, count);
            } else {
                int i5 = this.dwN + i;
                int dd2 = mo31269dd(i5, count) - this.cEe;
                while (dd2 < dxa) {
                    i5++;
                    if (i5 < getMaxTrimRange()) {
                        dd2 = mo31269dd(i5, count) - this.cEe;
                        if (dd2 >= dxa) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.dwO = i5;
                this.cEf = mo31269dd(this.dwO, count);
            }
        }
    }

    /* renamed from: hS */
    public void mo31283hS(boolean z) {
        if ((this.cEe + this.dwL) - this.cEf < dxa && this.dwM > 0) {
            int count = getCount();
            int i = 1;
            this.dxj = true;
            int i2 = 0;
            if (dxa < this.dwL) {
                i2 = dxa / this.dwM;
            }
            int i3 = (i2 * this.doK) + ((this.doK * (dxa % this.dwM)) / this.dwM);
            if (i3 != 0) {
                i = i3;
            }
            if (z) {
                int maxTrimRange = (this.dwO + i) - getMaxTrimRange();
                int dd = (mo31269dd(maxTrimRange, count) + this.dwL) - this.cEf;
                while (dd < dxa) {
                    maxTrimRange++;
                    if (maxTrimRange <= this.dwO) {
                        dd = (mo31269dd(maxTrimRange, count) + this.dwL) - this.cEf;
                        if (dd >= dxa) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.dwN = maxTrimRange;
                this.cEe = mo31269dd(this.dwN, count);
            } else {
                int maxTrimRange2 = getMaxTrimRange();
                int i4 = (this.dwN + maxTrimRange2) - i;
                int dd2 = (this.cEe + this.dwL) - mo31269dd(i4, count);
                while (dd2 < dxa) {
                    i4--;
                    if (i4 <= maxTrimRange2) {
                        dd2 = (this.cEe + this.dwL) - mo31269dd(i4, count);
                        if (dd2 >= dxa) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.dwO = i4;
                this.cEf = mo31269dd(this.dwO, count);
            }
        }
    }

    public boolean isPlaying() {
        return this.cGk;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cDW == null || !this.cDW.mo28155e(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.cDW == null || !this.cDW.mo28157f(i, keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: pQ */
    public void mo31287pQ(int i) {
        m20827hT(false);
        this.dwT = false;
        this.dwZ = -1;
    }

    /* renamed from: qu */
    public int mo31288qu(int i) {
        return mo31269dd((avM() ? this.dwN : this.dwO) + i, getCount());
    }

    /* renamed from: qv */
    public int mo31289qv(int i) {
        return this.doK * i;
    }

    /* renamed from: qw */
    public int mo31290qw(int i) {
        if (i < 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            View childAt = getChildAt(0);
            i = firstVisiblePosition * this.doK;
            if (childAt != null) {
                i -= childAt.getLeft();
            }
        }
        return i + getWidth();
    }

    public void setCenterAlign(boolean z) {
        this.dwD = z;
    }

    public void setClipDuration(int i) {
        this.dwL = i;
    }

    public void setClipIndex(int i) {
        this.mClipIndex = i;
    }

    public void setCurPlayPos(int i) {
        this.dwR = i;
        postInvalidate();
    }

    public void setDrawableCurTimeNeedle(Drawable drawable) {
        this.dwx = drawable;
    }

    public void setIsPositiveTrim(boolean z) {
        this.dxk = z;
    }

    public void setLeftDraging(boolean z) {
        this.dwS = z;
    }

    public void setLeftMessage(String str) {
        this.dnG = str;
    }

    public void setLeftTrimBarDrawable(Drawable drawable, Drawable drawable2) {
        this.dwp = drawable;
        this.dwr = drawable2;
    }

    public void setMaxRightPos(int i) {
        this.dxc = i;
    }

    public void setMbDragSatus(int i) {
        this.dwE = i;
    }

    public void setMinLeftPos(int i) {
        this.dxb = i;
    }

    public void setMinMaxEqualLimitEnable() {
        this.dwQ = true;
    }

    public void setOnTrimGalleryListener(C7093b bVar) {
        this.cDW = bVar;
    }

    public void setParentViewOffset(int i) {
        this.dwV = i;
    }

    public void setPerChildDuration(int i) {
        this.dwM = i;
    }

    public void setPlaying(boolean z) {
        this.cGk = z;
        postInvalidate();
    }

    public void setRightMessage(String str) {
        this.dnH = str;
    }

    public void setRightTrimBarDrawable(Drawable drawable, Drawable drawable2) {
        this.dwq = drawable;
        this.dws = drawable2;
    }

    public void setSplitMessage(String str) {
        this.dnG = str;
    }

    public void setSplitMode(boolean z) {
        this.dxi = z;
    }

    public void setTrimLeftValue(int i) {
        this.cEe = i;
        this.dwN = mo31259F(i, getCount(), this.dwM);
        m20826hQ(this.dxk);
        invalidate();
    }

    public void setTrimLeftValueWithoutLimitDetect(int i) {
        this.cEe = i;
        this.dwN = mo31259F(i, getCount(), this.dwM);
        invalidate();
    }

    public void setTrimRightValue(int i) {
        this.cEf = i;
        this.dwO = mo31259F(i, getCount(), this.dwM);
        if (this.dwO == 0) {
            this.dwO = 1;
        }
        m20826hQ(this.dxk);
        invalidate();
    }

    public void setTrimRightValueWithoutLimitDetect(int i) {
        this.cEf = i;
        this.dwO = mo31259F(i, getCount(), this.dwM);
        if (this.dwO == 0) {
            this.dwO = 1;
        }
        invalidate();
    }

    public void setmDrawableLeftTrimBarDis(Drawable drawable) {
        this.dwt = drawable;
    }

    public void setmDrawableRightTrimBarDis(Drawable drawable) {
        this.dwu = drawable;
    }

    public void setmDrawableTrimContent(Drawable drawable) {
        this.dwv = drawable;
    }

    public void setmDrawableTrimContentDis(Drawable drawable) {
        this.dww = drawable;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public boolean mo31320x(MotionEvent motionEvent) {
        if (this.dwT) {
            this.dwT = false;
            if (this.dxp != null) {
                this.dxp.agw();
            }
            return true;
        } else if (this.dwZ < 0) {
            return super.mo31320x(motionEvent);
        } else {
            View view = (View) getParent();
            if (view instanceof VeGallery) {
                VeGallery veGallery = (VeGallery) view;
                SpinnerAdapter adapter = veGallery.getAdapter();
                View childAt = veGallery.getChildAt(this.dwZ);
                int firstVisiblePosition = this.dwZ + veGallery.getFirstVisiblePosition();
                if (adapter != null) {
                    veGallery.mo31335b(childAt, firstVisiblePosition, adapter.getItemId(firstVisiblePosition));
                }
            }
            return true;
        }
    }
}
