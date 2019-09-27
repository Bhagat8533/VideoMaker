package com.introvd.template;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.SDCardManager;
import com.p131c.p132a.C2561a;
import java.io.File;

/* renamed from: com.introvd.template.g */
public class C4677g {
    public static final String TAG = "g";
    private static boolean bfR;

    /* renamed from: Gd */
    public static void m12174Gd() {
        FileUtils.createMultilevelDirectory(CommonConfigure.APP_PRIVATE_ROOT_PATH);
        m12179cT(CommonConfigure.APP_PRIVATE_ROOT_PATH);
        FileUtils.createMultilevelDirectory(CommonConfigure.APP_PUBLIC_ROOT_PATH);
        m12179cT(CommonConfigure.APP_PUBLIC_ROOT_PATH);
        FileUtils.createMultilevelDirectory(CommonConfigure.APP_DATA_PATH_INNER);
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DATA_PATH);
        sb.append("ini/");
        FileUtils.createMultilevelDirectory(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CommonConfigure.APP_DATA_PATH);
        sb2.append("ini/");
        m12179cT(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(CommonConfigure.APP_DATA_PATH);
        sb3.append("fdfile/");
        FileUtils.createMultilevelDirectory(sb3.toString());
        FileUtils.createMultilevelDirectory(CommonConfigure.APP_DEFAULTMUSIC_PATH);
        FileUtils.createMultilevelDirectory(CommonConfigure.getCameraVideoPath());
        FileUtils.createMultilevelDirectory(CommonConfigure.APP_DEFAULT_SOCIALCACHE_PATH);
        FileUtils.createMultilevelDirectory(CommonConfigure.APP_DOWNLOAD_TEMPLATES_PATH);
        FileUtils.createMultilevelDirectory(CommonConfigure.getProjectSavePath());
        FileUtils.createMultilevelDirectory(CommonConfigure.getMediaSavePath());
        m12179cT(CommonConfigure.getMediaSavePath());
        FileUtils.createMultilevelDirectory(CommonConfigure.getAudioSavePath());
        m12179cT(CommonConfigure.getAudioSavePath());
        FileUtils.createMultilevelDirectory(CommonConfigure.APP_DEFAULT_EXPORT_PATH);
        FileUtils.createMultilevelDirectory(CommonConfigure.APP_PRIVATE_FONT_PATH);
        FileUtils.createMultilevelDirectory(CommonConfigure.APP_PATH_INTERNAL_TEMPLATES);
    }

