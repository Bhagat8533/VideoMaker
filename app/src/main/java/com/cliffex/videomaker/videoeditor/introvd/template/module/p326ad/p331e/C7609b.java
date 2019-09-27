package com.introvd.template.module.p326ad.p331e;

import com.p131c.p132a.C2561a;

/* renamed from: com.introvd.template.module.ad.e.b */
class C7609b {
    private static final C7608a dNg;

    static {
        if (C2561a.aOR() == 2) {
            dNg = new C7611d();
        } else if (C2561a.aOR() == 3 || C2561a.aOR() == 6) {
            dNg = new C7610c();
        } else {
            dNg = new C7612e();
        }
    }

    /* renamed from: kl */
    public static String m22414kl(String str) {
        return dNg == null ? "" : dNg.mo32499kl(str);
    }
}
