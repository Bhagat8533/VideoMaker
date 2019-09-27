package com.introvd.template.common.p236ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.introvd.template.common.MSize;
import com.introvd.template.common.utils.UtilsDensity;
import com.introvd.template.common.utils.UtilsMSize;

/* renamed from: com.introvd.template.common.ui.video.XYSimpleVideoView */
public class XYSimpleVideoView extends FrameLayout {
    private TextureView bGs;
    private int btX;
    private MSize cii;
    private boolean cij;
    /* access modifiers changed from: private */
    public OnSurfaceListener cik;
    private SurfaceTextureListener cil = new SurfaceTextureListener() {
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            XYSimpleVideoView.this.mSurface = new Surface(surfaceTexture);
            if (XYSimpleVideoView.this.cik != null) {
                XYSimpleVideoView.this.cik.onSurfaceCreate(XYSimpleVideoView.this.mSurface);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (XYSimpleVideoView.this.mSurface != null) {
                XYSimpleVideoView.this.mSurface.release();
                XYSimpleVideoView.this.mSurface = null;
            }
            if (XYSimpleVideoView.this.cik != null) {
                XYSimpleVideoView.this.cik.onSurfaceDestroyed();
            }
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    /* access modifiers changed from: private */
    public Surface mSurface;

    /* renamed from: com.introvd.template.common.ui.video.XYSimpleVideoView$OnSurfaceListener */
    public interface OnSurfaceListener {
        void onSurfaceCreate(Surface surface);

        void onSurfaceDestroyed();
    }

    public XYSimpleVideoView(Context context) {
        super(context);
        m14534Ll();
    }

    public XYSimpleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14534Ll();
    }

    public XYSimpleVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14534Ll();
    }

    /* renamed from: Ll */
    private void m14534Ll() {
        this.bGs = new TextureView(getContext());
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        addView(this.bGs, layoutParams);
        layoutParams.gravity = 17;
        this.bGs.setSurfaceTextureListener(this.cil);
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.btX = i4;
        if (z && this.cii != null) {
            setTextureViewSize(UtilsMSize.getFitInSize(this.cii, new MSize(i3, i4)), this.cij);
        }
    }

    public void setOnSurfaceListener(OnSurfaceListener onSurfaceListener) {
        this.cik = onSurfaceListener;
    }

    public void setTextureViewSize(MSize mSize, boolean z) {
        LayoutParams layoutParams = (LayoutParams) this.bGs.getLayoutParams();
        layoutParams.width = mSize.width;
        layoutParams.height = mSize.height;
        this.cij = z;
        float f = 1.0f;
        if (z) {
            if (mSize.width < UtilsDensity.getScreenW(getContext())) {
                f = (((float) (UtilsDensity.getScreenW(getContext()) + 1)) * 1.0f) / ((float) mSize.width);
            } else if (mSize.height < this.btX) {
                f = (((float) (this.btX + 1)) * 1.0f) / ((float) mSize.height);
            }
        }
        this.bGs.setScaleX(f);
        this.bGs.setScaleY(f);
        this.bGs.setLayoutParams(layoutParams);
    }

    public void setVideoSize(MSize mSize) {
        this.cii = mSize;
    }
}
