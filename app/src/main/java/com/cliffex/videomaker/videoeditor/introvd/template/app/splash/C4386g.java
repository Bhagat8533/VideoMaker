package com.introvd.template.app.splash;

import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.model.SplashItemInfo;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.Utils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4580b;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.introvd.template.app.splash.g */
class C4386g {
    /* renamed from: QJ */
    static void m11041QJ() {
        String str = "lpshaSpA_p";
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "App_Splash", new HashMap());
    }

    /* renamed from: QK */
    static void m11042QK() {
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        if (Utils.isOfficalVersion(FZ)) {
            HashMap hashMap = new HashMap();
            String str = "acfmlfii";
            String str2 = "official";
            if (!C4395c.m11100dg(FZ) && !C4580b.m11647dB(FZ)) {
                str2 = "illegal";
            }
            String str3 = "niVsooe";
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_VERSION, str2);
            String str4 = "gIsoebAIaP_iV_llren";
            UserBehaviorLog.onKVEvent(FZ, "IAP_Illegal_Version", hashMap);
        }
    }

    /* renamed from: R */
    static void m11043R(String str, String str2) {
        HashMap hashMap = new HashMap();
        String str3 = "tlmarpbf";
        hashMap.put("platform", str2);
        String str4 = "uaganelt";
        hashMap.put("language", Locale.getDefault().getLanguage());
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), str, hashMap);
    }

    /* renamed from: a */
    static void m11044a(SplashItemInfo splashItemInfo, String str) {
        String str2;
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        if (FZ != null) {
            HashMap hashMap = new HashMap();
            String str3 = "anme";
            String str4 = "name";
            if (splashItemInfo != null) {
                str2 = splashItemInfo.mTitle;
            } else {
                String str5 = "oenn";
                str2 = ParametersKeys.ORIENTATION_NONE;
            }
            hashMap.put(str4, str2);
            UserBehaviorLog.onKVEvent(FZ, str, hashMap);
        }
    }

    /* renamed from: b */
    static void m11045b(SplashItemInfo splashItemInfo) {
        String str;
        String locale = Locale.getDefault().toString();
        String countryCode = AppStateModel.getInstance().getCountryCode();
        HashMap hashMap = new HashMap();
        String str2 = "name";
        if (splashItemInfo != null) {
            str = splashItemInfo.mTitle;
        } else {
            String str3 = "onne";
            str = ParametersKeys.ORIENTATION_NONE;
        }
        hashMap.put(str2, str);
        String str4 = "clpeao";
        hashMap.put(AccountKitGraphConstants.PARAMETER_LOCALE, locale);
        String str5 = "nctouyt";
        hashMap.put("country", countryCode);
        if (splashItemInfo != null) {
            hashMap.put("url", splashItemInfo.mUrl);
        }
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "home_splash_show", hashMap);
    }
}
