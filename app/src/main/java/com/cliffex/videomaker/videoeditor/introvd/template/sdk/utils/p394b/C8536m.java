package com.introvd.template.sdk.utils.p394b;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.introvd.template.common.bitmapfun.util.ImageFetcherWithListener;
import com.introvd.template.common.bitmapfun.util.ImageWorkerFactory;
import com.introvd.template.sdk.utils.C8500b;

/* renamed from: com.introvd.template.sdk.utils.b.m */
public class C8536m {
    public static final int cnS = C8500b.m24591P(50.0f);
    public static final int cnT = C8500b.m24591P(50.0f);
    private static ImageFetcherWithListener dgb = null;
    private static Bitmap eie = null;

    /* renamed from: K */
    public static Bitmap m24779K(String str, int i) {
        if (dgb == null || str == null) {
            return null;
        }
        return dgb.syncLoadImage(m24781M(str, i), null);
    }

    /* renamed from: L */
    public static void m24780L(String str, int i) {
        if (dgb != null && str != null) {
            dgb.removeBitmapFromCache(m24781M(str, i), true);
        }
    }

    /* renamed from: M */
    public static String m24781M(String str, int i) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf > 0) {
                int lastIndexOf2 = str.lastIndexOf(47, lastIndexOf - 1);
                if (lastIndexOf2 < 0) {
                    lastIndexOf2 = lastIndexOf;
                }
                str = str.substring(lastIndexOf2 + 1);
            }
        } else {
            str = str2;
        }
        String replace = str.replace(".", "_").replace("/", "_");
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append("_INX_");
        sb.append(i);
        sb.append(".jpg");
        return sb.toString();
    }

    /* renamed from: a */
    public static String m24782a(String str, int i, Bitmap bitmap) {
        if (dgb == null || str == null || bitmap == null) {
            return null;
        }
        return dgb.addBitmapToCache(m24781M(str, i), bitmap);
    }

    /* renamed from: a */
    public static synchronized void m24783a(Context context, Bitmap bitmap) {
        synchronized (C8536m.class) {
            if (dgb == null) {
                dgb = ImageWorkerFactory.CreateImageWorker(context, cnS, cnT, "ClipThumbs");
                dgb.setGlobalImageWorker(ImageWorkerFactory.getGlobalImageWorker(context));
            }
            if (eie == null) {
                eie = bitmap;
            }
        }
    }
}
