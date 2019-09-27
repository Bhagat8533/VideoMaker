package com.introvd.template.module.iap.business.home.p358a;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p349a.p350a.C7826a;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.utils.C8078b;
import com.introvd.template.module.iap.utils.C8081e;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.setting.ISettingRouter;
import com.introvd.template.router.setting.LocaleModel;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

/* renamed from: com.introvd.template.module.iap.business.home.a.a */
public final class C7961a {
    /* renamed from: a */
    private static int m23120a(C7832c cVar) {
        int lW = C8081e.m23450lW(cVar.mo32757ss());
        if (lW >= 7 && lW < 30) {
            return 1;
        }
        if (lW < 30 || lW >= 365) {
            return lW >= 365 ? 4 : 3;
        }
        return 2;
    }

    /* renamed from: a */
    private static C7826a m23121a(C7832c cVar, int i) {
        C7826a aVar = new C7826a();
        aVar.goodsId = cVar.getId();
        aVar.dSa = m23135sE(i);
        aVar.dSb = m23136sF(i);
        aVar.dSd = true;
        return aVar;
    }

    /* renamed from: a */
    private static String m23122a(int i, C7832c cVar) {
        if (i <= 0) {
            return null;
        }
        String b = m23127b(cVar.mo32756sp(), BigDecimal.valueOf(cVar.aCE()).divide(BigDecimal.valueOf(1000000), 2, RoundingMode.DOWN).divide(BigDecimal.valueOf((long) i), 2, RoundingMode.DOWN).doubleValue());
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        return b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r0 = r1.getString(com.introvd.template.module.iap.R.string.iap_goods_scriptions_for_promotion);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r0 = r1.getString(com.introvd.template.module.iap.R.string.iap_vip_renew_purchase_recommend);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        return r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String m23123a(com.introvd.template.module.iap.business.p349a.p350a.C7826a r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.introvd.template.module.iap.g r1 = com.introvd.template.module.iap.C8048e.aBe()
            android.content.Context r1 = r1.getContext()
            if (r1 != 0) goto L_0x000f
            return r0
        L_0x000f:
            int r2 = r3.dSe
            switch(r2) {
                case 3101: goto L_0x002b;
                case 3102: goto L_0x0024;
                default: goto L_0x0014;
            }
        L_0x0014:
            switch(r2) {
                case 3201: goto L_0x002b;
                case 3202: goto L_0x0024;
                case 3203: goto L_0x001d;
                case 3204: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0031
        L_0x0018:
            java.lang.String r0 = m23132g(r3)
            goto L_0x0031
        L_0x001d:
            double r0 = r3.dSc
            java.lang.String r0 = m23133i(r0)
            goto L_0x0031
        L_0x0024:
            int r3 = com.introvd.template.module.iap.R.string.iap_goods_scriptions_for_promotion
            java.lang.String r0 = r1.getString(r3)
            goto L_0x0031
        L_0x002b:
            int r3 = com.introvd.template.module.iap.R.string.iap_vip_renew_purchase_recommend
            java.lang.String r0 = r1.getString(r3)
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.module.iap.business.home.p358a.C7961a.m23123a(com.introvd.template.module.iap.business.a.a.a):java.lang.String");
    }

    /* renamed from: b */
    private static C7826a m23124b(C7832c cVar) {
        C7826a aVar = new C7826a();
        aVar.goodsId = cVar.getId();
        aVar.dSa = IronSourceConstants.RV_API_HAS_AVAILABILITY_TRUE;
        aVar.dSd = false;
        return aVar;
    }

    /* renamed from: b */
    private static C7826a m23125b(C7832c cVar, int i) {
        C7826a aVar = new C7826a();
        aVar.goodsId = cVar.getId();
        aVar.dSa = m23135sE(i);
        aVar.dSd = true;
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005b, code lost:
        r0 = r1.getString(com.introvd.template.module.iap.R.string.iap_vip_year_member);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0062, code lost:
        r0 = r1.getString(com.introvd.template.module.iap.R.string.iap_vip_half_year);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0069, code lost:
        r0 = r1.getString(com.introvd.template.module.iap.R.string.iap_vip_month);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0070, code lost:
        r0 = r1.getString(com.introvd.template.module.iap.R.string.iap_vip_week);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007d, code lost:
        return r0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m23126b(com.introvd.template.module.iap.business.p349a.p350a.C7826a r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.introvd.template.module.iap.g r1 = com.introvd.template.module.iap.C8048e.aBe()
            android.content.Context r1 = r1.getContext()
            if (r1 != 0) goto L_0x000f
            return r0
        L_0x000f:
            int r2 = r7.dSa
            switch(r2) {
                case 1101: goto L_0x0077;
                case 1102: goto L_0x0070;
                case 1103: goto L_0x0069;
                case 1104: goto L_0x0062;
                case 1105: goto L_0x005b;
                case 1106: goto L_0x0018;
                default: goto L_0x0014;
            }
        L_0x0014:
            switch(r2) {
                case 1201: goto L_0x0070;
                case 1202: goto L_0x0069;
                case 1203: goto L_0x0062;
                case 1204: goto L_0x005b;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x007d
        L_0x0018:
            com.introvd.template.module.iap.b.c r0 = com.introvd.template.module.iap.p341b.C7738c.aEv()
            com.introvd.template.vivaiap.warehouse.d r0 = r0.aNw()
            java.lang.String r7 = r7.goodsId
            com.introvd.template.vivaiap.base.a.a r7 = r0.mo35913ri(r7)
            com.introvd.template.module.iap.business.a.c r7 = (com.introvd.template.module.iap.business.p349a.C7832c) r7
            int r7 = r7.aCz()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.res.Resources r2 = r1.getResources()
            int r3 = com.introvd.template.module.iap.R.plurals.xiaoying_str_vip_home_free_trial_day_pluals
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            java.lang.String r6 = java.lang.String.valueOf(r7)
            r4[r5] = r6
            java.lang.String r7 = r2.getQuantityString(r3, r7, r4)
            r0.append(r7)
            java.lang.String r7 = " "
            r0.append(r7)
            int r7 = com.introvd.template.module.iap.R.string.xiaoying_str_vip_home_free_trial
            java.lang.String r7 = r1.getString(r7)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            goto L_0x007d
        L_0x005b:
            int r7 = com.introvd.template.module.iap.R.string.iap_vip_year_member
            java.lang.String r0 = r1.getString(r7)
            goto L_0x007d
        L_0x0062:
            int r7 = com.introvd.template.module.iap.R.string.iap_vip_half_year
            java.lang.String r0 = r1.getString(r7)
            goto L_0x007d
        L_0x0069:
            int r7 = com.introvd.template.module.iap.R.string.iap_vip_month
            java.lang.String r0 = r1.getString(r7)
            goto L_0x007d
        L_0x0070:
            int r7 = com.introvd.template.module.iap.R.string.iap_vip_week
            java.lang.String r0 = r1.getString(r7)
            goto L_0x007d
        L_0x0077:
            int r7 = com.introvd.template.module.iap.R.string.xiaoying_str_vip_subscribe
            java.lang.String r0 = r1.getString(r7)
        L_0x007d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.module.iap.business.home.p358a.C7961a.m23126b(com.introvd.template.module.iap.business.a.a.a):java.lang.String");
    }

    /* renamed from: b */
    private static String m23127b(String str, double d) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lS = C8078b.m23443lS(Double.toString(d));
        if (TextUtils.isEmpty(lS)) {
            return null;
        }
        return str.replaceAll("\\d+([,|.]*\\d*)*", lS);
    }

    /* renamed from: c */
    public static String m23128c(C7826a aVar) {
        String str = null;
        if (aVar == null) {
            return null;
        }
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(aVar.goodsId);
        if (cVar == null) {
            return null;
        }
        Context context = C8048e.aBe().getContext();
        if (context == null) {
            return null;
        }
        int i = aVar.dSb;
        switch (i) {
            case IronSourceConstants.IS_CHECK_READY_TRUE /*2101*/:
                int aCz = cVar.aCz();
                StringBuilder sb = new StringBuilder();
                sb.append(context.getResources().getQuantityString(R.plurals.xiaoying_str_vip_home_free_trial_day_pluals, aCz, new Object[]{String.valueOf(aCz)}));
                sb.append(" ");
                sb.append(context.getString(R.string.xiaoying_str_vip_home_free_trial));
                str = sb.toString();
                break;
            case IronSourceConstants.IS_CHECK_READY_FALSE /*2102*/:
                int aCz2 = cVar.aCz();
                str = context.getString(R.string.xiaoying_str_free_trial_then_price_week, new Object[]{String.valueOf(aCz2), cVar.mo32756sp()});
                break;
            case IronSourceConstants.IS_CHECK_CAPPED_TRUE /*2103*/:
                int aCz3 = cVar.aCz();
                str = context.getString(R.string.xiaoying_str_free_trial_then_price_month, new Object[]{String.valueOf(aCz3), cVar.mo32756sp()});
                break;
            case 2104:
                int aCz4 = cVar.aCz();
                str = context.getString(R.string.xiaoying_str_free_trial_then_price_year, new Object[]{String.valueOf(aCz4), cVar.mo32756sp()});
                break;
            case 2105:
                str = context.getString(R.string.xiaoying_str_weekly_price_des, new Object[]{cVar.mo32756sp()});
                break;
            case 2106:
                str = context.getString(R.string.xiaoying_str_monthly_price_des, new Object[]{cVar.mo32756sp()});
                break;
            case 2107:
                str = context.getString(R.string.xiaoying_str_yearly_price_des, new Object[]{cVar.mo32756sp()});
                break;
            default:
                switch (i) {
                    case IronSourceConstants.IS_INSTANCE_SHOW /*2201*/:
                        String a = m23122a(C8081e.m23450lW(cVar.mo32757ss()), cVar);
                        if (!TextUtils.isEmpty(a)) {
                            str = context.getString(R.string.xiaoying_str_vip_price_by_day, new Object[]{a});
                            break;
                        } else {
                            return null;
                        }
                    case IronSourceConstants.IS_INSTANCE_SHOW_SUCCESS /*2202*/:
                        String a2 = m23122a(C8081e.m23451lX(cVar.mo32757ss()), cVar);
                        if (!TextUtils.isEmpty(a2)) {
                            str = context.getString(R.string.xiaoying_str_vip_price_by_week, new Object[]{a2});
                            break;
                        } else {
                            return null;
                        }
                    case IronSourceConstants.IS_INSTANCE_SHOW_FAILED /*2203*/:
                        String a3 = m23122a(C8081e.m23452lY(cVar.mo32757ss()), cVar);
                        if (!TextUtils.isEmpty(a3)) {
                            str = context.getString(R.string.xiaoying_str_vip_home_purchase_month, new Object[]{a3});
                            break;
                        } else {
                            return null;
                        }
                    case IronSourceConstants.IS_INSTANCE_CLOSED /*2204*/:
                        String a4 = m23122a(C8081e.m23453lZ(cVar.mo32757ss()), cVar);
                        if (!TextUtils.isEmpty(a4)) {
                            str = context.getString(R.string.xiaoying_str_vip_price_per_year, new Object[]{a4});
                            break;
                        } else {
                            return null;
                        }
                    case IronSourceConstants.IS_INSTANCE_INIT_SUCCESS /*2205*/:
                        String aCD = cVar.aCD();
                        if (!TextUtils.isEmpty(aCD)) {
                            str = context.getString(R.string.xiaoying_str_vip_for_first_price_week, new Object[]{aCD});
                            break;
                        } else {
                            return null;
                        }
                    case IronSourceConstants.IS_INSTANCE_INIT_FAILED /*2206*/:
                        String aCD2 = cVar.aCD();
                        if (!TextUtils.isEmpty(aCD2)) {
                            str = context.getString(R.string.xiaoying_str_vip_for_first_price_month, new Object[]{aCD2});
                            break;
                        } else {
                            return null;
                        }
                    case 2207:
                        String aCD3 = cVar.aCD();
                        if (!TextUtils.isEmpty(aCD3)) {
                            str = context.getString(R.string.xiaoying_str_vip_for_first_price_year_half, new Object[]{aCD3});
                            break;
                        } else {
                            return null;
                        }
                    case 2208:
                        String aCD4 = cVar.aCD();
                        if (!TextUtils.isEmpty(aCD4)) {
                            str = context.getString(R.string.xiaoying_str_vip_for_first_price_year, new Object[]{aCD4});
                            break;
                        } else {
                            return null;
                        }
                    case 2209:
                        if (!TextUtils.isEmpty(cVar.aCD())) {
                            str = context.getString(R.string.xiaoying_str_vip_intro_price_later_week, new Object[]{cVar.aCD(), cVar.mo32756sp()});
                            break;
                        } else {
                            return null;
                        }
                    case IronSourceConstants.IS_INSTANCE_VISIBLE /*2210*/:
                        if (!TextUtils.isEmpty(cVar.aCD())) {
                            str = context.getString(R.string.xiaoying_str_vip_intro_price_later_month, new Object[]{cVar.aCD(), cVar.mo32756sp()});
                            break;
                        } else {
                            return null;
                        }
                    case IronSourceConstants.IS_INSTANCE_READY_TRUE /*2211*/:
                        if (!TextUtils.isEmpty(cVar.aCD())) {
                            str = context.getString(R.string.xiaoying_str_vip_intro_price_later_year_half, new Object[]{cVar.aCD(), cVar.mo32756sp()});
                            break;
                        } else {
                            return null;
                        }
                    case IronSourceConstants.IS_INSTANCE_READY_FALSE /*2212*/:
                        if (!TextUtils.isEmpty(cVar.aCD())) {
                            str = context.getString(R.string.xiaoying_str_vip_intro_price_later_year, new Object[]{cVar.aCD(), cVar.mo32756sp()});
                            break;
                        } else {
                            return null;
                        }
                    case 2213:
                        str = m23133i(aVar.dSc);
                        break;
                    case 2214:
                        str = m23132g(aVar);
                        break;
                }
        }
        return str;
    }

    /* renamed from: d */
    static boolean m23129d(C7826a aVar) {
        return ((C7832c) C7738c.aEv().aNw().mo35913ri(aVar.goodsId)).aCy() == aVar.dRZ;
    }

    /* renamed from: e */
    static String m23130e(C7826a aVar) {
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(aVar.goodsId);
        if (cVar == null) {
            return null;
        }
        BigDecimal f = m23131f(aVar);
        if (f == null) {
            return null;
        }
        cVar.mo32738aM(f.longValue());
        String b = m23127b(cVar.mo32756sp(), f.divide(BigDecimal.valueOf(1000000), 2, RoundingMode.DOWN).doubleValue());
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        cVar.mo32748li(b);
        return b;
    }

    /* renamed from: f */
    private static BigDecimal m23131f(C7826a aVar) {
        if (aVar == null) {
            return null;
        }
        BigDecimal valueOf = BigDecimal.valueOf(aVar.dSc);
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(aVar.goodsId);
        if (valueOf.compareTo(BigDecimal.ZERO) <= 0 || valueOf.compareTo(BigDecimal.ONE) >= 1 || cVar == null) {
            return null;
        }
        return new BigDecimal(cVar.aCE()).divide(valueOf, 2, RoundingMode.DOWN);
    }

    /* renamed from: g */
    private static String m23132g(C7826a aVar) {
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(aVar.goodsId);
        if (cVar == null) {
            return null;
        }
        BigDecimal f = m23131f(aVar);
        if (f == null) {
            return null;
        }
        String b = m23127b(cVar.mo32756sp(), f.subtract(BigDecimal.valueOf(cVar.aCE())).divide(BigDecimal.valueOf(1000000), 2, RoundingMode.DOWN).doubleValue());
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        Context context = C8048e.aBe().getContext();
        if (context == null) {
            return null;
        }
        return context.getString(R.string.xiaoying_str_vip_save_price, new Object[]{b});
    }

    /* renamed from: i */
    private static String m23133i(double d) {
        String str;
        BigDecimal valueOf = BigDecimal.valueOf(d);
        if (valueOf.compareTo(BigDecimal.ZERO) <= 0 || valueOf.compareTo(BigDecimal.ONE) >= 1) {
            return null;
        }
        String language = Locale.getDefault().getLanguage();
        ISettingRouter iSettingRouter = (ISettingRouter) BizServiceManager.getService(ISettingRouter.class);
        if (iSettingRouter != null) {
            LocaleModel appSettedLocaleModel = iSettingRouter.getAppSettedLocaleModel(C8048e.aBe().getContext());
            if (appSettedLocaleModel != null && !TextUtils.isEmpty(appSettedLocaleModel.value) && !SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE.equalsIgnoreCase(appSettedLocaleModel.value)) {
                language = appSettedLocaleModel.value;
            }
        }
        if (TextUtils.isEmpty(language) || !language.contains("zh")) {
            String lS = C8078b.m23443lS(Double.toString(BigDecimal.ONE.subtract(valueOf).multiply(BigDecimal.valueOf(100)).setScale(0, RoundingMode.DOWN).doubleValue()));
            if (TextUtils.isEmpty(lS)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(lS);
            sb.append("% OFF");
            str = sb.toString();
        } else {
            String lS2 = C8078b.m23443lS(Double.toString(valueOf.multiply(BigDecimal.TEN).setScale(1, RoundingMode.DOWN).doubleValue()));
            if (TextUtils.isEmpty(lS2)) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(lS2);
            sb2.append("折");
            str = sb2.toString();
        }
        return str;
    }

    /* renamed from: lC */
    static C7826a m23134lC(String str) {
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(str);
        if (cVar == null) {
            return null;
        }
        if (cVar.aCy()) {
            return m23124b(cVar);
        }
        int a = m23120a(cVar);
        return (cVar.aCC() > 0 ? 1 : (cVar.aCC() == 0 ? 0 : -1)) > 0 ? m23121a(cVar, a) : m23125b(cVar, a);
    }

    /* renamed from: sE */
    private static int m23135sE(int i) {
        switch (i) {
            case 1:
                return 1201;
            case 2:
                return 1202;
            case 3:
                return IronSourceConstants.RV_INSTANCE_CLOSED;
            case 4:
                return IronSourceConstants.RV_INSTANCE_STARTED;
            default:
                return 1200;
        }
    }

    /* renamed from: sF */
    private static int m23136sF(int i) {
        switch (i) {
            case 1:
                return IronSourceConstants.IS_INSTANCE_INIT_SUCCESS;
            case 2:
                return IronSourceConstants.IS_INSTANCE_INIT_FAILED;
            case 3:
                return 2207;
            case 4:
                return 2208;
            default:
                return IronSourceConstants.IS_INSTANCE_LOAD_FAILED;
        }
    }
}
