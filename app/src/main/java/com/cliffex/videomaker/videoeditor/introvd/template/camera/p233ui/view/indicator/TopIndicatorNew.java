package com.introvd.template.camera.p233ui.view.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.camera.p208a.C4671j;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.camera.p233ui.view.CaptrueRatioImageView;
import com.introvd.template.camera.p233ui.view.CaptrueRatioImageView.C5166a;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.indicator.TopIndicatorNew */
public class TopIndicatorNew extends RelativeLayout implements OnClickListener {
    /* access modifiers changed from: private */
    public C4671j caA;
    private boolean caB;
    private ImageView cau;
    private ImageView cav;
    private ImageView caw;
    private CaptrueRatioImageView cax;
    private TextView cay;
    private TextView caz;

    public TopIndicatorNew(Context context) {
        this(context, null);
    }

    public TopIndicatorNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopIndicatorNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.caB = true;
        m14149dQ(context);
    }

    /* renamed from: dQ */
    private void m14149dQ(Context context) {
        View inflate = inflate(context, R.layout.cam_view_func_top_indicator, this);
        this.cau = (ImageView) inflate.findViewById(R.id.cam_btn_cancel);
        this.cax = (CaptrueRatioImageView) inflate.findViewById(R.id.cam_btn_ratio);
        this.cax.setmOnTimerModeChangeListener(new C5166a() {
            /* renamed from: js */
            public void mo26154js(int i) {
                if (TopIndicatorNew.this.caA != null) {
                    TopIndicatorNew.this.caA.mo25007iO(i);
                }
            }
        });
        this.cav = (ImageView) inflate.findViewById(R.id.img_switch);
        this.caw = (ImageView) inflate.findViewById(R.id.cam_btn_setting);
        this.cay = (TextView) inflate.findViewById(R.id.cam_recording_total_time);
        this.caz = (TextView) inflate.findViewById(R.id.cam_clip_count);
        this.cau.setOnClickListener(this);
        this.cav.setOnClickListener(this);
        this.caw.setOnClickListener(this);
    }

    /* renamed from: YK */
    public void mo26282YK() {
        this.caz.setVisibility(8);
    }

    /* renamed from: YL */
    public void mo26283YL() {
        this.caz.setVisibility(0);
    }

    /* renamed from: dA */
    public void mo26284dA(boolean z) {
        if (z) {
            this.caz.setBackgroundResource(R.drawable.v5_xiaoying_cam_clipcount_text_focus_bg_shape);
            this.caz.setTextColor(-1);
            return;
        }
        this.caz.setBackgroundResource(R.drawable.v5_xiaoying_cam_clipcount_text_bg_shape);
        this.caz.setTextColor(getContext().getResources().getColor(R.color.color_ff774e));
    }

    /* renamed from: dB */
    public void mo26285dB(boolean z) {
        if (this.cax != null && (!z || this.cax.getVisibility() == 0)) {
            if (z || this.cax.getVisibility() != 0) {
                this.cax.setVisibility((!this.caB || z || C5008i.m12937VU().getState() == 2) ? 4 : 0);
            }
        }
    }

    public CaptrueRatioImageView getRatioBtn() {
        return this.cax;
    }

    /* renamed from: iH */
    public void mo26287iH(int i) {
        if (Math.abs((this.cau != null ? this.cau.getRotation() : 0.0f) - ((float) i)) >= 360.0f) {
            i = 0;
        }
        if (this.caB) {
            C4562a.m11540v(this.cax, i);
        }
        C4562a.m11540v(this.cau, i);
        C4562a.m11540v(this.cav, i);
        this.caw.setTag(Integer.valueOf(i));
    }

    public void onClick(View view) {
        if (view.equals(this.cau)) {
            if (this.caA != null) {
                this.caA.mo25004UT();
            }
        } else if (view.equals(this.cav)) {
            if (this.caA != null) {
                this.caA.mo25005UV();
            }
        } else if (view.equals(this.caw) && this.caA != null) {
            this.caA.mo25006cm(this.caw);
        }
    }

    public void setCameraRatioMode(int i) {
        if (this.cax != null) {
            this.cax.setCameraRatioMode(i);
        }
    }

    public void setClipCount(String str) {
        this.caz.setText(str);
    }

    public void setRatioEnable(boolean z) {
        this.caB = z;
        mo26285dB(!z);
    }

    public void setTimeExceed(boolean z) {
        boolean ku = C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId());
        if (!z || ku) {
            this.cay.setTextColor(getContext().getResources().getColor(R.color.white));
        } else {
            this.cay.setTextColor(-65536);
        }
    }

    public void setTimeValue(long j) {
        this.cay.setText(C5034e.m13263jN((int) j));
    }

    public void setTopIndicatorClickListener(C4671j jVar) {
        this.caA = jVar;
    }

    public void update() {
        int clipCount = C5008i.m12937VU().getClipCount();
        int state = C5008i.m12937VU().getState();
        if (this.cay.getVisibility() != 0) {
            this.cay.setVisibility(0);
        }
        if (clipCount <= 0) {
            mo26282YK();
            if (state != 2) {
                this.cay.setVisibility(8);
            } else {
                this.cay.setVisibility(0);
            }
        } else {
            mo26283YL();
        }
        if (state == 2) {
            this.cau.setVisibility(4);
            this.cax.setVisibility(4);
            this.cav.setVisibility(4);
            this.caw.setVisibility(4);
            return;
        }
        this.cau.setVisibility(0);
        this.cav.setVisibility(0);
        this.caw.setVisibility(0);
    }
}
