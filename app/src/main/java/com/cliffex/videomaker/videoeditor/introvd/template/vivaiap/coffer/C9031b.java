package com.introvd.template.vivaiap.coffer;

import com.introvd.template.vivaiap.base.C9022a;
import com.introvd.template.vivaiap.base.C9024b;
import com.introvd.template.vivaiap.base.p417a.C9023a;
import java.util.List;

/* renamed from: com.introvd.template.vivaiap.coffer.b */
class C9031b<T extends C9023a, R extends C9023a> extends C9029a<T, R> {
    /* access modifiers changed from: private */
    public C9037e<T> eAS;
    /* access modifiers changed from: private */
    public C9037e<R> eAT;
    /* access modifiers changed from: private */
    public C9024b<T> eAU;
    /* access modifiers changed from: private */
    public C9024b<R> eAV;
    /* access modifiers changed from: private */
    public C9036d<T> eAW = new C9036d<T>() {
        /* renamed from: c */
        public void mo35842c(C9038f fVar, List<T> list) {
            if (!(fVar == null || !fVar.isSuccess() || C9031b.this.eAU == null)) {
                C9031b.this.eAU.mo35828df(list);
            }
            if (C9031b.this.aNt() != null) {
                C9031b.this.aNt().mo32626a(fVar, list);
            }
        }
    };
    /* access modifiers changed from: private */
    public C9036d<R> eAX = new C9036d<R>() {
        /* renamed from: c */
        public void mo35842c(C9038f fVar, List<R> list) {
            if (!(fVar == null || !fVar.isSuccess() || C9031b.this.eAV == null)) {
                C9031b.this.eAV.mo35828df(list);
            }
            if (C9031b.this.aNt() != null) {
                C9031b.this.aNt().mo32627b(fVar, list);
            }
        }
    };
    private C9022a eAY = new C9022a() {
        public void aNr() {
            if (C9031b.this.eAS != null) {
                C9031b.this.eAS.mo32603a(C9031b.this.eAW);
            }
        }

        public void aNs() {
            if (C9031b.this.eAT != null) {
                C9031b.this.eAT.mo32603a(C9031b.this.eAX);
            }
        }
    };

    C9031b() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35829a(C9024b<T> bVar) {
        this.eAU = bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35831a(C9037e<T> eVar) {
        this.eAS = eVar;
    }

    public C9022a aNu() {
        return this.eAY;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo35834b(C9024b<R> bVar) {
        this.eAV = bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo35835b(C9037e<R> eVar) {
        this.eAT = eVar;
    }
}
