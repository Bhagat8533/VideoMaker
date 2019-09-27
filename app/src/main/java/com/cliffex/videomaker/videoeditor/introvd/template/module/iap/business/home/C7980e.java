package com.introvd.template.module.iap.business.home;

import android.text.TextUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.home.p358a.C7962b;
import com.introvd.template.module.iap.business.home.p358a.C7967c;
import com.introvd.template.module.iap.business.home.p358a.C7968d;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.p341b.C7738c;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.C1849t;
import p037b.p050b.C1851v;

/* renamed from: com.introvd.template.module.iap.business.home.e */
public class C7980e {
    /* access modifiers changed from: private */
    public List<C7967c> dTC;

    /* access modifiers changed from: 0000 */
    public String aCH() {
        if (this.dTC == null || this.dTC.isEmpty()) {
            C7835b.m22857iH(false);
            return aDp();
        }
        C7835b.m22857iH(true);
        String str = null;
        for (C7967c cVar : this.dTC) {
            if (cVar != null && !TextUtils.isEmpty(cVar.goodsId)) {
                C7832c cVar2 = (C7832c) C7738c.aEv().aNw().mo35913ri(cVar.goodsId);
                if (cVar2 != null && cVar2.aCy()) {
                    str = cVar.goodsId;
                }
            }
        }
        return TextUtils.isEmpty(str) ? aDp() : str;
    }

    public C1848s<String> aDn() {
        return C1848s.m5324a((C1851v<T>) new C1851v<String>() {
            /* renamed from: a */
            public void mo10201a(final C1849t<String> tVar) throws Exception {
                C7962b.m23138a(new C7968d() {
                    /* renamed from: cl */
                    public void mo32916cl(List<C7967c> list) {
                        C7980e.this.dTC = list;
                        tVar.onSuccess(C7980e.this.aCH());
                    }
                });
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void aDo() {
        C7962b.m23138a(new C7968d() {
            /* renamed from: cl */
            public void mo32916cl(List<C7967c> list) {
                C7980e.this.dTC = list;
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public String aDp() {
        return aDq() ? "premium_platinium_yearly_15.99" : "premium_platinium_monthly_2.49";
    }

    /* access modifiers changed from: 0000 */
    public boolean aDq() {
        return C8048e.aBe().mo23616MH();
    }
}
