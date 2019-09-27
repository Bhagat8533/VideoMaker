package com.introvd.template.module.iap.p340a;

import android.text.TextUtils;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3626d;
import com.introvd.template.apicore.C3634k;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.module.iap.business.exchange.C7914b;
import com.introvd.template.module.iap.business.exchange.C7922d;
import com.introvd.template.module.iap.business.p349a.p351b.C7829b;
import java.util.HashMap;
import java.util.List;
import okhttp3.C9943t;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9768m;
import p469f.C9769n;

/* renamed from: com.introvd.template.module.iap.a.d */
public class C7712d extends C3626d {
    private static C1848s<C7711c> aBy() {
        String GM = C3625c.m8880GI().mo22959GM();
        return TextUtils.isEmpty(GM) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(GM).mo10199i(new C1518f<C9769n, C7711c>() {
            /* renamed from: j */
            public C7711c apply(C9769n nVar) throws Exception {
                return (C7711c) nVar.mo37510S(C7711c.class);
            }
        });
    }

    /* renamed from: kG */
    public static C1848s<C9768m<List<C7829b>>> m22622kG(final String str) {
        return aBy().mo10198h(new C1518f<C7711c, C1852w<? extends C9768m<List<C7829b>>>>() {
            /* renamed from: a */
            public C1852w<? extends C9768m<List<C7829b>>> apply(C7711c cVar) throws Exception {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str);
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22959GM());
                sb.append("vip2");
                return cVar.mo32589n(new C3634k(C9943t.m28421ti(sb.toString()), (Object) hashMap).mo22977GW());
            }
        }).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa());
    }

    /* renamed from: sh */
    public static C1848s<C7914b> m22623sh(final int i) {
        return aBy().mo10198h(new C1518f<C7711c, C1852w<? extends C7914b>>() {
            /* renamed from: a */
            public C1852w<? extends C7914b> apply(C7711c cVar) throws Exception {
                HashMap hashMap = new HashMap();
                if (i > 0) {
                    hashMap.put("exchangeType", String.valueOf(i));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22959GM());
                sb.append("listExchangeAbleVips");
                return cVar.mo32590o(new C3634k(C9943t.m28421ti(sb.toString()), (Object) hashMap).mo22977GW());
            }
        }).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa());
    }

    /* renamed from: u */
    public static C1848s<C7922d> m22624u(final int i, final String str) {
        return aBy().mo10198h(new C1518f<C7711c, C1852w<? extends C7922d>>() {
            /* renamed from: a */
            public C1852w<? extends C7922d> apply(C7711c cVar) throws Exception {
                if (i < 0) {
                    return C1848s.m5331x(new Throwable("error parameter"));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("exchangeType", String.valueOf(i));
                if (i == 1) {
                    hashMap.put("exchangeCode", String.valueOf(str));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22959GM());
                sb.append("exchangeVip");
                return cVar.mo32591p(new C3634k(C9943t.m28421ti(sb.toString()), (Object) hashMap).mo22977GW());
            }
        }).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa());
    }
}
