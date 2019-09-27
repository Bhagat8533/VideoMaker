package com.introvd.template.module.iap.p341b;

import com.introvd.template.router.iaphuawei.HuaweiIAPServiceProxy;
import com.introvd.template.vivaiap.payment.C9055b;
import com.introvd.template.vivaiap.payment.C9056c;
import com.quvideo.plugin.payclient.alipay.C4847a;
import com.quvideo.plugin.payclient.google.C4866b;
import com.quvideo.plugin.payclient.wechat.C4883a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.b.e */
public class C7791e extends C9056c {
    private Map<String, C9055b> dVi = new HashMap();

    /* access modifiers changed from: protected */
    /* renamed from: lI */
    public C9055b mo32652lI(String str) {
        C9055b bVar = (C9055b) this.dVi.get(str);
        if (bVar != null) {
            return bVar;
        }
        C9055b bVar2 = "huawei_lite".equals(str) ? null : "google".equals(str) ? new C4866b(str) : "huawei".equals(str) ? (C9055b) HuaweiIAPServiceProxy.getHuaWeiPayClient(str) : "wx".equals(str) ? new C4883a(str) : "alipay".equals(str) ? new C4847a(str) : new C4847a("alipay");
        this.dVi.put(str, bVar2);
        return bVar2;
    }
}
