package com.introvd.template.editor.slideshow.p278a;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import java.util.HashMap;
import p504io.fabric.sdk.android.services.settings.AppSettingsData;

/* renamed from: com.introvd.template.editor.slideshow.a.a */
public class C6738a {
    /* renamed from: A */
    public static void m19555A(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("create", str);
        hashMap.put("ttid", str2);
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Demo_Create", hashMap);
    }

    /* renamed from: M */
    public static void m19556M(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("modify", z ? "yes" : "no");
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Modify_Music_Result", hashMap);
    }

    /* renamed from: bJ */
    public static void m19557bJ(Context context, String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("category", str);
        }
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Category_Click", hashMap);
    }

    /* renamed from: bK */
    public static void m19558bK(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Template_Center_Click", hashMap);
    }

    /* renamed from: bL */
    public static void m19559bL(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialConstDef.TEMPLATE_ID, str);
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Demo_Dialog_Show", hashMap);
    }

    /* renamed from: bM */
    public static void m19560bM(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("choose", str);
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Demo_Dialog_Click", hashMap);
    }

    /* renamed from: c */
    public static void m19561c(Context context, boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? AppSettingsData.STATUS_NEW : "replace");
        hashMap.put("ttid", str);
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Add_Pic", hashMap);
    }

    /* renamed from: d */
    public static void m19562d(Context context, boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? AppSettingsData.STATUS_NEW : "replace");
        hashMap.put("ttid", str);
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Modifly_Text", hashMap);
    }

    /* renamed from: e */
    public static void m19563e(Context context, boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "Pic_added" : "Pic_not_added");
        hashMap.put("ttid", str);
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Preview_Play", hashMap);
    }

    /* renamed from: fn */
    public static void m19564fn(Context context) {
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Modify_Music_Click", new HashMap());
    }

    /* renamed from: fo */
    public static void m19565fo(Context context) {
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Music_Used_Delete", new HashMap());
    }

    /* renamed from: fp */
    public static void m19566fp(Context context) {
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Music_Reset", new HashMap());
    }

    /* renamed from: y */
    public static void m19567y(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("create", str);
        hashMap.put("ttid", str2);
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Template_Create", hashMap);
    }

    /* renamed from: z */
    public static void m19568z(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", str);
        hashMap.put("ttid", str2);
        UserBehaviorLog.onKVEvent(context, "Creative_Video_Template_Download", hashMap);
    }
}
