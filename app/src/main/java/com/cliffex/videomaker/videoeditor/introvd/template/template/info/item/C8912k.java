package com.introvd.template.template.info.item;

/* renamed from: com.introvd.template.template.info.item.k */
public class C8912k {
    private Boolean eso;
    private Integer esp;

    /* renamed from: com.introvd.template.template.info.item.k$a */
    public static final class C8914a {
        /* access modifiers changed from: private */
        public Boolean eso;
        /* access modifiers changed from: private */
        public Integer esp;

        /* renamed from: F */
        public C8914a mo35474F(Boolean bool) {
            this.eso = bool;
            return this;
        }

        public C8912k aLU() {
            return new C8912k(this);
        }

        /* renamed from: o */
        public C8914a mo35476o(Integer num) {
            this.esp = num;
            return this;
        }
    }

    private C8912k(C8914a aVar) {
        this.eso = aVar.eso;
        this.esp = aVar.esp;
    }

    public Boolean aLS() {
        return this.eso;
    }

    public Integer aLT() {
        return this.esp;
    }
}
