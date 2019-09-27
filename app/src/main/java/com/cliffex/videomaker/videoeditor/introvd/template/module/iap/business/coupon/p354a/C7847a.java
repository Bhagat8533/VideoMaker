package com.introvd.template.module.iap.business.coupon.p354a;

import android.text.TextUtils;
import com.introvd.template.module.iap.business.coupon.C7846a;
import com.introvd.template.module.iap.business.p356e.C7899c;

/* renamed from: com.introvd.template.module.iap.business.coupon.a.a */
public class C7847a implements C7848b {
    /* renamed from: d */
    private long m22889d(C7846a aVar) {
        String a = C7851e.m22896a("key_coupon_show_strategy_common", 0, aVar.code, 1);
        long j = 0;
        if (TextUtils.isEmpty(a)) {
            return 0;
        }
        try {
            j = Long.parseLong(a);
        } catch (NumberFormatException unused) {
        }
        return j;
    }

    /* renamed from: c */
    public boolean mo32775c(C7846a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar.endTime - currentTimeMillis <= 0 || aVar.endTime - currentTimeMillis > 259200000) {
            return false;
        }
        long d = m22889d(aVar);
        if (aVar.endTime - d <= 0 || aVar.endTime - d < 86400000) {
            return false;
        }
        if (aVar.endTime - currentTimeMillis > 86400000 && aVar.endTime - d > 86400000 && aVar.endTime - d < 259200000) {
            return false;
        }
        C7851e.m22898e("key_coupon_show_strategy_common", aVar.code, String.valueOf(currentTimeMillis));
        return true;
    }

    public void clear() {
        C7899c.aDg().remove("key_coupon_show_strategy_common");
    }
}
