package com.introvd.template.picker.adapter;

/* renamed from: com.introvd.template.picker.adapter.b */
public class C8178b {
    private Boolean dYc;
    private Boolean dYd;
    private Boolean dYe;

    /* renamed from: com.introvd.template.picker.adapter.b$a */
    public static class C8179a {
        /* access modifiers changed from: private */
        public Boolean dYc;
        /* access modifiers changed from: private */
        public Boolean dYd;
        /* access modifiers changed from: private */
        public Boolean dYe;

        /* renamed from: B */
        public C8179a mo33272B(Boolean bool) {
            this.dYe = bool;
            return this;
        }

        /* renamed from: C */
        public C8179a mo33273C(Boolean bool) {
            this.dYc = bool;
            return this;
        }

        /* renamed from: D */
        public C8179a mo33274D(Boolean bool) {
            this.dYd = bool;
            return this;
        }

        public C8178b aFy() {
            return new C8178b(this);
        }
    }

    public C8178b(C8179a aVar) {
        this.dYc = aVar.dYc;
        this.dYd = aVar.dYd;
        this.dYe = aVar.dYe;
    }

    public Boolean aFv() {
        return this.dYe;
    }

    public Boolean aFw() {
        return this.dYc;
    }

    public Boolean aFx() {
        return this.dYd;
    }
}
