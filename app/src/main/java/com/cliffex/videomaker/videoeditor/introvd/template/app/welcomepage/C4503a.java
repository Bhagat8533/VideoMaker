package com.introvd.template.app.welcomepage;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.Surface;
import com.introvd.template.R;
import com.introvd.template.common.Constants;
import com.introvd.template.common.MSize;
import com.introvd.template.common.p236ui.video.XYSimpleVideoView;
import com.introvd.template.common.p236ui.video.XYSimpleVideoView.OnSurfaceListener;
import com.introvd.template.common.utils.UtilsMSize;

/* renamed from: com.introvd.template.app.welcomepage.a */
public class C4503a {
    /* access modifiers changed from: private */
    public MediaPlayer bIS;
    /* access modifiers changed from: private */
    public XYSimpleVideoView bzr;

    public C4503a(XYSimpleVideoView xYSimpleVideoView) {
        this.bzr = xYSimpleVideoView;
        this.bzr.setOnSurfaceListener(new OnSurfaceListener() {
            public void onSurfaceCreate(Surface surface) {
                C4503a.this.bIS = new MediaPlayer();
                C4503a.this.mo24723Rz();
                C4503a.this.bIS.setSurface(surface);
            }

            public void onSurfaceDestroyed() {
                C4503a.this.mo24721Ow();
            }
        });
    }

    /* renamed from: Ow */
    public void mo24721Ow() {
        if (this.bIS != null) {
            this.bIS.release();
            this.bIS = null;
        }
    }

    /* renamed from: RA */
    public void mo24722RA() {
        if (this.bzr.getSurface() != null && this.bIS == null) {
            this.bIS = new MediaPlayer();
            mo24723Rz();
            this.bIS.setSurface(this.bzr.getSurface());
        }
    }

    /* renamed from: Rz */
    public void mo24723Rz() {
        try {
            this.bIS.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if (C4503a.this.bIS != null) {
                        C4503a.this.bIS.start();
                    }
                }
            });
            this.bIS.setOnPreparedListener(new OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    C4503a.this.bzr.setVideoSize(new MSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight()));
                    C4503a.this.bzr.setTextureViewSize(UtilsMSize.getFitInSize(new MSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight()), Constants.getActivityScreenSize((Activity) C4503a.this.bzr.getContext())), true);
                    C4503a.this.bIS.start();
                }
            });
            MediaPlayer mediaPlayer = this.bIS;
            Context context = this.bzr.getContext();
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.bzr.getContext().getPackageName());
            sb.append("/");
            sb.append(R.raw.welcome_video);
            mediaPlayer.setDataSource(context, Uri.parse(sb.toString()));
            this.bIS.setVolume(0.0f, 0.0f);
            this.bIS.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pauseVideo() {
        mo24721Ow();
    }
}
