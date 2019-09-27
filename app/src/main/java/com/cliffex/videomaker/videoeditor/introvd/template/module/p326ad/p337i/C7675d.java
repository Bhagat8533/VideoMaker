package com.introvd.template.module.p326ad.p337i;

import android.text.TextUtils;
import com.introvd.template.module.p326ad.C7678j;
import com.introvd.template.module.p326ad.p334h.C7662c;
import com.introvd.template.module.p326ad.p334h.p335a.C7655a;
import com.introvd.template.module.p326ad.p334h.p335a.p336a.C7656a;
import com.introvd.template.router.iap.IapServiceProxy;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1809b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.module.ad.i.d */
public class C7675d {
    /* renamed from: D */
    public static void m22502D(String str, int i) {
        m22505f(str, i, 1);
        IapServiceProxy.execute(IapServiceProxy.addReward, str);
    }

    public static void aAK() {
        if (!C7678j.aAd().isInChina()) {
            C7656a.aAF().aAG().mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<List<C7655a>, C1840o<C7655a>>() {
                /* renamed from: aE */
                public C1840o<C7655a> apply(List<C7655a> list) {
                    return C1834l.m5262d((Iterable<? extends T>) list);
                }
            }).mo10149b((C1842q<? super T>) new C1809b<C7655a>() {
                /* renamed from: e */
                public void mo9886K(C7655a aVar) {
                    if (C7675d.m22503c(aVar)) {
                        C7656a.aAF().mo32551ko(aVar.aAB());
                    } else if (aVar.aAE() == 1) {
                        IapServiceProxy.execute(IapServiceProxy.addReward, aVar.aAB());
                    }
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                }
            });
        }
    }

    public static String aAL() {
        String string = C7662c.aAA().getString("key_pref_encourage_unlock_sign", null);
        if (!TextUtils.isEmpty(string)) {
            C7662c.aAA().setString("key_pref_encourage_unlock_sign", null);
        }
        return string;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m22503c(C7655a aVar) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        if (System.currentTimeMillis() - aVar.aAC() > ((long) aVar.aAD()) * 86400000) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public static void m22505f(String str, int i, int i2) {
        if (C7656a.aAF().mo32550kn(str) != null) {
            C7656a.aAF().mo32551ko(str);
        }
        C7656a.aAF().mo32548a(new C7655a(str, i, i2));
    }

    /* renamed from: kp */
    public static int m22506kp(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (((Boolean) IapServiceProxy.execute(IapServiceProxy.isEncourageAllTemplate, str)).booleanValue()) {
            i = 1;
        } else if (str.contains("ad_")) {
            i = 2;
        }
        return i;
    }

    /* renamed from: kq */
    public static boolean m22507kq(String str) {
        return (C7678j.aAd().mo23619Mk() && !C7678j.aAd().isInChina()) && C7656a.aAF().mo32550kn(str) != null;
    }

    /* renamed from: rW */
    public static String m22508rW(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("ad_");
        sb.append(i);
        return sb.toString();
    }
}
