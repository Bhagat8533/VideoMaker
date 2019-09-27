package com.introvd.template.vivaiap.warehouse;

import com.introvd.template.vivaiap.base.C9024b;
import com.introvd.template.vivaiap.base.p417a.C9023a;

/* renamed from: com.introvd.template.vivaiap.warehouse.f */
public abstract class C9072f<T extends C9023a, R extends C9023a> {
    private C9082h eBt;

    /* renamed from: com.introvd.template.vivaiap.warehouse.f$a */
    public static final class C9073a<T extends C9023a, R extends C9023a> {
        private C9082h eBt;
        private C9067a<R> eBu;

        public C9073a(C9067a<R> aVar) {
            this.eBu = aVar;
        }

        public C9072f<T, R> aNN() {
            C9074g gVar = new C9074g(this.eBu);
            gVar.mo35915a(this.eBt);
            return gVar;
        }

        /* renamed from: b */
        public C9073a<T, R> mo35923b(C9082h hVar) {
            this.eBt = hVar;
            return this;
        }
    }

    /* renamed from: a */
    public void mo35915a(C9082h hVar) {
        this.eBt = hVar;
    }

    public abstract C9070d<T> aNH();

    public abstract C9070d<R> aNI();

    public abstract C9024b<T> aNJ();

    public abstract C9024b<R> aNK();

    public abstract C9068b aNL();

    /* access modifiers changed from: 0000 */
    public C9082h aNM() {
        return this.eBt;
    }
}
