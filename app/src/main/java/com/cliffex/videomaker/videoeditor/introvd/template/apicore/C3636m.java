package com.introvd.template.apicore;

import java.util.HashMap;
import java.util.Map;
import p037b.p050b.C1848s;
import p469f.C9769n;

/* renamed from: com.introvd.template.apicore.m */
public class C3636m {
    private static Map<String, C9769n> bhA = new HashMap();
    public static String bhq = C3629g.m8897db("no base url");

    /* renamed from: GX */
    public static synchronized void m8911GX() {
        synchronized (C3636m.class) {
            bhA.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ C9769n m8912a(String str, Boolean bool) throws Exception {
        if (bhA.get(str) != null) {
            return (C9769n) bhA.get(str);
        }
        C9769n de = C3646w.m8938de(str);
        bhA.put(str, de);
        return de;
    }

    /* renamed from: dd */
    public static C1848s<C9769n> m8914dd(String str) {
        return C1848s.m5326ai(Boolean.valueOf(true)).mo10199i(new C3637n(str));
    }

    /* renamed from: m */
    public static C1848s<C9769n> m8915m(String str, int i) {
        return C1848s.m5326ai(C3646w.m8941n(str, i));
    }
}
