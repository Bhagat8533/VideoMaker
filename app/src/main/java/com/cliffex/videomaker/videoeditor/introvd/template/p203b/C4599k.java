package com.introvd.template.p203b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.ironsource.environment.ConnectivityService;

/* renamed from: com.introvd.template.b.k */
public class C4599k {
    /* renamed from: dL */
    public static String m11733dL(Context context) {
        String str = "unknow";
        if (!m11735dN(context)) {
            return "disconect";
        }
        switch (m11734dM(context)) {
            case 0:
                str = ConnectivityService.NETWORK_TYPE_WIFI;
                break;
            case 1:
                str = "2G";
                break;
            case 2:
                str = "3G";
                break;
            case 3:
                str = "4G";
                break;
        }
        return str;
    }

    /* renamed from: dM */
    public static int m11734dM(Context context) {
        if (context == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 0) {
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 1;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 2;
                case 13:
                    return 3;
            }
        }
        return -1;
    }

    /* renamed from: dN */
    public static boolean m11735dN(Context context) {
        boolean z = false;
        if (context != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getState() == State.CONNECTED) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: dO */
    public static boolean m11736dO(Context context) {
        boolean z = false;
        if (context != null) {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isAvailable()) {
                if (networkInfo.getState() == State.CONNECTED) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }
}
