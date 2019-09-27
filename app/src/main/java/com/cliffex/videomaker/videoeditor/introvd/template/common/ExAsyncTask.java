package com.introvd.template.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ExAsyncTask<Params, Progress, Result> {
    private static final String LOG_TAG = "AsyncTask";
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static final int POST_MESSAGE_PER_DELAY = 10;
    public static final Executor SERIAL_EXECUTOR = new SerialExecutor();
    /* access modifiers changed from: private */
    public static final List<Object> mPendingPostMsgList = Collections.synchronizedList(new ArrayList());
    private static volatile Executor sDefaultExecutor = SERIAL_EXECUTOR;
    private static final C5212b sHandler = new C5212b(Looper.getMainLooper());
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final FutureTask<Result> mFuture = new FutureTask<Result>(this.mWorker) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                ExAsyncTask.this.postResultIfNotInvoked(get());
            } catch (InterruptedException e) {
                Log.w(ExAsyncTask.LOG_TAG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                ExAsyncTask.this.postResultIfNotInvoked(null);
            }
        }
    };
    private volatile Status mStatus = Status.PENDING;
    /* access modifiers changed from: private */
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private final C5213c<Params, Result> mWorker = new C5213c<Params, Result>() {
        public Result call() throws Exception {
            ExAsyncTask.this.mTaskInvoked.set(true);
            Process.setThreadPriority(10);
            return ExAsyncTask.this.postResult(ExAsyncTask.this.doInBackground(this.mParams));
        }
    };

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: com.introvd.template.common.ExAsyncTask$a */
    private static class C5211a<Data> {
        final ExAsyncTask ccp;
        final Data[] mData;

        C5211a(ExAsyncTask exAsyncTask, Data... dataArr) {
            this.ccp = exAsyncTask;
            this.mData = dataArr;
        }
    }

    /* renamed from: com.introvd.template.common.ExAsyncTask$b */
    private static class C5212b extends Handler {
        public C5212b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int size = ExAsyncTask.mPendingPostMsgList.size();
                    if (size != 0) {
                        removeMessages(1);
                        try {
                            C5211a aVar = (C5211a) ExAsyncTask.mPendingPostMsgList.remove(size - 1);
                            aVar.ccp.finish(aVar.mData[0]);
                        } catch (Exception unused) {
                        }
                        sendEmptyMessageDelayed(1, 10);
                        return;
                    }
                    return;
                case 2:
                    C5211a aVar2 = (C5211a) message.obj;
                    aVar2.ccp.onProgressUpdate(aVar2.mData);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.introvd.template.common.ExAsyncTask$c */
    private static abstract class C5213c<Params, Result> implements Callable<Result> {
        Params[] mParams;

        private C5213c() {
        }
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    /* access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = Status.FINISHED;
    }

    public static void init() {
        sHandler.getLooper();
    }

    /* access modifiers changed from: private */
    public Result postResult(Result result) {
        mPendingPostMsgList.add(new C5211a(this, result));
        sHandler.sendEmptyMessage(1);
        return result;
    }

    /* access modifiers changed from: private */
    public void postResultIfNotInvoked(Result result) {
        if (!this.mTaskInvoked.get()) {
            postResult(result);
        }
    }

    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    /* access modifiers changed from: protected */
    public abstract Result doInBackground(Params... paramsArr);

    public final ExAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final ExAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mStatus != Status.PENDING) {
            switch (this.mStatus) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
        onCancelled();
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    public final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            sHandler.obtainMessage(2, new C5211a(this, progressArr)).sendToTarget();
        }
    }
}
