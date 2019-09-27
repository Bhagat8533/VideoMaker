package com.introvd.template.camera;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.camera.base.CameraActivityBase;
import com.introvd.template.camera.model.SaveRequest;
import com.introvd.template.camera.p229b.C4991c;
import com.introvd.template.camera.p229b.C4996f;
import com.introvd.template.camera.p229b.C4999g;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p232e.C5030b;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p381b.C8393c;
import com.introvd.template.sdk.p381b.C8394d;
import com.introvd.template.sdk.p381b.p382a.C8384a.C8385a;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8555k;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.vivacamera.R;
import com.mediarecorder.engine.QRecorderStatus;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.player.QPlayer;
import xiaoying.utils.QComUtils;

@C1942a(mo10417rZ = "/vivacamera/simulate")
public class SimulateCameraActivity extends CameraActivityBase {
    private WakeLock ajC;
    private int bLR = 1;
    /* access modifiers changed from: private */
    public boolean bLV = false;
    private boolean bLW = false;
    public C8522g bMM = null;
    public C4991c bMO;
    /* access modifiers changed from: private */
    public String bMd;
    private C8394d bMh;
    /* access modifiers changed from: private */
    public Thread bMi = null;
    private String bNc;
    private C4999g bNr;
    private int bNz = 2;
    private C4661a bOg;
    /* access modifiers changed from: private */
    public C1890f bOh;
    private TODOParamModel bOi;
    private String bOj;
    /* access modifiers changed from: private */
    public int bOk;
    private String bOl = "";
    private String bOm = "";
    private String bOn = "";
    /* access modifiers changed from: private */
    public String bOo = "";
    /* access modifiers changed from: private */
    public String bOp = "";
    /* access modifiers changed from: private */
    public boolean bOq;

    /* renamed from: com.introvd.template.camera.SimulateCameraActivity$a */
    public static class C4661a extends WeakHandler<SimulateCameraActivity> {
        public C4661a(SimulateCameraActivity simulateCameraActivity) {
            super(simulateCameraActivity);
        }

        public void handleMessage(Message message) {
            SimulateCameraActivity simulateCameraActivity = (SimulateCameraActivity) getOwner();
            if (simulateCameraActivity == null) {
                LogUtils.m14222e(SimulateCameraActivity.TAG, "theActivity == null");
                return;
            }
            switch (message.what) {
                case 8194:
                    removeMessages(8194);
                    simulateCameraActivity.m12109Ug();
                    break;
                case QPlayer.PROP_PLAYER_RANGE /*32769*/:
                    simulateCameraActivity.onConnected();
                    break;
                case QPlayer.PROP_PLAYER_SEEK_DIR /*32770*/:
                    simulateCameraActivity.m12096Tc();
                    break;
                case 32773:
                    simulateCameraActivity.m12100Th();
                    break;
                case 32776:
                    if (!simulateCameraActivity.bLV) {
                        long j = (long) message.arg1;
                        StringBuilder sb = new StringBuilder();
                        sb.append("-------------recording:");
                        sb.append(j);
                        LogUtils.m14223i("SImuliate", sb.toString());
                        if (j > ((long) simulateCameraActivity.bOk)) {
                            simulateCameraActivity.bOq = true;
                            C5008i.m12937VU().mo25635cK(true);
                            simulateCameraActivity.m12110Uh();
                            AppRouter.startWebPage(simulateCameraActivity, simulateCameraActivity.bOp, "");
                            simulateCameraActivity.finish();
                            break;
                        }
                    }
                    break;
                case 268443653:
                case 268443654:
                case 268443655:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("==========PROJECT_SAVE========");
                    sb2.append(message.what);
                    LogUtils.m14223i("SImuliate", sb2.toString());
                    break;
            }
        }
    }

