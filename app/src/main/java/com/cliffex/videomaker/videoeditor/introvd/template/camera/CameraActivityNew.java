package com.introvd.template.camera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.OnZoomChangeListener;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.camera.base.CameraActivityBase;
import com.introvd.template.camera.base.CameraNewViewBase;
import com.introvd.template.camera.model.CameraTodoParam;
import com.introvd.template.camera.model.SaveRequest;
import com.introvd.template.camera.p229b.C4988a;
import com.introvd.template.camera.p229b.C4991c;
import com.introvd.template.camera.p229b.C4994d;
import com.introvd.template.camera.p229b.C4996f;
import com.introvd.template.camera.p229b.C4999g;
import com.introvd.template.camera.p229b.C4999g.C5004b;
import com.introvd.template.camera.p229b.C4999g.C5005c;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p229b.C5011k;
import com.introvd.template.camera.p229b.C5016m;
import com.introvd.template.camera.p229b.C5016m.C5018a;
import com.introvd.template.camera.p232e.C5029a;
import com.introvd.template.camera.p232e.C5030b;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.camera.p232e.C5032d;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.camera.p232e.C5036f;
import com.introvd.template.camera.p232e.C5039g;
import com.introvd.template.camera.p232e.C5039g.C5040a;
import com.introvd.template.camera.p232e.C5041h;
import com.introvd.template.camera.p233ui.camview.CameraFuncView;
import com.introvd.template.camera.p233ui.view.CameraRotateTipView;
import com.introvd.template.camera.p233ui.view.SegProgressbar;
import com.introvd.template.camera.p233ui.view.SegProgressbar.C5176a;
import com.introvd.template.camera.p233ui.view.indicator.C5198c;
import com.introvd.template.common.ActivityStateCheckListener;
import com.introvd.template.common.ApiHelper;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.joinevent.JoinEventInfo;
import com.introvd.template.common.joinevent.JoinEventUtil;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.common.utils.PreferUtils;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8058h;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.business.C7870d;
import com.introvd.template.module.iap.business.C7870d.C7873a;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7593c;
import com.introvd.template.module.p326ad.p328b.C7594d;
import com.introvd.template.p173a.p174a.C3574d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p203b.C4600l;
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
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p381b.C8393c;
import com.introvd.template.sdk.p381b.C8394d;
import com.introvd.template.sdk.p381b.p382a.C8384a.C8385a;
import com.introvd.template.sdk.p381b.p382a.C8387c.C8388a;
import com.introvd.template.sdk.p381b.p382a.C8387c.C8389b;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8555k;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8560o;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8518c;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8536m;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.download.C8702c;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.template.widget.p412a.C8937c;
import com.introvd.template.videoeditor.p416a.C9006a;
import com.introvd.template.vivacamera.R;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.mediarecorder.engine.QRecorderStatus;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.rescue.C4905b;
import java.io.File;
import java.lang.Thread.State;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lib.C12177i;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QClip.QCamExportedEffectData;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.player.QPlayer;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QComUtils;

@C1942a(mo10417rZ = "/vivacamera/new_version")
public class CameraActivityNew extends CameraActivityBase implements OnDoubleTapListener, OnGestureListener, OnSeekBarChangeListener, VideoAdsListener, VideoRewardListener, C5018a, C5040a, ActivityStateCheckListener {
    /* access modifiers changed from: private */
    public static final String TAG = "CameraActivityNew";
    private static final int[] bNM = {0, R.string.xiaoying_str_cam_fd_expression_type_mouth_open, R.string.xiaoying_str_cam_fd_expression_type_eyebrow_raise, R.string.xiaoying_str_cam_fd_expression_type_blink, R.string.xiaoying_str_cam_fd_expression_type_headshake, R.string.xiaoying_str_cam_fd_expression_type_headnod, R.string.xiaoying_str_cam_fd_expression_type_headshake_or_nod};
    private GestureDetector aML;
    private WakeLock ajC;
    private C5032d bLP;
    private int bLQ = 1;
    /* access modifiers changed from: private */
    public int bLR = 0;
    /* access modifiers changed from: private */
    public Handler bLS;
    private MSize bLT = new MSize(800, 480);
    /* access modifiers changed from: private */
    public boolean bLV = false;
    private boolean bLW = false;
    private boolean bLX = false;
    /* access modifiers changed from: private */
    public boolean bMA = false;
    /* access modifiers changed from: private */
    public int bMB = 4097;
    private int bMD = 0;
    /* access modifiers changed from: private */
    public int bME = 0;
    private boolean bMF = false;
    /* access modifiers changed from: private */
    public int bMG;
    /* access modifiers changed from: private */
    public int bMH;
    private int bMJ = 1;
    public C8522g bMM = null;
    public C4991c bMO;
    private boolean bMR = false;
    private long bMT = 0;
    private int bMV;
    private boolean bMW = false;
    private boolean bMX = false;
    private C8759b bMZ;
    /* access modifiers changed from: private */
    public boolean bMa = false;
    /* access modifiers changed from: private */
    public boolean bMb = false;
    private String bMd;
    private C5041h bMf;
    private float bMg = 2.14748365E9f;
    private C8394d bMh;
    /* access modifiers changed from: private */
    public Thread bMi = null;
    /* access modifiers changed from: private */
    public RelativeLayout bMj;
    private RelativeLayout bMk;
    private C5039g bMm;
    private boolean bMn = false;
    private boolean bMo = true;
    /* access modifiers changed from: private */
    public int bMq = 0;
    private boolean bMr = false;
    private int bMs = 0;
    /* access modifiers changed from: private */
    public boolean bMu = false;
    private long bMw = 0;
    private String bMy = null;
    private C4651e bNA;
    /* access modifiers changed from: private */
    public long bNB = 0;
    /* access modifiers changed from: private */
    public C8937c bNC;
    /* access modifiers changed from: private */
    public String bND;
    /* access modifiers changed from: private */
    public boolean bNE = true;
    private C4988a bNF;
    private C7870d bNG;
    /* access modifiers changed from: private */
    public boolean bNH;
    private CameraTodoParam bNI;
    /* access modifiers changed from: private */
    public String bNJ;
    private int bNK = -1;
    /* access modifiers changed from: private */
    public volatile boolean bNL = false;
    private int bNN = -1;
    private boolean bNO = false;
    /* access modifiers changed from: private */
    public TemplateInfo bNP;
    private C8702c bNQ = new C8702c() {
        /* renamed from: b */
        public void mo24951b(Long l) {
            StringBuilder sb = new StringBuilder();
            sb.append("onXytTemplateDownloadStart lTTID=");
            sb.append(l);
            LogUtilsV2.m14228e(sb.toString());
            CameraActivityNew.this.bNB = l.longValue();
        }

        /* renamed from: c */
        public void mo24952c(long j, int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateXytDownloadProgress templateId=");
            sb.append(j);
            sb.append(";progress=");
            sb.append(i);
            LogUtilsV2.m14228e(sb.toString());
            if (i == -1) {
                CameraActivityNew.this.m12058l(false, true);
                if (CameraActivityNew.this.bNJ != null && CameraActivityNew.this.bNJ.equals(String.valueOf(j))) {
                    List qQ = CameraActivityNew.this.bNC.mo35576qQ(CameraActivityNew.this.bNJ);
                    if (qQ != null && qQ.size() > 0) {
                        CameraActivityNew.this.m12013b(CameraActivityNew.this.bOt.mo35205bx(((Long) qQ.get(0)).longValue()), true, false);
                    }
                }
            }
            if (CameraActivityNew.this.bNo != null) {
                CameraActivityNew.this.bNo.mo25727a(Long.valueOf(j), i);
            }
        }

        /* renamed from: c */
        public void mo24953c(Long l) {
            StringBuilder sb = new StringBuilder();
            sb.append("onXytTemplateInstallSuc lTTID=");
            sb.append(l);
            LogUtilsV2.m14228e(sb.toString());
            if (l.longValue() == CameraActivityNew.this.bNB) {
                if (QTemplateIDUtils.getTemplateSubType(l.longValue()) == 1 && CameraActivityNew.this.getState() != 2) {
                    CameraActivityNew.this.m12036eP(C8762d.aMt().mo35225bB(l.longValue()));
                    if (CameraActivityNew.this.bNo != null) {
                        CameraActivityNew.this.bNo.mo25729aj(l.longValue());
                    }
                }
                CameraActivityNew.this.bNB = -1;
            }
        }
    };
    private boolean bNa = false;
    private C5530d bNb;
    private String bNc = null;
    private CameraIntentInfo bNd;
    private C8388a bNe = new C8388a() {
        /* renamed from: a */
        public void mo24924a(CameraInfo cameraInfo) {
            if (Build.MODEL.equals("HTC ChaCha A810e") && cameraInfo.facing == 1) {
                CameraActivityNew.this.bOJ.mo25558iY(1);
            }
        }

        /* renamed from: a */
        public void mo24925a(C8389b bVar, CameraInfo cameraInfo) {
        }
    };
    private int bNn = -1;
    /* access modifiers changed from: private */
    public C5011k bNo;
    private CameraRotateTipView bNp;
    /* access modifiers changed from: private */
    public SegProgressbar bNq;
    private C4999g bNr;
    private boolean bNs = false;
    private MusicDataItem bNt;
    /* access modifiers changed from: private */
    public C4994d bNu;
    /* access modifiers changed from: private */
    public int bNv = 0;
    private boolean bNw = true;
    private C4646a bNx = null;
    private final C4654f bNy = new C4654f();
    /* access modifiers changed from: private */
    public int bNz = 2;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public String mPrjPath = "";
    private TODOParamModel todoParamModel;

    /* renamed from: com.introvd.template.camera.CameraActivityNew$a */
    private final class C4646a implements AutoFocusCallback {
        private final WeakReference<CameraActivityNew> bNg;

        public C4646a(CameraActivityNew cameraActivityNew) {
            this.bNg = new WeakReference<>(cameraActivityNew);
        }

        public void onAutoFocus(boolean z, Camera camera) {
            if (((CameraActivityNew) this.bNg.get()) != null) {
                String Ua = CameraActivityNew.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("AutoFocusCallback: ");
                sb.append(z);
                LogUtils.m14223i(Ua, sb.toString());
                if (CameraActivityNew.this.getState() == 2) {
                    CameraActivityNew.this.bMu = false;
                } else if (CameraActivityNew.this.mHandler != null && CameraActivityNew.this.bON != null) {
                    CameraActivityNew.this.mHandler.sendMessage(CameraActivityNew.this.mHandler.obtainMessage(32, Boolean.valueOf(z)));
                    CameraActivityNew.this.bON.mo25781da(z);
                }
            }
        }
    }

    /* renamed from: com.introvd.template.camera.CameraActivityNew$b */
    private static class C4647b extends WeakHandler<CameraActivityNew> {
        public C4647b(CameraActivityNew cameraActivityNew) {
            super(cameraActivityNew);
        }

        public void handleMessage(Message message) {
            CameraActivityNew cameraActivityNew = (CameraActivityNew) getOwner();
            if (cameraActivityNew == null) {
                LogUtils.m14222e(CameraActivityNew.TAG, "theActivity == null");
                return;
            }
            boolean z = false;
            switch (message.what) {
                case 4097:
                    cameraActivityNew.m11922SW();
                    break;
                case 4098:
                    cameraActivityNew.m11923SX();
                    break;
                case 4099:
                    if (cameraActivityNew.bOt != null) {
                        EffectInfoModel vh = cameraActivityNew.bOt.mo35214vh(message.arg1);
                        if (vh != null && !vh.isbNeedDownload()) {
                            cameraActivityNew.m12013b(message.arg1, true, false);
                            break;
                        }
                    } else {
                        return;
                    }
                case 4101:
                    cameraActivityNew.m11944TT();
                    break;
                case 4102:
                    if (cameraActivityNew.getState() == 2) {
                        cameraActivityNew.m11955Te();
                    }
                    cameraActivityNew.m11942TR();
                    break;
                case 4104:
                    cameraActivityNew.bOG = true;
                    if (cameraActivityNew.getState() == 2) {
                        cameraActivityNew.m11955Te();
                        cameraActivityNew.m12027cj(true);
                    } else if (cameraActivityNew.getState() == 6) {
                        cameraActivityNew.m12027cj(true);
                    }
                    cameraActivityNew.m11937TM();
                    break;
                case 4105:
                    cameraActivityNew.m11967Tw();
                    break;
                case QEffect.PROP_AUDIO_FRAME_RANGE /*4112*/:
                    String str = "";
                    if (CameraCodeMgr.isCameraParamDefault(cameraActivityNew.bOz) || CameraCodeMgr.isCameraParamMV(cameraActivityNew.bOz)) {
                        str = "0";
                    } else if (CameraCodeMgr.isCameraParamFB(cameraActivityNew.bOz)) {
                        str = "2";
                    }
                    TemplateRouter.launchFilterForResult(cameraActivityNew, str, 24580);
                    break;
                case QEffect.PROP_AUDIO_FRAME_REPEAT_MODE /*4113*/:
                    cameraActivityNew.m12019bS(message.arg1, message.arg2);
                    break;
                case QEffect.PROP_AUDIO_FRAME_ADJUST_DB /*4115*/:
                    if (message.obj instanceof MusicDataItem) {
                        cameraActivityNew.m11992a((MusicDataItem) message.obj);
                        break;
                    }
                    break;
                case QEffect.PROP_AUDIO_FRAME_FADEIN /*4116*/:
                    cameraActivityNew.m11945TU();
                    break;
                case QEffect.PROP_VIDEO_FRAME_ROTATION /*4121*/:
                    cameraActivityNew.bNo.mo25733cX(true);
                    break;
                case QEffect.PROP_EFFECT_PROPDATA /*4129*/:
                    cameraActivityNew.m11964Ts();
                    break;
                case 4137:
                    cameraActivityNew.bNu.mo25480iT(message.arg1);
                    break;
                case 4145:
                    int i = message.arg1;
                    int i2 = message.arg2;
                    if (!(cameraActivityNew.bOz == i2 && cameraActivityNew.bNz == i)) {
                        cameraActivityNew.bNz = i;
                        AppPreferencesSetting.getInstance().setAppSettingInt("key_pref_last_camera_ratio", i);
                        if (cameraActivityNew.getState() == 2) {
                            cameraActivityNew.bOG = true;
                            cameraActivityNew.m11955Te();
                            cameraActivityNew.m12027cj(true);
                        } else if (cameraActivityNew.getState() == 6) {
                            cameraActivityNew.bOG = true;
                            cameraActivityNew.m12027cj(true);
                        }
                        cameraActivityNew.m11982a(cameraActivityNew.bOy, i2, false, 3);
                        break;
                    }
                case QEffect.PROP_EFFECT_POSITION_ALIGNMENT /*4146*/:
                    if (!((Boolean) message.obj).booleanValue()) {
                        cameraActivityNew.bNq.mo26193Yk();
                        break;
                    } else {
                        cameraActivityNew.bNq.mo26192Yj();
                        break;
                    }
                case QPlayer.PROP_PLAYER_RANGE /*32769*/:
                    cameraActivityNew.onConnected();
                    break;
                case QPlayer.PROP_PLAYER_SEEK_DIR /*32770*/:
                    cameraActivityNew.m11953Tc();
                    break;
                case QPlayer.PROP_PLAYER_PREVIEW_FPS /*32772*/:
                    if (cameraActivityNew.mHandler != null) {
                        cameraActivityNew.mHandler.sendEmptyMessageDelayed(2, 100);
                        break;
                    }
                    break;
                case 32773:
                    cameraActivityNew.m11958Th();
                    break;
                case 32775:
                    C5198c.m14174dx(false);
                    cameraActivityNew.m11921SV();
                    sendEmptyMessage(4101);
                    C5008i.m12937VU().mo25635cK(true);
                    break;
                case 32776:
                    if (!cameraActivityNew.bLV && !cameraActivityNew.bNH) {
                        cameraActivityNew.m12050iC((int) ((long) message.arg1));
                        break;
                    }
                case 32777:
                    cameraActivityNew.m11921SV();
                    sendEmptyMessage(4101);
                    break;
                case 32778:
                    if (!TextUtils.isEmpty(cameraActivityNew.bND)) {
                        if (!CameraCodeMgr.isParamFacialEnable(cameraActivityNew.bOz)) {
                            cameraActivityNew.bNo.mo25734cY(false);
                            break;
                        } else {
                            C5011k a = cameraActivityNew.bNo;
                            if (((Integer) message.obj).intValue() != 0) {
                                z = true;
                            }
                            a.mo25734cY(z);
                            break;
                        }
                    } else {
                        return;
                    }
                case 32780:
                    cameraActivityNew.bNo.mo25737co(((Boolean) message.obj).booleanValue());
                    break;
                case 32781:
                    cameraActivityNew.bNo.mo25725Wx();
                    cameraActivityNew.m11921SV();
                    break;
                case 65585:
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(message.arg1);
                    String sb2 = sb.toString();
                    TemplateInfo templateInfo = null;
                    if (message.obj != null) {
                        templateInfo = (TemplateInfo) message.obj;
                    }
                    if (!C8399c.ecY.equals(sb2)) {
                        if (C8399c.edg.equals(sb2)) {
                            cameraActivityNew.m12016b(templateInfo);
                            break;
                        }
                    } else {
                        cameraActivityNew.m11993a(templateInfo);
                        break;
                    }
                    break;
                case 65586:
                    cameraActivityNew.m11983a(message.arg1, (TemplateInfo) message.obj);
                    break;
                case 268443649:
                    if (cameraActivityNew.bMM != null) {
                        cameraActivityNew.bMM.mo34741a(message.arg2, (Handler) this, true);
                        break;
                    }
                    break;
                case 268443653:
                case 268443654:
                case 268443655:
                    if (!cameraActivityNew.bMa) {
                        C4586g.m11696Sm();
                        cameraActivityNew.m12024cg(false);
                        break;
                    } else {
                        C4586g.m11696Sm();
                        cameraActivityNew.m12024cg(false);
                        cameraActivityNew.finish();
                        break;
                    }
            }
        }
    }

