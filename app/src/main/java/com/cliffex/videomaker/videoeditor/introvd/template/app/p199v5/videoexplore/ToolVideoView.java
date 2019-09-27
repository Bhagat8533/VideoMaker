package com.introvd.template.app.p199v5.videoexplore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import org.greenrobot.eventbus.C10021c;

@SuppressLint({"NewApi"})
/* renamed from: com.introvd.template.app.v5.videoexplore.ToolVideoView */
public class ToolVideoView extends RelativeLayout implements SurfaceTextureListener {
    /* access modifiers changed from: private */
    public static int bGq = 15000;
    /* access modifiers changed from: private */
    public static int bGr = 480;
    private final String TAG = "CustomVideoView ";
    /* access modifiers changed from: private */
    public GestureDetector aML = null;
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            if (ToolVideoView.this.bGJ != null) {
                if (view.equals(ToolVideoView.this.bGv)) {
                    ToolVideoView.this.bGJ.onPlayClick();
                } else if (view.equals(ToolVideoView.this.bGw)) {
                    ToolVideoView.this.bGJ.onPauseClick();
                } else if (view.equals(ToolVideoView.this.bGB)) {
                    ToolVideoView.this.bGJ.onFullScreenClick();
                } else if (view.equals(ToolVideoView.this.bGC) || view.equals(ToolVideoView.this.bGD)) {
                    ToolVideoView.this.bGH = !ToolVideoView.this.bGH;
                    ToolVideoView.this.bGJ.onSilentModeChanged(ToolVideoView.this.bGH);
                    ToolVideoView.this.setSilentMode(ToolVideoView.this.bGH);
                    ToolVideoView.this.removeCallbacks(ToolVideoView.this.bGU);
                    ToolVideoView.this.postDelayed(ToolVideoView.this.bGU, 3000);
                    UserBehaviorUtilsV5.onEventVoiceSwitch(ToolVideoView.this.getContext(), ToolVideoView.this.bGH ? "Mute" : "Vocal");
                }
            }
            if (view.equals(ToolVideoView.this.bGt)) {
                if (ToolVideoView.this.bGJ != null) {
                    ToolVideoView.this.bGJ.onControllerShown();
                }
                if (!ToolVideoView.this.bGI) {
                    ToolVideoView.this.mo24539Rc();
                    ToolVideoView.this.hideControllerDelay(2000);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public RelativeLayout bGA = null;
    /* access modifiers changed from: private */
    public ImageView bGB = null;
    /* access modifiers changed from: private */
    public ImageView bGC;
    /* access modifiers changed from: private */
    public ImageView bGD;
    private ImageView bGE;
    /* access modifiers changed from: private */
    public long bGF = 0;
    /* access modifiers changed from: private */
    public boolean bGG = false;
    /* access modifiers changed from: private */
    public boolean bGH = false;
    /* access modifiers changed from: private */
    public boolean bGI = false;
    /* access modifiers changed from: private */
    public C4445d bGJ = null;
    /* access modifiers changed from: private */
    public C4443b bGK = null;
    private boolean bGL = false;
    private boolean bGM = false;
    private boolean bGN = false;
    private boolean bGO = true;
    /* access modifiers changed from: private */
    public boolean bGP = false;
    private Runnable bGQ = new Runnable() {
        public void run() {
            ToolVideoView.this.m11216Re();
        }
    };
    private OnSeekBarChangeListener bGR = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("onProgressChanged fromUser: ");
            sb.append(z);
            LogUtils.m14223i("CustomVideoView ", sb.toString());
            if (z) {
                if (ToolVideoView.this.bGJ != null) {
                    ToolVideoView.this.bGJ.onSeekChanged((ToolVideoView.this.bGF * ((long) seekBar.getProgress())) / 100);
                }
                ToolVideoView.this.bGy.setText(C4580b.m11637V((ToolVideoView.this.bGF * ((long) i)) / 100));
                ToolVideoView.this.mo24539Rc();
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ToolVideoView.this.mo24539Rc();
            ToolVideoView.this.bGG = true;
            C10021c.aZH().mo38492aA(new C4442a(true));
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (ToolVideoView.this.bGJ != null) {
                ToolVideoView.this.bGJ.onSeekChanged((ToolVideoView.this.bGF * ((long) seekBar.getProgress())) / 100);
            }
            ToolVideoView.this.mo24539Rc();
            ToolVideoView.this.hideControllerDelay(2000);
            ToolVideoView.this.bGG = false;
            C10021c.aZH().mo38492aA(new C4442a(false));
        }
    };
    private OnTouchListener bGS = new OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (ToolVideoView.this.bGK != null && ToolVideoView.this.bGK.mo24575Rk()) {
                        ToolVideoView.this.bGK.mo24573Ri();
                        break;
                    }
                case 1:
                case 3:
                    if (ToolVideoView.this.bGK != null && ToolVideoView.this.bGK.mo24575Rk() && ToolVideoView.this.bGP) {
                        ToolVideoView.this.bGP = false;
                        ToolVideoView.this.bGK.mo24574Rj();
                        if (ToolVideoView.this.bGu != null) {
                            ToolVideoView.this.bGu.setVisibility(4);
                            break;
                        }
                    }
                    break;
            }
            return ToolVideoView.this.aML.onTouchEvent(motionEvent);
        }
    };
    private boolean bGT = true;
    /* access modifiers changed from: private */
    public Runnable bGU = new Runnable() {
        public void run() {
            ToolVideoView.this.bGD.setVisibility(4);
        }
    };
    private TextureView bGs = null;
    /* access modifiers changed from: private */
    public RelativeLayout bGt = null;
    /* access modifiers changed from: private */
    public View bGu = null;
    /* access modifiers changed from: private */
    public ImageView bGv = null;
    /* access modifiers changed from: private */
    public ImageView bGw = null;
    /* access modifiers changed from: private */
    public SeekBar bGx = null;
    /* access modifiers changed from: private */
    public TextView bGy = null;
    private TextView bGz = null;
    private Surface mSurface = null;

    /* renamed from: com.introvd.template.app.v5.videoexplore.ToolVideoView$a */
    public class C4442a {
        public boolean isSeeking;

        public C4442a(boolean z) {
            this.isSeeking = z;
        }
    }

    /* renamed from: com.introvd.template.app.v5.videoexplore.ToolVideoView$b */
    public interface C4443b {
        /* renamed from: Rh */
        int mo24572Rh();

        /* renamed from: Ri */
        void mo24573Ri();

        /* renamed from: Rj */
        void mo24574Rj();

        /* renamed from: Rk */
        boolean mo24575Rk();

        /* renamed from: hV */
        int mo24576hV(int i);

        /* renamed from: hW */
        int mo24577hW(int i);

        /* renamed from: hX */
        int mo24578hX(int i);
    }

    /* renamed from: com.introvd.template.app.v5.videoexplore.ToolVideoView$c */
    private class C4444c extends SimpleOnGestureListener {
        private int bGW;

        private C4444c() {
            this.bGW = 0;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            LogUtils.m14223i("CustomVideoView ", "onDoubleTap");
            if (ToolVideoView.this.bGJ != null) {
                return ToolVideoView.this.bGJ.onDoubleClick();
            }
            return false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            LogUtils.m14223i("CustomVideoView ", "onDown");
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            StringBuilder sb = new StringBuilder();
            sb.append("onScroll distanceX=");
            sb.append(f);
            sb.append(";distanceY=");
            sb.append(f2);
            sb.append(";e1=");
            sb.append(motionEvent.getX());
            sb.append(";e2=");
            sb.append(motionEvent2.getX());
            LogUtils.m14223i("CustomVideoView ", sb.toString());
            if (ToolVideoView.this.bGK == null || !ToolVideoView.this.bGK.mo24575Rk()) {
                return true;
            }
            if (!ToolVideoView.this.bGP) {
                ToolVideoView.this.bGP = true;
                if (ToolVideoView.this.bGK != null) {
                    this.bGW = ToolVideoView.this.bGK.mo24572Rh();
                }
                if (ToolVideoView.this.bGu != null) {
                    ToolVideoView.this.bGu.setVisibility(0);
                }
            }
            if (ToolVideoView.this.bGP) {
                float x = motionEvent2.getX() - motionEvent.getX();
                int Rf = ToolVideoView.bGq;
                if (ToolVideoView.this.bGK != null) {
                    Rf = ToolVideoView.this.bGK.mo24578hX(Rf);
                }
                int Rg = this.bGW + ((int) ((((float) Rf) * x) / ((float) ToolVideoView.bGr)));
                if (ToolVideoView.this.bGK != null) {
                    Rg = ToolVideoView.this.bGK.mo24576hV(Rg);
                }
                int i = Rg - this.bGW;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onScroll curTime =");
                sb2.append(Rg);
                LogUtils.m14223i("CustomVideoView ", sb2.toString());
                ToolVideoView.this.m11224bL(i, Rg);
                ToolVideoView.this.bGy.setText(C4580b.m11637V((long) Rg));
                if (ToolVideoView.this.bGF > 0) {
                    ToolVideoView.this.bGx.setProgress((int) (((long) (Rg * 100)) / ToolVideoView.this.bGF));
                }
                if (ToolVideoView.this.bGK != null) {
                    ToolVideoView.this.bGK.mo24577hW(Rg);
                }
            }
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            LogUtils.m14223i("CustomVideoView ", "onSingleTapConfirmed");
            if (ToolVideoView.this.bGJ != null) {
                ToolVideoView.this.bGJ.onControllerShown();
            }
            if (!ToolVideoView.this.bGI) {
                if (ToolVideoView.this.bGA.getVisibility() == 0) {
                    ToolVideoView.this.hideControllerDelay(0);
                } else {
                    ToolVideoView.this.mo24539Rc();
                    ToolVideoView.this.hideControllerDelay(2000);
                }
            }
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            LogUtils.m14223i("CustomVideoView ", "onSingleTapUp");
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* renamed from: com.introvd.template.app.v5.videoexplore.ToolVideoView$d */
    public interface C4445d {
        void onControllerShown();

        boolean onDoubleClick();

        void onFullScreenClick();

        void onPauseClick();

        void onPlayClick();

        void onSeekChanged(long j);

        void onSilentModeChanged(boolean z);

        void onSurfaceTextureAvailable(Surface surface);

        void onSurfaceTextureDestroyed(Surface surface);
    }

    public ToolVideoView(Context context) {
        super(context);
        init();
    }

    public ToolVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ToolVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* access modifiers changed from: private */
    /* renamed from: Re */
    public void m11216Re() {
        removeCallbacks(this.bGQ);
        this.bGA.setVisibility(4);
        this.bGB.setVisibility(4);
        if (this.bGL) {
            this.bGw.setVisibility(4);
            this.bGv.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bL */
    public void m11224bL(int i, int i2) {
        TextView textView = (TextView) this.bGu.findViewById(R.id.xiaoying_txtview_actual_time);
        ((TextView) this.bGu.findViewById(R.id.xiaoying_txtview_relative_timespan)).setText(String.format("%1$+01d", new Object[]{Integer.valueOf(i / 1000)}));
        textView.setText(C4580b.m11637V((long) i2));
    }

    private void init() {
        if (!isInEditMode()) {
            bGr = Constants.getScreenSize().height;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.xiaoying_tool_videoview_layout, this, true);
            this.bGt = (RelativeLayout) inflate.findViewById(R.id.xiaoying_com_videoview_layout);
            this.bGs = (TextureView) inflate.findViewById(R.id.xiaoying_com_activity_videoview);
            this.bGv = (ImageView) inflate.findViewById(R.id.xiaoying_com_btn_video_view_play);
            this.bGw = (ImageView) inflate.findViewById(R.id.xiaoying_com_btn_video_view_pause);
            this.bGx = (SeekBar) inflate.findViewById(R.id.xiaoying_com_video_seekbar);
            this.bGy = (TextView) inflate.findViewById(R.id.xiaoying_com_current_time);
            this.bGz = (TextView) inflate.findViewById(R.id.xiaoying_com_total_time);
            this.bGA = (RelativeLayout) inflate.findViewById(R.id.xiaoying_com_video_info_layout);
            this.bGB = (ImageView) inflate.findViewById(R.id.xiaoying_com_btn_fullscreen);
            this.bGC = (ImageView) inflate.findViewById(R.id.btn_silent_mode);
            this.bGD = (ImageView) inflate.findViewById(R.id.btn_silent_mode2);
            this.bGC.setOnClickListener(this.acD);
            this.bGD.setOnClickListener(this.acD);
            if (!C3742b.m9111II().mo23182ca(getContext())) {
                this.bGC.setVisibility(8);
                this.bGD.setVisibility(8);
            }
            this.bGu = inflate.findViewById(R.id.xiaoying_com_fine_seek_layout);
            this.bGE = (ImageView) inflate.findViewById(R.id.video_control_info_layout);
            this.bGv.setOnClickListener(this.acD);
            this.bGw.setOnClickListener(this.acD);
            this.bGB.setOnClickListener(this.acD);
            this.bGs.setSurfaceTextureListener(this);
            this.bGx.setOnSeekBarChangeListener(this.bGR);
            this.aML = new GestureDetector(getContext(), new C4444c());
        }
    }

    /* renamed from: Rc */
    public void mo24539Rc() {
        removeCallbacks(this.bGQ);
        this.bGD.setVisibility(4);
        this.bGA.setVisibility(0);
        if (this.bGO) {
            this.bGB.setVisibility(0);
        }
        setPlayPauseBtnState(this.bGL);
    }

    /* renamed from: Rd */
    public boolean mo24540Rd() {
        return this.bGA.getVisibility() == 0;
    }

    public OnTouchListener getOnTouchListener() {
        return this.bGS;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    /* renamed from: hU */
    public void mo24543hU(int i) {
        float measureText = this.bGz.getPaint().measureText(C4580b.m11637V((long) i));
        ((LayoutParams) this.bGz.getLayoutParams()).width = (int) (((float) C4583d.m11670O(getContext(), 10)) + measureText);
        ((LayoutParams) this.bGy.getLayoutParams()).width = (int) (measureText + ((float) C4583d.m11670O(getContext(), 10)));
    }

    public void hideControllerDelay(int i) {
        removeCallbacks(this.bGQ);
        postDelayed(this.bGQ, (long) i);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        LogUtils.m14223i("CustomVideoView ", "onSurfaceTextureAvailable");
        this.mSurface = new Surface(surfaceTexture);
        if (this.bGJ != null) {
            this.bGJ.onSurfaceTextureAvailable(this.mSurface);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        LogUtils.m14223i("CustomVideoView ", "onSurfaceTextureDestroyed");
        if (this.bGJ != null) {
            this.bGJ.onSurfaceTextureDestroyed(this.mSurface);
        }
        if (this.mSurface != null && this.mSurface.isValid()) {
            this.mSurface.release();
        }
        this.mSurface = null;
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        LogUtils.m14223i("CustomVideoView ", "onSurfaceTextureSizeChanged");
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("onTouch event.getAction()=");
        sb.append(motionEvent.getAction());
        LogUtils.m14223i("CustomVideoView ", sb.toString());
        if (!this.bGT) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.bGK != null && this.bGK.mo24575Rk()) {
                    this.bGK.mo24573Ri();
                    break;
                }
            case 1:
            case 3:
                if (this.bGK != null && this.bGK.mo24575Rk() && this.bGP) {
                    this.bGP = false;
                    this.bGK.mo24574Rj();
                    if (this.bGu != null) {
                        this.bGu.setVisibility(4);
                        break;
                    }
                }
                break;
        }
        return this.aML.onTouchEvent(motionEvent);
    }

    public void setBtnFullScreenState(boolean z) {
        this.bGB.setImageResource(z ? R.drawable.vivavideo_icon_exit_screen_n : R.drawable.vivavideo_icon_full_screen_n);
    }

    public void setBufferProgress(int i) {
    }

    public void setCurrentTime(long j) {
        if (!this.bGP) {
            this.bGy.setText(C4580b.m11637V(j));
            if (this.bGF > 0) {
                this.bGx.setProgress((int) ((j * 100) / this.bGF));
            }
        }
    }

    public void setFeedHotMode(boolean z) {
        this.bGI = z;
    }

    public void setFullScreenVisible(boolean z) {
        this.bGO = z;
        if (z) {
            this.bGB.setVisibility(0);
            return;
        }
        LayoutParams layoutParams = (LayoutParams) this.bGz.getLayoutParams();
        layoutParams.addRule(11);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginEnd(C4583d.m11670O(getContext(), 10));
        } else {
            layoutParams.rightMargin = C4583d.m11670O(getContext(), 10);
        }
        this.bGB.setVisibility(8);
    }

    public void setPlayBtnScale(float f) {
        this.bGw.setScaleX(f);
        this.bGw.setScaleY(f);
        this.bGv.setScaleX(f);
        this.bGv.setScaleY(f);
    }

    public void setPlayPauseBtnState(boolean z) {
        int i = 4;
        this.bGw.setVisibility(z ? 0 : 4);
        ImageView imageView = this.bGv;
        if (!z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public void setPlayState(boolean z) {
        this.bGL = z;
    }

    public void setSilentMode(boolean z) {
        if (C3742b.m9111II().mo23182ca(getContext())) {
            this.bGH = z;
            this.bGC.setSelected(this.bGH);
            this.bGD.setSelected(this.bGH);
        }
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

    public void setTextureViewViewScale(float f) {
        this.bGs.setScaleX(f);
        this.bGs.setScaleY(f);
    }

    public void setTotalTime(long j) {
        this.bGF = j;
        this.bGz.setText(C4580b.m11637V(this.bGF));
    }

    public void setTouchEventEnable(boolean z) {
        this.bGT = z;
    }

    public void setVideoFineSeekListener(C4443b bVar) {
        this.bGK = bVar;
    }

    public void setVideoViewListener(C4445d dVar) {
        this.bGJ = dVar;
    }
}
