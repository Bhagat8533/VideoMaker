package com.introvd.template.component.videofetcher.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;

/* renamed from: com.introvd.template.component.videofetcher.utils.b */
public class C5484b {
    private static C5484b cmw;

    public static C5484b aaD() {
        if (cmw == null) {
            synchronized (C5484b.class) {
                if (cmw == null) {
                    cmw = new C5484b();
                }
            }
        }
        return cmw;
    }

    /* renamed from: fL */
    public int[] mo27172fL(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[]{1, 1};
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null) {
            return new int[]{1, 1};
        }
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        options.inJustDecodeBounds = false;
        return new int[]{width, height};
    }
}
