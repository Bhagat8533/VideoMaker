package com.introvd.template.explorer.music;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Message;
import com.introvd.template.common.LogUtils;
import com.introvd.template.explorer.music.p304b.C7262a;
import com.introvd.template.explorer.music.p304b.C7266e;
import com.introvd.template.explorer.music.p304b.C7267f;
import com.introvd.template.explorer.p300e.C7208b;
import com.introvd.template.p203b.C4597i;
import java.lang.ref.WeakReference;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.introvd.template.explorer.music.b */
public class C7257b {
    /* access modifiers changed from: private */
    public MediaPlayer bQf;
    private OnCompletionListener bQn = new OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (!C7257b.this.dAm) {
                C7257b.this.dAk = true;
                if (C7257b.this.dAi != null) {
                    C7257b.this.bQf.seekTo(C7257b.this.dAg);
                    C10021c.aZH().mo38492aA(new C7267f(C7257b.this.dAi, 3));
                }
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
            LogUtils.m14223i("MusicPlayerManager", sb.toString());
            return false;
        }
    };
    private OnPreparedListener bQp = new OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (C7257b.this.dAn) {
                C7257b.this.dAn = false;
                C7257b.this.dAg = 0;
                C7257b.this.dAh = C7257b.this.bQf.getDuration();
                C7267f fVar = new C7267f(C7257b.this.dAi, 1);
                fVar.setDuration(C7257b.this.bQf.getDuration());
                C10021c.aZH().mo38492aA(fVar);
            }
            C7257b.this.dAj.sendEmptyMessageDelayed(4097, 50);
        }
    };
    /* access modifiers changed from: private */
    public int dAg = 0;
    /* access modifiers changed from: private */
    public int dAh = 0;
    /* access modifiers changed from: private */
    public C7262a dAi;
    /* access modifiers changed from: private */
    public C7261a dAj = new C7261a(this);
    /* access modifiers changed from: private */
    public boolean dAk;
    /* access modifiers changed from: private */
    public boolean dAl;
    /* access modifiers changed from: private */
    public boolean dAm;
    /* access modifiers changed from: private */
    public boolean dAn = true;
    private boolean dAo;
    private Activity mActivity;

    /* renamed from: com.introvd.template.explorer.music.b$a */
    private static class C7261a extends Handler {
        private WeakReference<C7257b> dAq;

        C7261a(C7257b bVar) {
            this.dAq = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            C7257b bVar = (C7257b) this.dAq.get();
            if (bVar != null) {
                switch (message.what) {
                    case 4096:
                        if (bVar.bQf == null) {
                            bVar.anG();
                        }
                        bVar.dAm = false;
                        bVar.dAl = false;
                        bVar.dAn = true;
                        C7262a aVar = (C7262a) message.obj;
                        bVar.dAi = aVar;
                        bVar.m21443jg(aVar.dBl);
                        break;
                    case 4097:
                        bVar.ary();
                        break;
                    case 4098:
                        removeMessages(4100);
                        bVar.awK();
                        break;
                    case 4099:
                        removeMessages(4100);
                        bVar.awL();
                        break;
                    case 4100:
                        removeMessages(4100);
                        bVar.awM();
                        break;
                }
            }
        }
    }

    public C7257b(Activity activity) {
        this.mActivity = activity;
        C10021c.aZH().mo38494ax(this);
        anG();
    }

    /* renamed from: a */
    private void m21426a(C7262a aVar, int i) {
        if (aVar != null && m21428a(aVar)) {
            this.dAg = aVar.dBn;
            this.dAh = aVar.dBo;
            boolean z = false;
            this.dAm = Math.abs(this.dAh - this.bQf.getDuration()) > 100;
            if (this.dAg > 0) {
                z = true;
            }
            this.dAl = z;
            if (i == 1) {
                awK();
                ary();
            } else if (i == 2) {
                awK();
                m21444qI(this.dAh - 3000);
            }
        }
    }

    /* renamed from: a */
    private boolean m21428a(C7262a aVar) {
        return this.dAi != null && this.dAi.dBj.equals(aVar.dBj) && this.dAi.dBk.equals(aVar.dBk) && this.dAi.dBm == aVar.dBm;
    }

    private void aoe() {
        if (this.dAj != null) {
            this.dAj.removeCallbacksAndMessages(null);
        }
        if (this.bQf != null) {
            try {
                this.bQf.stop();
                this.bQf.reset();
                this.bQf.release();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        this.dAi = null;
    }

    /* access modifiers changed from: private */
    public void ary() {
        C7208b.m21288dF(this.mActivity);
        if (this.bQf != null && !isPlaying()) {
            try {
                if (this.dAg >= 0) {
                    this.bQf.seekTo(this.dAg);
                }
                if (awO() >= this.dAh) {
                    this.bQf.seekTo(this.dAg);
                }
                this.bQf.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.dAj.sendEmptyMessageDelayed(4100, awN());
    }

    private void awJ() {
        C7208b.m21288dF(this.mActivity);
        if (this.bQf != null && !isPlaying()) {
            try {
                if (awO() >= this.dAh) {
                    this.bQf.seekTo(this.dAg);
                }
                this.bQf.start();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        this.dAj.sendEmptyMessageDelayed(4100, awN());
    }

    /* access modifiers changed from: private */
    public void awK() {
        C4597i.m11729b(false, this.mActivity);
        if (this.bQf != null) {
            try {
                this.bQf.pause();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void awL() {
        if (this.bQf != null) {
            try {
                this.bQf.stop();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        C4597i.m11729b(false, this.mActivity);
    }

    /* access modifiers changed from: private */
    public void awM() {
        if (this.bQf != null && awO() >= 0) {
            if (awO() >= this.dAh && this.dAm) {
                this.bQf.seekTo(this.dAg);
                this.dAj.sendEmptyMessage(4098);
                C10021c.aZH().mo38492aA(new C7267f(this.dAi, 3));
            }
            if (isPlaying()) {
                this.dAj.sendEmptyMessageDelayed(4100, awN());
                C4597i.m11729b(true, this.mActivity);
            }
            C7267f fVar = new C7267f(this.dAi, 2);
            fVar.setProgress(awO());
            C10021c.aZH().mo38492aA(fVar);
        }
    }

    private long awN() {
        long j;
        try {
            j = (long) (this.dAh - awO());
        } catch (Exception e) {
            e.printStackTrace();
            j = 0;
        }
        if (j > 300) {
            return 300;
        }
        if (j < 0) {
            return 0;
        }
        return j;
    }

    private int awO() {
        try {
            return this.bQf.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return -1;
        }
    }

    private boolean isPlaying() {
        boolean z = false;
        try {
            if (this.bQf != null) {
                z = this.bQf.isPlaying();
            }
            return z;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: jg */
    public void m21443jg(String str) {
        try {
            anG();
            this.dAk = false;
            this.bQf.setDataSource(str);
            this.bQf.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: qI */
    private void m21444qI(int i) {
        C7208b.m21288dF(this.mActivity);
        if (this.bQf != null && !isPlaying()) {
            try {
                if (i >= this.dAg) {
                    this.bQf.seekTo(i);
                } else {
                    this.bQf.seekTo(this.dAg);
                }
                this.bQf.start();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        this.dAj.sendEmptyMessageDelayed(4100, awN());
    }

    public final void anG() {
        if (this.bQf != null) {
            try {
                this.bQf.reset();
                this.bQf.release();
            } catch (Exception unused) {
            }
            this.bQf = null;
        }
        this.bQf = new MediaPlayer();
        this.bQf.setAudioStreamType(3);
        this.bQf.setOnCompletionListener(this.bQn);
        this.bQf.setOnErrorListener(this.bQo);
        this.bQf.setOnPreparedListener(this.bQp);
    }

    /* renamed from: ib */
    public void mo31851ib(boolean z) {
        this.dAo = z;
        if (z) {
            release();
        } else {
            anG();
        }
    }

    public void onDetach() {
        if (this.dAj != null) {
            this.dAj.removeCallbacksAndMessages(null);
            this.dAj = null;
        }
        this.dAi = null;
        aoe();
        C10021c.aZH().mo38496az(this);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7266e eVar) {
        C7262a axn = eVar.axn();
        switch (eVar.getEventType()) {
            case 1:
                if (axn != null && !this.dAo) {
                    if (this.dAi != null && !m21428a(axn)) {
                        C7267f fVar = new C7267f(axn, 4);
                        fVar.mo31871c(this.dAi);
                        C10021c.aZH().mo38492aA(fVar);
                    }
                    if (m21428a(axn) && this.bQf != null) {
                        if (!this.dAk) {
                            awJ();
                            break;
                        } else {
                            m21443jg(this.dAi.dBl);
                            break;
                        }
                    } else {
                        this.dAj.sendMessage(this.dAj.obtainMessage(4096, axn));
                        break;
                    }
                } else {
                    return;
                }
            case 2:
                if (axn != null && m21428a(axn)) {
                    this.dAj.sendMessage(this.dAj.obtainMessage(4098));
                    break;
                }
            case 3:
                aoe();
                break;
            case 4:
                m21426a(axn, 1);
                break;
            case 5:
                m21426a(axn, 2);
                break;
        }
    }

    public void release() {
        if (!(this.dAj == null || this.dAi == null)) {
            this.dAj.removeCallbacksAndMessages(null);
        }
        if (this.bQf != null) {
            C7267f fVar = new C7267f(null, 4);
            fVar.mo31871c(this.dAi);
            C10021c.aZH().mo38492aA(fVar);
        }
        aoe();
    }
}
