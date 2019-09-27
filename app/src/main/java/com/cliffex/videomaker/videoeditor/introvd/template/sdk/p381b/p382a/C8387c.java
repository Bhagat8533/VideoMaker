package com.introvd.template.sdk.p381b.p382a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.C8379a;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.p381b.p382a.C8384a.C8385a;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p393a.C8497f;
import com.introvd.template.sdk.utils.p394b.C8521f;
import com.mediarecorder.engine.CapturePicture.CapturePictureCallback;
import com.mediarecorder.engine.QBaseCamEngine;
import com.mediarecorder.engine.QCamEffect;
import com.mediarecorder.engine.QCamEffectUpdateItem;
import com.mediarecorder.engine.QCameraComdef;
import com.mediarecorder.engine.QCameraConnectParam;
import com.mediarecorder.engine.QCameraDisplayParam;
import com.mediarecorder.engine.QCameraExportParam;
import com.mediarecorder.engine.QCameraUtils;
import com.mediarecorder.engine.QFilterParam;
import com.mediarecorder.engine.QPIPFrameParam;
import com.mediarecorder.engine.QPIPSource;
import com.mediarecorder.engine.QPIPSourceMode;
import com.mediarecorder.engine.QRecorderStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import lib.C12177i;
import xiaoying.engine.base.IQTemplateAdapter;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QUtils;
import xiaoying.platform.QAudioIn;
import xiaoying.utils.QRect;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.sdk.b.a.c */
public final class C8387c extends C8384a implements OnErrorListener, CapturePictureCallback {
    private String LOG_TAG = "MediaRecorderEngine";
    private IQTemplateAdapter bPy = new C8521f();
    private Context bbr;
    private int ecA = -1;
    private QBaseCamEngine ecB;
    /* access modifiers changed from: private */
    public int ecC;
    private ReentrantLock ecD;
    private CameraInfo ecE;
    private Point ecF;
    private QAudioIn ecG;
    public C8388a ecH;
    private int ecI;
    private int ecJ;
    private Point ecK;
    private C8390c ecL;
    /* access modifiers changed from: private */
    public boolean ecM;
    private volatile boolean ecN;
    private int ecq = -1;
    private int ecr = -1;
    private int ecs = 0;
    private int ect = 0;
    private boolean ecu = false;
    private int ecv = 0;
    private boolean ecw = false;
    private QCameraDisplayParam ecx;
    private List<QCamEffect> ecy = new ArrayList();
    private int ecz = 0;

    /* renamed from: com.introvd.template.sdk.b.a.c$a */
    public interface C8388a {
        /* renamed from: a */
        void mo24924a(CameraInfo cameraInfo);

        /* renamed from: a */
        void mo24925a(C8389b bVar, CameraInfo cameraInfo);
    }

    /* renamed from: com.introvd.template.sdk.b.a.c$b */
    public static class C8389b {
        public int ecO;
        public int ecP;
        public int ecQ;
    }

    /* renamed from: com.introvd.template.sdk.b.a.c$c */
    private static class C8390c extends C8497f<C8387c> {
        public C8390c(C8387c cVar) {
            super(cVar);
        }

