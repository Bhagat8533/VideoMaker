package com.introvd.template.sdk.utils;

import java.util.Calendar;
import java.util.Date;

/* renamed from: com.introvd.template.sdk.utils.c */
public class C8542c {
    /* renamed from: a */
    public static boolean m24981a(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        throw new IllegalArgumentException("The dates must not be null");
    }

    /* renamed from: b */
    public static boolean m24982b(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return m24981a(instance, instance2);
    }
}
