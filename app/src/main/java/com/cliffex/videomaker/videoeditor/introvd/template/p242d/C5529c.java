package com.introvd.template.p242d;

import android.content.Context;

/* renamed from: com.introvd.template.d.c */
public class C5529c {
    /* renamed from: aA */
    public static boolean m14971aA(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        if (str.equals("android.media.action.VIDEO_CAPTURE")) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".");
        sb.append("android.media.action.VIDEO_CAPTURE");
        return str.equals(sb.toString());
    }

    /* renamed from: ax */
    public static boolean m14972ax(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        if (str.equals("android.intent.action.SEND_MULTIPLE")) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".");
        sb.append("android.intent.action.SEND_MULTIPLE");
        return str.equals(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005e, code lost:
        if (r5.equals(r1.toString()) != false) goto L_0x0060;
     */
    /* renamed from: ay */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m14973ay(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0063
            if (r5 != 0) goto L_0x0006
            goto L_0x0063
        L_0x0006:
            java.lang.String r1 = "android.intent.action.SEND"
            boolean r1 = r5.equals(r1)
            r2 = 1
            if (r1 != 0) goto L_0x0062
            java.lang.String r1 = "android.intent.action.VIEW"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0062
            java.lang.String r1 = "android.intent.action.EDIT"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0020
            goto L_0x0062
        L_0x0020:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r4.getPackageName()
            r1.append(r3)
            java.lang.String r3 = "."
            r1.append(r3)
            java.lang.String r3 = "android.intent.action.SEND"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0060
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = r4.getPackageName()
            r1.append(r4)
            java.lang.String r4 = "."
            r1.append(r4)
            java.lang.String r4 = "android.intent.action.VIEW"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0061
        L_0x0060:
            r0 = 1
        L_0x0061:
            return r0
        L_0x0062:
            return r2
        L_0x0063:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p242d.C5529c.m14973ay(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: az */
    public static boolean m14974az(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".");
        sb.append("android.intent.action.EDIT");
        return str.equals(sb.toString());
    }

    /* renamed from: km */
    public static boolean m14975km(int i) {
        switch (i) {
            case 1000:
            case 1001:
            case 1002:
                return true;
            default:
                return false;
        }
    }
}
