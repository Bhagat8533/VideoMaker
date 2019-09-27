package com.introvd.template.editor.clipedit.trim;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.clipedit.trim.d */
public class C5835d {
    /* renamed from: aP */
    static void m16318aP(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_Trim", hashMap);
        }
    }

    /* renamed from: aQ */
    static void m16319aQ(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_TrimTunning", hashMap);
        }
    }

    /* renamed from: aR */
    static void m16320aR(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "VE_ClipEdit_Cut", hashMap);
        }
    }
}
