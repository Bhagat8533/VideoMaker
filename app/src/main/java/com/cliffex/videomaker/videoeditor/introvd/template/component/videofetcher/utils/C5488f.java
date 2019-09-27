package com.introvd.template.component.videofetcher.utils;

import android.text.TextUtils;
import java.io.File;
import java.text.DecimalFormat;

/* renamed from: com.introvd.template.component.videofetcher.utils.f */
public class C5488f {
    /* renamed from: as */
    public static String m14898as(long j) {
        double d = (double) j;
        double d2 = d / 1024.0d;
        double d3 = d2 / 1024.0d;
        double d4 = d3 / 1024.0d;
        double d5 = d4 / 1024.0d;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return d5 > 1.0d ? decimalFormat.format(d5).concat(" TB") : d4 > 1.0d ? decimalFormat.format(d4).concat(" GB") : d3 > 1.0d ? decimalFormat.format(d3).concat(" MB") : d2 > 1.0d ? decimalFormat.format(d2).concat(" KB") : decimalFormat.format(d).concat(" B");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0061 A[SYNTHETIC, Splitter:B:39:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0069 A[Catch:{ IOException -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0074 A[SYNTHETIC, Splitter:B:49:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x007c A[Catch:{ IOException -> 0x0078 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0084
            if (r5 == 0) goto L_0x0084
            boolean r1 = r4.equals(r5)
            if (r1 == 0) goto L_0x000d
            goto L_0x0084
        L_0x000d:
            java.io.File r1 = new java.io.File
            r1.<init>(r4)
            boolean r4 = r1.exists()
            if (r4 != 0) goto L_0x0019
            return r0
        L_0x0019:
            boolean r4 = r1.isFile()
            if (r4 != 0) goto L_0x0020
            return r0
        L_0x0020:
            java.io.File r4 = new java.io.File
            r4.<init>(r5)
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0055 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0055 }
        L_0x0034:
            int r4 = r3.read(r5)     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            r2 = -1
            if (r4 == r2) goto L_0x003f
            r1.write(r5, r0, r4)     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            goto L_0x0034
        L_0x003f:
            r1.flush()     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            r4 = 1
            r1.close()     // Catch:{ IOException -> 0x004a }
            r3.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004e:
            return r4
        L_0x004f:
            r4 = move-exception
            r2 = r1
            goto L_0x0072
        L_0x0052:
            r4 = move-exception
            r2 = r1
            goto L_0x005c
        L_0x0055:
            r4 = move-exception
            goto L_0x005c
        L_0x0057:
            r4 = move-exception
            r3 = r2
            goto L_0x0072
        L_0x005a:
            r4 = move-exception
            r3 = r2
        L_0x005c:
            r4.printStackTrace()     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x0067
            r2.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0067
        L_0x0065:
            r4 = move-exception
            goto L_0x006d
        L_0x0067:
            if (r3 == 0) goto L_0x0070
            r3.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0070
        L_0x006d:
            r4.printStackTrace()
        L_0x0070:
            return r0
        L_0x0071:
            r4 = move-exception
        L_0x0072:
            if (r2 == 0) goto L_0x007a
            r2.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x007a
        L_0x0078:
            r5 = move-exception
            goto L_0x0080
        L_0x007a:
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x0083
        L_0x0080:
            r5.printStackTrace()
        L_0x0083:
            throw r4
        L_0x0084:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.component.videofetcher.utils.C5488f.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean deleteDirectory(String str) {
        if (!str.endsWith(File.separator)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(File.separator);
            str = sb.toString();
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        boolean z = true;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                z = deleteFile(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            } else {
                z = deleteDirectory(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            }
        }
        return z && file.delete();
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.isFile()) {
            return false;
        }
        try {
            file.delete();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: fN */
    public static boolean m14899fN(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* renamed from: fO */
    public static boolean m14900fO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return false;
    }

    /* renamed from: fP */
    public static boolean m14901fP(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                boolean z = true;
                if (listFiles == null) {
                    return true;
                }
                if (listFiles.length > 0) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }
}
