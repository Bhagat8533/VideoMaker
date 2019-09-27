package com.introvd.template.p309f;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.f.a */
public class C7347a {
    private static Uri col;

    /* renamed from: a */
    public static long m21671a(ContentResolver contentResolver, String str, String str2, int i, int i2, int i3, int i4, int i5, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote", str);
        contentValues.put("local", str2);
        contentValues.put("maintype", Integer.valueOf(i));
        contentValues.put("subtype", Integer.valueOf(i2));
        contentValues.put(SocialConstDef.DOWNLOAD_TOTAL, Integer.valueOf(0));
        contentValues.put(SocialConstDef.DOWNLOAD_CURRENT_SIZE, Integer.valueOf(0));
        contentValues.put("state", Integer.valueOf(i5));
        contentValues.put("time", str3);
        Uri insert = contentResolver.insert(getTableUri(), contentValues);
        if (insert != null) {
            return ContentUris.parseId(insert);
        }
        return 0;
    }

    /* renamed from: a */
    public static Cursor m21672a(ContentResolver contentResolver, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("state=");
        sb.append(i);
        String sb2 = sb.toString();
        return contentResolver.query(getTableUri(), new String[]{"remote", "local", "_id", "maintype", "subtype"}, sb2, null, "priority, _id DESC");
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r6v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r8v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r9v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r9v7, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r8 != 0) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r8.close();
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r8 != 0) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        return r6;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY]]
      uses: [java.lang.String, ?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor]
      mth insns count: 35
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
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m21673a(android.content.ContentResolver r8, boolean r9, long r10, java.lang.String r12) {
        /*
            java.lang.String r3 = "_id=?"
            r6 = 0
            android.net.Uri r1 = getTableUri()     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            r7 = 0
            r2[r7] = r12     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            r4[r7] = r10     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            r5 = 0
            r0 = r8
            android.database.Cursor r8 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            if (r8 == 0) goto L_0x0039
            boolean r10 = r8.moveToFirst()     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            if (r10 == 0) goto L_0x0039
            if (r9 == 0) goto L_0x002b
            java.lang.String r9 = r8.getString(r7)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
        L_0x0029:
            r6 = r9
            goto L_0x0039
        L_0x002b:
            int r9 = r8.getInt(r7)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            goto L_0x0029
        L_0x0034:
            r9 = move-exception
            r6 = r8
            goto L_0x0040
        L_0x0037:
            goto L_0x0047
        L_0x0039:
            if (r8 == 0) goto L_0x004a
        L_0x003b:
            r8.close()
            goto L_0x004a
        L_0x003f:
            r9 = move-exception
        L_0x0040:
            if (r6 == 0) goto L_0x0045
            r6.close()
        L_0x0045:
            throw r9
        L_0x0046:
            r8 = r6
        L_0x0047:
            if (r8 == 0) goto L_0x004a
            goto L_0x003b
        L_0x004a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p309f.C7347a.m21673a(android.content.ContentResolver, boolean, long, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static void m21674a(ContentResolver contentResolver, int i, int i2) {
        String str = "state <> ?";
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(i));
        try {
            contentResolver.update(getTableUri(), contentValues, str, new String[]{String.valueOf(i2)});
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m21675a(ContentResolver contentResolver, long j, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(i));
        contentResolver.update(getTableUri(), contentValues, "_id = ?", new String[]{String.valueOf(j)});
    }

    /* renamed from: a */
    public static void m21676a(ContentResolver contentResolver, long j, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SocialConstDef.DOWNLOAD_TOTAL, Long.valueOf(j2));
        contentResolver.update(getTableUri(), contentValues, "_id = ?", new String[]{String.valueOf(j)});
    }

    /* renamed from: a */
    public static void m21677a(ContentResolver contentResolver, long j, long j2, long j3, long j4) {
        ContentValues contentValues = new ContentValues();
        if (j2 != 0) {
            contentValues.put(SocialConstDef.DOWNLOAD_TOTAL, Integer.valueOf((int) j2));
        }
        contentValues.put(SocialConstDef.DOWNLOAD_CURRENT_SIZE, Long.valueOf(j3));
        contentValues.put("speed", Integer.valueOf((int) j4));
        String str = "_id = ?";
        try {
            contentResolver.update(getTableUri(), contentValues, str, new String[]{String.valueOf(j)});
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m21678a(ContentResolver contentResolver, long j, String str, String str2, int i, int i2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote", str);
        contentValues.put("local", str2);
        contentValues.put("priority", Integer.valueOf(i));
        if (z) {
            contentValues.put(SocialConstDef.DOWNLOAD_TOTAL, Integer.valueOf(0));
            contentValues.put(SocialConstDef.DOWNLOAD_CURRENT_SIZE, Integer.valueOf(0));
        }
        contentValues.put("state", Integer.valueOf(i2));
        try {
            contentResolver.update(getTableUri(), contentValues, "_id= ?", new String[]{String.valueOf(j)});
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m21679a(ContentResolver contentResolver, String str, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("speed", Integer.valueOf(i));
        contentValues.put("state", Integer.valueOf(i2));
        String str2 = "remote = ?";
        try {
            contentResolver.update(getTableUri(), contentValues, str2, new String[]{str});
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m21680b(ContentResolver contentResolver, String str) {
        contentResolver.delete(getTableUri(), "remote = ?", new String[]{str});
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m21681c(android.content.ContentResolver r9, java.lang.String r10) {
        /*
            java.lang.String r3 = "remote = ?"
            r6 = 0
            r8 = 0
            android.net.Uri r1 = getTableUri()     // Catch:{ Exception -> 0x0041, all -> 0x003a }
            java.lang.String r0 = "_id"
            java.lang.String[] r2 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x0041, all -> 0x003a }
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0041, all -> 0x003a }
            r0 = 0
            r4[r0] = r10     // Catch:{ Exception -> 0x0041, all -> 0x003a }
            r5 = 0
            r0 = r9
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0041, all -> 0x003a }
            if (r9 == 0) goto L_0x0034
            boolean r10 = r9.moveToNext()     // Catch:{ Exception -> 0x0032, all -> 0x002f }
            if (r10 == 0) goto L_0x0034
            java.lang.String r10 = "_id"
            int r10 = r9.getColumnIndex(r10)     // Catch:{ Exception -> 0x0032, all -> 0x002f }
            long r0 = r9.getLong(r10)     // Catch:{ Exception -> 0x0032, all -> 0x002f }
            r6 = r0
            goto L_0x0034
        L_0x002f:
            r10 = move-exception
            r8 = r9
            goto L_0x003b
        L_0x0032:
            r8 = r9
            goto L_0x0042
        L_0x0034:
            if (r9 == 0) goto L_0x0047
            r9.close()
            goto L_0x0047
        L_0x003a:
            r10 = move-exception
        L_0x003b:
            if (r8 == 0) goto L_0x0040
            r8.close()
        L_0x0040:
            throw r10
        L_0x0041:
        L_0x0042:
            if (r8 == 0) goto L_0x0047
            r8.close()
        L_0x0047:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p309f.C7347a.m21681c(android.content.ContentResolver, java.lang.String):long");
    }

    /* renamed from: c */
    public static void m21682c(ContentResolver contentResolver) {
        contentResolver.delete(getTableUri(), null, null);
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r6v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r8v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r9v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r8 != 0) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        r8.close();
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r8 != 0) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        return r6;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY]]
      uses: [java.lang.String, ?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor]
      mth insns count: 28
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
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m21683d(android.content.ContentResolver r8, java.lang.String r9) {
        /*
            java.lang.String r3 = "remote=?"
            r6 = 0
            android.net.Uri r1 = getTableUri()     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            java.lang.String r0 = "local"
            java.lang.String[] r2 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            r7 = 0
            r4[r7] = r9     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            r5 = 0
            r0 = r8
            android.database.Cursor r8 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            if (r8 == 0) goto L_0x002c
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            if (r9 == 0) goto L_0x002c
            java.lang.String r9 = r8.getString(r7)     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            r6 = r9
            goto L_0x002c
        L_0x0027:
            r9 = move-exception
            r6 = r8
            goto L_0x0033
        L_0x002a:
            goto L_0x003a
        L_0x002c:
            if (r8 == 0) goto L_0x003d
        L_0x002e:
            r8.close()
            goto L_0x003d
        L_0x0032:
            r9 = move-exception
        L_0x0033:
            if (r6 == 0) goto L_0x0038
            r6.close()
        L_0x0038:
            throw r9
        L_0x0039:
            r8 = r6
        L_0x003a:
            if (r8 == 0) goto L_0x003d
            goto L_0x002e
        L_0x003d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p309f.C7347a.m21683d(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    private static Uri getTableUri() {
        if (col == null) {
            synchronized (C7347a.class) {
                if (col == null) {
                    col = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_DOWNLOAD);
                }
            }
        }
        return col;
    }
}
