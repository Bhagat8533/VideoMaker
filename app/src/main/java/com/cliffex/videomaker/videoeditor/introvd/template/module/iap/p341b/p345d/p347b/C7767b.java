package com.introvd.template.module.iap.p341b.p345d.p347b;

import android.content.Context;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.p341b.C7792f;
import com.introvd.template.vivaiap.payment.C9054a;
import com.introvd.template.vivaiap.payment.PayParam.C9046a;
import com.introvd.template.vivaiap.payment.PayResult;

/* renamed from: com.introvd.template.module.iap.b.d.b.b */
public class C7767b extends C7792f {
    /* renamed from: b */
    public void mo32602b(Context context, String str, String str2, final C9054a aVar) {
        C7738c.aEv().mo35846a(context, new C9046a("huawei_lite", str).aNB(), new C9054a() {
            /* renamed from: a */
            public void mo32328a(PayResult payResult) {
                aVar.mo32328a(payResult);
            }
        });
    }
}
