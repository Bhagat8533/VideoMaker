package com.introvd.template.component.videofetcher.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

/* renamed from: com.introvd.template.component.videofetcher.utils.h */
public class C5490h {
    private LruCache<String, Bitmap> cmy = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8) {
        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int sizeOf(String str, Bitmap bitmap) {
            return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
        }
    };

    /* renamed from: b */
    public void mo27173b(String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(str) && bitmap != null && getBitmapFromMemCache(str) == null) {
            this.cmy.put(str, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (Bitmap) this.cmy.get(str);
    }
}
