package com.introvd.template.module.p326ad.p334h;

import android.annotation.SuppressLint;
import com.introvd.template.module.p326ad.C7678j;
import com.vivavideo.mobile.component.sharedpref.C9324b;
import com.vivavideo.mobile.component.sharedpref.C9327e;

@SuppressLint({"ApplySharedPref"})
/* renamed from: com.introvd.template.module.ad.h.c */
public class C7662c {
    private static C9324b bEy = C9327e.m27033ag(C7678j.aAd().getContext(), "iap_ad_module", "iap_module");
    private static C7662c dNv = new C7662c();

    private C7662c() {
    }

    public static C7662c aAA() {
        return dNv;
    }

    public boolean getBoolean(String str, boolean z) {
        return bEy.getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return bEy.getString(str, str2);
    }

    public void setBoolean(String str, boolean z) {
        bEy.setBoolean(str, z);
    }

    public void setString(String str, String str2) {
        bEy.setString(str, str2);
    }
}
