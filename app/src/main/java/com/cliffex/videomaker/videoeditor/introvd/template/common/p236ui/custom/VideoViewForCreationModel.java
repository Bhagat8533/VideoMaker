package com.introvd.template.common.p236ui.custom;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Surface;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.custom.CustomVideoForCreationView.VideoViewListener;
import com.introvd.template.p203b.C4597i;
import com.quvideo.xyvideoplayer.library.C9196b;
import com.quvideo.xyvideoplayer.library.C9197c;

/* renamed from: com.introvd.template.common.ui.custom.VideoViewForCreationModel */
public class VideoViewForCreationModel implements VideoViewListener {
    private static VideoViewForCreationModel chm;
    /* access modifiers changed from: private */
    public CustomVideoForCreationView chn;
    /* access modifiers changed from: private */
    public C9196b cho;
    /* access modifiers changed from: private */
    public boolean chp;
    private boolean chq;
    private String chr;
    /* access modifiers changed from: private */
    public VideoPlayControlListener chs;
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
                if (VideoViewForCreationModel.this.chp) {
                    VideoViewForCreationModel.this.seekTo(0);
                    VideoViewForCreationModel.this.startVideo();
                    if (VideoViewForCreationModel.this.chs != null) {
                        VideoViewForCreationModel.this.chs.addPlayCount();
                    }
                }
                if (!VideoViewForCreationModel.this.chp) {
                    VideoViewForCreationModel.this.chn.setPlayState(false);
                    VideoViewForCreationModel.this.chn.hideControllerDelay(0);
                    VideoViewForCreationModel.this.chn.setPlayPauseBtnState(false);
                    VideoViewForCreationModel.this.cho.pause();
                    VideoViewForCreationModel.this.seekTo(0);
                    C4597i.m11729b(false, (Activity) VideoViewForCreationModel.this.chn.getContext());
                }
                if (VideoViewForCreationModel.this.chs != null) {
                    VideoViewForCreationModel.this.chs.onVideoCompletion();
                }
            }
        }

        /* renamed from: Oz */
        public void mo24205Oz() {
            LogUtilsV2.m14230i("onSeekComplete ");
            if (VideoViewForCreationModel.this.chs != null) {
                VideoViewForCreationModel.this.chs.onSeekCompletion();
            }
        }

        /* renamed from: a */
        public void mo24206a(C9196b bVar) {
        }

        public void onBuffering(boolean z) {
            if (VideoViewForCreationModel.this.chs != null) {
                VideoViewForCreationModel.this.chs.onBuffering(z);
            }
        }

        public void onError(Exception exc) {
            StringBuilder sb = new StringBuilder();
            sb.append("onError : ");
            sb.append(exc.getMessage());
            LogUtilsV2.m14228e(sb.toString());
        }

        public void onPaused() {
        }

        public void onPlayerPreReset() {
            if (VideoViewForCreationModel.this.chs != null) {
                VideoViewForCreationModel.this.chs.onPlayerPreReset();
            }
        }

        public void onPlayerReset() {
            if (VideoViewForCreationModel.this.chs != null) {
                VideoViewForCreationModel.this.chs.onPlayerReset();
            }
        }

        public void onStarted() {
        }

        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            int measuredWidth = VideoViewForCreationModel.this.chn.getMeasuredWidth();
            int measuredHeight = VideoViewForCreationModel.this.chn.getMeasuredHeight();
            if (measuredWidth > 0 && measuredHeight > 0) {
                if (i2 == 0 || i == 0) {
                    VideoViewForCreationModel.this.chn.setTextureViewSize(measuredWidth, measuredHeight);
                    return;
                }
                if (measuredWidth > measuredHeight) {
                    measuredHeight = (i2 * measuredWidth) / i;
                } else {
                    measuredWidth = (i * measuredHeight) / i2;
                }
                VideoViewForCreationModel.this.chn.setTextureViewSize(measuredWidth, measuredHeight);
            }
        }

        public void onVideoStartRender() {
            if (VideoViewForCreationModel.this.chs != null) {
                VideoViewForCreationModel.this.chs.onVideoStartRender();
            }
        }
    };

    /* renamed from: com.introvd.template.common.ui.custom.VideoViewForCreationModel$VideoPlayControlListener */
    public interface VideoPlayControlListener {
        void addPlayCount();

        void onBuffering(boolean z);

        void onPauseVideo();

        void onPlayerPreReset();

        void onPlayerReset();

        void onSeekCompletion();

        void onVideoCompletion();

        void onVideoStartRender();

        void onViewClick();
    }

    private VideoViewForCreationModel(Context context) {
        this.cho = VideoAutoPlayHelper.newPlayerInstance(context);
        this.cho.mo36239a(this.cht);
    }

    public static VideoViewForCreationModel getInstance(Context context) {
        if (chm == null) {
            chm = new VideoViewForCreationModel(context);
        }
        return chm;
    }

    public long getCurDuration() {
        return this.cho.getCurrentPosition();
    }

    public long getDuration() {
        return this.cho.getDuration();
    }

    public long getRealPlayDuration() {
        return this.cho.getRealPlayDuration();
    }

    public boolean isVideoPlaying() {
        return this.cho.isPlaying();
    }

    public void onPauseClick() {
        if (!AppStateModel.getInstance().isCommunitySupport() || this.chs == null) {
            pauseVideo();
        } else {
            this.chs.onViewClick();
        }
    }

    public void onPlayClick() {
        if (!AppStateModel.getInstance().isCommunitySupport() || this.chs == null) {
            startVideo();
        } else {
            this.chs.onViewClick();
        }
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
        if (this.chn != null) {
            C4597i.m11729b(false, (Activity) this.chn.getContext());
            this.chn.setPlayState(false);
            this.chn.setPlayPauseBtnState(false);
        }
        if (this.chs != null) {
            this.chs.onPauseVideo();
        }
    }

    public void resetPlayer() {
        this.chr = null;
        this.chq = false;
        this.cho.reset();
    }

    public void seekTo(int i) {
        this.cho.seekTo((long) i);
    }

    public void setListener(VideoPlayControlListener videoPlayControlListener) {
        this.chs = videoPlayControlListener;
    }

    public void setLooping(boolean z) {
        this.chp = z;
    }

    public void setMute(boolean z) {
        this.cho.setMute(z);
    }

    public void setVideoUrl(String str) throws IllegalStateException {
        if (this.cho != null) {
            this.chn.setPlayState(false);
            Surface surface = this.chn.getSurface();
            if (surface == null) {
                this.chq = true;
                this.chr = str;
                return;
            }
            this.cho.setSurface(surface);
            this.cho.mo36247ro(str);
        }
    }

    public void setVideoView(CustomVideoForCreationView customVideoForCreationView) {
        this.chn = customVideoForCreationView;
        this.chn.setVideoViewListener(this);
    }

    public void startVideo() {
        if (this.cho != null && this.chn != null) {
            C4597i.m11729b(true, (Activity) this.chn.getContext());
            this.cho.start();
            this.chn.setPlayState(true);
            this.chn.hideControllerDelay(0);
        }
    }
}
