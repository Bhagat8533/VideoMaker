package com.introvd.template.p207c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.p021v4.content.FileProvider;
import com.introvd.template.VivaBaseApplication;
import java.io.File;

/* renamed from: com.introvd.template.c.a */
public class C4612a {
    /* renamed from: a */
    public static void m11759a(Intent intent, String str, File file, boolean z) {
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        if (VERSION.SDK_INT >= 24) {
            Uri d = m11761d(FZ, file);
            intent.setDataAndType(d, str);
            intent.addFlags(1);
            if (z) {
                intent.addFlags(2);
            }
            FZ.grantUriPermission(FZ.getPackageName(), d, 3);
            return;
        }
        intent.setDataAndType(Uri.fromFile(file), str);
    }

    /* renamed from: c */
    private static Uri m11760c(Context context, File file) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(".provider");
            return FileProvider.getUriForFile(context, sb.toString(), file);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static Uri m11761d(Context context, File file) {
        if (context == null || file == null) {
            return null;
        }
        Uri c = VERSION.SDK_INT >= 24 ? m11760c(context, file) : Uri.fromFile(file);
        context.grantUriPermission(context.getPackageName(), c, 2);
        context.grantUriPermission(context.getPackageName(), c, 1);
        return c;
    }
}
