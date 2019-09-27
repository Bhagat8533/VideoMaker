package com.introvd.template.camera.p233ui.camview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.p024v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1899e;
import com.introvd.template.camera.base.AbstractCameraView;
import com.introvd.template.camera.base.CameraActivityBase;
import com.introvd.template.camera.base.CameraNewViewBase;
import com.introvd.template.camera.p208a.C4662a;
import com.introvd.template.camera.p208a.C4663b;
import com.introvd.template.camera.p208a.C4669h;
import com.introvd.template.camera.p208a.C4671j;
import com.introvd.template.camera.p229b.C4989b;
import com.introvd.template.camera.p229b.C4989b.C4990a;
import com.introvd.template.camera.p229b.C4999g;
import com.introvd.template.camera.p229b.C4999g.C5004b;
import com.introvd.template.camera.p229b.C4999g.C5005c;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p232e.C5030b;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.camera.p233ui.facial.C5138c;
import com.introvd.template.camera.p233ui.facial.CameraFacialView;
import com.introvd.template.camera.p233ui.shutter.CamShutterLayout;
import com.introvd.template.camera.p233ui.view.BackDeleteTextButton;
import com.introvd.template.camera.p233ui.view.BeautyLevelBar;
import com.introvd.template.camera.p233ui.view.C5179a;
import com.introvd.template.camera.p233ui.view.C5179a.C5181a;
import com.introvd.template.camera.p233ui.view.MusicControlView;
import com.introvd.template.camera.p233ui.view.MusicControlView.C5171a;
import com.introvd.template.camera.p233ui.view.TimerView;
import com.introvd.template.camera.p233ui.view.TimerView.C5178b;
import com.introvd.template.camera.p233ui.view.indicator.TopIndicatorNew;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.MSize;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.template.widget.p412a.C8928b;
import com.introvd.template.template.widget.p412a.C8928b.C8935a;
import com.introvd.template.template.widget.p412a.C8937c;
import com.introvd.template.template.widget.p412a.p413a.C8925e;
import com.introvd.template.template.widget.p412a.p413a.C8926f;
import com.introvd.template.template.widget.p412a.p413a.C8927g;
import com.introvd.template.vivacamera.R;
import com.introvd.template.xyui.C9136a;
import com.p131c.p132a.p135c.C2575a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import xiaoying.engine.clip.QEffect;

/* renamed from: com.introvd.template.camera.ui.camview.CameraFuncView */
public class CameraFuncView extends CameraNewViewBase {
    private C9136a bML;
    /* access modifiers changed from: private */
    public C4999g bNr;
    private int bOB = 0;
    /* access modifiers changed from: private */
    public int bOz = 1;
    /* access modifiers changed from: private */
    public long bSR = 0;
    /* access modifiers changed from: private */
    public C8928b bSS;
    /* access modifiers changed from: private */
    public C8937c bST;
    private ArrayList<C8927g> bSU;
    /* access modifiers changed from: private */
    public RelativeLayout bSV;
    private RelativeLayout bSW;
    /* access modifiers changed from: private */
    public RelativeLayout bSX;
    private TextView bSY;
    private TextView bSZ;
    private C5138c bTA = new C5138c() {
        /* renamed from: e */
        public void mo25968e(TemplateInfo templateInfo) {
            if (CameraFuncView.this.bLS != null) {
                Message obtainMessage = CameraFuncView.this.bLS.obtainMessage(65585, C2575a.parseInt(C8399c.edg), 0);
                if (templateInfo != null) {
                    obtainMessage.obj = templateInfo;
                }
                CameraFuncView.this.bLS.sendMessage(obtainMessage);
            }
        }

        /* renamed from: f */
        public void mo25969f(TemplateInfo templateInfo) {
            if (CameraFuncView.this.bLS != null && CameraFuncView.this.bST != null && templateInfo != null) {
                Message obtainMessage = CameraFuncView.this.bLS.obtainMessage(65586, Integer.valueOf(C2575a.parseInt(C8399c.edg)).intValue(), 0);
                obtainMessage.obj = templateInfo;
                CameraFuncView.this.bLS.sendMessage(obtainMessage);
            }
        }
    };
    /* access modifiers changed from: private */
    public C4669h bTB = new C4669h() {
        /* renamed from: UH */
        public void mo24983UH() {
            CameraFuncView.this.bTh.mo26284dA(false);
        }

        /* renamed from: UI */
        public void mo24984UI() {
            CameraFuncView.this.m13418dg(false);
            if (CameraFuncView.this.bLS != null) {
                CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(4097));
            }
        }