    /* renamed from: Ta */
    private void m12095Ta() {
        if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                aHe.setCameraPipMode(false);
                aHe.iCameraCode = CameraCodeMgr.getCameraCode(this.bOy, this.bOz);
                aHe.strExtra = C8558m.m25016a(aHe.strExtra, Float.valueOf(this.bOx));
                aHe.strExtra = C8558m.m25022g(aHe.strExtra, this.bNz, this.bOy);
                aHe.strExtra = C5030b.m13204fk(aHe.strExtra);
                int durationLimit = C5008i.m12937VU().getDurationLimit();
                if (durationLimit != 0) {
                    aHe.nDurationLimit = durationLimit + 100;
                } else {
                    aHe.nDurationLimit = 0;
                }
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("dataItemProject.strExtra: ");
                sb.append(aHe.strExtra);
                LogUtils.m14223i(str, sb.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Tc */
    public void m12096Tc() {
        if (!TextUtils.isEmpty(this.bOj)) {
            this.bOJ.mo25550eP(this.bOj);
        }
        if (this.bNr != null && this.bNr.mo25576VK()) {
            this.bNr.play();
        }
        this.bOg.sendEmptyMessageDelayed(8194, 100);
    }

    /* renamed from: Td */
    private void m12097Td() {
        if (!this.bLV && this.bOJ.mo25524Vx() != null) {
            this.bOJ.setState(2);
            this.bOE = 0;
            this.bOD = 0;
            C4582c.m11669dF(this);
            this.bOJ.mo25540cC(SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(this.bMh.getString("pref_aelock_key", "auto")));
            String d = C5034e.m13260d(this, System.currentTimeMillis());
            StringBuilder sb = new StringBuilder();
            sb.append(CommonConfigure.getCameraVideoPath());
            sb.append(d);
            sb.append(".mp4");
            this.bMd = sb.toString();
            this.bOJ.setOutputFile(this.bMd);
            this.bOJ.mo25548cy(false);
        }
    }

    /* renamed from: Te */
    private void m12098Te() {
        this.bOJ.setState(6);
        this.bOJ.mo25549cz(true);
        m12099Tf();
    }

    /* renamed from: Tf */
    private void m12099Tf() {
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
        int i = (saveRequest.endPos - saveRequest.startPos) + (saveRequest.startPos - this.bOM);
        this.bOM = saveRequest.endPos;
        this.bMO.mo25466a(saveRequest);
        this.bOD = this.bOE;
        this.bOF = (int) (((long) this.bOF) + C5034e.m13252b(this.bOx, (long) i));
        this.bNc = "CameraHD";
    }

    /* access modifiers changed from: private */
    /* renamed from: Th */
    public void m12100Th() {
        this.bOJ.setState(1);
    }

    /* renamed from: Tj */
    private void m12101Tj() {
        if (!this.bLW) {
            this.bMh = new C8394d(getApplicationContext(), this.bLR);
            C8393c.m24213d(this.bMh.aHm());
            C8393c.m24212c(this.bMh.aHn());
            m12103Tw();
            this.bLW = true;
            this.bOJ.mo25546cv(true);
            startPreview();
        }
    }

    /* renamed from: Tk */
    private void m12102Tk() {
        if (this.bMh == null) {
            this.bMh = new C8394d(getApplicationContext(), this.bLR);
        }
        C8393c.m24209a(this.bMh, this.bLR);
        C8393c.m24212c(this.bMh.aHn());
        m12103Tw();
        startPreview();
    }

    /* renamed from: Tw */
    private void m12103Tw() {
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
                this.bOJ.mo25533b(VC);
                if (VC.getFlashMode() == null || !VC.getFlashMode().equals("on")) {
                    this.bOJ.mo25545cH(false);
                } else {
                    this.bOJ.mo25545cH(true);
                }
            }
        }
    }

    /* renamed from: Tx */
    private void m12104Tx() {
        this.bMh = new C8394d(getApplicationContext(), this.bLR);
        C8393c.m24213d(this.bMh.aHm());
        this.bOJ.mo25561ja(this.bLR);
    }

