package com.introvd.template.common.userbehaviorutils;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.HitBuilders.TimingBuilder;
import com.google.android.gms.analytics.Tracker;
import com.vivavideo.mobile.p431a.C9318b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GAUserBehaviorLog extends BaseBehaviorLog {
    /* access modifiers changed from: private */
    public static List<Map<String, String>> cdE = Collections.synchronizedList(new ArrayList());
    private static String ciE = "GA_TRACKER_ID";
    private static Handler mHandler;
    private static HandlerThread mHandlerThread;
    private Tracker ciF = null;
    private Map<String, Long> ciG = Collections.synchronizedMap(new LinkedHashMap());
    boolean ciH = false;
    private GoogleAnalytics ciI = null;
    private Integer ciJ = null;
    private boolean mbInited = false;

    public GAUserBehaviorLog(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("GAScreenID");
            if (obj instanceof Integer) {
                this.ciJ = (Integer) obj;
            }
        }
    }

    /* renamed from: I */
    private void m14550I(Map<String, String> map) {
        if (this.ciF != null && map != null) {
            try {
                cdE.add(map);
                mHandler.sendEmptyMessageDelayed(0, cdE.size() >= 30 ? 1000 : 500);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ZC */
    public void m14552ZC() {
        if (this.ciF != null && cdE.size() != 0) {
            try {
                this.ciF.send((Map) cdE.remove(0));
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m14553a(Context context, String str, String str2, long j) {
        m14558eh(context);
        if (this.ciF != null) {
            try {
                m14550I(new TimingBuilder().setCategory(str).setVariable(m14559fy(str2)).setValue(j).build());
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    private static void m14555a(HashMap<String, String> hashMap) {
        String[] strArr;
        if (hashMap != null && !hashMap.isEmpty()) {
            Set keySet = hashMap.keySet();
            for (String str : (String[]) keySet.toArray(new String[keySet.size()])) {
                String str2 = (String) hashMap.get(str);
                if (str2 != null && str2.length() > 1024) {
                    hashMap.put(str, m14559fy(str2));
                }
            }
        }
    }

    /* renamed from: ab */
    private static String m14556ab(String str, String str2) {
        return String.format("evt_%s_lbl_%s", new Object[]{str, str2});
    }

    /* renamed from: b */
    private static HashMap<String, String> m14557b(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        try {
            hashMap.put("time period", String.valueOf(Calendar.getInstance().get(11)));
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    /* renamed from: eh */
    private void m14558eh(Context context) {
        if (context != null && !this.mbInited) {
            this.mbInited = true;
            if (this.ciI == null) {
                try {
                    this.ciI = GoogleAnalytics.getInstance(context.getApplicationContext());
                } catch (Throwable unused) {
                    return;
                }
            }
            if (this.ciF == null) {
                try {
                    String metaDataValue = C9318b.getMetaDataValue(context, ciE, "Unknown");
                    if (this.ciJ != null) {
                        this.ciF = this.ciI.newTracker(this.ciJ.intValue());
                    } else {
                        if ("Unknown".equals(metaDataValue)) {
                            metaDataValue = "UA-60675348-1";
                        }
                        this.ciF = this.ciI.newTracker(metaDataValue);
                    }
                    this.ciF.enableAdvertisingIdCollection(true);
                    this.ciF.enableExceptionReporting(false);
                } catch (Throwable unused2) {
                }
                setDebugMode(this.ciH);
            }
            if (mHandlerThread == null) {
                mHandlerThread = new HandlerThread("GASender", 10);
                mHandlerThread.start();
            }
            if (mHandler == null) {
                mHandler = new Handler(mHandlerThread.getLooper()) {
                    public void handleMessage(Message message) {
                        GAUserBehaviorLog.this.m14552ZC();
                        removeMessages(0);
                        int size = GAUserBehaviorLog.cdE.size();
                        if (size > 0) {
                            sendEmptyMessageDelayed(0, size >= 30 ? AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS : 1000);
                        }
                        super.handleMessage(message);
                    }
                };
            }
        }
    }

    /* renamed from: fy */
    private static String m14559fy(String str) {
        return (str == null || str.length() <= 1024) ? str : str.substring(0, 1024);
    }

    public void onEvent(Context context, String str) {
        onEvent(context, str, "Default");
    }

    public void onEvent(Context context, String str, String str2) {
        m14558eh(context);
        if (this.ciF != null) {
            try {
                m14550I(new EventBuilder().setCategory(str).setAction(m14559fy(str2)).build());
            } catch (Throwable unused) {
            }
        }
    }

    public void onEventEnd(Context context, String str) {
        onEventEnd(context, str, "Default");
    }

    public void onEventEnd(Context context, String str, String str2) {
        try {
            Long l = (Long) this.ciG.remove(m14556ab(str, str2));
            if (l != null) {
                m14553a(context, str, str2, System.currentTimeMillis() - l.longValue());
            }
        } catch (Throwable unused) {
        }
    }

    public void onKVEvent(Context context, String str, HashMap<String, String> hashMap) {
        m14558eh(context);
        if (this.ciF != null) {
            try {
                m14555a(hashMap);
                HashMap b = m14557b(hashMap);
                for (String str2 : b.keySet()) {
                    m14550I(new EventBuilder().setCategory(str).setAction(str2).setLabel((String) b.get(str2)).build());
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onPause(Context context) {
        m14558eh(context);
        if (this.ciI != null) {
            try {
                if (context instanceof Activity) {
                    if (VERSION.SDK_INT >= 14) {
                        this.ciI.enableAutoActivityReports(((Activity) context).getApplication());
                    } else {
                        this.ciI.reportActivityStop((Activity) context);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void onResume(Context context) {
        m14558eh(context);
        if (this.ciI != null) {
            try {
                if (context instanceof Activity) {
                    if (VERSION.SDK_INT >= 14) {
                        this.ciI.enableAutoActivityReports(((Activity) context).getApplication());
                    } else {
                        this.ciI.reportActivityStart((Activity) context);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void setDebugMode(boolean z) {
        this.ciH = z;
    }
}
