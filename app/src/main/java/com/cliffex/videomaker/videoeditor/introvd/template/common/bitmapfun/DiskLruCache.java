package com.introvd.template.common.bitmapfun;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.ExAsyncTask;
import java.io.File;

public class DiskLruCache {
    private static File cdF;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m14282b(File file, long j) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < listFiles.length; i++) {
                try {
                    if (listFiles[i] != null) {
                        if (listFiles[i].exists()) {
                            if (listFiles[i].isDirectory()) {
                                m14282b(listFiles[i], j);
                            } else if (listFiles[i].lastModified() + j < currentTimeMillis) {
                                listFiles[i].delete();
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: c */
    private static void m14283c(File file, final long j) {
        if (file != null) {
            new ExAsyncTask<Object, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Object... objArr) {
                    File file = objArr[0];
                    if (file == null) {
                        return null;
                    }
                    DiskLruCache.m14282b(file, j);
                    return null;
                }
            }.execute((Params[]) new Object[]{file});
        }
    }

    public static void clearCache(Context context, String str, long j) {
        m14283c(getDiskCacheDir(context, str), j);
    }

    public static File getDiskCacheDir(Context context, String str) {
        String path = Utils.getExternalCacheDir(context).getPath();
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        sb.append(File.separator);
        sb.append(".thumbnail");
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(File.separator);
            sb3.append(str);
            sb2 = sb3.toString();
        }
        return new File(sb2);
    }
}
