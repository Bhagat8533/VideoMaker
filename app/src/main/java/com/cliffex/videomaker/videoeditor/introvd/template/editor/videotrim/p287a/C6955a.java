package com.introvd.template.editor.videotrim.p287a;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4580b;

/* renamed from: com.introvd.template.editor.videotrim.a.a */
public class C6955a {
    /* access modifiers changed from: private */
    public static int bGq = 2000;
    /* access modifiers changed from: private */
    public static int bGr = 480;
    /* access modifiers changed from: private */
    public boolean bGP = false;
    private OnTouchListener bWl = new OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTouch event.getAction()=");
            sb.append(motionEvent.getAction());
            LogUtils.m14223i("FineTunningManager", sb.toString());
            if (motionEvent.getAction() == 0) {
                C6955a.this.cRS = C6955a.this.dlW != null && C6955a.this.dlW.atC();
            }
            if (!C6955a.this.cRS) {
                if (C6955a.this.dlW != null && motionEvent.getAction() == 0) {
                    C6955a.this.dlW.atB();
                }
                C6955a.this.cRR.onTouchEvent(motionEvent);
                return true;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (C6955a.this.dlW != null) {
                        C6955a.this.dlW.atB();
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (C6955a.this.bGP) {
                        C6955a.this.bGP = false;
                        if (C6955a.this.dlW != null) {
                            C6955a.this.dlW.atz();
                        }
                        if (C6955a.this.cRN != null) {
                            C6955a.this.cRN.setVisibility(4);
                            break;
                        }
                    }
                    break;
            }
            C6955a.this.cRR.onTouchEvent(motionEvent);
            return true;
        }
    };
    private View cRM;
    /* access modifiers changed from: private */
    public RelativeLayout cRN;
    /* access modifiers changed from: private */
    public boolean cRQ = false;
    /* access modifiers changed from: private */
    public GestureDetector cRR;
    /* access modifiers changed from: private */
    public boolean cRS = true;
    /* access modifiers changed from: private */
    public C6958b dlW;
    private C6957a dmS = new C6957a();

    /* renamed from: com.introvd.template.editor.videotrim.a.a$a */
    public class C6957a extends SimpleOnGestureListener {
        private int bGW = 0;

        public C6957a() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent == null || motionEvent2 == null) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onScroll distanceX=");
            sb.append(f);
            sb.append(";distanceY=");
            sb.append(f2);
            sb.append(";e1=");
            sb.append(motionEvent.getX());
            sb.append(";e2=");
            sb.append(motionEvent2.getX());
            LogUtils.m14223i("FineTunningManager", sb.toString());
            if (!C6955a.this.cRS) {
                return true;
            }
            if (!C6955a.this.bGP) {
                C6955a.this.bGP = true;
                if (C6955a.this.dlW != null) {
                    this.bGW = C6955a.this.dlW.atA();
                }
                if (C6955a.this.cRN != null) {
                    C6955a.this.cRN.setVisibility(0);
                }
            }
            if (C6955a.this.bGP) {
                float x = motionEvent2.getX() - motionEvent.getX();
                if (C6955a.this.cRQ) {
                    x = -x;
                }
                int access$500 = this.bGW + ((int) ((((float) C6955a.bGq) * x) / ((float) C6955a.bGr)));
                if (C6955a.this.dlW != null) {
                    access$500 = C6955a.this.dlW.mo30605hV(access$500);
                }
                int i = access$500 - this.bGW;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onScroll curTime =");
                sb2.append(access$500);
                LogUtils.m14223i("FineTunningManager", sb2.toString());
                C6955a.this.m20317bL(i, access$500);
                if (C6955a.this.dlW != null) {
                    C6955a.this.dlW.mo30606pE(access$500);
                }
            }
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (C6955a.this.dlW == null || !(C6955a.this.dlW instanceof C6959c)) {
                return false;
            }
            return ((C6959c) C6955a.this.dlW).mo30621x(motionEvent);
        }
    }

    public C6955a(View view, RelativeLayout relativeLayout) {
        this.cRM = view;
        this.cRN = relativeLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: bL */
    public void m20317bL(int i, int i2) {
        TextView textView = (TextView) this.cRN.findViewById(R.id.xiaoying_txtview_actual_time);
        ((TextView) this.cRN.findViewById(R.id.xiaoying_txtview_relative_timespan)).setText(String.format("%1$+01.1f", new Object[]{Float.valueOf(((float) i) / 1000.0f)}));
        textView.setText(C4580b.m11665ih(i2));
    }

    /* renamed from: a */
    public void mo30616a(C6958b bVar) {
        this.dlW = bVar;
    }

    public void adc() {
        if (this.cRM != null) {
            this.cRM.setOnTouchListener(this.bWl);
            this.cRR = new GestureDetector(this.cRM.getContext(), this.dmS);
        }
        bGr = Constants.getScreenSize().width;
    }
}
