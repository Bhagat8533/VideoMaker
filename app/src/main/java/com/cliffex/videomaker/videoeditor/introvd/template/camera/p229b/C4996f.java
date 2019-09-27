package com.introvd.template.camera.p229b;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.sdk.p381b.C8392b;
import com.introvd.template.sdk.p381b.C8393c;
import com.introvd.template.sdk.p381b.p382a.C8384a.C8385a;
import com.introvd.template.sdk.p381b.p382a.C8387c;
import com.introvd.template.sdk.p381b.p382a.C8387c.C8388a;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.vivacamera.R;
import com.mediarecorder.engine.QCameraComdef;
import com.mediarecorder.engine.QFilterParam;
import com.mediarecorder.engine.QPIPFrameParam;
import com.mediarecorder.engine.QPIPSource;
import com.mediarecorder.engine.QPIPSourceMode;
import com.mediarecorder.engine.QRecorderStatus;
import com.mediarecorder.engine.basicdef.QExpressionPasterStatus;
import com.p131c.p132a.p135c.C2575a;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import lib.C12177i;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.player.QPlayer;
import xiaoying.utils.WorkThreadTaskItem;

/* renamed from: com.introvd.template.camera.b.f */
public class C4996f {
    private static int bPI = 640;
    private static int bPJ = 480;
    private int bLR = 0;
    /* access modifiers changed from: private */
    public Handler bLS;
    private MSize bLU = new MSize(bPI, bPJ);
    private boolean bLW = false;
    private RelativeLayout bMj;
    private C8388a bNe = null;
    /* access modifiers changed from: private */
    public C4998a bPG;
    private long bPH = 0;
    private VeMSize bPK = new VeMSize(800, 480);
    private boolean bPL = true;
    private C8392b bPM;
    private C8387c bPN;
    /* access modifiers changed from: private */
    public boolean bPO = false;
    /* access modifiers changed from: private */
    public SurfaceView bPP;
    /* access modifiers changed from: private */
    public SurfaceView bPQ;
    private Parameters bPR;
    private QEngine bPS;
    /* access modifiers changed from: private */
    public int bPT = 1;
    /* access modifiers changed from: private */
    public int bPU = 2;
    private int bPV = 4;
    private int bPW = ((this.bPT | this.bPU) | this.bPV);
    /* access modifiers changed from: private */
    public int bPX = 0;
    /* access modifiers changed from: private */
    public long bPY = 0;
    /* access modifiers changed from: private */
    public boolean bPZ = false;
    private boolean bQa = false;
    private boolean bQb;
    private Callback bQc = new Callback() {
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder.getSurface() == null) {
                LogUtils.m14221d("CameraModel", "holder.getSurface() == null");
            } else if (C4996f.this.bPP == null || !C4996f.this.bPP.getHolder().equals(surfaceHolder)) {
                StringBuilder sb = new StringBuilder();
                sb.append("surfaceChanged <--- width =");
                sb.append(i2);
                sb.append(". height =");
                sb.append(i3);
                LogUtils.m14223i("CameraModel", sb.toString());
                if (C4996f.this.bPQ instanceof SurfaceView) {
                    C4996f.this.bPQ.setZOrderMediaOverlay(true);
                }
                C4996f.this.bPO = true;
                C4996f.this.bPX = C4996f.this.bPX | C4996f.this.bPT;
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            C4996f.this.bPO = false;
        }
    };
    private MSize bQd = new MSize(bPI, bPJ);
    /* access modifiers changed from: private */
    public WeakReference<Activity> bwg;
    private int mState = -1;

    /* renamed from: com.introvd.template.camera.b.f$a */
    private static class C4998a extends WeakHandler<C4996f> {
        public C4998a(C4996f fVar) {
            super(fVar);
        }

        public void handleMessage(Message message) {
            C4996f fVar = (C4996f) getOwner();
            if (fVar != null) {
                Activity activity = (Activity) fVar.bwg.get();
                if (activity != null) {
                    boolean z = true;
                    switch (message.what) {
                        case 4097:
                            if (message.arg2 != 100) {
                                if (!fVar.m12845cw(false)) {
                                    removeMessages(4097);
                                    sendEmptyMessageDelayed(4097, 50);
                                    break;
                                }
                            } else {
                                if (!fVar.m12851g(false, message.arg1)) {
                                    removeMessages(4097);
                                    sendMessageDelayed(obtainMessage(4097, message.arg1, 100), 50);
                                }
                                return;
                            }
                            break;
                        case 4098:
                            if (message.obj != null) {
                                C5031c.m13208a(activity.getApplicationContext(), (MSize) message.obj);
                                break;
                            }
                            break;
                        case QCameraComdef.EVENT_CAPTURE_DONE /*536870913*/:
                            fVar.bLS.sendMessage(fVar.bLS.obtainMessage(32771, message.obj));
                            break;
                        case QCameraComdef.EVENT_OPERATION_DONE /*536870914*/:
                            int i = message.arg1;
                            if (i == 6) {
                                if ((message.obj instanceof WorkThreadTaskItem) && !((WorkThreadTaskItem) message.obj).isSyncTask()) {
                                    fVar.setState(1);
                                    fVar.bLS.sendMessage(fVar.bLS.obtainMessage(32773));
                                    break;
                                }
                            } else {
                                switch (i) {
                                    case 1:
                                        if (message.arg2 == 0) {
                                            fVar.m12831Vz();
                                            fVar.bPX = fVar.bPX | fVar.bPU;
                                            break;
                                        } else {
                                            LogUtils.m14223i("CameraKKKKK", "--------!!!CameraModel TASK_TYPE_CONNECT Error!!!------");
                                            fVar.bPZ = false;
                                            ToastUtils.show((Context) activity, R.string.xiaoying_str_cam_cannot_connect_camera_tip, 1);
                                            activity.finish();
                                            return;
                                        }
                                    case 2:
                                        fVar.bPX = fVar.bPX & (~fVar.bPU);
                                        fVar.bPG.removeMessages(4097);
                                        fVar.bLS.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                                        break;
                                    case 3:
                                        LogUtils.m14223i("OPERATION", "TASK_TYPE_STARTPREVIEW");
                                        fVar.bLS.sendEmptyMessageDelayed(QPlayer.PROP_PLAYER_SEEK_DIR, 100);
                                        break;
                                    case 4:
                                        fVar.bLS.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                                        LogUtils.m14223i("OPERATION", "TASK_TYPE_STOPPREVIEW");
                                        break;
                                }
                            }
                            break;
                        case QCameraComdef.EVENT_PIP_SRCOBJ_END /*536883205*/:
                            fVar.bLS.sendEmptyMessage(32777);
                            break;
                        case QCameraComdef.EVENT_NO_FACE_DETECTED /*536883209*/:
                            LogUtils.m14223i("CameraModel", "===CameraEnginEvent 没有检测到人脸");
                            fVar.bLS.sendMessage(fVar.bLS.obtainMessage(32778, Integer.valueOf(1)));
                            break;
                        case QCameraComdef.EVENT_FACE_DETECED /*536883210*/:
                            LogUtils.m14223i("CameraModel", "===CameraEnginEvent 检测到人脸");
                            fVar.bLS.sendMessage(fVar.bLS.obtainMessage(32778, Integer.valueOf(0)));
                            break;
                        case QCameraComdef.EVENT_EXPRESSION_PASTER_DISPLAY_STATUS_CHANGE /*536883211*/:
                            if (message.obj != null && (message.obj instanceof QExpressionPasterStatus)) {
                                QExpressionPasterStatus qExpressionPasterStatus = (QExpressionPasterStatus) message.obj;
                                StringBuilder sb = new StringBuilder();
                                sb.append("PASTER_DISPLAY_STATUS_CHANGE Status=");
                                sb.append(qExpressionPasterStatus.status);
                                LogUtils.m14223i("CameraModel", sb.toString());
                                Message obtainMessage = fVar.bLS.obtainMessage();
                                obtainMessage.what = 32780;
                                if (qExpressionPasterStatus.status != 1) {
                                    z = false;
                                }
                                obtainMessage.obj = Boolean.valueOf(z);
                                fVar.bLS.sendMessage(obtainMessage);
                                break;
                            }
                        case QCameraComdef.EVENT_RECORDER_READY /*553648129*/:
                            fVar.bLS.sendMessage(fVar.bLS.obtainMessage(QPlayer.PROP_PLAYER_PREVIEW_FPS));
                            break;
                        case QCameraComdef.EVENT_RECORDER_RUNNING /*553648130*/:
                            if (System.currentTimeMillis() - fVar.bPY > 20) {
                                fVar.bLS.sendMessage(fVar.bLS.obtainMessage(32776, (int) ((long) message.arg1), 0));
                                fVar.bPY = System.currentTimeMillis();
                                break;
                            }
                            break;
                        case QCameraComdef.EVENT_RECORDER_PAUSED /*553648131*/:
                            fVar.bLS.sendEmptyMessage(32779);
                            break;
                        case QCameraComdef.EVENT_RECORDER_SIZE_EXCEEDED /*553652224*/:
                            LogUtils.m14223i("CameraModel", "EVENT_RECORDER_SIZE_EXCEEDED");
                            fVar.bLS.sendMessage(fVar.bLS.obtainMessage(32781));
                            break;
                        case QCameraComdef.EVENT_RECORDER_DURATION_EXCEEDED /*553652225*/:
                            LogUtils.m14223i("CameraModel", "EVENT_RECORDER_DURATION_EXCEEDED");
                            fVar.bLS.sendEmptyMessage(32775);
                            break;
                    }
                }
            }
        }
    }

    public C4996f(Activity activity, QEngine qEngine, boolean z) {
        this.bwg = new WeakReference<>(activity);
        this.bPS = qEngine;
        this.bQb = z;
        this.bPK.width = Constants.getScreenSize().width;
        this.bPK.height = Constants.getScreenSize().height;
        this.bPG = new C4998a(this);
        if (z) {
            bPI = 960;
            bPJ = 544;
            this.bLU = new MSize(bPI, bPJ);
            this.bQd = new MSize(bPI, bPJ);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Vz */
    public synchronized boolean m12831Vz() {
        LogUtils.m14223i("CameraModel", "onConnected<---");
        if (this.bPN == null) {
            return false;
        }
        Camera camera = (Camera) this.bPN.getCamera();
        if (camera == null) {
            return false;
        }
        if (this.bPM == null) {
            this.bPM = C8392b.aHk();
        }
        if (this.bPM != null) {
            this.bPM.mo33943a(camera);
            this.bPR = this.bPM.getParameters();
        }
        this.bLS.sendEmptyMessage(QPlayer.PROP_PLAYER_RANGE);
        this.bPZ = false;
        LogUtils.m14223i("CameraModel", "onConnected--->");
        return true;
    }

    /* renamed from: X */
    private boolean m12832X(String str, String str2) {
        return (str.equalsIgnoreCase("on") || str.equalsIgnoreCase("torch")) && (str2.equalsIgnoreCase("on") || str2.equalsIgnoreCase("torch"));
    }

    /* renamed from: a */
    private MSize m12836a(MSize mSize, int i) {
        int i2;
        int i3;
        MSize mSize2 = new MSize();
        mSize2.width = mSize.width;
        mSize2.height = mSize.height;
        if (i == 0) {
            int min = Math.min(mSize.width, mSize.height);
            mSize2.width = min;
            mSize2.height = min;
        } else if (i == 1) {
            if (mSize.width > mSize.height) {
                int i4 = mSize.width;
                i2 = C8572y.m25087dI((int) ((((float) mSize.width) / 4.0f) * 3.0f), 16);
                i3 = i4;
            } else {
                i2 = mSize.height;
                i3 = C8572y.m25087dI((int) ((((float) mSize.height) / 4.0f) * 3.0f), 16);
            }
            mSize2.width = i3;
            mSize2.height = i2;
        } else if (i == 2) {
            mSize2.width = mSize.width;
            mSize2.height = mSize.height;
        }
        return mSize2;
    }

    /* renamed from: a */
    private MSize m12837a(C8385a aVar, boolean z, int i) {
        int i2 = this.bLU.width;
        int i3 = this.bLU.height;
        StringBuilder sb = new StringBuilder();
        sb.append("nPreviewH height: ");
        sb.append(i3);
        sb.append(" nPreviewW: ");
        sb.append(i2);
        LogUtils.m14223i("CameraModel", sb.toString());
        MSize a = m12836a(C5034e.m13245a(new MSize(i2, i3), this.bPL, z), i);
        this.bQd = a;
        aVar.set("out-video-width", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(a.width)}));
        aVar.set("out-video-height", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(a.height)}));
        return a;
    }

    /* renamed from: a */
    private void m12838a(C8385a aVar, boolean z, boolean z2) {
        int i = this.bLU.width;
        int i2 = this.bLU.height;
        StringBuilder sb = new StringBuilder();
        sb.append("nPreviewH height: ");
        sb.append(i2);
        sb.append(" nPreviewW: ");
        sb.append(i);
        LogUtils.m14223i("CameraModel", sb.toString());
        MSize a = C5034e.m13243a(C5034e.getCpuNumber(), new MSize(i, i2), this.bPL, z, z2);
        if (this.bwg.get() != null) {
            C5031c.m13208a(((Activity) this.bwg.get()).getApplicationContext(), a);
        }
        this.bQd = a;
        aVar.set("out-video-width", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(a.width)}));
        aVar.set("out-video-height", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(a.height)}));
    }

    /* access modifiers changed from: private */
    /* renamed from: cw */
    public boolean m12845cw(boolean z) {
        boolean z2 = false;
        if (!this.bPO || !this.bLW || this.bPQ == null || (this.bPX & this.bPW) != this.bPW) {
            return false;
        }
        if (!(this.bPN == null || getState() == 1)) {
            LogUtils.m14223i("CameraModel", "startPreview<---");
            if (this.bLR != 0) {
                z2 = true;
            }
            mo25547cx(z2);
            this.bPN.mo33932jc(z);
            LogUtils.m14223i("CameraModel", "startPreview--->");
            setState(1);
        }
        return true;
    }

    /* renamed from: eT */
    private boolean m12848eT(String str) {
        boolean a = C8450a.m24462a(C8501a.aJs().aJv(), Long.valueOf(C8762d.aMt().getTemplateID(str)).longValue(), "should_set_orient_angle");
        if (!a) {
            for (long a2 : C8450a.m24476nZ(str)) {
                a = C8450a.m24462a(C8501a.aJs().aJv(), a2, "should_set_orient_angle");
                if (a) {
                    break;
                }
            }
        }
        return a;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m12851g(boolean z, int i) {
        if (!this.bPO || !this.bLW || this.bPQ == null || (this.bPX & this.bPW) != this.bPW) {
            return false;
        }
        if (!(this.bPN == null || getState() == 1)) {
            LogUtils.m14223i("CameraModel", "startPreview<---");
            mo25556h(this.bQa, i);
            this.bPN.mo33939t(z, i);
            LogUtils.m14223i("CameraModel", "startPreview--->");
            setState(1);
        }
        return true;
    }

    /* renamed from: Ur */
    public void mo25514Ur() {
        this.bPX &= ~this.bPU;
        if (this.bPN != null) {
            try {
                this.bPN.aHw();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.bPN = null;
        }
        if (this.bPM != null) {
            try {
                Camera aHl = this.bPM.aHl();
                if (aHl != null) {
                    aHl.setZoomChangeListener(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.bPM = null;
        }
        setState(-1);
        LogUtils.m14223i("CameraModel", "disConnected--->");
    }

    /* renamed from: VA */
    public MSize mo25515VA() {
        if (this.bPN == null) {
            return null;
        }
        C8385a aHq = this.bPN.aHq();
        if (aHq == null) {
            return null;
        }
        String str = aHq.get("out-video-width");
        String str2 = aHq.get("out-video-height");
        int i = 0;
        int parseInt = TextUtils.isEmpty(str) ? 0 : C2575a.parseInt(str);
        if (!TextUtils.isEmpty(str2)) {
            i = C2575a.parseInt(str2);
        }
        return new MSize(parseInt, i);
    }

    /* renamed from: VB */
    public MSize mo25516VB() {
        return this.bQd;
    }

    /* renamed from: VC */
    public Parameters mo25517VC() {
        if (this.bPM == null) {
            return null;
        }
        return this.bPM.getParameters();
    }

    /* renamed from: VD */
    public void mo25518VD() {
        if (this.bPP != null) {
            this.bPP.setVisibility(8);
            this.bPP = null;
        }
        if (this.bPQ != null) {
            this.bPQ.setVisibility(8);
            this.bPQ = null;
        }
        mo25514Ur();
    }

    /* renamed from: VE */
    public int mo25519VE() {
        if (this.bPN != null) {
            return this.bPN.mo33892VE();
        }
        return 0;
    }

    /* renamed from: VF */
    public int mo25520VF() {
        if (this.bPN != null) {
            return this.bPN.mo33893VF();
        }
        return 0;
    }

    /* renamed from: VG */
    public int mo25521VG() {
        if (this.bPN != null) {
            return this.bPN.mo33911VG();
        }
        return 0;
    }

    /* renamed from: VH */
    public int mo25522VH() {
        if (this.bPN != null) {
            return this.bPN.mo33894VH();
        }
        return 0;
    }

    /* renamed from: Vw */
    public int mo25523Vw() {
        int i;
        int i2;
        int i3;
        Activity activity = (Activity) this.bwg.get();
        if (activity == null || getState() != -1 || this.bPZ) {
            return -1;
        }
        if (this.bPN == null) {
            CommonConfigure.APP_DEFAULT_AUDIO_SAMPLERATE = C8387c.m24162T(activity.getApplicationContext(), true);
            this.bPN = new C8387c((Activity) this.bwg.get(), this.bLR, this.bQb);
            if (C5034e.m13264s(activity, this.bQb)) {
                this.bPN.mo33941tK(0);
            } else {
                this.bPN.mo33941tK(C5034e.m13265t(activity, this.bQb) + activity.getResources().getDimensionPixelSize(R.dimen.v2_panel_top_height));
            }
            if (this.bLR == 1) {
                i3 = AppPreferencesSetting.getInstance().getAppSettingInt("pref_front_camera_display_offset", 0);
                i2 = AppPreferencesSetting.getInstance().getAppSettingInt("pref_front_camera_display_hormirror", 0);
                i = AppPreferencesSetting.getInstance().getAppSettingInt("pref_front_camera_display_vermirror", 0);
            } else {
                i3 = AppPreferencesSetting.getInstance().getAppSettingInt("pref_back_camera_display_offset", 0);
                i2 = AppPreferencesSetting.getInstance().getAppSettingInt("pref_back_camera_display_hormirror", 0);
                i = AppPreferencesSetting.getInstance().getAppSettingInt("pref_back_camera_display_vermirror", 0);
            }
            this.bPN.mo33904tA(i3);
            this.bPN.mo33901iY(i2);
            this.bPN.mo33902iZ(i);
            this.bPN.mo33921dw(12312, i2 | i);
            if (this.bPG == null) {
                this.bPG = new C4998a(this);
            }
            this.bPN.mo33900b((Handler) this.bPG);
            this.bPN.mo33906tC(activity.getResources().getConfiguration().orientation == 1 ? 90 : 0);
            this.bPN.mo33914a(this.bNe);
            this.bPN.mo33930i(this.bPP, this.bPQ);
        }
        setState(0);
        this.bPX &= ~this.bPU;
        this.bPN.mo33940tJ(this.bLR);
        this.bPZ = true;
        LogUtils.m14222e("CameraKKKKK", "--------Camera  Engine Connect ------");
        return 0;
    }

    /* renamed from: Vx */
    public C8387c mo25524Vx() {
        return this.bPN;
    }

    /* renamed from: Vy */
    public C8392b mo25525Vy() {
        return this.bPM;
    }

    /* renamed from: a */
    public int mo25526a(int i, QPIPSource qPIPSource) {
        if (this.bPN == null) {
            return -1;
        }
        return this.bPN.mo33912a(i, qPIPSource);
    }

    /* renamed from: a */
    public int mo25527a(QFilterParam qFilterParam) {
        if (this.bPN == null) {
            return -1;
        }
        return this.bPN.mo33913a(qFilterParam, 1);
    }

    /* renamed from: a */
    public void mo25528a(Parameters parameters, String str, String str2) {
        if (parameters != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.equalsIgnoreCase(str2) && !m12832X(str, str2)) {
                str = str2;
            }
            parameters.setFlashMode(str);
        }
    }

    /* renamed from: a */
    public void mo25529a(C8388a aVar) {
        this.bNe = aVar;
    }

    /* renamed from: a */
    public void mo25530a(boolean z, QPIPFrameParam qPIPFrameParam) {
        if (this.bPN != null) {
            this.bPN.mo33917b(z, qPIPFrameParam);
        }
    }

    /* renamed from: a */
    public void mo25531a(boolean z, QPIPSourceMode qPIPSourceMode) {
        if (this.bPN != null) {
            setState(2);
            this.bPN.mo33919d(z, qPIPSourceMode);
        }
    }

    /* renamed from: b */
    public int mo25532b(QPIPFrameParam qPIPFrameParam, int i) {
        if (this.bPN == null) {
            return -1;
        }
        return this.bPN.mo33916b(qPIPFrameParam, i);
    }

    /* renamed from: b */
    public void mo25533b(Parameters parameters) {
        this.bPR = parameters;
        if (this.bPM != null) {
            this.bPM.setParameters(this.bPR);
        }
    }

    /* renamed from: b */
    public void mo25534b(String str, int i, boolean z) {
        if (this.bPN != null) {
            this.bPN.mo33918d(str, i, z);
        }
    }

    /* renamed from: b */
    public void mo25535b(boolean z, QPIPSourceMode qPIPSourceMode) {
        if (this.bPN != null) {
            this.bPN.pauseRecording(z, qPIPSourceMode);
        }
    }

    /* renamed from: c */
    public void mo25536c(RelativeLayout relativeLayout) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.bMj = relativeLayout;
            if (this.bPP == null) {
                this.bPP = new SurfaceView(activity);
                LayoutParams layoutParams = new LayoutParams(1, 1);
                layoutParams.addRule(12);
                this.bPP.setLayoutParams(layoutParams);
                this.bMj.addView(this.bPP, this.bMj.getChildCount());
                SurfaceHolder holder = this.bPP.getHolder();
                holder.addCallback(this.bQc);
                holder.setType(3);
            }
            if (this.bPQ == null) {
                this.bPQ = new SurfaceView(activity);
                LayoutParams layoutParams2 = new LayoutParams(-1, -1);
                layoutParams2.addRule(10);
                this.bPQ.setLayoutParams(layoutParams2);
                this.bMj.addView(this.bPQ, this.bMj.getChildCount());
                SurfaceHolder holder2 = this.bPQ.getHolder();
                holder2.addCallback(this.bQc);
                holder2.setFormat(1);
            }
            if (this.bPN != null) {
                this.bPN.mo33930i(this.bPP, this.bPQ);
            }
        }
    }

    /* renamed from: c */
    public void mo25537c(boolean z, QPIPSourceMode qPIPSourceMode) {
        if (this.bPN != null) {
            setState(2);
            this.bPN.mo33922e(z, qPIPSourceMode);
        }
    }

    /* renamed from: cA */
    public void mo25538cA(boolean z) {
        mo25537c(z, (QPIPSourceMode) null);
    }

    /* renamed from: cB */
    public void mo25539cB(boolean z) {
        if (this.bPN != null) {
            this.bPN.stopRecording(z);
        }
        mo25540cC(false);
    }

    /* renamed from: cC */
    public void mo25540cC(boolean z) {
        if (this.bPM != null) {
            this.bPR = this.bPM.getParameters();
            if (this.bPR != null) {
                if (this.bPR.isAutoExposureLockSupported()) {
                    this.bPR.setAutoExposureLock(z);
                }
                if (this.bPR.isAutoWhiteBalanceLockSupported()) {
                    this.bPR.setAutoWhiteBalanceLock(z);
                }
                if (this.bPM != null) {
                    this.bPM.setParameters(this.bPR);
                }
            }
        }
    }

    /* renamed from: cD */
    public void mo25541cD(boolean z) {
        if (this.bPL != z) {
            this.bPL = z;
            mo25543cF(z);
        }
    }

    /* renamed from: cE */
    public void mo25542cE(boolean z) {
        if (this.bPL == z) {
            StringBuilder sb = new StringBuilder();
            sb.append("=========== same video portrait:");
            sb.append(z);
            LogUtils.m14223i("CameraModel", sb.toString());
            return;
        }
        this.bPL = z;
        mo25543cF(z);
        mo25547cx(this.bLR != 0);
    }

    /* renamed from: cF */
    public void mo25543cF(boolean z) {
        if (this.bPM != null) {
            this.bPR = this.bPM.getParameters();
            if (this.bPR != null) {
                List supportedPreviewSizes = this.bPR.getSupportedPreviewSizes();
                boolean z2 = true;
                if (supportedPreviewSizes != null && supportedPreviewSizes.size() > 1) {
                    for (int size = supportedPreviewSizes.size() - 1; size >= 0; size--) {
                        Size size2 = (Size) supportedPreviewSizes.get(size);
                        if (size2.width < size2.height || size2.width == 0 || size2.height == 0) {
                            supportedPreviewSizes.remove(size);
                        }
                    }
                }
                if (supportedPreviewSizes != null && supportedPreviewSizes.size() > 1) {
                    Collections.sort(supportedPreviewSizes, new C5015l());
                }
                if (!C8393c.m24211a(this.bPK, supportedPreviewSizes, this.bPR, z)) {
                    LogUtils.m14222e("CameraModel", "No supported preview size found");
                } else {
                    z2 = false;
                }
                Size previewSize = this.bPR.getPreviewSize();
                MSize mSize = previewSize == null ? new MSize(bPI, bPJ) : new MSize(previewSize.width, previewSize.height);
                if (mSize.width < mSize.height) {
                    int i = mSize.width;
                    mSize.width = mSize.height;
                    mSize.height = i;
                }
                if (!(this.bLU.width == mSize.width && this.bLU.height == mSize.height && this.bLW)) {
                    this.bLU.width = mSize.width;
                    this.bLU.height = mSize.height;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Preview size is (");
                sb.append(mSize.width);
                sb.append("x");
                sb.append(mSize.height);
                sb.append(")");
                LogUtils.m14222e("CameraModel", sb.toString());
                if (z2 && mSize.width * mSize.height > bPI * bPJ) {
                    mSize.width = bPI;
                    mSize.height = bPJ;
                }
                AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                instance.setAppSettingInt("pref_camera_preview_msize_width", mSize.width);
                instance.setAppSettingInt("pref_camera_preview_msize_height", mSize.height);
                if (this.bPN != null) {
                    int aHr = this.bPN.aHr();
                }
                if (this.bPM != null) {
                    this.bPM.setParameters(this.bPR);
                }
            }
        }
    }

    /* renamed from: cG */
    public void mo25544cG(boolean z) {
        if (this.bPN != null) {
            this.bPN.stopPreview(z);
            setState(0);
        }
    }

    /* renamed from: cH */
    public void mo25545cH(boolean z) {
        if (this.bPM != null) {
            this.bPR = this.bPM.getParameters();
            if (this.bPR != null && this.bPR.getFlashMode() != null) {
                if (z) {
                    if (this.bPR.getFlashMode().equals("on")) {
                        this.bPR.setFlashMode("torch");
                        this.bPM.setParameters(this.bPR);
                    }
                } else if (this.bPR.getFlashMode().equals("torch")) {
                    if ("魅族 M9".equals(Build.MODEL) || "M032".equals(Build.MODEL) || "M031".equals(Build.MODEL) || "M030".equals(Build.MODEL) || "MEIZU MX".equals(Build.MODEL) || "M040".equals(Build.MODEL)) {
                        this.bPR.setFlashMode("off");
                        this.bPM.setParameters(this.bPR);
                    }
                    this.bPR.setFlashMode("on");
                    this.bPM.setParameters(this.bPR);
                }
            }
        }
    }

    /* renamed from: cv */
    public void mo25546cv(boolean z) {
        this.bLW = z;
        if (z) {
            this.bPX |= this.bPV;
        } else {
            this.bPX &= ~this.bPV;
        }
    }

    /* renamed from: cx */
    public void mo25547cx(boolean z) {
        if (((Activity) this.bwg.get()) != null) {
            C8385a aVar = new C8385a();
            aVar.set("audio-codec-type", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(4)}));
            aVar.set("video-codec-type", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(2)}));
            aVar.set("video-bitrate", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(this.bPS != null ? QUtils.caculateVideoBitrate(this.bPS, 2, 15, this.bLU.width, this.bLU.height, 1, C8572y.aJm(), 3) : 0)}));
            aVar.set("video-frame-rate", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(C12177i.f6157m)}));
            aVar.set("preview-width", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(this.bLU.width)}));
            aVar.set("preview-height", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(this.bLU.height)}));
            aVar.set("max-duration", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(0)}));
            String.format(Locale.US, "%d", new Object[]{Integer.valueOf(0)});
            aVar.set("max-filesize", String.valueOf(this.bPH));
            aVar.set("file-type", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(2)}));
            aVar.set("audio-channel-count", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(1)}));
            aVar.set("audio-sampling-rate", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(CommonConfigure.APP_DEFAULT_AUDIO_SAMPLERATE)}));
            aVar.set("audio-bits-persample", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(16)}));
            AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false);
            aVar.set("video-hw-codec", "0");
            m12838a(aVar, z, !this.bQb);
            if (this.bPN != null) {
                this.bPN.mo33895a(aVar);
                this.bPN.mo33903nx("/sdcard/temp.3gp");
                this.bPN.mo33930i(this.bPP, this.bPQ);
            }
        }
    }

    /* renamed from: cy */
    public void mo25548cy(boolean z) {
        mo25531a(z, (QPIPSourceMode) null);
    }

    /* renamed from: cz */
    public void mo25549cz(boolean z) {
        mo25535b(z, (QPIPSourceMode) null);
    }

    /* renamed from: eP */
    public void mo25550eP(String str) {
        if (this.bPN != null) {
            this.bPN.mo33934nz(str);
        }
    }

    /* renamed from: eU */
    public int mo25551eU(String str) {
        if (this.bPN == null) {
            return -1;
        }
        return this.bPN.mo33923eU(str);
    }

    /* renamed from: eV */
    public int mo25552eV(String str) {
        if (this.bPN == null) {
            return -1;
        }
        return this.bPN.mo33924eV(str);
    }

    public int getConfig(int i) {
        if (this.bPN != null) {
            return this.bPN.getConfig(i);
        }
        return 0;
    }

    public int getRecordStatus(QRecorderStatus qRecorderStatus) {
        if (this.bPN != null) {
            return this.bPN.getRecordStatus(qRecorderStatus);
        }
        return -1;
    }

    public int getState() {
        return this.mState;
    }

    /* renamed from: h */
    public void mo25556h(boolean z, int i) {
        boolean z2 = z;
        if (((Activity) this.bwg.get()) != null) {
            this.bQa = z2;
            C8385a aVar = new C8385a();
            aVar.set("audio-codec-type", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(4)}));
            aVar.set("video-codec-type", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(2)}));
            if (this.bLU == null) {
                this.bLU = new MSize((int) QUtils.VIDEO_RES_VGA_WIDTH, 480);
            }
            aVar.set("video-bitrate", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(this.bPS != null ? QUtils.caculateVideoBitrate(this.bPS, 2, 15, this.bLU.width, this.bLU.height, 1, C8572y.aJm(), 3) : 0)}));
            aVar.set("video-frame-rate", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(C12177i.f6157m)}));
            aVar.set("preview-width", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(this.bLU.width)}));
            aVar.set("preview-height", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(this.bLU.height)}));
            aVar.set("max-duration", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(0)}));
            String.format(Locale.US, "%d", new Object[]{Integer.valueOf(0)});
            aVar.set("max-filesize", String.valueOf(this.bPH));
            aVar.set("file-type", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(2)}));
            aVar.set("audio-channel-count", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(1)}));
            aVar.set("audio-sampling-rate", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(CommonConfigure.APP_DEFAULT_AUDIO_SAMPLERATE)}));
            aVar.set("audio-bits-persample", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(16)}));
            AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false);
            aVar.set("video-hw-codec", "0");
            MSize a = m12837a(aVar, z2, i);
            if (this.bPG != null) {
                Message obtainMessage = this.bPG.obtainMessage(4098);
                obtainMessage.obj = a;
                this.bPG.sendMessage(obtainMessage);
            }
            if (this.bPN != null) {
                this.bPN.mo33895a(aVar);
                this.bPN.mo33903nx("/sdcard/temp.3gp");
                this.bPN.mo33930i(this.bPP, this.bPQ);
            }
        }
    }

    /* renamed from: iX */
    public void mo25557iX(int i) {
        if (this.bPQ != null && this.bPG != null && (this.bPX & this.bPU) != 0) {
            this.bPG.removeMessages(4097);
            this.bPG.sendMessageDelayed(this.bPG.obtainMessage(4097, i, 100), 50);
        }
    }

    /* renamed from: iY */
    public void mo25558iY(int i) {
        if (this.bPN != null) {
            this.bPN.mo33901iY(i);
        }
    }

    /* renamed from: iZ */
    public void mo25559iZ(int i) {
        if (this.bPN != null) {
            this.bPN.mo33902iZ(i);
        }
    }

    /* renamed from: j */
    public void mo25560j(int i, String str) {
        if (this.bPN != null && C8450a.m24475nY(str) && m12848eT(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(">>>>>> updateEffectOritation updateEffectParam path=");
            sb.append(str);
            sb.append(";value=");
            sb.append(i);
            LogUtilsV2.m14230i(sb.toString());
            QFilterParam qFilterParam = new QFilterParam();
            qFilterParam.f3421id = 1;
            qFilterParam.value = i;
            this.bPN.mo33913a(qFilterParam, 5);
        }
    }

    /* renamed from: ja */
    public void mo25561ja(int i) {
        this.bLR = i;
    }

    /* renamed from: jb */
    public void mo25562jb(int i) {
        if (this.bPN != null) {
            this.bPN.mo33931jb(i);
        }
    }

    /* renamed from: jc */
    public void mo25563jc(int i) {
        if (this.bPN != null) {
            this.bPN.mo33904tA(i);
        }
    }

    public void setCallbackHandler(Handler handler) {
        this.bLS = handler;
    }

    public void setDeviceOrientation(int i) {
        if (this.bPN != null) {
            this.bPN.mo33905tB(i);
        }
    }

    public void setOutputFile(String str) {
        if (this.bPN != null) {
            this.bPN.mo33903nx(str);
        }
    }

    public void setState(int i) {
        this.mState = i;
        StringBuilder sb = new StringBuilder();
        sb.append("mState == ");
        sb.append(i);
        LogUtils.m14223i("CameraModel", sb.toString());
    }

    public void startPreview() {
        if (this.bPQ != null && this.bPG != null && (this.bPX & this.bPU) != 0) {
            this.bPG.removeMessages(4097);
            this.bPG.sendEmptyMessageDelayed(4097, 50);
        }
    }

    /* renamed from: x */
    public void mo25569x(int i, int i2, int i3) {
        if (this.bPN != null) {
            this.bPN.mo33910K(i, i2, i3);
        }
    }
}
