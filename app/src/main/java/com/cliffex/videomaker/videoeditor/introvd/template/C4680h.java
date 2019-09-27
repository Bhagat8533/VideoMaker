package com.introvd.template;

import android.content.Context;
import android.os.Build;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.introvd.template.h */
class C4680h {
    /* renamed from: F */
    static void m12181F(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("choose", str);
        UserBehaviorLog.onKVEvent(context, "Dev_Event_Change_Install_Mode", hashMap);
    }

    /* renamed from: G */
    static void m12182G(Context context, String str) {
        String language = Locale.getDefault().getLanguage();
        HashMap hashMap = new HashMap();
        hashMap.put("language", language);
        hashMap.put("country", str);
        UserBehaviorLog.onKVEvent(context, "System_Language_India", hashMap);
    }

    /* renamed from: bx */
    static void m12183bx(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("uuid", Build.SERIAL);
        hashMap.put("language", Locale.getDefault().getLanguage());
        UserBehaviorLog.onKVEvent(context, "app_button_back", hashMap);
    }
}
