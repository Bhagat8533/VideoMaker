package com.introvd.template.sdk.utils.p393a;

import com.introvd.template.sdk.utils.C8554j;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* renamed from: com.introvd.template.sdk.utils.a.a */
public class C8482a {

    /* renamed from: com.introvd.template.sdk.utils.a.a$a */
    class C8483a implements FileFilter {
        C8483a() {
        }

        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static int getCpuNumber() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C8483a());
            if (listFiles != null) {
                return listFiles.length;
            }
            return 1;
        } catch (Exception e) {
            C8554j.m25007e("CpuFeatures", "CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }
}
