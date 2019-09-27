package com.introvd.template.common.filecache;

/* renamed from: com.introvd.template.common.filecache.a */
class C5276a {
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0029, code lost:
        if (r1 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0033, code lost:
        if (r1 != null) goto L_0x002b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0039 A[SYNTHETIC, Splitter:B:34:0x0039] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0030=Splitter:B:28:0x0030, B:22:0x0026=Splitter:B:22:0x0026} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m14368a(java.lang.String r3, java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x003d
            if (r3 != 0) goto L_0x0006
            goto L_0x003d
        L_0x0006:
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002f, Exception -> 0x0025 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x002f, Exception -> 0x0025 }
            r4 = 9
            byte[] r3 = m14369a(r3, r4, r5)     // Catch:{ IOException -> 0x0020, Exception -> 0x001d, all -> 0x001a }
            r2.write(r3)     // Catch:{ IOException -> 0x0020, Exception -> 0x001d, all -> 0x001a }
            r3 = 1
            r2.close()     // Catch:{ IOException -> 0x0019 }
        L_0x0019:
            return r3
        L_0x001a:
            r3 = move-exception
            r1 = r2
            goto L_0x0037
        L_0x001d:
            r3 = move-exception
            r1 = r2
            goto L_0x0026
        L_0x0020:
            r3 = move-exception
            r1 = r2
            goto L_0x0030
        L_0x0023:
            r3 = move-exception
            goto L_0x0037
        L_0x0025:
            r3 = move-exception
        L_0x0026:
            r3.printStackTrace()     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0036
        L_0x002b:
            r1.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x0036
        L_0x002f:
            r3 = move-exception
        L_0x0030:
            r3.printStackTrace()     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            return r0
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            throw r3
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.filecache.C5276a.m14368a(java.lang.String, java.io.File, java.lang.String):boolean");
    }

    /* renamed from: a */
    private static byte[] m14369a(String str, byte b, String str2) throws Exception {
        byte[] bytes = str.getBytes(str2);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ b);
        }
        return bytes;
    }

    /* renamed from: a */
    private static byte[] m14370a(byte[] bArr, byte b) throws Exception {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ b);
        }
        return bArr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|5|(3:6|7|(1:9)(8:18|19|20|21|22|23|24|44))|54|11|12|13|14|15|16) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:18|19|20|21|22|23|24|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0064, code lost:
        if (r1 != null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0072, code lost:
        if (r1 != null) goto L_0x0066;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0048 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0053 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0069 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0079 A[SYNTHETIC, Splitter:B:48:0x0079] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0061=Splitter:B:32:0x0061, B:41:0x006f=Splitter:B:41:0x006f} */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String m14371c(java.io.File r7, java.lang.String r8) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r1]
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>(r1)
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x006d, Exception -> 0x005f, all -> 0x005c }
            r1.<init>(r7)     // Catch:{ IOException -> 0x006d, Exception -> 0x005f, all -> 0x005c }
        L_0x0012:
            int r4 = r1.read(r2)     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            r5 = -1
            if (r4 == r5) goto L_0x004c
            r5 = 9
            byte[] r5 = m14370a(r2, r5)     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            r6 = 0
            r3.write(r5, r6, r4)     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            int r4 = r3.size()     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            r5 = 2097152(0x200000, float:2.938736E-39)
            if (r4 <= r5) goto L_0x0012
            java.lang.String r8 = "IoUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            r2.<init>()     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            java.lang.String r4 = "File too large, maybe not a string. "
            r2.append(r4)     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            r2.append(r7)     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            android.util.Log.e(r8, r7)     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            r1.close()     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            r3.close()     // Catch:{ IOException -> 0x004b }
        L_0x004b:
            return r0
        L_0x004c:
            java.lang.String r7 = r3.toString(r8)     // Catch:{ IOException -> 0x005a, Exception -> 0x0058 }
            r1.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            r3.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            r0 = r7
            goto L_0x0075
        L_0x0058:
            r7 = move-exception
            goto L_0x0061
        L_0x005a:
            r7 = move-exception
            goto L_0x006f
        L_0x005c:
            r7 = move-exception
            r1 = r0
            goto L_0x0077
        L_0x005f:
            r7 = move-exception
            r1 = r0
        L_0x0061:
            r7.printStackTrace()     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x0069
        L_0x0066:
            r1.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            r3.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0075
        L_0x006d:
            r7 = move-exception
            r1 = r0
        L_0x006f:
            r7.printStackTrace()     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x0069
            goto L_0x0066
        L_0x0075:
            return r0
        L_0x0076:
            r7 = move-exception
        L_0x0077:
            if (r1 == 0) goto L_0x007c
            r1.close()     // Catch:{ IOException -> 0x007c }
        L_0x007c:
            r3.close()     // Catch:{ IOException -> 0x007f }
        L_0x007f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.filecache.C5276a.m14371c(java.io.File, java.lang.String):java.lang.String");
    }
}
