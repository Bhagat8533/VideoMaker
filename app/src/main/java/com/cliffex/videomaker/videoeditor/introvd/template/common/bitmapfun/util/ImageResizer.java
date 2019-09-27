package com.introvd.template.common.bitmapfun.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ThumbnailUtils;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.utils.C8554j;

public class ImageResizer extends ImageWorker {
    public ImageResizer(Context context, int i, int i2) {
        super(context);
        setImageSize(i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d2, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.graphics.Bitmap bilinearDecodeBitmapFromImageFile(java.lang.String r10, int r11, int r12, boolean r13) {
        /*
            java.lang.Class<com.introvd.template.common.bitmapfun.util.ImageResizer> r0 = com.introvd.template.common.bitmapfun.util.ImageResizer.class
            monitor-enter(r0)
            r1 = 0
            int r2 = com.introvd.template.common.bitmapfun.util.Utils.getFileOrientation(r10)     // Catch:{ Throwable -> 0x00d5 }
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ Throwable -> 0x00d5 }
            r3.<init>()     // Catch:{ Throwable -> 0x00d5 }
            r4 = 1
            r3.inJustDecodeBounds = r4     // Catch:{ Throwable -> 0x00d5 }
            android.graphics.BitmapFactory.decodeFile(r10, r3)     // Catch:{ Throwable -> 0x00d5 }
            r4 = 0
            int r5 = calculateInSampleSize(r3, r11, r12, r4)     // Catch:{ Throwable -> 0x00d5 }
            r3.inJustDecodeBounds = r4     // Catch:{ Throwable -> 0x00d5 }
            r3.inSampleSize = r5     // Catch:{ Throwable -> 0x00d5 }
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeFile(r10, r3)     // Catch:{ Throwable -> 0x00d5 }
            if (r10 == 0) goto L_0x008a
            int r3 = r10.getWidth()     // Catch:{ Throwable -> 0x00d5 }
            int r5 = r10.getHeight()     // Catch:{ Throwable -> 0x00d5 }
            int r6 = r5 * 9
            int r7 = r3 * 10
            if (r6 < r7) goto L_0x0033
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x0033:
            if (r13 == 0) goto L_0x0040
            int r11 = r3 >> 2
            int r11 = r11 << 2
            int r12 = r5 >> 2
            int r12 = r12 << 2
            r13 = r11
            r6 = r12
            goto L_0x005a
        L_0x0040:
            int r13 = r11 * r5
            int r6 = r12 * r3
            if (r13 < r6) goto L_0x0050
            int r6 = r6 / r11
            int r13 = r6 >> 2
            int r13 = r13 << 2
            r6 = r12
            r12 = r13
            r13 = r11
            r11 = r3
            goto L_0x005a
        L_0x0050:
            int r13 = r13 / r12
            int r13 = r13 >> 2
            int r13 = r13 << 2
            r6 = r12
            r12 = r5
            r9 = r13
            r13 = r11
            r11 = r9
        L_0x005a:
            int r11 = java.lang.Math.min(r3, r11)     // Catch:{ Throwable -> 0x00d5 }
            int r12 = java.lang.Math.min(r5, r12)     // Catch:{ Throwable -> 0x00d5 }
            int r3 = r3 - r11
            int r3 = r3 / 2
            int r3 = r3 >> 2
            int r3 = r3 << 2
            int r5 = r5 - r12
            int r5 = r5 / 2
            int r5 = r5 >> 2
            int r5 = r5 << 2
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r10, r3, r5, r11, r12)     // Catch:{ Throwable -> 0x00d5 }
            android.graphics.Bitmap r12 = android.graphics.Bitmap.createScaledBitmap(r11, r13, r6, r4)     // Catch:{ Throwable -> 0x00d5 }
            if (r12 == r11) goto L_0x007e
            r11.recycle()     // Catch:{ Throwable -> 0x00d5 }
            r11 = r1
        L_0x007e:
            if (r11 == r10) goto L_0x008b
            boolean r11 = r10.isRecycled()     // Catch:{ Throwable -> 0x00d5 }
            if (r11 != 0) goto L_0x008b
            r10.recycle()     // Catch:{ Throwable -> 0x00d5 }
            goto L_0x008b
        L_0x008a:
            r12 = r1
        L_0x008b:
            if (r12 == 0) goto L_0x00d1
            int r10 = r12.getHeight()     // Catch:{ Throwable -> 0x00d5 }
            if (r10 <= 0) goto L_0x00d1
            int r10 = r12.getWidth()     // Catch:{ Throwable -> 0x00d5 }
            if (r10 > 0) goto L_0x009a
            goto L_0x00d1
        L_0x009a:
            android.graphics.Matrix r7 = new android.graphics.Matrix     // Catch:{ Throwable -> 0x00d5 }
            r7.<init>()     // Catch:{ Throwable -> 0x00d5 }
            float r10 = (float) r2     // Catch:{ Throwable -> 0x00d5 }
            r7.postRotate(r10)     // Catch:{ Throwable -> 0x00d5 }
            r3 = 0
            r4 = 0
            int r10 = r12.getWidth()     // Catch:{ Throwable -> 0x00c8, all -> 0x00c1 }
            int r10 = r10 >> 2
            int r5 = r10 << 2
            int r10 = r12.getHeight()     // Catch:{ Throwable -> 0x00c8, all -> 0x00c1 }
            int r10 = r10 >> 2
            int r6 = r10 << 2
            r8 = 1
            r2 = r12
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c1 }
            if (r12 == r10) goto L_0x00cf
            r12.recycle()     // Catch:{ Throwable -> 0x00d5 }
            goto L_0x00cf
        L_0x00c1:
            r10 = move-exception
            if (r12 == 0) goto L_0x00c7
            r12.recycle()     // Catch:{ Throwable -> 0x00d5 }
        L_0x00c7:
            throw r10     // Catch:{ Throwable -> 0x00d5 }
        L_0x00c8:
            if (r12 == 0) goto L_0x00ce
            r12.recycle()     // Catch:{ Throwable -> 0x00d5 }
        L_0x00ce:
            r10 = r1
        L_0x00cf:
            monitor-exit(r0)
            return r10
        L_0x00d1:
            monitor-exit(r0)
            return r1
        L_0x00d3:
            r10 = move-exception
            goto L_0x00db
        L_0x00d5:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x00d3 }
            monitor-exit(r0)
            return r1
        L_0x00db:
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.ImageResizer.bilinearDecodeBitmapFromImageFile(java.lang.String, int, int, boolean):android.graphics.Bitmap");
    }

    public static int calculateInSampleSize(Options options, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = options.outHeight;
        int i6 = options.outWidth;
        if (i == 0) {
            i = Math.min(C8401d.MAX_EXPORT_RESOLUTION_WIDTH, i6);
        }
        if (i2 == 0) {
            i2 = Math.min(C8401d.MAX_EXPORT_RESOLUTION_HEIGHT, i5);
        }
        boolean z2 = true;
        if (i5 <= i6 ? i >= i2 : i <= i2) {
            z2 = false;
        }
        if (!z2) {
            int i7 = i2;
            i2 = i;
            i = i7;
        }
        if (i5 <= i && i6 <= i2) {
            return 0;
        }
        if (z) {
            i3 = Math.round((((float) i5) * 1.0f) / ((float) i));
            i4 = Math.round((((float) i6) * 1.0f) / ((float) i2));
        } else {
            i3 = i5 / i;
            i4 = i6 / i2;
        }
        return Math.min(i3, i4);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i, int i2, int i3) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3, true);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    /* access modifiers changed from: protected */
    public Bitmap decodeSampledBitmapFromFile(Context context, String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2;
        try {
            int fileOrientation = Utils.getFileOrientation(str);
            boolean isPhotoFile = Utils.isPhotoFile(str);
            boolean isVideoFile = Utils.isVideoFile(str);
            if (isPhotoFile) {
                bitmap = getImageThumbFromFile(str, i, i2);
            } else if (!isVideoFile) {
                bitmap = getImageThumbFromFile(str, i, i2);
                if (bitmap == null) {
                    isVideoFile = true;
                }
            } else {
                bitmap = null;
            }
            if (bitmap == null && isVideoFile) {
                if (i == 0) {
                    i = C8401d.MAX_EXPORT_RESOLUTION_WIDTH;
                }
                if (i2 == 0) {
                    i2 = C8401d.MAX_EXPORT_RESOLUTION_HEIGHT;
                }
                bitmap = getVideoThumbFromFile(str, i, i2);
            }
            bitmap2 = bitmap;
            if (bitmap2 != null && bitmap2.getHeight() > 0) {
                if (bitmap2.getWidth() > 0) {
                    if (fileOrientation != 0) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate((float) fileOrientation);
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                        bitmap2.recycle();
                        bitmap2 = createBitmap;
                    }
                    return bitmap2;
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Bitmap getImageThumbFromFile(String str, int i, int i2) {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = calculateInSampleSize(options, i, i2, true);
            options.inJustDecodeBounds = false;
            return Utils.decodeFileInStream(str, options);
        } catch (Exception e) {
            e.printStackTrace();
            C8554j.m25007e("ImageResizer", "LoadBitmap2 load bitmap fail");
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            C8554j.m25007e("ImageResizer", "LoadBitmap2 out of memory");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Bitmap getVideoThumbFromFile(String str, int i, int i2) {
        Bitmap bitmap;
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            bitmap = ThumbnailUtils.createVideoThumbnail(str, 1);
        } catch (Exception e) {
            e.printStackTrace();
            C8554j.m25007e("ImageResizer", "LoadBitmap2 load bitmap fail");
            bitmap = null;
            return bitmap;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            C8554j.m25007e("ImageResizer", "LoadBitmap2 out of memory");
            bitmap = null;
            return bitmap;
        }
        return bitmap;
    }

    /* access modifiers changed from: protected */
    public Bitmap processBitmap(Object obj) {
        int i;
        try {
            i = Integer.parseInt(String.valueOf(obj));
        } catch (Exception unused) {
            i = 0;
        }
        return processBitmapWithResId(i);
    }

    /* access modifiers changed from: protected */
    public Bitmap processBitmapWithResId(int i) {
        return decodeSampledBitmapFromResource(this.mContext.getResources(), i, this.mImageWidth, this.mImageHeight);
    }
}
