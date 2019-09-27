package com.introvd.template.videoeditor.p416a;

import android.content.res.Resources;
import java.util.Locale;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.videoeditor.a.a */
public class C9006a {
    private int ctm = 0;
    private int mDuration = 0;
    private Resources mResources;

    public C9006a(Resources resources, int i, int i2) {
        this.mResources = resources;
        this.mDuration = i;
        this.ctm = i2;
    }

    /* renamed from: a */
    private static String m26423a(int i, Resources resources) {
        String str;
        if (i < 0) {
            i = 0;
        }
        int i2 = i / 1000;
        String string = resources.getString(C10122R.string.xiaoying_str_com_second_unit);
        if (i2 >= 60) {
            int i3 = i2 % 60;
            if (i3 == 0) {
                String string2 = resources.getString(C10122R.string.xiaoying_str_com_minute_unit);
                Locale locale = Locale.US;
                StringBuilder sb = new StringBuilder();
                sb.append("%d");
                sb.append(string2);
                str = String.format(locale, sb.toString(), new Object[]{Integer.valueOf(i2 / 60)});
            } else {
                String string3 = resources.getString(C10122R.string.xiaoying_str_com_minutes_unit);
                Locale locale2 = Locale.US;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("%d");
                sb2.append(string3);
                String format = String.format(locale2, sb2.toString(), new Object[]{Integer.valueOf(i2 / 60)});
                StringBuilder sb3 = new StringBuilder();
                sb3.append(format);
                Locale locale3 = Locale.US;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("%d");
                sb4.append(string);
                sb3.append(String.format(locale3, sb4.toString(), new Object[]{Integer.valueOf(i3)}));
                str = sb3.toString();
            }
        } else {
            Locale locale4 = Locale.US;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("%d");
            sb5.append(string);
            str = String.format(locale4, sb5.toString(), new Object[]{Integer.valueOf(i2)});
        }
        return str.trim();
    }

    public boolean aNp() {
        return this.mDuration > this.ctm;
    }

    public String aNq() {
        if (this.mResources != null) {
            return m26423a(this.ctm, this.mResources);
        }
        return null;
    }
}
