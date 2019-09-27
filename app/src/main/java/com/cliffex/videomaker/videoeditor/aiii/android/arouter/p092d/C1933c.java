package com.aiii.android.arouter.p092d;

import com.aiii.android.arouter.p091c.C1919a;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.aiii.android.arouter.d.c */
public class C1933c implements ThreadFactory {
    private static final AtomicInteger atO = new AtomicInteger(1);
    private final AtomicInteger atP = new AtomicInteger(1);
    private final ThreadGroup atQ;
    private final String namePrefix;

    public C1933c() {
        SecurityManager securityManager = System.getSecurityManager();
        this.atQ = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        StringBuilder sb = new StringBuilder();
        sb.append("ARouter task pool No.");
        sb.append(atO.getAndIncrement());
        sb.append(", thread No.");
        this.namePrefix = sb.toString();
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.namePrefix);
        sb.append(this.atP.getAndIncrement());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Thread production, name is [");
        sb3.append(sb2);
        sb3.append(RequestParameters.RIGHT_BRACKETS);
        C1919a.atC.mo10378h("ARouter::", sb3.toString());
        Thread thread = new Thread(this.atQ, runnable, sb2, 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Running task appeared exception! Thread [");
                sb.append(thread.getName());
                sb.append("], because [");
                sb.append(th.getMessage());
                sb.append(RequestParameters.RIGHT_BRACKETS);
                C1919a.atC.mo10378h("ARouter::", sb.toString());
            }
        });
        return thread;
    }
}
