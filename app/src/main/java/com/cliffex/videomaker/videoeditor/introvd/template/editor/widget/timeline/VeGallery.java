package com.introvd.template.editor.widget.timeline;

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
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.Scroller;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.widget.timeline.VeAdapterView.C7086a;
import java.lang.reflect.Field;

@SuppressLint({"WrongCall"})
public class VeGallery extends VeAbsSpinner implements OnGestureListener {
    private final GestureDetector aML;
    protected int aex;
    private View doA;
    private boolean doB;
    private boolean doC;
    /* access modifiers changed from: private */
    public boolean doD;
    private boolean doE;
    private boolean doG;
    private boolean doH;
    private boolean doI;
    private boolean doJ;
    protected int doK;
    protected int doL;
    protected boolean doM;
    protected boolean doN;
    protected int doO;
    protected int doP;
    protected int doR;
    protected int doS;
    protected boolean doT;
    protected boolean doU;
    private boolean doV;
    private boolean doW;
    private int doq;
    /* access modifiers changed from: private */
    public int dor;
    private float dos;
    private int dot;
    private int dou;
    /* access modifiers changed from: private */
    public int dov;
    private View dow;
    private final Runnable doy;
    /* access modifiers changed from: private */
    public boolean doz;
    private boolean dpc;
    private boolean dpd;
    /* access modifiers changed from: private */
    public boolean dpg;
    private boolean dph;
    private boolean dpi;
    private boolean dpj;
    private int dpk;
    protected boolean dpl;
    protected boolean dpm;
    protected boolean dpn;
    private final OnDoubleTapListener dpo;
    private final C7097a dxn;
    private C7086a dxo;
    protected C7101e dxp;
    protected OnTouchListener dxq;
    private C7100d dxr;
    private C7103g dxs;
    private C7102f dxt;
    private C7099c dxu;
    private final C7098b dxv;
    private C7104h dxw;
    private int dxx;
    private int dxy;
    private MotionEvent mCurrentDownEvent;
    private int mGravity;
    private int mTouchSlopSquare;

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

    /* renamed from: com.introvd.template.editor.widget.timeline.VeGallery$a */
    private class C7097a implements Runnable {
        private int aaQ;
        private boolean dpq = false;
        /* access modifiers changed from: private */
        public final Scroller mScroller;

        public C7097a() {
            this.mScroller = new Scroller(VeGallery.this.getContext());
        }

        private void aus() {
            VeGallery.this.removeCallbacks(this);
        }

        /* access modifiers changed from: private */
        /* renamed from: hB */
        public void m20893hB(boolean z) {
            this.dpq = false;
            VeGallery.this.dpg = false;
            this.mScroller.forceFinished(true);
            if (z) {
                VeGallery.this.aug();
            }
        }

        /* renamed from: pU */
        public void mo31407pU(int i) {
            if (i != 0) {
                aus();
                int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                this.aaQ = i2;
                this.mScroller.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                VeGallery.this.post(this);
            }
        }

        /* renamed from: pV */
        public void mo31408pV(int i) {
            if (i != 0) {
                aus();
                this.aaQ = 0;
                this.mScroller.startScroll(0, 0, -i, 0, VeGallery.this.dor);
                VeGallery.this.post(this);
            }
        }

        public void run() {
            int i;
            if (VeGallery.this.aaE == 0) {
                m20893hB(true);
                return;
            }
            VeGallery.this.doz = false;
            Scroller scroller = this.mScroller;
            boolean computeScrollOffset = scroller.computeScrollOffset();
            int currX = scroller.getCurrX();
            this.dpq = computeScrollOffset;
            int i2 = this.aaQ - currX;
            if (i2 > 0) {
                VeGallery.this.dov = VeGallery.this.dnS;
                i = Math.min(((VeGallery.this.getWidth() - VeGallery.this.getPaddingLeft()) - VeGallery.this.getPaddingRight()) - 1, i2);
            } else {
                VeGallery.this.dov = VeGallery.this.dnS + (VeGallery.this.getChildCount() - 1);
                i = Math.max(-(((VeGallery.this.getWidth() - VeGallery.this.getPaddingRight()) - VeGallery.this.getPaddingLeft()) - 1), i2);
            }
            VeGallery.this.mo31327ag(i, true);
            if (!computeScrollOffset || VeGallery.this.doz) {
                m20893hB(true);
            } else {
                this.aaQ = currX;
                VeGallery.this.post(this);
            }
        }

