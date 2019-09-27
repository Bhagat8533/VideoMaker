package com.introvd.template.camera.p229b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.router.explorer.MusicDataItem;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* renamed from: com.introvd.template.camera.b.g */
public class C4999g {
    /* access modifiers changed from: private */
    public MediaPlayer bQf;
    /* access modifiers changed from: private */
    public int bQg = 0;
    /* access modifiers changed from: private */
    public int bQh = 0;
    /* access modifiers changed from: private */
    public int bQi;
    private C5003a bQj = new C5003a(this);
    /* access modifiers changed from: private */
    public C5004b bQk;
    private String bQl;
    /* access modifiers changed from: private */
    public boolean bQm;
    private OnCompletionListener bQn = new OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            LogUtils.m14223i("CameraMusicMgr", "onCompletion");
            if (C4999g.this.bQm && C4999g.this.bQf != null) {
                C4999g.this.bQf.start();
            }
            if (C4999g.this.bQk != null) {
                C4999g.this.bQi = C4999g.this.bQh;
                C4999g.this.bQk.mo24955iD(1000);
                C4999g.this.bQk.mo24954Oy();
            }
        }
    };
    private OnErrorListener bQo = new OnErrorListener() {
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("onError:");
            sb.append(i);
            sb.append(",extra:");
            sb.append(i2);
            LogUtils.m14223i("CameraMusicMgr", sb.toString());
            if (C4999g.this.bQk != null) {
                C4999g.this.bQk.mo25594bX(i, i2);
            }
            return false;
        }
    };
    private OnPreparedListener bQp = new OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            LogUtils.m14223i("CameraMusicMgr", "onPrepared");
            if (C4999g.this.bQk != null) {
                C4999g.this.bQk.onPrepared();
            }
        }
    };
    private String mTitle;

    /* renamed from: com.introvd.template.camera.b.g$a */
    private static class C5003a extends Handler {
        private final WeakReference<C4999g> bQr;

        C5003a(C4999g gVar) {
            this.bQr = new WeakReference<>(gVar);
        }

        public void handleMessage(Message message) {
            C4999g gVar = (C4999g) this.bQr.get();
            if (gVar != null) {
                switch (message.what) {
                    case 4097:
                        removeMessages(4097);
                        if (gVar.bQf.isPlaying()) {
                            if (gVar.bQi < gVar.bQf.getCurrentPosition()) {
                                gVar.bQi = gVar.bQf.getCurrentPosition();
                            }
                            sendEmptyMessageDelayed(4097, 100);
                            sendEmptyMessage(4098);
                            break;
                        }
                        break;
                    case 4098:
                        removeMessages(4098);
                        if (gVar.bQk != null) {
                            int y = C4999g.m12910y(gVar.bQi, gVar.bQg, gVar.bQh);
                            if (gVar.bQh - gVar.bQg > 0 && gVar.bQi >= gVar.bQg && gVar.bQi <= gVar.bQh) {
                                gVar.bQk.mo24955iD(y);
                                break;
                            } else {
                                gVar.bQi = gVar.bQh;
                                gVar.bQk.mo24955iD(y);
                                gVar.bQk.mo24954Oy();
                                break;
                            }
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.camera.b.g$b */
    public interface C5004b {
        /* renamed from: Oy */
        void mo24954Oy();

        /* renamed from: bX */
        void mo25594bX(int i, int i2);

        /* renamed from: iD */
        void mo24955iD(int i);

        void onPrepared();
    }

    /* renamed from: com.introvd.template.camera.b.g$c */
    public static class C5005c implements C5004b {
        /* renamed from: Oy */
        public void mo24954Oy() {
        }

        /* renamed from: bX */
        public void mo25594bX(int i, int i2) {
        }

        /* renamed from: iD */
        public void mo24955iD(int i) {
        }

        public void onPrepared() {
        }
    }

    public C4999g(boolean z) {
        if (this.bQf != null) {
            this.bQf.release();
            this.bQf = null;
        }
        this.bQf = new MediaPlayer();
        this.bQf.setOnErrorListener(this.bQo);
        this.bQf.setOnPreparedListener(this.bQp);
        this.bQf.setAudioStreamType(3);
        this.bQf.setLooping(false);
        this.bQm = z;
    }

    /* renamed from: y */
    public static int m12910y(int i, int i2, int i3) {
        int i4 = i3 - i2;
        if (i4 <= 0 || i < i2 || i > i3) {
            return 1000;
        }
        return ((i - i2) * 1000) / i4;
    }

    /* renamed from: VI */
    public void mo25574VI() {
        LogUtils.m14223i("CameraMusicMgr", "realeasePlayer ");
        this.bQi = this.bQg;
        this.bQj.removeMessages(4097);
        if (this.bQf != null) {
            if (this.bQf.isPlaying()) {
                this.bQf.stop();
            }
            this.bQf.release();
            this.bQf = null;
        }
    }

    /* renamed from: VJ */
    public void mo25575VJ() {
        try {
            this.bQf.seekTo(this.bQg);
            this.bQi = this.bQg;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: VK */
    public boolean mo25576VK() {
        return !TextUtils.isEmpty(this.bQl);
    }

    /* renamed from: VL */
    public MusicDataItem mo25577VL() {
        if (!mo25576VK()) {
            return null;
        }
        MusicDataItem musicDataItem = new MusicDataItem();
        musicDataItem.filePath = this.bQl;
        musicDataItem.title = this.mTitle;
        musicDataItem.startTimeStamp = this.bQg;
        musicDataItem.stopTimeStamp = this.bQh;
        musicDataItem.currentTimeStamp = this.bQi;
        return musicDataItem;
    }

    /* renamed from: VM */
    public boolean mo25578VM() {
        return this.bQi == this.bQh;
    }

    /* renamed from: VN */
    public boolean mo25579VN() {
        return this.bQi > this.bQg;
    }

    /* renamed from: a */
    public void mo25580a(C5004b bVar) {
        this.bQk = bVar;
    }

    /* renamed from: eW */
    public void mo25581eW(String str) {
        this.bQl = str;
        if (TextUtils.isEmpty(str)) {
            if (this.bQf != null) {
                try {
                    this.bQf.stop();
                    this.bQf.reset();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("setSource() Error:");
                    sb.append(e.getMessage());
                    LogUtils.m14223i("CameraMusicMgr", sb.toString());
                }
            }
            return;
        }
        this.bQg = 0;
        this.bQi = 0;
        if (this.bQf != null) {
            try {
                this.bQf.stop();
                this.bQf.reset();
                this.bQf.setDataSource(str);
                this.bQf.prepare();
                this.bQg = 0;
                this.bQi = 0;
                this.bQh = this.bQf.getDuration();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setSource() Error:");
                sb2.append(Arrays.toString(e2.getStackTrace()));
                LogUtils.m14223i("CameraMusicMgr", sb2.toString());
            }
        }
    }

    public boolean isPlaying() {
        return this.bQf != null && mo25576VK() && this.bQf.isPlaying();
    }

    public void pause() {
        if (mo25576VK() && this.bQf != null) {
            try {
                this.bQj.removeMessages(4097);
                this.bQf.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void play() {
        if (mo25576VK() && this.bQf != null) {
            this.bQf.setOnCompletionListener(this.bQn);
            try {
                this.bQj.removeMessages(4097);
                this.bQj.sendMessage(this.bQj.obtainMessage(4097));
                this.bQf.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void reset() {
        if (mo25576VK() && this.bQf != null) {
            try {
                this.bQj.removeMessages(4097);
                this.bQf.stop();
                this.bQf.reset();
                this.bQl = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void seekTo(int i) {
        if (mo25576VK() && this.bQf != null) {
            try {
                this.bQi = i;
                this.bQf.seekTo(i);
            } catch (Exception e) {
                LogUtils.m14223i("CameraMusicMgr", e.getMessage());
            }
        }
    }

    public void setLooping(boolean z) {
        this.bQm = z;
    }

    public void setRange(int i, int i2) {
        this.bQg = i;
        this.bQh = i2;
        seekTo(this.bQg);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}
