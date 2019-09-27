package com.introvd.template.module.iap.p341b.p345d;

import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.p341b.p343b.C7737e;
import com.introvd.template.vivaiap.payment.PayResult;

/* renamed from: com.introvd.template.module.iap.b.d.b */
public final class C7765b {
    /* renamed from: c */
    public static boolean m22704c(PayResult payResult) {
        if (payResult == null) {
            return false;
        }
        if (!C8048e.aBe().isInChina()) {
            return payResult.isSuccess();
        }
        boolean isSuccess = payResult.isSuccess();
        if (!isSuccess) {
            isSuccess = payResult.getCode() == 10000;
        }
        return isSuccess;
    }

    /* renamed from: d */
    public static C7737e m22705d(PayResult payResult) {
        return new C7737e(m22704c(payResult), payResult.aAB());
    }
}
