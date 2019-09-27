package com.introvd.template.p309f;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.f.f */
public class C7352f {
    private static Uri coo;

    /* renamed from: a */
    public static int m21693a(ContentResolver contentResolver, String str, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i2;
        String str2 = "_id= ?";
        String[] strArr = {str};
        Uri tableUri = getTableUri();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SocialConstDef.TASK_SUB_TYPE, Integer.valueOf(i));
        contentValues.put("state", Integer.valueOf(i2));
        if (i3 != -1) {
            contentValues.put(SocialConstDef.TASK_SUB_STATE, Integer.valueOf(i3));
        }
        if (i6 == 196608) {
            Cursor query = contentResolver.query(tableUri, new String[]{SocialConstDef.TASK_PROGRESS_1, SocialConstDef.TASK_PROGRESS_2}, str2, new String[]{str}, null);
            if (query != null) {
                if (query.moveToNext()) {
                    i5 = query.getInt(0);
                    i4 = query.getInt(1);
                } else {
                    i5 = 0;
                    i4 = 0;
                }
                query.close();
            } else {
                i5 = 0;
                i4 = 0;
            }
            if (i5 == i4) {
                contentValues.put(SocialConstDef.TASK_PROGRESS_1, Integer.valueOf(0));
                contentValues.put(SocialConstDef.TASK_PROGRESS_2, Integer.valueOf(0));
            }
        } else if (i6 == 131072) {
            contentValues.put(SocialConstDef.TASK_PROGRESS_1, Integer.valueOf(100));
            contentValues.put(SocialConstDef.TASK_PROGRESS_2, Integer.valueOf(100));
        }
        ContentResolver contentResolver2 = contentResolver;
        return contentResolver.update(tableUri, contentValues, str2, strArr);
    }

    /* renamed from: a */
    public static void m21694a(ContentResolver contentResolver, String str, int i) {
        String[] strArr = null;
        String str2 = str != null ? "_id= ?" : null;
        if (str != null) {
            strArr = new String[]{str};
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(i));
        contentResolver.update(getTableUri(), contentValues, str2, strArr);
    }

    /* renamed from: a */
    public static void m21695a(ContentResolver contentResolver, String str, long j, long j2) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str};
        contentValues.put(SocialConstDef.TASK_PROGRESS_1, Long.valueOf(j));
        contentValues.put(SocialConstDef.TASK_PROGRESS_2, Long.valueOf(j2));
        contentResolver.update(getTableUri(), contentValues, "_id = ?", strArr);
    }

    /* renamed from: a */
    public static void m21696a(ContentResolver contentResolver, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("( state=196608");
        sb.append(" OR state=0");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(" OR state=262144");
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb4);
        sb5.append(" OR state=65536 )");
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(sb6);
        sb7.append(" AND main_type=2");
        String sb8 = sb7.toString();
        StringBuilder sb9 = new StringBuilder();
        sb9.append(sb8);
        sb9.append(" AND sub_type <> 100");
        String sb10 = sb9.toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(z ? 327680 : 262144));
        contentResolver.update(getTableUri(), contentValues, sb10, null);
    }

    /* renamed from: b */
    public static void m21697b(ContentResolver contentResolver, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("state=196608");
        sb.append(" OR state=0");
        String sb2 = sb.toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(z ? 327680 : 262144));
        contentResolver.update(getTableUri(), contentValues, sb2, null);
    }

    /* renamed from: c */
    public static void m21698c(ContentResolver contentResolver) {
        contentResolver.delete(getTableUri(), null, null);
    }

    /* renamed from: d */
    public static void m21699d(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(0));
        contentResolver.update(getTableUri(), contentValues, "state=262144 OR state=65536", null);
    }

    /* renamed from: e */
    public static Cursor m21700e(ContentResolver contentResolver) {
        StringBuilder sb = new StringBuilder();
        sb.append("state=196608");
        sb.append(" OR state=0");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(" OR (sub_type <> 100 AND state = 131072)");
        return contentResolver.query(getTableUri(), new String[]{"_id"}, sb3.toString(), null, null);
    }

    /* renamed from: f */
    public static Cursor m21701f(ContentResolver contentResolver) {
        StringBuilder sb = new StringBuilder();
        sb.append("state=196608");
        sb.append(" OR (sub_type <> 100 AND state = 131072)");
        return contentResolver.query(getTableUri(), new String[]{"_id"}, sb.toString(), null, null);
    }

    /* renamed from: g */
    public static Cursor m21702g(ContentResolver contentResolver) {
        StringBuilder sb = new StringBuilder();
        sb.append("( state=0");
        sb.append(" OR state=262144");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(" )");
        return contentResolver.query(getTableUri(), new String[]{"_id", SocialConstDef.TASK_SUB_STATE, SocialConstDef.TASK_MAIN_TYPE}, sb3.toString(), null, SocialConstDef.TASK_STARTTIME);
    }

    private static Uri getTableUri() {
        if (coo == null) {
            synchronized (C7352f.class) {
                if (coo == null) {
                    coo = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TASK);
                }
            }
        }
        return coo;
    }

    /* renamed from: i */
    public static void m21703i(ContentResolver contentResolver, String str) {
        String[] strArr = {str};
        contentResolver.delete(getTableUri(), "_id= ?", strArr);
    }

    /* renamed from: j */
    public static Cursor m21704j(ContentResolver contentResolver, String str) {
        String[] strArr = {SocialConstDef.TASK_USER_DATA};
        return contentResolver.query(getTableUri(), strArr, "_id = ?", new String[]{str}, null);
    }

    /* renamed from: k */
    public static Cursor m21705k(ContentResolver contentResolver, String str) {
        String[] strArr = {SocialConstDef.TASK_MAIN_TYPE, SocialConstDef.TASK_USER_DATA};
        return contentResolver.query(getTableUri(), strArr, "_id= ?", new String[]{str}, SocialConstDef.TASK_STARTTIME);
    }
}
