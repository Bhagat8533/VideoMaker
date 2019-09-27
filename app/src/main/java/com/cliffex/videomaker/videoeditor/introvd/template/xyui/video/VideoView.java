package com.introvd.template.xyui.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.introvd.template.router.todoCode.TodoConstants;

public class VideoView extends SurfaceView {
    private String TAG;
    /* access modifiers changed from: private */
    public MediaPlayer bQf;
    /* access modifiers changed from: private */
    public OnCompletionListener bQn;
    /* access modifiers changed from: private */
    public int eDR;
    /* access modifiers changed from: private */
    public int eDS;
    /* access modifiers changed from: private */
    public SurfaceHolder eDT;
    /* access modifiers changed from: private */
    public int eDU;
    /* access modifiers changed from: private */
    public int eDV;
    /* access modifiers changed from: private */
    public int eDW;
    /* access modifiers changed from: private */
    public int eDX;
    /* access modifiers changed from: private */
    public int eDY;
    /* access modifiers changed from: private */
    public C9183a eDZ;
    OnVideoSizeChangedListener eEa;
    OnPreparedListener eEb;
    private OnCompletionListener eEc;
    private OnInfoListener eEd;
    private OnSeekCompleteListener eEe;
    private OnErrorListener eEf;
    Callback eEg;
    private int mDuration;
    private Uri mUri;

