package com.introvd.template.editor.videotrim.p292ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.Scroller;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.videotrim.p292ui.VeAdapterView.C6988a;
import com.introvd.template.editor.videotrim.p292ui.VeGallery2.C6994a;
import java.lang.reflect.Field;

@SuppressLint({"WrongCall"})
/* renamed from: com.introvd.template.editor.videotrim.ui.VePIPGallery */
public class VePIPGallery extends VeAbsSpinner implements OnGestureListener {
    protected final GestureDetector aML;
    protected int aex;
    protected C7003f cuQ;
    protected View doA;
    protected boolean doB;
    protected boolean doC;
    protected boolean doD;
    protected boolean doE;
    protected C6988a doF;
    protected boolean doG;
    protected boolean doH;
    protected boolean doI;
    protected boolean doJ;
    protected int doK;
    protected int doL;
    protected boolean doM;
    protected boolean doN;
    protected int doO;
    protected int doP;
    protected int doQ;
    protected int doR;
    protected int doS;
    protected boolean doT;
    protected boolean doU;
    protected boolean doV;
    protected boolean doW;
    protected C7002e doX;
    protected C7001d doY;
    protected C7004g doZ;
    protected boolean dop;
    protected int doq;
    protected int dor;
    protected float dos;
    protected int dot;
    protected int dou;
    protected int dov;
    protected View dow;
    public final C6998a dox;
    protected final Runnable doy;
    protected boolean doz;
    protected C7000c dpa;
    protected final C6999b dpb;
    protected boolean dpc;
    protected boolean dpd;
    protected boolean dpe;
    protected boolean dpf;
    protected boolean dpg;
    protected boolean dph;
    protected boolean dpi;
    private boolean dpj;
    protected int dpk;
    protected boolean dpl;
    protected boolean dpm;
    protected boolean dpn;
    private final OnDoubleTapListener dpo;
    protected MotionEvent mCurrentDownEvent;
    protected int mGravity;
    protected int mTouchSlopSquare;

    /* renamed from: com.introvd.template.editor.videotrim.ui.VePIPGallery$LayoutParams */
    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VePIPGallery$a */
    protected class C6998a implements Runnable {
        private int aaQ;
        private boolean dpq = false;
        /* access modifiers changed from: private */
        public final Scroller mScroller;

        public C6998a() {
            this.mScroller = new Scroller(VePIPGallery.this.getContext());
        }

        private void aus() {
            VePIPGallery.this.removeCallbacks(this);
        }

        /* renamed from: hB */
        public void mo30880hB(boolean z) {
            this.dpq = false;
            VePIPGallery.this.dpg = false;
            this.mScroller.forceFinished(true);
            if (z) {
                VePIPGallery.this.aug();
            }
        }

        /* renamed from: pU */
        public void mo30881pU(int i) {
            if (i != 0) {
                aus();
                int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                this.aaQ = i2;
                this.mScroller.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                VePIPGallery.this.post(this);
            }
        }

        /* renamed from: pV */
        public void mo30882pV(int i) {
            if (i != 0) {
                aus();
                this.aaQ = 0;
                this.mScroller.startScroll(0, 0, -i, 0, VePIPGallery.this.dor);
                VePIPGallery.this.post(this);
            }
        }

        public void run() {
            int i;
            if (VePIPGallery.this.aaE == 0) {
                mo30880hB(true);
                return;
            }
            VePIPGallery.this.doz = false;
            Scroller scroller = this.mScroller;
            boolean computeScrollOffset = scroller.computeScrollOffset();
            int currX = scroller.getCurrX();
            this.dpq = computeScrollOffset;
            int i2 = this.aaQ - currX;
            if (i2 > 0) {
                VePIPGallery.this.dov = VePIPGallery.this.dnS;
                i = Math.min(((VePIPGallery.this.getWidth() - VePIPGallery.this.getPaddingLeft()) - VePIPGallery.this.getPaddingRight()) - 1, i2);
            } else {
                int childCount = VePIPGallery.this.getChildCount() - 1;
                VePIPGallery.this.dov = VePIPGallery.this.dnS + childCount;
                i = Math.max(-(((VePIPGallery.this.getWidth() - VePIPGallery.this.getPaddingRight()) - VePIPGallery.this.getPaddingLeft()) - 1), i2);
            }
            VePIPGallery.this.mo30788ag(i, true);
            if (!computeScrollOffset || VePIPGallery.this.doz) {
                mo30880hB(true);
            } else {
                this.aaQ = currX;
                VePIPGallery.this.post(this);
            }
        }

        public void stop(boolean z) {
            VePIPGallery.this.removeCallbacks(this);
            mo30880hB(z);
        }
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VePIPGallery$b */
    private class C6999b implements Runnable {
        private boolean dpr = false;
        private boolean dps = false;

