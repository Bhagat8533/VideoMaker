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
import com.introvd.template.p414ui.view.RotateImageView;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.indicator.IndicatorBarLan */
public class IndicatorBarLan extends RelativeLayout implements OnClickListener {
    private C4664c bZH;
    private RotateImageView bZI;
    private RotateImageView bZJ;
    private RotateImageView bZK;
    private RotateImageView bZL;
    private ImageView bZM;
    private Context mContext;

    public IndicatorBarLan(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public IndicatorBarLan(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public IndicatorBarLan(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    /* renamed from: YH */
    private void m14111YH() {
        boolean z = C5008i.m12937VU().mo25621Wh() || (-1 != C5008i.m12937VU().mo25622Wi() && !C5008i.m12937VU().mo25620Wg());
        this.bZJ.setEnabled(z);
        this.bZI.setEnabled(z);
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_indicator_lan, this, true);
        this.bZI = (RotateImageView) findViewById(R.id.img_effect);
        this.bZJ = (RotateImageView) findViewById(R.id.img_mode);
        this.bZK = (RotateImageView) findViewById(R.id.img_switch);
        this.bZL = (RotateImageView) findViewById(R.id.img_setting);
        this.bZM = (ImageView) findViewById(R.id.cam_btn_cancel_capture);
        this.bZI.setOnClickListener(this);
        this.bZJ.setOnClickListener(this);
        this.bZK.setOnClickListener(this);
        this.bZL.setOnClickListener(this);
        this.bZM.setOnClickListener(this);
    }

    /* renamed from: YI */
    public void mo26237YI() {
        boolean Wc = C5008i.m12937VU().mo25616Wc();
        boolean Wl = C5008i.m12937VU().mo25625Wl();
        boolean Wd = C5008i.m12937VU().mo25617Wd();
        boolean We = C5008i.m12937VU().mo25618We();
        boolean Wm = C5008i.m12937VU().mo25626Wm();
        boolean Wf = C5008i.m12937VU().mo25619Wf();
        boolean Wo = C5008i.m12937VU().mo25628Wo();
        boolean z = true;
        this.bZI.setSelected(Wc || Wf || Wl);
        this.bZL.setSelected(Wo);
        if (CameraCodeMgr.isCameraParamPIP(C5008i.m12937VU().mo25610VW())) {
            this.bZJ.setSelected(false);
            return;
        }
        RotateImageView rotateImageView = this.bZJ;
        if (!Wd && !We && !Wm) {
            z = false;
        }
        rotateImageView.setSelected(z);
    }

    public void onClick(View view) {
        if (view.equals(this.bZI)) {
            if (this.bZH != null) {
                this.bZH.mo24978iJ(0);
            }
        } else if (view.equals(this.bZJ)) {
            if (this.bZH != null) {
                this.bZH.mo24978iJ(1);
            }
        } else if (view.equals(this.bZK)) {
            if (this.bZH != null) {
                this.bZH.mo24978iJ(2);
            }
        } else if (view.equals(this.bZL)) {
            if (this.bZH != null) {
                this.bZH.mo24978iJ(3);
            }
        } else if (view.equals(this.bZM) && this.bZH != null) {
            this.bZH.mo24978iJ(4);
        }
    }

    public void setIndicatorItemClickListener(C4664c cVar) {
        this.bZH = cVar;
    }

    public void update() {
        if (AppPreferencesSetting.getInstance().getAppSettingInt("pref_view_camera_count", 1) > 1) {
            this.bZK.setVisibility(0);
        } else {
            this.bZK.setVisibility(8);
        }
        this.bZI.setEnabled(true);
        this.bZJ.setEnabled(true);
        int VW = C5008i.m12937VU().mo25610VW();
        this.bZI.setVisibility(0);
        int i = R.drawable.v4_xiaoying_cam_indicator_effect_selector;
        if (CameraCodeMgr.isCameraParamPIP(VW)) {
            i = R.drawable.v4_xiaoying_cam_indicator_pip_selector;
        }
        this.bZI.setImageResource(i);
        this.bZJ.setImageResource(CameraCodeMgr.isCameraParamPIP(VW) ? R.drawable.v4_xiaoying_cam_indicator_pip_swap_selector : R.drawable.xiaoying_cam_indicator_speed_normal_selector);
        this.bZJ.setVisibility(0);
        if (CameraCodeMgr.isCameraParamPIP(VW)) {
            m14111YH();
        }
    }
}
