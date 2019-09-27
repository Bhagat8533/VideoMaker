package com.introvd.template.common.bitmapfun;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

public class RecyclingBitmapDrawable extends BitmapDrawable {
    private int cdM;
    private int cdN;
    private boolean cdO;
    private boolean cdP;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0016, code lost:
        return r1;
     */
    /* renamed from: Za */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m14285Za() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.cdP     // Catch:{ all -> 0x0017 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r2)
            return r1
        L_0x0008:
            android.graphics.Bitmap r0 = r2.getBitmap()     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0015
            boolean r0 = r0.isRecycled()     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x0015
            r1 = 1
        L_0x0015:
            monitor-exit(r2)
            return r1
        L_0x0017:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.RecyclingBitmapDrawable.m14285Za():boolean");
    }

    private synchronized void checkState() {
        if (this.cdM <= 0 && this.cdN <= 0 && this.cdO && m14285Za()) {
            Bitmap bitmap = getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                DelayRecycleBitmapTask.delayRecycle(bitmap);
                this.cdP = true;
            }
        }
    }

    public void draw(Canvas canvas) {
        if (m14285Za()) {
            super.draw(canvas);
        }
    }

    public void setIsDisplayed(boolean z) {
        synchronized (this) {
            if (z) {
                try {
                    this.cdN++;
                    this.cdO = true;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            } else {
                this.cdN--;
            }
        }
        checkState();
    }
}
