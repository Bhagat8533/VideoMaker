package com.introvd.template.camera.p233ui.camview;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.introvd.template.camera.base.CameraActivityBase;
import com.introvd.template.camera.base.CameraViewBase;
import com.introvd.template.camera.p208a.C4664c;
import com.introvd.template.camera.p208a.C4665d;
import com.introvd.template.camera.p208a.C4666e;
import com.introvd.template.camera.p208a.C4668g;
import com.introvd.template.camera.p208a.C4669h;
import com.introvd.template.camera.p208a.C4670i;
import com.introvd.template.camera.p229b.C4989b.C4990a;
import com.introvd.template.camera.p229b.C5006h;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p229b.C5020n;
import com.introvd.template.camera.p230c.C5023a;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.camera.p233ui.p234a.C5051c;
import com.introvd.template.camera.p233ui.shutter.ShutterLayoutLan;
import com.introvd.template.camera.p233ui.view.PipSwapWidgetHor;
import com.introvd.template.camera.p233ui.view.TimerView;
import com.introvd.template.camera.p233ui.view.TimerView.C5178b;
import com.introvd.template.camera.p233ui.view.indicator.IndicatorBarLan;
import com.introvd.template.camera.p233ui.view.indicator.SettingIndicatorLan;
import com.introvd.template.camera.p233ui.view.indicator.TopIndicatorLan;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.SpeedUIManager;
import com.introvd.template.common.SpeedUIManager.SimpleSpeedChangeListener;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p414ui.view.RotateTextView;
import com.introvd.template.p414ui.view.TextSeekBar;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.sdk.p386e.C8411a.C8415b;
import com.introvd.template.sdk.p386e.C8411a.C8416c;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.vivacamera.R;
import com.introvd.template.xyui.C9136a;
import com.mediarecorder.engine.QPIPFrameParam;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QEffect;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.camera.ui.camview.CameraViewDefaultLan */
public class CameraViewDefaultLan extends CameraViewBase {
    /* access modifiers changed from: private */
    public C9136a bML;
    private RelativeLayout bMj;
    private int bOB = 0;
    private int bOy = 512;
    /* access modifiers changed from: private */
    public int bOz = 1;
    private C4669h bTB = new C4669h() {
        /* renamed from: UH */
        public void mo24983UH() {
            CameraViewDefaultLan.this.bUe.mo26273dA(false);
        }

        /* renamed from: UI */
        public void mo24984UI() {
            if (CameraViewDefaultLan.this.bLS != null) {
                CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(4097));
            }
        }

