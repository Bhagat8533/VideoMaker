package com.introvd.template.p317h;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.h.b */
public class C7514b {
    private static Uri cqY = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SOCIAL_ACCOUNT);

    /* renamed from: a */
    public static Uri m22230a(ContentResolver contentResolver, int i, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("uid", str);
        contentValues.put("name", str2);
        contentValues.put("path", str3);
        return contentResolver.insert(cqY, contentValues);
    }

    /* renamed from: b */
    public static String m22231b(ContentResolver contentResolver, String str, String str2) {
        String[] strArr;
        String str3;
        String str4 = "";
        String[] strArr2 = {"path"};
        if (!TextUtils.isEmpty(str2)) {
            strArr = new String[]{str2};
            str3 = "type = ?";
        } else if (str == null) {
            return str4;
        } else {
            strArr = new String[]{str};
            str3 = "uid = ?";
        }
        Cursor query = contentResolver.query(cqY, strArr2, str3, strArr, null);
        if (query != null) {
            if (query.moveToFirst()) {
                str4 = query.getString(0);
            }
            query.close();
        }
        return str4;
    }

    /* renamed from: m */
    public static String m22232m(ContentResolver contentResolver, String str) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(cqY, null, "type = ?", new String[]{str}, null);
        String str2 = null;
        if (query != null) {
            if (query.moveToNext()) {
                str2 = query.getString(query.getColumnIndex("uid"));
            }
            query.close();
        }
        return str2;
    }

    /* renamed from: n */
    public static int m22233n(ContentResolver contentResolver, String str) {
        return contentResolver.delete(cqY, "type = ?", new String[]{str});
    }
}
