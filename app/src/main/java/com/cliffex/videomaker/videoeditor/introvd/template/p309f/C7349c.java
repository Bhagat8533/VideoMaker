package com.introvd.template.p309f;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.f.c */
public class C7349c {
    private static Uri TABLE_PUBLISH;

    /* renamed from: c */
    public static void m21685c(ContentResolver contentResolver) {
        contentResolver.delete(getTableUri(), null, null);
    }

    /* renamed from: e */
    public static void m21686e(ContentResolver contentResolver, String str) {
        contentResolver.delete(getTableUri(), "_id = ? ", new String[]{str});
    }

    /* renamed from: f */
    public static Cursor m21687f(ContentResolver contentResolver, String str) {
        String[] strArr = {SocialConstDef.PUBLISH_VIDEO_THUMB_LOCAL_BIG, SocialConstDef.PUBLISH_VIDEO_POSTER_LOCAL_URL, SocialConstDef.PUBLISH_VIDEO_LOCAL_URL};
        return contentResolver.query(getTableUri(), strArr, "_id = ?", new String[]{str}, null);
    }

    /* renamed from: g */
    public static Cursor m21688g(ContentResolver contentResolver, String str) {
        String[] strArr = {SocialConstDef.PUBLISH_VIDEO_THUMB_LOCAL_URL, SocialConstDef.PUBLISH_VIDEO_THUMB_LOCAL_BIG, SocialConstDef.PUBLISH_VIDEO_POSTER_LOCAL_URL};
        return contentResolver.query(getTableUri(), strArr, "_id = ?", new String[]{str}, null);
    }

    private static Uri getTableUri() {
        if (TABLE_PUBLISH == null) {
            synchronized (C7349c.class) {
                if (TABLE_PUBLISH == null) {
                    TABLE_PUBLISH = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_PUBLISH);
                }
            }
        }
        return TABLE_PUBLISH;
    }
}
