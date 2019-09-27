package com.aiii.android.arouter.p092d;

import com.aiii.android.arouter.p091c.C1919a;
import com.aiii.android.arouter.p093e.C1940e;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.aiii.android.arouter.d.b */
public class C1931b extends ThreadPoolExecutor {
    private static final int akA = Runtime.getRuntime().availableProcessors();
    private static final int atL = (akA + 1);
    private static final int atM = atL;
    private static C1931b atN;

    private C1931b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                C1919a.atC.mo10380k("ARouter::", "Task rejected, too many task!");
            }
        });
    }

    /* renamed from: si */
    public static C1931b m5558si() {
        if (atN == null) {
            synchronized (C1931b.class) {
                if (atN == null) {
                    C1931b bVar = new C1931b(atL, atM, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new C1933c());
                    atN = bVar;
                }
            }
        }
        return atN;
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (CancellationException e) {
                th = e;
            } catch (ExecutionException e2) {
                th = e2.getCause();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Running task appeared exception! Thread [");
            sb.append(Thread.currentThread().getName());
            sb.append("], because [");
            sb.append(th.getMessage());
            sb.append("]\n");
            sb.append(C1940e.m5577a(th.getStackTrace()));
            C1919a.atC.mo10379j("ARouter::", sb.toString());
        }
    }
}
