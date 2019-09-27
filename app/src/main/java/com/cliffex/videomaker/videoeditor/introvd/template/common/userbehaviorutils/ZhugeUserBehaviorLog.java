package com.introvd.template.common.userbehaviorutils;

import android.content.Context;
import com.zhuge.analysis.stat.ZhugeSDK;
import java.util.HashMap;
import java.util.Map;

public class ZhugeUserBehaviorLog extends BaseBehaviorLog {
    public ZhugeUserBehaviorLog(Context context, Map<String, Object> map) {
        ZhugeSDK.getInstance().disablePhoneNumber(true);
        ZhugeSDK.getInstance().init(context);
    }

    public void onKVEvent(Context context, String str, HashMap<String, String> hashMap) {
    }

    public void setDebugMode(boolean z) {
        ZhugeSDK.getInstance().setDebug(z);
    }
}
