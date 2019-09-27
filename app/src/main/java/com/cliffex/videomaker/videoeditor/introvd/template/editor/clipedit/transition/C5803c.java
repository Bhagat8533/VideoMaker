package com.introvd.template.editor.clipedit.transition;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.sdk.p391g.C8450a;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.clipedit.transition.c */
public class C5803c {
    /* renamed from: a */
    public static void m16155a(Context context, long j, String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("how", str);
        }
        if (j > 0) {
            hashMap.put("ttid", C8450a.m24469bn(j));
        }
        UserBehaviorLog.onKVEvent(context, "VE_Transition_Set", hashMap);
    }

    /* renamed from: e */
    public static void m16156e(Context context, String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("ttid", C8450a.m24469bn(j));
        UserBehaviorLog.onKVEvent(context, "VE_Transition_Show", hashMap);
    }
}
