package com.introvd.template.common.behavior;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

public class UserBehaviorABTestUtils {
    private static final String TAG = "UserBehaviorABTestUtils";

    public static void eventMapAddTabList(Context context, String str, HashMap hashMap) {
        UserBehaviorLog.onKVEvent(context, str, hashMap);
    }

    public static void homeCreateTipDisappear(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("how", str);
        UserBehaviorLog.onKVEvent(context, "Home_Create_Tip_Disappear", hashMap);
    }

    public static void homeFunctionTipClick(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        UserBehaviorLog.onKVEvent(context, "Home_Function_Tip_Click", hashMap);
    }

    public static void homeFunctionTipShow(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        UserBehaviorLog.onKVEvent(context, "Home_Function_Tip_Show", hashMap);
    }

    public static void homeTabCreateTipClick(Context context) {
        UserBehaviorLog.onKVEvent(context, "Home_tab_create_tip_click", new HashMap());
    }

    public static void homeTabCreateTipShow(Context context) {
        UserBehaviorLog.onKVEvent(context, "Home_tab_create_tip_show", new HashMap());
    }

    public static void onEventExploreBanner(Context context, int i, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Explore_Banner";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Explore_Banner";
            hashMap.put("click", str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("order", sb.toString());
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventExportdoneRecommend(Context context, int i, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Exportdone_Recommend";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Exportdone_Recommend";
            hashMap.put("click", str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("order", sb.toString());
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventFloatBanner(Context context, int i, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Float_Banner";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Float_Banner";
            hashMap.put("click", str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("order", sb.toString());
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventHomeNavigationRight(Context context, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Home_Navigation_Right";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Home_Navigation_Right";
            hashMap.put("click", str);
        }
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventHomeRecommend(Context context, int i, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Home_Recommend";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Home_Recommend";
            hashMap.put("click", str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("order", sb.toString());
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventHomeRecommendGroup(Context context, int i, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Home_Recommend_Group";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Home_Recommend_Group";
            hashMap.put("click", str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("order", sb.toString());
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventNavigationbarIcon(Context context, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Navigationbar_Icon";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Navigationbar_Icon";
            hashMap.put("click", str);
        }
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventShowExploreRecommend(Context context, int i, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Explore_Recommend";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Explore_Recommend";
            hashMap.put("click", str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("order", sb.toString());
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventShowHomeMain(Context context, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("show", str);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("order", sb.toString());
        hashMap.put("id", str2);
        eventMapAddTabList(context, "Show_Home_Main", hashMap);
    }

    public static void onEventShowHomePop(Context context, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Home_Pop";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Home_Pop";
            hashMap.put("click", str);
        }
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventShowHomeSecondary(Context context, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("show", str);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("order", sb.toString());
        hashMap.put("id", str2);
        eventMapAddTabList(context, "Show_Home_Secondary", hashMap);
    }

    public static void onEventShowSetting(Context context, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Setting";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Setting";
            hashMap.put("click", str);
        }
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventShowSplash(Context context, String str, long j, boolean z) {
        String str2;
        HashMap hashMap = new HashMap();
        if (z) {
            str2 = "Show_Splash";
            hashMap.put("show", str);
        } else {
            str2 = "Click_Splash";
            hashMap.put("click", str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("");
        hashMap.put("id", sb.toString());
        eventMapAddTabList(context, str2, hashMap);
    }

    public static void onEventTemplateBanner(Context context, int i, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Template_Banner";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Template_Banner";
            hashMap.put("click", str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("order", sb.toString());
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventTopIcon(Context context, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_Top_Background";
            hashMap.put("show", str);
        } else {
            str3 = "Click_Top_Background";
            hashMap.put("click", str);
        }
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }

    public static void onEventVIPPage(Context context, String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        if (z) {
            str3 = "Show_VIP_Page";
            hashMap.put("show", str);
        } else {
            str3 = "Click_VIP_Page";
            hashMap.put("click", str);
        }
        hashMap.put("id", str2);
        eventMapAddTabList(context, str3, hashMap);
    }
}
