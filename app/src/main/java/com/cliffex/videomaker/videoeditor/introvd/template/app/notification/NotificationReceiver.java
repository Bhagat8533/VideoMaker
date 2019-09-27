package com.introvd.template.app.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.aiii.sdk.android.oss.common.RequestParameters;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;

public class NotificationReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("onReceive action : ");
        sb.append(action);
        LogUtilsV2.m14230i(sb.toString());
        if (!"xiaoying_notification_clicked".equals(action)) {
            try {
                String stringExtra = intent.getStringExtra("pushType");
                String stringExtra2 = intent.getStringExtra("pushMessageId");
                if ("GROUP".equals(stringExtra)) {
                    UserBehaviorUtilsV5.recordPushOperationEvent(RequestParameters.SUBRESOURCE_DELETE, stringExtra2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return;
        }
        C4082d.m10137h(context, intent);
    }
}
