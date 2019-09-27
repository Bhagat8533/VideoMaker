package com.introvd.template.editor.preview.theme;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.preview.theme.c */
public class C6664c {
    /* renamed from: J */
    public static void m19362J(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("BGM", z ? "trun on" : "turn off");
        UserBehaviorLog.onKVEvent(context, "Preview_Adjust_Volume", hashMap);
    }

    /* renamed from: K */
    public static void m19363K(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_sound", z ? "trun on" : "turn off");
        UserBehaviorLog.onKVEvent(context, "Preview_Adjust_Volume", hashMap);
    }

    /* renamed from: L */
    public static void m19364L(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("adjust", z ? TtmlNode.LEFT : TtmlNode.RIGHT);
        UserBehaviorLog.onKVEvent(context, "Preview_BGM_Adjust", hashMap);
    }

    /* renamed from: a */
    public static void m19365a(Context context, String str, String str2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("ttid", str2);
        hashMap.put("order", String.valueOf(i));
        UserBehaviorLog.onKVEvent(context, "VE_Theme_Show", hashMap);
    }

    /* renamed from: aa */
    public static void m19366aa(Context context, int i) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("-");
        sb.append(10 - i);
        hashMap.put("adjust_value", sb.toString());
        UserBehaviorLog.onKVEvent(context, "Preview_Adjust_Volume", hashMap);
    }

    /* renamed from: ab */
    public static void m19367ab(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialConstDef.SEARCH_HISTORY_COUNT, String.valueOf(i));
        UserBehaviorLog.onKVEvent(context, "Preview_Theme_All_Downloaded_Count", hashMap);
    }

    /* renamed from: bG */
    public static void m19368bG(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", str);
        UserBehaviorLog.onKVEvent(context, "Preview_SetMV_Duration", hashMap);
    }

    /* renamed from: fi */
    public static void m19369fi(Context context) {
        UserBehaviorLog.onKVEvent(context, "Preview_SetThemeTitle_Modify", new HashMap());
    }

    /* renamed from: fj */
    public static void m19370fj(Context context) {
        UserBehaviorLog.onKVEvent(context, "Preview_Reset_Music", new HashMap());
    }

    /* renamed from: fk */
    public static void m19371fk(Context context) {
        UserBehaviorLog.onKVEvent(context, "Preview_Delete_Music", new HashMap());
    }

    /* renamed from: g */
    public static void m19372g(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("theme", str);
        hashMap.put("ttid", str2);
        UserBehaviorLog.onKVEvent(context, str3, hashMap);
    }

    /* renamed from: h */
    public static void m19373h(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("theme", str);
        hashMap.put("type", str2);
        hashMap.put("status", str3);
        UserBehaviorLog.onKVEvent(context, "Preview_SetTheme_Click", hashMap);
    }
}
