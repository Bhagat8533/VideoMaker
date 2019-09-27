package com.introvd.template.vivaiap.warehouse;

import com.introvd.template.vivaiap.base.C9024b;
import com.introvd.template.vivaiap.base.p417a.C9023a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.vivaiap.warehouse.g */
class C9074g<T extends C9023a, R extends C9023a> extends C9072f<T, R> {
    private final C9024b<T> eAU = new C9024b<T>() {
        /* renamed from: df */
        public void mo35828df(List<T> list) {
            C9074g.this.eBw.clear();
            C9074g.this.eBw.mo35911dg(list);
            if (C9074g.this.aNM() != null) {
                C9074g.this.aNM().aDC();
            }
        }
    };
    private final C9024b<R> eAV = new C9024b<R>() {
        /* renamed from: df */
        public void mo35828df(List<R> list) {
            C9074g.this.eBx.clear();
            C9074g.this.eBx.mo35911dg(list);
            if (C9074g.this.aNM() != null) {
                C9074g.this.aNM().aEG();
            }
        }
    };
    /* access modifiers changed from: private */
    public final C9067a<R> eBu;
    private final C9068b eBv = new C9068b() {
        /* renamed from: rh */
        public boolean mo35906rh(String str) {
            return C9074g.this.eBu != null && C9074g.this.eBu.mo32604a(C9074g.this.eBx, str);
        }
    };
    /* access modifiers changed from: private */
    public final C9070d<T> eBw = new C9071e(new C9069c<T>() {
        /* renamed from: b */
        public void mo35907b(int i, T t) {
            if (i == 1) {
                i = 1;
            } else if (i == 2) {
                i = 2;
            }
            C9074g.this.aNM().mo32622a(i, t);
        }
    });
    /* access modifiers changed from: private */
    public final C9070d<R> eBx = new C9081b(new C9069c<R>() {
        /* renamed from: b */
        public void mo35907b(int i, R r) {
            if (C9074g.this.aNM() != null) {
                if (i == 1) {
                    i = -1;
                } else if (i == 2) {
                    i = -2;
                }
                C9074g.this.aNM().mo32622a(i, r);
            }
        }
    });
    /* access modifiers changed from: private */
    public Map<String, Boolean> eBy = new HashMap();

    /* renamed from: com.introvd.template.vivaiap.warehouse.g$a */
    private class C9080a implements C9067a<R> {
        private C9067a<R> eBu;

        C9080a(C9067a<R> aVar) {
            this.eBu = aVar;
        }

        /* renamed from: a */
        public boolean mo32604a(C9070d<R> dVar, String str) {
            if (C9074g.this.eBy.containsKey(str)) {
                return ((Boolean) C9074g.this.eBy.get(str)).booleanValue();
            }
            boolean a = this.eBu.mo32604a(dVar, str);
            C9074g.this.eBy.put(str, Boolean.valueOf(a));
            return a;
        }
    }

    /* renamed from: com.introvd.template.vivaiap.warehouse.g$b */
    private class C9081b extends C9071e<R> {
        C9081b(C9069c<R> cVar) {
            super(cVar);
        }

        /* renamed from: a */
        public void mo35908a(R r) {
            C9074g.this.eBy.remove(r.getId());
            super.mo35908a(r);
        }

        public void clear() {
            C9074g.this.eBy.clear();
            super.clear();
        }

        /* renamed from: dg */
        public void mo35911dg(List<R> list) {
            C9074g.this.eBy.clear();
            super.mo35911dg(list);
        }
    }

    C9074g(C9067a<R> aVar) {
        this.eBu = new C9080a(aVar);
    }

    public C9070d<T> aNH() {
        return this.eBw;
    }

    public C9070d<R> aNI() {
        return this.eBx;
    }

    public C9024b<T> aNJ() {
        return this.eAU;
    }

    public C9024b<R> aNK() {
        return this.eAV;
    }

    public C9068b aNL() {
        return this.eBv;
    }
}
