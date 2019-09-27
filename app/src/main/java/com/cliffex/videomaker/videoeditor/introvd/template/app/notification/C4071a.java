package com.introvd.template.app.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.p021v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.introvd.template.R;
import com.introvd.template.XiaoYingActivity;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.datacenter.SocialConstDef;
import com.p131c.p132a.p135c.C2575a;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.app.notification.a */
public class C4071a {
    /* access modifiers changed from: private */
    public static Map<Integer, Notification> buQ = Collections.synchronizedMap(new HashMap());
    private static C4072a buR = null;
    private static HandlerThread mHandlerThread = null;

    /* renamed from: com.introvd.template.app.notification.a$a */
    private static class C4072a extends Handler {
        private Context mContext = null;

        public C4072a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
                if (message.what < 1 || message.what > 99 || !C4071a.m10119ct(this.mContext)) {
                    notificationManager.cancel(message.what);
                    C4071a.buQ.remove(Integer.valueOf(message.what));
                }
            } catch (Exception unused) {
            }
        }

        public void setContext(Context context) {
            this.mContext = context.getApplicationContext();
        }
    }

    /* renamed from: Nh */
    public static boolean m10116Nh() {
        Calendar instance = Calendar.getInstance();
        int i = (instance.get(11) * 60) + instance.get(12);
        return i < 510 || i >= 1260;
    }

    /* renamed from: a */
    public static synchronized void m10117a(Context context, int i, long j) {
        synchronized (C4071a.class) {
            if (mHandlerThread == null) {
                mHandlerThread = new HandlerThread("NotificationCenterMonitor");
                mHandlerThread.start();
                buR = new C4072a(mHandlerThread.getLooper());
            }
            buR.removeMessages(i);
            buR.setContext(context);
            buR.sendEmptyMessageDelayed(i, j);
        }
    }

    /* renamed from: a */
    public static void m10118a(Context context, int i, Notification notification) {
        if (context != null && notification != null) {
            if (m10116Nh()) {
                notification.defaults &= -2;
                notification.defaults &= -3;
                notification.defaults &= -5;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("com.introvd.template.notification.default", "Default", 3));
            }
            try {
                notificationManager.notify(i, notification);
            } catch (Exception e) {
                C5523b.logException(e);
            }
        }
    }

    /* renamed from: ct */
    public static boolean m10119ct(Context context) {
        if (context == null || TextUtils.isEmpty(BaseSocialNotify.getActiveNetworkName(context))) {
            return false;
        }
        Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TASK), new String[]{"_id"}, "state= ?", new String[]{String.valueOf(196608)}, null);
        if (query != null) {
            int count = query.getCount();
            query.close();
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    public static void hideDownloadNotification(Context context, int i) {
        if (buR != null) {
            buR.removeMessages(i);
        }
        m10117a(context, i, 100);
    }

    public static void setNotificationProgress(Context context, int i, int i2, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        Notification notification = new Notification(i2, sb.toString(), System.currentTimeMillis());
        notification.contentView = new RemoteViews(context.getPackageName(), R.layout.notification);
        notification.contentView.setProgressBar(R.id.progressbar, 100, str3.contains(".") ? (int) C2575a.parseFloat(str3) : C2575a.parseInt(str3), false);
        notification.contentView.setTextViewText(R.id.content_title, str2);
        notification.contentView.setTextViewText(R.id.content_text, str);
        RemoteViews remoteViews = notification.contentView;
        int i3 = R.id.content_info;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        sb2.append("%");
        remoteViews.setTextViewText(i3, sb2.toString());
        Intent intent = new Intent(context, XiaoYingActivity.class);
        intent.putExtra("switch_share_page", true);
        intent.setFlags(536870912);
        notification.contentIntent = PendingIntent.getActivity(context, 0, intent, 0);
        ((NotificationManager) context.getSystemService("notification")).notify(i, notification);
        if (buR != null) {
            buR.removeMessages(i);
        }
        m10117a(context, i, (long) DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    public static void showDownloadNotification(Context context, int i, String str, int i2) {
        Notification notification;
        String string = context.getResources().getString(R.string.xiaoying_str_com_msg_download);
        if (!buQ.containsKey(Integer.valueOf(i))) {
            Builder smallIcon = new Builder(context, "com.introvd.template.notification.download").setSmallIcon(R.drawable.nofi_download);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" - ");
            sb.append(string);
            notification = smallIcon.setTicker(sb.toString()).setWhen(System.currentTimeMillis()).build();
            notification.contentView = new RemoteViews(context.getPackageName(), R.layout.notification);
            notification.contentView.setTextViewText(R.id.content_title, string);
            notification.contentView.setTextViewText(R.id.content_text, str);
            notification.contentView.setImageViewResource(R.id.icon, R.drawable.nofi_download);
            buQ.put(Integer.valueOf(i), notification);
        } else {
            notification = (Notification) buQ.get(Integer.valueOf(i));
        }
        notification.contentView.setProgressBar(R.id.progressbar, 100, i2, false);
        RemoteViews remoteViews = notification.contentView;
        int i3 = R.id.content_info;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i2);
        sb2.append("%");
        remoteViews.setTextViewText(i3, sb2.toString());
        notification.contentIntent = PendingIntent.getActivity(context, 0, new Intent(), 0);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("com.introvd.template.notification.download", SocialConstDef.TBL_NAME_DOWNLOAD, 2));
        }
        notificationManager.notify(i, notification);
        if (buR != null) {
            buR.removeMessages(i);
        }
        m10117a(context, i, (long) DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }
}
