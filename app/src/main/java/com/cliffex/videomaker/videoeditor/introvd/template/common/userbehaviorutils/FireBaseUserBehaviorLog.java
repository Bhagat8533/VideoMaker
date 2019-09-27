package com.introvd.template.common.userbehaviorutils;

import android.content.Context;
import android.os.Bundle;
import com.fiii.aiii.analytics.FirebaseAnalytics;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

public class FireBaseUserBehaviorLog extends BaseBehaviorLog {
    public void onKVEvent(Context context, String str, HashMap<String, String> hashMap) {
        Bundle bundle = new Bundle();
        if (hashMap != null && !hashMap.isEmpty()) {
            for (String str2 : hashMap.keySet()) {
                bundle.putString(str2, (String) hashMap.get(str2));
            }
        }
        FirebaseAnalytics.getInstance(context).logEvent(str, bundle);
    }

    public void setUserProperty(String str, String str2) {
        try {
            FirebaseAnalytics.getInstance(UserBehaviorLog.s_Application).setUserProperty("country", String.valueOf(str));
            FirebaseAnalytics.getInstance(UserBehaviorLog.s_Application).setUserProperty("lang", String.valueOf(str2));
        } catch (Exception unused) {
        }
    }

    public void updateAccount(String str, long j) {
        try {
            FirebaseAnalytics.getInstance(UserBehaviorLog.s_Application).setUserId(String.valueOf(j));
            FirebaseAnalytics.getInstance(UserBehaviorLog.s_Application).setUserProperty("duid", String.valueOf(j));
            FirebaseAnalytics.getInstance(UserBehaviorLog.s_Application).setUserProperty("auid", String.valueOf(str));
        } catch (Exception unused) {
        }
    }
}
