package com.introvd.template.sdk.p386e;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.sdk.utils.C8500b;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.VeMSize;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.introvd.template.sdk.e.a */
public abstract class C8411a {
    protected GestureDetector aML;
    protected C8415b bUr;
    private OnTouchListener bWl = new OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return C8411a.this.mo25871o(motionEvent);
        }
    };
    protected View cBo = null;
    protected ScaleGestureDetector cBp;
    protected volatile boolean cBq = false;
    protected boolean cBr = false;
    private final OnScaleGestureListener cBv = new SimpleOnScaleGestureListener() {
        private float efe;

        /* renamed from: d */
        private int m24291d(VeMSize veMSize) {
            if (veMSize == null || veMSize.width <= 0 || veMSize.height <= 0) {
                return 0;
            }
            int i = 160000 / veMSize.width;
            if (veMSize.width > veMSize.height) {
                i = 160000 / veMSize.height;
            }
            return i;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float currentSpan = scaleGestureDetector.getCurrentSpan();
            StringBuilder sb = new StringBuilder();
            sb.append("onScale span=");
            sb.append(currentSpan);
            C8554j.m25008i("BaseVideoRegionController", sb.toString());
            if (C8411a.this.efb >= 0 && C8411a.this.efb < C8411a.this.eeZ.size()) {
                float f = currentSpan / this.efe;
                C8417b bVar = (C8417b) C8411a.this.eeZ.get(C8411a.this.efb);
                Rect aIJ = bVar.aIJ();
                if (C8411a.this.m24278a(aIJ, f, bVar.aIM(), m24291d(bVar.aIL())) && C8411a.this.bUr != null) {
                    C8411a.this.bUr.mo25990b(C8411a.this.efb, aIJ);
                }
                this.efe = currentSpan;
            }
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.efe = scaleGestureDetector.getCurrentSpan();
            StringBuilder sb = new StringBuilder();
            sb.append("onScaleBegin lastSpan=");
            sb.append(this.efe);
            C8554j.m25008i("BaseVideoRegionController", sb.toString());
            return true;
        }
    };
    protected ArrayList<C8417b> eeZ;
    protected VeMSize efa = null;
    protected int efb = -1;
    protected int efc;
    protected Context mContext;

    /* renamed from: com.introvd.template.sdk.e.a$a */
    private class C8414a extends SimpleOnGestureListener {
        private C8414a() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return C8411a.this.mo25873r(motionEvent);
        }

        public void onLongPress(MotionEvent motionEvent) {
            C8411a.this.mo25870WN();
            super.onLongPress(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return C8411a.this.mo25872q(f, f2);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            C8554j.m25008i("BaseVideoRegionController", "MyOnGestureListener onSingleTapConfirmed");
            return super.onSingleTapConfirmed(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (C8411a.this.mo25869WM()) {
                return true;
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* renamed from: com.introvd.template.sdk.e.a$b */
    public interface C8415b {
        /* renamed from: a */
        void mo25989a(int i, Rect rect);

        int anK();

        /* renamed from: b */
        void mo25990b(int i, Rect rect);

        /* renamed from: cF */
        int mo29538cF(int i, int i2);

        /* renamed from: d */
        void mo29539d(Point point);

        /* renamed from: e */
        int mo29540e(Point point);

        /* renamed from: f */
        int mo29541f(Point point);

        /* renamed from: nR */
        boolean mo29542nR(int i);
    }

    /* renamed from: com.introvd.template.sdk.e.a$c */
    public static class C8416c implements C8415b {
        /* renamed from: a */
        public void mo25989a(int i, Rect rect) {
        }

        public int anK() {
            return 0;
        }

        /* renamed from: b */
        public void mo25990b(int i, Rect rect) {
        }

        /* renamed from: cF */
        public int mo29538cF(int i, int i2) {
            return 0;
        }

        /* renamed from: d */
        public void mo29539d(Point point) {
        }

        /* renamed from: e */
        public int mo29540e(Point point) {
            return 0;
        }

        /* renamed from: f */
        public int mo29541f(Point point) {
            return 0;
        }

        /* renamed from: nR */
        public boolean mo29542nR(int i) {
            return false;
        }
    }

    public C8411a(View view) {
        this.cBo = view;
        this.cBo.setOnTouchListener(this.bWl);
        this.mContext = view.getContext();
        this.aML = new GestureDetector(this.mContext, new C8414a());
        this.cBp = new ScaleGestureDetector(this.mContext, this.cBv);
    }

    /* renamed from: a */
    public static int m24277a(float f, boolean z, VeMSize veMSize, Rect rect) {
        if (veMSize == null || rect == null) {
            return ((int) f) * 3;
        }
        int i = veMSize.width;
        int i2 = veMSize.height;
        return (i <= 0 || i2 <= 0) ? ((int) f) * 3 : z ? (int) ((((float) rect.height()) * f) / ((float) i2)) : (int) ((((float) rect.width()) * f) / ((float) i));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m24278a(Rect rect, float f, Rect rect2, int i) {
        if (rect == null || rect2 == null || f <= 0.0f) {
            return false;
        }
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int width = rect.width();
        int height = rect.height();
        Rect rect3 = new Rect();
        float f2 = ((float) width) / f;
        float f3 = ((float) height) / f;
        if (f2 > ((float) rect2.width()) || f3 > ((float) rect2.height())) {
            f2 = (float) rect2.width();
            f3 = (float) rect2.height();
        }
        rect3.left = (int) (((float) centerX) - (f2 / 2.0f));
        rect3.right = (int) (((float) rect3.left) + f2);
        rect3.top = (int) (((float) centerY) - (f3 / 2.0f));
        rect3.bottom = (int) (((float) rect3.top) + f3);
        if (rect3.left < 0) {
            rect3.left += -rect3.left;
            rect3.right += -rect3.left;
        } else if (rect3.right > 10000) {
            rect3.left += 10000 - rect3.right;
            rect3.right += 10000 - rect3.right;
        }
        if (rect3.top < 0) {
            rect3.top += -rect3.top;
            rect3.bottom += -rect3.top;
        } else if (rect3.bottom > 10000) {
            rect3.top += 10000 - rect3.bottom;
            rect3.bottom += 10000 - rect3.bottom;
        }
        if (f >= 1.0f && (rect3.width() < i || rect3.height() < i)) {
            return false;
        }
        rect.set(rect3);
        return true;
    }

    /* renamed from: a */
    public static boolean m24279a(Rect rect, int i, int i2) {
        boolean z = false;
        if (rect == null) {
            return false;
        }
        if ((i2 > 0 && rect.bottom < 10000) || (i2 < 0 && rect.top > 0)) {
            rect.top += i2;
            rect.bottom += i2;
            if (rect.top < 0) {
                int i3 = -rect.top;
                rect.top += i3;
                rect.bottom += i3;
            }
            if (rect.bottom > 10000) {
                int i4 = 10000 - rect.bottom;
                rect.top += i4;
                rect.bottom += i4;
            }
            z = true;
        } else if (rect.top < 0) {
            int i5 = -rect.top;
            rect.top += i5;
            rect.bottom += i5;
        } else if (rect.bottom > 10000) {
            int i6 = 10000 - rect.bottom;
            rect.top += i6;
            rect.bottom += i6;
        }
        if ((i > 0 && rect.right < 10000) || (i < 0 && rect.left > 0)) {
            rect.left += i;
            rect.right += i;
            if (rect.left < 0) {
                int i7 = -rect.left;
                rect.left += i7;
                rect.right += i7;
            }
            if (rect.right > 10000) {
                int i8 = 10000 - rect.right;
                rect.left += i8;
                rect.right += i8;
            }
            return true;
        } else if (rect.left < 0) {
            int i9 = -rect.left;
            rect.left += i9;
            rect.right += i9;
            return z;
        } else if (rect.right <= 10000) {
            return z;
        } else {
            int i10 = 10000 - rect.right;
            rect.left += i10;
            rect.right += i10;
            return z;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: WM */
    public abstract boolean mo25869WM();

    /* access modifiers changed from: protected */
    /* renamed from: WN */
    public abstract void mo25870WN();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Point mo34108a(MotionEvent motionEvent, VeMSize veMSize) {
        if (veMSize == null) {
            return null;
        }
        return new Point((((int) motionEvent.getX()) * 10000) / veMSize.width, (((int) motionEvent.getY()) * 10000) / veMSize.height);
    }

    /* renamed from: a */
    public void mo34109a(C8415b bVar) {
        this.bUr = bVar;
    }

    public boolean aIG() {
        if (this.eeZ == null) {
            return false;
        }
        Iterator it = this.eeZ.iterator();
        while (it.hasNext()) {
            if (!((C8417b) it.next()).aIN()) {
                return false;
            }
        }
        return true;
    }

    public boolean aIH() {
        if (this.eeZ != null) {
            Iterator it = this.eeZ.iterator();
            while (it.hasNext()) {
                if (((C8417b) it.next()).aIN()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public void mo34112c(VeMSize veMSize) {
        this.efa = veMSize;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public abstract boolean mo25871o(MotionEvent motionEvent);

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public abstract boolean mo25872q(float f, float f2);

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public abstract boolean mo25873r(MotionEvent motionEvent);

    public void refreshView() {
        if (this.cBo != null) {
            VeMSize veMSize = this.efa;
            RelativeLayout relativeLayout = (RelativeLayout) this.cBo;
            for (int childCount = relativeLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = relativeLayout.getChildAt(childCount);
                if (childAt instanceof ImageView) {
                    relativeLayout.removeView(childAt);
                }
            }
            if (this.eeZ != null) {
                int size = this.eeZ.size();
                for (int i = 0; i < size; i++) {
                    C8417b bVar = (C8417b) this.eeZ.get(i);
                    if (bVar != null && !bVar.aIN()) {
                        Rect aII = bVar.aII();
                        VeMSize aIK = bVar.aIK();
                        Point aIO = bVar.aIO();
                        if (!(aII == null || aIK == null || aIO == null || this.efc <= 0)) {
                            int i2 = (aII.left * veMSize.width) / 10000;
                            int i3 = (aII.top * veMSize.height) / 10000;
                            int i4 = (aIK.width * aIO.x) / 10000;
                            int i5 = (aIK.height * aIO.y) / 10000;
                            ImageView imageView = new ImageView(this.mContext);
                            imageView.setImageResource(this.efc);
                            int P = C8500b.m24591P(37.0f);
                            LayoutParams layoutParams = new LayoutParams(P, P);
                            int i6 = P / 2;
                            int i7 = (i2 + i4) - i6;
                            if (VERSION.SDK_INT >= 17) {
                                layoutParams.setMarginStart(i7);
                            } else {
                                layoutParams.leftMargin = i7;
                            }
                            int i8 = (i3 + i5) - i6;
                            layoutParams.topMargin = i8;
                            StringBuilder sb = new StringBuilder();
                            sb.append("refreshView x=");
                            sb.append(i7);
                            sb.append(";marginY=");
                            sb.append(i8);
                            C8554j.m25008i("BaseVideoRegionController", sb.toString());
                            relativeLayout.addView(imageView, layoutParams);
                        }
                    }
                }
                relativeLayout.invalidate();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("refreshView count=");
                sb2.append(relativeLayout.getChildCount());
                C8554j.m25008i("BaseVideoRegionController", sb2.toString());
            }
        }
    }

    /* renamed from: s */
    public void mo34114s(ArrayList<C8417b> arrayList) {
        if (arrayList != null) {
            this.eeZ = arrayList;
        }
    }

    /* renamed from: ui */
    public void mo34115ui(int i) {
        this.efc = i;
    }
}
