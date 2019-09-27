package com.introvd.template.editor.effects.collage;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.template.p408f.C8750d;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.effects.collage.b */
public class C6073b {
    /* renamed from: C */
    static void m17301C(Context context, boolean z) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", z ? TtmlNode.LEFT : TtmlNode.RIGHT);
            UserBehaviorLog.onKVEvent(context, "VE_PIP_Adjust", hashMap);
        }
    }

    /* renamed from: D */
    static void m17302D(Context context, boolean z) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", z ? TtmlNode.LEFT : TtmlNode.RIGHT);
            UserBehaviorLog.onKVEvent(context, "VE_PIP_Finetune", hashMap);
        }
    }

    /* renamed from: a */
    public static void m17303a(Context context, C8441b bVar) {
        if (bVar != null && context != null) {
            String str = "pic";
            if (C8750d.m25573jM(bVar.aIf())) {
                str = "gif";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", str);
            UserBehaviorLog.onKVEvent(context, "VE_PIP_Add", hashMap);
        }
    }

    /* renamed from: eI */
    public static void m17304eI(Context context) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("enter", "enter");
            UserBehaviorLog.onKVEvent(context, "VE_PIP_Enter_Otheralbum", hashMap);
        }
    }

    /* renamed from: eJ */
    public static void m17305eJ(Context context) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Event.SEARCH, Event.SEARCH);
            UserBehaviorLog.onKVEvent(context, "VE_PIP_Gif_Search", hashMap);
        }
    }
}
