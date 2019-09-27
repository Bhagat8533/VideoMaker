package com.introvd.template.datacenter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.p243e.C5542a;
import com.introvd.template.p309f.C7352f;
import com.xiaoying.p448a.C9537b;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import lib.C12177i;

public class BaseSocialNotify {
    public static final String CONNECTIVITY_NAME_MOBILE = "MOBILE";
    public static final String CONNECTIVITY_NAME_WIFI = "WIFI";
    public static final int NETWORK_ACCESS_TYPE_COMMON = 0;
    public static final int NETWORK_ACCESS_TYPE_DOWNLOAD = 2;
    public static final int NETWORK_ACCESS_TYPE_UPLOAD = 1;
    public static final int NETWORK_STATUS_INACTIVE = -1;
    public static final int NETWORK_STATUS_NOTALLOW = -2;
    public static final int NETWORK_STATUS_OK = 0;
    public static final int SOCIAL_MGR_RESULT_CANCEL = 327680;
    public static final int SOCIAL_MGR_RESULT_FAIL = 65536;
    public static final int SOCIAL_MGR_RESULT_OK = 131072;
    public static final int SOCIAL_MGR_RESULT_PENDING = 0;
    public static final int SOCIAL_MGR_RESULT_RETRY = 458752;
    public static final int SOCIAL_MGR_RESULT_RUNNING = 196608;
    private static final String TAG = "BaseSocialNotify";
    private static Map<String, PendingIntent> mPendingIntentMap = Collections.synchronizedMap(new LinkedHashMap());

    public static int checkNetworkPrefAndState(Context context, int i) {
        String activeNetworkName = getActiveNetworkName(context);
        if (activeNetworkName == null) {
            return -1;
        }
        if (i == 1 || i == 2) {
            boolean bUsageMobileNet = getBUsageMobileNet(context);
            if (activeNetworkName.toUpperCase(Locale.ENGLISH).equalsIgnoreCase(CONNECTIVITY_NAME_MOBILE) && !bUsageMobileNet) {
                return -2;
            }
        }
        return 0;
    }

    private static void feedbackMessage(Context context, String str, int i, long j, long j2) {
        if (context != null) {
            Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_SERVICE_FEEDBACK);
            intent.putExtra("social_method", str);
            intent.putExtra("errCode", i);
            intent.putExtra("wParam", j);
            intent.putExtra("lParam", j2);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static final void fillFeedbackParam(Bundle bundle, String str, int i, long j, long j2) {
        if (bundle != null) {
            if (str != null && bundle.get("social_method") == null) {
                bundle.putString("social_method", str);
            }
            if (bundle.get("errCode") == null) {
                bundle.putInt("errCode", i);
            }
            if (bundle.get("wParam") == null) {
                bundle.putInt("wParam", 0);
            }
            if (bundle.get("lParam") == null) {
                bundle.putInt("lParam", 0);
            }
        }
    }

    public static String getActiveNetworkName(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = null;
        if (!isNetworkAvaliable(context, sb)) {
            return null;
        }
        if (sb.length() != 0) {
            str = sb.toString();
        }
        return str;
    }

    public static boolean getBUsageMobileNet(Context context) {
        return AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_network_mobile", false);
    }

    public static int getBadNetworkAccessCount() {
        String parameter = C9537b.getParameter("FailedCount");
        if (!TextUtils.isEmpty(parameter)) {
            return Integer.parseInt(parameter);
        }
        return 0;
    }

    public static long getNetworkTaskCheckingDelay(long j) {
        int badNetworkAccessCount = getBadNetworkAccessCount();
        int i = badNetworkAccessCount <= 3 ? 3000 : badNetworkAccessCount <= 10 ? C12177i.f6157m : badNetworkAccessCount <= 20 ? C12177i.f6158n : badNetworkAccessCount <= 30 ? 600000 : 3600000;
        return Math.max(j, (long) i);
    }

    public static boolean isNetworkAvaliable(Context context) {
        return isNetworkAvaliable(context, null);
    }

    public static boolean isNetworkAvaliable(Context context, StringBuilder sb) {
        boolean z;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            z = activeNetworkInfo.isConnected();
            if (z && sb != null) {
                try {
                    String typeName = activeNetworkInfo.getTypeName();
                    if (typeName != null) {
                        sb.append(typeName.toUpperCase(Locale.ENGLISH));
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return z;
                }
            }
            return z;
        } catch (Exception e2) {
            e = e2;
            z = false;
            e.printStackTrace();
            return z;
        }
    }

    public static void removeAllPendingIntent(Context context) {
        try {
            if (mPendingIntentMap.isEmpty()) {
                mPendingIntentMap.clear();
                return;
            }
            Set keySet = mPendingIntentMap.keySet();
            if (keySet.isEmpty()) {
                mPendingIntentMap.clear();
                return;
            }
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.addAll(keySet);
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                alarmManager.cancel((PendingIntent) mPendingIntentMap.get((String) it.next()));
            }
            mPendingIntentMap.clear();
        } catch (Exception unused) {
        } catch (Throwable th) {
            mPendingIntentMap.clear();
            throw th;
        }
    }

