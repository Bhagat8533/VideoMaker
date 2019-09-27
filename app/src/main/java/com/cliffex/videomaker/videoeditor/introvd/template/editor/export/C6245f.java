package com.introvd.template.editor.export;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.animation.DecelerateInterpolator;

/* renamed from: com.introvd.template.editor.export.f */
class C6245f extends Drawable {
    private C6226a cOH;
    private C6226a cOI;
    private C6226a cOJ;
    private ObjectAnimator cOK;
    private ObjectAnimator cOL;
    private ObjectAnimator cOM;
    private ObjectAnimator cON;
    private ObjectAnimator cOO;
    private ObjectAnimator cOP;
    private ObjectAnimator cOQ;
    private ObjectAnimator cOR;
    private ObjectAnimator cOS;
    private ObjectAnimator cOT;
    private ObjectAnimator cOU;
    /* access modifiers changed from: private */
    public int cOV;
    private Bitmap cOW;
    private Paint cOX;
    private RectF cOY = new RectF();
    private Rect cOZ = new Rect();
    /* access modifiers changed from: private */
    public int cPa;
    /* access modifiers changed from: private */
    public int cPb;
    /* access modifiers changed from: private */
    public int cPc;
    private Property<C6226a, Float> cPd = new Property<C6226a, Float>(Float.class, "zoomin") {
        /* renamed from: a */
        public Float get(C6226a aVar) {
            return Float.valueOf(0.0f);
        }

        /* renamed from: a */
        public void set(C6226a aVar, Float f) {
            aVar.setRadius(f.floatValue());
            C6245f.this.invalidateSelf();
        }
    };
    private Property<C6226a, Integer> cPe = new Property<C6226a, Integer>(Integer.class, "alpha") {
        /* renamed from: a */
        public void set(C6226a aVar, Integer num) {
            aVar.setAlpha(num.intValue());
            C6245f.this.invalidateSelf();
        }

        /* renamed from: b */
        public Integer get(C6226a aVar) {
            return Integer.valueOf(0);
        }
    };
    private Property<C6226a, Float> cPf = new Property<C6226a, Float>(Float.class, "zoomout") {
        /* renamed from: a */
        public Float get(C6226a aVar) {
            return Float.valueOf(0.0f);
        }

        /* renamed from: a */
        public void set(C6226a aVar, Float f) {
            aVar.setRadius((((float) C6245f.this.mSize) / 2.0f) - f.floatValue());
            C6245f.this.invalidateSelf();
        }
    };
    private Property<C6226a, Integer> cPg = new Property<C6226a, Integer>(Integer.class, "zoomout2") {
        /* renamed from: a */
        public void set(C6226a aVar, Integer num) {
            aVar.setStrokeWidth((float) (C6245f.this.cOV - num.intValue()));
            C6245f.this.invalidateSelf();
        }

        /* renamed from: b */
        public Integer get(C6226a aVar) {
            return Integer.valueOf(0);
        }
    };
    private Property<C6245f, Integer> cPh = new Property<C6245f, Integer>(Integer.class, "percent") {
        /* renamed from: a */
        public void set(C6245f fVar, Integer num) {
            C6245f.this.cPa = num.intValue();
            C6245f.this.invalidateSelf();
        }

        /* renamed from: d */
        public Integer get(C6245f fVar) {
            return Integer.valueOf(0);
        }
    };
    private Property<Paint, Integer> cPi = new Property<Paint, Integer>(Integer.class, "alpha") {
        /* renamed from: a */
        public Integer get(Paint paint) {
            return Integer.valueOf(0);
        }

        /* renamed from: a */
        public void set(Paint paint, Integer num) {
            paint.setAlpha(num.intValue());
            C6245f.this.invalidateSelf();
        }
    };
    private Property<C6245f, Integer> cPj = new Property<C6245f, Integer>(Integer.class, "trans") {
        /* renamed from: a */
        public void set(C6245f fVar, Integer num) {
            C6245f.this.cPc = C6245f.this.cPb - num.intValue();
            C6245f.this.invalidateSelf();
        }

        /* renamed from: d */
        public Integer get(C6245f fVar) {
            return Integer.valueOf(0);
        }
    };
    /* access modifiers changed from: private */
    public int mSize;

