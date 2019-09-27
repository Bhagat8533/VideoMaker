package com.aiii.sdk.android.oss.model;

public class GetBucketInfoRequest extends OSSRequest {
    private String bucketName;

    public GetBucketInfoRequest(String str) {
        this.bucketName = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }
}
