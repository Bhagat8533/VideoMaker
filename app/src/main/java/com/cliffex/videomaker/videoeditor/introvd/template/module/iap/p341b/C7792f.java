package com.introvd.template.module.iap.p341b;

import android.content.Context;
import com.introvd.template.module.iap.p341b.p342a.C7722b;
import com.introvd.template.module.iap.p341b.p342a.C7730e;
import com.introvd.template.vivaiap.payment.C9054a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.b.f */
public abstract class C7792f {
    protected Map<String, C7794g> dVj = new HashMap();

    public C7792f() {
        mo32654a(new C7722b());
        mo32654a(new C7730e());
    }

    /* renamed from: a */
    public void mo32653a(Context context, String str, String str2, C9054a aVar) {
        for (C7794g gVar : this.dVj.values()) {
            boolean cc = gVar.mo32596cc(context, str);
            if (gVar instanceof C7795h) {
                C7795h hVar = (C7795h) gVar;
                final Context context2 = context;
                final String str3 = str;
                final String str4 = str2;
                final C9054a aVar2 = aVar;
                C77931 r3 = new Runnable() {
                    public void run() {
                        C7792f.this.mo32653a(context2, str3, str4, aVar2);
                    }
                };
                hVar.mo32657l(r3);
                continue;
            }
            if (cc) {
                return;
            }
        }
        mo32602b(context, str, str2, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32654a(C7794g gVar) {
        if (gVar != null) {
            this.dVj.put(gVar.getId(), gVar);
        }
    }

    /* renamed from: b */
    public abstract void mo32602b(Context context, String str, String str2, C9054a aVar);
}
