package com.introvd.template.common;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Locale;
import xiaoying.utils.QStreamAssets;

public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY = new File[0];
    public static final BigInteger ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
    public static final BigInteger ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
    public static final BigInteger ONE_KB_BI = BigInteger.valueOf(1024);
    public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);
    public static final BigInteger ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
    public static final BigInteger ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
    public static final BigInteger ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
    public static final BigInteger ONE_ZB = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
    public static final Charset UTF8 = Charset.forName("UTF-8");

    public static boolean copyDirectory(String str, String str2) {
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
        String[] list = file.list();
        boolean z = true;
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(list[i]);
                if (new File(sb3.toString()).isFile()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append(list[i]);
                    String sb5 = sb4.toString();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str2);
                    sb6.append(list[i]);
                    z = copyFile(sb5, sb6.toString());
                    if (!z) {
                        break;
                    }
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str2);
                    sb7.append(list[i]);
                    sb7.append(File.separator);
                    createMultilevelDirectory(sb7.toString());
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str);
                    sb8.append(list[i]);
                    String sb9 = sb8.toString();
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(str2);
                    sb10.append(list[i]);
                    z = copyDirectory(sb9, sb10.toString());
                    if (!z) {
                        break;
                    }
                }
            }
        }
        return z;
    }

    public static boolean copyFile(InputStream inputStream, OutputStream outputStream) {
        boolean z = false;
        if (inputStream == null || outputStream == null) {
            return false;
        }
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        outputStream.flush();
        z = true;
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0079 A[SYNTHETIC, Splitter:B:48:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0083 A[SYNTHETIC, Splitter:B:53:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x008f A[SYNTHETIC, Splitter:B:60:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0099 A[SYNTHETIC, Splitter:B:65:0x0099] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x00a2
            if (r5 == 0) goto L_0x00a2
            boolean r1 = r4.equals(r5)
            if (r1 == 0) goto L_0x000d
            goto L_0x00a2
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
            boolean r2 = r4.exists()
            if (r2 == 0) goto L_0x0031
            boolean r2 = r4.isDirectory()
            if (r2 != 0) goto L_0x0038
        L_0x0031:
            java.lang.String r5 = getFileParentPath(r5)
            createMultilevelDirectory(r5)
        L_0x0038:
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x006d }
            r1.<init>(r4)     // Catch:{ Exception -> 0x006d }
        L_0x0047:
            int r4 = r3.read(r5)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
            r2 = -1
            if (r4 == r2) goto L_0x0052
            r1.write(r5, r0, r4)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
            goto L_0x0047
        L_0x0052:
            r1.flush()     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
            r4 = 1
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005e:
            r3.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0066:
            return r4
        L_0x0067:
            r4 = move-exception
            r2 = r1
            goto L_0x008d
        L_0x006a:
            r4 = move-exception
            r2 = r1
            goto L_0x0074
        L_0x006d:
            r4 = move-exception
            goto L_0x0074
        L_0x006f:
            r4 = move-exception
            r3 = r2
            goto L_0x008d
        L_0x0072:
            r4 = move-exception
            r3 = r2
        L_0x0074:
            r4.printStackTrace()     // Catch:{ all -> 0x008c }
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0081:
            if (r3 == 0) goto L_0x008b
            r3.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r4 = move-exception
            r4.printStackTrace()
        L_0x008b:
            return r0
        L_0x008c:
            r4 = move-exception
        L_0x008d:
            if (r2 == 0) goto L_0x0097
            r2.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0097:
            if (r3 == 0) goto L_0x00a1
            r3.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a1
        L_0x009d:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00a1:
            throw r4
        L_0x00a2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.FileUtils.copyFile(java.lang.String, java.lang.String):boolean");
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

    public static boolean deleteFiles(String[] strArr) {
        if (strArr != null) {
            for (String deleteFile : strArr) {
                deleteFile(deleteFile);
            }
        }
        return true;
    }

    public static void deleteFolderSubFiles(String str, FilenameFilter filenameFilter) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(filenameFilter);
            if (listFiles != null && listFiles.length > 0) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isFile()) {
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    public static long fileSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return sizeOf(new File(str));
    }

    public static String formatFileSize(long j) {
        if (j < 1024) {
            return String.format(Locale.US, "%d B", new Object[]{Integer.valueOf((int) j)});
        } else if (j < 1048576) {
            return String.format(Locale.US, "%.2f KB", new Object[]{Float.valueOf(((float) j) / ((float) 1024))});
        } else if (j < 1073741824) {
            return String.format(Locale.US, "%.2f MB", new Object[]{Float.valueOf(((float) j) / ((float) 1048576))});
        } else {
            return String.format(Locale.US, "%.2f GB", new Object[]{Float.valueOf(((float) j) / ((float) 1073741824))});
        }
    }

    public static long getFileDate(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.lastModified();
        }
        return 0;
    }

    public static String getFileExtFromAbPath(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            int lastIndexOf = str.lastIndexOf(46);
            return lastIndexOf > 0 ? str.substring(lastIndexOf) : str2;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("exception ex=");
            sb.append(e.getMessage());
            LogUtilsV2.m14228e(sb.toString());
            return str2;
        }
    }

    public static String getFileName(String str) {
        String name = new File(str).getName();
        if (TextUtils.isEmpty(name)) {
            return name;
        }
        int lastIndexOf = name.lastIndexOf(".");
        return lastIndexOf > 0 ? name.substring(0, lastIndexOf) : name;
    }

    public static String getFileNameWithExt(String str) {
        if (str == null) {
            return null;
        }
        if (str.endsWith(File.separator)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf > 0) {
            str = str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static String getFileNameWithFormat(String str) {
        return new File(str).getName();
    }

    public static String getFileParentPath(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf <= 0) {
                return str2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, lastIndexOf));
            sb.append("/");
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String getFileType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return null;
        }
        return str.substring(lastIndexOf + 1).toUpperCase();
    }

    public static String getFreeFileName(String str, String str2, String str3, int i) {
        if (str == null || str2 == null || str3 == null) {
            return null;
        }
        if (!str.endsWith(File.separator)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(File.separator);
            str = sb.toString();
        }
        if (!str2.endsWith("_")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
            sb2.append(str3);
            String sb3 = sb2.toString();
            if (!isFileExisted(sb3)) {
                return sb3;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2);
            sb4.append("_");
            str2 = sb4.toString();
            if (i == 0) {
                i = 1;
            }
        }
        while (true) {
            String format = String.format(Locale.US, "%s%s%d%s", new Object[]{str, str2, Integer.valueOf(i), str3});
            if (!isFileExisted(format)) {
                return format;
            }
            i++;
        }
    }

    public static long getFreeSpace(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (str.startsWith(absolutePath)) {
            return new File(absolutePath).getUsableSpace();
        }
        File file = new File(str);
        while (true) {
            if (file.exists()) {
                break;
            }
            file = file.getParentFile();
            if (file != null) {
                if (file.getAbsolutePath().equals(File.separator)) {
                    break;
                }
            } else {
                file = new File(File.separator);
                break;
            }
        }
        return file.getUsableSpace();
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

    public static boolean isFileExisted(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(QStreamAssets.ASSETS_THEME)) {
            String substring = str.substring(QStreamAssets.ASSETS_THEME.length());
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            return ResourceUtils.isAssetsFileExisted(ResourceUtils.mAssetsManager, substring);
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            z = true;
        }
        return z;
    }

    public static boolean isSymlink(File file) throws IOException {
        if (file != null) {
            if (file.getParent() != null) {
                file = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            return !file.getCanonicalFile().equals(file.getAbsoluteFile());
        }
        throw new NullPointerException("File must not be null");
    }

    public static boolean isValidFileName(String str) {
        boolean z;
        boolean z2 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                z = file.isFile();
            } else {
                z = file.createNewFile();
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Throwable th) {
                    z2 = z;
                    th = th;
                    StringBuilder sb = new StringBuilder();
                    sb.append("IOException=");
                    sb.append(th.getMessage());
                    Log.e("exception", sb.toString());
                    z = z2;
                    return z;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("IOException=");
            sb2.append(th.getMessage());
            Log.e("exception", sb2.toString());
            z = z2;
            return z;
        }
        return z;
    }

    public static boolean renameFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str);
        return file.isFile() && file.renameTo(new File(str2));
    }

    public static long sizeOf(File file) {
        if (!file.exists()) {
            return 0;
        }
        return file.isDirectory() ? sizeOfDirectory(file) : file.length();
    }

    public static long sizeOfDirectory(File file) {
        try {
            m14220u(file);
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0;
            }
            long j = 0;
            for (File file2 : listFiles) {
                try {
                    if (!isSymlink(file2)) {
                        j += sizeOf(file2);
                        if (j < 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (IOException unused) {
                }
            }
            return j;
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* renamed from: u */
    private static void m14220u(File file) {
        if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(file);
            sb.append(" does not exist");
            throw new IllegalArgumentException(sb.toString());
        } else if (!file.isDirectory()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(file);
            sb2.append(" is not a directory");
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
