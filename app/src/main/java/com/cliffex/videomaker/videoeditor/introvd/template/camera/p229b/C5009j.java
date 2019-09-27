package com.introvd.template.camera.p229b;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.introvd.template.camera.base.AbstractCameraView.C5021a;
import com.introvd.template.camera.base.CameraViewBase;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.camera.p232e.C5041h;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.vivacamera.R;
import com.mediarecorder.engine.QPIPFrameParam;
import java.lang.ref.WeakReference;
import xiaoying.engine.clip.QEffect;

/* renamed from: com.introvd.template.camera.b.j */
public class C5009j {
    /* access modifiers changed from: private */
    public Handler bLS;
    private C5530d bNb;
    /* access modifiers changed from: private */
    public boolean bOI = true;
    private CameraViewBase bQZ;
    private CameraViewBase bRa;
    private CameraViewBase bRb;
    private RelativeLayout bRc;
    private RelativeLayout bRd;
    private C5021a bRe = new C5021a() {
        /* renamed from: iG */
        public void mo25709iG(int i) {
            int[] z = C4989b.m12747z(i, C5009j.this.bOI);
            C5009j.this.bLS.sendMessage(C5009j.this.bLS.obtainMessage(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE, z[0], z[1]));
        }
    };
    private WeakReference<Activity> bwg;

    public C5009j(Activity activity, C5530d dVar) {
        this.bNb = dVar;
        this.bwg = new WeakReference<>(activity);
        this.bRc = (RelativeLayout) activity.findViewById(R.id.camera_view_layout);
        m12985Wr();
    }

