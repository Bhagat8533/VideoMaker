package com.aiii.sdk.android.oss.network;

import android.content.Context;
import com.aiii.sdk.android.oss.callback.OSSCompletedCallback;
import com.aiii.sdk.android.oss.callback.OSSProgressCallback;
import com.aiii.sdk.android.oss.callback.OSSRetryCallback;
import com.aiii.sdk.android.oss.model.OSSRequest;
import com.aiii.sdk.android.oss.model.OSSResult;
import okhttp3.C9951x;

public class ExecutionContext<Request extends OSSRequest, Result extends OSSResult> {
    private Context applicationContext;
    private CancellationHandler cancellationHandler;
    private C9951x client;
    private OSSCompletedCallback completedCallback;
    private OSSProgressCallback progressCallback;
    private Request request;
    private OSSRetryCallback retryCallback;

    public ExecutionContext(C9951x xVar, Request request2) {
        this(xVar, request2, null);
    }

    public ExecutionContext(C9951x xVar, Request request2, Context context) {
        this.cancellationHandler = new CancellationHandler();
        setClient(xVar);
        setRequest(request2);
        this.applicationContext = context;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public CancellationHandler getCancellationHandler() {
        return this.cancellationHandler;
    }

    public C9951x getClient() {
        return this.client;
    }

    public OSSCompletedCallback<Request, Result> getCompletedCallback() {
        return this.completedCallback;
    }

    public OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public Request getRequest() {
        return this.request;
    }

    public OSSRetryCallback getRetryCallback() {
        return this.retryCallback;
    }

    public void setClient(C9951x xVar) {
        this.client = xVar;
    }

    public void setCompletedCallback(OSSCompletedCallback<Request, Result> oSSCompletedCallback) {
        this.completedCallback = oSSCompletedCallback;
    }

    public void setProgressCallback(OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setRequest(Request request2) {
        this.request = request2;
    }

    public void setRetryCallback(OSSRetryCallback oSSRetryCallback) {
        this.retryCallback = oSSRetryCallback;
    }
}
