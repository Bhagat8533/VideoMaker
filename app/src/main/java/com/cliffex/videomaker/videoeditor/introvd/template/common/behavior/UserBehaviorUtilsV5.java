package com.introvd.template.common.behavior;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.p021v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class UserBehaviorUtilsV5 {
    private static final String TAG = "UserBehaviorUtilsV5";

    public static void onEventActivityAttend(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("via", str);
        hashMap.put("title", str2);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str3);
        UserBehaviorLog.onKVEvent(context, "Activity_Attend_V5", hashMap);
    }

    public static void onEventCommunityPublishKeyboardTest(String str) {
        boolean IV = C3742b.m9111II().mo23128IV();
        HashMap hashMap = new HashMap();
        hashMap.put("Action", str);
        hashMap.put("Status", IV ? "pop up" : SocialServiceDef.EXTRAS_DOWNLOAD_TASK_SILENT);
        UserBehaviorLog.onAliEvent("Community_Publish_keyboard_test", hashMap);
    }

    public static void onEventDeeplinkAction(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put(str, sb.toString());
        UserBehaviorLog.onKVEvent(context, "Deeplink_Action", hashMap);
    }

    public static void onEventEditVideoCover(Context context) {
        UserBehaviorLog.onKVEvent(context, "Edit_Video_Cover_V5", new HashMap());
    }

    public static void onEventExploreBanner(Context context, String str, int i, boolean z) {
        HashMap hashMap = new HashMap();
        String str2 = "Explore_Banner_V5";
        if (z) {
            int i2 = Calendar.getInstance().get(11);
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append("");
            hashMap.put("show time period", sb.toString());
            hashMap.put("show", str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append("");
            hashMap.put("show order", sb2.toString());
        } else {
            str2 = "Explore_Banner_Click";
            hashMap.put("title", str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i);
            sb3.append("");
            hashMap.put("order", sb3.toString());
        }
        UserBehaviorLog.onKVEvent(context, str2, hashMap);
    }

    public static void onEventExploreSingleRecommend(Context context, boolean z, String str) {
        HashMap hashMap = new HashMap();
        int i = Calendar.getInstance().get(11);
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            hashMap.put("show time period", sb.toString());
            hashMap.put("show", str);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append("");
            hashMap.put("click time period", sb2.toString());
            hashMap.put("click", str);
        }
        UserBehaviorLog.onKVEvent(context, "Explore_Single_Recommend", hashMap);
    }

    public static void onEventHDFreeExportDialogAction(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        UserBehaviorLog.onKVEvent(context, "HD_Free_Export_Dialog_Action", hashMap);
    }

    public static void onEventHDFreeExportDialogClick(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", str);
        UserBehaviorLog.onKVEvent(context, "HD_Free_Export_Dialog_Click", hashMap);
    }

    public static void onEventHomeEditV5(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("configname", str2);
        UserBehaviorLog.onKVEvent(context, "Home_Edit_V6", hashMap);
        UserBehaviorUtils.recordHomeClick(str);
    }

    public static void onEventHomeFloatClick(Context context, String str, boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("click", str);
        } else {
            hashMap.put("close", str);
        }
        UserBehaviorLog.onKVEvent(context, "Home_Float_Click", hashMap);
    }

    public static void onEventHomeFloatShow(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "Home_Float_Show", hashMap);
    }

    public static void onEventHomeMore(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        UserBehaviorLog.onKVEvent(context, "Home_More", hashMap);
    }

    public static void onEventHomeRefreshOperation(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", str);
        UserBehaviorLog.onKVEvent(context, "Home_refresh_Operation", hashMap);
    }

    public static void onEventHomeScroll(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("direction", str);
        UserBehaviorLog.onKVEvent(context, "Home_Scroll", hashMap);
    }

    public static void onEventHomeSkinChange(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        UserBehaviorLog.onKVEvent(context, "Home_Skin_Change", hashMap);
    }

    public static void onEventHomeSlide(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("choose", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(SocialConstDef.TBL_NAME_SNS, str2);
        }
        UserBehaviorLog.onKVEvent(context, "Home_Slide", hashMap);
    }

    public static void onEventHomeStudioClick(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        UserBehaviorLog.onKVEvent(context, "Home_Studio_Click", hashMap);
    }

    public static void onEventLevelPageEnter(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str);
        UserBehaviorLog.onKVEvent(context, "Level_Page_Enter", hashMap);
    }

    public static void onEventMessageClick(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("redpoint", z ? "1" : "0");
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Message_Click_V5", hashMap);
    }

    public static void onEventPrivateAccountSwitch(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("FinalStatus", str);
        UserBehaviorLog.onKVEvent(context, "Private_Account_Switch", hashMap);
    }

    public static void onEventPushReceiveForeground(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialConstDef.TEMPLATEMONETIZATION_ITEM_TODOCODE, str);
        UserBehaviorLog.onKVEvent(context, "Push_Receive_Foreground", hashMap);
    }

    public static void onEventShortCutClick(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Click", str);
        UserBehaviorLog.onAliEvent("Shortcut_Click", hashMap);
    }

    public static void onEventTemplateListServerResult(Context context, String str, int i, int i2, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("tcid", str);
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("");
        hashMap.put("themeType", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb2.append("");
        hashMap.put("errorcode", sb2.toString());
        hashMap.put("result", str2);
        hashMap.put("api_code", str3);
        UserBehaviorLog.onKVEvent(context, "Dev_Template_List_Server_Result", hashMap);
    }

    public static void onEventUnlockMaterialRate(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("choose", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("result", str2);
        }
        UserBehaviorLog.onKVEvent(context, "Unlock_Material_Rate", hashMap);
    }

    public static void onEventVideoExploreScroll(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("direction", str);
        hashMap.put("to end", str2);
        UserBehaviorLog.onKVEvent(context, "Explore_Video_Scroll", hashMap);
    }

    public static void onEventVideoShare(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str);
        hashMap.put("sns", str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("todoCodeFromString", str3);
        }
        UserBehaviorLog.onKVEvent(context, "Video_Share_V5", hashMap);
    }

    public static void onEventVoiceSwitch(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("FinalStatus", str);
        UserBehaviorLog.onKVEvent(context, "Voice_Switch", hashMap);
    }

    public static void recordAutoplaySwitchStatus(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("recordAutoplaySwitchStatus status : ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("Status", str);
        UserBehaviorLog.onKVEvent(context, "Autoplay_Switch_Status", hashMap);
    }

    public static void recordDeviceLanguage() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", Locale.getDefault().toString());
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Device_Language", hashMap);
    }

    public static void recordFirstPage(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("recordFirstPage pageName : ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordFirstPage reason : ");
        sb2.append(str2);
        LogUtilsV2.m14230i(sb2.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("Page", str);
        hashMap.put("reason", str2);
        UserBehaviorLog.onKVEvent(context, "First_Page", hashMap);
    }

    public static void recordNotificationDisable(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("recordNotificationDisable : ");
        sb.append(Build.MODEL);
        LogUtilsV2.m14230i(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("Msg_ID", str);
        hashMap.put("Device_Brand", Build.BRAND);
        hashMap.put("System_Model", Build.MODEL);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(VERSION.RELEASE);
        sb2.append("");
        hashMap.put("System_Version", sb2.toString());
        UserBehaviorLog.onAliEvent("Dev_Event_Notification_Disable", hashMap);
    }

    public static void recordPermissionNotificationStatus(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", NotificationManagerCompat.from(context).areNotificationsEnabled() ? "on" : "off");
        hashMap.put("Device_Brand", Build.BRAND);
        hashMap.put("System_Model", Build.MODEL);
        StringBuilder sb = new StringBuilder();
        sb.append(VERSION.RELEASE);
        sb.append("");
        hashMap.put("System_Version", sb.toString());
        UserBehaviorLog.onAliEvent("Permission_Notification_Status", hashMap);
    }

    public static void recordPushArrive(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("recordPushArrive : ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordPushArrive : ");
        sb2.append(str2);
        LogUtilsV2.m14230i(sb2.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("carrier", str2);
        UserBehaviorLog.onKVEvent(context, "Remote_Push_Arrive", hashMap);
    }

    public static void recordPushClicked(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("recordPushClicked : ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("carrier", str2);
        UserBehaviorLog.onKVEvent(context, "Remote_Push_Click", hashMap);
    }

    public static void recordPushOperationEvent(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("recordPushOperationEvent : ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("method", str);
        hashMap.put("type", str2);
        UserBehaviorLog.onAliEvent("Push_Operation", hashMap);
    }

    public static void recordPushReceiveShow(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("recordPushReceiveShow : ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordPushReceiveShow : ");
        sb2.append(str2);
        LogUtilsV2.m14230i(sb2.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("show_result", str2);
        UserBehaviorLog.onKVEvent(context, "Remote_Push_Receive_Show", hashMap);
    }

    public static void recordPushReceived(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("recordPushReceived : ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordPushReceived : ");
        sb2.append(str2);
        LogUtilsV2.m14230i(sb2.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("show_result", str2);
        UserBehaviorLog.onKVEvent(context, "Remote_Push_Receive", hashMap);
    }
}
