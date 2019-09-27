package com.introvd.template.common.bitmapfun.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.introvd.template.sdk.utils.p393a.C8484b;
import com.introvd.template.sdk.utils.p393a.C8493d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import xiaoying.engine.base.QUtils;

public abstract class ImageWorker {
    /* access modifiers changed from: private */
    public static Map<String, Long> cdK = Collections.synchronizedMap(new LinkedHashMap());
    private static long cdL = 0;
    private static final Executor mExecutor = new C8493d("ImageWork", 2, 10, 5);
    /* access modifiers changed from: private */
    public String cek = null;
    /* access modifiers changed from: private */
    public int cel = 0;
    /* access modifiers changed from: private */
    public long cem = 0;
    private Bitmap cen = null;
    private boolean ceo = false;
    private Bitmap ceq = null;
    private boolean cer = false;
    private int ces = 1;
    /* access modifiers changed from: private */
    public boolean cet = false;
    private Map<Long, WeakReference<C5263b>> ceu = new LinkedHashMap();
    private int cev = 255;
    private Executor cew = mExecutor;
    protected Context mContext;
    protected ImageCache mImageCache;
    protected int mImageHeight;
    protected int mImageHeightMaxSync = 480;
    protected int mImageWidth;
    protected int mImageWidthMaxSync = QUtils.VIDEO_RES_VGA_WIDTH;
    protected int mLoadMode = 196610;
    protected int mThreadPriority = 10;
    protected int mThumbFitMode = 0;
    protected String mstrTag = "None";

    public interface ImageWorkerListener {
        Bitmap onGetThumbnailReady(Object obj, Bitmap bitmap);
    }

    public interface RecyclingImageViewListener {
        Drawable getOriDrawable();
    }

    /* renamed from: com.introvd.template.common.bitmapfun.util.ImageWorker$a */
    private static class C5262a extends BitmapDrawable {
        private final WeakReference<C5263b> cex;

        /* renamed from: Zd */
        public C5263b mo26522Zd() {
            return (C5263b) this.cex.get();
        }

