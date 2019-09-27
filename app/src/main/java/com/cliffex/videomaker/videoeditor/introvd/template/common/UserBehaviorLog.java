package com.introvd.template.common;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.introvd.template.common.userbehaviorutils.AbstractUserBehaviorLog;
import com.introvd.template.common.userbehaviorutils.AliONEUserbehaviorLog;
import com.introvd.template.common.userbehaviorutils.FBUserBehaviorLog;
import com.introvd.template.common.userbehaviorutils.FireBaseUserBehaviorLog;
import com.introvd.template.common.userbehaviorutils.FlurryUserBehaviorLog;
import com.introvd.template.common.userbehaviorutils.GAUserBehaviorLog;
import com.introvd.template.common.userbehaviorutils.ThreadHelper;
import com.introvd.template.common.userbehaviorutils.UMengUserBehaviorLog;
import com.introvd.template.common.userbehaviorutils.ZhugeUserBehaviorLog;
import com.vivavideo.mobile.p431a.C9317a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserBehaviorLog {
    public static boolean DEBUG = false;
    public static final String UBA_ROUTE_TO_GA = GAUserBehaviorLog.class.getSimpleName();
    public static final String UBA_ROUTE_TO_UMENG = UMengUserBehaviorLog.class.getSimpleName();
    public static final String UBA_ROUTE_TO_ZHUGEIO = ZhugeUserBehaviorLog.class.getSimpleName();
    /* access modifiers changed from: private */
    public static final List<AbstractUserBehaviorLog> cda = new ArrayList();
    private static int cdb = 0;
    private static boolean cdc = true;
    /* access modifiers changed from: private */
    public static int cdd = 0;
    private static Map<String, Object> cde = null;
    private static ABTestListener cdf;
    private static HashMap<String, String> cdg;
    public static volatile boolean isForeground = true;
    public static Application s_Application;

    /* renamed from: YY */
    private static HashMap<String, String> m14268YY() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api_level", String.valueOf(VERSION.SDK_INT));
        return hashMap;
    }

    /* renamed from: a */
    private static void m14270a(final AbstractUserBehaviorLog abstractUserBehaviorLog) {
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                UserBehaviorLog.cda.add(abstractUserBehaviorLog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static boolean m14271a(AbstractUserBehaviorLog abstractUserBehaviorLog, int i) {
        return (((((((abstractUserBehaviorLog instanceof UMengUserBehaviorLog) && (i & 1) != 0) || ((abstractUserBehaviorLog instanceof GAUserBehaviorLog) && (i & 2) != 0)) || ((abstractUserBehaviorLog instanceof ZhugeUserBehaviorLog) && (i & 4) != 0)) || ((abstractUserBehaviorLog instanceof FlurryUserBehaviorLog) && (i & 8) != 0)) || ((abstractUserBehaviorLog instanceof AliONEUserbehaviorLog) && (i & 16) != 0)) || ((abstractUserBehaviorLog instanceof FBUserBehaviorLog) && (i & 32) != 0)) || ((abstractUserBehaviorLog instanceof FireBaseUserBehaviorLog) && (i & 64) != 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void addCommonMap(java.util.HashMap<java.lang.String, java.lang.String> r2) {
        /*
            java.lang.Class<com.introvd.template.common.UserBehaviorLog> r0 = com.introvd.template.common.UserBehaviorLog.class
            monitor-enter(r0)
            if (r2 == 0) goto L_0x0021
            int r1 = r2.size()     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = cdg     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x0017
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x001e }
            r1.<init>()     // Catch:{ all -> 0x001e }
            cdg = r1     // Catch:{ all -> 0x001e }
        L_0x0017:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = cdg     // Catch:{ all -> 0x001e }
            r1.putAll(r2)     // Catch:{ all -> 0x001e }
            monitor-exit(r0)
            return
        L_0x001e:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x0021:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.UserBehaviorLog.addCommonMap(java.util.HashMap):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0038, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void m14272b(android.app.Application r3, android.content.Context r4) {
        /*
            java.lang.Class<com.introvd.template.common.UserBehaviorLog> r0 = com.introvd.template.common.UserBehaviorLog.class
            monitor-enter(r0)
            boolean r1 = isEnable()     // Catch:{ all -> 0x0039 }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r0)
            return
        L_0x000b:
            int r1 = cdb     // Catch:{ all -> 0x0039 }
            r2 = 127(0x7f, float:1.78E-43)
            r1 = r1 & r2
            if (r1 != r2) goto L_0x0014
            monitor-exit(r0)
            return
        L_0x0014:
            int r1 = cdb     // Catch:{ all -> 0x0039 }
            r1 = r1 & 16
            if (r1 != 0) goto L_0x0037
            java.lang.Class<com.aiii.sdk.android.man.MANServiceProvider> r1 = com.aiii.sdk.android.man.MANServiceProvider.class
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Throwable -> 0x002d }
            if (r1 == 0) goto L_0x0031
            com.introvd.template.common.userbehaviorutils.AliONEUserbehaviorLog r1 = new com.introvd.template.common.userbehaviorutils.AliONEUserbehaviorLog     // Catch:{ Throwable -> 0x002d }
            java.util.Map<java.lang.String, java.lang.Object> r2 = cde     // Catch:{ Throwable -> 0x002d }
            r1.<init>(r3, r4, r2)     // Catch:{ Throwable -> 0x002d }
            m14270a(r1)     // Catch:{ Throwable -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0039 }
        L_0x0031:
            int r3 = cdb     // Catch:{ all -> 0x0039 }
            r3 = r3 | 16
            cdb = r3     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r0)
            return
        L_0x0039:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.UserBehaviorLog.m14272b(android.app.Application, android.content.Context):void");
    }

    public static synchronized void clearCommonMap() {
        synchronized (UserBehaviorLog.class) {
            if (cdg != null) {
                cdg.clear();
                cdg = null;
            }
        }
    }

    public static synchronized void clearStack(final Context context) {
        synchronized (UserBehaviorLog.class) {
            init(context);
            ThreadHelper.getInstance().executeTask(new Runnable() {
                public void run() {
                    for (AbstractUserBehaviorLog clearStack : UserBehaviorLog.cda) {
                        clearStack.clearStack(context);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0097, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00d9, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0048 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x006a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0098 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x00b8 */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.content.Context r3) {
        /*
            java.lang.Class<com.introvd.template.common.UserBehaviorLog> r0 = com.introvd.template.common.UserBehaviorLog.class
            monitor-enter(r0)
            boolean r1 = isEnable()     // Catch:{ all -> 0x00da }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r0)
            return
        L_0x000b:
            int r1 = cdb     // Catch:{ all -> 0x00da }
            r2 = 127(0x7f, float:1.78E-43)
            r1 = r1 & r2
            if (r1 != r2) goto L_0x0014
            monitor-exit(r0)
            return
        L_0x0014:
            int r1 = cdb     // Catch:{ all -> 0x00da }
            r1 = r1 & 1
            if (r1 != 0) goto L_0x0030
            com.umeng.analytics.b r1 = com.umeng.analytics.MobclickAgent.getAgent()     // Catch:{ Throwable -> 0x002a }
            if (r1 == 0) goto L_0x002a
            com.introvd.template.common.userbehaviorutils.UMengUserBehaviorLog r1 = new com.introvd.template.common.userbehaviorutils.UMengUserBehaviorLog     // Catch:{ Throwable -> 0x002a }
            java.util.Map<java.lang.String, java.lang.Object> r2 = cde     // Catch:{ Throwable -> 0x002a }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x002a }
            m14270a(r1)     // Catch:{ Throwable -> 0x002a }
        L_0x002a:
            int r1 = cdb     // Catch:{ all -> 0x00da }
            r1 = r1 | 1
            cdb = r1     // Catch:{ all -> 0x00da }
        L_0x0030:
            int r1 = cdb     // Catch:{ all -> 0x00da }
            r1 = r1 & 2
            if (r1 != 0) goto L_0x004e
            java.lang.Class<com.google.android.gms.analytics.GoogleAnalytics> r1 = com.google.android.gms.analytics.GoogleAnalytics.class
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Throwable -> 0x0048 }
            if (r1 == 0) goto L_0x0048
            com.introvd.template.common.userbehaviorutils.GAUserBehaviorLog r1 = new com.introvd.template.common.userbehaviorutils.GAUserBehaviorLog     // Catch:{ Throwable -> 0x0048 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = cde     // Catch:{ Throwable -> 0x0048 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0048 }
            m14270a(r1)     // Catch:{ Throwable -> 0x0048 }
        L_0x0048:
            int r1 = cdb     // Catch:{ all -> 0x00da }
            r1 = r1 | 2
            cdb = r1     // Catch:{ all -> 0x00da }
        L_0x004e:
            int r1 = cdb     // Catch:{ all -> 0x00da }
            r1 = r1 & 4
            if (r1 != 0) goto L_0x0070
            if (r3 != 0) goto L_0x0058
            monitor-exit(r0)
            return
        L_0x0058:
            java.lang.Class<com.zhuge.analysis.stat.ZhugeSDK> r1 = com.zhuge.analysis.stat.ZhugeSDK.class
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Throwable -> 0x006a }
            if (r1 == 0) goto L_0x006a
            com.introvd.template.common.userbehaviorutils.ZhugeUserBehaviorLog r1 = new com.introvd.template.common.userbehaviorutils.ZhugeUserBehaviorLog     // Catch:{ Throwable -> 0x006a }
            java.util.Map<java.lang.String, java.lang.Object> r2 = cde     // Catch:{ Throwable -> 0x006a }
            r1.<init>(r3, r2)     // Catch:{ Throwable -> 0x006a }
            m14270a(r1)     // Catch:{ Throwable -> 0x006a }
        L_0x006a:
            int r1 = cdb     // Catch:{ all -> 0x00da }
            r1 = r1 | 4
            cdb = r1     // Catch:{ all -> 0x00da }
        L_0x0070:
            int r1 = cdb     // Catch:{ all -> 0x00da }
            r1 = r1 & 8
            if (r1 != 0) goto L_0x0098
            if (r3 == 0) goto L_0x0096
            java.util.Map<java.lang.String, java.lang.Object> r1 = cde     // Catch:{ all -> 0x00da }
            if (r1 != 0) goto L_0x007d
            goto L_0x0096
        L_0x007d:
            java.lang.Class<com.flurry.android.FlurryAgent> r1 = com.flurry.android.FlurryAgent.class
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Throwable -> 0x0098 }
            if (r1 == 0) goto L_0x008f
            com.introvd.template.common.userbehaviorutils.FlurryUserBehaviorLog r1 = new com.introvd.template.common.userbehaviorutils.FlurryUserBehaviorLog     // Catch:{ Throwable -> 0x0098 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = cde     // Catch:{ Throwable -> 0x0098 }
            r1.<init>(r3, r2)     // Catch:{ Throwable -> 0x0098 }
            m14270a(r1)     // Catch:{ Throwable -> 0x0098 }
        L_0x008f:
            int r1 = cdb     // Catch:{ Throwable -> 0x0098 }
            r1 = r1 | 8
            cdb = r1     // Catch:{ Throwable -> 0x0098 }
            goto L_0x0098
        L_0x0096:
            monitor-exit(r0)
            return
        L_0x0098:
            int r1 = cdb     // Catch:{ all -> 0x00da }
            r1 = r1 & 32
            if (r1 != 0) goto L_0x00b8
            if (r3 != 0) goto L_0x00a2
            monitor-exit(r0)
            return
        L_0x00a2:
            java.lang.Class<com.eiii.appevents.AppEventsLogger> r1 = com.eiii.appevents.AppEventsLogger.class
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Throwable -> 0x00b8 }
            if (r1 == 0) goto L_0x00b2
            com.introvd.template.common.userbehaviorutils.FBUserBehaviorLog r1 = new com.introvd.template.common.userbehaviorutils.FBUserBehaviorLog     // Catch:{ Throwable -> 0x00b8 }
            r1.<init>(r3)     // Catch:{ Throwable -> 0x00b8 }
            m14270a(r1)     // Catch:{ Throwable -> 0x00b8 }
        L_0x00b2:
            int r1 = cdb     // Catch:{ Throwable -> 0x00b8 }
            r1 = r1 | 32
            cdb = r1     // Catch:{ Throwable -> 0x00b8 }
        L_0x00b8:
            int r1 = cdb     // Catch:{ all -> 0x00da }
            r1 = r1 & 64
            if (r1 != 0) goto L_0x00d8
            if (r3 != 0) goto L_0x00c2
            monitor-exit(r0)
            return
        L_0x00c2:
            java.lang.Class<com.fiii.aiii.analytics.FirebaseAnalytics> r3 = com.fiii.aiii.analytics.FirebaseAnalytics.class
            java.lang.String r3 = r3.getSimpleName()     // Catch:{ Throwable -> 0x00d8 }
            if (r3 == 0) goto L_0x00d2
            com.introvd.template.common.userbehaviorutils.FireBaseUserBehaviorLog r3 = new com.introvd.template.common.userbehaviorutils.FireBaseUserBehaviorLog     // Catch:{ Throwable -> 0x00d8 }
            r3.<init>()     // Catch:{ Throwable -> 0x00d8 }
            m14270a(r3)     // Catch:{ Throwable -> 0x00d8 }
        L_0x00d2:
            int r3 = cdb     // Catch:{ Throwable -> 0x00d8 }
            r3 = r3 | 64
            cdb = r3     // Catch:{ Throwable -> 0x00d8 }
        L_0x00d8:
            monitor-exit(r0)
            return
        L_0x00da:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.UserBehaviorLog.init(android.content.Context):void");
    }

    public static boolean isEnable() {
        return cdc;
    }

    public static void onAliEvent(final String str, HashMap<String, String> hashMap) {
        final HashMap YY = m14268YY();
        if (hashMap != null) {
            YY.putAll(hashMap);
        }
        if (cdf != null && !TextUtils.isEmpty(cdf.getABTestKey()) && !TextUtils.isEmpty(cdf.getABTestValue()) && !YY.containsKey(cdf.getABTestKey())) {
            YY.put(cdf.getABTestKey(), cdf.getABTestValue());
        }
        if (DEBUG) {
            C9317a.m27024a(s_Application, 3, str, YY);
        }
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog abstractUserBehaviorLog : UserBehaviorLog.cda) {
                    if (abstractUserBehaviorLog instanceof AliONEUserbehaviorLog) {
                        abstractUserBehaviorLog.setForeground(UserBehaviorLog.isForeground);
                        ((AliONEUserbehaviorLog) abstractUserBehaviorLog).onAliEvent(str, YY);
                        return;
                    }
                }
            }
        });
    }

    public static void onEvent(final Context context, final String str) {
        init(context);
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog abstractUserBehaviorLog : UserBehaviorLog.cda) {
                    abstractUserBehaviorLog.setForeground(UserBehaviorLog.isForeground);
                    abstractUserBehaviorLog.onEvent(context, str);
                }
            }
        });
    }

    public static void onEventEnd(final Context context, final String str) {
        init(context);
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog abstractUserBehaviorLog : UserBehaviorLog.cda) {
                    abstractUserBehaviorLog.setForeground(UserBehaviorLog.isForeground);
                    abstractUserBehaviorLog.onEventEnd(context, str);
                }
            }
        });
    }

    public static void onKVEvent(final Context context, final String str, HashMap<String, String> hashMap) {
        init(context);
        final HashMap YY = m14268YY();
        if (hashMap != null) {
            YY.putAll(hashMap);
        }
        if (cdf != null && !TextUtils.isEmpty(cdf.getABTestKey()) && !TextUtils.isEmpty(cdf.getABTestValue()) && !YY.containsKey(cdf.getABTestKey())) {
            YY.put(cdf.getABTestKey(), cdf.getABTestValue());
        }
        if (cdg != null && cdg.size() > 0) {
            YY.putAll(cdg);
        }
        if (DEBUG) {
            C9317a.m27024a(s_Application, 3, str, YY);
        }
        final String str2 = (String) YY.remove("#XY_UBA_Behavior_Route");
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog abstractUserBehaviorLog : UserBehaviorLog.cda) {
                    if (!UserBehaviorLog.m14271a(abstractUserBehaviorLog, UserBehaviorLog.cdd) && (str2 == null || str2.equals(abstractUserBehaviorLog.getClass().getSimpleName()))) {
                        abstractUserBehaviorLog.setForeground(UserBehaviorLog.isForeground);
                        abstractUserBehaviorLog.onKVEvent(context, str, YY);
                    }
                }
            }
        });
    }

    public static void onKVEventBegin(final Context context, final String str, final HashMap<String, String> hashMap, final String str2) {
        init(context);
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog abstractUserBehaviorLog : UserBehaviorLog.cda) {
                    abstractUserBehaviorLog.setForeground(UserBehaviorLog.isForeground);
                    abstractUserBehaviorLog.onKVEventBegin(context, str, hashMap, str2);
                }
            }
        });
    }

    public static void onKillProcess(final Context context) {
        init(context);
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog onKillProcess : UserBehaviorLog.cda) {
                    onKillProcess.onKillProcess(context);
                }
            }
        });
    }

    public static void onPause(final Context context) {
        init(context);
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog onPause : UserBehaviorLog.cda) {
                    onPause.onPause(context);
                }
            }
        });
    }

    public static void onResume(final Context context) {
        init(context);
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog onResume : UserBehaviorLog.cda) {
                    onResume.onResume(context);
                }
            }
        });
    }

    public static void pageDisappear(final Object obj) {
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog abstractUserBehaviorLog : UserBehaviorLog.cda) {
                    if (abstractUserBehaviorLog instanceof AliONEUserbehaviorLog) {
                        ((AliONEUserbehaviorLog) abstractUserBehaviorLog).pageDisappear(obj);
                        return;
                    }
                }
            }
        });
    }

    public static void pageFragmentAppear(final Object obj, final String... strArr) {
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog abstractUserBehaviorLog : UserBehaviorLog.cda) {
                    if (abstractUserBehaviorLog instanceof AliONEUserbehaviorLog) {
                        ((AliONEUserbehaviorLog) abstractUserBehaviorLog).pageFragmentAppear(obj, strArr);
                        return;
                    }
                }
            }
        });
    }

    @Deprecated
    public static void reportError(Context context, String str) {
    }

    public static void setAbTestListener(ABTestListener aBTestListener) {
        cdf = aBTestListener;
    }

    public static void setCrashLogReport(Context context, final boolean z) {
        init(context);
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog crashLogReport : UserBehaviorLog.cda) {
                    crashLogReport.setCrashLogReport(z);
                }
            }
        });
    }

    public static void setDebugMode(Context context, final boolean z) {
        init(context);
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog debugMode : UserBehaviorLog.cda) {
                    debugMode.setDebugMode(z);
                }
            }
        });
    }

    public static void setEnable(boolean z) {
        cdc = z;
    }

    public static void setInitParam(Application application, final Context context, Map<String, Object> map) {
        if (map != null) {
            cde = new HashMap(map);
        }
        s_Application = application;
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                if (context != null) {
                    UserBehaviorLog.init(context);
                }
            }
        });
        if (application != null && context != null) {
            m14272b(application, context);
        }
    }

    public static void setLoggerDebug(boolean z) {
        DEBUG = z;
    }

    public static void setReportPolicy(final Context context, final int i) {
        init(context);
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog reportPolicy : UserBehaviorLog.cda) {
                    reportPolicy.setReportPolicy(context, i);
                }
            }
        });
    }

    public static void setUserProperty(final String str, final String str2) {
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog abstractUserBehaviorLog : UserBehaviorLog.cda) {
                    if (abstractUserBehaviorLog instanceof FireBaseUserBehaviorLog) {
                        ((FireBaseUserBehaviorLog) abstractUserBehaviorLog).setUserProperty(str, str2);
                    }
                }
            }
        });
    }

    public static void skipPage(final Object obj) {
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog abstractUserBehaviorLog : UserBehaviorLog.cda) {
                    if (abstractUserBehaviorLog instanceof AliONEUserbehaviorLog) {
                        ((AliONEUserbehaviorLog) abstractUserBehaviorLog).skipPage(obj);
                        return;
                    }
                }
            }
        });
    }

    public static void updateAccount(final String str, final long j) {
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog abstractUserBehaviorLog : UserBehaviorLog.cda) {
                    if (abstractUserBehaviorLog instanceof AliONEUserbehaviorLog) {
                        ((AliONEUserbehaviorLog) abstractUserBehaviorLog).regRelatID(str, Long.toString(j));
                        return;
                    } else if (abstractUserBehaviorLog instanceof FireBaseUserBehaviorLog) {
                        ((FireBaseUserBehaviorLog) abstractUserBehaviorLog).updateAccount(str, j);
                    }
                }
            }
        });
    }

    public static void updateOnlineConfig(final Context context) {
        init(context);
        ThreadHelper.getInstance().executeTask(new Runnable() {
            public void run() {
                for (AbstractUserBehaviorLog updateOnlineConfig : UserBehaviorLog.cda) {
                    updateOnlineConfig.updateOnlineConfig(context);
                }
            }
        });
    }
}
