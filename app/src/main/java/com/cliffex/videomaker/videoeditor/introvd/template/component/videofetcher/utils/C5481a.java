package com.introvd.template.component.videofetcher.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;

/* renamed from: com.introvd.template.component.videofetcher.utils.a */
public class C5481a {

    /* renamed from: com.introvd.template.component.videofetcher.utils.a$a */
    private static class C5483a {
        /* access modifiers changed from: private */
        public static final C5481a cmv = new C5481a();
    }

    private C5481a() {
    }

    /* renamed from: a */
    private int m14886a(Options options, int i, int i2) {
        int i3 = 1;
        if (i == 0 || i2 == 0) {
            return 1;
        }
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i2 || i5 > i) {
            int i6 = i4 / 2;
            int i7 = i5 / 2;
            while (i6 / i3 >= i2 && i7 / i3 >= i) {
                i3 *= 2;
            }
        }
        return i3;
    }

    public static C5481a aaB() {
        return C5483a.cmv;
    }

    /* renamed from: b */
    public Bitmap mo27170b(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = ((float) i) / ((float) width);
        float f2 = ((float) i2) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* renamed from: c */
    public Bitmap mo27171c(String str, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = m14886a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }
}
