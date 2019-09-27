package com.introvd.template.editor.common.p249c;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.common.c.a */
public class C5844a {
    /* renamed from: W */
    public static void m16354W(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialConstDef.SEARCH_HISTORY_COUNT, String.valueOf(i));
        UserBehaviorLog.onKVEvent(context, "Preview_Theme_Auto_Downloaded_Count", hashMap);
    }

    /* renamed from: X */
    public static void m16355X(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("downloaded_count", String.valueOf(i));
        UserBehaviorLog.onKVEvent(context, "Wifi_Theme_Auto_Download_Pause", hashMap);
    }
}
