package com.introvd.template.camera.p229b;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.camera.base.AbstractCameraView.C5021a;
import com.introvd.template.camera.base.CameraNewViewBase;
import com.introvd.template.camera.p229b.C4989b.C4990a;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.camera.p232e.C5041h;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.MSize;
import com.introvd.template.explorer.music.XYMusicFragment;
import com.introvd.template.explorer.p297b.C7140b;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.vivacamera.R;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.p131c.p132a.p135c.C2585b;
import java.lang.ref.WeakReference;
import xiaoying.engine.clip.QEffect;

/* renamed from: com.introvd.template.camera.b.k */
public class C5011k {
    /* access modifiers changed from: private */
    public Handler bLS;
    private C5530d bNb;
    /* access modifiers changed from: private */
    public boolean bOI = true;
    private RelativeLayout bRc;
    private RelativeLayout bRd;
    private C5021a bRe = new C5021a() {
        /* renamed from: iG */
        public void mo25709iG(int i) {
            int[] A = C4989b.m12745A(((C4990a) C4989b.m12746iP(C5008i.m12937VU().mo25609VV()).get(i)).bPb, C5011k.this.bOI);
            C5011k.this.bLS.sendMessage(C5011k.this.bLS.obtainMessage(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE, A[0], A[1]));
        }
    };
    private CameraNewViewBase bRg;
    private RelativeLayout bRh = null;
    /* access modifiers changed from: private */
    public C2585b bRi;
    private XYMusicFragment bRj;
    private WeakReference<Activity> bwg;

    public C5011k(Activity activity, C5530d dVar) {
        this.bNb = dVar;
        this.bwg = new WeakReference<>(activity);
        this.bRc = (RelativeLayout) activity.findViewById(R.id.camera_view_layout);
        this.bRi = new C2585b(activity);
        this.bRi.mo12858dZ(activity.getResources().getColor(R.color.black), IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED);
        m13022Wr();
    }

