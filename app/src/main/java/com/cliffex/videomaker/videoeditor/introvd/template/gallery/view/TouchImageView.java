package com.introvd.template.gallery.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.introvd.template.gallery.view.p315a.C7508a;
import com.introvd.template.gallery.view.p315a.C7510b;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

@SuppressLint({"AppCompatCustomView"})
public class TouchImageView extends ImageView {
    /* access modifiers changed from: private */
    public GestureDetector aML;
    private ScaleType aNd;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public float dJP;
    private Matrix dJQ;
    /* access modifiers changed from: private */
    public C7504i dJR;
    /* access modifiers changed from: private */
    public float dJS;
    /* access modifiers changed from: private */
    public float dJT;
    private float dJU;
    private float dJV;
    /* access modifiers changed from: private */
    public float[] dJW;
    /* access modifiers changed from: private */
    public C7499d dJX;
    private Paint dJY;
    private boolean dJZ;
    private boolean dKa;
    /* access modifiers changed from: private */
    public boolean dKb = false;
    private boolean dKc = false;
    private Rect dKd;
    private C7505j dKe;
    /* access modifiers changed from: private */
    public int dKf;
    /* access modifiers changed from: private */
    public int dKg;
    private int dKh;
    private int dKi;
    private float dKj;
    private float dKk;
    private float dKl;
    private float dKm;
    /* access modifiers changed from: private */
    public ScaleGestureDetector dKn;
    /* access modifiers changed from: private */
    public OnDoubleTapListener dKo = null;
    /* access modifiers changed from: private */
    public OnTouchListener dKp = null;
    /* access modifiers changed from: private */
    public C7501f dKq = null;
    private C1495b dKr;
    /* access modifiers changed from: private */
    public C1838m<C7497b> dKs;
    private Paint dlZ;
    /* access modifiers changed from: private */
    public Bitmap mBitmap = null;
    private float mRotation = 0.0f;
    /* access modifiers changed from: private */
    public Matrix matrix;

    /* renamed from: com.introvd.template.gallery.view.TouchImageView$4 */
    static /* synthetic */ class C74954 {

        /* renamed from: Cb */
        static final /* synthetic */ int[] f3552Cb = new int[ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3552Cb = r0
                int[] r0 = f3552Cb     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3552Cb     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3552Cb     // Catch:{ NoSuchFieldError -> 0x002a }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f3552Cb     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f3552Cb     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.gallery.view.TouchImageView.C74954.<clinit>():void");
        }
    }

    @TargetApi(9)
    /* renamed from: com.introvd.template.gallery.view.TouchImageView$a */
    private class C7496a {
        Scroller dKv;
        OverScroller dKw;
        boolean dKx = false;

        public C7496a(Context context) {
            this.dKw = new OverScroller(context);
        }

