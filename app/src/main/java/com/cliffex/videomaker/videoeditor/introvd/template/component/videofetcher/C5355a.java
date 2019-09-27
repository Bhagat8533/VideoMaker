package com.introvd.template.component.videofetcher;

import android.os.Environment;

/* renamed from: com.introvd.template.component.videofetcher.a */
public class C5355a {
    public static final String ciX;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append("/DCIM/VivaDownloader/");
        ciX = sb.toString();
    }
}
