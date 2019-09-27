package com.introvd.template.app.p176a;

import android.content.Context;
import com.introvd.template.C3569a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.a.b */
public class C3677b {
    /* renamed from: b */
    private static void m8969b(String str, String str2, long j) {
        long j2 = j / 50;
        HashMap hashMap = new HashMap();
        hashMap.put("fileParent", str);
        hashMap.put("fileName", str2);
        hashMap.put("fileSize50kb", String.valueOf(j2));
        UserBehaviorLog.onAliEvent("dev_event_shared_pref_795_1", hashMap);
    }

    /* renamed from: bV */
    public static void m8970bV(Context context) {
        if (!C3569a.m8773FL()) {
            AppPreferencesSetting.getInstance().removeAppKey("App_Config_Json");
            return;
        }
        try {
            File filesDir = context.getFilesDir();
            StringBuilder sb = new StringBuilder();
            sb.append(filesDir.getParent());
            sb.append("/shared_prefs/");
            String sb2 = sb.toString();
            File file = new File(sb2);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    for (String str : list) {
                        long j = -1;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(sb2);
                        sb3.append(str);
                        String sb4 = sb3.toString();
                        File file2 = new File(sb4);
                        if (file2.exists()) {
                            j = file2.length() / 1024;
                        }
                        if (str.contains("com.quvideo.xiaoying_preferences")) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("WARNING !!! FileSize = ");
                            sb5.append(j);
                            sb5.append("KB,FileName = ");
                            sb5.append(sb4);
                            LogUtilsV2.m14228e(sb5.toString());
                            m8969b(sb2, str, j);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
