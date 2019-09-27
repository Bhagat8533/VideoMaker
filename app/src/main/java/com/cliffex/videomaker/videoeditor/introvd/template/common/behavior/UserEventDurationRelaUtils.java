package com.introvd.template.common.behavior;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4599k;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.ironsource.sdk.controller.BannerJSAdapter;
import java.util.HashMap;
import java.util.Map;

public class UserEventDurationRelaUtils {
    private static HashMap<String, Long> cdB = new HashMap<>();
    private static Map<String, Integer> cdC = new HashMap();
    private static Map<String, String> cdD = new HashMap();

    /* renamed from: a */
    private static HashMap<String, String> m14279a(Context context, long j, String str, String str2, String str3, String str4) {
        String str5 = ">30s";
        if (j <= 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j);
            str5 = sb.toString();
        } else if (j <= 10) {
            str5 = "5-10s";
        } else if (j <= 20) {
            str5 = "10-20s";
        } else if (j <= 30) {
            str5 = "20-30s";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("result", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        hashMap.put("duration", str5);
        hashMap.put("name", str3);
        hashMap.put("ttid", str4);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(C4599k.m11734dM(context));
        hashMap.put("contype", sb2.toString());
        return hashMap;
    }

    public static void dummyXytDownloadStartEvent(Context context, String str, String str2, String str3) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put("download_type", str2);
            hashMap.put("ttid", str3);
            UserBehaviorLog.onKVEvent(context, "Template_DownloadDirect_Start", hashMap);
        }
    }

    public static void finishDummyDuraEventFail(Context context, String str, String str2, String str3, String str4, String str5, boolean z) {
        if (!TextUtils.isEmpty(str) && cdB != null && cdB.get(str) != null) {
            long longValue = ((Long) cdB.get(str)).longValue();
            if (longValue > 0) {
                long currentTimeMillis = ((System.currentTimeMillis() - longValue) + 500) / 1000;
                HashMap a = m14279a(context, currentTimeMillis < 0 ? 0 : currentTimeMillis, BannerJSAdapter.FAIL, str3, str4, str);
                a.put("activity_finished", z ? "yes" : "no");
                a.put("type", str5);
                a.put("failtype", str5);
                UserBehaviorLog.onKVEvent(context, str2, a);
            }
        }
    }

    public static void finishDuraEventFail(Context context, String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && cdB != null && cdB.get(str) != null) {
            long longValue = ((Long) cdB.get(str)).longValue();
            if (longValue > 0) {
                long currentTimeMillis = ((System.currentTimeMillis() - longValue) + 500) / 1000;
                UserBehaviorLog.onKVEvent(context, str2, m14279a(context, currentTimeMillis < 0 ? 0 : currentTimeMillis, BannerJSAdapter.FAIL, str3, str4, str));
            }
        }
    }

    public static void finishDuraEventSuc(Context context, String str, String str2, String str3, String str4) {
        if (cdB != null && cdB.containsKey(str) && ((Long) cdB.get(str)).longValue() > 0) {
            finishDuraEventSuc(context, str, str2, str3, str4, ParametersKeys.ORIENTATION_NONE);
        }
    }

    public static void finishDuraEventSuc(Context context, String str, String str2, String str3, String str4, String str5) {
        Context context2 = context;
        String str6 = str;
        if (cdB != null && cdB.containsKey(str)) {
            long longValue = ((Long) cdB.get(str)).longValue();
            long j = 0;
            if (longValue > 0) {
                long currentTimeMillis = System.currentTimeMillis() - longValue;
                long j2 = (500 + currentTimeMillis) / 1000;
                HashMap a = m14279a(context, j2 < 0 ? 0 : j2, "success", str3, str4, str);
                if (!TextUtils.isEmpty(str5)) {
                    a.put("type", str5);
                }
                String str7 = str2;
                UserBehaviorLog.onKVEvent(context, str2, a);
                j = currentTimeMillis;
            }
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j);
            hashMap.put("duration", sb.toString());
            if (cdC != null && cdC.containsKey(str)) {
                Integer num = (Integer) cdC.get(str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(num);
                hashMap.put("fileSize", sb2.toString());
            }
            String str8 = "";
            if (cdD != null && cdD.containsKey(str)) {
                str8 = (String) cdD.get(str);
            }
            hashMap.put("domain", str8);
            hashMap.put("ttid", str);
            UserBehaviorLog.onKVEvent(context, "DEV_Event_Template_Download_Performance_Log", hashMap);
        }
    }

    public static void startDurationEvent(String str, int i, String str2) {
        cdB.put(str, Long.valueOf(System.currentTimeMillis()));
        cdC.put(str, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            cdD.put(str, str2);
        }
    }
}
