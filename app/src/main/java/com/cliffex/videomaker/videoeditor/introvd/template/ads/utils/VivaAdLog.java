package com.introvd.template.ads.utils;

import android.util.Log;

public final class VivaAdLog {
    private static boolean bhd;

    /* renamed from: GA */
    private static boolean m8845GA() {
        return bhd;
    }

    /* renamed from: d */
    public static void m8846d(String str, String str2) {
        if (m8845GA()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("");
            Log.d(str, sb.toString());
        }
    }

    /* renamed from: e */
    public static void m8847e(String str, String str2) {
        if (m8845GA()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("");
            Log.e(str, sb.toString());
        }
    }

    public static void setCanOutputLog(boolean z) {
        bhd = z;
    }
}