    /* renamed from: com.introvd.template.camera.CameraActivityNew$c */
    private static class C4648c implements Runnable {
        private TextView mTxt;

        C4648c(TextView textView) {
            this.mTxt = textView;
        }

        public void run() {
            if (this.mTxt != null && this.mTxt.getVisibility() == 0) {
                this.mTxt.setVisibility(4);
            }
        }
    }

    /* renamed from: com.introvd.template.camera.CameraActivityNew$d */
    private static class C4649d extends WeakHandler<CameraActivityNew> {
        public C4649d(CameraActivityNew cameraActivityNew) {
            super(cameraActivityNew);
        }

        public void handleMessage(Message message) {
            CameraActivityNew cameraActivityNew = (CameraActivityNew) getOwner();
            if (cameraActivityNew != null) {
                boolean z = true;
                switch (message.what) {
                    case 2:
                        removeMessages(2);
                        if (!cameraActivityNew.bLV) {
                            if (cameraActivityNew.getState() != 2) {
                                cameraActivityNew.m11966Tv();
                                break;
                            }
                        } else {
                            return;
                        }
                        break;
                    case 3:
                        if (!cameraActivityNew.isFinishing() && cameraActivityNew.bOJ != null && cameraActivityNew.bOJ.mo25525Vy() != null) {
                            removeMessages(3);
                            Parameters parameters = cameraActivityNew.bOJ.mo25525Vy().getParameters();
                            if (parameters != null) {
                                int zoom = parameters.getZoom();
                                int maxZoom = parameters.getMaxZoom();
                                if (maxZoom == 0) {
                                    maxZoom = 1;
                                }
                                int abs = Math.abs(message.arg2) <= 100 / maxZoom ? 1 : (int) ((((float) (Math.abs(message.arg2) * maxZoom)) * 1.0f) / 100.0f);
                                if (message.arg1 == 1) {
                                    zoom += abs;
                                } else if (message.arg1 == -1) {
                                    zoom -= abs;
                                }
                                if (zoom < 0) {
                                    zoom = 0;
                                } else if (zoom > maxZoom) {
                                    zoom = maxZoom;
                                }
                                cameraActivityNew.m12051ix(zoom);
                                cameraActivityNew.bNo.setZoomValue((double) ((zoom * 100) / maxZoom));
                                break;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                        break;
                    case 20:
                        cameraActivityNew.exit();
                        break;
                    case 25:
                        cameraActivityNew.m12049iB(message.arg1);
                        break;
                    case 32:
                        if (!cameraActivityNew.bLV) {
                            removeMessages(771);
                            removeMessages(32);
                            removeMessages(1027);
                            boolean booleanValue = ((Boolean) message.obj).booleanValue();
                            String Ua = CameraActivityNew.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("onAutoFocus=");
                            sb.append(booleanValue);
                            LogUtils.m14222e(Ua, sb.toString());
                            if (cameraActivityNew.bON != null) {
                                cameraActivityNew.bON.mo25784jr(4);
                                if (booleanValue) {
                                    cameraActivityNew.bON.mo25785m(Boolean.valueOf(cameraActivityNew.bMu));
                                } else {
                                    cameraActivityNew.bON.mo25786n(Boolean.valueOf(cameraActivityNew.bMu));
                                }
                            }
                            if (cameraActivityNew.bMu) {
                                sendEmptyMessageDelayed(771, 3000);
                            } else {
                                sendEmptyMessageDelayed(1027, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                            }
                            cameraActivityNew.bMu = false;
                            cameraActivityNew.m11969Ty();
                            break;
                        } else {
                            return;
                        }
                    case 37:
                        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_mode", false);
                        if (!cameraActivityNew.isFinishing() && !appSettingBoolean) {
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_mode", true);
                            break;
                        }
                    case 39:
                        if (CameraCodeMgr.isParamBeautyEffectEnable(cameraActivityNew.bOz)) {
                            if (!cameraActivityNew.bNE) {
                                int i = cameraActivityNew.bOA;
                                if (cameraActivityNew.bOA == 0) {
                                    z = false;
                                }
                                cameraActivityNew.m12013b(i, z, false);
                                break;
                            } else {
                                cameraActivityNew.bNE = false;
                                if (cameraActivityNew.bNo != null) {
                                    cameraActivityNew.bNo.mo25724Ww();
                                    break;
                                }
                            }
                        } else {
                            int i2 = cameraActivityNew.bOB;
                            if (cameraActivityNew.bOB == 0) {
                                z = false;
                            }
                            cameraActivityNew.m12013b(i2, z, false);
                            break;
                        }
                        break;
                    case 48:
                        boolean appSettingBoolean2 = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_duration", false);
                        if (!cameraActivityNew.isFinishing() && !appSettingBoolean2) {
                            if (cameraActivityNew.getState() != 2) {
                                cameraActivityNew.bNo.mo25716Uo();
                            }
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_duration", true);
                            break;
                        }
                    case 51:
                        C5198c.m14175jH(3);
                        if (AppPreferencesSetting.getInstance().getAppSettingInt("key_enter_normal_mode", 0) >= 2 && !AppPreferencesSetting.getInstance().getAppSettingBoolean("hor_record_help_show", false)) {
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("hor_record_help_show", true);
                            final View topIndicatorView = cameraActivityNew.bNo.getTopIndicatorView();
                            if (topIndicatorView != null && ApiHelper.JELLY_BEAN_AND_HIGHER) {
                                final ViewTreeObserver viewTreeObserver = topIndicatorView.getViewTreeObserver();
                                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                                    viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                                        @SuppressLint({"NewApi"})
                                        public void onGlobalLayout() {
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
                    case 771:
                        removeMessages(771);
                        if (!cameraActivityNew.bLV) {
                            cameraActivityNew.bON.mo25770WE();
                            cameraActivityNew.bON.mo25768Tp();
                            break;
                        } else {
                            return;
                        }
                    case 1025:
                        String str = (String) message.obj;
                        if (!(cameraActivityNew.bMM == null || cameraActivityNew.bMM.aHe() == null)) {
                            String str2 = cameraActivityNew.bMM.aHe().strPrjURL;
                            IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
                            if (iEditorService != null) {
                                iEditorService.applyTheme(cameraActivityNew.getApplicationContext(), str2, str);
                                break;
                            }
                        }
                        break;
                    case 1027:
                        if (cameraActivityNew.bON != null) {
                            cameraActivityNew.bON.mo25784jr(4);
                            break;
                        }
                        break;
                    case 1281:
                        cameraActivityNew.bMi = null;
                        break;
                    case 1540:
                        if ((cameraActivityNew.getState() == 6 || cameraActivityNew.getState() == 1) && !cameraActivityNew.bOG) {
                            cameraActivityNew.m12026ci(true);
                            cameraActivityNew.m11982a(cameraActivityNew.m12048iA(cameraActivityNew.bMq), cameraActivityNew.bOz, false, 2);
                            break;
                        }
                    case 268443649:
                        if (cameraActivityNew.bMM != null) {
                            cameraActivityNew.bMM.aJE();
                            ProjectItem ahP = cameraActivityNew.bMM.aHf();
                            if (ahP != null) {
                                if ((ahP.getCacheFlag() & 8) == 0) {
                                    cameraActivityNew.bMM.mo33877a((Handler) this, true);
                                }
                                cameraActivityNew.bOG = true;
                                sendEmptyMessage(20);
                                break;
                            }
                        }
                        break;
                    case 268443650:
                    case 268443651:
                    case 268443657:
                        cameraActivityNew.bOG = true;
                        sendEmptyMessage(20);
                        break;
                }
                super.handleMessage(message);
            }
        }
    }

    /* renamed from: com.introvd.template.camera.CameraActivityNew$e */
    class C4651e extends OrientationEventListener {
        SparseIntArray bNU;
        int bNV = 0;
        SparseIntArray bNW = new SparseIntArray() {
            {
                put(0, 360);
                put(QDisplayContext.DISPLAY_ROTATION_270, 90);
                put(QDisplayContext.DISPLAY_ROTATION_180, QDisplayContext.DISPLAY_ROTATION_180);
                put(90, QDisplayContext.DISPLAY_ROTATION_270);
                put(360, 0);
            }
        };
        SparseIntArray bNX = new SparseIntArray() {
            {
                put(0, 0);
                put(90, -90);
                put(QDisplayContext.DISPLAY_ROTATION_180, -180);
                put(QDisplayContext.DISPLAY_ROTATION_270, -270);
                put(360, -360);
            }
        };
        private int bNY = 0;
        private int bNZ = 0;
        private boolean bOa = true;
        private boolean bOb = true;
        private SparseIntArray bOc = new SparseIntArray();

        C4651e(Context context, int i) {
            super(context, i);
        }

        /* renamed from: iE */
        private int m12091iE(int i) {
            int i2 = (i + 90) % 360;
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 90) {
                return 2;
            }
            if (i2 != 180) {
                return i2 != 270 ? 0 : 4;
            }
            return 3;
        }

        public void onOrientationChanged(int i) {
            if (i != -1 && CameraActivityNew.this.bNo != null) {
                if (CameraCodeMgr.isParamFacialEnable(CameraActivityNew.this.bOz) || CameraActivityNew.this.getState() != 2) {
                    boolean z = true;
                    if (!((CameraActivityNew.this.bOG && CameraActivityNew.this.getState() >= 1) || CameraActivityNew.this.bNo.mo25720Wn() || CameraActivityNew.this.bNo.mo25713Ul())) {
                        int cg = C5034e.m13258cg(i, -1);
                        if (cg != CameraActivityNew.this.bMq) {
                            if (this.bOc.get(cg) <= 10) {
                                this.bOc.put(cg, this.bOc.get(cg) + 1);
                                return;
                            }
                            this.bOc.clear();
                        }
                        int i2 = i - this.bNV;
                        if (i2 > 180) {
                            this.bOa = false;
                        } else if (i2 < -180) {
                            this.bOa = true;
                        }
                        if (this.bOb == this.bOa || this.bNZ < 3) {
                            if (this.bOb != this.bOa) {
                                this.bNZ++;
                            } else {
                                this.bNZ = 0;
                            }
                        }
                        if (this.bNZ >= 3) {
                            this.bOb = this.bOa;
                            this.bNZ = 0;
                        }
                        this.bNV = i;
                        int a = CameraActivityNew.this.m12048iA(cg);
                        if (a != CameraActivityNew.this.bOy || (CameraActivityNew.this.bMq != cg && this.bNY >= 5)) {
                            this.bNY = 0;
                            if (CameraCodeMgr.isParamFacialEnable(CameraActivityNew.this.bOz)) {
                                CameraActivityNew.this.bOJ.mo25562jb(m12091iE(cg));
                                CameraActivityNew.this.bNL = true;
                                if (CameraActivityNew.this.getState() == 2) {
                                    CameraActivityNew.this.bMq = cg;
                                    return;
                                } else if (CameraActivityNew.this.getState() != 6) {
                                    CameraActivityNew.this.bOJ.mo25560j(CameraActivityNew.this.m12053iz(cg), CameraActivityNew.this.bND);
                                }
                            }
                            boolean z2 = CameraActivityNew.this.bOF > 0 && (CameraActivityNew.this.getState() == 6 || CameraActivityNew.this.getState() == 5 || CameraActivityNew.this.getState() == 1);
                            if (!z2 || CameraActivityNew.this.bNv == cg) {
                                if (CameraActivityNew.this.bNo != null) {
                                    CameraActivityNew.this.bNo.mo25719WB();
                                }
                            } else if (CameraActivityNew.this.bNo != null) {
                                CameraActivityNew.this.bNo.mo25735ca(CameraActivityNew.this.bNv, cg);
                            }
                            if (!(CameraActivityNew.this.bOF == 0 || (z2 && (CameraActivityNew.this.bNv + 90) % QDisplayContext.DISPLAY_ROTATION_180 == 0 && (cg + 90) % QDisplayContext.DISPLAY_ROTATION_180 == 0))) {
                                z = false;
                            }
                            int i3 = (CameraActivityNew.this.bMq == 270 && cg == 0) ? 360 : cg;
                            this.bNU = this.bOb ? this.bNX : this.bNW;
                            int i4 = this.bNU.get(i3);
                            if (z && CameraActivityNew.this.bNo != null) {
                                CameraActivityNew.this.bNo.mo25744iH(i4);
                            }
                            CameraActivityNew.this.bMq = cg;
                            CameraActivityNew.this.m11932TH();
                            if (CameraActivityNew.this.bOF == 0) {
                                CameraActivityNew.this.m11982a(a, CameraActivityNew.this.bOz, false, 2);
                            } else if ((CameraActivityNew.this.bNv + 90) % QDisplayContext.DISPLAY_ROTATION_180 == 0 && (cg + 90) % QDisplayContext.DISPLAY_ROTATION_180 == 0 && CameraActivityNew.this.mHandler != null && CameraActivityNew.this.bOy != a) {
                                CameraActivityNew.this.mHandler.removeMessages(1540);
                                CameraActivityNew.this.mHandler.sendEmptyMessage(1540);
                            }
                            return;
                        }
                        if (CameraActivityNew.this.bMq != cg || !CameraActivityNew.this.bNL) {
                            this.bNY++;
                        } else {
                            this.bNY = 0;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.introvd.template.camera.CameraActivityNew$f */
    private final class C4654f implements OnZoomChangeListener {
        private C4654f() {
        }

        public void onZoomChange(int i, boolean z, Camera camera) {
            String Ua = CameraActivityNew.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Zoom changed: value=");
            sb.append(i);
            sb.append(". stopped=");
            sb.append(z);
            LogUtils.m14225v(Ua, sb.toString());
            CameraActivityNew.this.bMG = i;
            if (CameraActivityNew.this.bOJ != null) {
                Parameters VC = CameraActivityNew.this.bOJ.mo25517VC();
                if (VC != null && CameraActivityNew.this.bOJ.mo25525Vy() != null) {
                    VC.setZoom(i);
                    if (z && CameraActivityNew.this.bME != 0) {
                        if (i != CameraActivityNew.this.bMH) {
                            CameraActivityNew.this.bOJ.mo25525Vy().aHl().startSmoothZoom(CameraActivityNew.this.bMH);
                            CameraActivityNew.this.bME = 1;
                        } else {
                            CameraActivityNew.this.bME = 0;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: SU */
    private void m11920SU() {
        DataItemProject aHe = this.bMM.aHe();
        if (((aHe == null || TextUtils.isEmpty(aHe.strExtra)) ? 0 : C5030b.m13203fj(aHe.strExtra)) == 0) {
            C5030b.m13202YP();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: SV */
    public void m11921SV() {
        if (getState() == 2) {
            m11955Te();
            m12027cj(true);
        } else if (getState() == 6) {
            m12027cj(true);
        } else if (this.bMO != null && !this.bOH) {
            this.bMO.mo25469cu(this.bMW);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: SW */
    public void m11922SW() {
        if (C8049f.aBf().mo33101iL(this.bOO)) {
            C8049f.aBf().mo33097b(this, C8070o.aBw(), C7825a.ALL_TEMPLATE.getId(), "effects", -1);
            return;
        }
        if (getState() == 6) {
            m11957Tg();
        } else if (getState() == 1) {
            m11961Tl();
        }
        m11969Ty();
    }

    /* access modifiers changed from: private */
    /* renamed from: SX */
    public void m11923SX() {
        if (getState() == 2) {
            m11955Te();
        }
        m11969Ty();
    }

    /* renamed from: SY */
    private void m11924SY() {
        this.bNo.mo25710SY();
    }

    /* renamed from: TA */
    private void m11926TA() {
        C8978m.m26349hs(this).mo10296do(R.string.xiaoying_str_com_msg_save_draft_ask).mo10303dv(R.string.xiaoying_str_com_save_title).mo10299dr(R.string.xiaoying_str_com_discard_title).mo10291b(new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                DataItemProject aHe = CameraActivityNew.this.bMM.aHe();
                if (aHe != null) {
                    CameraActivityNew.this.bMM.mo34774oG(aHe.strPrjURL);
                }
                UserBehaviorUtils.recordPrjSave(CameraActivityNew.this, "camera");
                CameraActivityNew.this.bOG = true;
                CameraActivityNew.this.mHandler.sendEmptyMessage(20);
                ToastUtils.show(CameraActivityNew.this.getApplicationContext(), R.string.xiaoying_str_com_saved_into_draft_box_tip, 1);
                C4586g.bKT = true;
            }
        }).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                CameraActivityNew.this.m11927TB();
                C4586g.bKT = true;
            }
        }).mo10313qu().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: TB */
    public void m11927TB() {
        this.bOH = true;
        if (this.bMn || this.bMJ == 1) {
            mo24934k(true, true);
            this.bOG = true;
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(20);
            }
        } else if (this.bMM == null) {
            this.bOG = true;
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(20);
            }
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
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(20);
            }
        }
    }

    /* renamed from: TC */
    private void m11928TC() {
        C1890f qu = C8978m.m26350ht(this).mo10296do(R.string.xiaoying_str_com_dialog_cancel_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                CameraActivityNew.this.bOH = true;
                if (CameraActivityNew.this.bMM != null && (CameraActivityNew.this.bMA || CameraActivityNew.this.bMM.aJJ())) {
                    DataItemProject aHe = CameraActivityNew.this.bMM.aHe();
                    if (aHe != null) {
                        String str = aHe.strPrjURL;
                        if (!TextUtils.isEmpty(str)) {
                            int nt = CameraActivityNew.this.bMM.mo33889nt(str);
                            if (nt >= 0) {
                                CameraActivityNew.this.bMM.mo34764i(CameraActivityNew.this.bMM.aHf());
                                CameraActivityNew.this.bMM.mo34773oF(str);
                                CameraActivityNew.this.bMM.ebQ = nt;
                                C8553i.setContext(CameraActivityNew.this.getApplicationContext());
                                C8553i.m25005ut(55);
                                CameraActivityNew.this.bMM.mo34739a(str, CameraActivityNew.this.bOK, CameraActivityNew.this.mHandler);
                                CameraActivityNew.this.bOK.mo34669jt(false);
                            }
                        }
                    }
                }
                CameraActivityNew.this.bMb = true;
                CameraActivityNew.this.bOG = true;
            }
        }).mo10313qu();
        if (hasWindowFocus()) {
            qu.show();
        }
    }

    /* renamed from: TD */
    private void m11929TD() {
        Parameters VC = this.bOJ.mo25517VC();
        if (VC != null && this.bOJ.mo25525Vy() != null && VC.isZoomSupported()) {
            this.bMF = VC.isSmoothZoomSupported();
            this.bOJ.mo25525Vy().aHl().setZoomChangeListener(this.bNy);
        }
    }

    /* renamed from: TE */
    private void m11930TE() {
        if (this.bOJ.mo25525Vy() != null) {
            Parameters VC = this.bOJ.mo25517VC();
            if (VC != null && VC.isZoomSupported()) {
                VC.setZoom(this.bMG);
                this.bOJ.mo25525Vy().setParameters(VC);
            }
        }
    }

    /* renamed from: TG */
    private void m11931TG() {
        this.bNq = (SegProgressbar) findViewById(R.id.cam_seg_progressbar);
        ArrayList c = C5034e.m13257c(this.bMM);
        C5008i.m12937VU().mo25632a(c);
        int durationLimit = C5008i.m12937VU().getDurationLimit();
        if (durationLimit >= 2000) {
            this.bNq.setProcessLimit((long) durationLimit);
            this.bNq.mo26198b(c);
            this.bNq.setSegListener(new C5176a() {
                /* renamed from: Ub */
                public void mo24957Ub() {
                    C5008i.m12937VU().mo25635cK(true);
                    CameraActivityNew.this.m11921SV();
                    CameraActivityNew.this.bLS.sendMessage(CameraActivityNew.this.bLS.obtainMessage(4101));
                }
            });
            this.bNq.setVisibility(0);
            if (this.bNq.mo26194Yl()) {
                C5008i.m12937VU().mo25635cK(true);
            } else {
                C5008i.m12937VU().mo25635cK(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: TH */
    public void m11932TH() {
        if ("MIX 2".equals(Build.MODEL)) {
            if (this.bLR == 1 && this.bMq == 0) {
                this.bNp.show();
            } else {
                this.bNp.dismiss();
            }
        }
    }

    /* renamed from: TI */
    private void m11933TI() {
        int i;
        m11920SU();
        m11934TJ();
        m11935TK();
        if (this.bNd != null) {
            this.bMB = this.bNd.cameraIntent;
        }
        boolean z = this.bMs == 2;
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        String[] strArr = {"", ""};
        if (iEditorService != null) {
            strArr = iEditorService.getCommonBehaviorParam();
        }
        switch (this.bMB) {
            case 4097:
                if (this.bMM.ebQ == -1) {
                    this.bMn = true;
                    this.bMM.mo34756b(getApplicationContext(), this.bLS, z, strArr[0], strArr[1]);
                    this.bLP.mo25886YQ();
                }
                ProjectItem ahP = this.bMM.aHf();
                if (ahP.mProjectDataItem != null) {
                    if (ahP.mProjectDataItem._id > 0) {
                        C8446b.aIZ().mo34319b(getApplicationContext(), ahP.mProjectDataItem._id, 2);
                    }
                    int i2 = ahP.mProjectDataItem.iCameraCode;
                    String str = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("iCameraCode: ");
                    sb.append(i2);
                    LogUtils.m14223i(str, sb.toString());
                    if (i2 != 0) {
                        this.bOy = CameraCodeMgr.getCameraMode(i2);
                        this.bOz = CameraCodeMgr.getCameraModeParam(i2);
                    } else {
                        this.bOz = AppPreferencesSetting.getInstance().getAppSettingInt(CameraRouter.KEY_PREF_LAST_CAMERA_MODE_PARAM, 1);
                    }
                    m11982a(this.bOy, this.bOz, false, 1);
                    return;
                }
                return;
            case 4098:
                this.mClipCount = 0;
                this.bNs = true;
                DataItemProject aHe = this.bMM.aHe();
                if (aHe != null) {
                    this.mPrjPath = aHe.strPrjURL;
                }
                m11982a(256, 1, false, 1);
                this.bMM.ebQ = -1;
                this.bMn = true;
                this.bMM.mo34756b(getApplicationContext(), this.bLS, z, strArr[0], strArr[1]);
                this.bLP.mo25886YQ();
                return;
            case 4099:
                if (this.bMM.ebQ == -1) {
                    this.bMn = true;
                    this.bMM.mo34756b(getApplicationContext(), this.bLS, z, strArr[0], strArr[1]);
                    this.bLP.mo25886YQ();
                }
                if (this.bMy != null) {
                    if (this.bNd != null) {
                        this.bOy = this.bNd.cameraMode;
                        this.bOz = this.bNd.cameraModeParam;
                    }
                    m11982a(this.bOy, this.bOz, true, 1);
                    return;
                }
                return;
            case 4100:
                this.bMn = true;
                this.bMM.mo34756b(getApplicationContext(), this.bLS, z, strArr[0], strArr[1]);
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
                    m11982a(this.bOy, this.bOz, true, 1);
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(51, 1000);
                        return;
                    }
                    return;
                }
                return;
            case 4101:
                ProjectItem ahP3 = this.bMM.aHf();
                if (!(ahP3 == null || ahP3.mProjectDataItem == null)) {
                    if (ahP3.mProjectDataItem._id > 0) {
                        C8446b.aIZ().mo34319b(getApplicationContext(), ahP3.mProjectDataItem._id, 2);
                    }
                    int i3 = ahP3.mProjectDataItem.nDurationLimit;
                    if (i3 != 0) {
                        i3 -= 100;
                    }
                    C5008i.m12937VU().setDurationLimit(i3);
                    int i4 = ahP3.mProjectDataItem.iCameraCode;
                    String str2 = TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("iCameraCode: ");
                    sb2.append(i4);
                    LogUtils.m14223i(str2, sb2.toString());
                    String str3 = TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("project extra info:");
                    sb3.append(ahP3.mProjectDataItem.strExtra);
                    LogUtils.m14223i(str3, sb3.toString());
                    this.bOx = C8558m.m25026oi(ahP3.mProjectDataItem.strExtra);
                    if (i4 != 0) {
                        this.bOy = CameraCodeMgr.getCameraMode(i4);
                        i = CameraCodeMgr.getCameraModeParam(i4);
                    } else {
                        i = AppPreferencesSetting.getInstance().getAppSettingInt(CameraRouter.KEY_PREF_LAST_CAMERA_MODE_PARAM, 1);
                    }
                    m11982a(this.bOy, i, false, 1);
                }
                DataItemProject aHe2 = this.bMM.aHe();
                if (aHe2 != null) {
                    this.bMM.mo34774oG(aHe2.strPrjURL);
                }
                this.bMM.aHg();
                this.bMR = true;
                return;
            case 4102:
                if (this.bNd != null) {
                    this.bLR = this.bNd.cameraAdjustMode;
                }
                this.bOH = true;
                if (this.bMM.ebQ == -1) {
                    this.bMn = true;
                    this.bMM.mo34756b(getApplicationContext(), this.bLS, z, strArr[0], strArr[1]);
                    this.bLP.mo25886YQ();
                }
                ProjectItem ahP4 = this.bMM.aHf();
                if (ahP4 != null && ahP4.mProjectDataItem != null) {
                    if (ahP4.mProjectDataItem._id > 0) {
                        C8446b.aIZ().mo34319b(getApplicationContext(), ahP4.mProjectDataItem._id, 2);
                    }
                    this.bOy = 256;
                    this.bOz = 1;
                    m11982a(this.bOy, this.bOz, false, 1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: TJ */
    private void m11934TJ() {
        MusicDataItem musicDataItem = this.bNd.musicDataItem;
        if (musicDataItem == null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                int i = aHe.iCameraCode;
                if (i != 0 && CameraCodeMgr.isParamMVEnable(CameraCodeMgr.getCameraModeParam(i))) {
                    String str = aHe.strExtra;
                    if (!TextUtils.isEmpty(str)) {
                        musicDataItem = C5029a.m13199fh(str);
                    }
                }
            }
        }
        if (this.bNr != null && musicDataItem != null && !TextUtils.isEmpty(musicDataItem.filePath)) {
            this.bNr.setTitle(musicDataItem.title);
            this.bNr.mo25581eW(musicDataItem.filePath);
            this.bNr.setRange(musicDataItem.startTimeStamp, musicDataItem.stopTimeStamp);
            if (musicDataItem.currentTimeStamp != musicDataItem.startTimeStamp) {
                this.bNr.seekTo(musicDataItem.currentTimeStamp);
            }
            if (this.bNo != null) {
                this.bNo.mo25731b(musicDataItem);
            }
            this.bNt = musicDataItem;
        }
    }

    /* renamed from: TK */
    private void m11935TK() {
        if (!TextUtils.isEmpty(this.bNd.stickerPath)) {
            m12036eP(this.bNd.stickerPath);
            m11946TV();
            if (this.bNo != null) {
                this.bNo.mo25728a(true, null, this.bNd.stickerPath);
            }
        }
    }

    /* renamed from: TL */
    private int m11936TL() {
        if (this.bOy == 512) {
            return 0;
        }
        if (this.bOy == 768) {
            return QDisplayContext.DISPLAY_ROTATION_180;
        }
        return 90;
    }

    /* access modifiers changed from: private */
    /* renamed from: TM */
    public boolean m11937TM() {
        if (this.bLQ < 2) {
            this.bOG = false;
            return false;
        } else if (!this.ajR) {
            this.bNa = true;
            return false;
        } else {
            this.bNa = false;
            if (this.bOJ.getState() == 2 || this.bOJ.getState() == 6) {
                m12027cj(true);
            }
            this.bLR = (this.bLR + 1) % 2;
            if (this.bNn != 2) {
                if (this.bMh == null) {
                    this.bMh = new C8394d(getApplicationContext(), this.bLR);
                }
                C8393c.m24209a(this.bMh, this.bLR);
                AppPreferencesSetting.getInstance().setAppSettingInt("pref_view_camera_id", this.bLR);
            }
            this.bOJ.mo25561ja(this.bLR);
            this.bMX = true;
            mo25824Ur();
            connect();
            this.bNo.mo25711Uj();
            m11932TH();
            return true;
        }
    }

    /* renamed from: TN */
    private void m11938TN() {
        View findViewById = findViewById(R.id.iap_vip_tip);
        if (findViewById != null) {
            if (TextUtils.isEmpty(this.bOO) || !C8049f.aBf().mo33101iL(this.bOO)) {
                m12055j(findViewById, true);
                return;
            }
            if (findViewById.getVisibility() != 0) {
                m12047i(findViewById, true);
                findViewById.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C8049f.aBf().mo33097b(CameraActivityNew.this, C8070o.aBw(), C7825a.ALL_TEMPLATE.getId(), "effects", -1);
                    }
                });
            }
        }
    }

    /* renamed from: TO */
    private void m11939TO() {
        if (this.bNo == null) {
            this.bNo = new C5011k(this, this.bNb);
        }
        if (this.bNo.mo25723Wv()) {
            this.bNo.mo25745jo(this.bOy);
            return;
        }
        this.bNo.mo25726a((CameraNewViewBase) new CameraFuncView((Activity) this));
        this.bNo.mo25745jo(this.bOy);
        this.bNo.setCallbackHandler(this.bLS);
        this.bNo.setEffectMgr(this.bOt);
        this.bNo.mo25740g(this.bNr);
        this.bNo.setSoundPlayer(this.bMf);
        this.bNo.mo25746jq(this.bNz);
    }

    /* renamed from: TP */
    private void m11940TP() {
        if (this.bNA == null) {
            this.bNA = new C4651e(getApplicationContext(), 2);
            this.bNA.enable();
        }
    }

    /* renamed from: TQ */
    private int m11941TQ() {
        if (this.bMM == null) {
            return 1;
        }
        if (this.bMM.aHe() != null) {
            QStoryboard aHd = this.bMM.aHd();
            if (aHd == null) {
                ProjectItem ahP = this.bMM.aHf();
                if (ahP != null) {
                    this.bMM.mo34764i(ahP);
                }
                mo24934k(true, true);
                this.bMM.ebQ = this.bMM.mo33889nt(this.mPrjPath);
                LogUtils.m14223i(TAG, "QStoryboard is null");
                return 1;
            }
            int nt = this.bMM.mo33889nt(this.mPrjPath);
            this.bMM.ebQ = nt;
            if (nt == -1) {
                return 1;
            }
            ProjectItem uz = this.bMM.mo34778uz(nt);
            if (uz == null || uz.mStoryBoard == null) {
                return 1;
            }
            int clipCount = aHd.getClipCount();
            ArrayList arrayList = new ArrayList();
            if (clipCount > 0) {
                for (int i = 0; i < clipCount; i++) {
                    QClip clip = aHd.getClip(i);
                    QClip qClip = new QClip();
                    if (clip != null && clip.duplicate(qClip) == 0) {
                        C8440a aVar = new C8440a();
                        aVar.mo34257tQ(1);
                        C8518c.m24650a(qClip, aVar);
                        aVar.mo34264u((Bitmap) C8537n.m24793a(qClip, 0, 360, 360, true, false, false));
                        arrayList.add(C8443d.m24427b(aVar));
                    }
                }
            }
            this.bMM.ebQ = 0;
            ProjectItem ahP2 = this.bMM.aHf();
            if (ahP2 != null) {
                this.bMM.mo34764i(ahP2);
            }
            mo24934k(false, false);
            this.bOK.mo34669jt(true);
            this.bMM.ebQ = this.bMM.mo33889nt(this.mPrjPath);
            ArrayList arrayList2 = new ArrayList(arrayList);
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra(MediaGalleryRouter.INTENT_BACK_RANG_LIST_FROM_CAMERA, arrayList2);
            setResult(-1, intent);
            finish();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: TR */
    public boolean m11942TR() {
        if (this.bNs) {
            if (this.mClipCount > 0) {
                C8978m.m26350ht(this).mo10296do(R.string.xiaoying_str_com_dialog_cancel_ask).mo10281a((C1904j) new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        CameraActivityNew.this.bOH = true;
                        ProjectItem ahP = CameraActivityNew.this.bMM.aHf();
                        if (ahP != null) {
                            CameraActivityNew.this.bMM.mo34764i(ahP);
                        }
                        CameraActivityNew.this.mo24934k(true, true);
                        CameraActivityNew.this.bMM.ebQ = CameraActivityNew.this.bMM.mo33889nt(CameraActivityNew.this.mPrjPath);
                        CameraActivityNew.this.setResult(0);
                        CameraActivityNew.this.finish();
                    }
                }).mo10313qu().show();
            } else {
                ProjectItem ahP = this.bMM.aHf();
                if (ahP != null) {
                    this.bMM.mo34764i(ahP);
                }
                mo24934k(true, true);
                this.bMM.ebQ = this.bMM.mo33889nt(this.mPrjPath);
                setResult(0);
                finish();
                return true;
            }
        } else if (!this.bMA && !this.bMM.aJJ() && (this.bMJ != 1 || this.mClipCount == 0)) {
            if (this.bMR && !this.bMr) {
                this.bMb = true;
            }
            C4586g.bKT = true;
            this.bOG = true;
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(20);
            }
        } else if (this.bMr) {
            C8978m.m26350ht(this).mo10296do(R.string.xiaoying_str_com_msg_intent_send_cancel_tip).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    CameraActivityNew.this.finish();
                }
            }).mo10313qu().show();
        } else if (this.bMn) {
            if (this.mClipCount == 0) {
                m11927TB();
                C4586g.bKT = true;
            } else {
                m11926TA();
            }
        } else if (!this.bMR) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                this.bMM.mo34774oG(aHe.strPrjURL);
            }
            this.bOG = true;
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(20);
            }
        } else if (this.bMM == null) {
            this.bMb = true;
            this.bOG = true;
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(20);
            }
        } else if (this.bMA || this.bMM.aJJ()) {
            m11928TC();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: TS */
    public void m11943TS() {
        if (this.bNP == null) {
            return;
        }
        if (TextUtils.equals(this.bNP.tcid, C8399c.ecY)) {
            if (TextUtils.isEmpty(this.bNP.strUrl) && (this.bNP instanceof RollInfo)) {
                this.bNP.strUrl = ((RollInfo) this.bNP).rollModel.rollDownUrl;
            }
            m11993a(this.bNP);
            return;
        }
        m12016b(this.bNP);
    }

    /* access modifiers changed from: private */
    /* renamed from: TT */
    public void m11944TT() {
        if (Math.abs(System.currentTimeMillis() - this.bMT) >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS && !this.bNH) {
            this.bMT = System.currentTimeMillis();
            if (this.mClipCount != 0 || getState() == 2 || this.bNs) {
                this.bMW = true;
                this.bLX = !this.bNs;
                if (getState() == 2) {
                    m11955Te();
                    m12027cj(true);
                }
                this.bNH = true;
                this.bOG = true;
                if (this.bOK != null) {
                    this.bOK.mo34669jt(true);
                }
                exit();
                return;
            }
            this.bNo.mo25712Uk();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: TU */
    public void m11945TU() {
        if (this.bMM != null && this.bMO != null && this.bNr != null && this.bNr.mo25579VN()) {
            List UY = this.bMO.mo25460UY();
            if (UY != null && UY.size() > 0) {
                this.bOF = (int) (((long) this.bOF) - C5034e.m13252b(this.bOx, (long) (((SaveRequest) UY.get(UY.size() - 1)).endPos - ((SaveRequest) UY.get(0)).startPos)));
                m11966Tv();
                this.bNr.mo25575VJ();
                int UZ = this.bMO.mo25461UZ();
                for (int i = 0; i < UZ; i++) {
                    this.bNq.mo26195Ym();
                }
                this.mClipCount -= UZ;
                this.mClipCount -= this.bMM.aJD();
                this.bNo.setClipCount(this.mClipCount, false);
            } else if (this.bMR || this.bMA) {
                int aJD = this.bMM.aJD();
                ProjectItem ahP = this.bMM.aHf();
                if (!(ahP == null || ahP.mProjectDataItem == null || ahP.mProjectDataItem.strExtra == null)) {
                    MusicDataItem fh = C5029a.m13199fh(ahP.mProjectDataItem.strExtra);
                    this.bOF -= fh.currentTimeStamp - fh.startTimeStamp;
                    fh.currentTimeStamp = fh.startTimeStamp;
                    this.bNr.setTitle(fh.title);
                    this.bNr.mo25581eW(fh.filePath);
                    this.bNr.setRange(fh.startTimeStamp, fh.stopTimeStamp);
                    this.bNr.seekTo(fh.startTimeStamp);
                    this.bNo.mo25731b(fh);
                    this.mClipCount -= aJD;
                    this.bNo.setClipCount(this.mClipCount, false);
                    m11966Tv();
                    this.bMA = true;
                }
            }
            ArrayList c = C5034e.m13257c(this.bMM);
            this.bOF = C5034e.m13256c(c);
            C5008i.m12937VU().mo25632a(c);
            int durationLimit = C5008i.m12937VU().getDurationLimit();
            if (durationLimit == 0 || this.bOF < durationLimit) {
                C5008i.m12937VU().mo25635cK(false);
            } else {
                C5008i.m12937VU().mo25635cK(true);
            }
            if (getState() == 2) {
                m11955Te();
                m12027cj(true);
            } else if (getState() == 6) {
                m12027cj(true);
            }
        }
    }

    /* renamed from: TV */
    private void m11946TV() {
        TextView textView = (TextView) findViewById(R.id.expression_action_hint);
        C4648c cVar = new C4648c(textView);
        int VG = this.bOJ != null ? this.bOJ.mo25521VG() : 0;
        if (VG != 0) {
            if (this.mHandler != null) {
                this.mHandler.removeCallbacks(cVar);
            }
            textView.setVisibility(0);
            textView.setText(getResources().getString(bNM[VG]));
            if (this.mHandler != null) {
                this.mHandler.postDelayed(cVar, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                return;
            }
            return;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(cVar);
        }
        textView.setVisibility(4);
    }

    /* renamed from: TW */
    private boolean m11947TW() {
        return SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "unlock"));
    }

    /* renamed from: TX */
    private void m11948TX() {
        if (!(this.bNn == -1)) {
            m11949TY();
        }
    }

    /* renamed from: TY */
    private void m11949TY() {
        C5034e.m13246a((Context) this, (OnClickListener) new OnClickListener() {
            public void onClick(View view) {
                if (view == null) {
                    if (CameraActivityNew.this.bMB == 4102) {
                        C5034e.m13238YR();
                        CameraActivityNew.this.exit();
                    } else {
                        CameraActivityNew.this.m11950TZ();
                    }
                } else if (((Integer) view.getTag()).intValue() == 5) {
                    int VH = CameraActivityNew.this.bOJ.mo25522VH();
                    int VE = CameraActivityNew.this.bOJ.mo25519VE();
                    int VF = CameraActivityNew.this.bOJ.mo25520VF();
                    if (CameraActivityNew.this.bLR == 0) {
                        AppPreferencesSetting.getInstance().setAppSettingInt("pref_back_camera_display_offset", VH);
                        AppPreferencesSetting.getInstance().setAppSettingInt("pref_back_camera_display_hormirror", VE);
                        AppPreferencesSetting.getInstance().setAppSettingInt("pref_back_camera_display_vermirror", VF);
                    } else {
                        AppPreferencesSetting.getInstance().setAppSettingInt("pref_front_camera_display_offset", VH);
                        AppPreferencesSetting.getInstance().setAppSettingInt("pref_front_camera_display_hormirror", VE);
                        AppPreferencesSetting.getInstance().setAppSettingInt("pref_front_camera_display_vermirror", VF);
                    }
                    if (CameraActivityNew.this.bMB == 4102) {
                        C5034e.m13238YR();
                        CameraActivityNew.this.exit();
                    } else {
                        CameraActivityNew.this.m11950TZ();
                    }
                } else {
                    Message obtainMessage = CameraActivityNew.this.mHandler.obtainMessage(25, ((Integer) view.getTag()).intValue(), 0);
                    CameraActivityNew.this.bMj.setVisibility(4);
                    CameraActivityNew.this.mHandler.sendMessage(obtainMessage);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: TZ */
    public void m11950TZ() {
        if (this.bNn != -1) {
            this.bNn = -1;
            C5034e.m13238YR();
        }
        m11969Ty();
    }

    /* renamed from: Ta */
    private void m11951Ta() {
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
                aHe.strExtra = C8558m.m25022g(aHe.strExtra, this.bNz, this.bOy);
                if (CameraCodeMgr.isParamMVEnable(this.bOz) && !this.bOH && this.bNr != null && this.bNr.mo25577VL() != null) {
                    aHe.strExtra = C5029a.m13198a(aHe.strExtra, this.bNr.mo25577VL());
                }
                aHe.strExtra = C5030b.m13204fk(aHe.strExtra);
                int durationLimit = C5008i.m12937VU().getDurationLimit();
                if (durationLimit != 0) {
                    aHe.nDurationLimit = durationLimit + 100;
                } else {
                    aHe.nDurationLimit = 0;
                }
                String str2 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("dataItemProject.strExtra: ");
                sb2.append(aHe.strExtra);
                LogUtils.m14223i(str2, sb2.toString());
            }
        }
    }

    /* renamed from: Tb */
    private void m11952Tb() {
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
    public void m11953Tc() {
        if (!(this.bMj == null || this.bNn == -1)) {
            this.bMj.setVisibility(0);
        }
        this.bOG = false;
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(771, 1000);
        }
        if (CameraCodeMgr.isParamFacialEnable(this.bOz)) {
            m12036eP(this.bND);
        }
        if (CameraCodeMgr.isParamBeautyEnable(this.bOz)) {
            if (this.bNu != null) {
                this.bNu.mo25477Vi();
            }
            if (CameraCodeMgr.isCameraParamFB(this.bOz)) {
                if (this.bNK > -1) {
                    m12013b(this.bNK, true, false);
                    this.bNK = -1;
                    this.bNo.mo25732cW(true);
                } else {
                    m12013b(this.bOA, false, false);
                }
            }
        } else {
            String str = null;
            DataItemProject aHe = this.bMM != null ? this.bMM.aHe() : null;
            if (aHe != null && aHe.usedEffectTempId > 0) {
                str = C8759b.m25586by(aHe.usedEffectTempId);
            }
            if (str != null) {
                m12035eN(str);
                if (this.bOt != null) {
                    m12013b(this.bOt.mo35208qC(str), false, false);
                }
            } else if (this.bNK > -1) {
                m12013b(this.bNK, true, false);
                this.bNK = -1;
                this.bNo.mo25732cW(true);
            } else {
                m12013b(this.bOA, false, false);
            }
        }
        if (this.bMB == 4102) {
            m11921SV();
            if (this.bNn != 2 && getState() == 1 && !this.bOG) {
                this.bNn = this.bLR;
                m11948TX();
            }
        }
        if (this.bMX) {
            this.bMX = false;
        }
    }

    /* renamed from: Td */
    private void m11954Td() {
        if (!this.bLV && this.bOJ.mo25524Vx() != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                boolean z = true;
                this.bMA = true;
                if (!CameraCodeMgr.isParamMvNecessary(this.bOz) || this.bNr == null || this.bNr.mo25576VK()) {
                    if (CameraCodeMgr.isCameraParamPerfect(this.bOz)) {
                        C5011k kVar = this.bNo;
                        if (this.bNr == null || this.bNr.mo25577VL() == null) {
                            z = false;
                        }
                        kVar.setMusicViewEnable(z);
                    }
                    setState(2);
                    this.mHandler.removeMessages(771);
                    this.bOE = 0;
                    this.bOD = 0;
                    C4582c.m11669dF(this);
                    this.bOJ.mo25540cC(m11947TW());
                    String d = C5034e.m13260d(this, System.currentTimeMillis());
                    C5530d dVar = (C5530d) MagicCode.getMagicParam(this.bMw, "AppRunningMode", null);
                    String cameraVideoPath = (!this.bMr || dVar == null || dVar.cnX != 2) ? CommonConfigure.getCameraVideoPath() : C8572y.m25097ou(aHe.strPrjURL);
                    StringBuilder sb = new StringBuilder();
                    sb.append(cameraVideoPath);
                    sb.append(d);
                    sb.append(".mp4");
                    this.bMd = sb.toString();
                    this.bOJ.setOutputFile(this.bMd);
                    this.bNq.mo26196Yn();
                    this.bOJ.mo25548cy(false);
                    this.bON.mo25784jr(4);
                    if (CameraCodeMgr.isParamMVEnable(this.bOz) && this.bNr != null) {
                        this.bNr.play();
                    }
                    if (this.bOF == 0) {
                        this.bNv = this.bMq;
                    }
                    return;
                }
                this.bNo.mo25733cX(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Te */
    public void m11955Te() {
        if (CameraCodeMgr.isParamMVEnable(this.bOz)) {
            if (this.bNr != null) {
                this.bNr.pause();
            }
            this.bNq.mo26200dv(false);
        } else {
            this.bNq.mo26200dv(true);
        }
        setState(6);
        this.mHandler.removeMessages(2);
        this.bOJ.mo25549cz(true);
        m11956Tf();
        m11924SY();
    }

    /* renamed from: Tf */
    private void m11956Tf() {
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
        if (CameraCodeMgr.isParamMVEnable(this.bOz) && this.bNr.mo25577VL() != null) {
            saveRequest.musicItem = this.bNr.mo25577VL();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("AAAAA---startPos: ");
        sb.append(saveRequest.startPos);
        sb.append(", endPos: ");
        sb.append(saveRequest.endPos);
        LogUtils.m14222e(">>TIMESTAMP<<", sb.toString());
        int i = (saveRequest.endPos - saveRequest.startPos) + (saveRequest.startPos - this.bOM);
        this.bOM = saveRequest.endPos;
        int i2 = CameraCodeMgr.isParamBeautyEffectEnable(this.bOz) ? this.bOA : this.bOB;
        EffectInfoModel vh = this.bOt.mo35214vh(i2);
        if (vh != null) {
            saveRequest.effectFilepath = vh.mPath;
        }
        saveRequest.effectConfigureIndex = this.bOC;
        if (!this.bMO.mo25468b(saveRequest)) {
            this.mClipCount++;
        }
        if (CameraCodeMgr.isParamFacialEnable(this.bOz)) {
            QCamExportedEffectData qCamExportedEffectData = new QCamExportedEffectData();
            qCamExportedEffectData.mlTemplateID = C8762d.aMt().getTemplateID(this.bND);
            saveRequest.camExportEffectDataArray = new QCamExportedEffectData[]{qCamExportedEffectData};
        }
        this.bMO.mo25466a(saveRequest);
        this.bNo.setClipCount(this.mClipCount, false);
        this.bOD = this.bOE;
        this.bOF = (int) (((long) this.bOF) + C5034e.m13252b(this.bOx, (long) i));
        this.bOG = false;
        this.mHandler.sendEmptyMessage(2);
        String str = ParametersKeys.ORIENTATION_NONE;
        if (i2 >= 0 && this.bOt.mo35214vh(i2) != null) {
            str = C8762d.aMt().mo35224aa(this.bOt.mo35214vh(i2).mPath, 4);
        }
        if (this.bOy == 256) {
            if (CameraCodeMgr.isCameraParamMV(this.bOz)) {
                m12034eM("CameraMusic");
                C5031c.m13219an(getApplicationContext(), str);
            } else if (CameraCodeMgr.isCameraParamFB(this.bOz)) {
                m12034eM("Cameraselfie");
                C5031c.m13220ao(getApplicationContext(), str);
            } else {
                m12034eM("CameraHD");
                C5031c.m13219an(getApplicationContext(), str);
            }
        } else if (!CameraCodeMgr.isLandScapeMode(this.bOy)) {
        } else {
            if (CameraCodeMgr.isCameraParamMV(this.bOz)) {
                m12034eM("CameraMusic");
                C5031c.m13219an(getApplicationContext(), str);
            } else if (CameraCodeMgr.isCameraParamFB(this.bOz)) {
                C5031c.m13220ao(getApplicationContext(), str);
                m12034eM("Cameraselfie");
            } else {
                m12034eM("CameraHD");
                C5031c.m13219an(getApplicationContext(), str);
            }
        }
    }

    /* renamed from: Tg */
    private void m11957Tg() {
        if (CameraCodeMgr.isParamMVEnable(this.bOz) && this.bNr != null) {
            this.bNr.play();
        }
        if (CameraCodeMgr.isCameraParamPerfect(this.bOz)) {
            this.bNo.setMusicViewEnable((this.bNr == null || this.bNr.mo25577VL() == null) ? false : true);
        }
        setState(2);
        this.mHandler.removeMessages(771);
        this.bNq.mo26196Yn();
        this.bOJ.mo25538cA(false);
        C4582c.m11669dF(this);
        this.bOJ.mo25540cC(m11947TW());
        this.bON.mo25784jr(4);
        this.mHandler.sendEmptyMessage(2);
        if (this.bOF == 0) {
            this.bNv = this.bMq;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Th */
    public void m11958Th() {
        LogUtils.m14223i(TAG, "stopRecord--->");
        setState(1);
        this.mHandler.sendEmptyMessage(2);
        this.bOG = false;
    }

    /* renamed from: Tj */
    private void m11959Tj() {
        if (!this.bLW) {
            LogUtils.m14222e(TAG, "initializeFirstTime<---");
            this.bMh = new C8394d(getApplicationContext(), this.bLR);
            C8393c.m24213d(this.bMh.aHm());
            C8393c.m24212c(this.bMh.aHn());
            m11967Tw();
            if (this.bON != null) {
                this.bON.mo25779c(this.bOJ.mo25517VC());
                this.bON.mo25776a(this, this.bMj, this, false, this.bOw);
                this.bON.mo25777aa(this);
            }
            this.bLW = true;
            this.bOJ.mo25546cv(true);
            startPreview();
            LogUtils.m14222e(TAG, "initializeFirstTime--->");
        }
    }

    /* renamed from: Tk */
    private void m11960Tk() {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("initializeSecondTime<---");
        sb.append(getState());
        LogUtils.m14222e(str, sb.toString());
        if (this.bNn != 2) {
            if (this.bMh == null) {
                this.bMh = new C8394d(getApplicationContext(), this.bLR);
            }
            C8393c.m24209a(this.bMh, this.bLR);
        }
        this.bMG = 0;
        C8393c.m24212c(this.bMh.aHn());
        m11929TD();
        m11967Tw();
        startPreview();
    }

    /* renamed from: Tl */
    private void m11961Tl() {
        m12027cj(false);
    }

    /* renamed from: Tm */
    private void m11962Tm() {
        LogUtils.m14221d(TAG, "onShutterButtonClick");
        if (!this.bOG || getState() == 2 || getState() == 6) {
            LogUtils.m14222e(TAG, "rec btn click");
            if (getState() == 1) {
                if (m8736bo(this)) {
                    LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.introvd.template.diskspace"));
                    return;
                }
                if (this.bOJ.mo25524Vx() != null) {
                    C8385a aHq = this.bOJ.mo25524Vx().aHq();
                    if (aHq != null) {
                        long FQ = m8731FQ() - 52428800;
                        if (FQ > 0) {
                            FQ = 0;
                        }
                        aHq.set("max-filesize", String.valueOf(FQ));
                        this.bOJ.mo25524Vx().mo33895a(aHq);
                    }
                }
                if (this.bOJ.mo25524Vx() != null) {
                    this.bOJ.mo25524Vx().mo33899aW(this.bOJ.mo25524Vx().aHp() & -2);
                    C8385a aHq2 = this.bOJ.mo25524Vx().aHq();
                    if (aHq2 != null) {
                        int i = C8572y.m25072a(this.bOK) ? 4 : 2;
                        MSize mSize = new MSize();
                        mSize.width = aHq2.getInt("out-video-width");
                        mSize.height = aHq2.getInt("out-video-height");
                        int i2 = this.bLR == 0 ? 2 : 1;
                        QEngine qEngine = null;
                        if (this.bOK != null) {
                            qEngine = this.bOK.aJv();
                        }
                        aHq2.set("video-bitrate", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(QUtils.caculateVideoBitrate(qEngine, i, 33, mSize.width, mSize.height, i2, C8572y.aJm(), 3))}));
                        aHq2.set("video-frame-rate", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(33330)}));
                        long c = (this.todoParamModel == null || this.todoParamModel.getActivityFlag() <= 0 || this.todoParamModel.getLimitDuration() <= 0) ? 0 : m12021c(this.bOx, this.todoParamModel.getLimitDuration() - this.bOF);
                        if (c < 0) {
                            c = 1;
                        }
                        aHq2.set("max-duration", String.valueOf(c));
                        this.bOJ.mo25524Vx().mo33895a(aHq2);
                    } else {
                        return;
                    }
                }
                m11954Td();
            } else if (this.bOJ.getState() == 2 || this.bOJ.getState() == 6) {
                m12026ci(this.bMo);
                this.mHandler.removeMessages(2);
            }
        }
    }

    /* renamed from: To */
    private void m11963To() {
        if (this.bNA != null) {
            this.bNA.disable();
            this.bNA = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Ts */
    public void m11964Ts() {
        if (this.bMO != null && !this.bMO.mo25463Vc() && this.mClipCount > 0) {
            SaveRequest Va = this.bMO.mo25462Va();
            this.mClipCount--;
            this.bMO.mo25457Ts();
            this.bNq.mo26195Ym();
            if (Va != null) {
                int i = Va.endPos - Va.startPos;
                this.bOF = (int) (((long) this.bOF) - C5034e.m13252b(this.bOx, (long) i));
                if (this.mClipCount == 0) {
                    this.bOF = 0;
                }
                if (CameraCodeMgr.isParamMVEnable(this.bOz) && this.bNr != null) {
                    MusicDataItem VL = this.bNr.mo25577VL();
                    if (VL != null) {
                        int i2 = (((((VL.currentTimeStamp - VL.startTimeStamp) - i) / 100) * 100) * 1000) / (((VL.stopTimeStamp - VL.startTimeStamp) / 100) * 100);
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        List UY = this.bMO.mo25460UY();
                        if (UY == null || UY.size() == 0) {
                            this.bNo.mo25743iF(0);
                            this.bNr.mo25575VJ();
                        } else {
                            this.bNo.mo25743iF(i2);
                            this.bNr.seekTo(VL.currentTimeStamp - i);
                        }
                    }
                }
            } else {
                if (CameraCodeMgr.isParamMVEnable(this.bOz)) {
                    if (this.bNr != null && this.bNr.mo25576VK()) {
                        this.bNr.mo25575VJ();
                    }
                    this.bNo.mo25743iF(0);
                }
                this.bOF = 0;
                QStoryboard aHd = this.bMM.aHd();
                if (aHd != null && aHd.getClipCount() > 0) {
                    ProjectItem ahP = this.bMM.aHf();
                    if (ahP != null) {
                        C8443d dVar = ahP.mClipModelCacheList;
                        for (int i3 = 0; i3 < dVar.getCount(); i3++) {
                            C8440a tX = dVar.mo34307tX(i3);
                            if (tX != null && !tX.isCover()) {
                                this.bOF += tX.aHV();
                            }
                        }
                        String str = TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("mCurrentTotalTime : ");
                        sb.append(this.bOF);
                        LogUtils.m14223i(str, sb.toString());
                    }
                }
            }
            m11966Tv();
            if (C5008i.m12937VU().getDurationLimit() != 0) {
                m11921SV();
                if (C5008i.m12937VU().mo25615Wb()) {
                    C5008i.m12937VU().mo25635cK(false);
                }
            }
            this.bMA = true;
            this.bNo.setClipCount(this.mClipCount, false);
            if (this.mClipCount == 0) {
                if (CameraCodeMgr.isCameraParamPerfect(this.bOz)) {
                    this.bNo.setMusicViewEnable(true);
                }
                this.bNo.mo25719WB();
                if (!(this.bNA == null || this.bNA.bNU == null)) {
                    this.bNo.mo25744iH(this.bNA.bNU.get(this.bMq));
                }
            }
            if (!(this.mClipCount != 0 || this.mHandler == null || m12048iA(this.bMq) == this.bOy)) {
                this.mHandler.removeMessages(1540);
                this.mHandler.sendEmptyMessage(1540);
            }
        }
    }

    /* renamed from: Tu */
    private void m11965Tu() {
        if (this.bMZ == null) {
            this.bMZ = new C8759b(4);
            this.bMZ.mo35196a(getApplicationContext(), 0, 210239504, AppStateModel.getInstance().isInChina());
        }
        EffectInfoModel aMr = this.bMZ.aMr();
        if (aMr != null) {
            m12035eN(aMr.mPath);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Tv */
    public void m11966Tv() {
        long j = (long) this.bOF;
        this.bNo.setTimeExceed(new C9006a(null, (int) j, this.bMV).aNp());
        this.bNo.setCurrentTimeValue(j);
        if (this.bOJ.getState() == 2) {
            this.bNq.setProgress(j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Tw */
    public void m11967Tw() {
        LogUtils.m14223i(TAG, "onSharedPreferencesChanged");
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
                } else if (m11997a(appSettingStr, supportedFlashModes)) {
                    this.bOJ.mo25528a(VC, VC.getFlashMode(), appSettingStr);
                } else {
                    appSettingStr = VC.getFlashMode();
                    if (appSettingStr == null) {
                        appSettingStr = "no_flash";
                    }
                }
                AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_flash_mode", appSettingStr);
                String string = this.bMh.getString("pref_camera_focusmode_key", getString(R.string.xiaoying_str_cam_pref_camera_focusmode_default_notrans));
                if (!m11997a(string, VC.getSupportedFocusModes())) {
                    String focusMode = VC.getFocusMode();
                } else if (this.bOJ.mo25517VC() != null) {
                    this.bOJ.mo25517VC().setFocusMode(string);
                }
                C5008i.m12937VU().mo25634cJ(C5030b.m13205jL(this.bOz));
                if (m11995a(VC)) {
                    m11994a(m11947TW(), VC);
                } else {
                    AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", "no_aelock");
                }
                this.bOJ.mo25533b(VC);
                this.bNo.mo25711Uj();
                this.bON.mo25779c(VC);
                if ("on".equalsIgnoreCase(VC.getFlashMode()) || "torch".equalsIgnoreCase(VC.getFlashMode())) {
                    this.bOJ.mo25545cH(true);
                } else {
                    this.bOJ.mo25545cH(false);
                }
            }
        }
    }

    /* renamed from: Tx */
    private void m11968Tx() {
        this.bMh = new C8394d(getApplicationContext(), this.bLR);
        C8393c.m24213d(this.bMh.aHm());
        if (this.bNn == 2) {
            this.bLR = 0;
        }
        this.bOJ.mo25561ja(this.bLR);
        AppPreferencesSetting.getInstance().setAppSettingInt("pref_view_camera_id", this.bLR);
    }

    /* access modifiers changed from: private */
    /* renamed from: Ty */
    public void m11969Ty() {
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

    /* renamed from: a */
    private int m11978a(CameraIntentInfo cameraIntentInfo) {
        if (cameraIntentInfo != null && cameraIntentInfo.cameraIntent == 4101) {
            ProjectItem ahP = this.bMM.aHf();
            if (!(ahP == null || ahP.mProjectDataItem == null)) {
                int[] oj = C8558m.m25027oj(ahP.mProjectDataItem.strExtra);
                if (oj[0] >= 0) {
                    return oj[0];
                }
            }
        }
        return 2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x028a  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m11982a(int r17, int r18, boolean r19, int r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r20
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "cameraMode: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = ",cameraModeParam: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            com.introvd.template.common.LogUtilsV2.m14230i(r4)
            com.introvd.template.camera.b.f r4 = r0.bOJ
            if (r4 != 0) goto L_0x0029
            return
        L_0x0029:
            r16.m11969Ty()
            int r4 = r0.bOz
            r0.bMD = r4
            r0.bOy = r1
            r0.bOz = r2
            int r1 = r0.bMD
            int r2 = r0.bOz
            r4 = 1
            r5 = 0
            if (r1 == r2) goto L_0x003e
            r1 = 1
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            if (r1 == 0) goto L_0x0052
            int r2 = r0.bMD
            boolean r2 = com.introvd.template.router.camera.CameraCodeMgr.isParamBeautyEnable(r2)
            if (r2 == 0) goto L_0x0052
            com.introvd.template.camera.b.d r2 = r0.bNu
            if (r2 == 0) goto L_0x0052
            com.introvd.template.camera.b.d r2 = r0.bNu
            r2.mo25479Vk()
        L_0x0052:
            int r2 = r0.bOz
            boolean r2 = com.introvd.template.router.camera.CameraCodeMgr.isParamFacialEnable(r2)
            int r6 = r0.bOz
            boolean r6 = com.introvd.template.router.camera.CameraCodeMgr.isParamBeautyEnable(r6)
            int r7 = r0.bOz
            boolean r7 = com.introvd.template.router.camera.CameraCodeMgr.isParamBeautyEffectEnable(r7)
            if (r2 != 0) goto L_0x006b
            com.introvd.template.camera.b.k r8 = r0.bNo
            r8.mo25734cY(r5)
        L_0x006b:
            int r8 = r0.bOy
            boolean r8 = com.introvd.template.router.camera.CameraCodeMgr.isLandScapeMode(r8)
            r9 = 90
            r10 = 270(0x10e, float:3.78E-43)
            r11 = 2
            if (r8 == 0) goto L_0x00c3
            int r8 = r16.getState()
            if (r8 == r11) goto L_0x00a9
            int r8 = r0.bOy
            r12 = 512(0x200, float:7.175E-43)
            if (r8 != r12) goto L_0x0087
            r8 = 270(0x10e, float:3.78E-43)
            goto L_0x0089
        L_0x0087:
            r8 = 90
        L_0x0089:
            r0.bOw = r8
            r0.bOI = r5
            com.introvd.template.camera.b.f r8 = r0.bOJ
            r8.mo25541cD(r5)
            com.introvd.template.camera.b.f r8 = r0.bOJ
            r12 = r6 ^ 1
            int r13 = r0.bNz
            r8.mo25556h(r12, r13)
            com.introvd.template.camera.b.f r8 = r0.bOJ
            com.introvd.template.common.MSize r8 = r8.mo25516VB()
            int r12 = r8.height
            int r8 = r8.width
            r0.m12018bR(r12, r8)
            goto L_0x0105
        L_0x00a9:
            int r8 = r0.bOF
            if (r8 <= 0) goto L_0x0105
            int r8 = r16.getState()
            r12 = 6
            if (r8 == r12) goto L_0x00bb
            int r8 = r16.getState()
            r12 = 5
            if (r8 != r12) goto L_0x0105
        L_0x00bb:
            java.lang.String r8 = TAG
            java.lang.String r12 = "else comes !!!!!!!!!!!!!!!!!!!!!!!!!!"
            com.introvd.template.common.LogUtils.m14222e(r8, r12)
            goto L_0x0105
        L_0x00c3:
            java.lang.String r8 = "M040"
            java.lang.String r12 = android.os.Build.MODEL
            boolean r8 = r8.equals(r12)
            if (r8 != 0) goto L_0x00e6
            android.view.Window r8 = r16.getWindow()
            android.view.View r8 = r8.getDecorView()
            int r8 = r8.getSystemUiVisibility()
            if (r8 == 0) goto L_0x00e6
            android.view.Window r8 = r16.getWindow()
            android.view.View r8 = r8.getDecorView()
            r8.setSystemUiVisibility(r5)
        L_0x00e6:
            r0.bOw = r5
            r0.bOI = r4
            com.introvd.template.camera.b.f r8 = r0.bOJ
            r8.mo25541cD(r4)
            com.introvd.template.camera.b.f r8 = r0.bOJ
            r12 = r6 ^ 1
            int r13 = r0.bNz
            r8.mo25556h(r12, r13)
            com.introvd.template.camera.b.f r8 = r0.bOJ
            com.introvd.template.common.MSize r8 = r8.mo25516VB()
            int r12 = r8.width
            int r8 = r8.height
            r0.m12018bR(r12, r8)
        L_0x0105:
            r16.m11965Tu()
            r12 = 0
            com.introvd.template.sdk.utils.b.g r8 = r0.bMM
            xiaoying.engine.storyboard.QStoryboard r8 = r8.aHd()
            if (r8 == 0) goto L_0x0122
            r12 = 16391(0x4007, float:2.2969E-41)
            java.lang.Object r8 = r8.getProperty(r12)
            java.lang.String r8 = (java.lang.String) r8
            com.introvd.template.template.g.d r12 = com.introvd.template.template.p409g.C8762d.aMt()
            long r12 = r12.getTemplateID(r8)
        L_0x0122:
            r0.m12003ae(r12)
            r16.m11939TO()
            com.introvd.template.camera.b.k r8 = r0.bNo
            if (r8 == 0) goto L_0x014f
            com.introvd.template.camera.b.k r8 = r0.bNo
            int r12 = r0.bOy
            int r13 = r0.bOz
            if (r3 != r11) goto L_0x0136
            r14 = 1
            goto L_0x0137
        L_0x0136:
            r14 = 0
        L_0x0137:
            if (r3 != r4) goto L_0x013b
            r15 = 1
            goto L_0x013c
        L_0x013b:
            r15 = 0
        L_0x013c:
            r8.setCameraMode(r12, r13, r14, r15)
            com.introvd.template.camera.b.k r8 = r0.bNo
            r8.mo25736cm(r5)
            com.introvd.template.camera.b.k r8 = r0.bNo
            int r12 = r0.mClipCount
            if (r3 != r4) goto L_0x014b
            goto L_0x014c
        L_0x014b:
            r4 = 0
        L_0x014c:
            r8.setClipCount(r12, r4)
        L_0x014f:
            com.introvd.template.camera.b.k r4 = r0.bNo
            if (r4 == 0) goto L_0x0158
            com.introvd.template.camera.b.k r4 = r0.bNo
            r4.mo25733cX(r5)
        L_0x0158:
            int r4 = r0.bMD
            boolean r4 = com.introvd.template.router.camera.CameraCodeMgr.isParamMVEnable(r4)
            if (r4 == 0) goto L_0x0175
            int r4 = r0.bOz
            boolean r4 = com.introvd.template.router.camera.CameraCodeMgr.isParamMVEnable(r4)
            if (r4 != 0) goto L_0x0175
            com.introvd.template.camera.b.g r4 = r0.bNr
            boolean r4 = r4.mo25576VK()
            if (r4 == 0) goto L_0x0175
            com.introvd.template.camera.b.g r4 = r0.bNr
            r4.reset()
        L_0x0175:
            int r4 = r0.bOw
            com.introvd.template.camera.p232e.C5036f.setDegree(r4)
            int r4 = r0.bMD
            int r8 = r0.bOz
            if (r4 == r8) goto L_0x0183
            r16.m11921SV()
        L_0x0183:
            com.introvd.template.camera.b.k r4 = r0.bNo
            android.widget.RelativeLayout r8 = r0.bMj
            r4.mo25730b(r8)
            r16.m11969Ty()
            int r4 = r0.bMB
            r8 = 4097(0x1001, float:5.741E-42)
            if (r4 != r8) goto L_0x019e
            com.introvd.template.common.AppPreferencesSetting r4 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r8 = "key_pref_last_camera_mode_param"
            int r12 = r0.bOz
            r4.setAppSettingInt(r8, r12)
        L_0x019e:
            com.introvd.template.template.widget.a.c r4 = r0.bNC
            if (r4 != 0) goto L_0x01c0
            com.introvd.template.template.widget.a.c r4 = com.introvd.template.template.widget.p412a.C8937c.aMA()
            r0.bNC = r4
            com.introvd.template.template.widget.a.c r4 = r0.bNC
            com.introvd.template.template.g.b r8 = r0.bOt
            r4.setEffectMgr(r8)
            com.introvd.template.template.widget.a.c r4 = r0.bNC
            r4.aMB()
            com.introvd.template.template.widget.a.c r4 = r0.bNC
            if (r7 == 0) goto L_0x01bb
            java.lang.String r8 = "2"
            goto L_0x01bd
        L_0x01bb:
            java.lang.String r8 = "0"
        L_0x01bd:
            r4.mo35573qM(r8)
        L_0x01c0:
            if (r19 == 0) goto L_0x01c7
            int r4 = r0.bOz
            r0.m12052iy(r4)
        L_0x01c7:
            r4 = 0
            if (r3 == r11) goto L_0x0217
            int r8 = r0.bMB
            r12 = 4102(0x1006, float:5.748E-42)
            if (r8 == r12) goto L_0x0217
            com.introvd.template.camera.model.CameraTodoParam r8 = r0.bNI
            if (r8 == 0) goto L_0x01df
            com.introvd.template.camera.model.CameraTodoParam r8 = r0.bNI
            int r8 = r8.getCameraId()
            if (r8 < 0) goto L_0x01df
            r0.bNI = r4
            goto L_0x0217
        L_0x01df:
            int r8 = r0.bOz
            boolean r8 = com.introvd.template.router.camera.CameraCodeMgr.isCameraParamMV(r8)
            if (r8 != 0) goto L_0x0202
            if (r6 == 0) goto L_0x01ea
            goto L_0x0202
        L_0x01ea:
            com.introvd.template.router.todoCode.TODOParamModel r1 = r0.todoParamModel
            if (r1 == 0) goto L_0x0217
            com.introvd.template.router.todoCode.TODOParamModel r1 = r0.todoParamModel
            int r1 = r1.getActivityFlag()
            if (r1 > 0) goto L_0x0217
            int r1 = r0.bLR
            if (r1 == 0) goto L_0x0217
            r1 = 3
            if (r3 == r1) goto L_0x0217
            boolean r1 = r16.m11937TM()
            goto L_0x0218
        L_0x0202:
            if (r1 != 0) goto L_0x0208
            boolean r1 = r0.bNw
            if (r1 == 0) goto L_0x0217
        L_0x0208:
            r0.bNw = r5
            int r1 = r0.bLQ
            if (r1 < r11) goto L_0x0217
            int r1 = r0.bLR
            if (r1 != 0) goto L_0x0217
            boolean r1 = r16.m11937TM()
            goto L_0x0218
        L_0x0217:
            r1 = 0
        L_0x0218:
            boolean r3 = r0.bOI
            if (r3 == 0) goto L_0x0246
            com.introvd.template.camera.b.f r3 = r0.bOJ
            if (r3 == 0) goto L_0x025f
            if (r1 != 0) goto L_0x025f
            java.lang.String r1 = "MIX 2"
            java.lang.String r3 = android.os.Build.MODEL
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x023c
            int r1 = r0.bMq
            r3 = 180(0xb4, float:2.52E-43)
            if (r1 != r3) goto L_0x023c
            com.introvd.template.camera.b.f r1 = r0.bOJ
            int r3 = r0.bNz
            int r6 = r0.bOz
            r1.mo25569x(r10, r3, r6)
            goto L_0x025f
        L_0x023c:
            com.introvd.template.camera.b.f r1 = r0.bOJ
            int r3 = r0.bNz
            int r6 = r0.bOz
            r1.mo25569x(r9, r3, r6)
            goto L_0x025f
        L_0x0246:
            com.introvd.template.camera.b.f r3 = r0.bOJ
            if (r3 == 0) goto L_0x025f
            int r3 = r16.getState()
            if (r3 == r11) goto L_0x025f
            if (r1 != 0) goto L_0x025f
            com.introvd.template.camera.b.f r1 = r0.bOJ
            int r3 = r16.m11936TL()
            int r6 = r0.bNz
            int r8 = r0.bOz
            r1.mo25569x(r3, r6, r8)
        L_0x025f:
            boolean r1 = r0.ajR
            if (r1 == 0) goto L_0x0270
            if (r7 == 0) goto L_0x026b
            int r1 = r0.bOA
            r0.m12013b(r1, r5, r5)
            goto L_0x0270
        L_0x026b:
            int r1 = r0.bOB
            r0.m12013b(r1, r5, r5)
        L_0x0270:
            if (r2 == 0) goto L_0x028a
            com.introvd.template.camera.b.d r1 = r0.bNu
            r1.mo25478Vj()
            java.lang.String r1 = r0.bND
            r0.m12036eP(r1)
            com.introvd.template.camera.b.f r1 = r0.bOJ
            int r2 = r0.bMq
            int r2 = r0.m12053iz(r2)
            java.lang.String r3 = r0.bND
            r1.mo25560j(r2, r3)
            goto L_0x0294
        L_0x028a:
            java.lang.String r1 = ""
            r0.m12036eP(r1)
            com.introvd.template.camera.b.f r1 = r0.bOJ
            r1.mo25552eV(r4)
        L_0x0294:
            com.introvd.template.camera.b.k r1 = r0.bNo
            r1.mo25711Uj()
            com.introvd.template.camera.b.m r1 = r0.bON
            r1.mo25770WE()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.CameraActivityNew.m11982a(int, int, boolean, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11983a(int i, TemplateInfo templateInfo) {
        if (templateInfo != null && C4600l.m11739k(getApplicationContext(), true)) {
            if (i == 4) {
                if (C8739i.m25526qq(templateInfo.ttid)) {
                    this.bNP = templateInfo;
                    this.bNG.templateId = templateInfo.ttid;
                    this.bNG.mo32790iE(C7589a.isAdAvailable(this, 19));
                    this.bNG.mo32789a((C7873a) new C7873a() {
                        /* renamed from: cl */
                        public void mo24962cl(boolean z) {
                            if (z) {
                                C7589a.m22358a(CameraActivityNew.this, 19, CameraActivityNew.this);
                                return;
                            }
                            CameraActivityNew.this.m11943TS();
                            C8739i.m25523cC(CameraActivityNew.this.getApplicationContext(), CameraActivityNew.this.bNP.ttid);
                        }
                    });
                    this.bNG.show();
                } else if (C8739i.m25527qr(templateInfo.ttid)) {
                    this.bNP = templateInfo;
                    C4586g.m11710d(this, TemplateRouter.RATE_UNLOCK_REQUEST_CODE, templateInfo.strTitle);
                } else {
                    C8058h aBf = C8049f.aBf();
                    if (aBf != null) {
                        this.bNP = templateInfo;
                        if (aBf.mo33101iL(templateInfo.ttid)) {
                            if (C7680l.aAe().getAdView(this, 37) != null) {
                                aBf.mo33100g(this, 37, templateInfo.ttid);
                            } else {
                                aBf.mo33097b(this, "platinum", C7825a.ALL_TEMPLATE.getId(), "effects", IapRTConstants.REQUEST_CODE_FOR_VIP);
                            }
                        } else if (this.bNP != null) {
                            m11943TS();
                            if (this.bNo != null) {
                                this.bNo.mo25739eX(this.bNP.ttid);
                            }
                        }
                    }
                }
            } else if (C8739i.m25527qr(templateInfo.ttid)) {
                this.bNP = templateInfo;
                C4586g.m11710d(this, TemplateRouter.RATE_UNLOCK_REQUEST_CODE, templateInfo.strTitle);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11992a(MusicDataItem musicDataItem) {
        if (this.bMO != null && this.bNr != null) {
            if (this.bNr.mo25576VK()) {
                List UY = this.bMO.mo25460UY();
                if (UY != null && UY.size() > 0) {
                    this.bOF = (int) (((long) this.bOF) - C5034e.m13252b(this.bOx, (long) (((SaveRequest) UY.get(UY.size() - 1)).endPos - ((SaveRequest) UY.get(0)).startPos)));
                    m11966Tv();
                    this.bNr.mo25575VJ();
                    int UZ = this.bMO.mo25461UZ();
                    for (int i = 0; i < UZ; i++) {
                        this.bNq.mo26195Ym();
                    }
                    this.mClipCount -= UZ;
                    this.mClipCount -= this.bMM.aJD();
                    this.bNo.setClipCount(this.mClipCount, false);
                } else if (this.bMR || this.bMA) {
                    int aJD = this.bMM.aJD();
                    ProjectItem ahP = this.bMM.aHf();
                    if (!(ahP == null || ahP.mProjectDataItem == null || ahP.mProjectDataItem.strExtra == null)) {
                        MusicDataItem fh = C5029a.m13199fh(ahP.mProjectDataItem.strExtra);
                        this.bOF -= fh.currentTimeStamp - fh.startTimeStamp;
                        this.mClipCount -= aJD;
                        this.bNo.setClipCount(this.mClipCount, false);
                        m11966Tv();
                        this.bMA = true;
                    }
                }
            }
            if (getState() == 2) {
                m11955Te();
                m12027cj(true);
            } else if (getState() == 6) {
                m12027cj(true);
            }
            if (this.bNt == null) {
                this.bNt = new MusicDataItem();
            }
            this.bNt.title = musicDataItem.title;
            this.bNt.filePath = musicDataItem.filePath;
            this.bNt.startTimeStamp = musicDataItem.startTimeStamp;
            this.bNt.stopTimeStamp = musicDataItem.stopTimeStamp;
            this.bNt.currentTimeStamp = musicDataItem.currentTimeStamp;
            this.bNr.setTitle(musicDataItem.title);
            this.bNr.mo25581eW(musicDataItem.filePath);
            this.bNr.setRange(musicDataItem.startTimeStamp, musicDataItem.stopTimeStamp);
            this.bNr.seekTo(musicDataItem.currentTimeStamp);
            ArrayList c = C5034e.m13257c(this.bMM);
            this.bOF = C5034e.m13256c(c);
            C5008i.m12937VU().mo25632a(c);
            this.bNo.setClipCount(this.mClipCount, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11993a(TemplateInfo templateInfo) {
        this.bNF.mo25452a(templateInfo, "type_roll");
    }

    /* renamed from: a */
    private void m11994a(boolean z, Parameters parameters) {
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
    private boolean m11995a(Parameters parameters) {
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
    private static boolean m11997a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    /* renamed from: ae */
    private void m12003ae(long j) {
        long j2;
        if (this.bOI) {
            j2 = 524304;
        } else {
            j2 = this.bOJ.mo25516VB().height * 9 == this.bOJ.mo25516VB().width * 16 ? 524296 : 524290;
        }
        this.bOt.mo35196a(getApplicationContext(), j, CameraCodeMgr.isParamBeautyEffectEnable(this.bOz) ? j2 | 33554432 : j2 | 209715200, AppStateModel.getInstance().isInChina());
        this.bNo.setEffectMgr(this.bOt);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004f, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m12013b(int r5, boolean r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.introvd.template.template.g.b r0 = r4.bOt     // Catch:{ all -> 0x0050 }
            if (r0 == 0) goto L_0x004e
            com.introvd.template.sdk.utils.b.g r0 = r4.bMM     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x000a
            goto L_0x004e
        L_0x000a:
            com.introvd.template.template.g.b r0 = r4.bOt     // Catch:{ all -> 0x0050 }
            com.introvd.template.sdk.model.editor.EffectInfoModel r0 = r0.mo35214vh(r5)     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0014
            monitor-exit(r4)
            return
        L_0x0014:
            com.introvd.template.sdk.utils.b.g r1 = r4.bMM     // Catch:{ all -> 0x0050 }
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r1.aHe()     // Catch:{ all -> 0x0050 }
            if (r1 != 0) goto L_0x001e
            monitor-exit(r4)
            return
        L_0x001e:
            java.lang.String r2 = r0.mPath     // Catch:{ all -> 0x0050 }
            long r2 = com.introvd.template.template.p409g.C8759b.m25587jf(r2)     // Catch:{ all -> 0x0050 }
            r1.usedEffectTempId = r2     // Catch:{ all -> 0x0050 }
            int r1 = r4.bOz     // Catch:{ all -> 0x0050 }
            boolean r1 = com.introvd.template.router.camera.CameraCodeMgr.isParamBeautyEffectEnable(r1)     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x0034
            r4.bOA = r5     // Catch:{ all -> 0x0050 }
            r1 = 0
            r4.bOO = r1     // Catch:{ all -> 0x0050 }
            goto L_0x003e
        L_0x0034:
            r4.bOB = r5     // Catch:{ all -> 0x0050 }
            long r1 = r0.mTemplateId     // Catch:{ all -> 0x0050 }
            java.lang.String r1 = com.introvd.template.template.p407e.C8745n.m25556bv(r1)     // Catch:{ all -> 0x0050 }
            r4.bOO = r1     // Catch:{ all -> 0x0050 }
        L_0x003e:
            java.lang.String r0 = r0.mPath     // Catch:{ all -> 0x0050 }
            r4.m12035eN(r0)     // Catch:{ all -> 0x0050 }
            com.introvd.template.camera.b.k r0 = r4.bNo     // Catch:{ all -> 0x0050 }
            r1 = 1
            r0.setEffect(r5, r1, r6, r7)     // Catch:{ all -> 0x0050 }
            r4.m11938TN()     // Catch:{ all -> 0x0050 }
            monitor-exit(r4)
            return
        L_0x004e:
            monitor-exit(r4)
            return
        L_0x0050:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.CameraActivityNew.m12013b(int, boolean, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12016b(TemplateInfo templateInfo) {
        if (templateInfo == null || templateInfo.nState != 1) {
            String str = "";
            if (templateInfo != null) {
                str = C8762d.aMt().mo35225bB(C2575a.m7391rq(templateInfo.ttid));
            }
            m12036eP(str);
            m11946TV();
            if (templateInfo == null && this.bNo != null) {
                this.bNo.mo25734cY(false);
            }
            if (this.bNo != null) {
                this.bNo.mo25729aj(templateInfo != null ? C2575a.m7391rq(templateInfo.ttid) : 0);
                return;
            }
            return;
        }
        this.bNF.mo25453c(templateInfo);
        this.bNo.mo25738d(templateInfo);
    }

    /* renamed from: bR */
    private void m12018bR(int i, int i2) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("adjustPreviewLayout outputsize height: ");
        sb.append(i2);
        sb.append(" width: ");
        sb.append(i);
        LogUtils.m14223i(str, sb.toString());
        LayoutParams layoutParams = (LayoutParams) this.bMj.getLayoutParams();
        if (i2 == i) {
            if (C5034e.m13264s(this, true) || this.bNz != 0) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = C5034e.m13265t(this, true) + getResources().getDimensionPixelSize(R.dimen.v4_xiaoying_com_top_panel_height);
            }
            layoutParams.width = this.bLT.width;
            layoutParams.height = layoutParams.width;
        } else if (i2 > i) {
            if (Math.abs(((((float) i) * 1.0f) / ((float) i2)) - 0.75f) <= 0.05f) {
                layoutParams.width = this.bLT.width;
                layoutParams.height = (this.bLT.width * i2) / i;
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
            } else if (i2 * i < 230400) {
                layoutParams.topMargin = 0;
                layoutParams.width = this.bLT.width;
                layoutParams.height = (layoutParams.width * i2) / i;
            } else if ((this.bLT.width * i2) / i >= this.bLT.height) {
                layoutParams.topMargin = (this.bLT.height - ((this.bLT.width * i2) / i)) / 2;
                layoutParams.bottomMargin = layoutParams.topMargin;
                layoutParams.width = this.bLT.width;
                layoutParams.height = (layoutParams.width * i2) / i;
            } else {
                layoutParams.topMargin = 0;
                layoutParams.height = this.bLT.height;
                layoutParams.width = (layoutParams.height * i) / i2;
            }
        }
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("params.topMargin: ");
        sb2.append(layoutParams.topMargin);
        LogUtils.m14223i(str2, sb2.toString());
        String str3 = TAG;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("params.width: ");
        sb3.append(layoutParams.width);
        LogUtils.m14223i(str3, sb3.toString());
        String str4 = TAG;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("params.height: ");
        sb4.append(layoutParams.height);
        LogUtils.m14223i(str4, sb4.toString());
        this.bMj.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: bS */
    public void m12019bS(int i, int i2) {
        if (this.bNu != null) {
            this.bNu.mo25479Vk();
        }
        if (CameraCodeMgr.isParamMVEnable(i2)) {
            this.bOx = 1.0f;
        }
        boolean z = false;
        if (!(this.bOy == i && this.bOz == i2)) {
            if (i == 0) {
                m11982a(this.bOy, i2, false, 0);
            } else {
                m11982a(i, i2, false, 0);
            }
        }
        if (!CameraCodeMgr.isCameraParamDefault(this.bMD) || (CameraCodeMgr.isCameraParamDefault(this.bMD) && !CameraCodeMgr.isCameraParamDefault(i2))) {
            z = true;
        }
        if (z && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(39, 500);
        }
    }

    /* renamed from: c */
    private long m12021c(float f, int i) {
        return f <= 0.0f ? (long) i : (long) (((float) i) / f);
    }

    /* access modifiers changed from: private */
    /* renamed from: cg */
    public boolean m12024cg(boolean z) {
        if (this.bMM == null) {
            return true;
        }
        if (this.bLX) {
            String l = CameraCodeMgr.isParamBeautyEffectEnable(this.bOz) ? C8762d.aMt().mo35241l(this.bOt.mo35215vi(this.bOA), 4) : C8762d.aMt().mo35241l(this.bOt.mo35215vi(this.bOB), 4);
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                ArrayList X = C8540q.m24915X(this.bMM.aHd());
                C5031c.m13227m(getApplicationContext(), X.size() > 0);
                String str = "";
                if (!(this.bNr == null || this.bNr.mo25577VL() == null)) {
                    str = this.bNr.mo25577VL().title;
                }
                String str2 = str;
                StringBuilder sb = new StringBuilder();
                if (X.size() > 0) {
                    Iterator it = X.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        if (sb.length() > 0) {
                            sb.append("/");
                        }
                        sb.append(str3);
                    }
                }
                C5031c.m13207a(getApplicationContext(), this.bOy, aHe.iPrjDuration, this.bOz, this.bOJ.mo25515VA(), l, this.bOx, str2, sb.toString());
                if (this.todoParamModel == null || this.todoParamModel.getActivityFlag() <= 0 || this.todoParamModel.isEnterPreview()) {
                    C4905b.m12546fR(10);
                    boolean bi = C8446b.aIZ().mo34322bi(aHe._id);
                    String passThroughUrlFromIntent = PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent());
                    if (bi) {
                        EditorRouter.launchEditorPreviewActivity((Activity) this, C3742b.m9111II().mo23139JG(), passThroughUrlFromIntent);
                    } else {
                        EditorRouter.launchEditorActivity((Activity) this, passThroughUrlFromIntent);
                    }
                } else {
                    FuncExportRouter.launchFuncExportActivity(this, this.todoParamModel);
                }
            }
            if (CameraCodeMgr.isCameraParamPerfect(this.bOz)) {
                C5031c.m13228n(getApplicationContext(), this.bNr != null && this.bNr.mo25576VK());
                QStoryboard aHd = this.bMM.aHd();
                if (aHd != null) {
                    for (int i = 0; i < aHd.getClipCount(); i++) {
                        String t = C8540q.m24972t(this.bMM.aHd().getClip(i));
                        if (t != null) {
                            C5031c.m13212ah(getApplicationContext(), this.bOt.mo35209qD(t));
                        }
                    }
                }
            }
        } else if (z) {
            DataItemProject aHe2 = this.bMM.aHe();
            String str4 = null;
            if (!(aHe2 == null || aHe2.strPrjURL == null)) {
                str4 = aHe2.strPrjURL;
            }
            if (str4 != null) {
                File file = new File(C8572y.m25097ou(str4));
                String[] list = file.list();
                if (list == null || list.length == 0) {
                    file.delete();
                }
            }
        }
        if (this.bMb) {
            StudioRouter.launchStudioActivity(this);
        } else if (!this.bOH && !this.bLX && this.bMa && (this.bMA || this.bMM.aJJ() || (this.bMJ == 1 && this.mClipCount != 0))) {
            StudioRouter.launchStudioActivity(this);
        }
        return true;
    }

    /* renamed from: ch */
    private void m12025ch(boolean z) {
        if (this.bMi == null) {
            if (!z) {
                mo25824Ur();
                LogUtils.m14222e(TAG, "========= doReleaseEginge done ==========");
            } else {
                this.bMi = new Thread(new Runnable() {
                    public void run() {
                        Process.setThreadPriority(1);
                        try {
                            CameraActivityNew.this.mo25824Ur();
                            if (CameraActivityNew.this.mHandler != null) {
                                CameraActivityNew.this.mHandler.sendEmptyMessage(1281);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        LogUtils.m14222e(CameraActivityNew.TAG, "========= doAsyncReleaseEginge done ==========");
                    }
                });
                this.bMi.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ci */
    public void m12026ci(boolean z) {
        setState(5);
        this.bOG = true;
        this.bOJ.mo25539cB(z);
        if (z) {
            m11958Th();
        }
        m11924SY();
        this.bOD = 0;
        this.bOM = 0;
        if (this.bOH) {
            FileUtils.deleteFile(this.bMd);
        }
        if (this.bMO != null && !this.bOH) {
            if (CameraCodeMgr.isParamMVEnable(this.bMD) && !CameraCodeMgr.isParamMVEnable(this.bOz)) {
                this.bNq.setNewProcess(true);
                this.bNq.mo26200dv(true);
            }
            this.bMO.mo25469cu(this.bMW);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cj */
    public void m12027cj(boolean z) {
        this.bMo = z;
        m11962Tm();
        this.bMo = true;
    }

    /* renamed from: eM */
    private void m12034eM(String str) {
        if (TextUtils.isEmpty(this.bNc)) {
            this.bNc = str;
        }
    }

    /* renamed from: eN */
    private void m12035eN(String str) {
        boolean z = false;
        this.bOC = C8560o.m25040dH(0, C8540q.m24966oP(str));
        C4996f fVar = this.bOJ;
        int i = this.bOC;
        if (this.bNC != null && this.bNC.mo35574qO(str)) {
            z = true;
        }
        fVar.mo25534b(str, i, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: eP */
    public void m12036eP(String str) {
        this.bND = str;
        if (this.bOJ != null) {
            this.bOJ.mo25550eP(str);
        }
    }

    /* access modifiers changed from: private */
    public void exit() {
        int i;
        if (!this.bLV) {
            if (getState() == 2 || getState() == 6) {
                m12027cj(true);
            }
            m12025ch(true);
            if (this.bOH) {
                FileUtils.deleteFile(this.bMd);
            } else {
                if (this.bMO != null) {
                    this.bMO.mo25469cu(this.bMW);
                    this.bMO.mo25459UX();
                }
                m11951Ta();
            }
            this.bMa = true;
            if (this.bNs) {
                if (m11941TQ() != 0) {
                    setResult(0);
                    finish();
                }
                return;
            }
            if (this.bOH || this.mClipCount == 0) {
                i = 1;
            } else {
                i = this.bMM.mo34731a(!this.bMn || this.bLX || this.bMb, this.bOK, this.bLS, true, true, AppStateModel.getInstance().isCommunitySupport(), this.bMM.aHf());
                C4586g.m11704a((Context) this, R.string.xiaoying_str_com_loading, (OnCancelListener) null, false);
            }
            if ((this.bMn || this.bMJ == 1) && this.bMM != null) {
                DataItemProject aHe = this.bMM.aHe();
                if (aHe != null) {
                    C8446b.aIZ().mo34319b(getApplicationContext(), aHe._id, 2);
                    C8446b.aIZ().mo34320b(getApplicationContext(), aHe._id, this.bNc);
                }
            }
            if (i != 0) {
                m12024cg(true);
                finish();
            }
        }
    }

    /* renamed from: i */
    private void m12047i(final View view, boolean z) {
        if (view != null && view.getVisibility() != 0) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) (-view.getHeight()), 0.0f}).setDuration(300)});
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        view.setVisibility(0);
                    }
                });
                animatorSet.start();
            } else {
                view.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: iA */
    public int m12048iA(int i) {
        int i2 = i % 360;
        if (Build.MODEL.equals("HTC ChaCha A810e")) {
            i2 = (i + 90) % 360;
        }
        return i2 == 90 ? CameraCodeMgr.FLAG_CAMERA_MODE_LANDSCAPE_RIGHT : i2 == 270 ? 512 : 256;
    }

    /* access modifiers changed from: private */
    /* renamed from: iB */
    public void m12049iB(int i) {
        if (this.bOJ != null) {
            this.bOJ.mo25544cG(false);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int VH = this.bOJ.mo25522VH();
            int VE = this.bOJ.mo25519VE();
            int VF = this.bOJ.mo25520VF();
            int i2 = VE | VF;
            switch (i) {
                case 1:
                    if (i2 != 1 && i2 != 2) {
                        VH = (VH + QDisplayContext.DISPLAY_ROTATION_270) % 360;
                        break;
                    } else {
                        VH = (VH + 90) % 360;
                        break;
                    }
                case 2:
                    if (i2 != 1 && i2 != 2) {
                        VH = (VH + 90) % 360;
                        break;
                    } else {
                        VH = (VH + QDisplayContext.DISPLAY_ROTATION_270) % 360;
                        break;
                    }
                case 3:
                    if (VE != 1) {
                        VE = 1;
                        break;
                    } else {
                        VE = 0;
                        break;
                    }
                case 4:
                    if (VF != 2) {
                        VF = 2;
                        break;
                    } else {
                        VF = 0;
                        break;
                    }
            }
            this.bOJ.mo25558iY(VE);
            this.bOJ.mo25559iZ(VF);
            this.bOJ.mo25563jc(VH);
            if (CameraCodeMgr.isLandScapeMode(this.bOy)) {
                if (!(this.bOJ == null || this.bOF != 0 || getState() == 2)) {
                    this.bOJ.mo25569x(m11936TL(), this.bNz, this.bOz);
                }
            } else if (this.bOy == 256 && this.bOJ != null) {
                this.bOJ.mo25569x(90, this.bNz, this.bOz);
            }
            this.bOJ.mo25557iX(this.bNz);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: iC */
    public void m12050iC(int i) {
        if (this.bMM != null) {
            long b = C5034e.m13252b(this.bOx, (long) (i - this.bOD));
            if (this.bMM.aHd() != null) {
                long j = ((long) this.bOF) + b;
                this.bNo.setTimeExceed(new C9006a(null, (int) j, this.bMV).aNp());
                if (this.bOJ.getState() == 2) {
                    this.bNo.setCurrentTimeValue(j);
                    this.bNq.setProgress(j);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ix */
    public void m12051ix(int i) {
        try {
            if (!this.bMF) {
                this.bMG = i;
                m11930TE();
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

    /* renamed from: iy */
    private void m12052iy(int i) {
        if (this.bNI != null) {
            this.bNz = this.bNI.getCameraRatio();
            String stickerGroupCode = this.bNI.getStickerGroupCode();
            if (CameraCodeMgr.isCameraParamFB(i) && this.bNo != null && !TextUtils.isEmpty(stickerGroupCode) && C4600l.m11739k(this, true)) {
                this.bNo.mo25728a(true, stickerGroupCode, null);
            }
            if (this.bNo != null) {
                if (this.bNI.isNeedOpenFilter() == 1) {
                    this.bNo.mo25732cW(true);
                } else if (this.bNI.isNeedOpenFilter() == 2) {
                    int cametaFilterUpCount = this.bNI.getCametaFilterUpCount();
                    if (cametaFilterUpCount > 0) {
                        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                        StringBuilder sb = new StringBuilder();
                        sb.append("prefer_filter_roll_up_count");
                        sb.append(i);
                        sb.append(this.bNI.getCameraFilterRollCode());
                        int appSettingInt = instance.getAppSettingInt(sb.toString(), -1);
                        if (appSettingInt == -1 || appSettingInt > 0) {
                            AppPreferencesSetting instance2 = AppPreferencesSetting.getInstance();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("prefer_filter_roll_up_count");
                            sb2.append(i);
                            sb2.append(this.bNI.getCameraFilterRollCode());
                            instance2.setAppSettingInt(sb2.toString(), appSettingInt == -1 ? cametaFilterUpCount - 1 : appSettingInt - 1);
                            this.bNJ = this.bNI.getCameraFilterRollCode();
                            if (this.bNJ != null) {
                                C8937c cVar = this.bNC;
                                if (C8937c.m26270qR(this.bNJ) == 2) {
                                    List qQ = this.bNC.mo35576qQ(this.bNJ);
                                    if (qQ != null && qQ.size() > 0) {
                                        this.bNK = this.bOt.mo35205bx(((Long) qQ.get(0)).longValue());
                                    }
                                } else {
                                    this.bNo.mo25741g(true, this.bNJ);
                                }
                            }
                        }
                    }
                }
            }
            int cameraDurLimit = this.bNI.getCameraDurLimit();
            int durationLimit = C5008i.m12937VU().getDurationLimit();
            if (cameraDurLimit <= durationLimit) {
                cameraDurLimit = durationLimit;
            }
            if (cameraDurLimit > 2000) {
                C5008i.m12937VU().setDurationLimit(cameraDurLimit);
                this.bNq.setProcessLimit((long) cameraDurLimit);
                this.bNq.setVisibility(0);
                this.bNq.setSegListener(new C5176a() {
                    /* renamed from: Ub */
                    public void mo24957Ub() {
                        C5008i.m12937VU().mo25635cK(true);
                        CameraActivityNew.this.m11921SV();
                        CameraActivityNew.this.bLS.sendMessage(CameraActivityNew.this.bLS.obtainMessage(4101));
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: iz */
    public int m12053iz(int i) {
        if (90 == i) {
            return QDisplayContext.DISPLAY_ROTATION_270;
        }
        if (270 == i) {
            return 90;
        }
        return i;
    }

    /* renamed from: j */
    private void m12055j(final View view, boolean z) {
        if (view != null && view.getVisibility() != 8) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, (float) (-view.getHeight())}).setDuration(300)});
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        if (!CameraActivityNew.this.isFinishing() && view != null) {
                            view.setVisibility(8);
                        }
                    }
                });
                animatorSet.start();
            } else {
                view.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m12058l(boolean z, boolean z2) {
        long j;
        LogUtils.m14223i("TAG", "notifyDataUpdate run");
        if (this.bMM != null) {
            QStoryboard aHd = this.bMM.aHd();
            if (aHd != null) {
                j = C8762d.aMt().getTemplateID((String) aHd.getProperty(16391));
            } else {
                j = 0;
            }
            if (z) {
                m11965Tu();
            }
            m12003ae(j);
            if (this.bNo != null) {
                if (z2) {
                    this.bNo.mo25718WA();
                } else {
                    this.bNo.mo25736cm(true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onConnected() {
        if (this.bOL) {
            this.ajR = true;
            m12025ch(false);
        } else if (this.bOJ.mo25524Vx() == null || this.bOJ.mo25524Vx().getCamera() == null || this.bOJ.mo25525Vy() == null) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_cam_cannot_connect_camera_tip, 1);
            exit();
        } else {
            LogUtils.m14223i("CameraKKKKK", "*******************Camera Connected*******************");
            this.ajR = true;
            if (!this.bLW) {
                m11959Tj();
            } else {
                m11960Tk();
            }
            this.bON.mo25784jr(4);
            if (CameraCodeMgr.isLandScapeMode(this.bOy)) {
                if (this.bOJ != null) {
                    this.bOJ.mo25569x(m11936TL(), this.bNz, this.bOz);
                }
            } else if (this.bOy == 256 && this.bOJ != null) {
                if (!"MIX 2".equals(Build.MODEL) || this.bMq != 180) {
                    this.bOJ.mo25569x(90, this.bNz, this.bOz);
                } else {
                    this.bOJ.mo25569x(QDisplayContext.DISPLAY_ROTATION_270, this.bNz, this.bOz);
                }
            }
            if (this.bNa) {
                m11937TM();
            }
        }
    }

    private void setState(int i) {
        this.bOJ.setState(i);
        this.bNo.setState(i, this.bOJ.mo25515VA());
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("mState == ");
        sb.append(i);
        LogUtils.m14223i(str, sb.toString());
    }

    private void startPreview() {
        if (!this.bLV && !isFinishing() && this.bLW && getState() != 1) {
            this.bOJ.mo25556h(true ^ CameraCodeMgr.isCameraParamFB(this.bOz), this.bNz);
            this.bOJ.mo25557iX(this.bNz);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: SZ */
    public void mo24895SZ() {
        LogUtils.m14223i("CameraKKKKK", "-------- doOnResume Start------");
        m11938TN();
        C8345d.m24060R(getApplication(), "AppIsBusy", String.valueOf(true));
        m11940TP();
        C4597i.m11729b(true, this);
        this.bOG = true;
        C8553i.setContext(getApplicationContext());
        C8553i.m25005ut(55);
        QStoryboard aHd = this.bMM.aHd();
        long templateID = aHd != null ? C8762d.aMt().getTemplateID((String) aHd.getProperty(16391)) : 0;
        m11965Tu();
        m12003ae(templateID);
        if (this.bNo != null) {
            this.bNo.mo25736cm(false);
        }
        long j = this.bMM.aHe() != null ? this.bMM.aHe().usedEffectTempId : 0;
        int bx = j != 0 ? this.bOt.mo35205bx(j) : 0;
        if (bx == -1 && C8759b.m25586by(j) == null) {
            bx = 0;
        }
        if (CameraCodeMgr.isParamBeautyEffectEnable(this.bOz)) {
            this.bOA = bx;
        } else {
            this.bOB = bx;
        }
        if (this.bNo != null) {
            this.bNo.onResume();
        }
        if (this.bMO == null) {
            this.bMO = new C4991c(getApplicationContext());
        }
        this.bMO.mo25458UW();
        if (this.ajC != null) {
            this.ajC.setReferenceCounted(false);
            this.ajC.acquire();
        }
        this.bMG = 0;
        this.bLV = false;
        this.bOL = false;
        connect();
        if (this.bON != null) {
            this.bON.mo25772WI();
        }
        C7591a.m22377kg("拍摄");
        LogUtils.m14223i("CameraKKKKK", "-------- doOnResume End------");
    }

    /* renamed from: Tp */
    public void mo24897Tp() {
        if (!(this.bLR == 1 || this.bOJ == null || this.bOJ.mo25525Vy() == null)) {
            try {
                this.bOJ.mo25525Vy().autoFocus(this.bNx);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

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

    /* renamed from: a */
    public boolean mo24904a(C5039g gVar) {
        return true;
    }

    /* renamed from: b */
    public boolean mo24905b(C5039g gVar) {
        int i;
        Parameters VC = this.bOJ.mo25517VC();
        if (VC == null || !VC.isZoomSupported() || VC.getZoomRatios() == null) {
            return false;
        }
        float currentSpan = gVar.getCurrentSpan() - this.bMg;
        if (currentSpan > 10.0f) {
            this.bMg = gVar.getCurrentSpan();
            i = 1;
        } else if (currentSpan >= -10.0f) {
            return true;
        } else {
            this.bMg = gVar.getCurrentSpan();
            i = -1;
        }
        this.mHandler.removeMessages(3);
        if (Math.abs(currentSpan) > 1.07374182E9f) {
            return true;
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
        return true;
    }

    /* renamed from: c */
    public void mo24906c(C5039g gVar) {
        this.bMg = 2.14748365E9f;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bOG || !this.ajR || motionEvent == null) {
            return true;
        }
        if (C5008i.m12937VU().mo25612VY()) {
            this.bNo.mo25750p(motionEvent);
            return true;
        } else if (C5008i.m12937VU().mo25608Ul()) {
            this.bNo.mo25750p(motionEvent);
            return true;
        } else {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public boolean isResponseTodoProcess() {
        return false;
    }

    /* renamed from: k */
    public void mo24934k(boolean z, boolean z2) {
        if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                this.bMM.mo34734a(getContentResolver(), aHe.strPrjURL, z ? 3 : 0, z2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24580) {
            m12058l(true, false);
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("template_path");
                if (!TextUtils.isEmpty(stringExtra)) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.bOt.getCount()) {
                            i3 = 0;
                            break;
                        }
                        EffectInfoModel vh = this.bOt.mo35214vh(i3);
                        if (vh != null && vh.mPath.equals(stringExtra)) {
                            break;
                        }
                        i3++;
                    }
                    m12013b(i3, true, false);
                }
            } else {
                long j = (this.bMM == null || this.bMM.aHe() == null) ? 0 : this.bMM.aHe().usedEffectTempId;
                int bx = j != 0 ? this.bOt.mo35205bx(j) : 0;
                if (bx == -1 && C8759b.m25586by(j) == null) {
                    bx = 0;
                }
                if (CameraCodeMgr.isParamBeautyEffectEnable(this.bOz)) {
                    this.bOA = bx;
                } else {
                    this.bOB = bx;
                }
                m12013b(bx, true, false);
            }
            if (this.bNo != null) {
                this.bNo.mo25732cW(true);
            }
        } else if (i == 4369) {
            if (this.bNP != null) {
                C8739i.m25523cC(this, this.bNP.ttid);
                this.bNo.mo25739eX(this.bNP.ttid);
                m11943TS();
                ToastUtils.show((Context) this, getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get), 1);
            }
            if (this.bNo != null) {
                this.bNo.mo25732cW(true);
            }
        } else if (i == 9527) {
            if (i2 == -1) {
                m11943TS();
                if (this.bNo != null) {
                    this.bNo.mo25739eX(this.bNP.ttid);
                }
            }
            if (this.bNo != null) {
                this.bNo.mo25732cW(true);
            }
        }
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        C8553i.setContext(getApplicationContext());
        C8553i.m25005ut(55);
        this.bMM = C8522g.aJA();
        this.bMM.init(this);
        C5008i.m12937VU().init();
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C8739i.m25524ho(VivaBaseApplication.m8749FZ());
            }

            public void onError(Throwable th) {
            }
        });
        this.bNd = (CameraIntentInfo) PassThoughUrlGenerator.getInfoFromIntent(getIntent(), CameraIntentInfo.class);
        this.todoParamModel = (TODOParamModel) PassThoughUrlGenerator.getInfoFromIntent(getIntent(), TODOParamModel.class);
        if (this.bNd != null) {
            this.bMw = this.bNd.magicCode;
            this.bMJ = this.bNd.newPrj;
            this.bLR = this.bNd.cameraAdjustMode;
            this.bMy = this.bNd.activityID;
            C5008i.m12937VU().mo25652jg(this.bNd.captureMode);
        } else {
            this.bNd = new Builder().build();
        }
        this.bNz = m11978a(this.bNd);
        this.bNx = new C4646a(this);
        this.bLQ = Camera.getNumberOfCameras();
        AppPreferencesSetting.getInstance().setAppSettingInt("pref_view_camera_count", this.bLQ);
        this.ajC = ((PowerManager) getSystemService("power")).newWakeLock(26, getClass().getName());
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
                C5523b.logException(e);
                return;
            }
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("MagicCode:");
        sb.append(this.bMw);
        LogUtils.m14223i(str, sb.toString());
        this.bOK = C8501a.aJs();
        this.bOJ = new C4996f(this, this.bOK.aJv(), true);
        this.bNu = new C4994d(this.bOJ);
        this.bLP = new C5032d();
        this.bMO = new C4991c(getApplicationContext());
        this.bLS = new C4647b(this);
        this.mHandler = new C4649d(this);
        this.bOJ.mo25529a(this.bNe);
        this.bOJ.setCallbackHandler(this.bLS);
        this.bMV = C12177i.f6158n;
        this.bNb = (C5530d) MagicCode.getMagicParam(this.bMw, "AppRunningMode", new C5530d());
        this.bMr = this.bNb.cnU == 11;
        this.bMs = this.bNb.cnX;
        this.bON = new C5016m("auto");
        this.bOt = new C8759b(4);
        this.bNr = new C4999g(false);
        this.bNr.mo25580a((C5004b) new C5005c() {
            /* renamed from: Oy */
            public void mo24954Oy() {
                C5198c.m14174dx(false);
                CameraActivityNew.this.m11921SV();
                CameraActivityNew.this.bLS.sendMessage(CameraActivityNew.this.bLS.obtainMessage(4101));
            }

            /* renamed from: iD */
            public void mo24955iD(int i) {
                if (CameraCodeMgr.isParamMVEnable(CameraActivityNew.this.bOz) && CameraActivityNew.this.bNo != null) {
                    CameraActivityNew.this.bNo.mo25743iF(i);
                }
            }
        });
        this.bMf = new C5041h(getResources());
        C8536m.m24783a(getApplicationContext(), BitmapFactory.decodeResource(getResources(), R.drawable.xiaoying_ve_clip_no_content));
        if (this.todoParamModel != null) {
            if (this.todoParamModel.getActivityFlag() > 0) {
                this.bLR = this.todoParamModel.getCameraId();
                Long k = C8555k.m25011k(this.todoParamModel.getJsonObj());
                if (k.longValue() > 0) {
                    String bB = C8762d.aMt().mo35225bB(k.longValue());
                    if (!TextUtils.isEmpty(bB)) {
                        Message obtainMessage = this.mHandler.obtainMessage(1025);
                        obtainMessage.obj = bB;
                        this.mHandler.sendMessageDelayed(obtainMessage, 1000);
                    }
                }
            } else {
                this.bNI = new CameraTodoParam(this.todoParamModel);
                this.bLR = this.bNI.getCameraId();
            }
        }
        if (VERSION.SDK_INT >= 21) {
            this.bLT = C5034e.m13249af(this);
        } else {
            this.bLT = DeviceInfo.getScreenSize(this);
        }
        this.bOG = true;
        LogUtils.m14223i(TAG, "onCreate <---");
        setContentView(R.layout.cam_act_main_new);
        this.mClipCount = C5034e.m13251b(this.bMM);
        C5008i.m12937VU().mo25655jj(this.mClipCount);
        m11939TO();
        this.bMj = (RelativeLayout) findViewById(R.id.cam_layout_preview);
        this.bMk = (RelativeLayout) findViewById(R.id.cam_layout_surfaceview);
        this.bNp = (CameraRotateTipView) findViewById(R.id.camera_rotate_tip_view);
        this.bOJ.mo25536c(this.bMk);
        this.bNo.setClipCount(this.mClipCount, true);
        m11940TP();
        m11933TI();
        m11968Tx();
        connect();
        this.aML = new GestureDetector(getApplicationContext(), this);
        this.bMm = new C5039g(getApplicationContext(), this);
        this.bOF = this.bMn ? 0 : C5034e.m13259d(this.bMM);
        m11931TG();
        m11966Tv();
        if (this.bOy == 256) {
            this.bNv = 0;
        } else if (this.bOy == 512) {
            this.bNv = QDisplayContext.DISPLAY_ROTATION_270;
        } else if (this.bOy == 768) {
            this.bNv = 90;
        }
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_mode", false);
        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_help_new_video_count", 0);
        if (!appSettingBoolean && this.bMn && this.bMB != 4098 && this.bMB != 4102 && appSettingInt >= 2 && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(37, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
        if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_duration", false) && this.bMn && this.bMB != 4098 && this.bMB != 4102 && appSettingInt >= 3 && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(48, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
        C7680l.aAe().mo32526aj(this, 19);
        C7593c.m22383b("camera_filter", C7594d.dMB, new String[0]);
        this.bNG = new C7870d(this);
        this.bNF = new C4988a(getApplicationContext(), this.bNQ);
        LogUtilsV2.m14230i("onCreate --->");
        C5031c.m13221ap(getApplicationContext(), C5034e.m13236S(this, this.bOz));
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                CameraActivityNew.this.m11932TH();
            }
        }, 500);
        if (this.bMn) {
            PreferUtils.addCamEnterCount();
        }
        if (!AppPreferencesSetting.getInstance().getAppSettingBoolean(CameraRouter.KEY_PREFER_HAS_ENTER_CAMERA, false)) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean(CameraRouter.KEY_PREFER_HAS_ENTER_CAMERA, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C3574d.m8800ey("Camera");
        m11963To();
        if (this.bLS != null) {
            this.bLS.removeCallbacksAndMessages(null);
            this.bLS = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bNq != null) {
            this.bNq.mo26197Yo();
        }
        this.aML = null;
        this.bMm = null;
        if (this.bON != null) {
            this.bON.mo25769WD();
            this.bON = null;
        }
        if (this.bNr != null) {
            this.bNr.mo25574VI();
        }
        if (this.bNF != null) {
            this.bNF.release();
        }
        if (!this.bOH && (!AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_mode", false) || !AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_duration", false) || !AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_delete", false)) && this.mClipCount > 0 && this.bMn && this.bMB != 4098 && this.bMB != 4102) {
            AppPreferencesSetting.getInstance().setAppSettingInt("pref_help_new_video_count", AppPreferencesSetting.getInstance().getAppSettingInt("pref_help_new_video_count", 0) + 1);
        }
        m11952Tb();
        if (this.bOJ != null) {
            this.bOJ.mo25518VD();
        }
        if (this.bMf != null) {
            this.bMf.release();
            this.bMf = null;
        }
        this.bNx = null;
        this.bNe = null;
        this.bLP = null;
        this.bOJ = null;
        if (this.bNo != null) {
            this.bNo.onDestroy();
            this.bNo = null;
        }
        this.bMO = null;
        this.bMi = null;
        this.bON = null;
        this.bNr = null;
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
        QComUtils.resetInstanceMembers(this);
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

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        if (r9 > -800.0f) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0072, code lost:
        if (r9 < -800.0f) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007d, code lost:
        if (r10 < -800.0f) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0089, code lost:
        if (r9 < -800.0f) goto L_0x0079;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onFling(android.view.MotionEvent r7, android.view.MotionEvent r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1
            if (r7 == 0) goto L_0x00a4
            if (r8 != 0) goto L_0x0007
            goto L_0x00a4
        L_0x0007:
            int r8 = r6.getState()
            r1 = 2
            r2 = 0
            if (r8 != r1) goto L_0x0010
            return r2
        L_0x0010:
            int[] r8 = new int[r1]
            android.widget.RelativeLayout r1 = r6.bMj
            if (r1 == 0) goto L_0x0039
            android.widget.RelativeLayout r1 = r6.bMj
            r1.getLocationOnScreen(r8)
            float r1 = r7.getY()
            r3 = r8[r0]
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0038
            float r7 = r7.getY()
            r8 = r8[r0]
            android.widget.RelativeLayout r1 = r6.bMj
            int r1 = r1.getHeight()
            int r8 = r8 + r1
            float r8 = (float) r8
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x0039
        L_0x0038:
            return r0
        L_0x0039:
            int r7 = r6.bOz
            boolean r7 = com.introvd.template.router.camera.CameraCodeMgr.isParamBeautyEffectEnable(r7)
            if (r7 == 0) goto L_0x0044
            int r7 = r6.bOA
            goto L_0x0046
        L_0x0044:
            int r7 = r6.bOB
        L_0x0046:
            com.introvd.template.template.g.b r8 = r6.bOt
            long r7 = r8.mo35215vi(r7)
            int r1 = r6.bOw
            r3 = -1001914368(0xffffffffc4480000, float:-800.0)
            r4 = 1145569280(0x44480000, float:800.0)
            if (r1 == 0) goto L_0x0080
            r5 = 90
            if (r1 == r5) goto L_0x0075
            r10 = 180(0xb4, float:2.52E-43)
            if (r1 == r10) goto L_0x006b
            r10 = 270(0x10e, float:3.78E-43)
            if (r1 == r10) goto L_0x0061
            goto L_0x008c
        L_0x0061:
            int r10 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r10 >= 0) goto L_0x0066
            goto L_0x0084
        L_0x0066:
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 <= 0) goto L_0x008c
            goto L_0x0079
        L_0x006b:
            int r10 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x0070
            goto L_0x0079
        L_0x0070:
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x008c
            goto L_0x0084
        L_0x0075:
            int r9 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x007b
        L_0x0079:
            r9 = 1
            goto L_0x008d
        L_0x007b:
            int r9 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x008c
            goto L_0x0084
        L_0x0080:
            int r10 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x0087
        L_0x0084:
            r9 = 1
            r10 = 0
            goto L_0x008e
        L_0x0087:
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x008c
            goto L_0x0079
        L_0x008c:
            r9 = 0
        L_0x008d:
            r10 = 1
        L_0x008e:
            if (r9 == 0) goto L_0x00a3
            com.introvd.template.template.widget.a.c r9 = r6.bNC
            java.lang.Long r7 = r9.mo35572e(r7, r10)
            com.introvd.template.template.g.b r8 = r6.bOt
            long r9 = r7.longValue()
            int r7 = r8.mo35205bx(r9)
            r6.m12013b(r7, r0, r0)
        L_0x00a3:
            return r2
        L_0x00a4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.CameraActivityNew.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 24:
                if (!CameraCodeMgr.isParamMVEnable(this.bOz)) {
                    this.mHandler.removeMessages(3);
                    Message obtainMessage = this.mHandler.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.arg1 = 1;
                    this.mHandler.sendMessage(obtainMessage);
                    return true;
                }
                break;
            case 25:
                if (!CameraCodeMgr.isParamMVEnable(this.bOz)) {
                    this.mHandler.removeMessages(3);
                    Message obtainMessage2 = this.mHandler.obtainMessage();
                    obtainMessage2.what = 3;
                    obtainMessage2.arg1 = -1;
                    this.mHandler.sendMessage(obtainMessage2);
                    return true;
                }
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.bOG || !this.ajR) {
            return true;
        }
        if (i != 4) {
            switch (i) {
                case 24:
                    if (!CameraCodeMgr.isParamMVEnable(this.bOz)) {
                        return C4580b.m11632Sf() ? true : true;
                    }
                    break;
                case 25:
                    if (!CameraCodeMgr.isParamMVEnable(this.bOz)) {
                        return C4580b.m11632Sf() ? true : true;
                    }
                    break;
            }
            return super.onKeyUp(i, keyEvent);
        } else if (C5008i.m12937VU().mo25612VY()) {
            this.bNo.mo25715Un();
            return true;
        } else if (this.bNo.mo25713Ul()) {
            this.bNo.mo25710SY();
            return true;
        } else {
            if (this.bNo.mo25720Wn()) {
                this.bNo.mo25733cX(false);
            } else if (this.bNo.mo25721Ws()) {
                this.bNo.mo25722Wt();
            } else if (!this.bNo.mo25717Uq() && getState() != 2 && m11942TR()) {
                return true;
            }
            return true;
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getTitle().equals(getString(R.string.xiaoying_str_cam_pref_setting_adjust_camera_title))) {
            m11921SV();
            if (this.bNn != 2 && getState() == 1 && !this.bOG) {
                this.bNn = this.bLR;
                m11948TX();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        LogUtils.m14223i("CameraKKKKK", "-------- OnPause Start------");
        C7680l.aAf().mo32495iu(false);
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_flash_mode", "no_flash");
        if ("off".equals(appSettingStr) || "on".equals(appSettingStr)) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_flash_mode", "off");
        }
        AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", "unlock");
        if (isFinishing()) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_grid", "off");
            C4586g.m11696Sm();
        }
        this.bLV = true;
        if (this.ajC != null && this.ajC.isHeld()) {
            try {
                this.ajC.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.bNo != null) {
            this.bNo.onPause();
        }
        if (this.bON != null) {
            this.bON.mo25773WJ();
        }
        if (CameraCodeMgr.isParamMVEnable(this.bOz)) {
            this.bNq.setNewProcess(true);
            this.bNq.mo26200dv(true);
        }
        m11921SV();
        if (this.bMO != null) {
            if (!this.bOH) {
                this.bMO.mo25469cu(this.bMW);
            }
            this.bMO.mo25459UX();
        }
        m11924SY();
        m11963To();
        m12025ch(isFinishing());
        this.ajR = false;
        if (this.mHandler != null) {
            this.mHandler.removeMessages(2);
        }
        if (!this.bMa) {
            ProjectItem ahP = this.bMM.aHf();
            if (!(ahP == null || ahP.mStoryBoard == null || ahP.mStoryBoard.getClipCount() <= 0)) {
                this.bMM.mo34731a(false, this.bOK, this.bLS, false, true, AppStateModel.getInstance().isCommunitySupport(), ahP);
            }
            if (this.bMn && ahP != null) {
                DataItemProject aHe = this.bMM.aHe();
                if (aHe != null) {
                    C8446b.aIZ().mo34319b(getApplicationContext(), aHe._id, 2);
                    C8446b.aIZ().mo34320b(getApplicationContext(), ahP.mProjectDataItem._id, this.bNc);
                }
            }
            m11951Ta();
        }
        super.onPause();
        this.bOL = true;
        C5036f.hide();
        C8345d.m24060R(getApplication(), "AppIsBusy", String.valueOf(false));
        setState(-1);
        UserBehaviorLog.onPause(this);
        C4597i.m11729b(false, this);
        LogUtils.m14223i("CameraKKKKK", "-------- OnPause End------");
        C7680l.aAe().releasePosition(19, false);
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z && i != this.bNN) {
            this.mHandler.removeMessages(3);
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.arg1 = i > this.bNN ? 1 : -1;
            obtainMessage.arg2 = i - this.bNN;
            this.mHandler.sendMessage(obtainMessage);
        }
        this.bNN = i;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        C7680l.aAf().mo32495iu(true);
        super.onResume();
        C3574d.m8799e("Camera", this.bfB);
        this.bfB = 0;
        C7680l.aAe().mo32531h(19, this);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public void onShowVideoAd(AdPositionInfoParam adPositionInfoParam, boolean z) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (getState() == 2) {
            return true;
        }
        if (motionEvent == null) {
            return false;
        }
        if (this.bMj == null || this.bNO) {
            return true;
        }
        if (this.bNo != null && this.bNo.mo25750p(motionEvent)) {
            return true;
        }
        int[] iArr = new int[2];
        this.bMj.getLocationOnScreen(iArr);
        if (this.bMj != null && motionEvent.getY() < ((float) iArr[1]) && motionEvent.getY() > ((float) (iArr[1] + this.bMj.getHeight()))) {
            return true;
        }
        if (this.bLR != 1 || this.bNo == null) {
            if (getState() == 1 || getState() == 6) {
                motionEvent.setAction(1);
                if (motionEvent.getX() < ((float) this.bMj.getLeft()) || motionEvent.getY() < ((float) this.bMj.getTop()) || motionEvent.getX() > ((float) (this.bMj.getLeft() + this.bMj.getWidth())) || motionEvent.getY() > ((float) (this.bMj.getTop() + this.bMj.getHeight()))) {
                    return false;
                }
                this.bNo.mo25714Um();
                this.mHandler.removeMessages(771);
                this.bMu = true;
                this.bON.mo25787q(motionEvent);
            }
            return true;
        }
        this.bNo.mo25714Um();
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.bNO = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.bNO = false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bMm != null) {
            this.bMm.mo25894s(motionEvent);
        }
        return this.aML != null ? this.aML.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }
}
