package com.introvd.template.module.p325a;

import p037b.p050b.C1848s;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p076j.C1820a;
import p469f.C9703c.C9704a;
import p469f.C9730e.C9731a;
import p469f.C9768m;
import p469f.C9769n;
import p469f.C9769n.C9771a;
import p469f.p470a.p471a.C9698h;
import p469f.p472b.p473a.C9700a;

/* renamed from: com.introvd.template.module.a.c */
class C7577c {
    private static C9769n dMe;

    /* renamed from: Hc */
    private static C9769n m22353Hc() {
        if (dMe == null) {
            dMe = new C9771a().mo37528ua("http://=").mo37523a((C9731a) C9700a.baR()).mo37522a((C9704a) C9698h.baQ()).baM();
        }
        return dMe;
    }

    /* renamed from: kb */
    static C1848s<C9768m<Void>> m22354kb(String str) {
        C7576b bVar = (C7576b) m22353Hc().mo37510S(C7576b.class);
        return bVar == null ? C1848s.m5331x(new Throwable("no base url")) : bVar.mo32477kb(str).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa());
    }
}
