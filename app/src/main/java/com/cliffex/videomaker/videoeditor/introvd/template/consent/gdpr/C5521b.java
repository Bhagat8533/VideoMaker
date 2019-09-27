package com.introvd.template.consent.gdpr;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/* renamed from: com.introvd.template.consent.gdpr.b */
public final class C5521b {
    private static String cnz;
    @SuppressLint({"StaticFieldLeak"})
    private static Context context;

    /* renamed from: a */
    public static void m14956a(Application application) {
        m14957a(application, null);
    }

    /* renamed from: a */
    public static void m14957a(Application application, String str) {
        if (application == null || application.getApplicationContext() == null) {
            throw new IllegalArgumentException("Application and Application Context can't be null.");
        }
        context = application.getApplicationContext();
        cnz = str;
    }

    public static boolean aaL() {
        return C5520a.aaK().mo27240d(context, m14960fS(cnz), false);
    }

    public static void aaM() {
        C5520a.aaK().mo27239c(context, m14960fS(cnz), false);
    }

    public static void aaN() {
        C5520a.aaK().mo27239c(context, m14960fS(cnz), true);
    }

    /* renamed from: dG */
    public static void m14958dG(boolean z) {
        C5520a.aaK().mo27239c(context, m14961fT(cnz), z);
    }

    /* renamed from: dH */
    public static boolean m14959dH(boolean z) {
        return C5520a.aaK().mo27240d(context, m14961fT(cnz), z);
    }

    /* renamed from: fS */
    private static String m14960fS(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("user_consent_");
        sb.append(context.getPackageName());
        String sb2 = sb.toString();
        if (str == null) {
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(str);
        return sb3.toString();
    }

    /* renamed from: fT */
    private static String m14961fT(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m14960fS(str));
        sb.append("_boolean_helper");
        return sb.toString();
    }
}
