package com.aiii.sdk.android.oss.exception;

import java.io.IOException;

public class InconsistentException extends IOException {
    private Long clientChecksum;
    private String requestId;
    private Long serverChecksum;

    public InconsistentException(Long l, Long l2, String str) {
        this.clientChecksum = l;
        this.serverChecksum = l2;
        this.requestId = str;
    }

    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("InconsistentException: inconsistent object\n[RequestId]: ");
        sb.append(this.requestId);
        sb.append("\n[ClientChecksum]: ");
        sb.append(this.clientChecksum);
        sb.append("\n[ServerChecksum]: ");
        sb.append(this.serverChecksum);
        return sb.toString();
    }
}
