package com.introvd.template.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

public class StorageInfo {
    private static ArrayList<String> ccO;
    private static Context mContext;

    /* renamed from: HG */
    private static synchronized boolean m14259HG() {
        synchronized (StorageInfo.class) {
            if (ccO != null) {
                return true;
            }
            ccO = m14264x(mContext, true);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d5, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d6, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d8, code lost:
        r3 = null;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e9, code lost:
        if (r5.exists() != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00eb, code lost:
        r5.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f5, code lost:
        if (r5.exists() == false) goto L_0x0027;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d5 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e5 A[SYNTHETIC, Splitter:B:49:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f1 A[SYNTHETIC, Splitter:B:56:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0027 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String> m14260a(android.content.Context r8, java.util.ArrayList<java.lang.String> r9, boolean r10) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = ""
            if (r8 == 0) goto L_0x0022
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Android/data/"
            r1.append(r2)
            java.lang.String r8 = r8.getPackageName()
            r1.append(r8)
            java.lang.String r8 = java.io.File.separator
            r1.append(r8)
            java.lang.String r1 = r1.toString()
        L_0x0022:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0027:
            boolean r2 = r9.isEmpty()
            if (r2 != 0) goto L_0x00f8
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x00d8, all -> 0x00d5 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x00d8, all -> 0x00d5 }
            java.lang.String r2 = com.introvd.template.common.MD5.md5(r2)     // Catch:{ Throwable -> 0x00d8, all -> 0x00d5 }
            r3 = 0
            java.lang.Object r3 = r9.remove(r3)     // Catch:{ Throwable -> 0x00d8, all -> 0x00d5 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Throwable -> 0x00d8, all -> 0x00d5 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            r4.<init>()     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            r4.append(r3)     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            r4.append(r5)     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            r4.append(r1)     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            r4.append(r2)     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            java.lang.String r5 = ".dat"
            r4.append(r5)     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            java.io.File r5 = new java.io.File     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            r5.<init>(r4)     // Catch:{ Throwable -> 0x00d3, all -> 0x00d5 }
            java.lang.String r4 = r5.getParent()     // Catch:{ Throwable -> 0x00d1 }
            com.introvd.template.common.FileUtils.createMultilevelDirectory(r4)     // Catch:{ Throwable -> 0x00d1 }
            r5.createNewFile()     // Catch:{ Throwable -> 0x00d1 }
            boolean r4 = r5.exists()     // Catch:{ Throwable -> 0x00d1 }
            if (r4 == 0) goto L_0x00ca
            boolean r4 = r5.isFile()     // Catch:{ Throwable -> 0x00d1 }
            if (r4 != 0) goto L_0x0078
            goto L_0x00ca
        L_0x0078:
            int r4 = r9.size()     // Catch:{ Throwable -> 0x00d1 }
            int r4 = r4 + -1
        L_0x007e:
            if (r4 < 0) goto L_0x00b9
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00d1 }
            r6.<init>()     // Catch:{ Throwable -> 0x00d1 }
            java.lang.Object r7 = r9.get(r4)     // Catch:{ Throwable -> 0x00d1 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Throwable -> 0x00d1 }
            r6.append(r7)     // Catch:{ Throwable -> 0x00d1 }
            java.lang.String r7 = java.io.File.separator     // Catch:{ Throwable -> 0x00d1 }
            r6.append(r7)     // Catch:{ Throwable -> 0x00d1 }
            r6.append(r1)     // Catch:{ Throwable -> 0x00d1 }
            r6.append(r2)     // Catch:{ Throwable -> 0x00d1 }
            java.lang.String r7 = ".dat"
            r6.append(r7)     // Catch:{ Throwable -> 0x00d1 }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x00d1 }
            java.io.File r7 = new java.io.File     // Catch:{ Throwable -> 0x00d1 }
            r7.<init>(r6)     // Catch:{ Throwable -> 0x00d1 }
            boolean r6 = r7.exists()     // Catch:{ Throwable -> 0x00d1 }
            if (r6 == 0) goto L_0x00b6
            boolean r6 = r7.isFile()     // Catch:{ Throwable -> 0x00d1 }
            if (r6 == 0) goto L_0x00b6
            r9.remove(r4)     // Catch:{ Throwable -> 0x00d1 }
        L_0x00b6:
            int r4 = r4 + -1
            goto L_0x007e
        L_0x00b9:
            r8.add(r3)     // Catch:{ Throwable -> 0x00d1 }
            boolean r2 = r5.exists()     // Catch:{ Exception -> 0x00c7 }
            if (r2 == 0) goto L_0x0027
        L_0x00c2:
            r5.delete()     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0027
        L_0x00c7:
            goto L_0x0027
        L_0x00ca:
            boolean r2 = r5.exists()     // Catch:{ Exception -> 0x00c7 }
            if (r2 == 0) goto L_0x0027
            goto L_0x00c2
        L_0x00d1:
            goto L_0x00da
        L_0x00d3:
            r5 = r0
            goto L_0x00da
        L_0x00d5:
            r8 = move-exception
            r5 = r0
            goto L_0x00e3
        L_0x00d8:
            r3 = r0
            r5 = r3
        L_0x00da:
            if (r3 == 0) goto L_0x00ef
            if (r10 != 0) goto L_0x00ef
            r8.add(r3)     // Catch:{ all -> 0x00e2 }
            goto L_0x00ef
        L_0x00e2:
            r8 = move-exception
        L_0x00e3:
            if (r5 == 0) goto L_0x00ee
            boolean r9 = r5.exists()     // Catch:{ Exception -> 0x00ee }
            if (r9 == 0) goto L_0x00ee
            r5.delete()     // Catch:{ Exception -> 0x00ee }
        L_0x00ee:
            throw r8
        L_0x00ef:
            if (r5 == 0) goto L_0x0027
            boolean r2 = r5.exists()     // Catch:{ Exception -> 0x00c7 }
            if (r2 == 0) goto L_0x0027
            goto L_0x00c2
        L_0x00f8:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.StorageInfo.m14260a(android.content.Context, java.util.ArrayList, boolean):java.util.ArrayList");
    }

    public static synchronized void clear() {
        synchronized (StorageInfo.class) {
            if (ccO != null) {
                ccO.clear();
            }
            ccO = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getExtStorage() {
        /*
            java.lang.Class<com.introvd.template.common.StorageInfo> r0 = com.introvd.template.common.StorageInfo.class
            monitor-enter(r0)
            m14259HG()     // Catch:{ all -> 0x002b }
            java.util.ArrayList<java.lang.String> r1 = ccO     // Catch:{ all -> 0x002b }
            r2 = 0
            if (r1 == 0) goto L_0x0029
            java.util.ArrayList<java.lang.String> r1 = ccO     // Catch:{ all -> 0x002b }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0014
            goto L_0x0029
        L_0x0014:
            java.util.ArrayList<java.lang.String> r1 = ccO     // Catch:{ all -> 0x002b }
            int r1 = r1.size()     // Catch:{ all -> 0x002b }
            r3 = 1
            if (r1 > r3) goto L_0x001f
            monitor-exit(r0)
            return r2
        L_0x001f:
            java.util.ArrayList<java.lang.String> r1 = ccO     // Catch:{ all -> 0x002b }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x002b }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x002b }
            monitor-exit(r0)
            return r1
        L_0x0029:
            monitor-exit(r0)
            return r2
        L_0x002b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.StorageInfo.getExtStorage():java.lang.String");
    }

    public static synchronized String getMainStorage() {
        synchronized (StorageInfo.class) {
            m14259HG();
            if (ccO != null) {
                if (!ccO.isEmpty()) {
                    String str = (String) ccO.get(0);
                    return str;
                }
            }
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            return absolutePath;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getStorageRootPath() {
        /*
            java.lang.Class<com.introvd.template.common.StorageInfo> r0 = com.introvd.template.common.StorageInfo.class
            monitor-enter(r0)
            android.content.Context r1 = mContext     // Catch:{ all -> 0x0065 }
            r2 = 0
            java.util.ArrayList r1 = m14264x(r1, r2)     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0061
            int r3 = r1.size()     // Catch:{ all -> 0x0065 }
            if (r3 != 0) goto L_0x0013
            goto L_0x0061
        L_0x0013:
            int r3 = r1.size()     // Catch:{ all -> 0x0065 }
            r4 = 1
            if (r3 != r4) goto L_0x0022
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0065 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0065 }
            monitor-exit(r0)
            return r1
        L_0x0022:
            java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0065 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0065 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0065 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0065 }
            r3.<init>(r2)     // Catch:{ all -> 0x0065 }
        L_0x0033:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r4.<init>()     // Catch:{ all -> 0x0065 }
            r4.append(r2)     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ all -> 0x0065 }
            r4.append(r5)     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0065 }
            boolean r4 = r1.contains(r4)     // Catch:{ all -> 0x0065 }
            if (r4 != 0) goto L_0x005f
            java.io.File r3 = r3.getParentFile()     // Catch:{ all -> 0x0065 }
            if (r3 != 0) goto L_0x0053
            java.lang.String r2 = java.io.File.separator     // Catch:{ all -> 0x0065 }
            goto L_0x005f
        L_0x0053:
            java.lang.String r2 = r3.getAbsolutePath()     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ all -> 0x0065 }
            boolean r4 = r2.equals(r4)     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x0033
        L_0x005f:
            monitor-exit(r0)
            return r2
        L_0x0061:
            java.lang.String r1 = java.io.File.separator     // Catch:{ all -> 0x0065 }
            monitor-exit(r0)
            return r1
        L_0x0065:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.StorageInfo.getStorageRootPath():java.lang.String");
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            mContext = context.getApplicationContext();
        }
    }

    /* renamed from: u */
    private static String m14261u(Context context, boolean z) {
        try {
            String str = System.getenv("SECONDARY_STORAGE");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split(":");
            if (split != null) {
                if (split.length != 0) {
                    for (String str2 : split) {
                        if (str2 != null) {
                            File file = new File(str2);
                            if (file.isDirectory() && file.canWrite()) {
                                return file.getAbsolutePath();
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: v */
    private static ArrayList<String> m14262v(Context context, boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            arrayList.add(Environment.getExternalStorageDirectory().getAbsolutePath());
            File[] externalCacheDirs = context.getExternalCacheDirs();
            if (externalCacheDirs != null && externalCacheDirs.length > 0) {
                for (File file : externalCacheDirs) {
                    if (file != null && file.isDirectory()) {
                        if (file.canWrite()) {
                            String absolutePath = file.getAbsolutePath();
                            if (absolutePath != null) {
                                int indexOf = absolutePath.indexOf("/Android/");
                                if (indexOf > 0) {
                                    String substring = absolutePath.substring(0, indexOf);
                                    if (!arrayList.contains(substring)) {
                                        arrayList.add(substring);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    /* renamed from: w */
    private static ArrayList<String> m14263w(Context context, boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            arrayList.add(Environment.getExternalStorageDirectory().getAbsolutePath());
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                String absolutePath = externalCacheDir.getAbsolutePath();
                int indexOf = absolutePath.indexOf("/Android/");
                if (indexOf > 0) {
                    String substring = absolutePath.substring(0, indexOf);
                    if (!arrayList.contains(substring)) {
                        arrayList.add(substring);
                    }
                }
            }
            String u = m14261u(context, z);
            if (u != null && !arrayList.contains(u)) {
                arrayList.add(u);
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    /* renamed from: x */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String> m14264x(android.content.Context r3, boolean r4) {
        /*
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0020 }
            r2 = 19
            if (r1 < r2) goto L_0x000d
            java.util.ArrayList r1 = m14262v(r3, r4)     // Catch:{ Throwable -> 0x0020 }
        L_0x000b:
            r0 = r1
            goto L_0x0012
        L_0x000d:
            java.util.ArrayList r1 = m14263w(r3, r4)     // Catch:{ Throwable -> 0x0020 }
            goto L_0x000b
        L_0x0012:
            if (r0 == 0) goto L_0x0020
            int r1 = r0.size()     // Catch:{ Throwable -> 0x0020 }
            r2 = 1
            if (r1 <= r2) goto L_0x0020
            java.util.ArrayList r3 = m14260a(r3, r0, r4)     // Catch:{ Throwable -> 0x0020 }
            goto L_0x0021
        L_0x0020:
            r3 = r0
        L_0x0021:
            if (r3 != 0) goto L_0x0028
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x0028:
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0039
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = r4.getAbsolutePath()
            r3.add(r4)
        L_0x0039:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.StorageInfo.m14264x(android.content.Context, boolean):java.util.ArrayList");
    }
}
