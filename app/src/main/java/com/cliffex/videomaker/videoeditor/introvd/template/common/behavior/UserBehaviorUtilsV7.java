package com.introvd.template.common.behavior;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import java.util.HashMap;

public class UserBehaviorUtilsV7 {
    private static final String TAG = "UserBehaviorUtilsV7";

    public static void eventClickVivaplanetBackTop(Context context) {
        UserBehaviorLog.onKVEvent(context, "Click_VivaPlanet_BackTop", new HashMap());
    }

    public static void eventPageviewOverseasLogin(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("position", str2);
        UserBehaviorLog.onKVEvent(context, "Pageview_Overseas_Login", hashMap);
    }

    public static void eventPageviewVivaPlanetBackTop(Context context) {
        UserBehaviorLog.onKVEvent(context, "Pageview_VivaPlanet_BackTop", new HashMap());
    }

    public static void onEventClickHomepageDraftList(Context context, String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("action", str);
        }
        UserBehaviorLog.onKVEvent(context, "Click_Homepage_DraftList", hashMap);
    }

    public static void onEventClickLanguageChoose(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("option", str);
        UserBehaviorLog.onKVEvent(context, "Click_LanguageChoose", hashMap);
    }

    public static void onEventPageviewHomepage(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialConstDef.ACTIVITY_VIDEOLIST_LABEL, str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("DraftTips", str3);
        }
        UserBehaviorLog.onKVEvent(context, "Pageview_Homepage", hashMap);
    }

    public static void onEventPageviewLanguageChoose(Context context) {
        UserBehaviorLog.onKVEvent(context, "Pageview_LanguageChoose", new HashMap());
    }
}
