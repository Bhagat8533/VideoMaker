package com.introvd.template.common.bitmapfun.util;

import android.content.Context;
import android.graphics.Bitmap;
import com.introvd.template.common.bitmapfun.util.ImageWorker.ImageWorkerListener;

public class ImageFetcherWithListener extends ImageFetcher implements ImageWorkerListener {
    private ImageWorker cei = null;
    private ImageWorker cej = null;

    public ImageFetcherWithListener(Context context, int i, int i2) {
        super(context, i, i2);
    }

    public String addBitmapToCache(Object obj, Bitmap bitmap) {
        if (obj == null || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (!DiskLruCache.isHttpFile(String.valueOf(obj)) && !(bitmap.getWidth() == this.mImageWidth && bitmap.getHeight() == this.mImageHeight)) {
            bitmap = Utils.convertToReqSize(bitmap, this.mImageWidth, this.mImageHeight, this.mThumbFitMode);
        }
        if (bitmap != null) {
            return this.mImageCache.addBitmapToCache(String.valueOf(obj), bitmap);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0045, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String addBitmapToDiskCache(java.lang.Object r5, android.graphics.Bitmap r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            if (r5 == 0) goto L_0x0044
            if (r6 == 0) goto L_0x0044
            boolean r1 = r6.isRecycled()     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x000d
            goto L_0x0044
        L_0x000d:
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0041 }
            boolean r1 = com.introvd.template.common.bitmapfun.util.DiskLruCache.isHttpFile(r1)     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x0031
            int r1 = r6.getWidth()     // Catch:{ all -> 0x0041 }
            int r2 = r4.mImageWidth     // Catch:{ all -> 0x0041 }
            if (r1 != r2) goto L_0x0027
            int r1 = r6.getHeight()     // Catch:{ all -> 0x0041 }
            int r2 = r4.mImageHeight     // Catch:{ all -> 0x0041 }
            if (r1 == r2) goto L_0x0031
        L_0x0027:
            int r1 = r4.mImageWidth     // Catch:{ all -> 0x0041 }
            int r2 = r4.mImageHeight     // Catch:{ all -> 0x0041 }
            int r3 = r4.mThumbFitMode     // Catch:{ all -> 0x0041 }
            android.graphics.Bitmap r6 = com.introvd.template.common.bitmapfun.util.Utils.convertToReqSize(r6, r1, r2, r3)     // Catch:{ all -> 0x0041 }
        L_0x0031:
            if (r6 == 0) goto L_0x003f
            com.introvd.template.common.bitmapfun.util.ImageCache r0 = r4.mImageCache     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = r0.addBitmapToDiskCache(r5, r6)     // Catch:{ all -> 0x0041 }
            monitor-exit(r4)
            return r5
        L_0x003f:
            monitor-exit(r4)
            return r0
        L_0x0041:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0044:
            monitor-exit(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.ImageFetcherWithListener.addBitmapToDiskCache(java.lang.Object, android.graphics.Bitmap):java.lang.String");
    }

    public Bitmap onGetThumbnailReady(Object obj, Bitmap bitmap) {
        if (this.mImageCache == null || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (!DiskLruCache.isHttpFile(String.valueOf(obj))) {
            bitmap = Utils.convertToReqSize(bitmap, this.mImageWidth, this.mImageHeight, this.mThumbFitMode);
        }
        if (bitmap == null) {
            return null;
        }
        this.mImageCache.addBitmapToDiskCache(String.valueOf(obj), bitmap);
        return bitmap;
    }

    public void release() {
        if (this.cei != null) {
            this.cei.setExitTasksEarly(true);
            this.cei.release();
        }
        this.cej = null;
        super.release();
    }

    public synchronized void setExitTasksEarly(boolean z) {
        if (this.cei != null) {
            this.cei.setExitTasksEarly(z);
        }
        if (this.cej != null) {
            this.cej.setExitTasksEarly(z);
        }
        super.setExitTasksEarly(z);
    }

    public void setGlobalImageWorker(ImageWorker imageWorker) {
        this.cej = imageWorker;
    }
}
