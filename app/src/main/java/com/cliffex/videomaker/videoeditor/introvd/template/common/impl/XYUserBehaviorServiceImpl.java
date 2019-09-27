package com.introvd.template.common.impl;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.api.XYUserBehaviorService;
import java.util.HashMap;

public class XYUserBehaviorServiceImpl implements XYUserBehaviorService {
    public void onAliEvent(String str, HashMap<String, String> hashMap) {
        UserBehaviorLog.onAliEvent(str, hashMap);
    }

    public void onKVEvent(Context context, String str, HashMap<String, String> hashMap) {
        UserBehaviorLog.onKVEvent(context, str, hashMap);
    }

    public void onKillProcess(Context context) {
        UserBehaviorLog.onKillProcess(context);
    }

    public void onPause(Context context) {
        UserBehaviorLog.onPause(context);
    }

    public void onResume(Context context) {
        UserBehaviorLog.onResume(context);
    }
}
