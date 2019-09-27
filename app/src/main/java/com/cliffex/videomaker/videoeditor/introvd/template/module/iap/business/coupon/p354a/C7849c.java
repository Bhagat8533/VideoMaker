package com.introvd.template.module.iap.business.coupon.p354a;

import android.text.TextUtils;
import com.introvd.template.module.iap.business.coupon.C7846a;
import com.introvd.template.module.iap.business.p356e.C7899c;
import java.util.Calendar;

/* renamed from: com.introvd.template.module.iap.business.coupon.a.c */
public class C7849c implements C7848b {
    /* renamed from: e */
    private int m22892e(C7846a aVar) {
        int i;
        String a = C7851e.m22896a("key_coupon_show_strategy_every_day", 0, aVar.code, 1);
        if (TextUtils.isEmpty(a)) {
            return -1;
        }
        try {
            i = Integer.parseInt(a);
        } catch (NumberFormatException unused) {
            i = -1;
        }
        return i;
    }

    /* renamed from: c */
    public boolean mo32775c(C7846a aVar) {
        int i = Calendar.getInstance().get(6);
        boolean z = i - m22892e(aVar) > 0;
        if (z) {
            C7851e.m22898e("key_coupon_show_strategy_every_day", aVar.code, String.valueOf(i));
        }
        return z;
    }

    public void clear() {
        C7899c.aDg().remove("key_coupon_show_strategy_every_day");
    }
}