        public boolean computeScrollOffset() {
            if (this.dKx) {
                return this.dKv.computeScrollOffset();
            }
            this.dKw.computeScrollOffset();
            return this.dKw.computeScrollOffset();
        }

        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.dKx) {
                this.dKv.fling(i, i2, i3, i4, i5, i6, i7, i8);
            } else {
                this.dKw.fling(i, i2, i3, i4, i5, i6, i7, i8);
            }
        }

        public void forceFinished(boolean z) {
            if (this.dKx) {
                this.dKv.forceFinished(z);
            } else {
                this.dKw.forceFinished(z);
            }
        }

        public int getCurrX() {
            return this.dKx ? this.dKv.getCurrX() : this.dKw.getCurrX();
        }

        public int getCurrY() {
            return this.dKx ? this.dKv.getCurrY() : this.dKw.getCurrY();
        }

        public boolean isFinished() {
            return this.dKx ? this.dKv.isFinished() : this.dKw.isFinished();
        }
    }

    /* renamed from: com.introvd.template.gallery.view.TouchImageView$b */
    private class C7497b {
        public Bitmap dKy;
        public float dKz;

        public C7497b(Bitmap bitmap, float f) {
            this.dKy = bitmap;
            this.dKz = f;
        }
    }

    /* renamed from: com.introvd.template.gallery.view.TouchImageView$c */
    private class C7498c implements Runnable {
        private float dKA;
        private float dKB;
        private float dKC;
        private float dKD;
        private boolean dKE;
        private AccelerateDecelerateInterpolator dKF = new AccelerateDecelerateInterpolator();
        private PointF dKG;
        private PointF dKH;
        private long startTime;

        C7498c(float f, float f2, float f3, boolean z) {
            TouchImageView.this.setState(C7504i.ANIMATE_ZOOM);
            this.startTime = System.currentTimeMillis();
            this.dKA = TouchImageView.this.dJP;
            this.dKB = f;
            this.dKE = z;
            PointF a = TouchImageView.this.m22187c(f2, f3, false);
            this.dKC = a.x;
            this.dKD = a.y;
            this.dKG = TouchImageView.this.m22170N(this.dKC, this.dKD);
            this.dKH = new PointF((float) (TouchImageView.this.dKf / 2), (float) (TouchImageView.this.dKg / 2));
        }

        /* renamed from: Ag */
        private float m22217Ag() {
            return this.dKF.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.startTime)) / 500.0f));
        }

        /* renamed from: aM */
        private void m22218aM(float f) {
            float f2 = this.dKG.x + ((this.dKH.x - this.dKG.x) * f);
            float f3 = this.dKG.y + (f * (this.dKH.y - this.dKG.y));
            PointF a = TouchImageView.this.m22170N(this.dKC, this.dKD);
            TouchImageView.this.matrix.postTranslate(f2 - a.x, f3 - a.y);
        }

        /* renamed from: aN */
        private double m22219aN(float f) {
            return ((double) (this.dKA + (f * (this.dKB - this.dKA)))) / ((double) TouchImageView.this.dJP);
        }

        public void run() {
            float Ag = m22217Ag();
            TouchImageView.this.m22178a(m22219aN(Ag), this.dKC, this.dKD, this.dKE);
            m22218aM(Ag);
            TouchImageView.this.azC();
            TouchImageView.this.setImageMatrix(TouchImageView.this.matrix);
            if (TouchImageView.this.dKq != null) {
                TouchImageView.this.dKq.azH();
            }
            if (Ag < 1.0f) {
                TouchImageView.this.m22199k((Runnable) this);
            } else {
                TouchImageView.this.setState(C7504i.NONE);
            }
        }
    }

    /* renamed from: com.introvd.template.gallery.view.TouchImageView$d */
    private class C7499d implements Runnable {
        C7496a dKI;
        int dKJ;
        int dKK;

        C7499d(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            TouchImageView.this.setState(C7504i.FLING);
            this.dKI = new C7496a(TouchImageView.this.context);
            TouchImageView.this.matrix.getValues(TouchImageView.this.dJW);
            int i7 = (int) TouchImageView.this.dJW[2];
            int i8 = (int) TouchImageView.this.dJW[5];
            if (TouchImageView.this.getImageWidth() > ((float) TouchImageView.this.dKf)) {
                i4 = TouchImageView.this.dKf - ((int) TouchImageView.this.getImageWidth());
                i3 = 0;
            } else {
                i4 = i7;
                i3 = i4;
            }
            if (TouchImageView.this.dKb) {
                i6 = (int) (C7508a.BOTTOM.atF() - TouchImageView.this.getImageHeight());
                i5 = (int) C7508a.TOP.atF();
            } else if (TouchImageView.this.getImageHeight() > ((float) TouchImageView.this.dKg)) {
                i6 = TouchImageView.this.dKg - ((int) TouchImageView.this.getImageHeight());
                i5 = 0;
            } else {
                i6 = i8;
                i5 = i6;
            }
            this.dKI.fling(i7, i8, i, i2, i4, i3, i6, i5);
            this.dKJ = i7;
            this.dKK = i8;
        }

        /* renamed from: Ad */
        public void mo32279Ad() {
            if (this.dKI != null) {
                TouchImageView.this.setState(C7504i.NONE);
                this.dKI.forceFinished(true);
            }
        }

        public void run() {
            if (TouchImageView.this.dKq != null) {
                TouchImageView.this.dKq.azH();
            }
            if (this.dKI.isFinished()) {
                this.dKI = null;
                return;
            }
            if (this.dKI.computeScrollOffset()) {
                int currX = this.dKI.getCurrX();
                int currY = this.dKI.getCurrY();
                int i = currX - this.dKJ;
                int i2 = currY - this.dKK;
                this.dKJ = currX;
                this.dKK = currY;
                TouchImageView.this.matrix.postTranslate((float) i, (float) i2);
                TouchImageView.this.azB();
                TouchImageView.this.setImageMatrix(TouchImageView.this.matrix);
                TouchImageView.this.m22199k((Runnable) this);
            }
        }
    }

    /* renamed from: com.introvd.template.gallery.view.TouchImageView$e */
    private class C7500e extends SimpleOnGestureListener {
        private C7500e() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean onDoubleTap = TouchImageView.this.dKo != null ? TouchImageView.this.dKo.onDoubleTap(motionEvent) : false;
            if (TouchImageView.this.dJR != C7504i.NONE) {
                return onDoubleTap;
            }
            C7498c cVar = new C7498c(TouchImageView.this.dJP == TouchImageView.this.dJS ? TouchImageView.this.dJT : TouchImageView.this.dJS, motionEvent.getX(), motionEvent.getY(), false);
            TouchImageView.this.m22199k((Runnable) cVar);
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (TouchImageView.this.dKo != null) {
                return TouchImageView.this.dKo.onDoubleTapEvent(motionEvent);
            }
            return false;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (TouchImageView.this.dJX != null) {
                TouchImageView.this.dJX.mo32279Ad();
            }
            TouchImageView.this.dJX = new C7499d((int) f, (int) f2);
            TouchImageView.this.m22199k((Runnable) TouchImageView.this.dJX);
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public void onLongPress(MotionEvent motionEvent) {
            try {
                TouchImageView.this.performLongClick();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return TouchImageView.this.dKo != null ? TouchImageView.this.dKo.onSingleTapConfirmed(motionEvent) : TouchImageView.this.performClick();
        }
    }

    /* renamed from: com.introvd.template.gallery.view.TouchImageView$f */
    public interface C7501f {
        void azH();
    }

    /* renamed from: com.introvd.template.gallery.view.TouchImageView$g */
    private class C7502g implements OnTouchListener {
        private PointF dKL;

        private C7502g() {
            this.dKL = new PointF();
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            TouchImageView.this.dKn.onTouchEvent(motionEvent);
            TouchImageView.this.aML.onTouchEvent(motionEvent);
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            if (TouchImageView.this.dJR == C7504i.NONE || TouchImageView.this.dJR == C7504i.DRAG || TouchImageView.this.dJR == C7504i.FLING) {
                int action = motionEvent.getAction();
                if (action != 6) {
                    switch (action) {
                        case 0:
                            this.dKL.set(pointF);
                            if (TouchImageView.this.dJX != null) {
                                TouchImageView.this.dJX.mo32279Ad();
                            }
                            TouchImageView.this.setState(C7504i.DRAG);
                            break;
                        case 1:
                            break;
                        case 2:
                            if (TouchImageView.this.dJR == C7504i.DRAG) {
                                float f = pointF.y - this.dKL.y;
                                TouchImageView.this.matrix.postTranslate(TouchImageView.this.m22207q(pointF.x - this.dKL.x, (float) TouchImageView.this.dKf, TouchImageView.this.getImageWidth()), TouchImageView.this.m22209r(f, (float) TouchImageView.this.dKg, TouchImageView.this.getImageHeight()));
                                TouchImageView.this.azB();
                                this.dKL.set(pointF.x, pointF.y);
                                break;
                            }
                            break;
                    }
                }
                TouchImageView.this.setState(C7504i.NONE);
            }
            TouchImageView.this.setImageMatrix(TouchImageView.this.matrix);
            if (TouchImageView.this.dKp != null) {
                TouchImageView.this.dKp.onTouch(view, motionEvent);
            }
            if (TouchImageView.this.dKq != null) {
                TouchImageView.this.dKq.azH();
            }
            return true;
        }
    }

    /* renamed from: com.introvd.template.gallery.view.TouchImageView$h */
    private class C7503h extends SimpleOnScaleGestureListener {
        private C7503h() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.m22178a((double) scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            if (TouchImageView.this.dKq != null) {
                TouchImageView.this.dKq.azH();
            }
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.setState(C7504i.ZOOM);
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            TouchImageView.this.setState(C7504i.NONE);
            float d = TouchImageView.this.dJP;
            boolean z = true;
            if (TouchImageView.this.dJP > TouchImageView.this.dJT) {
                d = TouchImageView.this.dJT;
            } else if (TouchImageView.this.dJP < TouchImageView.this.dJS) {
                d = TouchImageView.this.dJS;
            } else {
                z = false;
            }
            float f = d;
            if (z) {
                C7498c cVar = new C7498c(f, (float) (TouchImageView.this.dKf / 2), (float) (TouchImageView.this.dKg / 2), true);
                TouchImageView.this.m22199k((Runnable) cVar);
            }
        }
    }

    /* renamed from: com.introvd.template.gallery.view.TouchImageView$i */
    private enum C7504i {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM,
        CROP_VIEW_ZOOM
    }

    /* renamed from: com.introvd.template.gallery.view.TouchImageView$j */
    private class C7505j {
        public float dKT;
        public float dKU;
        public ScaleType dKV;
        public float scale;

        public C7505j(float f, float f2, float f3, ScaleType scaleType) {
            this.scale = f;
            this.dKT = f2;
            this.dKU = f3;
            this.dKV = scaleType;
        }
    }

    public TouchImageView(Context context2) {
        super(context2);
        m22193gd(context2);
    }

    public TouchImageView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        m22193gd(context2);
    }

    public TouchImageView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        m22193gd(context2);
    }

    /* renamed from: I */
    private int m22169I(int i, int i2, int i3) {
        return i != Integer.MIN_VALUE ? i != 0 ? i2 : i3 : Math.min(i3, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public PointF m22170N(float f, float f2) {
        this.matrix.getValues(this.dJW);
        return new PointF(this.dJW[2] + (getImageWidth() * (f / ((float) getDrawable().getIntrinsicWidth()))), this.dJW[5] + (getImageHeight() * (f2 / ((float) getDrawable().getIntrinsicHeight()))));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22178a(double d, float f, float f2, boolean z) {
        float f3;
        float f4;
        if (z) {
            f3 = this.dJU;
            f4 = this.dJV;
        } else {
            f3 = this.dJS;
            f4 = this.dJT;
        }
        float f5 = this.dJP;
        this.dJP = (float) (((double) this.dJP) * d);
        if (this.dJP > f4) {
            this.dJP = f4;
            d = (double) (f4 / f5);
        } else if (this.dJP < f3) {
            this.dJP = f3;
            d = (double) (f3 / f5);
        }
        float f6 = (float) d;
        this.matrix.postScale(f6, f6, f, f2);
        azC();
        if (this.dKb) {
            azE();
        }
    }

    /* renamed from: a */
    private void m22179a(int i, float f, float f2, float f3, int i2, int i3, int i4) {
        float f4 = (float) i3;
        if (f3 < f4) {
            this.dJW[i] = (f4 - (((float) i4) * this.dJW[0])) * 0.5f;
        } else if (f > 0.0f) {
            this.dJW[i] = -((f3 - f4) * 0.5f);
        } else {
            this.dJW[i] = -((((Math.abs(f) + (((float) i2) * 0.5f)) / f2) * f3) - (f4 * 0.5f));
        }
    }

    /* renamed from: a */
    private void m22180a(final C7497b bVar) {
        if (bVar != null && bVar.dKy != null) {
            if (this.dKs == null) {
                this.dKr = C1834l.m5254a((C1839n<T>) new C1839n<C7497b>() {
                    /* renamed from: a */
                    public void mo10177a(C1838m<C7497b> mVar) throws Exception {
                        TouchImageView.this.dKs = mVar;
                        mVar.mo9791K(bVar);
                    }
                }).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<C7497b, C1840o<Bitmap>>() {
                    /* renamed from: b */
                    public C1840o<Bitmap> apply(C7497b bVar) throws Exception {
                        Matrix matrix = new Matrix();
                        matrix.preRotate(bVar.dKz, (float) (bVar.dKy.getWidth() / 2), (float) (bVar.dKy.getHeight() / 2));
                        return C1834l.m5257ah(Bitmap.createBitmap(bVar.dKy, 0, 0, bVar.dKy.getWidth(), bVar.dKy.getHeight(), matrix, true));
                    }
                }).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Bitmap>() {
                    /* renamed from: t */
                    public void accept(Bitmap bitmap) throws Exception {
                        if (TouchImageView.this.getContext() != null && bitmap != null && !bitmap.isRecycled()) {
                            TouchImageView.this.setImageBitmap(bitmap);
                            TouchImageView.this.mBitmap = bitmap;
                        }
                    }
                });
            }
            if (this.dKs != null) {
                this.dKs.mo9791K(bVar);
            }
        }
    }

    /* renamed from: aL */
    private void m22184aL(float f) {
        if (this.mBitmap == null && (getDrawable() instanceof BitmapDrawable)) {
            this.mBitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            m22180a(new C7497b(this.mBitmap, f));
        }
    }

    /* access modifiers changed from: private */
    public void azB() {
        this.matrix.getValues(this.dJW);
        float f = this.dJW[2];
        float f2 = this.dJW[5];
        float o = m22203o(f, (float) this.dKf, getImageWidth());
        float p = m22205p(f2, (float) this.dKg, getImageHeight());
        if (o != 0.0f || p != 0.0f) {
            this.matrix.postTranslate(o, p);
        }
    }

    /* access modifiers changed from: private */
    public void azC() {
        azB();
        if (!this.dKb) {
            this.matrix.getValues(this.dJW);
            if (getImageWidth() < ((float) this.dKf)) {
                this.dJW[2] = (((float) this.dKf) - getImageWidth()) / 2.0f;
            }
            if (getImageHeight() < ((float) this.dKg)) {
                this.dJW[5] = (((float) this.dKg) - getImageHeight()) / 2.0f;
            }
            this.matrix.setValues(this.dJW);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        r1 = java.lang.Math.min(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        r5 = ((float) r11.dKf) - (r1 * r2);
        r7 = ((float) r11.dKg) - (r3 * r4);
        r11.dKj = ((float) r11.dKf) - r5;
        r11.dKk = ((float) r11.dKg) - r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0083, code lost:
        if (azy() != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0087, code lost:
        if (r11.dJZ != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0089, code lost:
        r11.matrix.setScale(r1, r3);
        r11.matrix.postTranslate(r5 / 2.0f, r7 / 2.0f);
        r11.dJP = 1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        if (r11.dKl == 0.0f) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a5, code lost:
        if (r11.dKm != 0.0f) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        azz();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00aa, code lost:
        r11.dJQ.getValues(r11.dJW);
        r11.dJW[0] = (r11.dKj / r2) * r11.dJP;
        r11.dJW[4] = (r11.dKk / r4) * r11.dJP;
        r4 = r11.dJW[2];
        r10 = r11.dJW[5];
        m22179a(2, r4, r11.dKl * r11.dJP, getImageWidth(), r11.dKh, r11.dKf, r9);
        r4 = r11.dKm * r11.dJP;
        r5 = getImageHeight();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f2, code lost:
        if (r11.dKb != false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f4, code lost:
        m22179a(5, r10, r4, r5, r11.dKi, r11.dKg, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ff, code lost:
        r11.matrix.setValues(r11.dJW);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0106, code lost:
        azB();
        setImageMatrix(r11.matrix);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void azD() {
        /*
            r11 = this;
            android.graphics.drawable.Drawable r0 = r11.getDrawable()
            if (r0 == 0) goto L_0x0110
            int r1 = r0.getIntrinsicWidth()
            if (r1 == 0) goto L_0x0110
            int r1 = r0.getIntrinsicHeight()
            if (r1 != 0) goto L_0x0014
            goto L_0x0110
        L_0x0014:
            android.graphics.Matrix r1 = r11.matrix
            if (r1 == 0) goto L_0x010f
            android.graphics.Matrix r1 = r11.dJQ
            if (r1 != 0) goto L_0x001e
            goto L_0x010f
        L_0x001e:
            int r9 = r0.getIntrinsicWidth()
            int r0 = r0.getIntrinsicHeight()
            int r1 = r11.dKf
            float r1 = (float) r1
            float r2 = (float) r9
            float r1 = r1 / r2
            int r3 = r11.dKg
            float r3 = (float) r3
            float r4 = (float) r0
            float r3 = r3 / r4
            int[] r5 = com.introvd.template.gallery.view.TouchImageView.C74954.f3552Cb
            android.widget.ImageView$ScaleType r6 = r11.aNd
            int r6 = r6.ordinal()
            r5 = r5[r6]
            r6 = 1065353216(0x3f800000, float:1.0)
            switch(r5) {
                case 1: goto L_0x0063;
                case 2: goto L_0x0056;
                case 3: goto L_0x0047;
                case 4: goto L_0x0050;
                case 5: goto L_0x0067;
                default: goto L_0x003f;
            }
        L_0x003f:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "TouchImageView does not support FIT_START or FIT_END"
            r0.<init>(r1)
            throw r0
        L_0x0047:
            float r1 = java.lang.Math.min(r1, r3)
            float r1 = java.lang.Math.min(r6, r1)
            r3 = r1
        L_0x0050:
            float r1 = java.lang.Math.min(r1, r3)
        L_0x0054:
            r3 = r1
            goto L_0x0067
        L_0x0056:
            boolean r5 = r11.dKb
            if (r5 == 0) goto L_0x005e
            int r3 = r11.dKf
            float r3 = (float) r3
            float r3 = r3 / r4
        L_0x005e:
            float r1 = java.lang.Math.max(r1, r3)
            goto L_0x0054
        L_0x0063:
            r1 = 1065353216(0x3f800000, float:1.0)
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x0067:
            int r5 = r11.dKf
            float r5 = (float) r5
            float r7 = r1 * r2
            float r5 = r5 - r7
            int r7 = r11.dKg
            float r7 = (float) r7
            float r8 = r3 * r4
            float r7 = r7 - r8
            int r8 = r11.dKf
            float r8 = (float) r8
            float r8 = r8 - r5
            r11.dKj = r8
            int r8 = r11.dKg
            float r8 = (float) r8
            float r8 = r8 - r7
            r11.dKk = r8
            boolean r8 = r11.azy()
            if (r8 != 0) goto L_0x009a
            boolean r8 = r11.dJZ
            if (r8 != 0) goto L_0x009a
            android.graphics.Matrix r0 = r11.matrix
            r0.setScale(r1, r3)
            android.graphics.Matrix r0 = r11.matrix
            r1 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r1
            float r7 = r7 / r1
            r0.postTranslate(r5, r7)
            r11.dJP = r6
            goto L_0x0106
        L_0x009a:
            float r1 = r11.dKl
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00a7
            float r1 = r11.dKm
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x00aa
        L_0x00a7:
            r11.azz()
        L_0x00aa:
            android.graphics.Matrix r1 = r11.dJQ
            float[] r3 = r11.dJW
            r1.getValues(r3)
            float[] r1 = r11.dJW
            r3 = 0
            float r5 = r11.dKj
            float r5 = r5 / r2
            float r2 = r11.dJP
            float r5 = r5 * r2
            r1[r3] = r5
            float[] r1 = r11.dJW
            r2 = 4
            float r3 = r11.dKk
            float r3 = r3 / r4
            float r4 = r11.dJP
            float r3 = r3 * r4
            r1[r2] = r3
            float[] r1 = r11.dJW
            r2 = 2
            r4 = r1[r2]
            float[] r1 = r11.dJW
            r2 = 5
            r10 = r1[r2]
            float r1 = r11.dKl
            float r2 = r11.dJP
            float r5 = r1 * r2
            float r6 = r11.getImageWidth()
            r3 = 2
            int r7 = r11.dKh
            int r8 = r11.dKf
            r2 = r11
            r2.m22179a(r3, r4, r5, r6, r7, r8, r9)
            float r1 = r11.dKm
            float r2 = r11.dJP
            float r4 = r1 * r2
            float r5 = r11.getImageHeight()
            boolean r1 = r11.dKb
            if (r1 != 0) goto L_0x00ff
            r2 = 5
            int r6 = r11.dKi
            int r7 = r11.dKg
            r1 = r11
            r3 = r10
            r8 = r0
            r1.m22179a(r2, r3, r4, r5, r6, r7, r8)
        L_0x00ff:
            android.graphics.Matrix r0 = r11.matrix
            float[] r1 = r11.dJW
            r0.setValues(r1)
        L_0x0106:
            r11.azB()
            android.graphics.Matrix r0 = r11.matrix
            r11.setImageMatrix(r0)
            return
        L_0x010f:
            return
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.gallery.view.TouchImageView.azD():void");
    }

    private void azE() {
        if (this.dKf > 0 && this.dKg > 0) {
            Rect rect = new Rect();
            rect.left = Math.max(0, ((int) (((float) this.dKf) - getImageWidth())) / 2);
            rect.top = Math.max(0, ((int) (((float) this.dKg) - getImageHeight())) / 2);
            rect.right = Math.min(this.dKf, (int) (((float) rect.left) + getImageWidth()));
            rect.bottom = Math.min(this.dKg, (int) (((float) rect.top) + getImageHeight()));
            setBitmapRect(rect);
        }
    }

    private void azF() {
        C7508a.LEFT.mo32294aw(0.0f);
        C7508a.TOP.mo32294aw((float) ((this.dKg - this.dKf) / 2));
        C7508a.RIGHT.mo32294aw((float) this.dKf);
        C7508a.BOTTOM.mo32294aw((float) (this.dKg - ((this.dKg - this.dKf) / 2)));
    }

    private void azx() {
        this.dlZ = C7510b.m22224ge(this.context);
        this.dJY = C7510b.m22225gf(this.context);
    }

    private void azz() {
        if (this.matrix != null && this.dKg != 0 && this.dKf != 0) {
            this.matrix.getValues(this.dJW);
            this.dJQ.setValues(this.dJW);
            this.dKm = this.dKk;
            this.dKl = this.dKj;
            this.dKi = this.dKg;
            this.dKh = this.dKf;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public PointF m22187c(float f, float f2, boolean z) {
        this.matrix.getValues(this.dJW);
        float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
        float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
        float f3 = this.dJW[2];
        float imageWidth = ((f - f3) * intrinsicWidth) / getImageWidth();
        float imageHeight = ((f2 - this.dJW[5]) * intrinsicHeight) / getImageHeight();
        if (z) {
            imageWidth = Math.min(Math.max(imageWidth, 0.0f), intrinsicWidth);
            imageHeight = Math.min(Math.max(imageHeight, 0.0f), intrinsicHeight);
        }
        return new PointF(imageWidth, imageHeight);
    }

    /* renamed from: gd */
    private void m22193gd(Context context2) {
        super.setClickable(true);
        this.context = context2;
        this.dKn = new ScaleGestureDetector(context2, new C7503h());
        this.aML = new GestureDetector(context2, new C7500e());
        this.matrix = new Matrix();
        this.dJQ = new Matrix();
        this.dJW = new float[9];
        this.dJP = 1.0f;
        if (this.aNd == null) {
            this.aNd = ScaleType.FIT_CENTER;
        }
        this.dJS = 1.0f;
        this.dJT = 3.0f;
        this.dJU = this.dJS * 0.75f;
        this.dJV = this.dJT * 1.25f;
        setImageMatrix(this.matrix);
        setScaleType(ScaleType.MATRIX);
        setState(C7504i.NONE);
        this.dKa = false;
        super.setOnTouchListener(new C7502g());
    }

    /* access modifiers changed from: private */
    public float getImageHeight() {
        return this.dKk * this.dJP;
    }

    /* access modifiers changed from: private */
    public float getImageWidth() {
        return this.dKj * this.dJP;
    }

    /* renamed from: i */
    private void m22196i(Canvas canvas, Rect rect) {
        float atF = C7508a.LEFT.atF();
        float atF2 = C7508a.TOP.atF();
        float atF3 = C7508a.RIGHT.atF();
        float atF4 = C7508a.BOTTOM.atF();
        Canvas canvas2 = canvas;
        canvas2.drawRect(0.0f, 0.0f, (float) this.dKf, atF2, this.dJY);
        canvas2.drawRect(0.0f, atF4, (float) this.dKf, (float) this.dKg, this.dJY);
        canvas.drawRect(0.0f, atF2, atF, atF4, this.dJY);
        canvas.drawRect(atF3, atF2, (float) this.dKf, atF4, this.dJY);
    }

    /* access modifiers changed from: private */
    @TargetApi(16)
    /* renamed from: k */
    public void m22199k(Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16);
        }
    }

    /* renamed from: o */
    private float m22203o(float f, float f2, float f3) {
        float f4;
        float f5;
        if (f3 <= f2) {
            f4 = f2 - f3;
            f5 = 0.0f;
        } else {
            f5 = f2 - f3;
            f4 = 0.0f;
        }
        if (f < f5) {
            return (-f) + f5;
        }
        if (f > f4) {
            return (-f) + f4;
        }
        return 0.0f;
    }

    /* renamed from: p */
    private float m22205p(float f, float f2, float f3) {
        if (!this.dKb) {
            return m22203o(f, f2, f3);
        }
        float atF = C7508a.BOTTOM.atF() - f3;
        float atF2 = C7508a.TOP.atF();
        if (f < atF) {
            return (-f) + atF;
        }
        if (f > atF2) {
            return (-f) + atF2;
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public float m22207q(float f, float f2, float f3) {
        if (f3 <= f2) {
            return 0.0f;
        }
        return f;
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public float m22209r(float f, float f2, float f3) {
        return !this.dKb ? m22207q(f, f2, f3) : f;
    }

    /* access modifiers changed from: private */
    public void setState(C7504i iVar) {
        this.dJR = iVar;
    }

    public void azA() {
        this.dJP = 1.0f;
        azD();
    }

    public boolean azG() {
        return this.mRotation % 360.0f != 0.0f || this.dKb;
    }

    public boolean azw() {
        return this.dKb;
    }

    public boolean azy() {
        return this.dJP != 1.0f;
    }

    public boolean canScrollHorizontally(int i) {
        this.matrix.getValues(this.dJW);
        float f = this.dJW[2];
        boolean z = false;
        if (getImageWidth() < ((float) this.dKf)) {
            return false;
        }
        if (f >= -1.0f && i < 0) {
            return false;
        }
        if (Math.abs(f) + ((float) this.dKf) + 1.0f < getImageWidth() || i <= 0) {
            z = true;
        }
        return z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public RectF getCropViewRect() {
        this.matrix.getValues(this.dJW);
        int i = (int) this.dJW[2];
        int i2 = (int) this.dJW[5];
        RectF rectF = new RectF();
        rectF.left = C7508a.LEFT.atF() - ((float) i);
        rectF.top = C7508a.TOP.atF() - ((float) i2);
        rectF.right = rectF.left + C7508a.getWidth();
        rectF.bottom = rectF.top + C7508a.getHeight();
        return rectF;
    }

    public float getCurrentZoom() {
        return this.dJP;
    }

    public RectF getDisplayImageRect() {
        RectF rectF = new RectF();
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getImageWidth();
        rectF.bottom = getImageHeight();
        return rectF;
    }

    public float getMaxZoom() {
        return this.dJT;
    }

    public float getMinZoom() {
        return this.dJS;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public ScaleType getScaleType() {
        return this.aNd;
    }

    public PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        PointF c = m22187c((float) (this.dKf / 2), (float) (this.dKg / 2), true);
        c.x /= (float) intrinsicWidth;
        c.y /= (float) intrinsicHeight;
        return c;
    }

    public RectF getZoomedRect() {
        if (this.aNd != ScaleType.FIT_XY) {
            PointF c = m22187c(0.0f, 0.0f, true);
            PointF c2 = m22187c((float) this.dKf, (float) this.dKg, true);
            float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
            float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
            return new RectF(c.x / intrinsicWidth, c.y / intrinsicHeight, c2.x / intrinsicWidth, c2.y / intrinsicHeight);
        }
        throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        azz();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.dKa = true;
        this.dJZ = true;
        if (this.dKe != null) {
            setZoom(this.dKe.scale, this.dKe.dKT, this.dKe.dKU, this.dKe.dKV);
            this.dKe = null;
        }
        super.onDraw(canvas);
        if (this.dKb && this.dKd != null) {
            m22196i(canvas, this.dKd);
            canvas.drawRect(C7508a.LEFT.atF(), C7508a.TOP.atF(), C7508a.RIGHT.atF(), C7508a.BOTTOM.atF(), this.dlZ);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        this.dKf = m22169I(mode, size, intrinsicWidth);
        this.dKg = m22169I(mode2, size2, intrinsicHeight);
        setMeasuredDimension(this.dKf, this.dKg);
        azD();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.dJP = bundle.getFloat("saveScale");
            this.dJW = bundle.getFloatArray("matrix");
            this.dJQ.setValues(this.dJW);
            this.dKm = bundle.getFloat("matchViewHeight");
            this.dKl = bundle.getFloat("matchViewWidth");
            this.dKi = bundle.getInt("viewHeight");
            this.dKh = bundle.getInt("viewWidth");
            this.dJZ = bundle.getBoolean("imageRendered");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.dJP);
        bundle.putFloat("matchViewHeight", this.dKk);
        bundle.putFloat("matchViewWidth", this.dKj);
        bundle.putInt("viewWidth", this.dKf);
        bundle.putInt("viewHeight", this.dKg);
        this.matrix.getValues(this.dJW);
        bundle.putFloatArray("matrix", this.dJW);
        bundle.putBoolean("imageRendered", this.dJZ);
        return bundle;
    }

    /* renamed from: rI */
    public boolean mo32250rI(int i) {
        return canScrollHorizontally(i);
    }

    public void setBitmapRect(Rect rect) {
        if (C7508a.LEFT.mo32295o(rect) || C7508a.RIGHT.mo32295o(rect) || C7508a.TOP.mo32295o(rect) || C7508a.BOTTOM.mo32295o(rect)) {
            this.dKc = false;
        }
        this.dKd = rect;
        azF();
    }

    public void setCropViewEnable(boolean z) {
        this.dKb = z;
        if (z) {
            this.aNd = ScaleType.CENTER_CROP;
            azx();
            return;
        }
        this.aNd = ScaleType.FIT_CENTER;
        azD();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        azz();
        azD();
        if (this.dKb) {
            azE();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        azz();
        azD();
        if (this.dKb) {
            azE();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        azz();
        azD();
        if (this.dKb) {
            azE();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        azz();
        azD();
        if (this.dKb) {
            azE();
        }
    }

    public void setMaxZoom(float f) {
        this.dJT = f;
        this.dJV = this.dJT * 1.25f;
    }

    public void setMinZoom(float f) {
        this.dJS = f;
        this.dJU = this.dJS * 0.75f;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.dKo = onDoubleTapListener;
    }

    public void setOnTouchImageViewListener(C7501f fVar) {
        this.dKq = fVar;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.dKp = onTouchListener;
    }

    public void setRotation(float f) {
        m22184aL(((f - this.mRotation) + 360.0f) % 360.0f);
        this.mRotation = f;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType == ScaleType.FIT_START || scaleType == ScaleType.FIT_END) {
            throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
        } else if (scaleType == ScaleType.MATRIX) {
            super.setScaleType(ScaleType.MATRIX);
        } else {
            this.aNd = scaleType;
            if (this.dKa) {
                setZoom(this);
            }
        }
    }

    public void setScrollPosition(float f, float f2) {
        setZoom(this.dJP, f, f2);
    }

    public void setZoom(float f) {
        setZoom(f, 0.5f, 0.5f);
    }

    public void setZoom(float f, float f2, float f3) {
        setZoom(f, f2, f3, this.aNd);
    }

    public void setZoom(float f, float f2, float f3, ScaleType scaleType) {
        if (!this.dKa) {
            C7505j jVar = new C7505j(f, f2, f3, scaleType);
            this.dKe = jVar;
            return;
        }
        if (scaleType != this.aNd) {
            setScaleType(scaleType);
        }
        azA();
        m22178a((double) f, (float) (this.dKf / 2), (float) (this.dKg / 2), true);
        this.matrix.getValues(this.dJW);
        this.dJW[2] = -((f2 * getImageWidth()) - (((float) this.dKf) * 0.5f));
        this.dJW[5] = -((f3 * getImageHeight()) - (((float) this.dKg) * 0.5f));
        this.matrix.setValues(this.dJW);
        azB();
        setImageMatrix(this.matrix);
    }

    public void setZoom(TouchImageView touchImageView) {
        PointF scrollPosition = touchImageView.getScrollPosition();
        if (scrollPosition != null) {
            setZoom(touchImageView.getCurrentZoom(), scrollPosition.x, scrollPosition.y, touchImageView.getScaleType());
        }
    }

    public void uninit() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.dKr != null && !this.dKr.aAy()) {
            this.dKr.dispose();
        }
    }
}
