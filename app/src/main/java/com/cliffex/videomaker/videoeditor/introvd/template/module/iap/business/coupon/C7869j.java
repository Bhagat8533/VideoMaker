package com.introvd.template.module.iap.business.coupon;

import android.annotation.SuppressLint;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.coupon.p354a.C7847a;
import com.introvd.template.module.iap.business.coupon.p354a.C7848b;
import com.introvd.template.module.iap.business.coupon.p354a.C7849c;
import com.introvd.template.module.iap.business.coupon.p354a.C7850d;
import com.introvd.template.module.iap.business.p356e.C7899c;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.business.coupon.j */
public final class C7869j {
    @SuppressLint({"UseSparseArrays"})
    private static Map<String, C7848b> dQT = new HashMap();

    static {
        C7849c cVar = new C7849c();
        dQT.put("3", cVar);
        dQT.put("8", cVar);
        C7850d dVar = new C7850d();
        dQT.put("4", dVar);
        dQT.put("5", dVar);
        dQT.put("6", dVar);
        dQT.put("7", dVar);
        dQT.put("-1", new C7847a());
    }

    public static void clear() {
        for (C7848b bVar : dQT.values()) {
            if (bVar != null) {
                bVar.clear();
            }
        }
        C7899c.aDg().remove("key_last_coupon_tip_date");
    }

    /* renamed from: lc */
    static boolean m22934lc(String str) {
        if (C8072q.aBx().isVip()) {
            return false;
        }
        C7846a kY = C7858e.m22922kY(str);
        if (kY == null || !kY.isValid()) {
            return false;
        }
        int i = Calendar.getInstance().get(6);
        if (C7899c.aDg().getInt("key_last_coupon_tip_date", 0) >= i) {
            return false;
        }
        boolean c = m22935sr(kY.dQy).mo32775c(kY);
        if (c) {
            C7899c.aDg().setInt("key_last_coupon_tip_date", i);
        }
        return c;
    }

    /* renamed from: sr */
    private static C7848b m22935sr(int i) {
        C7848b bVar = (C7848b) dQT.get(String.valueOf(i));
        return bVar == null ? (C7848b) dQT.get("-1") : bVar;
    }
}
