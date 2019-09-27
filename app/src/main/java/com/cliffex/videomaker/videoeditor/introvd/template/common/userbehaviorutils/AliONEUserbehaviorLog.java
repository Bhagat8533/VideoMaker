package com.introvd.template.common.userbehaviorutils;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.aiii.sdk.android.man.MANAnalytics;
import com.aiii.sdk.android.man.MANHitBuilders.MANCustomHitBuilder;
import com.aiii.sdk.android.man.MANService;
import com.aiii.sdk.android.man.MANServiceProvider;
import com.introvd.template.common.UserBehaviorLog;
import com.ut.mini.UTAnalytics;
import com.vivavideo.mobile.p431a.C9318b;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AliONEUserbehaviorLog extends BaseBehaviorLog {
    private MANService ciw = MANServiceProvider.getService();
    private boolean cix;
    private C5346a ciy;

    public AliONEUserbehaviorLog(Application application, Context context, Map<String, Object> map) {
        Log.d("AliONEUserbehaviorLog", "AliONEUserbehaviorLog init");
        String str = (String) map.get("ali_appkey");
        String str2 = (String) map.get("ali_secret");
        String str3 = (String) map.get("appkey_channel");
        MANAnalytics mANAnalytics = this.ciw.getMANAnalytics();
        mANAnalytics.turnOffCrashReporter();
        if (TextUtils.isEmpty(str3)) {
            str3 = "10009900";
        }
        if (str3.length() == 8) {
            mANAnalytics.setChannel(str3.substring(6));
        }
        mANAnalytics.init(application, context, str, str2);
        mANAnalytics.setAppVersion(C9318b.getAppVersion(context));
        this.ciy = new C5346a(this);
    }

    public void onAliEvent(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            MANCustomHitBuilder mANCustomHitBuilder = new MANCustomHitBuilder(str);
            if (map.containsKey("alisdk_event_duration")) {
                mANCustomHitBuilder.setDurationOnEvent(Long.valueOf((String) map.get("alisdk_event_duration")).longValue());
                map.remove("alisdk_event_duration");
            }
            if (map.containsKey("alisdk_pagename")) {
                mANCustomHitBuilder.setEventPage((String) map.get("alisdk_pagename"));
                map.remove("alisdk_pagename");
            }
            for (Entry entry : map.entrySet()) {
                if (entry != null) {
                    mANCustomHitBuilder.setProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            this.ciw.getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        }
    }

    public void onKVEvent(Context context, String str, HashMap<String, String> hashMap) {
        if (UserBehaviorLog.isEnable()) {
            try {
                hashMap.put("appState", isForeground() ? "fore" : "bg");
                if (this.cix) {
                    onAliEvent(str, hashMap);
                } else {
                    this.ciy.mo26917h(str, hashMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pageDisappear(Object obj) {
        if (obj != null) {
            UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(obj);
        }
    }

    public void pageFragmentAppear(Object obj, String... strArr) {
        if (obj != null) {
            UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(obj);
            if (strArr == null || strArr.length <= 0) {
                UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(obj);
            } else {
                UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(obj, strArr[0]);
                UTAnalytics.getInstance().getDefaultTracker().updatePageName(obj, strArr[0]);
            }
        }
    }

    public void regRelatID(String str, String str2) {
        if (this.ciw != null) {
            this.ciw.getMANAnalytics().updateUserAccount(str, str2);
        }
        this.cix = !TextUtils.isEmpty(str2);
        if (this.cix) {
            this.ciy.mo26916ZB();
        }
    }

    public void setDebugMode(boolean z) {
        if (z && this.ciw != null) {
            this.ciw.getMANAnalytics().turnOnDebug();
        }
    }

    public void skipPage(Object obj) {
        if (obj != null) {
            UTAnalytics.getInstance().getDefaultTracker().skipPage(obj);
        }
    }
}
