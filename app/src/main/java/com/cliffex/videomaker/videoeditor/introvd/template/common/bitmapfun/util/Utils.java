package com.introvd.template.common.bitmapfun.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.text.TextUtils;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.utils.C8548e;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class Utils {
    private static final Config cdR = Config.RGB_565;

    public static int calculateBitmapCacheSize(int i, int i2, int i3) {
        int i4 = cdR == Config.RGB_565 ? i2 * 2 : cdR == Config.ARGB_8888 ? i2 * 4 : 0;
        return i * i4 * i3;
    }

    public static Bitmap convertToReqSize(Bitmap bitmap, int i, int i2, int i3) {
        Point point;
        if (bitmap == null || i == 0 || i2 == 0) {
            return bitmap;
        }
        if (i == bitmap.getWidth() && i2 == bitmap.getHeight()) {
            return bitmap;
        }
        switch (i3) {
            case 1:
                point = getFitinSize(new Point(bitmap.getWidth(), bitmap.getHeight()), new Point(i, i2), false);
                break;
            case 2:
                point = getFitoutSize(new Point(bitmap.getWidth(), bitmap.getHeight()), new Point(i, i2), false);
                break;
            default:
                point = new Point(i, i2);
                break;
        }
        return extractThumbnail(bitmap, point.x, point.y);
    }

    public static Bitmap decodeFileInStream(String str) {
        return decodeFileInStream(str, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038 A[SYNTHETIC, Splitter:B:17:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f A[SYNTHETIC, Splitter:B:24:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeFileInStream(java.lang.String r3, android.graphics.BitmapFactory.Options r4) {
        /*
            r0 = 0
            java.util.Locale r1 = java.util.Locale.US     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
            java.lang.String r1 = r3.toUpperCase(r1)     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
            java.lang.String r2 = ".PNG"
            boolean r1 = r1.endsWith(r2)     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
            if (r1 != 0) goto L_0x001d
            if (r4 != 0) goto L_0x0016
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
            r4.<init>()     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
        L_0x0016:
            android.graphics.Bitmap$Config r1 = cdR     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
            r4.inPreferredConfig = r1     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
            r1 = 1
            r4.inDither = r1     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
        L_0x001d:
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
            r1.<init>(r3)     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
            r3.<init>(r1)     // Catch:{ Throwable -> 0x003c, all -> 0x0035 }
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3, r0, r4)     // Catch:{ Throwable -> 0x0033, all -> 0x002f }
            r3.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0043
        L_0x002f:
            r4 = move-exception
            r0 = r3
            r3 = r4
            goto L_0x0036
        L_0x0033:
            goto L_0x003d
        L_0x0035:
            r3 = move-exception
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ IOException -> 0x003b }
        L_0x003b:
            throw r3
        L_0x003c:
            r3 = r0
        L_0x003d:
            if (r3 == 0) goto L_0x0042
            r3.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            r4 = r0
        L_0x0043:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.Utils.decodeFileInStream(java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static Bitmap extractThumbnail(Bitmap bitmap, int i, int i2) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i == 0) {
                i = Math.min(C8401d.MAX_EXPORT_RESOLUTION_WIDTH, width);
            }
            if (i2 == 0) {
                i2 = Math.min(C8401d.MAX_EXPORT_RESOLUTION_HEIGHT, height);
            }
            return (width == i && height == i2) ? bitmap : ThumbnailUtils.extractThumbnail(bitmap, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static File getExternalCacheDir(Context context) {
        return new File(C8401d.anf());
    }

    public static int getFileOrientation(String str) {
        int i = 0;
        if (str == null) {
            return 0;
        }
        if (!isVideoFile(str)) {
            ExifInterface exifInterface = null;
            try {
                exifInterface = new ExifInterface(str);
            } catch (IOException unused) {
            }
            i = ExThumbnailUtil.getOrientation(exifInterface);
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Point getFitinSize(android.graphics.Point r3, android.graphics.Point r4, boolean r5) {
        /*
            int r0 = r3.x
            int r3 = r3.y
            int r1 = r4.x
            int r4 = r4.y
            if (r0 > r1) goto L_0x001a
            if (r3 > r4) goto L_0x001a
            if (r5 == 0) goto L_0x0027
            int r5 = r0 * r4
            int r2 = r1 * r3
            if (r5 <= r2) goto L_0x0017
            int r3 = r2 / r0
            goto L_0x0022
        L_0x0017:
            int r0 = r5 / r3
            goto L_0x0026
        L_0x001a:
            int r5 = r0 * r4
            int r2 = r1 * r3
            if (r5 <= r2) goto L_0x0024
            int r3 = r2 / r0
        L_0x0022:
            r0 = r1
            goto L_0x0027
        L_0x0024:
            int r0 = r5 / r3
        L_0x0026:
            r3 = r4
        L_0x0027:
            r4 = 2
            if (r0 >= r4) goto L_0x002b
            r0 = 2
        L_0x002b:
            if (r3 >= r4) goto L_0x002e
            r3 = 2
        L_0x002e:
            int r4 = r3 % 2
            if (r4 == 0) goto L_0x0034
            int r3 = r3 + -1
        L_0x0034:
            int r4 = r0 % 2
            if (r4 == 0) goto L_0x003a
            int r0 = r0 + -1
        L_0x003a:
            android.graphics.Point r4 = new android.graphics.Point
            r4.<init>(r0, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.Utils.getFitinSize(android.graphics.Point, android.graphics.Point, boolean):android.graphics.Point");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Point getFitoutSize(android.graphics.Point r3, android.graphics.Point r4, boolean r5) {
        /*
            int r0 = r3.x
            int r3 = r3.y
            int r1 = r4.x
            int r4 = r4.y
            if (r0 <= r1) goto L_0x001b
            if (r3 > r4) goto L_0x000d
            goto L_0x001b
        L_0x000d:
            int r5 = r0 * r4
            int r2 = r1 * r3
            if (r5 <= r2) goto L_0x0017
            int r0 = r5 / r3
        L_0x0015:
            r3 = r4
            goto L_0x0029
        L_0x0017:
            int r3 = r2 / r0
        L_0x0019:
            r0 = r1
            goto L_0x0029
        L_0x001b:
            if (r5 == 0) goto L_0x0029
            int r5 = r0 * r4
            int r2 = r1 * r3
            if (r5 <= r2) goto L_0x0026
            int r0 = r5 / r3
            goto L_0x0015
        L_0x0026:
            int r3 = r2 / r0
            goto L_0x0019
        L_0x0029:
            r4 = 2
            if (r0 >= r4) goto L_0x002d
            r0 = 2
        L_0x002d:
            if (r3 >= r4) goto L_0x0030
            r3 = 2
        L_0x0030:
            int r4 = r3 % 2
            if (r4 == 0) goto L_0x0036
            int r3 = r3 + 1
        L_0x0036:
            int r4 = r0 % 2
            if (r4 == 0) goto L_0x003c
            int r0 = r0 + 1
        L_0x003c:
            android.graphics.Point r4 = new android.graphics.Point
            r4.<init>(r0, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.Utils.getFitoutSize(android.graphics.Point, android.graphics.Point, boolean):android.graphics.Point");
    }

    @TargetApi(9)
    public static long getUsableSpace(File file) {
        if (VERSION.SDK_INT >= 9) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    public static boolean isPhotoFile(String str) {
        if (str == null) {
            return false;
        }
        String fileType = C8548e.getFileType(str);
        if (TextUtils.isEmpty(fileType)) {
            return false;
        }
        String lowerCase = fileType.toLowerCase(Locale.US);
        return lowerCase.equals("jpg") || lowerCase.equals("png") || lowerCase.equals("bmp") || lowerCase.equals("jpeg") || lowerCase.equals("gif");
    }

    public static boolean isVideoFile(String str) {
        if (str == null) {
            return false;
        }
        String fileType = C8548e.getFileType(str);
        if (TextUtils.isEmpty(fileType)) {
            return false;
        }
        String lowerCase = fileType.toLowerCase(Locale.US);
        return lowerCase.equals("mp4") || lowerCase.equals("3gp") || lowerCase.equals("3g2") || lowerCase.equals("3gpp") || lowerCase.equals("mov") || lowerCase.equals("avi") || lowerCase.equals("wmv") || lowerCase.equals("rm") || lowerCase.equals("rmvb");
    }
}
