package com.introvd.template.plugin.downloader.p371b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.introvd.template.plugin.downloader.entity.C8313b;
import com.introvd.template.plugin.downloader.entity.DownloadStatus;
import com.introvd.template.plugin.downloader.p373d.C8304e;

/* renamed from: com.introvd.template.plugin.downloader.b.a */
public class C8263a {
    private static volatile C8263a eal;
    private final Object dNA = new Object();
    private volatile SQLiteDatabase dNC;
    private C8264a eam;
    private volatile SQLiteDatabase ean;

    /* renamed from: com.introvd.template.plugin.downloader.b.a$a */
    private static class C8264a extends SQLiteOpenHelper {
        C8264a(Context context) {
            super(context, "quvideo_xiaoying_download.db", null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("CREATE TABLE download_record (id INTEGER PRIMARY KEY AUTOINCREMENT,url TEXT NOT NULL,save_name TEXT,save_path TEXT,total_size INTEGER,download_size INTEGER,is_chunked INTEGER,download_flag INTEGER,date INTEGER NOT NULL  )");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append(e.getMessage());
                sb.append("");
                C8304e.log(sb.toString());
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
            sQLiteDatabase.endTransaction();
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private C8263a(Context context) {
        this.eam = new C8264a(context);
    }

    /* renamed from: gJ */
    public static C8263a m23832gJ(Context context) {
        if (eal == null) {
            synchronized (C8263a.class) {
                if (eal == null) {
                    eal = new C8263a(context);
                }
            }
        }
        return eal;
    }

    private SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase = this.dNC;
        if (sQLiteDatabase == null) {
            synchronized (this.dNA) {
                sQLiteDatabase = this.dNC;
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = this.eam.getReadableDatabase();
                    this.dNC = sQLiteDatabase;
                }
            }
        }
        return sQLiteDatabase;
    }

