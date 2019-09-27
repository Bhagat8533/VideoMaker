package com.introvd.template.camera;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.OnZoomChangeListener;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.camera.base.CameraActivityBase;
import com.introvd.template.camera.model.SaveRequest;
import com.introvd.template.camera.p229b.C4991c;
import com.introvd.template.camera.p229b.C4995e;
import com.introvd.template.camera.p229b.C4996f;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p229b.C5009j;
import com.introvd.template.camera.p229b.C5016m;
import com.introvd.template.camera.p229b.C5016m.C5018a;
import com.introvd.template.camera.p232e.C5030b;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.camera.p232e.C5032d;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.camera.p232e.C5036f;
import com.introvd.template.camera.p232e.C5039g;
import com.introvd.template.camera.p232e.C5039g.C5040a;
import com.introvd.template.camera.p232e.C5041h;
import com.introvd.template.camera.p233ui.camview.CameraViewDefaultLan;
import com.introvd.template.camera.p233ui.camview.CameraViewDefaultPor;
import com.introvd.template.camera.p233ui.view.indicator.C5198c;
import com.introvd.template.common.ActivityStateCheckListener;
import com.introvd.template.common.ApiHelper;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.common.joinevent.JoinEventInfo;
import com.introvd.template.common.joinevent.JoinEventUtil;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.FuncExportRouter;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.router.camera.CameraIntentInfo;
import com.introvd.template.router.camera.CameraIntentInfo.Builder;
import com.introvd.template.router.camera.CameraRouter;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.editor.pip.PIPDesignerRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p381b.C8393c;
import com.introvd.template.sdk.p381b.C8394d;
import com.introvd.template.sdk.p381b.p382a.C8387c.C8388a;
import com.introvd.template.sdk.p381b.p382a.C8387c.C8389b;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8560o;
import com.introvd.template.sdk.utils.C8567u;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8536m;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;
import com.introvd.template.template.download.C8692b;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.videoeditor.p416a.C9006a;
import com.introvd.template.vivacamera.R;
import com.introvd.template.xyui.C9136a;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.mediarecorder.engine.PerfBenchmark;
import com.mediarecorder.engine.QBaseCamEngine;
import com.mediarecorder.engine.QPIPFrameParam;
import com.mediarecorder.engine.QRecorderStatus;
import java.io.File;
import java.lang.Thread.State;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import lib.C12177i;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.player.QPlayer;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QComUtils;
import xiaoying.utils.QRect;

@C1942a(mo10417rZ = "/vivacamera/old_version")
public class CameraActivity extends CameraActivityBase implements OnDoubleTapListener, OnGestureListener, C5018a, C5040a, ActivityStateCheckListener {
    private static String bMz = "key_pref_last_not_funny_camera_id";
    private GestureDetector aML;
    private WakeLock ajC;
    private C5032d bLP;
    private int bLQ = 1;
    private int bLR = 0;
    private Handler bLS = null;
    private MSize bLT = new MSize(800, 480);
    private MSize bLU = new MSize((int) QUtils.VIDEO_RES_VGA_WIDTH, 480);
    /* access modifiers changed from: private */
    public boolean bLV = false;
    private boolean bLW = false;
    public boolean bLX = false;
    private boolean bLY = false;
    private boolean bLZ = false;
    /* access modifiers changed from: private */
    public boolean bMA = false;
    private int bMB = 4097;
    private int bMC = 0;
    private int bMD = 0;
    /* access modifiers changed from: private */
    public int bME = 0;
    private boolean bMF = false;
    /* access modifiers changed from: private */
    public int bMG;
    /* access modifiers changed from: private */
    public int bMH;
    private final C4627d bMI = new C4627d();
    /* access modifiers changed from: private */
    public int bMJ = 1;
    private boolean bMK = true;
    /* access modifiers changed from: private */
    public C9136a bML;
    public C8522g bMM = null;
    public C5009j bMN;
    public C4991c bMO;
    /* access modifiers changed from: private */
    public C8692b bMP = null;
    private boolean bMQ = false;
    /* access modifiers changed from: private */
    public boolean bMR = false;
    private long bMS = -1;
    /* access modifiers changed from: private */
    public long bMT = 0;
    private View bMU;
    private int bMV;
    /* access modifiers changed from: private */
    public boolean bMW = false;
    private boolean bMX = false;
    /* access modifiers changed from: private */
    public C4995e bMY;
    private C8759b bMZ;
    /* access modifiers changed from: private */
    public boolean bMa = false;
    /* access modifiers changed from: private */
    public boolean bMb = false;
    public boolean bMc = false;
    private String bMd;
    private String bMe;
    private C5041h bMf;
    private float bMg = 0.0f;
    private C8394d bMh;
    /* access modifiers changed from: private */
    public Thread bMi = null;
    private RelativeLayout bMj;
    private RelativeLayout bMk;
    private OrientationEventListener bMl;
    private C5039g bMm;
    /* access modifiers changed from: private */
    public boolean bMn = false;
    private boolean bMo = true;
    private int bMp = 0;
    /* access modifiers changed from: private */
    public int bMq = 0;
    /* access modifiers changed from: private */
    public boolean bMr = false;
    private int bMs = 0;
    private int bMt;
    /* access modifiers changed from: private */
    public boolean bMu = false;
    private C4622a bMv = null;
    private long bMw = 0;
    boolean bMx = false;
    private String bMy = null;
    private boolean bNa = false;
    private C5530d bNb;
    private String bNc = null;
    private CameraIntentInfo bNd;
    private C8388a bNe = new C8388a() {
        /* renamed from: a */
        public void mo24924a(CameraInfo cameraInfo) {
            if ("HTC ChaCha A810e".equals(Build.MODEL) && cameraInfo.facing == 1) {
                CameraActivity.this.bOJ.mo25558iY(1);
            }
        }

        /* renamed from: a */
        public void mo24925a(C8389b bVar, CameraInfo cameraInfo) {
        }
    };
    /* access modifiers changed from: private */
    public Handler mHandler = null;
    /* access modifiers changed from: private */
    public int mOrientation = -1;
    private TODOParamModel todoParamModel;

    /* renamed from: com.introvd.template.camera.CameraActivity$a */
    private final class C4622a implements AutoFocusCallback {
        private final WeakReference<CameraActivity> bNg;

        public C4622a(CameraActivity cameraActivity) {
            this.bNg = new WeakReference<>(cameraActivity);
        }

        public void onAutoFocus(boolean z, Camera camera) {
            if (((CameraActivity) this.bNg.get()) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("AutoFocusCallback: ");
                sb.append(z);
                LogUtils.m14223i("CameraActivity", sb.toString());
                if (CameraActivity.this.getState() == 2) {
                    CameraActivity.this.bMu = false;
                } else if (CameraActivity.this.mHandler != null && CameraActivity.this.bON != null) {
                    CameraActivity.this.mHandler.sendMessage(CameraActivity.this.mHandler.obtainMessage(32, Boolean.valueOf(z)));
                    CameraActivity.this.bON.mo25781da(z);
                }
            }
        }
    }

    /* renamed from: com.introvd.template.camera.CameraActivity$b */
    private static class C4623b extends Handler {
        private final WeakReference<CameraActivity> bNh;

        C4623b(CameraActivity cameraActivity) {
            this.bNh = new WeakReference<>(cameraActivity);
        }

