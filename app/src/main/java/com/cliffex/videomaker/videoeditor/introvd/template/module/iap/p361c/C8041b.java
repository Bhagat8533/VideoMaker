package com.introvd.template.module.iap.p361c;

import android.text.TextUtils;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3634k;
import com.introvd.template.apicore.C3636m;
import java.util.List;
import okhttp3.C9943t;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9769n;

/* renamed from: com.introvd.template.module.iap.c.b */
public class C8041b {
    private static C1848s<C8040a> aBy() {
        String cZ = C3625c.m8880GI().mo22964cZ("ad");
        return TextUtils.isEmpty(cZ) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(cZ).mo10199i(new C1518f<C9769n, C8040a>() {
            /* renamed from: k */
            public C8040a apply(C9769n nVar) throws Exception {
                return (C8040a) nVar.mo37510S(C8040a.class);
            }
        });
    }

    /* renamed from: cy */
    public static C1848s<List<String>> m23263cy(final List<C8044c> list) {
        return aBy().mo10198h(new C1518f<C8040a, C1852w<? extends List<String>>>() {
            /* renamed from: a */
            public C1852w<? extends List<String>> apply(C8040a aVar) throws Exception {
                return aVar.mo33063q(new C3634k(C9943t.m28421ti(C8041b.getUrl()), (Object) list).mo22977GW());
            }
        }).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa());
    }

    /* access modifiers changed from: private */
    public static String getUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(C3625c.m8880GI().mo22964cZ("ad"));
        sb.append("googlePayVerify");
        return sb.toString();
    }
}
