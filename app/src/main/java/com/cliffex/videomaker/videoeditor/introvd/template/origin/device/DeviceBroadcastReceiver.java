package com.introvd.template.origin.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.p203b.C4600l;

public class DeviceBroadcastReceiver extends BroadcastReceiver {
    /* renamed from: cw */
    public static void m23518cw(Context context) {
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(new DeviceBroadcastReceiver(), intentFilter);
        }
    }

    public void onReceive(Context context, Intent intent) {
        boolean k = C4600l.m11739k(context, false);
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceLogin:network connect : ");
        sb.append(k);
        LogUtilsV2.m14230i(sb.toString());
        if (k) {
            C8138f.aEW().aEX();
        }
    }
}
