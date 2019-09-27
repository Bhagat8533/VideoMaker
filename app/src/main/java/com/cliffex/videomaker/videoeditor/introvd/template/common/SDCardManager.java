package com.introvd.template.common;

import android.os.Environment;

public class SDCardManager {
    public static boolean hasSDCard() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (NullPointerException unused) {
            return false;
        }
    }
}
