package com.introvd.template.sdk.utils.p393a;

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
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.introvd.template.sdk.utils.a.b */
public abstract class C8484b<Params, Progress, Result> {
    public static final Executor SERIAL_EXECUTOR = new C8493d();
    private static final C8489b ehl = new C8489b(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static final List<Object> mPendingPostMsgList = Collections.synchronizedList(new ArrayList());
    private static volatile Executor sDefaultExecutor = SERIAL_EXECUTOR;
    private final C8491d<Params, Result> ehm = new C8491d<Params, Result>() {
        public Result call() throws Exception {
            C8484b.this.mTaskInvoked.set(true);
            Process.setThreadPriority(10);
            return C8484b.this.postResult(C8484b.this.doInBackground(this.mParams));
        }
    };
    private volatile C8490c ehn = C8490c.PENDING;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final FutureTask<Result> mFuture = new FutureTask<Result>(this.ehm) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                C8484b.this.postResultIfNotInvoked(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                C8484b.this.postResultIfNotInvoked(null);
            }
        }
    };
    /* access modifiers changed from: private */
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean();

    /* renamed from: com.introvd.template.sdk.utils.a.b$a */
    private static class C8488a<Data> {
        final C8484b ehq;
        final Data[] mData;

        C8488a(C8484b bVar, Data... dataArr) {
            this.ehq = bVar;
            this.mData = dataArr;
        }
    }

    /* renamed from: com.introvd.template.sdk.utils.a.b$b */
    private static class C8489b extends Handler {
        public C8489b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int size = C8484b.mPendingPostMsgList.size();
                    if (size != 0) {
                        removeMessages(1);
                        try {
                            C8488a aVar = (C8488a) C8484b.mPendingPostMsgList.remove(size - 1);
                            aVar.ehq.finish(aVar.mData[0]);
                        } catch (Exception unused) {
                        }
                        sendEmptyMessageDelayed(1, 10);
                        return;
                    }
                    return;
                case 2:
                    C8488a aVar2 = (C8488a) message.obj;
                    aVar2.ehq.onProgressUpdate(aVar2.mData);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.introvd.template.sdk.utils.a.b$c */
    public enum C8490c {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: com.introvd.template.sdk.utils.a.b$d */
    private static abstract class C8491d<Params, Result> implements Callable<Result> {
        Params[] mParams;

        private C8491d() {
        }
    }

    /* access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.ehn = C8490c.FINISHED;
    }

    /* access modifiers changed from: private */
    public Result postResult(Result result) {
        mPendingPostMsgList.add(new C8488a(this, result));
        ehl.sendEmptyMessage(1);
        return result;
    }

    /* access modifiers changed from: private */
    public void postResultIfNotInvoked(Result result) {
        if (!this.mTaskInvoked.get()) {
            postResult(result);
        }
    }

    /* renamed from: a */
    public final C8484b<Params, Progress, Result> mo34650a(Executor executor, Params... paramsArr) {
        if (this.ehn != C8490c.PENDING) {
            switch (this.ehn) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.ehn = C8490c.RUNNING;
        onPreExecute();
        this.ehm.mParams = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    /* access modifiers changed from: protected */
    public abstract Result doInBackground(Params... paramsArr);

    /* renamed from: e */
    public final C8484b<Params, Progress, Result> mo34652e(Params... paramsArr) {
        return mo34650a(sDefaultExecutor, paramsArr);
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
}
