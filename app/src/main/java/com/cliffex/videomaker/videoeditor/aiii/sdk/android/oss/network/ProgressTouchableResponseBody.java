package com.aiii.sdk.android.oss.network;

import com.aiii.sdk.android.oss.callback.OSSProgressCallback;
import com.aiii.sdk.android.oss.model.OSSRequest;
import java.io.IOException;
import okhttp3.C9804ad;
import okhttp3.C9947v;
import p468e.C9655c;
import p468e.C9659e;
import p468e.C9662h;
import p468e.C9666l;
import p468e.C9677s;

public class ProgressTouchableResponseBody<T extends OSSRequest> extends C9804ad {
    private C9659e mBufferedSource;
    /* access modifiers changed from: private */
    public OSSProgressCallback mProgressListener;
    /* access modifiers changed from: private */
    public final C9804ad mResponseBody;
    /* access modifiers changed from: private */
    public T request;

    public ProgressTouchableResponseBody(C9804ad adVar, ExecutionContext executionContext) {
        this.mResponseBody = adVar;
        this.mProgressListener = executionContext.getProgressCallback();
        this.request = executionContext.getRequest();
    }

    private C9677s source(C9677s sVar) {
        return new C9662h(sVar) {
            private long totalBytesRead = 0;

            public long read(C9655c cVar, long j) throws IOException {
                long read = super.read(cVar, j);
                int i = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                this.totalBytesRead += i != 0 ? read : 0;
                if (!(ProgressTouchableResponseBody.this.mProgressListener == null || i == 0 || this.totalBytesRead == 0)) {
                    ProgressTouchableResponseBody.this.mProgressListener.onProgress(ProgressTouchableResponseBody.this.request, this.totalBytesRead, ProgressTouchableResponseBody.this.mResponseBody.contentLength());
                }
                return read;
            }
        };
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public C9947v contentType() {
        return this.mResponseBody.contentType();
    }

    public C9659e source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = C9666l.m27769b(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }
}
