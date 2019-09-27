package com.introvd.template.sdk.utils;

import android.graphics.Bitmap;
import java.util.HashMap;

/* renamed from: com.introvd.template.sdk.utils.s */
public class C8564s {
    private static HashMap<Object, Bitmap> egT = new HashMap<>(20);
    private static C8564s egU = null;

    private C8564s() {
    }

    public static C8564s aJi() {
        if (egU != null) {
            return egU;
        }
        C8564s sVar = new C8564s();
        egU = sVar;
        return sVar;
    }

    /* renamed from: Y */
    public Bitmap mo34802Y(Object obj) {
        if (!(egT == null || obj == null)) {
            Bitmap bitmap = (Bitmap) egT.get(obj);
            if (bitmap != null && !bitmap.isRecycled()) {
                return bitmap;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo34803a(Object obj, Bitmap bitmap) {
        if (egT != null && obj != null && bitmap != null && !bitmap.isRecycled()) {
            egT.put(obj, bitmap.copy(bitmap.getConfig(), false));
        }
    }
}
