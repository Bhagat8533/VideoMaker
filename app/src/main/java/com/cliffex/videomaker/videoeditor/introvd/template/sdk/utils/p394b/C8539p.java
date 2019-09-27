package com.introvd.template.sdk.utils.p394b;

import android.graphics.Bitmap;
import com.introvd.template.sdk.editor.cache.C8444e;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8569v;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;

/* renamed from: com.introvd.template.sdk.utils.b.p */
public class C8539p {
    private static volatile C8444e eif;

    /* renamed from: a */
    public static Bitmap m24891a(String str, int i, float f, float f2, QEngine qEngine) {
        long currentTimeMillis = System.currentTimeMillis();
        if (f <= 0.0f || f2 <= 0.0f) {
            return null;
        }
        if (f * f2 > 921600.0f) {
            VeMSize a = C8569v.m25057a(new VeMSize((int) f, (int) f2), new VeMSize((int) QUtils.VIDEO_RES_720P_HEIGHT, (int) QUtils.VIDEO_RES_720P_WIDTH));
            float f3 = (float) a.width;
            f2 = (float) a.height;
            f = f3;
        }
        float dI = (float) C8572y.m25087dI((int) f, 4);
        float dI2 = (float) C8572y.m25087dI((int) f2, 4);
        if (eif == null) {
            eif = new C8444e((int) dI, (int) dI2);
        } else {
            eif.mo34313dD((int) dI, (int) dI2);
        }
        QBitmap aIn = eif.aIn();
        if (aIn == null || QUtils.getAnimatedFrameBitmap(qEngine, str, i, aIn) != 0) {
            return null;
        }
        Bitmap createBitmapFromQBitmap = QAndroidBitmapFactory.createBitmapFromQBitmap(aIn, false);
        StringBuilder sb = new StringBuilder();
        sb.append("Jamin decode time = ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        C8554j.m25006d("XYSDKEffectThumbUtil", sb.toString());
        return createBitmapFromQBitmap;
    }

    public static void aJP() {
        if (eif != null) {
            eif.release();
            eif = null;
        }
    }
}
