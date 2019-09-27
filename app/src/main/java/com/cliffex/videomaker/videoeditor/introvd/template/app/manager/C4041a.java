package com.introvd.template.app.manager;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialServiceDef;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.app.manager.a */
public class C4041a {
    /* access modifiers changed from: private */
    public static C4058c btR;
    public static volatile boolean btS;

    /* access modifiers changed from: private */
    /* renamed from: B */
    public static C4058c m10037B(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        C4058c cVar = new C4058c();
        cVar.bus = (String) map.get("af_status");
        cVar.buB = (String) map.get("is_first_launch");
        cVar.but = (String) map.get("media_source");
        cVar.buu = (String) map.get(Param.CAMPAIGN);
        cVar.buv = (String) map.get("af_keywords");
        cVar.buw = (String) map.get("is_fb");
        cVar.bux = (String) map.get("campaign_id");
        cVar.buy = (String) map.get("adset");
        cVar.buz = (String) map.get("adset_id");
        cVar.buA = (String) map.get("ad_id");
        return cVar;
    }

    /* renamed from: MV */
    public static void m10039MV() {
        btS = true;
    }

    /* renamed from: N */
    public static void m10041N(String str, String str2) {
    }

    /* renamed from: O */
    private static String m10042O(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    /* renamed from: a */
    public static void m10044a(Context context, double d, String str) {
    }

    /* renamed from: a */
    public static boolean m10045a(Context context, C4058c cVar) {
        if (cVar == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, m10042O(cVar.bus, ParametersKeys.ORIENTATION_NONE));
        hashMap.put("af_status", m10042O(cVar.bus, ParametersKeys.ORIENTATION_NONE));
        hashMap.put("isFirst", m10042O(cVar.buB, ParametersKeys.ORIENTATION_NONE));
        hashMap.put("af_media_source", m10042O(cVar.but, ParametersKeys.ORIENTATION_NONE));
        hashMap.put("af_campaign", m10042O(cVar.buu, ParametersKeys.ORIENTATION_NONE));
        hashMap.put("af_keywords", m10042O(cVar.buv, ParametersKeys.ORIENTATION_NONE));
        hashMap.put("af_is_fb", m10042O(cVar.buw, ParametersKeys.ORIENTATION_NONE));
        hashMap.put("af_fb_campaign_id", m10042O(cVar.bux, ParametersKeys.ORIENTATION_NONE));
        hashMap.put("af_fb_adset", m10042O(cVar.buy, ParametersKeys.ORIENTATION_NONE));
        hashMap.put("af_fb_adset_id", m10042O(cVar.buz, ParametersKeys.ORIENTATION_NONE));
        hashMap.put("af_fb_ad_id", m10042O(cVar.buA, ParametersKeys.ORIENTATION_NONE));
        UserBehaviorLog.onKVEvent(context, "New_User_From", hashMap);
        return true;
    }

    /* renamed from: c */
    public static void m10046c(Context context, String str, Map<String, Object> map) {
    }

    /* renamed from: cp */
    public static void m10047cp(Context context) {
    }

    /* renamed from: cq */
    public static String m10048cq(Context context) {
        return "";
    }

    /* renamed from: m */
    public static void m10049m(Application application) {
    }

    /* renamed from: o */
    public static void m10050o(Context context, String str) {
    }
}
