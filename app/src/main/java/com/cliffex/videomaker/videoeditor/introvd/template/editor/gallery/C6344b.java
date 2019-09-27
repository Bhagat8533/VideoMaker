package com.introvd.template.editor.gallery;

import android.content.Context;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.editor.p244a.C5555c;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.HashMap;
import p504io.fabric.sdk.android.services.settings.AppSettingsData;

/* renamed from: com.introvd.template.editor.gallery.b */
public class C6344b {
    /* renamed from: a */
    public static void m18170a(Context context, int i, int i2, int i3, int i4, boolean z) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("amount", sb.toString());
        hashMap.put("video_amount", i2 > 10 ? ">10" : String.valueOf(i2));
        hashMap.put("pic_amount", i3 > 10 ? ">10" : String.valueOf(i3));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i4);
        sb2.append("");
        hashMap.put("duration", sb2.toString());
        hashMap.put("gallery_version", z ? AppSettingsData.STATUS_NEW : "old");
        UserBehaviorLog.onKVEvent(context, "Gallery_Next", hashMap);
    }

    /* renamed from: a */
    public static void m18171a(Context context, String str, int i, long j, int i2, int i3) {
        if (context != null) {
            try {
                boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false);
                HashMap hashMap = new HashMap();
                hashMap.put("mode", m18180cD(i2, i3));
                hashMap.put(SocialConstDef.PUBLISH_VIDEO_DURATION, C5555c.m15041an((long) i));
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i / 1000);
                hashMap.put("video_duration_detail", sb.toString());
                hashMap.put("time_cost", C5555c.m15041an(j));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(j / 1000);
                hashMap.put("time_cost_detail", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(i2);
                hashMap.put("video_amount", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(i3);
                hashMap.put("pic_amount", sb4.toString());
                hashMap.put("hardware", appSettingBoolean ? "on" : "off");
                UserBehaviorLog.onKVEvent(context, str, hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static void m18172b(Context context, int i, int i2, int i3) {
        if (context != null) {
            try {
                boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false);
                HashMap hashMap = new HashMap();
                hashMap.put("mode", m18180cD(i2, i3));
                hashMap.put(SocialConstDef.PUBLISH_VIDEO_DURATION, C5555c.m15041an((long) i));
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i / 1000);
                hashMap.put("video_duration_detail", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(i2);
                hashMap.put("video_amount", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(i3);
                hashMap.put("pic_amount", sb3.toString());
                hashMap.put("hardware", appSettingBoolean ? "on" : "off");
                UserBehaviorLog.onKVEvent(context, "Gallery_Import_transcode_Start", hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: bA */
    public static void m18173bA(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialConstDef.SEARCH_HISTORY_COUNT, str);
        UserBehaviorLog.onKVEvent(context, "Gallery_Add_Pic_Multiple", hashMap);
    }

    /* renamed from: bu */
    public static void m18174bu(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("trim", str);
            UserBehaviorLog.onKVEvent(context, "Gallery_Video_Trim", hashMap);
        }
    }

    /* renamed from: bv */
    public static void m18175bv(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("trim", str);
            UserBehaviorLog.onKVEvent(context, "Gallery_Video_Trim_Finetune", hashMap);
        }
    }

    /* renamed from: bw */
    public static void m18176bw(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "Gallery_Rotate", hashMap);
        }
    }

    /* renamed from: bx */
    public static void m18177bx(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("resolution", str);
            UserBehaviorLog.onKVEvent(context, "Gallery_Import_Resolution", hashMap);
        }
    }

    /* renamed from: by */
    public static void m18178by(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("time_cost", str);
            UserBehaviorLog.onKVEvent(context, "Gallery_Import_Resolution", hashMap);
        }
    }

    /* renamed from: bz */
    public static void m18179bz(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "Gallery_Intent_Action", hashMap);
        }
    }

    /* renamed from: cD */
    private static String m18180cD(int i, int i2) {
        return (i <= 0 || i2 <= 0) ? i > 0 ? "video" : i2 > 0 ? "pic" : ParametersKeys.ORIENTATION_NONE : "mixed";
    }

    /* renamed from: e */
    public static void m18181e(Context context, boolean z, boolean z2) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "focused" : "unfocused");
            hashMap.put("preview_status", z2 ? "yes" : "no");
            UserBehaviorLog.onKVEvent(context, "Gallery_Clip_Select", hashMap);
        }
    }

    /* renamed from: f */
    public static void m18182f(Context context, boolean z, boolean z2) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "focused" : "unfocused");
            hashMap.put("preview_status", z2 ? "yes" : "no");
            UserBehaviorLog.onKVEvent(context, "Gallery_Clip_Select_MV", hashMap);
        }
    }

    /* renamed from: fa */
    public static void m18183fa(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "Gallery_Switch_Pic_Video", new HashMap());
        }
    }

    /* renamed from: fb */
    public static void m18184fb(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "Gallery_Video_trim_Add", new HashMap());
        }
    }

    /* renamed from: g */
    public static void m18185g(Context context, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        hashMap.put("gallery_version", z ? AppSettingsData.STATUS_NEW : "old");
        UserBehaviorLog.onKVEvent(context, "Gallery_Exit", hashMap);
    }

    /* renamed from: g */
    public static void m18186g(Context context, boolean z, boolean z2) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "focused" : "unfocused");
            hashMap.put("preview_status", z2 ? "yes" : "no");
            UserBehaviorLog.onKVEvent(context, "Gallery_Clip_Select_Edit", hashMap);
        }
    }

    /* renamed from: h */
    public static void m18187h(Context context, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("how", str);
        hashMap.put("gallery_version", z ? AppSettingsData.STATUS_NEW : "old");
        UserBehaviorLog.onKVEvent(context, "Gallery_Enter", hashMap);
    }
}
