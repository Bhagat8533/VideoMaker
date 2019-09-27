package com.introvd.template.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.introvd.template.common.bitmapfun.util.ImageResizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import xiaoying.engine.base.QUtils;

/* renamed from: com.introvd.template.sdk.utils.d */
public class C8545d {
    public static final VeMSize egG = new VeMSize(960, (int) QUtils.VIDEO_RES_720P_HEIGHT);
    public static final VeMSize egH = new VeMSize((int) QUtils.VIDEO_RES_VGA_WIDTH, 480);

    /* renamed from: b */
    private static Bitmap m24985b(String str, VeMSize veMSize) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return ImageResizer.bilinearDecodeBitmapFromImageFile(str, veMSize.width, veMSize.height, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ae A[SYNTHETIC, Splitter:B:50:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ba A[SYNTHETIC, Splitter:B:59:0x00ba] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m24986e(java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            r1.<init>(r5)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            boolean r1 = r1.exists()     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            if (r1 != 0) goto L_0x0010
            return r0
        L_0x0010:
            r1 = 303(0x12f, float:4.25E-43)
            int r2 = com.introvd.template.sdk.utils.C8556l.GetFileMediaType(r5)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            if (r1 != r2) goto L_0x001a
            r1 = 1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            boolean r2 = m24987ob(r5)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            if (r2 != 0) goto L_0x0026
            if (r1 == 0) goto L_0x0025
            if (r7 != 0) goto L_0x0026
        L_0x0025:
            return r5
        L_0x0026:
            if (r1 == 0) goto L_0x0031
            if (r7 != 0) goto L_0x0031
            java.lang.String r2 = ".png"
            java.lang.String r2 = m24988u(r6, r5, r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            goto L_0x0037
        L_0x0031:
            java.lang.String r2 = ".jpg"
            java.lang.String r2 = m24988u(r6, r5, r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
        L_0x0037:
            if (r2 != 0) goto L_0x003a
            return r0
        L_0x003a:
            com.introvd.template.sdk.utils.VeMSize r3 = egH     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            boolean r4 = com.introvd.template.sdk.utils.C8549f.aJd()     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            if (r4 == 0) goto L_0x0044
            com.introvd.template.sdk.utils.VeMSize r3 = egG     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
        L_0x0044:
            android.graphics.Bitmap r3 = m24985b(r5, r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            if (r3 != 0) goto L_0x004b
            return r0
        L_0x004b:
            boolean r4 = com.introvd.template.sdk.utils.C8548e.isDirectoryExisted(r6)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            if (r4 != 0) goto L_0x0054
            com.introvd.template.sdk.utils.C8548e.createMultilevelDirectory(r6)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
        L_0x0054:
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            boolean r4 = r6.exists()     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            if (r4 == 0) goto L_0x0062
            r6.delete()     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
        L_0x0062:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            r4.<init>(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            r6.<init>(r4)     // Catch:{ Exception -> 0x00b7, all -> 0x00ab }
            r4 = 100
            if (r1 == 0) goto L_0x0078
            if (r7 != 0) goto L_0x0078
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            r3.compress(r5, r4, r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            goto L_0x009f
        L_0x0078:
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            r3.compress(r7, r4, r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            int r5 = com.introvd.template.common.bitmapfun.util.Utils.getFileOrientation(r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            android.media.ExifInterface r7 = new android.media.ExifInterface     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            r7.<init>(r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            java.lang.String r1 = "Model"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            r3.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            java.lang.String r4 = "XiaoYing@"
            r3.append(r4)     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            r3.append(r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            r7.setAttribute(r1, r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
            r7.saveAttributes()     // Catch:{ Exception -> 0x00b8, all -> 0x00a8 }
        L_0x009f:
            r6.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00a7:
            return r2
        L_0x00a8:
            r5 = move-exception
            r0 = r6
            goto L_0x00ac
        L_0x00ab:
            r5 = move-exception
        L_0x00ac:
            if (r0 == 0) goto L_0x00b6
            r0.close()     // Catch:{ IOException -> 0x00b2 }
            goto L_0x00b6
        L_0x00b2:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00b6:
            throw r5
        L_0x00b7:
            r6 = r0
        L_0x00b8:
            if (r6 == 0) goto L_0x00c2
            r6.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x00be:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00c2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8545d.m24986e(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: ob */
    private static boolean m24987ob(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options.outWidth * options.outHeight > 307200;
    }

    public static void saveBitmap(String str, Bitmap bitmap, int i) {
        if (str != null && bitmap != null) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    String upperCase = str.toUpperCase(Locale.US);
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    if (upperCase.endsWith(".PNG")) {
                        compressFormat = CompressFormat.PNG;
                    }
                    bitmap.compress(compressFormat, i, fileOutputStream);
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                } catch (FileNotFoundException unused2) {
                }
            } catch (IOException unused3) {
            }
        }
    }

    /* renamed from: u */
    public static String m24988u(String str, String str2, String str3) {
        File file;
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return null;
        }
        String substring = str2.substring(str2.lastIndexOf(47) + 1, lastIndexOf);
        if (str3 == null) {
            str3 = str2.substring(lastIndexOf);
        }
        int i = 0;
        do {
            i++;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(substring);
            sb.append("_");
            sb.append(i);
            sb.append(str3);
            file = new File(sb.toString());
            if (!file.isFile()) {
                break;
            }
        } while (file.exists());
        return file.getAbsolutePath();
    }
}
