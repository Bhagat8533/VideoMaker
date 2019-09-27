package com.introvd.template.module.iap.business.exchange;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.business.exchange.C7914b.C7915a;
import com.introvd.template.module.iap.business.p352b.C7834a;
import com.introvd.template.module.iap.p340a.C7712d;
import com.introvd.template.router.user.UserServiceProxy;
import com.p131c.p132a.p135c.C2575a;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.module.iap.business.exchange.c */
public class C7916c {
    private final SparseArray<Long> dSA;
    /* access modifiers changed from: private */
    public boolean dSB;
    /* access modifiers changed from: private */
    public SparseIntArray dSC;

    /* renamed from: com.introvd.template.module.iap.business.exchange.c$a */
    public interface C7920a {
        /* renamed from: a */
        void mo32574a(C7922d dVar);
    }

    /* renamed from: com.introvd.template.module.iap.business.exchange.c$b */
    private static final class C7921b {
        /* access modifiers changed from: private */
        public static final C7916c dSF = new C7916c();
    }

    private C7916c() {
        this.dSA = new SparseArray<>();
        this.dSB = false;
        this.dSC = new SparseIntArray();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C7922d m23043a(C7914b bVar) {
        if (bVar == null) {
            return new C7922d(String.valueOf(-1), "vip exchange info is null");
        }
        int parseInt = C2575a.parseInt(bVar.code);
        if (parseInt != 0) {
            return new C7922d(String.valueOf(parseInt), bVar.message);
        }
        if (bVar.dSz == null || bVar.dSz.isEmpty()) {
            return new C7922d(String.valueOf(parseInt), "vip exchange info list is empty");
        }
        for (C7915a aVar : bVar.dSz) {
            if (aVar != null) {
                this.dSC.put(aVar.type, aVar.days);
            }
        }
        return new C7922d(bVar.code, bVar.message);
    }

    public static C7916c aCW() {
        return C7921b.dSF;
    }

    /* renamed from: sA */
    private boolean m23047sA(int i) {
        if (this.dSA.indexOfKey(i) < 0) {
            this.dSA.put(i, Long.valueOf(System.currentTimeMillis()));
            LogUtilsV2.m14228e("set flag and don't block");
            return false;
        }
        if (System.currentTimeMillis() - ((Long) this.dSA.get(i)).longValue() > DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
            this.dSA.put(i, Long.valueOf(System.currentTimeMillis()));
            LogUtilsV2.m14228e("out of 5s, update flag and don't block");
            return false;
        }
        LogUtilsV2.m14228e("block");
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: sB */
    public void m23048sB(int i) {
        LogUtilsV2.m14228e("reset flag");
        this.dSA.remove(i);
    }

    /* renamed from: a */
    public void mo32875a(final int i, final C7920a aVar) {
        LogUtilsV2.m14228e("exchange request");
        if (!m23047sA(i)) {
            C7834a.m22840sx(i);
            C7712d.m22624u(i, null).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<C7922d>() {
                /* renamed from: b */
                public void onSuccess(C7922d dVar) {
                    LogUtilsV2.m14228e("exchange response");
                    C7916c.this.m23048sB(i);
                    if (dVar.aDa()) {
                        C8049f.aBf().restoreGoodsAndPurchaseInfo();
                        C7916c.this.dSC.delete(i);
                    }
                    if (aVar != null) {
                        aVar.mo32574a(dVar);
                    }
                }

                public void onError(Throwable th) {
                    LogUtilsV2.m14228e("exchange response");
                    C7916c.this.m23048sB(i);
                    if (aVar != null) {
                        C7920a aVar = aVar;
                        String valueOf = String.valueOf(-1);
                        StringBuilder sb = new StringBuilder();
                        sb.append(th.getMessage());
                        sb.append("");
                        aVar.mo32574a(new C7922d(valueOf, sb.toString()));
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo32876a(final C7920a aVar) {
        if (UserServiceProxy.isLogin()) {
            C7712d.m22623sh(-1).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<C7914b>() {
                /* renamed from: b */
                public void onSuccess(C7914b bVar) {
                    C7916c.this.dSB = true;
                    C7922d a = C7916c.this.m23043a(bVar);
                    if (aVar != null) {
                        aVar.mo32574a(a);
                    }
                }

                public void onError(Throwable th) {
                    if (aVar != null) {
                        C7920a aVar = aVar;
                        String valueOf = String.valueOf(-1);
                        StringBuilder sb = new StringBuilder();
                        sb.append(th.getMessage());
                        sb.append("");
                        aVar.mo32574a(new C7922d(valueOf, sb.toString()));
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo32877a(String str, final C7920a aVar) {
        if (!m23047sA(1)) {
            C7712d.m22624u(1, str).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<C7922d>() {
                /* renamed from: b */
                public void onSuccess(C7922d dVar) {
                    C7916c.this.m23048sB(1);
                    C8049f.aBf().restoreGoodsAndPurchaseInfo();
                    if (aVar != null) {
                        aVar.mo32574a(dVar);
                    }
                }

                public void onError(Throwable th) {
                    C7916c.this.m23048sB(1);
                    C8049f.aBf().restoreGoodsAndPurchaseInfo();
                    if (aVar != null) {
                        C7920a aVar = aVar;
                        String valueOf = String.valueOf(-1);
                        StringBuilder sb = new StringBuilder();
                        sb.append(th.getMessage());
                        sb.append("");
                        aVar.mo32574a(new C7922d(valueOf, sb.toString()));
                    }
                }
            });
        }
    }

    public boolean aCX() {
        return this.dSC.indexOfKey(4) >= 0;
    }

    public boolean aCY() {
        return !this.dSB;
    }

    /* renamed from: sz */
    public int mo32880sz(int i) {
        return this.dSC.get(i);
    }

    public void unInit() {
        this.dSB = false;
        this.dSC.clear();
    }
}
