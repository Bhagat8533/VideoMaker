package com.introvd.template.sdk.editor.p388b;

import com.introvd.template.sdk.utils.C8554j;
import java.util.concurrent.atomic.AtomicBoolean;
import p037b.p050b.C1485a;
import p037b.p050b.C1510d;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p057e.C1520h;
import p037b.p050b.p076j.C1820a;
import p037b.p050b.p077k.C1830a;
import p037b.p050b.p077k.C1833c;

/* renamed from: com.introvd.template.sdk.editor.b.a */
public class C8421a {
    private final C1833c<C8424a> cSJ = C1830a.aVl();
    /* access modifiers changed from: private */
    public boolean cyG = false;
    /* access modifiers changed from: private */
    public AtomicBoolean eeo = new AtomicBoolean(true);
    private boolean eep = false;
    private volatile C8431d eeq;
    private int eer;
    /* access modifiers changed from: private */
    public int ees;

    /* renamed from: com.introvd.template.sdk.editor.b.a$a */
    public static class C8424a {
        public boolean eeu;
        public boolean eev;
        public int position;

        public C8424a(int i, boolean z) {
            this.position = i;
            this.eeu = z;
        }
    }

    public C8421a() {
        this.cSJ.aVm();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m24345c(C8424a aVar) {
        if (this.eeq == null) {
            return false;
        }
        if (!this.eep || aVar.eev) {
            return this.eeq.mo34196uf(aVar.position);
        }
        boolean dE = this.eeq.mo34187dE(aVar.position, this.eer);
        this.eer = aVar.position;
        return dE;
    }

    /* renamed from: a */
    public void mo34146a(C8431d dVar) {
        this.eeq = dVar;
    }

    public C1510d<C8424a> aIo() {
        return this.cSJ.mo10135a((C1520h<? super T>) new C1520h<C8424a>() {
            /* renamed from: e */
            public boolean test(C8424a aVar) {
                if (aVar.eeu) {
                    return true;
                }
                C8421a.this.ees = aVar.position;
                return C8421a.this.eeo.get();
            }
        }).mo10131a(C1485a.BUFFER).mo9828b(C1820a.aVi()).mo9814a(C1820a.aVi()).mo9827b((C1518f<? super T, ? extends R>) new C1518f<C8424a, C8424a>() {
            /* renamed from: d */
            public C8424a apply(C8424a aVar) {
                long currentTimeMillis = System.currentTimeMillis();
                C8421a.this.eeo.set(false);
                boolean a = C8421a.this.m24345c(aVar);
                C8421a.this.eeo.set(true);
                StringBuilder sb = new StringBuilder();
                sb.append("seek position = ");
                sb.append(aVar.position);
                sb.append(",finish = ");
                sb.append(aVar.eev);
                sb.append(",cost = ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                sb.append("ms,isSuccess = ");
                sb.append(a);
                C8554j.m25006d("PlayerSeekRx", sb.toString());
                aVar.eev = C8421a.this.cyG;
                return aVar;
            }
        }).mo9814a(C1487a.aUa());
    }

    public void aIp() {
        StringBuilder sb = new StringBuilder();
        sb.append("stopSeek = ");
        sb.append(this.ees);
        C8554j.m25006d("PlayerSeekRx", sb.toString());
        C8424a aVar = new C8424a(this.ees, true);
        aVar.eev = true;
        mo34149b(aVar);
        this.cyG = true;
    }

    /* renamed from: b */
    public void mo34149b(C8424a aVar) {
        if (this.cSJ != null) {
            this.cyG = false;
            this.cSJ.mo9886K(aVar);
            StringBuilder sb = new StringBuilder();
            sb.append("post position = ");
            sb.append(aVar.position);
            C8554j.m25006d("PlayerSeekRx", sb.toString());
        }
    }

    public void setMode(int i) {
        this.eep = i == 2;
        if (this.eep) {
            this.eer = 0;
        }
    }
}
