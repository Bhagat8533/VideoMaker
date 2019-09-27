package com.introvd.template.plugin.downloader.p373d;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.introvd.template.plugin.downloader.d.g */
public class C8310g {
    /* renamed from: aU */
    public static String m23985aU(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }

    /* renamed from: ns */
    public static long m23986ns(String str) throws ParseException {
        if (TextUtils.isEmpty(str)) {
            return new Date().getTime();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.parse(str).getTime();
    }
}
