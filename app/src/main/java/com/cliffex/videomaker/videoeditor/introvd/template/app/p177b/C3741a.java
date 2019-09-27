package com.introvd.template.app.p177b;

import com.introvd.template.common.AppPreferencesSetting;

/* renamed from: com.introvd.template.app.b.a */
public class C3741a {
    /* renamed from: IG */
    public static void m9109IG() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("");
        AppPreferencesSetting.getInstance().setAppSettingStr("pref_key_last_app_launch_time", sb.toString());
    }

    /* renamed from: IH */
    public static void m9110IH() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("");
        AppPreferencesSetting.getInstance().setAppSettingStr("pref_key_last_push_receive_time", sb.toString());
    }
}