    public C6245f(int i, int i2, Bitmap bitmap, int i3) {
        this.cOW = bitmap;
        this.mSize = i;
        this.cOV = i2;
        this.cPb = i3;
        this.cOH = new C6226a(i);
        this.cOH.setBounds(0, 0, i, i);
        float f = (float) i2;
        this.cOH.setStrokeWidth(f);
        this.cOI = new C6226a(i);
        this.cOI.setBounds(0, 0, i, i);
        this.cOI.setStrokeWidth(f);
        this.cOJ = new C6226a(i);
        this.cOJ.setBounds(0, 0, i, i);
        this.cOJ.setStrokeWidth(f);
        this.cOX = new Paint();
        this.cOX.setAntiAlias(true);
        als();
    }

    /* renamed from: E */
    private void m17895E(Canvas canvas) {
        if (this.cOW != null) {
            this.cOZ.left = 0;
            this.cOZ.top = 0;
            this.cOZ.right = (this.cOW.getWidth() * this.cPa) / 100;
            this.cOZ.bottom = this.cOW.getHeight();
            this.cOY.left = (float) (((this.mSize / 2) + this.cOV) - (this.cOW.getWidth() / 2));
            this.cOY.top = (float) ((((this.mSize / 2) + this.cOV) - (this.cOW.getHeight() / 2)) - this.cPc);
            this.cOY.right = this.cOY.left + ((float) ((this.cOW.getWidth() * this.cPa) / 100));
            this.cOY.bottom = this.cOY.top + ((float) this.cOW.getHeight());
            canvas.drawBitmap(this.cOW, this.cOZ, this.cOY, this.cOX);
        }
    }

    private void als() {
        this.cOK = ObjectAnimator.ofFloat(this.cOH, this.cPd, new float[]{(((float) this.mSize) * 0.8f) / 2.0f, (float) (this.mSize / 2)});
        this.cOK.setDuration(462);
        this.cOK.setStartDelay(300);
        this.cOK.setInterpolator(new DecelerateInterpolator());
        this.cOM = ObjectAnimator.ofFloat(this.cOJ, this.cPd, new float[]{(((float) this.mSize) * 0.8f) / 2.0f, (float) (this.mSize / 2)});
        this.cOM.setDuration(462);
        this.cOM.setStartDelay(150);
        this.cOM.setInterpolator(new DecelerateInterpolator());
        this.cOL = ObjectAnimator.ofFloat(this.cOI, this.cPd, new float[]{(((float) this.mSize) * 0.8f) / 2.0f, (float) (this.mSize / 2)});
        this.cOL.setDuration(462);
        this.cOL.setInterpolator(new DecelerateInterpolator());
        this.cON = ObjectAnimator.ofInt(this.cOH, this.cPe, new int[]{33});
        this.cON.setDuration(462);
        this.cON.setStartDelay(300);
        this.cON.setInterpolator(new DecelerateInterpolator());
        this.cOP = ObjectAnimator.ofInt(this.cOJ, this.cPe, new int[]{33});
        this.cOP.setDuration(462);
        this.cOP.setStartDelay(150);
        this.cOP.setInterpolator(new DecelerateInterpolator());
        this.cOO = ObjectAnimator.ofInt(this.cOI, this.cPe, new int[]{33});
        this.cOO.setDuration(462);
        this.cOO.setInterpolator(new DecelerateInterpolator());
        this.cOQ = ObjectAnimator.ofFloat(this.cOH, this.cPf, new float[]{(((float) this.mSize) * 0.5f) / 2.0f});
        this.cOQ.setDuration(330);
        this.cOQ.setInterpolator(new DecelerateInterpolator());
        this.cOR = ObjectAnimator.ofInt(this.cOH, this.cPg, new int[]{this.cOV / 2});
        this.cOR.setDuration(330);
        this.cOR.setInterpolator(new DecelerateInterpolator());
        this.cOS = ObjectAnimator.ofInt(this, this.cPh, new int[]{100});
        this.cOS.setDuration(330);
        this.cOS.setStartDelay(264);
        this.cOS.setInterpolator(new DecelerateInterpolator());
        this.cOT = ObjectAnimator.ofInt(this.cOX, this.cPi, new int[]{255});
        this.cOT.setDuration(330);
        this.cOT.setStartDelay(200);
        this.cOT.setInterpolator(new DecelerateInterpolator());
        this.cOU = ObjectAnimator.ofInt(this, this.cPj, new int[]{this.cPb});
        this.cOU.setDuration(330);
        this.cOU.setStartDelay(200);
        this.cOU.setInterpolator(new DecelerateInterpolator());
    }

    public void draw(Canvas canvas) {
        this.cOH.draw(canvas);
        this.cOI.draw(canvas);
        this.cOJ.draw(canvas);
        m17895E(canvas);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setProgress(int i) {
        this.cOH.setProgress(i);
        invalidateSelf();
    }
}