        /* renamed from: UJ */
        public void mo24985UJ() {
            if (CameraViewDefaultLan.this.bLS != null) {
                C5031c.m13216al(CameraViewDefaultLan.this.getContext().getApplicationContext(), "hold");
                CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(4098));
            }
        }

        /* renamed from: UK */
        public void mo24986UK() {
        }

        /* renamed from: UL */
        public void mo24987UL() {
        }

        /* renamed from: UM */
        public void mo24988UM() {
            CameraViewDefaultLan.this.mo25852UF();
            if (CameraViewDefaultLan.this.bTo != null) {
                CameraViewDefaultLan.this.bTo.mo26210Ys();
            }
        }

        /* renamed from: UN */
        public void mo24989UN() {
        }

        /* renamed from: UO */
        public void mo24990UO() {
            CameraViewDefaultLan.this.m13544Xa();
        }

        /* renamed from: UP */
        public void mo24991UP() {
        }

        /* renamed from: UQ */
        public void mo24992UQ() {
            if (CameraViewDefaultLan.this.bLS != null) {
                CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(QEffect.PROP_EFFECT_PARAM_DATA));
            }
        }

        /* renamed from: UR */
        public void mo24993UR() {
            CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(QEffect.PROP_EFFECT_TA_SOURCE));
        }

        /* renamed from: US */
        public void mo24994US() {
        }

        /* renamed from: a */
        public void mo24995a(C4990a aVar) {
        }

        /* renamed from: cr */
        public void mo24996cr(boolean z) {
            if (z) {
                CameraViewDefaultLan.this.bUe.mo26273dA(false);
                CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(QEffect.PROP_EFFECT_PROPDATA));
                return;
            }
            CameraViewDefaultLan.this.bUe.mo26273dA(true);
        }

        /* renamed from: cs */
        public void mo24997cs(boolean z) {
            CameraViewDefaultLan.this.m13576dd(true);
        }

        /* renamed from: ct */
        public void mo24998ct(boolean z) {
        }

        /* renamed from: iM */
        public void mo24999iM(int i) {
        }
    };
    private OnClickListener bTD = new OnClickListener() {
        public void onClick(View view) {
            view.equals(CameraViewDefaultLan.this.bTW);
        }
    };
    private C5051c bTP;
    private int bTQ = 0;
    private boolean bTR = true;
    /* access modifiers changed from: private */
    public boolean bTS = false;
    private long bTT = 0;
    /* access modifiers changed from: private */
    public RelativeLayout bTU;
    private RotateTextView bTV;
    /* access modifiers changed from: private */
    public RelativeLayout bTW;
    /* access modifiers changed from: private */
    public RelativeLayout bTX;
    private RotateTextView bTY;
    private boolean bTZ = false;
    /* access modifiers changed from: private */
    public TimerView bTo;
    /* access modifiers changed from: private */
    public int bTp = 0;
    /* access modifiers changed from: private */
    public int bTq = 0;
    /* access modifiers changed from: private */
    public Animation bTv;
    /* access modifiers changed from: private */
    public Animation bUa;
    private IndicatorBarLan bUb;
    private SpeedUIManager bUc;
    private TextSeekBar bUd;
    /* access modifiers changed from: private */
    public TopIndicatorLan bUe;
    private ShutterLayoutLan bUf;
    private PipSwapWidgetHor bUg;
    private C5023a bUh;
    private RelativeLayout bUi;
    private SettingIndicatorLan bUj;
    private RecyclerView bUk;
    private C4665d bUl = new C4665d() {
        /* renamed from: iK */
        public void mo24979iK(int i) {
            if (CameraViewDefaultLan.this.bLS == null) {
                return;
            }
            if (C5008i.m12937VU().mo25621Wh()) {
                CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(QEffect.PROP_EFFECT_AUDIO_ADDITIONAL_TIME));
            } else {
                CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(QEffect.PROP_EFFECT_TA_SOURCE_LIST));
            }
        }
    };
    private C4670i bUm = new C4670i() {
        /* renamed from: UO */
        public void mo25000UO() {
        }

        /* renamed from: UT */
        public void mo25001UT() {
        }

        /* renamed from: UU */
        public void mo25002UU() {
            CameraViewDefaultLan.this.mo25796Um();
        }

        /* renamed from: iN */
        public void mo25003iN(int i) {
            int VW = C5008i.m12937VU().mo25610VW();
            if (!(i == 6 || i == 8 || i == 10 || i == 15)) {
                switch (i) {
                    case 0:
                        break;
                }
            }
            CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE, 256, VW));
            CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(QEffect.PROP_EFFECT_THEME_POS_TYPE, Integer.valueOf(i)));
            CameraViewDefaultLan.this.bML.aNX();
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_duration", true);
        }
    };
    private C4668g bUn = new C4668g() {
        /* renamed from: bV */
        public void mo24981bV(int i, int i2) {
            String string = CameraViewDefaultLan.this.getResources().getString(R.string.xiaoying_str_cam_timer);
            boolean z = true;
            if (!(i2 != 10)) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append(" ");
                sb.append(CameraViewDefaultLan.this.getResources().getString(R.string.xiaoying_str_cam_state_off));
                CameraViewDefaultLan.this.m13586fd(sb.toString());
                CameraViewDefaultLan.this.bTp = 0;
                CameraViewDefaultLan.this.bTq = 0;
                CameraViewDefaultLan.this.bTo.mo26208Yq();
                CameraViewDefaultLan.this.bTo.reset();
                AppPreferencesSetting.getInstance().setAppSettingStr("pref_timer_onoff_key", "off");
            } else {
                if (i2 != 11) {
                    z = false;
                }
                if (z) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(string);
                    sb2.append(" ");
                    sb2.append(CameraViewDefaultLan.this.getResources().getString(R.string.xiaoying_str_cam_state_on));
                    CameraViewDefaultLan.this.m13586fd(sb2.toString());
                } else {
                    CameraViewDefaultLan.this.bTo.onClick(CameraViewDefaultLan.this.bTo);
                }
                CameraViewDefaultLan.this.bTp = CameraViewDefaultLan.this.bTo.getTimerValue();
                CameraViewDefaultLan.this.bTq = CameraViewDefaultLan.this.bTp;
                CameraViewDefaultLan.this.bTo.mo26207Yp();
                AppPreferencesSetting.getInstance().setAppSettingStr("pref_timer_onoff_key", "on");
            }
            C5008i.m12937VU().mo25656jk(CameraViewDefaultLan.this.bTp);
            CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(4105));
            Activity activity = (Activity) CameraViewDefaultLan.this.bwg.get();
            if (activity != null) {
                C5031c.m13226i(activity, C5034e.m13235R(activity, CameraViewDefaultLan.this.bOz), CameraViewDefaultLan.this.bTp);
            }
        }

        /* renamed from: iL */
        public void mo24982iL(int i) {
            if (i != 4) {
                switch (i) {
                    case 0:
                        CameraViewDefaultLan.this.m13547Xd();
                        return;
                    case 1:
                        CameraViewDefaultLan.this.m13546Xc();
                        return;
                    default:
                        return;
                }
            } else {
                CameraViewDefaultLan.this.m13549Xf();
            }
        }
    };
    private C4664c bUo = new C4664c() {
        /* renamed from: iJ */
        public void mo24978iJ(int i) {
            switch (i) {
                case 0:
                    CameraViewDefaultLan.this.m13545Xb();
                    return;
                case 1:
                    CameraViewDefaultLan.this.m13550Xt();
                    return;
                case 2:
                    CameraViewDefaultLan.this.m13552Xv();
                    return;
                case 3:
                    CameraViewDefaultLan.this.m13553Xw();
                    return;
                case 4:
                    CameraViewDefaultLan.this.m13548Xe();
                    return;
                default:
                    return;
            }
        }
    };
    private C4666e bUp = new C4666e() {
        /* renamed from: w */
        public boolean mo24980w(View view, int i) {
            if (C4580b.m11632Sf() || ((Activity) CameraViewDefaultLan.this.bwg.get()) == null) {
                return false;
            }
            CameraViewDefaultLan.this.mo25852UF();
            if (i != 0 || !CameraViewDefaultLan.this.bTS) {
                if (CameraViewDefaultLan.this.bTS) {
                    i--;
                }
                view.startAnimation(CameraViewDefaultLan.this.bUa);
                CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(QEffect.PROP_EFFECT_ANIMATE_POINT_GENERATOR, i, 0));
                return true;
            }
            CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(QEffect.PROP_EFFECT_FRAME_BGSIZE));
            return true;
        }
    };
    private C5178b bUq = new C5178b() {
        /* renamed from: jw */
        public void mo25958jw(int i) {
            CameraViewDefaultLan.this.bTp = i;
            CameraViewDefaultLan.this.bTq = CameraViewDefaultLan.this.bTp;
            C5008i.m12937VU().mo25656jk(CameraViewDefaultLan.this.bTp);
        }

        /* renamed from: jx */
        public void mo25959jx(int i) {
            if (CameraViewDefaultLan.this.mHandler != null) {
                CameraViewDefaultLan.this.mHandler.sendMessage(CameraViewDefaultLan.this.mHandler.obtainMessage(8197));
            }
        }
    };
    private C8415b bUr = new C8416c() {
        /* renamed from: a */
        public void mo25989a(int i, Rect rect) {
            StringBuilder sb = new StringBuilder();
            sb.append("=================OnPIPControlListener onControlRegionScroll curIndex=");
            sb.append(i);
            sb.append(";rectScrolled:");
            sb.append(rect);
            Log.e("CameraViewDefaultLan", sb.toString());
            QRect qRect = new QRect(rect.left, rect.top, rect.right, rect.bottom);
            if (CameraViewDefaultLan.this.bLS != null) {
                CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(4144, i, 0, qRect));
            }
        }

        /* renamed from: b */
        public void mo25990b(int i, Rect rect) {
            StringBuilder sb = new StringBuilder();
            sb.append("==================OnPIPControlListener onControlRegionZoom curIndex=");
            sb.append(i);
            sb.append(";regionAfterScroll:");
            sb.append(rect);
            Log.e("CameraViewDefaultLan", sb.toString());
            QRect qRect = new QRect(rect.left, rect.top, rect.right, rect.bottom);
            if (CameraViewDefaultLan.this.bLS != null) {
                CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(4144, i, 0, qRect));
            }
        }
    };
    /* access modifiers changed from: private */
    public WeakReference<Activity> bwg;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 8194:
                    removeMessages(8194);
                    CameraViewDefaultLan.this.bTU.setVisibility(4);
                    CameraViewDefaultLan.this.bTU.startAnimation(CameraViewDefaultLan.this.bTv);
                    return;
                case 8195:
                    removeMessages(8195);
                    CameraViewDefaultLan.this.bTX.setVisibility(4);
                    CameraViewDefaultLan.this.bTX.startAnimation(CameraViewDefaultLan.this.bTv);
                    return;
                case 8197:
                    removeMessages(8197);
                    CameraViewDefaultLan.this.m13576dd(false);
                    if (CameraViewDefaultLan.this.bTq <= 0 || CameraViewDefaultLan.this.getState() == 2) {
                        CameraViewDefaultLan.this.bTo.mo26208Yq();
                        if (CameraViewDefaultLan.this.bLS != null) {
                            CameraViewDefaultLan.this.bLS.sendMessage(CameraViewDefaultLan.this.bLS.obtainMessage(4097));
                            return;
                        }
                        return;
                    }
                    if (CameraViewDefaultLan.this.bMf != null) {
                        CameraViewDefaultLan.this.bMf.mo25896jO(4100);
                    }
                    CameraViewDefaultLan.this.bTo.setTimer(CameraViewDefaultLan.this.bTq);
                    CameraViewDefaultLan.this.bTq = CameraViewDefaultLan.this.bTq - 1;
                    if (CameraViewDefaultLan.this.mHandler != null) {
                        CameraViewDefaultLan.this.mHandler.sendMessageDelayed(CameraViewDefaultLan.this.mHandler.obtainMessage(8197), 1000);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private int mState = -1;

    public CameraViewDefaultLan(Activity activity) {
        super(activity);
        this.bwg = new WeakReference<>(activity);
        this.bML = new C9136a((Activity) this.bwg.get(), true);
        this.bTR = Constants.TEMPLATE_GET_MORE_ENABLE;
        this.bUa = AnimationUtils.loadAnimation(activity, R.anim.xiaoying_anim_click);
        LayoutInflater.from(activity).inflate(R.layout.cam_view_lan, this);
        mo25986Oj();
    }

    /* renamed from: WV */
    private void m13542WV() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.mShowAnim = AnimationUtils.loadAnimation(activity, R.anim.v4_xiaoying_slide_out_up_self);
            this.mHideAnim = AnimationUtils.loadAnimation(activity, R.anim.v4_xiaoying_slide_in_up_self);
            this.bTv = AnimationUtils.loadAnimation(activity, R.anim.xiaoying_anim_effect_tips_alpha);
            this.bOP = AnimationUtils.loadAnimation(activity, R.anim.xiaoying_slide_out_left_self);
            this.bOQ = AnimationUtils.loadAnimation(activity, R.anim.xiaoying_slide_in_left_self);
            this.bOR = AnimationUtils.loadAnimation(activity, R.anim.v4_xiaoying_slide_out_down_self);
            this.bOS = AnimationUtils.loadAnimation(activity, R.anim.v4_xiaoying_slide_in_down_self);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xa */
    public void m13544Xa() {
        this.bLS.sendMessage(this.bLS.obtainMessage(4101));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xb */
    public void m13545Xb() {
        m13582dm(true);
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            mo25852UF();
            m13577dh(true);
            m13580dk(true);
            if (this.bUk.getVisibility() != 0) {
                m13579dj(true);
            } else {
                m13578di(true);
            }
        }
        if (this.bUb != null) {
            this.bUb.mo26237YI();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xc */
    public void m13546Xc() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_grid", "off");
        String string = getResources().getString(R.string.xiaoying_str_cam_grid);
        if ("off".equals(appSettingStr)) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" ");
            sb.append(getResources().getString(R.string.xiaoying_str_cam_state_on));
            m13586fd(sb.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_grid", "on");
        } else if ("on".equals(appSettingStr)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(" ");
            sb2.append(getResources().getString(R.string.xiaoying_str_cam_state_off));
            m13586fd(sb2.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_grid", "off");
        }
        this.bLS.sendMessage(this.bLS.obtainMessage(4105));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xd */
    public void m13547Xd() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_flash_mode", "no_flash");
        String string = getResources().getString(R.string.xiaoying_str_cam_flash);
        if ("off".equals(appSettingStr)) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" ");
            sb.append(getResources().getString(R.string.xiaoying_str_cam_state_on));
            m13586fd(sb.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_flash_mode", "on");
        } else if ("on".equals(appSettingStr)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(" ");
            sb2.append(getResources().getString(R.string.xiaoying_str_cam_state_off));
            m13586fd(sb2.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_flash_mode", "off");
        }
        this.bLS.sendMessage(this.bLS.obtainMessage(4105));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xe */
    public void m13548Xe() {
        this.bLS.sendMessage(this.bLS.obtainMessage(4102));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xf */
    public void m13549Xf() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "unlock");
        String string = getResources().getString(R.string.xiaoying_str_cam_aelock);
        if ("unlock".equals(appSettingStr)) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" ");
            sb.append(getResources().getString(R.string.xiaoying_str_cam_state_on));
            m13586fd(sb.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK);
        } else if (SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(appSettingStr)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(" ");
            sb2.append(getResources().getString(R.string.xiaoying_str_cam_state_off));
            m13586fd(sb2.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", "unlock");
        }
        this.bLS.sendMessage(this.bLS.obtainMessage(4105));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xt */
    public void m13550Xt() {
        m13582dm(true);
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bLS.sendEmptyMessage(QEffect.PROP_EFFECT_AUDIO_ADDITIONAL_TIME);
        } else {
            m13577dh(true);
            if (this.bUd.getVisibility() != 0) {
                m13581dl(true);
            } else {
                m13580dk(true);
            }
        }
        if (this.bUb != null) {
            this.bUb.mo26237YI();
        }
    }

    /* renamed from: Xu */
    private void m13551Xu() {
    }

    /* access modifiers changed from: private */
    /* renamed from: Xv */
    public void m13552Xv() {
        this.bLS.sendMessage(this.bLS.obtainMessage(4104));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xw */
    public void m13553Xw() {
        if (this.bUk != null && this.bUk.getVisibility() == 0) {
            m13578di(true);
        }
        m13580dk(true);
        m13577dh(true);
        if (this.bUj.getVisibility() != 0) {
            m13583dn(true);
        } else {
            m13582dm(true);
        }
        if (this.bUb != null) {
            this.bUb.mo26237YI();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dd */
    public void m13576dd(boolean z) {
        if (this.bTp != 0 && z) {
            this.bTq = this.bTp;
            this.mHandler.removeMessages(8197);
            this.bTo.mo26207Yp();
        }
        if (this.bUb != null) {
            this.bUb.setEnabled(z);
            this.bUb.setVisibility(z ? 0 : 4);
        }
        this.bUe.setEnabled(z);
        if (!z) {
            m13577dh(true);
        }
        if (this.bUb != null) {
            this.bUb.mo26237YI();
        }
    }

    /* renamed from: dh */
    private void m13577dh(boolean z) {
        C5008i.m12937VU().mo25636cL(false);
        C5008i.m12937VU().mo25643cS(false);
    }

    /* renamed from: di */
    private void m13578di(boolean z) {
        if (this.bUk != null && this.bUk.getVisibility() == 0) {
            this.bUk.setVisibility(8);
            if (z) {
                this.bUk.startAnimation(this.mHideAnim);
            }
        }
        C5008i.m12937VU().mo25639cO(false);
    }

    /* renamed from: dj */
    private void m13579dj(boolean z) {
        if (!(this.bUk == null || this.bUk.getVisibility() == 0)) {
            this.bUk.setVisibility(0);
            if (z) {
                this.bUk.startAnimation(this.mShowAnim);
            }
        }
        C5008i.m12937VU().mo25639cO(true);
    }

    /* renamed from: dk */
    private void m13580dk(boolean z) {
        if (this.bUd.getVisibility() == 0) {
            Activity activity = (Activity) this.bwg.get();
            if (activity != null) {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(((CameraActivityBase) activity).bOx);
                hashMap.put("speed", sb.toString());
                UserBehaviorLog.onKVEvent(activity, "Cam_Speed", hashMap);
            }
            this.bUd.setVisibility(8);
            if (z) {
                this.bUd.startAnimation(this.mHideAnim);
            }
        }
        C5008i.m12937VU().mo25638cN(false);
    }

    /* renamed from: dl */
    private void m13581dl(boolean z) {
        if (this.bUd.getVisibility() != 0) {
            this.bUd.setVisibility(0);
            if (z) {
                this.bUd.startAnimation(this.mShowAnim);
            }
        }
        C5008i.m12937VU().mo25638cN(true);
    }

    /* renamed from: dm */
    private void m13582dm(boolean z) {
        if (this.bUj != null) {
            this.bUj.mo26246ds(z);
        }
    }

    /* renamed from: dn */
    private void m13583dn(boolean z) {
        if (this.bUj != null) {
            this.bUj.mo26247dy(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fd */
    public void m13586fd(String str) {
        this.bTU.clearAnimation();
        this.bTU.setVisibility(0);
        if (str != null) {
            TextPaint paint = this.bTV.getPaint();
            int i = (int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
            int measureText = (int) paint.measureText(str);
            this.bTV.setWidth(i);
            this.bTV.setHeight(measureText);
            this.bTV.setDegree(QDisplayContext.DISPLAY_ROTATION_270);
            this.bTV.setText(str);
        }
        this.mHandler.removeMessages(8194);
        this.mHandler.sendEmptyMessageDelayed(8194, 1000);
    }

    /* access modifiers changed from: private */
    public int getState() {
        return this.mState;
    }

    private void initUI() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.bUk = (RecyclerView) findViewById(R.id.pip_listview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
            linearLayoutManager.setReverseLayout(true);
            linearLayoutManager.setOrientation(0);
            this.bUk.setLayoutManager(linearLayoutManager);
            if (this.bOT) {
                mo25851UE();
            }
            this.bTU = (RelativeLayout) findViewById(R.id.effect_tip_layout_hor);
            this.bTV = (RotateTextView) findViewById(R.id.txt_effect_name_hor);
            this.bTX = (RelativeLayout) findViewById(R.id.zoom_tip_layout_hor);
            this.bTY = (RotateTextView) findViewById(R.id.txt_zoom_value_hor);
            this.bTW = (RelativeLayout) findViewById(R.id.cam_rotate_tips_layout);
            this.bTW.setOnClickListener(this.bTD);
            this.bTo = (TimerView) findViewById(R.id.timer_view);
            this.bTo.mo26211a(this.bUq);
            this.bTo.setPortrait(false);
            RotateTextView rotateTextView = (RotateTextView) findViewById(R.id.txt_scene_tips_hor);
            String string = activity.getString(R.string.xiaoying_str_cam_fx_preview_tip);
            if (rotateTextView != null) {
                TextPaint paint = rotateTextView.getPaint();
                int i = (int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
                int measureText = (int) paint.measureText(string);
                rotateTextView.setWidth(i);
                rotateTextView.setHeight(measureText);
                rotateTextView.setDegree(QDisplayContext.DISPLAY_ROTATION_270);
                rotateTextView.setText(string);
            }
            this.bUb = (IndicatorBarLan) findViewById(R.id.xiaoying_cam_indicator_por);
            if (this.bUb != null) {
                this.bUb.setIndicatorItemClickListener(this.bUo);
            }
            this.bUe = (TopIndicatorLan) findViewById(R.id.cam_layout_title);
            this.bUe.setTopIndicatorClickListener(this.bUm);
            this.bUd = (TextSeekBar) findViewById(R.id.xiaoying_cam_speed_indicator_por);
            this.bUc = new SpeedUIManager(this.bUd, true);
            this.bUc.initViewState(((CameraActivityBase) activity).bOx);
            this.bUc.setmOnSpeedChangeListener(new SimpleSpeedChangeListener() {
                public void onSpeedChanged(float f) {
                    Activity activity = (Activity) CameraViewDefaultLan.this.bwg.get();
                    if (activity != null) {
                        ((CameraActivityBase) activity).bOx = f;
                    }
                }
            });
            this.bUf = (ShutterLayoutLan) findViewById(R.id.shutter_layout);
            this.bUf.setShutterLayoutLanEventListener(this.bTB);
            this.bUf.mo26072a(activity, (CameraViewBase) this);
            this.bUg = (PipSwapWidgetHor) findViewById(R.id.pip_swap_view_hor);
            this.bUg.setPipOnAddClipClickListener(this.bUl);
            this.bUi = (RelativeLayout) findViewById(R.id.preview_layout_fake);
            this.bUj = (SettingIndicatorLan) findViewById(R.id.xiaoying_cam_setting_indicator);
            this.bUj.setSettingItemClickListener(this.bUn);
        }
    }

    /* renamed from: Oj */
    public final void mo25986Oj() {
        if (((Activity) this.bwg.get()) != null) {
            m13542WV();
            initUI();
        }
    }

    /* renamed from: SY */
    public void mo25791SY() {
        m13576dd(true);
        if (this.bTp != 0) {
            this.bTq = this.bTp;
            this.mHandler.removeMessages(8197);
            this.bTo.mo26207Yp();
        }
    }

    /* renamed from: Tr */
    public void mo25846Tr() {
        VeMSize veMSize = new VeMSize(360, (int) QUtils.VIDEO_RES_VGA_WIDTH);
        if (this.bMj != null) {
            veMSize.width = this.bMj.getWidth();
            veMSize.height = this.bMj.getHeight();
        }
        QPIPFrameParam Wk = C5008i.m12937VU().mo25624Wk();
        if (this.bUh == null) {
            this.bUh = new C5023a(this.bUi, false);
        }
        this.bUh.mo34109a(this.bUr);
        this.bUh.mo34112c(veMSize);
        this.bUh.mo34114s(C5020n.m13113a(Wk, new MSize(veMSize.width, veMSize.height), false));
        this.bUh.refreshView();
    }

    /* renamed from: Ts */
    public void mo25792Ts() {
    }

    /* renamed from: UA */
    public void mo25847UA() {
    }

    /* renamed from: UB */
    public void mo25848UB() {
    }

    /* renamed from: UC */
    public void mo25849UC() {
        m13578di(false);
        this.bUf.update();
    }

    /* renamed from: UD */
    public void mo25850UD() {
    }

    /* renamed from: UF */
    public void mo25852UF() {
        if (this.bML != null) {
            this.bML.aNX();
        }
        this.bUf.mo26071XO();
    }

    /* access modifiers changed from: protected */
    /* renamed from: UG */
    public void mo25853UG() {
    }

    /* renamed from: Uj */
    public void mo25793Uj() {
        if (this.bUb != null) {
            this.bUb.update();
        }
        if (!(this.bUc == null || this.bwg == null)) {
            Activity activity = (Activity) this.bwg.get();
            if (activity != null) {
                this.bUc.update(((CameraActivityBase) activity).bOx);
            }
        }
        if (this.bUe != null) {
            this.bUe.update();
        }
        if (this.bUf != null) {
            this.bUf.update();
        }
        if (this.bUj != null) {
            this.bUj.update();
        }
    }

    /* renamed from: Uk */
    public void mo25794Uk() {
    }

    /* renamed from: Ul */
    public boolean mo25795Ul() {
        return this.bTo.mo26209Yr();
    }

    /* renamed from: Um */
    public void mo25796Um() {
        m13580dk(true);
        m13577dh(true);
        m13582dm(true);
        m13551Xu();
        if (this.bUb != null) {
            this.bUb.mo26237YI();
        }
    }

    /* renamed from: Un */
    public void mo25797Un() {
        this.bUf.mo26069Un();
    }

    /* renamed from: Uo */
    public void mo25798Uo() {
    }

    /* renamed from: Up */
    public void mo25799Up() {
        mo25852UF();
    }

    /* renamed from: Uq */
    public boolean mo25800Uq() {
        return false;
    }

    /* renamed from: Ux */
    public void mo25854Ux() {
        this.bUf.mo26070Ux();
    }

    /* renamed from: Uy */
    public void mo25855Uy() {
    }

    /* renamed from: Uz */
    public void mo25856Uz() {
    }

    /* renamed from: a */
    public void mo25857a(int i, QPIPFrameParam qPIPFrameParam) {
        if (this.bUg != null) {
            this.bUg.mo26188c(i, qPIPFrameParam);
        }
    }

    /* renamed from: a */
    public void mo25801a(Long l, int i) {
        if (CameraCodeMgr.isCameraParamPIP(this.bOz) && this.bTP != null) {
            this.bTP.mo25925b(l, i);
            this.bTP.notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public void mo25802b(RelativeLayout relativeLayout) {
        this.bMj = relativeLayout;
        mo25793Uj();
    }

    /* renamed from: b */
    public void mo25803b(MusicDataItem musicDataItem) {
    }

    /* renamed from: bU */
    public void mo25859bU(int i, int i2) {
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bUe.mo26272bU(i, i2);
        }
    }

    /* renamed from: cm */
    public void mo25805cm(boolean z) {
        if (this.bTP != null) {
            this.bTP.notifyDataSetChanged();
        }
    }

    /* renamed from: cp */
    public void mo25861cp(boolean z) {
        if (!z || this.bTW.getVisibility() != 0) {
            int i = 8;
            if (z || this.bTW.getVisibility() != 8) {
                RelativeLayout relativeLayout = this.bTW;
                if (z) {
                    i = 0;
                }
                relativeLayout.setVisibility(i);
                if (z && this.bUf != null) {
                    this.bUf.mo26071XO();
                }
            }
        }
    }

    /* renamed from: cq */
    public void mo25862cq(boolean z) {
        if (z) {
            this.bUe.mo26271YL();
            if (this.bUb != null) {
                this.bUb.setVisibility(0);
            }
        } else {
            this.bUe.mo26270YK();
            if (this.bUb != null) {
                this.bUb.setVisibility(4);
            }
        }
        this.bUf.mo26073dq(z);
    }

    public View getTopIndicatorView() {
        return null;
    }

    /* renamed from: iF */
    public void mo25808iF(int i) {
    }

    public void onDestroy() {
        this.bLS = null;
        this.bML = null;
    }

    public void onPause() {
        if (this.bUf != null) {
            this.bUf.onPause();
        }
        if (this.bUe != null) {
            this.bUe.onPause();
        }
    }

    public void onResume() {
        LogUtils.m14223i("CameraViewDefaultLan", "onResume() < ---------");
    }

    /* renamed from: p */
    public boolean mo25812p(MotionEvent motionEvent) {
        boolean p = this.bUf.mo26077p(motionEvent);
        if (p) {
            return true;
        }
        if (CameraCodeMgr.isCameraParamPIP(this.bOz) && this.bUg != null) {
            p = this.bUg.mo26189p(motionEvent);
        }
        return p;
    }

    public void setCameraMode(int i, int i2, boolean z) {
        if (((Activity) this.bwg.get()) != null) {
            this.bOz = i2;
            this.bTp = 0;
            C5008i.m12937VU().mo25656jk(this.bTp);
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_timer_onoff_key", "off");
            this.bUe.mo26271YL();
            this.bTo.mo26208Yq();
            m13577dh(true);
            m13578di(true);
            if (!CameraCodeMgr.isCameraParamDefault(i2)) {
                m13580dk(true);
            }
            m13582dm(true);
            mo25791SY();
            this.bUg.setVisibility(4);
            this.bUi.setVisibility(8);
            if (i == 512 && CameraCodeMgr.isCameraParamPIP(i2)) {
                this.bUi.setVisibility(0);
                m13579dj(true);
                C5008i.m12937VU().mo25641cQ(true);
                this.bUg.setVisibility(0);
            }
            this.bUf.update();
            if (this.bUb != null) {
                this.bUb.mo26237YI();
            }
        }
    }

    public void setClipCount(int i, boolean z) {
        if (((Activity) this.bwg.get()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            String sb2 = sb.toString();
            if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                int VO = C5006h.m12925VO();
                if (-1 != VO) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("");
                    sb3.append(C5006h.m12926jf(VO));
                    sb2 = sb3.toString();
                }
            }
            this.bUe.update();
            this.bUe.setClipCount(sb2);
            this.bUf.mo26074jB(i);
        }
    }

    public void setCurrentTimeValue(long j) {
        this.bUe.setTimeValue(j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setEffect(int r1, boolean r2, boolean r3, boolean r4) {
        /*
            r0 = this;
            monitor-enter(r0)
            int r4 = r0.bOB     // Catch:{ all -> 0x0045 }
            if (r4 != r1) goto L_0x0009
            if (r2 != 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            if (r1 >= 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.lang.String r2 = "CameraViewDefaultLan"
            java.lang.String r4 = "setEffect() < ---------"
            com.introvd.template.common.LogUtils.m14223i(r2, r4)     // Catch:{ all -> 0x0045 }
            r0.bOB = r1     // Catch:{ all -> 0x0045 }
            com.introvd.template.template.g.b r1 = r0.bOt     // Catch:{ all -> 0x0045 }
            int r2 = r0.bOB     // Catch:{ all -> 0x0045 }
            com.introvd.template.sdk.model.editor.EffectInfoModel r1 = r1.mo35214vh(r2)     // Catch:{ all -> 0x0045 }
            if (r1 != 0) goto L_0x0022
            monitor-exit(r0)
            return
        L_0x0022:
            java.lang.String r1 = "none"
            int r2 = r0.bOB     // Catch:{ all -> 0x0045 }
            if (r2 < 0) goto L_0x003e
            com.introvd.template.template.g.b r2 = r0.bOt     // Catch:{ all -> 0x0045 }
            int r4 = r0.bOB     // Catch:{ all -> 0x0045 }
            com.introvd.template.sdk.model.editor.EffectInfoModel r2 = r2.mo35214vh(r4)     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x003e
            com.introvd.template.template.g.b r2 = r0.bOt     // Catch:{ all -> 0x0045 }
            int r4 = r0.bOB     // Catch:{ all -> 0x0045 }
            com.introvd.template.sdk.model.editor.EffectInfoModel r2 = r2.mo35214vh(r4)     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x003e
            java.lang.String r1 = r2.mName     // Catch:{ all -> 0x0045 }
        L_0x003e:
            if (r3 == 0) goto L_0x0043
            r0.m13586fd(r1)     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r0)
            return
        L_0x0045:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p233ui.camview.CameraViewDefaultLan.setEffect(int, boolean, boolean, boolean):void");
    }

    public void setEffectMgr(C8759b bVar) {
        if (((Activity) this.bwg.get()) != null) {
            this.bOt = bVar;
        }
    }

    public void setPipEffect(int i, boolean z) {
        if (this.bTQ == i && !z) {
            return;
        }
        if ((this.bTP == null || i < this.bTP.getItemCount()) && i >= 0) {
            LogUtils.m14223i("CameraViewDefaultLan", "setPipEffect() < ---------");
            this.bTQ = i;
            if (this.bTP != null) {
                this.bTP.mo25927jt(this.bTQ);
                this.bTP.notifyDataSetChanged();
            }
        }
    }

    public void setPipEffectMgr(C8759b bVar) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            if (this.bTP == null) {
                this.bTP = new C5051c(activity);
                this.bTP.setEffectMgr(bVar);
                this.bTP.mo25926db(this.bTS);
                this.bUk.setAdapter(this.bTP);
                this.bTP.mo25923a(this.bUp);
            } else {
                this.bTP.notifyDataSetChanged();
            }
        }
    }

    public void setState(int i, MSize mSize) {
        if (this.mState != i) {
            this.mState = i;
            switch (this.mState) {
                case 2:
                    mo25862cq(false);
                    mo25852UF();
                    m13580dk(false);
                    m13582dm(false);
                    if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                        m13578di(false);
                        C5008i.m12937VU().mo25641cQ(false);
                        if (this.bUb != null) {
                            this.bUb.update();
                        }
                    }
                    m13577dh(false);
                    this.bUe.update();
                    if (this.bUb != null) {
                        this.bUb.mo26237YI();
                        break;
                    }
                    break;
                case 6:
                    mo25862cq(true);
                    break;
            }
            this.bUf.update();
        }
    }

    public void setTimeExceed(boolean z) {
        this.bUe.setTimeExceed(z);
    }

    public void setZoomValue(double d) {
        this.bTX.clearAnimation();
        this.bTX.setVisibility(0);
        this.bTY.setDegree(QDisplayContext.DISPLAY_ROTATION_270);
        RotateTextView rotateTextView = this.bTY;
        StringBuilder sb = new StringBuilder();
        sb.append("x");
        sb.append(d);
        rotateTextView.setText(sb.toString());
        this.mHandler.removeMessages(8195);
        this.mHandler.sendEmptyMessageDelayed(8195, 1000);
    }
}
