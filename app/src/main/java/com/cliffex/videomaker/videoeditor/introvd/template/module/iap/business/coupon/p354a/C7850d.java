package com.introvd.template.module.iap.business.coupon.p354a;

import com.introvd.template.module.iap.business.coupon.C7846a;
import com.introvd.template.module.iap.business.p356e.C7899c;

/* renamed from: com.introvd.template.module.iap.business.coupon.a.d */
public class C7850d implements C7848b {
    /* renamed from: f */
    private boolean m22894f(C7846a aVar) {
        return C7851e.m22897aw("key_coupon_show_strategy_one_time", aVar.code);
    }

    /* renamed from: c */
    public boolean mo32775c(C7846a aVar) {
        boolean f = m22894f(aVar);
        if (!f) {
            C7851e.m22898e("key_coupon_show_strategy_one_time", aVar.code);
        }
        return !f;
    }

    public void clear() {
        C7899c.aDg().remove("key_coupon_show_strategy_one_time");
    }
}
