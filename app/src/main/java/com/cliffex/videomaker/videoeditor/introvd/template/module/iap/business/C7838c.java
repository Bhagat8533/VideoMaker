package com.introvd.template.module.iap.business;

import android.os.Environment;
import java.io.File;

/* renamed from: com.introvd.template.module.iap.business.c */
public class C7838c {
    public static final String dPi;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append(File.separator);
        sb.append("XiaoYing");
        sb.append(File.separator);
        sb.append("last_info");
        dPi = sb.toString();
    }
}
