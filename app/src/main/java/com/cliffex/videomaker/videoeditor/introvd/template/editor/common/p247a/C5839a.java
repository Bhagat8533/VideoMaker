package com.introvd.template.editor.common.p247a;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.sdk.p390f.C8446b;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.editor.common.a.a */
public class C5839a {
    /* renamed from: aS */
    public static void m16325aS(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "VE_Video_Edit_Tools_Click", hashMap);
    }

    /* renamed from: aT */
    public static void m16326aT(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "VE_Video_Effects_Tools_Click", hashMap);
    }

    /* renamed from: aU */
    public static void m16327aU(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("tool", str);
            UserBehaviorLog.onKVEvent(context, "VE_Mutiple_Mode_Tools_Use", hashMap);
        }
    }

    /* renamed from: aV */
    public static void m16328aV(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("tools", str);
            UserBehaviorLog.onKVEvent(context, "VE_Tools_Click", hashMap);
        }
    }

    /* renamed from: aW */
    public static void m16329aW(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("tools", str);
            UserBehaviorLog.onKVEvent(context, "Preview_Simple_Tools_Click", hashMap);
        }
    }

    /* renamed from: eA */
    public static void m16330eA(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "DEV_Event_Clip_Trim_Pos_Invalid", new HashMap());
        }
    }

    /* renamed from: ey */
    public static void m16331ey(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_More_Click_Simple", new HashMap());
        }
    }

    /* renamed from: ez */
    public static void m16332ez(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Share_Btn_Click_Simple", new HashMap());
        }
    }

    /* renamed from: p */
    public static void m16333p(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str);
            hashMap.put("mode", str2);
            UserBehaviorLog.onKVEvent(context, "Preview_Enter", hashMap);
        }
    }

    /* renamed from: q */
    public static void m16334q(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("how", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        UserBehaviorLog.onKVEvent(context, "Preview_Exit", hashMap);
    }

    /* renamed from: r */
    public static void m16335r(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        UserBehaviorLog.onKVEvent(context, "Preview_Exit_Dialog", hashMap);
    }

    /* renamed from: z */
    public static void m16336z(Context context, boolean z) {
        List list = C8446b.aIZ().getList();
        int size = list != null ? list.size() : 0;
        HashMap hashMap = new HashMap();
        if (size < 6) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(size);
            hashMap.put("draft", sb.toString());
        } else if (size < 11) {
            hashMap.put("draft", "6-10");
        } else if (size < 21) {
            hashMap.put("draft", "11-20");
        } else {
            hashMap.put("draft", ">20");
        }
        hashMap.put("mode", z ? "list" : "grid");
        UserBehaviorLog.onKVEvent(context, "Home_Studio", hashMap);
    }
}
