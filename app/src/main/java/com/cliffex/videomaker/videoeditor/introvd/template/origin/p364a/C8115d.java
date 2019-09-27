package com.introvd.template.origin.p364a;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p203b.C4600l;
import java.util.HashMap;

/* renamed from: com.introvd.template.origin.a.d */
class C8115d {
    /* renamed from: a */
    static void m23505a(boolean z, JsonObject jsonObject) {
        LogUtilsV2.m14227d("AppConfig:DEV_EVENT_APP_CONFIG_NET_WORK success=");
        HashMap hashMap = new HashMap();
        hashMap.put("result", z ? "success" : "success error");
        if (!z && jsonObject != null && TextUtils.isEmpty(jsonObject.toString())) {
            hashMap.put("errorJson", jsonObject.toString());
        }
        UserBehaviorLog.onAliEvent("dev_event_app_config_net_work", hashMap);
    }

    /* renamed from: a */
    public static void m23506a(boolean z, String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("AppConfig:DEV_EVENT_APP_CONFIG needCheck=");
        sb.append(z);
        sb.append(",reason=");
        sb.append(str);
        LogUtilsV2.m14227d(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("needCheck", String.valueOf(z));
        hashMap.put("reason", str);
        if (j > 0) {
            hashMap.put("interval", m23507aR(j));
        }
        UserBehaviorLog.onAliEvent("dev_event_app_config", hashMap);
    }

    /* renamed from: aR */
    private static String m23507aR(long j) {
        return j <= 60 ? "1min" : j <= 1800 ? "1-30min" : j <= 3600 ? "30-60min" : j <= 7200 ? "1h-2h" : j <= 14400 ? "2h-4h" : j <= 21600 ? "4h-6h" : j <= 86400 ? "6h-24h" : j <= 172800 ? "24h-48h" : ">48h";
    }

    /* renamed from: l */
    static void m23508l(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("AppConfig:DEV_EVENT_APP_CONFIG_NET_WORK errorCode=");
        sb.append(i);
        LogUtilsV2.m14227d(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("result", String.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("language", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("country", str2);
        }
        UserBehaviorLog.onAliEvent("dev_event_app_config_net_work", hashMap);
    }

    /* renamed from: s */
    static void m23509s(String str, String str2, String str3) {
        boolean k = C4600l.m11739k(VivaBaseApplication.m8749FZ(), false);
        StringBuilder sb = new StringBuilder();
        sb.append("AppConfig:DEV_EVENT_APP_CONFIG_CLIENT_WORK country=");
        sb.append(str2);
        sb.append(",networkConnect=");
        sb.append(k);
        sb.append(",msg=");
        sb.append(str3);
        LogUtilsV2.m14227d(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("result", String.valueOf(-1111));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("language", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("country", str2);
        }
        hashMap.put("netWork", String.valueOf(k));
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("msg", str3);
        }
        UserBehaviorLog.onAliEvent("dev_event_app_config_client_work", hashMap);
    }
}
