package com.introvd.template.app.homepage.pop;

import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.homepage.pop.h */
final class C3998h {
    /* renamed from: du */
    static void m9883du(String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "viva_home_popup_record", hashMap);
    }
}
