package com.introvd.template.datacenter;

import android.text.TextUtils;
import java.io.File;

class FileUtils {
    FileUtils() {
    }

    static boolean copyDirectory(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!str.endsWith(File.separator)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(File.separator);
            str = sb.toString();
        }
        if (!str2.endsWith(File.separator)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(File.separator);
            str2 = sb2.toString();
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File file2 = new File(str2);
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        String[] list = file.list();
        boolean z = true;
        if (list != null) {
            for (String str3 : list) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(str3);
                if (new File(sb3.toString()).isFile()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append(str3);
                    String sb5 = sb4.toString();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str2);
                    sb6.append(str3);
                    z = copyFile(sb5, sb6.toString());
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str2);
                    sb7.append(str3);
                    sb7.append(File.separator);
                    createMultilevelDirectory(sb7.toString());
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str);
                    sb8.append(str3);
                    String sb9 = sb8.toString();
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(str2);
                    sb10.append(str3);
                    z = copyDirectory(sb9, sb10.toString());
                }
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x006a A[SYNTHETIC, Splitter:B:45:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0074 A[SYNTHETIC, Splitter:B:50:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0081 A[SYNTHETIC, Splitter:B:58:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x008b A[SYNTHETIC, Splitter:B:63:0x008b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0094
            if (r5 == 0) goto L_0x0094
            boolean r1 = r4.equals(r5)
            if (r1 == 0) goto L_0x000d
            goto L_0x0094
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
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0063, all -> 0x005f }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0063, all -> 0x005f }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
        L_0x0034:
            int r4 = r3.read(r5)     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            r2 = -1
            if (r4 == r2) goto L_0x003f
            r1.write(r5, r0, r4)     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            goto L_0x0034
        L_0x003f:
            r1.flush()     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            r4 = 1
            r3.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004b:
            r1.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0053:
            return r4
        L_0x0054:
            r4 = move-exception
            goto L_0x007f
        L_0x0056:
            r4 = move-exception
            goto L_0x005d
        L_0x0058:
            r4 = move-exception
            r1 = r2
            goto L_0x007f
        L_0x005b:
            r4 = move-exception
            r1 = r2
        L_0x005d:
            r2 = r3
            goto L_0x0065
        L_0x005f:
            r4 = move-exception
            r1 = r2
            r3 = r1
            goto L_0x007f
        L_0x0063:
            r4 = move-exception
            r1 = r2
        L_0x0065:
            r4.printStackTrace()     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x0072
            r2.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0072:
            if (r1 == 0) goto L_0x007c
            r1.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r4 = move-exception
            r4.printStackTrace()
        L_0x007c:
            return r0
        L_0x007d:
            r4 = move-exception
            r3 = r2
        L_0x007f:
            if (r3 == 0) goto L_0x0089
            r3.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0089:
            if (r1 == 0) goto L_0x0093
            r1.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0093
        L_0x008f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0093:
            throw r4
        L_0x0094:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.FileUtils.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean createMultilevelDirectory(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        file.mkdirs();
        File file2 = new File(str);
        if (file2.exists() && file2.isDirectory()) {
            z = true;
        }
        return z;
    }

    public static boolean isDirectoryExisted(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            z = true;
        }
        return z;
    }
}