    public static void removePendingIntent(Context context, String str) {
        try {
            PendingIntent pendingIntent = (PendingIntent) mPendingIntentMap.remove(str);
            if (pendingIntent != null) {
                ((AlarmManager) context.getSystemService("alarm")).cancel(pendingIntent);
            }
        } catch (Exception unused) {
        }
    }

    public static void reportNetworkError(Context context, String str, int i, long j, long j2) {
        if (str != null && context != null) {
            Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_SERVICE_NETWORK_ERR_REPORT);
            intent.putExtra("social_method", str);
            intent.putExtra("errCode", i);
            intent.putExtra("wParam", j);
            intent.putExtra("lParam", j2);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("reportNetworkError, method:");
            sb.append(str);
            sb.append(", errCode:");
            sb.append(i);
            LogUtils.m14222e(str2, sb.toString());
        }
    }

    public static void scheduleIntent(Context context, Intent intent, int i) {
        int i2;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("social_method");
                if (stringExtra != null) {
                    removePendingIntent(context, stringExtra);
                    int intExtra = intent.getIntExtra(SocialServiceDef.EXTRAS_SERVICE_TASK_REPROCESS, 0);
                    if (intExtra != 0) {
                        if (i != 0) {
                            i2 = intExtra <= 3 ? SocialServiceDef.SERVICE_TIME_DELAY_CHECKING : intExtra <= 6 ? C12177i.f6158n : intExtra <= 10 ? 600000 : intExtra <= 15 ? 1800000 : 3600000;
                            int i3 = intExtra + 1;
                            int max = Math.max(i, i2);
                            intent.putExtra(SocialServiceDef.EXTRAS_SERVICE_TASK_REPROCESS, i3);
                            PendingIntent service = PendingIntent.getService(context, 0, intent, 0);
                            Calendar instance = Calendar.getInstance();
                            instance.setTimeInMillis(System.currentTimeMillis());
                            instance.add(14, max);
                            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                            mPendingIntentMap.put(stringExtra, service);
                            alarmManager.set(0, instance.getTimeInMillis(), service);
                        }
                    }
                    i2 = i;
                    int i32 = intExtra + 1;
                    int max2 = Math.max(i, i2);
                    intent.putExtra(SocialServiceDef.EXTRAS_SERVICE_TASK_REPROCESS, i32);
                    PendingIntent service2 = PendingIntent.getService(context, 0, intent, 0);
                    Calendar instance2 = Calendar.getInstance();
                    instance2.setTimeInMillis(System.currentTimeMillis());
                    instance2.add(14, max2);
                    AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
                    mPendingIntentMap.put(stringExtra, service2);
                    alarmManager2.set(0, instance2.getTimeInMillis(), service2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void notifyAllListener(Context context, String str, int i, Bundle bundle, C5542a aVar) {
        if (bundle != null) {
            try {
                String string = bundle.getString(SocialServiceDef.TODO_TASK_ID);
                if (!TextUtils.isEmpty(string)) {
                    if (i == 131072) {
                        C7352f.m21703i(context.getContentResolver(), string);
                    } else if (i == 65536) {
                        if (bundle.getInt("errCode", -1) < 900) {
                            C7352f.m21703i(context.getContentResolver(), string);
                        } else {
                            C7352f.m21694a(context.getContentResolver(), string, 65536);
                            TaskService.doPendingTask(context, DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS);
                        }
                    }
                }
            } finally {
            }
        }
        if (aVar != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("social_method", str);
            aVar.onExecuteServiceNotify("key_api_method", i, bundle);
        }
        int i2 = bundle.getInt("errCode", -1);
        int i3 = bundle.getInt("wParam", 0);
        int i4 = bundle.getInt("lParam", 0);
        if (i2 > 0 || i3 > 0) {
            feedbackMessage(context, str, i2, (long) i3, (long) i4);
        }
    }

    public void onHandleIntentFailed(Context context, Intent intent) {
    }

    public void onNotify(Context context, String str, Object obj, int i) {
        onNotify(context, str, obj, i, 0, null);
    }

    public void onNotify(Context context, String str, Object obj, int i, int i2, Intent intent) {
        onNotify(context, str, obj, i, i2, intent, null);
    }

    public void onNotify(Context context, String str, Object obj, int i, int i2, Intent intent, C5542a aVar) {
    }
}
