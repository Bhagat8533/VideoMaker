package com.introvd.template.sdk.utils.p394b;

import com.introvd.template.sdk.C8382b;
import com.introvd.template.sdk.C8410e;

/* renamed from: com.introvd.template.sdk.utils.b.k */
class C8532k {
    static String getTemplateExternalFile(long j, int i, int i2) {
        String str = "";
        C8382b aHa = C8410e.aGX().aHa();
        return aHa != null ? aHa.getTemplateExternalFile(j, i, i2) : str;
    }

    /* renamed from: ig */
    static Long m24768ig(String str) {
        Long valueOf = Long.valueOf(0);
        C8382b aHa = C8410e.aGX().aHa();
        return aHa != null ? aHa.mo29495ig(str) : valueOf;
    }

    /* renamed from: q */
    static String m24769q(Long l) {
        String str = "";
        C8382b aHa = C8410e.aGX().aHa();
        return aHa != null ? aHa.mo29496q(l) : str;
    }

    /* renamed from: s */
    static boolean m24770s(Long l) {
        C8382b aHa = C8410e.aGX().aHa();
        if (aHa != null) {
            return aHa.mo29498s(l);
        }
        return true;
    }
}
