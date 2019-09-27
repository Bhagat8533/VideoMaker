package com.introvd.template.editor.effects.mosaic;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.effects.mosaic.a */
public class C6166a {
    /* renamed from: bn */
    public static void m17634bn(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("style", str);
            UserBehaviorLog.onKVEvent(context, "VE_Mosaic_Choose", hashMap);
        }
    }

    /* renamed from: bo */
    public static void m17635bo(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "VE_Mosaic_Level_Adjust", hashMap);
        }
    }

    /* renamed from: bp */
    public static void m17636bp(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("direction", str);
            UserBehaviorLog.onKVEvent(context, "VE_Mosaic_Control_Direction", hashMap);
        }
    }

    /* renamed from: eU */
    public static void m17637eU(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Mosaic_Control_Scale", new HashMap());
        }
    }
}
