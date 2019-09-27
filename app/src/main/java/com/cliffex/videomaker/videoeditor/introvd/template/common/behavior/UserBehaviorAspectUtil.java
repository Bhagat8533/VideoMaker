package com.introvd.template.common.behavior;

import android.text.TextUtils;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;
import org.p487a.p488a.C9957a;
import org.p487a.p488a.C9957a.C9958a;

public class UserBehaviorAspectUtil {
    public static final String LOG_EVENT_CLICK_EVENT = "Log_Event_Click_Event";
    public static final String LOG_EVENT_ITEM_CLICK_EVENT = "Log_Event_Item_Click_Event";
    private static final String TAG = "UserBehaviorAspectUtil";

    private HashMap<String, String> getInfoFromJoinPoint(C9957a aVar) {
        if (aVar == null) {
            return null;
        }
        C9958a aZF = aVar.aZF();
        if (aZF == null || aZF.aZG() == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String bVar = aZF.aZG().toString();
        String str = "";
        String str2 = "";
        Object[] aZE = aVar.aZE();
        if (aZE != null && aZE.length > 0 && (aZE[0] instanceof View)) {
            View view = (View) aZE[0];
            str2 = view.getClass().getName();
            if (view.getTag() != null) {
                str = view.getTag().toString();
            }
        }
        if (!TextUtils.isEmpty(bVar)) {
            hashMap.put("ControlName", bVar.replace(" ", "_"));
        }
        hashMap.put("ControlType", str2);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(Param.INDEX, str);
        }
        return hashMap;
    }

    public void clickEvent() {
        LogUtils.m14223i(TAG, "===CORECLICK===1 clickEvent");
    }

    public void logClickEvent(C9957a aVar) {
        HashMap infoFromJoinPoint = getInfoFromJoinPoint(aVar);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("===CORECLICK===1 ");
        sb.append(infoFromJoinPoint);
        LogUtils.m14223i(str, sb.toString());
        UserBehaviorLog.onAliEvent(LOG_EVENT_CLICK_EVENT, infoFromJoinPoint);
    }

    public void logItemClickEvent(C9957a aVar) {
        HashMap infoFromJoinPoint = getInfoFromJoinPoint(aVar);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("===COREITEMCLICK===2 ");
        sb.append(infoFromJoinPoint);
        LogUtils.m14223i(str, sb.toString());
        UserBehaviorLog.onAliEvent(LOG_EVENT_ITEM_CLICK_EVENT, infoFromJoinPoint);
    }

    public void onItemClick() {
        LogUtils.m14223i(TAG, "===COREITEMCLICK===2 clickEvent");
    }
}
