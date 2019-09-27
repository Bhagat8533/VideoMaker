package com.introvd.template.common.bitmapfun.util;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import com.introvd.template.common.bitmapfun.util.ImageCache.ImageCacheParams;
import java.io.File;
import java.util.ArrayList;
import xiaoying.engine.base.QUtils;

public class ImageWorkerFactory {
    private static ArrayList<Point> ceE = new ArrayList<>();
    private static ImageWorker cej = null;

    public interface onCreateImageWorkerListener {
        ImageFetcherWithListener onNewImageWorker(Context context, int i, int i2);
    }

    public static ImageFetcherWithListener CreateImageWorker(Context context, int i, int i2, String str) {
        return CreateImageWorker(context, i, i2, str, 0);
    }

    public static ImageFetcherWithListener CreateImageWorker(Context context, int i, int i2, String str, int i3) {
        return CreateImageWorker(context, i, i2, str, i3, 0);
    }

    public static ImageFetcherWithListener CreateImageWorker(Context context, int i, int i2, String str, int i3, int i4) {
        return CreateImageWorker(null, context, i, i2, str, i3, i4, null);
    }

    public static ImageFetcherWithListener CreateImageWorker(onCreateImageWorkerListener oncreateimageworkerlistener, Context context, int i, int i2, String str, int i3, int i4, CompressFormat compressFormat) {
        return CreateImageWorker(oncreateimageworkerlistener, context, i, i2, true, str, i3, i4, compressFormat);
    }

    public static ImageFetcherWithListener CreateImageWorker(onCreateImageWorkerListener oncreateimageworkerlistener, Context context, int i, int i2, boolean z, String str, int i3, int i4, CompressFormat compressFormat) {
        File diskCacheDir = DiskLruCache.getDiskCacheDir(context, "");
        if (!diskCacheDir.exists()) {
            diskCacheDir.mkdirs();
        }
        if (i3 == 0) {
            i3 = 1;
        }
        ImageFetcherWithListener onNewImageWorker = oncreateimageworkerlistener != null ? oncreateimageworkerlistener.onNewImageWorker(context, i, i2) : new ImageFetcherWithListener(context, i, i2);
        String makeCacheID = makeCacheID(i, i2);
        if (str == null) {
            str = makeCacheID;
        }
        ImageCacheParams imageCacheParams = new ImageCacheParams(str);
        if (i3 > 0) {
            imageCacheParams.memoryCacheEnabled = true;
            imageCacheParams.memCacheSize = i3;
        }
        if (i4 != 0) {
            imageCacheParams.compressQuality = i4;
        }
        if (!z) {
            imageCacheParams.diskCacheEnabled = false;
        }
        if (compressFormat != null) {
            imageCacheParams.compressFormat = compressFormat;
        }
        ImageCache imageCache = new ImageCache(context, imageCacheParams);
        onNewImageWorker.setTag(imageCacheParams.uniqueName);
        onNewImageWorker.setImageCache(imageCache);
        m14333fp(makeCacheID);
        onNewImageWorker.setExitTasksEarly(false);
        return onNewImageWorker;
    }

    public static void DestroyImageWorker(ImageWorker imageWorker) {
        if (imageWorker != null) {
            imageWorker.setExitTasksEarly(true);
            imageWorker.release();
        }
    }

    /* renamed from: ch */
    private static Point m14329ch(int i, int i2) {
        Point point = new Point(QUtils.VIDEO_RES_VGA_WIDTH, QUtils.VIDEO_RES_VGA_WIDTH);
        synchronized (ceE) {
            int size = ceE.size();
            for (int i3 = 0; i3 < size; i3++) {
                Point point2 = (Point) ceE.get(i3);
                if (point2.x > i && point2.y > i2 && point2.x * point2.y < point.x * point.y) {
                    point = point2;
                }
            }
        }
        return point;
    }

    /* renamed from: d */
    private static ImageWorker m14330d(Context context, int i, int i2) {
        if (context == null) {
            return null;
        }
        m14331ed(context);
        Point ch = m14329ch(i, i2);
        ImageFetcher imageFetcher = new ImageFetcher(context, ch.x, ch.y);
        ImageCacheParams imageCacheParams = new ImageCacheParams(makeCacheID(ch.x, ch.y));
        ImageCache imageCache = new ImageCache(context, imageCacheParams);
        imageCache.setDiskCacheMode(1);
        imageFetcher.setImageCache(imageCache);
        imageFetcher.setTag(imageCacheParams.uniqueName);
        imageFetcher.setExitTasksEarly(false);
        return imageFetcher;
    }

    /* renamed from: ed */
    private static void m14331ed(Context context) {
        if (context != null && ceE.size() <= 0) {
            File diskCacheDir = DiskLruCache.getDiskCacheDir(context, "");
            if (diskCacheDir != null && diskCacheDir.exists()) {
                File[] listFiles = diskCacheDir.listFiles();
                if (listFiles != null) {
                    for (int i = 0; i < listFiles.length; i++) {
                        if (listFiles[i].isDirectory()) {
                            String path = listFiles[i].getPath();
                            int lastIndexOf = path.lastIndexOf(47);
                            if (lastIndexOf >= 0) {
                                m14333fp(path.substring(lastIndexOf + 1));
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: fo */
    private static Point m14332fo(String str) {
        int lastIndexOf = str.lastIndexOf("wXh");
        if (lastIndexOf != -1) {
            try {
                return new Point(Integer.parseInt(str.substring(0, lastIndexOf)), Integer.parseInt(str.substring(lastIndexOf + "wXh".length())));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: fp */
    private static void m14333fp(String str) {
        if (str != null && str.contains("wXh")) {
            Point fo = m14332fo(str);
            if (fo != null) {
                synchronized (ceE) {
                    int size = ceE.size();
                    int i = 0;
                    while (i < size) {
                        Point point = (Point) ceE.get(i);
                        if (point.x != fo.x || point.y != fo.y) {
                            i++;
                        } else {
                            return;
                        }
                    }
                    ceE.add(fo);
                }
            }
        }
    }

    public static synchronized ImageWorker getGlobalImageWorker(Context context) {
        ImageWorker imageWorker;
        synchronized (ImageWorkerFactory.class) {
            if (cej == null) {
                cej = m14330d(context, QUtils.VIDEO_RES_VGA_WIDTH, QUtils.VIDEO_RES_VGA_WIDTH);
            }
            imageWorker = cej;
        }
        return imageWorker;
    }

    public static String makeCacheID(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("wXh");
        sb.append(i2);
        return sb.toString();
    }
}
