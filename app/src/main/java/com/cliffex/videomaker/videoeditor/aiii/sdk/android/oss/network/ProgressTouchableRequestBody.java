package com.aiii.sdk.android.oss.network;

import com.aiii.sdk.android.oss.callback.OSSProgressCallback;
import com.aiii.sdk.android.oss.model.OSSRequest;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.C9798ab;
import okhttp3.C9947v;
import p468e.C9658d;
import p468e.C9666l;
import p468e.C9677s;

public class ProgressTouchableRequestBody<T extends OSSRequest> extends C9798ab {
    private static final int SEGMENT_SIZE = 2048;
    private OSSProgressCallback callback;
    private long contentLength;
    private String contentType;
    private InputStream inputStream;
    private T request;

    public ProgressTouchableRequestBody(InputStream inputStream2, long j, String str, ExecutionContext executionContext) {
        this.inputStream = inputStream2;
        this.contentType = str;
        this.contentLength = j;
        this.callback = executionContext.getProgressCallback();
        this.request = executionContext.getRequest();
    }

    public long contentLength() throws IOException {
        return this.contentLength;
    }

    public C9947v contentType() {
        return C9947v.m28445ts(this.contentType);
    }

    public void writeTo(C9658d dVar) throws IOException {
        C9677s k = C9666l.m27774k(this.inputStream);
        long j = 0;
        while (j < this.contentLength) {
            long read = k.read(dVar.aYT(), Math.min(this.contentLength - j, 2048));
            if (read == -1) {
                break;
            }
            j += read;
            dVar.flush();
            if (!(this.callback == null || j == 0)) {
                this.callback.onProgress(this.request, j, this.contentLength);
            }
        }
        if (k != null) {
            k.close();
        }
    }
}
