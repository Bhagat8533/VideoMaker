package com.introvd.template.common.userbehaviorutils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.eiii.appevents.AppEventsLogger;
import java.util.HashMap;

public class FBUserBehaviorLog extends BaseBehaviorLog {
    private AppEventsLogger ciD;

    public FBUserBehaviorLog(Context context) {
        if (context != null) {
            AppEventsLogger.activateApp(context.getApplicationContext());
        }
    }

    /* renamed from: eg */
    private AppEventsLogger m14549eg(Context context) {
        if (this.ciD == null) {
            this.ciD = AppEventsLogger.newLogger(context);
        }
        return this.ciD;
    }

    public void onKVEvent(Context context, String str, HashMap<String, String> hashMap) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Bundle bundle = new Bundle();
                if (hashMap != null && !hashMap.keySet().isEmpty()) {
                    for (String str2 : hashMap.keySet()) {
                        bundle.putString(str2, (String) hashMap.get(str2));
                    }
                }
                m14549eg(context).logEvent(str, bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
