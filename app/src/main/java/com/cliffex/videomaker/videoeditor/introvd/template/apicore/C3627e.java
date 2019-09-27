package com.introvd.template.apicore;

/* renamed from: com.introvd.template.apicore.e */
public class C3627e {
    private static volatile C3627e bhr;
    private C3630h bhs;

    private C3627e() {
    }

    /* renamed from: GQ */
    public static C3627e m8892GQ() {
        if (bhr == null) {
            synchronized (C3627e.class) {
                if (bhr == null) {
                    bhr = new C3627e();
                }
            }
        }
        return bhr;
    }

    /* renamed from: GR */
    public C3630h mo22966GR() {
        return this.bhs;
    }

    /* renamed from: a */
    public void mo22967a(C3630h hVar) {
        this.bhs = hVar;
    }
}
