package com.introvd.template.module.iap.business.p352b;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.introvd.template.ads.utils.VivaAdLog;
import com.introvd.template.common.LogUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.iap.C8045d;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.coupon.C7858e;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.router.iap.IapServiceProxy;
import com.introvd.template.router.user.UserServiceProxy;
import com.ironsource.mediationsdk.utils.ServerResponseWrapper;
import com.ironsource.sdk.controller.BannerJSAdapter;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.b.b */
public class C7835b {
    private static boolean dSj;

    /* renamed from: com.introvd.template.module.iap.business.b.b$a */
    private static class C7837a {
        String key;
        String value;

        private C7837a() {
        }
    }

    /* renamed from: D */
    public static void m22841D(boolean z, boolean z2) {
        String str = z ? z2 ? "direct_buy" : "vip_membership" : null;
        String str2 = "VIP_exit_dialog_click";
        C7837a[] aVarArr = new C7837a[2];
        aVarArr[0] = m22850aD("type", z ? "buy" : "exit");
        aVarArr[1] = m22850aD("intent", str);
        m22845a(str2, aVarArr);
    }

    /* renamed from: a */
    private static void m22842a(String str, int i, String str2, String str3, String str4) {
        String str5;
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(m22864lt(str));
        hashMap.put("type", sb.toString());
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        hashMap.put("media_source", str3);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(SocialConstDef.TEMPLATE_ID, str4);
        }
        String c = C7897a.m23024c("Iap_Domestic_Todo_Code", new String[0]);
        if (!TextUtils.isEmpty(c)) {
            hashMap.put(SocialConstDef.MESSAGE_TODO_CODE, c);
        }
        String str6 = null;
        if (i == 0) {
            str5 = "Subscription_Purchased_Android_Success";
        } else if (i == 1) {
            str5 = "Subscription_Purchased_Android_Cancel";
            str6 = BannerJSAdapter.FAIL;
        } else {
            str5 = "Subscription_Purchased_Android_Fail";
            str6 = "cancel";
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(str6, String.valueOf(i));
        }
        m22856i(str5, hashMap);
    }

    /* renamed from: a */
    public static void m22843a(String str, List<String> list, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", str);
        hashMap.put("server_valid", String.valueOf(list));
        hashMap.put("local_valid", C8045d.aAZ().aBd().toString());
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str2);
        C8048e.aBe().mo23653g("Subscription_Purchase_Valid_Server", hashMap);
        VivaAdLog.m8847e("Subscription_Purchase_Valid_Server", hashMap.toString());
    }

    /* renamed from: a */
    public static void m22844a(String str, boolean z, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str);
        hashMap.put(IapServiceProxy.isVip, z ? "1" : "0");
        hashMap.put("result", String.valueOf(i));
        C8048e.aBe().mo23653g("Subscription_Restore_Click", hashMap);
    }

    /* renamed from: a */
    private static void m22845a(String str, C7837a... aVarArr) {
        HashMap hashMap;
        if (aVarArr == null || aVarArr.length == 0) {
            hashMap = null;
        } else {
            hashMap = new HashMap(aVarArr.length);
            for (C7837a aVar : aVarArr) {
                hashMap.put(aVar.key, aVar.value);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("reportEvent  ");
            sb.append(str);
            sb.append("   ");
            sb.append(hashMap.toString());
            LogUtils.m14222e("IAPUserBehaviorLog ", sb.toString());
        }
        C8048e.aBe().mo23653g(str, hashMap);
    }

    /* renamed from: a */
    public static void m22846a(boolean z, String str, String str2, int i, String str3) {
        HashMap hashMap = new HashMap();
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(m22864lt(str));
            str2 = sb.toString();
            hashMap.put("success", str2);
        } else {
            hashMap.put("failed_or_cancel", str2);
        }
        String c = C7897a.m23024c("Iap_Non_Organic_Flag", new String[0]);
        hashMap.put("media_source", c);
        if ("Non_Organic".equals(c)) {
            m22860l(z, str2);
        }
        String string = C7899c.aDg().getString("key_enter_vip_source", "home vip");
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, string);
        if ("tip".equals(string)) {
            m22859k(z, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("templateId", str3);
        }
        m22856i("Subscription_Purchased_Android", hashMap);
        C8048e.aBe().mo23646dC("Subscription_Purchased_Android");
        m22842a(str, i, string, c, str3);
    }

    /* renamed from: aA */
    public static void m22847aA(String str, String str2) {
        String string = C7899c.aDg().getString("key_enter_vip_source", "home vip");
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, string);
        String str3 = "Subscription_Platinum_Enter";
        hashMap.put(Param.COUPON, C7858e.isEmpty() ? "否" : "是");
        hashMap.put(SocialConstDef.MESSAGE_TODO_CODE, C7897a.m23024c("Iap_Domestic_Todo_Code", new String[0]));
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("templateId", str2);
        }
        m22856i(str3, hashMap);
    }

    /* renamed from: aB */
    public static void m22848aB(String str, String str2) {
        HashMap hashMap = new HashMap();
        if ("Purchased_users_Dialog_Show".equals(str)) {
            hashMap.put("show", "show");
        } else {
            hashMap.put("which", str2);
        }
        m22856i(str, hashMap);
    }

    /* renamed from: aC */
    public static void m22849aC(String str, String str2) {
        m22845a("VIP_exit_dialog_show", m22850aD("frequency", str), m22850aD("time", str2));
    }

    public static void aCM() {
        C8048e.aBe().mo23653g("Subscription_GP_AccountHold_Banner_Show", new HashMap());
    }

    public static void aCN() {
        C8048e.aBe().mo23653g("Subscription_GP_AccountHold_Banner_Click", new HashMap());
    }

    public static boolean aCO() {
        return dSj;
    }

    public static void aCP() {
        HashMap hashMap = new HashMap();
        hashMap.put(ServerResponseWrapper.USER_ID_FIELD, String.valueOf(UserServiceProxy.getUserId()));
        hashMap.put("deviceId", String.valueOf(C8048e.aBe().mo23620Ml()));
        C8048e.aBe().mo23653g("dev_event_domestic_iap_crack", hashMap);
    }

    public static void aCQ() {
        C8048e.aBe().mo23653g("Subscription_NonOrganic_NewUserTip_Show", new HashMap());
    }

    public static void aCR() {
        boolean z = true;
        if (!C8072q.aBx().isVip()) {
            if (!C8072q.aBx().mo33070i(C7825a.GOLD_MONTHLY.getId(), C7825a.GOLD_YEARLY.getId())) {
                z = false;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "yes" : "no");
        C8048e.aBe().mo23653g("Vip_Member", hashMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void aCS() {
        /*
            com.introvd.template.module.iap.p r0 = com.introvd.template.module.iap.C8072q.aBx()
            boolean r0 = r0.isVip()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x002c
            com.introvd.template.module.iap.p r0 = com.introvd.template.module.iap.C8072q.aBx()
            java.lang.String[] r4 = new java.lang.String[r1]
            com.introvd.template.module.iap.business.a.a r5 = com.introvd.template.module.iap.business.p349a.C7825a.GOLD_MONTHLY
            java.lang.String r5 = r5.getId()
            r4[r3] = r5
            com.introvd.template.module.iap.business.a.a r5 = com.introvd.template.module.iap.business.p349a.C7825a.GOLD_YEARLY
            java.lang.String r5 = r5.getId()
            r4[r2] = r5
            boolean r0 = r0.mo33070i(r4)
            if (r0 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r0 = 0
            goto L_0x002d
        L_0x002c:
            r0 = 1
        L_0x002d:
            java.lang.String r4 = "iap_restore_click"
            java.lang.String[] r5 = new java.lang.String[r3]
            java.lang.String r4 = com.introvd.template.module.iap.business.p356e.C7897a.m23024c(r4, r5)
            java.lang.String r5 = "VIP_verify_result"
            com.introvd.template.module.iap.business.b.b$a[] r1 = new com.introvd.template.module.iap.business.p352b.C7835b.C7837a[r1]
            java.lang.String r6 = "result"
            if (r0 == 0) goto L_0x0040
            java.lang.String r0 = "是"
            goto L_0x0042
        L_0x0040:
            java.lang.String r0 = "否"
        L_0x0042:
            com.introvd.template.module.iap.business.b.b$a r0 = m22850aD(r6, r0)
            r1[r3] = r0
            java.lang.String r0 = "type"
            java.lang.String r6 = "click"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0055
            java.lang.String r4 = "restore"
            goto L_0x0057
        L_0x0055:
            java.lang.String r4 = "系统验证"
        L_0x0057:
            com.introvd.template.module.iap.business.b.b$a r0 = m22850aD(r0, r4)
            r1[r2] = r0
            m22845a(r5, r1)
            java.lang.String r0 = "iap_restore_click"
            java.lang.String[] r1 = new java.lang.String[r3]
            com.introvd.template.module.iap.business.p356e.C7897a.m23026f(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.module.iap.business.p352b.C7835b.aCS():void");
    }

    /* renamed from: aD */
    private static C7837a m22850aD(String str, String str2) {
        C7837a aVar = new C7837a();
        aVar.key = str;
        aVar.value = str2;
        return aVar;
    }

    /* renamed from: az */
    public static void m22851az(String str, String str2) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(m22864lt(str));
        String sb2 = sb.toString();
        hashMap.put("type", sb2);
        String string = C7899c.aDg().getString("key_enter_vip_source", "home vip");
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, string);
        String c = C7897a.m23024c("Iap_Non_Organic_Flag", new String[0]);
        hashMap.put("media_source", c);
        if ("Non_Organic".equals(c)) {
            m22865lu(sb2);
        }
        if ("tip".equals(string)) {
            m22862lr(sb2);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("templateId", str2);
        }
        m22856i("Subscription_Btn_Click_Android", hashMap);
    }

    /* renamed from: b */
    public static void m22852b(String str, boolean z, int i) {
        if (C8048e.aBe().isInChina()) {
            HashMap hashMap = new HashMap();
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str);
            hashMap.put("before", z ? "1" : "0");
            hashMap.put("after", i == 1 ? "1" : "0");
            C8048e.aBe().mo23653g("Subscription_Restore_Login", hashMap);
            VivaAdLog.m8847e("Subscription_Restore_Login", hashMap.toString());
        }
    }

    /* renamed from: ca */
    public static void m22853ca(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        C8048e.aBe().mo23653g("IAP_Tips_Click", hashMap);
    }

    /* renamed from: ds */
    public static void m22854ds(int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        hashMap.put("paymentState", String.valueOf(i2));
        C8048e.aBe().mo23653g("Subscription_GP_Notification_Receive", hashMap);
    }

    /* renamed from: dt */
    public static void m22855dt(int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", String.valueOf(i));
        hashMap.put("SurveyResult", String.valueOf(i2));
        C8048e.aBe().mo23653g("Subscription_GP_Cancel_Reason", hashMap);
    }

    /* renamed from: i */
    private static void m22856i(String str, HashMap<String, String> hashMap) {
        C8048e.aBe().mo23653g(str, hashMap);
    }

    /* renamed from: iH */
    public static void m22857iH(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("server_data", z ? "yes" : "no");
        m22856i("Dev_iap_home_dialog_purchase_click", hashMap);
    }

    /* renamed from: iI */
    public static void m22858iI(boolean z) {
        dSj = z;
    }

    /* renamed from: k */
    public static void m22859k(boolean z, String str) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("success", str);
        } else {
            hashMap.put("failed_or_cancel", str);
        }
        hashMap.put(SocialConstDef.MIXED_PAGE_PAGETYPE, "recordKeyEnterVipSource");
        m22856i("Subscription_Organic_Purchased", hashMap);
    }

    /* renamed from: l */
    public static void m22860l(boolean z, String str) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("success", str);
        } else {
            hashMap.put("failed_or_cancel", str);
        }
        hashMap.put(SocialConstDef.SNSCONFIG_ITEM_PAGETYPE, "新用户首页弹窗");
        C8048e.aBe().mo23653g("Subscription_NonOrganic_Purchased", hashMap);
    }

    /* renamed from: lq */
    public static void m22861lq(String str) {
        if (!TextUtils.isEmpty(str)) {
            C7899c.aDg().setString("key_enter_vip_source", str);
            C7897a.m23022b(str, C7898b.dSW, new String[0]);
        }
    }

    /* renamed from: lr */
    public static void m22862lr(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put(SocialConstDef.MIXED_PAGE_PAGETYPE, "recordKeyEnterVipSource");
        m22856i("Subscription_Organic_Btn_Click", hashMap);
    }

    /* renamed from: ls */
    public static void m22863ls(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        m22856i("Remote_Config_Apply", hashMap);
    }

    /* renamed from: lt */
    private static String m22864lt(String str) {
        String str2;
        C7832c kw = C8045d.aAZ().mo33074kw(str);
        int aCz = kw != null ? kw.aCz() : 0;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        if (aCz > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("free trial ");
            sb2.append(aCz);
            sb2.append(" days");
            str2 = sb2.toString();
        } else {
            str2 = "not";
        }
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: lu */
    public static void m22865lu(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put(SocialConstDef.SNSCONFIG_ITEM_PAGETYPE, "新用户首页弹窗");
        C8048e.aBe().mo23653g("Subscription_NonOrganic_Btn_Click", hashMap);
    }

    /* renamed from: p */
    public static void m22866p(String str, String str2, String str3) {
        m22845a("Exit_Purchase_Pop_imp", m22850aD("popID", str), m22850aD("title", str2), m22850aD("frequency", str3));
    }

    /* renamed from: q */
    public static void m22867q(String str, String str2, String str3) {
        m22845a("Exit_Purchase_Pop_click", m22850aD("popID", str), m22850aD("title", str2), m22850aD("frequency", str3));
    }

    /* renamed from: u */
    public static void m22868u(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("purchase_button", z ? "show" : "hide");
        m22856i("platinum".equals(str) ? "Subscription_Platinum_Exit" : "Subscription_Gold_Exit", hashMap);
    }

    /* renamed from: v */
    public static void m22869v(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("period", String.valueOf(i));
        hashMap.put(PlaceFields.PAGE, str);
        C8048e.aBe().mo23653g("Subscription_AutoTrigger_Show", hashMap);
    }
}
