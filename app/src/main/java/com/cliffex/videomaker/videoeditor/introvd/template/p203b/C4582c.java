package com.introvd.template.p203b;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.google.android.exoplayer2.util.MimeTypes;
import com.introvd.template.common.LogUtils;
import java.io.File;

/* renamed from: com.introvd.template.b.c */
public class C4582c {
    private static String bKL;

    /* renamed from: dD */
    public static String m11667dD(Context context) {
        if (bKL != null) {
            return bKL;
        }
        try {
            bKL = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (bKL == null || bKL.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception:");
            sb.append(e.getMessage());
            LogUtils.m14222e("ContextUtils", sb.toString());
        }
        return bKL;
    }

    /* renamed from: dE */
    public static String m11668dE(Context context) {
        if (context == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append("loggers");
        return sb.toString();
    }

    /* renamed from: dF */
    public static void m11669dF(Context context) {
        if (context != null) {
            Intent intent = new Intent("com.diii.music.musicservicecommand");
            intent.putExtra("command", "pause");
            context.sendBroadcast(intent);
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager != null) {
                try {
                    audioManager.requestAudioFocus(null, 3, 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
