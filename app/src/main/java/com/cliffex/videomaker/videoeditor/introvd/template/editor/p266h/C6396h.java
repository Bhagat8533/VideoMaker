package com.introvd.template.editor.p266h;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;

/* renamed from: com.introvd.template.editor.h.h */
public class C6396h {
    private static Context dkJ;

    /* renamed from: ac */
    public static String m18391ac(Context context, int i) {
        if (context == null || i <= 0) {
            return null;
        }
        if (dkJ == null) {
            dkJ = m18392b(context, Locale.CHINESE);
        }
        if (dkJ != null) {
            return dkJ.getResources().getString(i);
        }
        return null;
    }

    /* renamed from: b */
    private static Context m18392b(Context context, Locale locale) {
        Context createConfigurationContext = context.getApplicationContext().createConfigurationContext(context.getResources().getConfiguration());
        Resources resources = createConfigurationContext.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, null);
        return createConfigurationContext;
    }
}
