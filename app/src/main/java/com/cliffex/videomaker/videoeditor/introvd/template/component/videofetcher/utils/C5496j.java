package com.introvd.template.component.videofetcher.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Locale;

/* renamed from: com.introvd.template.component.videofetcher.utils.j */
public class C5496j {
    public static boolean isNetworkAvaliable(Context context) {
        return isNetworkAvaliable(context, null);
    }

    public static boolean isNetworkAvaliable(Context context, StringBuilder sb) {
        boolean z;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            z = activeNetworkInfo.isConnected();
            if (z && sb != null) {
                try {
                    String typeName = activeNetworkInfo.getTypeName();
                    if (typeName != null) {
                        sb.append(typeName.toUpperCase(Locale.ENGLISH));
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return z;
                }
            }
            return z;
        } catch (Exception e2) {
            e = e2;
            z = false;
            e.printStackTrace();
            return z;
        }
    }
}
