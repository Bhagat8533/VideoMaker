package com.introvd.template.router.lvl;

public interface GoogleLicenseErrorListener {
    public static final int ERROR_CHECK_IN_PROGRESS = 4;
    public static final int ERROR_INVALID_PACKAGE_NAME = 1;
    public static final int ERROR_INVALID_PUBLIC_KEY = 5;
    public static final int ERROR_MISSING_PERMISSION = 6;
    public static final int ERROR_NON_MATCHING_UID = 2;
    public static final int ERROR_NOT_MARKET_MANAGED = 3;
    public static final int ERROR_OTHERS = 7;
    public static final int REASON_ALLOW = 256;
    public static final int REASON_DONT_ALLOW = 561;
    public static final int REASON_RETRY = 291;

    void onError(int i);
}
