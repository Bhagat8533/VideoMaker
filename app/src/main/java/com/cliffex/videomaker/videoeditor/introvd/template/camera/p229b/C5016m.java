package com.introvd.template.camera.p229b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.camera.p232e.C5041h;
import com.introvd.template.camera.p233ui.view.indicator.FocusIndicatorView;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.vivacamera.R;
import com.mediarecorder.engine.QPIPFrameParam;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import xiaoying.utils.QPoint;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.camera.b.m */
public class C5016m {

    /* renamed from: bI */
    private boolean f3422bI;
    private C5041h bMf;
    private Parameters bPR;
    private boolean bRA = false;
    /* access modifiers changed from: private */
    public long bRB = 0;
    private int bRC = 0;
    private int bRD = 0;
    /* access modifiers changed from: private */
    public int bRE;
    /* access modifiers changed from: private */
    public QPIPFrameParam bRF;
    private int bRG = 1;
    private SensorEventListener bRH = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            synchronized (this) {
                if (System.currentTimeMillis() - C5016m.this.bRB >= 500) {
                    C5016m.this.bRB = System.currentTimeMillis();
                    float[] fArr = sensorEvent.values;
                    if (!C5016m.this.bRx) {
                        if (C5016m.this.bRt != -1.0f || C5016m.this.bRu != -1.0f || C5016m.this.bRv != -1.0f) {
                            float abs = Math.abs(C5016m.this.bRt - fArr[0]);
                            float abs2 = Math.abs(C5016m.this.bRu - fArr[1]);
                            float abs3 = Math.abs(C5016m.this.bRv - fArr[2]);
                            if (C5016m.this.m13091k(abs, abs2, abs3)) {
                                C5016m.this.bRy = true;
                                C5016m.this.bRz = false;
                                if (C5016m.this.mHandler != null) {
                                    C5016m.this.mHandler.removeMessages(1);
                                }
                            }
                            if (C5016m.this.m13092l(abs, abs2, abs3)) {
                                if (!C5016m.this.bRz) {
                                    C5016m.this.bRz = true;
                                    if (C5016m.this.mHandler != null) {
                                        C5016m.this.mHandler.removeMessages(1);
                                        C5016m.this.mHandler.sendEmptyMessage(1);
                                    }
                                } else {
                                    return;
                                }
                            }
                            C5016m.this.bRt = fArr[0];
                            C5016m.this.bRu = fArr[1];
                            C5016m.this.bRv = fArr[2];
                            return;
                        }
                    }
                    C5016m.this.bRt = fArr[0];
                    C5016m.this.bRu = fArr[1];
                    C5016m.this.bRv = fArr[2];
                }
            }
        }
    };
    private boolean bRl = true;
    private FocusIndicatorView bRm;
    private View bRn;
    private List<Area> bRo;
    private List<Area> bRp;
    private String bRq;
    private C5018a bRr;
    private SensorManager bRs;
    /* access modifiers changed from: private */
    public float bRt = -1.0f;
    /* access modifiers changed from: private */
    public float bRu = -1.0f;
    /* access modifiers changed from: private */
    public float bRv = -1.0f;
    private Sensor bRw = null;
    /* access modifiers changed from: private */
    public boolean bRx = false;
    /* access modifiers changed from: private */
    public boolean bRy = false;
    /* access modifiers changed from: private */
    public boolean bRz = true;
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new C5019b(this);
    private Matrix mMatrix = new Matrix();

    /* renamed from: com.introvd.template.camera.b.m$a */
    public interface C5018a {
        /* renamed from: Tp */
        void mo24897Tp();

        /* renamed from: Tq */
        void mo24898Tq();
    }

    /* renamed from: com.introvd.template.camera.b.m$b */
    private static class C5019b extends Handler {
        private WeakReference<C5016m> bRJ;

        public C5019b(C5016m mVar) {
            this.bRJ = new WeakReference<>(mVar);
        }

        public void handleMessage(Message message) {
            C5016m mVar = (C5016m) this.bRJ.get();
            if (mVar != null) {
                int i = message.what;
                if (i != 4097) {
                    switch (i) {
                        case 0:
                            mVar.mo25770WE();
                            break;
                        case 1:
                            if (mVar.bRy) {
                                mVar.mo25770WE();
                                mVar.mo25768Tp();
                                mVar.bRy = false;
                                break;
                            }
                            break;
                    }
                } else {
                    mVar.mo25778b(mVar.bRE, mVar.bRF);
                }
            }
        }
    }

    public C5016m(String str) {
    }

    /* renamed from: WF */
    private boolean m13070WF() {
        boolean z = false;
        if (AppPreferencesSetting.getInstance().getAppSettingInt("pref_view_camera_id", 0) != 0) {
            return false;
        }
        String focusMode = getFocusMode();
        if (!TextUtils.isEmpty(focusMode) && (focusMode.equals("auto") || focusMode.equals("fixed") || focusMode.equals("edof") || focusMode.equals("macro"))) {
            z = true;
        }
        return z;
    }

    /* renamed from: WH */
    private void m13071WH() {
        this.bRs = (SensorManager) this.mContext.getSystemService("sensor");
        this.bRw = this.bRs.getDefaultSensor(1);
    }

    /* renamed from: a */
    private void m13074a(int i, int i2, float f, int i3, int i4, Rect rect) {
        int i5 = (int) (((float) i) * f);
        int i6 = (int) (((float) i2) * f);
        int clamp = C5034e.clamp(i3 - (i5 / 2), -1000, 1000);
        int clamp2 = C5034e.clamp(i4 - (i6 / 2), -1000, 1000);
        RectF rectF = new RectF((float) clamp, (float) clamp2, (float) (clamp + i5), (float) (clamp2 + i6));
        this.mMatrix.mapRect(rectF);
        C5034e.m13248a(rectF, rect);
    }

    private String getFocusMode() {
        if (this.bPR == null) {
            return "infinity";
        }
        if ("5860A".equals(Build.MODEL) || "vivo S3".equals(Build.MODEL)) {
            return "infinity";
        }
        this.bRq = this.bPR.getFocusMode();
        return this.bRq;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean m13091k(float f, float f2, float f3) {
        return f > 0.3f || f2 > 0.3f || f3 > 0.3f;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean m13092l(float f, float f2, float f3) {
        return f < 0.2f && f2 < 0.2f && f3 < 0.2f;
    }

    /* renamed from: Tp */
    public void mo25768Tp() {
        if (m13070WF()) {
            mo25774WK();
            this.bRr.mo24897Tp();
            mo25771WG();
            this.mHandler.removeMessages(0);
        }
    }

    /* renamed from: WD */
    public void mo25769WD() {
        if (this.bMf != null) {
            this.bMf.release();
            this.bMf = null;
        }
    }

    /* renamed from: WE */
    public void mo25770WE() {
        if (this.f3422bI) {
            if (CameraCodeMgr.isCameraParamPIP(C5008i.m12937VU().mo25610VW())) {
                LayoutParams layoutParams = (LayoutParams) this.bRm.getLayoutParams();
                layoutParams.getRules()[13] = 0;
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(this.bRC);
                } else {
                    layoutParams.leftMargin = this.bRC;
                }
                layoutParams.topMargin = this.bRD;
                this.bRm.setLayoutParams(layoutParams);
            } else {
                LayoutParams layoutParams2 = (LayoutParams) this.bRm.getLayoutParams();
                layoutParams2.getRules()[13] = -1;
                layoutParams2.setMargins(0, 0, 0, 0);
                this.bRm.setLayoutParams(layoutParams2);
            }
            this.bRo = null;
            this.bRp = null;
            this.bRm.invalidate();
        }
    }

    /* renamed from: WG */
    public void mo25771WG() {
        this.bRm.mo26229YB();
    }

    /* renamed from: WI */
    public void mo25772WI() {
        if (this.bRs != null && !this.bRA && this.bRw != null) {
            this.bRA = true;
            this.bRs.registerListener(this.bRH, this.bRw, 3);
        }
    }

    /* renamed from: WJ */
    public void mo25773WJ() {
        if (this.bRH != null && this.bRw != null && this.bRA) {
            this.bRA = false;
            this.bRs.unregisterListener(this.bRH);
            this.bRH = null;
            this.bRv = -1.0f;
            this.bRu = -1.0f;
            this.bRt = -1.0f;
        }
    }

    /* renamed from: WK */
    public void mo25774WK() {
        this.bRx = true;
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    /* renamed from: WL */
    public void mo25775WL() {
        this.bRx = false;
    }

    /* renamed from: a */
    public void mo25776a(Activity activity, View view, C5018a aVar, boolean z, int i) {
        this.bRm = (FocusIndicatorView) activity.findViewById(R.id.focus_indicator);
        this.bRn = view;
        this.bRr = aVar;
        Matrix matrix = new Matrix();
        C5034e.m13247a(matrix, z, i, view.getWidth(), view.getHeight());
        matrix.invert(this.mMatrix);
        if (this.bPR != null) {
            this.f3422bI = true;
        }
        this.mContext = (Context) aVar;
        m13071WH();
        mo25772WI();
    }

    /* renamed from: aa */
    public void mo25777aa(Activity activity) {
        this.bMf = new C5041h(activity.getResources());
    }

    /* renamed from: b */
    public void mo25778b(int i, QPIPFrameParam qPIPFrameParam) {
        this.bRE = i;
        if (i == 0 || 1 == i) {
            this.bRF = qPIPFrameParam;
            int width = ((RelativeLayout) this.bRm.getParent()).getWidth();
            int height = ((RelativeLayout) this.bRm.getParent()).getHeight();
            int width2 = this.bRm.getWidth();
            int height2 = this.bRm.getHeight();
            if ((width == 0 || height == 0 || width2 == 0 || height2 == 0) && this.bRG < 3) {
                if (this.mHandler == null) {
                    this.mHandler = new C5019b(this);
                }
                this.mHandler.sendEmptyMessageDelayed(4097, 500);
                this.bRG++;
                return;
            }
            this.bRG = 1;
            QPoint elementTipsLocation = qPIPFrameParam.getElementTipsLocation(i);
            QRect elementDisplayRegion = qPIPFrameParam.getElementDisplayRegion(i);
            if (!(elementDisplayRegion == null || elementTipsLocation == null)) {
                this.bRC = ((width * (elementDisplayRegion.left + (((elementDisplayRegion.right - elementDisplayRegion.left) * elementTipsLocation.f3733x) / 10000))) / 10000) - (width2 / 2);
                this.bRD = ((height * (elementDisplayRegion.top + (((elementDisplayRegion.bottom - elementDisplayRegion.top) * elementTipsLocation.f3734y) / 10000))) / 10000) - (height2 / 2);
            }
            LayoutParams layoutParams = (LayoutParams) this.bRm.getLayoutParams();
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.bRC);
            } else {
                layoutParams.leftMargin = this.bRC;
            }
            layoutParams.topMargin = this.bRD;
            this.bRm.setLayoutParams(layoutParams);
            this.bRm.invalidate();
        }
    }

    /* renamed from: c */
    public void mo25779c(Parameters parameters) {
        if (parameters != null) {
            this.bRq = parameters.getFocusMode();
            this.bPR = parameters;
        }
    }

    public void clearFocus() {
        if (this.bRm != null) {
            this.bRm.clearAnimation();
            mo25770WE();
            mo25784jr(4);
        }
    }

    /* renamed from: da */
    public void mo25781da(boolean z) {
        mo25775WL();
    }

    @TargetApi(14)
    public List<Area> getFocusAreas() {
        if (this.bRo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Area area : this.bRo) {
            Area area2 = new Area(area.rect, area.weight);
            if (area2.rect.top <= area2.rect.bottom) {
                arrayList.add(area2);
            }
        }
        return arrayList;
    }

    @TargetApi(14)
    public List<Area> getMeteringAreas() {
        if (this.bRp == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Area area : this.bRp) {
            Area area2 = new Area(area.rect, area.weight);
            if (area2.rect.top <= area2.rect.bottom) {
                arrayList.add(area2);
            }
        }
        return arrayList;
    }

    /* renamed from: jr */
    public void mo25784jr(int i) {
        if (this.bRm != null) {
            this.bRm.setVisibility(i);
        }
    }

    /* renamed from: m */
    public void mo25785m(Boolean bool) {
        mo25784jr(0);
        this.bRm.mo26230YC();
    }

    /* renamed from: n */
    public void mo25786n(Boolean bool) {
        mo25784jr(0);
        this.bRm.mo26231YD();
    }

    /* renamed from: q */
    public boolean mo25787q(MotionEvent motionEvent) {
        if (!this.f3422bI || !m13070WF()) {
            return false;
        }
        int round = Math.round(motionEvent.getX());
        int round2 = Math.round(motionEvent.getY());
        int width = this.bRm.getWidth();
        int height = this.bRm.getHeight();
        int width2 = this.bRn.getWidth();
        int height2 = this.bRn.getHeight();
        int[] iArr = new int[2];
        this.bRn.getLocationOnScreen(iArr);
        if (this.bRo == null) {
            this.bRo = new ArrayList();
            this.bRo.add(new Area(new Rect(), 800));
            this.bRp = new ArrayList();
            this.bRp.add(new Area(new Rect(), 800));
        }
        int i = width;
        int i2 = height;
        int i3 = round;
        int i4 = round2;
        m13074a(i, i2, 1.0f, i3, i4, ((Area) this.bRo.get(0)).rect);
        m13074a(i, i2, 1.5f, i3, i4, ((Area) this.bRp.get(0)).rect);
        LayoutParams layoutParams = (LayoutParams) this.bRm.getLayoutParams();
        int clamp = C5034e.clamp(round - (width / 2), iArr[0], (iArr[0] + width2) - width);
        int clamp2 = C5034e.clamp((round2 - iArr[1]) - (height / 2), 0, height2 - height);
        if (C4580b.m11666qi()) {
            int i5 = (width2 - width) - clamp;
            layoutParams.setMargins(i5, clamp2, 0, 0);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(i5);
            }
        } else {
            layoutParams.setMargins(clamp, clamp2, 0, 0);
        }
        layoutParams.getRules()[13] = 0;
        this.bRm.setLayoutParams(layoutParams);
        this.bRm.invalidate();
        this.bRr.mo24898Tq();
        mo25768Tp();
        return true;
    }
}
