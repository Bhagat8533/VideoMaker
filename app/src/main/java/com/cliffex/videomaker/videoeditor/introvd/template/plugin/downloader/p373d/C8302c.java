package com.introvd.template.plugin.downloader.p373d;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.util.Locale;

/* renamed from: com.introvd.template.plugin.downloader.d.c */
public class C8302c {
    /* renamed from: aO */
    public static String[] m23959aO(String str, String str2) {
        String charSequence = TextUtils.concat(new CharSequence[]{str2, File.separator, ".cache"}).toString();
        return new String[]{TextUtils.concat(new CharSequence[]{str2, File.separator, str}).toString(), TextUtils.concat(new CharSequence[]{charSequence, File.separator, str, ".tmp"}).toString(), TextUtils.concat(new CharSequence[]{charSequence, File.separator, str, ".lmf"}).toString(), TextUtils.concat(new CharSequence[]{str2, File.separator, str, ".dst"}).toString()};
    }

    /* renamed from: aP */
    public static File[] m23960aP(String str, String str2) {
        String[] aO = m23959aO(str, str2);
        return new File[]{new File(aO[0]), new File(aO[1]), new File(aO[2]), new File(aO[3])};
    }

    /* renamed from: aQ */
    public static File[] m23961aQ(String str, String str2) {
        String[] aO = m23959aO(str, str2);
        return new File[]{new File(aO[1]), new File(aO[2])};
    }

    /* renamed from: b */
    public static File m23962b(File[] fileArr) {
        if (fileArr == null || fileArr.length <= 0) {
            return null;
        }
        return fileArr[0];
    }

    /* renamed from: c */
    public static void m23963c(File... fileArr) {
        for (File file : fileArr) {
            if (file.exists()) {
                if (file.delete()) {
                    C8304e.log(String.format(Locale.getDefault(), "File [%s] delete success.", new Object[]{file.getName()}));
                } else {
                    C8304e.log(String.format(Locale.getDefault(), "File [%s] delete failed.", new Object[]{file.getName()}));
                }
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: k */
    public static void m23964k(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                C8304e.m23974f("Path [%s] not exists, so create.", str);
                if (file.mkdirs()) {
                    C8304e.m23974f("Path [%s] create success.", str);
                } else {
                    C8304e.m23974f("Path [%s] create failed.", str);
                }
            } else {
                C8304e.m23974f("Path [%s] exists.", str);
            }
        }
    }
}