        public void handleMessage(Message message) {
            C8387c cVar = (C8387c) getOwner();
            if (cVar != null) {
                boolean z = true;
                if (message.what == 4097) {
                    if (message.arg1 == 0) {
                        z = false;
                    }
                    cVar.m24173je(z);
                    if (message.arg1 != 0) {
                        sendMessageDelayed(obtainMessage(4097, 0, 0), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                    return;
                }
                if (message.what == 536870914) {
                    if (message.arg2 == 0 && message.arg1 == 1) {
                        if (cVar.ecC == 0 || cVar.ecC == 1) {
                            cVar.m24175tE(cVar.ecC);
                            if (cVar.ecM) {
                                cVar.ecM = false;
                                sendMessageDelayed(obtainMessage(4097, 1, 0), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                            }
                        }
                    } else if (message.arg1 != 5) {
                        int i = message.arg1;
                    }
                }
                if (cVar.mEventHandler != null) {
                    cVar.mEventHandler.sendMessage(cVar.mEventHandler.obtainMessage(message.what, message.arg1, message.arg2, message.obj));
                }
            }
        }
    }

    /* renamed from: com.introvd.template.sdk.b.a.c$d */
    public static class C8391d {
        public Bitmap bitmap;
        public String ecR;
    }

    public C8387c(Activity activity, int i, boolean z) {
        Application application = null;
        this.ecB = null;
        this.ecC = -1;
        this.ecD = new ReentrantLock();
        this.ecE = new CameraInfo();
        this.ecF = new Point(QUtils.VIDEO_RES_VGA_WIDTH, 480);
        this.ecG = null;
        this.ecH = null;
        this.ecI = 0;
        this.ecJ = 0;
        this.ecK = new Point(QUtils.VIDEO_RES_VGA_WIDTH, 480);
        this.ecL = null;
        this.ecM = true;
        this.ecN = false;
        this.ecC = i;
        if (activity != null) {
            application = activity.getApplication();
        }
        this.bbr = application;
        if (z) {
            aHv();
        } else {
            init();
        }
    }

    /* renamed from: T */
    public static int m24162T(Context context, boolean z) {
        C8379a aGZ = C8410e.aGX().aGZ();
        int i = 0;
        int i2 = aGZ.getInt("pref_record_samplerate", 0);
        if (i2 != 0) {
            return i2;
        }
        int[] iArr = {22050, 16000};
        int i3 = 16000;
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            int length = iArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                int i4 = iArr[i];
                if (m24174tD(i4)) {
                    i3 = i4;
                    break;
                }
                i++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getValidAudioSampleRate:");
            sb.append(i3);
            sb.append(", cost:");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            C8554j.m25007e("MediaRecorderEngine", sb.toString());
            aGZ.setInt("pref_record_samplerate", i3);
        }
        return i3;
    }

    /* renamed from: a */
    private int m24164a(QCamEffect qCamEffect) {
        int i = -1;
        if (this.ecN) {
            return -1;
        }
        QCamEffect[] qCamEffectArr = {qCamEffect};
        if (this.ecB != null) {
            i = this.ecB.setEffect(false, qCamEffectArr);
        }
        return i;
    }

    /* renamed from: a */
    private int m24165a(QCamEffectUpdateItem qCamEffectUpdateItem) {
        if (this.ecN) {
            return -1;
        }
        return this.ecB.updateEffect(true, new QCamEffectUpdateItem[]{qCamEffectUpdateItem});
    }

    /* renamed from: a */
    public static QRect m24166a(QRect qRect, QSize qSize, int i, int i2) {
        if (qRect == null || qSize.mWidth * qSize.mHeight == 0) {
            return null;
        }
        QRect qRect2 = new QRect();
        QSize qSize2 = new QSize();
        qSize2.mHeight = qRect.bottom - qRect.top;
        qSize2.mWidth = qRect.right - qRect.left;
        int i3 = (qSize.mHeight - i2) - qSize2.mHeight;
        int i4 = (i + qSize.mWidth) - qSize2.mWidth;
        qRect2.left = i4;
        qRect2.right = i4 + qSize2.mWidth;
        qRect2.top = i3;
        qRect2.bottom = i3 + qSize2.mHeight;
        return qRect2;
    }

    private int aHA() {
        return (this.ecl + this.ecn) % 360;
    }

    private void aHB() {
        this.ecz = 0;
    }

    private synchronized void aHv() {
        if (this.ecB == null) {
            QAudioIn.setRecFlag(0);
            try {
                if (C8549f.aJd()) {
                    this.ecB = QCameraUtils.CreateCamEngine(3);
                } else {
                    this.ecB = QCameraUtils.CreateCamEngine(2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ecL = new C8390c(this);
        }
        this.ecF = new Point(960, 544);
        this.ecK = new Point(960, 544);
    }

    private QCameraDisplayParam aHx() {
        int i;
        switch (m24176tF(this.ecm % 360)) {
            case 1:
            case 2:
                i = 0;
                break;
            case 3:
            case 4:
                i = 2;
                break;
            default:
                return null;
        }
        return m24178tH(i);
    }

    private QCameraDisplayParam aHy() {
        int i;
        switch (m24176tF(this.ecm % 360)) {
            case 1:
            case 2:
                i = 0;
                break;
            case 3:
            case 4:
                i = 2;
                break;
            default:
                return null;
        }
        return m24178tH(i);
    }

    private QCameraExportParam aHz() {
        QCameraExportParam qCameraExportParam = new QCameraExportParam();
        qCameraExportParam.videoCodecType = this.eci.getInt("video-codec-type");
        qCameraExportParam.audioCodecType = this.eci.getInt("audio-codec-type");
        qCameraExportParam.videoFPS = this.eci.getInt("video-frame-rate");
        qCameraExportParam.videoBitrates = this.eci.getInt("video-bitrate");
        qCameraExportParam.fileType = this.eci.getInt("file-type");
        qCameraExportParam.maxDuration = this.eci.getInt("max-duration");
        qCameraExportParam.maxFileSize = this.eci.getInt("max-filesize");
        qCameraExportParam.audioChannel = this.eci.getInt("audio-channel-count");
        qCameraExportParam.audioBPS = this.eci.getInt("audio-bits-persample");
        qCameraExportParam.audioSamplingRate = this.eci.getInt("audio-sampling-rate");
        boolean z = true;
        qCameraExportParam.isUseHWEnc = this.eci.getInt("video-hw-codec") == 1;
        if (this.eci.getInt("export_with_effect") != 1) {
            z = false;
        }
        qCameraExportParam.isWithEffect = z;
        qCameraExportParam.exportFilePath = this.ech;
        int aHA = (((this.ecm + aHA()) - 90) + 360) % 360;
        int i = this.eci.getInt("preview-width");
        int i2 = this.eci.getInt("preview-height");
        int i3 = this.eci.getInt("out-video-width");
        int i4 = this.eci.getInt("out-video-height");
        qCameraExportParam.srcPickRect = QBaseCamEngine.calculatePickRect(i, i2, i3, i4, 65538, aHA, 1);
        if (90 != aHA % QDisplayContext.DISPLAY_ROTATION_180) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
        }
        if (i == 0 || i2 == 0 || i4 == 0 || i3 == 0) {
            qCameraExportParam.srcPickRect = new QRect(0, 0, 10000, 10000);
        }
        return qCameraExportParam;
    }

    /* renamed from: cJ */
    private void m24171cJ(List<QCamEffect> list) {
        if (!this.ecN && list != null && list.size() != 0) {
            int size = list.size();
            QCamEffect[] qCamEffectArr = new QCamEffect[size];
            for (int i = 0; i < size; i++) {
                qCamEffectArr[i] = (QCamEffect) list.get(i);
                qCamEffectArr[i].src = null;
            }
            if (this.ecB != null) {
                this.ecB.setEffect(true, qCamEffectArr);
            }
        }
    }

    /* renamed from: h */
    private boolean m24172h(Point point) {
        String str = this.eci.get("out-video-width");
        int i = 0;
        int parseInt = str != null ? parseInt(str) : 0;
        String str2 = this.eci.get("out-video-height");
        if (str2 != null) {
            i = parseInt(str2);
        }
        point.x = (parseInt >> 2) << 2;
        point.y = (i >> 2) << 2;
        return true;
    }

    private synchronized void init() {
        if (this.ecB == null) {
            QAudioIn.setRecFlag(0);
            try {
                if (!C8549f.aJd() || this.ecC != 0) {
                    this.ecB = QCameraUtils.CreateCamEngine(2);
                } else {
                    this.ecB = QCameraUtils.CreateCamEngine(3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ecL = new C8390c(this);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        r14.ecG = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        throw r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bb, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bc, code lost:
        r14.ecG = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00be, code lost:
        throw r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c7, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c9, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r15.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r15 = r14.ecD;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r14.ecD.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00de, code lost:
        throw r15;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:11:0x0016, B:15:0x0024, B:42:0x00aa, B:46:0x00b8] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00b8 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0031 A[Catch:{ Exception -> 0x00b8, all -> 0x00bb, Exception -> 0x0024, all -> 0x0027, Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0033 A[Catch:{ Exception -> 0x00b8, all -> 0x00bb, Exception -> 0x0024, all -> 0x0027, Exception -> 0x00c9 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0024=Splitter:B:15:0x0024, B:46:0x00b8=Splitter:B:46:0x00b8, B:42:0x00aa=Splitter:B:42:0x00aa} */
    /* renamed from: je */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m24173je(boolean r15) {
        /*
            r14 = this;
            monitor-enter(r14)
            boolean r0 = r14.ecw     // Catch:{ all -> 0x00df }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r14)
            return
        L_0x0007:
            java.lang.String r0 = "MediaRecorderEngine"
            java.lang.String r1 = "enter enableGetMaxAmplitude()"
            com.introvd.template.sdk.utils.C8554j.m25006d(r0, r1)     // Catch:{ all -> 0x00df }
            java.util.concurrent.locks.ReentrantLock r0 = r14.ecD     // Catch:{ all -> 0x00df }
            r0.lock()     // Catch:{ all -> 0x00df }
            r0 = 0
            if (r15 == 0) goto L_0x009f
            xiaoying.platform.QAudioIn r15 = r14.ecG     // Catch:{ Exception -> 0x0024, all -> 0x0027 }
            if (r15 == 0) goto L_0x0024
            xiaoying.platform.QAudioIn r15 = r14.ecG     // Catch:{ Exception -> 0x0024, all -> 0x0027 }
            r15.Stop()     // Catch:{ Exception -> 0x0024, all -> 0x0027 }
            xiaoying.platform.QAudioIn r15 = r14.ecG     // Catch:{ Exception -> 0x0024, all -> 0x0027 }
            r15.Uninit()     // Catch:{ Exception -> 0x0024, all -> 0x0027 }
        L_0x0024:
            r14.ecG = r0     // Catch:{ Exception -> 0x00c9 }
            goto L_0x002b
        L_0x0027:
            r15 = move-exception
            r14.ecG = r0     // Catch:{ Exception -> 0x00c9 }
            throw r15     // Catch:{ Exception -> 0x00c9 }
        L_0x002b:
            int r15 = r14.ecv     // Catch:{ Exception -> 0x00c9 }
            r0 = 4
            r15 = r15 & r0
            if (r15 == 0) goto L_0x0033
            goto L_0x00c1
        L_0x0033:
            r15 = 16
            r1 = 16000(0x3e80, float:2.2421E-41)
            com.introvd.template.sdk.b.a.a$a r2 = r14.eci     // Catch:{ Exception -> 0x00c9 }
            r3 = 1
            if (r2 == 0) goto L_0x006f
            com.introvd.template.sdk.b.a.a$a r2 = r14.eci     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r4 = "audio-channel-count"
            java.lang.String r2 = r2.get(r4)     // Catch:{ Exception -> 0x00c9 }
            if (r2 == 0) goto L_0x004b
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x00c9 }
            goto L_0x004c
        L_0x004b:
            r2 = 1
        L_0x004c:
            com.introvd.template.sdk.b.a.a$a r4 = r14.eci     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r5 = "audio-bits-persample"
            java.lang.String r4 = r4.get(r5)     // Catch:{ Exception -> 0x00c9 }
            if (r4 == 0) goto L_0x005a
            int r15 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x00c9 }
        L_0x005a:
            com.introvd.template.sdk.b.a.a$a r4 = r14.eci     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r5 = "audio-sampling-rate"
            java.lang.String r4 = r4.get(r5)     // Catch:{ Exception -> 0x00c9 }
            if (r4 == 0) goto L_0x006c
            int r1 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x00c9 }
            r7 = r15
            r8 = r1
            r6 = r2
            goto L_0x0074
        L_0x006c:
            r7 = r15
            r6 = r2
            goto L_0x0072
        L_0x006f:
            r6 = 1
            r7 = 16
        L_0x0072:
            r8 = 16000(0x3e80, float:2.2421E-41)
        L_0x0074:
            xiaoying.platform.QAudioIn r15 = new xiaoying.platform.QAudioIn     // Catch:{ Exception -> 0x00c9 }
            r15.<init>()     // Catch:{ Exception -> 0x00c9 }
            r14.ecG = r15     // Catch:{ Exception -> 0x00c9 }
            int r15 = r6 * r7
            int r15 = r15 * r8
            int r15 = r15 / 8
            int r15 = r15 * 40
            int r15 = r15 / 1000
            int r15 = r15 >> r0
            int r9 = r15 << 4
            xiaoying.platform.QAudioIn r4 = r14.ecG     // Catch:{ Exception -> 0x00c9 }
            r5 = 1
            r10 = 0
            r12 = 0
            r4.Init(r5, r6, r7, r8, r9, r10, r12)     // Catch:{ Exception -> 0x00c9 }
            xiaoying.platform.QAudioIn r15 = r14.ecG     // Catch:{ Exception -> 0x00c9 }
            r1 = 9
            r15.SetConfig(r1, r3, r0)     // Catch:{ Exception -> 0x00c9 }
            xiaoying.platform.QAudioIn r15 = r14.ecG     // Catch:{ Exception -> 0x00c9 }
            r15.Start()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00c1
        L_0x009f:
            com.introvd.template.sdk.b.a.c$c r15 = r14.ecL     // Catch:{ Exception -> 0x00c9 }
            if (r15 == 0) goto L_0x00aa
            com.introvd.template.sdk.b.a.c$c r15 = r14.ecL     // Catch:{ Exception -> 0x00c9 }
            r1 = 4097(0x1001, float:5.741E-42)
            r15.removeMessages(r1)     // Catch:{ Exception -> 0x00c9 }
        L_0x00aa:
            xiaoying.platform.QAudioIn r15 = r14.ecG     // Catch:{ Exception -> 0x00b8, all -> 0x00bb }
            if (r15 == 0) goto L_0x00b8
            xiaoying.platform.QAudioIn r15 = r14.ecG     // Catch:{ Exception -> 0x00b8, all -> 0x00bb }
            r15.Stop()     // Catch:{ Exception -> 0x00b8, all -> 0x00bb }
            xiaoying.platform.QAudioIn r15 = r14.ecG     // Catch:{ Exception -> 0x00b8, all -> 0x00bb }
            r15.Uninit()     // Catch:{ Exception -> 0x00b8, all -> 0x00bb }
        L_0x00b8:
            r14.ecG = r0     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00bf
        L_0x00bb:
            r15 = move-exception
            r14.ecG = r0     // Catch:{ Exception -> 0x00c9 }
            throw r15     // Catch:{ Exception -> 0x00c9 }
        L_0x00bf:
            int r15 = r14.ecv     // Catch:{ Exception -> 0x00c9 }
        L_0x00c1:
            java.util.concurrent.locks.ReentrantLock r15 = r14.ecD     // Catch:{ all -> 0x00df }
        L_0x00c3:
            r15.unlock()     // Catch:{ all -> 0x00df }
            goto L_0x00d0
        L_0x00c7:
            r15 = move-exception
            goto L_0x00d9
        L_0x00c9:
            r15 = move-exception
            r15.printStackTrace()     // Catch:{ all -> 0x00c7 }
            java.util.concurrent.locks.ReentrantLock r15 = r14.ecD     // Catch:{ all -> 0x00df }
            goto L_0x00c3
        L_0x00d0:
            java.lang.String r15 = "MediaRecorderEngine"
            java.lang.String r0 = "exit enableGetMaxAmplitude()"
            com.introvd.template.sdk.utils.C8554j.m25006d(r15, r0)     // Catch:{ all -> 0x00df }
            monitor-exit(r14)
            return
        L_0x00d9:
            java.util.concurrent.locks.ReentrantLock r0 = r14.ecD     // Catch:{ all -> 0x00df }
            r0.unlock()     // Catch:{ all -> 0x00df }
            throw r15     // Catch:{ all -> 0x00df }
        L_0x00df:
            r15 = move-exception
            monitor-exit(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.p381b.p382a.C8387c.m24173je(boolean):void");
    }

    public static int parseInt(String str) {
        return parseInt(str, 0);
    }

    public static int parseInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    /* renamed from: tD */
    private static boolean m24174tD(int i) {
        boolean z = false;
        try {
            QAudioIn qAudioIn = new QAudioIn();
            if (qAudioIn.Init(1, 1, 16, i, (((((i * 16) / 8) * 40) / 1000) >> 4) << 4, 0, 0) == 0) {
                qAudioIn.Uninit();
                z = true;
            }
        } catch (Throwable th) {
            QAudioIn.release();
            throw th;
        }
        QAudioIn.release();
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: tE */
    public void m24175tE(int i) {
        try {
            Camera.getCameraInfo(i, this.ecE);
        } catch (Exception unused) {
        }
        if (this.ecH != null) {
            this.ecH.mo24924a(this.ecE);
        }
        if (this.ecH != null) {
            C8389b bVar = new C8389b();
            bVar.ecO = this.ecJ;
            bVar.ecP = this.ecI;
            bVar.ecQ = 0;
            this.ecH.mo24925a(bVar, this.ecE);
            this.ecJ = bVar.ecO;
            this.ecI = bVar.ecP;
        }
    }

    /* renamed from: tF */
    private int m24176tF(int i) {
        if (i == 0) {
            return 3;
        }
        if (i == 90) {
            return 1;
        }
        if (i != 180) {
            return i != 270 ? 0 : 2;
        }
        return 4;
    }

    /* renamed from: tG */
    private QCameraConnectParam m24177tG(int i) {
        QCameraConnectParam qCameraConnectParam = new QCameraConnectParam();
        qCameraConnectParam.iCameraID = i;
        qCameraConnectParam.sh_only_for_connect = ((SurfaceView) this.ecj).getHolder();
        qCameraConnectParam.templateAdapter = this.bPy;
        qCameraConnectParam.FDMode = 1;
        qCameraConnectParam.FDDataFile = C8386b.aHs();
        qCameraConnectParam.appCtx = this.bbr;
        qCameraConnectParam.FDInterval = 1;
        return qCameraConnectParam;
    }

    /* renamed from: tH */
    private QCameraDisplayParam m24178tH(int i) {
        int i2;
        int i3;
        QCameraDisplayParam qCameraDisplayParam;
        int i4;
        int i5;
        int i6;
        QSize qSize;
        int i7 = i;
        SurfaceView surfaceView = (SurfaceView) this.eck;
        QSize qSize2 = new QSize();
        qSize2.mHeight = surfaceView.getHeight();
        qSize2.mWidth = surfaceView.getWidth();
        int i8 = qSize2.mWidth;
        if (i7 == 0) {
            i8 = qSize2.mWidth;
        } else {
            if (i7 == 1) {
                i8 = qSize2.mWidth;
                i2 = (int) ((((float) qSize2.mWidth) * 4.0f) / 3.0f);
            } else if (i7 == 2) {
                i8 = qSize2.mWidth;
                i2 = qSize2.mHeight;
            }
            i3 = this.eci.getInt("preview-width");
            int i9 = this.eci.getInt("preview-height");
            qCameraDisplayParam = new QCameraDisplayParam();
            qCameraDisplayParam.iDeviceOrientation = m24176tF(this.ecm % 360);
            qCameraDisplayParam.iDeviceVFrameW = i3;
            qCameraDisplayParam.iDeviceVFrameH = i9;
            if (i3 != 0 || i9 == 0 || i8 == 0) {
                qCameraDisplayParam.rtWork = new QRect(0, 0, 100, 100);
                qCameraDisplayParam.viewPort = new QRect(0, 0, 1, 1);
                return qCameraDisplayParam;
            }
            qCameraDisplayParam.rtDspDstRender = new QRect(0, 0, 10000, 10000);
            qCameraDisplayParam.flipState = this.eco | this.ecp;
            int aHA = aHA();
            if (1 == this.ecE.facing) {
                aHA = (360 - aHA) % 360;
            }
            int i10 = aHA;
            StringBuilder sb = new StringBuilder();
            sb.append("mLayoutOrientation=");
            sb.append(this.ecn);
            sb.append("mDeviceOrientation");
            sb.append(this.ecm);
            sb.append(" mDisplayOffsetDegrees=");
            sb.append(this.ecl);
            sb.append(" nSrc2ViewDegree=");
            sb.append(i10);
            C8554j.m25007e("MediaRecorderEngine", sb.toString());
            int i11 = this.eci.getInt("out-video-width");
            int i12 = this.eci.getInt("out-video-height");
            int tI = (m24179tI(this.ecm) + i10) % 360;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("work>>>>>rtWork calculatePickRect: ");
            sb2.append(i3);
            sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb2.append(i9);
            sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb2.append(i11);
            sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb2.append(i12);
            sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb2.append(tI);
            C8554j.m25007e("MediaRecorderEngine", sb2.toString());
            int i13 = i12;
            int i14 = i11;
            QSize qSize3 = qSize2;
            qCameraDisplayParam.rtWork = QBaseCamEngine.calculatePickRect(i3, i9, i11, i12, 65538, tI, 1);
            if (qCameraDisplayParam.rtWork == null) {
                C8554j.m25007e("MediaRecorderEngine", ">>>>>cdp.rtWork: err!!!! null!!!");
                return null;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("work>>>>>cdp.rtWork: ");
            sb3.append(qCameraDisplayParam.rtWork.left);
            sb3.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb3.append(qCameraDisplayParam.rtWork.top);
            sb3.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb3.append(qCameraDisplayParam.rtWork.right);
            sb3.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb3.append(qCameraDisplayParam.rtWork.bottom);
            C8554j.m25007e("MediaRecorderEngine", sb3.toString());
            int dI = C8572y.m25087dI(i14, 16);
            int dI2 = C8572y.m25087dI(i13, 16);
            qCameraDisplayParam.exportFrameW = dI;
            qCameraDisplayParam.exportFrameH = dI2;
            int i15 = (i3 * (qCameraDisplayParam.rtWork.right - qCameraDisplayParam.rtWork.left)) / 10000;
            int i16 = (i9 * (qCameraDisplayParam.rtWork.bottom - qCameraDisplayParam.rtWork.top)) / 10000;
            int i17 = i10 % 360;
            int i18 = this.ecm + this.ecl;
            if (i18 == 90 || i18 == 270) {
                if (this.ecl == 90 || this.ecl == 270) {
                    i4 = i8;
                    i5 = i2;
                } else {
                    i5 = i8;
                    i4 = i2;
                }
                i17 = 0;
            } else {
                i5 = i8;
                i4 = i2;
                int i19 = i16;
                i16 = i15;
                i15 = i19;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("src>>>>>calculatePickRect: ");
            sb4.append(i16);
            sb4.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb4.append(i15);
            sb4.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb4.append(i5);
            sb4.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb4.append(i4);
            sb4.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb4.append(i17);
            C8554j.m25007e("MediaRecorderEngine", sb4.toString());
            qCameraDisplayParam.rtDspSrcPick = QBaseCamEngine.calculatePickRect(i16, i15, i5, i4, 65538, i17, 1);
            if (qCameraDisplayParam.rtDspSrcPick != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("src>>>>>cdp.rtDspSrcPick: ");
                sb5.append(qCameraDisplayParam.rtDspSrcPick.left);
                sb5.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                sb5.append(qCameraDisplayParam.rtDspSrcPick.top);
                sb5.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                sb5.append(qCameraDisplayParam.rtDspSrcPick.right);
                sb5.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                sb5.append(qCameraDisplayParam.rtDspSrcPick.bottom);
                C8554j.m25007e("MediaRecorderEngine", sb5.toString());
            } else {
                C8554j.m25007e("MediaRecorderEngine", ">>>>>cdp.rtDspSrcPick: err!!!! null!!!");
            }
            qCameraDisplayParam.viewPort = new QRect(0, 0, i8, i2);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(">>>>>cdp.viewPort: ");
            sb6.append(qCameraDisplayParam.viewPort.left);
            sb6.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb6.append(qCameraDisplayParam.viewPort.top);
            sb6.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb6.append(qCameraDisplayParam.viewPort.right);
            sb6.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb6.append(qCameraDisplayParam.viewPort.bottom);
            C8554j.m25007e("MediaRecorderEngine", sb6.toString());
            QRect qRect = qCameraDisplayParam.viewPort;
            if (i7 != 0) {
                qSize = qSize3;
                i6 = 0;
            } else {
                i6 = this.ect;
                qSize = qSize3;
            }
            qCameraDisplayParam.viewPort = m24166a(qRect, qSize, 0, i6);
            if (qCameraDisplayParam.viewPort == null) {
                Log.e(this.LOG_TAG, "null == cdp.viewPort");
                return null;
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(">>>>>after transSurfaceRectToOpenGLRect cdp.viewPort: ");
            sb7.append(qCameraDisplayParam.viewPort.left);
            sb7.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb7.append(qCameraDisplayParam.viewPort.top);
            sb7.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb7.append(qCameraDisplayParam.viewPort.right);
            sb7.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb7.append(qCameraDisplayParam.viewPort.bottom);
            C8554j.m25007e("MediaRecorderEngine", sb7.toString());
            qCameraDisplayParam.iDVFRotationToView = aHA();
            qCameraDisplayParam.sh_only_for_preview = ((SurfaceView) this.eck).getHolder();
            return qCameraDisplayParam;
        }
        i2 = i8;
        i3 = this.eci.getInt("preview-width");
        int i92 = this.eci.getInt("preview-height");
        qCameraDisplayParam = new QCameraDisplayParam();
        qCameraDisplayParam.iDeviceOrientation = m24176tF(this.ecm % 360);
        qCameraDisplayParam.iDeviceVFrameW = i3;
        qCameraDisplayParam.iDeviceVFrameH = i92;
        if (i3 != 0) {
        }
        qCameraDisplayParam.rtWork = new QRect(0, 0, 100, 100);
        qCameraDisplayParam.viewPort = new QRect(0, 0, 1, 1);
        return qCameraDisplayParam;
    }

    /* renamed from: tI */
    private int m24179tI(int i) {
        if (i == 0) {
            return QDisplayContext.DISPLAY_ROTATION_270;
        }
        if (i == 90) {
            return 0;
        }
        if (i == 180) {
            return 90;
        }
        if (i != 270) {
            return 0;
        }
        return QDisplayContext.DISPLAY_ROTATION_180;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        return 0;
     */
    /* renamed from: K */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo33910K(int r3, int r4, int r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            super.mo33905tB(r3)     // Catch:{ all -> 0x003b }
            int r0 = r2.ecq     // Catch:{ all -> 0x003b }
            r1 = 0
            if (r0 != r3) goto L_0x0017
            boolean r0 = r2.ecu     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0017
            int r0 = r2.ecr     // Catch:{ all -> 0x003b }
            if (r0 != r4) goto L_0x0017
            int r0 = r2.ecs     // Catch:{ all -> 0x003b }
            if (r5 != r0) goto L_0x0017
            monitor-exit(r2)
            return r1
        L_0x0017:
            r2.ecu = r1     // Catch:{ all -> 0x003b }
            r2.ecs = r5     // Catch:{ all -> 0x003b }
            r2.ecr = r4     // Catch:{ all -> 0x003b }
            r2.ecq = r3     // Catch:{ all -> 0x003b }
            com.mediarecorder.engine.QCameraDisplayParam r3 = r2.m24178tH(r4)     // Catch:{ all -> 0x003b }
            r2.ecx = r3     // Catch:{ all -> 0x003b }
            com.mediarecorder.engine.QBaseCamEngine r3 = r2.ecB     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x0039
            boolean r3 = r2.ecw     // Catch:{ all -> 0x003b }
            if (r3 != 0) goto L_0x0039
            com.mediarecorder.engine.QCameraDisplayParam r3 = r2.ecx     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x0039
            com.mediarecorder.engine.QBaseCamEngine r3 = r2.ecB     // Catch:{ all -> 0x003b }
            com.mediarecorder.engine.QCameraDisplayParam r4 = r2.ecx     // Catch:{ all -> 0x003b }
            r5 = 0
            r3.updateDisplayParam(r4, r5)     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r2)
            return r1
        L_0x003b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.p381b.p382a.C8387c.mo33910K(int, int, int):int");
    }

    /* renamed from: VG */
    public int mo33911VG() {
        return this.ecz;
    }

    /* renamed from: a */
    public int mo33912a(int i, QPIPSource qPIPSource) {
        if (this.ecB == null) {
            return -1;
        }
        qPIPSource.idx = i;
        QCamEffectUpdateItem qCamEffectUpdateItem = new QCamEffectUpdateItem();
        qCamEffectUpdateItem.type = 2;
        qCamEffectUpdateItem.data = qPIPSource;
        qCamEffectUpdateItem.ZOrder = 104;
        return m24165a(qCamEffectUpdateItem);
    }

    /* renamed from: a */
    public int mo33913a(QFilterParam qFilterParam, int i) {
        if (this.ecB == null) {
            return -1;
        }
        QCamEffectUpdateItem qCamEffectUpdateItem = new QCamEffectUpdateItem();
        qCamEffectUpdateItem.data = qFilterParam;
        qCamEffectUpdateItem.type = 1;
        qCamEffectUpdateItem.ZOrder = i;
        return m24165a(qCamEffectUpdateItem);
    }

    /* renamed from: a */
    public void mo33895a(C8385a aVar) {
        int i;
        if (aVar != null) {
            super.mo33895a(aVar);
        }
        if (this.eci != null) {
            String str = this.eci.get("audio-codec-type");
            if (str != null) {
                parseInt(str);
            }
            String str2 = this.eci.get("audio-channel-count");
            if (str2 != null) {
                parseInt(str2);
            }
            String str3 = this.eci.get("audio-bits-persample");
            if (str3 != null) {
                parseInt(str3);
            }
            String str4 = this.eci.get("audio-sampling-rate");
            if (str4 != null) {
                parseInt(str4);
            }
            String str5 = this.eci.get("video-codec-type");
            int i2 = 0;
            String str6 = this.eci.get((str5 != null ? parseInt(str5) : 0) != 0 ? "video-bitrate" : "audio-bitrate");
            if (str6 != null) {
                parseInt(str6);
            }
            String str7 = this.eci.get("preview-input-fps");
            if (str7 != null) {
                i = parseInt(str7);
            } else {
                String str8 = this.eci.get("video-frame-rate");
                i = str8 != null ? parseInt(str8) : DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
            }
            if (i > 30000) {
                i = C12177i.f6157m;
            } else if (i < 5000) {
                i = 5000;
            }
            String str9 = this.eci.get("preview-width");
            int parseInt = str9 != null ? parseInt(str9) : 0;
            String str10 = this.eci.get("preview-height");
            if (str10 != null) {
                i2 = parseInt(str10);
            }
            if (i2 > parseInt) {
                this.eci.set("preview-width", String.valueOf(i2));
                this.eci.set("preview-height", String.valueOf(parseInt));
            } else {
                int i3 = parseInt;
                parseInt = i2;
                i2 = i3;
            }
            if (i > 15000) {
                int i4 = i / 1000;
            }
            String str11 = this.eci.get("max-duration");
            if (str11 != null) {
                parseInt(str11);
            }
            String str12 = this.eci.get("max-filesize");
            if (str12 != null) {
                parseInt(str12);
            }
            String str13 = this.eci.get("file-type");
            if (str13 != null) {
                parseInt(str13);
            }
            if (i2 != 0 && parseInt != 0) {
                this.ecF.x = i2;
                this.ecF.y = parseInt;
                m24172h(this.ecF);
                if (this.ecF.y * i2 <= this.ecF.x * parseInt) {
                    this.ecK.x = this.ecF.x;
                    this.ecK.y = (parseInt * this.ecF.x) / i2;
                } else {
                    this.ecK.y = this.ecF.y;
                    this.ecK.x = (i2 * this.ecF.y) / parseInt;
                }
                this.ecK.x = (this.ecK.x >> 2) << 2;
                this.ecK.y = (this.ecK.y >> 2) << 2;
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo33914a(C8388a aVar) {
        this.ecH = aVar;
    }

    public int aHr() {
        return aHA() % QDisplayContext.DISPLAY_ROTATION_180;
    }

    public int aHw() {
        if (this.ecB == null || this.ecN) {
            return 0;
        }
        this.ecN = true;
        this.ecw = true;
        if (this.ecL != null) {
            this.ecL.removeMessages(4097);
            this.ecL = null;
        }
        if (this.mEventHandler != null) {
            this.mEventHandler.removeCallbacksAndMessages(null);
            this.mEventHandler = null;
        }
        if ((1 & this.ecv) != 0) {
            disconnect();
        }
        if (this.ecB != null) {
            this.ecB.release();
            C8554j.m25007e("MediaRecorderEngine", "CameraKKKKK--------Camera  Engine release end------");
        }
        this.ecB = null;
        QAudioIn.release();
        this.ecN = false;
        return 0;
    }

    /* renamed from: aW */
    public void mo33899aW(long j) {
        this.ecD.lock();
        try {
            boolean z = false;
            boolean z2 = (this.ecg & 1) != 0;
            if ((j & 1) != 0) {
                z = true;
            }
            super.mo33899aW(j);
            if (z2 != z) {
                m24173je(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.ecD.unlock();
            throw th;
        }
        this.ecD.unlock();
    }

    /* renamed from: b */
    public int mo33916b(QPIPFrameParam qPIPFrameParam, int i) {
        if (this.ecB == null) {
            return -1;
        }
        QCamEffect qCamEffect = new QCamEffect();
        qCamEffect.type = 3;
        qCamEffect.src = qPIPFrameParam;
        qCamEffect.startPos = i;
        qCamEffect.isExported2Video = false;
        qCamEffect.ZOrder = 104;
        return m24164a(qCamEffect);
    }

    /* renamed from: b */
    public int mo33917b(boolean z, QPIPFrameParam qPIPFrameParam) {
        super.mo33905tB(0);
        if (this.ecu == z) {
            return 0;
        }
        this.ecu = z;
        this.ecq = 0;
        if (z) {
            this.ecx = aHy();
        } else {
            this.ecx = aHx();
        }
        if (this.ecB != null) {
            QBaseCamEngine qBaseCamEngine = this.ecB;
            QCameraDisplayParam qCameraDisplayParam = this.ecx;
            if (!z) {
                qPIPFrameParam = null;
            }
            qBaseCamEngine.updateDisplayParam(qCameraDisplayParam, qPIPFrameParam);
        }
        return 0;
    }

    /* renamed from: b */
    public synchronized void mo33900b(Handler handler) {
        super.mo33900b(handler);
        if (this.ecB != null) {
            this.ecB.setEventHandler(this.ecL);
        }
    }

    /* renamed from: d */
    public int mo33918d(String str, int i, boolean z) {
        if (this.ecN || this.ecB == null) {
            return -1;
        }
        QCamEffect qCamEffect = new QCamEffect();
        qCamEffect.type = 1;
        qCamEffect.src = str;
        qCamEffect.isExported2Video = false;
        qCamEffect.cfgIdx = i;
        qCamEffect.ZOrder = 102;
        qCamEffect.isCyclicMode = false;
        if (z) {
            qCamEffect.isNeedFD = true;
            if (!TextUtils.isEmpty(str)) {
                QStyle qStyle = new QStyle();
                qStyle.create(str, null, 0);
                int pasterExpressionType = qStyle.getPasterExpressionType();
                if (pasterExpressionType != 0) {
                    this.ecz = pasterExpressionType;
                }
                qStyle.destroy();
            }
        }
        return m24164a(qCamEffect);
    }

    /* renamed from: d */
    public synchronized int mo33919d(boolean z, QPIPSourceMode qPIPSourceMode) {
        if (this.ecB == null) {
            return -1;
        }
        if ((this.ecv & 4) != 0) {
            stopRecording(true);
        }
        m24173je(false);
        QCameraExportParam aHz = aHz();
        this.ecv |= 12;
        return this.ecB.startRecording(z, aHz, qPIPSourceMode);
    }

    public synchronized int disconnect() {
        this.ecv = 0;
        if (this.ecL != null) {
            this.ecL.removeMessages(4097);
        }
        if (this.ecB == null) {
            return 0;
        }
        this.ecq = -1;
        return this.ecB.disconnect();
    }

    /* renamed from: dw */
    public synchronized int mo33921dw(int i, int i2) {
        return -1;
    }

    /* renamed from: e */
    public synchronized int mo33922e(boolean z, QPIPSourceMode qPIPSourceMode) {
        if (this.ecB == null) {
            return -1;
        }
        QCameraExportParam aHz = aHz();
        this.ecv |= 8;
        return this.ecB.resumeRecording(z, aHz.exportUnitCount, qPIPSourceMode);
    }

    /* renamed from: eU */
    public int mo33923eU(String str) {
        if (this.ecB == null) {
            return -1;
        }
        QCamEffect qCamEffect = new QCamEffect();
        qCamEffect.type = 1;
        qCamEffect.src = str;
        qCamEffect.isExported2Video = false;
        qCamEffect.ZOrder = 101;
        return m24164a(qCamEffect);
    }

    /* renamed from: eV */
    public int mo33924eV(String str) {
        if (this.ecB == null) {
            return -1;
        }
        QCamEffect qCamEffect = new QCamEffect();
        qCamEffect.type = 1;
        qCamEffect.src = str;
        qCamEffect.isExported2Video = true;
        qCamEffect.ZOrder = 1;
        return m24164a(qCamEffect);
    }

    public synchronized Object getCamera() {
        if (this.ecB == null) {
            return null;
        }
        return this.ecB.getCamera();
    }

    public synchronized int getConfig(int i) {
        if (this.ecB == null) {
            return -1;
        }
        return this.ecB.getConfig(i);
    }

    public synchronized int getRecordDuration() {
        if (this.ecB == null) {
            return 0;
        }
        return this.ecB.getRecordDuration();
    }

    public int getRecordStatus(QRecorderStatus qRecorderStatus) {
        if (this.ecB == null) {
            return -1;
        }
        return this.ecB.getRecordStatus(qRecorderStatus);
    }

    public synchronized int getState() {
        return this.ecv;
    }

    /* renamed from: i */
    public int mo33930i(Object obj, Object obj2) {
        this.ecj = obj;
        this.eck = obj2;
        return 0;
    }

    /* renamed from: jb */
    public void mo33931jb(int i) {
        if (!this.ecN && this.ecA != i) {
            this.ecA = i;
            if (this.ecB != null) {
                this.ecB.setConfig(12291, Integer.valueOf(i));
            }
        }
    }

    /* renamed from: jc */
    public synchronized int mo33932jc(boolean z) {
        if (this.ecB == null) {
            return -1;
        }
        if ((this.ecv & 1) == 0) {
            return 1;
        }
        if ((this.ecv & 2) != 0) {
            stopPreview(true);
        }
        this.ecv |= 2;
        this.ecx = aHx();
        return this.ecB.startPreview(z, this.ecx);
    }

    /* renamed from: jd */
    public synchronized int mo33933jd(boolean z) {
        return mo33919d(z, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d1, code lost:
        return -1;
     */
    /* renamed from: nz */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo33934nz(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.List<com.mediarecorder.engine.QCamEffect> r0 = r9.ecy     // Catch:{ all -> 0x00d2 }
            r9.m24171cJ(r0)     // Catch:{ all -> 0x00d2 }
            r9.aHB()     // Catch:{ all -> 0x00d2 }
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00d2 }
            r1 = 0
            if (r0 == 0) goto L_0x0012
            monitor-exit(r9)
            return r1
        L_0x0012:
            boolean r0 = r9.ecN     // Catch:{ all -> 0x00d2 }
            r2 = -1
            if (r0 == 0) goto L_0x0019
            monitor-exit(r9)
            return r2
        L_0x0019:
            long[] r0 = com.introvd.template.sdk.p391g.C8450a.m24476nZ(r10)     // Catch:{ all -> 0x00d2 }
            com.mediarecorder.engine.QBaseCamEngine r3 = r9.ecB     // Catch:{ all -> 0x00d2 }
            if (r3 == 0) goto L_0x00d0
            if (r0 != 0) goto L_0x0025
            goto L_0x00d0
        L_0x0025:
            java.util.List<com.mediarecorder.engine.QCamEffect> r2 = r9.ecy     // Catch:{ all -> 0x00d2 }
            r2.clear()     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = "MediaRecorderEngine"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r3.<init>()     // Catch:{ all -> 0x00d2 }
            java.lang.String r4 = " ===setFDTemplate "
            r3.append(r4)     // Catch:{ all -> 0x00d2 }
            r3.append(r10)     // Catch:{ all -> 0x00d2 }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x00d2 }
            com.introvd.template.sdk.utils.C8554j.m25008i(r2, r10)     // Catch:{ all -> 0x00d2 }
            int r10 = r0.length     // Catch:{ all -> 0x00d2 }
            com.mediarecorder.engine.QCamEffect[] r2 = new com.mediarecorder.engine.QCamEffect[r10]     // Catch:{ all -> 0x00d2 }
            r3 = 0
        L_0x0044:
            r4 = 1
            if (r3 >= r10) goto L_0x00c8
            com.mediarecorder.engine.QCamEffect r5 = new com.mediarecorder.engine.QCamEffect     // Catch:{ all -> 0x00d2 }
            r5.<init>()     // Catch:{ all -> 0x00d2 }
            r2[r3] = r5     // Catch:{ all -> 0x00d2 }
            r5 = r0[r3]     // Catch:{ all -> 0x00d2 }
            r7 = r2[r3]     // Catch:{ all -> 0x00d2 }
            int r8 = com.introvd.template.sdk.p391g.C8450a.getTemplateType(r5)     // Catch:{ all -> 0x00d2 }
            r7.type = r8     // Catch:{ all -> 0x00d2 }
            java.lang.String r7 = ""
            com.introvd.template.sdk.e r8 = com.introvd.template.sdk.C8410e.aGX()     // Catch:{ all -> 0x00d2 }
            com.introvd.template.sdk.b r8 = r8.aHa()     // Catch:{ all -> 0x00d2 }
            if (r8 == 0) goto L_0x006c
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00d2 }
            java.lang.String r7 = r8.mo29496q(r5)     // Catch:{ all -> 0x00d2 }
        L_0x006c:
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00d2 }
            if (r5 == 0) goto L_0x0073
            goto L_0x00c4
        L_0x0073:
            r5 = r2[r3]     // Catch:{ all -> 0x00d2 }
            r5.src = r7     // Catch:{ all -> 0x00d2 }
            java.lang.String r5 = "MediaRecorderEngine"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r6.<init>()     // Catch:{ all -> 0x00d2 }
            java.lang.String r8 = "===strTemplatePath "
            r6.append(r8)     // Catch:{ all -> 0x00d2 }
            r6.append(r7)     // Catch:{ all -> 0x00d2 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00d2 }
            com.introvd.template.sdk.utils.C8554j.m25008i(r5, r6)     // Catch:{ all -> 0x00d2 }
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00d2 }
            if (r5 != 0) goto L_0x00a7
            xiaoying.engine.base.QStyle r5 = new xiaoying.engine.base.QStyle     // Catch:{ all -> 0x00d2 }
            r5.<init>()     // Catch:{ all -> 0x00d2 }
            r6 = 0
            r5.create(r7, r6, r1)     // Catch:{ all -> 0x00d2 }
            int r6 = r5.getPasterExpressionType()     // Catch:{ all -> 0x00d2 }
            if (r6 == 0) goto L_0x00a4
            r9.ecz = r6     // Catch:{ all -> 0x00d2 }
        L_0x00a4:
            r5.destroy()     // Catch:{ all -> 0x00d2 }
        L_0x00a7:
            r5 = r2[r3]     // Catch:{ all -> 0x00d2 }
            r5.isExported2Video = r4     // Catch:{ all -> 0x00d2 }
            r5 = r2[r3]     // Catch:{ all -> 0x00d2 }
            r5.isCyclicMode = r4     // Catch:{ all -> 0x00d2 }
            r5 = r2[r3]     // Catch:{ all -> 0x00d2 }
            r5.isNeedFD = r4     // Catch:{ all -> 0x00d2 }
            r4 = r2[r3]     // Catch:{ all -> 0x00d2 }
            r4.cfgIdx = r3     // Catch:{ all -> 0x00d2 }
            r4 = r2[r3]     // Catch:{ all -> 0x00d2 }
            int r5 = r3 + 5
            r4.ZOrder = r5     // Catch:{ all -> 0x00d2 }
            java.util.List<com.mediarecorder.engine.QCamEffect> r4 = r9.ecy     // Catch:{ all -> 0x00d2 }
            r5 = r2[r3]     // Catch:{ all -> 0x00d2 }
            r4.add(r5)     // Catch:{ all -> 0x00d2 }
        L_0x00c4:
            int r3 = r3 + 1
            goto L_0x0044
        L_0x00c8:
            com.mediarecorder.engine.QBaseCamEngine r10 = r9.ecB     // Catch:{ all -> 0x00d2 }
            int r10 = r10.setEffect(r4, r2)     // Catch:{ all -> 0x00d2 }
            monitor-exit(r9)
            return r10
        L_0x00d0:
            monitor-exit(r9)
            return r2
        L_0x00d2:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.p381b.p382a.C8387c.mo33934nz(java.lang.String):int");
    }

    public int onCapturePictureCallback(String str, int i, Bitmap bitmap) {
        if (this.mEventHandler != null) {
            C8391d dVar = new C8391d();
            dVar.ecR = str;
            dVar.bitmap = bitmap;
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(QCameraComdef.EVENT_CAPTURE_DONE, i, 0, dVar));
        }
        return 0;
    }

    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Recording onError, what=");
        sb.append(i);
        C8554j.m25006d("MediaRecorderEngine", sb.toString());
        if (this.mEventHandler != null) {
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(QCameraComdef.EVENT_RECORDER_ERROR, i, i2));
        }
        stopRecording(true);
    }

    public synchronized int pauseRecording(boolean z, QPIPSourceMode qPIPSourceMode) {
        if (this.ecB == null) {
            return -1;
        }
        if ((this.ecv & 8) == 0) {
            return 0;
        }
        this.ecv &= -9;
        return this.ecB.pauseRecording(z, qPIPSourceMode);
    }

    public synchronized int stopPreview(boolean z) {
        if (this.ecB == null) {
            return -1;
        }
        if ((this.ecv & 1) == 0) {
            return 0;
        }
        if ((this.ecv & 2) == 0) {
            return 0;
        }
        this.ecv &= -3;
        int stopPreview = this.ecB.stopPreview(z);
        this.ecq = -1;
        return stopPreview;
    }

    public synchronized int stopRecording(boolean z) {
        if (this.ecB == null) {
            return -1;
        }
        this.ecv &= -13;
        return this.ecB.stopRecording(z);
    }

    /* renamed from: t */
    public synchronized int mo33939t(boolean z, int i) {
        if (this.ecB == null) {
            return -1;
        }
        if ((this.ecv & 1) == 0) {
            return 1;
        }
        if ((this.ecv & 2) != 0) {
            stopPreview(true);
        }
        this.ecv |= 2;
        this.ecx = m24178tH(i);
        return this.ecB.startPreview(z, this.ecx);
    }

    /* renamed from: tA */
    public int mo33904tA(int i) {
        super.mo33904tA(i % 360);
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        return 0;
     */
    /* renamed from: tB */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo33905tB(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            super.mo33905tB(r4)     // Catch:{ all -> 0x002f }
            int r0 = r3.ecq     // Catch:{ all -> 0x002f }
            r1 = 0
            if (r0 != r4) goto L_0x000f
            boolean r0 = r3.ecu     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r3)
            return r1
        L_0x000f:
            r3.ecu = r1     // Catch:{ all -> 0x002f }
            r3.ecq = r4     // Catch:{ all -> 0x002f }
            com.mediarecorder.engine.QCameraDisplayParam r4 = r3.aHx()     // Catch:{ all -> 0x002f }
            r3.ecx = r4     // Catch:{ all -> 0x002f }
            com.mediarecorder.engine.QBaseCamEngine r4 = r3.ecB     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x002d
            boolean r4 = r3.ecw     // Catch:{ all -> 0x002f }
            if (r4 != 0) goto L_0x002d
            com.mediarecorder.engine.QCameraDisplayParam r4 = r3.ecx     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x002d
            com.mediarecorder.engine.QBaseCamEngine r4 = r3.ecB     // Catch:{ all -> 0x002f }
            com.mediarecorder.engine.QCameraDisplayParam r0 = r3.ecx     // Catch:{ all -> 0x002f }
            r2 = 0
            r4.updateDisplayParam(r0, r2)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r3)
            return r1
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.p381b.p382a.C8387c.mo33905tB(int):int");
    }

    /* renamed from: tJ */
    public synchronized int mo33940tJ(int i) {
        QCameraConnectParam tG;
        this.ecC = i;
        tG = m24177tG(i);
        init();
        this.ecv |= 1;
        return this.ecB.connect(tG);
    }

    /* renamed from: tK */
    public void mo33941tK(int i) {
        this.ect = i;
    }
}
