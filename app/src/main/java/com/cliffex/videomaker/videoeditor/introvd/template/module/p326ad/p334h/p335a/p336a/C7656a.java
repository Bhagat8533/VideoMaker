package com.introvd.template.module.p326ad.p334h.p335a.p336a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.introvd.template.module.p326ad.C7678j;
import com.introvd.template.module.p326ad.p334h.p335a.C7655a;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.C1839n;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.module.ad.h.a.a.a */
public class C7656a {
    private final Object dNA;
    private final C7659b dNB;
    private volatile SQLiteDatabase dNC;

    /* renamed from: com.introvd.template.module.ad.h.a.a.a$a */
    private static final class C7658a {
        /* access modifiers changed from: private */
        public static final C7656a dNE = new C7656a();
    }

    /* renamed from: com.introvd.template.module.ad.h.a.a.a$b */
    private static class C7659b extends SQLiteOpenHelper {
        private C7659b(Context context) {
            super(context, "com.quvideo.money.db", null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("CREATE TABLE encourage_resource (id INTEGER PRIMARY KEY AUTOINCREMENT,res_id TEXT NOT NULL,unlock_time INTEGER NOT NULL,valid_duration INTEGER NOT NULL,encourage_type INTEGER NOT NULL )");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception unused) {
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
            sQLiteDatabase.endTransaction();
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private C7656a() {
        this.dNA = new Object();
        this.dNB = new C7659b(C7678j.aAd().getContext());
    }

    public static C7656a aAF() {
        return C7658a.dNE;
    }

    /* access modifiers changed from: private */
    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase = this.dNC;
        if (sQLiteDatabase == null) {
            synchronized (this.dNA) {
                sQLiteDatabase = this.dNC;
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = this.dNB.getReadableDatabase();
                    this.dNC = sQLiteDatabase;
                }
            }
        }
        return sQLiteDatabase;
    }

    /* renamed from: a */
    public long mo32548a(C7655a aVar) {
        return this.dNB.getWritableDatabase().insert("encourage_resource", null, C7660b.m22481b(aVar));
    }

    public C1834l<List<C7655a>> aAG() {
        return C1834l.m5254a((C1839n<T>) new C1839n<List<C7655a>>() {
            /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo10177a(p037b.p050b.C1838m<java.util.List<com.introvd.template.module.p326ad.p334h.p335a.C7655a>> r11) {
                /*
                    r10 = this;
                    r0 = 0
                    com.introvd.template.module.ad.h.a.a.a r1 = com.introvd.template.module.p326ad.p334h.p335a.p336a.C7656a.this     // Catch:{ all -> 0x0048 }
                    android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch:{ all -> 0x0048 }
                    java.lang.String r3 = "encourage_resource"
                    java.lang.String r1 = "res_id"
                    java.lang.String r4 = "unlock_time"
                    java.lang.String r5 = "valid_duration"
                    java.lang.String r6 = "encourage_type"
                    java.lang.String[] r4 = new java.lang.String[]{r1, r4, r5, r6}     // Catch:{ all -> 0x0048 }
                    r5 = 0
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0048 }
                    java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0045 }
                    r0.<init>()     // Catch:{ all -> 0x0045 }
                    r1.moveToFirst()     // Catch:{ all -> 0x0045 }
                    int r2 = r1.getCount()     // Catch:{ all -> 0x0045 }
                    if (r2 <= 0) goto L_0x0039
                L_0x002c:
                    com.introvd.template.module.ad.h.a.a r2 = com.introvd.template.module.p326ad.p334h.p335a.p336a.C7660b.m22482k(r1)     // Catch:{ all -> 0x0045 }
                    r0.add(r2)     // Catch:{ all -> 0x0045 }
                    boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0045 }
                    if (r2 != 0) goto L_0x002c
                L_0x0039:
                    r11.mo9791K(r0)     // Catch:{ all -> 0x0045 }
                    r11.onComplete()     // Catch:{ all -> 0x0045 }
                    if (r1 == 0) goto L_0x0044
                    r1.close()
                L_0x0044:
                    return
                L_0x0045:
                    r11 = move-exception
                    r0 = r1
                    goto L_0x0049
                L_0x0048:
                    r11 = move-exception
                L_0x0049:
                    if (r0 == 0) goto L_0x004e
                    r0.close()
                L_0x004e:
                    throw r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.module.p326ad.p334h.p335a.p336a.C7656a.C76571.mo10177a(b.b.m):void");
            }
        }).mo10157d(C1820a.aVi());
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.introvd.template.module.ad.h.a.a] */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r11v7, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r1v5, types: [com.introvd.template.module.ad.h.a.a] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        if (r11 != 0) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r11 != 0) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        r11.close();
        r0 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY]]
      uses: [com.introvd.template.module.ad.h.a.a, ?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor]
      mth insns count: 38
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: kn */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.introvd.template.module.p326ad.p334h.p335a.C7655a mo32550kn(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            java.lang.String r2 = "encourage_resource"
            java.lang.String r3 = "res_id"
            java.lang.String r4 = "unlock_time"
            java.lang.String r5 = "valid_duration"
            java.lang.String r6 = "encourage_type"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6}     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            java.lang.String r4 = "res_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r6 = 0
            r5[r6] = r11     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r11.moveToFirst()     // Catch:{ Exception -> 0x0036 }
            int r1 = r11.getCount()     // Catch:{ Exception -> 0x0036 }
            if (r1 == 0) goto L_0x0030
            com.introvd.template.module.ad.h.a.a r1 = com.introvd.template.module.p326ad.p334h.p335a.p336a.C7660b.m22482k(r11)     // Catch:{ Exception -> 0x0036 }
            r0 = r1
        L_0x0030:
            if (r11 == 0) goto L_0x0046
        L_0x0032:
            r11.close()
            goto L_0x0046
        L_0x0036:
            r1 = move-exception
            goto L_0x003c
        L_0x0038:
            r11 = move-exception
            goto L_0x004b
        L_0x003a:
            r1 = move-exception
            r11 = r0
        L_0x003c:
            com.introvd.template.module.ad.j r2 = com.introvd.template.module.p326ad.C7678j.aAd()     // Catch:{ all -> 0x0047 }
            r2.logException(r1)     // Catch:{ all -> 0x0047 }
            if (r11 == 0) goto L_0x0046
            goto L_0x0032
        L_0x0046:
            return r0
        L_0x0047:
            r0 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.close()
        L_0x0050:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.module.p326ad.p334h.p335a.p336a.C7656a.mo32550kn(java.lang.String):com.introvd.template.module.ad.h.a.a");
    }

    /* renamed from: ko */
    public void mo32551ko(String str) {
        this.dNB.getWritableDatabase().delete("encourage_resource", "res_id=?", new String[]{str});
    }
}
