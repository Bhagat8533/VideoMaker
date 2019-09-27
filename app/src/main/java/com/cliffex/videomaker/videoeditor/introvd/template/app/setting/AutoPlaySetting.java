package com.introvd.template.app.setting;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.ironsource.environment.ConnectivityService;

public class AutoPlaySetting extends EventActivity implements OnClickListener {
    private RelativeLayout bAK;
    private RelativeLayout bAL;
    private RelativeLayout bAM;
    private ImageView bAN;
    private ImageView bAO;
    private ImageView bAP;
    private int bAQ;
    private ImageView bvn;

    /* renamed from: bN */
    private void m10738bN(boolean z) {
        String str = "";
        if (this.bAQ == 0) {
            this.bAN.setVisibility(0);
            this.bAO.setVisibility(8);
            this.bAP.setVisibility(8);
            str = "never";
        } else if (this.bAQ == 1) {
            this.bAN.setVisibility(8);
            this.bAO.setVisibility(0);
            this.bAP.setVisibility(8);
            str = ConnectivityService.NETWORK_TYPE_WIFI;
        } else if (this.bAQ == 2) {
            this.bAN.setVisibility(8);
            this.bAO.setVisibility(8);
            this.bAP.setVisibility(0);
            str = "data&wifi";
        }
        if (z) {
            UserBehaviorUtilsV5.recordAutoplaySwitchStatus(this, str);
            AppPreferencesSetting.getInstance().setAppSettingInt("pref_key_setting_autoplay_type", this.bAQ);
        }
    }

    private void initUI() {
        this.bAN = (ImageView) findViewById(R.id.img_check_autoplay_none);
        this.bAO = (ImageView) findViewById(R.id.img_check_autoplay_wifi);
        this.bAP = (ImageView) findViewById(R.id.img_check_autoplay_mobile);
        this.bAK = (RelativeLayout) findViewById(R.id.check_autoplay_none_layout);
        this.bAL = (RelativeLayout) findViewById(R.id.check_autoplay_wifi_layout);
        this.bAM = (RelativeLayout) findViewById(R.id.check_autoplay_mobile_layout);
        this.bAK.setOnClickListener(this);
        this.bAL.setOnClickListener(this);
        this.bAM.setOnClickListener(this);
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.bvn.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.equals(this.bAK)) {
            this.bAQ = 0;
            m10738bN(true);
        } else if (view.equals(this.bAL)) {
            this.bAQ = 1;
            m10738bN(true);
        } else if (view.equals(this.bAM)) {
            this.bAQ = 2;
            m10738bN(true);
        } else if (view.equals(this.bvn)) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.setting_auto_play_layout);
        initUI();
        this.bAQ = AppPreferencesSetting.getInstance().getAppSettingInt("pref_key_setting_autoplay_type", -1);
        if (this.bAQ == -1) {
            this.bAQ = C3742b.m9111II().mo23122IP();
        }
        m10738bN(false);
    }
}
