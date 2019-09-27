package com.introvd.template.picker.p365a;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.picker.a.a */
public class C8172a {
    /* renamed from: ci */
    public static void m23621ci(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "Gallery_Online_login", hashMap);
        }
    }

    /* renamed from: cj */
    public static void m23622cj(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "Gallery_Online_login", hashMap);
        }
    }

    /* renamed from: gF */
    public static void m23623gF(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "Gallery_Other_Album_Back", new HashMap());
        }
    }

    /* renamed from: gG */
    public static void m23624gG(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "Gallery_ScanFile", new HashMap());
        }
    }
}
