package com.introvd.template.module.iap.p341b.p345d;

import android.os.Environment;
import android.text.TextUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.utils.C8080d;
import com.introvd.template.router.user.UserServiceProxy;
import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.b.d.e */
public final class C7776e {
    private static final String dVD;

    /* renamed from: com.introvd.template.module.iap.b.d.e$a */
    private static class C7777a implements Serializable {
        String cnz;
        long dVE;
        List<C7827b> dVF;

        C7777a(String str, long j, List<C7827b> list) {
            this.cnz = str;
            this.dVE = j;
            this.dVF = list;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append(File.separator);
        sb.append("XiaoYing");
        sb.append(File.separator);
        sb.append("local_iap_cache");
        sb.append(File.separator);
        dVD = sb.toString();
    }

    /* renamed from: a */
    public static void m22721a(String str, long j, List<C7827b> list) {
        if (!TextUtils.isEmpty(str) && j > 0 && list != null && !list.isEmpty()) {
            C8080d.m23448e(new C7777a(str, j, list), m22724lK(str));
        }
    }

    /* renamed from: a */
    private static boolean m22722a(String str, long j, C7777a aVar) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || aVar == null || TextUtils.isEmpty(aVar.cnz) || aVar.dVE <= 0 || aVar.dVF == null || aVar.dVF.isEmpty()) {
            return false;
        }
        Date date = new Date(aVar.dVE);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(10, C8048e.aBe().mo23606IX());
        if (str.equals(aVar.cnz) && instance.getTime().getTime() - j >= 0) {
            z = true;
        }
        return z;
    }

    private static C7777a aEM() {
        Object lV = C8080d.m23449lV(m22724lK(UserServiceProxy.getUserId()));
        if (lV instanceof C7777a) {
            return (C7777a) lV;
        }
        return null;
    }

    /* renamed from: i */
    public static List<C7827b> m22723i(String str, long j) {
        C7777a aEM = aEM();
        if (aEM != null && m22722a(str, j, aEM)) {
            return aEM.dVF;
        }
        return null;
    }

    /* renamed from: lK */
    private static String m22724lK(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(dVD);
        sb.append("_");
        sb.append(str);
        return sb.toString();
    }
}
