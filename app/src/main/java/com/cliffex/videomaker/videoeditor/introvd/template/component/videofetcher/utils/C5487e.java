package com.introvd.template.component.videofetcher.utils;

import java.util.Locale;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.component.videofetcher.utils.e */
public class C5487e {
    /* renamed from: kf */
    public static String m14896kf(int i) {
        int i2 = i / 1000;
        int i3 = i2 / 3600;
        int i4 = (i2 % 3600) / 60;
        int i5 = i2 % 60;
        String valueOf = String.valueOf(i3);
        if (i3 < 10) {
            StringBuilder sb = new StringBuilder();
            sb.append("0");
            sb.append(valueOf);
            valueOf = sb.toString();
        }
        String valueOf2 = String.valueOf(i4);
        if (i4 < 10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(valueOf2);
            valueOf2 = sb2.toString();
        }
        String valueOf3 = String.valueOf(i5);
        if (i5 < 10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(valueOf3);
            valueOf3 = sb3.toString();
        }
        if (i3 < 1) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(valueOf2);
            sb4.append(":");
            sb4.append(valueOf3);
            return sb4.toString();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(valueOf);
        sb5.append(":");
        sb5.append(valueOf2);
        sb5.append(":");
        sb5.append(valueOf3);
        return sb5.toString();
    }

    /* renamed from: kg */
    public static String m14897kg(int i) {
        String str;
        String str2 = "";
        if (i < 0) {
            i = 0;
        }
        int i2 = (i + HttpStatus.SC_INTERNAL_SERVER_ERROR) / 1000;
        if (i2 >= 3600) {
            try {
                str = String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Integer.valueOf(i2 / 3600), Integer.valueOf((i2 % 3600) / 60), Integer.valueOf(i2 % 60)});
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            str = String.format(Locale.US, "%2d:%02d", new Object[]{Integer.valueOf((i2 % 3600) / 60), Integer.valueOf(i2 % 60)});
        }
        str2 = str;
        return str2.trim();
    }
}
