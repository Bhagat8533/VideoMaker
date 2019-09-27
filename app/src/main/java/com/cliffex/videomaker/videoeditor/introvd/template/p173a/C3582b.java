package com.introvd.template.p173a;

import android.content.Context;
import android.content.Intent;
import com.introvd.template.crash.C5523b;

/* renamed from: com.introvd.template.a.b */
public class C3582b {
    /* renamed from: k */
    public static void m8808k(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                context.startService(intent);
            } catch (Exception e) {
                C5523b.logException(e);
            }
        }
    }
}
