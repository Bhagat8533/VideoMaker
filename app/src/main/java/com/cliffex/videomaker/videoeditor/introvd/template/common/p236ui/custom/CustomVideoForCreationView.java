package com.introvd.template.common.p236ui.custom;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;

/* renamed from: com.introvd.template.common.ui.custom.CustomVideoForCreationView */
public class CustomVideoForCreationView extends RelativeLayout implements SurfaceTextureListener {
    private final String TAG = "CustomVideoView ";
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            if (CustomVideoForCreationView.this.cgP != null && view.equals(CustomVideoForCreationView.this.bGt)) {
                if (CustomVideoForCreationView.this.bGL) {
                    CustomVideoForCreationView.this.cgP.onPauseClick();
                } else {
                    CustomVideoForCreationView.this.cgP.onPlayClick();
                }
                UserBehaviorUtils.recordMonHomeSingleVideoClick(CustomVideoForCreationView.this.getContext(), CustomVideoForCreationView.this.bGL ? "pause" : "play", CustomVideoForCreationView.this.cgQ);
                Context context = CustomVideoForCreationView.this.getContext();
                int f = CustomVideoForCreationView.this.position;
                String g = CustomVideoForCreationView.this.title;
                StringBuilder sb = new StringBuilder();
                sb.append(CustomVideoForCreationView.this.rawId);
                sb.append("");
                UserBehaviorABTestUtils.onEventHomeRecommend(context, f, g, sb.toString(), false);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean bGL = false;
    private Runnable bGQ = new Runnable() {
        public void run() {
            CustomVideoForCreationView.this.m14475Re();
        }
    };
    private TextureView bGs = null;
    /* access modifiers changed from: private */
    public RelativeLayout bGt = null;
    private RelativeLayout bHP = null;
    private TextView bHQ = null;
    /* access modifiers changed from: private */
    public VideoViewListener cgP = null;
    /* access modifiers changed from: private */
    public String cgQ = null;
    private Context mContext = null;
    private Surface mSurface = null;
    /* access modifiers changed from: private */
    public int position;
    /* access modifiers changed from: private */
    public int rawId;
    /* access modifiers changed from: private */
    public String title;

    /* renamed from: com.introvd.template.common.ui.custom.CustomVideoForCreationView$VideoViewListener */
    public interface VideoViewListener {
        void onPauseClick();

        void onPlayClick();

        void onSurfaceTextureAvailable(Surface surface);

        void onSurfaceTextureDestroyed(Surface surface);
    }

    public CustomVideoForCreationView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CustomVideoForCreationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public CustomVideoForCreationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    /* access modifiers changed from: private */
    /* renamed from: Re */
    public void m14475Re() {
        removeCallbacks(this.bGQ);
        if (this.bGL) {
            this.bHP.setVisibility(4);
        }
    }

    private void init() {
        if (!isInEditMode()) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.v5_xiaoying_home_videoview_layout, this, true);
            this.bGt = (RelativeLayout) inflate.findViewById(R.id.xiaoying_com_videoview_layout);
            this.bGs = (TextureView) inflate.findViewById(R.id.xiaoying_com_activity_videoview);
            this.bHP = (RelativeLayout) inflate.findViewById(R.id.xiaoying_com_custom_play_info_layout);
            this.bHQ = (TextView) inflate.findViewById(R.id.xiaoying_com_custom_play_num);
            this.bGt.setOnClickListener(this.acD);
            this.bGs.setSurfaceTextureListener(this);
        }
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void hideControllerDelay(int i) {
        removeCallbacks(this.bGQ);
        postDelayed(this.bGQ, (long) i);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        LogUtils.m14223i("CustomVideoView ", "onSurfaceTextureAvailable");
        this.mSurface = new Surface(surfaceTexture);
        if (this.cgP != null) {
            this.cgP.onSurfaceTextureAvailable(this.mSurface);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        LogUtils.m14223i("CustomVideoView ", "onSurfaceTextureDestroyed");
        if (this.cgP != null) {
            this.cgP.onSurfaceTextureDestroyed(this.mSurface);
        }
        if (this.mSurface != null) {
            this.mSurface.release();
            this.mSurface = null;
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        LogUtils.m14223i("CustomVideoView ", "onSurfaceTextureSizeChanged");
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setBehaviorParams(int i, int i2, String str) {
        this.position = i;
        this.rawId = i2;
        this.title = str;
    }

    public void setPlayNum(String str) {
        if (this.bHQ != null) {
            this.bHQ.setText(str);
        }
    }

    public void setPlayPauseBtnState(boolean z) {
        this.bHP.setVisibility(z ? 8 : 0);
    }

    public void setPlayState(boolean z) {
        this.bGL = z;
    }

    public void setTextureViewSize(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.bGs.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        StringBuilder sb = new StringBuilder();
        sb.append("fit in video view : ");
        sb.append(layoutParams.width);
        sb.append(" x ");
        sb.append(layoutParams.height);
        LogUtils.m14223i("CustomVideoView ", sb.toString());
        this.bGs.setLayoutParams(layoutParams);
        this.bGs.requestLayout();
    }

    public void setVideoId(String str) {
        this.cgQ = str;
    }

    public void setVideoViewListener(VideoViewListener videoViewListener) {
        this.cgP = videoViewListener;
    }
}
