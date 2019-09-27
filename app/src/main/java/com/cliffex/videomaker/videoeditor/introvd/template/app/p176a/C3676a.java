package com.introvd.template.app.p176a;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.a.a */
public class C3676a {
    private static final String TAG = "a";

    /* renamed from: bU */
    public static void m8967bU(Context context) {
        UserBehaviorLog.onKVEvent(context, "Pageview_Homepage_Draft_NewTips", new HashMap());
    }

    /* renamed from: d */
    public static void m8968d(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str2);
        hashMap.put("type", str);
        UserBehaviorLog.onKVEvent(context, "Pageview_CreatePage_Module", hashMap);
    }
}
