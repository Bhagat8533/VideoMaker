package com.introvd.template.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.p105b.p106a.C2120b;
import com.p105b.p106a.C2126g;

public class LogUtilsV2 {
    private static boolean DEBUG = true;
    public static boolean Logable = false;
    private static C5220a ccr = null;
    public static CustomLogger customLogger = null;
    public static String customTagPrefix = "QuVideo";

    public interface CustomLogger {
        /* renamed from: d */
        void mo26391d(String str, String str2);

        /* renamed from: e */
        void mo26392e(String str, String str2);

        /* renamed from: e */
        void mo26393e(String str, String str2, Throwable th);

        /* renamed from: i */
        void mo26394i(String str, String str2);

        /* renamed from: v */
        void mo26395v(String str, String str2);

        /* renamed from: w */
        void mo26396w(String str, String str2);
    }

    /* renamed from: com.introvd.template.common.LogUtilsV2$a */
    static class C5220a extends Handler {
        C5220a(Looper looper) {
            super(looper);
        }
    }

    /* renamed from: b */
    private static String m14226b(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        String format = String.format("%s.%s(L:%d)", new Object[]{className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())});
        if (TextUtils.isEmpty(customTagPrefix)) {
            return format;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(customTagPrefix);
        sb.append(":");
        sb.append(format);
        return sb.toString();
    }

    /* renamed from: d */
    public static void m14227d(final String str) {
        if (Logable) {
            C2126g.m5941J(str);
        }
        if (DEBUG && ccr != null) {
            final String b = m14226b(getCallerStackTraceElement());
            ccr.post(new Runnable() {
                public void run() {
                    if (LogUtilsV2.customLogger != null) {
                        LogUtilsV2.customLogger.mo26391d(b, str);
                    } else {
                        Log.d(b, str);
                    }
                }
            });
        }
    }

    /* renamed from: e */
    public static void m14228e(final String str) {
        if (Logable) {
            C2126g.m5943e(str, new Object[0]);
        }
        if (DEBUG && ccr != null) {
            final String b = m14226b(getCallerStackTraceElement());
            ccr.post(new Runnable() {
                public void run() {
                    if (LogUtilsV2.customLogger != null) {
                        LogUtilsV2.customLogger.mo26392e(b, str);
                    } else {
                        Log.e(b, str);
                    }
                }
            });
        }
    }

    /* renamed from: e */
    public static void m14229e(final String str, final Throwable th) {
        if (Logable) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(m14231p(th));
            C2126g.m5943e(sb.toString(), new Object[0]);
        }
        if (DEBUG && ccr != null) {
            final String b = m14226b(getCallerStackTraceElement());
            ccr.post(new Runnable() {
                public void run() {
                    if (LogUtilsV2.customLogger != null) {
                        LogUtilsV2.customLogger.mo26393e(b, str, th);
                    } else {
                        Log.e(b, str, th);
                    }
                }
            });
        }
    }

    public static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }

    /* renamed from: i */
    public static void m14230i(final String str) {
        if (Logable) {
            C2126g.m5944i(str, new Object[0]);
        }
        if (DEBUG && ccr != null) {
            final String b = m14226b(getCallerStackTraceElement());
            ccr.post(new Runnable() {
                public void run() {
                    if (LogUtilsV2.customLogger != null) {
                        LogUtilsV2.customLogger.mo26394i(b, str);
                    } else {
                        Log.i(b, str);
                    }
                }
            });
        }
    }

    public static void init(boolean z, String str) {
        DEBUG = z;
        if (DEBUG) {
            customTagPrefix = str;
            HandlerThread handlerThread = new HandlerThread("LogException");
            handlerThread.start();
            ccr = new C5220a(handlerThread.getLooper());
        }
    }

    public static void initLoggerWriterAdapter() {
        C2126g.m5942a(new C2120b());
    }

    /* renamed from: p */
    private static String m14231p(Throwable th) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\r");
        sb2.append(th.toString());
        sb.append(sb2.toString());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\rat ");
            sb3.append(stackTraceElement);
            sb.append(sb3.toString());
        }
        return sb.toString();
    }

    /* renamed from: v */
    public static void m14232v(final String str) {
        if (Logable) {
            C2126g.m5945v(str, new Object[0]);
        }
        if (DEBUG && ccr != null) {
            final String b = m14226b(getCallerStackTraceElement());
            ccr.post(new Runnable() {
                public void run() {
                    if (LogUtilsV2.customLogger != null) {
                        LogUtilsV2.customLogger.mo26395v(b, str);
                    } else {
                        Log.v(b, str);
                    }
                }
            });
        }
    }

    /* renamed from: w */
    public static void m14233w(final String str) {
        if (Logable) {
            C2126g.m5946w(str, new Object[0]);
        }
        if (DEBUG && ccr != null) {
            final String b = m14226b(getCallerStackTraceElement());
            ccr.post(new Runnable() {
                public void run() {
                    if (LogUtilsV2.customLogger != null) {
                        LogUtilsV2.customLogger.mo26396w(b, str);
                    } else {
                        Log.w(b, str);
                    }
                }
            });
        }
    }
}
