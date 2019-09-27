package com.introvd.template.app.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.R;
import com.introvd.template.app.AppTodoInterceptorImpl;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.splash.SplashActivity;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p203b.C4584e;
import com.introvd.template.router.todoCode.TodoConstants;
import com.p131c.p132a.p135c.C2575a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.alarm.a */
public class C3724a {
    private static volatile C3724a bjw;
    private AlarmManager aju = ((AlarmManager) this.mContext.getSystemService("alarm"));
    private Context mContext;

    private C3724a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* renamed from: G */
    private String m9044G(Context context, int i) {
        if (4099 == i) {
            return context.getResources().getString(R.string.xiaoying_str_ve_uncomplete_video_tips);
        }
        int nextInt = new Random().nextInt(3) % 3;
        return nextInt == 0 ? 4097 == i ? context.getResources().getString(R.string.xiaoying_str_com_long_time_no_use_tips_01) : context.getResources().getString(R.string.xiaoying_str_com_gallery_scan_tips_01) : 1 == nextInt ? 4097 == i ? context.getResources().getString(R.string.xiaoying_str_com_long_time_no_use_tips_02) : context.getResources().getString(R.string.xiaoying_str_com_gallery_scan_tips_02) : 4097 == i ? context.getResources().getString(R.string.xiaoying_str_com_long_time_no_use_tips_03) : context.getResources().getString(R.string.xiaoying_str_com_gallery_scan_tips_03);
    }

    /* renamed from: H */
    public static void m9045H(Context context, String str) {
        Intent intent = new Intent(context, SplashActivity.class);
        intent.setFlags(805306368);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.putExtra("event", str);
        intent.putExtra("PushService", "local_notify_click");
        context.startActivity(intent);
    }

    /* renamed from: I */
    private void m9046I(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        UserBehaviorLog.onKVEvent(context, "Local_Push_Receive", hashMap);
    }

    /* renamed from: Ih */
    public static boolean m9047Ih() {
        return AppPreferencesSetting.getInstance().getAppSettingInt("key_next_day_location_notification_show_count", 0) < 2 && !AppPreferencesSetting.getInstance().getAppSettingBoolean("key_next_day_location_notification_clicked", false);
    }

    /* renamed from: J */
    private void m9048J(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        UserBehaviorLog.onKVEvent(context, "Local_Push_Click", hashMap);
    }

