package com.introvd.template;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.p203b.C4580b;
import java.util.Locale;

/* renamed from: com.introvd.template.b */
public class C4561b {
    /* renamed from: FP */
    public static boolean m11529FP() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("key_first_launch_language", "");
        if (TextUtils.isEmpty(appSettingStr)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Preference langauge: ");
        sb.append(appSettingStr);
        LogUtils.m14223i("AppVersionMgr", sb.toString());
        return "zh_cn".equals(appSettingStr.toLowerCase(Locale.US));
    }

    /* renamed from: bm */
    public static boolean m11530bm(Context context) {
        String dx = C4580b.m11651dx(context);
        return dx != null && dx.toLowerCase().contains("ts");
    }
}