        public void draw(Canvas canvas) {
            try {
                super.draw(canvas);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.introvd.template.common.bitmapfun.util.ImageWorker$b */
    private class C5263b extends C8484b<Object, Void, RecyclingBitmapDrawable> {
        private int ceA;
        private boolean ceB;
        private boolean ceC;
        final /* synthetic */ ImageWorker ceD;
        private final WeakReference<ImageView> cey;
        private final ImageWorkerListener cez;
        private Object data;

        /* renamed from: id */
        private final long f3447id;

        /* renamed from: Zf */
        private ImageView m14323Zf() {
            ImageView imageView = (ImageView) this.cey.get();
            if (this == ImageWorker.m14320l(imageView)) {
                return imageView;
            }
            return null;
        }

        /* renamed from: a */
        private void m14324a(RecyclingBitmapDrawable recyclingBitmapDrawable) {
            if (recyclingBitmapDrawable != null) {
                if (this.ceC && this.data != null) {
                    this.ceD.mImageCache.removeBitmapFromMemoryCache(String.valueOf(this.data), false);
                }
                recyclingBitmapDrawable.setIsDisplayed(true);
                recyclingBitmapDrawable.setIsDisplayed(false);
                recyclingBitmapDrawable.setIsCached(false);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: Ze */
        public long mo26524Ze() {
            return this.f3447id;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x012a A[Catch:{ Throwable -> 0x0174 }] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0135 A[Catch:{ Throwable -> 0x0174 }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0137 A[Catch:{ Throwable -> 0x0174 }] */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x013e A[Catch:{ Throwable -> 0x0174 }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.introvd.template.common.bitmapfun.util.RecyclingBitmapDrawable doInBackground(java.lang.Object... r12) {
            /*
                r11 = this;
                int r0 = r11.ceA     // Catch:{ Throwable -> 0x0005 }
                android.os.Process.setThreadPriority(r0)     // Catch:{ Throwable -> 0x0005 }
            L_0x0005:
                r0 = 0
                com.introvd.template.common.bitmapfun.util.ImageWorker r1 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.ImageCache r1 = r1.mImageCache     // Catch:{ Throwable -> 0x0174 }
                if (r1 != 0) goto L_0x000d
                return r0
            L_0x000d:
                boolean r1 = r11.isCancelled()     // Catch:{ Throwable -> 0x0174 }
                if (r1 != 0) goto L_0x0173
                android.widget.ImageView r1 = r11.m14323Zf()     // Catch:{ Throwable -> 0x0174 }
                if (r1 == 0) goto L_0x0173
                java.lang.ref.WeakReference<android.widget.ImageView> r1 = r11.cey     // Catch:{ Throwable -> 0x0174 }
                java.lang.Object r1 = r1.get()     // Catch:{ Throwable -> 0x0174 }
                if (r1 == 0) goto L_0x0173
                com.introvd.template.common.bitmapfun.util.ImageWorker r1 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                boolean r1 = r1.cet     // Catch:{ Throwable -> 0x0174 }
                if (r1 == 0) goto L_0x002b
                goto L_0x0173
            L_0x002b:
                r1 = 0
                r2 = r12[r1]     // Catch:{ Throwable -> 0x0174 }
                r11.data = r2     // Catch:{ Throwable -> 0x0174 }
                java.lang.Object r2 = r11.data     // Catch:{ Throwable -> 0x0174 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.ImageWorker r3 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.ImageCache r3 = r3.mImageCache     // Catch:{ Throwable -> 0x0174 }
                java.lang.Object r4 = r11.data     // Catch:{ Throwable -> 0x0174 }
                java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.RecyclingBitmapDrawable r3 = r3.getBitmapDrawableFromMemCache(r4)     // Catch:{ Throwable -> 0x0174 }
                r4 = 1
                if (r3 == 0) goto L_0x004b
                r3.setIsCached(r4)     // Catch:{ Throwable -> 0x0174 }
                return r3
            L_0x004b:
                com.introvd.template.common.bitmapfun.util.ImageWorker r3 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                long r5 = r3.cem     // Catch:{ Throwable -> 0x0174 }
                r7 = 0
                int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r3 <= 0) goto L_0x0066
                com.introvd.template.common.bitmapfun.util.ImageWorker r3 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.ImageCache r3 = r3.mImageCache     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.ImageWorker r5 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                long r5 = r5.cem     // Catch:{ Throwable -> 0x0174 }
                android.graphics.Bitmap r3 = r3.getBitmapFromDiskCache(r2, r5)     // Catch:{ Throwable -> 0x0174 }
                goto L_0x006e
            L_0x0066:
                com.introvd.template.common.bitmapfun.util.ImageWorker r3 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.ImageCache r3 = r3.mImageCache     // Catch:{ Throwable -> 0x0174 }
                android.graphics.Bitmap r3 = r3.getBitmapFromDiskCache(r2)     // Catch:{ Throwable -> 0x0174 }
            L_0x006e:
                if (r3 == 0) goto L_0x0072
                r5 = 1
                goto L_0x0073
            L_0x0072:
                r5 = 0
            L_0x0073:
                boolean r6 = r11.isCancelled()     // Catch:{ Throwable -> 0x0174 }
                if (r6 != 0) goto L_0x016d
                android.widget.ImageView r6 = r11.m14323Zf()     // Catch:{ Throwable -> 0x0174 }
                if (r6 == 0) goto L_0x016d
                java.lang.ref.WeakReference<android.widget.ImageView> r6 = r11.cey     // Catch:{ Throwable -> 0x0174 }
                java.lang.Object r6 = r6.get()     // Catch:{ Throwable -> 0x0174 }
                if (r6 == 0) goto L_0x016d
                com.introvd.template.common.bitmapfun.util.ImageWorker r6 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                boolean r6 = r6.cet     // Catch:{ Throwable -> 0x0174 }
                if (r6 == 0) goto L_0x0091
                goto L_0x016d
            L_0x0091:
                if (r3 != 0) goto L_0x00f1
                com.introvd.template.common.bitmapfun.util.ImageWorker r3 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                r12 = r12[r1]     // Catch:{ Throwable -> 0x0174 }
                android.graphics.Bitmap r12 = r3.processBitmap(r12)     // Catch:{ Throwable -> 0x0174 }
                if (r12 != 0) goto L_0x00df
                r11.ceB = r4     // Catch:{ Throwable -> 0x0174 }
                java.util.Map r1 = com.introvd.template.common.bitmapfun.util.ImageWorker.cdK     // Catch:{ Throwable -> 0x0174 }
                boolean r1 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x0174 }
                if (r1 == 0) goto L_0x00b7
                java.util.Map r1 = com.introvd.template.common.bitmapfun.util.ImageWorker.cdK     // Catch:{ Throwable -> 0x0174 }
                java.lang.Object r1 = r1.get(r2)     // Catch:{ Throwable -> 0x0174 }
                java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Throwable -> 0x0174 }
                long r7 = r1.longValue()     // Catch:{ Throwable -> 0x0174 }
            L_0x00b7:
                r9 = 1
                long r7 = r7 + r9
                r9 = 3
                int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r1 <= 0) goto L_0x00d2
                if (r2 == 0) goto L_0x00cc
                java.lang.String r12 = "http"
                boolean r12 = r2.startsWith(r12)     // Catch:{ Throwable -> 0x0174 }
                if (r12 == 0) goto L_0x00cc
                r3 = r0
                goto L_0x00d3
            L_0x00cc:
                com.introvd.template.common.bitmapfun.util.ImageWorker r12 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                android.graphics.Bitmap r12 = r12.m14311Zc()     // Catch:{ Throwable -> 0x0174 }
            L_0x00d2:
                r3 = r12
            L_0x00d3:
                java.util.Map r12 = com.introvd.template.common.bitmapfun.util.ImageWorker.cdK     // Catch:{ Throwable -> 0x0174 }
                java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ Throwable -> 0x0174 }
                r12.put(r2, r1)     // Catch:{ Throwable -> 0x0174 }
                goto L_0x00f1
            L_0x00df:
                java.util.Map r1 = com.introvd.template.common.bitmapfun.util.ImageWorker.cdK     // Catch:{ Throwable -> 0x0174 }
                boolean r1 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x0174 }
                if (r1 == 0) goto L_0x00f0
                java.util.Map r1 = com.introvd.template.common.bitmapfun.util.ImageWorker.cdK     // Catch:{ Throwable -> 0x0174 }
                r1.remove(r2)     // Catch:{ Throwable -> 0x0174 }
            L_0x00f0:
                r3 = r12
            L_0x00f1:
                boolean r12 = r11.isCancelled()     // Catch:{ Throwable -> 0x0174 }
                if (r12 != 0) goto L_0x0167
                android.widget.ImageView r12 = r11.m14323Zf()     // Catch:{ Throwable -> 0x0174 }
                if (r12 == 0) goto L_0x0167
                java.lang.ref.WeakReference<android.widget.ImageView> r12 = r11.cey     // Catch:{ Throwable -> 0x0174 }
                java.lang.Object r12 = r12.get()     // Catch:{ Throwable -> 0x0174 }
                if (r12 == 0) goto L_0x0167
                com.introvd.template.common.bitmapfun.util.ImageWorker r12 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                boolean r12 = r12.cet     // Catch:{ Throwable -> 0x0174 }
                if (r12 == 0) goto L_0x010e
                goto L_0x0167
            L_0x010e:
                if (r3 != 0) goto L_0x0111
                return r0
            L_0x0111:
                if (r5 != 0) goto L_0x0127
                com.introvd.template.common.bitmapfun.util.ImageWorker$ImageWorkerListener r12 = r11.cez     // Catch:{ Throwable -> 0x0174 }
                if (r12 == 0) goto L_0x0120
                com.introvd.template.common.bitmapfun.util.ImageWorker$ImageWorkerListener r12 = r11.cez     // Catch:{ Throwable -> 0x0174 }
                java.lang.Object r1 = r11.data     // Catch:{ Throwable -> 0x0174 }
                android.graphics.Bitmap r12 = r12.onGetThumbnailReady(r1, r3)     // Catch:{ Throwable -> 0x0174 }
                goto L_0x0128
            L_0x0120:
                com.introvd.template.common.bitmapfun.util.ImageWorker r12 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.ImageCache r12 = r12.mImageCache     // Catch:{ Throwable -> 0x0174 }
                r12.addBitmapToDiskCache(r2, r3)     // Catch:{ Throwable -> 0x0174 }
            L_0x0127:
                r12 = r3
            L_0x0128:
                if (r12 == r3) goto L_0x012d
                r3.recycle()     // Catch:{ Throwable -> 0x0174 }
            L_0x012d:
                com.introvd.template.common.bitmapfun.util.ImageWorker r1 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                int r1 = r1.cel     // Catch:{ Throwable -> 0x0174 }
                if (r1 == r4) goto L_0x0137
                r1 = r0
                goto L_0x013c
            L_0x0137:
                com.introvd.template.common.bitmapfun.util.b r1 = new com.introvd.template.common.bitmapfun.util.b     // Catch:{ Throwable -> 0x0174 }
                r1.<init>()     // Catch:{ Throwable -> 0x0174 }
            L_0x013c:
                if (r1 == 0) goto L_0x0150
                com.introvd.template.common.bitmapfun.util.ImageWorker r3 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                java.lang.String r3 = r3.cek     // Catch:{ Throwable -> 0x0174 }
                android.graphics.Bitmap r1 = r1.mo26543a(r12, r3)     // Catch:{ Throwable -> 0x0174 }
                if (r1 == 0) goto L_0x0150
                if (r1 == r12) goto L_0x0150
                r12.recycle()     // Catch:{ Throwable -> 0x0174 }
                r12 = r1
            L_0x0150:
                com.introvd.template.common.bitmapfun.util.RecyclingBitmapDrawable r1 = new com.introvd.template.common.bitmapfun.util.RecyclingBitmapDrawable     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.ImageWorker r3 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                android.content.Context r3 = r3.mContext     // Catch:{ Throwable -> 0x0174 }
                android.content.res.Resources r3 = r3.getResources()     // Catch:{ Throwable -> 0x0174 }
                r1.<init>(r3, r12)     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.ImageWorker r12 = r11.ceD     // Catch:{ Throwable -> 0x0174 }
                com.introvd.template.common.bitmapfun.util.ImageCache r12 = r12.mImageCache     // Catch:{ Throwable -> 0x0174 }
                r12.addBitmapToMemCache(r2, r1)     // Catch:{ Throwable -> 0x0174 }
                r11.ceC = r4     // Catch:{ Throwable -> 0x0174 }
                return r1
            L_0x0167:
                if (r3 == 0) goto L_0x016c
                r3.recycle()     // Catch:{ Throwable -> 0x0174 }
            L_0x016c:
                return r0
            L_0x016d:
                if (r3 == 0) goto L_0x0172
                r3.recycle()     // Catch:{ Throwable -> 0x0174 }
            L_0x0172:
                return r0
            L_0x0173:
                return r0
            L_0x0174:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.ImageWorker.C5263b.doInBackground(java.lang.Object[]):com.introvd.template.common.bitmapfun.util.RecyclingBitmapDrawable");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(RecyclingBitmapDrawable recyclingBitmapDrawable) {
            if (isCancelled() || m14323Zf() == null || this.cey.get() == null || this.ceD.cet) {
                m14324a(recyclingBitmapDrawable);
                return;
            }
            try {
                ImageView Zf = m14323Zf();
                if (recyclingBitmapDrawable == null || Zf == null) {
                    m14324a(recyclingBitmapDrawable);
                } else {
                    this.ceD.setImageDrawableWithFadeIn(Zf, recyclingBitmapDrawable, this.data);
                }
            } catch (Exception e) {
                m14324a(recyclingBitmapDrawable);
                e.printStackTrace();
            }
            this.ceD.m14313a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onCancelled(RecyclingBitmapDrawable recyclingBitmapDrawable) {
            m14324a(recyclingBitmapDrawable);
            this.ceD.m14313a(this);
        }
    }

    protected ImageWorker(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* access modifiers changed from: private */
    /* renamed from: Zc */
    public synchronized Bitmap m14311Zc() {
        Bitmap bitmap;
        bitmap = null;
        if (this.ceq != null) {
            bitmap = this.ceq.copy(this.ceq.getConfig(), false);
        } else if (this.cen != null) {
            bitmap = this.cen.copy(this.cen.getConfig(), false);
        }
        return bitmap;
    }

    /* renamed from: a */
    private static void m14312a(ImageView imageView, Drawable drawable, Object obj) {
        if (imageView != null) {
            if (imageView instanceof RecyclingImageView) {
                ((RecyclingImageView) imageView).setImageDrawable(drawable, obj);
            } else {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14313a(C5263b bVar) {
        if (bVar != null) {
            this.ceu.remove(Long.valueOf(bVar.mo26524Ze()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static C5263b m14320l(ImageView imageView) {
        if (imageView != null) {
            Drawable oriDrawable = imageView instanceof RecyclingImageViewListener ? ((RecyclingImageViewListener) imageView).getOriDrawable() : null;
            if (!(oriDrawable instanceof C5262a)) {
                oriDrawable = imageView.getDrawable();
            }
            if (oriDrawable instanceof C5262a) {
                return ((C5262a) oriDrawable).mo26522Zd();
            }
        }
        return null;
    }

    public String addBitmapToCache(Object obj, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || this.mImageCache == null) {
            return null;
        }
        return this.mImageCache.addBitmapToCache(String.valueOf(obj), bitmap);
    }

    public String addBitmapToDiskCache(Object obj, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || this.mImageCache == null || obj == null) {
            return null;
        }
        return this.mImageCache.addBitmapToDiskCache(String.valueOf(obj), bitmap);
    }

    public void clearMemoryCache(boolean z) {
        if (this.mImageCache != null) {
            this.mImageCache.clearMemoryCaches(z);
        }
    }

    public Bitmap getBitmapFromCache(Object obj) {
        if (this.mImageCache == null) {
            return null;
        }
        Bitmap bitmapFromMemCache = this.mImageCache.getBitmapFromMemCache(String.valueOf(obj));
        return (bitmapFromMemCache == null || bitmapFromMemCache.isRecycled()) ? this.mImageCache.getBitmapFromDiskCache(String.valueOf(obj)) : bitmapFromMemCache.copy(bitmapFromMemCache.getConfig(), false);
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap getImageThumbFromFile(String str, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract Bitmap getVideoThumbFromFile(String str, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract Bitmap processBitmap(Object obj);

    public synchronized void release() {
        setExitTasksEarly(true);
        if (this.mImageCache != null) {
            this.mImageCache.clearMemoryCaches(true);
        }
        if (this.cen != null && this.ceo) {
            DelayRecycleBitmapTask.delayRecycle(this.cen);
            this.ceo = false;
            this.cen = null;
        }
        if (this.ceq != null && this.cer) {
            DelayRecycleBitmapTask.delayRecycle(this.ceq);
            this.ceq = null;
            this.cer = false;
        }
    }

    public void removeBitmapFromCache(Object obj, boolean z) {
        if (this.mImageCache != null) {
            this.mImageCache.removeBitmapFromCache(String.valueOf(obj), z);
        }
    }

    public synchronized void setErrorImage(int i) {
        Bitmap bitmap = null;
        if (this.ceq != null && this.cer) {
            bitmap = this.ceq;
        }
        this.ceq = BitmapFactory.decodeResource(this.mContext.getResources(), i);
        this.cer = true;
        if (bitmap != null) {
            DelayRecycleBitmapTask.delayRecycle(bitmap);
        }
    }

    public void setExitTasksEarly(boolean z) {
        this.cet = z;
        if (z && this.ceu.size() > 0) {
            HashSet<Long> hashSet = new HashSet<>();
            try {
                hashSet.addAll(this.ceu.keySet());
            } catch (Exception unused) {
            }
            for (Long remove : hashSet) {
                WeakReference weakReference = (WeakReference) this.ceu.remove(remove);
                if (weakReference != null) {
                    C5263b bVar = (C5263b) weakReference.get();
                    if (bVar != null && !bVar.isCancelled()) {
                        bVar.cancel(false);
                    }
                }
            }
            this.ceu.clear();
        }
    }

    public void setImageCache(ImageCache imageCache) {
        this.mImageCache = imageCache;
    }

    /* access modifiers changed from: protected */
    public void setImageDrawableWithFadeIn(ImageView imageView, BitmapDrawable bitmapDrawable, Object obj) {
        if (imageView != null) {
            if (this.ces != 0) {
                Drawable drawable = null;
                if (this.ces == 2) {
                    drawable = imageView.getDrawable();
                }
                if (drawable == null) {
                    drawable = new ColorDrawable(imageView.getContext().getResources().getColor(17170445));
                }
                TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable, bitmapDrawable});
                m14312a(imageView, transitionDrawable, obj);
                transitionDrawable.startTransition(200);
            } else {
                m14312a(imageView, bitmapDrawable, obj);
            }
        }
    }

    public void setImageFadeIn(int i) {
        this.ces = i;
    }

    public void setImageSize(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void setLoadMode(int i) {
        this.mLoadMode = i;
    }

    public void setTag(String str) {
        this.mstrTag = str;
    }

    public Bitmap syncLoadImage(Object obj, ImageView imageView) {
        RecyclingBitmapDrawable recyclingBitmapDrawable;
        Bitmap bitmap = null;
        if (obj == null) {
            return null;
        }
        if (this.mImageCache != null) {
            RecyclingBitmapDrawable bitmapDrawableFromMemCache = this.mImageCache.getBitmapDrawableFromMemCache(String.valueOf(obj));
            if (bitmapDrawableFromMemCache != null) {
                if (imageView != null) {
                    m14312a(imageView, bitmapDrawableFromMemCache, obj);
                }
                return bitmapDrawableFromMemCache.getBitmap();
            }
            boolean z = false;
            Bitmap bitmapFromDiskCache = this.cem > 0 ? this.mImageCache.getBitmapFromDiskCache(String.valueOf(obj), this.cem) : this.mImageCache.getBitmapFromDiskCache(String.valueOf(obj));
            if (bitmapFromDiskCache != null) {
                z = true;
            }
            if (bitmapFromDiskCache == null || bitmapFromDiskCache.isRecycled()) {
                try {
                    File file = new File(String.valueOf(obj));
                    if (file.isFile() && file.exists()) {
                        bitmapFromDiskCache = processBitmap(obj);
                    }
                } catch (Exception unused) {
                }
            }
            if (bitmapFromDiskCache == null || bitmapFromDiskCache.isRecycled()) {
                recyclingBitmapDrawable = null;
            } else {
                if (!z) {
                    addBitmapToDiskCache(obj, bitmapFromDiskCache);
                }
                recyclingBitmapDrawable = new RecyclingBitmapDrawable(this.mContext.getResources(), bitmapFromDiskCache);
                this.mImageCache.addBitmapToMemCache(String.valueOf(obj), recyclingBitmapDrawable);
            }
            if (imageView != null) {
                if (recyclingBitmapDrawable != null) {
                    m14312a(imageView, recyclingBitmapDrawable, obj);
                } else {
                    imageView.setImageBitmap(null);
                }
            }
            bitmap = bitmapFromDiskCache;
        }
        return bitmap;
    }
}