    /* renamed from: a */
    static int m9049a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(7);
    }

    /* renamed from: a */
    private static Date m9050a(Date date, int i) {
        Date b = m9051b(C4584e.m11680c(date), 7);
        Calendar instance = Calendar.getInstance();
        instance.setTime(b);
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                instance.set(7, i);
                break;
            default:
                instance.set(7, 1);
                break;
        }
        return C4584e.m11680c(instance.getTime());
    }

    /* renamed from: b */
    static Date m9051b(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(6, i);
        return instance.getTime();
    }

    /* renamed from: bR */
    public static C3724a m9052bR(Context context) {
        if (bjw == null) {
            synchronized (C3724a.class) {
                bjw = new C3724a(context);
            }
        }
        return bjw;
    }

    /* renamed from: c */
    static Date m9053c(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(11, i);
        return instance.getTime();
    }

    /* renamed from: d */
    static Date m9054d(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(12, i);
        return instance.getTime();
    }

    /* renamed from: e */
    private String m9055e(int i, String str) {
        if (4097 == i) {
            return C4395c.m11102h(1, "");
        }
        if (4098 == i) {
            return C4395c.m11102h(408, "");
        }
        if (4099 == i) {
            return C4395c.m11102h(TodoConstants.TODO_TYPE_EDITOR_PREVIEW, str);
        }
        if (4102 != i && 4103 != i) {
            return 4104 == i ? C4395c.m11102h(424, "") : new JSONObject().toString();
        }
        AppPreferencesSetting.getInstance().setAppSettingBoolean("key_next_day_location_notification_clicked", true);
        return C4395c.m11102h(TodoConstants.TODO_TYPE_OPEN_URL, AppTodoInterceptorImpl.makeOpenUrlTodoContent("https://hybrid.xiaoying.tv/web/xiaoying/upend/upend10.html"));
    }

    public static int getCurrentTime() {
        return C2575a.parseInt(new SimpleDateFormat("HH", Locale.US).format(new Date()));
    }

    /* renamed from: a */
    public void mo23081a(long j, int i) {
        mo23085gp(i);
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent("com.diii.xiaoying.alarm.receive");
        intent.setPackage(this.mContext.getPackageName());
        intent.putExtra("alarm_request_code", i);
        intent.putExtra("alarm_event_unique_id", currentTimeMillis);
        this.aju.set(1, j, PendingIntent.getBroadcast(this.mContext, i, intent, 134217728));
        HashMap hashMap = new HashMap();
        hashMap.put("unique_id", String.valueOf(currentTimeMillis));
        UserBehaviorLog.onKVEvent(this.mContext, "Dev_Event_Alarm_Event_Start", hashMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0163  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo23082a(android.content.Context r13, int r14, java.lang.String r15) {
        /*
            r12 = this;
            java.lang.String r0 = "XiaoYingActivityWeakRef"
            r1 = 0
            r3 = 0
            java.lang.Object r0 = com.introvd.template.common.MagicCode.getMagicParam(r1, r0, r3)
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            if (r0 == 0) goto L_0x0016
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 == 0) goto L_0x0016
            return
        L_0x0016:
            r0 = 4103(0x1007, float:5.75E-42)
            r1 = 4102(0x1006, float:5.748E-42)
            r2 = 4099(0x1003, float:5.744E-42)
            r3 = 4098(0x1002, float:5.743E-42)
            r4 = 4097(0x1001, float:5.741E-42)
            r5 = 0
            r6 = 43200000(0x2932e00, double:2.1343636E-316)
            if (r4 != r14) goto L_0x002f
            java.lang.String r8 = "key_last_long_no_use_ts"
            boolean r6 = com.introvd.template.common.utils.PeriodDetectUtil.isInPeriod(r8, r6)
            if (r6 == 0) goto L_0x0056
            return
        L_0x002f:
            if (r3 != r14) goto L_0x003a
            java.lang.String r8 = "key_last_scan_gallery_ts"
            boolean r6 = com.introvd.template.common.utils.PeriodDetectUtil.isInPeriod(r8, r6)
            if (r6 == 0) goto L_0x0056
            return
        L_0x003a:
            if (r2 != r14) goto L_0x0045
            java.lang.String r8 = "key_last_video_uncomplete_ts"
            boolean r6 = com.introvd.template.common.utils.PeriodDetectUtil.isInPeriod(r8, r6)
            if (r6 == 0) goto L_0x0056
            return
        L_0x0045:
            if (r1 == r14) goto L_0x0049
            if (r0 != r14) goto L_0x0056
        L_0x0049:
            com.introvd.template.common.AppPreferencesSetting r6 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r7 = "key_next_day_location_notification_clicked"
            boolean r6 = r6.getAppSettingBoolean(r7, r5)
            if (r6 == 0) goto L_0x0056
            return
        L_0x0056:
            java.lang.String r6 = r12.m9044G(r13, r14)
            android.content.res.Resources r7 = r13.getResources()
            int r8 = com.introvd.template.R.string.xiaoying_str_com_app_name
            java.lang.String r7 = r7.getString(r8)
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r9 = "com.diii.xiaoying.alarm.click"
            r8.<init>(r9)
            java.lang.String r9 = r13.getPackageName()
            r8.setPackage(r9)
            java.lang.String r9 = "alarm_notification_click"
            r10 = 1
            r8.putExtra(r9, r10)
            java.lang.String r9 = "alarm_request_code"
            r8.putExtra(r9, r14)
            r9 = 4104(0x1008, float:5.751E-42)
            r11 = 8193(0x2001, float:1.1481E-41)
            if (r4 != r14) goto L_0x008f
            com.introvd.template.app.p177b.C3741a.m9110IH()
            java.lang.String r15 = "14days"
            r12.m9046I(r13, r15)
        L_0x008b:
            r9 = 8193(0x2001, float:1.1481E-41)
            goto L_0x010f
        L_0x008f:
            if (r3 != r14) goto L_0x009d
            r9 = 8194(0x2002, float:1.1482E-41)
            com.introvd.template.app.p177b.C3741a.m9110IH()
            java.lang.String r15 = "weekend"
            r12.m9046I(r13, r15)
            goto L_0x010f
        L_0x009d:
            if (r2 != r14) goto L_0x00af
            java.lang.String r0 = "alarm_notification_data"
            r8.putExtra(r0, r15)
            r9 = 8195(0x2003, float:1.1484E-41)
            com.introvd.template.app.p177b.C3741a.m9110IH()
            java.lang.String r15 = "unexport"
            r12.m9046I(r13, r15)
            goto L_0x010f
        L_0x00af:
            if (r1 == r14) goto L_0x00c6
            if (r0 != r14) goto L_0x00b4
            goto L_0x00c6
        L_0x00b4:
            if (r9 != r14) goto L_0x008b
            android.content.res.Resources r15 = r13.getResources()
            int r0 = com.introvd.template.R.string.xiaoying_str_com_app_auto_create_video_notice
            java.lang.String r6 = r15.getString(r0)
            java.lang.String r15 = "new_mv"
            r12.m9046I(r13, r15)
            goto L_0x010f
        L_0x00c6:
            r9 = 8196(0x2004, float:1.1485E-41)
            com.introvd.template.common.AppPreferencesSetting r15 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r0 = "key_next_day_location_notification_show_count"
            int r15 = r15.getAppSettingInt(r0, r5)
            if (r15 != 0) goto L_0x00eb
            android.content.res.Resources r0 = r13.getResources()
            int r1 = com.introvd.template.R.string.xiaoying_str_location_notification_title1
            java.lang.String r0 = r0.getString(r1)
            android.content.res.Resources r1 = r13.getResources()
            int r2 = com.introvd.template.R.string.xiaoying_str_location_notification_content1
            java.lang.String r1 = r1.getString(r2)
        L_0x00e8:
            r7 = r0
            r6 = r1
            goto L_0x0100
        L_0x00eb:
            android.content.res.Resources r0 = r13.getResources()
            int r1 = com.introvd.template.R.string.xiaoying_str_location_notification_title2
            java.lang.String r0 = r0.getString(r1)
            android.content.res.Resources r1 = r13.getResources()
            int r2 = com.introvd.template.R.string.xiaoying_str_location_notification_content2
            java.lang.String r1 = r1.getString(r2)
            goto L_0x00e8
        L_0x0100:
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r1 = "key_next_day_location_notification_show_count"
            int r15 = r15 + r10
            r0.setAppSettingInt(r1, r15)
            java.lang.String r15 = "reverse"
            r12.m9046I(r13, r15)
        L_0x010f:
            android.app.PendingIntent r15 = android.app.PendingIntent.getBroadcast(r13, r9, r8, r5)
            java.lang.String r0 = "notification"
            java.lang.Object r0 = r13.getSystemService(r0)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            android.support.v4.app.NotificationCompat$BigTextStyle r1 = new android.support.v4.app.NotificationCompat$BigTextStyle
            r1.<init>()
            android.support.v4.app.NotificationCompat$BigTextStyle r2 = r1.setBigContentTitle(r7)
            r2.bigText(r6)
            int r2 = com.introvd.template.R.mipmap.ic_launcher
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 < r4) goto L_0x0131
            int r2 = com.introvd.template.R.drawable.push_icon_notice_logo
        L_0x0131:
            android.support.v4.app.NotificationCompat$Builder r3 = new android.support.v4.app.NotificationCompat$Builder
            java.lang.String r4 = "com.introvd.template.notification.default"
            r3.<init>(r13, r4)
            android.support.v4.app.NotificationCompat$Builder r13 = r3.setSmallIcon(r2)
            android.support.v4.app.NotificationCompat$Builder r13 = r13.setTicker(r6)
            android.support.v4.app.NotificationCompat$Builder r13 = r13.setContentTitle(r7)
            android.support.v4.app.NotificationCompat$Builder r13 = r13.setContentText(r6)
            android.support.v4.app.NotificationCompat$Builder r13 = r13.setAutoCancel(r10)
            r2 = -1
            android.support.v4.app.NotificationCompat$Builder r13 = r13.setDefaults(r2)
            android.support.v4.app.NotificationCompat$Builder r13 = r13.setContentIntent(r15)
            android.support.v4.app.NotificationCompat$Builder r13 = r13.setStyle(r1)
            android.app.Notification r13 = r13.build()
            int r15 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r15 < r1) goto L_0x0170
            android.app.NotificationChannel r15 = new android.app.NotificationChannel
            java.lang.String r1 = "com.introvd.template.notification.default"
            java.lang.String r2 = "Default"
            r3 = 3
            r15.<init>(r1, r2, r3)
            r0.createNotificationChannel(r15)
        L_0x0170:
            r0.notify(r14, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.alarm.C3724a.mo23082a(android.content.Context, int, java.lang.String):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23083b(Context context, int i, String str) {
        if (4097 == i) {
            m9048J(context, "14days");
        } else if (4098 == i) {
            m9048J(context, "weekend");
        } else if (4099 == i) {
            m9048J(context, "unexport");
        } else if (4102 == i || 4103 == i) {
            m9048J(context, "reverse");
        } else if (4104 == i) {
            m9048J(context, "new_mv");
        }
        try {
            m9045H(context, m9055e(i, str));
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }

    /* renamed from: dj */
    public void mo23084dj(int i) {
        mo23081a(mo23086gq(i), i);
    }

    /* renamed from: gp */
    public void mo23085gp(int i) {
        this.aju.cancel(PendingIntent.getBroadcast(this.mContext, i, new Intent("com.diii.xiaoying.alarm.receive"), 0));
    }

    /* renamed from: gq */
    public long mo23086gq(int i) {
        if (4097 == i) {
            return m9053c(m9051b(C4584e.m11680c(new Date()), 14), 19).getTime();
        }
        if (4098 == i) {
            return m9053c(m9050a(C4584e.m11680c(new Date()), 1), 18).getTime();
        }
        if (4099 == i) {
            Date c = C4584e.m11680c(new Date());
            if (getCurrentTime() >= 19) {
                c = m9051b(c, 1);
            }
            long time = m9053c(c, 19).getTime();
            long currentTimeMillis = (time - System.currentTimeMillis()) / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("getNormalCheckTime REQUEST_CODE_VIDEO_UNCOMPLETE intervalTime ");
            sb.append(currentTimeMillis);
            LogUtilsV2.m14230i(sb.toString());
            return time;
        } else if (4100 == i) {
            return new Date().getTime() + DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS;
        } else {
            if (4101 == i) {
                return new Date().getTime() + DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
            }
            if (4102 == i) {
                Date d = m9054d(m9053c(m9051b(C4584e.m11680c(new Date()), 1), 19), 30);
                long time2 = d.getTime();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("show location notification when :  ");
                sb2.append(d.toString());
                LogUtilsV2.m14230i(sb2.toString());
                return time2;
            } else if (4103 == i) {
                Date d2 = m9054d(m9053c(C4584e.m11680c(new Date()), 19), 30);
                long time3 = d2.getTime();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("show location notification when :  ");
                sb3.append(d2.toString());
                LogUtilsV2.m14230i(sb3.toString());
                return time3;
            } else if (4104 == i) {
                return C3742b.m9111II().mo23160Jg() > 0 ? m9051b(C4584e.m11680c(new Date()), 1).getTime() + (C3742b.m9111II().mo23160Jg() * 1000) : m9053c(m9051b(C4584e.m11680c(new Date()), 1), 12).getTime();
            } else {
                return 2147483647L;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gr */
    public long mo23087gr(int i) {
        long parseLong = 4097 == i ? C2575a.parseLong(AppPreferencesSetting.getInstance().getAppSettingStr("key_last_long_no_use_ts", "0")) : C2575a.parseLong(AppPreferencesSetting.getInstance().getAppSettingStr("key_last_scan_gallery_ts", "0"));
        return 0 == parseLong ? mo23086gq(i) : mo23086gq(i) - parseLong;
    }
}
