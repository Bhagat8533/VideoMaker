package com.introvd.template.common.api;

import android.content.Context;
import java.util.HashMap;

public interface XYUserBehaviorService {
    void onAliEvent(String str, HashMap<String, String> hashMap);

    void onKVEvent(Context context, String str, HashMap<String, String> hashMap);

    void onKillProcess(Context context);

    void onPause(Context context);

    void onResume(Context context);
}
