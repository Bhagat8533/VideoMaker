package com.introvd.template.app.creation;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.creation.b */
public class C3818b {
    /* renamed from: L */
    public static void m9354L(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "Home_New_Click_Without_Draft", hashMap);
    }

    /* renamed from: M */
    public static void m9355M(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "Home_New_Click_With_Draft", hashMap);
    }

    /* renamed from: N */
    public static void m9356N(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "Home_New_More_Function_Click", hashMap);
    }
}
