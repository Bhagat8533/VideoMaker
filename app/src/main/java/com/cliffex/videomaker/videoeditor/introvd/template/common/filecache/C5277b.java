package com.introvd.template.common.filecache;

/* renamed from: com.introvd.template.common.filecache.b */
class C5277b {
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0027, code lost:
        if (r1 != null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0031, code lost:
        if (r1 != null) goto L_0x0029;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0037 A[SYNTHETIC, Splitter:B:33:0x0037] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0024=Splitter:B:21:0x0024, B:27:0x002e=Splitter:B:27:0x002e} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m14372a(java.lang.String r3, java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x003b
            if (r3 != 0) goto L_0x0006
            goto L_0x003b
        L_0x0006:
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002d, Exception -> 0x0023 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x002d, Exception -> 0x0023 }
            byte[] r3 = r3.getBytes(r5)     // Catch:{ IOException -> 0x001e, Exception -> 0x001b, all -> 0x0018 }
            r2.write(r3)     // Catch:{ IOException -> 0x001e, Exception -> 0x001b, all -> 0x0018 }
            r3 = 1
            r2.close()     // Catch:{ IOException -> 0x0017 }
        L_0x0017:
            return r3
        L_0x0018:
            r3 = move-exception
            r1 = r2
            goto L_0x0035
        L_0x001b:
            r3 = move-exception
            r1 = r2
            goto L_0x0024
        L_0x001e:
            r3 = move-exception
            r1 = r2
            goto L_0x002e
        L_0x0021:
            r3 = move-exception
            goto L_0x0035
        L_0x0023:
            r3 = move-exception
        L_0x0024:
            r3.printStackTrace()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0034
        L_0x0029:
            r1.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0034
        L_0x002d:
            r3 = move-exception
        L_0x002e:
            r3.printStackTrace()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            return r0
        L_0x0035:
            if (r1 == 0) goto L_0x003a
            r1.close()     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            throw r3
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.filecache.C5277b.m14372a(java.lang.String, java.io.File, java.lang.String):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|5|(3:6|7|(1:9)(7:18|19|20|21|22|23|38))|48|11|12|13|14|15|16) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:18|19|20|21|22|23|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:24|29|30|(2:32|33)|34|35|36|38) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0042 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x004d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005d A[SYNTHETIC, Splitter:B:32:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0068 A[SYNTHETIC, Splitter:B:42:0x0068] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String m14373c(java.io.File r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r1]
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>(r1)
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            r1.<init>(r6)     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
        L_0x0012:
            int r4 = r1.read(r2)     // Catch:{ IOException -> 0x0051 }
            r5 = -1
            if (r4 == r5) goto L_0x0046
            r5 = 0
            r3.write(r2, r5, r4)     // Catch:{ IOException -> 0x0051 }
            int r4 = r3.size()     // Catch:{ IOException -> 0x0051 }
            r5 = 2097152(0x200000, float:2.938736E-39)
            if (r4 <= r5) goto L_0x0012
            java.lang.String r7 = "IoUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0051 }
            r2.<init>()     // Catch:{ IOException -> 0x0051 }
            java.lang.String r4 = "File too large, maybe not a string. "
            r2.append(r4)     // Catch:{ IOException -> 0x0051 }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ IOException -> 0x0051 }
            r2.append(r6)     // Catch:{ IOException -> 0x0051 }
            java.lang.String r6 = r2.toString()     // Catch:{ IOException -> 0x0051 }
            android.util.Log.e(r7, r6)     // Catch:{ IOException -> 0x0051 }
            r1.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            r3.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            return r0
        L_0x0046:
            java.lang.String r6 = r3.toString(r7)     // Catch:{ IOException -> 0x0051 }
            r1.close()     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            r3.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0064
        L_0x0051:
            r6 = move-exception
            goto L_0x0058
        L_0x0053:
            r6 = move-exception
            r1 = r0
            goto L_0x0066
        L_0x0056:
            r6 = move-exception
            r1 = r0
        L_0x0058:
            r6.printStackTrace()     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0060
            r1.close()     // Catch:{ IOException -> 0x0060 }
        L_0x0060:
            r3.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0063:
            r6 = r0
        L_0x0064:
            return r6
        L_0x0065:
            r6 = move-exception
        L_0x0066:
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            r3.close()     // Catch:{ IOException -> 0x006e }
        L_0x006e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.filecache.C5277b.m14373c(java.io.File, java.lang.String):java.lang.String");
    }
}
