package com.introvd.template.app.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.crash.C5523b;
import java.util.HashMap;

public class AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.diii.xiaoying.alarm.receive".equals(action)) {
            long longExtra = intent.getLongExtra("alarm_event_unique_id", -1);
            HashMap hashMap = new HashMap();
            hashMap.put("unique_id", String.valueOf(longExtra));
            UserBehaviorLog.onKVEvent(context, "Dev_Event_Alarm_Event_End", hashMap);
            C3724a bR = C3724a.m9052bR(context);
            int intExtra = intent.getIntExtra("alarm_request_code", -1);
            String stringExtra = intent.getStringExtra("alarm_notification_data");
            boolean booleanExtra = intent.getBooleanExtra("alarm_notification_click", false);
            if (4104 == intExtra) {
                bR.mo23082a(context, intExtra, stringExtra);
                return;
            }
            try {
                C3725b.m9065a(intExtra, stringExtra, booleanExtra);
            } catch (Exception e) {
                C5523b.logException(e);
            }
        } else if ("com.diii.xiaoying.alarm.click".equals(action)) {
            C3724a.m9052bR(context).mo23083b(context, intent.getIntExtra("alarm_request_code", -1), intent.getStringExtra("alarm_notification_data"));
        } else if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
            UserBehaviorLog.onEvent(context, "Dev_Event_Device_Complete");
            C3724a bR2 = C3724a.m9052bR(context);
            bR2.mo23081a(System.currentTimeMillis() + bR2.mo23087gr(4097), 4097);
            bR2.mo23081a(System.currentTimeMillis() + bR2.mo23087gr(4098), 4098);
            bR2.mo23084dj(4100);
        }
    }
}
