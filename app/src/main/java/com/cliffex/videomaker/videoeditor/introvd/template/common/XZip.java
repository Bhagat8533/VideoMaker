package com.introvd.template.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class XZip {
    public static ArrayList<String> UnZipFolder(String str, String str2) throws Exception {
        String str3;
        LogUtilsV2.m14230i("UnZipFolder(String, String)");
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            ArrayList<String> arrayList = new ArrayList<>();
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    String substring = name.substring(0, name.length() - 1);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(File.separator);
                    sb.append(substring);
                    new File(sb.toString()).mkdirs();
                } else {
                    if (!str2.endsWith(File.separator)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(File.separator);
                        str3 = sb2.toString();
                    } else {
                        str3 = str2;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str3);
                    sb3.append(name);
                    String sb4 = sb3.toString();
                    if (name.contains(File.separator)) {
                        int lastIndexOf = sb4.lastIndexOf(File.separator);
                        if (lastIndexOf != -1) {
                            new File(sb4.substring(0, lastIndexOf)).mkdirs();
                        }
                    }
                    File file = new File(sb4);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                    arrayList.add(sb4);
                }
            }
            zipInputStream.close();
            try {
                fileInputStream.close();
            } catch (Exception unused) {
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059 A[SYNTHETIC, Splitter:B:27:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0063 A[SYNTHETIC, Splitter:B:33:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e A[SYNTHETIC, Splitter:B:38:0x006e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0054=Splitter:B:24:0x0054, B:30:0x005e=Splitter:B:30:0x005e} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m14278a(java.lang.String r6, java.lang.String r7, java.util.zip.ZipOutputStream r8) {
        /*
            java.lang.String r0 = "ZipFiles(String, String, ZipOutputStream)"
            com.introvd.template.common.LogUtilsV2.m14230i(r0)
            if (r8 != 0) goto L_0x0008
            return
        L_0x0008:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.isFile()
            r2 = 0
            if (r1 == 0) goto L_0x0077
            java.util.zip.ZipEntry r6 = new java.util.zip.ZipEntry
            r6.<init>(r7)
            r7 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x005d, IOException -> 0x0053 }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x005d, IOException -> 0x0053 }
            r8.putNextEntry(r6)     // Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x004a, all -> 0x0048 }
            r6 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x004a, all -> 0x0048 }
        L_0x0035:
            int r7 = r1.read(r6)     // Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x004a, all -> 0x0048 }
            r0 = -1
            if (r7 == r0) goto L_0x0040
            r8.write(r6, r2, r7)     // Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x004a, all -> 0x0048 }
            goto L_0x0035
        L_0x0040:
            r8.closeEntry()     // Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x004a, all -> 0x0048 }
            r1.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x00c2
        L_0x0048:
            r6 = move-exception
            goto L_0x006c
        L_0x004a:
            r6 = move-exception
            r7 = r1
            goto L_0x0054
        L_0x004d:
            r6 = move-exception
            r7 = r1
            goto L_0x005e
        L_0x0050:
            r6 = move-exception
            r1 = r7
            goto L_0x006c
        L_0x0053:
            r6 = move-exception
        L_0x0054:
            r6.printStackTrace()     // Catch:{ all -> 0x0050 }
            if (r7 == 0) goto L_0x00c2
            r7.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x00c2
        L_0x005d:
            r6 = move-exception
        L_0x005e:
            r6.printStackTrace()     // Catch:{ all -> 0x0050 }
            if (r7 == 0) goto L_0x00c2
            r7.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x00c2
        L_0x0067:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x00c2
        L_0x006c:
            if (r1 == 0) goto L_0x0076
            r1.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0076:
            throw r6
        L_0x0077:
            java.lang.String[] r0 = r0.list()
            if (r0 == 0) goto L_0x00a1
            int r1 = r0.length
            if (r1 > 0) goto L_0x00a1
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r4 = java.io.File.separator
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r3)
            r8.putNextEntry(r1)     // Catch:{ IOException -> 0x009d }
            r8.closeEntry()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a1
        L_0x009d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00a1:
            if (r0 == 0) goto L_0x00c2
            int r1 = r0.length
        L_0x00a4:
            if (r2 >= r1) goto L_0x00c2
            r3 = r0[r2]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            m14278a(r6, r3, r8)
            int r2 = r2 + 1
            goto L_0x00a4
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.XZip.m14278a(java.lang.String, java.lang.String, java.util.zip.ZipOutputStream):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[SYNTHETIC, Splitter:B:25:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061 A[SYNTHETIC, Splitter:B:30:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b A[SYNTHETIC, Splitter:B:36:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0075 A[SYNTHETIC, Splitter:B:41:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080 A[SYNTHETIC, Splitter:B:46:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x008a A[SYNTHETIC, Splitter:B:51:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0052=Splitter:B:22:0x0052, B:33:0x0066=Splitter:B:33:0x0066} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zipFiles(java.lang.String r5, java.lang.String... r6) {
        /*
            java.lang.String r0 = "zipFiles(String, String...)"
            com.introvd.template.common.LogUtilsV2.m14230i(r0)
            r0 = 0
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ FileNotFoundException -> 0x0065, Exception -> 0x0051 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0065, Exception -> 0x0051 }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0065, Exception -> 0x0051 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0065, Exception -> 0x0051 }
            int r5 = r6.length     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            r0 = 0
        L_0x0012:
            if (r0 >= r5) goto L_0x003a
            r2 = r6[r0]     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            r3.<init>(r2)     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            java.lang.String r4 = r3.getParent()     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            r2.append(r4)     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            r2.append(r4)     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            java.lang.String r3 = r3.getName()     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            m14278a(r2, r3, r1)     // Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0048, all -> 0x0046 }
            int r0 = r0 + 1
            goto L_0x0012
        L_0x003a:
            r1.finish()     // Catch:{ IOException -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0042:
            r1.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0046:
            r5 = move-exception
            goto L_0x007e
        L_0x0048:
            r5 = move-exception
            r0 = r1
            goto L_0x0052
        L_0x004b:
            r5 = move-exception
            r0 = r1
            goto L_0x0066
        L_0x004e:
            r5 = move-exception
            r1 = r0
            goto L_0x007e
        L_0x0051:
            r5 = move-exception
        L_0x0052:
            r5.printStackTrace()     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x005f
            r0.finish()     // Catch:{ IOException -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005f:
            if (r0 == 0) goto L_0x007d
            r0.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0065:
            r5 = move-exception
        L_0x0066:
            r5.printStackTrace()     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0073
            r0.finish()     // Catch:{ IOException -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0073:
            if (r0 == 0) goto L_0x007d
            r0.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r5 = move-exception
            r5.printStackTrace()
        L_0x007d:
            return
        L_0x007e:
            if (r1 == 0) goto L_0x0088
            r1.finish()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0088:
            if (r1 == 0) goto L_0x0092
            r1.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0092:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.XZip.zipFiles(java.lang.String, java.lang.String[]):void");
    }
}