        public C6999b() {
        }

        public void run() {
            int i = VePIPGallery.this.doK;
            int pT = this.dpr ? VePIPGallery.this.mo30847pT(-i) : VePIPGallery.this.mo30847pT(i);
            if (this.dps) {
                VePIPGallery.this.mo30792ah(pT, true);
                stop();
            }
        }

        public void stop() {
            if (this.dps) {
                this.dps = false;
                VePIPGallery.this.removeCallbacks(this);
            }
        }
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VePIPGallery$c */
    public interface C7000c {
        /* renamed from: a */
        boolean mo30887a(VeAdapterView<?> veAdapterView, View view, int i);
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VePIPGallery$d */
    public interface C7001d {
        void onDraw(Canvas canvas);
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VePIPGallery$e */
    public interface C7002e {
        void acC();

        /* renamed from: cu */
        void mo27501cu(View view);

        /* renamed from: cv */
        void mo27502cv(View view);

        /* renamed from: w */
        void mo27503w(MotionEvent motionEvent);

        /* renamed from: y */
        void mo27505y(MotionEvent motionEvent);

        /* renamed from: y */
        void mo27506y(View view, int i);
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VePIPGallery$f */
    public interface C7003f {
        /* renamed from: cw */
        void mo27509cw(View view);
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VePIPGallery$g */
    public interface C7004g {
        /* renamed from: aA */
        void mo30888aA(float f);

        void aut();

        /* renamed from: az */
        void mo30890az(float f);
    }

    public VePIPGallery(Context context) {
        this(context, null);
    }

    public VePIPGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842864);
    }

