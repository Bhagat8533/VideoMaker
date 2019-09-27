package com.introvd.template.template.p409g;

import android.content.Context;
import android.net.Uri;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.template.g.a */
public class C8758a {
    private static Uri etO;

    /* renamed from: cN */
    public static void m25583cN(Context context, String str) {
        if (context != null) {
            try {
                context.getContentResolver().delete(getTableUri(), "local = ? ", new String[]{str});
            } catch (Exception unused) {
            }
        }
    }

    private static Uri getTableUri() {
        if (etO == null) {
            synchronized (C8758a.class) {
                if (etO == null) {
                    etO = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_DOWNLOAD);
                }
            }
        }
        return etO;
    }
}
