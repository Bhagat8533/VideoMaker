package com.introvd.template.common.utils;

import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.p203b.C4580b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataRefreshValidateUtil {
    public static boolean isRefreshTimeout(String str, int i) {
        return C4580b.m11663f(AppPreferencesSetting.getInstance().getAppSettingStr(str, ""), (long) i);
    }

    public static void recordDataRefreshTime(String str) {
        AppPreferencesSetting.getInstance().setAppSettingStr(str, new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date()));
    }
}
