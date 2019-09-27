package com.introvd.template.common.userbehaviorutils;

import android.content.Context;
import android.text.TextUtils;
import com.PinkiePie;
import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryAgent.Builder;
import java.util.HashMap;
import java.util.Map;

public class FlurryUserBehaviorLog extends BaseBehaviorLog {
    public FlurryUserBehaviorLog(Context context, Map<String, Object> map) {
        String str = (String) map.get("Flurry_API_key");
        String str2 = (String) map.get("Flurry_User_ID");
        if (!TextUtils.isEmpty(str2)) {
            regRelatID(str2, "");
        }
        FlurryAgent.init(context, str);
        new Builder().build(context, str);
    }

    public void onEvent(Context context, String str) {
        PinkiePie.DianePie();
    }

    public void onKVEvent(Context context, String str, HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            PinkiePie.DianePie();
        } else {
            PinkiePie.DianePie();
        }
    }

    public void regRelatID(String str, String str2) {
        try {
            FlurryAgent.setUserId(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
