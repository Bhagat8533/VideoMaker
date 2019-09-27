package com.introvd.template.common.p236ui.custom;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Surface;
import com.introvd.template.app.p199v5.videoexplore.C4453b.C4459a;
import com.introvd.template.app.p199v5.videoexplore.ToolVideoView;
import com.introvd.template.app.p199v5.videoexplore.ToolVideoView.C4445d;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.p153p.C3209a;
import com.introvd.template.p203b.C4597i;
import com.quvideo.xyvideoplayer.library.C9196b;
import com.quvideo.xyvideoplayer.library.C9197c;
import java.io.EOFException;

/* renamed from: com.introvd.template.common.ui.custom.VideoViewModelForVideoExplore */
public class VideoViewModelForVideoExplore implements C4445d {
    private static VideoViewModelForVideoExplore chv;
    /* access modifiers changed from: private */
    public ToolVideoView bHl;
    /* access modifiers changed from: private */
    public C9196b cho;
    /* access modifiers changed from: private */
    public boolean chp;
    private boolean chq;
    private String chr;
    private C9197c cht = new C9197c() {
        private long time = 0;

        /* renamed from: F */
        public void mo24203F(long j) {
        }

        /* renamed from: Oy */
        public void mo24204Oy() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.time >= 1000) {
                this.time = currentTimeMillis;
                if (VideoViewModelForVideoExplore.this.chp) {
                    VideoViewModelForVideoExplore.this.seekTo(0);
                    VideoViewModelForVideoExplore.this.startVideo();
                    if (VideoViewModelForVideoExplore.this.chw != null) {
                        VideoViewModelForVideoExplore.this.chw.addPlayCount();
                    }
                }
                if (!VideoViewModelForVideoExplore.this.chp) {
                    VideoViewModelForVideoExplore.this.bHl.setPlayState(false);
                    VideoViewModelForVideoExplore.this.bHl.hideControllerDelay(0);
                    VideoViewModelForVideoExplore.this.bHl.setPlayPauseBtnState(false);
                    VideoViewModelForVideoExplore.this.cho.pause();
                    VideoViewModelForVideoExplore.this.seekTo(0);
                    C4597i.m11729b(false, (Activity) VideoViewModelForVideoExplore.this.bHl.getContext());
                }
                if (VideoViewModelForVideoExplore.this.chw != null) {
                    VideoViewModelForVideoExplore.this.chw.onVideoCompletion();
                }
            }
        }

        /* renamed from: Oz */
        public void mo24205Oz() {
            LogUtilsV2.m14230i("onSeekComplete ");
            if (VideoViewModelForVideoExplore.this.chw != null) {
                VideoViewModelForVideoExplore.this.chw.onSeekCompletion();
            }
        }

        /* renamed from: a */
        public void mo24206a(C9196b bVar) {
            if (bVar != null) {
                LogUtilsV2.m14230i("Media Player onPrepared ");
                VideoViewModelForVideoExplore.this.bHl.setTotalTime(bVar.getDuration());
                VideoViewModelForVideoExplore.this.bHl.mo24543hU((int) bVar.getDuration());
            }
        }

        public void onBuffering(boolean z) {
            if (VideoViewModelForVideoExplore.this.chw != null) {
                VideoViewModelForVideoExplore.this.chw.onBuffering(z);
            }
        }

        public void onError(Exception exc) {
            StringBuilder sb = new StringBuilder();
            sb.append("onError : ");
            sb.append(exc.getMessage());
            LogUtilsV2.m14228e(sb.toString());
            boolean z = exc.getCause() instanceof EOFException;
        }

        public void onPaused() {
        }

        public void onPlayerPreReset() {
            if (VideoViewModelForVideoExplore.this.chw != null) {
                VideoViewModelForVideoExplore.this.chw.onPlayerPreReset();
            }
        }

        public void onPlayerReset() {
            if (VideoViewModelForVideoExplore.this.chw != null) {
                VideoViewModelForVideoExplore.this.chw.onPlayerReset();
            }
        }

        public void onStarted() {
        }

        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            int measuredWidth = VideoViewModelForVideoExplore.this.bHl.getMeasuredWidth();
            int measuredHeight = VideoViewModelForVideoExplore.this.bHl.getMeasuredHeight();
            if (measuredWidth > 0 && measuredHeight > 0) {
                if (i2 == 0 || i == 0) {
                    VideoViewModelForVideoExplore.this.bHl.setTextureViewSize(measuredWidth, measuredHeight);
                    return;
                }
                if (measuredWidth > measuredHeight) {
                    measuredHeight = (i2 * measuredWidth) / i;
                } else {
                    measuredWidth = (i * measuredHeight) / i2;
                }
                VideoViewModelForVideoExplore.this.bHl.setTextureViewSize(measuredWidth, measuredHeight);
            }
        }

        public void onVideoStartRender() {
            if (VideoViewModelForVideoExplore.this.chw != null) {
                VideoViewModelForVideoExplore.this.chw.onVideoStartRender();
            }
        }
    };
    /* access modifiers changed from: private */
    public C4459a chw;
    private Runnable chx = new Runnable() {
        public void run() {
            if (VideoViewModelForVideoExplore.this.bHl.mo24540Rd()) {
                if (VideoViewModelForVideoExplore.this.isVideoPlaying()) {
                    VideoViewModelForVideoExplore.this.bHl.setCurrentTime(VideoViewModelForVideoExplore.this.cho.getCurrentPosition());
                }
                VideoViewModelForVideoExplore.this.bHl.postDelayed(this, 1000);
            }
        }
    };

    private VideoViewModelForVideoExplore(Context context, int i) {
        this.cho = VideoAutoPlayHelper.newPlayerInstance(context);
        this.cho.mo36239a(this.cht);
    }

    public static VideoViewModelForVideoExplore getInstance(Context context, int i) {
        if (chv == null) {
            chv = new VideoViewModelForVideoExplore(context, i);
        }
        return chv;
    }

    public long getDuration() {
        return this.cho.getDuration();
    }

    public boolean isVideoPlaying() {
        return this.cho.isPlaying();
    }

    public void onControllerShown() {
        if (this.cho != null && this.cho.isPlaying()) {
            this.bHl.setCurrentTime(this.cho.getCurrentPosition());
            this.bHl.removeCallbacks(this.chx);
            this.bHl.post(this.chx);
        }
    }

    public boolean onDoubleClick() {
        return this.chw != null && this.chw.onDoubleClick();
    }

    public void onFullScreenClick() {
        pauseVideo();
        if (this.chw != null) {
            this.chw.mo24624L(this.cho.getCurrentPosition());
        }
    }

    public void onPauseClick() {
        pauseVideo();
    }

    public void onPlayClick() {
        startVideo();
    }

    public void onSeekChanged(long j) {
        seekTo(j);
    }

    public void onSilentModeChanged(boolean z) {
        setMute(z);
        C3209a.aJZ().mo18327jy(z);
    }

    public void onSurfaceTextureAvailable(Surface surface) {
        if (this.chq && !TextUtils.isEmpty(this.chr)) {
            this.cho.setSurface(surface);
            this.cho.mo36247ro(this.chr);
            this.chq = false;
            this.chr = null;
        }
    }

    public void onSurfaceTextureDestroyed(Surface surface) {
    }

    public void pauseVideo() {
        if (this.cho != null) {
            this.cho.pause();
        }
        if (this.bHl != null) {
            C4597i.m11729b(false, (Activity) this.bHl.getContext());
            this.bHl.setPlayState(false);
            this.bHl.setPlayPauseBtnState(false);
            this.bHl.removeCallbacks(this.chx);
        }
        if (this.chw != null) {
            this.chw.mo24625Rp();
        }
    }

    public void release() {
        if (this.cho != null) {
            this.cho.release();
            this.cho = null;
            chv = null;
        }
    }

    public void resetPlayer() {
        if (this.bHl != null) {
            this.bHl.removeCallbacks(this.chx);
        }
        this.chr = null;
        this.chq = false;
        if (this.cho != null) {
            this.cho.reset();
        }
    }

    public void seekTo(long j) {
        this.cho.seekTo(j);
        this.bHl.setTotalTime(this.cho.getDuration());
        this.bHl.setCurrentTime(j);
    }

    public void setListener(C4459a aVar) {
        this.chw = aVar;
    }

    public void setLooping(boolean z) {
        this.chp = z;
    }

    public void setMute(boolean z) {
        this.cho.setMute(z);
    }

    public void setVideoUrl(String str) {
        if (this.cho != null) {
            this.bHl.setPlayState(false);
            Surface surface = this.bHl.getSurface();
            if (surface == null) {
                this.chq = true;
                this.chr = str;
                return;
            }
            this.cho.setSurface(surface);
            this.cho.mo36247ro(str);
        }
    }

    public void setVideoView(ToolVideoView toolVideoView) {
        this.bHl = toolVideoView;
        this.bHl.setVideoViewListener(this);
    }

    public void startVideo() {
        if (this.cho != null && this.bHl != null) {
            C4597i.m11729b(true, (Activity) this.bHl.getContext());
            this.cho.start();
            this.bHl.setPlayState(true);
            this.bHl.hideControllerDelay(0);
            this.bHl.removeCallbacks(this.chx);
            this.bHl.post(this.chx);
        }
    }
}
