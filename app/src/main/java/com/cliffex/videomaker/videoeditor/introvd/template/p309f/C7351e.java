package com.introvd.template.p309f;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.f.e */
public class C7351e {
    private static Uri con;

    /* renamed from: a */
    public static void m21690a(ContentResolver contentResolver, int i, String str, long j, String str2, String str3, String str4, String str5, int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SocialConstDef.SNS_ACCESSTOKEN, str);
        contentValues.put("expiredtime", Long.valueOf(j));
        contentValues.put("uid", str2);
        contentValues.put("name", str3);
        contentValues.put("nickname", str4);
        contentValues.put("avatar", str5);
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put(SocialConstDef.SNS_BIND_FLAG, Integer.valueOf(i2));
        contentValues.put("updatetime", Long.valueOf(j2));
        StringBuilder sb = new StringBuilder();
        sb.append("type= ");
        sb.append(i);
        if (contentResolver.update(getTableUri(), contentValues, sb.toString(), null) == 0) {
            contentResolver.insert(getTableUri(), contentValues);
        }
    }

    /* renamed from: b */
    public static int m21691b(ContentResolver contentResolver, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("type= ");
        sb.append(i);
        return contentResolver.delete(getTableUri(), sb.toString(), null);
    }

    private static Uri getTableUri() {
        if (con == null) {
            synchronized (C7351e.class) {
                if (con == null) {
                    con = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SNS);
                }
            }
        }
        return con;
    }

    /* renamed from: h */
    public static Cursor m21692h(ContentResolver contentResolver, String str) {
        return contentResolver.query(getTableUri(), new String[]{"uid", SocialConstDef.SNS_ACCESSTOKEN}, "type = ?", new String[]{str}, null);
    }
}