    public VideoView(Context context) {
        super(context);
        this.TAG = "VideoView";
        this.eDR = 0;
        this.eDS = 0;
        this.eDT = null;
        this.bQf = null;
        this.eEa = new OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.eDU = mediaPlayer.getVideoWidth();
                VideoView.this.eDV = mediaPlayer.getVideoHeight();
                if (VideoView.this.eDU != 0 && VideoView.this.eDV != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.eDU, VideoView.this.eDV);
                }
            }
        };
        this.eEb = new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoView.this.eDR = 2;
                if (VideoView.this.eDZ != null) {
                    VideoView.this.eDZ.onPrepared(VideoView.this.bQf);
                }
                VideoView.this.eDU = mediaPlayer.getVideoWidth();
                VideoView.this.eDV = mediaPlayer.getVideoHeight();
                int e = VideoView.this.eDY;
                if (e != 0) {
                    VideoView.this.seekTo(e);
                }
                if (VideoView.this.eDU != 0 && VideoView.this.eDV != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.eDU, VideoView.this.eDV);
                    if (VideoView.this.eDW != VideoView.this.eDU || VideoView.this.eDX != VideoView.this.eDV) {
                        return;
                    }
                    if (VideoView.this.eDS == 3) {
                        VideoView.this.start();
                        if (VideoView.this.eDZ != null) {
                            VideoView.this.eDZ.aqv();
                        }
                    } else if (VideoView.this.isPlaying()) {
                    } else {
                        if ((e != 0 || VideoView.this.getCurrentPosition() > 0) && VideoView.this.eDZ != null) {
                            VideoView.this.eDZ.aqv();
                        }
                    }
                } else if (VideoView.this.eDS == 3) {
                    VideoView.this.start();
                }
            }
        };
        this.eEc = new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoView.this.eDR = 5;
                VideoView.this.eDS = 5;
                VideoView.this.bQf.seekTo(0);
                if (VideoView.this.bQn != null) {
                    VideoView.this.bQn.onCompletion(VideoView.this.bQf);
                }
                if (VideoView.this.eDZ != null) {
                    VideoView.this.eDZ.aqv();
                    VideoView.this.eDZ.onCompletion(VideoView.this.bQf);
                }
            }
        };
        this.eEd = new OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                switch (i) {
                    case TodoConstants.TODO_TYPE_STUDIO /*701*/:
                        if (VideoView.this.eDZ != null) {
                            VideoView.this.eDZ.onBuffering(true);
                            break;
                        }
                        break;
                    case 702:
                        if (VideoView.this.eDZ != null) {
                            VideoView.this.eDZ.onBuffering(false);
                            break;
                        }
                        break;
                }
                return false;
            }
        };
        this.eEe = new OnSeekCompleteListener() {
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                if (VideoView.this.eDZ != null && mediaPlayer != null) {
                    VideoView.this.eDZ.mo30103oU(mediaPlayer.getCurrentPosition());
                }
            }
        };
        this.eEf = new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.eDR = -1;
                VideoView.this.eDS = -1;
                if (VideoView.this.eDZ != null) {
                    VideoView.this.eDZ.aqw();
                    VideoView.this.eDZ.onError(VideoView.this.bQf, i, i2);
                }
                return true;
            }
        };
        this.eEg = new Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                VideoView.this.eDW = i2;
                VideoView.this.eDX = i3;
                boolean z = false;
                boolean z2 = VideoView.this.eDS == 3;
                if (VideoView.this.eDU == i2 && VideoView.this.eDV == i3) {
                    z = true;
                }
                if (VideoView.this.bQf != null && z2 && z) {
                    if (VideoView.this.eDY != 0) {
                        VideoView.this.seekTo(VideoView.this.eDY);
                    }
                    VideoView.this.start();
                    if (VideoView.this.eDZ != null) {
                        if (VideoView.this.eDZ.aqu()) {
                            VideoView.this.eDZ.aqw();
                        }
                        VideoView.this.eDZ.aqv();
                    }
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView.this.eDT = surfaceHolder;
                VideoView.this.aOg();
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView.this.eDT = null;
                if (VideoView.this.eDZ != null) {
                    VideoView.this.eDZ.aqw();
                }
                VideoView.this.mo36197aM(true);
            }
        };
        aOf();
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        aOf();
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "VideoView";
        this.eDR = 0;
        this.eDS = 0;
        this.eDT = null;
        this.bQf = null;
        this.eEa = new OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.eDU = mediaPlayer.getVideoWidth();
                VideoView.this.eDV = mediaPlayer.getVideoHeight();
                if (VideoView.this.eDU != 0 && VideoView.this.eDV != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.eDU, VideoView.this.eDV);
                }
            }
        };
        this.eEb = new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoView.this.eDR = 2;
                if (VideoView.this.eDZ != null) {
                    VideoView.this.eDZ.onPrepared(VideoView.this.bQf);
                }
                VideoView.this.eDU = mediaPlayer.getVideoWidth();
                VideoView.this.eDV = mediaPlayer.getVideoHeight();
                int e = VideoView.this.eDY;
                if (e != 0) {
                    VideoView.this.seekTo(e);
                }
                if (VideoView.this.eDU != 0 && VideoView.this.eDV != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.eDU, VideoView.this.eDV);
                    if (VideoView.this.eDW != VideoView.this.eDU || VideoView.this.eDX != VideoView.this.eDV) {
                        return;
                    }
                    if (VideoView.this.eDS == 3) {
                        VideoView.this.start();
                        if (VideoView.this.eDZ != null) {
                            VideoView.this.eDZ.aqv();
                        }
                    } else if (VideoView.this.isPlaying()) {
                    } else {
                        if ((e != 0 || VideoView.this.getCurrentPosition() > 0) && VideoView.this.eDZ != null) {
                            VideoView.this.eDZ.aqv();
                        }
                    }
                } else if (VideoView.this.eDS == 3) {
                    VideoView.this.start();
                }
            }
        };
        this.eEc = new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoView.this.eDR = 5;
                VideoView.this.eDS = 5;
                VideoView.this.bQf.seekTo(0);
                if (VideoView.this.bQn != null) {
                    VideoView.this.bQn.onCompletion(VideoView.this.bQf);
                }
                if (VideoView.this.eDZ != null) {
                    VideoView.this.eDZ.aqv();
                    VideoView.this.eDZ.onCompletion(VideoView.this.bQf);
                }
            }
        };
        this.eEd = new OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                switch (i) {
                    case TodoConstants.TODO_TYPE_STUDIO /*701*/:
                        if (VideoView.this.eDZ != null) {
                            VideoView.this.eDZ.onBuffering(true);
                            break;
                        }
                        break;
                    case 702:
                        if (VideoView.this.eDZ != null) {
                            VideoView.this.eDZ.onBuffering(false);
                            break;
                        }
                        break;
                }
                return false;
            }
        };
        this.eEe = new OnSeekCompleteListener() {
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                if (VideoView.this.eDZ != null && mediaPlayer != null) {
                    VideoView.this.eDZ.mo30103oU(mediaPlayer.getCurrentPosition());
                }
            }
        };
        this.eEf = new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.eDR = -1;
                VideoView.this.eDS = -1;
                if (VideoView.this.eDZ != null) {
                    VideoView.this.eDZ.aqw();
                    VideoView.this.eDZ.onError(VideoView.this.bQf, i, i2);
                }
                return true;
            }
        };
        this.eEg = new Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                VideoView.this.eDW = i2;
                VideoView.this.eDX = i3;
                boolean z = false;
                boolean z2 = VideoView.this.eDS == 3;
                if (VideoView.this.eDU == i2 && VideoView.this.eDV == i3) {
                    z = true;
                }
                if (VideoView.this.bQf != null && z2 && z) {
                    if (VideoView.this.eDY != 0) {
                        VideoView.this.seekTo(VideoView.this.eDY);
                    }
                    VideoView.this.start();
                    if (VideoView.this.eDZ != null) {
                        if (VideoView.this.eDZ.aqu()) {
                            VideoView.this.eDZ.aqw();
                        }
                        VideoView.this.eDZ.aqv();
                    }
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView.this.eDT = surfaceHolder;
                VideoView.this.aOg();
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView.this.eDT = null;
                if (VideoView.this.eDZ != null) {
                    VideoView.this.eDZ.aqw();
                }
                VideoView.this.mo36197aM(true);
            }
        };
        aOf();
    }

    private void aOf() {
        this.eDU = 0;
        this.eDV = 0;
        getHolder().addCallback(this.eEg);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.eDR = 0;
        this.eDS = 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:4|5|6|7|8|(1:10)|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0080 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void aOg() {
        /*
            r6 = this;
            android.net.Uri r0 = r6.mUri
            if (r0 == 0) goto L_0x00a7
            android.view.SurfaceHolder r0 = r6.eDT
            if (r0 != 0) goto L_0x000a
            goto L_0x00a7
        L_0x000a:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.diii.music.musicservicecommand"
            r0.<init>(r1)
            java.lang.String r1 = "command"
            java.lang.String r2 = "pause"
            r0.putExtra(r1, r2)
            android.content.Context r1 = r6.getContext()
            r1.sendBroadcast(r0)
            r0 = 0
            r6.mo36197aM(r0)
            r1 = 1
            r2 = -1
            android.media.MediaPlayer r3 = new android.media.MediaPlayer     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r3.<init>()     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r6.bQf = r3     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer$OnPreparedListener r4 = r6.eEb     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r3.setOnPreparedListener(r4)     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer$OnVideoSizeChangedListener r4 = r6.eEa     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r3.setOnVideoSizeChangedListener(r4)     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r6.mDuration = r2     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer$OnCompletionListener r4 = r6.eEc     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r3.setOnCompletionListener(r4)     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer$OnSeekCompleteListener r4 = r6.eEe     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r3.setOnSeekCompleteListener(r4)     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer$OnErrorListener r4 = r6.eEf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r3.setOnErrorListener(r4)     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.content.Context r4 = r6.getContext()     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.net.Uri r5 = r6.mUri     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r3.setDataSource(r4, r5)     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.view.SurfaceHolder r4 = r6.eDT     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r3.setDisplay(r4)     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r4 = 3
            r3.setAudioStreamType(r4)     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r3.setScreenOnWhilePlaying(r1)     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            r3.prepareAsync()     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0080 }
            r4 = 17
            if (r3 < r4) goto L_0x0080
            android.media.MediaPlayer r3 = r6.bQf     // Catch:{ Throwable -> 0x0080 }
            android.media.MediaPlayer$OnInfoListener r4 = r6.eEd     // Catch:{ Throwable -> 0x0080 }
            r3.setOnInfoListener(r4)     // Catch:{ Throwable -> 0x0080 }
        L_0x0080:
            r6.eDR = r1     // Catch:{ IOException -> 0x009b, IllegalArgumentException -> 0x008f, Exception -> 0x0083 }
            return
        L_0x0083:
            r6.eDR = r2
            r6.eDS = r2
            android.media.MediaPlayer$OnErrorListener r2 = r6.eEf
            android.media.MediaPlayer r3 = r6.bQf
            r2.onError(r3, r1, r0)
            return
        L_0x008f:
            r6.eDR = r2
            r6.eDS = r2
            android.media.MediaPlayer$OnErrorListener r2 = r6.eEf
            android.media.MediaPlayer r3 = r6.bQf
            r2.onError(r3, r1, r0)
            return
        L_0x009b:
            r6.eDR = r2
            r6.eDS = r2
            android.media.MediaPlayer$OnErrorListener r2 = r6.eEf
            android.media.MediaPlayer r3 = r6.bQf
            r2.onError(r3, r1, r0)
            return
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.xyui.video.VideoView.aOg():void");
    }

    private void aOh() {
        if (this.eDZ == null) {
            return;
        }
        if (this.eDZ.aqu()) {
            this.eDZ.aqw();
        } else {
            this.eDZ.aqv();
        }
    }

    /* renamed from: aM */
    public void mo36197aM(boolean z) {
        if (this.bQf != null) {
            this.bQf.reset();
            this.bQf.release();
            this.bQf = null;
            this.eDR = 0;
            if (z) {
                this.eDS = 0;
            }
        }
    }

    public boolean aOi() {
        return (this.bQf == null || this.eDR == -1 || this.eDR == 0 || this.eDR == 1) ? false : true;
    }

    public int getCurrentPosition() {
        if (aOi()) {
            return this.bQf.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (!aOi()) {
            this.mDuration = -1;
            return this.mDuration;
        } else if (this.mDuration > 0) {
            return this.mDuration;
        } else {
            this.mDuration = this.bQf.getDuration();
            return this.mDuration;
        }
    }

    public int getVideoHeight() {
        if (this.bQf != null) {
            return this.bQf.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        if (this.bQf != null) {
            return this.bQf.getVideoWidth();
        }
        return 0;
    }

    public int getmCurrentState() {
        return this.eDR;
    }

    public MediaPlayer getmMediaPlayer() {
        return this.bQf;
    }

    public boolean isPlaying() {
        return aOi() && this.bQf.isPlaying();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 82 || i == 5 || i == 6) ? false : true;
        if (aOi() && z && this.eDZ != null) {
            if (i == 79 || i == 85) {
                if (this.bQf.isPlaying()) {
                    pause();
                    this.eDZ.aqv();
                } else {
                    start();
                    this.eDZ.aqw();
                }
                return true;
            } else if (i != 86 || !this.bQf.isPlaying()) {
                aOh();
            } else {
                pause();
                this.eDZ.aqv();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.eDU, i);
        int defaultSize2 = getDefaultSize(this.eDV, i2);
        if (this.eDU > 0 && this.eDV > 0) {
            if (this.eDU * defaultSize2 > this.eDV * defaultSize) {
                defaultSize2 = (this.eDV * defaultSize) / this.eDU;
            } else if (this.eDU * defaultSize2 < this.eDV * defaultSize) {
                defaultSize = (this.eDU * defaultSize2) / this.eDV;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (aOi() && this.eDZ != null) {
            aOh();
        }
        if (isPlaying()) {
            this.eDZ.aqx();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (aOi() && this.eDZ != null) {
            aOh();
        }
        return false;
    }

    public void pause() {
        if (aOi() && this.bQf.isPlaying()) {
            this.bQf.pause();
            this.eDR = 4;
        }
        this.eDS = 4;
    }

    public synchronized void seekTo(int i) {
        if (aOi()) {
            this.bQf.seekTo(i);
            this.eDY = 0;
        } else {
            this.eDY = i;
        }
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.bQn = onCompletionListener;
    }

    public void setVideoURI(Uri uri) {
        this.mUri = uri;
        this.eDY = 0;
        aOg();
        requestLayout();
        invalidate();
    }

    public void setVideoViewListener(C9183a aVar) {
        this.eDZ = aVar;
    }

    public void start() {
        if (aOi()) {
            this.bQf.start();
            this.eDR = 3;
        }
        this.eDS = 3;
    }

    public void stop() {
        if (this.bQf != null) {
            this.bQf.stop();
            this.bQf.release();
            this.bQf = null;
            this.eDR = 0;
            this.eDS = 0;
        }
    }
}
