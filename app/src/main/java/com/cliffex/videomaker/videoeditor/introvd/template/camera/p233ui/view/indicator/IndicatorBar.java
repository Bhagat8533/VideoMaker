package com.introvd.template.camera.p233ui.view.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.camera.p208a.C4664c;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.indicator.IndicatorBar */
public class IndicatorBar extends RelativeLayout implements OnClickListener {
    private ImageView bZA;
    private ImageView bZB;
    public RelativeLayout bZC;
    public RelativeLayout bZD;
    public RelativeLayout bZE;
    public RelativeLayout bZF;
    private boolean bZG = false;
    private C4664c bZH;
    private ImageView bZu;
    private ImageView bZv;
    private ImageView bZw;
    private ImageView bZx;
    private ImageView bZy;
    private ImageView bZz;
    private Context mContext;

    public IndicatorBar(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public IndicatorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public IndicatorBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    /* renamed from: YH */
    private void m14109YH() {
        boolean z = C5008i.m12937VU().mo25621Wh() || (-1 != C5008i.m12937VU().mo25622Wi() && !C5008i.m12937VU().mo25620Wg());
        this.bZv.setEnabled(z);
        this.bZu.setEnabled(z);
        if (!z) {
            this.bZu.setSelected(false);
        }
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_indicator_por, this, true);
        this.bZu = (ImageView) findViewById(R.id.img_effect);
        this.bZv = (ImageView) findViewById(R.id.img_mode);
        this.bZw = (ImageView) findViewById(R.id.img_switch);
        this.bZx = (ImageView) findViewById(R.id.img_setting);
        this.bZy = (ImageView) findViewById(R.id.img_effect_tab);
        this.bZz = (ImageView) findViewById(R.id.img_mode_tab);
        this.bZA = (ImageView) findViewById(R.id.img_switch_tab);
        this.bZB = (ImageView) findViewById(R.id.img_setting_tab);
        this.bZC = (RelativeLayout) findViewById(R.id.effect_layout);
        this.bZD = (RelativeLayout) findViewById(R.id.mode_layout);
        this.bZE = (RelativeLayout) findViewById(R.id.switch_layout);
        this.bZF = (RelativeLayout) findViewById(R.id.setting_layout);
        this.bZu.setOnClickListener(this);
        this.bZv.setOnClickListener(this);
        this.bZw.setOnClickListener(this);
        this.bZx.setOnClickListener(this);
    }

    /* renamed from: YI */
    public void mo26232YI() {
        int i = 4;
        if (C5008i.m12937VU().getState() == 2) {
            this.bZu.setVisibility(4);
            this.bZv.setVisibility(4);
            this.bZw.setVisibility(4);
            this.bZx.setVisibility(4);
            this.bZy.setVisibility(4);
            this.bZz.setVisibility(4);
            this.bZA.setVisibility(4);
            this.bZB.setVisibility(4);
            return;
        }
        this.bZu.setVisibility(0);
        this.bZv.setVisibility(0);
        this.bZw.setVisibility(0);
        this.bZx.setVisibility(0);
        boolean Wc = C5008i.m12937VU().mo25616Wc();
        boolean Wl = C5008i.m12937VU().mo25625Wl();
        boolean Wd = C5008i.m12937VU().mo25617Wd();
        boolean We = C5008i.m12937VU().mo25618We();
        boolean Wm = C5008i.m12937VU().mo25626Wm();
        boolean Wf = C5008i.m12937VU().mo25619Wf();
        boolean Wo = C5008i.m12937VU().mo25628Wo();
        boolean z = true;
        boolean z2 = Wc || Wf || Wl;
        this.bZu.setSelected(z2);
        this.bZx.setSelected(Wo);
        if (this.bZG) {
            this.bZy.setVisibility(z2 ? 0 : 4);
            this.bZB.setVisibility(Wo ? 0 : 4);
        }
        if (CameraCodeMgr.isCameraParamPIP(C5008i.m12937VU().mo25610VW())) {
            this.bZv.setSelected(false);
            this.bZz.setVisibility(4);
        } else {
            if (!Wd && !We && !Wm) {
                z = false;
            }
            this.bZv.setSelected(z);
            if (this.bZG) {
                ImageView imageView = this.bZz;
                if (z) {
                    i = 0;
                }
                imageView.setVisibility(i);
            }
        }
    }

    public void onClick(View view) {
        if (!C4580b.m11632Sf()) {
            if (view.equals(this.bZu)) {
                if (this.bZH != null) {
                    this.bZH.mo24978iJ(0);
                }
            } else if (view.equals(this.bZv)) {
                if (this.bZH != null) {
                    this.bZH.mo24978iJ(1);
                }
            } else if (view.equals(this.bZw)) {
                if (this.bZH != null) {
                    this.bZH.mo24978iJ(2);
                }
            } else if (view.equals(this.bZx) && this.bZH != null) {
                this.bZH.mo24978iJ(3);
            }
        }
    }

    public void setEnabled(boolean z) {
        if (CameraCodeMgr.isCameraParamPIP(C5008i.m12937VU().mo25610VW())) {
            m14109YH();
        } else {
            this.bZv.setEnabled(z);
            this.bZu.setEnabled(z);
        }
        this.bZw.setEnabled(z);
        super.setEnabled(z);
    }

    public void setIndicatorItemClickListener(C4664c cVar) {
        this.bZH = cVar;
    }

    public void update() {
        int i;
        if (AppPreferencesSetting.getInstance().getAppSettingInt("pref_view_camera_count", 1) > 1) {
            this.bZE.setVisibility(0);
        } else {
            this.bZE.setVisibility(8);
        }
        int VW = C5008i.m12937VU().mo25610VW();
        this.bZu.setEnabled(true);
        this.bZv.setEnabled(true);
        this.bZD.setVisibility(0);
        this.bZC.setVisibility(0);
        int i2 = R.drawable.v4_xiaoying_cam_indicator_effect_selector;
        if (CameraCodeMgr.isCameraParamPIP(VW)) {
            i2 = R.drawable.v4_xiaoying_cam_indicator_pip_selector;
            m14109YH();
        }
        this.bZu.setImageResource(i2);
        if (CameraCodeMgr.isCameraParamPIP(VW)) {
            i = R.drawable.v4_xiaoying_cam_indicator_pip_swap_selector;
            m14109YH();
        } else {
            i = R.drawable.xiaoying_cam_indicator_speed_normal_selector;
        }
        this.bZv.setImageResource(i);
    }
}
