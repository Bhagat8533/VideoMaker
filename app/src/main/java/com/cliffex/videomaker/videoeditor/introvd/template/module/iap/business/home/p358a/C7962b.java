package com.introvd.template.module.iap.business.home.p358a;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.reflect.TypeToken;
import com.introvd.template.common.filecache.FileCacheV2.Builder;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p349a.p350a.C7826a;
import com.introvd.template.module.iap.p340a.C7700b;
import com.introvd.template.module.iap.p341b.C7738c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.module.iap.business.home.a.b */
public final class C7962b {
    /* renamed from: a */
    public static void m23138a(final C7968d dVar) {
        C7700b.m22609iC(C8049f.aBf().aBl()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<List<C7826a>, List<C7967c>>() {
            public List<C7967c> apply(List<C7826a> list) throws Exception {
                return C7962b.m23141cn(list);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<List<C7967c>>() {
            public void onError(Throwable th) {
                if (dVar != null) {
                    dVar.mo32916cl(C7962b.aDL());
                }
            }

            public void onSuccess(List<C7967c> list) {
                if (dVar != null) {
                    dVar.mo32916cl(list);
                }
                C7962b.m23140cm(list);
            }
        });
    }

    public static List<C7967c> aDK() {
        return (List) new Builder(C8048e.aBe().getContext(), "Abroad_goods_config_cache", new TypeToken<List<C7967c>>() {
        }.getType()).unEncrypted().build().getCacheSync();
    }

    /* access modifiers changed from: private */
    public static List<C7967c> aDL() {
        ArrayList arrayList = new ArrayList(2);
        C7967c h = m23143h(C7961a.m23134lC("premium_platinium_monthly_2.49"));
        if (h != null) {
            arrayList.add(h);
        }
        C7967c h2 = m23143h(C7961a.m23134lC("premium_platinium_yearly_12.99"));
        if (h2 != null) {
            arrayList.add(h2);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: cm */
    public static void m23140cm(List<C7967c> list) {
        new Builder(C8048e.aBe().getContext(), "Abroad_goods_config_cache", new TypeToken<C7967c>() {
        }.getType()).unEncrypted().build().saveCache(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: cn */
    public static List<C7967c> m23141cn(List<C7826a> list) {
        if (list == null || list.isEmpty()) {
            return aDL();
        }
        List<C7967c> arrayList = new ArrayList<>();
        for (C7826a h : list) {
            C7967c h2 = m23143h(h);
            if (h2 != null) {
                arrayList.add(h2);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = aDL();
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: h */
    private static C7967c m23143h(C7826a aVar) {
        if (aVar == null) {
            return null;
        }
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(aVar.goodsId);
        if (cVar == null) {
            return null;
        }
        if (!C7961a.m23129d(aVar)) {
            aVar = C7961a.m23134lC(aVar.goodsId);
            if (aVar == null) {
                return null;
            }
        }
        C7967c cVar2 = new C7967c();
        cVar2.order = aVar.order;
        cVar2.dRZ = cVar.aCy();
        cVar2.goodsId = aVar.goodsId;
        if (aVar.dSd) {
            cVar2.dQa = cVar.mo32756sp();
        }
        if (aVar.dSc - FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE > 1.0E-4d && aVar.dSc - 1.0d < 1.0E-4d) {
            cVar2.dQb = C7961a.m23130e(aVar);
        }
        cVar2.title = C7961a.m23126b(aVar);
        cVar2.description = C7961a.m23128c(aVar);
        cVar2.label = C7961a.m23123a(aVar);
        return cVar2;
    }
}
