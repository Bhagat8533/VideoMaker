package com.introvd.template.camera.p232e;

import android.content.Context;
import android.view.MotionEvent;

/* renamed from: com.introvd.template.camera.e.g */
public class C5039g {
    private int bYV;
    private int bYW;
    private C5040a cbH;
    private MotionEvent cbI;
    private MotionEvent cbJ;
    private boolean cbK;
    private float cbL;
    private float cbM;
    private float cbN;
    private float cbO;
    private float cbP;
    private float cbQ;
    private float cbR;
    private float cbS;
    private float cbT;
    private int cbU;
    private int cbV;
    private int cbW;
    private Context mContext;

    /* renamed from: com.introvd.template.camera.e.g$a */
    public interface C5040a {
        /* renamed from: a */
        boolean mo24904a(C5039g gVar);

        /* renamed from: b */
        boolean mo24905b(C5039g gVar);

        /* renamed from: c */
        void mo24906c(C5039g gVar);
    }

    public C5039g(Context context, C5040a aVar) {
        this.mContext = context;
        this.cbH = aVar;
    }

    private void reset() {
        if (this.cbJ != null) {
            this.cbJ.recycle();
            this.cbJ = null;
        }
        if (this.cbI != null) {
            this.cbI.recycle();
            this.cbI = null;
        }
    }

    /* renamed from: t */
    private void m13270t(MotionEvent motionEvent) {
        if (this.cbI != null) {
            this.cbI.recycle();
        }
        this.cbI = MotionEvent.obtain(motionEvent);
        this.cbP = -1.0f;
        this.cbQ = -1.0f;
        this.cbR = -1.0f;
        this.cbL = this.cbJ.getX(1) - this.cbJ.getX(0);
        this.cbM = this.cbJ.getY(1) - this.cbJ.getY(0);
        try {
            this.cbN = motionEvent.getX(1) - motionEvent.getX(0);
            this.cbO = motionEvent.getY(1) - motionEvent.getY(0);
            float abs = Math.abs(this.cbN - this.cbL);
            float abs2 = Math.abs(this.cbO - this.cbM);
            if (abs < 1.0f && abs2 < 1.0f) {
                this.cbN = this.cbL;
                this.cbO = this.cbM;
            }
            this.cbS = motionEvent.getPressure(0) + motionEvent.getPressure(1);
            this.cbT = this.cbJ.getPressure(0) + this.cbJ.getPressure(1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: YV */
    public float mo25891YV() {
        if (this.cbR == -1.0f) {
            this.cbR = getCurrentSpan() / getPreviousSpan();
            if (getPreviousSpan() < 50.0f) {
                this.cbR = 1.0f;
            }
            if (this.cbR > 1.2f) {
                this.cbR = 1.2f;
            } else if (this.cbR < 0.8f) {
                this.cbR = 0.8f;
            }
        }
        return this.cbR;
    }

    public float getCurrentSpan() {
        if (this.cbP == -1.0f) {
            float f = this.cbN;
            float f2 = this.cbO;
            this.cbP = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        }
        return this.cbP;
    }

    public float getPreviousSpan() {
        if (this.cbQ == -1.0f) {
            float f = this.cbL;
            float f2 = this.cbM;
            this.cbQ = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        }
        return this.cbQ;
    }

    /* renamed from: s */
    public boolean mo25894s(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!this.cbK) {
            if ((action == 5 || action == 261) && motionEvent.getPointerCount() >= 2) {
                reset();
                this.cbJ = MotionEvent.obtain(motionEvent);
                this.bYV = (int) ((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f);
                this.bYW = (int) ((motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
                m13270t(motionEvent);
                this.cbK = this.cbH.mo24904a(this);
                this.cbU = action;
                try {
                    if (this.cbU == 5) {
                        this.cbV = (int) motionEvent.getX(0);
                        this.cbW = (int) motionEvent.getY(0);
                    } else if (this.cbU == 261) {
                        this.cbV = (int) motionEvent.getX(1);
                        this.cbW = (int) motionEvent.getY(1);
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        } else if (motionEvent.getPointerCount() < 2) {
            return true;
        } else {
            if (!(action == 6 || action == 262)) {
                switch (action) {
                    case 2:
                        m13270t(motionEvent);
                        if (this.cbS / this.cbT > 0.67f && this.cbH.mo24905b(this)) {
                            this.cbJ.recycle();
                            this.cbJ = MotionEvent.obtain(motionEvent);
                            break;
                        }
                    case 3:
                        break;
                }
            }
            m13270t(motionEvent);
            this.cbH.mo24906c(this);
            this.cbK = false;
            reset();
        }
        return true;
    }
}
