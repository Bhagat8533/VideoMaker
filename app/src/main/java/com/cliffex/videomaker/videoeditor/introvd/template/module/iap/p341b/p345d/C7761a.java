package com.introvd.template.module.iap.p341b.p345d;

import android.text.TextUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p349a.p351b.C7828a;
import com.introvd.template.module.iap.business.p349a.p351b.C7829b;
import com.introvd.template.module.iap.utils.C8078b;
import com.introvd.template.module.iap.utils.C8079c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.b.d.a */
public class C7761a {
    /* renamed from: a */
    public static List<C7827b> m22691a(long j, List<C7829b> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (C7829b bVar : list) {
            if (bVar != null) {
                C7827b bVar2 = new C7827b(bVar.aCH(), bVar.isValid());
                bVar2.mo32703ld(bVar.aCK());
                bVar2.mo32700aL(j);
                arrayList.add(bVar2);
            }
        }
        return arrayList;
    }

    /* renamed from: cv */
    public static List<C7832c> m22692cv(List<C7828a> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (C7828a aVar : list) {
            if (aVar != null && (!C8048e.aBe().mo23628Mt() || TextUtils.isEmpty(aVar.aCH()) || !aVar.aCH().contains("vip_subscription"))) {
                C7832c cVar = new C7832c(C8079c.m23444E(aVar.aCH(), aVar.aCG()));
                cVar.setOrder(aVar.getOrder());
                cVar.setName(aVar.getTitle());
                cVar.setDescription(aVar.getDescription());
                cVar.mo32758su(aVar.aCG());
                cVar.mo32749lj(aVar.getLabel());
                cVar.mo32740aO((long) aVar.aCI());
                cVar.mo32752lm(C8078b.m23440aP((long) aVar.aCI()));
                cVar.mo32738aM((long) aVar.aCJ());
                cVar.mo32748li(C8078b.m23440aP((long) aVar.aCJ()));
                cVar.mo32751ll("CNY");
                cVar.mo32753ln(aVar.aCF());
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }
}
