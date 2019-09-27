package com.introvd.template.explorer.p299d;

import android.content.Context;
import com.introvd.template.common.AppPreferencesSetting;
import com.p131c.p132a.p135c.C2575a;

/* renamed from: com.introvd.template.explorer.d.f */
public class C7189f {
    /* renamed from: a */
    public static void m21245a(Context context, C7188e eVar, int i) {
        if (context != null && eVar != null) {
            String str = i == 28 ? "_facebook" : "_instagram";
            AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("user_id_sns");
            sb.append(str);
            instance.setAppSettingStr(sb.toString(), eVar.userId);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("user_name_sns");
            sb2.append(str);
            instance.setAppSettingStr(sb2.toString(), eVar.userName);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("last_update_time_sns");
            sb3.append(str);
            instance.setAppSettingStr(sb3.toString(), String.valueOf(System.currentTimeMillis()));
            StringBuilder sb4 = new StringBuilder();
            sb4.append("is_finish_fetching_sns");
            sb4.append(str);
            instance.setAppSettingBoolean(sb4.toString(), eVar.dDA);
        }
    }

    /* renamed from: ad */
    public static C7188e m21246ad(Context context, int i) {
        if (context == null) {
            return null;
        }
        String str = i == 28 ? "_facebook" : "_instagram";
        C7188e eVar = new C7188e();
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("user_id_sns");
        sb.append(str);
        eVar.userId = instance.getAppSettingStr(sb.toString(), "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("user_name_sns");
        sb2.append(str);
        eVar.userName = instance.getAppSettingStr(sb2.toString(), "");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("last_update_time_sns");
        sb3.append(str);
        eVar.lastUpdateTime = C2575a.parseLong(instance.getAppSettingStr(sb3.toString(), String.valueOf(System.currentTimeMillis())));
        StringBuilder sb4 = new StringBuilder();
        sb4.append("is_finish_fetching_sns");
        sb4.append(str);
        eVar.dDA = instance.getAppSettingBoolean(sb4.toString(), false);
        return eVar;
    }
}
