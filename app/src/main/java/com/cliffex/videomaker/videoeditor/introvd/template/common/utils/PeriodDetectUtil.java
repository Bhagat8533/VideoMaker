package com.introvd.template.common.utils;

import com.introvd.template.common.AppPreferencesSetting;
import com.p131c.p132a.p135c.C2575a;
import java.util.HashMap;
import java.util.Map;

public class PeriodDetectUtil {
    private static final Map<String, String> cache = new HashMap();

    public static void clear(String str) {
        cache.put(str, "0");
        AppPreferencesSetting.getInstance().setAppSettingStr(str, "0");
    }

    public static boolean isInPeriod(String str, long j) {
        String str2;
        if (cache.containsKey(str)) {
            str2 = (String) cache.get(str);
        } else {
            str2 = AppPreferencesSetting.getInstance().getAppSettingStr(str, "0");
            cache.put(str, str2);
        }
        if (Math.abs(System.currentTimeMillis() - C2575a.parseLong(str2)) < j) {
            return true;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        cache.put(str, valueOf);
        AppPreferencesSetting.getInstance().setAppSettingStr(str, valueOf);
        return false;
    }
}
