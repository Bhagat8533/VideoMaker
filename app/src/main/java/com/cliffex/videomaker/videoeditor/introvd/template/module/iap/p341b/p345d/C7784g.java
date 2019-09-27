package com.introvd.template.module.iap.p341b.p345d;

import com.introvd.template.apicore.C3635l;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p349a.p351b.C7828a;
import com.introvd.template.module.iap.p340a.C7700b;
import com.introvd.template.vivaiap.coffer.C9036d;
import com.introvd.template.vivaiap.coffer.C9037e;
import com.introvd.template.vivaiap.coffer.C9038f;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.b.d.g */
public class C7784g implements C9037e<C7832c> {
    /* renamed from: a */
    public void mo32603a(final C9036d<C7832c> dVar) {
        C7700b.m22606c(new C3635l<List<C7828a>>() {
            public void onError(String str) {
                dVar.mo35842c(new C9038f(false, str), null);
            }

            public void onSuccess(List<C7828a> list) {
                dVar.mo35842c(new C9038f(true, "success"), C7761a.m22692cv(list));
            }
        });
    }
}