    /* renamed from: br */
    public static synchronized void m12175br(Context context) {
        synchronized (C4677g.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("createXYFileDir mInitedFileDir = ");
            sb.append(bfR);
            LogUtilsV2.m14227d(sb.toString());
            if (!bfR) {
                if (SDCardManager.hasSDCard()) {
                    m12176bs(context);
                    m12177bt(context);
                    bfR = true;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a2, code lost:
        if (r11 > 20971520) goto L_0x00a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ce A[Catch:{ Throwable -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d2 A[Catch:{ Throwable -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0110  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: bs */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m12176bs(android.content.Context r16) {
        /*
            java.lang.String r0 = com.introvd.template.common.StorageInfo.getMainStorage()
            java.lang.String r1 = com.introvd.template.common.StorageInfo.getExtStorage()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0016
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r0 = r0.getPath()
        L_0x0016:
            long r2 = com.introvd.template.common.FileUtils.getFreeSpace(r0)
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            r5 = 19
            r6 = 0
            r8 = 0
            r9 = 20971520(0x1400000, double:1.03613076E-316)
            if (r4 != 0) goto L_0x0067
            java.io.File r4 = new java.io.File
            r4.<init>(r1)
            boolean r11 = r4.isDirectory()
            if (r11 == 0) goto L_0x0039
            boolean r4 = r4.canWrite()
            if (r4 != 0) goto L_0x003a
        L_0x0039:
            r1 = r8
        L_0x003a:
            if (r1 == 0) goto L_0x0067
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r5) goto L_0x005b
            java.io.File[] r4 = r16.getExternalCacheDirs()     // Catch:{ Throwable -> 0x0045 }
            goto L_0x0046
        L_0x0045:
            r4 = r8
        L_0x0046:
            if (r4 == 0) goto L_0x0056
            int r4 = r4.length
            if (r4 == 0) goto L_0x0056
            long r11 = com.introvd.template.common.FileUtils.getFreeSpace(r1)
            int r4 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x0054
            goto L_0x0058
        L_0x0054:
            r1 = r0
            goto L_0x0058
        L_0x0056:
            r1 = r0
            r11 = r6
        L_0x0058:
            r4 = r1
            r1 = r8
            goto L_0x0069
        L_0x005b:
            long r11 = com.introvd.template.common.FileUtils.getFreeSpace(r1)
            int r4 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x0065
            r4 = r1
            goto L_0x0069
        L_0x0065:
            r4 = r0
            goto L_0x0069
        L_0x0067:
            r4 = r0
            r11 = r6
        L_0x0069:
            com.introvd.template.common.AppPreferencesSetting r8 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r13 = "pref_media_storage"
            r14 = 1
            java.lang.String r15 = java.lang.String.valueOf(r14)
            java.lang.String r8 = r8.getAppSettingStr(r13, r15)
            int r8 = com.p131c.p132a.p135c.C2575a.parseInt(r8)
            boolean r13 = android.text.TextUtils.isEmpty(r1)
            if (r13 != 0) goto L_0x00a5
            boolean r13 = r0.equals(r1)
            if (r13 != 0) goto L_0x00a5
            int r6 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0090
            long r11 = com.introvd.template.common.FileUtils.getFreeSpace(r1)
        L_0x0090:
            if (r8 != r14) goto L_0x009c
            int r6 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r6 >= 0) goto L_0x00a5
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x00a5
            r14 = 0
            goto L_0x00a6
        L_0x009c:
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x00a5
            int r2 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r14 = r8
        L_0x00a6:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x00ae
            if (r14 != 0) goto L_0x00af
        L_0x00ae:
            r1 = r0
        L_0x00af:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r3 = "/Android/data/"
            r2.append(r3)
            java.lang.String r3 = com.introvd.template.common.CommonConfigure.APP_PACKAGE_FULLNAME
            r2.append(r3)
            java.lang.String r3 = "/cache/"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x00d5 }
            if (r3 < r5) goto L_0x00d2
            r16.getExternalCacheDirs()     // Catch:{ Throwable -> 0x00d5 }
            goto L_0x00d5
        L_0x00d2:
            r16.getExternalCacheDir()     // Catch:{ Throwable -> 0x00d5 }
        L_0x00d5:
            com.introvd.template.common.FileUtils.createMultilevelDirectory(r2)
            boolean r3 = com.introvd.template.common.FileUtils.isDirectoryExisted(r2)
            if (r3 != 0) goto L_0x0103
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r4 = "/Android/data/"
            r3.append(r4)
            java.lang.String r4 = com.introvd.template.common.CommonConfigure.APP_PACKAGE_FULLNAME
            r3.append(r4)
            java.lang.String r4 = "/cache/"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            boolean r4 = r3.equals(r2)
            if (r4 != 0) goto L_0x0103
            com.introvd.template.common.FileUtils.createMultilevelDirectory(r3)
            r2 = r3
        L_0x0103:
            com.introvd.template.common.CommonConfigure.setAppCacheDir(r2)
            com.introvd.template.common.model.AppStateModel r2 = com.introvd.template.common.model.AppStateModel.getInstance()
            boolean r2 = r2.isInChina()
            if (r2 != 0) goto L_0x012b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "/"
            r2.append(r3)
            java.lang.String r3 = android.os.Environment.DIRECTORY_DCIM
            r2.append(r3)
            java.lang.String r3 = "/StarVideo/"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.introvd.template.common.CommonConfigure.setExportSubPath(r2)
        L_0x012b:
            com.introvd.template.common.CommonConfigure.setMainStoragePath(r0)
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0142
            long r2 = com.introvd.template.common.FileUtils.getFreeSpace(r1)
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0142
            com.introvd.template.common.CommonConfigure.setMediaStoragePath(r1)
            com.introvd.template.common.CommonConfigure.setExportStoragePath(r1)
        L_0x0142:
            java.lang.String r0 = com.introvd.template.common.CommonConfigure.APP_DEFAULT_SOCIALCACHE_PATH
            com.introvd.template.datacenter.SocialServiceDef.setSocialDownloadPath(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH
            r0.append(r1)
            java.lang.String r1 = "Templates/"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.introvd.template.common.CommonConfigure.APP_DOWNLOAD_TEMPLATES_PATH = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.C4677g.m12176bs(android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0164, code lost:
        return;
     */
    /* renamed from: bt */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void m12177bt(android.content.Context r12) {
        /*
            java.lang.Class<com.introvd.template.g> r0 = com.introvd.template.C4677g.class
            monitor-enter(r0)
            java.lang.String r1 = r12.getPackageName()     // Catch:{ all -> 0x0165 }
            java.lang.String r2 = "videoeditor.videomaker.slowmotions.starsleap"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0165 }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r0)
            return
        L_0x0011:
            java.lang.String r1 = com.introvd.template.common.StorageInfo.getMainStorage()     // Catch:{ all -> 0x0165 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0165 }
            if (r2 == 0) goto L_0x001d
            monitor-exit(r0)
            return
        L_0x001d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r2.<init>()     // Catch:{ all -> 0x0165 }
            r2.append(r1)     // Catch:{ all -> 0x0165 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ all -> 0x0165 }
            r2.append(r3)     // Catch:{ all -> 0x0165 }
            java.lang.String r3 = "XiaoYingPro"
            r2.append(r3)     // Catch:{ all -> 0x0165 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0165 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r3.<init>()     // Catch:{ all -> 0x0165 }
            r3.append(r1)     // Catch:{ all -> 0x0165 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ all -> 0x0165 }
            r3.append(r1)     // Catch:{ all -> 0x0165 }
            java.lang.String r1 = "XiaoYing"
            r3.append(r1)     // Catch:{ all -> 0x0165 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0165 }
            boolean r3 = com.introvd.template.common.FileUtils.isDirectoryExisted(r1)     // Catch:{ all -> 0x0165 }
            if (r3 != 0) goto L_0x0051
            monitor-exit(r0)
            return
        L_0x0051:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r3.<init>()     // Catch:{ all -> 0x0165 }
            r3.append(r2)     // Catch:{ all -> 0x0165 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ all -> 0x0165 }
            r3.append(r4)     // Catch:{ all -> 0x0165 }
            java.lang.String r4 = ".private"
            r3.append(r4)     // Catch:{ all -> 0x0165 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0165 }
            java.lang.String r12 = m12178bu(r12)     // Catch:{ all -> 0x0165 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0165 }
            r4.<init>(r3)     // Catch:{ all -> 0x0165 }
            com.introvd.template.g$1 r5 = new com.introvd.template.g$1     // Catch:{ all -> 0x0165 }
            r5.<init>(r12)     // Catch:{ all -> 0x0165 }
            java.lang.String[] r4 = r4.list(r5)     // Catch:{ all -> 0x0165 }
            if (r4 == 0) goto L_0x0080
            int r4 = r4.length     // Catch:{ all -> 0x0165 }
            if (r4 <= 0) goto L_0x0080
            monitor-exit(r0)
            return
        L_0x0080:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r4.<init>()     // Catch:{ all -> 0x0165 }
            r4.append(r1)     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ all -> 0x0165 }
            r4.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = ".private"
            r4.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0165 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0165 }
            r5.<init>(r4)     // Catch:{ all -> 0x0165 }
            com.introvd.template.g$2 r6 = new com.introvd.template.g$2     // Catch:{ all -> 0x0165 }
            r6.<init>(r12)     // Catch:{ all -> 0x0165 }
            java.lang.String[] r12 = r5.list(r6)     // Catch:{ all -> 0x0165 }
            if (r12 == 0) goto L_0x0163
            int r5 = r12.length     // Catch:{ all -> 0x0165 }
            if (r5 != 0) goto L_0x00ab
            goto L_0x0163
        L_0x00ab:
            m12179cT(r3)     // Catch:{ all -> 0x0165 }
            int r5 = r12.length     // Catch:{ all -> 0x0165 }
            r6 = 0
            r7 = 0
        L_0x00b1:
            if (r7 >= r5) goto L_0x00e3
            r8 = r12[r7]     // Catch:{ all -> 0x0165 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r9.<init>()     // Catch:{ all -> 0x0165 }
            r9.append(r4)     // Catch:{ all -> 0x0165 }
            java.lang.String r10 = java.io.File.separator     // Catch:{ all -> 0x0165 }
            r9.append(r10)     // Catch:{ all -> 0x0165 }
            r9.append(r8)     // Catch:{ all -> 0x0165 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0165 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r10.<init>()     // Catch:{ all -> 0x0165 }
            r10.append(r3)     // Catch:{ all -> 0x0165 }
            java.lang.String r11 = java.io.File.separator     // Catch:{ all -> 0x0165 }
            r10.append(r11)     // Catch:{ all -> 0x0165 }
            r10.append(r8)     // Catch:{ all -> 0x0165 }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x0165 }
            com.introvd.template.common.FileUtils.copyFile(r9, r8)     // Catch:{ all -> 0x0165 }
            int r7 = r7 + 1
            goto L_0x00b1
        L_0x00e3:
            java.io.File r12 = new java.io.File     // Catch:{ all -> 0x0165 }
            r12.<init>(r1)     // Catch:{ all -> 0x0165 }
            java.io.File[] r12 = r12.listFiles()     // Catch:{ all -> 0x0165 }
            if (r12 != 0) goto L_0x00f0
            monitor-exit(r0)
            return
        L_0x00f0:
            int r1 = r12.length     // Catch:{ all -> 0x0165 }
        L_0x00f1:
            if (r6 >= r1) goto L_0x0161
            r3 = r12[r6]     // Catch:{ all -> 0x0165 }
            boolean r4 = r3.isDirectory()     // Catch:{ all -> 0x0165 }
            if (r4 != 0) goto L_0x00fc
            goto L_0x015e
        L_0x00fc:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r4.<init>()     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = r3.getAbsolutePath()     // Catch:{ all -> 0x0165 }
            r4.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ all -> 0x0165 }
            r4.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = "database"
            r4.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0165 }
            boolean r4 = com.introvd.template.common.FileUtils.isDirectoryExisted(r4)     // Catch:{ all -> 0x0165 }
            if (r4 == 0) goto L_0x015e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r4.<init>()     // Catch:{ all -> 0x0165 }
            r4.append(r2)     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ all -> 0x0165 }
            r4.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = r3.getName()     // Catch:{ all -> 0x0165 }
            r4.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ all -> 0x0165 }
            r4.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = "database"
            r4.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0165 }
            com.introvd.template.common.FileUtils.createMultilevelDirectory(r4)     // Catch:{ all -> 0x0165 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r5.<init>()     // Catch:{ all -> 0x0165 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0165 }
            r5.append(r3)     // Catch:{ all -> 0x0165 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ all -> 0x0165 }
            r5.append(r3)     // Catch:{ all -> 0x0165 }
            java.lang.String r3 = "database"
            r5.append(r3)     // Catch:{ all -> 0x0165 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0165 }
            com.introvd.template.common.FileUtils.copyDirectory(r3, r4)     // Catch:{ all -> 0x0165 }
        L_0x015e:
            int r6 = r6 + 1
            goto L_0x00f1
        L_0x0161:
            monitor-exit(r0)
            return
        L_0x0163:
            monitor-exit(r0)
            return
        L_0x0165:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.C4677g.m12177bt(android.content.Context):void");
    }

    /* renamed from: bu */
    public static String m12178bu(Context context) {
        return isOfficalVersion(context) ? "global.db" : "internal.db";
    }

    /* renamed from: cT */
    public static void m12179cT(String str) {
        if (str != null) {
            if (!str.endsWith(File.separator)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(File.separator);
                str = sb.toString();
            }
            FileUtils.createMultilevelDirectory(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(".nomedia");
            File file = new File(sb2.toString());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                } else if (file.isDirectory()) {
                    file.delete();
                    file.createNewFile();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r6.length() <= 0) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isOfficalVersion(android.content.Context r6) {
        /*
            java.lang.String r0 = "0.0.0.0"
            r1 = 0
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch:{ Exception -> 0x001b }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x001b }
            android.content.pm.PackageInfo r6 = r2.getPackageInfo(r6, r1)     // Catch:{ Exception -> 0x001b }
            java.lang.String r6 = r6.versionName     // Catch:{ Exception -> 0x001b }
            if (r6 == 0) goto L_0x0019
            int r0 = r6.length()     // Catch:{ Exception -> 0x001c }
            if (r0 > 0) goto L_0x001c
        L_0x0019:
            java.lang.String r0 = "0.0.0.0"
        L_0x001b:
            r6 = r0
        L_0x001c:
            int r0 = r6.length()
            r2 = 0
            r3 = 0
        L_0x0022:
            if (r2 >= r0) goto L_0x0031
            char r4 = r6.charAt(r2)
            r5 = 46
            if (r4 != r5) goto L_0x002e
            int r3 = r3 + 1
        L_0x002e:
            int r2 = r2 + 1
            goto L_0x0022
        L_0x0031:
            r6 = 2
            if (r3 > r6) goto L_0x0035
            r1 = 1
        L_0x0035:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.C4677g.isOfficalVersion(android.content.Context):boolean");
    }

    /* renamed from: j */
    static void m12180j(Application application) {
        Log.d(TAG, "initAppRootPath = ");
        String str = C2561a.aOR() == 4 ? "XiaoYingPro" : C2561a.aOR() == 2 ? "XiaoYingLiteHuaWei" : C2561a.aOR() == 3 ? "XiaoYingLite" : C2561a.aOS() ? "VideoLeap" : "XiaoYing";
        String packageName = application.getPackageName();
        CommonConfigure.init(packageName, str);
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("packageName = ");
        sb.append(packageName);
        sb.append(", appRootDirName = ");
        sb.append(str);
        Log.d(str2, sb.toString());
    }
}
