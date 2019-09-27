package com.introvd.template.app.school.template.detail;

import android.view.Surface;
import android.view.View;
import android.widget.ImageView;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.MSize;
import com.introvd.template.common.p236ui.video.XYSimpleVideoView;
import com.introvd.template.common.p236ui.video.XYSimpleVideoView.OnSurfaceListener;
import com.introvd.template.common.utils.UtilsMSize;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import com.quvideo.xyvideoplayer.library.C9196b;
import com.quvideo.xyvideoplayer.library.C9197c;
import com.quvideo.xyvideoplayer.library.p422a.C9194e;

/* renamed from: com.introvd.template.app.school.template.detail.h */
public class C4229h {
    /* access modifiers changed from: private */
    public XYSimpleVideoView bzr;
    /* access modifiers changed from: private */
    public ImageView bzs = ((ImageView) this.bzr.findViewById(R.id.btnPlay));
    /* access modifiers changed from: private */
    public DynamicLoadingImageView bzt = ((DynamicLoadingImageView) this.bzr.findViewById(R.id.imgCover));
    /* access modifiers changed from: private */
    public boolean bzu;
    /* access modifiers changed from: private */
    public C4233j bzv;
    /* access modifiers changed from: private */
    public Surface surface;

    C4229h(XYSimpleVideoView xYSimpleVideoView) {
        this.bzr = xYSimpleVideoView;
        this.bzr.setOnSurfaceListener(new OnSurfaceListener() {
            public void onSurfaceCreate(Surface surface) {
                C4229h.this.surface = surface;
                if (C4229h.this.bzu) {
                    C4229h.this.mo24197Ox();
                    C4229h.this.bzu = false;
                }
            }

            public void onSurfaceDestroyed() {
                C4229h.this.surface = null;
            }
        });
        this.bzr.setOnClickListener(new C4232i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: Ou */
    public void m10591Ou() {
        C9194e Ov = m10592Ov();
        if (Ov != null) {
            if (Ov.isPlaying()) {
                Ov.pause();
                this.bzs.setVisibility(0);
            } else {
                Ov.start();
            }
        }
    }

    /* renamed from: Ov */
    private C9194e m10592Ov() {
        final C9194e hw = C9194e.m26753hw(VivaBaseApplication.m8749FZ());
        hw.mo36263b((C9197c) new C9197c() {
            /* renamed from: F */
            public void mo24203F(long j) {
            }

            /* renamed from: Oy */
            public void mo24204Oy() {
                hw.seekTo(0);
            }

            /* renamed from: Oz */
            public void mo24205Oz() {
            }

            /* renamed from: a */
            public void mo24206a(C9196b bVar) {
                C4229h.this.bzv.setDuration(bVar.getDuration());
            }

            public void onBuffering(boolean z) {
            }

            public void onError(Exception exc) {
            }

            public void onPaused() {
            }

            public void onPlayerPreReset() {
                C4229h.this.bzt.setVisibility(0);
                C4229h.this.m10591Ou();
                C4229h.this.bzv.mo24216OA();
            }

            public void onPlayerReset() {
            }

            public void onStarted() {
                C4229h.this.bzs.setVisibility(4);
            }

            public void onVideoSizeChanged(int i, int i2, int i3, float f) {
                C4229h.this.bzr.setVideoSize(new MSize(i, i2));
                C4229h.this.bzr.setTextureViewSize(UtilsMSize.getFitInSize(new MSize(i, i2), new MSize(C4229h.this.bzr.getWidth(), C4229h.this.bzr.getHeight())), false);
            }

            public void onVideoStartRender() {
                C4229h.this.bzt.setVisibility(4);
                C4229h.this.bzs.setVisibility(4);
            }
        });
        return hw;
    }

    /* renamed from: Ow */
    private void m10593Ow() {
        C9194e Ov = m10592Ov();
        if (Ov != null) {
            Ov.reset();
            Ov.release();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bR */
    public /* synthetic */ void m10599bR(View view) {
        m10591Ou();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: Ox */
    public void mo24197Ox() {
        C9194e Ov = m10592Ov();
        if (Ov.isPlaying()) {
            Ov.pause();
        } else if (this.surface == null || !this.surface.isValid()) {
            this.bzu = true;
        } else {
            Ov.setSurface(this.surface);
            Ov.mo36269ro(this.bzv.getVideoUrl());
            Ov.start();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo24198a(C4233j jVar) {
        this.bzv = jVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: dS */
    public void mo24199dS(String str) {
        this.bzv.mo24217dT(str);
    }

    public void onPause() {
        m10593Ow();
    }
}
