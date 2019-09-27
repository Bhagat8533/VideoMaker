package com.introvd.template.origin.route;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3633j;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.editor.p252e.C5878a;
import java.util.Map;
import okhttp3.C9943t;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.p057e.C1518f;
import p469f.C9769n;

/* renamed from: com.introvd.template.origin.route.b */
public class C8142b {
    /* renamed from: N */
    static C1848s<JsonObject> m23559N(final Map<String, String> map) {
        return TextUtils.isEmpty(C3625c.m8880GI().mo22956GJ()) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8915m(C3625c.m8880GI().mo22956GJ(), 10).mo10198h(new C1518f<C9769n, C1852w<JsonObject>>() {
            /* renamed from: m */
            public C1852w<JsonObject> apply(C9769n nVar) {
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22956GJ());
                sb.append(C5878a.TAG);
                return ((C8141a) nVar.mo37510S(C8141a.class)).mo33221w(C3633j.m8906b(C9943t.m28421ti(sb.toString()), map));
            }
        });
    }

    /* renamed from: b */
    public static C1848s<JsonObject> m23560b(final String str, final Map<String, String> map) {
        return C3636m.m8915m("http://s.api.xiaoying.co/api/rest/rt/", 10).mo10198h(new C1518f<C9769n, C1852w<JsonObject>>() {
            /* renamed from: m */
            public C1852w<JsonObject> apply(C9769n nVar) {
                return ((C8141a) nVar.mo37510S(C8141a.class)).mo33220b(str, map);
            }
        });
    }
}
