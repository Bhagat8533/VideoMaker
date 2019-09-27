package com.aiii.sdk.android.oss.internal;

import com.aiii.sdk.android.oss.common.utils.CaseInsensitiveHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

abstract class HttpMessage {
    private InputStream content;
    private long contentLength;
    private Map<String, String> headers = new CaseInsensitiveHashMap();
    private String stringBody;

    HttpMessage() {
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public void close() throws IOException {
        if (this.content != null) {
            this.content.close();
            this.content = null;
        }
    }

    public InputStream getContent() {
        return this.content;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getStringBody() {
        return this.stringBody;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public void setHeaders(Map<String, String> map) {
        if (this.headers == null) {
            this.headers = new CaseInsensitiveHashMap();
        }
        if (this.headers != null && this.headers.size() > 0) {
            this.headers.clear();
        }
        this.headers.putAll(map);
    }

    public void setStringBody(String str) {
        this.stringBody = str;
    }
}
