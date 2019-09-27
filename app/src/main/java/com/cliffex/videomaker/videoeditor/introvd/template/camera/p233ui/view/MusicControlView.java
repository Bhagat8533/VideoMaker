package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.introvd.template.common.Constants;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.vivacamera.R;
import com.introvd.template.xyui.MarqueeTextView;

/* renamed from: com.introvd.template.camera.ui.view.MusicControlView */
public class MusicControlView extends RelativeLayout {
    private MarqueeTextView bXA;
    /* access modifiers changed from: private */
    public C5171a bXB;
    private Paint bXC;
    private RelativeLayout bXy;
    private ProgressBar bXz;
    /* access modifiers changed from: private */
    public boolean enable = true;
    private Context mContext;
    private int progress;

    /* renamed from: com.introvd.template.camera.ui.view.MusicControlView$a */
    public interface C5171a {
        /* renamed from: Xo */
        void mo25957Xo();
    }

    public MusicControlView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public MusicControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public MusicControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    /* renamed from: XT */
    public void mo26175XT() {
        setMusicTitle(this.mContext.getResources().getString(R.string.xiaoying_str_cam_choose_music_tips));
        this.bXz.setProgress(0);
    }

    /* renamed from: dt */
    public void mo26176dt(boolean z) {
        if (this.enable) {
            if (z && this.bXy.getVisibility() != 0) {
                this.bXy.setVisibility(0);
                this.bXA.requestFocus();
            } else if (!z && this.bXy.getVisibility() == 0) {
                this.bXy.setVisibility(4);
            }
        }
    }

    public int getProgress() {
        return this.progress;
    }

    public void init() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_music_control, this, true);
        this.bXy = (RelativeLayout) inflate.findViewById(R.id.layout_music_info);
        this.bXy.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MusicControlView.this.enable && MusicControlView.this.bXB != null) {
                    MusicControlView.this.bXB.mo25957Xo();
                }
            }
        });
        this.bXz = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.bXA = (MarqueeTextView) inflate.findViewById(R.id.music_title);
        this.bXC = this.bXA.getPaint();
        setMusicTitle(this.mContext.getResources().getString(R.string.xiaoying_str_cam_choose_music_tips));
        mo26176dt(true);
    }

    public void setControlListener(C5171a aVar) {
        this.bXB = aVar;
    }

    public void setEnable(boolean z) {
        this.enable = z;
        setAlpha(z ? 1.0f : 0.5f);
    }

    public void setMusicProgress(int i) {
        if (this.enable) {
            this.progress = i;
            this.bXz.setProgress(i);
        }
    }

    public void setMusicTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bXA.setText(str);
            LayoutParams layoutParams = new LayoutParams(-2, -1);
            float measureText = this.bXC.measureText(str);
            if (measureText < ((float) Constants.getScreenSize().width) * 0.2f) {
                layoutParams.width = C4583d.dpFloatToPixel(getContext(), 100.0f);
            } else if (measureText < ((float) Constants.getScreenSize().width) * 0.35f) {
                layoutParams.width = C4583d.dpFloatToPixel(getContext(), 140.0f);
            } else if (measureText < ((float) Constants.getScreenSize().width) * 0.5f) {
                layoutParams.width = C4583d.dpFloatToPixel(getContext(), 165.0f);
            } else {
                layoutParams.width = C4583d.dpFloatToPixel(getContext(), 175.0f);
            }
            this.bXA.setLayoutParams(layoutParams);
        }
    }
}
