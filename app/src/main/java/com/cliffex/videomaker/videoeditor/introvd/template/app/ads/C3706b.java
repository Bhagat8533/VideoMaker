package com.introvd.template.app.ads;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3626d;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.apicore.C3646w;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.p203b.C4580b;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.C1853x;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9769n;

/* renamed from: com.introvd.template.app.ads.b */
class C3706b extends C3626d {

    /* renamed from: com.introvd.template.app.ads.b$a */
    static class C3711a {
        @SerializedName("result")
        List<C3720e> bjh;

        C3711a() {
        }
    }

    /* renamed from: EN */
    static <T> C1853x<T, T> m9003EN() {
        return new C1853x<T, T>() {
            /* renamed from: b */
            public C1852w<T> mo10202b(C1848s<T> sVar) {
                return sVar.mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa());
            }
        };
    }

    /* renamed from: HN */
    private static C1848s<C3705a> m9004HN() {
        String cZ = C3625c.m8880GI().mo22964cZ("ad");
        return TextUtils.isEmpty(cZ) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(cZ).mo10199i(new C1518f<C9769n, C3705a>() {
            /* renamed from: a */
            public C3705a apply(C9769n nVar) {
                return (C3705a) nVar.mo37510S(C3705a.class);
            }
        });
    }

    /* renamed from: HO */
    static C1848s<List<C3720e>> m9005HO() {
        return m9004HN().mo10198h(new C1518f<C3705a, C1852w<C3711a>>() {
            /* renamed from: a */
            public C1852w<C3711a> apply(C3705a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, C4580b.m11635Si());
                hashMap.put(C7234b.TAG, AppStateModel.getInstance().getCountryCode());
                hashMap.put("duid", C4580b.m11653dz(VivaBaseApplication.m8749FZ()));
                return aVar.mo23060p(C3646w.m8942o(hashMap));
            }
        }).mo10187a(m9003EN()).mo10199i(new C1518f<C3711a, List<C3720e>>() {
            /* renamed from: a */
            public List<C3720e> apply(C3711a aVar) {
                return aVar.bjh;
            }
        });
    }
}
