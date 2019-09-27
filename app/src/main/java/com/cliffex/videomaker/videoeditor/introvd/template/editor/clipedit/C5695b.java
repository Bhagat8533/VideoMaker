package com.introvd.template.editor.clipedit;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.clipedit.b */
public class C5695b {
    /* renamed from: aK */
    public static void m15714aK(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_Adjust", hashMap);
    }

    /* renamed from: aL */
    public static void m15715aL(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_CopyClip", hashMap);
    }

    /* renamed from: aM */
    public static void m15716aM(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_Mute", hashMap);
    }

    /* renamed from: aN */
    public static void m15717aN(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", str);
        UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_Reverse", hashMap);
    }

    /* renamed from: ew */
    public static void m15718ew(Context context) {
        UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_Rotate", new HashMap());
    }

    /* renamed from: n */
    public static void m15719n(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("distance", str);
        hashMap.put("how", str2);
        UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_MoveClip", hashMap);
    }

    /* renamed from: o */
    public static void m15720o(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("speed", str);
        hashMap.put("tone_changed", str2);
        UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_Speed", hashMap);
    }
}
