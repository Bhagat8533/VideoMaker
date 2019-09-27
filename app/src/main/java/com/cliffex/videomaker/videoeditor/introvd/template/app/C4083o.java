package com.introvd.template.app;

import android.app.Activity;
import android.os.Process;
import android.util.Log;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.introvd.template.app.o */
public class C4083o implements UncaughtExceptionHandler {
    private static volatile C4083o biF;
    private UncaughtExceptionHandler biG;

    private C4083o() {
    }

    /* renamed from: HA */
    private static void m10140HA() {
        m10141HB();
        Process.killProcess(Process.myPid());
    }

    /* renamed from: HB */
    private static void m10141HB() {
        List Hh = C3740b.m9101He().mo23112Hh();
        for (int i = 0; i < Hh.size(); i++) {
            WeakReference weakReference = (WeakReference) Hh.get(i);
            if (weakReference != null) {
                Activity activity = (Activity) weakReference.get();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    /* renamed from: Hy */
    public static C4083o m10142Hy() {
        if (biF == null) {
            synchronized (C4083o.class) {
                if (biF == null) {
                    biF = new C4083o();
                }
            }
        }
        return biF;
    }

    /* renamed from: Hz */
    public void mo23761Hz() {
        try {
            this.biG = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(biF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Log.e("vivaAppCrashHandler", th.getMessage(), th);
        th.printStackTrace();
        m10140HA();
    }
}