    /* renamed from: Wr */
    private void m12985Wr() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.bRd = (RelativeLayout) activity.findViewById(R.id.guideline_layout);
        }
    }

    /* renamed from: SY */
    public void mo25663SY() {
        this.bQZ.mo25791SY();
    }

    /* renamed from: Tr */
    public void mo25664Tr() {
        this.bQZ.mo25846Tr();
    }

    /* renamed from: Ts */
    public void mo25665Ts() {
        this.bQZ.mo25792Ts();
    }

    /* renamed from: UA */
    public void mo25666UA() {
        this.bQZ.mo25847UA();
    }

    /* renamed from: UB */
    public void mo25667UB() {
        this.bQZ.mo25848UB();
    }

    /* renamed from: UC */
    public void mo25668UC() {
        this.bQZ.mo25849UC();
    }

    /* renamed from: UD */
    public void mo25669UD() {
        this.bQZ.mo25850UD();
    }

    /* renamed from: Uj */
    public void mo25670Uj() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_grid", "off");
        if (this.bRd != null) {
            if ("on".equals(appSettingStr)) {
                this.bRd.setVisibility(0);
            } else {
                this.bRd.setVisibility(4);
            }
        }
        this.bQZ.mo25793Uj();
    }

    /* renamed from: Uk */
    public void mo25671Uk() {
        this.bQZ.mo25794Uk();
    }

    /* renamed from: Ul */
    public boolean mo25672Ul() {
        return this.bQZ.mo25795Ul();
    }

    /* renamed from: Um */
    public void mo25673Um() {
        C5031c.m13217am((Context) this.bwg.get(), "screen");
        this.bQZ.mo25796Um();
    }

    /* renamed from: Un */
    public void mo25674Un() {
        this.bQZ.mo25797Un();
    }

    /* renamed from: Uo */
    public void mo25675Uo() {
        this.bQZ.mo25798Uo();
    }

    /* renamed from: Uq */
    public boolean mo25676Uq() {
        return this.bOI ? this.bRa.mo25800Uq() : this.bRb.mo25800Uq();
    }

    /* renamed from: Ux */
    public void mo25677Ux() {
        this.bQZ.mo25854Ux();
    }

    /* renamed from: Uy */
    public void mo25678Uy() {
        this.bQZ.mo25855Uy();
    }

    /* renamed from: Uz */
    public void mo25679Uz() {
        this.bQZ.mo25856Uz();
    }

    /* renamed from: Ws */
    public boolean mo25680Ws() {
        return false;
    }

    /* renamed from: Wt */
    public void mo25681Wt() {
    }

    /* renamed from: Wu */
    public void mo25682Wu() {
        this.bQZ.mo25805cm(false);
    }

    /* renamed from: a */
    public void mo25683a(int i, CameraViewBase cameraViewBase) {
        if (((Activity) this.bwg.get()) != null) {
            if (i == 256) {
                if (this.bRa == null) {
                    this.bRa = cameraViewBase;
                    this.bRc.addView(this.bRa);
                    this.bRa.setmModeChooseListener(this.bRe);
                }
            } else if (this.bRb == null) {
                this.bRb = cameraViewBase;
                this.bRb.setmModeChooseListener(this.bRe);
                this.bRc.addView(this.bRb);
            }
        }
    }

    /* renamed from: a */
    public void mo25684a(int i, QPIPFrameParam qPIPFrameParam) {
        this.bQZ.mo25857a(i, qPIPFrameParam);
    }

    /* renamed from: a */
    public void mo25685a(Long l, int i) {
        this.bQZ.mo25801a(l, i);
    }

    /* renamed from: b */
    public synchronized void mo25686b(int i, boolean z, boolean z2) {
        this.bQZ.setEffect(i, z, z2, false);
    }

    /* renamed from: b */
    public void mo25687b(RelativeLayout relativeLayout) {
        this.bQZ.mo25802b(relativeLayout);
    }

    /* renamed from: bU */
    public void mo25688bU(int i, int i2) {
        this.bQZ.mo25859bU(i, i2);
    }

    /* renamed from: bZ */
    public void mo25689bZ(int i, int i2) {
        C5008i.m12937VU().mo25653jh(i);
        C5008i.m12937VU().mo25654ji(i2);
        if (CameraCodeMgr.isCameraParamPIP(i2)) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_grid", "off");
        }
        this.bQZ.setCameraMode(i, i2, false);
    }

    /* renamed from: cp */
    public void mo25690cp(boolean z) {
        this.bQZ.mo25861cp(z);
    }

    /* renamed from: cq */
    public void mo25691cq(boolean z) {
        this.bQZ.mo25862cq(z);
    }

    public View getTopIndicatorView() {
        if (this.bQZ != null) {
            return this.bQZ.getTopIndicatorView();
        }
        return null;
    }

    /* renamed from: jj */
    public void mo25693jj(int i) {
        C5008i.m12937VU().mo25655jj(i);
        this.bQZ.setClipCount(i, false);
    }

    /* renamed from: jo */
    public void mo25694jo(int i) {
        if (((Activity) this.bwg.get()) != null) {
            if (i == 256) {
                this.bOI = true;
                if (this.bRb != null) {
                    this.bRb.setVisibility(8);
                    this.bRb.mo25852UF();
                }
                this.bRa.setVisibility(0);
                this.bQZ = this.bRa;
                this.bRa.mo25855Uy();
            } else {
                this.bOI = false;
                if (this.bRa != null) {
                    this.bRa.setVisibility(8);
                    this.bRa.mo25852UF();
                }
                this.bRb.setVisibility(0);
                this.bQZ = this.bRb;
            }
        }
    }

    /* renamed from: jp */
    public boolean mo25695jp(int i) {
        boolean z = false;
        if (i == 256) {
            if (this.bRa != null) {
                z = true;
            }
            return z;
        }
        if (this.bRb != null) {
            z = true;
        }
        return z;
    }

    public void onDestroy() {
        this.bQZ.onDestroy();
    }

    public void onPause() {
        this.bQZ.onPause();
    }

    public void onResume() {
        this.bQZ.onResume();
    }

    /* renamed from: p */
    public boolean mo25699p(MotionEvent motionEvent) {
        return this.bQZ.mo25812p(motionEvent);
    }

    public void setCallbackHandler(Handler handler) {
        this.bLS = handler;
        this.bQZ.setCallbackHandler(handler);
    }

    public void setCurrentTimeValue(long j) {
        this.bQZ.setCurrentTimeValue(j);
    }

    public void setEffectMgr(C8759b bVar) {
        this.bQZ.setEffectMgr(bVar);
    }

    public synchronized void setPipEffect(int i, boolean z) {
        this.bQZ.setPipEffect(i, z);
    }

    public void setPipEffectMgr(C8759b bVar) {
        this.bQZ.setPipEffectMgr(bVar);
    }

    public void setSoundPlayer(C5041h hVar) {
        this.bQZ.setSoundPlayer(hVar);
    }

    public void setState(int i) {
        C5008i.m12937VU().setState(i);
        this.bQZ.setState(i, null);
    }

    public void setTimeExceed(boolean z) {
        this.bQZ.setTimeExceed(z);
    }

    public void setZoomValue(double d) {
        this.bQZ.setZoomValue(d);
    }
}
