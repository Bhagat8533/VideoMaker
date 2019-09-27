package com.introvd.template.module.p326ad.p334h.p335a.p336a;

import android.content.ContentValues;
import android.database.Cursor;
import com.introvd.template.module.p326ad.p334h.p335a.C7655a;

/* renamed from: com.introvd.template.module.ad.h.a.a.b */
public class C7660b {
    /* renamed from: b */
    static ContentValues m22481b(C7655a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("res_id", aVar.aAB());
        contentValues.put("unlock_time", Long.valueOf(aVar.aAC()));
        contentValues.put("valid_duration", Integer.valueOf(aVar.aAD()));
        contentValues.put("encourage_type", Integer.valueOf(aVar.aAE()));
        return contentValues;
    }

    /* renamed from: k */
    static C7655a m22482k(Cursor cursor) {
        C7655a aVar = new C7655a(cursor.getString(cursor.getColumnIndexOrThrow("res_id")), cursor.getLong(cursor.getColumnIndexOrThrow("unlock_time")), cursor.getInt(cursor.getColumnIndexOrThrow("valid_duration")), cursor.getInt(cursor.getColumnIndexOrThrow("encourage_type")));
        return aVar;
    }
}
