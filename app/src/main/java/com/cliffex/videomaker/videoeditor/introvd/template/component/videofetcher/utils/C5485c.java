package com.introvd.template.component.videofetcher.utils;

import java.util.regex.PatternSyntaxException;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.component.videofetcher.utils.c */
public class C5485c {
    private static long bKD;
    private static long bKE;
    private static final char[] cdx = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: Sf */
    public static boolean m14890Sf() {
        return m14893ig(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    /* renamed from: bM */
    public static boolean m14891bM(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = (long) i2;
        boolean z = bKE == j;
        if (Math.abs(currentTimeMillis - bKD) < ((long) i) && z) {
            return true;
        }
        bKD = currentTimeMillis;
        bKE = j;
        return false;
    }

    /* renamed from: fM */
    public static String m14892fM(String str) {
        try {
            return str.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\"\" \"\"]", "v").trim();
        } catch (PatternSyntaxException unused) {
            return str.trim();
        }
    }

    /* renamed from: ig */
    public static boolean m14893ig(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - bKD) < ((long) i)) {
            return true;
        }
        bKD = currentTimeMillis;
        return false;
    }

    public static String replaceAll(String str) {
        try {
            return str.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\"\" \"\"]", "-").trim();
        } catch (PatternSyntaxException unused) {
            return str.trim();
        }
    }
}
