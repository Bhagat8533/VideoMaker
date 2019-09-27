package com.introvd.template.common.userbehaviorutils;

import android.content.Context;
import java.util.HashMap;

public abstract class AbstractUserBehaviorLog {
    private boolean isForeground = true;

    public abstract void clearStack(Context context);

    public boolean isForeground() {
        return this.isForeground;
    }

    public abstract void onEvent(Context context, String str);

    public abstract void onEventEnd(Context context, String str);

    public abstract void onKVEvent(Context context, String str, HashMap<String, String> hashMap);

    public abstract void onKVEventBegin(Context context, String str, HashMap<String, String> hashMap, String str2);

    public abstract void onKillProcess(Context context);

    public abstract void onPause(Context context);

    public abstract void onResume(Context context);

    public abstract void setCrashLogReport(boolean z);

    public abstract void setDebugMode(boolean z);

    public void setForeground(boolean z) {
        this.isForeground = z;
    }

    public abstract void setReportPolicy(Context context, int i);

    public abstract void updateOnlineConfig(Context context);
}
