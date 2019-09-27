package com.introvd.template.app.p193m;

import android.content.Context;
import com.introvd.template.C3569a;
import com.introvd.template.app.manager.C4041a;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.m.a */
public class C4040a {
    /* renamed from: X */
    public static void m10034X(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("tab", str);
        UserBehaviorLog.onKVEvent(context, "Home_Tab_V5", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("tab", str);
        C4041a.m10046c(context, "Home_Tab_V5", hashMap2);
    }

    /* renamed from: cU */
    public static void m10035cU(Context context) {
        if (C3569a.m8772FK()) {
            HashMap hashMap = new HashMap();
            hashMap.put("isNew", String.valueOf(C3569a.m8772FK()));
            UserBehaviorLog.onKVEvent(context, "dev_new_enter_xy_act", hashMap);
        }
    }
}
