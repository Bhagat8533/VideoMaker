package com.aiii.sdk.android.oss.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.C9802ac;

public class ResponseMessage extends HttpMessage {
    private RequestMessage request;
    private C9802ac response;
    private int statusCode;

    public /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    public /* bridge */ /* synthetic */ InputStream getContent() {
        return super.getContent();
    }

    public /* bridge */ /* synthetic */ long getContentLength() {
        return super.getContentLength();
    }

    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    public RequestMessage getRequest() {
        return this.request;
    }

    public C9802ac getResponse() {
        return this.response;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public /* bridge */ /* synthetic */ String getStringBody() {
        return super.getStringBody();
    }

    public /* bridge */ /* synthetic */ void setContent(InputStream inputStream) {
        super.setContent(inputStream);
    }

    public /* bridge */ /* synthetic */ void setContentLength(long j) {
        super.setContentLength(j);
    }

    public /* bridge */ /* synthetic */ void setHeaders(Map map) {
        super.setHeaders(map);
    }

    public void setRequest(RequestMessage requestMessage) {
        this.request = requestMessage;
    }

    public void setResponse(C9802ac acVar) {
        this.response = acVar;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public /* bridge */ /* synthetic */ void setStringBody(String str) {
        super.setStringBody(str);
    }
}