    private SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase = this.ean;
        if (sQLiteDatabase == null) {
            synchronized (this.dNA) {
                sQLiteDatabase = this.ean;
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = this.eam.getWritableDatabase();
                    this.ean = sQLiteDatabase;
                }
            }
        }
        return sQLiteDatabase;
    }

    /* renamed from: F */
    public long mo33418F(String str, int i) {
        return (long) getWritableDatabase().update("download_record", C8265b.m23846to(i), "url=?", new String[]{str});
    }

    /* renamed from: a */
    public long mo33419a(C8313b bVar, int i) {
        return getWritableDatabase().insert("download_record", null, C8265b.m23842b(bVar, i));
    }

    /* renamed from: a */
    public long mo33420a(String str, String str2, String str3, int i) {
        return (long) getWritableDatabase().update("download_record", C8265b.m23843c(str2, str3, i), "url=?", new String[]{str});
    }

    public long aGc() {
        return (long) getWritableDatabase().update("download_record", C8265b.m23846to(9993), "download_flag=? or download_flag=?", new String[]{"9991", "9992"});
    }

    public void aGd() {
        synchronized (this.dNA) {
            this.dNC = null;
            this.ean = null;
            this.eam.close();
        }
    }

    /* renamed from: e */
    public long mo33423e(String str, DownloadStatus downloadStatus) {
        return (long) getWritableDatabase().update("download_record", C8265b.m23841a(downloadStatus), "url=?", new String[]{str});
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* renamed from: ng */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo33424ng(java.lang.String r13) {
        /*
            r12 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r12.getReadableDatabase()     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = "download_record"
            java.lang.String r3 = "id"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ all -> 0x0032 }
            java.lang.String r4 = "url=?"
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ all -> 0x0032 }
            r10 = 0
            r5[r10] = r13     // Catch:{ all -> 0x0032 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r13 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0032 }
            r13.moveToFirst()     // Catch:{ all -> 0x002d }
            int r0 = r13.getCount()     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r9 = 0
        L_0x0027:
            if (r13 == 0) goto L_0x002c
            r13.close()
        L_0x002c:
            return r9
        L_0x002d:
            r0 = move-exception
            r11 = r0
            r0 = r13
            r13 = r11
            goto L_0x0033
        L_0x0032:
            r13 = move-exception
        L_0x0033:
            if (r0 == 0) goto L_0x0038
            r0.close()
        L_0x0038:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.plugin.downloader.p371b.C8263a.mo33424ng(java.lang.String):boolean");
    }

    /* renamed from: nh */
    public int mo33425nh(String str) {
        return getWritableDatabase().delete("download_record", "url=?", new String[]{str});
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* renamed from: ni */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.introvd.template.plugin.downloader.entity.C8317e mo33426ni(java.lang.String r14) {
        /*
            r13 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r13.getReadableDatabase()     // Catch:{ all -> 0x004a }
            java.lang.String r2 = "download_record"
            java.lang.String r3 = "id"
            java.lang.String r4 = "url"
            java.lang.String r5 = "save_name"
            java.lang.String r6 = "save_path"
            java.lang.String r7 = "download_size"
            java.lang.String r8 = "total_size"
            java.lang.String r9 = "is_chunked"
            java.lang.String r10 = "download_flag"
            java.lang.String r11 = "date"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9, r10, r11}     // Catch:{ all -> 0x004a }
            java.lang.String r4 = "url=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x004a }
            r6 = 0
            r5[r6] = r14     // Catch:{ all -> 0x004a }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x004a }
            r14.moveToFirst()     // Catch:{ all -> 0x0045 }
            int r1 = r14.getCount()     // Catch:{ all -> 0x0045 }
            if (r1 != 0) goto L_0x003b
            if (r14 == 0) goto L_0x003a
            r14.close()
        L_0x003a:
            return r0
        L_0x003b:
            com.introvd.template.plugin.downloader.entity.e r0 = com.introvd.template.plugin.downloader.p371b.C8265b.m23845m(r14)     // Catch:{ all -> 0x0045 }
            if (r14 == 0) goto L_0x0044
            r14.close()
        L_0x0044:
            return r0
        L_0x0045:
            r0 = move-exception
            r12 = r0
            r0 = r14
            r14 = r12
            goto L_0x004b
        L_0x004a:
            r14 = move-exception
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.close()
        L_0x0050:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.plugin.downloader.p371b.C8263a.mo33426ni(java.lang.String):com.introvd.template.plugin.downloader.entity.e");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* renamed from: nj */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.introvd.template.plugin.downloader.entity.DownloadStatus mo33427nj(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = "download_record"
            java.lang.String r3 = "download_size"
            java.lang.String r4 = "total_size"
            java.lang.String r5 = "is_chunked"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch:{ all -> 0x0043 }
            java.lang.String r4 = "url=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x0043 }
            r6 = 0
            r5[r6] = r11     // Catch:{ all -> 0x0043 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0043 }
            r11.moveToFirst()     // Catch:{ all -> 0x003e }
            int r0 = r11.getCount()     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x0034
            com.introvd.template.plugin.downloader.entity.DownloadStatus r0 = new com.introvd.template.plugin.downloader.entity.DownloadStatus     // Catch:{ all -> 0x003e }
            r0.<init>()     // Catch:{ all -> 0x003e }
            if (r11 == 0) goto L_0x0033
            r11.close()
        L_0x0033:
            return r0
        L_0x0034:
            com.introvd.template.plugin.downloader.entity.DownloadStatus r0 = com.introvd.template.plugin.downloader.p371b.C8265b.m23844l(r11)     // Catch:{ all -> 0x003e }
            if (r11 == 0) goto L_0x003d
            r11.close()
        L_0x003d:
            return r0
        L_0x003e:
            r0 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x0044
        L_0x0043:
            r11 = move-exception
        L_0x0044:
            if (r0 == 0) goto L_0x0049
            r0.close()
        L_0x0049:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.plugin.downloader.p371b.C8263a.mo33427nj(java.lang.String):com.introvd.template.plugin.downloader.entity.DownloadStatus");
    }
}
