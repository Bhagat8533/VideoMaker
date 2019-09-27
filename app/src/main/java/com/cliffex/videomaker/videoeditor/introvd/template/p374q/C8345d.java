package com.introvd.template.p374q;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.MagicCode;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.q.d */
public class C8345d {
    /* renamed from: Q */
    private static void m24059Q(Context context, String str, String str2) {
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str);
        contentValues.put("value", str2);
        try {
            contentResolver.insert(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_MEMORY_SHARES), contentValues);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: R */
    public static void m24060R(Context context, String str, String str2) {
        if (str != null) {
            m24059Q(context, str, str2);
        }
    }

    /* renamed from: V */
    public static void m24061V(Context context, boolean z) {
        m24060R(context, "ServiceRunning", String.valueOf(z));
    }

    public static boolean aKc() {
        return MagicCode.getCount() > 0;
    }

    /* renamed from: b */
    public static int m24062b(Context context, String str, int i, boolean z) {
        int cp = m24066cp(context, str);
        int i2 = z ? i | cp : (~i) & cp;
        m24060R(context, str, String.valueOf(i2));
        return i2;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r8v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r7v8, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r8 != 0) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r8.close();
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r8 != 0) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004b, code lost:
        return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY]]
      uses: [java.lang.String, ?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor]
      mth insns count: 33
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
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: cm */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m24063cm(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ Exception -> 0x0047, all -> 0x0040 }
            java.lang.String r4 = "key = ?"
            java.lang.String r7 = "MemShares"
            android.net.Uri r2 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r7)     // Catch:{ Exception -> 0x0047, all -> 0x0040 }
            java.lang.String r7 = "value"
            java.lang.String[] r3 = new java.lang.String[]{r7}     // Catch:{ Exception -> 0x0047, all -> 0x0040 }
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch:{ Exception -> 0x0047, all -> 0x0040 }
            r7 = 0
            r5[r7] = r8     // Catch:{ Exception -> 0x0047, all -> 0x0040 }
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0047, all -> 0x0040 }
            if (r8 == 0) goto L_0x003a
            int r1 = r8.getCount()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            if (r1 <= 0) goto L_0x003a
            boolean r1 = r8.moveToFirst()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            if (r1 == 0) goto L_0x003a
            java.lang.String r7 = r8.getString(r7)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            r0 = r7
            goto L_0x003a
        L_0x0035:
            r7 = move-exception
            r0 = r8
            goto L_0x0041
        L_0x0038:
            goto L_0x0048
        L_0x003a:
            if (r8 == 0) goto L_0x004b
        L_0x003c:
            r8.close()
            goto L_0x004b
        L_0x0040:
            r7 = move-exception
        L_0x0041:
            if (r0 == 0) goto L_0x0046
            r0.close()
        L_0x0046:
            throw r7
        L_0x0047:
            r8 = r0
        L_0x0048:
            if (r8 == 0) goto L_0x004b
            goto L_0x003c
        L_0x004b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p374q.C8345d.m24063cm(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: cn */
    public static String m24064cn(Context context, String str) {
        if (str == null) {
            return null;
        }
        return m24063cm(context, str);
    }

    /* renamed from: co */
    public static boolean m24065co(Context context, String str) {
        String cn = m24064cn(context, str);
        return cn != null && Boolean.valueOf(cn).booleanValue();
    }

    /* renamed from: cp */
    public static int m24066cp(Context context, String str) {
        String cn = m24064cn(context, str);
        if (!TextUtils.isEmpty(cn)) {
            return Integer.parseInt(cn);
        }
        return 0;
    }

    /* renamed from: e */
    public static void m24067e(Context context, int i, boolean z) {
        m24062b(context, "AppTaskDoneFlag", i, z);
    }

    /* renamed from: gP */
    public static int m24068gP(Context context) {
        return m24066cp(context, "AppTaskDoneFlag");
    }

    /* renamed from: gQ */
    public static boolean m24069gQ(Context context) {
        return m24065co(context, "ServiceRunning");
    }

    /* renamed from: l */
    public static void m24070l(Context context, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("TCID");
        sb.append(str);
        m24060R(context, sb.toString(), String.valueOf(z));
    }
}
