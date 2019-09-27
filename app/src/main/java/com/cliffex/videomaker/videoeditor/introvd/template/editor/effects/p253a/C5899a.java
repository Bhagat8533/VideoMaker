package com.introvd.template.editor.effects.p253a;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.effects.a.a */
public class C5899a {
    /* renamed from: bl */
    public static void m16542bl(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("template", str);
            UserBehaviorLog.onKVEvent(context, "Keyframe_Delete", hashMap);
        }
    }

    /* renamed from: bm */
    public static void m16543bm(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("template", str);
            UserBehaviorLog.onKVEvent(context, "Keyframe_Focus", hashMap);
        }
    }

    /* renamed from: v */
    public static void m16544v(Context context, String str, String str2) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("template", str);
            hashMap.put("how", str2);
            UserBehaviorLog.onKVEvent(context, "Keyframe_Add", hashMap);
        }
    }
}
