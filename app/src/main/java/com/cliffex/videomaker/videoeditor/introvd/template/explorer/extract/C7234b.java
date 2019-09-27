package com.introvd.template.explorer.extract;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import android.os.Message;
import com.introvd.template.common.controller.BaseController;
import java.io.IOException;
import java.lang.ref.WeakReference;
import xiaoying.utils.LogUtils;

/* renamed from: com.introvd.template.explorer.extract.b */
public class C7234b extends BaseController<C7237d> implements OnCompletionListener, OnPreparedListener, OnSeekCompleteListener {
    public static final String TAG = "b";
    private MediaPlayer bQf;
    /* access modifiers changed from: private */
    public boolean dyv = true;
    /* access modifiers changed from: private */
    public C7235a dyw = new C7235a(this);

    /* renamed from: com.introvd.template.explorer.extract.b$a */
    public static class C7235a extends Handler {
        private WeakReference<C7234b> cYS;

        C7235a(C7234b bVar) {
            this.cYS = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1001) {
                ((C7234b) this.cYS.get()).awj();
                if (((C7234b) this.cYS.get()).dyv) {
                    ((C7234b) this.cYS.get()).dyw.sendEmptyMessageDelayed(1001, 100);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void awj() {
        if (this.bQf != null && getMvpView() != null) {
            int currentPosition = (this.bQf.getCurrentPosition() * 100) / this.bQf.getDuration();
            if (currentPosition >= 100) {
                this.dyv = false;
            }
            ((C7237d) getMvpView()).mo31710qy(currentPosition);
        }
    }

    /* renamed from: a */
    public void attachView(C7237d dVar) {
        super.attachView(dVar);
    }

    public void detachView() {
        super.detachView();
    }

    /* renamed from: eg */
    public void mo31743eg(String str) {
        this.bQf = new MediaPlayer();
        try {
            this.bQf.setOnCompletionListener(this);
            this.bQf.setOnSeekCompleteListener(this);
            this.bQf.setDataSource(str);
            this.bQf.prepare();
            this.bQf.setOnPreparedListener(this);
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.m28708e(TAG, " music play fail");
        }
    }

    public void onActivityDestory() {
        if (this.bQf != null) {
            this.bQf.release();
            this.bQf = null;
        }
    }

    public void onActivityPause() {
        pause();
    }

    public void onActivityResume() {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.dyv = false;
        this.dyw.removeMessages(1001);
        ((C7237d) getMvpView()).mo31710qy(100);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null && getMvpView() != null) {
            ((C7237d) getMvpView()).mo31711qz(mediaPlayer.getDuration());
        }
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.dyw.sendEmptyMessageDelayed(1001, 100);
    }

    public void pause() {
        if (this.bQf != null && this.bQf.isPlaying()) {
            this.dyv = false;
            this.dyw.removeMessages(1001);
            this.bQf.pause();
        }
    }

    public void play() {
        if (this.bQf != null && !this.bQf.isPlaying()) {
            this.dyv = true;
            this.bQf.start();
            this.dyw.sendEmptyMessage(1001);
        }
    }

    public void seekTo(int i) {
        if (this.bQf != null) {
            this.dyw.removeMessages(1001);
            this.bQf.seekTo((this.bQf.getDuration() * i) / 100);
        }
    }
}
