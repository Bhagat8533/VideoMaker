package com.introvd.template.p374q;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.introvd.template.datacenter.SocialServiceDef;
import com.xiaoying.p448a.C9561c;
import org.json.JSONObject;

/* renamed from: com.introvd.template.q.e */
public class C8346e {
    private static C8346e ejc;
    private static int ejd;

    /* renamed from: T */
    public static void m24071T(Context context, String str, String str2) {
        Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
        intent.putExtra("social_method", SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGES);
        intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_TYPE, str);
        intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_P1, str2);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* renamed from: U */
    public static void m24072U(Context context, String str, String str2) {
        Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
        intent.putExtra("social_method", SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ITEM_INFO);
        intent.putExtra("tcid", str);
        intent.putExtra("ttid", str2);
        intent.putExtra("version", aKe());
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* renamed from: a */
    public static void m24073a(Context context, String str, Boolean bool, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
            intent.putExtra("social_method", SocialServiceDef.SOCIAL_PASSTHROUGH_METHOD_HTTP_REQUEST);
            intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_TYPE, bool.booleanValue() ? 1 : 0);
            intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_P1, str);
            if (bundle != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str2 : bundle.keySet()) {
                        jSONObject.put(str2, bundle.get(str2));
                    }
                } catch (Throwable unused) {
                }
                intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_P2, jSONObject.toString());
            }
            intent.setPackage(context.getPackageName());
            C9561c.m27511k(context, intent);
        }
    }

    public static C8346e aKd() {
        if (ejc == null) {
            ejc = new C8346e();
        }
        return ejc;
    }

    private static String aKe() {
        return String.valueOf(ejd);
    }

    /* renamed from: c */
    public static void m24074c(Context context, String str, int i, String str2) {
        Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
        intent.putExtra("social_method", SocialServiceDef.SOCIAL_MISC_METHOD_CRASHLOG);
        intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_P1, str);
        intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_P2, i);
        intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_P3, str2);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* renamed from: cq */
    public static void m24075cq(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
            intent.putExtra("social_method", SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGE_DETAIL);
            intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_TYPE, str);
            intent.putExtra("version", aKe());
            intent.setPackage(context.getPackageName());
            C9561c.m27511k(context, intent);
        }
    }

    /* renamed from: cr */
    public static void m24076cr(Context context, String str) {
        if (!TextUtils.isDigitsOnly(str)) {
            Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
            intent.putExtra("social_method", SocialServiceDef.SOCIAL_MISC_METHOD_REPORT_APP_LIST_INFO);
            intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_P1, str);
            intent.setPackage(context.getPackageName());
            C9561c.m27511k(context, intent);
        }
    }

    /* renamed from: d */
    public static void m24077d(Context context, int i, String str, String str2) {
        Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
        intent.putExtra("social_method", SocialServiceDef.SOCIAL_MISC_METHOD_BANNER_PAGE);
        intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_TYPE, i);
        intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_P1, str);
        intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_P2, str2);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* renamed from: l */
    public static void m24078l(Context context, long j) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        defaultSharedPreferences.edit().putLong("PatchCheckTime", j).apply();
    }

    /* renamed from: uB */
    public static void m24079uB(int i) {
        ejd = i;
    }

    /* renamed from: S */
    public void mo33599S(Context context, String str, String str2) {
        Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
        intent.putExtra("social_method", SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ROLL_DETAIL);
        intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_TYPE, str);
        intent.putExtra("version", aKe());
        intent.putExtra(SocialServiceDef.EXTRAS_REQUEST_P1, str2);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }
}
