package com.introvd.template.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.StatFs;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.text.TextUtils;
import java.io.File;
import java.security.MessageDigest;

public class Utils {
    private static String appVersion = "";
    private static boolean cdw;
    private static final char[] cdx = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static HandlerThread cdy = null;

    /* renamed from: com.introvd.template.common.Utils$a */
    private static class C5254a extends HandlerThread {
        private boolean cdz = false;

        public C5254a(String str, int i) {
            super(str, i);
        }

        public void interrupt() {
        }

        public boolean quit() {
            return false;
        }

        public boolean quitSafely() {
            return false;
        }

        public synchronized void start() {
            if (!this.cdz) {
                super.start();
                this.cdz = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r7 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r7 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m14275a(android.net.Uri r7, android.content.Context r8) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Throwable -> 0x0032, all -> 0x002f }
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r7
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Throwable -> 0x0032, all -> 0x002f }
            if (r7 == 0) goto L_0x0029
            java.lang.String r8 = "_data"
            int r8 = r7.getColumnIndexOrThrow(r8)     // Catch:{ Throwable -> 0x0027 }
            boolean r1 = r7.moveToFirst()     // Catch:{ Throwable -> 0x0027 }
            if (r1 == 0) goto L_0x0029
            java.lang.String r8 = r7.getString(r8)     // Catch:{ Throwable -> 0x0027 }
            r0 = r8
            goto L_0x0029
        L_0x0027:
            r8 = move-exception
            goto L_0x0034
        L_0x0029:
            if (r7 == 0) goto L_0x004f
        L_0x002b:
            r7.close()
            goto L_0x004f
        L_0x002f:
            r8 = move-exception
            r7 = r0
            goto L_0x0051
        L_0x0032:
            r8 = move-exception
            r7 = r0
        L_0x0034:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
            r1.<init>()     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = "Exception ex:"
            r1.append(r2)     // Catch:{ all -> 0x0050 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0050 }
            r1.append(r8)     // Catch:{ all -> 0x0050 }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0050 }
            com.introvd.template.common.LogUtilsV2.m14228e(r8)     // Catch:{ all -> 0x0050 }
            if (r7 == 0) goto L_0x004f
            goto L_0x002b
        L_0x004f:
            return r0
        L_0x0050:
            r8 = move-exception
        L_0x0051:
            if (r7 == 0) goto L_0x0056
            r7.close()
        L_0x0056:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.Utils.m14275a(android.net.Uri, android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    private static String m14276a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return toHexString(instance.digest(), ":");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r3.length() <= 0) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAppVersion(android.content.Context r3) {
        /*
            java.lang.String r0 = appVersion
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x000b
            java.lang.String r3 = appVersion
            return r3
        L_0x000b:
            java.lang.String r0 = "0"
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x0027 }
            r2 = 0
            android.content.pm.PackageInfo r3 = r1.getPackageInfo(r3, r2)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r3 = r3.versionName     // Catch:{ Exception -> 0x0027 }
            if (r3 == 0) goto L_0x0024
            int r0 = r3.length()     // Catch:{ Exception -> 0x0028 }
            if (r0 > 0) goto L_0x0028
        L_0x0024:
            java.lang.String r0 = "0"
            return r0
        L_0x0027:
            r3 = r0
        L_0x0028:
            appVersion = r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.Utils.getAppVersion(android.content.Context):java.lang.String");
    }

    public static synchronized HandlerThread getHandlerThreadFromCommon() {
        HandlerThread handlerThread;
        synchronized (Utils.class) {
            if (cdy == null) {
                cdy = new C5254a("CommonHandlerThread", 10);
                cdy.start();
            }
            handlerThread = cdy;
        }
        return handlerThread;
    }

    public static String getMetaDataValue(Context context, String str, String str2) {
        Object obj = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                obj = applicationInfo.metaData.get(str);
            }
        } catch (Exception unused) {
        }
        return obj == null ? str2 : String.valueOf(obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r9 != null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (r9 != null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getRealPathFromURI(android.net.Uri r9, android.content.Context r10) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r4 = new java.lang.String[]{r0}
            r0 = 0
            android.support.v4.content.CursorLoader r8 = new android.support.v4.content.CursorLoader     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            r5 = 0
            r6 = 0
            r7 = 0
            r1 = r8
            r2 = r10
            r3 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            android.database.Cursor r9 = r8.loadInBackground()     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            if (r9 != 0) goto L_0x001e
            if (r9 == 0) goto L_0x001d
            r9.close()
        L_0x001d:
            return r0
        L_0x001e:
            java.lang.String r10 = "_data"
            int r10 = r9.getColumnIndexOrThrow(r10)     // Catch:{ Throwable -> 0x0035 }
            boolean r1 = r9.moveToFirst()     // Catch:{ Throwable -> 0x0035 }
            if (r1 == 0) goto L_0x002f
            java.lang.String r10 = r9.getString(r10)     // Catch:{ Throwable -> 0x0035 }
            r0 = r10
        L_0x002f:
            if (r9 == 0) goto L_0x0042
        L_0x0031:
            r9.close()
            goto L_0x0042
        L_0x0035:
            r10 = move-exception
            goto L_0x003c
        L_0x0037:
            r10 = move-exception
            r9 = r0
            goto L_0x0044
        L_0x003a:
            r10 = move-exception
            r9 = r0
        L_0x003c:
            r10.printStackTrace()     // Catch:{ all -> 0x0043 }
            if (r9 == 0) goto L_0x0042
            goto L_0x0031
        L_0x0042:
            return r0
        L_0x0043:
            r10 = move-exception
        L_0x0044:
            if (r9 == 0) goto L_0x0049
            r9.close()
        L_0x0049:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.Utils.getRealPathFromURI(android.net.Uri, android.content.Context):java.lang.String");
    }

    public static String getSignatureInfo(Context context, String str, String str2) {
        try {
            return m14276a(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray(), str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (r9 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        if (r9 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0071, code lost:
        return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri getURIFromRealPath(java.lang.String r9, android.content.Context r10) {
        /*
            int r0 = com.introvd.template.common.MediaFileUtils.GetFileMediaType(r9)
            boolean r1 = com.introvd.template.common.MediaFileUtils.IsVideoFileType(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000e
            android.net.Uri r0 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            goto L_0x0016
        L_0x000e:
            boolean r0 = com.introvd.template.common.MediaFileUtils.IsImageFileType(r0)
            if (r0 == 0) goto L_0x0079
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        L_0x0016:
            java.lang.String r1 = "_data"
            java.lang.String r3 = "_id"
            java.lang.String[] r5 = new java.lang.String[]{r1, r3}
            java.lang.String r6 = "_data = ?"
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Throwable -> 0x0069, all -> 0x0066 }
            r10 = 1
            java.lang.String[] r7 = new java.lang.String[r10]     // Catch:{ Throwable -> 0x0069, all -> 0x0066 }
            r10 = 0
            r7[r10] = r9     // Catch:{ Throwable -> 0x0069, all -> 0x0066 }
            r8 = 0
            r4 = r0
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Throwable -> 0x0069, all -> 0x0066 }
            if (r9 != 0) goto L_0x0038
            if (r9 == 0) goto L_0x0037
            r9.close()
        L_0x0037:
            return r2
        L_0x0038:
            java.lang.String r10 = "_id"
            int r10 = r9.getColumnIndexOrThrow(r10)     // Catch:{ Throwable -> 0x0064 }
            boolean r1 = r9.moveToFirst()     // Catch:{ Throwable -> 0x0064 }
            if (r1 == 0) goto L_0x005e
            int r10 = r9.getInt(r10)     // Catch:{ Throwable -> 0x0064 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0064 }
            r1.<init>()     // Catch:{ Throwable -> 0x0064 }
            java.lang.String r3 = ""
            r1.append(r3)     // Catch:{ Throwable -> 0x0064 }
            r1.append(r10)     // Catch:{ Throwable -> 0x0064 }
            java.lang.String r10 = r1.toString()     // Catch:{ Throwable -> 0x0064 }
            android.net.Uri r10 = android.net.Uri.withAppendedPath(r0, r10)     // Catch:{ Throwable -> 0x0064 }
            r2 = r10
        L_0x005e:
            if (r9 == 0) goto L_0x0071
        L_0x0060:
            r9.close()
            goto L_0x0071
        L_0x0064:
            r10 = move-exception
            goto L_0x006b
        L_0x0066:
            r10 = move-exception
            r9 = r2
            goto L_0x0073
        L_0x0069:
            r10 = move-exception
            r9 = r2
        L_0x006b:
            r10.printStackTrace()     // Catch:{ all -> 0x0072 }
            if (r9 == 0) goto L_0x0071
            goto L_0x0060
        L_0x0071:
            return r2
        L_0x0072:
            r10 = move-exception
        L_0x0073:
            if (r9 == 0) goto L_0x0078
            r9.close()
        L_0x0078:
            throw r10
        L_0x0079:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.Utils.getURIFromRealPath(java.lang.String, android.content.Context):android.net.Uri");
    }

    @TargetApi(9)
    public static long getUsableSpace(File file) {
        if (VERSION.SDK_INT >= 9) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    public static boolean isNewVersion(String str, String str2) {
        String str3;
        String str4;
        boolean z = false;
        if (str == null || str2 == null) {
            return false;
        }
        try {
            if (str2.equals(str)) {
                return false;
            }
            String valueOf = String.valueOf(str.replace("@", ""));
            String valueOf2 = String.valueOf(str2);
            int i = 0;
            int i2 = 0;
            while (true) {
                i = valueOf.indexOf(46, i);
                i2 = valueOf2.indexOf(46, i2);
                if (i != -1) {
                    String substring = valueOf.substring(0, i);
                    str3 = valueOf.substring(i + 1);
                    valueOf = substring;
                } else {
                    str3 = "";
                }
                if (i2 != -1) {
                    String substring2 = valueOf2.substring(0, i2);
                    str4 = valueOf2.substring(i2 + 1);
                    valueOf2 = substring2;
                } else {
                    str4 = "";
                }
                try {
                    int parseInt = TextUtils.isEmpty(valueOf2) ? 0 : Integer.parseInt(valueOf2);
                    int parseInt2 = TextUtils.isEmpty(valueOf) ? 0 : Integer.parseInt(valueOf);
                    if (parseInt == parseInt2) {
                        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                            break;
                        }
                        valueOf2 = str4;
                        valueOf = str3;
                    } else {
                        if (parseInt2 > parseInt) {
                            z = true;
                        }
                        return z;
                    }
                } catch (Exception unused) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused2) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r7.length() <= 0) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isOfficalVersion(android.content.Context r7) {
        /*
            boolean r0 = cdw
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r0 = "0.0.0.0"
            r2 = 0
            android.content.pm.PackageManager r3 = r7.getPackageManager()     // Catch:{ Exception -> 0x0021 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ Exception -> 0x0021 }
            android.content.pm.PackageInfo r7 = r3.getPackageInfo(r7, r2)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r7 = r7.versionName     // Catch:{ Exception -> 0x0021 }
            if (r7 == 0) goto L_0x001f
            int r0 = r7.length()     // Catch:{ Exception -> 0x0022 }
            if (r0 > 0) goto L_0x0022
        L_0x001f:
            java.lang.String r0 = "0.0.0.0"
        L_0x0021:
            r7 = r0
        L_0x0022:
            int r0 = r7.length()
            r3 = 0
            r4 = 0
        L_0x0028:
            if (r3 >= r0) goto L_0x0037
            char r5 = r7.charAt(r3)
            r6 = 46
            if (r5 != r6) goto L_0x0034
            int r4 = r4 + 1
        L_0x0034:
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0037:
            r7 = 2
            if (r4 > r7) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.Utils.isOfficalVersion(android.content.Context):boolean");
    }

    public static boolean isSupportedContentUri(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (!FileUtils.isFileExisted(uri.getPath()) && !FileUtils.isFileExisted(uri.getLastPathSegment())) {
            return m14277p(uri);
        }
        return true;
    }

    /* renamed from: p */
    private static boolean m14277p(Uri uri) {
        boolean z = false;
        if (uri == null) {
            return false;
        }
        if ("content".equals(uri.getScheme())) {
            String uri2 = uri.toString();
            if (uri2.startsWith(Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(Media.INTERNAL_CONTENT_URI.toString()) || uri2.startsWith(Video.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(Video.Media.INTERNAL_CONTENT_URI.toString())) {
                z = true;
            }
        }
        return z;
    }

    public static String parseInputUri(Uri uri, Context context, boolean z) {
        if (uri == null) {
            return null;
        }
        String str = "content".equals(uri.getScheme()) ? z ? m14275a(uri, context) : getRealPathFromURI(uri, context) : null;
        if (str == null) {
            String path = uri.getPath();
            if (FileUtils.isFileExisted(path)) {
                return path;
            }
            str = uri.getLastPathSegment();
        }
        if (!FileUtils.isFileExisted(str)) {
            return null;
        }
        return str;
    }

    public static String toHexString(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (i < bArr.length - 1) {
            sb.append(cdx[(bArr[i] & 240) >>> 4]);
            sb.append(cdx[bArr[i] & 15]);
            if (str != null) {
                sb.append(str);
            }
            i++;
        }
        sb.append(cdx[(bArr[i] & 240) >>> 4]);
        sb.append(cdx[bArr[i] & 15]);
        return sb.toString();
    }
}
