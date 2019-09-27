package com.introvd.template.component.videofetcher.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;

/* renamed from: com.introvd.template.component.videofetcher.utils.g */
public class C5489g {
    public static boolean PERFORMANCE_LOG_OPEN = true;
    public static HashMap<String, Long> mTimeStamp = new HashMap<>();
    public static int mlogLevel = 31;

    /* renamed from: d */
    public static void m14902d(String str, String str2) {
        if ((mlogLevel & 8) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            printFullLog(8, "XiaoYing", sb.toString());
        }
    }

    /* renamed from: e */
    public static void m14903e(String str, String str2) {
        if ((mlogLevel & 1) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            printFullLog(1, "XiaoYing", sb.toString());
        }
    }

    /* renamed from: i */
    public static void m14904i(String str, String str2) {
        if ((mlogLevel & 4) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            printFullLog(4, "XiaoYing", sb.toString());
        }
    }

    /* renamed from: k */
    private static void m14905k(int i, String str, String str2) {
        if (i == 1) {
            Log.e(str, str2);
        } else if (i == 2) {
            Log.w(str, str2);
        } else if (i == 4) {
            Log.i(str, str2);
        } else if (i == 8) {
            Log.d(str, str2);
        } else {
            Log.v(str, str2);
        }
    }

    public static void printFullLog(int i, String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.length() <= 3800) {
            m14905k(i, str, str2);
            return;
        }
        int length = (str2.length() / 3800) + 1;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == length - 1) {
                String substring = str2.substring(i2 * 3800, str2.length());
                StringBuilder sb = new StringBuilder();
                sb.append(" O(>_<)o <--- ");
                sb.append(substring);
                m14905k(i, str, sb.toString());
            } else if (i2 == 0) {
                String substring2 = str2.substring(0, (i2 + 1) * 3800);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(substring2);
                sb2.append(" ---> o(>_<)O ");
                m14905k(i, str, sb2.toString());
            } else {
                String substring3 = str2.substring(i2 * 3800, (i2 + 1) * 3800);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" O(>_<)o <--- ");
                sb3.append(substring3);
                sb3.append(" ---> o(>_<)O ");
                m14905k(i, str, sb3.toString());
            }
        }
    }
}
