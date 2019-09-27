package com.aiii.sdk.android.oss.network;

import okhttp3.C9814e;

public class CancellationHandler {
    private volatile C9814e call;
    private volatile boolean isCancelled;

    public void cancel() {
        if (this.call != null) {
            this.call.cancel();
        }
        this.isCancelled = true;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCall(C9814e eVar) {
        this.call = eVar;
    }
}
