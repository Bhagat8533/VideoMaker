package com.introvd.template.module.iap.p341b.p344c;

import android.text.TextUtils;
import com.diii.p142a.p143a.C2653a;
import com.diii.p142a.p143a.C2655c;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.introvd.template.module.iap.b.c.b */
public final class C7746b {
    /* renamed from: cq */
    public static List<C7827b> m22663cq(List<C2653a> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (C2653a aVar : list) {
            if (aVar != null) {
                Object obj = null;
                try {
                    obj = new C7827b("subscription", aVar.mo13108sn());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: cr */
    public static List<C7832c> m22664cr(List<C2655c> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (C2655c cVar : list) {
            if (cVar != null) {
                C7832c cVar2 = new C7832c(cVar.mo13116sm());
                cVar2.mo32745lf(cVar.getType());
                cVar2.mo32752lm(cVar.mo13117sp());
                cVar2.mo32740aO(cVar.mo13118sq());
                cVar2.mo32751ll(cVar.mo13119sr());
                if (!TextUtils.isEmpty(cVar.mo13123sv())) {
                    try {
                        cVar2.mo32739aN(C2575a.parseLong(cVar.mo13123sv()));
                        cVar2.mo32750lk(cVar.mo13122su());
                    } catch (NumberFormatException e) {
                        C8048e.aBe().logException(e);
                    }
                }
                cVar2.mo32746lg(cVar.mo13121st());
                cVar2.mo32747lh(cVar.mo13120ss());
                cVar2.mo32745lf(cVar.getType());
                cVar2.setDescription(cVar.getDescription());
                arrayList.add(cVar2);
            }
        }
        return arrayList;
    }
}
