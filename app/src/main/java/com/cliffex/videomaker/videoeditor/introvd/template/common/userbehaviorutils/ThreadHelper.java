package com.introvd.template.common.userbehaviorutils;

import android.os.Process;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ThreadHelper {
    /* access modifiers changed from: private */
    public String ciL;
    private ExecutorService executorService;

    /* renamed from: com.introvd.template.common.userbehaviorutils.ThreadHelper$a */
    private static class C5345a {
        /* access modifiers changed from: private */
        public static final ThreadHelper ciN = new ThreadHelper();
    }

    private ThreadHelper() {
        this.ciL = "report-event";
        this.executorService = Executors.newSingleThreadExecutor();
        init();
    }

    public static ThreadHelper getInstance() {
        return C5345a.ciN;
    }

    private void init() {
        this.executorService.execute(new Runnable() {
            public void run() {
                Thread.currentThread().setName(ThreadHelper.this.ciL);
                Process.setThreadPriority(10);
            }
        });
    }

    public void executeTask(Runnable runnable) {
        if (runnable != null) {
            this.executorService.execute(runnable);
        }
    }
}
