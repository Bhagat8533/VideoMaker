package com.introvd.template.vivaiap.coffer;

import com.introvd.template.vivaiap.base.C9022a;
import com.introvd.template.vivaiap.base.C9024b;
import com.introvd.template.vivaiap.base.p417a.C9023a;

/* renamed from: com.introvd.template.vivaiap.coffer.a */
public abstract class C9029a<T extends C9023a, R extends C9023a> {
    private C9035c<T, R> eAR;

    /* renamed from: com.introvd.template.vivaiap.coffer.a$a */
    public static class C9030a<T extends C9023a, R extends C9023a> {
        private C9035c<T, R> eAR;
        private C9037e<T> eAS;
        private C9037e<R> eAT;
        private C9024b<T> eAU;
        private C9024b<R> eAV;

        public C9029a<T, R> aNv() {
            C9031b bVar = new C9031b();
            bVar.mo35829a(this.eAU);
            bVar.mo35834b(this.eAV);
            bVar.mo35831a(this.eAS);
            bVar.mo35835b(this.eAT);
            bVar.mo35830a(this.eAR);
            return bVar;
        }

        /* renamed from: b */
        public C9030a<T, R> mo35837b(C9035c<T, R> cVar) {
            this.eAR = cVar;
            return this;
        }

        /* renamed from: c */
        public C9030a<T, R> mo35838c(C9024b<T> bVar) {
            this.eAU = bVar;
            return this;
        }

        /* renamed from: c */
        public C9030a<T, R> mo35839c(C9037e<T> eVar) {
            this.eAS = eVar;
            return this;
        }

        /* renamed from: d */
        public C9030a<T, R> mo35840d(C9024b<R> bVar) {
            this.eAV = bVar;
            return this;
        }

        /* renamed from: d */
        public C9030a<T, R> mo35841d(C9037e<R> eVar) {
            this.eAT = eVar;
            return this;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo35829a(C9024b<T> bVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35830a(C9035c<T, R> cVar) {
        this.eAR = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo35831a(C9037e<T> eVar);

    /* access modifiers changed from: 0000 */
    public C9035c<T, R> aNt() {
        return this.eAR;
    }

    public abstract C9022a aNu();

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract void mo35834b(C9024b<R> bVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract void mo35835b(C9037e<R> eVar);
}
