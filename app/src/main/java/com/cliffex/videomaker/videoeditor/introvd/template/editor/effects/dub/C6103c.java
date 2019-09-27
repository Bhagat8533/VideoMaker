package com.introvd.template.editor.effects.dub;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.effects.dub.c */
class C6103c {
    /* renamed from: E */
    public static void m17400E(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", z ? TtmlNode.TAG_HEAD : TtmlNode.END);
        UserBehaviorLog.onKVEvent(context, "VE_Dubbing_Finetune", hashMap);
    }

    /* renamed from: F */
    public static void m17401F(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", z ? TtmlNode.TAG_HEAD : TtmlNode.END);
        UserBehaviorLog.onKVEvent(context, "VE_Dubbing_Adjust", hashMap);
    }

    /* renamed from: bk */
    public static void m17402bk(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "VE_Dubbing_Addsound", hashMap);
    }

    /* renamed from: eP */
    public static void m17403eP(Context context) {
        UserBehaviorLog.onKVEvent(context, "VE_Dubbing_Add", new HashMap());
    }

    /* renamed from: eQ */
    public static void m17404eQ(Context context) {
        UserBehaviorLog.onKVEvent(context, "VE_Dubbing_SetVolume", new HashMap());
    }

    /* renamed from: eR */
    public static void m17405eR(Context context) {
        UserBehaviorLog.onKVEvent(context, "VE_Dubbing_Delete", new HashMap());
    }
}
