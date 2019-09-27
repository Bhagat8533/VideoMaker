package com.introvd.template.sdk.editor.p388b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8561p;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.VeMSize;
import java.lang.ref.WeakReference;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.IQSessionStateListener;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QSessionState;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QVEError;
import xiaoying.engine.base.QVideoInfo;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.player.QPlayer;
import xiaoying.engine.player.QPlayerState;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QColorSpace;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.sdk.editor.b.d */
public class C8431d implements IQSessionStateListener {
    private boolean eeM = false;
    private volatile int eeN = 0;
    private QPlayer eeO = new QPlayer();
    private int eeP = 0;
    private int eeQ = 0;
    private QSessionStream eeR;
    private volatile boolean eeS = false;
    /* access modifiers changed from: private */
    public C8434c eeT;
    private Handler mHandler;

    /* renamed from: com.introvd.template.sdk.editor.b.d$a */
    public enum C8432a {
        PREV_KEYFRAME,
        NEXT_KEYFRAME
    }

    /* renamed from: com.introvd.template.sdk.editor.b.d$b */
    private static class C8433b extends Handler {
        private WeakReference<C8431d> cYS;

        C8433b(C8431d dVar) {
            super(Looper.getMainLooper());
            this.cYS = new WeakReference<>(dVar);
        }

