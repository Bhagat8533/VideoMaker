package com.introvd.template;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

/* renamed from: com.introvd.template.f */
public class C4676f {
    private static boolean bfI;
    private static String bfJ;

    /* renamed from: FY */
    public static boolean m12172FY() {
        return bfI;
    }

    /* renamed from: bq */
    public static String m12173bq(Context context) {
        if (context == null) {
            return null;
        }
        if (bfJ != null) {
            return bfJ;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        bfJ = runningAppProcessInfo.processName;
                        return bfJ;
                    }
                }
            }
        }
        return null;
    }

    public static void init(Context context) {
        String bq = m12173bq(context);
        if (TextUtils.equals(context.getPackageName(), bq) || TextUtils.isEmpty(bq)) {
            bfI = true;
        } else {
            bfI = false;
        }
    }
}
