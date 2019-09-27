package com.introvd.template.editor.p266h;

import android.text.TextUtils;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.crash.C5523b;
import com.introvd.template.sdk.p381b.p382a.C8386b;
import com.introvd.template.sdk.utils.C8553i;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.editor.h.f */
public class C6389f {
    /* access modifiers changed from: private */
    public static void asT() {
        LogUtilsV2.m14227d("initFDLicence");
        boolean z = false;
        try {
            String aHt = C8386b.aHt();
            C8553i.m25005ut(4);
            if (!C8386b.m24161ny(aHt)) {
                String str = "https://hybrid.xiaoying.tv/app/face/arcsoft_spotlight.license";
                if (!TextUtils.isEmpty(C3742b.m9111II().mo23119IM())) {
                    str = C3742b.m9111II().mo23119IM();
                }
                m18383c(aHt, str, false);
            }
        } catch (Throwable th) {
            C5523b.logException(th);
        }
        boolean isFileExisted = FileUtils.isFileExisted(C8386b.aHs());
        if (!isFileExisted || FileUtils.fileSize(C8386b.aHs()) <= 6291456) {
            z = isFileExisted;
        } else {
            FileUtils.deleteFile(C8386b.aHs());
        }
        if (!z) {
            String aHs = C8386b.aHs();
            if (!TextUtils.isEmpty(aHs)) {
                String IL = C3742b.m9111II().mo23118IL();
                if (TextUtils.isEmpty(IL)) {
                    IL = "http://hybrid.xiaoying.tv/vivavideo/track_data_v770.zip";
                }
                m18383c(aHs, IL, true);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0082 A[SYNTHETIC, Splitter:B:44:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087 A[Catch:{ IOException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0092 A[SYNTHETIC, Splitter:B:53:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0097 A[Catch:{ IOException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a2 A[SYNTHETIC, Splitter:B:62:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a7 A[Catch:{ IOException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00b2 A[SYNTHETIC, Splitter:B:71:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ba A[Catch:{ IOException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00c5 A[SYNTHETIC, Splitter:B:80:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00cd A[Catch:{ IOException -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:41:0x007d=Splitter:B:41:0x007d, B:50:0x008d=Splitter:B:50:0x008d, B:59:0x009d=Splitter:B:59:0x009d, B:68:0x00ad=Splitter:B:68:0x00ad} */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m18383c(java.lang.String r6, java.lang.String r7, boolean r8) {
        /*
            r0 = 0
            java.lang.String r1 = com.introvd.template.common.FileUtils.getFileNameWithExt(r6)     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            int r1 = r6.indexOf(r1)     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            r2 = 0
            java.lang.String r1 = r6.substring(r2, r1)     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            r3.append(r1)     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            java.lang.String r4 = "/data.zip"
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            if (r8 != 0) goto L_0x002b
            boolean r3 = com.introvd.template.common.FileUtils.isFileExisted(r6)     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            if (r3 == 0) goto L_0x002c
            com.introvd.template.common.FileUtils.deleteFile(r6)     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            goto L_0x002c
        L_0x002b:
            r6 = r3
        L_0x002c:
            java.net.URL r3 = new java.net.URL     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            r3.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            java.io.InputStream r7 = r3.openStream()     // Catch:{ FileNotFoundException -> 0x00ab, MalformedURLException -> 0x009b, IOException -> 0x008b, Exception -> 0x007b, all -> 0x0078 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0076, MalformedURLException -> 0x0074, IOException -> 0x0072, Exception -> 0x0070 }
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0076, MalformedURLException -> 0x0074, IOException -> 0x0072, Exception -> 0x0070 }
            r4.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0076, MalformedURLException -> 0x0074, IOException -> 0x0072, Exception -> 0x0070 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0076, MalformedURLException -> 0x0074, IOException -> 0x0072, Exception -> 0x0070 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ FileNotFoundException -> 0x006d, MalformedURLException -> 0x006a, IOException -> 0x0067, Exception -> 0x0064, all -> 0x0060 }
        L_0x0043:
            int r4 = r7.read(r0)     // Catch:{ FileNotFoundException -> 0x006d, MalformedURLException -> 0x006a, IOException -> 0x0067, Exception -> 0x0064, all -> 0x0060 }
            r5 = -1
            if (r4 <= r5) goto L_0x004e
            r3.write(r0, r2, r4)     // Catch:{ FileNotFoundException -> 0x006d, MalformedURLException -> 0x006a, IOException -> 0x0067, Exception -> 0x0064, all -> 0x0060 }
            goto L_0x0043
        L_0x004e:
            if (r8 == 0) goto L_0x0056
            com.introvd.template.common.XZip.UnZipFolder(r6, r1)     // Catch:{ FileNotFoundException -> 0x006d, MalformedURLException -> 0x006a, IOException -> 0x0067, Exception -> 0x0064, all -> 0x0060 }
            com.introvd.template.common.FileUtils.deleteFile(r6)     // Catch:{ FileNotFoundException -> 0x006d, MalformedURLException -> 0x006a, IOException -> 0x0067, Exception -> 0x0064, all -> 0x0060 }
        L_0x0056:
            r3.close()     // Catch:{ IOException -> 0x00b6 }
            if (r7 == 0) goto L_0x00c1
            r7.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00c1
        L_0x0060:
            r6 = move-exception
            r0 = r3
            goto L_0x00c3
        L_0x0064:
            r6 = move-exception
            r0 = r3
            goto L_0x007d
        L_0x0067:
            r6 = move-exception
            r0 = r3
            goto L_0x008d
        L_0x006a:
            r6 = move-exception
            r0 = r3
            goto L_0x009d
        L_0x006d:
            r6 = move-exception
            r0 = r3
            goto L_0x00ad
        L_0x0070:
            r6 = move-exception
            goto L_0x007d
        L_0x0072:
            r6 = move-exception
            goto L_0x008d
        L_0x0074:
            r6 = move-exception
            goto L_0x009d
        L_0x0076:
            r6 = move-exception
            goto L_0x00ad
        L_0x0078:
            r6 = move-exception
            r7 = r0
            goto L_0x00c3
        L_0x007b:
            r6 = move-exception
            r7 = r0
        L_0x007d:
            r6.printStackTrace()     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x0085
            r0.close()     // Catch:{ IOException -> 0x00b6 }
        L_0x0085:
            if (r7 == 0) goto L_0x00c1
            r7.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00c1
        L_0x008b:
            r6 = move-exception
            r7 = r0
        L_0x008d:
            r6.printStackTrace()     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x0095
            r0.close()     // Catch:{ IOException -> 0x00b6 }
        L_0x0095:
            if (r7 == 0) goto L_0x00c1
            r7.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00c1
        L_0x009b:
            r6 = move-exception
            r7 = r0
        L_0x009d:
            r6.printStackTrace()     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x00a5
            r0.close()     // Catch:{ IOException -> 0x00b6 }
        L_0x00a5:
            if (r7 == 0) goto L_0x00c1
            r7.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00c1
        L_0x00ab:
            r6 = move-exception
            r7 = r0
        L_0x00ad:
            r6.printStackTrace()     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x00b8
            r0.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00b8
        L_0x00b6:
            r6 = move-exception
            goto L_0x00be
        L_0x00b8:
            if (r7 == 0) goto L_0x00c1
            r7.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00c1
        L_0x00be:
            r6.printStackTrace()
        L_0x00c1:
            return
        L_0x00c2:
            r6 = move-exception
        L_0x00c3:
            if (r0 == 0) goto L_0x00cb
            r0.close()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00cb
        L_0x00c9:
            r7 = move-exception
            goto L_0x00d1
        L_0x00cb:
            if (r7 == 0) goto L_0x00d4
            r7.close()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00d4
        L_0x00d1:
            r7.printStackTrace()
        L_0x00d4:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.p266h.C6389f.m18383c(java.lang.String, java.lang.String, boolean):void");
    }

    public static void init() {
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                C6389f.asT();
            }
        });
    }
}
