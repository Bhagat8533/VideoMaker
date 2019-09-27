package com.introvd.template.camera.p233ui.camview;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
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
import com.introvd.template.camera.p232e.C5030b;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.camera.p233ui.p234a.C5048b;
import com.introvd.template.camera.p233ui.shutter.ShutterLayoutPor;
import com.introvd.template.camera.p233ui.view.BackDeleteProgressBar;
import com.introvd.template.camera.p233ui.view.PipSwapWidget;
import com.introvd.template.camera.p233ui.view.TimerView;
import com.introvd.template.camera.p233ui.view.TimerView.C5178b;
import com.introvd.template.camera.p233ui.view.indicator.C5198c;
import com.introvd.template.camera.p233ui.view.indicator.IndicatorBar;
import com.introvd.template.camera.p233ui.view.indicator.SettingIndicator;
import com.introvd.template.camera.p233ui.view.indicator.TopIndicator;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.SpeedUIManager;
import com.introvd.template.common.SpeedUIManager.SimpleSpeedChangeListener;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
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
import java.util.ArrayList;
import java.util.HashMap;
import xiaoying.engine.clip.QEffect;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.camera.ui.camview.CameraViewDefaultPor */
public class CameraViewDefaultPor extends CameraViewBase {
    private MSize bLT = new MSize(800, 480);
    private C9136a bML;
    private RelativeLayout bMj;
    private int bOB = 0;
    /* access modifiers changed from: private */
    public int bOz = 1;
    /* access modifiers changed from: private */
    public RelativeLayout bSV;
    /* access modifiers changed from: private */
    public RelativeLayout bSX;
    private TextView bSY;
    private OnClickListener bTD = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(CameraViewDefaultPor.this.bUN)) {
                CameraViewDefaultPor.this.mo25796Um();
                C5031c.m13217am(CameraViewDefaultPor.this.getContext(), "sward");
            }
        }
    };
    private C5178b bTI = new C5178b() {
        /* renamed from: jw */
        public void mo25958jw(int i) {
            CameraViewDefaultPor.this.bTp = i;
            CameraViewDefaultPor.this.bTq = CameraViewDefaultPor.this.bTp;
            C5008i.m12937VU().mo25656jk(CameraViewDefaultPor.this.bTp);
        }

        /* renamed from: jx */
        public void mo25959jx(int i) {
            CameraViewDefaultPor.this.mHandler.sendMessage(CameraViewDefaultPor.this.mHandler.obtainMessage(8196));
        }
    };
    private int bTQ = 0;
    private boolean bTR = true;
    /* access modifiers changed from: private */
    public boolean bTS = false;
    /* access modifiers changed from: private */
    public TimerView bTo;
    /* access modifiers changed from: private */
    public int bTp = 0;
    /* access modifiers changed from: private */
    public int bTq = 0;
    /* access modifiers changed from: private */
    public Animation bTv;
    private Animation bUA = null;
    private Animation bUB = null;
    /* access modifiers changed from: private */
    public RelativeLayout bUC;
    private TextView bUD;
    private C8759b bUE;
    private RelativeLayout bUF;
    /* access modifiers changed from: private */
    public TopIndicator bUG;
    /* access modifiers changed from: private */
    public ShutterLayoutPor bUH;
    /* access modifiers changed from: private */
    public BackDeleteProgressBar bUI;
    /* access modifiers changed from: private */
    public int bUJ = 0;
    /* access modifiers changed from: private */
    public int bUK = 0;
    /* access modifiers changed from: private */
    public C5198c bUL;
    private PipSwapWidget bUM;
    /* access modifiers changed from: private */
    public RelativeLayout bUN;
    private SettingIndicator bUO;
    private C4669h bUP = new C4669h() {
        /* renamed from: UH */
        public void mo24983UH() {
            CameraViewDefaultPor.this.bUG.mo26256dA(false);
            if (C5008i.m12937VU().getDurationLimit() != 0) {
                CameraViewDefaultPor.this.bUI.mo26113XY();
                CameraViewDefaultPor.this.bUI.mo26114XZ();
            }
        }

        /* renamed from: UI */
        public void mo24984UI() {
            if (CameraViewDefaultPor.this.bLS != null) {
                CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(4097));
            }
        }

        /* renamed from: UJ */
        public void mo24985UJ() {
            if (CameraViewDefaultPor.this.bLS != null) {
                CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(4098));
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
            CameraViewDefaultPor.this.bUL.mo26315XO();
            CameraViewDefaultPor.this.mo25852UF();
            if (CameraViewDefaultPor.this.bTo != null) {
                CameraViewDefaultPor.this.bTo.mo26210Ys();
            }
        }

        /* renamed from: UN */
        public void mo24989UN() {
            CameraViewDefaultPor.this.mo25791SY();
        }

        /* renamed from: UO */
        public void mo24990UO() {
        }

        /* renamed from: UP */
        public void mo24991UP() {
            CameraViewDefaultPor.this.m13693Xa();
        }

        /* renamed from: UQ */
        public void mo24992UQ() {
            CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(QEffect.PROP_EFFECT_PARAM_DATA));
        }

        /* renamed from: UR */
        public void mo24993UR() {
            if (CameraCodeMgr.isCameraParamPIP(CameraViewDefaultPor.this.bOz)) {
                if (C5008i.m12937VU().getDurationLimit() != 0) {
                    CameraViewDefaultPor.this.mo25847UA();
                }
                CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(QEffect.PROP_EFFECT_TA_SOURCE));
            }
        }

        /* renamed from: US */
        public void mo24994US() {
            C5031c.m13216al(CameraViewDefaultPor.this.getContext().getApplicationContext(), "hold");
            if (CameraViewDefaultPor.this.mHandler != null) {
                CameraViewDefaultPor.this.mHandler.sendEmptyMessageDelayed(8199, 300);
            }
        }

        /* renamed from: a */
        public void mo24995a(C4990a aVar) {
        }

        /* renamed from: cr */
        public void mo24996cr(boolean z) {
            int durationLimit = C5008i.m12937VU().getDurationLimit();
            if (z) {
                CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(QEffect.PROP_EFFECT_PROPDATA));
                return;
            }
            CameraViewDefaultPor.this.bUG.mo26256dA(true);
            if (durationLimit != 0) {
                CameraViewDefaultPor.this.bUI.mo26112XX();
                CameraViewDefaultPor.this.bUI.mo26115Ya();
            }
        }

        /* renamed from: cs */
        public void mo24997cs(boolean z) {
            CameraViewDefaultPor.this.m13729dd(z);
        }

        /* renamed from: ct */
        public void mo24998ct(boolean z) {
            if (!z && CameraViewDefaultPor.this.mHandler != null) {
                C5031c.m13216al(CameraViewDefaultPor.this.getContext().getApplicationContext(), "tap");
                CameraViewDefaultPor.this.mHandler.sendEmptyMessageDelayed(8198, 300);
            }
        }

        /* renamed from: iM */
        public void mo24999iM(int i) {
        }
    };
    private C4670i bUQ = new C4670i() {
        /* renamed from: UO */
        public void mo25000UO() {
            CameraViewDefaultPor.this.m13693Xa();
        }

        /* renamed from: UT */
        public void mo25001UT() {
            CameraViewDefaultPor.this.m13697Xe();
        }

        /* renamed from: UU */
        public void mo25002UU() {
            CameraViewDefaultPor.this.mo25796Um();
        }

        /* renamed from: iN */
        public void mo25003iN(int i) {
            CameraViewDefaultPor.this.m13744jz(i);
        }
    };
    /* access modifiers changed from: private */
    public Runnable bUR = new Runnable() {
        public void run() {
            int durationLimit = C5008i.m12937VU().getDurationLimit();
            if (CameraViewDefaultPor.this.bUI != null && durationLimit != 0) {
                int maxProgress = CameraViewDefaultPor.this.bUI.getMaxProgress();
                int Wi = C5008i.m12937VU().mo25622Wi();
                if (!CameraCodeMgr.isCameraParamPIP(CameraViewDefaultPor.this.bOz) || -1 == Wi) {
                    CameraViewDefaultPor.this.bUK = durationLimit;
                }
                int state = C5008i.m12937VU().getState();
                int ad = (CameraViewDefaultPor.this.bUJ * maxProgress) / CameraViewDefaultPor.this.bUK;
                if (ad < maxProgress && state == 2) {
                    CameraViewDefaultPor.this.bUI.setProgress(ad);
                    CameraViewDefaultPor.this.bUI.postDelayed(CameraViewDefaultPor.this.bUR, 30);
                }
            }
        }
    };
    private SpeedUIManager bUc;
    private TextSeekBar bUd;
    private C5023a bUh;
    private RelativeLayout bUi;
    private RecyclerView bUk;
    private C4665d bUl = new C4665d() {
        /* renamed from: iK */
        public void mo24979iK(int i) {
            if (CameraViewDefaultPor.this.bLS == null) {
                return;
            }
            if (C5008i.m12937VU().mo25621Wh()) {
                CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(QEffect.PROP_EFFECT_AUDIO_ADDITIONAL_TIME));
            } else {
                CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(QEffect.PROP_EFFECT_TA_SOURCE_LIST));
            }
        }
    };
    private C4668g bUn = new C4668g() {
        /* renamed from: bV */
        public void mo24981bV(int i, int i2) {
            String string = CameraViewDefaultPor.this.getResources().getString(R.string.xiaoying_str_cam_timer);
            boolean z = false;
            if (!(i2 != 10)) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append(" ");
                sb.append(CameraViewDefaultPor.this.getResources().getString(R.string.xiaoying_str_cam_state_off));
                CameraViewDefaultPor.this.m13739fd(sb.toString());
                CameraViewDefaultPor.this.bTp = 0;
                CameraViewDefaultPor.this.bTq = 0;
                CameraViewDefaultPor.this.bTo.mo26208Yq();
                CameraViewDefaultPor.this.bTo.reset();
                AppPreferencesSetting.getInstance().setAppSettingStr("pref_timer_onoff_key", "off");
            } else {
                if (i2 == 11) {
                    z = true;
                }
                if (z) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(string);
                    sb2.append(" ");
                    sb2.append(CameraViewDefaultPor.this.getResources().getString(R.string.xiaoying_str_cam_state_on));
                    CameraViewDefaultPor.this.m13739fd(sb2.toString());
                } else {
                    CameraViewDefaultPor.this.bTo.onClick(CameraViewDefaultPor.this.bTo);
                }
                CameraViewDefaultPor.this.bTp = CameraViewDefaultPor.this.bTo.getTimerValue();
                CameraViewDefaultPor.this.bTq = CameraViewDefaultPor.this.bTp;
                CameraViewDefaultPor.this.bTo.mo26207Yp();
                AppPreferencesSetting.getInstance().setAppSettingStr("pref_timer_onoff_key", "on");
                C5030b.m13201C(CameraViewDefaultPor.this.bOz, true);
                C5008i.m12937VU().mo25634cJ(true);
                CameraViewDefaultPor.this.bUH.mo26087XL();
                CameraViewDefaultPor.this.bUL.mo26314XL();
            }
            C5008i.m12937VU().mo25656jk(CameraViewDefaultPor.this.bTp);
            CameraViewDefaultPor.this.bUH.mo26089XS();
            CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(4105));
            Activity activity = (Activity) CameraViewDefaultPor.this.bwg.get();
            if (activity != null) {
                C5031c.m13226i(activity, C5034e.m13235R(activity, CameraViewDefaultPor.this.bOz), CameraViewDefaultPor.this.bTp);
            }
        }

        /* renamed from: iL */
        public void mo24982iL(int i) {
            switch (i) {
                case 0:
                    CameraViewDefaultPor.this.m13696Xd();
                    return;
                case 1:
                    CameraViewDefaultPor.this.m13695Xc();
                    return;
                case 4:
                    CameraViewDefaultPor.this.m13698Xf();
                    return;
                default:
                    return;
            }
        }
    };
    private C4664c bUo = new C4664c() {
        /* renamed from: iJ */
        public void mo24978iJ(int i) {
            switch (i) {
                case 0:
                    CameraViewDefaultPor.this.m13694Xb();
                    CameraViewDefaultPor.this.mo25858b(CameraViewDefaultPor.this.bSX, true, true);
                    return;
                case 1:
                    CameraViewDefaultPor.this.m13699Xt();
                    return;
                case 2:
                    CameraViewDefaultPor.this.m13700Xv();
                    return;
                case 3:
                    CameraViewDefaultPor.this.m13701Xw();
                    CameraViewDefaultPor.this.mo25858b(CameraViewDefaultPor.this.bSX, true, true);
                    return;
                default:
                    return;
            }
        }
    };
    private C4666e bUp = new C4666e() {
        /* renamed from: w */
        public boolean mo24980w(View view, int i) {
            if (C4580b.m11632Sf() || ((Activity) CameraViewDefaultPor.this.bwg.get()) == null) {
                return false;
            }
            CameraViewDefaultPor.this.mo25852UF();
            if (i != 0 || !CameraViewDefaultPor.this.bTS) {
                if (CameraViewDefaultPor.this.bTS) {
                    i--;
                }
                CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(QEffect.PROP_EFFECT_ANIMATE_POINT_GENERATOR, i, 0));
                return true;
            }
            CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(QEffect.PROP_EFFECT_FRAME_BGSIZE));
            return true;
        }
    };
    private C8415b bUr = new C8416c() {
        /* renamed from: a */
        public void mo25989a(int i, Rect rect) {
            StringBuilder sb = new StringBuilder();
            sb.append("=================OnPIPControlListener onControlRegionScroll curIndex=");
            sb.append(i);
            sb.append(";regionAfterScroll:");
            sb.append(rect);
            LogUtils.m14223i("CameraViewDefaultPor", sb.toString());
            QRect qRect = new QRect(rect.left, rect.top, rect.right, rect.bottom);
            if (CameraViewDefaultPor.this.bLS != null) {
                CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(4144, i, 0, qRect));
            }
        }

        /* renamed from: b */
        public void mo25990b(int i, Rect rect) {
            StringBuilder sb = new StringBuilder();
            sb.append("==================OnPIPControlListener onControlRegionZoom curIndex=");
            sb.append(i);
            sb.append(";regionAfterScroll:");
            sb.append(rect);
            LogUtils.m14223i("CameraViewDefaultPor", sb.toString());
            QRect qRect = new QRect(rect.left, rect.top, rect.right, rect.bottom);
            if (CameraViewDefaultPor.this.bLS != null) {
                CameraViewDefaultPor.this.bLS.sendMessage(CameraViewDefaultPor.this.bLS.obtainMessage(4144, i, 0, qRect));
            }
        }
    };
    private C5048b bUt;
    /* access modifiers changed from: private */
    public IndicatorBar bUu;
    private RelativeLayout bUv;
    private ImageView bUw;
    private ImageView bUx;
    private Animation bUy = null;
    private Animation bUz = null;
    /* access modifiers changed from: private */
    public WeakReference<Activity> bwg;
    /* access modifiers changed from: private */
    public Handler mHandler = new C5110a(this);
    private int mState = -1;

    /* renamed from: com.introvd.template.camera.ui.camview.CameraViewDefaultPor$a */
    private static class C5110a extends Handler {
        private final WeakReference<CameraViewDefaultPor> bwg;

        public C5110a(CameraViewDefaultPor cameraViewDefaultPor) {
            this.bwg = new WeakReference<>(cameraViewDefaultPor);
        }

        public void handleMessage(Message message) {
            CameraViewDefaultPor cameraViewDefaultPor = (CameraViewDefaultPor) this.bwg.get();
            if (cameraViewDefaultPor != null) {
                switch (message.what) {
                    case 8194:
                        removeMessages(8194);
                        cameraViewDefaultPor.bSV.setVisibility(4);
                        cameraViewDefaultPor.bSV.startAnimation(cameraViewDefaultPor.bTv);
                        break;
                    case 8195:
                        removeMessages(8195);
                        cameraViewDefaultPor.bUC.setVisibility(4);
                        cameraViewDefaultPor.bUC.startAnimation(cameraViewDefaultPor.bTv);
                        break;
                    case 8196:
                        removeMessages(8196);
                        cameraViewDefaultPor.m13729dd(false);
                        if (cameraViewDefaultPor.bTq > 0 && cameraViewDefaultPor.getState() != 2) {
                            cameraViewDefaultPor.bMf.mo25896jO(4100);
                            cameraViewDefaultPor.bTq = cameraViewDefaultPor.bTq - 1;
                            break;
                        } else {
                            cameraViewDefaultPor.bTo.mo26208Yq();
                            if (cameraViewDefaultPor.bLS != null) {
                                cameraViewDefaultPor.bLS.sendMessage(cameraViewDefaultPor.bLS.obtainMessage(4097));
                                break;
                            }
                        }
                        break;
                    case 8198:
                        if (cameraViewDefaultPor.bUL != null && !CameraCodeMgr.isCameraParamPIP(cameraViewDefaultPor.bOz)) {
                            cameraViewDefaultPor.bUL.mo26318jG(1);
                            break;
                        }
                    case 8199:
                        if (cameraViewDefaultPor.bUL != null && !CameraCodeMgr.isCameraParamPIP(cameraViewDefaultPor.bOz)) {
                            cameraViewDefaultPor.bUL.mo26318jG(2);
                            break;
                        }
                }
            }
        }
    }

    public CameraViewDefaultPor(Activity activity) {
        super(activity);
        this.bwg = new WeakReference<>(activity);
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        this.bLT.width = windowManager.getDefaultDisplay().getWidth();
        this.bLT.height = windowManager.getDefaultDisplay().getHeight();
        this.bML = new C9136a((Activity) this.bwg.get(), true);
        this.bTR = Constants.TEMPLATE_GET_MORE_ENABLE;
        LayoutInflater.from(activity).inflate(R.layout.cam_view_ver, this, true);
        mo25992Oj();
    }

    /* renamed from: WV */
    private void m13691WV() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.mShowAnim = C4562a.m11532Se();
            this.mHideAnim = C4562a.m11531Sd();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            this.bUy = translateAnimation;
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            this.bUz = translateAnimation2;
            TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            this.bUA = translateAnimation3;
            TranslateAnimation translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            this.bUB = translateAnimation4;
            this.bUy.setDuration(300);
            this.bUz.setDuration(300);
            this.bUA.setDuration(300);
            this.bUB.setDuration(300);
            this.bUy.setFillAfter(true);
            this.bUB.setFillAfter(true);
            this.bTv = AnimationUtils.loadAnimation(activity, R.anim.xiaoying_anim_effect_tips_alpha);
            this.bOP = AnimationUtils.loadAnimation(activity, R.anim.xiaoying_slide_out_left_self);
            this.bOQ = AnimationUtils.loadAnimation(activity, R.anim.xiaoying_slide_in_left_self);
            this.bOR = C4562a.m11532Se();
            this.bOS = C4562a.m11531Sd();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xa */
    public void m13693Xa() {
        if (this.bLS != null) {
            this.bLS.sendMessage(this.bLS.obtainMessage(4101));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xb */
    public void m13694Xb() {
        m13735dm(false);
        m13730dh(false);
        m13733dk(false);
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            mo25852UF();
            m13732dj(false);
        }
        if (this.bUu != null) {
            this.bUu.mo26232YI();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xc */
    public void m13695Xc() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_grid", "off");
        String string = getResources().getString(R.string.xiaoying_str_cam_grid);
        if ("off".equals(appSettingStr)) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" ");
            sb.append(getResources().getString(R.string.xiaoying_str_cam_state_on));
            m13739fd(sb.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_grid", "on");
        } else if ("on".equals(appSettingStr)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(" ");
            sb2.append(getResources().getString(R.string.xiaoying_str_cam_state_off));
            m13739fd(sb2.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_grid", "off");
        }
        this.bLS.sendMessage(this.bLS.obtainMessage(4105));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xd */
    public void m13696Xd() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_flash_mode", "no_flash");
        String string = getResources().getString(R.string.xiaoying_str_cam_flash);
        if ("off".equals(appSettingStr)) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" ");
            sb.append(getResources().getString(R.string.xiaoying_str_cam_state_on));
            m13739fd(sb.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_flash_mode", "on");
        } else if ("on".equals(appSettingStr)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(" ");
            sb2.append(getResources().getString(R.string.xiaoying_str_cam_state_off));
            m13739fd(sb2.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_flash_mode", "off");
        }
        this.bLS.sendMessage(this.bLS.obtainMessage(4105));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xe */
    public void m13697Xe() {
        this.bLS.sendMessage(this.bLS.obtainMessage(4102));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xf */
    public void m13698Xf() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "unlock");
        String string = getResources().getString(R.string.xiaoying_str_cam_aelock);
        if ("unlock".equals(appSettingStr)) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" ");
            sb.append(getResources().getString(R.string.xiaoying_str_cam_state_on));
            m13739fd(sb.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK);
        } else if (SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(appSettingStr)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(" ");
            sb2.append(getResources().getString(R.string.xiaoying_str_cam_state_off));
            m13739fd(sb2.toString());
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", "unlock");
        }
        this.bLS.sendMessage(this.bLS.obtainMessage(4105));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xt */
    public void m13699Xt() {
        m13735dm(false);
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bLS.sendEmptyMessage(QEffect.PROP_EFFECT_AUDIO_ADDITIONAL_TIME);
        } else {
            m13730dh(false);
            m13734dl(false);
            mo25858b(this.bSX, true, true);
        }
        if (this.bUu != null) {
            this.bUu.mo26232YI();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xv */
    public void m13700Xv() {
        this.bLS.sendMessage(this.bLS.obtainMessage(4104));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xw */
    public void m13701Xw() {
        m13731di(false);
        m13733dk(false);
        m13730dh(false);
        if (this.bUO.getVisibility() != 0) {
            m13736dn(false);
        } else {
            m13735dm(false);
        }
        if (this.bUu != null) {
            this.bUu.mo26232YI();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dd */
    public void m13729dd(boolean z) {
        if (this.bUu != null) {
            this.bUu.setEnabled(z);
        }
        this.bUG.setEnabled(z);
        if (!z) {
            m13730dh(true);
        }
        if (this.bTp != 0 && z) {
            this.bTq = this.bTp;
            this.mHandler.removeMessages(8196);
            this.bTo.mo26207Yp();
        }
        this.bUH.setEnabled(z);
        if (this.bUu != null) {
            this.bUu.mo26232YI();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dh */
    public void m13730dh(boolean z) {
        C5008i.m12937VU().mo25636cL(false);
        C5008i.m12937VU().mo25643cS(false);
    }

    /* renamed from: di */
    private void m13731di(boolean z) {
        mo25860cl(this.bUk);
        C5008i.m12937VU().mo25639cO(false);
    }

    /* renamed from: dj */
    private void m13732dj(boolean z) {
        mo25804ck(this.bUk);
        C5008i.m12937VU().mo25639cO(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: dk */
    public void m13733dk(boolean z) {
        if (this.bUF.getVisibility() == 0) {
            Activity activity = (Activity) this.bwg.get();
            if (activity != null) {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(((CameraActivityBase) activity).bOx);
                hashMap.put("speed", sb.toString());
                UserBehaviorLog.onKVEvent(activity, "Cam_Speed", hashMap);
            }
            this.bUF.setVisibility(8);
            if (z) {
                this.bUF.startAnimation(this.mHideAnim);
            }
        }
        C5008i.m12937VU().mo25638cN(false);
    }

    /* renamed from: dl */
    private void m13734dl(boolean z) {
        if (this.bUF.getVisibility() != 0) {
            this.bUF.setVisibility(0);
            if (z) {
                this.bUF.startAnimation(this.mShowAnim);
            }
        }
        C5008i.m12937VU().mo25638cN(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: dm */
    public void m13735dm(boolean z) {
        if (this.bUO != null) {
            this.bUO.mo26241ds(z);
        }
    }

    /* renamed from: dn */
    private void m13736dn(boolean z) {
        if (this.bUO != null) {
            this.bUO.mo26242dy(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fd */
    public void m13739fd(String str) {
        this.bSV.clearAnimation();
        this.bSV.setVisibility(0);
        this.bSY.setText(str);
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
            this.bUu = (IndicatorBar) findViewById(R.id.xiaoying_cam_indicator_por);
            if (this.bUu != null) {
                this.bUu.setIndicatorItemClickListener(this.bUo);
            }
            this.bUk = (RecyclerView) findViewById(R.id.pip_listview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
            linearLayoutManager.setOrientation(0);
            this.bUk.setLayoutManager(linearLayoutManager);
            if (this.bOT) {
                mo25851UE();
            }
            this.bSV = (RelativeLayout) findViewById(R.id.effect_tip_layout);
            this.bSY = (TextView) findViewById(R.id.txt_effect_name);
            this.bUC = (RelativeLayout) findViewById(R.id.zoom_tip_layout);
            this.bUD = (TextView) findViewById(R.id.txt_zoom_value);
            this.bUv = (RelativeLayout) findViewById(R.id.cam_loading_layout);
            this.bUw = (ImageView) findViewById(R.id.cam_loading_up);
            this.bUx = (ImageView) findViewById(R.id.cam_loading_down);
            this.bTo = (TimerView) findViewById(R.id.timer_view);
            this.bTo.mo26211a(this.bTI);
            this.bUG = (TopIndicator) findViewById(R.id.cam_layout_title);
            this.bUG.setTopIndicatorClickListener(this.bUQ);
            this.bUd = (TextSeekBar) findViewById(R.id.xiaoying_cam_speed_indicator_por);
            this.bUF = (RelativeLayout) findViewById(R.id.layout_cam_speed_por);
            this.bUc = new SpeedUIManager(this.bUd, false);
            this.bUc.initViewState(((CameraActivityBase) activity).bOx);
            this.bUc.setmOnSpeedChangeListener(new SimpleSpeedChangeListener() {
                public void onSpeedChanged(float f) {
                    Activity activity = (Activity) CameraViewDefaultPor.this.bwg.get();
                    if (activity != null) {
                        ((CameraActivityBase) activity).bOx = f;
                    }
                }
            });
            this.bUH = (ShutterLayoutPor) findViewById(R.id.shutter_layout);
            this.bUH.setShutterLayoutEventListener(this.bUP);
            this.bUH.mo26092a(activity, (CameraViewBase) this);
            this.bUI = (BackDeleteProgressBar) findViewById(R.id.back_delete_progressbar);
            if (!C5034e.m13264s(activity, false)) {
                LayoutParams layoutParams = (LayoutParams) this.bUv.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.v4_xiaoying_cam_top_bar_height);
                this.bUv.setLayoutParams(layoutParams);
            }
            this.bUL = new C5198c(activity, true);
            RelativeLayout relativeLayout = null;
            if (this.bUu != null) {
                relativeLayout = this.bUu.bZD;
            }
            this.bUL.mo26317a(this.bUG.getBtnNext(), this.bUH.getBtnCapRec(), this.bUG, relativeLayout);
            this.bUM = (PipSwapWidget) findViewById(R.id.pip_swap_view);
            this.bUM.setPipOnAddClipClickListener(this.bUl);
            this.bSX = (RelativeLayout) findViewById(R.id.layout_2lev);
            this.bUN = (RelativeLayout) findViewById(R.id.layout_2lev_hide);
            this.bUN.setOnClickListener(this.bTD);
            this.bUi = (RelativeLayout) findViewById(R.id.preview_layout_fake);
            LayoutParams layoutParams2 = (LayoutParams) this.bUi.getLayoutParams();
            LayoutParams layoutParams3 = (LayoutParams) this.bUM.getLayoutParams();
            if (!C5034e.m13264s(activity, false)) {
                layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.v4_xiaoying_cam_top_bar_height);
                layoutParams3.topMargin = getResources().getDimensionPixelSize(R.dimen.v4_xiaoying_cam_top_bar_height);
                this.bUi.setLayoutParams(layoutParams2);
                this.bUM.setLayoutParams(layoutParams3);
                LayoutParams layoutParams4 = (LayoutParams) this.bUI.getLayoutParams();
                layoutParams4.topMargin = getResources().getDimensionPixelSize(R.dimen.v4_xiaoying_cam_top_bar_height) - C4583d.m11670O(activity, 8);
                this.bUI.setLayoutParams(layoutParams4);
            }
            this.bUO = (SettingIndicator) findViewById(R.id.xiaoying_cam_setting_indicator);
            this.bUO.setSettingItemClickListener(this.bUn);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: jz */
    public void m13744jz(int i) {
        int VW = C5008i.m12937VU().mo25610VW();
        if (i != 6 && i != 8 && i != 10 && i != 15) {
            switch (i) {
                case 0:
                    this.bUI.mo26115Ya();
                    this.bUI.setVisibility(4);
                    break;
                case 1:
                    this.bUI.mo26115Ya();
                    this.bUI.setVisibility(4);
                    this.bLS.sendMessage(this.bLS.obtainMessage(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE, 512, VW));
                    this.bUL.mo26315XO();
                    C5198c.m14174dx(false);
                    break;
            }
        } else {
            this.bUI.setVisibility(0);
            this.bUI.mo26114XZ();
        }
        this.bLS.sendMessage(this.bLS.obtainMessage(QEffect.PROP_EFFECT_THEME_POS_TYPE, Integer.valueOf(i)));
        if (C5008i.m12937VU().getDurationLimit() != 0) {
            this.bUG.mo26252YK();
        } else {
            this.bUG.mo26253YL();
        }
    }

    /* renamed from: Oj */
    public final void mo25992Oj() {
        if (((Activity) this.bwg.get()) != null) {
            m13691WV();
            initUI();
        }
    }

    /* renamed from: SY */
    public void mo25791SY() {
        m13729dd(true);
        if (this.bTp != 0) {
            this.bTq = this.bTp;
            this.mHandler.removeMessages(8196);
            this.bTo.mo26207Yp();
        }
        this.bUH.mo26087XL();
    }

    /* renamed from: Tr */
    public void mo25846Tr() {
        VeMSize veMSize = new VeMSize(480, 480);
        if (this.bMj != null) {
            veMSize.width = this.bMj.getWidth();
            veMSize.height = this.bMj.getHeight();
        }
        QPIPFrameParam Wk = C5008i.m12937VU().mo25624Wk();
        if (this.bUh == null) {
            this.bUh = new C5023a(this.bUi, true);
        }
        this.bUh.mo34109a(this.bUr);
        this.bUh.mo34112c(veMSize);
        this.bUh.mo34114s(C5020n.m13113a(Wk, new MSize(veMSize.width, veMSize.height), true));
        this.bUh.refreshView();
    }

    /* renamed from: Ts */
    public void mo25792Ts() {
        int durationLimit = C5008i.m12937VU().getDurationLimit();
        this.bUG.mo26256dA(false);
        if (durationLimit != 0) {
            this.bUI.mo26111XW();
            this.bUI.mo26114XZ();
        }
        this.bUL.mo26315XO();
    }

    /* renamed from: UA */
    public void mo25847UA() {
        ArrayList VZ = C5008i.m12937VU().mo25613VZ();
        int durationLimit = C5008i.m12937VU().getDurationLimit();
        if (durationLimit != 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            int maxProgress = this.bUI.getMaxProgress();
            for (int i = 0; i < VZ.size(); i++) {
                arrayList.add(Integer.valueOf((((Integer) VZ.get(i)).intValue() * maxProgress) / durationLimit));
            }
            this.bUI.setVisibility(0);
            this.bUI.mo26116b(arrayList);
            this.bUI.mo26114XZ();
        }
    }

    /* renamed from: UB */
    public void mo25848UB() {
        this.bUH.mo26082UB();
    }

    /* renamed from: UC */
    public void mo25849UC() {
        m13731di(false);
        this.bUH.update();
        int durationLimit = C5008i.m12937VU().getDurationLimit();
        if (this.bUI != null && durationLimit != 0) {
            this.bUI.reset();
        }
    }

    /* renamed from: UD */
    public void mo25850UD() {
        this.bUH.update();
    }

    /* renamed from: UF */
    public void mo25852UF() {
        if (this.bML != null) {
            this.bML.aNX();
        }
        this.bUH.mo26088XO();
        this.bUG.mo26251XO();
    }

    /* access modifiers changed from: protected */
    /* renamed from: UG */
    public void mo25853UG() {
    }

    /* renamed from: Uj */
    public void mo25793Uj() {
        if (this.bUu != null) {
            this.bUu.update();
        }
        if (!(this.bUc == null || this.bwg == null)) {
            Activity activity = (Activity) this.bwg.get();
            if (activity != null) {
                this.bUc.update(((CameraActivityBase) activity).bOx);
            }
        }
        if (this.bUG != null) {
            this.bUG.update();
        }
        if (this.bUH != null) {
            this.bUH.mo26087XL();
        }
        if (this.bUO != null) {
            this.bUO.update();
        }
    }

    /* renamed from: Uk */
    public void mo25794Uk() {
        this.bUH.mo26083Uk();
    }

    /* renamed from: Ul */
    public boolean mo25795Ul() {
        return this.bTo.mo26209Yr();
    }

    /* renamed from: Um */
    public void mo25796Um() {
        mo25858b(this.bSX, false, true);
        if (this.bUu != null) {
            this.bUu.postDelayed(new Runnable() {
                public void run() {
                    CameraViewDefaultPor.this.m13733dk(false);
                    CameraViewDefaultPor.this.m13730dh(false);
                    CameraViewDefaultPor.this.m13735dm(false);
                    CameraViewDefaultPor.this.bUu.mo26232YI();
                }
            }, 300);
        }
    }

    /* renamed from: Un */
    public void mo25797Un() {
        this.bUH.mo26084Un();
    }

    /* renamed from: Uo */
    public void mo25798Uo() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.bUG.mo26254ae(activity);
        }
    }

    /* renamed from: Up */
    public void mo25799Up() {
        this.bUL.mo26315XO();
        mo25852UF();
    }

    /* renamed from: Uq */
    public boolean mo25800Uq() {
        if (this.bSX.getVisibility() == 0) {
            mo25796Um();
            return true;
        } else if (this.bUL == null || !this.bUL.mo26316YF()) {
            return false;
        } else {
            this.bUL.mo26315XO();
            return true;
        }
    }

    /* renamed from: Ux */
    public void mo25854Ux() {
        this.bUH.mo26085Ux();
    }

    /* renamed from: Uy */
    public void mo25855Uy() {
        if (this.bUw != null && this.bUw.getVisibility() == 0) {
            this.bUw.setVisibility(4);
            this.bUw.startAnimation(this.bUy);
        }
        if (this.bUx != null && this.bUx.getVisibility() == 0) {
            this.bUx.setVisibility(4);
            this.bUx.startAnimation(this.bUB);
        }
    }

    /* renamed from: Uz */
    public void mo25856Uz() {
        if (this.bUw != null) {
            this.bUw.clearAnimation();
            this.bUw.setVisibility(0);
        }
        if (this.bUx != null) {
            this.bUx.clearAnimation();
            this.bUx.setVisibility(0);
        }
    }

    /* renamed from: a */
    public void mo25857a(int i, QPIPFrameParam qPIPFrameParam) {
        if (this.bUM != null) {
            this.bUM.mo26184c(i, qPIPFrameParam);
        }
    }

    /* renamed from: a */
    public void mo25801a(Long l, int i) {
        if (CameraCodeMgr.isCameraParamPIP(this.bOz) && this.bUt != null) {
            this.bUt.mo25917b(l, i);
            this.bUt.notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public void mo25802b(RelativeLayout relativeLayout) {
        this.bMj = relativeLayout;
        mo25793Uj();
        this.bUH.mo26093b(relativeLayout);
    }

    /* renamed from: b */
    public void mo25803b(MusicDataItem musicDataItem) {
    }

    /* renamed from: bU */
    public void mo25859bU(int i, int i2) {
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bUG.mo26255bU(i, i2);
            this.bUJ = i;
            this.bUK = i2;
        }
    }

    /* renamed from: cm */
    public void mo25805cm(boolean z) {
        if (this.bUt != null) {
            this.bUt.notifyDataSetChanged();
        }
    }

    /* renamed from: cp */
    public void mo25861cp(boolean z) {
    }

    /* renamed from: cq */
    public void mo25862cq(boolean z) {
    }

    public View getTopIndicatorView() {
        return this.bUG;
    }

    /* renamed from: iF */
    public void mo25808iF(int i) {
        this.bUG.setProgress(i);
    }

    public void onDestroy() {
        this.bLS = null;
        this.bML = null;
    }

    public void onPause() {
        if (this.bUL != null) {
            this.bUL.onPause();
        }
        if (this.bUH != null) {
            this.bUH.onPause();
        }
        if (this.bUG != null) {
            this.bUG.onPause();
        }
    }

    public void onResume() {
        LogUtils.m14223i("CameraViewDefaultPor", "onResume() < ---------");
    }

    /* renamed from: p */
    public boolean mo25812p(MotionEvent motionEvent) {
        boolean p = this.bUH.mo26098p(motionEvent);
        if (p) {
            return true;
        }
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            if (this.bUM != null) {
                p = this.bUM.mo26185p(motionEvent);
            }
            if (p) {
                return true;
            }
        }
        return p;
    }

    public void setCameraMode(int i, int i2, boolean z) {
        if (((Activity) this.bwg.get()) != null) {
            this.bOz = i2;
            this.bTp = 0;
            C5008i.m12937VU().mo25656jk(this.bTp);
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_timer_onoff_key", "off");
            int durationLimit = C5008i.m12937VU().getDurationLimit();
            if (durationLimit != 0) {
                this.bUG.mo26252YK();
            } else {
                this.bUG.mo26253YL();
            }
            if (durationLimit != 0) {
                this.bUI.setVisibility(0);
                this.bUI.mo26114XZ();
            } else {
                this.bUI.setVisibility(4);
                this.bUI.mo26115Ya();
            }
            this.bTo.mo26208Yq();
            this.bUG.mo26257dz(false);
            m13730dh(false);
            m13731di(false);
            if (!CameraCodeMgr.isCameraParamDefault(i2)) {
                m13733dk(false);
            }
            m13735dm(false);
            mo25791SY();
            this.bUM.setVisibility(4);
            this.bUi.setVisibility(8);
            if (i == 256 && CameraCodeMgr.isCameraParamPIP(i2)) {
                this.bUi.setVisibility(0);
                m13732dj(true);
                C5008i.m12937VU().mo25641cQ(true);
                this.bUM.setVisibility(0);
                C5198c.m14174dx(false);
            }
            this.bUH.mo26090XT();
            boolean jL = C5030b.m13205jL(this.bOz);
            C5030b.m13201C(this.bOz, jL);
            C5008i.m12937VU().mo25634cJ(jL);
            this.bUH.mo26087XL();
            if (this.bUu != null) {
                this.bUu.mo26232YI();
            }
            this.bUL.mo26314XL();
        }
    }

    public void setClipCount(int i, boolean z) {
        if (((Activity) this.bwg.get()) != null) {
            this.bUG.update();
            this.bUH.mo26091XU();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            String sb2 = sb.toString();
            if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                if (this.bUu != null) {
                    this.bUu.update();
                }
                int VO = C5006h.m12925VO();
                if (-1 != VO) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("");
                    sb3.append(C5006h.m12926jf(VO));
                    sb2 = sb3.toString();
                }
            }
            this.bUG.setClipCount(sb2);
        }
    }

    public void setCurrentTimeValue(long j) {
        this.bUG.setTimeValue(j);
        this.bUJ = (int) j;
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
            java.lang.String r2 = "CameraViewDefaultPor"
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
            r0.m13739fd(r1)     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r0)
            return
        L_0x0045:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p233ui.camview.CameraViewDefaultPor.setEffect(int, boolean, boolean, boolean):void");
    }

    public void setEffectMgr(C8759b bVar) {
        if (((Activity) this.bwg.get()) != null) {
            this.bOt = bVar;
        }
    }

    public void setPipEffect(int i, boolean z) {
        if ((this.bTQ != i || z) && this.bUt != null && i >= 0 && i < this.bUt.getItemCount()) {
            LogUtils.m14223i("CameraViewDefaultPor", "setPipEffect() < ---------");
            this.bTQ = i;
            if (this.bUt != null) {
                this.bUt.mo25919jt(this.bTQ);
                this.bUt.notifyDataSetChanged();
            }
        }
    }

    public void setPipEffectMgr(C8759b bVar) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.bUE = bVar;
            if (this.bUt == null) {
                this.bUt = new C5048b(activity);
                this.bUt.setEffectMgr(this.bUE);
                this.bUt.mo25918db(this.bTS);
                this.bUk.setAdapter(this.bUt);
                this.bUt.mo25915a(this.bUp);
            } else {
                this.bUt.notifyDataSetChanged();
            }
        }
    }

    public void setState(int i, MSize mSize) {
        if (this.mState != i) {
            this.mState = i;
            switch (this.mState) {
                case 2:
                    mo25852UF();
                    m13733dk(false);
                    m13735dm(false);
                    if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                        m13731di(false);
                        C5008i.m12937VU().mo25641cQ(false);
                        if (this.bUu != null) {
                            this.bUu.update();
                        }
                    }
                    m13730dh(false);
                    this.bUI.mo26115Ya();
                    this.bUI.post(this.bUR);
                    break;
                case 5:
                    this.bUI.mo26114XZ();
                    break;
                case 6:
                    this.bUI.mo26110XV();
                    this.bUI.mo26114XZ();
                    break;
            }
            this.bUG.update();
            if (this.bUu != null) {
                this.bUu.mo26232YI();
            }
            this.bUH.mo26086XJ();
            this.bUL.mo26313XJ();
        }
    }

    public void setTimeExceed(boolean z) {
        this.bUG.setTimeExceed(z);
    }

    public void setZoomValue(double d) {
        this.bUC.clearAnimation();
        this.bUC.setVisibility(0);
        TextView textView = this.bUD;
        StringBuilder sb = new StringBuilder();
        sb.append("x");
        sb.append(d);
        textView.setText(sb.toString());
        this.mHandler.removeMessages(8195);
        this.mHandler.sendEmptyMessageDelayed(8195, 1000);
    }
}
