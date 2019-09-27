package com.introvd.template.p203b;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.introvd.template.b.e */
public class C4584e {
    public static Date MAX_DATE = new Date(Long.MAX_VALUE);
    private static final SimpleDateFormat bKN = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    /* renamed from: X */
    public static String m11674X(long j) {
        return m11675a(new Date(j), "yyyy-MM-dd");
    }

    /* renamed from: a */
    public static String m11675a(Date date, String str) {
        return new SimpleDateFormat(str, Locale.US).format(date);
    }

    /* renamed from: a */
    public static boolean m11676a(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        throw new IllegalArgumentException("The dates must not be null");
    }

    /* renamed from: b */
    public static boolean m11677b(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        boolean z = false;
        if (calendar.get(0) < calendar2.get(0)) {
            return true;
        }
        if (calendar.get(0) > calendar2.get(0)) {
            return false;
        }
        if (calendar.get(1) < calendar2.get(1)) {
            return true;
        }
        if (calendar.get(1) > calendar2.get(1)) {
            return false;
        }
        if (calendar.get(6) < calendar2.get(6)) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m11678b(Date date) {
        return m11679b(date, Calendar.getInstance().getTime());
    }

    /* renamed from: b */
    public static boolean m11679b(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return m11676a(instance, instance2);
    }

    /* renamed from: c */
    public static Date m11680c(Date date) {
        if (date == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    /* renamed from: c */
    public static boolean m11681c(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return m11677b(instance, instance2);
    }

    /* renamed from: d */
    public static boolean m11682d(Date date, Date date2) {
        boolean z = false;
        if (date == null || date2 == null) {
            return false;
        }
        if (date.getTime() > date2.getTime()) {
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    public static int m11683e(Date date, Date date2) {
        return (int) (Math.abs(date.getTime() - date2.getTime()) / 86400000);
    }

    /* renamed from: eH */
    public static Date m11684eH(String str) {
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    /* renamed from: ij */
    public static String m11685ij(int i) {
        String str;
        if (i <= 0) {
            return "00:00";
        }
        int i2 = i / 60;
        if (i2 < 60) {
            int i3 = i % 60;
            StringBuilder sb = new StringBuilder();
            sb.append(m11686ik(i2));
            sb.append(":");
            sb.append(m11686ik(i3));
            str = sb.toString();
        } else {
            int i4 = i2 / 60;
            if (i4 > 99) {
                return "99:59:59";
            }
            int i5 = i2 % 60;
            int i6 = (i - (i4 * 3600)) - (i5 * 60);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m11686ik(i4));
            sb2.append(":");
            sb2.append(m11686ik(i5));
            sb2.append(":");
            sb2.append(m11686ik(i6));
            str = sb2.toString();
        }
        return str;
    }

    /* renamed from: ik */
    private static String m11686ik(int i) {
        if (i < 0 || i >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("0");
        sb2.append(Integer.toString(i));
        return sb2.toString();
    }
}
