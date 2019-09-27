package com.introvd.template.introduce.page;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.R;
import com.introvd.template.common.Constants;
import com.introvd.template.introduce.page.model.IntroduceMediaItem;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

public class IntroduceMediaView extends RelativeLayout {
    TextureView bGs;
    /* access modifiers changed from: private */
    public MediaPlayer bQf;
    DynamicLoadingImageView cDk;
    RelativeLayout clu;
    private boolean cwn;
    DynamicLoadingImageView dLG;
    ImageButton dLH;
    private IntroduceMediaItem dLI;
    /* access modifiers changed from: private */
    public Surface mSurface;

    public IntroduceMediaView(Context context) {
        this(context, null);
    }

    public IntroduceMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IntroduceMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* access modifiers changed from: private */
    public void ary() {
        if (this.cwn && this.dLI != null && !this.dLI.isImage() && this.mSurface != null && this.mSurface.isValid()) {
            try {
                azR();
                this.bQf = new MediaPlayer();
                this.bQf.setDataSource(this.dLI.getPreviewUrl());
                this.bQf.setSurface(this.mSurface);
                this.bQf.setAudioStreamType(3);
                this.bQf.setLooping(true);
                azS();
                this.bQf.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                        int videoWidth = mediaPlayer.getVideoWidth();
                        int videoHeight = mediaPlayer.getVideoHeight();
                        if (videoWidth > videoHeight) {
                            int i3 = Constants.getScreenSize().width;
                            LayoutParams layoutParams = new LayoutParams(i3, (int) ((((float) i3) / ((float) videoWidth)) * ((float) videoHeight)));
                            layoutParams.addRule(15);
                            IntroduceMediaView.this.clu.setLayoutParams(layoutParams);
                            return;
                        }
                        int i4 = Constants.getScreenSize().width;
                        LayoutParams layoutParams2 = new LayoutParams((int) ((((float) i4) / ((float) videoHeight)) * ((float) videoWidth)), i4);
                        layoutParams2.addRule(14);
                        IntroduceMediaView.this.clu.setLayoutParams(layoutParams2);
                    }
                });
                this.bQf.setOnPreparedListener(new OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        IntroduceMediaView.this.dLH.setVisibility(0);
                        IntroduceMediaView.this.bQf.start();
                    }
                });
                this.bQf.prepareAsync();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void azQ() {
        this.bGs.setSurfaceTextureListener(new SurfaceTextureListener() {
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                IntroduceMediaView.this.mSurface = new Surface(surfaceTexture);
                IntroduceMediaView.this.ary();
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                IntroduceMediaView.this.mSurface = null;
                IntroduceMediaView.this.azR();
                return true;
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void azS() {
        if (this.bQf != null) {
            this.bQf.setVolume(0.0f, 0.0f);
        }
    }

    /* access modifiers changed from: private */
    public void azT() {
        if (this.bQf != null) {
            this.bQf.setVolume(1.0f, 1.0f);
        }
    }

    /* renamed from: dq */
    private void m22293dq(int i, int i2) {
        int i3;
        int i4;
        if (i > i2) {
            int i5 = Constants.getScreenSize().width;
            i3 = (i2 * i5) / i;
            i4 = i5;
        } else {
            int i6 = Constants.getScreenSize().width;
            i4 = (i * i6) / i2;
            i3 = i6;
        }
        LayoutParams layoutParams = (LayoutParams) this.cDk.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i3;
        layoutParams.addRule(13);
        this.cDk.setLayoutParams(layoutParams);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.introduce_media_view_layout, this, true);
        this.dLG = (DynamicLoadingImageView) findViewById(R.id.thumbnail);
        this.cDk = (DynamicLoadingImageView) findViewById(R.id.iv_cover);
        this.dLH = (ImageButton) findViewById(R.id.btn_volume);
        this.clu = (RelativeLayout) findViewById(R.id.video_preview_layout);
        this.bGs = (TextureView) findViewById(R.id.texture_view);
        this.dLH.setVisibility(8);
        azQ();
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                IntroduceMediaView.this.dLH.setSelected(!IntroduceMediaView.this.dLH.isSelected());
                if (IntroduceMediaView.this.dLH.isSelected()) {
                    IntroduceMediaView.this.azT();
                } else {
                    IntroduceMediaView.this.azS();
                }
            }
        }, this.dLH);
    }

    /* renamed from: a */
    public void mo32340a(IntroduceMediaItem introduceMediaItem) {
        this.dLI = introduceMediaItem;
        if (introduceMediaItem.isImage()) {
            this.cDk.setVisibility(0);
            this.clu.setVisibility(8);
        } else {
            this.clu.setVisibility(0);
            this.cDk.setVisibility(8);
        }
        if (!TextUtils.isEmpty(introduceMediaItem.getCoverUrl())) {
            this.dLG.setImageURI(introduceMediaItem.getCoverUrl());
        } else if (introduceMediaItem.isImage()) {
            this.dLG.setImageURI(introduceMediaItem.getPreviewUrl());
        }
        if (!TextUtils.isEmpty(introduceMediaItem.getPreviewUrl()) && introduceMediaItem.isImage()) {
            if (!(introduceMediaItem.getWidth() == 0 || introduceMediaItem.getHeight() == 0)) {
                m22293dq(introduceMediaItem.getWidth(), introduceMediaItem.getHeight());
            }
            this.cDk.setImageURI(introduceMediaItem.getPreviewUrl());
        }
    }

    public void azR() {
        this.dLH.setSelected(false);
        try {
            if (this.bQf != null) {
                this.bQf.stop();
                this.bQf.release();
                this.bQf = null;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void setFocusStatus(boolean z) {
        this.cwn = z;
        if (!z) {
            azR();
        } else if (this.dLI != null && !this.dLI.isImage()) {
            ary();
        }
    }
}
