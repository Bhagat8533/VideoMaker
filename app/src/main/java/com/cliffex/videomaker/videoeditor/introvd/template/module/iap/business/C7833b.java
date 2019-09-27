package com.introvd.template.module.iap.business;

import com.introvd.template.module.iap.C8045d;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.p349a.C7827b;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.b */
public class C7833b {
    public static int aBA() {
        if (!m22830sj(aBC()) || C8048e.aBe().getContext() == null) {
            return 0;
        }
        C7827b aBa = C8045d.aAZ().aBa();
        if (aBa == null) {
            return 0;
        }
        return aBa.aCx();
    }

    public static String aBB() {
        if (C8048e.aBe().getContext() == null) {
            return "";
        }
        C7827b aBa = C8045d.aAZ().aBa();
        return aBa == null ? "" : aBa.mo32696Mp();
    }

    public static int aBC() {
        List<C7827b> aBd = C8045d.aAZ().aBd();
        if (aBd == null || aBd.isEmpty()) {
            return -1;
        }
        int i = 0;
        boolean z = false;
        for (C7827b isValid : aBd) {
            z = isValid.isValid();
            if (z) {
                break;
            }
        }
        if (z) {
            i = 1;
        }
        return i;
    }

    /* renamed from: sj */
    public static boolean m22830sj(int i) {
        return 1 == i;
    }

    /* renamed from: sk */
    public static boolean m22831sk(int i) {
        return i == 0;
    }
}
