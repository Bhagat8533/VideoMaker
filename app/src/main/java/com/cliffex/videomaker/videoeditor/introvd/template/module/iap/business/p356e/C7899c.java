package com.introvd.template.module.iap.business.p356e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.introvd.template.module.iap.C8048e;
import com.vivavideo.mobile.component.sharedpref.C9324b;
import com.vivavideo.mobile.component.sharedpref.C9327e;

@SuppressLint({"ApplySharedPref"})
/* renamed from: com.introvd.template.module.iap.business.e.c */
public class C7899c {
    private static C9324b bEy = C9327e.m27035cS(C8048e.aBe().getContext(), "iap_module");
    private static C7899c dTb = new C7899c();

    private C7899c() {
    }

    public static C7899c aDg() {
        return dTb;
    }

    public boolean getBoolean(String str, boolean z) {
        return bEy.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        return bEy.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return bEy.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return bEy.getString(str, str2);
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            bEy.remove(str);
        }
    }

    public void setBoolean(String str, boolean z) {
        bEy.setBoolean(str, z);
    }

    public void setInt(String str, int i) {
        bEy.setInt(str, i);
    }

    public void setLong(String str, long j) {
        bEy.setLong(str, j);
    }

    public void setString(String str, String str2) {
        bEy.setString(str, str2);
    }
}
