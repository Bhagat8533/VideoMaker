package com.introvd.template.p309f;

import android.content.ContentResolver;
import android.net.Uri;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.f.b */
public class C7348b {

    /* renamed from: com reason: collision with root package name */
    private static Uri f6182com;

    /* renamed from: c */
    public static void m21684c(ContentResolver contentResolver) {
        contentResolver.delete(getTableUri(), null, null);
    }

    private static Uri getTableUri() {
        if (f6182com == null) {
            synchronized (C7348b.class) {
                if (f6182com == null) {
                    f6182com = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_INSIDE_DB_BACKUP);
                }
            }
        }
        return f6182com;
    }
}
