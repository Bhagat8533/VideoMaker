package com.introvd.template.datacenter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.Utils;
import com.introvd.template.p309f.C7349c;
import com.introvd.template.p309f.C7352f;
import com.xiaoying.p448a.C9561c;
import java.util.Iterator;
import org.json.JSONObject;

public class TaskService extends BaseIntentService {
    private static final int MAX_RUNNING_TASK_COUNT = 1;
    private static final String TAG = "TaskService";
    private static final String TASK_AUTO_NEXT_KEY = "autoNext";
    public static final int TASK_SERVER_RESULT_PENDING = 0;
    private static final int TIME_DELAY_CHECKING = 60000;
    private static MainHandler mHandler;
    private ContentResolver mContentResolver = null;

    private static class MainHandler extends Handler {
        private Context mContext;

        public MainHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (this.mContext != null && message.what == 0) {
                TaskService.doPendingTask(this.mContext, 0);
            }
        }

        public void setContext(Context context) {
            this.mContext = context.getApplicationContext();
        }
    }

    public TaskService() {
        super(TAG);
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void autoDriveNextTask() {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            int r2 = r10.getRunningTaskCount()     // Catch:{ all -> 0x0136 }
            if (r2 < r0) goto L_0x0048
            com.introvd.template.datacenter.TaskService$MainHandler r2 = mHandler
            r2.removeMessages(r1)
            android.content.Context r1 = r10.getApplicationContext()
            if (r1 == 0) goto L_0x0047
            boolean r2 = com.introvd.template.p374q.C8345d.aKc()
            if (r2 != 0) goto L_0x0047
            boolean r2 = com.introvd.template.p374q.C8345d.m24069gQ(r1)
            if (r2 == 0) goto L_0x0047
            int r2 = r10.getRunningAndPendingTaskCount()
            if (r2 != 0) goto L_0x0047
            com.introvd.template.datacenter.BaseSocialNotify.removeAllPendingIntent(r10)
            com.introvd.template.p374q.C8343b.m24053gO(r10)
            com.introvd.template.p374q.C8356h.m24101gO(r10)
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "socialservice.action.TASK"
            r2.setAction(r3)
            java.lang.String r3 = "AppExit"
            r2.putExtra(r3, r0)
            java.lang.String r0 = r10.getPackageName()
            r2.setPackage(r0)
            com.xiaoying.p448a.C9561c.m27511k(r1, r2)
        L_0x0047:
            return
        L_0x0048:
            android.content.ContentResolver r3 = r10.mContentResolver     // Catch:{ all -> 0x0136 }
            android.database.Cursor r3 = com.introvd.template.p309f.C7352f.m21702g(r3)     // Catch:{ all -> 0x0136 }
            if (r3 != 0) goto L_0x0090
            com.introvd.template.datacenter.TaskService$MainHandler r2 = mHandler
            r2.removeMessages(r1)
            android.content.Context r1 = r10.getApplicationContext()
            if (r1 == 0) goto L_0x008f
            boolean r2 = com.introvd.template.p374q.C8345d.aKc()
            if (r2 != 0) goto L_0x008f
            boolean r2 = com.introvd.template.p374q.C8345d.m24069gQ(r1)
            if (r2 == 0) goto L_0x008f
            int r2 = r10.getRunningAndPendingTaskCount()
            if (r2 != 0) goto L_0x008f
            com.introvd.template.datacenter.BaseSocialNotify.removeAllPendingIntent(r10)
            com.introvd.template.p374q.C8343b.m24053gO(r10)
            com.introvd.template.p374q.C8356h.m24101gO(r10)
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "socialservice.action.TASK"
            r2.setAction(r3)
            java.lang.String r3 = "AppExit"
            r2.putExtra(r3, r0)
            java.lang.String r0 = r10.getPackageName()
            r2.setPackage(r0)
            com.xiaoying.p448a.C9561c.m27511k(r1, r2)
        L_0x008f:
            return
        L_0x0090:
            r4 = 0
            r5 = 0
        L_0x0092:
            boolean r6 = r3.moveToNext()     // Catch:{ all -> 0x0134 }
            r7 = 262144(0x40000, float:3.67342E-40)
            if (r6 == 0) goto L_0x00c7
            java.lang.String r4 = r3.getString(r1)     // Catch:{ all -> 0x0134 }
            int r6 = r3.getInt(r0)     // Catch:{ all -> 0x0134 }
            r8 = 2
            int r8 = r3.getInt(r8)     // Catch:{ all -> 0x0134 }
            r9 = 3
            if (r8 == r9) goto L_0x00ac
        L_0x00aa:
            r4 = r6
            goto L_0x0092
        L_0x00ac:
            int r8 = com.introvd.template.datacenter.BaseSocialNotify.checkNetworkPrefAndState(r10, r1)     // Catch:{ all -> 0x0134 }
            if (r8 == 0) goto L_0x00b7
            r10.updateTaskStateForStopAll(r1)     // Catch:{ all -> 0x0134 }
            r2 = 1
            goto L_0x00c9
        L_0x00b7:
            boolean r8 = r10.startTask(r4)     // Catch:{ all -> 0x0134 }
            if (r8 == 0) goto L_0x00c1
            int r2 = r2 + 1
            r5 = 1
            goto L_0x00c4
        L_0x00c1:
            r10.updateTaskState(r4, r7)     // Catch:{ all -> 0x0134 }
        L_0x00c4:
            if (r2 < r0) goto L_0x00aa
            goto L_0x00c8
        L_0x00c7:
            r6 = r4
        L_0x00c8:
            r2 = 0
        L_0x00c9:
            r3.close()     // Catch:{ all -> 0x0134 }
            if (r2 == 0) goto L_0x00f2
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ all -> 0x0134 }
            r2.<init>()     // Catch:{ all -> 0x0134 }
            java.lang.String r3 = "state"
            r2.putInt(r3, r7)     // Catch:{ all -> 0x0134 }
            java.lang.String r3 = "sub_type"
            r2.putInt(r3, r6)     // Catch:{ all -> 0x0134 }
            java.lang.String r3 = "_id"
            r2.putInt(r3, r1)     // Catch:{ all -> 0x0134 }
            java.lang.String r3 = "project_title"
            java.lang.String r4 = ""
            r2.putString(r3, r4)     // Catch:{ all -> 0x0134 }
            java.lang.String r3 = "snstype"
            r4 = -1
            r2.putInt(r3, r4)     // Catch:{ all -> 0x0134 }
            com.introvd.template.datacenter.SocialServiceVideoNotify.showPublishNotification(r10, r2)     // Catch:{ all -> 0x0134 }
        L_0x00f2:
            if (r5 != 0) goto L_0x0133
            com.introvd.template.datacenter.TaskService$MainHandler r2 = mHandler
            r2.removeMessages(r1)
            android.content.Context r1 = r10.getApplicationContext()
            if (r1 == 0) goto L_0x0133
            boolean r2 = com.introvd.template.p374q.C8345d.aKc()
            if (r2 != 0) goto L_0x0133
            boolean r2 = com.introvd.template.p374q.C8345d.m24069gQ(r1)
            if (r2 == 0) goto L_0x0133
            int r2 = r10.getRunningAndPendingTaskCount()
            if (r2 != 0) goto L_0x0133
            com.introvd.template.datacenter.BaseSocialNotify.removeAllPendingIntent(r10)
            com.introvd.template.p374q.C8343b.m24053gO(r10)
            com.introvd.template.p374q.C8356h.m24101gO(r10)
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "socialservice.action.TASK"
            r2.setAction(r3)
            java.lang.String r3 = "AppExit"
            r2.putExtra(r3, r0)
            java.lang.String r0 = r10.getPackageName()
            r2.setPackage(r0)
            com.xiaoying.p448a.C9561c.m27511k(r1, r2)
        L_0x0133:
            return
        L_0x0134:
            r2 = move-exception
            goto L_0x0138
        L_0x0136:
            r2 = move-exception
            r5 = 0
        L_0x0138:
            if (r5 != 0) goto L_0x0179
            com.introvd.template.datacenter.TaskService$MainHandler r3 = mHandler
            r3.removeMessages(r1)
            android.content.Context r1 = r10.getApplicationContext()
            if (r1 == 0) goto L_0x0179
            boolean r3 = com.introvd.template.p374q.C8345d.aKc()
            if (r3 != 0) goto L_0x0179
            boolean r3 = com.introvd.template.p374q.C8345d.m24069gQ(r1)
            if (r3 == 0) goto L_0x0179
            int r3 = r10.getRunningAndPendingTaskCount()
            if (r3 != 0) goto L_0x0179
            com.introvd.template.datacenter.BaseSocialNotify.removeAllPendingIntent(r10)
            com.introvd.template.p374q.C8343b.m24053gO(r10)
            com.introvd.template.p374q.C8356h.m24101gO(r10)
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            java.lang.String r4 = "socialservice.action.TASK"
            r3.setAction(r4)
            java.lang.String r4 = "AppExit"
            r3.putExtra(r4, r0)
            java.lang.String r0 = r10.getPackageName()
            r3.setPackage(r0)
            com.xiaoying.p448a.C9561c.m27511k(r1, r3)
        L_0x0179:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TaskService.autoDriveNextTask():void");
    }

    private boolean checkTaskCondition() {
        return BaseSocialNotify.checkNetworkPrefAndState(this, 0) == 0;
    }

    private void clearTask(String str) {
        if (str == null) {
            C7349c.m21685c(this.mContentResolver);
            C7352f.m21698c(this.mContentResolver);
            return;
        }
        Cursor j = C7352f.m21704j(this.mContentResolver, str);
        if (j != null && j.getCount() > 0) {
            j.moveToFirst();
            String string = j.getString(0);
            j.close();
            j = null;
            Cursor g = C7349c.m21688g(this.mContentResolver, string);
            if (g != null) {
                if (g.moveToFirst()) {
                    String string2 = g.getString(0);
                    String string3 = g.getString(1);
                    String string4 = g.getString(2);
                    if (!TextUtils.isEmpty(string2)) {
                        FileUtils.deleteFile(string2);
                    }
                    if (!TextUtils.isEmpty(string3)) {
                        FileUtils.deleteFile(string3);
                    }
                    if (!TextUtils.isEmpty(string4)) {
                        FileUtils.deleteFile(string4);
                    }
                }
                g.close();
            }
            C7349c.m21686e(this.mContentResolver, string);
        }
        if (j != null) {
            j.close();
        }
        C7352f.m21703i(this.mContentResolver, str);
    }

    public static void doPendingTask(Context context, long j) {
        if (context != null) {
            initMyUri(context);
            Intent intent = new Intent();
            intent.setAction(SocialServiceDef.ACTION_SOCIAL_TASK);
            if (j <= 0) {
                intent.putExtra(TASK_AUTO_NEXT_KEY, true);
            } else {
                intent.putExtra(SocialServiceDef.EXTRAS_SERVICE_TASK_DELAY, j);
            }
            intent.setPackage(context.getPackageName());
            C9561c.m27511k(context, intent);
        }
    }

    private Bundle formatToDoList(String str) {
        Bundle bundle;
        Bundle bundle2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            if (keys == null) {
                return null;
            }
            bundle = new Bundle();
            while (keys.hasNext()) {
                try {
                    String str2 = (String) keys.next();
                    bundle.putString(str2, jSONObject.optString(str2));
                } catch (Exception unused) {
                }
            }
            if (bundle != null && !bundle.isEmpty()) {
                bundle2 = bundle;
            }
            return bundle2;
        } catch (Exception unused2) {
            bundle = null;
        }
    }

    private int getRunningAndPendingTaskCount() {
        Cursor e = C7352f.m21700e(this.mContentResolver);
        if (e == null) {
            return 0;
        }
        int count = e.getCount();
        e.close();
        return count;
    }

    private int getRunningTaskCount() {
        Cursor f = C7352f.m21701f(this.mContentResolver);
        if (f == null) {
            return 0;
        }
        int count = f.getCount();
        f.close();
        return count;
    }

    private static void initMyUri(Context context) {
        SocialProvider.init(context);
    }

    private boolean isEnable() {
        return true;
    }

    private boolean startTask(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("startTask, id:");
        sb.append(str);
        LogUtilsV2.m14228e(sb.toString());
        boolean z = false;
        if (!checkTaskCondition()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("startTask, login failed:");
            sb2.append(str);
            LogUtilsV2.m14228e(sb2.toString());
            return false;
        }
        Cursor k = C7352f.m21705k(this.mContentResolver, str);
        if (k == null) {
            return false;
        }
        if (k.getCount() == 0) {
            k.close();
            return false;
        }
        k.moveToFirst();
        int i = k.getInt(0);
        String string = k.getString(1);
        k.close();
        if (i == 3) {
            Bundle formatToDoList = formatToDoList(string);
            if (formatToDoList == null || formatToDoList.isEmpty()) {
                C7352f.m21703i(this.mContentResolver, str);
            } else {
                String string2 = formatToDoList.getString(SocialServiceDef.TODO_ACTION);
                if (!TextUtils.isEmpty(string2)) {
                    Intent intent = new Intent(string2);
                    formatToDoList.putString(SocialServiceDef.TODO_TASK_ID, str);
                    intent.putExtras(formatToDoList);
                    updateTaskState(str, 327680);
                    intent.setPackage(getPackageName());
                    C9561c.m27511k(this, intent);
                    z = true;
                }
            }
        }
        return z;
    }

    private void stopAllTask(boolean z, boolean z2) {
        if (!z) {
            updateTaskStateForStopAll(z2);
        } else {
            updateAllUnsuccTaskToStop(z2);
        }
    }

    private void updateAllUnsuccTaskToStop(boolean z) {
        C7352f.m21696a(this.mContentResolver, z);
    }

    private void updateTaskState(String str, int i) {
        C7352f.m21694a(this.mContentResolver, str, i);
    }

    private void updateTaskStateForRestart() {
        C7352f.m21699d(this.mContentResolver);
    }

    private void updateTaskStateForStopAll(boolean z) {
        C7352f.m21697b(this.mContentResolver, z);
    }

    public void onCreate() {
        super.onCreate();
        initMyUri(getApplicationContext());
        if (mHandler == null) {
            mHandler = new MainHandler(Utils.getHandlerThreadFromCommon().getLooper());
        }
        mHandler.setContext(this);
        mHandler.removeMessages(0);
        mHandler.sendEmptyMessageDelayed(0, DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:38|(1:40)|41|42|43|44|45) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00c9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r8.getAction()     // Catch:{ Throwable -> 0x0135 }
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            java.lang.String r1 = "socialservice.action.TASK"
            boolean r0 = r1.equals(r0)     // Catch:{ Throwable -> 0x0135 }
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            boolean r0 = r7.isEnable()     // Catch:{ Throwable -> 0x0135 }
            r1 = 0
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = "AppExit"
            boolean r0 = r8.getBooleanExtra(r0, r1)     // Catch:{ Throwable -> 0x0135 }
            if (r0 != 0) goto L_0x0023
            return
        L_0x0023:
            android.content.ContentResolver r0 = r7.mContentResolver     // Catch:{ Throwable -> 0x0135 }
            if (r0 != 0) goto L_0x002d
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch:{ Throwable -> 0x0135 }
            r7.mContentResolver = r0     // Catch:{ Throwable -> 0x0135 }
        L_0x002d:
            java.lang.String r0 = "TaskDelay"
            r2 = 0
            long r4 = r8.getLongExtra(r0, r2)     // Catch:{ Throwable -> 0x0135 }
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0048
            com.introvd.template.datacenter.TaskService$MainHandler r8 = mHandler     // Catch:{ Throwable -> 0x0135 }
            r8.removeMessages(r1)     // Catch:{ Throwable -> 0x0135 }
            com.introvd.template.datacenter.TaskService$MainHandler r8 = mHandler     // Catch:{ Throwable -> 0x0135 }
            long r2 = com.introvd.template.datacenter.BaseSocialNotify.getNetworkTaskCheckingDelay(r4)     // Catch:{ Throwable -> 0x0135 }
            r8.sendEmptyMessageDelayed(r1, r2)     // Catch:{ Throwable -> 0x0135 }
            return
        L_0x0048:
            java.lang.String r0 = "autoNext"
            boolean r0 = r8.getBooleanExtra(r0, r1)     // Catch:{ Throwable -> 0x0135 }
            if (r0 == 0) goto L_0x0054
            r7.autoDriveNextTask()     // Catch:{ Throwable -> 0x0135 }
            return
        L_0x0054:
            java.lang.String r0 = "stop"
            boolean r0 = r8.getBooleanExtra(r0, r1)     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r2 = "clear"
            boolean r2 = r8.getBooleanExtra(r2, r1)     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r3 = "CtrlAll"
            boolean r3 = r8.getBooleanExtra(r3, r1)     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r4 = "manually"
            boolean r4 = r8.getBooleanExtra(r4, r1)     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r5 = "AppExit"
            boolean r5 = r8.getBooleanExtra(r5, r1)     // Catch:{ Throwable -> 0x0135 }
            r6 = 1
            if (r5 == 0) goto L_0x0077
            r0 = 1
            r3 = 1
        L_0x0077:
            if (r3 == 0) goto L_0x00f4
            if (r0 != 0) goto L_0x007d
            if (r2 == 0) goto L_0x0090
        L_0x007d:
            java.lang.String r0 = "ResetAll"
            boolean r0 = r8.getBooleanExtra(r0, r1)     // Catch:{ Throwable -> 0x0135 }
            r7.stopAllTask(r0, r4)     // Catch:{ Throwable -> 0x0135 }
            com.introvd.template.datacenter.TaskService$MainHandler r0 = mHandler     // Catch:{ Throwable -> 0x0135 }
            r0.removeMessages(r1)     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r0 = "Stopped All Task"
            com.introvd.template.common.LogUtilsV2.m14228e(r0)     // Catch:{ Throwable -> 0x0135 }
        L_0x0090:
            r0 = 0
            if (r2 == 0) goto L_0x009b
            r7.clearTask(r0)     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r2 = "Clear All Pending Task"
            com.introvd.template.common.LogUtilsV2.m14228e(r2)     // Catch:{ Throwable -> 0x0135 }
        L_0x009b:
            if (r5 == 0) goto L_0x00cd
            int r8 = com.introvd.template.common.MagicCode.getCount()     // Catch:{ Throwable -> 0x0135 }
            if (r8 != 0) goto L_0x00cc
            java.lang.String r8 = "Service Exit"
            com.introvd.template.common.LogUtilsV2.m14228e(r8)     // Catch:{ Throwable -> 0x0135 }
            android.content.Context r8 = r7.getApplicationContext()     // Catch:{ Throwable -> 0x0135 }
            com.introvd.template.p374q.C8345d.m24061V(r8, r1)     // Catch:{ Throwable -> 0x0135 }
            android.content.ContentResolver r8 = r7.getContentResolver()     // Catch:{ Throwable -> 0x0135 }
            com.introvd.template.p309f.C7348b.m21684c(r8)     // Catch:{ Throwable -> 0x0135 }
            com.introvd.template.datacenter.TaskService$MainHandler r8 = mHandler     // Catch:{ Throwable -> 0x0135 }
            if (r8 == 0) goto L_0x00bf
            com.introvd.template.datacenter.TaskService$MainHandler r8 = mHandler     // Catch:{ Throwable -> 0x0135 }
            r8.removeCallbacksAndMessages(r0)     // Catch:{ Throwable -> 0x0135 }
        L_0x00bf:
            r7.stopSelf()     // Catch:{ Throwable -> 0x0135 }
            com.introvd.template.common.api.XYUserBehaviorService r8 = com.xiaoying.p448a.C9561c.aRh()     // Catch:{ Throwable -> 0x00c9 }
            r8.onKillProcess(r7)     // Catch:{ Throwable -> 0x00c9 }
        L_0x00c9:
            java.lang.System.exit(r1)     // Catch:{ Throwable -> 0x0135 }
        L_0x00cc:
            return
        L_0x00cd:
            java.lang.String r0 = "restart"
            boolean r8 = r8.getBooleanExtra(r0, r1)     // Catch:{ Throwable -> 0x0135 }
            if (r8 == 0) goto L_0x00f3
            boolean r8 = r7.checkTaskCondition()     // Catch:{ Throwable -> 0x0135 }
            if (r8 != 0) goto L_0x00dc
            return
        L_0x00dc:
            java.lang.String r8 = "Restart All Pending Task"
            com.introvd.template.common.LogUtilsV2.m14228e(r8)     // Catch:{ Throwable -> 0x0135 }
            r7.updateTaskStateForRestart()     // Catch:{ Throwable -> 0x0135 }
            com.introvd.template.datacenter.TaskService$MainHandler r8 = mHandler     // Catch:{ Throwable -> 0x0135 }
            if (r8 == 0) goto L_0x0131
            com.introvd.template.datacenter.TaskService$MainHandler r8 = mHandler     // Catch:{ Throwable -> 0x0135 }
            r8.removeMessages(r1)     // Catch:{ Throwable -> 0x0135 }
            com.introvd.template.datacenter.TaskService$MainHandler r8 = mHandler     // Catch:{ Throwable -> 0x0135 }
            r8.sendEmptyMessage(r1)     // Catch:{ Throwable -> 0x0135 }
            goto L_0x0131
        L_0x00f3:
            return
        L_0x00f4:
            java.lang.String r3 = "_id"
            r4 = -1
            int r3 = r8.getIntExtra(r3, r4)     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ Throwable -> 0x0135 }
            if (r0 == 0) goto L_0x0102
            goto L_0x0131
        L_0x0102:
            if (r2 == 0) goto L_0x011c
            r7.clearTask(r3)     // Catch:{ Throwable -> 0x0135 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0135 }
            r8.<init>()     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r0 = "Clear Task: "
            r8.append(r0)     // Catch:{ Throwable -> 0x0135 }
            r8.append(r3)     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r8 = r8.toString()     // Catch:{ Throwable -> 0x0135 }
            com.introvd.template.common.LogUtilsV2.m14228e(r8)     // Catch:{ Throwable -> 0x0135 }
            goto L_0x0131
        L_0x011c:
            java.lang.String r0 = "TaskReport"
            int r8 = r8.getIntExtra(r0, r4)     // Catch:{ Throwable -> 0x0135 }
            if (r8 == r4) goto L_0x0128
            r7.updateTaskState(r3, r8)     // Catch:{ Throwable -> 0x0135 }
            goto L_0x0131
        L_0x0128:
            int r8 = java.lang.Integer.parseInt(r3)     // Catch:{ Throwable -> 0x0135 }
            if (r8 < 0) goto L_0x0131
            r7.updateTaskState(r3, r1)     // Catch:{ Throwable -> 0x0135 }
        L_0x0131:
            r7.autoDriveNextTask()     // Catch:{ Throwable -> 0x0135 }
            goto L_0x0145
        L_0x0135:
            r8 = move-exception
            java.lang.String r0 = "TaskService"
            com.xiaoying.a.a.a r1 = com.xiaoying.p448a.p449a.C9534a.code9999
            int r1 = r1.getCode()
            java.lang.String r8 = r8.getMessage()
            com.introvd.template.datacenter.SocialService.reportSocialError(r7, r0, r1, r8)
        L_0x0145:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TaskService.onHandleIntent(android.content.Intent):void");
    }
}