        public void handleMessage(Message message) {
            C8431d dVar = (C8431d) this.cYS.get();
            if (dVar != null && dVar.eeT != null) {
                switch (message.what) {
                    case 4097:
                        C8554j.m25008i("XYMediaPlayer", "=====PLAYER_READY====");
                        dVar.eeT.mo27391cj(2, message.arg1);
                        break;
                    case 4098:
                        dVar.eeT.mo27391cj(5, message.arg1);
                        break;
                    case 4099:
                        dVar.eeT.mo27391cj(3, message.arg1);
                        break;
                    case 4100:
                        dVar.eeT.mo27391cj(4, message.arg1);
                        break;
                    case 4101:
                        dVar.eeT.mo27391cj(6, message.arg1);
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.sdk.editor.b.d$c */
    public interface C8434c {
        /* renamed from: cj */
        void mo27391cj(int i, int i2);
    }

    /* renamed from: a */
    private int m24368a(C8432a aVar) {
        if (this.eeO == null) {
            return 5;
        }
        return this.eeO.setProperty(QPlayer.PROP_PLAYER_SEEK_DIR, Integer.valueOf(aVar == C8432a.PREV_KEYFRAME ? 0 : 1));
    }

    private void aIw() {
        if (this.mHandler != null) {
            for (int i = 4096; i <= 4100; i++) {
                this.mHandler.removeMessages(i);
            }
        }
    }

    private int syncSeekTo(int i) {
        if (this.eeO == null || !this.eeS) {
            return 1;
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(4099);
            this.mHandler.removeMessages(4100);
        }
        if (this.eeO.syncSeekTo(i) == 0) {
            return 0;
        }
        C8554j.m25007e("XYMediaPlayer", "Sync seek error!");
        return 1;
    }

    /* renamed from: a */
    public int mo34166a(QDisplayContext qDisplayContext, int i) {
        int displayContext = setDisplayContext(qDisplayContext);
        if (this.eeO == null || this.eeR == null || this.eeS) {
            return displayContext;
        }
        int activeStream = this.eeO.activeStream(this.eeR, i, false);
        this.eeS = true;
        return activeStream;
    }

    /* renamed from: a */
    public int mo34167a(QClip qClip, int i, QEffect qEffect) {
        if (qClip == null || this.eeO == null || !this.eeS) {
            return 1;
        }
        return this.eeO.refreshStream(qClip, i, qEffect);
    }

    /* renamed from: a */
    public boolean mo34168a(QSessionStream qSessionStream, int i) {
        if (qSessionStream == null) {
            return false;
        }
        pause();
        if (this.eeO == null) {
            return false;
        }
        mo34191jn(false);
        this.eeS = false;
        int deactiveStream = this.eeO.deactiveStream();
        if (deactiveStream != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("!!!deactiveStream res=");
            sb.append(deactiveStream);
            C8554j.m25007e("XYMediaPlayer", sb.toString());
        }
        aIu();
        if (this.mHandler != null) {
            this.mHandler.removeMessages(4099);
            this.mHandler.removeMessages(4100);
        }
        int activeStream = this.eeO.activeStream(qSessionStream, i, false);
        if (activeStream != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("!!!activeStream res=");
            sb2.append(activeStream);
            C8554j.m25007e("XYMediaPlayer", sb2.toString());
            return false;
        }
        this.eeR = qSessionStream;
        this.eeS = true;
        if (aIB() == 0) {
            return true;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("!!!refreshDisplay res=");
        sb3.append(activeStream);
        C8554j.m25007e("XYMediaPlayer", sb3.toString());
        return false;
    }

    /* renamed from: a */
    public boolean mo34169a(QSessionStream qSessionStream, C8434c cVar, VeMSize veMSize, int i, QEngine qEngine, SurfaceHolder surfaceHolder) {
        return mo34170a(qSessionStream, cVar, veMSize, i, qEngine, surfaceHolder, null);
    }

    /* renamed from: a */
    public boolean mo34170a(QSessionStream qSessionStream, C8434c cVar, VeMSize veMSize, int i, QEngine qEngine, SurfaceHolder surfaceHolder, QDisplayContext qDisplayContext) {
        if (qSessionStream == null || veMSize == null || qEngine == null || this.eeO == null) {
            return false;
        }
        this.eeR = qSessionStream;
        this.eeT = cVar;
        if (this.mHandler == null) {
            this.mHandler = new C8433b(this);
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.eeO.init(qEngine, this) != 0) {
            return false;
        }
        mo34191jn(false);
        if (qDisplayContext == null) {
            qDisplayContext = C8571x.m25060c(veMSize.width, veMSize.height, 1, surfaceHolder);
        }
        if (setDisplayContext(qDisplayContext) != 0) {
            this.eeO.unInit();
            this.eeO = null;
            return false;
        } else if (this.eeO.activeStream(qSessionStream, i, false) != 0) {
            this.eeO.unInit();
            this.eeO = null;
            return false;
        } else {
            this.eeS = true;
            mo34191jn(this.eeM);
            this.eeN = ((QPlayerState) this.eeO.getState()).get(3);
            return true;
        }
    }

    public int aIA() {
        if (this.eeO == null) {
            return -1;
        }
        try {
            int i = ((QPlayerState) this.eeO.getState()).get(3);
            if (i > 0) {
                this.eeN = i;
            }
            this.eeO.setVolume(0);
            return 0;
        } catch (Exception unused) {
            return 4;
        }
    }

    public int aIB() {
        C8554j.m25008i("XYMediaPlayer", "PlaybackModule.RefreshDisplay");
        if (this.eeO == null) {
            return 1;
        }
        int displayRefresh = this.eeO.displayRefresh();
        if (displayRefresh != 0) {
            return displayRefresh;
        }
        return 0;
    }

    public VeRange aIC() {
        if (this.eeO == null) {
            return null;
        }
        QRange qRange = (QRange) this.eeO.getProperty(QPlayer.PROP_PLAYER_RANGE);
        if (qRange != null) {
            return C8561p.m25041d(qRange);
        }
        return null;
    }

    public int aID() {
        return mo34197ug(0);
    }

    public boolean aIE() {
        return this.eeO != null;
    }

    public void aIt() {
        if (this.eeO != null && this.eeR != null && this.eeS) {
            this.eeO.deactiveStream();
            this.eeS = false;
        }
    }

    public void aIu() {
        if (this.eeR != null) {
            this.eeR.close();
            this.eeR = null;
        }
        this.eeS = false;
    }

    public void aIv() {
        if (this.eeO != null) {
            if (this.eeS) {
                this.eeS = false;
                this.eeO.deactiveStream();
            }
            this.eeO.unInit();
            this.eeO = null;
        }
        this.eeT = null;
        aIu();
        aIw();
        this.mHandler = null;
        this.eeP = 0;
        this.eeQ = 0;
    }

    public int aIx() {
        if (this.eeO == null) {
            return -1;
        }
        QPlayerState qPlayerState = (QPlayerState) this.eeO.getState();
        if (qPlayerState == null) {
            return -1;
        }
        int i = qPlayerState.get(1);
        StringBuilder sb = new StringBuilder();
        sb.append("enableDisplay curTime=");
        sb.append(i);
        C8554j.m25008i("XYMediaPlayer", sb.toString());
        return i;
    }

    public int aIy() {
        VeRange aIC = aIC();
        return aIC != null ? aIC.getmTimeLength() : agX();
    }

    public int aIz() {
        if (this.eeO == null) {
            return -1;
        }
        try {
            this.eeO.setVolume(this.eeN);
            return 0;
        } catch (Exception unused) {
            return 4;
        }
    }

    public int agX() {
        if (this.eeO == null) {
            return -1;
        }
        QPlayerState qPlayerState = (QPlayerState) this.eeO.getState();
        if (qPlayerState == null) {
            return -1;
        }
        QVideoInfo videoInfo = qPlayerState.getVideoInfo();
        if (videoInfo == null) {
            return -1;
        }
        return videoInfo.get(5);
    }

    /* renamed from: b */
    public int mo34183b(VeMSize veMSize) {
        if (veMSize == null || this.eeO == null) {
            return 1;
        }
        return this.eeO.setProperty(QPlayer.PROP_PLAYER_STREAM_FRAME_SIZE, new QSize(veMSize.width, veMSize.height));
    }

    /* renamed from: b */
    public boolean mo34184b(QSessionStream qSessionStream, int i) {
        if (qSessionStream == null || this.eeO == null) {
            return false;
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(4099);
            this.mHandler.removeMessages(4100);
        }
        if (this.eeO.activeStream(qSessionStream, i, false) != 0) {
            return false;
        }
        this.eeR = qSessionStream;
        boolean z = true;
        this.eeS = true;
        if (aIB() != 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    public void mo34185c(Handler handler) {
        this.mHandler = handler;
    }

    /* renamed from: d */
    public int mo34186d(VeRange veRange) {
        if (this.eeO == null || veRange == null) {
            return 1;
        }
        QRange qRange = new QRange(veRange.getmPosition(), veRange.getmTimeLength());
        StringBuilder sb = new StringBuilder();
        sb.append("Set player veRange  veRange:");
        sb.append(veRange);
        C8554j.m25008i("XYMediaPlayer", sb.toString());
        return this.eeO.setProperty(QPlayer.PROP_PLAYER_RANGE, qRange);
    }

    /* renamed from: dE */
    public boolean mo34187dE(int i, int i2) {
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (this.eeO == null || !this.eeS) {
            return false;
        }
        if (i2 <= 0) {
            i2 = aIx();
        }
        if (i > i2) {
            m24368a(C8432a.NEXT_KEYFRAME);
            i3 = syncSeekTo(i);
            if (i3 != 0) {
                m24368a(C8432a.PREV_KEYFRAME);
                i3 = syncSeekTo(i);
            }
        } else if (i < i2) {
            m24368a(C8432a.PREV_KEYFRAME);
            i3 = syncSeekTo(i);
            if (i3 != 0) {
                m24368a(C8432a.NEXT_KEYFRAME);
                i3 = syncSeekTo(i);
            }
        } else {
            i3 = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("player syncSeekTo:");
        sb.append(aIx());
        sb.append(";msTime:");
        sb.append(i);
        sb.append("; time consume=");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        C8554j.m25008i("XYMediaPlayer", sb.toString());
        if (i3 == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: dF */
    public int mo34188dF(int i, int i2) {
        if (this.eeO == null || i < 0 || i2 < 0) {
            return 1;
        }
        if (this.eeO.setProperty(QPlayer.PROP_PLAYER_RANGE, new QRange(i, i2)) == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Set player mVeRange start = ");
        sb.append(i);
        sb.append(", length = ");
        sb.append(i2);
        sb.append(" error!");
        C8554j.m25007e("XYMediaPlayer", sb.toString());
        return 1;
    }

    /* renamed from: dG */
    public Bitmap mo34189dG(int i, int i2) {
        if (i * i2 > 0 && this.eeO != null) {
            QBitmap curFrame = this.eeO.getCurFrame(i, i2, QColorSpace.QPAF_RGB32_A8R8G8B8);
            if (curFrame != null) {
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                int transformQBitmapIntoBitmap = QAndroidBitmapFactory.transformQBitmapIntoBitmap(curFrame, createBitmap);
                if (!curFrame.isRecycled()) {
                    curFrame.recycle();
                }
                if (transformQBitmapIntoBitmap != 0) {
                    return null;
                }
                return createBitmap;
            }
        }
        return null;
    }

    public boolean isPlaying() {
        boolean z = false;
        if (this.eeO == null || !this.eeS) {
            return false;
        }
        QPlayerState qPlayerState = (QPlayerState) this.eeO.getState();
        if (qPlayerState != null && qPlayerState.get(0) == 2) {
            z = true;
        }
        return z;
    }

    /* renamed from: jn */
    public boolean mo34191jn(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("enableDisplay isEnable=");
        sb.append(z);
        C8554j.m25008i("XYMediaPlayer", sb.toString());
        this.eeM = z;
        boolean z2 = false;
        if (this.eeO == null) {
            return false;
        }
        if (this.eeO.disableDisplay(!z) == 0) {
            z2 = true;
        }
        return z2;
    }

    public int onSessionStatus(QSessionState qSessionState) {
        int currentTime = qSessionState.getCurrentTime();
        int errorCode = qSessionState.getErrorCode();
        if (qSessionState.getStatus() != 4 && errorCode != 0 && 268455950 != errorCode) {
            return QVEError.QERR_COMMON_CANCEL;
        }
        if (this.mHandler == null) {
            return 0;
        }
        if (268455950 == errorCode) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4101, errorCode, 0));
        }
        int min = Math.min(qSessionState.getDuration(), currentTime);
        switch (qSessionState.getStatus()) {
            case 1:
                this.eeQ = 0;
                this.eeP = 0;
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4097, min, 0), 20);
                break;
            case 2:
                int i = this.eeQ >= min ? this.eeQ - min : min - this.eeQ;
                if (this.eeP != qSessionState.getStatus() || i >= 100) {
                    Message obtainMessage = this.mHandler.obtainMessage(4099, min, 0);
                    this.mHandler.removeMessages(4099);
                    this.mHandler.sendMessage(obtainMessage);
                    this.eeQ = min;
                    break;
                }
            case 3:
                this.mHandler.sendMessage(this.mHandler.obtainMessage(4100, min, 0));
                break;
            case 4:
                this.mHandler.sendMessage(this.mHandler.obtainMessage(4098, min, 0));
                break;
            default:
                return QVEError.QERR_APP_NOT_SUPPORT;
        }
        this.eeP = qSessionState.getStatus();
        return 0;
    }

    public boolean pause() {
        if (this.eeO == null) {
            return false;
        }
        if (isPlaying()) {
            this.eeO.pause();
        }
        return true;
    }

    public boolean play() {
        boolean z = false;
        if (this.eeO == null || isPlaying()) {
            return false;
        }
        if (this.eeO.play() == 0) {
            z = true;
        }
        return z;
    }

    public int setDisplayContext(QDisplayContext qDisplayContext) {
        if (this.eeO == null) {
            return 5;
        }
        return this.eeO.setDisplayContext(qDisplayContext) != 0 ? 1 : 0;
    }

    public int stop() {
        return (this.eeO != null && this.eeO.stop() == 0) ? 0 : 1;
    }

    /* renamed from: uf */
    public boolean mo34196uf(int i) {
        if (this.eeO == null || !this.eeS) {
            return false;
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(4099);
        }
        QRange qRange = (QRange) this.eeO.getProperty(QPlayer.PROP_PLAYER_RANGE);
        if (qRange != null) {
            int i2 = qRange.get(0);
            if (i < i2) {
                i = i2 + 1;
            }
            int i3 = qRange.get(1);
            int i4 = i2 + i3;
            if (i > i4 && i3 > 0) {
                i = i4 - 1;
            }
        }
        int seekTo = this.eeO.seekTo(i);
        if (seekTo != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("player Seek Async seek error! seekTo:");
            sb.append(seekTo);
            sb.append(";msTime=");
            sb.append(i);
            C8554j.m25007e("XYMediaPlayer", sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("player SeekTo:");
        sb2.append(aIx());
        sb2.append(";msTime:");
        sb2.append(i);
        C8554j.m25008i("XYMediaPlayer", sb2.toString());
        return true;
    }

    /* renamed from: ug */
    public int mo34197ug(int i) {
        if (this.eeO == null) {
            return 5;
        }
        QRange qRange = (QRange) this.eeO.getProperty(QPlayer.PROP_PLAYER_RANGE);
        if (qRange != null) {
            int i2 = qRange.get(0);
            int i3 = qRange.get(1) + i2;
            if (i > 0) {
                i2 += i;
            }
            if (i2 > i3) {
                i2 = i3 - 1;
            }
            if (this.eeO.seekTo(i2) != 0) {
                return 1;
            }
        }
        return 0;
    }
}
