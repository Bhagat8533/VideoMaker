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

/* renamed from: com.introvd.template.editor.clipedit.ratioadjust.c */
public class C5741c {
    private GestureDetector aML;
    private OnTouchListener bWl = new OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return C5741c.this.m15966o(motionEvent);
        }
    };
    private View cBo = null;
    private ScaleGestureDetector cBp;
    /* access modifiers changed from: private */
    public volatile boolean cBq = false;
    /* access modifiers changed from: private */
    public boolean cBr = false;
    private float cBs = 0.0f;
    /* access modifiers changed from: private */
    public C5746c cBt;
    private boolean cBu = true;
    private final OnScaleGestureListener cBv = new SimpleOnScaleGestureListener() {
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (C5741c.this.cBt != null) {
                C5741c.this.cBt.mo28008an(scaleFactor);
            }
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }
    };

    /* renamed from: com.introvd.template.editor.clipedit.ratioadjust.c$a */
    private class C5744a extends SimpleOnGestureListener {
        private C5744a() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            C5741c.this.cBr = true;
            super.onLongPress(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!C5741c.this.cBq) {
                StringBuilder sb = new StringBuilder();
                sb.append(f);
                sb.append("===");
                sb.append(f2);
                LogUtilsV2.m14230i(sb.toString());
                if (C5741c.this.cBt != null) {
                    C5741c.this.cBt.mo28005A(f, f2);
                }
            }
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return super.onSingleTapConfirmed(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return C5741c.this.cBt != null ? C5741c.this.cBt.afr() : super.onSingleTapUp(motionEvent);
        }
    }

    /* renamed from: com.introvd.template.editor.clipedit.ratioadjust.c$b */
    public static class C5745b implements C5746c {
        /* renamed from: A */
        public void mo28005A(float f, float f2) {
        }

        public void afq() {
        }

        public boolean afr() {
            return false;
        }

        /* renamed from: an */
        public void mo28008an(float f) {
        }

        /* renamed from: co */
        public boolean mo28009co(int i, int i2) {
            return true;
        }

        /* renamed from: lm */
        public void mo28010lm(int i) {
        }

        /* renamed from: ln */
        public void mo28011ln(int i) {
        }
    }

    /* renamed from: com.introvd.template.editor.clipedit.ratioadjust.c$c */
    public interface C5746c {
        /* renamed from: A */
        void mo28005A(float f, float f2);

        void afq();

        boolean afr();

        /* renamed from: an */
        void mo28008an(float f);

        /* renamed from: co */
        boolean mo28009co(int i, int i2);

        /* renamed from: lm */
        void mo28010lm(int i);

        /* renamed from: ln */
        void mo28011ln(int i);
    }

    public C5741c(View view) {
        this.cBo = view;
    }

    /* renamed from: D */
    private float m15961D(MotionEvent motionEvent) {
        try {
            return (float) Math.toDegrees(Math.atan2((double) (motionEvent.getY(1) - motionEvent.getY(0)), (double) (motionEvent.getX(1) - motionEvent.getX(0))));
        } catch (IllegalArgumentException unused) {
            return 0.0f;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean m15966o(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0 && this.cBt != null) {
            this.cBt.afq();
            if (motionEvent.getPointerCount() == 1) {
                this.cBu = this.cBt.mo28009co((int) motionEvent.getX(), (int) motionEvent.getY());
            } else if (motionEvent.getPointerCount() == 2) {
                this.cBu = this.cBt.mo28009co((int) motionEvent.getX(), (int) motionEvent.getY()) || this.cBt.mo28009co((int) motionEvent.getX(), (int) motionEvent.getY());
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
                    float D = m15961D(motionEvent) - this.cBs;
                    StringBuilder sb = new StringBuilder();
                    sb.append("rotation change:");
                    sb.append(D);
                    LogUtilsV2.m14230i(sb.toString());
                    if (this.cBt != null) {
                        this.cBt.mo28010lm((int) D);
                        break;
                    }
                }
                break;
            case 5:
                this.cBs = m15961D(motionEvent);
                if (!this.cBr) {
                    this.cBq = true;
                    break;
                }
                break;
            case 6:
                if (this.cBt != null) {
                    float D2 = m15961D(motionEvent) - this.cBs;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("rotation end:");
                    sb2.append(D2);
                    LogUtilsV2.m14230i(sb2.toString());
                    if (this.cBt != null) {
                        this.cBt.mo28011ln((int) D2);
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
    public void mo27995a(C5746c cVar) {
        this.cBt = cVar;
    }

    public void adc() {
        this.cBo.setOnTouchListener(this.bWl);
        this.aML = new GestureDetector(this.cBo.getContext(), new C5744a());
        this.cBp = new ScaleGestureDetector(this.cBo.getContext(), this.cBv);
    }
}
