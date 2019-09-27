package com.introvd.template.editor.export;

import com.introvd.template.common.AppPreferencesSetting;

/* renamed from: com.introvd.template.editor.export.g */
public class C6253g {
    public static int alt() {
        return AppPreferencesSetting.getInstance().getAppSettingInt("key_pref_hd_privilege_share_state", 1);
    }

    public static String alu() {
        return AppPreferencesSetting.getInstance().getAppSettingStr("key_pref_share_hd_unlock_sns", "unknown");
    }

    /* renamed from: hE */
    public static void m17915hE(String str) {
        AppPreferencesSetting.getInstance().setAppSettingStr("key_pref_share_hd_unlock_sns", str);
    }

    /* renamed from: no */
    public static void m17916no(int i) {
        AppPreferencesSetting.getInstance().setAppSettingInt("key_pref_hd_privilege_share_state", i);
    }
}
