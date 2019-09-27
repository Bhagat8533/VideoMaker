package com.introvd.template.crash;

import android.database.sqlite.SQLiteException;
import com.introvd.template.C4681i;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import java.io.File;

/* renamed from: com.introvd.template.crash.b */
public class C5523b {
    /* renamed from: a */
    public static boolean m14965a(Throwable th, Thread thread) {
        if (thread.getId() == 1 || th == null || th.getMessage() == null || th.getStackTrace() == null) {
            return false;
        }
        String str = null;
        if (th.getStackTrace() != null && th.getStackTrace().length > 0) {
            str = th.getStackTrace()[0].toString();
        }
        if (str == null) {
            return false;
        }
        if ((th instanceof SQLiteException) || th.getMessage().contains("androidx.work.workdb")) {
            try {
                File databasePath = C4681i.m12184Gp().mo25017Gs().getDatabasePath("androidx.work.workdb");
                if (databasePath != null) {
                    if (databasePath.exists()) {
                        logException(new C5526d("Fuck androidx.work.workdb dbFile.exists() = true", th));
                    } else {
                        logException(new C5526d("Fuck androidx.work.workdb dbFile.exists() = false", th));
                    }
                }
            } catch (Exception unused) {
            }
            return true;
        }
        boolean z = th instanceof IllegalStateException;
        if (z && th.getMessage().contains("in the builder in which case Room will re-create all of the tables.")) {
            try {
                boolean delete = C4681i.m12184Gp().mo25017Gs().getDatabasePath("androidx.work.workdb").delete();
                StringBuilder sb = new StringBuilder();
                sb.append("success delete = ");
                sb.append(delete);
                logException(new C5526d(sb.toString(), th));
            } catch (Exception unused2) {
            }
            return false;
        } else if (th.getMessage().contains("Results have already been set")) {
            logException(th);
            return true;
        } else if (th.getMessage().contains("finalize() timed out after") && "FinalizerWatchdogDaemon".equals(thread.getName())) {
            logException(th);
            return true;
        } else if (str.contains("com.google.android.gms")) {
            if ((th instanceof NullPointerException) || str.contains("com.giii.aiii.biii.ads.safebrowsing")) {
                logException(C5522a.m14964s(th));
            }
            return true;
        } else if (str.contains("firebase") && (th instanceof NullPointerException)) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (str.contains("com.cloudtech.ads")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (str.contains("cn.jpush")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if ((th instanceof NullPointerException) && th.getMessage().contains("ssl_session == null")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (th.getMessage().contains("Native method not found: com.quvideo.xiaoying.jni.XYSignJni.getReqSign")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (str.contains("okhttp3.internal")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (z && str.contains("okhttp3.CipherSuite$1.")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (str.contains("com.diggds.d.i.b") && th.getMessage().contains(" libcore.io.ErrnoException")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (str.contains("com.eiii.")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (th.getMessage().contains("while executing doInBackground()")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (str.contains("com.duapps.ad") || str.contains("ducaller")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (str.contains("com.moat.analytics")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (th.getMessage().contains("Permission denied (missing INTERNET permission?)")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (str.contains("cn.jiguang")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (str.contains("android.webkit.DeviceMotionService")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (str.contains("com.mobvista.msdk")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (th.getMessage().contains("java.lang.String android.content.ComponentName.getPackageName()'")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if ((th instanceof SecurityException) && "metoknlp_app".equals(thread.getName())) {
            logException(C5522a.m14964s(th));
            return true;
        } else if (z && th.getMessage().contains("Apps may not schedule more than") && th.getMessage().contains("distinct jobs")) {
            logException(C5522a.m14964s(th));
            return true;
        } else if ((th instanceof NoClassDefFoundError) || (th instanceof NoSuchMethodException) || (th instanceof NoSuchMethodError) || (th instanceof NoSuchFieldException) || (th instanceof AbstractMethodError) || (th instanceof NoSuchFieldError)) {
            logException(C5522a.m14964s(th));
            return true;
        } else {
            try {
                if ((th instanceof OutOfMemoryError) && "SharedPreferencesImpl".equals(Thread.currentThread().getName())) {
                    aaR();
                }
            } catch (Exception unused3) {
            }
            return false;
        }
    }

    private static void aaR() throws Exception {
        VivaBaseApplication Gs = C4681i.m12184Gp().mo25017Gs();
        StringBuilder sb = new StringBuilder();
        sb.append("/data/data/");
        sb.append(Gs.getPackageName());
        sb.append("/shared_prefs");
        File file = new File(sb.toString());
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("fs.length = ");
                sb2.append(listFiles.length);
                LogUtilsV2.m14227d(sb2.toString());
                for (File file2 : listFiles) {
                    if (!file2.isDirectory() && file2.length() > ((long) 5242880)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("fileName=");
                        sb3.append(file2.getName());
                        sb3.append(",size=");
                        sb3.append(file2.length() / 1024);
                        sb3.append("kb");
                        logException(new C5526d(sb3.toString()));
                        if (file2.length() > ((long) 10485760)) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }

    public static void logException(Throwable th) {
        ICrashFlavour iCrashFlavour = C4681i.m12184Gp().bgs;
        if (iCrashFlavour != null) {
            iCrashFlavour.logException(C5522a.m14964s(th));
        }
    }

    /* renamed from: t */
    static void m14966t(Throwable th) {
        ICrashFlavour iCrashFlavour = C4681i.m12184Gp().bgs;
        if (iCrashFlavour != null) {
            iCrashFlavour.logException(th);
        }
    }
}
