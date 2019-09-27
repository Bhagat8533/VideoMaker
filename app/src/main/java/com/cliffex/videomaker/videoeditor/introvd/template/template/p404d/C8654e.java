package com.introvd.template.template.p404d;

import android.os.Environment;

/* renamed from: com.introvd.template.template.d.e */
public class C8654e extends C8645a {
    private static final String emq;
    private static C8654e emr = null;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());
        sb.append("/GIF");
        emq = sb.toString();
    }

    private C8654e() {
    }

    public static C8654e aKD() {
        if (emr != null) {
            return emr;
        }
        BASE_URL = "http://api.giphy.com/v1/gifs";
        elY = emq;
        return new C8654e();
    }
}
