package com.introvd.template.common.bitmapfun.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.support.p021v4.util.LruCache;
import android.text.TextUtils;
import com.introvd.template.sdk.utils.C8554j;
import java.io.File;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ImageCache {
    /* access modifiers changed from: private */
    public static final CompressFormat cdZ = CompressFormat.JPEG;
    private int cea = 3;
    private String ceb = "None";
    protected DiskLruCache mDiskCache;
    protected LruCache<String, RecyclingBitmapDrawable> mMemoryCache;
    private Resources mResources;

    public static class ImageCacheParams {
        public boolean clearDiskCacheOnStart = true;
        public CompressFormat compressFormat = ImageCache.cdZ;
        public int compressQuality = 85;
        public boolean diskCacheEnabled = true;
        public int diskCacheSize = 2097152;
        public int memCacheSize = 5242880;
        public boolean memoryCacheEnabled = false;
        public String uniqueName;

        public ImageCacheParams(String str) {
            this.uniqueName = str;
            if (TextUtils.isEmpty(str)) {
                this.diskCacheEnabled = false;
            }
        }
    }

    public ImageCache(Context context, ImageCacheParams imageCacheParams) {
        m14299a(context, imageCacheParams);
    }

    /* renamed from: a */
    private void m14299a(Context context, ImageCacheParams imageCacheParams) {
        this.mResources = context.getResources();
        File diskCacheDir = DiskLruCache.getDiskCacheDir(context, imageCacheParams.uniqueName);
        imageCacheParams.memoryCacheEnabled = true;
        if (imageCacheParams.memCacheSize <= 0) {
            imageCacheParams.memCacheSize = 1;
        }
        if (imageCacheParams.diskCacheEnabled) {
            this.mDiskCache = DiskLruCache.openCache(context, diskCacheDir, (long) imageCacheParams.diskCacheSize);
            if (this.mDiskCache != null) {
                this.mDiskCache.setCompressParams(imageCacheParams.compressFormat, imageCacheParams.compressQuality);
                if (imageCacheParams.clearDiskCacheOnStart) {
                    this.mDiskCache.clearCache();
                }
            }
        }
        if (imageCacheParams.memoryCacheEnabled && imageCacheParams.memCacheSize > 0) {
            this.mMemoryCache = new LruCache<String, RecyclingBitmapDrawable>(imageCacheParams.memCacheSize) {
                /* renamed from: a */
                private int m14300a(BitmapDrawable bitmapDrawable) {
                    Bitmap bitmap = bitmapDrawable.getBitmap();
                    if (bitmap == null) {
                        return 1;
                    }
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int sizeOf(String str, RecyclingBitmapDrawable recyclingBitmapDrawable) {
                    int a = m14300a(recyclingBitmapDrawable);
                    if (a == 0) {
                        return 1;
                    }
                    return a;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void entryRemoved(boolean z, String str, RecyclingBitmapDrawable recyclingBitmapDrawable, RecyclingBitmapDrawable recyclingBitmapDrawable2) {
                    recyclingBitmapDrawable.setIsCached(false);
                }
            };
        }
        this.ceb = imageCacheParams.uniqueName;
        StringBuilder sb = new StringBuilder();
        sb.append("init ");
        sb.append(this.ceb);
        C8554j.m25007e("ImageCache", sb.toString());
    }

    private boolean isVideoFile(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.endsWith(".mp4") || lowerCase.endsWith(".3gp");
    }

    public String addBitmapToCache(String str, Bitmap bitmap) {
        try {
            addBitmapToMemCache(str, bitmap);
            return addBitmapToDiskCache(str, bitmap);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if ((r4.cea & 2) != 0) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String addBitmapToDiskCache(java.lang.String r5, android.graphics.Bitmap r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0038
            if (r6 == 0) goto L_0x0038
            boolean r1 = r6.isRecycled()     // Catch:{ Exception -> 0x0037 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0038
        L_0x000c:
            boolean r1 = r4.isVideoFile(r5)     // Catch:{ Exception -> 0x0037 }
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x001c
            int r1 = r4.cea     // Catch:{ Exception -> 0x0037 }
            r1 = r1 & 2
            if (r1 == 0) goto L_0x0022
        L_0x001a:
            r2 = 1
            goto L_0x0022
        L_0x001c:
            int r1 = r4.cea     // Catch:{ Exception -> 0x0037 }
            r1 = r1 & r3
            if (r1 == 0) goto L_0x0022
            goto L_0x001a
        L_0x0022:
            if (r2 == 0) goto L_0x0037
            com.introvd.template.common.bitmapfun.util.DiskLruCache r1 = r4.mDiskCache     // Catch:{ Exception -> 0x0037 }
            if (r1 == 0) goto L_0x0037
            com.introvd.template.common.bitmapfun.util.DiskLruCache r1 = r4.mDiskCache     // Catch:{ Exception -> 0x0037 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ Exception -> 0x0037 }
            if (r1 != 0) goto L_0x0037
            com.introvd.template.common.bitmapfun.util.DiskLruCache r1 = r4.mDiskCache     // Catch:{ Exception -> 0x0037 }
            java.lang.String r5 = r1.put(r5, r6)     // Catch:{ Exception -> 0x0037 }
            r0 = r5
        L_0x0037:
            return r0
        L_0x0038:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.ImageCache.addBitmapToDiskCache(java.lang.String, android.graphics.Bitmap):java.lang.String");
    }

    public void addBitmapToMemCache(String str, Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            addBitmapToMemCache(str, new RecyclingBitmapDrawable(this.mResources, bitmap));
        }
    }

    public void addBitmapToMemCache(String str, RecyclingBitmapDrawable recyclingBitmapDrawable) {
        if (str != null && recyclingBitmapDrawable != null) {
            try {
                if (this.mMemoryCache != null) {
                    RecyclingBitmapDrawable recyclingBitmapDrawable2 = (RecyclingBitmapDrawable) this.mMemoryCache.get(str);
                    if (recyclingBitmapDrawable2 != null) {
                        recyclingBitmapDrawable2.setIsCached(false);
                        this.mMemoryCache.remove(str);
                    }
                    recyclingBitmapDrawable.setIsCached(true);
                    this.mMemoryCache.put(str, recyclingBitmapDrawable);
                }
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void clearMemoryCaches(boolean z) {
        if (this.mMemoryCache != null) {
            Map snapshot = this.mMemoryCache.snapshot();
            if (snapshot != null && snapshot.size() > 0) {
                Set keySet = snapshot.keySet();
                if (keySet != null && keySet.size() > 0) {
                    String[] strArr = (String[]) keySet.toArray(new String[keySet.size()]);
                    if (strArr != null && strArr.length > 0) {
                        for (String remove : strArr) {
                            try {
                                ((RecyclingBitmapDrawable) this.mMemoryCache.remove(remove)).setIsCached(false);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            String str = "ImageCache";
            StringBuilder sb = new StringBuilder();
            sb.append("clearMemoryCaches ");
            sb.append(this.ceb);
            C8554j.m25007e(str, sb.toString());
        }
    }

    public RecyclingBitmapDrawable getBitmapDrawableFromMemCache(String str) {
        if (this.mMemoryCache == null) {
            return null;
        }
        return (RecyclingBitmapDrawable) this.mMemoryCache.get(str);
    }

    public Bitmap getBitmapFromDiskCache(String str) {
        if (this.mDiskCache != null) {
            return this.mDiskCache.get(str);
        }
        return null;
    }

    public Bitmap getBitmapFromDiskCache(String str, long j) {
        if (this.mDiskCache != null) {
            return this.mDiskCache.get(str, j);
        }
        return null;
    }

    public Bitmap getBitmapFromMemCache(String str) {
        RecyclingBitmapDrawable bitmapDrawableFromMemCache = getBitmapDrawableFromMemCache(str);
        if (bitmapDrawableFromMemCache == null) {
            return null;
        }
        return bitmapDrawableFromMemCache.getBitmap();
    }

    public void removeBitmapFromCache(String str, boolean z) {
        try {
            removeBitmapFromMemoryCache(str, z);
            removeBitmapFromDiskCache(str);
        } catch (Exception unused) {
        }
    }

    public void removeBitmapFromDiskCache(String str) {
        try {
            if (this.mDiskCache != null && this.mDiskCache.containsKey(str)) {
                this.mDiskCache.remove(str);
            }
        } catch (Exception unused) {
        }
    }

    public Bitmap removeBitmapFromMemoryCache(String str, boolean z) {
        try {
            if (!(this.mMemoryCache == null || this.mMemoryCache.get(str) == null)) {
                RecyclingBitmapDrawable recyclingBitmapDrawable = (RecyclingBitmapDrawable) this.mMemoryCache.remove(str);
                if (recyclingBitmapDrawable != null) {
                    recyclingBitmapDrawable.setIsCached(false);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void setDiskCacheMode(int i) {
        this.cea = i;
    }
}
