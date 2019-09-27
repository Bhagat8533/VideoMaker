package com.introvd.template.common.bitmapfun.util;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.introvd.template.sdk.utils.C8550g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DelayRecycleBitmapTask {
    /* access modifiers changed from: private */
    public static List<Bitmap> cdE = Collections.synchronizedList(new ArrayList());
    private static Handler mHandler;
    private static HandlerThread mHandlerThread;

    /* access modifiers changed from: private */
    /* renamed from: YZ */
    public static synchronized void m14287YZ() {
        synchronized (DelayRecycleBitmapTask.class) {
            if (cdE.size() != 0) {
                try {
                    ((Bitmap) cdE.remove(0)).recycle();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void delayRecycle(android.graphics.Bitmap r4) {
        /*
            java.lang.Class<com.introvd.template.common.bitmapfun.util.DelayRecycleBitmapTask> r0 = com.introvd.template.common.bitmapfun.util.DelayRecycleBitmapTask.class
            monitor-enter(r0)
            if (r4 == 0) goto L_0x002d
            boolean r1 = r4.isRecycled()     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x000c
            goto L_0x002d
        L_0x000c:
            init()     // Catch:{ all -> 0x002a }
            java.util.List<android.graphics.Bitmap> r1 = cdE     // Catch:{ all -> 0x002a }
            r1.add(r4)     // Catch:{ all -> 0x002a }
            android.os.Handler r4 = mHandler     // Catch:{ all -> 0x002a }
            r1 = 0
            java.util.List<android.graphics.Bitmap> r2 = cdE     // Catch:{ all -> 0x002a }
            int r2 = r2.size()     // Catch:{ all -> 0x002a }
            r3 = 1
            if (r2 <= r3) goto L_0x0023
            r2 = 50
            goto L_0x0025
        L_0x0023:
            r2 = 0
        L_0x0025:
            r4.sendEmptyMessageDelayed(r1, r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x002d:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.DelayRecycleBitmapTask.delayRecycle(android.graphics.Bitmap):void");
    }

    public static synchronized void init() {
        synchronized (DelayRecycleBitmapTask.class) {
            if (mHandlerThread == null) {
                mHandlerThread = C8550g.getHandlerThreadFromCommon();
            }
            if (mHandler == null) {
                mHandler = new Handler(mHandlerThread.getLooper()) {
                    public void handleMessage(Message message) {
                        DelayRecycleBitmapTask.m14287YZ();
                        removeMessages(0);
                        int size = DelayRecycleBitmapTask.cdE.size();
                        if (size > 0) {
                            sendEmptyMessageDelayed(0, size >= 10 ? 50 : 25);
                        }
                        super.handleMessage(message);
                    }
                };
            }
        }
    }
}
