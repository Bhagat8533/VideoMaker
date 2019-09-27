package com.introvd.template.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.crash.C5523b;

public class NetworkRuntimeBroadcastReceiver extends BroadcastReceiver {
    /* renamed from: cw */
    public static void m10224cw(Context context) {
        if (context != null && VERSION.SDK_INT >= 24) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(new NetworkRuntimeBroadcastReceiver(), intentFilter);
        }
    }

    public void onReceive(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Receive Network getAction = ");
        sb.append(intent.getAction());
        sb.append(",isInitialStickyBroadcast = ");
        sb.append(isInitialStickyBroadcast());
        LogUtilsV2.m14227d(sb.toString());
        if (!isInitialStickyBroadcast()) {
            try {
                C4129a.schedule();
            } catch (Exception e) {
                C5523b.logException(e);
            }
        }
    }
}
