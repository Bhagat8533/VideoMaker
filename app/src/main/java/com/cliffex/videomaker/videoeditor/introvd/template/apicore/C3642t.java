package com.introvd.template.apicore;

/* renamed from: com.introvd.template.apicore.t */
class C3642t {
    private static volatile C3642t bhF;
    private C3641s bhG;

    private C3642t() {
    }

    /* renamed from: GZ */
    public static C3642t m8923GZ() {
        if (bhF == null) {
            synchronized (C3642t.class) {
                if (bhF == null) {
                    bhF = new C3642t();
                }
            }
        }
        return bhF;
    }

    /* renamed from: Ha */
    public C3641s mo22986Ha() {
        return this.bhG;
    }

    /* renamed from: a */
    public void mo22987a(C3641s sVar) {
        this.bhG = sVar;
    }
}
