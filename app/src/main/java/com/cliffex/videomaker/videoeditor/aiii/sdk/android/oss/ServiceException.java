package com.aiii.sdk.android.oss;

import com.aiii.sdk.android.oss.common.OSSLog;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 430933593095358673L;
    private String errorCode;
    private String hostId;
    private String partEtag;
    private String partNumber;
    private String rawMessage;
    private String requestId;
    private int statusCode;

    public ServiceException(int i, String str, String str2, String str3, String str4, String str5) {
        super(str);
        this.statusCode = i;
        this.errorCode = str2;
        this.requestId = str3;
        this.hostId = str4;
        this.rawMessage = str5;
        OSSLog.logThrowable2Local(this);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getHostId() {
        return this.hostId;
    }

    public String getPartEtag() {
        return this.partEtag;
    }

    public String getPartNumber() {
        return this.partNumber;
    }

    public String getRawMessage() {
        return this.rawMessage;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setPartEtag(String str) {
        this.partEtag = str;
    }

    public void setPartNumber(String str) {
        this.partNumber = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[StatusCode]: ");
        sb.append(this.statusCode);
        sb.append(", [Code]: ");
        sb.append(getErrorCode());
        sb.append(", [Message]: ");
        sb.append(getMessage());
        sb.append(", [Requestid]: ");
        sb.append(getRequestId());
        sb.append(", [HostId]: ");
        sb.append(getHostId());
        sb.append(", [RawMessage]: ");
        sb.append(getRawMessage());
        return sb.toString();
    }
}
