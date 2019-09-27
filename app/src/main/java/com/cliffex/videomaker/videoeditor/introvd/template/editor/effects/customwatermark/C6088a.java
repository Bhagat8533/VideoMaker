package com.introvd.template.editor.effects.customwatermark;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.effects.customwatermark.a */
public class C6088a {
    /* renamed from: bi */
    public static void m17348bi(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("direction", str);
            UserBehaviorLog.onKVEvent(context, "VE_Watermark_Customise_Move_Refine", hashMap);
        }
    }

    /* renamed from: bj */
    public static void m17349bj(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("position", str);
            UserBehaviorLog.onKVEvent(context, "VE_Watermark_Customise_Positionning", hashMap);
        }
    }

    /* renamed from: eK */
    public static void m17350eK(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Watermark_Customise_Add", new HashMap());
        }
    }

    /* renamed from: eL */
    public static void m17351eL(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Watermark_Customise_Size", new HashMap());
        }
    }

    /* renamed from: eM */
    public static void m17352eM(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Watermark_Customise_Alpha", new HashMap());
        }
    }

    /* renamed from: eN */
    public static void m17353eN(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Watermark_Customise_Move", new HashMap());
        }
    }

    /* renamed from: eO */
    public static void m17354eO(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Watermark_Customise_Replace", new HashMap());
        }
    }
}
