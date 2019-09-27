package com.introvd.template.p203b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.util.Locale;

/* renamed from: com.introvd.template.b.j */
public class C4598j {
    /* renamed from: SA */
    public static boolean m11730SA() {
        String Si = C4580b.m11635Si();
        return !TextUtils.isEmpty(Si) && Si.startsWith("zh_CN");
    }

    /* renamed from: a */
    public static void m11731a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        if (VERSION.SDK_INT >= 24) {
            context.getApplicationContext().createConfigurationContext(configuration);
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    /* renamed from: eK */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Locale m11732eK(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            switch(r0) {
                case -372468771: goto L_0x00d1;
                case -372468770: goto L_0x00c7;
                case 3121: goto L_0x00bc;
                case 3201: goto L_0x00b2;
                case 3241: goto L_0x00a8;
                case 3246: goto L_0x009d;
                case 3259: goto L_0x0092;
                case 3276: goto L_0x0088;
                case 3329: goto L_0x007d;
                case 3355: goto L_0x0072;
                case 3371: goto L_0x0067;
                case 3383: goto L_0x005c;
                case 3428: goto L_0x0051;
                case 3494: goto L_0x0045;
                case 3588: goto L_0x0039;
                case 3651: goto L_0x002d;
                case 3700: goto L_0x0021;
                case 3710: goto L_0x0015;
                case 3763: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00db
        L_0x0009:
            java.lang.String r0 = "vi"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 11
            goto L_0x00dc
        L_0x0015:
            java.lang.String r0 = "tr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 10
            goto L_0x00dc
        L_0x0021:
            java.lang.String r0 = "th"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 14
            goto L_0x00dc
        L_0x002d:
            java.lang.String r0 = "ru"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 12
            goto L_0x00dc
        L_0x0039:
            java.lang.String r0 = "pt"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 15
            goto L_0x00dc
        L_0x0045:
            java.lang.String r0 = "ms"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 17
            goto L_0x00dc
        L_0x0051:
            java.lang.String r0 = "ko"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 6
            goto L_0x00dc
        L_0x005c:
            java.lang.String r0 = "ja"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 3
            goto L_0x00dc
        L_0x0067:
            java.lang.String r0 = "it"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 5
            goto L_0x00dc
        L_0x0072:
            java.lang.String r0 = "id"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 13
            goto L_0x00dc
        L_0x007d:
            java.lang.String r0 = "hi"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 16
            goto L_0x00dc
        L_0x0088:
            java.lang.String r0 = "fr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 7
            goto L_0x00dc
        L_0x0092:
            java.lang.String r0 = "fa"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 9
            goto L_0x00dc
        L_0x009d:
            java.lang.String r0 = "es"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 18
            goto L_0x00dc
        L_0x00a8:
            java.lang.String r0 = "en"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 2
            goto L_0x00dc
        L_0x00b2:
            java.lang.String r0 = "de"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 4
            goto L_0x00dc
        L_0x00bc:
            java.lang.String r0 = "ar"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 8
            goto L_0x00dc
        L_0x00c7:
            java.lang.String r0 = "zh-Hant"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 1
            goto L_0x00dc
        L_0x00d1:
            java.lang.String r0 = "zh-Hans"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00db
            r0 = 0
            goto L_0x00dc
        L_0x00db:
            r0 = -1
        L_0x00dc:
            switch(r0) {
                case 0: goto L_0x0151;
                case 1: goto L_0x014e;
                case 2: goto L_0x014b;
                case 3: goto L_0x0148;
                case 4: goto L_0x0145;
                case 5: goto L_0x0142;
                case 6: goto L_0x013f;
                case 7: goto L_0x013c;
                case 8: goto L_0x0134;
                case 9: goto L_0x012c;
                case 10: goto L_0x0124;
                case 11: goto L_0x011c;
                case 12: goto L_0x0114;
                case 13: goto L_0x010c;
                case 14: goto L_0x0104;
                case 15: goto L_0x00fc;
                case 16: goto L_0x00f4;
                case 17: goto L_0x00ec;
                case 18: goto L_0x00e4;
                default: goto L_0x00df;
            }
        L_0x00df:
            java.util.Locale r2 = java.util.Locale.getDefault()
            return r2
        L_0x00e4:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "ES"
            r0.<init>(r2, r1)
            return r0
        L_0x00ec:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "MY"
            r0.<init>(r2, r1)
            return r0
        L_0x00f4:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "IN"
            r0.<init>(r2, r1)
            return r0
        L_0x00fc:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "BR"
            r0.<init>(r2, r1)
            return r0
        L_0x0104:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "TH"
            r0.<init>(r2, r1)
            return r0
        L_0x010c:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "ID"
            r0.<init>(r2, r1)
            return r0
        L_0x0114:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "RU"
            r0.<init>(r2, r1)
            return r0
        L_0x011c:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "VN"
            r0.<init>(r2, r1)
            return r0
        L_0x0124:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "TR"
            r0.<init>(r2, r1)
            return r0
        L_0x012c:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "IR"
            r0.<init>(r2, r1)
            return r0
        L_0x0134:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "SA"
            r0.<init>(r2, r1)
            return r0
        L_0x013c:
            java.util.Locale r2 = java.util.Locale.FRANCE
            return r2
        L_0x013f:
            java.util.Locale r2 = java.util.Locale.KOREA
            return r2
        L_0x0142:
            java.util.Locale r2 = java.util.Locale.ITALY
            return r2
        L_0x0145:
            java.util.Locale r2 = java.util.Locale.GERMANY
            return r2
        L_0x0148:
            java.util.Locale r2 = java.util.Locale.JAPAN
            return r2
        L_0x014b:
            java.util.Locale r2 = java.util.Locale.US
            return r2
        L_0x014e:
            java.util.Locale r2 = java.util.Locale.TRADITIONAL_CHINESE
            return r2
        L_0x0151:
            java.util.Locale r2 = java.util.Locale.SIMPLIFIED_CHINESE
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p203b.C4598j.m11732eK(java.lang.String):java.util.Locale");
    }
}
