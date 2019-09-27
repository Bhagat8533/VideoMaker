package com.introvd.template.camera.p232e;

import android.os.Handler;
import android.text.TextPaint;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.introvd.template.p414ui.view.RotateTextView;

/* renamed from: com.introvd.template.camera.e.f */
public class C5036f {
    private static int cbA = 0;
    private static RotateTextView cbB = null;
    private static LayoutParams cbC = new LayoutParams();
    private static WindowManager cbD = null;
    private static boolean cbE = false;
    private static final Runnable cbF = new Runnable() {
        public void run() {
            C5036f.m13268qg();
        }
    };
    private static final Runnable cbG = new Runnable() {
        public void run() {
            C5036f.m13269qh();
        }
    };
    private static boolean cbu = false;
    private static int cbv = 0;
    private static int cbw = 0;
    private static int cbx = 0;
    private static int cby = 0;
    private static String cbz = "";
    private static int mDuration = 2000;
    private static final Handler mHandler = new Handler();

    public static void hide() {
        if (cbE) {
            mHandler.removeCallbacks(cbG);
            mHandler.post(cbG);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: qg */
    public static synchronized void m13268qg() {
        synchronized (C5036f.class) {
            if (!(cbD == null || cbB == null || cbC == null || cbB.getParent() != null)) {
                cbE = true;
                cbD.addView(cbB, cbC);
            }
            mHandler.postDelayed(cbG, (long) mDuration);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: qh */
    public static synchronized void m13269qh() {
        synchronized (C5036f.class) {
            if (!(cbB == null || cbB.getParent() == null)) {
                cbD.removeView(cbB);
                cbE = false;
            }
        }
    }

    public static void setDegree(int i) {
        if (cbE) {
            m13269qh();
            update(i);
            m13268qg();
        }
    }

    public static void update(int i) {
        cbA = i;
        if (cbB != null && cbC != null) {
            cbB.setDegree(cbA);
            TextPaint paint = cbB.getPaint();
            int i2 = ((int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent)) + (cby * 2);
            int measureText = ((int) paint.measureText(cbz)) + (cby * 2);
            if (i == 0) {
                cbB.setWidth(measureText);
                cbB.setHeight(i2);
                cbC.gravity = 49;
                cbC.x = 0;
                cbC.y = cbv + cbx;
            } else if (i == 90) {
                cbB.setWidth(i2);
                cbB.setHeight(measureText);
                cbC.gravity = 19;
                cbC.x = cbx;
                cbC.y = 0;
            } else if (i == 180) {
                cbB.setWidth(measureText);
                cbB.setHeight(i2);
                cbC.gravity = 81;
                cbC.x = 0;
                cbC.y = cbw + cbx;
            } else if (i == 270) {
                cbB.setWidth(i2);
                cbB.setHeight(measureText);
                cbC.gravity = 21;
                cbC.x = cbx;
                cbC.y = 0;
            }
        }
    }
}
