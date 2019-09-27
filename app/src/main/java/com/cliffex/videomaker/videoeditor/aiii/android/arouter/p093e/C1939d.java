package com.aiii.android.arouter.p093e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.aiii.android.arouter.p091c.C1919a;

/* renamed from: com.aiii.android.arouter.e.d */
public class C1939d {
    private static String aub;
    private static int auc;

    /* renamed from: J */
    public static boolean m5574J(Context context) {
        PackageInfo L = m5576L(context);
        if (L == null) {
            return true;
        }
        String str = L.versionName;
        int i = L.versionCode;
        SharedPreferences sharedPreferences = context.getSharedPreferences("SP_AROUTER_CACHE", 0);
        if (str.equals(sharedPreferences.getString("LAST_VERSION_NAME", null)) && i == sharedPreferences.getInt("LAST_VERSION_CODE", -1)) {
            return false;
        }
        aub = str;
        auc = i;
        return true;
    }

    /* renamed from: K */
    public static void m5575K(Context context) {
        if (!TextUtils.isEmpty(aub) && auc != 0) {
            context.getSharedPreferences("SP_AROUTER_CACHE", 0).edit().putString("LAST_VERSION_NAME", aub).putInt("LAST_VERSION_CODE", auc).apply();
        }
    }

    /* renamed from: L */
    private static PackageInfo m5576L(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception unused) {
            C1919a.atC.mo10380k("ARouter::", "Get package info error.");
            return null;
        }
    }
}
