package com.aiii.sdk.android.oss.model;

public class ListBucketsRequest extends OSSRequest {
    private static final int MAX_RETURNED_KEYS_LIMIT = 1000;
    private String marker;
    private Integer maxKeys;
    private String prefix;

    public ListBucketsRequest() {
    }

    public ListBucketsRequest(String str) {
        this(str, null);
    }

    public ListBucketsRequest(String str, String str2) {
        this(str, str2, Integer.valueOf(100));
    }

    public ListBucketsRequest(String str, String str2, Integer num) {
        this.prefix = str;
        this.marker = str2;
        this.maxKeys = num;
    }

    public String getMarker() {
        return this.marker;
    }

    public Integer getMaxKeys() {
        return this.maxKeys;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public void setMaxKeys(Integer num) {
        this.maxKeys = num;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }
}
