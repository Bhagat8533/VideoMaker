package com.introvd.template.app.school.p197c;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.school.c.a */
public class C4173a {
    /* renamed from: S */
    public static void m10393S(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("TabName", str);
        UserBehaviorLog.onKVEvent(context, "Click_Module_Tab", hashMap);
    }

    /* renamed from: T */
    public static void m10394T(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("tab", str);
        UserBehaviorLog.onKVEvent(context, "School_Module_Tab_Click", hashMap);
    }
}
