package com.introvd.template.common;

import android.os.Build.VERSION;

public class ApiHelper {
    public static final boolean GINGERBREAD_AND_HIGHER = (VERSION.SDK_INT >= 9);
    public static final boolean GINGERBREAD_MR1_AND_HIGHER = (VERSION.SDK_INT >= 10);
    public static final boolean HONEYCOMB_AND_HIGHER = (VERSION.SDK_INT >= 11);
    public static final boolean HONEYCOMB_HIGHER = (VERSION.SDK_INT > 11);
    public static final boolean ICE_CREAM_SANDWICH_AND_HIGHER = (VERSION.SDK_INT >= 14);
    public static final boolean JELLY_BEAN_AND_HIGHER = (VERSION.SDK_INT >= 16);
    public static final boolean JELLY_BEAN_MR1_AND_HIGHER = (VERSION.SDK_INT >= 17);
    public static final boolean JELLY_BEAN_MR1_AND_LOWER = (VERSION.SDK_INT <= 17);
    public static final boolean JELLY_BEAN_MR2_AND_HIGHER = (VERSION.SDK_INT >= 18);
    public static final boolean KITKAT_AND_HIGHER;

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 19) {
            z = true;
        }
        KITKAT_AND_HIGHER = z;
    }
}
