package com.introvd.template.p203b;

import com.introvd.template.common.AppPreferencesSetting;
import com.p131c.p132a.p135c.C2575a;

/* renamed from: com.introvd.template.b.h */
public class C4596h {
    /* renamed from: Sp */
    public static final void m11716Sp() {
        AppPreferencesSetting.getInstance().setAppSettingInt("FLAG_HW_RUN", AppPreferencesSetting.getInstance().getAppSettingInt("FLAG_HW_RUN", 0) + 1);
    }

    /* renamed from: Sq */
    public static final void m11717Sq() {
        AppPreferencesSetting.getInstance().setAppSettingInt("FLAG_HW_RUN", 0);
    }

    /* renamed from: Sr */
    public static void m11718Sr() {
        AppPreferencesSetting.getInstance().setAppSettingInt("FLAG_EXP_RUN", AppPreferencesSetting.getInstance().getAppSettingInt("FLAG_EXP_RUN", 0) + 1);
    }

    /* renamed from: Ss */
    public static void m11719Ss() {
        AppPreferencesSetting.getInstance().setAppSettingInt("FLAG_EXP_RUN", 0);
        AppPreferencesSetting.getInstance().setAppSettingBoolean("FLAG_IS_VIDEO_EXP_CRASH_REPORT", false);
    }

    /* renamed from: St */
    public static void m11720St() {
        AppPreferencesSetting.getInstance().setAppSettingBoolean("FLAG_IS_VIDEO_EXP_CRASH_REPORT", true);
    }

    /* renamed from: Su */
    public static boolean m11721Su() {
        return AppPreferencesSetting.getInstance().getAppSettingInt("FLAG_EXP_RUN", 0) >= 1 && !AppPreferencesSetting.getInstance().getAppSettingBoolean("FLAG_IS_VIDEO_EXP_CRASH_REPORT", false);
    }

    /* renamed from: Sv */
    public static void m11722Sv() {
        AppPreferencesSetting.getInstance().setAppSettingStr("flag_config_upgrade_time", String.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: Sw */
    public static void m11723Sw() {
        AppPreferencesSetting.getInstance().setAppSettingStr("flag_config_upgrade_time", "0");
    }

    /* renamed from: Sx */
    public static boolean m11724Sx() {
        return Math.abs(System.currentTimeMillis() - C2575a.parseLong(AppPreferencesSetting.getInstance().getAppSettingStr("flag_config_upgrade_time", "0"))) >= 86400000;
    }

    /* renamed from: Sy */
    public static boolean m11725Sy() {
        return AppPreferencesSetting.getInstance().getAppSettingBoolean("fb_copyright_tip", false);
    }

    /* renamed from: Sz */
    public static void m11726Sz() {
        AppPreferencesSetting.getInstance().setAppSettingBoolean("fb_copyright_tip", true);
    }
}
