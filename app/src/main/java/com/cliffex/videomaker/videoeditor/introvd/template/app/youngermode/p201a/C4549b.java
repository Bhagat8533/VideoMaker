package com.introvd.template.app.youngermode.p201a;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3633j;
import com.introvd.template.apicore.C3636m;
import java.util.HashMap;
import java.util.Map;
import okhttp3.C9943t;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.p057e.C1518f;
import p469f.C9769n;

/* renamed from: com.introvd.template.app.youngermode.a.b */
public class C4549b {
    /* renamed from: HN */
    private static C1848s<C4548a> m11485HN() {
        String GK = C3625c.m8880GI().mo22957GK();
        return TextUtils.isEmpty(GK) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(GK).mo10199i(new C1518f<C9769n, C4548a>() {
            /* renamed from: h */
            public C4548a apply(C9769n nVar) {
                return (C4548a) nVar.mo37510S(C4548a.class);
            }
        });
    }

    /* renamed from: RT */
    public static C1848s<JsonObject> m11486RT() {
        return m11485HN().mo10198h(new C1518f<C4548a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C4548a aVar) {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22957GK());
                sb.append("getTeenagerModel");
                return aVar.mo24781l(C3633j.m8905a(C9943t.m28421ti(sb.toString()), (Map<String, Object>) hashMap));
            }
        });
    }

    /* renamed from: V */
    public static C1848s<JsonObject> m11487V(final String str, final String str2) {
        return m11485HN().mo10198h(new C1518f<C4548a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C4548a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put("passWord", str);
                hashMap.put("teenagerModel", str2);
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22957GK());
                sb.append("setTeenagerModel");
                return aVar.mo24780k(C3633j.m8905a(C9943t.m28421ti(sb.toString()), (Map<String, Object>) hashMap));
            }
        });
    }
}
