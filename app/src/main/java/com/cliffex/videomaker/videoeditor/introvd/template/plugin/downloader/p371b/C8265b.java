package com.introvd.template.plugin.downloader.p371b;

import android.content.ContentValues;
import android.database.Cursor;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.plugin.downloader.entity.C8313b;
import com.introvd.template.plugin.downloader.entity.C8317e;
import com.introvd.template.plugin.downloader.entity.DownloadStatus;
import java.util.Date;

/* renamed from: com.introvd.template.plugin.downloader.b.b */
class C8265b {
    /* renamed from: a */
    static ContentValues m23841a(DownloadStatus downloadStatus) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_chunked", Boolean.valueOf(downloadStatus.eav));
        contentValues.put("download_size", Long.valueOf(downloadStatus.aGk()));
        contentValues.put(SocialConstDef.DOWNLOAD_TOTAL, Long.valueOf(downloadStatus.aaZ()));
        return contentValues;
    }

    /* renamed from: b */
    static ContentValues m23842b(C8313b bVar, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", bVar.getUrl());
        contentValues.put("save_name", bVar.aGf());
        contentValues.put("save_path", bVar.aGg());
        contentValues.put("download_flag", Integer.valueOf(i));
        contentValues.put("date", Long.valueOf(new Date().getTime()));
        return contentValues;
    }

    /* renamed from: c */
    static ContentValues m23843c(String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("save_name", str);
        contentValues.put("save_path", str2);
        contentValues.put("download_flag", Integer.valueOf(i));
        return contentValues;
    }

    /* renamed from: l */
    static DownloadStatus m23844l(Cursor cursor) {
        DownloadStatus downloadStatus = new DownloadStatus(cursor.getInt(cursor.getColumnIndexOrThrow("is_chunked")) > 0, cursor.getLong(cursor.getColumnIndexOrThrow("download_size")), cursor.getLong(cursor.getColumnIndexOrThrow(SocialConstDef.DOWNLOAD_TOTAL)));
        return downloadStatus;
    }

    /* renamed from: m */
    static C8317e m23845m(Cursor cursor) {
        C8317e eVar = new C8317e();
        eVar.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        eVar.setUrl(cursor.getString(cursor.getColumnIndexOrThrow("url")));
        eVar.mo33537nk(cursor.getString(cursor.getColumnIndexOrThrow("save_name")));
        eVar.mo33538nl(cursor.getString(cursor.getColumnIndexOrThrow("save_path")));
        DownloadStatus downloadStatus = new DownloadStatus(cursor.getInt(cursor.getColumnIndexOrThrow("is_chunked")) > 0, cursor.getLong(cursor.getColumnIndexOrThrow("download_size")), cursor.getLong(cursor.getColumnIndexOrThrow(SocialConstDef.DOWNLOAD_TOTAL)));
        eVar.mo33535c(downloadStatus);
        eVar.setFlag(cursor.getInt(cursor.getColumnIndexOrThrow("download_flag")));
        eVar.setDate(cursor.getLong(cursor.getColumnIndexOrThrow("date")));
        return eVar;
    }

    /* renamed from: to */
    static ContentValues m23846to(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_flag", Integer.valueOf(i));
        return contentValues;
    }
}
