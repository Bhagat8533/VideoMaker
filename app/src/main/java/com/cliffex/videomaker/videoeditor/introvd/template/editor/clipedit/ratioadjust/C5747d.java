package com.introvd.template.editor.clipedit.ratioadjust;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import com.introvd.template.common.LogUtilsV2;

/* renamed from: com.introvd.template.editor.clipedit.ratioadjust.d */
public class C5747d {
    private GestureDetector aML;
    private OnTouchListener bWl = new OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return C5747d.this.m15989o(motionEvent);
        }
    };
    /* access modifiers changed from: private */
    public C5752c cAV;
    private View cBo = null;
    private ScaleGestureDetector cBp;
    /* access modifiers changed from: private */
    public volatile boolean cBq = false;
    /* access modifiers changed from: private */
    public boolean cBr = false;
    private float cBs = 0.0f;
    private boolean cBu = true;
    private final OnScaleGestureListener cBv = new SimpleOnScaleGestureListener() {
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            C5747d.this.cBx = C5747d.this.cBx * scaleGestureDetector.getScaleFactor();
            if (Math.abs(C5747d.this.cBx) >= 5.0f) {
                if (C5747d.this.cBx > 0.0f) {
                    C5747d.this.cBx = 5.0f;
                } else {
                    C5747d.this.cBx = -5.0f;
                }
            }
            if (Math.abs(C5747d.this.cBx) <= 0.2f) {
                if (C5747d.this.cBx > 0.0f) {
                    C5747d.this.cBx = 0.2f;
                } else {
                    C5747d.this.cBx = -0.2f;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(C5747d.this.cBx);
            sb.append("");
            LogUtilsV2.m14230i(sb.toString());
            if (C5747d.this.cAV != null) {
                C5747d.this.cAV.mo27991z(C5747d.this.cBx, C5747d.this.cBx);
            }
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }
    };
    /* access modifiers changed from: private */
    public float cBx = 1.0f;
    /* access modifiers changed from: private */
    public float cBy = 0.0f;
    /* access modifiers changed from: private */
    public float cBz = 0.0f;

    /* renamed from: com.introvd.template.editor.clipedit.ratioadjust.d$a */
    private class C5750a extends SimpleOnGestureListener {
        private C5750a() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            C5747d.this.cBr = true;
            super.onLongPress(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!C5747d.this.cBq) {
                C5747d.this.cBy = C5747d.this.cBy - f;
                C5747d.this.cBz = C5747d.this.cBz - f2;
                StringBuilder sb = new StringBuilder();
                sb.append(C5747d.this.cBy);
                sb.append("===");
                sb.append(C5747d.this.cBz);
                LogUtilsV2.m14230i(sb.toString());
                if (C5747d.this.cAV != null) {
                    C5747d.this.cAV.mo27988A(C5747d.this.cBy, C5747d.this.cBz);
                }
            }
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return super.onSingleTapConfirmed(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return C5747d.this.cAV != null ? C5747d.this.cAV.afr() : super.onSingleTapUp(motionEvent);
        }
    }

    /* renamed from: com.introvd.template.editor.clipedit.ratioadjust.d$b */
    public static class C5751b implements C5752c {
        /* renamed from: A */
        public void mo27988A(float f, float f2) {
        }

        public void afq() {
        }

        public boolean afr() {
            return false;
        }

        /* renamed from: co */
        public boolean mo28023co(int i, int i2) {
            return true;
        }

        /* renamed from: lm */
        public void mo28024lm(int i) {
        }

        /* renamed from: ln */
        public void mo28025ln(int i) {
        }

        /* renamed from: z */
        public void mo27991z(float f, float f2) {
        }
    }

    /* renamed from: com.introvd.template.editor.clipedit.ratioadjust.d$c */
    public interface C5752c {
        /* renamed from: A */
        void mo27988A(float f, float f2);

        void afq();

        boolean afr();

        /* renamed from: co */
        boolean mo28023co(int i, int i2);

        /* renamed from: lm */
        void mo28024lm(int i);

        /* renamed from: ln */
        void mo28025ln(int i);

        /* renamed from: z */
        void mo27991z(float f, float f2);
    }

    public C5747d(View view) {
        this.cBo = view;
    }

    /* renamed from: D */
    private float m15978D(MotionEvent motionEvent) {
        try {
            return (float) Math.toDegrees(Math.atan2((double) (motionEvent.getY(1) - motionEvent.getY(0)), (double) (motionEvent.getX(1) - motionEvent.getX(0))));
        } catch (IllegalArgumentException unused) {
            return 0.0f;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean m15989o(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0 && this.cAV != null) {
            this.cAV.afq();
            if (motionEvent.getPointerCount() == 1) {
                this.cBu = this.cAV.mo28023co((int) motionEvent.getX(), (int) motionEvent.getY());
            } else if (motionEvent.getPointerCount() == 2) {
                this.cBu = this.cAV.mo28023co((int) motionEvent.getX(), (int) motionEvent.getY()) || this.cAV.mo28023co((int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
        if (!this.cBu) {
            return true;
        }
        if (this.aML != null) {
            this.aML.onTouchEvent(motionEvent);
        }
        if (this.cBp != null) {
            this.cBp.onTouchEvent(motionEvent);
        }
        switch (action) {
            case 1:
            case 3:
                this.cBr = false;
                break;
            case 2:
                if (this.cBq) {
                    float D = m15978D(motionEvent) - this.cBs;
                    StringBuilder sb = new StringBuilder();
                    sb.append("rotation change:");
                    sb.append(D);
                    LogUtilsV2.m14230i(sb.toString());
                    if (this.cAV != null) {
                        this.cAV.mo28024lm((int) D);
                        break;
                    }
                }
                break;
            case 5:
                this.cBs = m15978D(motionEvent);
                if (!this.cBr) {
                    this.cBq = true;
                    break;
                }
                break;
            case 6:
                if (this.cAV != null) {
                    float D2 = m15978D(motionEvent) - this.cBs;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("rotation end:");
                    sb2.append(D2);
                    LogUtilsV2.m14230i(sb2.toString());
                    if (this.cAV != null) {
                        this.cAV.mo28025ln((int) D2);
                    }
                }
                if (this.cBq) {
                    this.cBq = false;
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    public void mo28012a(C5752c cVar) {
        this.cAV = cVar;
    }

    public void adc() {
        this.cBo.setOnTouchListener(this.bWl);
        this.aML = new GestureDetector(this.cBo.getContext(), new C5750a());
        this.cBp = new ScaleGestureDetector(this.cBo.getContext(), this.cBv);
    }

    /* renamed from: m */
    public void mo28014m(float f, float f2, float f3) {
        this.cBx = f;
        this.cBy = f2;
        this.cBz = f3;
    }
}