    /* renamed from: Uc */
    private void m12105Uc() {
        this.bOi = (TODOParamModel) getIntent().getParcelableExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
        if (this.bOi != null) {
            JSONObject jsonObj = this.bOi.getJsonObj();
            if (jsonObj != null) {
                this.bOl = jsonObj.optString("title");
                this.bOm = jsonObj.optString("nextButtonText");
                this.bOn = jsonObj.optString("closeButtonText");
                this.bOo = jsonObj.optString("nextUrl");
                this.bOp = jsonObj.optString("closeUrl");
            }
            List r = C8555k.m25012r(jsonObj);
            if (r != null && r.size() > 0) {
                long j = ((EffectInfoModel) r.get(0)).mTemplateId;
                C8762d.aMt().mo35219Q(getApplicationContext(), true);
                this.bOj = C8762d.aMt().mo35225bB(j);
                String templateExternalFile = C8762d.aMt().getTemplateExternalFile(j, 0, 1003);
                if (!TextUtils.isEmpty(templateExternalFile)) {
                    if (this.bNr == null) {
                        this.bNr = new C4999g(true);
                    }
                    this.bNr.mo25581eW(templateExternalFile);
                }
            }
            this.bOk = this.bOi.getLimitDuration();
            if (this.bOk <= 0) {
                this.bOk = 10000;
            }
            C5008i.m12937VU().setDurationLimit(this.bOk);
        }
    }

