package com.introvd.template.channel;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;

/* renamed from: com.introvd.template.channel.b */
public class C5206b {
    private static volatile String bdc;
    private static volatile String cca;
    private static volatile String ccb;

    /* renamed from: dU */
    public static String m14211dU(Context context) {
        if (cca == null) {
            cca = getMetaDataValue(context.getApplicationContext(), "XiaoYing_Channel", "");
        }
        return cca;
    }

    /* renamed from: dV */
    public static synchronized String m14212dV(Context context) {
        String str;
        synchronized (C5206b.class) {
            if (bdc == null) {
                m14215dY(context);
            }
            str = bdc;
        }
        return str;
    }

    /* renamed from: dW */
    public static synchronized String m14213dW(Context context) {
        String str;
        synchronized (C5206b.class) {
            if (ccb == null) {
                m14215dY(context);
            }
            str = ccb;
        }
        return str;
    }

    /* renamed from: dX */
    public static String m14214dX(Context context) {
        String dV = m14212dV(context);
        if (dV == null) {
            dV = "";
        }
        if (dV.length() > 7) {
            dV = dV.substring(6, dV.length());
        }
        String dW = m14213dW(context);
        StringBuilder sb = new StringBuilder();
        sb.append(dV);
        sb.append("&&");
        sb.append(dW);
        return sb.toString();
    }

    /* renamed from: dY */
    private static synchronized void m14215dY(Context context) {
        String str;
        String str2;
        synchronized (C5206b.class) {
            String dT = C5205a.m14210dT(context);
            String[] strArr = null;
            if (!TextUtils.isEmpty(dT)) {
                strArr = dT.split("&&");
            }
            if (strArr != null) {
                if (strArr.length >= 2) {
                    str = strArr[0];
                    str2 = strArr[1];
                    if (str != null && str.length() == 1) {
                        str = "01";
                    }
                    String metaDataValue = getMetaDataValue(context.getApplicationContext(), "XiaoYing_AppKey", "100000");
                    StringBuilder sb = new StringBuilder();
                    sb.append(metaDataValue);
                    sb.append(str);
                    bdc = sb.toString();
                    ccb = str2;
                }
            }
            str = getMetaDataValue(context.getApplicationContext(), "BAD_channelKey", "FF");
            str2 = getMetaDataValue(context.getApplicationContext(), "BAD_Channel", "badChannel");
            str = "01";
            String metaDataValue2 = getMetaDataValue(context.getApplicationContext(), "XiaoYing_AppKey", "100000");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(metaDataValue2);
            sb2.append(str);
            bdc = sb2.toString();
            ccb = str2;
        }
    }

    private static String getMetaDataValue(Context context, String str, String str2) {
        Object obj = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                obj = applicationInfo.metaData.get(str);
            }
        } catch (Exception unused) {
        }
        return obj == null ? str2 : String.valueOf(obj);
    }
}
