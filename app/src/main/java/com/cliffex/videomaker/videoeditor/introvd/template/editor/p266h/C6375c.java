package com.introvd.template.editor.p266h;

import android.content.Context;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.p407e.C8743l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.editor.h.c */
public class C6375c {
    private static volatile C6375c dkk;
    /* access modifiers changed from: private */
    public volatile List<TemplateInfo> dkl = new ArrayList();
    private volatile ReentrantReadWriteLock dkm = new ReentrantReadWriteLock();
    private volatile boolean dkn = false;
    /* access modifiers changed from: private */
    public volatile List<TemplateInfo> dko = new ArrayList();
    private volatile ReentrantReadWriteLock dkp = new ReentrantReadWriteLock();
    private volatile boolean dkq = false;
    /* access modifiers changed from: private */
    public volatile List<TemplateInfo> dkr = new ArrayList();
    private volatile ReentrantReadWriteLock dks = new ReentrantReadWriteLock();
    private volatile boolean dkt = false;
    /* access modifiers changed from: private */
    public volatile List<TemplateInfo> dku = new ArrayList();
    private volatile ReentrantReadWriteLock dkv = new ReentrantReadWriteLock();
    private volatile boolean dkw = false;
    /* access modifiers changed from: private */
    public volatile List<TemplateInfo> dkx = new ArrayList();
    private volatile ReentrantReadWriteLock dky = new ReentrantReadWriteLock();
    private volatile boolean dkz = false;

    private C6375c() {
    }

    /* renamed from: a */
    private void m18336a(ReentrantReadWriteLock reentrantReadWriteLock) {
        try {
            if (reentrantReadWriteLock.writeLock().getHoldCount() > 0) {
                reentrantReadWriteLock.writeLock().unlock();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m18337a(boolean z, ReentrantReadWriteLock reentrantReadWriteLock) {
        if (!z) {
            int i = 0;
            while (i < 40) {
                try {
                    if (reentrantReadWriteLock.writeLock().getHoldCount() >= 1) {
                        Thread.sleep(10);
                        i++;
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    public static C6375c asF() {
        if (dkk == null) {
            synchronized (C6375c.class) {
                if (dkk == null) {
                    dkk = new C6375c();
                }
            }
        }
        return dkk;
    }

    /* access modifiers changed from: private */
    public void asH() {
        m18336a(this.dkm);
        this.dkn = true;
    }

    /* access modifiers changed from: private */
    public void asJ() {
        m18336a(this.dkp);
        this.dkq = true;
    }

    /* access modifiers changed from: private */
    public void asL() {
        m18336a(this.dks);
        this.dkt = true;
    }

    /* access modifiers changed from: private */
    public void asN() {
        m18336a(this.dkv);
        this.dkw = true;
    }

    /* access modifiers changed from: private */
    public void asP() {
        m18336a(this.dky);
        this.dkz = true;
    }

    /* renamed from: fM */
    private void m18346fM(final Context context) {
        this.dkn = false;
        this.dkm.writeLock().lock();
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                C6375c.this.dkl = C8743l.m25551cH(context, C8399c.ecX);
                return Boolean.valueOf(true);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C6375c.this.asH();
            }

            public void onError(Throwable th) {
                C6375c.this.asH();
            }
        });
    }

    /* renamed from: fN */
    private void m18347fN(final Context context) {
        this.dkq = false;
        this.dkp.writeLock().lock();
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                C6375c.this.dko = C8743l.m25551cH(context, C8399c.ecZ);
                return Boolean.valueOf(true);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C6375c.this.asJ();
            }

            public void onError(Throwable th) {
                C6375c.this.asJ();
            }
        });
    }

    /* renamed from: fO */
    private void m18348fO(final Context context) {
        this.dkt = false;
        this.dks.writeLock().lock();
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                C6375c.this.dkr = C8743l.m25552cI(context, C8399c.edb);
                return Boolean.valueOf(true);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C6375c.this.asL();
            }

            public void onError(Throwable th) {
                C6375c.this.asL();
            }
        });
    }

    /* renamed from: fP */
    private void m18349fP(final Context context) {
        this.dkw = false;
        this.dkv.writeLock().lock();
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                C6375c.this.dku = C8743l.m25552cI(context, C8399c.ede);
                return Boolean.valueOf(true);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C6375c.this.asN();
            }

            public void onError(Throwable th) {
                C6375c.this.asN();
            }
        });
    }

    /* renamed from: fQ */
    private void m18350fQ(final Context context) {
        this.dkz = false;
        this.dky.writeLock().lock();
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                C6375c.this.dkx = C8743l.m25551cH(context, C8399c.edd);
                return Boolean.valueOf(true);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C6375c.this.asP();
            }

            public void onError(Throwable th) {
                C6375c.this.asP();
            }
        });
    }

    public void asG() {
        this.dkn = false;
        this.dkq = false;
        this.dkt = false;
        this.dkw = false;
        this.dkz = false;
        this.dkl.clear();
        this.dko.clear();
        this.dkr.clear();
        this.dku.clear();
        this.dkx.clear();
    }

    public List<TemplateInfo> asI() {
        m18337a(this.dkn, this.dkm);
        m18336a(this.dkm);
        return this.dkl;
    }

    public List<TemplateInfo> asK() {
        m18337a(this.dkq, this.dkp);
        m18336a(this.dkp);
        return this.dko;
    }

    public List<TemplateInfo> asM() {
        m18337a(this.dkt, this.dks);
        m18336a(this.dks);
        return this.dkr;
    }

    public List<TemplateInfo> asO() {
        m18337a(this.dkw, this.dkv);
        m18336a(this.dkv);
        return this.dku;
    }

    public List<TemplateInfo> asQ() {
        m18337a(this.dkz, this.dky);
        m18336a(this.dky);
        return this.dkx;
    }

    /* renamed from: fK */
    public void mo29427fK(Context context) {
        m18348fO(context);
        m18349fP(context);
    }

    /* renamed from: fL */
    public void mo29428fL(Context context) {
        m18346fM(context);
        m18347fN(context);
        m18348fO(context);
        m18349fP(context);
        m18350fQ(context);
    }
}
