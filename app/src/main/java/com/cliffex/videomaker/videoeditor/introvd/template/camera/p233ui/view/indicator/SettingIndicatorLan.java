package com.introvd.template.camera.p233ui.view.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.introvd.template.camera.p208a.C4668g;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p233ui.TimerImageView;
import com.introvd.template.camera.p233ui.TimerImageView.C5043a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p414ui.view.RotateImageView;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.indicator.SettingIndicatorLan */
public class SettingIndicatorLan extends RelativeLayout implements OnClickListener {
    private static final String TAG = "SettingIndicatorLan";
    private TimerImageView bZQ;
    /* access modifiers changed from: private */
    public C4668g bZR;
    private RotateImageView bZT;
    private RotateImageView bZU;
    private RotateImageView bZV;
    private Context mContext;
    private Animation mHideAnim;
    private Animation mShowAnim;

    public SettingIndicatorLan(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public SettingIndicatorLan(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public SettingIndicatorLan(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    /* renamed from: WV */
    private void m14118WV() {
        this.mShowAnim = AnimationUtils.loadAnimation(this.mContext, R.anim.v4_xiaoying_slide_out_up_self);
        this.mHideAnim = AnimationUtils.loadAnimation(this.mContext, R.anim.v4_xiaoying_slide_in_up_self);
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_setting_indicator_lan, this, true);
        this.bZT = (RotateImageView) findViewById(R.id.v4_img_flash);
        this.bZU = (RotateImageView) findViewById(R.id.v4_img_grid);
        this.bZQ = (TimerImageView) findViewById(R.id.v4_img_timer);
        this.bZV = (RotateImageView) findViewById(R.id.v4_img_aelock);
        this.bZT.setOnClickListener(this);
        this.bZU.setOnClickListener(this);
        this.bZV.setOnClickListener(this);
        this.bZQ.setmOnTimerModeChangeListener(new C5043a() {
            /* renamed from: js */
            public void mo25907js(int i) {
                if (SettingIndicatorLan.this.bZR != null) {
                    SettingIndicatorLan.this.bZR.mo24981bV(2, i);
                }
            }
        });
        m14118WV();
        update();
    }

    /* renamed from: ds */
    public void mo26246ds(boolean z) {
        if (getVisibility() == 0) {
            setVisibility(8);
            if (z) {
                startAnimation(this.mHideAnim);
            }
        }
        C5008i.m12937VU().mo25646cV(false);
    }

    /* renamed from: dy */
    public void mo26247dy(boolean z) {
        if (getVisibility() != 0) {
            setVisibility(0);
            if (z) {
                startAnimation(this.mShowAnim);
            }
        }
        C5008i.m12937VU().mo25646cV(true);
    }

    public void onClick(View view) {
        if (view.equals(this.bZT)) {
            if (this.bZR != null) {
                this.bZR.mo24982iL(0);
            }
        } else if (view.equals(this.bZU)) {
            if (this.bZR != null) {
                this.bZR.mo24982iL(1);
            }
        } else if (view.equals(this.bZQ)) {
            if (this.bZR != null) {
                this.bZR.mo24982iL(2);
            }
        } else if (view.equals(this.bZV) && this.bZR != null) {
            this.bZR.mo24982iL(4);
        }
    }

    public void setSettingItemClickListener(C4668g gVar) {
        this.bZR = gVar;
    }

    public void update() {
        int i;
        boolean z;
        int VW = C5008i.m12937VU().mo25610VW();
        int i2 = R.drawable.v4_xiaoying_cam_indicator_flash_on;
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_flash_mode", "no_flash");
        boolean z2 = true;
        if ("off".equals(appSettingStr) || "on".equals(appSettingStr)) {
            if ("on".equals(appSettingStr)) {
                i2 = R.drawable.v4_xiaoying_cam_indicator_flash_off;
            } else if ("off".equals(appSettingStr)) {
                i2 = R.drawable.v4_xiaoying_cam_indicator_flash_on;
            }
            i = i2;
            z = true;
        } else {
            i = i2;
            z = false;
        }
        int i3 = R.drawable.v4_xiaoying_cam_indicator_grid_on;
        String appSettingStr2 = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_grid", "off");
        if ("off".equals(appSettingStr2)) {
            i3 = R.drawable.v4_xiaoying_cam_indicator_grid_on;
        } else if ("on".equals(appSettingStr2)) {
            i3 = R.drawable.v4_xiaoying_cam_indicator_grid_off;
        }
        int i4 = R.drawable.v4_xiaoying_cam_indicator_aelock_unlock;
        String appSettingStr3 = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "unlock");
        if (!"unlock".equals(appSettingStr3) && !SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(appSettingStr3)) {
            z2 = false;
        } else if (SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(appSettingStr3)) {
            i4 = R.drawable.v4_xiaoying_cam_indicator_aelock_unlock;
        } else if ("unlock".equals(appSettingStr3)) {
            i4 = R.drawable.v4_xiaoying_cam_indicator_aelock_lock;
        }
        if (z) {
            this.bZT.setVisibility(0);
            this.bZT.setImageResource(i);
        } else {
            this.bZT.setVisibility(8);
        }
        if (!CameraCodeMgr.isCameraParamPIP(VW)) {
            this.bZU.setVisibility(0);
            this.bZU.setImageResource(i3);
        } else {
            this.bZU.setVisibility(8);
        }
        if (z2) {
            this.bZV.setVisibility(0);
            this.bZV.setImageResource(i4);
            return;
        }
        this.bZV.setVisibility(8);
    }
}
