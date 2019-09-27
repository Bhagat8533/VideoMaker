package com.introvd.template.common.utils;

import android.content.Context;

public class UtilsDensity {
    public static int getScreenW(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
