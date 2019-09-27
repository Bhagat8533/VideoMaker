package com.introvd.template.editor.p252e;

import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.p173a.C3570a;

/* renamed from: com.introvd.template.editor.e.c */
public class C5880c extends Thread {
    public void run() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_record_samplerate", 0);
            if (appSettingInt == 0) {
                appSettingInt = 16000;
            }
            CommonConfigure.APP_DEFAULT_AUDIO_SAMPLERATE = appSettingInt;
            StringBuilder sb = new StringBuilder();
            sb.append("initGlobalComponents, cost:");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            LogUtilsV2.m14227d(sb.toString());
        } catch (Throwable th) {
            C3570a.m8781x(2, true);
            throw th;
        }
        C3570a.m8781x(2, true);
    }
}
