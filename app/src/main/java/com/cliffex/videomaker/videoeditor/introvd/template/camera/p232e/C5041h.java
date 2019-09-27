package com.introvd.template.camera.p232e;

import android.content.res.Resources;
import android.media.SoundPool;
import android.util.SparseIntArray;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.e.h */
public class C5041h {
    private SoundPool cbX = new SoundPool(10, 3, 0);
    private SparseIntArray cbY = new SparseIntArray();

    public C5041h(Resources resources) {
        mo25895a(4097, resources, R.raw.cam_raw_capture);
        mo25895a(4101, resources, R.raw.cam_raw_autofocus_ok);
        mo25895a(4102, resources, R.raw.cam_raw_autofocus_error);
        mo25895a(4098, resources, R.raw.cam_raw_rec_start);
        mo25895a(4099, resources, R.raw.cam_raw_rec_stop);
        mo25895a(4100, resources, R.raw.cam_raw_timer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002a A[SYNTHETIC, Splitter:B:18:0x002a] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo25895a(int r3, android.content.res.Resources r4, int r5) {
        /*
            r2 = this;
            android.util.SparseIntArray r0 = r2.cbY
            if (r0 == 0) goto L_0x003e
            android.media.SoundPool r0 = r2.cbX
            if (r0 == 0) goto L_0x003e
            r0 = 0
            android.content.res.AssetFileDescriptor r4 = r4.openRawResourceFd(r5)     // Catch:{ Throwable -> 0x0033, all -> 0x0026 }
            if (r4 == 0) goto L_0x0020
            android.util.SparseIntArray r5 = r2.cbY     // Catch:{ Throwable -> 0x001e, all -> 0x001c }
            android.media.SoundPool r0 = r2.cbX     // Catch:{ Throwable -> 0x001e, all -> 0x001c }
            r1 = 1
            int r0 = r0.load(r4, r1)     // Catch:{ Throwable -> 0x001e, all -> 0x001c }
            r5.put(r3, r0)     // Catch:{ Throwable -> 0x001e, all -> 0x001c }
            goto L_0x0020
        L_0x001c:
            r3 = move-exception
            goto L_0x0028
        L_0x001e:
            goto L_0x0034
        L_0x0020:
            if (r4 == 0) goto L_0x003e
            r4.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x0026:
            r3 = move-exception
            r4 = r0
        L_0x0028:
            if (r4 == 0) goto L_0x0032
            r4.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0032:
            throw r3
        L_0x0033:
            r4 = r0
        L_0x0034:
            if (r4 == 0) goto L_0x003e
            r4.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p232e.C5041h.mo25895a(int, android.content.res.Resources, int):void");
    }

    /* renamed from: jO */
    public void mo25896jO(int i) {
        if (this.cbY != null && this.cbX != null) {
            this.cbX.play(this.cbY.get(i), 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public void release() {
        if (this.cbX != null) {
            this.cbX.release();
            this.cbX = null;
        }
        if (this.cbY != null) {
            this.cbY.clear();
            this.cbY = null;
        }
    }
}
