package com.introvd.template.common;

import android.text.TextUtils;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SerialExecutor implements Executor {
    private final Executor THREAD_POOL_EXECUTOR;
    private final int ccA;
    final ArrayDeque<Runnable> ccB;
    /* access modifiers changed from: private */
    public final AtomicInteger ccz;
    /* access modifiers changed from: private */
    public final AtomicInteger mCount;
    private final BlockingQueue<Runnable> sPoolWorkQueue;
    private final ThreadFactory sThreadFactory;

    public SerialExecutor() {
        this(null, 2, 10, 1);
    }

    public SerialExecutor(final String str, int i, int i2, int i3) {
        this.mCount = new AtomicInteger(1);
        this.ccz = new AtomicInteger(0);
        this.ccB = new ArrayDeque<>();
        this.sThreadFactory = new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                String str;
                if (!TextUtils.isEmpty(str)) {
                    str = str;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SerialExecutor@");
                    sb.append(hashCode());
                    sb.append("#");
                    sb.append(SerialExecutor.this.mCount.getAndIncrement());
                    str = sb.toString();
                }
                return new Thread(runnable, str);
            }
        };
        this.sPoolWorkQueue = new LinkedBlockingQueue(i2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, (long) i3, TimeUnit.SECONDS, this.sPoolWorkQueue, this.sThreadFactory, new DiscardOldestPolicy());
        this.THREAD_POOL_EXECUTOR = threadPoolExecutor;
        this.ccA = i;
    }

    public synchronized void execute(final Runnable runnable) {
        this.ccB.offer(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    SerialExecutor.this.ccz.decrementAndGet();
                    SerialExecutor.this.scheduleNext();
                    throw th;
                }
                SerialExecutor.this.ccz.decrementAndGet();
                SerialExecutor.this.scheduleNext();
            }
        });
        scheduleNext();
    }

    /* access modifiers changed from: protected */
    public synchronized void scheduleNext() {
        if (this.ccz.get() < this.ccA) {
            try {
                Runnable runnable = (Runnable) this.ccB.pollLast();
                if (runnable != null) {
                    this.ccz.incrementAndGet();
                    this.THREAD_POOL_EXECUTOR.execute(runnable);
                }
            } catch (Throwable th) {
                this.ccz.decrementAndGet();
                th.printStackTrace();
            }
        } else {
            return;
        }
        return;
    }
}
