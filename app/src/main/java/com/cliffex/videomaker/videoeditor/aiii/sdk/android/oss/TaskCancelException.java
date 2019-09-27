package com.aiii.sdk.android.oss;

public class TaskCancelException extends Exception {
    public TaskCancelException() {
    }

    public TaskCancelException(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ErrorMessage]: ");
        sb.append(str);
        super(sb.toString());
    }

    public TaskCancelException(Throwable th) {
        super(th);
    }
}
