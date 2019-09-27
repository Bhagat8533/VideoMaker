package com.introvd.template.common;

import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;

public class ResourceUtils {
    public static AssetManager mAssetsManager;

    /* JADX WARNING: Removed duplicated region for block: B:43:0x005f A[SYNTHETIC, Splitter:B:43:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0069 A[SYNTHETIC, Splitter:B:49:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0075 A[SYNTHETIC, Splitter:B:56:0x0075] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x0064=Splitter:B:46:0x0064, B:40:0x005a=Splitter:B:40:0x005a} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m14248a(java.io.InputStream r7, java.io.File r8) {
        /*
            r0 = 0
            int r1 = r7.available()     // Catch:{ IOException -> 0x007e }
            long r1 = (long) r1     // Catch:{ IOException -> 0x007e }
            long r3 = r8.length()     // Catch:{ IOException -> 0x007e }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x000f
            return r0
        L_0x000f:
            r1 = 128(0x80, float:1.794E-43)
            byte[] r2 = new byte[r1]
            byte[] r1 = new byte[r1]
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0059 }
            r4.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0059 }
            int r8 = r4.read(r1)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            long r5 = (long) r8     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            int r7 = r7.read(r2)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            long r7 = (long) r7
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0032
            r4.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0031:
            return r0
        L_0x0032:
            r3 = 0
        L_0x0033:
            long r5 = (long) r3
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x004a
            byte r5 = r1[r3]     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            byte r6 = r2[r3]     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            if (r5 == r6) goto L_0x0047
            r4.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0046:
            return r0
        L_0x0047:
            int r3 = r3 + 1
            goto L_0x0033
        L_0x004a:
            r4.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x004e:
            r7 = move-exception
            r3 = r4
            goto L_0x0073
        L_0x0051:
            r7 = move-exception
            r3 = r4
            goto L_0x005a
        L_0x0054:
            r7 = move-exception
            r3 = r4
            goto L_0x0064
        L_0x0057:
            r7 = move-exception
            goto L_0x0073
        L_0x0059:
            r7 = move-exception
        L_0x005a:
            r7.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0071
            r3.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x0063:
            r7 = move-exception
        L_0x0064:
            r7.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0071
            r3.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0071:
            r7 = 1
            return r7
        L_0x0073:
            if (r3 == 0) goto L_0x007d
            r3.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r8 = move-exception
            r8.printStackTrace()
        L_0x007d:
            throw r7
        L_0x007e:
            r7 = move-exception
            r7.printStackTrace()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = ">>>>>>>>>>>>>>>> "
            r8.append(r1)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.introvd.template.common.LogUtilsV2.m14228e(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.ResourceUtils.m14248a(java.io.InputStream, java.io.File):boolean");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0083 */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x00d5 A[SYNTHETIC, Splitter:B:102:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x00e4 A[SYNTHETIC, Splitter:B:111:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0092 A[SYNTHETIC, Splitter:B:56:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ad A[SYNTHETIC, Splitter:B:77:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00b5 A[SYNTHETIC, Splitter:B:81:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00c4 A[SYNTHETIC, Splitter:B:90:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x00cd A[SYNTHETIC, Splitter:B:98:0x00cd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFileFromAssets(java.lang.String r5, java.lang.String r6, android.content.res.AssetManager r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x00e8
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x00e8
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L_0x0011
            goto L_0x00e8
        L_0x0011:
            java.lang.String r1 = com.introvd.template.common.FileUtils.getFileParentPath(r6)
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r3 = r2.exists()
            if (r3 == 0) goto L_0x0026
            boolean r2 = r2.isDirectory()
            if (r2 != 0) goto L_0x0029
        L_0x0026:
            com.introvd.template.common.FileUtils.createMultilevelDirectory(r1)
        L_0x0029:
            r1 = 0
            java.io.InputStream r5 = r7.open(r5)     // Catch:{ Exception -> 0x00c8, all -> 0x00a7 }
            boolean r7 = r5.markSupported()     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            if (r7 != 0) goto L_0x0041
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            r2 = 16384(0x4000, float:2.2959E-41)
            r7.<init>(r5, r2)     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            r2 = 1024(0x400, float:1.435E-42)
            r7.mark(r2)     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            goto L_0x0042
        L_0x0041:
            r7 = r5
        L_0x0042:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            r2.<init>(r6)     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            if (r3 == 0) goto L_0x0060
            boolean r2 = m14248a(r7, r2)     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            if (r2 == 0) goto L_0x0060
            if (r7 == 0) goto L_0x005a
            if (r7 == r5) goto L_0x005a
            r7.close()     // Catch:{ Throwable -> 0x005a }
        L_0x005a:
            if (r5 == 0) goto L_0x005f
            r5.close()     // Catch:{ Throwable -> 0x005f }
        L_0x005f:
            return r0
        L_0x0060:
            r7.reset()     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            r2.<init>(r6)     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x00cb, all -> 0x009c }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00cb, all -> 0x009c }
            int r4 = r6.length     // Catch:{ Exception -> 0x00cb, all -> 0x009c }
            r3.<init>(r2, r4)     // Catch:{ Exception -> 0x00cb, all -> 0x009c }
        L_0x0072:
            int r1 = r7.read(r6)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r4 = -1
            if (r1 == r4) goto L_0x007d
            r3.write(r6, r0, r1)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            goto L_0x0072
        L_0x007d:
            r3.flush()     // Catch:{ Throwable -> 0x0083 }
            r3.close()     // Catch:{ Throwable -> 0x0083 }
        L_0x0083:
            r2.flush()     // Catch:{ Throwable -> 0x0089 }
            r2.close()     // Catch:{ Throwable -> 0x0089 }
        L_0x0089:
            if (r7 == 0) goto L_0x0090
            if (r7 == r5) goto L_0x0090
            r7.close()     // Catch:{ Throwable -> 0x0090 }
        L_0x0090:
            if (r5 == 0) goto L_0x0095
            r5.close()     // Catch:{ Throwable -> 0x0095 }
        L_0x0095:
            r5 = 1
            return r5
        L_0x0097:
            r6 = move-exception
            r1 = r3
            goto L_0x00ab
        L_0x009a:
            r1 = r3
            goto L_0x00cb
        L_0x009c:
            r6 = move-exception
            goto L_0x00ab
        L_0x009e:
            r6 = move-exception
            goto L_0x00a2
        L_0x00a0:
            r6 = move-exception
            r7 = r5
        L_0x00a2:
            r2 = r1
            goto L_0x00ab
        L_0x00a4:
            r7 = r5
        L_0x00a5:
            r2 = r1
            goto L_0x00cb
        L_0x00a7:
            r6 = move-exception
            r5 = r1
            r7 = r5
            r2 = r7
        L_0x00ab:
            if (r1 == 0) goto L_0x00b3
            r1.flush()     // Catch:{ Throwable -> 0x00b3 }
            r1.close()     // Catch:{ Throwable -> 0x00b3 }
        L_0x00b3:
            if (r2 == 0) goto L_0x00bb
            r2.flush()     // Catch:{ Throwable -> 0x00bb }
            r2.close()     // Catch:{ Throwable -> 0x00bb }
        L_0x00bb:
            if (r7 == 0) goto L_0x00c2
            if (r7 == r5) goto L_0x00c2
            r7.close()     // Catch:{ Throwable -> 0x00c2 }
        L_0x00c2:
            if (r5 == 0) goto L_0x00c7
            r5.close()     // Catch:{ Throwable -> 0x00c7 }
        L_0x00c7:
            throw r6
        L_0x00c8:
            r5 = r1
            r7 = r5
            r2 = r7
        L_0x00cb:
            if (r1 == 0) goto L_0x00d3
            r1.flush()     // Catch:{ Throwable -> 0x00d3 }
            r1.close()     // Catch:{ Throwable -> 0x00d3 }
        L_0x00d3:
            if (r2 == 0) goto L_0x00db
            r2.flush()     // Catch:{ Throwable -> 0x00db }
            r2.close()     // Catch:{ Throwable -> 0x00db }
        L_0x00db:
            if (r7 == 0) goto L_0x00e2
            if (r7 == r5) goto L_0x00e2
            r7.close()     // Catch:{ Throwable -> 0x00e2 }
        L_0x00e2:
            if (r5 == 0) goto L_0x00e7
            r5.close()     // Catch:{ Throwable -> 0x00e7 }
        L_0x00e7:
            return r0
        L_0x00e8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.ResourceUtils.copyFileFromAssets(java.lang.String, java.lang.String, android.content.res.AssetManager):boolean");
    }

    public static boolean isAssetsFileExisted(AssetManager assetManager, String str) {
        boolean z = false;
        if (assetManager == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            InputStream open = assetManager.open(str);
            if (open != null) {
                z = true;
            }
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public static void setContext(AssetManager assetManager) {
        mAssetsManager = assetManager;
    }
}
