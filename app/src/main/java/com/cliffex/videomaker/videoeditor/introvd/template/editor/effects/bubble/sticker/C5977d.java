package com.introvd.template.editor.effects.bubble.sticker;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.effects.bubble.sticker.d */
class C5977d {
    /* renamed from: aX */
    static void m16826aX(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "VE_Sticker_Adjust", hashMap);
        }
    }

    /* renamed from: aY */
    static void m16827aY(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            UserBehaviorLog.onKVEvent(context, "VE_Sticker_Delete", hashMap);
        }
    }

    /* renamed from: aZ */
    static void m16828aZ(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "VE_Sticker_Finetune", hashMap);
        }
    }

    /* renamed from: ba */
    static void m16829ba(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("ttid", str);
            UserBehaviorLog.onKVEvent(context, "VE_Sticker_Show", hashMap);
        }
    }

    /* renamed from: eB */
    static void m16830eB(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Sticker_Replace", new HashMap());
        }
    }

    /* renamed from: eC */
    static void m16831eC(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Sticker_Mirror", new HashMap());
        }
    }

    /* renamed from: eD */
    static void m16832eD(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Sticker_Scale", new HashMap());
        }
    }

    /* renamed from: s */
    static void m16833s(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put("ttid", str2);
            UserBehaviorLog.onKVEvent(context, "VE_Sticker_Add", hashMap);
        }
    }
}
