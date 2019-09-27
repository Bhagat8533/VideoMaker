package com.introvd.template.p317h;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;

/* renamed from: com.introvd.template.h.a */
public class C7513a {
    private static final Uri cqX = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_GENERAL_APP);

    /* renamed from: a */
    public static void m22227a(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", str2);
        if (contentResolver.update(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_GENERAL_APP), contentValues, "key = ?", new String[]{str}) == 0) {
            contentValues.put("key", str);
            contentResolver.insert(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_GENERAL_APP), contentValues);
        }
    }

    /* renamed from: eo */
    public static String m22228eo(Context context) {
        return m22229l(context.getContentResolver(), SocialServiceDef.XIAOYING_CURRENT_ACCOUNT);
    }

    /* renamed from: l */
    public static String m22229l(ContentResolver contentResolver, String str) {
        String str2 = "";
        try {
            Cursor query = contentResolver.query(cqX, new String[]{"value"}, "key = ?", new String[]{str}, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    str2 = query.getString(0);
                }
                query.close();
            }
        } catch (Exception unused) {
        }
        return str2;
    }
}
