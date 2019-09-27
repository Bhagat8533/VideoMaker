package com.introvd.template.plugin.downloader.p373d;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* renamed from: com.introvd.template.plugin.downloader.d.e */
public class C8304e {
    private static boolean DEBUG;

    /* renamed from: f */
    public static void m23974f(String str, Object... objArr) {
        log(String.format(Locale.getDefault(), str, objArr));
    }

    public static void log(String str) {
        if (!TextUtils.isEmpty(str) && DEBUG) {
            Log.i("RxDownload", str);
        }
    }

    /* renamed from: v */
    public static void m23975v(Throwable th) {
        Log.w("RxDownload", th);
    }
}
