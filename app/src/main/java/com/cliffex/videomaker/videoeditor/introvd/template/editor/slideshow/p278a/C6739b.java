package com.introvd.template.editor.slideshow.p278a;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import java.util.HashMap;
import p503cz.msebera.android.httpclient.HttpHeaders;

/* renamed from: com.introvd.template.editor.slideshow.a.b */
public class C6739b {
    /* renamed from: B */
    public static void m19569B(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        UserBehaviorLog.onKVEvent(context, "School_Module_Gallery_Publish_Click", hashMap);
    }

    /* renamed from: C */
    public static void m19570C(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        UserBehaviorLog.onKVEvent(context, "School_Module_Gallery_Enter", hashMap);
    }

    /* renamed from: N */
    public static void m19571N(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", z ? "modified" : "not modified");
        UserBehaviorLog.onKVEvent(context, "School_Module_Gallery_ClipSort", hashMap);
    }

    /* renamed from: a */
    public static void m19572a(Context context, String str, String str2, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        hashMap.put("number", String.valueOf(i));
        hashMap.put("total_number", String.valueOf(i2));
        UserBehaviorLog.onKVEvent(context, "School_Module_Clip_Add", hashMap);
    }

    /* renamed from: b */
    public static void m19573b(Context context, String str, String str2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        hashMap.put("photo_number", String.valueOf(i));
        UserBehaviorLog.onKVEvent(context, "School_Module_Picture_Add", hashMap);
    }

    /* renamed from: bN */
    public static void m19574bN(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        UserBehaviorLog.onKVEvent(context, "slide_added_file_type", hashMap);
    }

    /* renamed from: bO */
    public static void m19575bO(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Name", str);
        UserBehaviorLog.onKVEvent(context, "slide_draft_click", hashMap);
    }

    /* renamed from: f */
    public static void m19576f(Context context, boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Status", z ? "Complete" : "Incomplete");
        hashMap.put(SocialConstDef.TEMPLATE_CARD_SUBTCID, str);
        UserBehaviorLog.onKVEvent(context, "slide_publish_click", hashMap);
    }

    /* renamed from: fq */
    public static void m19577fq(Context context) {
        UserBehaviorLog.onKVEvent(context, "slide_title_edit_show", new HashMap());
    }

    /* renamed from: fr */
    public static void m19578fr(Context context) {
        UserBehaviorLog.onKVEvent(context, "slide_title_edit_click", new HashMap());
    }

    /* renamed from: fs */
    public static void m19579fs(Context context) {
        UserBehaviorLog.onKVEvent(context, "slide_title_edit_done", new HashMap());
    }

    /* renamed from: i */
    public static void m19580i(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("Name", str);
        hashMap.put(SocialConstDef.TEMPLATE_CARD_SUBTCID, str2);
        hashMap.put(HttpHeaders.FROM, str3);
        UserBehaviorLog.onKVEvent(context, "Slide_Preview_Enter", hashMap);
    }

    /* renamed from: j */
    public static void m19581j(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        hashMap.put("save_postion", str3);
        UserBehaviorLog.onKVEvent(context, "School_Module_SaveDraft", hashMap);
    }
}