        public void handleMessage(Message message) {
            final CameraActivity cameraActivity = (CameraActivity) this.bNh.get();
            if (cameraActivity == null) {
                LogUtils.m14222e("CameraActivity", "theActivity == null");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("theActivity == ");
            sb.append(message.what);
            LogUtils.m14222e("CameraActivity", sb.toString());
            switch (message.what) {
                case 4097:
                    cameraActivity.m11787SW();
                    break;
                case 4098:
                    cameraActivity.m11788SX();
                    break;
                case 4101:
                    if (Math.abs(System.currentTimeMillis() - cameraActivity.bMT) >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                        cameraActivity.bMT = System.currentTimeMillis();
                        if (cameraActivity.mClipCount == 0 && cameraActivity.getState() != 2) {
                            cameraActivity.bMN.mo25671Uk();
                        }
                        cameraActivity.bMW = true;
                        if (!cameraActivity.bMc) {
                            cameraActivity.bLX = true;
                        }
                        if (cameraActivity.getState() == 2) {
                            cameraActivity.m11801Te();
                            cameraActivity.m11847cj(true);
                        }
                        cameraActivity.bOG = true;
                        cameraActivity.bOK.mo34669jt(true);
                        cameraActivity.mHandler.sendEmptyMessage(20);
                        break;
                    } else {
                        return;
                    }
                case 4102:
                    if (cameraActivity.getState() == 2) {
                        cameraActivity.m11801Te();
                    }
                    if (cameraActivity.bMA || cameraActivity.bMM.aJJ() || (cameraActivity.bMJ == 1 && cameraActivity.mClipCount != 0)) {
                        if (!cameraActivity.bMr) {
                            if (!cameraActivity.bMn) {
                                if (cameraActivity.bMR) {
                                    if (cameraActivity.bMM != null) {
                                        if (cameraActivity.bMA || cameraActivity.bMM.aJJ()) {
                                            cameraActivity.m11793TC();
                                            break;
                                        }
                                    } else {
                                        cameraActivity.bMb = true;
                                        cameraActivity.bOG = true;
                                        cameraActivity.mHandler.sendEmptyMessage(20);
                                        break;
                                    }
                                } else {
                                    DataItemProject aHe = cameraActivity.bMM.aHe();
                                    if (aHe != null) {
                                        cameraActivity.bMM.mo34774oG(aHe.strPrjURL);
                                    }
                                    cameraActivity.bOG = true;
                                    cameraActivity.mHandler.sendEmptyMessage(20);
                                    break;
                                }
                            } else if (cameraActivity.mClipCount != 0) {
                                if (!cameraActivity.bMc) {
                                    cameraActivity.m11791TA();
                                    break;
                                } else {
                                    cameraActivity.m11814Tz();
                                    break;
                                }
                            } else {
                                cameraActivity.m11792TB();
                                break;
                            }
                        } else {
                            C8978m.m26350ht(cameraActivity).mo10296do(R.string.xiaoying_str_com_msg_intent_send_cancel_tip).mo10281a((C1904j) new C1904j() {
                                public void onClick(C1890f fVar, C1885b bVar) {
                                    cameraActivity.finish();
                                }
                            }).mo10313qu().show();
                            break;
                        }
                    } else {
                        if (cameraActivity.bMR && !cameraActivity.bMr) {
                            cameraActivity.bMb = true;
                        }
                        cameraActivity.bOG = true;
                        cameraActivity.mHandler.sendEmptyMessage(20);
                        break;
                    }
                    break;
                case 4104:
                    if (CameraCodeMgr.isCameraParamPIP(cameraActivity.bOz)) {
                        cameraActivity.bMY.mo25487Vo();
                    } else {
                        cameraActivity.bOG = true;
                        if (cameraActivity.getState() == 2) {
                            cameraActivity.m11801Te();
                            cameraActivity.m11847cj(true);
                        } else if (cameraActivity.getState() == 6) {
                            cameraActivity.m11847cj(true);
                        }
                    }
                    cameraActivity.mHandler.sendEmptyMessageDelayed(18, 0);
                    break;
                case 4105:
                    cameraActivity.mo24903Tw();
                    break;
                case QEffect.PROP_AUDIO_FRAME_REPEAT_MODE /*4113*/:
                    int i = message.arg1;
                    int i2 = message.arg2;
                    cameraActivity.bOx = 1.0f;
                    if (!(cameraActivity.bOy == i && cameraActivity.bOz == i2)) {
                        if (i != 0) {
                            cameraActivity.m11859g(i, i2, true);
                            break;
                        } else {
                            cameraActivity.m11859g(cameraActivity.bOy, i2, true);
                            break;
                        }
                    }
                case QEffect.PROP_EFFECT_PROPDATA /*4129*/:
                    cameraActivity.mo24900Ts();
                    break;
                case QEffect.PROP_EFFECT_THEME_POS_TYPE /*4130*/:
                    int intValue = ((Integer) message.obj).intValue();
                    if (!(intValue == 8 || intValue == 15)) {
                        switch (intValue) {
                        }
                    }
                    if (cameraActivity.getState() != 2) {
                        if (cameraActivity.getState() == 6) {
                            cameraActivity.m11847cj(true);
                            break;
                        }
                    } else {
                        cameraActivity.m11801Te();
                        cameraActivity.m11847cj(true);
                        break;
                    }
                    break;
                case QEffect.PROP_EFFECT_ANIMATE_POINT_GENERATOR /*4131*/:
                    EffectInfoModel iW = cameraActivity.bMY.mo25509iW(message.arg1);
                    if (iW != null) {
                        if (!iW.isbNeedDownload()) {
                            cameraActivity.bMY.mo25508iV(message.arg1);
                            break;
                        } else {
                            cameraActivity.bMY.mo25501ai(iW.mTemplateId);
                            cameraActivity.m11826a(iW);
                            break;
                        }
                    } else {
                        return;
                    }
                case QEffect.PROP_EFFECT_AUDIO_ADDITIONAL_TIME /*4133*/:
                    cameraActivity.bMY.mo25485Ve();
                    break;
                case QEffect.PROP_EFFECT_TA_SOURCE_LIST /*4134*/:
                    cameraActivity.bMY.mo25483UC();
                    break;
                case QEffect.PROP_EFFECT_PARAM_DATA /*4135*/:
                    if (CameraCodeMgr.isCameraParamPIP(cameraActivity.bOz)) {
                        cameraActivity.mo24901Tt();
                        break;
                    }
                    break;
                case QEffect.PROP_EFFECT_TA_SOURCE /*4136*/:
                    cameraActivity.bMY.mo25484UD();
                    break;
                case 4144:
                    if (CameraCodeMgr.isCameraParamPIP(cameraActivity.bOz) && cameraActivity.bMY != null) {
                        cameraActivity.bMY.mo25494a(message.arg1, (QRect) message.obj);
                        break;
                    }
                case QPlayer.PROP_PLAYER_RANGE /*32769*/:
                    cameraActivity.onConnected();
                    break;
                case QPlayer.PROP_PLAYER_SEEK_DIR /*32770*/:
                    cameraActivity.m11799Tc();
                    break;
                case QPlayer.PROP_PLAYER_PREVIEW_FPS /*32772*/:
                    if (cameraActivity.mHandler != null) {
                        cameraActivity.mHandler.sendEmptyMessageDelayed(2, 100);
                        break;
                    }
                    break;
                case 32773:
                    cameraActivity.m11804Th();
                    break;
                case 32775:
                    int Wi = C5008i.m12937VU().mo25622Wi();
                    if (CameraCodeMgr.isCameraParamPIP(cameraActivity.bOz) && -1 == Wi) {
                        if (cameraActivity.getState() == 2) {
                            cameraActivity.m11788SX();
                        }
                        cameraActivity.bMY.mo25488Vp();
                        break;
                    } else {
                        C5198c.m14174dx(false);
                        cameraActivity.mo24894SV();
                        sendEmptyMessage(4101);
                        C5008i.m12937VU().mo25635cK(true);
                        break;
                    }
                case 32776:
                    cameraActivity.m11840bQ(cameraActivity.bOz, (int) ((long) message.arg1));
                    break;
                case 32777:
                    cameraActivity.mo24894SV();
                    sendEmptyMessage(4101);
                    break;
                case 268443649:
                    cameraActivity.bMM.mo34741a(message.arg2, (Handler) this, true);
                    break;
                case 268443653:
                case 268443654:
                case 268443655:
                    if (cameraActivity.bMa) {
                        if (cameraActivity.m11844cg(false)) {
                            cameraActivity.finish();
                            break;
                        }
                    } else {
                        cameraActivity.m11844cg(false);
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: com.introvd.template.camera.CameraActivity$c */
    private static class C4625c extends Handler {
        private final WeakReference<CameraActivity> bNh;

        C4625c(CameraActivity cameraActivity) {
            this.bNh = new WeakReference<>(cameraActivity);
        }

        public void handleMessage(Message message) {
            Message message2 = message;
            CameraActivity cameraActivity = (CameraActivity) this.bNh.get();
            if (cameraActivity == null) {
                LogUtils.m14222e("CameraActivity", "theActivity == null");
                return;
            }
            switch (message2.what) {
                case 2:
                    removeMessages(2);
                    if (!cameraActivity.bLV && cameraActivity.getState() != 2) {
                        cameraActivity.mo24902Tv();
                        break;
                    }
                case 3:
                    if (!cameraActivity.isFinishing() && cameraActivity.bOJ != null && cameraActivity.bOJ.mo25525Vy() != null) {
                        removeMessages(3);
                        Parameters parameters = cameraActivity.bOJ.mo25525Vy().getParameters();
                        if (parameters != null) {
                            int zoom = parameters.getZoom();
                            if (message2.arg1 == 1) {
                                zoom++;
                            } else if (message2.arg1 == -1) {
                                zoom--;
                            }
                            if (zoom > 0 && zoom < parameters.getMaxZoom()) {
                                cameraActivity.m11865ix(zoom);
                                cameraActivity.bMN.setZoomValue(((double) ((float) (zoom + 9))) / 10.0d);
                                break;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                    break;
                case 18:
                    cameraActivity.m11805Ti();
                    break;
                case 20:
                    if (cameraActivity.bMN != null) {
                        cameraActivity.bMN.mo25679Uz();
                    }
                    cameraActivity.exit();
                    break;
                case 32:
                    if (!cameraActivity.bLV) {
                        removeMessages(771);
                        removeMessages(32);
                        removeMessages(1027);
                        boolean booleanValue = ((Boolean) message2.obj).booleanValue();
                        StringBuilder sb = new StringBuilder();
                        sb.append("onAutoFocus=");
                        sb.append(booleanValue);
                        LogUtils.m14222e("CameraActivity", sb.toString());
                        if (cameraActivity.bON != null) {
                            cameraActivity.bON.mo25784jr(4);
                            if (booleanValue) {
                                cameraActivity.bON.mo25785m(Boolean.valueOf(cameraActivity.bMu));
                            } else {
                                cameraActivity.bON.mo25786n(Boolean.valueOf(cameraActivity.bMu));
                            }
                        }
                        if (cameraActivity.bMu) {
                            sendEmptyMessageDelayed(771, 3000);
                        } else {
                            sendEmptyMessageDelayed(1027, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                        }
                        cameraActivity.bMu = false;
                        cameraActivity.m11813Ty();
                        break;
                    } else {
                        return;
                    }
                case 35:
                    if (cameraActivity.bMN != null) {
                        cameraActivity.bMN.mo25678Uy();
                        if (cameraActivity.bOy == 256) {
                            sendEmptyMessageDelayed(39, 500);
                            break;
                        }
                    }
                    break;
                case 37:
                    boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_mode", false);
                    if (!cameraActivity.isFinishing() && !appSettingBoolean) {
                        if (cameraActivity.getState() != 2) {
                            cameraActivity.bMN.mo25667UB();
                        }
                        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_mode", true);
                        break;
                    }
                case 38:
                    LogUtils.m14223i("CameraActivity", "MSG_ORIENTATION_CHANGED ");
                    if (cameraActivity != null) {
                        cameraActivity.m11862iu(cameraActivity.bMq);
                    }
                    removeMessages(38);
                    break;
                case 39:
                    cameraActivity.m11881y(cameraActivity.bOB, true);
                    break;
                case 48:
                    boolean appSettingBoolean2 = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_duration", false);
                    if (!cameraActivity.isFinishing() && !appSettingBoolean2) {
                        if (cameraActivity.getState() != 2) {
                            cameraActivity.bMN.mo25675Uo();
                        }
                        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_duration", true);
                        break;
                    }
                case 51:
                    C5198c.m14175jH(3);
                    if (AppPreferencesSetting.getInstance().getAppSettingInt("key_enter_normal_mode", 0) >= 2 && !AppPreferencesSetting.getInstance().getAppSettingBoolean("hor_record_help_show", false)) {
                        AppPreferencesSetting.getInstance().setAppSettingBoolean("hor_record_help_show", true);
                        final View topIndicatorView = cameraActivity.bMN.getTopIndicatorView();
                        if (topIndicatorView != null) {
                            if (!ApiHelper.JELLY_BEAN_AND_HIGHER) {
                                sendEmptyMessage(52);
                                break;
                            } else {
                                final ViewTreeObserver viewTreeObserver = topIndicatorView.getViewTreeObserver();
                                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                                    viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                                        @SuppressLint({"NewApi"})
                                        public void onGlobalLayout() {
                                            C4625c.this.sendEmptyMessage(52);
                                            try {
                                                if (viewTreeObserver.isAlive()) {
                                                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                                                } else {
                                                    topIndicatorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 52:
                    View topIndicatorView2 = cameraActivity.bMN.getTopIndicatorView();
                    if (topIndicatorView2 != null) {
                        cameraActivity.bML.mo36087f(topIndicatorView2, 10, C4580b.m11666qi());
                        cameraActivity.bML.mo36086dt(cameraActivity.getResources().getString(R.string.xiaoying_str_help_cam_try_the_landscape_mode));
                        cameraActivity.bML.show();
                        break;
                    }
                    break;
                case 771:
                    removeMessages(771);
                    if (!cameraActivity.bLV) {
                        cameraActivity.bON.mo25770WE();
                        cameraActivity.bON.mo25768Tp();
                        break;
                    } else {
                        return;
                    }
                case 1027:
                    if (cameraActivity.bON != null) {
                        cameraActivity.bON.mo25784jr(4);
                        break;
                    }
                    break;
                case 1028:
                    cameraActivity.m11859g(message2.arg1, message2.arg2, ((Boolean) message2.obj).booleanValue());
                    break;
                case 1029:
                    cameraActivity.m11800Td();
                    break;
                case 1030:
                    cameraActivity.m11803Tg();
                    break;
                case 1281:
                    cameraActivity.bMi = null;
                    break;
                case 1537:
                    Long valueOf = Long.valueOf(message.getData().getLong("ttid"));
                    switch (message2.arg1) {
                        case 65282:
                            if (cameraActivity.mHandler != null) {
                                cameraActivity.mHandler.sendMessage(cameraActivity.mHandler.obtainMessage(1539, message2.arg2, 0, valueOf));
                                break;
                            }
                            break;
                        case 65283:
                            if (message2.arg2 == 131072) {
                                if (cameraActivity.bMP != null) {
                                    cameraActivity.bMP.mo35059a((String) message2.obj, 1538, (String) null, message.getData());
                                    break;
                                }
                            } else {
                                if (cameraActivity.mHandler != null) {
                                    cameraActivity.mHandler.sendMessage(cameraActivity.mHandler.obtainMessage(1539, 0, 0, valueOf));
                                }
                                UserEventDurationRelaUtils.finishDummyDuraEventFail(cameraActivity.getApplicationContext(), C8450a.m24469bn(valueOf.longValue()), "Template_Download_Direct", "list", C8762d.aMt().mo35241l(valueOf.longValue(), 4), "filter", cameraActivity.isFinishing());
                                break;
                            }
                            break;
                    }
                case 1538:
                    Long valueOf2 = Long.valueOf(message.getData().getLong("ttid"));
                    switch (message2.arg1) {
                        case 65282:
                            if (cameraActivity.mHandler != null) {
                                cameraActivity.mHandler.sendMessage(cameraActivity.mHandler.obtainMessage(1539, ((message2.arg2 * 10) / 100) + 90, 0, valueOf2));
                                break;
                            }
                            break;
                        case 65283:
                            if (message2.arg2 != 131072) {
                                if (cameraActivity.mHandler != null) {
                                    cameraActivity.mHandler.sendMessage(cameraActivity.mHandler.obtainMessage(1539, 0, 0, valueOf2));
                                }
                                UserEventDurationRelaUtils.finishDummyDuraEventFail(cameraActivity.getApplicationContext(), C8450a.m24469bn(valueOf2.longValue()), "Template_Download_Direct", "list", C8762d.aMt().mo35241l(valueOf2.longValue(), 4), "filter", cameraActivity.isFinishing());
                                break;
                            } else {
                                if (cameraActivity.mHandler != null) {
                                    cameraActivity.mHandler.sendMessage(cameraActivity.mHandler.obtainMessage(1539, 100, 0, valueOf2));
                                }
                                cameraActivity.m11796TF();
                                cameraActivity.m11831ad(valueOf2.longValue());
                                UserEventDurationRelaUtils.finishDummyDuraEventFail(cameraActivity.getApplicationContext(), C8450a.m24469bn(valueOf2.longValue()), "Template_Download_Direct", "list", C8762d.aMt().mo35241l(valueOf2.longValue(), 4), "filter", cameraActivity.isFinishing());
                                break;
                            }
                    }
                case 1539:
                    Long l = (Long) message2.obj;
                    int i = message2.arg1;
                    if (cameraActivity.bMN != null) {
                        cameraActivity.bMN.mo25685a(l, i);
                        break;
                    }
                    break;
                case 268443649:
                    if (cameraActivity.bMM != null) {
                        cameraActivity.bMM.aJE();
                        ProjectItem ahP = cameraActivity.bMM.aHf();
                        if (ahP != null) {
                            if ((ahP.getCacheFlag() & 8) == 0) {
                                cameraActivity.bMM.mo33877a((Handler) this, true);
                            }
                            cameraActivity.bOG = true;
                            sendEmptyMessage(20);
                            break;
                        }
                    }
                    break;
                case 268443650:
                case 268443651:
                case 268443657:
                    cameraActivity.bOG = true;
                    sendEmptyMessage(20);
                    break;
            }
        }
    }

    /* renamed from: com.introvd.template.camera.CameraActivity$d */
    private final class C4627d implements OnZoomChangeListener {
        private C4627d() {
        }

        public void onZoomChange(int i, boolean z, Camera camera) {
            StringBuilder sb = new StringBuilder();
            sb.append("Zoom changed: value=");
            sb.append(i);
            sb.append(". stopped=");
            sb.append(z);
            LogUtils.m14225v("CameraActivity", sb.toString());
            CameraActivity.this.bMG = i;
            if (CameraActivity.this.bOJ != null) {
                Parameters VC = CameraActivity.this.bOJ.mo25517VC();
                if (VC != null && CameraActivity.this.bOJ.mo25525Vy() != null) {
                    VC.setZoom(i);
                    if (z && CameraActivity.this.bME != 0) {
                        if (i != CameraActivity.this.bMH) {
                            try {
                                CameraActivity.this.bOJ.mo25525Vy().aHl().startSmoothZoom(CameraActivity.this.bMH);
                            } catch (Exception unused) {
                            }
                            CameraActivity.this.bME = 1;
                        } else {
                            CameraActivity.this.bME = 0;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: PN */
    private void m11782PN() {
        m11786SU();
        if (this.bNd != null) {
            this.bMB = this.bNd.cameraIntent;
        }
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        String[] strArr = {"", ""};
        if (iEditorService != null) {
            strArr = iEditorService.getCommonBehaviorParam();
        }
        switch (this.bMB) {
            case 4097:
                if (this.bMM.ebQ == -1) {
                    this.bMn = true;
                    this.bMM.mo34756b(getApplicationContext(), this.bLS, this.bMs == 2, strArr[0], strArr[1]);
                    this.bLP.mo25886YQ();
                }
                ProjectItem ahP = this.bMM.aHf();
                if (ahP != null && ahP.mProjectDataItem != null) {
                    if (ahP.mProjectDataItem._id > 0) {
                        C8446b.aIZ().mo34319b(getApplicationContext(), ahP.mProjectDataItem._id, 2);
                    }
                    int i = ahP.mProjectDataItem.iCameraCode;
                    StringBuilder sb = new StringBuilder();
                    sb.append("iCameraCode: ");
                    sb.append(i);
                    LogUtils.m14223i("CameraActivity", sb.toString());
                    if (i != 0) {
                        this.bOy = CameraCodeMgr.getCameraMode(i);
                        this.bOz = CameraCodeMgr.getCameraModeParam(i);
                    } else {
                        this.bOz = AppPreferencesSetting.getInstance().getAppSettingInt(CameraRouter.KEY_PREF_LAST_CAMERA_MODE_PARAM, 1);
                    }
                    m11838bO(this.bOy, this.bOz);
                    return;
                }
                return;
            case 4099:
                if (this.bMM.ebQ == -1) {
                    this.bMn = true;
                    this.bMM.mo34756b(getApplicationContext(), this.bLS, this.bMs == 2, strArr[0], strArr[1]);
                    this.bLP.mo25886YQ();
                }
                if (this.bMy != null) {
                    if (this.bNd != null) {
                        this.bOy = this.bNd.cameraMode;
                        this.bOz = this.bNd.cameraModeParam;
                    }
                    m11838bO(this.bOy, this.bOz);
                    return;
                }
                return;
            case 4100:
                this.bMn = true;
                this.bMM.mo34756b(getApplicationContext(), this.bLS, this.bMs == 2, strArr[0], strArr[1]);
                this.bLP.mo25886YQ();
                ProjectItem ahP2 = this.bMM.aHf();
                if (ahP2.mProjectDataItem != null) {
                    if (ahP2.mProjectDataItem._id > 0) {
                        C8446b.aIZ().mo34319b(getApplicationContext(), ahP2.mProjectDataItem._id, 2);
                    }
                    if (this.bNd != null) {
                        this.bOy = this.bNd.cameraMode;
                        this.bOz = this.bNd.cameraModeParam;
                    }
                    m11838bO(this.bOy, this.bOz);
                    this.mHandler.sendEmptyMessageDelayed(51, 1000);
                    return;
                }
                return;
            case 4101:
                ProjectItem ahP3 = this.bMM.aHf();
                if (!(ahP3 == null || ahP3.mProjectDataItem == null)) {
                    if (ahP3.mProjectDataItem._id > 0) {
                        C8446b.aIZ().mo34319b(getApplicationContext(), ahP3.mProjectDataItem._id, 2);
                    }
                    int i2 = ahP3.mProjectDataItem.nDurationLimit;
                    if (i2 != 0) {
                        i2 -= 100;
                    }
                    C5008i.m12937VU().setDurationLimit(i2);
                    int i3 = ahP3.mProjectDataItem.iCameraCode;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("iCameraCode: ");
                    sb2.append(i3);
                    LogUtils.m14223i("CameraActivity", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("project extra info:");
                    sb3.append(ahP3.mProjectDataItem.strExtra);
                    LogUtils.m14223i("CameraActivity", sb3.toString());
                    this.bOx = C8558m.m25026oi(ahP3.mProjectDataItem.strExtra);
                    if (i3 != 0) {
                        this.bOy = CameraCodeMgr.getCameraMode(i3);
                        this.bOz = CameraCodeMgr.getCameraModeParam(i3);
                    } else {
                        this.bOz = AppPreferencesSetting.getInstance().getAppSettingInt(CameraRouter.KEY_PREF_LAST_CAMERA_MODE_PARAM, 1);
                    }
                    m11838bO(this.bOy, this.bOz);
                }
                DataItemProject aHe = this.bMM.aHe();
                if (aHe != null) {
                    this.bMM.mo34774oG(aHe.strPrjURL);
                }
                this.bMM.aHg();
                this.bMR = true;
                return;
            case 4103:
                this.bMc = true;
                this.bMn = true;
                this.bMM.mo34756b(getApplicationContext(), this.bLS, this.bMs == 2, strArr[0], strArr[1]);
                this.bLP.mo25886YQ();
                ProjectItem ahP4 = this.bMM.aHf();
                if (ahP4.mProjectDataItem != null) {
                    if (ahP4.mProjectDataItem._id > 0) {
                        C8446b.aIZ().mo34319b(getApplicationContext(), ahP4.mProjectDataItem._id, 2);
                    }
                    if (this.bNd != null) {
                        this.bOy = this.bNd.cameraMode;
                        this.bOz = this.bNd.cameraModeParam;
                    }
                    m11838bO(this.bOy, this.bOz);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: SU */
    private void m11786SU() {
        ProjectItem ahP = this.bMM.aHf();
        if (((ahP == null || ahP.mProjectDataItem == null || ahP.mProjectDataItem.strExtra == null || TextUtils.isEmpty(ahP.mProjectDataItem.strExtra)) ? 0 : C5030b.m13203fj(ahP.mProjectDataItem.strExtra)) == 0) {
            C5030b.m13202YP();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: SW */
    public void m11787SW() {
        if (this.bOy == 512) {
            this.bMN.mo25691cq(false);
        }
        if (getState() == 6) {
            m11803Tg();
        } else if (getState() == 1) {
            mo24896Tl();
        }
        m11813Ty();
    }

    /* access modifiers changed from: private */
    /* renamed from: SX */
    public void m11788SX() {
        if (getState() != 1 && getState() == 2) {
            m11801Te();
        }
        m11813Ty();
    }

    /* renamed from: SY */
    private void m11789SY() {
        this.bMN.mo25663SY();
    }

    /* access modifiers changed from: private */
    /* renamed from: TA */
    public void m11791TA() {
        C8978m.m26349hs(this).mo10296do(R.string.xiaoying_str_com_msg_save_draft_ask).mo10303dv(R.string.xiaoying_str_com_save_title).mo10299dr(R.string.xiaoying_str_com_discard_title).mo10291b(new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                DataItemProject aHe = CameraActivity.this.bMM.aHe();
                if (aHe != null) {
                    CameraActivity.this.bMM.mo34774oG(aHe.strPrjURL);
                }
                UserBehaviorUtils.recordPrjSave(CameraActivity.this, "camera");
                CameraActivity.this.bOG = true;
                CameraActivity.this.mHandler.sendEmptyMessage(20);
                ToastUtils.show(CameraActivity.this.getApplicationContext(), R.string.xiaoying_str_com_saved_into_draft_box_tip, 1);
            }
        }).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                CameraActivity.this.m11792TB();
            }
        }).mo10313qu().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: TB */
    public void m11792TB() {
        this.bOH = true;
        if (this.bMn || this.bMJ == 1) {
            mo24908ck(true);
            this.bOG = true;
            this.mHandler.sendEmptyMessage(20);
        } else if (this.bMM == null) {
            this.bOG = true;
            this.mHandler.sendEmptyMessage(20);
        } else if (this.bMM.aJJ()) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                String str = aHe.strPrjURL;
                if (!TextUtils.isEmpty(str)) {
                    int nt = this.bMM.mo33889nt(str);
                    if (nt >= 0) {
                        this.bMM.mo34764i(this.bMM.aHf());
                        this.bMM.mo34773oF(str);
                        this.bMM.ebQ = nt;
                        C8553i.setContext(getApplicationContext());
                        C8553i.m25005ut(55);
                        this.bMM.mo34739a(str, this.bOK, this.mHandler);
                        this.bOK.mo34669jt(false);
                    }
                }
            }
        } else {
            if (this.bMM != null) {
                this.bMM.aJF();
                this.bMM.ebQ = -1;
            }
            this.bOG = true;
            this.mHandler.sendEmptyMessage(20);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: TC */
    public void m11793TC() {
        C8978m.m26350ht(this).mo10296do(R.string.xiaoying_str_com_dialog_cancel_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                CameraActivity.this.bOH = true;
                if (CameraActivity.this.bMM != null && (CameraActivity.this.bMA || CameraActivity.this.bMM.aJJ())) {
                    DataItemProject aHe = CameraActivity.this.bMM.aHe();
                    if (aHe != null) {
                        String str = aHe.strPrjURL;
                        if (!TextUtils.isEmpty(str)) {
                            int nt = CameraActivity.this.bMM.mo33889nt(str);
                            if (nt >= 0) {
                                CameraActivity.this.bMM.mo34764i(CameraActivity.this.bMM.aHf());
                                CameraActivity.this.bMM.mo34773oF(str);
                                CameraActivity.this.bMM.ebQ = nt;
                                C8553i.setContext(CameraActivity.this.getApplicationContext());
                                C8553i.m25005ut(55);
                                CameraActivity.this.bMM.mo34739a(str, CameraActivity.this.bOK, CameraActivity.this.mHandler);
                                CameraActivity.this.bOK.mo34669jt(false);
                            }
                        }
                    }
                }
                CameraActivity.this.bMb = true;
                CameraActivity.this.bOG = true;
                CameraActivity.this.mHandler.sendEmptyMessage(20);
            }
        }).mo10313qu().show();
    }

    /* renamed from: TD */
    private void m11794TD() {
        Parameters VC = this.bOJ.mo25517VC();
        if (VC != null && this.bOJ.mo25525Vy() != null && VC.isZoomSupported()) {
            this.bMF = VC.isSmoothZoomSupported();
            this.bOJ.mo25525Vy().aHl().setZoomChangeListener(this.bMI);
        }
    }

    /* renamed from: TE */
    private void m11795TE() {
        if (this.bOJ.mo25525Vy() != null) {
            Parameters VC = this.bOJ.mo25517VC();
            if (VC != null && VC.isZoomSupported()) {
                VC.setZoom(this.bMG);
                this.bOJ.mo25525Vy().setParameters(VC);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: TF */
    public void m11796TF() {
        long j;
        LogUtils.m14223i("TAG", "notifyDataUpdate run");
        if (this.bMM != null) {
            QStoryboard aHd = this.bMM.aHd();
            if (aHd != null) {
                j = C8762d.aMt().getTemplateID((String) aHd.getProperty(16391));
            } else {
                j = 0;
            }
            m11832ae(j);
            if (this.bMN != null) {
                this.bMN.mo25682Wu();
            }
        }
    }

    /* renamed from: Ta */
    private void m11797Ta() {
        String str;
        if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                aHe.setCameraPipMode(false);
                if (!TextUtils.isEmpty(this.bMy)) {
                    JoinEventInfo joinEventInfo = JoinEventUtil.getJoinEventInfo(getApplicationContext(), this.bMy);
                    aHe.strActivityData = this.bMy;
                    if (joinEventInfo != null) {
                        if (!TextUtils.isEmpty(aHe.strVideoDesc)) {
                            str = aHe.strVideoDesc;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("#");
                            sb.append(joinEventInfo.strEventTitle);
                            sb.append("#");
                            str = sb.toString();
                        }
                        aHe.strVideoDesc = str;
                    }
                }
                aHe.iCameraCode = CameraCodeMgr.getCameraCode(this.bOy, this.bOz);
                aHe.strExtra = C8558m.m25016a(aHe.strExtra, Float.valueOf(this.bOx));
                if (CameraCodeMgr.isCameraParamPIP(this.bOz) && !this.bOH) {
                    this.bMY.mo25498a(aHe);
                }
                aHe.strExtra = C5030b.m13204fk(aHe.strExtra);
                int durationLimit = C5008i.m12937VU().getDurationLimit();
                if (durationLimit != 0) {
                    aHe.nDurationLimit = durationLimit + 100;
                } else {
                    aHe.nDurationLimit = 0;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("dataItemProject.strExtra: ");
                sb2.append(aHe.strExtra);
                LogUtils.m14223i("CameraActivity", sb2.toString());
            }
        }
    }

    /* renamed from: Tb */
    private void m11798Tb() {
        if (this.bMi != null) {
            int i = 10;
            while (this.bMi.getState() == State.RUNNABLE) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (Exception unused) {
                }
                i = i2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Tc */
    public void m11799Tc() {
        this.bMj.setVisibility(0);
        this.bOG = false;
        if (this.bMK && this.mHandler != null) {
            this.bMK = false;
            this.mHandler.sendEmptyMessageDelayed(35, 100);
            this.mHandler.sendEmptyMessageDelayed(771, 1000);
        }
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bMY.mo25495a(this.bOz, this.bMX, this.bMM);
        }
        DataItemProject aHe = this.bMM.aHe();
        String by = (aHe == null || aHe.usedEffectTempId <= 0) ? null : C8759b.m25586by(aHe.usedEffectTempId);
        if (by != null) {
            m11855eN(by);
        } else {
            m11881y(this.bOB, false);
        }
        if (this.bMX) {
            this.bMX = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Td */
    public void m11800Td() {
        this.bMS = -1;
        if (!this.bLV && this.bOJ.mo25524Vx() != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                this.bMA = true;
                setState(2);
                LogUtils.m14223i("CameraActivity", "startRecord---");
                this.mHandler.removeMessages(771);
                this.bOE = 0;
                this.bOD = 0;
                C4582c.m11669dF(this);
                this.bOJ.mo25540cC(SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(this.bMh.getString("pref_aelock_key", "auto")));
                this.bMe = C5034e.m13260d(this, System.currentTimeMillis());
                C5530d dVar = (C5530d) MagicCode.getMagicParam(this.bMw, "AppRunningMode", null);
                String cameraVideoPath = (!this.bMr || dVar == null || dVar.cnX != 2) ? CommonConfigure.getCameraVideoPath() : C8572y.m25097ou(aHe.strPrjURL);
                StringBuilder sb = new StringBuilder();
                sb.append(cameraVideoPath);
                sb.append(this.bMe);
                sb.append(".mp4");
                this.bMd = sb.toString();
                this.bOJ.setOutputFile(this.bMd);
                this.bMx = true;
                if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                    this.bMY.mo25481Td();
                } else {
                    this.bOJ.mo25548cy(false);
                }
                this.bON.mo25784jr(4);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Te */
    public void m11801Te() {
        setState(6);
        this.mHandler.removeMessages(2);
        this.bOJ.mo25549cz(true);
        m11802Tf();
        m11789SY();
    }

    /* renamed from: Tf */
    private void m11802Tf() {
        QRecorderStatus qRecorderStatus = new QRecorderStatus();
        try {
            this.bOJ.getRecordStatus(qRecorderStatus);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        SaveRequest saveRequest = new SaveRequest();
        saveRequest.filePath = this.bMd;
        saveRequest.dateTaken = System.currentTimeMillis();
        saveRequest.isVideo = true;
        saveRequest.orientation = this.bOw;
        saveRequest.insertPosition = this.mClipCount;
        saveRequest.isVirtualFile = true;
        saveRequest.startPos = 0;
        saveRequest.fTimeScale = this.bOx;
        saveRequest.startPos = this.bOJ.getConfig(13);
        saveRequest.endPos = qRecorderStatus.mVFrameTS;
        this.bOE = qRecorderStatus.mVFrameTS;
        if (saveRequest.startPos < this.bOM) {
            saveRequest.startPos = this.bOM + 1;
        }
        if (saveRequest.endPos < saveRequest.startPos) {
            saveRequest.endPos = saveRequest.startPos + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("saveRequest startPos: ");
        sb.append(saveRequest.startPos);
        sb.append(", endPos: ");
        sb.append(saveRequest.endPos);
        LogUtils.m14223i("CameraActivity", sb.toString());
        int i = (saveRequest.endPos - saveRequest.startPos) + (saveRequest.startPos - this.bOM);
        this.bOM = saveRequest.endPos;
        int i2 = this.bOB;
        EffectInfoModel vh = this.bOt.mo35214vh(i2);
        if (vh != null) {
            saveRequest.effectFilepath = vh.mPath;
        }
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bMY.mo25504e(saveRequest);
        }
        saveRequest.effectConfigureIndex = this.bOC;
        if (!this.bMO.mo25468b(saveRequest)) {
            this.mClipCount++;
        }
        this.bMO.mo25466a(saveRequest);
        this.bMN.mo25693jj(this.mClipCount);
        this.bOD = this.bOE;
        this.bOF = (int) (((long) this.bOF) + C5034e.m13252b(this.bOx, (long) i));
        this.bOG = false;
        this.mHandler.sendEmptyMessage(2);
        String str = ParametersKeys.ORIENTATION_NONE;
        if (i2 >= 0 && this.bOt.mo35214vh(i2) != null) {
            str = C8762d.aMt().mo35224aa(this.bOt.mo35214vh(i2).mPath, 4);
        }
        if (this.bOy == 256) {
            if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                m11854eM("CameraPip");
                return;
            }
            m11854eM("CameraHD");
            C5031c.m13219an(getApplicationContext(), str);
        } else if (this.bOy != 512) {
        } else {
            if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                m11854eM("CameraPip");
                return;
            }
            m11854eM("CameraHD");
            C5031c.m13219an(getApplicationContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Tg */
    public void m11803Tg() {
        int i;
        LogUtils.m14223i("CameraActivity", "resumeRecord <---");
        this.bMS = -1;
        setState(2);
        this.mHandler.removeMessages(771);
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bMY.mo25482Tg();
        } else {
            this.bOJ.mo25538cA(false);
        }
        QRecorderStatus qRecorderStatus = new QRecorderStatus();
        try {
            i = this.bOJ.getRecordStatus(qRecorderStatus);
        } catch (Throwable unused) {
            i = -1;
        }
        if (i == 0) {
            this.bMp = qRecorderStatus.mVFrameTS;
            if (this.bMp != 0) {
                float perf = PerfBenchmark.getPerf(QBaseCamEngine.BENCHMARK_PREVIEW_CB);
                if (perf < 1.0f) {
                    perf = 33.0f;
                }
                this.bMp += (int) perf;
            }
        }
        C4582c.m11669dF(this);
        this.bOJ.mo25540cC(SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(this.bMh.getString("pref_aelock_key", "auto")));
        this.bMx = true;
        this.bON.mo25784jr(4);
        this.mHandler.sendEmptyMessage(2);
        LogUtils.m14223i("CameraActivity", "resumeRecord --->");
    }

    /* access modifiers changed from: private */
    /* renamed from: Th */
    public void m11804Th() {
        this.bMx = false;
        LogUtils.m14223i("CameraActivity", "stopRecord--->");
        setState(1);
        this.mHandler.sendEmptyMessage(2);
        this.bOG = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: Ti */
    public void m11805Ti() {
        boolean z = false;
        if (this.bLQ < 2) {
            this.bOG = false;
        } else if (!this.ajR) {
            this.bNa = true;
        } else {
            this.bNa = false;
            if (getState() == 2) {
                z = true;
            }
            if (z) {
                m11847cj(true);
            }
            this.bLR = (this.bLR + 1) % 2;
            if (this.bMh == null) {
                this.bMh = new C8394d(getApplicationContext(), this.bLR);
            }
            C8393c.m24209a(this.bMh, this.bLR);
            AppPreferencesSetting.getInstance().setAppSettingInt("pref_view_camera_id", this.bLR);
            AppPreferencesSetting.getInstance().setAppSettingInt(bMz, this.bLR);
            this.bOJ.mo25561ja(this.bLR);
            this.bMX = true;
            mo25824Ur();
            connect();
            this.bMN.mo25670Uj();
        }
    }

    /* renamed from: Tj */
    private void m11806Tj() {
        if (!this.bLW) {
            LogUtils.m14222e("CameraActivity", "initializeFirstTime<---");
            this.bMh = new C8394d(getApplicationContext(), this.bLR);
            C8393c.m24213d(this.bMh.aHm());
            C8393c.m24212c(this.bMh.aHn());
            mo24903Tw();
            if (this.bON != null) {
                this.bON.mo25779c(this.bOJ.mo25517VC());
                this.bON.mo25776a(this, this.bMj, this, false, this.bOw);
                this.bON.mo25777aa(this);
            }
            this.bLW = true;
            this.bOJ.mo25546cv(true);
            startPreview();
            LogUtils.m14222e("CameraActivity", "initializeFirstTime--->");
        }
    }

    /* renamed from: Tk */
    private void m11807Tk() {
        StringBuilder sb = new StringBuilder();
        sb.append("initializeSecondTime<---");
        sb.append(getState());
        LogUtils.m14222e("CameraActivity", sb.toString());
        if (this.bMh == null) {
            this.bMh = new C8394d(getApplicationContext(), this.bLR);
        }
        C8393c.m24209a(this.bMh, this.bLR);
        this.bMG = 0;
        C8393c.m24212c(this.bMh.aHn());
        m11794TD();
        mo24903Tw();
        startPreview();
        LogUtils.m14222e("CameraActivity", "initializeSecondTime--->");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01c0, code lost:
        return;
     */
    /* renamed from: Tm */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m11808Tm() {
        /*
            r15 = this;
            monitor-enter(r15)
            java.lang.String r0 = "CameraActivity"
            java.lang.String r1 = "onShutterButtonClick"
            com.introvd.template.common.LogUtils.m14221d(r0, r1)     // Catch:{ all -> 0x01c1 }
            boolean r0 = r15.bOG     // Catch:{ all -> 0x01c1 }
            r1 = 6
            r2 = 2
            if (r0 == 0) goto L_0x001c
            int r0 = r15.getState()     // Catch:{ all -> 0x01c1 }
            if (r0 == r2) goto L_0x001c
            int r0 = r15.getState()     // Catch:{ all -> 0x01c1 }
            if (r0 == r1) goto L_0x001c
            monitor-exit(r15)
            return
        L_0x001c:
            java.lang.String r0 = "CameraActivity"
            java.lang.String r3 = "rec btn click"
            com.introvd.template.common.LogUtils.m14222e(r0, r3)     // Catch:{ all -> 0x01c1 }
            int r0 = r15.getState()     // Catch:{ all -> 0x01c1 }
            r3 = 1
            if (r0 != r3) goto L_0x01a5
            boolean r0 = m8736bo(r15)     // Catch:{ all -> 0x01c1 }
            if (r0 == 0) goto L_0x0040
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x01c1 }
            java.lang.String r1 = "com.introvd.template.diskspace"
            r0.<init>(r1)     // Catch:{ all -> 0x01c1 }
            android.support.v4.content.LocalBroadcastManager r1 = android.support.p021v4.content.LocalBroadcastManager.getInstance(r15)     // Catch:{ all -> 0x01c1 }
            r1.sendBroadcast(r0)     // Catch:{ all -> 0x01c1 }
            monitor-exit(r15)
            return
        L_0x0040:
            com.introvd.template.camera.b.f r0 = r15.bOJ     // Catch:{ all -> 0x01c1 }
            com.introvd.template.sdk.b.a.c r0 = r0.mo25524Vx()     // Catch:{ all -> 0x01c1 }
            r4 = 0
            if (r0 == 0) goto L_0x0075
            com.introvd.template.camera.b.f r0 = r15.bOJ     // Catch:{ all -> 0x01c1 }
            com.introvd.template.sdk.b.a.c r0 = r0.mo25524Vx()     // Catch:{ all -> 0x01c1 }
            com.introvd.template.sdk.b.a.a$a r0 = r0.aHq()     // Catch:{ all -> 0x01c1 }
            if (r0 == 0) goto L_0x0075
            long r6 = m8731FQ()     // Catch:{ all -> 0x01c1 }
            r8 = 52428800(0x3200000, double:2.5903269E-316)
            long r6 = r6 - r8
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x0063
            r6 = r4
        L_0x0063:
            java.lang.String r1 = "max-filesize"
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x01c1 }
            r0.set(r1, r6)     // Catch:{ all -> 0x01c1 }
            com.introvd.template.camera.b.f r1 = r15.bOJ     // Catch:{ all -> 0x01c1 }
            com.introvd.template.sdk.b.a.c r1 = r1.mo25524Vx()     // Catch:{ all -> 0x01c1 }
            r1.mo33895a(r0)     // Catch:{ all -> 0x01c1 }
        L_0x0075:
            com.introvd.template.camera.b.f r0 = r15.bOJ     // Catch:{ all -> 0x01c1 }
            com.introvd.template.sdk.b.a.c r0 = r0.mo25524Vx()     // Catch:{ all -> 0x01c1 }
            if (r0 == 0) goto L_0x01a1
            com.introvd.template.camera.b.f r0 = r15.bOJ     // Catch:{ all -> 0x01c1 }
            com.introvd.template.sdk.b.a.c r0 = r0.mo25524Vx()     // Catch:{ all -> 0x01c1 }
            long r0 = r0.aHp()     // Catch:{ all -> 0x01c1 }
            r6 = -2
            long r0 = r0 & r6
            com.introvd.template.camera.b.f r6 = r15.bOJ     // Catch:{ all -> 0x01c1 }
            com.introvd.template.sdk.b.a.c r6 = r6.mo25524Vx()     // Catch:{ all -> 0x01c1 }
            r6.mo33899aW(r0)     // Catch:{ all -> 0x01c1 }
            com.introvd.template.camera.b.f r0 = r15.bOJ     // Catch:{ all -> 0x01c1 }
            com.introvd.template.sdk.b.a.c r0 = r0.mo25524Vx()     // Catch:{ all -> 0x01c1 }
            com.introvd.template.sdk.b.a.a$a r0 = r0.aHq()     // Catch:{ all -> 0x01c1 }
            if (r0 != 0) goto L_0x00a1
            monitor-exit(r15)
            return
        L_0x00a1:
            com.introvd.template.sdk.utils.b.a r1 = r15.bOK     // Catch:{ all -> 0x01c1 }
            boolean r1 = com.introvd.template.sdk.utils.C8572y.m25072a(r1)     // Catch:{ all -> 0x01c1 }
            if (r1 == 0) goto L_0x00ac
            r1 = 4
            r7 = 4
            goto L_0x00ad
        L_0x00ac:
            r7 = 2
        L_0x00ad:
            java.lang.String r1 = "PREVIEW_CB"
            float r1 = com.mediarecorder.engine.PerfBenchmark.getPerf(r1)     // Catch:{ all -> 0x01c1 }
            r6 = 0
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x00be
            r6 = 1203982336(0x47c35000, float:100000.0)
            float r6 = r6 / r1
            int r1 = (int) r6     // Catch:{ all -> 0x01c1 }
            goto L_0x00c0
        L_0x00be:
            r1 = 3333(0xd05, float:4.67E-42)
        L_0x00c0:
            com.introvd.template.common.MSize r6 = new com.introvd.template.common.MSize     // Catch:{ all -> 0x01c1 }
            r6.<init>()     // Catch:{ all -> 0x01c1 }
            java.lang.String r8 = "out-video-width"
            int r8 = r0.getInt(r8)     // Catch:{ all -> 0x01c1 }
            r6.width = r8     // Catch:{ all -> 0x01c1 }
            java.lang.String r8 = "out-video-height"
            int r8 = r0.getInt(r8)     // Catch:{ all -> 0x01c1 }
            r6.height = r8     // Catch:{ all -> 0x01c1 }
            int r8 = r15.bLR     // Catch:{ all -> 0x01c1 }
            if (r8 != 0) goto L_0x00db
            r11 = 2
            goto L_0x00dc
        L_0x00db:
            r11 = 1
        L_0x00dc:
            com.introvd.template.sdk.utils.b.a r8 = r15.bOK     // Catch:{ all -> 0x01c1 }
            xiaoying.engine.QEngine r8 = r8.aJv()     // Catch:{ all -> 0x01c1 }
            int r9 = r1 / 100
            int r10 = r6.width     // Catch:{ all -> 0x01c1 }
            int r12 = r6.height     // Catch:{ all -> 0x01c1 }
            int r13 = com.introvd.template.sdk.utils.C8572y.aJm()     // Catch:{ all -> 0x01c1 }
            r14 = 3
            r6 = r8
            r8 = r9
            r9 = r10
            r10 = r12
            r12 = r13
            r13 = r14
            int r6 = xiaoying.engine.base.QUtils.caculateVideoBitrate(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x01c1 }
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ all -> 0x01c1 }
            java.lang.String r8 = "%d"
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x01c1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01c1 }
            r10 = 0
            r9[r10] = r6     // Catch:{ all -> 0x01c1 }
            java.lang.String r6 = java.lang.String.format(r7, r8, r9)     // Catch:{ all -> 0x01c1 }
            java.lang.String r7 = "video-bitrate"
            r0.set(r7, r6)     // Catch:{ all -> 0x01c1 }
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ all -> 0x01c1 }
            java.lang.String r7 = "%d"
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x01c1 }
            int r1 = r1 * 10
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01c1 }
            r8[r10] = r1     // Catch:{ all -> 0x01c1 }
            java.lang.String r1 = java.lang.String.format(r6, r7, r8)     // Catch:{ all -> 0x01c1 }
            java.lang.String r6 = "video-frame-rate"
            r0.set(r6, r1)     // Catch:{ all -> 0x01c1 }
            com.introvd.template.camera.b.i r1 = com.introvd.template.camera.p229b.C5008i.m12937VU()     // Catch:{ all -> 0x01c1 }
            int r1 = r1.getDurationLimit()     // Catch:{ all -> 0x01c1 }
            if (r1 == 0) goto L_0x0160
            int r6 = r15.bOz     // Catch:{ all -> 0x01c1 }
            boolean r6 = com.introvd.template.router.camera.CameraCodeMgr.isCameraParamPIP(r6)     // Catch:{ all -> 0x01c1 }
            if (r6 == 0) goto L_0x0155
            com.introvd.template.camera.b.i r6 = com.introvd.template.camera.p229b.C5008i.m12937VU()     // Catch:{ all -> 0x01c1 }
            int r6 = r6.mo25622Wi()     // Catch:{ all -> 0x01c1 }
            r7 = -1
            if (r7 == r6) goto L_0x014a
            com.introvd.template.camera.b.c r1 = r15.bMO     // Catch:{ all -> 0x01c1 }
            int r1 = r1.mo25472iS(r6)     // Catch:{ all -> 0x01c1 }
            long r6 = (long) r1     // Catch:{ all -> 0x01c1 }
            r10 = 1
            goto L_0x0161
        L_0x014a:
            float r6 = r15.bOx     // Catch:{ all -> 0x01c1 }
            int r7 = r15.bOF     // Catch:{ all -> 0x01c1 }
            int r1 = r1 - r7
            long r7 = (long) r1     // Catch:{ all -> 0x01c1 }
            long r6 = r15.m11818a(r6, r7)     // Catch:{ all -> 0x01c1 }
            goto L_0x0161
        L_0x0155:
            float r6 = r15.bOx     // Catch:{ all -> 0x01c1 }
            int r7 = r15.bOF     // Catch:{ all -> 0x01c1 }
            int r1 = r1 - r7
            long r7 = (long) r1     // Catch:{ all -> 0x01c1 }
            long r6 = r15.m11818a(r6, r7)     // Catch:{ all -> 0x01c1 }
            goto L_0x0161
        L_0x0160:
            r6 = r4
        L_0x0161:
            com.introvd.template.router.todoCode.TODOParamModel r1 = r15.todoParamModel     // Catch:{ all -> 0x01c1 }
            if (r1 == 0) goto L_0x0189
            com.introvd.template.router.todoCode.TODOParamModel r1 = r15.todoParamModel     // Catch:{ all -> 0x01c1 }
            int r1 = r1.getActivityFlag()     // Catch:{ all -> 0x01c1 }
            if (r1 == r3) goto L_0x016f
            if (r1 != r2) goto L_0x0189
        L_0x016f:
            if (r10 != 0) goto L_0x0189
            com.introvd.template.router.todoCode.TODOParamModel r1 = r15.todoParamModel     // Catch:{ all -> 0x01c1 }
            int r1 = r1.getLimitDuration()     // Catch:{ all -> 0x01c1 }
            if (r1 <= 0) goto L_0x0189
            com.introvd.template.router.todoCode.TODOParamModel r1 = r15.todoParamModel     // Catch:{ all -> 0x01c1 }
            int r1 = r1.getLimitDuration()     // Catch:{ all -> 0x01c1 }
            float r2 = r15.bOx     // Catch:{ all -> 0x01c1 }
            int r3 = r15.bOF     // Catch:{ all -> 0x01c1 }
            int r1 = r1 - r3
            long r6 = (long) r1     // Catch:{ all -> 0x01c1 }
            long r6 = r15.m11818a(r2, r6)     // Catch:{ all -> 0x01c1 }
        L_0x0189:
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x018f
            r6 = 1
        L_0x018f:
            java.lang.String r1 = "max-duration"
            java.lang.String r2 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x01c1 }
            r0.set(r1, r2)     // Catch:{ all -> 0x01c1 }
            com.introvd.template.camera.b.f r1 = r15.bOJ     // Catch:{ all -> 0x01c1 }
            com.introvd.template.sdk.b.a.c r1 = r1.mo25524Vx()     // Catch:{ all -> 0x01c1 }
            r1.mo33895a(r0)     // Catch:{ all -> 0x01c1 }
        L_0x01a1:
            r15.m11800Td()     // Catch:{ all -> 0x01c1 }
            goto L_0x01bf
        L_0x01a5:
            com.introvd.template.camera.b.f r0 = r15.bOJ     // Catch:{ all -> 0x01c1 }
            int r0 = r0.getState()     // Catch:{ all -> 0x01c1 }
            if (r0 == r2) goto L_0x01b5
            com.introvd.template.camera.b.f r0 = r15.bOJ     // Catch:{ all -> 0x01c1 }
            int r0 = r0.getState()     // Catch:{ all -> 0x01c1 }
            if (r0 != r1) goto L_0x01bf
        L_0x01b5:
            boolean r0 = r15.bMo     // Catch:{ all -> 0x01c1 }
            r15.m11846ci(r0)     // Catch:{ all -> 0x01c1 }
            android.os.Handler r0 = r15.mHandler     // Catch:{ all -> 0x01c1 }
            r0.removeMessages(r2)     // Catch:{ all -> 0x01c1 }
        L_0x01bf:
            monitor-exit(r15)
            return
        L_0x01c1:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.CameraActivity.m11808Tm():void");
    }

    /* renamed from: Tn */
    private void m11809Tn() {
        if (this.bMl == null) {
            this.bMl = new OrientationEventListener(getApplicationContext()) {
                public void onOrientationChanged(int i) {
                    if (i != -1 && CameraActivity.this.bMN != null) {
                        if (CameraActivity.this.getState() == 2) {
                            CameraActivity.this.bMN.mo25690cp(false);
                        } else if (!CameraActivity.this.bOG && !CameraActivity.this.bMN.mo25672Ul()) {
                            int cg = C5034e.m13258cg(i, CameraActivity.this.mOrientation);
                            if (CameraActivity.this.bMq != cg) {
                                if (CameraActivity.this.bOy == 512 && CameraActivity.this.getState() != 2) {
                                    int i2 = cg % 360;
                                    if (Build.MODEL.equals("HTC ChaCha A810e")) {
                                        i2 = (cg + 90) % 360;
                                    }
                                    if (CameraActivity.this.bMN != null) {
                                        if (i2 == 0 || 180 == i2) {
                                            CameraActivity.this.bMN.mo25690cp(true);
                                        } else {
                                            CameraActivity.this.bMN.mo25690cp(false);
                                        }
                                    }
                                }
                                CameraActivity.this.bMq = cg;
                            }
                        }
                    }
                }
            };
            this.bMl.enable();
        }
    }

    /* renamed from: To */
    private void m11810To() {
        if (this.bMl != null) {
            this.bMl.disable();
            this.bMl = null;
        }
    }

    /* renamed from: Tu */
    private void m11811Tu() {
        if (this.bMZ == null) {
            this.bMZ = new C8759b(4);
            this.bMZ.mo35196a(getApplicationContext(), 0, 210239504, AppStateModel.getInstance().isInChina());
        }
        EffectInfoModel aMr = this.bMZ.aMr();
        if (aMr != null) {
            m11855eN(aMr.mPath);
        }
    }

    /* renamed from: Tx */
    private void m11812Tx() {
        this.bMh = new C8394d(getApplicationContext(), this.bLR);
        C8393c.m24213d(this.bMh.aHm());
        this.bOJ.mo25561ja(this.bLR);
        AppPreferencesSetting.getInstance().setAppSettingInt("pref_view_camera_id", this.bLR);
        if (this.ajR) {
            AppPreferencesSetting.getInstance().setAppSettingInt(bMz, this.bLR);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Ty */
    public void m11813Ty() {
        if (this.bON != null) {
            if (getState() == 4 || getState() == 2 || this.bLR != 0 || this.bOG) {
                this.mHandler.removeMessages(771);
                this.bON.mo25774WK();
                this.bON.clearFocus();
            } else {
                this.bON.mo25775WL();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Tz */
    public void m11814Tz() {
        C8978m.m26349hs(this).mo10296do(R.string.xiaoying_str_cam_uncompleted_pip_ask).mo10303dv(R.string.xiaoying_str_com_ok).mo10291b(new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                CameraActivity.this.bOH = true;
                if (CameraActivity.this.bMn || CameraActivity.this.bMJ == 1) {
                    CameraActivity.this.mo24908ck(true);
                    CameraActivity.this.bOG = true;
                    CameraActivity.this.mHandler.sendEmptyMessage(20);
                    return;
                }
                if (CameraActivity.this.bMM != null) {
                    CameraActivity.this.bMM.aJF();
                    CameraActivity.this.bMM.ebQ = -1;
                }
                CameraActivity.this.bOG = true;
                CameraActivity.this.mHandler.sendEmptyMessage(20);
            }
        }).mo10313qu().show();
    }

    /* renamed from: a */
    private long m11818a(float f, long j) {
        return f <= 0.0f ? j : (long) (((float) j) / f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11826a(EffectInfoModel effectInfoModel) {
        if (!BaseSocialNotify.isNetworkAvaliable(getApplicationContext())) {
            ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_com_msg_network_inactive, 0);
            return;
        }
        if (this.bMP == null) {
            this.bMP = new C8692b(getApplicationContext(), this.mHandler);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("ttid", effectInfoModel.mTemplateId);
        int a = this.bMP.mo35058a(effectInfoModel.mTemplateId, 1537, bundle);
        String bn = C8450a.m24469bn(effectInfoModel.mTemplateId);
        UserEventDurationRelaUtils.startDurationEvent(bn, a, "");
        UserEventDurationRelaUtils.dummyXytDownloadStartEvent(getApplicationContext(), effectInfoModel.mName, "transition", bn);
    }

    /* renamed from: a */
    private void m11827a(boolean z, Parameters parameters) {
        if (parameters != null) {
            if (parameters.isAutoExposureLockSupported()) {
                parameters.setAutoExposureLock(z);
            }
            if (parameters.isAutoWhiteBalanceLockSupported()) {
                parameters.setAutoWhiteBalanceLock(z);
            }
        }
    }

    /* renamed from: a */
    private boolean m11828a(Parameters parameters) {
        boolean z = false;
        if (parameters == null) {
            return false;
        }
        if (parameters.isAutoExposureLockSupported() || parameters.isAutoWhiteBalanceLockSupported()) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m11830a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: ad */
    public synchronized void m11831ad(long j) {
        if (getState() != 2) {
            if (CameraCodeMgr.isCameraParamPIP(this.bOz) && this.bMY != null && j == this.bMY.mo25491Vu().longValue()) {
                this.bMY.mo25503d(Long.valueOf(j));
            } else if (j == this.bMS && this.bOt != null) {
                int bx = this.bOt.mo35205bx(this.bMS);
                if (-1 != bx) {
                    m11863iv(bx);
                }
            }
        }
    }

    /* renamed from: ae */
    private void m11832ae(long j) {
        long j2;
        m11811Tu();
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bMY.mo25499ae(j);
        } else {
            if (this.bOI) {
                j2 = 524304;
            } else {
                j2 = this.bOJ.mo25516VB().height * 9 == this.bOJ.mo25516VB().width * 16 ? 524296 : 524290;
            }
            this.bOt.mo35196a(getApplicationContext(), j, j2 | 209715200, AppStateModel.getInstance().isInChina());
        }
        this.bMN.setEffectMgr(this.bOt);
    }

    /* renamed from: bN */
    private void m11837bN(int i, int i2) {
        if (this.bMN == null) {
            this.bMN = new C5009j(this, this.bNb);
        }
        if (this.bMN.mo25695jp(i)) {
            this.bMN.mo25694jo(this.bOy);
            return;
        }
        this.bMN.mo25683a(this.bOy, i == 256 ? new CameraViewDefaultPor(this) : new CameraViewDefaultLan(this));
        this.bMN.mo25694jo(this.bOy);
        this.bMN.setCallbackHandler(this.bLS);
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bMY.mo25496a(this.bMN);
            return;
        }
        this.bMN.setEffectMgr(this.bOt);
        this.bMN.setSoundPlayer(this.bMf);
    }

    /* renamed from: bO */
    private void m11838bO(int i, int i2) {
        m11859g(i, i2, false);
    }

    /* renamed from: bP */
    private RelativeLayout m11839bP(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("adjustPreviewLayout outputsize height: ");
        sb.append(i);
        sb.append(" width: ");
        sb.append(i2);
        LogUtils.m14223i("CameraActivity", sb.toString());
        LayoutParams layoutParams = (LayoutParams) this.bMj.getLayoutParams();
        if (i == i2) {
            if (C5034e.m13264s(this, false)) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.v4_xiaoying_com_top_panel_height);
            }
            layoutParams.width = this.bLT.width;
            layoutParams.height = layoutParams.width;
        } else if (i > i2) {
            if (i * i2 < 230400) {
                layoutParams.topMargin = 0;
                layoutParams.width = this.bLT.width;
                layoutParams.height = (layoutParams.width * i) / i2;
            } else if ((this.bLT.width * i) / i2 >= this.bLT.height) {
                layoutParams.topMargin = (this.bLT.height - ((this.bLT.width * i) / i2)) / 2;
                layoutParams.bottomMargin = layoutParams.topMargin;
                layoutParams.width = this.bLT.width;
                layoutParams.height = (layoutParams.width * i) / i2;
            } else {
                layoutParams.topMargin = 0;
                layoutParams.height = this.bLT.height;
                layoutParams.width = (layoutParams.height * i2) / i;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("params.topMargin: ");
        sb2.append(layoutParams.topMargin);
        LogUtils.m14223i("CameraActivity", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("params.width: ");
        sb3.append(layoutParams.width);
        LogUtils.m14223i("CameraActivity", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("params.height: ");
        sb4.append(layoutParams.height);
        LogUtils.m14223i("CameraActivity", sb4.toString());
        this.bMj.setLayoutParams(layoutParams);
        return this.bMj;
    }

    /* access modifiers changed from: private */
    /* renamed from: bQ */
    public void m11840bQ(int i, int i2) {
        if (this.bMM != null) {
            long b = C5034e.m13252b(this.bOx, (long) (i2 - this.bOD));
            if (this.bMM.aHd() != null) {
                long j = ((long) this.bOF) + b;
                boolean z = (!this.bMr || this.bMt == 0) ? new C9006a(null, (int) j, this.bMV).aNp() : j > ((long) (this.bMt * 1000));
                this.bMN.setTimeExceed(z);
                if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                    this.bMY.mo25500ah(j);
                } else {
                    this.bMN.setCurrentTimeValue(j);
                }
            }
            this.bMN.mo25677Ux();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cg */
    public boolean m11844cg(boolean z) {
        if (!this.bLX) {
            String str = null;
            if (this.bMc) {
                PIPDesignerRouter.launchPipDesigner(this, null);
            } else if (z) {
                DataItemProject aHe = this.bMM.aHe();
                if (!(aHe == null || aHe.strPrjURL == null)) {
                    str = aHe.strPrjURL;
                }
                if (str != null) {
                    File file = new File(C8572y.m25097ou(str));
                    String[] list = file.list();
                    if (list == null || list.length == 0) {
                        file.delete();
                    }
                }
            }
        } else if (this.bMM == null) {
            return true;
        } else {
            if (this.bMM.aHe() != null) {
                if (this.todoParamModel == null || this.todoParamModel.getActivityFlag() <= 0 || this.todoParamModel.isEnterPreview()) {
                    C8522g aJA = C8522g.aJA();
                    if (aJA != null) {
                        DataItemProject aHe2 = aJA.aHe();
                        if (aHe2 != null) {
                            boolean bi = C8446b.aIZ().mo34322bi(aHe2._id);
                            String passThroughUrlFromIntent = PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent());
                            if (bi) {
                                EditorRouter.launchEditorPreviewActivity((Activity) this, C3742b.m9111II().mo23139JG(), passThroughUrlFromIntent);
                            } else {
                                EditorRouter.launchEditorActivity((Activity) this, passThroughUrlFromIntent);
                            }
                        }
                    }
                } else {
                    FuncExportRouter.launchFuncExportActivity(this, this.todoParamModel);
                }
            }
        }
        if (this.bMb) {
            StudioRouter.launchStudioActivity(this);
        } else if (!this.bOH && !this.bLX && !this.bLY && !this.bLZ && !this.bMc && this.bMa && (this.bMA || this.bMM.aJJ() || (this.bMJ == 1 && this.mClipCount != 0))) {
            StudioRouter.launchStudioActivity(this);
        }
        return true;
    }

    /* renamed from: ch */
    private void m11845ch(boolean z) {
        if (this.bMi == null) {
            if (!z) {
                mo25824Ur();
                LogUtils.m14222e("CameraActivity", "========= doReleaseEginge done ==========");
            } else {
                this.bMi = new Thread(new Runnable() {
                    public void run() {
                        if (CameraActivity.this.bOJ != null) {
                            Process.setThreadPriority(1);
                            try {
                                CameraActivity.this.mo25824Ur();
                                if (CameraActivity.this.mHandler != null) {
                                    CameraActivity.this.mHandler.sendEmptyMessage(1281);
                                }
                            } catch (Exception unused) {
                            }
                            LogUtils.m14222e("CameraActivity", "========= doAsyncReleaseEginge done ==========");
                        }
                    }
                });
                this.bMi.start();
            }
        }
    }

    /* renamed from: ci */
    private void m11846ci(boolean z) {
        setState(5);
        this.bOG = true;
        this.bOJ.mo25539cB(z);
        if (z) {
            m11804Th();
        }
        m11789SY();
        this.bOD = 0;
        this.bOM = 0;
        if (this.bOH) {
            FileUtils.deleteFile(this.bMd);
        }
        if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bMY.mo25510m(z, this.bMW);
        } else if (this.bMO != null && !this.bOH) {
            this.bMO.mo25469cu(this.bMW);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cj */
    public void m11847cj(boolean z) {
        this.bMo = z;
        m11808Tm();
        this.bMo = true;
    }

    /* renamed from: eM */
    private void m11854eM(String str) {
        if (TextUtils.isEmpty(this.bNc)) {
            this.bNc = str;
        }
    }

    /* renamed from: eN */
    private synchronized void m11855eN(String str) {
        this.bOC = m11856eO(str);
        this.bOJ.mo25534b(str, this.bOC, false);
    }

    /* renamed from: eO */
    private int m11856eO(String str) {
        return C8560o.m25040dH(0, C8540q.m24966oP(str));
    }

    /* access modifiers changed from: private */
    public void exit() {
        LogUtils.m14223i("CameraActivity", "exit <---");
        if (!this.bLV) {
            if (getState() == 2 || getState() == 6) {
                m11847cj(true);
            }
            m11845ch(true);
            if (this.bOH) {
                FileUtils.deleteFile(this.bMd);
            } else if (this.bMO != null) {
                this.bMO.mo25469cu(this.bMW);
            }
            if (!this.bOH) {
                m11797Ta();
            }
            if (!this.bOH && this.bMO != null) {
                this.bMO.mo25459UX();
            }
            this.bMa = true;
            int a = !this.bOH ? this.bMM.mo34731a(!this.bMn || this.bLX || this.bLY || this.bLZ || this.bMb || this.bMc, this.bOK, this.bLS, true, true, AppStateModel.getInstance().isCommunitySupport(), this.bMM.mo34778uz(this.bMM.ebQ)) : 1;
            if ((this.bMn || this.bMJ == 1) && this.bMM != null) {
                DataItemProject aHe = this.bMM.aHe();
                if (aHe != null) {
                    C8446b.aIZ().mo34319b(getApplicationContext(), aHe._id, 2);
                    C8446b.aIZ().mo34320b(getApplicationContext(), aHe._id, this.bNc);
                }
            }
            if (a != 0) {
                finish();
                m11844cg(true);
            }
            LogUtils.m14223i("CameraActivity", "exit --->");
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: g */
    public void m11859g(int i, int i2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("cameraMode: ");
        sb.append(i);
        LogUtils.m14223i("CameraActivity", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cameraModeParam: ");
        sb2.append(i2);
        LogUtils.m14223i("CameraActivity", sb2.toString());
        if (this.bOJ != null) {
            m11813Ty();
            this.bMC = this.bOy;
            this.bMD = this.bOz;
            this.bOy = i;
            this.bOz = i2;
            long j = 0;
            QStoryboard aHd = this.bMM.aHd();
            if (aHd != null) {
                j = C8762d.aMt().getTemplateID((String) aHd.getProperty(16391));
            }
            this.bMQ = this.bMD != i2;
            int i3 = this.bMC;
            if (this.bMQ && CameraCodeMgr.isCameraParamPIP(this.bMD) && this.bMY != null) {
                this.bMY.mo25492Vv();
            }
            if (i == 512) {
                if (1 != this.bMU.getSystemUiVisibility() && !"M040".equals(Build.MODEL)) {
                    this.bMU.setSystemUiVisibility(1);
                }
                this.bOw = QDisplayContext.DISPLAY_ROTATION_270;
                this.bOI = false;
                this.bOJ.mo25542cE(false);
                m11839bP(this.bOJ.mo25516VB().width, this.bOJ.mo25516VB().height);
                this.bMN.mo25691cq(true);
            } else {
                if (!"M040".equals(Build.MODEL) && this.bMU.getSystemUiVisibility() != 0) {
                    this.bMU.setSystemUiVisibility(0);
                }
                this.bOw = 0;
                this.bOI = true;
                this.bOJ.mo25542cE(true);
                m11839bP(this.bLT.width, this.bLT.width);
            }
            m11832ae(j);
            m11837bN(this.bOy, this.bOz);
            if (this.bMN != null) {
                this.bMN.mo25689bZ(this.bOy, this.bOz);
                this.bMN.mo25682Wu();
                this.bMN.mo25693jj(this.mClipCount);
            }
            m11864iw(i2);
            C5036f.setDegree(this.bOw);
            if (this.bMD != this.bOz) {
                boolean Wg = C5008i.m12937VU().mo25620Wg();
                boolean Wh = C5008i.m12937VU().mo25621Wh();
                if (CameraCodeMgr.isCameraParamPIP(this.bMD)) {
                    if (Wg || Wh) {
                        this.bMW = true;
                        mo24907cf(false);
                        ArrayList c = C5034e.m13257c(this.bMM);
                        this.bOF = C5034e.m13259d(this.bMM);
                        this.mClipCount = C5034e.m13251b(this.bMM);
                        C5008i.m12937VU().mo25632a(c);
                        this.bMN.mo25693jj(this.mClipCount);
                        if (C5008i.m12937VU().getDurationLimit() != 0) {
                            this.bMN.mo25666UA();
                        }
                        this.bMW = false;
                    } else {
                        this.bMY.mo25489Vq();
                        this.bMN.mo25693jj(this.mClipCount);
                    }
                    mo24902Tv();
                } else {
                    mo24894SV();
                }
            }
            if (this.bOy == 512 && getState() != 2) {
                int i4 = this.bMq % 360;
                if ("HTC ChaCha A810e".equals(Build.MODEL)) {
                    i4 = (this.bMq + 90) % 360;
                }
                if (i4 == 0 || 180 == i4) {
                    this.bMN.mo25690cp(true);
                } else {
                    this.bMN.mo25690cp(false);
                }
            }
            this.bMN.mo25687b(this.bMj);
            m11813Ty();
            if (this.bOI) {
                if (this.bOJ != null) {
                    this.bOJ.setDeviceOrientation(90);
                }
            } else if (CameraCodeMgr.isCameraParamPIP(i2)) {
                if (this.bOJ != null) {
                    this.bOJ.mo25530a(true, (QPIPFrameParam) null);
                }
            } else if (this.bOJ != null) {
                this.bOJ.setDeviceOrientation(0);
            }
            if (this.bMB == 4097) {
                AppPreferencesSetting.getInstance().setAppSettingInt(CameraRouter.KEY_PREF_LAST_CAMERA_MODE_PARAM, this.bOz);
            }
            if (this.todoParamModel != null && this.todoParamModel.getActivityFlag() <= 0) {
                int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt(bMz, -1);
                if (-1 == appSettingInt || appSettingInt == this.bLR) {
                    AppPreferencesSetting.getInstance().setAppSettingInt(bMz, this.bLR);
                } else {
                    m11805Ti();
                }
            }
            if (this.ajR) {
                m11863iv(this.bOB);
            }
            if (CameraCodeMgr.isCameraParamPIP(i2)) {
                this.bMY.mo25506g(i, i2, this.ajR);
            }
            if (this.bOJ != null) {
                this.bOJ.mo25552eV(null);
            }
            this.bMN.mo25670Uj();
            this.bON.mo25770WE();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: iu */
    public void m11862iu(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("doOrientationChanged: orientation ");
        sb.append(i);
        LogUtils.m14223i("CameraActivity", sb.toString());
        if (this.mOrientation != i) {
            this.mOrientation = i;
            if (this.bOI || this.mClipCount == 0 || this.bOy != 512 || getState() == 2) {
                this.bML.aNX();
            } else {
                int i2 = this.mOrientation % 360;
                this.bOw = i2;
                if ("HTC ChaCha A810e".equals(Build.MODEL)) {
                    i2 = (this.mOrientation + 90) % 360;
                }
                if (i2 == 0 || 180 == i2) {
                    this.bML.mo36087f(findViewById(R.id.cam_layout_main), 0, C4580b.m11666qi());
                    this.bML.show();
                } else {
                    this.bML.aNX();
                }
            }
            if ("HTC ChaCha A810e".equals(Build.MODEL)) {
                this.bOw = (this.mOrientation + 90) % 360;
            } else {
                this.bOw = this.mOrientation % 360;
            }
        }
    }

    /* renamed from: iv */
    private synchronized void m11863iv(int i) {
        m11881y(i, false);
    }

    /* renamed from: iw */
    private void m11864iw(int i) {
        this.bOz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: ix */
    public void m11865ix(int i) {
        try {
            if (!this.bMF) {
                this.bMG = i;
                m11795TE();
            } else if (this.bMH != i && this.bME != 0) {
                this.bMH = i;
                if (this.bME == 1) {
                    this.bME = 2;
                    this.bOJ.mo25525Vy().aHl().stopSmoothZoom();
                }
            } else if (this.bME == 0 && this.bMG != i) {
                this.bMH = i;
                this.bOJ.mo25525Vy().aHl().startSmoothZoom(i);
                this.bME = 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onConnected() {
        LogUtils.m14223i("CameraActivity", "onConnected<---");
        if (this.bOJ.mo25524Vx() == null || this.bOJ.mo25524Vx().getCamera() == null || this.bOJ.mo25525Vy() == null) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_cam_cannot_connect_camera_tip, 1);
            exit();
            return;
        }
        if (!this.bLW) {
            m11806Tj();
        } else {
            m11807Tk();
        }
        this.bON.mo25784jr(4);
        if (this.bOy == 512) {
            if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                if (this.bOJ != null) {
                    this.bOJ.mo25530a(true, (QPIPFrameParam) null);
                }
            } else if (this.bOJ != null) {
                this.bOJ.setDeviceOrientation(0);
            }
        } else if (this.bOy == 256 && this.bOJ != null) {
            this.bOJ.setDeviceOrientation(90);
        }
        this.ajR = !this.bOL;
        if (this.bNa && this.mHandler != null) {
            this.mHandler.sendEmptyMessage(18);
        }
        LogUtils.m14223i("CameraActivity", "onConnected--->");
    }

    @SuppressLint({"NewApi"})
    private void setState(int i) {
        if (2 == i && this.bOy == 512 && 1 != this.bMU.getSystemUiVisibility() && !"M040".equals(Build.MODEL)) {
            this.bMU.setSystemUiVisibility(1);
        }
        this.bOJ.setState(i);
        this.bMN.setState(i);
        StringBuilder sb = new StringBuilder();
        sb.append("mState == ");
        sb.append(i);
        LogUtils.m14223i("CameraActivity", sb.toString());
    }

    private void startPreview() {
        if (!this.bLV && !isFinishing() && this.bLW) {
            boolean z = true;
            if (getState() != 1) {
                C4996f fVar = this.bOJ;
                if (this.bLR == 0) {
                    z = false;
                }
                fVar.mo25547cx(z);
                this.bOJ.startPreview();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public synchronized void m11881y(int i, boolean z) {
        this.bMS = -1;
        if (this.bOt != null) {
            EffectInfoModel vh = this.bOt.mo35214vh(i);
            if (vh != null) {
                if (this.bMM != null) {
                    DataItemProject aHe = this.bMM.aHe();
                    if (aHe != null) {
                        aHe.usedEffectTempId = C8759b.m25587jf(vh.mPath);
                        this.bOB = i;
                        m11855eN(vh.mPath);
                        this.bMN.mo25686b(i, true, z);
                    }
                }
            }
        }
    }

    /* renamed from: SV */
    public void mo24894SV() {
        if (getState() == 2) {
            m11801Te();
            m11847cj(true);
        } else if (getState() == 6) {
            m11847cj(true);
        } else if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bMY.mo25510m(true, this.bMW);
        } else if (this.bMO != null && !this.bOH) {
            this.bMO.mo25469cu(this.bMW);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: SZ */
    public void mo24895SZ() {
        C8345d.m24060R(getApplicationContext(), "AppIsBusy", String.valueOf(true));
        m11809Tn();
        C4597i.m11729b(true, this);
        this.bOG = true;
        C8553i.setContext(getApplicationContext());
        C8553i.m25005ut(55);
        UserBehaviorLog.onResume(this);
        QStoryboard aHd = this.bMM.aHd();
        m11832ae(aHd != null ? C8762d.aMt().getTemplateID((String) aHd.getProperty(16391)) : 0);
        if (this.bMN != null) {
            this.bMN.mo25682Wu();
        }
        long j = this.bMM.aHe() != null ? this.bMM.aHe().usedEffectTempId : 0;
        int bx = j != 0 ? this.bOt.mo35205bx(j) : 0;
        if (bx == -1 && C8759b.m25586by(j) == null) {
            bx = 0;
        }
        this.bOB = bx;
        if (this.bMN != null) {
            this.bMN.onResume();
        }
        LogUtils.m14223i("CameraActivity", "doOnResume <---");
        if (this.bMO == null) {
            this.bMO = new C4991c(getApplicationContext());
        }
        this.bMO.mo25458UW();
        this.ajC = ((PowerManager) getSystemService("power")).newWakeLock(26, getClass().getName());
        this.ajC.setReferenceCounted(false);
        this.ajC.acquire();
        connect();
        this.bMG = 0;
        this.bLV = false;
        if (this.bON != null) {
            this.bON.mo25772WI();
        }
        this.bOL = false;
        LogUtils.m14223i("CameraActivity", "doOnResume --->");
    }

    /* renamed from: Tl */
    public void mo24896Tl() {
        m11847cj(false);
    }

    /* renamed from: Tp */
    public void mo24897Tp() {
        if (!(this.bLR == 1 || this.bOJ == null || this.bOJ.mo25525Vy() == null)) {
            try {
                this.bOJ.mo25525Vy().autoFocus(this.bMv);
            } catch (Exception unused) {
            }
        }
    }

    @TargetApi(14)
    /* renamed from: Tq */
    public void mo24898Tq() {
        if (ApiHelper.ICE_CREAM_SANDWICH_AND_HIGHER) {
            Parameters VC = this.bOJ.mo25517VC();
            if (VC != null && this.bOJ.mo25525Vy() != null && this.bON != null) {
                boolean z = false;
                boolean z2 = VC.getMaxNumFocusAreas() > 0;
                if (VC.getMaxNumMeteringAreas() > 0) {
                    z = true;
                }
                if (z2) {
                    try {
                        VC.setFocusAreas(this.bON.getFocusAreas());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (z) {
                    try {
                        VC.setMeteringAreas(this.bON.getMeteringAreas());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (z2 || z) {
                    this.bOJ.mo25533b(VC);
                }
            }
        }
    }

    /* renamed from: Tr */
    public void mo24899Tr() {
        if (this.bMN != null && CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bMN.mo25664Tr();
        }
    }

    /* renamed from: Ts */
    public void mo24900Ts() {
        if (this.bMO != null && !this.bMO.mo25463Vc() && this.mClipCount > 0) {
            SaveRequest Va = this.bMO.mo25462Va();
            this.mClipCount--;
            this.bMO.mo25457Ts();
            if (Va != null) {
                this.bOF = (int) (((long) this.bOF) - C5034e.m13252b(this.bOx, (long) (Va.endPos - Va.startPos)));
                if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                    this.bMY.mo25505f(Va);
                }
            } else {
                this.bOF = 0;
                QStoryboard aHd = this.bMM.aHd();
                if (aHd != null && aHd.getClipCount() > 0) {
                    ProjectItem ahP = this.bMM.aHf();
                    if (ahP != null) {
                        C8443d dVar = ahP.mClipModelCacheList;
                        for (int i = 0; i < dVar.getCount(); i++) {
                            C8440a tX = dVar.mo34307tX(i);
                            if (tX != null && !tX.isCover()) {
                                this.bOF += tX.aHV();
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("mCurrentTotalTime : ");
                        sb.append(this.bOF);
                        LogUtils.m14223i("CameraActivity", sb.toString());
                    }
                }
            }
            mo24902Tv();
            if (C5008i.m12937VU().getDurationLimit() != 0) {
                if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                    mo24894SV();
                }
                if (C5008i.m12937VU().mo25615Wb()) {
                    C5008i.m12937VU().mo25635cK(false);
                }
            }
            this.bMA = true;
            this.bMN.mo25693jj(this.mClipCount);
            this.bMN.mo25665Ts();
        }
    }

    /* renamed from: Tt */
    public void mo24901Tt() {
        int durationLimit = C5008i.m12937VU().getDurationLimit();
        if (durationLimit == 0 || ((int) m11818a(this.bOx, (long) (durationLimit - this.bOF))) >= 2000) {
            GalleryRouter.getInstance().launchPIPVideoPicker(this, true, 8193);
        } else {
            ToastUtils.show((Context) this, R.string.xiaoying_str_cam_pip_disable_gallery_pick, 1);
        }
    }

    /* renamed from: Tv */
    public void mo24902Tv() {
        if (this.bMM.aHd() != null) {
            long j = (long) this.bOF;
            boolean z = (!this.bMr || this.bMt == 0) ? new C9006a(null, (int) j, this.bMV).aNp() : j > ((long) (this.bMt * 1000));
            this.bMN.setTimeExceed(z);
            if (CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                this.bMY.mo25500ah(j);
            } else {
                this.bMN.setCurrentTimeValue(j);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("updateTotalTime totalSecond:");
            sb.append(j);
            LogUtils.m14223i("CameraActivity", sb.toString());
        }
    }

    /* renamed from: Tw */
    public void mo24903Tw() {
        LogUtils.m14223i("CameraActivity", "onSharedPreferencesChanged");
        if (!this.bLV && this.bMh != null) {
            this.bOJ.mo25543cF(this.bOI);
            Parameters VC = this.bOJ.mo25517VC();
            if (VC != null) {
                VC.setFocusMode("auto");
                List supportedAntibanding = VC.getSupportedAntibanding();
                if (supportedAntibanding != null && supportedAntibanding.contains("auto")) {
                    VC.setAntibanding("auto");
                }
                String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_flash_mode", "no_flash");
                List supportedFlashModes = VC.getSupportedFlashModes();
                if (supportedFlashModes == null || supportedFlashModes.size() <= 1) {
                    appSettingStr = "no_flash";
                } else if (this.bLQ >= 2 && this.bLR == 1) {
                    appSettingStr = "no_flash";
                } else if (m11830a(appSettingStr, supportedFlashModes)) {
                    this.bOJ.mo25528a(VC, VC.getFlashMode(), appSettingStr);
                } else {
                    appSettingStr = VC.getFlashMode();
                    if (appSettingStr == null) {
                        appSettingStr = "no_flash";
                    }
                }
                AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_flash_mode", appSettingStr);
                String string = this.bMh.getString("pref_camera_focusmode_key", getString(R.string.xiaoying_str_cam_pref_camera_focusmode_default_notrans));
                if (!m11830a(string, VC.getSupportedFocusModes())) {
                    String focusMode = VC.getFocusMode();
                } else if (this.bOJ.mo25517VC() != null) {
                    this.bOJ.mo25517VC().setFocusMode(string);
                }
                C5008i.m12937VU().mo25634cJ(C5030b.m13205jL(this.bOz));
                String appSettingStr2 = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "unlock");
                if (m11828a(VC)) {
                    AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", appSettingStr2);
                    m11827a(SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(appSettingStr2), VC);
                } else {
                    AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", "no_aelock");
                }
                this.bOJ.mo25533b(VC);
                this.bMN.mo25670Uj();
                this.bON.mo25779c(VC);
                if ("on".equalsIgnoreCase(VC.getFlashMode()) || "torch".equalsIgnoreCase(VC.getFlashMode())) {
                    this.bOJ.mo25545cH(true);
                } else {
                    this.bOJ.mo25545cH(false);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo24904a(C5039g gVar) {
        return true;
    }

    /* renamed from: b */
    public boolean mo24905b(C5039g gVar) {
        int i;
        if (this.bLR == 1) {
            return false;
        }
        Parameters VC = this.bOJ.mo25517VC();
        if (VC == null || !VC.isZoomSupported() || VC.getZoomRatios() == null) {
            return false;
        }
        gVar.mo25891YV();
        if (gVar.getCurrentSpan() - this.bMg > 10.0f) {
            this.bMg = gVar.getCurrentSpan();
            i = 1;
        } else if (gVar.getCurrentSpan() - this.bMg >= -10.0f) {
            return true;
        } else {
            this.bMg = gVar.getCurrentSpan();
            i = -1;
        }
        this.mHandler.removeMessages(3);
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
        return true;
    }

    /* renamed from: c */
    public void mo24906c(C5039g gVar) {
    }

    /* renamed from: cf */
    public void mo24907cf(boolean z) {
        if (!z) {
            int i = 0;
            mo24894SV();
            while (this.bMO != null && this.bMO.mo25463Vc() && i < 5) {
                i++;
                try {
                    Thread.sleep(400);
                } catch (Exception unused) {
                }
            }
            return;
        }
        mo24894SV();
    }

    /* renamed from: ck */
    public void mo24908ck(boolean z) {
        if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                this.bMM.mo34734a(getContentResolver(), aHe.strPrjURL, 3, z);
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bOG || !this.ajR || motionEvent == null) {
            return true;
        }
        if (this.bML != null) {
            this.bML.aNX();
        }
        if (C5008i.m12937VU().mo25612VY()) {
            this.bMN.mo25699p(motionEvent);
            return true;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isResponseTodoProcess() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8193 && i2 == -1 && CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bMY.onActivityResult(i, i2, intent);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionFirebaseStarVlogs.actionSefieCameraActivity(this);
        if ("M040".equals(Build.MODEL) || NotchUtil.isNotchDevice()) {
            setTheme(R.style.Theme_XiaoYingNoSplash);
        }
        this.bNd = (CameraIntentInfo) PassThoughUrlGenerator.getInfoFromIntent(getIntent(), CameraIntentInfo.class);
        this.todoParamModel = (TODOParamModel) PassThoughUrlGenerator.getInfoFromIntent(getIntent(), TODOParamModel.class);
        if (this.bNd != null) {
            this.bMw = this.bNd.magicCode;
            this.bMJ = this.bNd.newPrj;
            this.bMy = this.bNd.activityID;
        } else {
            this.bNd = new Builder().build();
        }
        C8567u.setContext(getApplicationContext());
        C8553i.setContext(getApplicationContext());
        C8553i.m25005ut(55);
        C5008i.m12937VU().init();
        this.bMv = new C4622a(this);
        this.bML = new C9136a(this, true);
        this.bLQ = Camera.getNumberOfCameras();
        AppPreferencesSetting.getInstance().setAppSettingInt("pref_view_camera_count", this.bLQ);
        this.bLS = new C4623b(this);
        this.mHandler = new C4625c(this);
        if (C5034e.m13240YT() <= 0) {
            try {
                MSize YS = C5034e.m13239YS();
                if (YS != null) {
                    int i = YS.width * YS.height;
                    if (i > 0) {
                        C5034e.m13262jM(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                ToastUtils.show((Context) this, R.string.xiaoying_str_cam_cannot_connect_camera_tip, 0);
                finish();
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("MagicCode:");
        sb.append(this.bMw);
        LogUtils.m14223i("CameraActivity", sb.toString());
        this.bOK = C8501a.aJs();
        this.bOJ = new C4996f(this, this.bOK.aJv(), false);
        this.bOJ.mo25529a(this.bNe);
        this.bOJ.setCallbackHandler(this.bLS);
        this.bMY = new C4995e(this);
        this.bMY.mo25493Z(this);
        this.bLP = new C5032d();
        this.bMO = new C4991c(getApplicationContext());
        this.bMV = C12177i.f6158n;
        this.bNb = (C5530d) MagicCode.getMagicParam(this.bMw, "AppRunningMode", new C5530d());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("runMode:");
        sb2.append(this.bNb.cnU);
        LogUtils.m14223i("CameraActivity", sb2.toString());
        this.bMr = this.bNb.cnU == 11;
        this.bMs = this.bNb.cnX;
        this.bMt = ((Integer) MagicCode.getMagicParam(this.bMw, "android.intent.extra.durationLimit", Integer.valueOf(0))).intValue();
        this.bMM = C8522g.aJA();
        if (this.bMM == null) {
            finish();
            return;
        }
        this.bON = new C5016m("auto");
        this.bOt = new C8759b(4);
        this.bMf = new C5041h(getResources());
        C8536m.m24783a(getApplicationContext(), BitmapFactory.decodeResource(getResources(), R.drawable.xiaoying_ve_clip_no_content));
        if (this.todoParamModel != null && !TextUtils.isEmpty(this.todoParamModel.mJsonParam) && this.todoParamModel.getActivityFlag() > 0) {
            this.bLR = this.todoParamModel.getCameraId();
        }
        this.bOG = true;
        LogUtils.m14223i("CameraActivity", "onCreate <---");
        C8553i.setContext(getApplicationContext());
        C8553i.m25005ut(55);
        setVolumeControlStream(3);
        this.bLT = DeviceInfo.getScreenSize(this);
        this.bMU = LayoutInflater.from(this).inflate(R.layout.cam_act_main, null);
        setContentView(this.bMU);
        this.bMN = new C5009j(this, this.bNb);
        m11837bN(this.bOy, this.bOz);
        this.bMj = (RelativeLayout) findViewById(R.id.cam_layout_preview);
        this.bMk = (RelativeLayout) findViewById(R.id.cam_layout_surfaceview);
        this.bMM.init(getApplicationContext());
        this.bOJ.mo25536c(this.bMk);
        m11782PN();
        m11812Tx();
        connect();
        this.aML = new GestureDetector(getApplicationContext(), this);
        this.bMm = new C5039g(getApplicationContext(), this);
        if (!this.bMn) {
            this.bOF = C5034e.m13259d(this.bMM);
        } else {
            this.bOF = 0;
        }
        C5008i.m12937VU().mo25632a(C5034e.m13257c(this.bMM));
        int durationLimit = C5008i.m12937VU().getDurationLimit();
        if (durationLimit == 0 || this.bOF < durationLimit) {
            C5008i.m12937VU().mo25635cK(false);
        } else {
            C5008i.m12937VU().mo25635cK(true);
        }
        this.bMN.mo25666UA();
        mo24902Tv();
        this.mClipCount = C5034e.m13251b(this.bMM);
        this.bMN.mo25693jj(this.mClipCount);
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_mode", false);
        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_help_new_video_count", 0);
        if (!appSettingBoolean && this.bMn && appSettingInt >= 2) {
            this.mHandler.sendEmptyMessageDelayed(37, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
        if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_duration", false) && this.bMn && appSettingInt >= 3) {
            this.mHandler.sendEmptyMessageDelayed(48, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
        C5031c.m13221ap(getApplicationContext(), C5034e.m13236S(this, this.bOz));
        if (!AppPreferencesSetting.getInstance().getAppSettingBoolean(CameraRouter.KEY_PREFER_HAS_ENTER_CAMERA, false)) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean(CameraRouter.KEY_PREFER_HAS_ENTER_CAMERA, true);
        }
        LogUtils.m14223i("CameraActivity", "onCreate --->");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        LogUtils.m14223i("CameraActivity", "onDestroy <---");
        if (this.bLS != null) {
            this.bLS.removeCallbacksAndMessages(null);
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        this.aML = null;
        this.bMm = null;
        if (this.bON != null) {
            this.bON.mo25769WD();
            this.bON = null;
        }
        if (this.bLS != null) {
            this.bLS = null;
        }
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_mode", false);
        boolean appSettingBoolean2 = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_duration", false);
        boolean appSettingBoolean3 = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_delete", false);
        if (!this.bOH && ((!appSettingBoolean || !appSettingBoolean2 || !appSettingBoolean3) && this.mClipCount > 0 && this.bMn)) {
            AppPreferencesSetting.getInstance().setAppSettingInt("pref_help_new_video_count", AppPreferencesSetting.getInstance().getAppSettingInt("pref_help_new_video_count", 0) + 1);
        }
        if (this.bML != null) {
            this.bML.unInit();
            this.bML = null;
        }
        m11798Tb();
        if (this.bOJ != null) {
            this.bOJ.mo25518VD();
        }
        if (this.bMf != null) {
            this.bMf.release();
            this.bMf = null;
        }
        if (this.bLS != null) {
            this.bLS.removeCallbacksAndMessages(null);
        }
        this.bLS = null;
        this.bMv = null;
        this.bNe = null;
        this.bLP = null;
        this.bOJ = null;
        if (this.bMN != null) {
            this.bMN.onDestroy();
            this.bMN = null;
        }
        this.bMO = null;
        this.bMi = null;
        this.bON = null;
        this.aML = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        this.mHandler = null;
        this.bMm = null;
        this.bMl = null;
        this.bMh = null;
        if (this.bMj != null) {
            this.bMj.setVisibility(8);
            this.bMj = null;
        }
        this.bMM = null;
        this.ajC = null;
        if (this.bOt != null) {
            this.bOt.unInit(true);
            this.bOt = null;
        }
        if (this.bMY != null) {
            this.bMY.onDestroy();
        }
        QComUtils.resetInstanceMembers(this);
        LogUtils.m14223i("CameraActivity", "onDestroy --->");
        super.onDestroy();
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (this.bMj != null) {
            this.bMj.getLocationOnScreen(iArr);
            if (motionEvent.getY() < ((float) iArr[1]) && motionEvent.getY() > ((float) (iArr[1] + this.bMj.getHeight()))) {
                return true;
            }
        }
        return getState() == 2 ? true : true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b3 A[LOOP:0: B:61:0x00b3->B:68:0x00c7, LOOP_START, PHI: r7 
      PHI: (r7v8 int) = (r7v2 int), (r7v9 int) binds: [B:60:0x00b1, B:68:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e2 A[LOOP:2: B:78:0x00e2->B:86:0x00f8, LOOP_START, PHI: r7 
      PHI: (r7v3 int) = (r7v2 int), (r7v7 int) binds: [B:60:0x00b1, B:86:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onFling(android.view.MotionEvent r6, android.view.MotionEvent r7, float r8, float r9) {
        /*
            r5 = this;
            r0 = 1
            if (r6 == 0) goto L_0x0114
            if (r7 != 0) goto L_0x0007
            goto L_0x0114
        L_0x0007:
            int r1 = r5.getState()
            r2 = 2
            r3 = 0
            if (r1 != r2) goto L_0x0010
            return r3
        L_0x0010:
            int[] r1 = new int[r2]
            android.widget.RelativeLayout r2 = r5.bMj
            if (r2 == 0) goto L_0x0039
            android.widget.RelativeLayout r2 = r5.bMj
            r2.getLocationOnScreen(r1)
            float r2 = r6.getY()
            r4 = r1[r0]
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0038
            float r2 = r6.getY()
            r1 = r1[r0]
            android.widget.RelativeLayout r4 = r5.bMj
            int r4 = r4.getHeight()
            int r1 = r1 + r4
            float r1 = (float) r1
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0039
        L_0x0038:
            return r0
        L_0x0039:
            int r1 = r5.bOz
            boolean r1 = com.introvd.template.router.camera.CameraCodeMgr.isCameraParamPIP(r1)
            if (r1 == 0) goto L_0x004a
            com.introvd.template.camera.b.e r1 = r5.bMY
            boolean r6 = r1.onFling(r6, r7, r8, r9)
            if (r6 == 0) goto L_0x004a
            return r0
        L_0x004a:
            int r6 = r5.bOB
            int r7 = r5.bOw
            r1 = -1001914368(0xffffffffc4480000, float:-800.0)
            r2 = 1145569280(0x44480000, float:800.0)
            if (r7 == 0) goto L_0x008b
            r4 = 90
            if (r7 == r4) goto L_0x007d
            r9 = 180(0xb4, float:2.52E-43)
            if (r7 == r9) goto L_0x006f
            r9 = 270(0x10e, float:3.78E-43)
            if (r7 == r9) goto L_0x0061
            goto L_0x009b
        L_0x0061:
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0068
            int r6 = r6 + -1
            goto L_0x0091
        L_0x0068:
            int r7 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r7 <= 0) goto L_0x009b
            int r6 = r6 + 1
            goto L_0x0091
        L_0x006f:
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0076
            int r6 = r6 + 1
            goto L_0x0091
        L_0x0076:
            int r7 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x009b
            int r6 = r6 + -1
            goto L_0x0091
        L_0x007d:
            int r7 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0084
            int r6 = r6 + 1
            goto L_0x0091
        L_0x0084:
            int r7 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x009b
            int r6 = r6 + -1
            goto L_0x0091
        L_0x008b:
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0094
            int r6 = r6 + -1
        L_0x0091:
            r7 = r6
            r6 = 1
            goto L_0x009d
        L_0x0094:
            int r7 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x009b
            int r6 = r6 + 1
            goto L_0x0091
        L_0x009b:
            r7 = r6
            r6 = 0
        L_0x009d:
            com.introvd.template.template.g.b r8 = r5.bOt
            if (r8 == 0) goto L_0x00a8
            com.introvd.template.template.g.b r8 = r5.bOt
            int r8 = r8.getCount()
            goto L_0x00a9
        L_0x00a8:
            r8 = 0
        L_0x00a9:
            int r9 = r5.bOB
            if (r6 == 0) goto L_0x0113
            com.introvd.template.template.g.b r6 = r5.bOt
            if (r6 == 0) goto L_0x0113
            if (r7 >= r9) goto L_0x00e2
        L_0x00b3:
            if (r7 < 0) goto L_0x00ca
            com.introvd.template.template.g.b r6 = r5.bOt
            com.introvd.template.sdk.model.editor.EffectInfoModel r6 = r6.mo35214vh(r7)
            if (r6 == 0) goto L_0x00c7
            boolean r6 = r6.isbNeedDownload()
            if (r6 != 0) goto L_0x00c7
            r5.m11881y(r7, r0)
            return r3
        L_0x00c7:
            int r7 = r7 + -1
            goto L_0x00b3
        L_0x00ca:
            int r8 = r8 - r0
        L_0x00cb:
            if (r8 < r9) goto L_0x0113
            com.introvd.template.template.g.b r6 = r5.bOt
            com.introvd.template.sdk.model.editor.EffectInfoModel r6 = r6.mo35214vh(r8)
            if (r6 == 0) goto L_0x00df
            boolean r6 = r6.isbNeedDownload()
            if (r6 != 0) goto L_0x00df
            r5.m11881y(r8, r0)
            return r3
        L_0x00df:
            int r8 = r8 + -1
            goto L_0x00cb
        L_0x00e2:
            int r6 = r8 + -1
            if (r7 > r6) goto L_0x00fb
            com.introvd.template.template.g.b r6 = r5.bOt
            com.introvd.template.sdk.model.editor.EffectInfoModel r6 = r6.mo35214vh(r7)
            if (r6 == 0) goto L_0x00f8
            boolean r6 = r6.isbNeedDownload()
            if (r6 != 0) goto L_0x00f8
            r5.m11881y(r7, r0)
            return r3
        L_0x00f8:
            int r7 = r7 + 1
            goto L_0x00e2
        L_0x00fb:
            r6 = 0
        L_0x00fc:
            if (r6 > r9) goto L_0x0113
            com.introvd.template.template.g.b r7 = r5.bOt
            com.introvd.template.sdk.model.editor.EffectInfoModel r7 = r7.mo35214vh(r6)
            if (r7 == 0) goto L_0x0110
            boolean r7 = r7.isbNeedDownload()
            if (r7 != 0) goto L_0x0110
            r5.m11881y(r6, r0)
            return r3
        L_0x0110:
            int r6 = r6 + 1
            goto L_0x00fc
        L_0x0113:
            return r3
        L_0x0114:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.CameraActivity.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 24:
                this.mHandler.removeMessages(3);
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.what = 3;
                obtainMessage.arg1 = 1;
                this.mHandler.sendMessage(obtainMessage);
                return true;
            case 25:
                this.mHandler.removeMessages(3);
                Message obtainMessage2 = this.mHandler.obtainMessage();
                obtainMessage2.what = 3;
                obtainMessage2.arg1 = -1;
                this.mHandler.sendMessage(obtainMessage2);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.bOG || !this.ajR) {
            return true;
        }
        if (i != 4) {
            switch (i) {
                case 24:
                    return C4580b.m11632Sf() ? true : true;
                case 25:
                    return C4580b.m11632Sf() ? true : true;
                default:
                    return super.onKeyUp(i, keyEvent);
            }
        } else if (C5008i.m12937VU().mo25612VY()) {
            this.bMN.mo25674Un();
            return true;
        } else if (this.bMN.mo25672Ul()) {
            this.bMN.mo25663SY();
            return true;
        } else {
            if (this.bMN.mo25680Ws()) {
                this.bMN.mo25681Wt();
            } else if (this.bMN.mo25676Uq() || getState() == 2) {
                return true;
            } else {
                if (!this.bMA && !this.bMM.aJJ() && (this.bMJ != 1 || this.mClipCount == 0)) {
                    if (this.bMR && !this.bMr) {
                        this.bMb = true;
                    }
                    this.bOG = true;
                    this.mHandler.sendEmptyMessage(20);
                } else if (this.bMr) {
                    C8978m.m26350ht(this).mo10296do(R.string.xiaoying_str_com_msg_intent_send_cancel_tip).mo10281a((C1904j) new C1904j() {
                        public void onClick(C1890f fVar, C1885b bVar) {
                            CameraActivity.this.finish();
                        }
                    }).mo10313qu().show();
                } else if (this.bMn) {
                    if (this.mClipCount == 0) {
                        m11792TB();
                    } else if (this.bMc) {
                        m11814Tz();
                    } else {
                        m11791TA();
                    }
                } else if (!this.bMR) {
                    DataItemProject aHe = this.bMM.aHe();
                    if (aHe != null) {
                        this.bMM.mo34774oG(aHe.strPrjURL);
                    }
                    this.bOG = true;
                    this.mHandler.sendEmptyMessage(20);
                } else if (this.bMM == null) {
                    this.bMb = true;
                    this.bOG = true;
                    this.mHandler.sendEmptyMessage(20);
                } else if (this.bMA || this.bMM.aJJ()) {
                    m11793TC();
                }
            }
            return true;
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        LogUtils.m14223i("CameraActivity", "onPause <---");
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_flash_mode", "no_flash");
        if ("off".equals(appSettingStr) || "on".equals(appSettingStr)) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_flash_mode", "off");
        }
        AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", "unlock");
        this.bMK = true;
        if (this.bMN != null) {
            this.bMN.mo25679Uz();
        }
        this.bML.aNX();
        if (this.ajC != null) {
            this.ajC.release();
        }
        if (this.bMN != null) {
            this.bMN.onPause();
        }
        this.bLV = true;
        if (this.bON != null) {
            this.bON.mo25773WJ();
        }
        mo24894SV();
        if (this.bMO != null && !this.bOH) {
            this.bMO.mo25469cu(this.bMW);
        }
        m11789SY();
        m11845ch(true);
        m11810To();
        if (this.mHandler != null) {
            this.mHandler.removeMessages(2);
        }
        if (this.bMO != null) {
            this.bMO.mo25459UX();
        }
        super.overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
        if (!this.bMa) {
            ProjectItem ahP = this.bMM.aHf();
            if (!(ahP == null || ahP.mProjectDataItem == null || ahP.mProjectDataItem.iPrjClipCount <= 0)) {
                this.bMM.mo34731a(false, this.bOK, this.bLS, false, true, AppStateModel.getInstance().isCommunitySupport(), this.bMM.mo34778uz(this.bMM.ebQ));
            }
            if (this.bMn) {
                DataItemProject aHe = this.bMM.aHe();
                if (!(aHe == null || ahP == null)) {
                    C8446b.aIZ().mo34319b(getApplicationContext(), aHe._id, 2);
                    C8446b.aIZ().mo34320b(getApplicationContext(), ahP.mProjectDataItem._id, this.bNc);
                }
            }
            m11797Ta();
        }
        C8345d.m24060R(getApplicationContext(), "AppIsBusy", String.valueOf(false));
        C5036f.hide();
        this.mOrientation = -1;
        this.bMq = 0;
        this.ajR = false;
        this.bOL = true;
        super.onPause();
        UserBehaviorLog.onPause(this);
        setState(-1);
        C4597i.m11729b(false, this);
        LogUtils.m14223i("CameraActivity", "onPause --->");
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menu != null) {
            menu.clear();
        }
        getMenuInflater().inflate(R.menu.cam_menu_adjust, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.bfB = 0;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (getState() == 2) {
            return true;
        }
        if (motionEvent == null) {
            return false;
        }
        if (this.bMj == null) {
            return true;
        }
        if (this.bMN != null && this.bMN.mo25699p(motionEvent)) {
            return true;
        }
        int[] iArr = new int[2];
        this.bMj.getLocationOnScreen(iArr);
        if (this.bMj != null && motionEvent.getY() < ((float) iArr[1]) && motionEvent.getY() > ((float) (iArr[1] + this.bMj.getHeight()))) {
            return true;
        }
        if (this.bLR != 1 || this.bMN == null) {
            if (getState() == 1 || getState() == 6) {
                motionEvent.setAction(1);
                if (motionEvent.getX() < ((float) this.bMj.getLeft()) || motionEvent.getY() < ((float) this.bMj.getTop()) || motionEvent.getX() > ((float) (this.bMj.getLeft() + this.bMj.getWidth())) || motionEvent.getY() > ((float) (this.bMj.getTop() + this.bMj.getHeight()))) {
                    return false;
                }
                this.bMN.mo25673Um();
                this.mHandler.removeMessages(771);
                this.bMu = true;
                this.bON.mo25787q(motionEvent);
            }
            return true;
        }
        this.bMN.mo25673Um();
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bMm != null) {
            this.bMm.mo25894s(motionEvent);
        }
        return this.aML != null ? this.aML.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }
}
