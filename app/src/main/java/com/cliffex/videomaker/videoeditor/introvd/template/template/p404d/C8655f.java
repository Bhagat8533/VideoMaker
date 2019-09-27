package com.introvd.template.template.p404d;

import android.os.Environment;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.introvd.template.template.d.f */
public class C8655f extends C8645a {
    private static final String ems;
    private static C8655f emt = null;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());
        sb.append("/Giphy");
        ems = sb.toString();
    }

    private C8655f() {
    }

    public static C8655f aKE() {
        if (emt != null) {
            return emt;
        }
        BASE_URL = "http://api.giphy.com/v1/stickers";
        elY = ems;
        return new C8655f();
    }

    public boolean aKF() {
        String[] aKG = aKG();
        return aKG != null && aKG.length > 0;
    }

    public String[] aKG() {
        File file = new File(ems);
        if (!file.exists()) {
            return null;
        }
        String[] list = file.list(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".gif");
            }
        });
        if (list != null) {
            int length = list.length;
            for (int i = 0; i < length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(ems);
                sb.append(File.separator);
                sb.append(list[i]);
                list[i] = sb.toString();
            }
        }
        return list;
    }
}
