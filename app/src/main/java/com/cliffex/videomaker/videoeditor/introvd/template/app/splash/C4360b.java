package com.introvd.template.app.splash;

import android.text.TextUtils;
import com.p131c.p132a.p135c.C2575a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.introvd.template.app.splash.b */
public final class C4360b {
    private static String TIME_FORMAT = "yyyyMMddHHmmss";
    private static SimpleDateFormat bEx = new SimpleDateFormat(TIME_FORMAT, Locale.US);

    /* renamed from: Qi */
    static long m10948Qi() {
        return C2575a.parseLong(bEx.format(new Date()));
    }

    /* renamed from: d */
    static long m10949d(String str, long j) {
        return TextUtils.isEmpty(str) ? j : C2575a.parseLong(str);
    }

    /* renamed from: ec */
    static boolean m10950ec(String str) {
        return m10948Qi() <= m10949d(str, Long.MIN_VALUE);
    }

    /* renamed from: ed */
    static boolean m10951ed(String str) {
        return m10948Qi() >= m10949d(str, Long.MAX_VALUE);
    }

    /* renamed from: ee */
    public static Date m10952ee(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return bEx.parse(str);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
