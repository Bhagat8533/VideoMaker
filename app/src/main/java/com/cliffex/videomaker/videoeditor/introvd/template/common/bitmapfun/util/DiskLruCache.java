package com.introvd.template.common.bitmapfun.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.flurry.android.Constants;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.sdk.utils.p393a.C8484b;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import p503cz.msebera.android.httpclient.HttpHost;

public class DiskLruCache {
    private static File cdF;
    private int cdS = 0;
    private int cdT = 0;
    private final int cdU = 64;
    private long cdV = 5242880;
    private CompressFormat cdW = CompressFormat.JPEG;
    private int cdX = 85;
    private final Map<String, String> cdY = new LinkedHashMap(32, 0.75f, true);
    protected final File mCacheDir;

    private DiskLruCache(File file, long j) {
        this.mCacheDir = file;
        this.cdV = j;
    }

    /* renamed from: a */
    private static String m14289a(String str, CompressFormat compressFormat) {
        return m14296fm(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m14290a(android.graphics.Bitmap r4, java.lang.String r5, android.graphics.Bitmap.CompressFormat r6, int r7) throws java.io.IOException, java.io.FileNotFoundException {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x002a
            boolean r0 = r4.isRecycled()
            if (r0 != 0) goto L_0x002a
            if (r5 != 0) goto L_0x000b
            goto L_0x002a
        L_0x000b:
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0023 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0023 }
            r2.<init>(r5)     // Catch:{ all -> 0x0023 }
            r5 = 262144(0x40000, float:3.67342E-40)
            r1.<init>(r2, r5)     // Catch:{ all -> 0x0023 }
            boolean r4 = r4.compress(r6, r7, r1)     // Catch:{ all -> 0x0020 }
            r1.close()
            return r4
        L_0x0020:
            r4 = move-exception
            r0 = r1
            goto L_0x0024
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            if (r0 == 0) goto L_0x0029
            r0.close()
        L_0x0029:
            throw r4
        L_0x002a:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.DiskLruCache.m14290a(android.graphics.Bitmap, java.lang.String, android.graphics.Bitmap$CompressFormat, int):boolean");
    }

    /* renamed from: b */
    private static String m14291b(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        sb.append(File.separator);
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m14292b(File file, long j) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < listFiles.length; i++) {
                try {
                    if (listFiles[i] != null) {
                        if (listFiles[i].exists()) {
                            if (listFiles[i].isDirectory()) {
                                m14292b(listFiles[i], j);
                            } else if (listFiles[i].lastModified() + j < currentTimeMillis) {
                                listFiles[i].delete();
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: c */
    private static void m14293c(File file, final long j) {
        if (file != null) {
            new C8484b<Object, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Object... objArr) {
                    File file = objArr[0];
                    if (file == null) {
                        return null;
                    }
                    DiskLruCache.m14292b(file, j);
                    return null;
                }
            }.mo34652e(file);
        }
    }

    public static String createFilePath(File file, String str) {
        return m14291b(file, m14289a(str, null));
    }

    /* renamed from: fl */
    private static byte[] m14295fl(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (instance == null) {
                return str.getBytes();
            }
            instance.update(str.getBytes());
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str.getBytes();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void flushCache() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            java.util.Map<java.lang.String, java.lang.String> r1 = r6.cdY     // Catch:{ all -> 0x005a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r6)
            return
        L_0x000c:
            r1 = 4
            if (r0 >= r1) goto L_0x0058
            int r1 = r6.cdS     // Catch:{ all -> 0x005a }
            r2 = 64
            if (r1 > r2) goto L_0x001e
            int r1 = r6.cdT     // Catch:{ all -> 0x005a }
            long r1 = (long) r1     // Catch:{ all -> 0x005a }
            long r3 = r6.cdV     // Catch:{ all -> 0x005a }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0058
        L_0x001e:
            java.util.Map<java.lang.String, java.lang.String> r1 = r6.cdY     // Catch:{ all -> 0x005a }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x005a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x005a }
            java.lang.Object r1 = r1.next()     // Catch:{ all -> 0x005a }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x005a }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x005a }
            java.lang.Object r3 = r1.getValue()     // Catch:{ all -> 0x005a }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x005a }
            r2.<init>(r3)     // Catch:{ all -> 0x005a }
            long r2 = r2.length()     // Catch:{ all -> 0x005a }
            java.util.Map<java.lang.String, java.lang.String> r4 = r6.cdY     // Catch:{ all -> 0x005a }
            java.lang.Object r1 = r1.getKey()     // Catch:{ all -> 0x005a }
            r4.remove(r1)     // Catch:{ all -> 0x005a }
            java.util.Map<java.lang.String, java.lang.String> r1 = r6.cdY     // Catch:{ all -> 0x005a }
            int r1 = r1.size()     // Catch:{ all -> 0x005a }
            r6.cdS = r1     // Catch:{ all -> 0x005a }
            int r1 = r6.cdT     // Catch:{ all -> 0x005a }
            long r4 = (long) r1     // Catch:{ all -> 0x005a }
            long r4 = r4 - r2
            int r1 = (int) r4     // Catch:{ all -> 0x005a }
            r6.cdT = r1     // Catch:{ all -> 0x005a }
            int r0 = r0 + 1
            goto L_0x000c
        L_0x0058:
            monitor-exit(r6)
            return
        L_0x005a:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.DiskLruCache.flushCache():void");
    }

    /* renamed from: fm */
    private static String m14296fm(String str) {
        return toHexString(m14295fl(str), "");
    }

    public static File getDiskCacheDir(Context context, String str) {
        String path = Utils.getExternalCacheDir(context).getPath();
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        sb.append(File.separator);
        sb.append(".thumbnail");
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(File.separator);
            sb3.append(str);
            sb2 = sb3.toString();
        }
        return new File(sb2);
    }

    public static boolean isHttpFile(String str) {
        if (str == null || str.length() <= SocialService.CONST_URL_HTTP_PREFIX.length()) {
            return false;
        }
        return SocialService.CONST_URL_HTTP_PREFIX.equalsIgnoreCase(str.substring(0, SocialService.CONST_URL_HTTP_PREFIX.length()));
    }

    public static synchronized DiskLruCache openCache(Context context, File file, long j) {
        synchronized (DiskLruCache.class) {
            if (cdF == null) {
                cdF = getDiskCacheDir(context, HttpHost.DEFAULT_SCHEME_NAME);
                if (!cdF.exists()) {
                    cdF.mkdirs();
                }
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file.isDirectory() || !file.canWrite() || Utils.getUsableSpace(file) <= j) {
                return null;
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, j);
            return diskLruCache;
        }
    }

    private synchronized void put(String str, String str2) {
        this.cdY.put(str, str2);
        this.cdS = this.cdY.size();
        this.cdT = (int) (((long) this.cdT) + new File(str2).length());
    }

    private static String toHexString(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toHexString(b & Constants.UNKNOWN));
            sb.append(str);
        }
        return sb.toString();
    }

    /* renamed from: v */
    private static void m14297v(File file) {
        m14293c(file, 259200000);
    }

    public void clearCache() {
        m14297v(this.mCacheDir);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (new java.io.File(r0).exists() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (isHttpFile(r4) != false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        put(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        r0 = getFile(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if (r0 == null) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsKey(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.cdY     // Catch:{ all -> 0x002a }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x002a }
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            return r1
        L_0x000c:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            java.lang.String r0 = r3.getFile(r4)
            if (r0 == 0) goto L_0x0028
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x0028
            boolean r2 = isHttpFile(r4)
            if (r2 != 0) goto L_0x0027
            r3.put(r4, r0)
        L_0x0027:
            return r1
        L_0x0028:
            r4 = 0
            return r4
        L_0x002a:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.DiskLruCache.containsKey(java.lang.String):boolean");
    }

    public Bitmap get(String str) {
        String file = getFile(str);
        Bitmap bitmap = null;
        if (file == null) {
            return null;
        }
        try {
            if (!new File(file).exists()) {
                return null;
            }
            Bitmap decodeFileInStream = Utils.decodeFileInStream(file);
            try {
                new File(file).setLastModified(System.currentTimeMillis());
                return decodeFileInStream;
            } catch (Exception e) {
                e = e;
                bitmap = decodeFileInStream;
                e.printStackTrace();
                return bitmap;
            } catch (OutOfMemoryError e2) {
                e = e2;
                bitmap = decodeFileInStream;
                e.printStackTrace();
                return bitmap;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return bitmap;
        } catch (OutOfMemoryError e4) {
            e = e4;
            e.printStackTrace();
            return bitmap;
        }
    }

    public Bitmap get(String str, long j) {
        String file = getFile(str);
        Bitmap bitmap = null;
        if (file == null) {
            return null;
        }
        try {
            if (!new File(file).exists() || isCacheExpirationed(file, j)) {
                return null;
            }
            Bitmap decodeFileInStream = Utils.decodeFileInStream(file);
            try {
                new File(file).setLastModified(System.currentTimeMillis());
                return decodeFileInStream;
            } catch (Exception e) {
                e = e;
                bitmap = decodeFileInStream;
                e.printStackTrace();
                return bitmap;
            } catch (OutOfMemoryError e2) {
                e = e2;
                bitmap = decodeFileInStream;
                e.printStackTrace();
                return bitmap;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return bitmap;
        } catch (OutOfMemoryError e4) {
            e = e4;
            e.printStackTrace();
            return bitmap;
        }
    }

    public String getFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String a = m14289a(str, this.cdW);
        return isHttpFile(str) ? m14291b(cdF, a) : m14291b(this.mCacheDir, a);
    }

    public boolean isCacheExpirationed(String str, long j) {
        try {
            File file = new File(str);
            if (System.currentTimeMillis() - file.lastModified() <= j) {
                return false;
            }
            file.delete();
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        if (isHttpFile(r5) != false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        if (r0.endsWith(".jpg") == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        r2 = android.graphics.Bitmap.CompressFormat.JPEG;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        r2 = android.graphics.Bitmap.CompressFormat.PNG;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        if (m14290a(r6, r0, r2, r4.cdX) == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        flushCache();
        put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r0 = getFile(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        if (r0 != null) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String put(java.lang.String r5, android.graphics.Bitmap r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.cdY     // Catch:{ all -> 0x0038 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0038 }
            r1 = 0
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0038 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0038 }
            java.lang.String r0 = r4.getFile(r5)     // Catch:{ Throwable -> 0x0036 }
            if (r0 != 0) goto L_0x0014
            return r1
        L_0x0014:
            boolean r2 = isHttpFile(r5)     // Catch:{ Throwable -> 0x0036 }
            if (r2 != 0) goto L_0x0037
            java.lang.String r2 = ".jpg"
            boolean r2 = r0.endsWith(r2)     // Catch:{ Throwable -> 0x0036 }
            if (r2 == 0) goto L_0x0025
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Throwable -> 0x0036 }
            goto L_0x0027
        L_0x0025:
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Throwable -> 0x0036 }
        L_0x0027:
            int r3 = r4.cdX     // Catch:{ Throwable -> 0x0036 }
            boolean r6 = r4.m14290a(r6, r0, r2, r3)     // Catch:{ Throwable -> 0x0036 }
            if (r6 == 0) goto L_0x0037
            r4.flushCache()     // Catch:{ Throwable -> 0x0036 }
            r4.put(r5, r0)     // Catch:{ Throwable -> 0x0036 }
            goto L_0x0037
        L_0x0036:
            r0 = r1
        L_0x0037:
            return r0
        L_0x0038:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0038 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.DiskLruCache.put(java.lang.String, android.graphics.Bitmap):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|(1:9)|10|11|(1:15)|16|17|(1:19)) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void remove(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = isHttpFile(r7)     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r6)
            return
        L_0x0009:
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.cdY     // Catch:{ all -> 0x004e }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x004e }
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = r6.getFile(r7)     // Catch:{ all -> 0x004e }
        L_0x0017:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x003f }
            r1.<init>(r0)     // Catch:{ Exception -> 0x003f }
            boolean r0 = r1.exists()     // Catch:{ Exception -> 0x003f }
            if (r0 == 0) goto L_0x003f
            boolean r0 = r1.isFile()     // Catch:{ Exception -> 0x003f }
            if (r0 == 0) goto L_0x003f
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.cdY     // Catch:{ Exception -> 0x003f }
            int r0 = r0.size()     // Catch:{ Exception -> 0x003f }
            r6.cdS = r0     // Catch:{ Exception -> 0x003f }
            int r0 = r6.cdT     // Catch:{ Exception -> 0x003f }
            long r2 = (long) r0     // Catch:{ Exception -> 0x003f }
            long r4 = r1.length()     // Catch:{ Exception -> 0x003f }
            r0 = 0
            long r2 = r2 - r4
            int r0 = (int) r2     // Catch:{ Exception -> 0x003f }
            r6.cdT = r0     // Catch:{ Exception -> 0x003f }
            r1.delete()     // Catch:{ Exception -> 0x003f }
        L_0x003f:
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.cdY     // Catch:{ all -> 0x004e }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x004c
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.cdY     // Catch:{ all -> 0x004e }
            r0.remove(r7)     // Catch:{ all -> 0x004e }
        L_0x004c:
            monitor-exit(r6)
            return
        L_0x004e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.DiskLruCache.remove(java.lang.String):void");
    }

    public void setCompressParams(CompressFormat compressFormat, int i) {
        this.cdW = compressFormat;
        this.cdX = i;
    }
}
