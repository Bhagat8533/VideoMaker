package com.introvd.template.app.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p177b.C3748e;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.Switch;
import com.introvd.template.p414ui.dialog.C8978m;
import java.util.HashMap;

public class SettingNetWorkActivity extends EventActivity implements OnClickListener {
    private TextView bCQ;
    /* access modifiers changed from: private */
    public Switch bCR;
    private Switch bCS;
    private Switch bCT;
    private RelativeLayout bCU;
    private RelativeLayout bCV;
    private RelativeLayout bCW;
    private boolean bCX;
    private ImageView byK;

    /* renamed from: In */
    private void m10829In() {
        this.bCU.setOnClickListener(this);
        this.byK.setOnClickListener(this);
        this.bCV.setOnClickListener(this);
        this.bCW.setOnClickListener(this);
    }

    /* renamed from: PD */
    private void m10830PD() {
        if (C3748e.m9193JX().mo23193JZ()) {
            this.bCV.setVisibility(0);
            this.bCS.setChecked(C3748e.m9193JX().mo23195Kb());
        } else {
            this.bCV.setVisibility(8);
        }
        boolean z = true;
        this.bCR.setChecked(AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_network_wifi", true));
        this.bCQ.setText(R.string.xiaoying_str_com_pref_setting_network);
        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("auto_play_with_4g", -1);
        if (appSettingInt != -1) {
            if (appSettingInt != 1) {
                z = false;
            }
            this.bCX = z;
        } else {
            this.bCX = C3742b.m9111II().mo23123IQ();
        }
        this.bCT.setChecked(this.bCX);
        if (C3742b.m9111II().mo23125IS()) {
            this.bCW.setVisibility(0);
        } else {
            this.bCW.setVisibility(8);
        }
    }

    /* renamed from: PE */
    private void m10831PE() {
        boolean z = !AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_network_wifi", true);
        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_wifi", z);
        if (!AppStateModel.getInstance().isCommunitySupport()) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_mobile", false);
        } else if (!z) {
            String string = getResources().getString(R.string.xiaoying_str_com_dialog_attention);
            String string2 = getResources().getString(R.string.xiaoying_str_community_network_allow_3g);
            final HashMap hashMap = new HashMap();
            C8978m.m26350ht(this).mo10312q(string).mo10315r(string2).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    SettingNetWorkActivity.this.bCR.setChecked(true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("key_prefer_network_usage_wifi_switch_is_changed", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_wifi", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_mobile", false);
                    hashMap.put("type", "wifi only");
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    SettingNetWorkActivity.this.bCR.setChecked(false);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_wifi", false);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("key_prefer_network_usage_wifi_switch_is_changed", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_mobile", true);
                    hashMap.put("type", "wifi+mobile");
                }
            }).mo10275a((OnCancelListener) new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    SettingNetWorkActivity.this.bCR.setChecked(true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("key_prefer_network_usage_wifi_switch_is_changed", false);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_wifi", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_mobile", false);
                    hashMap.put("type", "wifi only");
                }
            }).mo10313qu().show();
        } else {
            this.bCR.setChecked(true);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("key_prefer_network_usage_wifi_switch_is_changed", true);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_wifi", true);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_mobile", false);
        }
    }

    public void onClick(View view) {
        if (view.equals(this.byK)) {
            finish();
        } else if (view.equals(this.bCV)) {
            this.bCS.setChecked(C3748e.m9193JX().mo23194Ka());
            C3748e.m9193JX().mo23196Kc();
        } else if (view.equals(this.bCU)) {
            m10831PE();
        } else if (view.equals(this.bCW)) {
            this.bCX = !this.bCX;
            this.bCT.setChecked(this.bCX);
            AppPreferencesSetting.getInstance().setAppSettingInt("auto_play_with_4g", this.bCX ? 1 : 0);
            HashMap hashMap = new HashMap();
            hashMap.put("State", this.bCX ? "打开" : "关闭");
            UserBehaviorLog.onKVEvent(this, "Click_Set_NetworkSet_MonetAutoPlay", hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.xyappv5_activity_setting_network);
        this.byK = (ImageView) findViewById(R.id.setting_back);
        this.bCQ = (TextView) findViewById(R.id.setting_title_content);
        this.bCR = (Switch) findViewById(R.id.setting_network_wifi_checkbox);
        this.bCS = (Switch) findViewById(R.id.setting_auto_play_next);
        this.bCT = (Switch) findViewById(R.id.setting_network_4g_checkbox);
        this.bCU = (RelativeLayout) findViewById(R.id.setting_network_wifi_rl);
        this.bCV = (RelativeLayout) findViewById(R.id.setting_auto_play_next_rl);
        this.bCW = (RelativeLayout) findViewById(R.id.setting_network_4g_rl);
        m10829In();
        m10830PD();
    }
}
