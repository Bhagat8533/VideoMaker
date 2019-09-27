package com.introvd.template.camera.p232e;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.C4681i;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.sdk.p381b.p382a.C8386b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p409g.C8762d;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.ironsource.sdk.controller.BannerJSAdapter;
import java.util.HashMap;
import lib.C12177i;

/* renamed from: com.introvd.template.camera.e.c */
public class C5031c {
    /* renamed from: Q */
    public static void m13206Q(Context context, int i) {
        HashMap hashMap = new HashMap();
        if (i == 1) {
            hashMap.put("how", "tap");
        } else if (i == 0) {
            hashMap.put("how", "slide");
        }
        UserBehaviorLog.onKVEvent(context, "Cam_Mode_Switch", hashMap);
    }

    /* renamed from: a */
    public static void m13207a(Context context, int i, int i2, int i3, MSize mSize, String str, float f, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("duration", m13218an((long) i2));
            if (CameraCodeMgr.isCameraParamFB(i3)) {
                hashMap.put("mode", "selfie");
            } else if (CameraCodeMgr.isCameraParamMV(i3)) {
                hashMap.put("mode", "music");
            } else {
                hashMap.put("mode", "normal");
            }
            if (mSize != null) {
                hashMap.put("resulation", UserBehaviorUtils.getResolutionStr(mSize.width, mSize.height));
            }
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("key_pref_last_camera_ratio", 2);
            if (appSettingInt == 2) {
                hashMap.put("ratio", "full");
            } else if (appSettingInt == 1) {
                hashMap.put("ratio", "4:3");
            } else {
                hashMap.put("ratio", "1:1");
            }
            hashMap.put("orientation", i == 256 ? ParametersKeys.ORIENTATION_PORTRAIT : ParametersKeys.ORIENTATION_LANDSCAPE);
            if (AppPreferencesSetting.getInstance().getAppSettingInt("pref_view_camera_id", 0) == 1) {
                hashMap.put("front_back", "front");
            } else {
                hashMap.put("front_back", "back");
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("filter", str);
            } else {
                hashMap.put("filter", ParametersKeys.ORIENTATION_NONE);
            }
            if (SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "no_aelock"))) {
                hashMap.put("exposure", "yes");
            } else {
                hashMap.put("exposure", "no");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(f);
            hashMap.put("speed", sb.toString());
            hashMap.put("music_title", str2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("ttid", str3);
            }
            UserBehaviorLog.onKVEvent(context, "Cam_Done", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m13208a(Context context, MSize mSize) {
        HashMap hashMap = new HashMap();
        hashMap.put("resolution", mSize.toString());
        UserBehaviorLog.onKVEvent(context, "Cam_Record_Resolution", hashMap);
    }

    /* renamed from: a */
    public static void m13209a(Context context, MSize mSize, int i, int i2, float f, long j) {
        try {
            HashMap hashMap = new HashMap();
            if (CameraCodeMgr.isCameraParamFB(i)) {
                hashMap.put("mode", "selfie");
            } else if (CameraCodeMgr.isCameraParamMV(i)) {
                hashMap.put("mode", "music");
            } else {
                hashMap.put("mode", "normal");
            }
            if (mSize != null) {
                hashMap.put("resulation", UserBehaviorUtils.getResolutionStr(mSize.width, mSize.height));
            }
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("key_pref_last_camera_ratio", 2);
            if (appSettingInt == 2) {
                hashMap.put("ratio", "full");
            } else if (appSettingInt == 1) {
                hashMap.put("ratio", "4:3");
            } else {
                hashMap.put("ratio", "1:1");
            }
            if (i2 == 512) {
                hashMap.put("orientation", ParametersKeys.ORIENTATION_LANDSCAPE);
            } else {
                hashMap.put("orientation", ParametersKeys.ORIENTATION_PORTRAIT);
            }
            if (AppPreferencesSetting.getInstance().getAppSettingInt("pref_view_camera_id", 0) == 1) {
                hashMap.put("front_back", "front");
            } else {
                hashMap.put("front_back", "back");
            }
            String l = C8762d.aMt().mo35241l(j, 4);
            if (!TextUtils.isEmpty(l)) {
                hashMap.put("filter", l);
            } else {
                hashMap.put("filter", ParametersKeys.ORIENTATION_NONE);
            }
            if (SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "no_aelock"))) {
                hashMap.put("exposure", "yes");
            } else {
                hashMap.put("exposure", "no");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(f);
            hashMap.put("speed", sb.toString());
            UserBehaviorLog.onKVEvent(context, "Cam_Start", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m13210a(Context context, Long l, int i) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(l);
        sb.append("");
        hashMap.put("name", sb.toString());
        if (i == -1) {
            hashMap.put("result", "success");
        } else if (i == -2) {
            hashMap.put("result", BannerJSAdapter.FAIL);
        }
        UserBehaviorLog.onKVEvent(context, "Cam_Filter_Download", hashMap);
    }

    /* renamed from: a */
    public static void m13211a(Context context, boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Type", z ? "On" : "Off");
        hashMap.put("mode", str);
        UserBehaviorLog.onKVEvent(context, "Cam_Setting_Grid", hashMap);
    }

    /* renamed from: ah */
    public static void m13212ah(Context context, String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("Type", str);
        }
        UserBehaviorLog.onKVEvent(context, "Click_CameraPackage_Beautify", hashMap);
    }

    /* renamed from: ai */
    public static void m13213ai(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("mode", str);
        UserBehaviorLog.onKVEvent(context, "Cam_Swap", hashMap);
    }

    /* renamed from: aj */
    public static void m13214aj(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("mode", str);
        UserBehaviorLog.onKVEvent(context, "Cam_Setting", hashMap);
    }

    /* renamed from: ak */
    public static void m13215ak(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        UserBehaviorLog.onKVEvent(context, "Cam_Facial_Effect_Show", hashMap);
    }

    /* renamed from: al */
    public static void m13216al(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        UserBehaviorLog.onKVEvent(context, "Cam_Record_New", hashMap);
    }

    /* renamed from: am */
    public static void m13217am(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("how", str);
        UserBehaviorLog.onKVEvent(context, "Cam_Menu_Down", hashMap);
    }

    /* renamed from: an */
    private static String m13218an(long j) {
        return j <= 10000 ? "<10s" : j <= 30000 ? "10s-30s" : j <= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS ? "30s-1m" : j <= 120000 ? "1m-2m" : j <= 180000 ? "2m-3m" : j <= 240000 ? "3m-4m" : j <= 300000 ? "4m-5m" : j <= 360000 ? "5m-6m" : j <= 420000 ? "6m-7m" : j <= 480000 ? "7m-8m" : j <= 540000 ? "8m-9m" : j <= C12177i.f6154j ? "9m-10m" : ">10m";
    }

    /* renamed from: an */
    public static void m13219an(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("filter", str);
        UserBehaviorLog.onKVEvent(context, "Cam_Normal_filter", hashMap);
    }

    /* renamed from: ao */
    public static void m13220ao(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("filter", str);
        UserBehaviorLog.onKVEvent(context, "Cam_Selfie_filter", hashMap);
    }

    /* renamed from: ap */
    public static void m13221ap(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("mode", str);
        UserBehaviorLog.onKVEvent(context, "Cam_Enter", hashMap);
        C4681i.m12184Gp().mo25016Gr().recordEvtOnAppflyer(context, "Cam_Enter");
    }

    /* renamed from: b */
    public static void m13222b(Context context, int i, long j) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(C5008i.m12937VU().mo25623Wj());
            sb.append("");
            hashMap.put("smoother_level", sb.toString());
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("key_pref_last_camera_ratio", 0);
            if (appSettingInt == 2) {
                hashMap.put("ratio", "full");
            } else if (appSettingInt == 1) {
                hashMap.put("ratio", "4:3");
            } else {
                hashMap.put("ratio", "1:1");
            }
            hashMap.put("orientation", i == 512 ? ParametersKeys.ORIENTATION_LANDSCAPE : ParametersKeys.ORIENTATION_PORTRAIT);
            hashMap.put("front_back", AppPreferencesSetting.getInstance().getAppSettingInt("pref_view_camera_id", 0) == 1 ? "front" : "back");
            String l = C8762d.aMt().mo35241l(j, 4);
            if (!TextUtils.isEmpty(l)) {
                hashMap.put("filter", l);
            } else {
                hashMap.put("filter", ParametersKeys.ORIENTATION_NONE);
            }
            if (SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "no_aelock"))) {
                hashMap.put("exposure", "yes");
            } else {
                hashMap.put("exposure", "no");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(j);
            hashMap.put("facial_effect_name", sb2.toString());
            if (!FileUtils.isFileExisted(C8386b.aHs())) {
                hashMap.put("fece data", "not ready");
            } else {
                hashMap.put("fece data", ParametersKeys.READY);
            }
            UserBehaviorLog.onKVEvent(context, "Cam_Selfie_start", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m13223b(Context context, Long l, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", C8450a.m24469bn(l.longValue()));
        hashMap.put("name", C8762d.aMt().mo35241l(l.longValue(), 4));
        if (i == -1) {
            hashMap.put("result", "success");
        } else if (i == -2) {
            hashMap.put("result", BannerJSAdapter.FAIL);
        }
        UserBehaviorLog.onKVEvent(context, "Cam_facial_Effect_Download", hashMap);
    }

    /* renamed from: dR */
    public static void m13224dR(Context context) {
        try {
            HashMap hashMap = new HashMap();
            if (FileUtils.isFileExisted(C8386b.aHs())) {
                hashMap.put("fece_data", "not ready");
            } else {
                hashMap.put("fece_data", ParametersKeys.READY);
            }
            UserBehaviorLog.onKVEvent(context, "Cam_Selfie_Enter", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: dS */
    public static void m13225dS(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "camera_filter");
        UserBehaviorLog.onKVEvent(context, "Template_Enter_New_Version", hashMap);
    }

    /* renamed from: i */
    public static void m13226i(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("mode", str);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        hashMap.put("value", sb.toString());
        UserBehaviorLog.onKVEvent(context, "Cam_Timer", hashMap);
    }

    /* renamed from: m */
    public static void m13227m(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("condition", z ? "yes" : "no");
        UserBehaviorLog.onKVEvent(context, "Click_CameraPackage_Sticker", hashMap);
    }

    /* renamed from: n */
    public static void m13228n(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("condition", z ? "yes" : "no");
        UserBehaviorLog.onKVEvent(context, "Click_CameraPackage_Music", hashMap);
    }

    /* renamed from: o */
    public static void m13229o(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("redo", "redo");
        } else {
            hashMap.put("single_click", "click");
        }
        UserBehaviorLog.onKVEvent(context, "Cam_Undo_Clip", hashMap);
    }

    /* renamed from: p */
    public static void m13230p(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("how", "swipe screen");
        } else {
            hashMap.put("how", "tap thumb");
        }
        UserBehaviorLog.onKVEvent(context, "Cam_Filter_Change", hashMap);
    }

    /* renamed from: q */
    public static void m13231q(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("orientation_tip_show", z ? "in portrait" : "in landscape");
        UserBehaviorLog.onKVEvent(context, "Cam_Start_Orientation_Change", hashMap);
    }

    /* renamed from: r */
    public static void m13232r(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("how", z ? "back button" : "tap screen");
        UserBehaviorLog.onKVEvent(context, "Cam_Filter_Down", hashMap);
    }
}
