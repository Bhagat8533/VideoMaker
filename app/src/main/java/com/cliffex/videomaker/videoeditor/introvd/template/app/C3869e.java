package com.introvd.template.app;

import android.content.ContentResolver;
import android.content.Context;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.router.community.ICommunityAPI;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.e */
public class C3869e {
    private static final String[] bhW = {SocialConstDef.TBL_NAME_BANNER_PAGE, SocialConstDef.TBL_NAME_DYNAMIC_FEATURE, SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO, SocialConstDef.TBL_NAME_SPLASH, SocialConstDef.TBL_NAME_FOLLOWED_VIDEO, SocialConstDef.TBL_NAME_USERVIDEOS, SocialConstDef.TBL_NAME_VIDEO_SHOW, SocialConstDef.TBL_NAME_CUSTOMIZED_USER, SocialConstDef.TBL_NAME_MESSAGE_LIST_NEW, SocialConstDef.TBL_NAME_MIXED_PAGE, SocialConstDef.TBL_NAME_RECOMMEND_USER_LIST, SocialConstDef.TBL_NAME_ACTIVITY_HOTEVENT, SocialConstDef.TBL_NAME_ACTIVITY_VIDEOLIST, SocialConstDef.TBL_NAME_ACTIVITY_LIST};

    /* renamed from: Hj */
    public static boolean m9526Hj() {
        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_key_app_init_data_crash_count", 0);
        AppPreferencesSetting.getInstance().setAppSettingInt("pref_key_app_init_data_crash_count", appSettingInt + 1);
        StringBuilder sb = new StringBuilder();
        sb.append("checkAppInitDataNeedClear crashCount : ");
        sb.append(appSettingInt);
        LogUtilsV2.m14230i(sb.toString());
        return appSettingInt >= 3;
    }

    /* renamed from: Hk */
    public static void m9527Hk() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10152c(C1820a.aVi()).mo10164f(5, TimeUnit.SECONDS).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                LogUtilsV2.m14230i("check app init data : valid ");
                AppPreferencesSetting.getInstance().setAppSettingInt("pref_key_app_init_data_crash_count", 0);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: by */
    public static void m9528by(Context context) {
        LogUtilsV2.m14230i("clearAppInitData");
        ContentResolver contentResolver = context.getContentResolver();
        for (String tableUri : bhW) {
            contentResolver.delete(SocialConstDef.getTableUri(tableUri), null, null);
        }
        ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
        if (iCommunityAPI != null) {
            iCommunityAPI.clearMyVideoListCache();
        }
        C3935b.m9679Lb().mo23485ci(context);
        HashMap hashMap = new HashMap();
        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_key_app_init_data_crash_count", 0);
        StringBuilder sb = new StringBuilder();
        sb.append(appSettingInt);
        sb.append("");
        hashMap.put("crashCount", sb.toString());
        UserBehaviorLog.onAliEvent("Dev_Clear_Data_By_Crash", hashMap);
    }
}
