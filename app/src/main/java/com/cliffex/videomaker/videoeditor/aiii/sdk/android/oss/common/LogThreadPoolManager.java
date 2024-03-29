package com.aiii.sdk.android.oss.common;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LogThreadPoolManager {
    private static final int PERIOD_TASK_QOS = 1000;
    private static final int SIZE_CACHE_QUEUE = 200;
    private static final int SIZE_CORE_POOL = 1;
    private static final int SIZE_MAX_POOL = 1;
    private static final int SIZE_WORK_QUEUE = 500;
    private static final int TIME_KEEP_ALIVE = 5000;
    private static LogThreadPoolManager sThreadPoolManager = new LogThreadPoolManager();
    private final Runnable mAccessBufferThread;
    private final RejectedExecutionHandler mHandler = new RejectedExecutionHandler() {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (LogThreadPoolManager.this.mTaskQueue.size() >= 200) {
                LogThreadPoolManager.this.mTaskQueue.poll();
            }
            LogThreadPoolManager.this.mTaskQueue.offer(runnable);
        }
    };
    protected final ScheduledFuture<?> mTaskHandler;
    /* access modifiers changed from: private */
    public final Queue<Runnable> mTaskQueue = new LinkedList();
    /* access modifiers changed from: private */
    public final ThreadPoolExecutor mThreadPool;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private LogThreadPoolManager() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(500), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-log-thread");
            }
        }, this.mHandler);
        this.mThreadPool = threadPoolExecutor;
        this.mAccessBufferThread = new Runnable() {
            public void run() {
                if (LogThreadPoolManager.this.hasMoreAcquire()) {
                    LogThreadPoolManager.this.mThreadPool.execute((Runnable) LogThreadPoolManager.this.mTaskQueue.poll());
                }
            }
        };
        this.mTaskHandler = this.scheduler.scheduleAtFixedRate(this.mAccessBufferThread, 0, 1000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public boolean hasMoreAcquire() {
        return !this.mTaskQueue.isEmpty();
    }

    public static LogThreadPoolManager newInstance() {
        if (sThreadPoolManager == null) {
            sThreadPoolManager = new LogThreadPoolManager();
        }
        return sThreadPoolManager;
    }

    public void addExecuteTask(Runnable runnable) {
        if (runnable != null) {
            this.mThreadPool.execute(runnable);
        }
    }
}
