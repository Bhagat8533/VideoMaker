package com.introvd.template.editor.widget.scalerotate.p295a;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.introvd.template.common.MD5;
import com.introvd.template.common.MSize;

/* renamed from: com.introvd.template.editor.widget.scalerotate.a.b */
public class C7066b implements ComponentCallbacks2 {
    private static volatile C7066b dsx;
    private MSize csP;
    private LruCache<String, Bitmap> dsw;

    private C7066b() {
        if (this.dsw == null) {
            this.dsw = new LruCache<String, Bitmap>(10485760) {
                /* access modifiers changed from: protected */
                /* renamed from: c */
                public int sizeOf(String str, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }
    }

    public static C7066b auS() {
        if (dsx == null) {
            synchronized (C7066b.class) {
                if (dsx == null) {
                    dsx = new C7066b();
                }
            }
        }
        return dsx;
    }

    public void clearMemory() {
        if (this.dsw != null && VERSION.SDK_INT >= 17) {
            this.dsw.trimToSize(0);
        }
    }

    /* renamed from: d */
    public synchronized void mo31045d(String str, Bitmap bitmap) {
        if (this.dsw != null) {
            String md5 = MD5.md5(str);
            if (bitmap != null) {
                this.dsw.put(md5, bitmap);
            }
        }
    }

    /* renamed from: g */
    public void mo31046g(MSize mSize) {
        this.csP = mSize;
    }

    public synchronized Bitmap getBitmap(String str) {
        if (this.dsw == null) {
            return null;
        }
        return (Bitmap) this.dsw.get(MD5.md5(str));
    }

    public MSize getSurfaceSize() {
        return this.csP;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        clearMemory();
    }

    public void onTrimMemory(int i) {
    }
}
