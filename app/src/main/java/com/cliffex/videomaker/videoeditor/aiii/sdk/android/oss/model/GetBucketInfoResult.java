package com.aiii.sdk.android.oss.model;

public class GetBucketInfoResult extends OSSResult {
    private OSSBucketSummary bucket;

    public OSSBucketSummary getBucket() {
        return this.bucket;
    }

    public void setBucket(OSSBucketSummary oSSBucketSummary) {
        this.bucket = oSSBucketSummary;
    }

    public String toString() {
        return String.format("GetBucketInfoResult<%s>:\n bucket:%s", new Object[]{super.toString(), this.bucket.toString()});
    }
}
