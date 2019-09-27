package com.introvd.template.editor.preview;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.preview.a */
public class C6521a {
    /* renamed from: I */
    public static void m18902I(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", z ? "select_all" : "unselect_all");
        UserBehaviorLog.onKVEvent(context, "VE_Mutiple_Mode_Select_All", hashMap);
    }

    /* renamed from: bB */
    public static void m18903bB(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("tab_name", str);
        UserBehaviorLog.onKVEvent(context, "Preview_Default_Tab_Focus", hashMap);
    }

    /* renamed from: bC */
    public static void m18904bC(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("tab_name", str);
        UserBehaviorLog.onKVEvent(context, "Preview_Tab_Click_4tabs", hashMap);
    }

    /* renamed from: bD */
    public static void m18905bD(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("how", str);
        UserBehaviorLog.onKVEvent(context, "Preview_Choose_material", hashMap);
    }

    /* renamed from: bE */
    public static void m18906bE(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("how", str);
        UserBehaviorLog.onKVEvent(context, "VE_Mutiple_Mode_Enter", hashMap);
    }

    /* renamed from: bF */
    public static void m18907bF(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_AddClip", hashMap);
    }

    /* renamed from: i */
    public static void m18908i(Context context, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "modify" : "not_modify");
        UserBehaviorLog.onKVEvent(context, str, hashMap);
    }
}
