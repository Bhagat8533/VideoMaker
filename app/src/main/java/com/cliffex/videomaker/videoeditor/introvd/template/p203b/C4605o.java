package com.introvd.template.p203b;

import android.net.Uri;
import android.text.TextUtils;

/* renamed from: com.introvd.template.b.o */
public class C4605o {
    public static String getHost(String str) {
        return TextUtils.isEmpty(str) ? "" : Uri.parse(str).getHost();
    }
}