    public VePIPGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dop = true;
        this.doq = 0;
        this.dor = 50;
        this.dox = new C6998a();
        this.doy = new Runnable() {
            public void run() {
                VePIPGallery.this.doD = false;
                VePIPGallery.this.aua();
            }
        };
        this.doB = true;
        this.doC = true;
        this.doH = false;
        this.doI = false;
        this.doJ = false;
        this.doK = 0;
        this.doL = -1;
        this.doM = false;
        this.doN = false;
        this.doO = -1;
        this.doP = 0;
        this.doQ = -1;
        this.doR = 0;
        this.doS = 0;
        this.doT = false;
        this.doU = true;
        this.doV = false;
        this.doW = false;
        this.doX = null;
        this.doY = null;
        this.doZ = null;
        this.cuQ = null;
        this.dpa = null;
        this.dpb = new C6999b();
        this.dpc = false;
        this.dpd = false;
        this.dpe = false;
        this.dpf = false;
        this.mTouchSlopSquare = 0;
        this.dpg = false;
        this.dph = true;
        this.dpi = false;
        this.dpj = false;
        this.dpk = 0;
        this.dpl = true;
        this.dpm = true;
        this.dpn = false;
        this.aex = 0;
        this.dpo = new OnDoubleTapListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                VePIPGallery.this.auf();
                return false;
            }

            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return false;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (VePIPGallery.this instanceof VeGallery2) {
                    if (VePIPGallery.this.doX == null || !(VePIPGallery.this.doX instanceof C6994a)) {
                        VePIPGallery.this.mo30874x(motionEvent);
                    } else {
                        C6994a aVar = (C6994a) VePIPGallery.this.doX;
                        if (aVar != null) {
                            aVar.mo27504x(motionEvent);
                        }
                    }
                    return false;
                }
                VePIPGallery.this.mo30874x(motionEvent);
                return false;
            }
        };
        this.aML = new GestureDetector(context, this);
        this.aML.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VeGallery, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.VeGallery_android_gravity, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.VeGallery_android_animationDuration, -1);
        if (i3 > 0) {
            setAnimationDuration(i3);
        }
        setSpacing(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.VeGallery_android_spacing, 0));
        setUnselectedAlpha(obtainStyledAttributes.getFloat(R.styleable.VeGallery_android_unselectedAlpha, 0.5f));
        obtainStyledAttributes.recycle();
        setStaticTransformationsEnabled(true);
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
    }

    /* renamed from: L */
    private float m20460L(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    /* renamed from: a */
    private void m20461a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    /* renamed from: a */
    private boolean m20462a(View view, int i, long j) {
        boolean z;
        if (this.doc != null) {
            z = this.doc.mo30784b(this, this.dow, this.dov, j);
        } else {
            z = false;
        }
        if (!z) {
            this.doF = new C6988a(view, i, j);
            z = super.showContextMenuForChild(this);
        }
        if (z) {
            performHapticFeedback(0);
        }
        return z;
    }

    /* access modifiers changed from: private */
    public boolean auf() {
        if (this.dpa == null || this.dov < 0) {
            return false;
        }
        return this.dpa.mo30887a(this, getChildAt(this.dov - this.dnS), this.dov);
    }

    /* access modifiers changed from: private */
    public void aug() {
        if (getChildCount() != 0 && this.doA != null) {
            if (!this.doH) {
                aui();
                return;
            }
            int centerOfGallery = getCenterOfGallery() - m20467cM(this.doA);
            if (centerOfGallery != 0) {
                this.dox.mo30882pV(centerOfGallery);
            } else {
                aui();
            }
        }
    }

    /* access modifiers changed from: private */
    public void auo() {
        if (this.dph) {
            int childCount = getChildCount();
            while (true) {
                childCount--;
                if (childCount >= 0) {
                    getChildAt(childCount).setPressed(false);
                } else {
                    setPressed(false);
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private void m20464b(View view, int i, int i2, boolean z) {
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        }
        boolean z2 = false;
        addViewInLayout(view, z ? -1 : 0, layoutParams);
        if (i == 0) {
            z2 = true;
        }
        view.setSelected(z2);
        view.measure(ViewGroup.getChildMeasureSpec(this.dnJ, this.dnL.left + this.dnL.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.dnI, this.dnL.top + this.dnL.bottom, layoutParams.height));
        int n = mo30833n(view, true);
        int measuredHeight = view.getMeasuredHeight() + n;
        int measuredWidth = view.getMeasuredWidth();
        if (z) {
            i3 = i2 + measuredWidth;
        } else {
            i3 = i2;
            i2 -= measuredWidth;
        }
        view.layout(i2, n, i3, measuredHeight);
    }

    /* renamed from: cM */
    public static int m20467cM(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    /* renamed from: cN */
    private void m20468cN(View view) {
        if (this.dph) {
            if (view != null) {
                view.setPressed(true);
            }
            setPressed(true);
        }
    }

    /* renamed from: pS */
    private boolean m20469pS(int i) {
        View childAt = getChildAt(i);
        if (childAt == null) {
            return false;
        }
        this.dox.mo30882pV(getCenterOfGallery() - m20467cM(childAt));
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void acC() {
        this.doT = false;
        if (this.dox.mScroller.isFinished()) {
            aug();
        }
        auo();
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"WrongCall"})
    /* renamed from: ae */
    public void mo30713ae(int i, boolean z) {
        int i2 = this.dnL.left;
        int right = ((getRight() - getLeft()) - this.dnL.left) - this.dnL.right;
        int count = getCount();
        if (this.bXu) {
            handleDataChanged();
        }
        if (this.aaE == 0 || this.f3520SZ == null) {
            atX();
            this.dnS = 0;
            if (this.cuQ != null) {
                this.cuQ.mo27509cw(this);
            }
            return;
        }
        if (this.doO >= 0) {
            this.dod = this.doO;
        }
        if (this.dod >= 0) {
            setSelectedPositionInt(this.dod);
        }
        atY();
        detachAllViewsFromParent();
        this.dou = 0;
        this.dot = 0;
        this.dnS = this.dof;
        View c = mo30803c(this.dof, 0, 0, true);
        if (this.doH) {
            int i3 = i2 + (right / 2);
            if (this.doI || this.doL <= 0) {
                c.offsetLeftAndRight(i3);
            } else if (this.doL > 0) {
                if (this.dof >= this.doL && this.dof < count - this.doL && count >= (this.doL * 2) + 1) {
                    c.offsetLeftAndRight(i3);
                } else if (this.dof < this.doL || count < (this.doL * 2) + 1) {
                    c.offsetLeftAndRight((this.doK * this.dof) + getPaddingLeft());
                } else {
                    int i4 = (this.dof - (count - this.doL)) + 1;
                    if (i4 > 0) {
                        c.offsetLeftAndRight((this.doK * (this.doL + i4)) + getPaddingLeft());
                    }
                }
            }
        } else {
            setSelectionInfoOnLayout(0, getCenterOfGallery() - getPaddingLeft());
            if (this.doO >= 0) {
                c.offsetLeftAndRight(this.dnL.left + this.doP);
            } else {
                c.offsetLeftAndRight(this.dnL.left);
            }
        }
        if (this.dpi) {
            auk();
        } else {
            aum();
            aul();
        }
        if (!this.doW) {
            this.dnN.clear();
        }
        if (this.cuQ != null) {
            this.cuQ.mo27509cw(this);
        }
        if (!this.dpm) {
            this.doO = -1;
            this.doP = -1;
        }
        invalidate();
        auc();
        this.bXu = false;
        this.dnX = false;
        setNextSelectedPositionInt(this.dof);
        auq();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ag */
    public int mo30788ag(int i, boolean z) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        boolean z2 = i < 0;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r = mo30790r(z2, i);
        if (r != 0) {
            if (r >= width) {
                r = width - 1;
            }
            int i2 = -width;
            if (r <= i2) {
                r = i2 + 1;
            }
            mo30846pR(r);
            mo30828hw(z2);
            if (z2) {
                aum();
            } else {
                aul();
            }
            this.dnN.clear();
            if (this.doH) {
                auj();
            }
            mo30789pQ(r);
            if (this.doX != null) {
                if (this.doG && z) {
                    this.doX.mo27502cv(this);
                    this.doG = false;
                }
                if (z) {
                    this.doJ = true;
                }
                this.doX.mo27506y(this, r);
            }
            invalidate();
        }
        if (r != i) {
            this.dox.mo30880hB(false);
            aui();
        }
        return r;
    }

    /* renamed from: ah */
    public void mo30792ah(int i, boolean z) {
        if (i != 0 && !this.dpg) {
            this.dpg = z;
            if (!this.doG) {
                this.doG = true;
            }
            this.dox.mo30882pV(i);
        }
    }

    /* access modifiers changed from: 0000 */
    public void aua() {
        if (!this.doD) {
            super.aua();
        }
    }

    /* access modifiers changed from: protected */
    public void auh() {
        StringBuilder sb = new StringBuilder();
        sb.append(" onMoveStoped222 run  mIsPressedStatus=");
        sb.append(this.doT);
        sb.append(";mCanSendMoveStop=");
        sb.append(this.doJ);
        LogUtils.m14223i("VePIPGallery", sb.toString());
        if (this.doX != null && this.doJ && !this.doT) {
            this.doJ = false;
            this.doX.mo27501cu(this);
        }
    }

    /* access modifiers changed from: protected */
    public void aui() {
        if (this.doD) {
            this.doD = false;
            super.aua();
        }
        this.dpg = false;
        auh();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void auj() {
        View view = this.doA;
        int centerOfGallery = getCenterOfGallery();
        if (view == null || view.getLeft() > centerOfGallery || view.getRight() < centerOfGallery) {
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            int childCount = getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    break;
                }
                View childAt = getChildAt(childCount);
                if (childAt.getLeft() <= centerOfGallery && childAt.getRight() >= centerOfGallery) {
                    i2 = childCount;
                    break;
                }
                int min = Math.min(Math.abs(childAt.getLeft() - centerOfGallery), Math.abs(childAt.getRight() - centerOfGallery));
                if (min < i) {
                    i2 = childCount;
                    i = min;
                }
                childCount--;
            }
            int i3 = this.dnS + i2;
            if (i3 != this.dof) {
                setSelectedPositionInt(i3);
                setNextSelectedPositionInt(i3);
                auc();
            }
        }
    }

    public void auk() {
        int i;
        int i2;
        int i3;
        int i4 = this.doq;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i5 = this.aaE;
        if (!this.dpj) {
            View childAt = getChildAt(0);
            int centerOfGallery = getCenterOfGallery() - this.dpk;
            int width = childAt.getWidth() + centerOfGallery;
            childAt.offsetLeftAndRight(centerOfGallery - childAt.getLeft());
            for (int i6 = this.dnS - 1; i6 >= 0; i6--) {
                View c = mo30803c(i6, i6 - this.dof, width, false);
                if (c == null) {
                    break;
                }
                if (c.getLeft() != centerOfGallery) {
                    int left = centerOfGallery - c.getLeft();
                    width += left;
                    c.offsetLeftAndRight(left);
                }
                this.dnS = i6;
            }
            for (int i7 = this.dof + 1; i7 < i5; i7++) {
                mo30803c(i7, i7 - this.dof, centerOfGallery, true);
            }
            return;
        }
        View childAt2 = getChildAt(childCount - 1);
        if (childAt2 != null) {
            i = this.dnS + childCount;
            i3 = childAt2.getLeft();
            i2 = childAt2.getRight() + i4;
        } else {
            i = this.dnS + childCount;
            i3 = getPaddingLeft();
            this.doz = true;
            i2 = right;
        }
        while (i < i5 && i2 < right) {
            i2 += mo30803c(i, i - this.dof, i3, true).getWidth() + i4;
            i++;
        }
    }

    public void aul() {
        int i;
        int i2;
        int i3 = this.doq;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.dnS - 1;
            i2 = childAt.getLeft() - i3;
        } else {
            i = this.dnS - 1;
            i2 = (getRight() - getLeft()) - getPaddingRight();
            this.doz = true;
        }
        while (i2 > paddingLeft && i >= 0) {
            View c = mo30803c(i, i - this.dof, i2, false);
            this.dnS = i;
            i2 = c.getLeft() - i3;
            i--;
        }
    }

    public void aum() {
        int i;
        int i2;
        int i3 = this.doq;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i4 = this.aaE;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.dnS + childCount;
            i2 = childAt.getRight() + i3;
        } else {
            i = this.dnS + childCount;
            i2 = getPaddingLeft();
            this.doz = true;
        }
        while (i2 < right && i < i4) {
            i2 = mo30803c(i, i - this.dof, i2, true).getRight() + i3;
            i++;
        }
    }

    public void aun() {
        Class cls = null;
        try {
            cls = Class.forName("android.view.GestureDetector");
        } catch (ClassNotFoundException e) {
            try {
                e.printStackTrace();
            } catch (SecurityException e2) {
                e2.printStackTrace();
                return;
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (cls != null) {
            Field declaredField = cls.getDeclaredField("mHandler");
            Field declaredField2 = cls.getDeclaredField("LONG_PRESS");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            try {
                Object obj = declaredField.get(this.aML);
                int i = declaredField2.getInt(this.aML);
                if (obj instanceof Handler) {
                    ((Handler) obj).removeMessages(i);
                }
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean aup() {
        if (this.aaE <= 0 || this.dof <= 0) {
            return false;
        }
        m20469pS((this.dof - this.dnS) - 1);
        return true;
    }

    /* access modifiers changed from: protected */
    public void auq() {
        View view = this.doA;
        View childAt = getChildAt(this.dof - this.dnS);
        this.doA = childAt;
        if (childAt != null) {
            childAt.setSelected(true);
            childAt.setFocusable(true);
            if (hasFocus()) {
                childAt.requestFocus();
            }
            if (view != null) {
                view.setSelected(false);
                view.setFocusable(false);
            }
        }
    }

    public boolean aur() {
        return this.dpf;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public View mo30803c(int i, int i2, int i3, boolean z) {
        View view;
        if (!this.bXu) {
            view = this.dnN.mo30740pO(i);
            if (view != null) {
                int left = view.getLeft();
                this.dou = Math.max(this.dou, view.getMeasuredWidth() + left);
                this.dot = Math.min(this.dot, left);
                m20464b(view, i2, i3, z);
                return view;
            }
        } else {
            view = null;
        }
        if (this.f3520SZ != null) {
            view = this.f3520SZ.getView(i, null, this);
            m20464b(view, i2, i3, z);
        }
        return view;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cK */
    public int mo30716cK(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollExtent() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollOffset() {
        return !this.doH ? this.dnS : this.dof;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        return this.aaE;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.doY != null) {
            this.doY.onDraw(canvas);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.doU ? keyEvent.dispatch(this) : super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
        if (this.doA != null) {
            this.doA.setPressed(z);
        }
    }

    public void dispatchSetSelected(boolean z) {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.dpl && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("dispatchTouchEvent e:");
        sb.append(motionEvent);
        LogUtils.m14223i("VePIPGallery", sb.toString());
        int action = motionEvent.getAction();
        if (action == 0 && this.doX != null) {
            this.doX.mo27503w(motionEvent);
        }
        if (this.dpc) {
            float y = motionEvent.getY();
            float x = motionEvent.getX();
            if (action == 0) {
                this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                this.dpd = true;
                this.doN = false;
                requestDisallowInterceptTouchEvent(true);
            } else if (action == 2 && this.dpd && this.mCurrentDownEvent != null) {
                int x2 = (int) (x - this.mCurrentDownEvent.getX());
                int y2 = (int) (y - this.mCurrentDownEvent.getY());
                if ((x2 * x2) + (y2 * y2) > this.mTouchSlopSquare) {
                    this.doN = true;
                    requestDisallowInterceptTouchEvent(false);
                    super.dispatchTouchEvent(motionEvent);
                    onTouchEvent(this.mCurrentDownEvent);
                    this.mCurrentDownEvent = null;
                }
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (action == 1 || action == 3) {
            if (this.doX != null) {
                this.doX.acC();
            }
            if ((this instanceof VeGallery2) && this.dop) {
                this.doJ = true;
                this.doT = false;
                auh();
            }
        }
        return dispatchTouchEvent;
    }

    /* access modifiers changed from: protected */
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCenterOfGallery() {
        return this.doQ > 0 ? this.doQ : (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = this.dof - this.dnS;
        return i3 < 0 ? i2 : i2 == i + -1 ? i3 : i2 >= i3 ? i2 + 1 : i2;
    }

    /* access modifiers changed from: protected */
    public boolean getChildStaticTransformation(View view, Transformation transformation) {
        transformation.clear();
        transformation.setAlpha(view == this.doA ? 1.0f : this.dos);
        return true;
    }

    public int getChildWidth() {
        return this.doK;
    }

    /* access modifiers changed from: protected */
    public ContextMenuInfo getContextMenuInfo() {
        return this.doF;
    }

    public boolean getFillToCenter() {
        return this.dpi;
    }

    public boolean getLeftToCenter() {
        return this.dpj;
    }

    public int getRightLimitMoveOffset() {
        return this.doS;
    }

    public int getSapcing() {
        return this.doq;
    }

    public int getmGalleryCenterPosition() {
        return this.doQ;
    }

    /* renamed from: hA */
    public void mo30825hA(boolean z) {
        this.doI = z;
    }

    /* renamed from: hu */
    public void mo30826hu(boolean z) {
        this.dnK = z;
    }

    /* renamed from: hv */
    public void mo30827hv(boolean z) {
        this.dpm = z;
    }

    /* renamed from: hw */
    public void mo30828hw(boolean z) {
        int i;
        int childCount = getChildCount();
        int i2 = this.dnS;
        int i3 = 0;
        if (z) {
            int paddingLeft = getPaddingLeft();
            i = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getRight() >= paddingLeft) {
                    break;
                }
                i++;
                this.dnN.mo30739f(i2 + i4, childAt);
            }
        } else {
            int width = getWidth() - getPaddingRight();
            int i5 = 0;
            for (int i6 = childCount - 1; i6 >= 0; i6--) {
                View childAt2 = getChildAt(i6);
                if (childAt2.getLeft() <= width) {
                    break;
                }
                i5 = i + 1;
                this.dnN.mo30739f(i2 + i6, childAt2);
                i3 = i6;
            }
        }
        detachViewsFromParent(i3, i);
        if (z) {
            this.dnS += i;
        }
    }

    /* renamed from: hx */
    public void mo30829hx(boolean z) {
        this.dpc = z;
    }

    /* renamed from: hy */
    public void mo30830hy(boolean z) {
        this.dpl = z;
    }

    /* renamed from: hz */
    public void mo30831hz(boolean z) {
        this.doH = z;
    }

    /* access modifiers changed from: 0000 */
    public boolean moveNext() {
        if (this.aaE <= 0 || this.dof >= this.aaE - 1) {
            return false;
        }
        m20469pS((this.dof - this.dnS) + 1);
        return true;
    }

    /* renamed from: n */
    public int mo30833n(View view, boolean z) {
        int measuredHeight = z ? getMeasuredHeight() : getHeight();
        int measuredHeight2 = z ? view.getMeasuredHeight() : view.getHeight();
        int i = this.mGravity;
        if (i == 16) {
            return this.dnL.top + ((((measuredHeight - this.dnL.bottom) - this.dnL.top) - measuredHeight2) / 2);
        } else if (i == 48) {
            return this.dnL.top;
        } else {
            if (i != 80) {
                return 0;
            }
            return (measuredHeight - this.dnL.bottom) - measuredHeight2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void onCancel() {
        acC();
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (this.dpg) {
            return true;
        }
        this.dox.stop(false);
        auh();
        this.dov = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (this.dov >= 0) {
            this.dow = getChildAt(this.dov - this.dnS);
            if (this.dph) {
                this.dow.setPressed(true);
            }
        } else {
            aun();
        }
        this.doG = true;
        this.doT = true;
        this.doJ = false;
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.doV || this.aex == 2) {
            return true;
        }
        if (!this.doB) {
            removeCallbacks(this.doy);
            if (!this.doD) {
                this.doD = true;
            }
        }
        this.dox.mo30881pU((int) (-f));
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z && this.doA != null) {
            this.doA.requestFocus(i);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.doN;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 66) {
            switch (i) {
                case 21:
                    if (aup()) {
                        playSoundEffect(1);
                    }
                    return true;
                case 22:
                    if (moveNext()) {
                        playSoundEffect(3);
                    }
                    return true;
                case 23:
                    break;
            }
        }
        this.doE = true;
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 23 && i != 66) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.doE && this.aaE > 0) {
            m20468cN(this.doA);
            postDelayed(new Runnable() {
                public void run() {
                    VePIPGallery.this.auo();
                }
            }, (long) ViewConfiguration.getPressedStateDuration());
            performItemClick(getChildAt(this.dof - this.dnS), this.dof, this.f3520SZ.getItemId(this.dof));
        }
        this.doE = false;
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.dpm) {
            this.mInLayout = true;
            mo30713ae(0, false);
            this.mInLayout = false;
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.dov >= 0) {
            performHapticFeedback(0);
            m20462a(this.dow, this.dov, getItemIdAtPosition(this.dov));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        if (this.doH && !this.doI && this.doK > 0) {
            this.doL = (measuredWidth / this.doK) / 2;
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.doV || this.aex == 2 || aur()) {
            return true;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.doB) {
            if (this.doG) {
                if (!this.doD) {
                    this.doD = true;
                }
                postDelayed(this.doy, 250);
            }
        } else if (this.doD) {
            this.doD = false;
        }
        mo30788ag(((int) f) * -1, true);
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this instanceof VeGallery2) {
            if (this.doX != null && (this.doX instanceof C6994a)) {
                ((C6994a) this.doX).mo27504x(motionEvent);
            } else if (this.dpa == null) {
                return mo30874x(motionEvent);
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("onTouchEvent e:");
        sb.append(motionEvent);
        LogUtils.m14223i("VePIPGallery", sb.toString());
        PointF pointF = new PointF();
        PointF pointF2 = new PointF();
        if (this.dpg && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            return true;
        }
        boolean z = false;
        if (this.dpe) {
            if (!this.dpf && this.aML.onTouchEvent(motionEvent)) {
                z = true;
            }
            int action = motionEvent.getAction() & 255;
            if (!z && motionEvent.getPointerCount() == 1 && action == 2 && this.doX != null) {
                this.doX.mo27505y(motionEvent);
            }
            if (action == 3 || action == 1) {
                acC();
            }
            return true;
        }
        boolean onTouchEvent = this.aex != 2 ? this.aML.onTouchEvent(motionEvent) : false;
        int action2 = motionEvent.getAction() & 255;
        if (action2 == 0) {
            this.dpd = false;
            pointF.set(motionEvent.getX(), motionEvent.getY());
            this.aex = 1;
        } else {
            if (action2 != 5 || !this.dpn) {
                if (action2 == 2) {
                    if (this.aex == 2) {
                        if (motionEvent.getPointerCount() >= 2) {
                            float L = m20460L(motionEvent);
                            if (this.doZ != null) {
                                this.doZ.mo30888aA(L);
                            }
                        }
                    }
                } else if (action2 == 1 || action2 == 6) {
                    if (action2 == 1) {
                        acC();
                    }
                    if (action2 == 6 && this.dpn && this.aex == 2 && this.doZ != null) {
                        this.doZ.aut();
                        onTouchEvent = true;
                    }
                    if (action2 == 1) {
                        this.aex = 0;
                    }
                } else if (action2 == 3) {
                    onCancel();
                    this.aex = 0;
                }
            } else if (!this.doJ) {
                float L2 = m20460L(motionEvent);
                m20461a(pointF2, motionEvent);
                this.aex = 2;
                aun();
                if (this.doZ != null) {
                    this.doZ.mo30890az(L2);
                }
            }
            onTouchEvent = true;
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    /* renamed from: pQ */
    public void mo30789pQ(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onGalleryMoved moveDistance=");
        sb.append(i);
        LogUtils.m14223i("VePIPGallery", sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: pR */
    public void mo30846pR(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetLeftAndRight(i);
        }
    }

    /* renamed from: pT */
    public int mo30847pT(int i) {
        if (this.doV) {
            return 0;
        }
        return mo30788ag(i, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public int mo30790r(boolean z, int i) {
        int i2 = 0;
        View childAt = getChildAt((z ? this.aaE - 1 : 0) - this.dnS);
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int centerOfGallery = this.doI ? getCenterOfGallery() : 0;
        if (childAt != null) {
            int cM = this.doI ? m20467cM(childAt) : 0;
            if (z) {
                if (this.doI) {
                    if (this.doH) {
                        if (cM <= centerOfGallery) {
                            return 0;
                        }
                    } else if (childAt.getRight() <= this.doS + centerOfGallery) {
                        return 0;
                    }
                } else if (childAt.getRight() <= width) {
                    return 0;
                }
            } else if (this.doI) {
                if (this.doH) {
                    if (cM >= centerOfGallery) {
                        return 0;
                    }
                } else if (childAt.getLeft() >= this.doR + centerOfGallery) {
                    return 0;
                }
            } else if (childAt.getLeft() >= paddingLeft) {
                return 0;
            }
            if (this.doI) {
                int i3 = this.doH ? centerOfGallery - cM : z ? (centerOfGallery - childAt.getRight()) + this.doS : (centerOfGallery - childAt.getLeft()) + this.doR;
                return z ? Math.max(i3, i) : Math.min(i3, i);
            }
            return z ? Math.max(width - childAt.getRight(), i) : Math.min(paddingLeft - childAt.getLeft(), i);
        } else if (this.doI && this.doH) {
            return i;
        } else {
            if (z) {
                int lastVisiblePosition = getLastVisiblePosition();
                View childAt2 = getChildAt(lastVisiblePosition - this.dnS);
                if (lastVisiblePosition < this.aaE - 1) {
                    i2 = ((this.aaE - 1) - lastVisiblePosition) * this.doK;
                }
                int right = i2 + (childAt2.getRight() - width) + (this.doq * ((this.aaE - 1) - lastVisiblePosition));
                if (this.doI) {
                    right += width - centerOfGallery;
                }
                if (this.doH) {
                    right -= this.doK / 2;
                }
                return Math.max(-(right - this.doS), i);
            }
            int i4 = (this.dnS * this.doK) + (-getChildAt(0).getLeft()) + paddingLeft + (this.doq * this.dnS);
            if (this.doI) {
                i4 += centerOfGallery - paddingLeft;
            }
            if (this.doH) {
                i4 -= this.doK / 2;
            }
            return Math.min(i4 + this.doR, i);
        }
    }

    public void requestLayout() {
        if (!this.dnK) {
            super.requestLayout();
            this.dpm = true;
        }
    }

    public void setAnimationDuration(int i) {
        this.dor = i;
    }

    public void setCallbackDuringFling(boolean z) {
        this.doB = z;
    }

    public void setCallbackOnUnselectedItemClick(boolean z) {
        this.doC = z;
    }

    public void setChildWidth(int i) {
        this.doK = i;
    }

    public void setFillToCenter(boolean z) {
        this.dpi = z;
    }

    public final void setGravity(int i) {
        if (this.mGravity != i) {
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setInterceptTouchEvent(boolean z) {
        this.doN = z;
    }

    public void setIsLongpressEnabled(boolean z) {
        this.aML.setIsLongpressEnabled(z);
    }

    public void setLeftToCenter(boolean z) {
        this.dpj = z;
    }

    public void setLeftToCenterOffset(int i) {
        this.dpk = i;
    }

    public void setLimitMoveOffset(int i, int i2) {
        this.doR = i;
        this.doS = i2;
    }

    public void setOnDoubleTapListener(C7000c cVar) {
        this.dpa = cVar;
        if (cVar != null) {
            this.aML.setOnDoubleTapListener(this.dpo);
        } else {
            this.aML.setOnDoubleTapListener(null);
        }
    }

    public void setOnGalleryDrawListener(C7001d dVar) {
        this.doY = dVar;
    }

    public void setOnGalleryOperationListener(C7002e eVar) {
        this.doX = eVar;
    }

    public void setOnLayoutListener(C7003f fVar) {
        this.cuQ = fVar;
    }

    public void setOnPinchZoomGestureListener(C7004g gVar) {
        this.doZ = gVar;
    }

    /* access modifiers changed from: 0000 */
    public void setSelectedPositionInt(int i) {
        super.setSelectedPositionInt(i);
        auq();
    }

    public void setSelection(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > getCount() - 1) {
            i = getCount() - 1;
        }
        super.setSelection(i);
    }

    public void setSelection(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (i > getCount() - 1) {
            i = getCount() - 1;
        }
        super.setSelection(i, z);
    }

    public void setSelectionInfoOnLayout(int i, int i2) {
        this.doO = i;
        this.doP = i2;
    }

    public void setSpacing(int i) {
        this.doq = i;
    }

    public void setUnselectedAlpha(float f) {
        this.dos = f;
    }

    public void setbInDraging(boolean z) {
        this.dpf = z;
    }

    public void setbInEditMode(boolean z) {
        this.dpe = z;
    }

    public void setmGalleryCenterPosition(int i) {
        this.doQ = i;
    }

    public void setmLeftLimitMoveOffset(int i) {
        this.doR = i;
    }

    public void setmRightLimitMoveOffset(int i) {
        this.doS = i;
    }

    public boolean showContextMenu() {
        if (!isPressed() || this.dof < 0) {
            return false;
        }
        return m20462a(getChildAt(this.dof - this.dnS), this.dof, this.dog);
    }

    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView < 0) {
            return false;
        }
        return m20462a(view, positionForView, this.f3520SZ.getItemId(positionForView));
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public boolean mo30874x(MotionEvent motionEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("onSingleTap e:");
        sb.append(motionEvent.getX());
        LogUtils.m14223i("VePIPGallery", sb.toString());
        if (this.dov < 0) {
            return false;
        }
        if (this.doM) {
            m20469pS(this.dov - this.dnS);
        }
        if (this.doC || this.dov == this.dof) {
            performItemClick(this.dow, this.dov, this.f3520SZ.getItemId(this.dov));
        }
        return true;
    }
}
