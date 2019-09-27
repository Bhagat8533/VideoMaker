package com.introvd.template.vivaiap.coffer;

/* renamed from: com.introvd.template.vivaiap.coffer.f */
public class C9038f {
    private final int code;
    private final String message;
    private final boolean success;

    public C9038f(boolean z) {
        this(z, "");
    }

    public C9038f(boolean z, int i, String str) {
        this.success = z;
        this.code = i;
        this.message = str;
    }

    public C9038f(boolean z, String str) {
        this(z, -1, str);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
