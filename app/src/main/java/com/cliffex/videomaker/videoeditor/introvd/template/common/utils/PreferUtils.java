package com.introvd.template.common.utils;

import com.introvd.template.common.AppPreferencesSetting;

public class PreferUtils {
    public static void addCamEnterCount() {
        AppPreferencesSetting.getInstance().setAppSettingInt("key_cam_enter_count", AppPreferencesSetting.getInstance().getAppSettingInt("key_cam_enter_count", 0) + 1);
    }

    public static boolean isPhotoMvShortCutDialogShow() {
        return AppPreferencesSetting.getInstance().getAppSettingBoolean("key_photo_mv_shortcut_dialog_show", false);
    }

    public static void setPhotoMvShortcutDialogShow() {
        AppPreferencesSetting.getInstance().setAppSettingBoolean("key_photo_mv_shortcut_dialog_show", true);
    }
}
