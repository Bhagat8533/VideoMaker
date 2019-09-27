package com.introvd.template.datacenter;

import android.content.Context;
import android.os.Environment;
import com.introvd.template.channel.C5206b;

public class ProviderUtil {
    public static void copyAllDatabaseToSD(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("/data/data/");
        sb.append(context.getPackageName());
        sb.append("/database/");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("/data/data/");
        sb3.append(context.getPackageName());
        sb3.append("/databases/");
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStorageDirectory().getPath());
        sb5.append("/");
        sb5.append(C5206b.m14211dU(context));
        sb5.append("/.private/");
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(sb6);
        sb7.append("database/");
        String sb8 = sb7.toString();
        StringBuilder sb9 = new StringBuilder();
        sb9.append(sb6);
        sb9.append("databases/");
        String sb10 = sb9.toString();
        FileUtils.copyDirectory(sb2, sb8);
        FileUtils.copyDirectory(sb4, sb10);
    }
}
