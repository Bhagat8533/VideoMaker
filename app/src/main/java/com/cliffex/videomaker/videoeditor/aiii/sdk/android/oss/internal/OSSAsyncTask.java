package com.aiii.sdk.android.oss.internal;

import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.ServiceException;
import com.aiii.sdk.android.oss.model.OSSResult;
import com.aiii.sdk.android.oss.network.ExecutionContext;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class OSSAsyncTask<T extends OSSResult> {
    private volatile boolean canceled;
    private ExecutionContext context;
    private Future<T> future;

    public static OSSAsyncTask wrapRequestTask(Future future2, ExecutionContext executionContext) {
        OSSAsyncTask oSSAsyncTask = new OSSAsyncTask();
        oSSAsyncTask.future = future2;
        oSSAsyncTask.context = executionContext;
        return oSSAsyncTask;
    }

    public void cancel() {
        this.canceled = true;
        if (this.context != null) {
            this.context.getCancellationHandler().cancel();
        }
    }

    public T getResult() throws ClientException, ServiceException {
        try {
            return (OSSResult) this.future.get();
        } catch (InterruptedException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(" InterruptedException and message : ");
            sb.append(e.getMessage());
            throw new ClientException(sb.toString(), e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof ClientException) {
                throw ((ClientException) cause);
            } else if (cause instanceof ServiceException) {
                throw ((ServiceException) cause);
            } else {
                cause.printStackTrace();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected exception!");
                sb2.append(cause.getMessage());
                throw new ClientException(sb2.toString());
            }
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isCompleted() {
        return this.future.isDone();
    }

    public void waitUntilFinished() {
        try {
            this.future.get();
        } catch (Exception unused) {
        }
    }
}
