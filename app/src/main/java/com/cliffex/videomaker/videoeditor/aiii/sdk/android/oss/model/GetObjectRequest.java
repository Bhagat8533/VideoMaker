package com.aiii.sdk.android.oss.model;

import com.aiii.sdk.android.oss.callback.OSSProgressCallback;
import java.util.Map;

public class GetObjectRequest extends OSSRequest {
    private String bucketName;
    private String objectKey;
    private OSSProgressCallback progressListener;
    private Range range;
    private Map<String, String> requestHeaders;
    private String xOssProcess;

    public GetObjectRequest(String str, String str2) {
        setBucketName(str);
        setObjectKey(str2);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public OSSProgressCallback getProgressListener() {
        return this.progressListener;
    }

    public Range getRange() {
        return this.range;
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public String getxOssProcess() {
        return this.xOssProcess;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setProgressListener(OSSProgressCallback<GetObjectRequest> oSSProgressCallback) {
        this.progressListener = oSSProgressCallback;
    }

    public void setRange(Range range2) {
        this.range = range2;
    }

    public void setRequestHeaders(Map<String, String> map) {
        this.requestHeaders = map;
    }

    public void setxOssProcess(String str) {
        this.xOssProcess = str;
    }
}