    /* renamed from: Ud */
    private void m12106Ud() {
        findViewById(R.id.termination).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SimulateCameraActivity.this.m12107Ue();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: Ue */
    public void m12107Ue() {
        if (this.bOh == null) {
            this.bOh = C8978m.m26348af(this, this.bOn, this.bOm).mo10315r(this.bOl).mo10290az(false).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (SimulateCameraActivity.this.bOh != null && SimulateCameraActivity.this.bOh.isShowing()) {
                        SimulateCameraActivity.this.bOh.dismiss();
                    }
                    SimulateCameraActivity.this.bOq = true;
                    SimulateCameraActivity.this.m12110Uh();
                    AppRouter.startWebPage(SimulateCameraActivity.this, SimulateCameraActivity.this.bOp, "");
                    SimulateCameraActivity.this.finish();
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (SimulateCameraActivity.this.bOh != null && SimulateCameraActivity.this.bOh.isShowing()) {
                        SimulateCameraActivity.this.bOh.dismiss();
                    }
                    SimulateCameraActivity.this.bOq = true;
                    SimulateCameraActivity.this.mo24972k(true, true);
                    FileUtils.deleteFile(SimulateCameraActivity.this.bMd);
                    AppRouter.startWebPage(SimulateCameraActivity.this, SimulateCameraActivity.this.bOo, "");
                    SimulateCameraActivity.this.finish();
                }
            }).mo10313qu();
        }
        if (!this.bOh.isShowing()) {
            m12098Te();
            if (this.bNr != null && this.bNr.mo25576VK()) {
                this.bNr.pause();
            }
            this.bOh.show();
        }
    }

    /* renamed from: Uf */
    private void m12108Uf() {
        this.bOJ.setState(5);
        this.bOJ.mo25539cB(true);
        m12100Th();
        this.bOD = 0;
        this.bOM = 0;
        if (this.bMO != null) {
            this.bMO.mo25469cu(false);
        }
        if (this.bNr != null && this.bNr.mo25576VK()) {
            this.bNr.pause();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Ug */
    public void m12109Ug() {
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
                    this.bOJ.mo25524Vx().mo33895a(aHq2);
                } else {
                    return;
                }
            }
            m12097Td();
        } else if (this.bOJ.getState() == 2 || this.bOJ.getState() == 6) {
            m12108Uf();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Uh */
    public void m12110Uh() {
        if (getState() == 2) {
            m12098Te();
            m12108Uf();
        } else if (getState() == 6) {
            m12108Uf();
        } else if (this.bMO != null) {
            this.bMO.mo25469cu(false);
        }
        m12117ch(true);
        if (this.bMO != null) {
            this.bMO.mo25459UX();
        }
        if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                this.bMM.mo34774oG(aHe.strPrjURL);
                m12095Ta();
                this.bMM.mo34731a(false, this.bOK, (Handler) this.bOg, true, true, AppStateModel.getInstance().isCommunitySupport(), this.bMM.mo34778uz(this.bMM.ebQ));
                C4586g.m11704a((Context) this, R.string.xiaoying_str_com_loading, (OnCancelListener) null, false);
                C8446b.aIZ().mo34320b(getApplicationContext(), aHe._id, this.bNc);
            }
        }
    }

    /* renamed from: ch */
    private void m12117ch(boolean z) {
        if (this.bMi == null) {
            if (!z) {
                mo25824Ur();
            } else {
                this.bMi = new Thread(new Runnable() {
                    public void run() {
                        if (SimulateCameraActivity.this.bOJ != null) {
                            Process.setThreadPriority(1);
                            try {
                                SimulateCameraActivity.this.mo25824Ur();
                                SimulateCameraActivity.this.bMi = null;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                this.bMi.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public void onConnected() {
        if (this.bOJ.mo25524Vx() == null || this.bOJ.mo25524Vx().getCamera() == null || this.bOJ.mo25525Vy() == null) {
            ToastUtils.longShow((Context) this, R.string.xiaoying_str_cam_cannot_connect_camera_tip);
            finish();
            return;
        }
        if (!this.bLW) {
            m12101Tj();
        } else {
            m12102Tk();
        }
        if (this.bOJ != null) {
            this.bOJ.mo25569x(90, this.bNz, this.bOz);
        }
        this.ajR = !this.bOL;
    }

    private void startPreview() {
        if (!this.bLV && !isFinishing() && this.bLW && getState() != 1) {
            this.bOJ.mo25556h(true, this.bNz);
            this.bOJ.mo25557iX(this.bNz);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: SZ */
    public void mo24895SZ() {
        C8345d.m24060R(getApplication(), "AppIsBusy", String.valueOf(true));
        C4597i.m11729b(true, this);
        if (this.ajC != null) {
            this.ajC.setReferenceCounted(false);
            this.ajC.acquire();
        }
        this.bOL = false;
        if (this.bLV) {
            this.bLV = false;
            if (!this.bOq) {
                AppRouter.startWebPage(this, "https://hybrid.xiaoying.tv/web/vivaVideo/180707/index.html#/Page4", "");
                finish();
            }
        }
    }

    /* renamed from: k */
    public void mo24972k(boolean z, boolean z2) {
        if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                this.bMM.mo34734a(getContentResolver(), aHe.strPrjURL, z ? 3 : 0, z2);
            }
        }
    }

    public void onBackPressed() {
        m12107Ue();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        C8553i.setContext(getApplicationContext());
        C8553i.m25005ut(55);
        this.bMM = C8522g.aJA();
        if (this.bMM == null) {
            finish();
            return;
        }
        this.bMM.init(this);
        C5008i.m12937VU().init();
        this.ajC = ((PowerManager) getSystemService("power")).newWakeLock(26, getClass().getName());
        m12105Uc();
        this.bOK = C8501a.aJs();
        this.bOJ = new C4996f(this, this.bOK.aJv(), true);
        this.bMO = new C4991c(getApplicationContext());
        this.bMO.mo25458UW();
        this.bOg = new C4661a(this);
        this.bOJ.setCallbackHandler(this.bOg);
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        String[] strArr = {"", ""};
        if (iEditorService != null) {
            strArr = iEditorService.getCommonBehaviorParam();
        }
        this.bMM.mo34756b(getApplicationContext(), this.bOg, false, strArr[0], strArr[1]);
        setVolumeControlStream(3);
        setContentView(R.layout.cam_act_simulate_camera);
        this.bOJ.mo25536c((RelativeLayout) findViewById(R.id.surface_layout));
        m12106Ud();
        m12104Tx();
        connect();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.bNr != null) {
            this.bNr.mo25574VI();
        }
        if (this.bOh != null && this.bOh.isShowing()) {
            this.bOh.dismiss();
        }
        if (this.bOg != null) {
            this.bOg.removeCallbacksAndMessages(null);
            this.bOg = null;
        }
        if (this.bOJ != null) {
            this.bOJ.mo25518VD();
            this.bOJ = null;
        }
        QComUtils.resetInstanceMembers(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.ajC != null && this.ajC.isHeld()) {
            try {
                this.ajC.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        m12108Uf();
        this.bLV = true;
        m12117ch(true);
        if (this.bMO != null) {
            this.bMO.mo25459UX();
        }
        this.bOJ.setState(-1);
        C8345d.m24060R(getApplication(), "AppIsBusy", String.valueOf(false));
        this.ajR = false;
        this.bOL = true;
        super.onPause();
        C4586g.m11696Sm();
        this.bOJ.setState(-1);
        C4597i.m11729b(false, this);
        if (!this.bOq) {
            mo24972k(true, true);
            FileUtils.deleteFile(this.bMd);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.bfB = 0;
    }
}
