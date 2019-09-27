package com.introvd.template.app.youngermode.p202b;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.youngermode.b.a */
public class C4556a {
    /* renamed from: ac */
    public static void m11505ac(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("State", str);
        UserBehaviorLog.onKVEvent(context, "State_Setting_YoungMod", hashMap);
    }

    /* renamed from: ad */
    public static void m11506ad(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("State", str);
        UserBehaviorLog.onKVEvent(context, "Click_YoungMod_OnStep", hashMap);
    }

    /* renamed from: ae */
    public static void m11507ae(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("option", str);
        UserBehaviorLog.onKVEvent(context, "Click_YoungMod_Dialog", hashMap);
    }

    /* renamed from: af */
    public static void m11508af(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Type", str);
        UserBehaviorLog.onKVEvent(context, " Pageview_YoungMod_TimeLimit", hashMap);
    }

    /* renamed from: ds */
    public static void m11509ds(Context context) {
        UserBehaviorLog.onKVEvent(context, "Pageview_Setting_YoungMod", new HashMap());
    }

    /* renamed from: dt */
    public static void m11510dt(Context context) {
        UserBehaviorLog.onKVEvent(context, "Success_YoungMod", new HashMap());
    }

    /* renamed from: du */
    public static void m11511du(Context context) {
        UserBehaviorLog.onKVEvent(context, "Pageview_YoungMod_Dialog", new HashMap());
    }

    /* renamed from: j */
    public static void m11512j(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("Step", str);
        hashMap.put("Type", str2);
        UserBehaviorLog.onKVEvent(context, "Click_YoungMod_OffStep", hashMap);
    }
}