        public void stop(boolean z) {
            VeGallery.this.removeCallbacks(this);
            m20893hB(z);
        }
    }

    /* renamed from: com.introvd.template.editor.widget.timeline.VeGallery$b */
    private class C7098b implements Runnable {
        private boolean dpr = false;
        private boolean dps = false;

        public C7098b() {
        }

        public void run() {
            int i = VeGallery.this.doK;
            int pT = this.dpr ? VeGallery.this.mo31376pT(-i) : VeGallery.this.mo31376pT(i);
            if (this.dps) {
                VeGallery.this.mo31328ah(pT, true);
                stop();
            }
        }

        public void stop() {
            if (this.dps) {
                this.dps = false;
                VeGallery.this.removeCallbacks(this);
            }
        }
    }

    /* renamed from: com.introvd.template.editor.widget.timeline.VeGallery$c */
    public interface C7099c {
        /* renamed from: a */
        boolean mo31413a(VeAdapterView<?> veAdapterView, View view, int i);
    }

    /* renamed from: com.introvd.template.editor.widget.timeline.VeGallery$d */
    public interface C7100d {
        void onDraw(Canvas canvas);
    }

    /* renamed from: com.introvd.template.editor.widget.timeline.VeGallery$e */
    public interface C7101e {
        void acC();

        void afq();

        void agw();

        /* renamed from: b */
        void mo28167b(View view, int i, int i2, int i3);

        /* renamed from: cu */
        void mo28168cu(View view);

        /* renamed from: cv */
        void mo28169cv(View view);

        /* renamed from: y */
        void mo28170y(View view, int i);
    }

    /* renamed from: com.introvd.template.editor.widget.timeline.VeGallery$f */
    public interface C7102f {
        /* renamed from: cw */
        void mo28150cw(View view);
    }

    /* renamed from: com.introvd.template.editor.widget.timeline.VeGallery$g */
    public interface C7103g {
        /* renamed from: aA */
        void mo31415aA(float f);

        void aut();

        /* renamed from: az */
        void mo31417az(float f);
    }

    /* renamed from: com.introvd.template.editor.widget.timeline.VeGallery$h */
    public interface C7104h {
    }

    public VeGallery(Context context) {
        this(context, null);
    }

