package com.introvd.template.xyui;

import java.util.Locale;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.xyui.c */
public class C9163c {
    /* renamed from: kg */
    public static String m26664kg(int i) {
        String str;
        String str2 = "";
        if (i < 0) {
            i = 0;
        }
        int i2 = (i + HttpStatus.SC_INTERNAL_SERVER_ERROR) / 1000;
        if (i2 >= 3600) {
            try {
                str = String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Integer.valueOf(i2 / 3600), Integer.valueOf((i2 % 3600) / 60), Integer.valueOf(i2 % 60)});
            } catch (Exception unused) {
            }
        } else {
            str = String.format(Locale.US, "%2d:%02d", new Object[]{Integer.valueOf((i2 % 3600) / 60), Integer.valueOf(i2 % 60)});
        }
        str2 = str;
        return str2.trim();
    }
}
