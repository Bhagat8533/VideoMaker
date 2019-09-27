package com.aiii.sdk.android.oss;

import com.aiii.sdk.android.oss.common.OSSLog;

public class ClientException extends Exception {
    private Boolean canceled;

    public ClientException() {
        this.canceled = Boolean.valueOf(false);
    }

    public ClientException(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ErrorMessage]: ");
        sb.append(str);
        super(sb.toString());
        this.canceled = Boolean.valueOf(false);
    }

    public ClientException(String str, Throwable th) {
        this(str, th, Boolean.valueOf(false));
    }

    public ClientException(String str, Throwable th, Boolean bool) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ErrorMessage]: ");
        sb.append(str);
        super(sb.toString(), th);
        this.canceled = Boolean.valueOf(false);
        this.canceled = bool;
        OSSLog.logThrowable2Local(this);
    }

    public ClientException(Throwable th) {
        super(th);
        this.canceled = Boolean.valueOf(false);
    }

    public String getMessage() {
        String message = super.getMessage();
        if (getCause() == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getCause().getMessage());
        sb.append("\n");
        sb.append(message);
        return sb.toString();
    }

    public Boolean isCanceledException() {
        return this.canceled;
    }
}