    public VeGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842864);
    }

    public VeGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.doq = 0;
        this.dor = 400;
        this.dxn = new C7097a();
        this.doy = new Runnable() {
            public void run() {
                VeGallery.this.doD = false;
                VeGallery.this.aua();
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
        this.doR = 0;
        this.doS = 0;
        this.doT = false;
        this.doU = true;
        this.doV = false;
        this.doW = false;
        this.dxp = null;
        this.dxq = null;
        this.dxr = null;
        this.dxs = null;
        this.dxt = null;
        this.dxu = null;
        this.dxv = new C7098b();
        this.dxw = null;
        this.dpc = false;
        this.dpd = false;
        this.mTouchSlopSquare = 0;
        this.dpg = false;
        this.dph = true;
        this.dpi = false;
        this.dpj = false;
        this.dpk = 0;
        this.dpl = true;
        this.dpm = true;
        this.dpn = false;
        this.dxx = 0;
        this.dxy = -1;
        this.aex = 0;
        this.dpo = new OnDoubleTapListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                VeGallery.this.auf();
                return true;
            }

            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return false;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                VeGallery.this.mo31320x(motionEvent);
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
    private float m20855L(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    /* renamed from: a */
    private void m20857a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    /* renamed from: a */
    private boolean m20858a(View view, int i, long j) {
        boolean z;
        if (this.dwk != null) {
            z = this.dwk.mo31254b(this, this.dow, this.dov, j);
        } else {
            z = false;
        }
        if (!z) {
            this.dxo = new C7086a(view, i, j);
            z = super.showContextMenuForChild(this);
        }
        if (z) {
            performHapticFeedback(0);
        }
        return z;
    }

    /* access modifiers changed from: private */
    public boolean auf() {
        if (this.dxu == null || this.dov < 0 || this.dov != this.dxy) {
            return false;
        }
        return this.dxu.mo31413a(this, getChildAt(this.dov - this.dnS), this.dov);
    }

    /* access modifiers changed from: private */
    public void aug() {
        if (getChildCount() != 0 && this.doA != null) {
            if (!this.doH) {
                aui();
                return;
            }
            int centerOfGallery = getCenterOfGallery() - m20868cM(this.doA);
            if (centerOfGallery != 0) {
                this.dxn.mo31408pV(centerOfGallery);
            } else {
                aui();
            }
        }
    }

    private void auh() {
        if (this.dxp != null && this.doJ && !this.doT) {
            this.doJ = false;
            this.dxp.mo28168cu(this);
        }
    }

    private void aui() {
        if (this.doD) {
            this.doD = false;
            super.aua();
        }
        this.dpg = false;
        auh();
        invalidate();
    }

    private void auj() {
        View view = this.doA;
        int paddingLeft = getPaddingLeft();
        if (view == null || view.getLeft() > paddingLeft || view.getRight() < paddingLeft) {
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            int childCount = getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    break;
                }
                View childAt = getChildAt(childCount);
                if (childAt.getLeft() <= paddingLeft && childAt.getRight() >= paddingLeft) {
                    i2 = childCount;
                    break;
                }
                int min = Math.min(Math.abs(childAt.getLeft() - paddingLeft), Math.abs(childAt.getRight() - paddingLeft));
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

    private void auq() {
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

    /* renamed from: b */
    private void m20861b(View view, int i, int i2, boolean z) {
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
        int n = mo31365n(view, true);
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

    /* renamed from: c */
    private View m20865c(int i, int i2, int i3, boolean z) {
        if (!this.bXu && i != getSelectedItemPosition() && this.doh <= this.aaE) {
            View pO = this.dwg.mo31210pO(i);
            if (pO != null) {
                int left = pO.getLeft();
                this.dou = Math.max(this.dou, pO.getMeasuredWidth() + left);
                this.dot = Math.min(this.dot, left);
                m20861b(pO, i2, i3, z);
                return pO;
            }
        }
        View view = this.f3534SZ.getView(i, null, this);
        m20861b(view, i2, i3, z);
        return view;
    }

    /* renamed from: c */
    private boolean m20866c(MotionEvent motionEvent, int i) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if ((i == 1 || i == 3) && this.dxp != null) {
            this.dxp.acC();
        }
        return dispatchTouchEvent;
    }

    /* renamed from: cM */
    public static int m20868cM(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    /* renamed from: cN */
    private void m20869cN(View view) {
        if (this.dph) {
            if (view != null) {
                view.setPressed(true);
            }
            setPressed(true);
        }
    }

    private int getLeftPaddingValue() {
        if (this instanceof VeAdvanceTrimGallery) {
            int width = getWidth();
            int childWidth = getChildWidth();
            int count = getCount();
            if (width > 0 && count > 0 && childWidth > 0) {
                int i = count * childWidth;
                if (i < width) {
                    mo31359hU(true);
                    return (width - i) / 2;
                }
            }
        }
        mo31359hU(false);
        return 0;
    }

    /* renamed from: pR */
    private void m20872pR(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetLeftAndRight(i);
        }
    }

    /* renamed from: pS */
    private boolean m20873pS(int i) {
        View childAt = getChildAt(i);
        if (childAt == null) {
            return false;
        }
        this.dxn.mo31408pV(getCenterOfGallery() - m20868cM(childAt));
        return true;
    }

    /* renamed from: aM */
    public int mo31325aM(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public void acC() {
        this.doT = false;
        if (this.dxn.mScroller.isFinished()) {
            aug();
        }
        auo();
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"WrongCall"})
    /* renamed from: ae */
    public void mo31183ae(int i, boolean z) {
        int leftPaddingValue = this.dnL.left + getLeftPaddingValue();
        int right = ((getRight() - getLeft()) - this.dnL.left) - this.dnL.right;
        int count = getCount();
        if (this.bXu) {
            handleDataChanged();
        }
        if (this.aaE == 0) {
            atX();
            this.dnS = 0;
            if (this.dxt != null) {
                this.dxt.mo28150cw(this);
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
        View c = m20865c(this.dof, 0, 0, true);
        if (this.doH) {
            int i2 = leftPaddingValue + (right / 2);
            if (this.doI || this.doL <= 0) {
                c.offsetLeftAndRight(i2);
            } else if (this.doL > 0) {
                if (this.dof >= this.doL && this.dof < count - this.doL && count >= (this.doL * 2) + 1) {
                    c.offsetLeftAndRight(i2);
                } else if (this.dof < this.doL || count < (this.doL * 2) + 1) {
                    c.offsetLeftAndRight((this.doK * this.dof) + getPaddingLeft());
                } else {
                    int i3 = (this.dof - (count - this.doL)) + 1;
                    if (i3 > 0) {
                        c.offsetLeftAndRight((this.doK * (this.doL + i3)) + getPaddingLeft());
                    }
                }
            }
        } else if (this.doO >= 0) {
            c.offsetLeftAndRight(leftPaddingValue + this.doP);
        } else {
            c.offsetLeftAndRight(leftPaddingValue);
        }
        if (this.dpi) {
            auk();
        } else {
            aum();
            aul();
        }
        if (!this.doW) {
            this.dwg.clear();
        }
        if (this.dxt != null) {
            this.dxt.mo28150cw(this);
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
    public int mo31327ag(int i, boolean z) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        boolean z2 = i < 0;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r = mo31377r(z2, i);
        if (r != 0) {
            if (r >= width) {
                r = width - 1;
            }
            int i2 = -width;
            if (r <= i2) {
                r = i2 + 1;
            }
            m20872pR(r);
            mo31362hw(z2);
            if (z2) {
                aum();
            } else {
                aul();
            }
            this.dwg.clear();
            if (this.doH) {
                auj();
            }
            mo31287pQ(r);
            if (this.dxp != null) {
                if (this.doG && z) {
                    this.dxp.mo28169cv(this);
                    this.doG = false;
                }
                if (z) {
                    this.doJ = true;
                }
                this.dxp.mo28170y(this, r);
            }
            invalidate();
        }
        if (r != i) {
            this.dxn.m20893hB(false);
            aui();
            if (z2) {
                aul();
            } else {
                aum();
            }
        }
        return r;
    }

    /* renamed from: ah */
    public void mo31328ah(int i, boolean z) {
        if (i != 0 && !this.dpg) {
            this.dpg = z;
            if (!this.doG) {
                this.doG = true;
            }
            this.dxn.mo31408pV(i);
        }
    }

    /* access modifiers changed from: 0000 */
    public void aua() {
        if (!this.doD) {
            super.aua();
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
                View c = m20865c(i6, i6 - this.dof, width, false);
                if (c.getLeft() != centerOfGallery) {
                    int left = centerOfGallery - c.getLeft();
                    width += left;
                    c.offsetLeftAndRight(left);
                }
                this.dnS = i6;
            }
            for (int i7 = this.dof + 1; i7 < i5; i7++) {
                m20865c(i7, i7 - this.dof, centerOfGallery, true);
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
            i2 += m20865c(i, i - this.dof, i3, true).getWidth() + i4;
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
            View c = m20865c(i, i - this.dof, i2, false);
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
            i2 = m20865c(i, i - this.dof, i2, true).getRight() + i3;
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
        m20873pS((this.dof - this.dnS) - 1);
        return true;
    }

    public boolean avN() {
        return this.doV;
    }

    /* renamed from: b */
    public void mo31335b(View view, int i, long j) {
        performItemClick(view, i, j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cK */
    public int mo31186cK(View view) {
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
        if (this.dxr != null) {
            this.dxr.onDraw(canvas);
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
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.dxp != null) {
                this.dxp.afq();
            }
            this.dxy = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
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
        return m20866c(motionEvent, action);
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
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
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
        return this.dxo;
    }

    public boolean getFillToCenter() {
        return this.dpi;
    }

    public int getLeftLimitMoveOffset() {
        return this.doR;
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

    public int getmClientFocusIndex() {
        return this.dxx;
    }

    public int getmDownTouchPosition() {
        return this.dov;
    }

    public int getmLastDownTouchPosition() {
        return this.dxy;
    }

    /* renamed from: hA */
    public void mo31358hA(boolean z) {
        this.doI = z;
    }

    /* renamed from: hU */
    public void mo31359hU(boolean z) {
        this.doV = z;
    }

    /* renamed from: hu */
    public void mo31360hu(boolean z) {
        this.dnK = z;
    }

    /* renamed from: hv */
    public void mo31361hv(boolean z) {
        this.dpm = z;
    }

    /* renamed from: hw */
    public void mo31362hw(boolean z) {
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
                this.dwg.mo31209f(i2 + i4, childAt);
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
                this.dwg.mo31209f(i2 + i6, childAt2);
                i3 = i6;
            }
        }
        detachViewsFromParent(i3, i);
        if (z) {
            this.dnS += i;
        }
    }

    /* renamed from: hy */
    public void mo31363hy(boolean z) {
        this.dpl = z;
    }

    /* access modifiers changed from: 0000 */
    public boolean moveNext() {
        if (this.aaE <= 0 || this.dof >= this.aaE - 1) {
            return false;
        }
        m20873pS((this.dof - this.dnS) + 1);
        return true;
    }

    /* renamed from: n */
    public int mo31365n(View view, boolean z) {
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
        this.dxn.stop(false);
        auh();
        this.dxy = this.dov;
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
        this.dxn.mo31407pU((int) (-f));
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
            m20869cN(this.doA);
            postDelayed(new Runnable() {
                public void run() {
                    VeGallery.this.auo();
                }
            }, (long) ViewConfiguration.getPressedStateDuration());
            performItemClick(getChildAt(this.dof - this.dnS), this.dof, this.f3534SZ.getItemId(this.dof));
        }
        this.doE = false;
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.dpm) {
            this.mInLayout = true;
            if (!isInEditMode()) {
                mo31183ae(0, false);
            }
            this.mInLayout = false;
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
        try {
            if (this.dov >= 0) {
                performHapticFeedback(0);
                m20858a(this.dow, this.dov, getItemIdAtPosition(this.dov));
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception message:");
            sb.append(e.getMessage());
            LogUtils.m14222e("VeGallery", sb.toString());
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
        if (this.doV || this.aex == 2) {
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
        mo31327ag(((int) f) * -1, true);
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.dxu == null && mo31320x(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF();
        PointF pointF2 = new PointF();
        if (this.dpg && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            return true;
        }
        boolean onTouchEvent = this.aex != 2 ? this.aML.onTouchEvent(motionEvent) : false;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.dpd = false;
            pointF.set(motionEvent.getX(), motionEvent.getY());
            this.aex = 1;
        } else {
            if (action != 5 || !this.dpn) {
                if (action == 2) {
                    if (this.aex == 2) {
                        if (motionEvent.getPointerCount() >= 2) {
                            float L = m20855L(motionEvent);
                            if (this.dxs != null) {
                                this.dxs.mo31415aA(L);
                            }
                        }
                    }
                } else if (action == 1 || action == 6) {
                    if (action == 1) {
                        acC();
                    }
                    if (action == 6 && this.dpn && this.aex == 2 && this.dxs != null) {
                        this.dxs.aut();
                        onTouchEvent = true;
                    }
                    if (action == 1) {
                        this.aex = 0;
                    }
                } else if (action == 3) {
                    onCancel();
                    this.aex = 0;
                }
            } else if (!this.doJ) {
                float L2 = m20855L(motionEvent);
                m20857a(pointF2, motionEvent);
                this.aex = 2;
                aun();
                if (this.dxs != null) {
                    this.dxs.mo31417az(L2);
                }
            }
            onTouchEvent = true;
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    /* renamed from: pQ */
    public void mo31287pQ(int i) {
    }

    /* renamed from: pT */
    public int mo31376pT(int i) {
        if (this.doV) {
            return 0;
        }
        return mo31327ag(i, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public int mo31377r(boolean z, int i) {
        int i2 = 0;
        View childAt = getChildAt((z ? this.aaE - 1 : 0) - this.dnS);
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int centerOfGallery = this.doI ? getCenterOfGallery() : 0;
        if (childAt != null) {
            int cM = this.doI ? m20868cM(childAt) : 0;
            if (z) {
                if (!this.doI) {
                    View childAt2 = getChildAt(0);
                    if (childAt2 != null && childAt2.getLeft() > paddingLeft) {
                        int left = paddingLeft - childAt2.getLeft();
                        return left < i ? left : i;
                    } else if (childAt.getRight() <= this.doS + width) {
                        return 0;
                    } else {
                        int right = (width + this.doS) - childAt.getRight();
                        return Math.abs(right) > Math.abs(i) ? i : right;
                    }
                } else if (this.doH) {
                    if (cM <= centerOfGallery) {
                        return 0;
                    }
                } else if (childAt.getRight() <= this.doS + centerOfGallery) {
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
            } else if (isInEditMode()) {
                if (childAt.getLeft() >= paddingLeft) {
                    return 0;
                }
            } else if (childAt.getLeft() > this.doR + paddingLeft) {
                return (paddingLeft + this.doR) - childAt.getLeft();
            } else {
                if (childAt.getLeft() == paddingLeft + this.doR) {
                    return 0;
                }
                return i;
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
                View childAt3 = getChildAt(lastVisiblePosition - this.dnS);
                if (lastVisiblePosition < this.aaE - 1) {
                    i2 = ((this.aaE - 1) - lastVisiblePosition) * this.doK;
                }
                int right2 = i2 + (childAt3.getRight() - width) + (this.doq * ((this.aaE - 1) - lastVisiblePosition));
                if (this.doI) {
                    right2 += centerOfGallery - paddingLeft;
                }
                if (this.doH) {
                    right2 -= this.doK / 2;
                }
                return Math.max(-(right2 - this.doS), i);
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
            mo31361hv(true);
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

    public void setOnDoubleTapListener(C7099c cVar) {
        this.dxu = cVar;
        if (cVar != null) {
            this.aML.setOnDoubleTapListener(this.dpo);
        } else {
            this.aML.setOnDoubleTapListener(null);
        }
    }

    public void setOnGalleryDrawListener(C7100d dVar) {
        this.dxr = dVar;
    }

    public void setOnGalleryOperationListener(C7101e eVar) {
        this.dxp = eVar;
    }

    public void setOnLayoutListener(C7102f fVar) {
        this.dxt = fVar;
    }

    public void setOnPinchZoomGestureListener(C7103g gVar) {
        this.dxs = gVar;
    }

    public void setOnPrepareChildListener(C7104h hVar) {
        this.dxw = hVar;
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

    public void setmClientFocusIndex(int i) {
        this.dxx = i;
    }

    public void setmOnGalleryChildTouchedListener(OnTouchListener onTouchListener) {
        this.dxq = onTouchListener;
    }

    public boolean showContextMenu() {
        if (!isPressed() || this.dof < 0) {
            return false;
        }
        return m20858a(getChildAt(this.dof - this.dnS), this.dof, this.dog);
    }

    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView < 0) {
            return false;
        }
        return m20858a(view, positionForView, this.f3534SZ.getItemId(positionForView));
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public boolean mo31320x(MotionEvent motionEvent) {
        if (this.dov < 0) {
            return false;
        }
        if (this.doM) {
            m20873pS(this.dov - this.dnS);
        }
        if (this.doC || this.dov == this.dof) {
            performItemClick(this.dow, this.dov, this.f3534SZ.getItemId(this.dov));
        }
        return true;
    }
}
