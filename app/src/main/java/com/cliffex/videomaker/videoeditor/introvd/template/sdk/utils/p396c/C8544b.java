package com.introvd.template.sdk.utils.p396c;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.introvd.template.sdk.utils.c.b */
public class C8544b extends C8543a {
    private String eiU = "locN ";

    public C8544b(String str, Locale locale) {
        super(str, locale);
    }

    /* renamed from: a */
    private static String m24983a(String str, Locale locale) {
        return str;
    }

    /* renamed from: a */
    private String m24984a(String str, Locale locale, Date date) {
        if (TextUtils.isEmpty(str) || date == null) {
            return null;
        }
        return (locale == null ? new SimpleDateFormat(str) : new SimpleDateFormat(str, locale)).format(date);
    }

    public String format(Object obj) {
        Date date = null;
        if (this.eiS == null) {
            return null;
        }
        int indexOf = this.eiS.indexOf(this.eiU);
        if (-1 == indexOf) {
            if (obj instanceof Date) {
                date = (Date) obj;
            }
            return m24984a(this.eiS, this.eiT, date);
        } else if (indexOf == 0) {
            return m24983a(m24984a(this.eiS.substring(this.eiU.length()), this.eiT, null), this.eiT);
        } else {
            return null;
        }
    }
}