    /* renamed from: Wr */
    private void m13022Wr() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.bRd = (RelativeLayout) activity.findViewById(R.id.guideline_layout);
        }
    }

    /* renamed from: Wy */
    private void m13023Wy() {
        final Activity activity = (Activity) this.bwg.get();
        if (activity != null && !activity.isFinishing()) {
            if (this.bRj == null) {
                this.bRj = (XYMusicFragment) C1919a.m5529sc().mo10355al(MusicParams.URL).mo10412rX();
                this.bRj.mo31826a((C7140b) new C7140b() {
                    /* renamed from: WC */
                    public void mo25762WC() {
                        C5011k.this.bRi.mo12858dZ(activity.getResources().getColor(R.color.black), IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED);
                    }

                    /* renamed from: c */
                    public void mo25763c(MusicDataItem musicDataItem) {
                        C5011k.this.bLS.sendMessage(C5011k.this.bLS.obtainMessage(QEffect.PROP_AUDIO_FRAME_ADJUST_DB, musicDataItem));
                        C5011k.this.mo25731b(musicDataItem);
                        C5008i.m12937VU().mo25645cU(false);
                    }

                    /* renamed from: cZ */
                    public void mo25764cZ(boolean z) {
                    }
                });
                ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).add(R.id.music_container, (Fragment) this.bRj).commitAllowingStateLoss();
            } else {
                ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).show(this.bRj).commitAllowingStateLoss();
            }
            this.bLS.postDelayed(new Runnable() {
                public void run() {
                    C5011k.this.bRi.mo12857dY(activity.getResources().getColor(R.color.color_6d6d6d), 0);
                }
            }, 300);
        }
    }

    /* renamed from: Wz */
    private void m13024Wz() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            if (this.bRj != null) {
                ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).hide(this.bRj).commitAllowingStateLoss();
            }
            this.bRi.mo12858dZ(activity.getResources().getColor(R.color.black), IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED);
        }
    }

    /* renamed from: SY */
    public void mo25710SY() {
        this.bRg.mo25791SY();
    }

    /* renamed from: Uj */
    public void mo25711Uj() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_grid", "off");
        if (this.bRd != null) {
            if ("on".equals(appSettingStr)) {
                this.bRd.setVisibility(0);
            } else {
                this.bRd.setVisibility(8);
            }
        }
        this.bRg.mo25793Uj();
    }

    /* renamed from: Uk */
    public void mo25712Uk() {
        this.bRg.mo25794Uk();
    }

    /* renamed from: Ul */
    public boolean mo25713Ul() {
        return this.bRg.mo25795Ul();
    }

    /* renamed from: Um */
    public void mo25714Um() {
        C5031c.m13217am((Context) this.bwg.get(), "screen");
        this.bRg.mo25796Um();
    }

    /* renamed from: Un */
    public void mo25715Un() {
        this.bRg.mo25797Un();
    }

    /* renamed from: Uo */
    public void mo25716Uo() {
        this.bRg.mo25798Uo();
    }

    /* renamed from: Uq */
    public boolean mo25717Uq() {
        if (this.bOI) {
            return this.bRg.mo25800Uq();
        }
        return false;
    }

    /* renamed from: WA */
    public void mo25718WA() {
        this.bRg.mo25833Uw();
    }

    /* renamed from: WB */
    public void mo25719WB() {
        if (this.bRg != null) {
            this.bRg.mo25831Uu();
        }
    }

    /* renamed from: Wn */
    public boolean mo25720Wn() {
        return this.bRj != null && this.bRj.isVisible();
    }

    /* renamed from: Ws */
    public boolean mo25721Ws() {
        return this.bRh != null && this.bRh.getVisibility() == 0;
    }

    /* renamed from: Wt */
    public void mo25722Wt() {
        if (this.bRh != null) {
            this.bRh.setVisibility(8);
        }
    }

    /* renamed from: Wv */
    public boolean mo25723Wv() {
        return this.bRg != null;
    }

    /* renamed from: Ww */
    public void mo25724Ww() {
        this.bRg.mo25830Ut();
    }

    /* renamed from: Wx */
    public void mo25725Wx() {
        if (this.bRg != null) {
            this.bRg.mo25832Uv();
        }
    }

    /* renamed from: a */
    public void mo25726a(CameraNewViewBase cameraNewViewBase) {
        if (((Activity) this.bwg.get()) != null && this.bRg == null) {
            this.bRg = cameraNewViewBase;
            this.bRc.addView(this.bRg);
            this.bRg.setmModeChooseListener(this.bRe);
        }
    }

    /* renamed from: a */
    public void mo25727a(Long l, int i) {
        this.bRg.mo25801a(l, i);
    }

    /* renamed from: a */
    public void mo25728a(boolean z, String str, String str2) {
        this.bRg.mo25835a(z, str, str2, false);
    }

    /* renamed from: aj */
    public void mo25729aj(long j) {
        if (this.bRg != null) {
            this.bRg.mo25836af(j);
        }
    }

    /* renamed from: b */
    public void mo25730b(RelativeLayout relativeLayout) {
        this.bRg.mo25802b(relativeLayout);
    }

    /* renamed from: b */
    public void mo25731b(MusicDataItem musicDataItem) {
        this.bRg.mo25803b(musicDataItem);
    }

    /* renamed from: cW */
    public void mo25732cW(boolean z) {
        this.bRg.mo25829Us();
    }

    /* renamed from: cX */
    public void mo25733cX(boolean z) {
        C5008i.m12937VU().mo25645cU(z);
        if (z) {
            m13023Wy();
            this.bRg.mo25799Up();
            return;
        }
        m13024Wz();
    }

    /* renamed from: cY */
    public void mo25734cY(boolean z) {
        if (this.bRg != null) {
            this.bRg.mo25838cn(z);
        }
    }

    /* renamed from: ca */
    public void mo25735ca(int i, int i2) {
        if (this.bRg != null) {
            this.bRg.mo25837bT(i, i2);
        }
    }

    /* renamed from: cm */
    public void mo25736cm(boolean z) {
        this.bRg.mo25805cm(z);
    }

    /* renamed from: co */
    public void mo25737co(boolean z) {
        if (this.bRg != null) {
            this.bRg.mo25839co(z);
        }
    }

    /* renamed from: d */
    public void mo25738d(TemplateInfo templateInfo) {
        if (this.bRg != null) {
            this.bRg.mo25834a(templateInfo, -1);
        }
    }

    /* renamed from: eX */
    public void mo25739eX(String str) {
        if (this.bRg != null) {
            this.bRg.mo25841eR(str);
        }
    }

    /* renamed from: g */
    public void mo25740g(C4999g gVar) {
        this.bRg.setCameraMusicMgr(gVar);
    }

    /* renamed from: g */
    public void mo25741g(boolean z, String str) {
        this.bRg.mo25840eQ(str);
    }

    public View getTopIndicatorView() {
        if (this.bRg != null) {
            return this.bRg.getTopIndicatorView();
        }
        return null;
    }

    /* renamed from: iF */
    public void mo25743iF(int i) {
        this.bRg.mo25808iF(i);
    }

    /* renamed from: iH */
    public void mo25744iH(int i) {
        this.bRg.mo25842iH(i);
    }

    /* renamed from: jo */
    public void mo25745jo(int i) {
        if (((Activity) this.bwg.get()) != null) {
            this.bOI = i == 256;
            this.bRg.setVisibility(0);
        }
    }

    /* renamed from: jq */
    public void mo25746jq(int i) {
        if (this.bRg != null) {
            this.bRg.setCameraViewRatio(i);
        }
    }

    public void onDestroy() {
        this.bRg.onDestroy();
    }

    public void onPause() {
        this.bRg.onPause();
    }

    public void onResume() {
        this.bRg.onResume();
    }

    /* renamed from: p */
    public boolean mo25750p(MotionEvent motionEvent) {
        return this.bRg.mo25812p(motionEvent);
    }

    public void setCallbackHandler(Handler handler) {
        this.bLS = handler;
        this.bRg.setCallbackHandler(handler);
    }

    public void setCameraMode(int i, int i2, boolean z, boolean z2) {
        C5008i.m12937VU().mo25653jh(i);
        C5008i.m12937VU().mo25654ji(i2);
        this.bRg.setCameraMode(i, i2, z, z2);
    }

    public void setClipCount(int i, boolean z) {
        C5008i.m12937VU().mo25655jj(i);
        this.bRg.setClipCount(i, z);
    }

    public void setCurrentTimeValue(long j) {
        this.bRg.setCurrentTimeValue(j);
    }

    public synchronized void setEffect(int i, boolean z, boolean z2, boolean z3) {
        this.bRg.setEffect(i, z, z2, z3);
    }

    public void setEffectMgr(C8759b bVar) {
        this.bRg.setEffectMgr(bVar);
    }

    public void setMusicViewEnable(boolean z) {
        this.bRg.setMusicViewEnable(z);
    }

    public void setSoundPlayer(C5041h hVar) {
        this.bRg.setSoundPlayer(hVar);
    }

    public void setState(int i, MSize mSize) {
        C5008i.m12937VU().setState(i);
        this.bRg.setState(i, mSize);
    }

    public void setTimeExceed(boolean z) {
        this.bRg.setTimeExceed(z);
    }

    public void setZoomValue(double d) {
        this.bRg.setZoomValue(d);
    }
}
