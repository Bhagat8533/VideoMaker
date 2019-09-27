package com.introvd.template.p374q;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.q.c */
public class C8344c {
    /* renamed from: P */
    public static void m24054P(Context context, String str, String str2) {
        if (context != null && str != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", str2);
            try {
                context.getContentResolver().insert(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_KEYVALUEMAP), contentValues);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r8v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r7v11, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r8 != 0) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r8.close();
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        if (r8 != 0) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
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
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: cl */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m24055cl(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x004c
            if (r8 != 0) goto L_0x0006
            goto L_0x004c
        L_0x0006:
            android.content.ContentResolver r1 = r7.getContentResolver()
            java.lang.String r7 = "KeyValueMap"
            android.net.Uri r2 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r7)     // Catch:{ Throwable -> 0x003b, all -> 0x0039 }
            java.lang.String r7 = "value"
            java.lang.String[] r3 = new java.lang.String[]{r7}     // Catch:{ Throwable -> 0x003b, all -> 0x0039 }
            java.lang.String r4 = "key = ?"
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch:{ Throwable -> 0x003b, all -> 0x0039 }
            r7 = 0
            r5[r7] = r8     // Catch:{ Throwable -> 0x003b, all -> 0x0039 }
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Throwable -> 0x003b, all -> 0x0039 }
            if (r8 == 0) goto L_0x0033
            boolean r1 = r8.moveToNext()     // Catch:{ Throwable -> 0x0031 }
            if (r1 == 0) goto L_0x0033
            java.lang.String r7 = r8.getString(r7)     // Catch:{ Throwable -> 0x0031 }
            r0 = r7
            goto L_0x0033
        L_0x0031:
            r7 = move-exception
            goto L_0x003d
        L_0x0033:
            if (r8 == 0) goto L_0x0043
        L_0x0035:
            r8.close()
            goto L_0x0043
        L_0x0039:
            r7 = move-exception
            goto L_0x0046
        L_0x003b:
            r7 = move-exception
            r8 = r0
        L_0x003d:
            r7.printStackTrace()     // Catch:{ all -> 0x0044 }
            if (r8 == 0) goto L_0x0043
            goto L_0x0035
        L_0x0043:
            return r0
        L_0x0044:
            r7 = move-exception
            r0 = r8
        L_0x0046:
            if (r0 == 0) goto L_0x004b
            r0.close()
        L_0x004b:
            throw r7
        L_0x004c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p374q.C8344c.m24055cl(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: d */
    public static boolean m24056d(Context context, String str, boolean z) {
        String cl = m24055cl(context, str);
        if (!TextUtils.isEmpty(cl)) {
            try {
                return Boolean.valueOf(cl).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    /* renamed from: f */
    public static long m24057f(Context context, String str, long j) {
        String cl = m24055cl(context, str);
        try {
            return (TextUtils.isEmpty(cl) || !TextUtils.isDigitsOnly(cl)) ? j : Long.parseLong(cl);
        } catch (Throwable th) {
            th.printStackTrace();
            return j;
        }
    }

    /* renamed from: k */
    public static int m24058k(Context context, String str, int i) {
        return (int) m24057f(context, str, (long) i);
    }
}
