package com.introvd.template.editor.clipedit.filter;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p409g.C8759b;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.clipedit.filter.a */
public class C5708a {
    /* renamed from: a */
    public static void m15807a(Context context, long j, int i) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("+");
        sb.append(i);
        sb.append("%");
        hashMap.put("ID_percentage", sb.toString());
        UserBehaviorLog.onKVEvent(context, "VE_Filter_Adjust", hashMap);
    }

    /* renamed from: a */
    static void m15808a(C8759b bVar, String str) {
        if (bVar != null && !TextUtils.isEmpty(str)) {
            String qD = bVar.mo35209qD(str);
            long jf = C8759b.m25587jf(str);
            if (jf >= 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("name", qD);
                hashMap.put("ttid", C8450a.m24469bn(jf));
                UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "VE_Filter_SetFilter", hashMap);
            }
        }
    }
}
