package com.introvd.template.editor.p246c;

import android.graphics.Point;
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

/* renamed from: com.introvd.template.editor.c.c */
public class C5689c {
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
            LogUtils.m14223i("FineTuningManager", sb.toString());
            if (motionEvent.getAction() == 0) {
                C5689c.this.cRS = C5689c.this.cRO != null && C5689c.this.cRO.aet();
            }
            if (!C5689c.this.cRS) {
                if (C5689c.this.cRO != null && motionEvent.getAction() == 0) {
                    C5689c.this.cRO.aeu();
                }
                C5689c.this.cRR.onTouchEvent(motionEvent);
                return true;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (C5689c.this.cRO != null) {
                        C5689c.this.cRO.aeu();
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (C5689c.this.bGP) {
                        C5689c.this.bGP = false;
                        if (C5689c.this.cRO != null) {
                            C5689c.this.cRO.aew();
                        }
                        if (C5689c.this.cRN != null) {
                            C5689c.this.cRN.setVisibility(4);
                            break;
                        }
                    }
                    break;
            }
            C5689c.this.cRR.onTouchEvent(motionEvent);
            return true;
        }
    };
    private View cRM;
    /* access modifiers changed from: private */
    public RelativeLayout cRN;
    /* access modifiers changed from: private */
    public C5688b cRO;
    private C5692a cRP = new C5692a();
    /* access modifiers changed from: private */
    public boolean cRQ = false;
    /* access modifiers changed from: private */
    public GestureDetector cRR;
    /* access modifiers changed from: private */
    public boolean cRS = true;
    private C5687a cyo = new C5687a() {
        /* renamed from: fS */
        public void mo27875fS(boolean z) {
            C5689c.this.mo27879fT(z);
        }
    };

    /* renamed from: com.introvd.template.editor.c.c$a */
    public class C5692a extends SimpleOnGestureListener {
        private int bGW = 0;

        public C5692a() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            StringBuilder sb = new StringBuilder();
            sb.append("onScroll distanceX=");
            sb.append(f);
            sb.append(";distanceY=");
            sb.append(f2);
            sb.append(";e1=");
            sb.append(motionEvent.getX());
            sb.append(";e2=");
            sb.append(motionEvent2.getX());
            LogUtils.m14223i("FineTuningManager", sb.toString());
            if (!C5689c.this.cRS) {
                return true;
            }
            if (!C5689c.this.bGP) {
                C5689c.this.bGP = true;
                if (C5689c.this.cRO != null) {
                    this.bGW = C5689c.this.cRO.aev();
                }
                if (C5689c.this.cRN != null) {
                    C5689c.this.cRN.setVisibility(0);
                }
            }
            if (C5689c.this.bGP) {
                float x = motionEvent2.getX() - motionEvent.getX();
                if (C5689c.this.cRQ) {
                    x = -x;
                }
                int access$500 = this.bGW + ((int) ((((float) C5689c.bGq) * x) / ((float) C5689c.bGr)));
                if (C5689c.this.cRO != null) {
                    access$500 = C5689c.this.cRO.mo27804hV(access$500);
                }
                int i = access$500 - this.bGW;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("--->onScroll curTime =");
                sb2.append(access$500);
                LogUtils.m14222e("FineTuningManager", sb2.toString());
                C5689c.this.m15696bL(i, access$500);
                if (C5689c.this.cRO != null) {
                    C5689c.this.cRO.mo27805lb(access$500);
                }
            }
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (C5689c.this.cRO == null) {
                return false;
            }
            return C5689c.this.cRO.mo27799a(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
        }
    }

    public C5689c(View view, RelativeLayout relativeLayout) {
        this.cRM = view;
        this.cRN = relativeLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: bL */
    public void m15696bL(int i, int i2) {
        TextView textView = (TextView) this.cRN.findViewById(R.id.xiaoying_txtview_actual_time);
        ((TextView) this.cRN.findViewById(R.id.xiaoying_txtview_relative_timespan)).setText(String.format("%1$+01.1f", new Object[]{Float.valueOf(((float) i) / 1000.0f)}));
        textView.setText(C4580b.m11665ih(i2));
    }

    /* renamed from: a */
    public void mo27876a(C5688b bVar) {
        this.cRO = bVar;
        if (bVar != null) {
            this.cRO.mo27798a(this.cyo);
        }
    }

    public void adc() {
        if (this.cRM != null) {
            this.cRM.setOnTouchListener(this.bWl);
            this.cRR = new GestureDetector(this.cRM.getContext(), this.cRP);
        }
        if (Constants.getScreenSize() != null) {
            bGr = Constants.getScreenSize().width;
        }
    }

    public C5687a aml() {
        return this.cyo;
    }

    /* renamed from: fT */
    public void mo27879fT(boolean z) {
        this.cRQ = z;
    }
}
