package com.introvd.template.common.behavior;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.biii.aiii.aiii.constants.ConstantsAPI.Token;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.C4681i;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.CpuFeatures;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4599k;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class UserBehaviorUtils {
    private static final String TAG = "UserBehaviorUtils";

    public static String getBehaviorSnsName(int i) {
        return i == 1 ? "weibo" : i == 10 ? "qq" : i == 7 ? Token.WX_TOKEN_PLATFORMID_VALUE : i == 28 ? "facebook" : i == 25 ? "google" : i == 3 ? "phone" : i == 38 ? "line" : i == 29 ? "twitter" : i == 31 ? "instagram" : i == 52 ? "phonenumber_oneclick" : i == 48 ? "PhoneNumber_CN" : "";
    }

    private static Context getContext() {
        return C4681i.m12184Gp().mo25017Gs();
    }

    public static String getResolutionStr(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("X");
        sb.append(i2);
        return sb.toString();
    }

    public static String getResolutionStr(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("X");
        sb.append(str2);
        return sb.toString();
    }

    public static void onEventDevDeviceX86(Context context) {
        if (CpuFeatures.isIntelCpu()) {
            HashMap hashMap = new HashMap();
            hashMap.put("dev_brand", Build.BRAND);
            hashMap.put("dev_manufacture", Build.MANUFACTURER);
            hashMap.put("dev_model", Build.MODEL);
            hashMap.put("dev_product", Build.PRODUCT);
            UserBehaviorLog.onKVEvent(context, "Dev_Device_X86", hashMap);
        }
    }

    public static void onEventShareExport2k4kSupport(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        UserBehaviorLog.onKVEvent(context, "Share_Export_2k_4k_Support", hashMap);
    }

    public static void recordCountrySimInfoEvent(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("isinclude", Arrays.binarySearch(AppStateModel.SimCountryCodes, AppStateModel.getInstance().getSimCountryCode()) >= 0 ? "yes" : "no");
        hashMap.put("countryCode", AppStateModel.getInstance().getSimCountryCode());
        UserBehaviorLog.onKVEvent(context, "Sim_Info_Result", hashMap);
    }

    public static void recordExportEmptyPrj(Context context) {
        try {
            UserBehaviorLog.onKVEvent(context, "Dev_Export_Empty_Prj", new HashMap());
        } catch (Exception unused) {
        }
    }

    public static void recordHomeClick(String str) {
        VivaBaseApplication Gs = C4681i.m12184Gp().mo25017Gs();
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(Gs, "Home_Click", hashMap);
    }

    public static void recordHomeStudioAdEvent(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("platform", str2);
        }
        UserBehaviorLog.onKVEvent(getContext(), str, hashMap);
    }

    public static void recordIAPTemplateClick(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("material_name", str2);
        hashMap.put("which", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str3);
        UserBehaviorLog.onKVEvent(context, "IAP_Template_Click", hashMap);
    }

    public static void recordIAPTemplatePreview(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("material_name", str2);
        hashMap.put("choose", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str3);
        UserBehaviorLog.onKVEvent(context, "IAP_Template_Preview", hashMap);
    }

    public static void recordIAPThemePreview(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("material_name", str2);
        hashMap.put("choose", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str3);
        UserBehaviorLog.onKVEvent(context, "IAP_Theme_Preview", hashMap);
    }

    public static void recordIpConfig(Context context, boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", z ? "real ip" : "native info");
        hashMap.put("country", str);
        hashMap.put(AccountKitGraphConstants.PARAMETER_LOCALE, Locale.getDefault().toString());
        UserBehaviorLog.onKVEvent(context, "Route_Config_Slide_Result", hashMap);
    }

    public static void recordMonContentScroll(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("direction", str);
        hashMap.put("to end", str2);
        UserBehaviorLog.onKVEvent(context, "Home_Group_Recommend_Scroll", hashMap);
    }

    public static void recordMonExploreLikeClick(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        hashMap.put("videoID", str2);
        UserBehaviorLog.onKVEvent(context, "Explore_Video_Like_Click", hashMap);
    }

    public static void recordMonExploreMoreClick(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("videoID", str2);
        UserBehaviorLog.onKVEvent(context, "Explore_Video_More_Click", hashMap);
    }

    public static void recordMonExploreShareClick(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sns", str);
        UserBehaviorLog.onKVEvent(context, "Explore_Video_Share_Click", hashMap);
    }

    public static void recordMonHOrRScroll(Context context, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("direction", str);
        hashMap.put("to end", str2);
        hashMap.put("module", str3);
        UserBehaviorLog.onKVEvent(context, str4, hashMap);
    }

    public static void recordMonHomeGroupVideoClick(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("videoID", str2);
        UserBehaviorLog.onKVEvent(context, str, hashMap);
    }

    public static void recordMonHomeSingleVideoClick(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("videoID", str2);
        hashMap.put("type", str);
        UserBehaviorLog.onKVEvent(context, "Home_Single_Video_Click", hashMap);
    }

    public static void recordPrjSave(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str);
        UserBehaviorLog.onKVEvent(context, "VE_Draft_Save", hashMap);
    }

    public static void recordRouteConfigEvent(Context context, boolean z, long j) {
        String str;
        if (C4599k.m11735dN(context)) {
            if (C4599k.m11736dO(context)) {
                str = "Route_Config_Time_Wifi";
            } else {
                int dM = C4599k.m11734dM(context);
                str = dM == 1 ? "Route_Config_Time_2G" : dM == 2 ? "Route_Config_Time_Mobile_3G" : "Route_Config_Time_Mobile_4G";
            }
            String str2 = j < 300 ? "<300" : j < 500 ? "300-500" : j < 700 ? "500-700" : j < 1000 ? "700-1000" : j < 1200 ? "1000-1200" : j < 1400 ? "1200-1400" : j < 1600 ? "1400-1600" : j < 1800 ? "1600-1800" : j < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS ? "1800-2000" : j < 3000 ? "2000-3000" : j < 4000 ? "3000-4000" : j < DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS ? "4000-5000" : j < 6000 ? "5000-6000" : j < 7000 ? "6000-7000" : j < 8000 ? "7000-8000" : j < 9000 ? "8000-9000" : j < 10000 ? "9000-10000" : j < 15000 ? "10000-15000" : j < 20000 ? "15000-20000" : ">20000";
            HashMap hashMap = new HashMap();
            if (z) {
                hashMap.put("duration", str2);
                hashMap.put("result", "success");
            } else {
                hashMap.put("result", ParametersKeys.FAILED);
            }
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("strEvent=");
            sb.append(str);
            sb.append("$$$duration=");
            sb.append(j);
            LogUtils.m14222e(str3, sb.toString());
            UserBehaviorLog.onKVEvent(context, str, hashMap);
        }
    }

    public static void recordShareTool(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("tool", str);
            UserBehaviorLog.onKVEvent(context, str2, hashMap);
        } catch (Exception unused) {
        }
    }

    public static void recordSubscribePushClick(Context context, int i, int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        hashMap.put("paymentState", String.valueOf(i2));
        hashMap.put("intent", str);
        UserBehaviorLog.onKVEvent(context, "Subscription_GP_Notification_Click", hashMap);
    }

    public static void recordTemplateExposureRate(Context context, String str, String str2, int i, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str2);
        hashMap.put("order", String.valueOf(i));
        hashMap.put("ttid", str3);
        UserBehaviorLog.onKVEvent(context, str, hashMap);
    }

    public static void recordUserLoginEvent(Context context, boolean z, String str, String str2, String str3) {
        String str4 = z ? "Login_Domestic" : "Login_Inter";
        HashMap hashMap = new HashMap();
        hashMap.put(SocialConstDef.TBL_NAME_SNS, str);
        hashMap.put("position", str2);
        hashMap.put("snsid", str3);
        if (str3.equals("28")) {
            hashMap.put("isFBInstall", C4580b.m11631B(VivaBaseApplication.m8749FZ(), "com.eiii.katana") ? "yes" : "no");
        }
        UserBehaviorLog.onKVEvent(context, str4, hashMap);
    }

    public static void recordUserLoginOpEvent(Context context, int i, String str) {
        String str2 = "";
        switch (i) {
            case 0:
                str2 = "Login_Position_Share";
                break;
            case 1:
                str2 = "Login_Position_Me";
                break;
            case 2:
                str2 = "Login_Position_Publish";
                break;
            case 3:
                str2 = "Login_Position_Followed";
                break;
        }
        if (!TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("choose", str);
            UserBehaviorLog.onKVEvent(context, str2, hashMap);
        }
    }

    public static void recordUserLoginPosition(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("position", str);
        UserBehaviorLog.onKVEvent(context, "Login_Position", hashMap);
    }

    public static void recordXYTPackEvent(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("name", str2);
        UserBehaviorLog.onKVEvent(context, "Template_Downloadpack", hashMap);
    }
}
