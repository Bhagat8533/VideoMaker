package com.introvd.template.module.iap.business.p352b;

import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.coupon.C7858e;
import com.introvd.template.module.iap.business.exchange.C7916c;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.utils.C8079c;
import com.introvd.template.router.iap.IapServiceProxy;
import com.introvd.template.router.user.UserServiceProxy;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.HashMap;

/* renamed from: com.introvd.template.module.iap.business.b.a */
public class C7834a {
    /* renamed from: a */
    public static void m22832a(String str, String str2, boolean z, String str3, String str4, String str5) {
        String c = C7897a.m23024c(C7898b.dSX, new String[0]);
        String c2 = C7897a.m23024c(C7898b.dSW, new String[0]);
        if (z) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            hashMap.put("price", str2);
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, c2);
            hashMap.put(PlaceFields.PAGE, c);
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("templateId", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                hashMap.put(Param.COUPON, str5);
            }
            if ("todoCode".equalsIgnoreCase(c2)) {
                hashMap.put(SocialConstDef.MESSAGE_TODO_CODE, C7897a.m23024c("Iap_Domestic_Todo_Code", new String[0]));
            }
            C8048e.aBe().mo23653g("Domestic_Subscription_Purchased", hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("price", str2);
            C8048e.aBe().mo23653g("__cust_event_1", hashMap2);
        }
        if ("会员页".equals(c)) {
            m22838m(str, str2, str3, str4);
        }
        HashMap hashMap3 = new HashMap();
        String str6 = "result";
        if (z) {
            str3 = "success";
        }
        hashMap3.put(str6, str3);
        C8048e.aBe().mo23653g("Domestic_Subscription_Result", hashMap3);
    }

    public static void aCL() {
        String c = C7897a.m23024c(C7898b.dSW, new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("isVIP", isVip() ? "1" : "0");
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, c);
        hashMap.put(Event.LOGIN, UserServiceProxy.isLogin() ? "是" : "否");
        hashMap.put(Param.COUPON, C7858e.isEmpty() ? "否" : "是");
        if ("todoCode".equalsIgnoreCase(c)) {
            hashMap.put(SocialConstDef.MESSAGE_TODO_CODE, C7897a.m23024c("Iap_Domestic_Todo_Code", new String[0]));
        }
        C7897a.m23022b(c, C7898b.dSW, new String[0]);
        C8048e.aBe().mo23653g("VIP_MembershipPage_Enter", hashMap);
    }

    /* renamed from: ax */
    public static void m22833ax(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("BannerID", str);
        hashMap.put(IapServiceProxy.isVip, isVip() ? "是" : "否");
        hashMap.put("name", str2);
        C8048e.aBe().mo23653g("Domestic_VIPMemberPage_banner_click", hashMap);
    }

    /* renamed from: ay */
    public static void m22834ay(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("BannerID", str);
        hashMap.put(IapServiceProxy.isVip, isVip() ? "是" : "否");
        hashMap.put("name", str2);
        C8048e.aBe().mo23653g("Domestic_VIPMemberPage_banner_imp", hashMap);
    }

    private static boolean isVip() {
        return C8072q.aBx().isVip();
    }

    /* renamed from: j */
    public static void m22835j(boolean z, String str) {
        HashMap hashMap = new HashMap();
        String c = C7897a.m23024c(C7898b.dSX, new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(z ? "_success" : "_fail");
        String sb2 = sb.toString();
        hashMap.put("result", sb2);
        if (TextUtils.isEmpty(str)) {
            str = C7897a.m23027g(C7898b.dSY, new String[0]);
        }
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(str);
        String str2 = "unknown";
        if (cVar != null) {
            str2 = cVar.mo32756sp();
        }
        hashMap.put("which", str);
        hashMap.put("price", str2);
        String c2 = C7897a.m23024c(C7898b.dSW, new String[0]);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, c2);
        if ("todoCode".equalsIgnoreCase(c2)) {
            hashMap.put(SocialConstDef.MESSAGE_TODO_CODE, C7897a.m23024c("Iap_Domestic_Todo_Code", new String[0]));
        }
        String c3 = C7897a.m23024c("Iap_Purchase_Template_Id", new String[0]);
        if (!TextUtils.isEmpty(c3)) {
            hashMap.put("templateId", c3);
        }
        C8048e.aBe().mo23653g("Domestic_Subscription_query_result_new", hashMap);
        if (z) {
            C8048e.aBe().mo23653g("Domestic_Subscription_query_success", hashMap);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("price", str2);
        hashMap2.put("result", sb2);
        C8048e.aBe().mo23653g("__cust_event_2", hashMap2);
    }

    /* renamed from: l */
    public static void m22836l(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        hashMap.put("price", str2);
        hashMap.put(PlaceFields.PAGE, C7897a.m23024c(C7898b.dSX, new String[0]));
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("templateId", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(Param.COUPON, str4);
        }
        if (C8048e.aBe().isInChina()) {
            hashMap.put("payChannel", C7897a.m23027g(C7898b.dTa, new String[0]));
        }
        String c = C7897a.m23024c(C7898b.dSW, new String[0]);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, c);
        if ("todoCode".equalsIgnoreCase(c)) {
            hashMap.put(SocialConstDef.MESSAGE_TODO_CODE, C7897a.m23024c("Iap_Domestic_Todo_Code", new String[0]));
        }
        C8048e.aBe().mo23653g("Domestic_Subscription_Btn_Click", hashMap);
        C7835b.m22851az(str, C7897a.m23024c("Iap_Purchase_Template_Id", new String[0]));
    }

    /* renamed from: lp */
    public static void m22837lp(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("button", str);
        C8048e.aBe().mo23653g("Unsubscribe_Alipay_Pop", hashMap);
    }

    /* renamed from: m */
    public static void m22838m(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("days", C8079c.m23446lU(str));
        hashMap.put("price", str2);
        hashMap.put("result", str3);
        hashMap.put("which", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, C7897a.m23024c(C7898b.dSW, new String[0]));
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("templateId", str4);
        }
        C8048e.aBe().mo23653g("Domestic_VIP_MembershipPage_Purchase", hashMap);
    }

    /* renamed from: o */
    public static void m22839o(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(AdUnitActivity.EXTRA_ACTIVITY_ID, str);
        hashMap.put("couponId", str2);
        hashMap.put("button", str3);
        C8048e.aBe().mo23653g("Domestic_coupon_pop_click", hashMap);
    }

    /* renamed from: sx */
    public static void m22840sx(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVIP", isVip() ? "1" : "0");
        hashMap.put("days", String.valueOf(C7916c.aCW().mo32880sz(i)));
        String str = "";
        if (i == 3) {
            str = "Exchange_Privilege_Click";
        } else if (i == 2) {
            str = "Exchange_Coin_Click";
        }
        if (!TextUtils.isEmpty(str)) {
            C8048e.aBe().mo23653g(str, hashMap);
        }
    }
}
