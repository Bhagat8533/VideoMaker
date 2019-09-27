package com.introvd.template.common.userbehaviorutils;

import android.content.Context;
import com.PinkiePie;
import com.introvd.template.common.UserBehaviorLog;
import com.umeng.analytics.MobclickAgent;
import com.umeng.onlineconfig.OnlineConfigAgent;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UMengUserBehaviorLog extends BaseBehaviorLog {
    public UMengUserBehaviorLog(Map<String, Object> map) {
    }

    /* renamed from: a */
    private static void m14562a(HashMap<String, String> hashMap) {
        String[] strArr;
        if (hashMap != null && !hashMap.isEmpty()) {
            Set keySet = hashMap.keySet();
            for (String str : (String[]) keySet.toArray(new String[keySet.size()])) {
                String str2 = (String) hashMap.get(str);
                if (str2 != null && str2.length() > 200) {
                    hashMap.put(str, m14565fy(str2));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
        return;
     */
    /* renamed from: as */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m14563as(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = com.introvd.template.common.UserBehaviorLog.isEnable()     // Catch:{ all -> 0x0098 }
            if (r0 == 0) goto L_0x0096
            if (r8 != 0) goto L_0x000b
            monitor-exit(r7)
            return
        L_0x000b:
            java.lang.String r0 = "StackRec"
            r1 = 0
            android.content.SharedPreferences r0 = r8.getSharedPreferences(r0, r1)     // Catch:{ all -> 0x0098 }
            if (r0 != 0) goto L_0x0016
            monitor-exit(r7)
            return
        L_0x0016:
            java.lang.String r2 = "AppStack"
            java.lang.String r3 = ""
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r3.<init>(r2)     // Catch:{ all -> 0x0098 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0098 }
            if (r2 != 0) goto L_0x002e
            java.lang.String r2 = "|"
            r3.append(r2)     // Catch:{ all -> 0x0098 }
        L_0x002e:
            java.util.Date r2 = new java.util.Date     // Catch:{ all -> 0x0098 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0098 }
            r2.<init>(r4)     // Catch:{ all -> 0x0098 }
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = "HH:mm:ss.SSS"
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ all -> 0x0098 }
            r4.<init>(r5, r6)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.format(r2)     // Catch:{ all -> 0x0098 }
            r3.append(r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = " "
            r3.append(r2)     // Catch:{ all -> 0x0098 }
            r3.append(r9)     // Catch:{ all -> 0x0098 }
            java.lang.String r9 = ": "
            r3.append(r9)     // Catch:{ all -> 0x0098 }
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x0098 }
            java.lang.String r8 = r8.getSimpleName()     // Catch:{ all -> 0x0098 }
            r3.append(r8)     // Catch:{ all -> 0x0098 }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x0098 }
            java.lang.String r9 = "\\|"
            java.lang.String[] r9 = r8.split(r9)     // Catch:{ all -> 0x0098 }
            if (r9 != 0) goto L_0x006d
            r9 = 0
            goto L_0x006e
        L_0x006d:
            int r9 = r9.length     // Catch:{ all -> 0x0098 }
        L_0x006e:
            r2 = 50
            if (r9 <= r2) goto L_0x0082
            java.lang.String r2 = "|"
            int r1 = r8.indexOf(r2, r1)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = "|"
            int r2 = r2.length()     // Catch:{ all -> 0x0098 }
            int r1 = r1 + r2
            int r9 = r9 + -1
            goto L_0x006e
        L_0x0082:
            if (r1 == 0) goto L_0x0088
            java.lang.String r8 = r8.substring(r1)     // Catch:{ all -> 0x0098 }
        L_0x0088:
            android.content.SharedPreferences$Editor r9 = r0.edit()     // Catch:{ all -> 0x0098 }
            if (r9 == 0) goto L_0x0096
            java.lang.String r0 = "AppStack"
            r9.putString(r0, r8)     // Catch:{ all -> 0x0098 }
            r9.commit()     // Catch:{ all -> 0x0098 }
        L_0x0096:
            monitor-exit(r7)
            return
        L_0x0098:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.userbehaviorutils.UMengUserBehaviorLog.m14563as(android.content.Context, java.lang.String):void");
    }

    /* renamed from: b */
    private static HashMap<String, String> m14564b(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        try {
            int i = Calendar.getInstance().get(11);
            if (hashMap.size() < 10) {
                hashMap.put("time period", String.valueOf(i));
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    /* renamed from: fy */
    private static String m14565fy(String str) {
        return (str == null || str.length() <= 200) ? str : str.substring(0, 200);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void clearStack(android.content.Context r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = com.introvd.template.common.UserBehaviorLog.isEnable()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            if (r3 != 0) goto L_0x000b
            monitor-exit(r2)
            return
        L_0x000b:
            java.lang.String r0 = "StackRec"
            r1 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r0, r1)     // Catch:{ all -> 0x0026 }
            if (r3 != 0) goto L_0x0016
            monitor-exit(r2)
            return
        L_0x0016:
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0026 }
            if (r3 == 0) goto L_0x0024
            java.lang.String r0 = "AppStack"
            r3.remove(r0)     // Catch:{ all -> 0x0026 }
            r3.commit()     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r2)
            return
        L_0x0026:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.userbehaviorutils.UMengUserBehaviorLog.clearStack(android.content.Context):void");
    }

    public void onEvent(Context context, String str) {
        if (UserBehaviorLog.isEnable()) {
            try {
                onKVEvent(context, str, null);
            } catch (Exception unused) {
            }
        }
    }

    public void onEvent(Context context, String str, String str2) {
        if (UserBehaviorLog.isEnable()) {
            String fy = m14565fy(str2);
            try {
                PinkiePie.DianePie();
            } catch (Exception unused) {
            }
        }
    }

    public void onEventEnd(Context context, String str) {
        if (UserBehaviorLog.isEnable()) {
            try {
                onKVEventEnd(context, str, str);
            } catch (Exception unused) {
            }
        }
    }

    public void onEventEnd(Context context, String str, String str2) {
        if (UserBehaviorLog.isEnable()) {
            m14565fy(str2);
        }
    }

    public void onKVEvent(Context context, String str, HashMap<String, String> hashMap) {
        if (UserBehaviorLog.isEnable()) {
            try {
                m14562a(hashMap);
                HashMap b = m14564b(hashMap);
                PinkiePie.DianePie();
            } catch (Exception unused) {
            }
        }
    }

    public void onKVEventBegin(Context context, String str, HashMap<String, String> hashMap, String str2) {
        if (UserBehaviorLog.isEnable()) {
            try {
                m14562a(hashMap);
                m14564b(hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public void onKVEventEnd(Context context, String str, String str2) {
        UserBehaviorLog.isEnable();
    }

    public void onKillProcess(Context context) {
        if (UserBehaviorLog.isEnable() && context != null) {
            try {
                MobclickAgent.onKillProcess(context);
            } catch (Exception unused) {
            }
        }
    }

    public void onPause(Context context) {
        if (UserBehaviorLog.isEnable()) {
            try {
                m14563as(context, "onPause");
                MobclickAgent.onPause(context);
            } catch (Exception unused) {
            }
        }
    }

    public void onResume(Context context) {
        if (UserBehaviorLog.isEnable()) {
            try {
                m14563as(context, "onResume");
                MobclickAgent.onResume(context);
            } catch (Exception unused) {
            }
        }
    }

    public void setCrashLogReport(boolean z) {
        if (UserBehaviorLog.isEnable()) {
            try {
                MobclickAgent.setCatchUncaughtExceptions(z);
            } catch (Exception unused) {
            }
        }
    }

    public void setDebugMode(boolean z) {
        if (UserBehaviorLog.isEnable()) {
            try {
                MobclickAgent.setDebugMode(z);
            } catch (Exception unused) {
            }
        }
    }

    public void setReportPolicy(Context context, int i) {
    }

    public void updateOnlineConfig(Context context) {
        if (UserBehaviorLog.isEnable()) {
            try {
                OnlineConfigAgent.getInstance().updateOnlineConfig(context);
            } catch (Exception unused) {
            }
        }
    }
}
