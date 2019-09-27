package com.introvd.template.app;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.g */
public class C3879g {
    public static long biv;
    public static long biw;
    public static long startTime;

    /* renamed from: Hq */
    public static void m9551Hq() {
        startTime = System.currentTimeMillis();
    }

    /* renamed from: Hr */
    public static void m9552Hr() {
        biv = System.currentTimeMillis();
    }

    /* renamed from: bD */
    public static void m9553bD(Context context) {
        m9554d(context, "SplashGoToHome", System.currentTimeMillis() - startTime);
        m9554d(context, "DeviceRegistSuccess", biw - startTime);
        m9554d(context, "DeviceLoginSuccess", biv - startTime);
    }

    /* renamed from: d */
    private static void m9554d(Context context, String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("step", str);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(j);
        hashMap.put("interval", sb.toString());
        UserBehaviorLog.onKVEvent(context, "Dev_Event_Launch_Step", hashMap);
    }

    public static void onDeviceRegSuc() {
        biw = System.currentTimeMillis();
    }
}
