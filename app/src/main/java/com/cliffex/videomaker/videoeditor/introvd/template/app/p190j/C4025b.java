package com.introvd.template.app.p190j;

import android.text.TextUtils;
import com.introvd.template.C3569a;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.alarm.C3724a;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.p236ui.custom.VideoAutoPlayHelper;
import com.introvd.template.router.app.config.AppConfigObserver;

/* renamed from: com.introvd.template.app.j.b */
public class C4025b extends AppConfigObserver {
    private boolean btO = false;

    /* renamed from: MT */
    private void m9992MT() {
        if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("key_prefer_network_usage_wifi_switch_is_changed", false)) {
            boolean IO = C3742b.m9111II().mo23121IO();
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_wifi", !IO);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_network_mobile", IO);
        }
    }

    /* renamed from: MU */
    private void m9993MU() {
        if (C3569a.m8772FK() && !this.btO) {
            this.btO = true;
            C3724a bR = C3724a.m9052bR(VivaBaseApplication.m8749FZ());
            bR.mo23081a(bR.mo23086gq(4104), 4104);
        }
    }

    public void onChange(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Type = ");
            sb.append(i);
            sb.append(",AppConfig = ");
            sb.append(str);
            LogUtilsV2.m14227d(sb.toString());
            C4023a.m9973MK().mo23681dH(str);
            m9992MT();
            m9993MU();
            VideoAutoPlayHelper.handleCreationVideoAutoPlayConfig(str);
        }
    }
}