        /* renamed from: UJ */
        public void mo24985UJ() {
            if (CameraFuncView.this.bLS != null) {
                CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(4098));
            }
        }

        /* renamed from: UK */
        public void mo24986UK() {
            if (CameraFuncView.this.bLS != null) {
                CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(QEffect.PROP_VIDEO_FRAME_ROTATION));
            }
        }

        /* renamed from: UL */
        public void mo24987UL() {
            CameraFuncView.this.m13350Xg();
        }

        /* renamed from: UM */
        public void mo24988UM() {
            CameraFuncView.this.mo25954UF();
            if (CameraFuncView.this.bTo != null) {
                CameraFuncView.this.bTo.mo26210Ys();
            }
        }

        /* renamed from: UN */
        public void mo24989UN() {
            CameraFuncView.this.mo25791SY();
        }

        /* renamed from: UO */
        public void mo24990UO() {
            CameraFuncView.this.m13344Xa();
        }

        /* renamed from: UP */
        public void mo24991UP() {
            CameraFuncView.this.m13344Xa();
        }

        /* renamed from: UQ */
        public void mo24992UQ() {
        }

        /* renamed from: UR */
        public void mo24993UR() {
        }

        /* renamed from: US */
        public void mo24994US() {
            C5031c.m13216al(CameraFuncView.this.getContext().getApplicationContext(), "hold");
        }

        /* renamed from: a */
        public void mo24995a(C4990a aVar) {
            if (CameraFuncView.this.bOu != null) {
                CameraFuncView.this.bOu.mo25709iG(C4989b.m12746iP(C5008i.m12937VU().mo25609VV()).indexOf(aVar));
            }
        }

        /* renamed from: cr */
        public void mo24996cr(boolean z) {
            if (z) {
                C5031c.m13229o(CameraFuncView.this.getContext().getApplicationContext(), true);
                CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(QEffect.PROP_EFFECT_PROPDATA));
                CameraFuncView.this.mo25792Ts();
                return;
            }
            CameraFuncView.this.bTh.mo26284dA(true);
        }

        /* renamed from: cs */
        public void mo24997cs(boolean z) {
            CameraFuncView.this.m13415dd(z);
        }

        /* renamed from: ct */
        public void mo24998ct(boolean z) {
            if (!z) {
                C5031c.m13216al(CameraFuncView.this.getContext().getApplicationContext(), "tap");
            }
        }

        /* renamed from: iM */
        public void mo24999iM(int i) {
            if (i == 0) {
                CameraFuncView.this.m13345Xb();
            } else {
                CameraFuncView.this.mo25835a(true, null, null, true);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean bTC;
    private OnClickListener bTD = new OnClickListener() {
        public void onClick(View view) {
            if (view.getId() == R.id.zoom_left_btn) {
                ((OnSeekBarChangeListener) CameraFuncView.this.getContext()).onProgressChanged(CameraFuncView.this.bTf, CameraFuncView.this.bTf.getProgress() - 1, true);
            } else if (view.getId() == R.id.zoom_right_btn) {
                ((OnSeekBarChangeListener) CameraFuncView.this.getContext()).onProgressChanged(CameraFuncView.this.bTf, CameraFuncView.this.bTf.getProgress() + 1, true);
            }
        }
    };
    private C4671j bTE = new C4671j() {
        /* renamed from: UT */
        public void mo25004UT() {
            CameraFuncView.this.m13348Xe();
        }

        /* renamed from: UV */
        public void mo25005UV() {
            CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(4104));
            C5031c.m13213ai(CameraFuncView.this.getContext(), C5034e.m13235R(CameraFuncView.this.getContext(), CameraFuncView.this.bOz));
        }

        /* renamed from: cm */
        public void mo25006cm(View view) {
            CameraFuncView.this.mo25955c(CameraFuncView.this.bSX, false, false);
            CameraFuncView.this.bTl.setViewVisibility(8);
            CameraFuncView.this.bSX.postDelayed(new Runnable() {
                public void run() {
                    CameraFuncView.this.m13353Xj();
                }
            }, 300);
            CameraFuncView.this.mo25956cn(view);
            C5031c.m13214aj(CameraFuncView.this.getContext(), C5034e.m13235R(CameraFuncView.this.getContext(), CameraFuncView.this.bOz));
        }

        /* renamed from: iO */
        public void mo25007iO(int i) {
            CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(4145, i, C5008i.m12937VU().mo25610VW()));
            CameraFuncView.this.mo25954UF();
        }
    };
    private C4663b bTF = new C4663b() {
        /* renamed from: iI */
        public void mo24977iI(int i) {
            switch (i) {
            }
            if (CameraFuncView.this.bLS != null) {
                CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(4137, i, 0));
            }
        }
    };
    private boolean bTG;
    private boolean bTH;
    private C5178b bTI = new C5178b() {
        /* renamed from: jw */
        public void mo25958jw(int i) {
            CameraFuncView.this.bTp = i;
            CameraFuncView.this.bTq = CameraFuncView.this.bTp;
            C5008i.m12937VU().mo25656jk(CameraFuncView.this.bTp);
        }

        /* renamed from: jx */
        public void mo25959jx(int i) {
            if (CameraFuncView.this.mHandler != null) {
                CameraFuncView.this.mHandler.sendMessage(CameraFuncView.this.mHandler.obtainMessage(8196));
            }
        }
    };
    private TextView bTa;
    private TextView bTb;
    private TextView bTc;
    /* access modifiers changed from: private */
    public LinearLayout bTd;
    private LinearLayout bTe;
    /* access modifiers changed from: private */
    public SeekBar bTf;
    /* access modifiers changed from: private */
    public MusicControlView bTg;
    /* access modifiers changed from: private */
    public TopIndicatorNew bTh;
    /* access modifiers changed from: private */
    public CamShutterLayout bTi;
    /* access modifiers changed from: private */
    public BeautyLevelBar bTj;
    private RecyclerView bTk;
    /* access modifiers changed from: private */
    public CameraFacialView bTl;
    private C5179a bTm;
    /* access modifiers changed from: private */
    public BackDeleteTextButton bTn;
    /* access modifiers changed from: private */
    public TimerView bTo;
    /* access modifiers changed from: private */
    public int bTp = 0;
    /* access modifiers changed from: private */
    public int bTq = 0;
    private int bTr = -1;
    private boolean bTs;
    private boolean bTt;
    private boolean bTu;
    /* access modifiers changed from: private */
    public Animation bTv;
    private Animation bTw;
    private boolean bTx = false;
    private int bTy = 0;
    private int bTz = 0;
    /* access modifiers changed from: private */
    public WeakReference<Activity> bwg;
    /* access modifiers changed from: private */
    public Handler mHandler = new C5086a(this);
    private int mOrientation = 256;
    /* access modifiers changed from: private */
    public int mState = -1;

    /* renamed from: com.introvd.template.camera.ui.camview.CameraFuncView$a */
    private static class C5086a extends WeakHandler<CameraFuncView> {
        public C5086a(CameraFuncView cameraFuncView) {
            super(cameraFuncView);
        }

        public void handleMessage(Message message) {
            CameraFuncView cameraFuncView = (CameraFuncView) getOwner();
            if (cameraFuncView != null) {
                switch (message.what) {
                    case 8194:
                        removeMessages(8194);
                        cameraFuncView.bSV.setVisibility(8);
                        cameraFuncView.bSV.startAnimation(cameraFuncView.bTv);
                        break;
                    case 8195:
                        removeMessages(8195);
                        cameraFuncView.bTd.setVisibility(8);
                        cameraFuncView.bTd.startAnimation(cameraFuncView.bTv);
                        sendEmptyMessageDelayed(8197, (long) ((int) cameraFuncView.bTv.getDuration()));
                        break;
                    case 8196:
                        removeMessages(8196);
                        cameraFuncView.m13415dd(false);
                        if (cameraFuncView.bTq > 0 && cameraFuncView.mState != 2) {
                            cameraFuncView.bMf.mo25896jO(4100);
                            cameraFuncView.bTq = cameraFuncView.bTq - 1;
                            break;
                        } else {
                            cameraFuncView.bTo.mo26208Yq();
                            if (cameraFuncView.bLS != null) {
                                cameraFuncView.bLS.sendMessage(cameraFuncView.bLS.obtainMessage(4097));
                                break;
                            }
                        }
                        break;
                    case 8197:
                        if (cameraFuncView.mState == 0 || cameraFuncView.mState == 1 || cameraFuncView.mState == 6 || cameraFuncView.mState == -1) {
                            if (CameraCodeMgr.isParamBeautyEnable(cameraFuncView.bOz) && cameraFuncView.bTj != null && cameraFuncView.bTj.getVisibility() != 0 && !cameraFuncView.bTl.isShown()) {
                                cameraFuncView.bTj.setVisibility(0);
                            }
                            if (!(!CameraCodeMgr.isParamMVEnable(cameraFuncView.bOz) || cameraFuncView.bTg == null || cameraFuncView.bTg.getVisibility() == 0)) {
                                cameraFuncView.bTg.setVisibility(0);
                                break;
                            }
                        }
                }
            }
        }
    }

    public CameraFuncView(Activity activity) {
        super(activity);
        this.bwg = new WeakReference<>(activity);
        this.bML = new C9136a((Activity) this.bwg.get());
        LayoutInflater.from(activity).inflate(R.layout.cam_view_ver_new, this, true);
        mo25953Oj();
        this.bTw = AnimationUtils.loadAnimation(getContext(), R.anim.xiaoying_no_face_detected_anim);
    }

    public CameraFuncView(Context context) {
        super(context);
    }

    /* renamed from: WV */
    private void m13338WV() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.mShowAnim = C4562a.m11532Se();
            this.mHideAnim = C4562a.m11531Sd();
            this.bTv = AnimationUtils.loadAnimation(activity, R.anim.xiaoying_anim_effect_tips_alpha);
            this.bOP = AnimationUtils.loadAnimation(activity, R.anim.xiaoying_slide_out_left_self);
            this.bOQ = AnimationUtils.loadAnimation(activity, R.anim.xiaoying_slide_in_left_self);
            this.bOR = C4562a.m11532Se();
            this.bOS = C4562a.m11531Sd();
        }
    }

    @TargetApi(17)
    /* renamed from: WW */
    private void m13339WW() {
        LayoutParams layoutParams = (LayoutParams) this.bTb.getLayoutParams();
        if (layoutParams == null || layoutParams.leftMargin != 0) {
            if (layoutParams == null) {
                this.bTx = false;
            }
            return;
        }
        int measuredWidth = this.bTb.getMeasuredWidth();
        int measuredHeight = this.bTb.getMeasuredHeight();
        if (measuredWidth == 0 || measuredHeight == 0) {
            this.bTx = false;
            return;
        }
        int O = ((measuredWidth - measuredHeight) / 2) - C4583d.m11670O(getContext(), 20);
        if (O <= 0) {
            O = -O;
        }
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(-O);
        } else {
            layoutParams.leftMargin = -O;
        }
        this.bTb.setLayoutParams(layoutParams);
        LayoutParams layoutParams2 = (LayoutParams) this.bTa.getLayoutParams();
        if (layoutParams2 != null && layoutParams2.rightMargin == 0) {
            if (VERSION.SDK_INT >= 17) {
                layoutParams2.setMarginEnd(-O);
            } else {
                layoutParams2.rightMargin = -O;
            }
            this.bTa.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: WX */
    public void m13340WX() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_camera_swipe_change_filter_effect", false) && this.bML != null && !AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_camera_ratio_tip", false) && this.bTh != null && this.bTh.getVisibility() == 0) {
            this.bML.mo36087f(this.bTh.getRatioBtn(), 12, C4580b.m11666qi());
            this.bML.mo36086dt(activity.getResources().getString(R.string.xiaoying_str_cam_help_ratio_tip));
            this.bML.show();
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_camera_ratio_tip", true);
        }
    }

    /* renamed from: WY */
    private void m13341WY() {
        if (!(((Activity) this.bwg.get()) == null || this.bSW == null || this.bSW.getVisibility() == 0 || AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_camera_swipe_change_filter_effect", false))) {
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.topMargin = (int) (((double) Constants.getScreenSize().height) * 0.275d);
            layoutParams.addRule(14);
            this.bSW.setLayoutParams(layoutParams);
            this.bSW.setVisibility(0);
            C4562a.m11538cb(this.bSW);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_camera_swipe_change_filter_effect", true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: WZ */
    public void m13342WZ() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(activity.getApplication().getString(R.string.xiaoying_str_cam_retake_directly));
            arrayList.add(activity.getApplication().getString(R.string.xiaoying_str_cam_retake_change_music));
            new C1895a(activity).mo10288aA(false).mo10286a((Collection) arrayList).mo10280a((C1899e) new C1899e() {
                /* renamed from: a */
                public void mo10328a(C1890f fVar, View view, int i, CharSequence charSequence) {
                    if (i == 0) {
                        CameraFuncView.this.bTg.setMusicProgress(0);
                        CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(QEffect.PROP_AUDIO_FRAME_FADEIN));
                    } else if (1 == i) {
                        CameraFuncView.this.mo25954UF();
                        CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(QEffect.PROP_VIDEO_FRAME_ROTATION));
                    }
                }
            }).mo10313qu().show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xa */
    public void m13344Xa() {
        if (this.bLS != null) {
            this.bLS.sendMessage(this.bLS.obtainMessage(4101));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xb */
    public void m13345Xb() {
        m13355Xl();
        m13417df(false);
        m13354Xk();
        mo25955c(this.bSX, true, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: Xc */
    public void m13346Xc() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_grid", "off");
        if (appSettingStr.equals("off")) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_grid", "on");
        } else if ("on".equals(appSettingStr)) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_grid", "off");
        }
        this.bLS.sendMessage(this.bLS.obtainMessage(4105));
        C5031c.m13211a(getContext(), appSettingStr.equals("off"), C5034e.m13235R(getContext(), this.bOz));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xd */
    public void m13347Xd() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_flash_mode", "no_flash");
        if (appSettingStr.equals("off")) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_flash_mode", "on");
        } else if ("on".equals(appSettingStr)) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_flash_mode", "off");
        }
        this.bLS.sendMessage(this.bLS.obtainMessage(4105));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xe */
    public void m13348Xe() {
        this.bLS.sendMessage(this.bLS.obtainMessage(4102));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xf */
    public void m13349Xf() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "unlock");
        String string = getResources().getString(R.string.xiaoying_str_cam_aelock);
        if ("unlock".equals(appSettingStr)) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" ");
            sb.append(getResources().getString(R.string.xiaoying_str_cam_state_on));
            this.bSZ.setText(sb.toString());
            this.bSZ.setVisibility(0);
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK);
        } else if (SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(appSettingStr)) {
            this.bSZ.setVisibility(4);
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", "unlock");
        }
        this.bLS.sendMessage(this.bLS.obtainMessage(4105));
    }

    /* access modifiers changed from: private */
    /* renamed from: Xg */
    public void m13350Xg() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.bML.mo36087f(activity.findViewById(R.id.cam_layout_main), 1, C4580b.m11666qi());
            this.bML.mo36086dt(activity.getResources().getString(R.string.xiaoying_str_cam_music_clip_complete_tip));
            this.bML.show();
        }
    }

    /* renamed from: Xh */
    private void m13351Xh() {
        if (this.bST != null) {
            this.bST.aMB();
            this.bST.mo35573qM("0");
            this.bSU = this.bST.aMC();
        }
    }

    /* renamed from: Xi */
    private void m13352Xi() {
        if (this.bST != null) {
            this.bST.aMB();
            this.bST.mo35573qM("2");
            this.bSU = this.bST.aMC();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xj */
    public void m13353Xj() {
        if (this.bTi != null) {
            C4562a.m11535bZ(this.bTi);
        }
        if (this.bTj != null && CameraCodeMgr.isParamBeautyEnable(this.bOz) && !this.bTf.isShown()) {
            C4562a.m11535bZ(this.bTj);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xk */
    public void m13354Xk() {
        if (this.bTi != null) {
            this.bTi.mo26050XO();
            C4562a.m11537ca(this.bTi);
        }
        if (this.bTj != null && CameraCodeMgr.isParamBeautyEnable(this.bOz)) {
            C4562a.m11537ca(this.bTj);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Xl */
    public void m13355Xl() {
        if (this.bTm != null) {
            this.bTm.dismiss();
        }
    }

    /* renamed from: Xm */
    private void m13356Xm() {
        if (this.bTe != null && this.bTe.getVisibility() != 0) {
            this.bTe.setVisibility(0);
            this.bTe.startAnimation(this.bTw);
        }
    }

    /* renamed from: Xn */
    private void m13357Xn() {
        if (this.bTe != null && this.bTe.getVisibility() == 0) {
            this.bTe.clearAnimation();
            this.bTe.setVisibility(8);
        }
    }

    /* renamed from: Y */
    private void m13359Y(final String str, final String str2) {
        if (this.bTl != null && TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public boolean onPreDraw() {
                    CameraFuncView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    CameraFuncView.this.bTl.setVisibility(0);
                    CameraFuncView.this.bTl.mo26017g(str, C8762d.aMt().getTemplateID(str2));
                    return false;
                }
            });
        }
    }

    /* renamed from: al */
    private void m13389al(long j) {
        if (j > 0) {
            String templateExternalFile = C8762d.aMt().getTemplateExternalFile(j, 0, 1002);
            String templateExternalFile2 = C8762d.aMt().getTemplateExternalFile(j, 0, 1003);
            if (!TextUtils.isEmpty(templateExternalFile)) {
                if (this.bNr == null) {
                    this.bNr = new C4999g(false);
                } else {
                    this.bNr.setLooping(false);
                }
                this.bNr.mo25580a((C5004b) null);
                this.bTH = false;
                this.bTG = true;
                this.bNr.mo25581eW(templateExternalFile);
                return;
            } else if (!TextUtils.isEmpty(templateExternalFile2)) {
                if (this.bNr == null) {
                    this.bNr = new C4999g(true);
                } else {
                    this.bNr.setLooping(true);
                }
                this.bNr.mo25580a((C5004b) new C5005c() {
                    public void onPrepared() {
                        CameraFuncView.this.bNr.play();
                    }
                });
                this.bTH = true;
                this.bTG = false;
                this.bNr.mo25581eW(templateExternalFile2);
                return;
            }
        }
        this.bTH = false;
        this.bTG = false;
        if (this.bNr != null && this.bNr.mo25576VK()) {
            this.bNr.reset();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13408b(TemplateInfo templateInfo, int i) {
        Message obtainMessage = this.bLS.obtainMessage(65585, i, 0);
        if (templateInfo instanceof RollInfo) {
            templateInfo.strUrl = ((RollInfo) templateInfo).rollModel.rollDownUrl;
        }
        obtainMessage.obj = templateInfo;
        this.bLS.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: dc */
    public void m13414dc(boolean z) {
        Message message = new Message();
        message.what = QEffect.PROP_EFFECT_POSITION_ALIGNMENT;
        message.obj = Boolean.valueOf(z);
        this.bLS.sendMessage(message);
    }

    /* access modifiers changed from: private */
    /* renamed from: dd */
    public void m13415dd(boolean z) {
        this.bTh.setEnabled(z);
        if (this.bTp != 0 && z) {
            this.bTq = this.bTp;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(8196);
            }
            this.bTo.mo26207Yp();
        }
        this.bTi.setEnabled(z);
    }

    /* renamed from: de */
    private void m13416de(boolean z) {
        if (this.bSS == null) {
            this.bSS = new C8928b(getContext());
            this.bSS.mo35552a(this.bTk, this.bSU, this.bOt);
            this.bSS.mo35553a((C8935a) new C8935a() {
                /* renamed from: Xs */
                public void mo25960Xs() {
                    C5031c.m13225dS(CameraFuncView.this.getContext().getApplicationContext());
                    CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(QEffect.PROP_AUDIO_FRAME_RANGE));
                }

                /* renamed from: a */
                public void mo25961a(C8925e eVar) {
                    if (((Activity) CameraFuncView.this.bwg.get()) != null) {
                        CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(4099, CameraFuncView.this.bOt.mo35205bx(eVar.aMN().aMI()), 0));
                    }
                }

                /* renamed from: a */
                public void mo25962a(C8926f fVar) {
                    CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(4099, 0, 0));
                }

                /* renamed from: b */
                public void mo25963b(C8926f fVar) {
                    if (CameraFuncView.this.bLS != null && CameraFuncView.this.bST != null && fVar != null && fVar.aMP() != null) {
                        Message obtainMessage = CameraFuncView.this.bLS.obtainMessage(65586, Integer.valueOf(C2575a.parseInt(C8399c.ecY)).intValue(), 0);
                        obtainMessage.obj = CameraFuncView.this.bST.mo35575qP(fVar.aMP().aMR());
                        CameraFuncView.this.bLS.sendMessage(obtainMessage);
                    }
                }

                /* renamed from: c */
                public void mo25964c(C8926f fVar) {
                    if (CameraFuncView.this.bLS != null && CameraFuncView.this.bST != null && fVar != null && fVar.aMP() != null) {
                        int parseInt = C2575a.parseInt(C8399c.ecY);
                        CameraFuncView.this.m13408b(CameraFuncView.this.bST.mo35575qP(fVar.aMP().aMR()), parseInt);
                    }
                }

                /* renamed from: jy */
                public void mo25965jy(int i) {
                    if (CameraFuncView.this.bSS != null) {
                        CameraFuncView.this.m13428ju(CameraFuncView.this.bOt.mo35205bx(CameraFuncView.this.bSR));
                        if (CameraFuncView.this.bSX.getVisibility() == 0) {
                            CameraFuncView.this.bSS.mo35563vr(i);
                        }
                    }
                }
            });
            return;
        }
        this.bSS.mo35557b(this.bOt);
        this.bSS.mo35559e(this.bSU, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: df */
    public void m13417df(boolean z) {
        if (this.bTj != null) {
            this.bTj.mo26129ds(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dg */
    public void m13418dg(boolean z) {
        this.bSV.clearAnimation();
        if (this.mHandler != null) {
            this.mHandler.removeMessages(8194);
            if (z) {
                this.mHandler.sendEmptyMessage(8194);
            } else {
                this.bSV.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fb */
    public void m13422fb(String str) {
        if (!(this.bSS == null || this.bST == null || C8937c.m26270qR(str) == 2)) {
            Activity activity = (Activity) this.bwg.get();
            if (activity != null) {
                this.bSS.mo35561qL(str);
                if (C4600l.m11739k(activity, true)) {
                    m13408b(this.bST.mo35575qP(str), C2575a.parseInt(C8399c.ecY));
                }
            }
        }
    }

    /* renamed from: fc */
    private void m13423fc(String str) {
        this.bSV.clearAnimation();
        this.bSV.setVisibility(0);
        this.bSY.setText(str);
        this.mHandler.removeMessages(8194);
        this.mHandler.sendEmptyMessageDelayed(8194, 1000);
    }

    private void initUI() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.bTl = (CameraFacialView) findViewById(R.id.pasterpanel);
            this.bTl.setOnItemClickListener(this.bTA);
            this.bTk = (RecyclerView) findViewById(R.id.effect_listview);
            this.bTk.setHasFixedSize(true);
            this.bSV = (RelativeLayout) findViewById(R.id.effect_tip_layout);
            this.bSY = (TextView) findViewById(R.id.txt_effect_name);
            this.bTd = (LinearLayout) findViewById(R.id.zoom_tip_layout);
            this.bTf = (SeekBar) findViewById(R.id.zoom_progress);
            int O = C4583d.m11670O((Context) this.bwg.get(), 5);
            this.bTf.setPadding(O, 0, O, 0);
            ((LayerDrawable) this.bTf.getProgressDrawable()).findDrawableByLayerId(16908288).setLevel(1);
            this.bTf.setOnSeekBarChangeListener((OnSeekBarChangeListener) getContext());
            findViewById(R.id.zoom_left_btn).setOnClickListener(this.bTD);
            findViewById(R.id.zoom_right_btn).setOnClickListener(this.bTD);
            this.bTg = (MusicControlView) findViewById(R.id.xiaoying_cam_mode_music_view);
            this.bTg.setControlListener(new C5171a() {
                /* renamed from: Xo */
                public void mo25957Xo() {
                    if (CameraFuncView.this.mState != 2) {
                        boolean z = CameraFuncView.this.bTg != null && CameraFuncView.this.bOs.mo25576VK() && CameraFuncView.this.bOs.mo25577VL() != null && CameraFuncView.this.bOs.mo25577VL().currentTimeStamp <= 0;
                        if (!CameraFuncView.this.bOs.mo25576VK() || z) {
                            CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(QEffect.PROP_VIDEO_FRAME_ROTATION));
                        } else {
                            CameraFuncView.this.m13342WZ();
                        }
                    }
                }
            });
            this.bTn = (BackDeleteTextButton) findViewById(R.id.cam_btn_delete);
            this.bTn.setDeleteSwitchClickListener(new C4662a() {
                /* renamed from: cr */
                public void mo24976cr(boolean z) {
                    CameraFuncView.this.bTi.mo26050XO();
                    C5031c.m13229o(CameraFuncView.this.getContext().getApplicationContext(), false);
                    CameraFuncView.this.bTn.setDeleteEnable(true);
                    CameraFuncView.this.m13414dc(true);
                    if (CameraFuncView.this.bTB != null) {
                        CameraFuncView.this.bTB.mo24996cr(z);
                    }
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_delete", true);
                }
            });
            this.bTo = (TimerView) activity.findViewById(R.id.timer_view);
            this.bTo.mo26211a(this.bTI);
            this.bTe = (LinearLayout) activity.findViewById(R.id.no_face_tips_layout);
            this.bTj = (BeautyLevelBar) findViewById(R.id.xiaoying_cam_fb_value_bar_por);
            this.bTj.setFBLevelItemClickListener(this.bTF);
            if (C5008i.m12937VU().mo25630Wq()) {
                LayoutParams layoutParams = new LayoutParams(-2, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(14);
                layoutParams.bottomMargin = C4583d.m11670O(getContext(), 185);
                this.bTj.setLayoutParams(layoutParams);
            }
            this.bTh = (TopIndicatorNew) findViewById(R.id.cam_layout_title_new);
            this.bTh.setTopIndicatorClickListener(this.bTE);
            this.bTi = (CamShutterLayout) findViewById(R.id.shutter_layout);
            this.bTi.setShutterLayoutEventListener(this.bTB);
            this.bTi.mo26051a(activity, (AbstractCameraView) this);
            this.bSX = (RelativeLayout) findViewById(R.id.layout_2lev);
            this.bSZ = (TextView) findViewById(R.id.layout_aelock_tip);
            this.bTc = (TextView) findViewById(R.id.cam_hint_for_lan);
            this.bTb = (TextView) findViewById(R.id.cam_hint_for_por_left);
            this.bTa = (TextView) findViewById(R.id.cam_hint_for_por_right);
            this.bSW = (RelativeLayout) findViewById(R.id.layout_swipe_filter_tip);
            this.bTh.getRatioBtn().getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (CameraFuncView.this.bTh.getRatioBtn().isShown()) {
                        CameraFuncView.this.m13340WX();
                        CameraFuncView.this.bTh.getRatioBtn().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ju */
    public void m13428ju(int i) {
        if (this.bSS != null) {
            this.bSS.mo35562vq(i);
        }
    }

    /* renamed from: n */
    private void m13433n(boolean z, boolean z2) {
        if (this.bTj != null) {
            this.bTj.mo26130o(z, z2);
        }
    }

    /* renamed from: Oj */
    public final void mo25953Oj() {
        if (((Activity) this.bwg.get()) != null) {
            m13338WV();
            initUI();
        }
    }

    /* renamed from: SY */
    public void mo25791SY() {
        m13415dd(true);
        this.bTi.mo26048XL();
    }

    /* renamed from: Ts */
    public void mo25792Ts() {
        this.bTh.mo26284dA(false);
    }

    /* renamed from: UF */
    public void mo25954UF() {
        if (this.bML != null) {
            this.bML.aNX();
        }
        this.bTi.mo26050XO();
    }

    /* renamed from: Uj */
    public void mo25793Uj() {
        if (this.bTj != null) {
            this.bTj.update();
        }
        if (this.bTh != null) {
            this.bTh.update();
        }
        if (this.bTi != null) {
            this.bTi.mo26048XL();
        }
        if (!(this.bTm == null || this.bwg == null)) {
            Activity activity = (Activity) this.bwg.get();
            if (activity != null) {
                this.bTm.mo26223Yu();
                this.bTm.mo26221T(((CameraActivityBase) activity).bOx);
            }
        }
        if (this.bSZ != null) {
            if (SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "no_aelock"))) {
                this.bSZ.setVisibility(0);
            } else {
                this.bSZ.setVisibility(4);
            }
        }
    }

    /* renamed from: Uk */
    public void mo25794Uk() {
        this.bTi.mo26046Uk();
    }

    /* renamed from: Ul */
    public boolean mo25795Ul() {
        return this.bTo.mo26209Yr();
    }

    /* renamed from: Um */
    public void mo25796Um() {
        mo25955c(this.bSX, false, false);
        m13353Xj();
        this.bTl.setViewVisibility(8);
        this.bSX.postDelayed(new Runnable() {
            public void run() {
                CameraFuncView.this.m13355Xl();
            }
        }, 300);
    }

    /* renamed from: Un */
    public void mo25797Un() {
        m13414dc(false);
        this.bTn.setDeleteEnable(false);
        if (this.bTB != null) {
            this.bTB.mo24983UH();
        }
    }

    /* renamed from: Uo */
    public void mo25798Uo() {
    }

    /* renamed from: Up */
    public void mo25799Up() {
        mo25954UF();
    }

    /* renamed from: Uq */
    public boolean mo25800Uq() {
        if (this.bSX != null && this.bSX.getVisibility() == 0) {
            mo25955c(this.bSX, false, true);
            m13353Xj();
            this.bTl.setViewVisibility(8);
            this.bSX.postDelayed(new Runnable() {
                public void run() {
                    CameraFuncView.this.m13355Xl();
                }
            }, 300);
            return true;
        } else if (this.bTl == null || !this.bTl.isShown()) {
            return false;
        } else {
            this.bTl.setViewVisibility(8);
            m13353Xj();
            return true;
        }
    }

    /* renamed from: Us */
    public void mo25829Us() {
        this.bTi.postDelayed(new Runnable() {
            public void run() {
                CameraFuncView.this.m13345Xb();
            }
        }, 300);
    }

    /* renamed from: Ut */
    public void mo25830Ut() {
        if (this.bSS != null) {
            this.bSS.aMx();
        }
    }

    /* renamed from: Uu */
    public void mo25831Uu() {
        if (this.bTy != 0 || this.bTz != 0) {
            this.bTc.setVisibility(4);
            this.bTb.setVisibility(4);
            this.bTa.setVisibility(4);
            this.bTy = 0;
            this.bTz = 0;
        }
    }

    /* renamed from: Uv */
    public void mo25832Uv() {
        m13415dd(true);
        if (CameraCodeMgr.isParamMVEnable(this.bOz)) {
            this.bTg.mo26176dt(true);
        }
    }

    /* renamed from: Uw */
    public void mo25833Uw() {
        if (CameraCodeMgr.isParamBeautyEffectEnable(this.bOz)) {
            m13352Xi();
        } else {
            m13351Xh();
        }
        m13416de(false);
    }

    /* renamed from: a */
    public void mo25834a(TemplateInfo templateInfo, int i) {
        if (this.bTl != null) {
            this.bTl.mo26019h(templateInfo);
        }
    }

    /* renamed from: a */
    public void mo25801a(Long l, int i) {
        if (this.bTl == null || !this.bTl.mo26018g(l)) {
            this.bSS.mo35551S(String.valueOf(l), i);
            if (i == -1 || i == -2) {
                C5031c.m13210a(getContext().getApplicationContext(), l, i);
                return;
            }
            return;
        }
        this.bTl.mo26015c(l, i);
        if (i == -1 || i == -2) {
            C5031c.m13223b(getContext().getApplicationContext(), l, i);
        }
    }

    /* renamed from: a */
    public void mo25835a(final boolean z, final String str, String str2, boolean z2) {
        if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (!z2) {
                this.bTi.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (CameraFuncView.this.bTi.isShown()) {
                            if (z && CameraCodeMgr.isParamFacialEnable(CameraFuncView.this.bOz)) {
                                CameraFuncView.this.m13355Xl();
                                CameraFuncView.this.m13354Xk();
                                CameraFuncView.this.m13417df(false);
                                if (SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE.equals(str)) {
                                    CameraFuncView.this.bTl.setVisibility(0);
                                } else {
                                    CameraFuncView.this.bTl.setChoosedSceneItem(str);
                                }
                            }
                            CameraFuncView.this.bTi.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        }
                    }
                });
            } else if (z && CameraCodeMgr.isParamFacialEnable(this.bOz)) {
                m13355Xl();
                m13354Xk();
                m13417df(false);
                this.bTl.setVisibility(0);
            }
            return;
        }
        m13359Y(str, str2);
    }

    /* renamed from: af */
    public void mo25836af(long j) {
        if (this.bTl != null) {
            m13389al(j);
            this.bTl.mo26016e(Long.valueOf(j));
        }
    }

    /* renamed from: b */
    public void mo25802b(RelativeLayout relativeLayout) {
        mo25793Uj();
        this.bTi.mo26052b(relativeLayout);
    }

    /* renamed from: b */
    public void mo25803b(MusicDataItem musicDataItem) {
        int y = C4999g.m12910y(musicDataItem.currentTimeStamp, musicDataItem.startTimeStamp, musicDataItem.stopTimeStamp);
        this.bTg.setMusicTitle(musicDataItem.title);
        this.bTg.setMusicProgress(y);
    }

    /* renamed from: bT */
    public void mo25837bT(int i, int i2) {
        if ((this.bTy != i || this.bTz != i2) && this.bTb != null && this.bTc != null && this.bTa != null) {
            if (!this.bTx) {
                this.bTx = true;
                m13339WW();
            }
            if (i2 == 270 && i == 0) {
                if (this.bTb.getVisibility() == 0) {
                    this.bTb.setVisibility(4);
                }
                if (this.bTc.getVisibility() == 0) {
                    this.bTc.setVisibility(4);
                }
                if (this.bTa.getVisibility() != 0) {
                    this.bTa.setVisibility(0);
                    C5031c.m13231q(getContext().getApplicationContext(), false);
                }
            } else if (i2 == 90 && i == 0) {
                if (this.bTb.getVisibility() != 0) {
                    this.bTb.setVisibility(0);
                    C5031c.m13231q(getContext().getApplicationContext(), false);
                }
                if (this.bTc.getVisibility() == 0) {
                    this.bTc.setVisibility(4);
                }
                if (this.bTa.getVisibility() == 0) {
                    this.bTa.setVisibility(4);
                }
            } else if ((i == 270 || i == 90) && i2 == 0) {
                if (this.bTb.getVisibility() == 0) {
                    this.bTb.setVisibility(4);
                }
                if (this.bTc.getVisibility() != 0) {
                    this.bTc.setVisibility(0);
                    C5031c.m13231q(getContext().getApplicationContext(), true);
                }
                if (this.bTa.getVisibility() == 0) {
                    this.bTa.setVisibility(4);
                }
            } else {
                mo25831Uu();
            }
            this.bTy = i;
            this.bTz = i2;
        }
    }

    /* renamed from: c */
    public void mo25955c(final View view, boolean z, boolean z2) {
        if (view != null) {
            if (!z) {
                if (view.getVisibility() == 0 && !this.bTC) {
                    C5008i.m12937VU().mo25636cL(false);
                    this.bOS.setAnimationListener(new AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            CameraFuncView.this.bTC = false;
                            view.setVisibility(8);
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            CameraFuncView.this.bTC = true;
                        }
                    });
                    view.startAnimation(this.bOS);
                }
                C5031c.m13232r(getContext().getApplicationContext(), z2);
            } else if (view.getVisibility() != 0) {
                view.setVisibility(0);
                view.startAnimation(this.bOR);
                if (this.bTt && this.bSS != null) {
                    this.bTt = false;
                    this.bSS.aMz();
                }
            }
        }
    }

    /* renamed from: cm */
    public void mo25805cm(boolean z) {
        if (z) {
            if (CameraCodeMgr.isParamBeautyEffectEnable(this.bOz)) {
                m13352Xi();
            } else {
                m13351Xh();
            }
            m13416de(true);
        } else if (this.bTr == -1) {
            if (CameraCodeMgr.isParamBeautyEffectEnable(this.bOz)) {
                m13352Xi();
            } else {
                m13351Xh();
            }
            m13416de(true);
        } else if (CameraCodeMgr.isCameraParamFB(this.bTr)) {
            if (!CameraCodeMgr.isCameraParamFB(this.bOz)) {
                m13351Xh();
                m13416de(true);
            }
        } else if (CameraCodeMgr.isCameraParamFB(this.bOz)) {
            m13352Xi();
            m13416de(true);
        }
        this.bTr = this.bOz;
    }

    /* renamed from: cn */
    public void mo25956cn(View view) {
        if (this.bTm == null) {
            if (this.bwg != null && this.bwg.get() != null) {
                Activity activity = (Activity) this.bwg.get();
                this.bTm = new C5179a(activity);
                this.bTm.mo26220S(((CameraActivityBase) activity).bOx);
                this.bTm.mo26226dw(CameraCodeMgr.isParamSpeedEnable(this.bOz));
                this.bTm.mo26224a((C5181a) new C5181a() {
                    /* renamed from: Xp */
                    public void mo25980Xp() {
                        CameraFuncView.this.m13347Xd();
                    }

                    /* renamed from: Xq */
                    public void mo25981Xq() {
                        CameraFuncView.this.m13346Xc();
                    }

                    /* renamed from: Xr */
                    public void mo25982Xr() {
                        CameraFuncView.this.m13349Xf();
                    }

                    /* renamed from: jv */
                    public void mo25983jv(int i) {
                        boolean z = false;
                        if (!(i != 0)) {
                            CameraFuncView.this.bTp = 0;
                            CameraFuncView.this.bTq = 0;
                            CameraFuncView.this.bTo.mo26213fg(CameraFuncView.this.getResources().getString(R.string.xiaoying_str_com_state_off));
                            CameraFuncView.this.bTo.reset();
                            CameraFuncView.this.bTo.mo26212am(1000);
                            AppPreferencesSetting.getInstance().setAppSettingStr("pref_timer_onoff_key", "off");
                        } else {
                            if (i == 3) {
                                z = true;
                            }
                            if (!z) {
                                CameraFuncView.this.bTo.onClick(CameraFuncView.this.bTo);
                            }
                            CameraFuncView.this.bTp = CameraFuncView.this.bTo.getTimerValue();
                            CameraFuncView.this.bTq = CameraFuncView.this.bTp;
                            CameraFuncView.this.bTo.mo26207Yp();
                            AppPreferencesSetting.getInstance().setAppSettingStr("pref_timer_onoff_key", "on");
                            C5030b.m13201C(CameraFuncView.this.bOz, true);
                            C5008i.m12937VU().mo25634cJ(true);
                            CameraFuncView.this.bTi.mo26048XL();
                        }
                        C5008i.m12937VU().mo25656jk(CameraFuncView.this.bTp);
                        CameraFuncView.this.bLS.sendMessage(CameraFuncView.this.bLS.obtainMessage(4105));
                        C5031c.m13226i(CameraFuncView.this.getContext(), C5034e.m13235R(CameraFuncView.this.getContext(), CameraFuncView.this.bOz), CameraFuncView.this.bTp);
                    }

                    public void onSpeedChanged(float f) {
                        Activity activity = (Activity) CameraFuncView.this.bwg.get();
                        if (activity != null) {
                            ((CameraActivityBase) activity).bOx = f;
                        }
                    }
                });
            } else {
                return;
            }
        }
        this.bTm.mo26225cp(view);
    }

    /* renamed from: cn */
    public void mo25838cn(boolean z) {
        if (z) {
            m13356Xm();
        } else {
            m13357Xn();
        }
    }

    /* renamed from: co */
    public void mo25839co(boolean z) {
        if (CameraCodeMgr.isParamFacialEnable(this.bOz) && this.bNr != null && this.bNr.mo25576VK() && this.bTG) {
            if (!z) {
                this.bNr.mo25575VJ();
                if (this.bNr.isPlaying()) {
                    this.bNr.pause();
                }
            } else if (!this.bNr.isPlaying()) {
                this.bNr.play();
            }
        }
    }

    /* renamed from: eQ */
    public void mo25840eQ(final String str) {
        this.bTi.postDelayed(new Runnable() {
            public void run() {
                CameraFuncView.this.m13345Xb();
                CameraFuncView.this.m13422fb(str);
            }
        }, 300);
    }

    /* renamed from: eR */
    public void mo25841eR(String str) {
        if (this.bSS == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.bSS.aMw();
        } else {
            this.bSS.mo35560qJ(str);
        }
    }

    public View getTopIndicatorView() {
        return this.bTh;
    }

    /* renamed from: iF */
    public void mo25808iF(int i) {
        this.bTg.setMusicProgress(i);
    }

    /* renamed from: iH */
    public void mo25842iH(int i) {
        if (this.bTh != null) {
            this.bTh.mo26287iH(i);
        }
        if (this.bTm != null && this.bTm.isShowing()) {
            this.bTm.mo26227iH(i);
        }
    }

    public void onDestroy() {
        mo25954UF();
        this.bLS = null;
        this.bML = null;
        if (this.bNr != null) {
            this.bNr.mo25574VI();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    public void onPause() {
        this.bTs = true;
        if (this.bwg != null) {
            Activity activity = (Activity) this.bwg.get();
            if (activity != null && !activity.isFinishing()) {
                if (this.bSX != null && this.bSX.getVisibility() == 0) {
                    this.bSX.setVisibility(8);
                }
                this.bTl.setVisibility(8);
                m13353Xj();
            }
        }
        if (CameraCodeMgr.isParamFacialEnable(this.bOz) && this.bNr != null && this.bNr.mo25576VK() && this.bNr.isPlaying()) {
            this.bNr.pause();
        }
        if (this.bTi != null) {
            this.bTi.onPause();
        }
    }

    public void onResume() {
        if (this.bTs) {
            m13428ju(this.bOt.mo35205bx(this.bSR));
        }
        if (CameraCodeMgr.isParamFacialEnable(this.bOz) && this.bNr != null && this.bNr.mo25576VK() && this.bTH) {
            this.bNr.play();
        }
    }

    /* renamed from: p */
    public boolean mo25812p(MotionEvent motionEvent) {
        boolean z = false;
        if (C5008i.m12937VU().mo25612VY()) {
            int width = this.bTn.getWidth();
            int height = this.bTn.getHeight();
            int[] iArr = new int[2];
            this.bTn.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + width;
            rect.bottom = rect.top + height;
            m13414dc(false);
            this.bTn.setDeleteEnable(false);
            if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (this.bTB != null) {
                    this.bTB.mo24983UH();
                }
                z = true;
            } else if (this.bTB != null) {
                this.bTB.mo24996cr(true);
            }
        }
        if (!this.bTo.mo26209Yr()) {
            return z;
        }
        m13415dd(true);
        this.bTi.mo26048XL();
        return true;
    }

    public void setCameraMode(int i, int i2, boolean z, boolean z2) {
        if (((Activity) this.bwg.get()) != null) {
            C5031c.m13206Q(getContext().getApplicationContext(), this.bTi == null ? -1 : this.bTi.getModeSwitchType());
            if (CameraCodeMgr.isParamMVEnable(this.bOz) && !CameraCodeMgr.isParamMVEnable(i2)) {
                this.bTg.mo26175XT();
            }
            if (CameraCodeMgr.isParamFacialEnable(this.bOz) && !CameraCodeMgr.isParamFacialEnable(i2)) {
                if (this.bNr != null) {
                    this.bNr.reset();
                }
                mo25836af(0);
            }
            this.bOz = i2;
            if (C5008i.m12937VU().getDurationLimit() != 0 || CameraCodeMgr.isCameraParamMV(i2)) {
                this.bTh.mo26282YK();
            } else {
                this.bTh.mo26283YL();
            }
            this.bTh.setRatioEnable(CameraCodeMgr.isParamRatioEnable(i2));
            if (this.bTm != null) {
                this.bTm.mo26226dw(CameraCodeMgr.isParamSpeedEnable(i2));
            }
            if (this.bTg != null) {
                this.bTg.setVisibility(CameraCodeMgr.isParamMVEnable(i2) ? 0 : 8);
            }
            mo25796Um();
            m13355Xl();
            if (!CameraCodeMgr.isParamBeautyEnable(i2)) {
                m13417df(false);
            } else {
                m13433n(false, z);
            }
            if (CameraCodeMgr.isParamMVEnable(i2)) {
                this.bTg.setVisibility(0);
            }
            this.bTi.mo26053do(z2);
            this.bTi.setOrientation(i);
            this.mOrientation = i;
            this.bTn.mo26124XT();
            boolean jL = C5030b.m13205jL(i2);
            C5030b.m13201C(i2, jL);
            C5008i.m12937VU().mo25634cJ(jL);
            this.bTi.mo26048XL();
        }
    }

    public void setCameraViewRatio(int i) {
        if (this.bTh != null) {
            this.bTh.setCameraRatioMode(i);
        }
    }

    public void setClipCount(int i, boolean z) {
        if (((Activity) this.bwg.get()) != null) {
            this.bTh.update();
            this.bTi.mo26054dp(true);
            TopIndicatorNew topIndicatorNew = this.bTh;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            topIndicatorNew.setClipCount(sb.toString());
            if (i == 0) {
                this.bTn.setVisibility(8);
            } else {
                this.bTn.setVisibility(0);
                m13341WY();
            }
        }
    }

    public void setCurrentTimeValue(long j) {
        this.bTh.setTimeValue(j);
        this.bTh.mo26285dB(j > 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setEffect(int r3, boolean r4, boolean r5, boolean r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.bOB     // Catch:{ all -> 0x007d }
            if (r0 != r3) goto L_0x0009
            if (r4 != 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            if (r3 < 0) goto L_0x007b
            com.introvd.template.template.g.b r4 = r2.bOt     // Catch:{ all -> 0x007d }
            if (r4 != 0) goto L_0x0010
            goto L_0x007b
        L_0x0010:
            r4 = 1
            r2.bTt = r4     // Catch:{ all -> 0x007d }
            android.widget.RelativeLayout r4 = r2.bSW     // Catch:{ all -> 0x007d }
            if (r4 == 0) goto L_0x002a
            android.widget.RelativeLayout r4 = r2.bSW     // Catch:{ all -> 0x007d }
            int r4 = r4.getVisibility()     // Catch:{ all -> 0x007d }
            if (r4 != 0) goto L_0x002a
            android.widget.RelativeLayout r4 = r2.bSW     // Catch:{ all -> 0x007d }
            com.introvd.template.p203b.C4562a.m11539cc(r4)     // Catch:{ all -> 0x007d }
            android.widget.RelativeLayout r4 = r2.bSW     // Catch:{ all -> 0x007d }
            r0 = 4
            r4.setVisibility(r0)     // Catch:{ all -> 0x007d }
        L_0x002a:
            r2.bOB = r3     // Catch:{ all -> 0x007d }
            com.introvd.template.template.g.b r3 = r2.bOt     // Catch:{ all -> 0x007d }
            int r4 = r2.bOB     // Catch:{ all -> 0x007d }
            long r3 = r3.mo35215vi(r4)     // Catch:{ all -> 0x007d }
            r2.bSR = r3     // Catch:{ all -> 0x007d }
            com.introvd.template.camera.ui.shutter.CamShutterLayout r3 = r2.bTi     // Catch:{ all -> 0x007d }
            long r0 = r2.bSR     // Catch:{ all -> 0x007d }
            r3.setCurrentEffectTemplateId(r0)     // Catch:{ all -> 0x007d }
            if (r6 == 0) goto L_0x0042
            r2.mo25796Um()     // Catch:{ all -> 0x007d }
        L_0x0042:
            android.content.Context r3 = r2.getContext()     // Catch:{ all -> 0x007d }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x007d }
            com.introvd.template.camera.p232e.C5031c.m13230p(r3, r6)     // Catch:{ all -> 0x007d }
            int r3 = r2.bOB     // Catch:{ all -> 0x007d }
            r2.m13428ju(r3)     // Catch:{ all -> 0x007d }
            com.introvd.template.template.g.b r3 = r2.bOt     // Catch:{ all -> 0x007d }
            int r4 = r2.bOB     // Catch:{ all -> 0x007d }
            com.introvd.template.sdk.model.editor.EffectInfoModel r3 = r3.mo35214vh(r4)     // Catch:{ all -> 0x007d }
            if (r3 != 0) goto L_0x005e
            monitor-exit(r2)
            return
        L_0x005e:
            java.lang.String r3 = "none"
            int r4 = r2.bOB     // Catch:{ all -> 0x007d }
            if (r4 < 0) goto L_0x0070
            com.introvd.template.template.g.b r4 = r2.bOt     // Catch:{ all -> 0x007d }
            int r6 = r2.bOB     // Catch:{ all -> 0x007d }
            com.introvd.template.sdk.model.editor.EffectInfoModel r4 = r4.mo35214vh(r6)     // Catch:{ all -> 0x007d }
            if (r4 == 0) goto L_0x0070
            java.lang.String r3 = r4.mName     // Catch:{ all -> 0x007d }
        L_0x0070:
            int r4 = r2.bOB     // Catch:{ all -> 0x007d }
            if (r4 < 0) goto L_0x0079
            if (r5 == 0) goto L_0x0079
            r2.m13423fc(r3)     // Catch:{ all -> 0x007d }
        L_0x0079:
            monitor-exit(r2)
            return
        L_0x007b:
            monitor-exit(r2)
            return
        L_0x007d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p233ui.camview.CameraFuncView.setEffect(int, boolean, boolean, boolean):void");
    }

    public void setEffectMgr(C8759b bVar) {
        if (((Activity) this.bwg.get()) != null) {
            this.bOt = bVar;
            if (this.bST == null) {
                this.bST = C8937c.aMA();
            }
            if (this.bOt != null) {
                this.bST.setEffectMgr(this.bOt);
            }
            if (this.bSS != null) {
                this.bSS.mo35557b(this.bOt);
            }
        }
    }

    public void setMusicViewEnable(boolean z) {
        if (CameraCodeMgr.isParamMVEnable(this.bOz)) {
            this.bTg.setEnable(z);
        }
    }

    public void setState(int i, MSize mSize) {
        if (this.mState != i) {
            this.mState = i;
            switch (this.mState) {
                case 1:
                case 5:
                    break;
                case 2:
                    mo25954UF();
                    m13355Xl();
                    m13417df(false);
                    if (!this.bTu) {
                        Activity activity = (Activity) this.bwg.get();
                        if (activity != null) {
                            C5031c.m13209a(getContext().getApplicationContext(), mSize, this.bOz, this.mOrientation, ((CameraActivityBase) activity).bOx, this.bSR);
                        }
                        this.bTu = true;
                    }
                    this.bTn.setVisibility(8);
                    if (CameraCodeMgr.isParamMVEnable(this.bOz)) {
                        this.bTg.mo26176dt(false);
                    }
                    if (CameraCodeMgr.isParamFacialEnable(this.bOz) && this.bNr != null && this.bNr.mo25576VK() && !this.bTG) {
                        if (this.bTH) {
                            this.bTH = false;
                            this.bNr.mo25575VJ();
                        }
                        this.bNr.play();
                    }
                    if (this.bSW.getVisibility() == 0) {
                        C4562a.m11539cc(this.bSW);
                        this.bSW.setVisibility(4);
                        break;
                    }
                    break;
                case 6:
                    if (CameraCodeMgr.isParamBeautyEnable(this.bOz)) {
                        m13433n(false, false);
                        break;
                    }
                    break;
                default:
                    if (C5008i.m12937VU().getClipCount() > 0) {
                        this.bTn.setVisibility(0);
                        break;
                    }
                    break;
            }
            if (C5008i.m12937VU().getClipCount() > 0) {
                this.bTn.setVisibility(0);
            }
            if (CameraCodeMgr.isParamMVEnable(this.bOz)) {
                this.bTg.mo26176dt(true);
            }
            if (CameraCodeMgr.isParamFacialEnable(this.bOz) && this.bNr != null && this.bNr.mo25576VK() && this.bNr.isPlaying() && !this.bTG) {
                this.bNr.pause();
            }
            this.bTh.update();
            this.bTi.mo26047XJ();
        }
    }

    public void setTimeExceed(boolean z) {
        this.bTh.setTimeExceed(z);
    }

    public void setZoomValue(double d) {
        this.bTd.clearAnimation();
        this.bTd.setVisibility(0);
        if (this.bTj != null && this.bTj.isShown()) {
            this.bTj.setVisibility(4);
        }
        if (this.bTg != null && this.bTg.isShown()) {
            this.bTg.setVisibility(4);
        }
        if (this.bTl != null && this.bTl.isShown()) {
            this.bTl.setViewVisibility(8);
            m13353Xj();
        }
        this.bTf.setProgress((int) d);
        this.mHandler.removeMessages(8195);
        this.mHandler.removeMessages(8197);
        this.mHandler.sendEmptyMessageDelayed(8195, 1000);
    }
}
