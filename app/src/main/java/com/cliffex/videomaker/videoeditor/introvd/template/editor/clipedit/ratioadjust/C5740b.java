package com.introvd.template.editor.clipedit.ratioadjust;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.clipedit.ratioadjust.b */
public class C5740b {
    /* renamed from: aO */
    public static void m15958aO(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("action", str);
            UserBehaviorLog.onKVEvent(context, "VE_Video_Size_Modify", hashMap);
        }
    }

    /* renamed from: c */
    public static void m15959c(Context context, String str, String str2, boolean z) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("video_size", str);
            hashMap.put("BG", str2);
            hashMap.put("apply_all", z ? "yes" : "not");
            UserBehaviorLog.onKVEvent(context, "VE_Video_Size_Modify_Ok", hashMap);
        }
    }

    /* renamed from: y */
    public static void m15960y(Context context, boolean z) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? ParametersKeys.AVAILABLE : "unavailable");
            UserBehaviorLog.onKVEvent(context, "VE_Video_Size_BG", hashMap);
        }
    }
}
