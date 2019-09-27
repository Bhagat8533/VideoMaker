package com.introvd.template.consent.gdpr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

@SuppressLint({"ApplySharedPref"})
/* renamed from: com.introvd.template.consent.gdpr.a */
public class C5520a {
    private static C5520a cny = new C5520a();

    private C5520a() {
    }

    public static C5520a aaK() {
        return cny;
    }

    /* renamed from: en */
    private SharedPreferences m14953en(Context context) {
        return context.getSharedPreferences("UserConsent", 0);
    }

    /* renamed from: c */
    public void mo27239c(Context context, String str, boolean z) {
        m14953en(context).edit().putBoolean(str, z).commit();
    }

    /* renamed from: d */
    public boolean mo27240d(Context context, String str, boolean z) {
        return m14953en(context).getBoolean(str, z);
    }
}
