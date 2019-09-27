package com.introvd.template.app.receiver;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.work.Worker;
import androidx.work.Worker.C1208a;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.p374q.C8343b;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.p374q.C8356h;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.community.ICommunityService;
import java.lang.ref.WeakReference;

public class NetworkRuntimeBroadcastReceiverWorker extends Worker {
    private static Handler mHandler;

    /* renamed from: com.introvd.template.app.receiver.NetworkRuntimeBroadcastReceiverWorker$a */
    private static class C4114a extends Handler {
        private WeakReference<Context> bvZ;

        public C4114a(Context context, Looper looper) {
            super(looper);
            this.bvZ = new WeakReference<>(context);
        }

        public void handleMessage(Message message) {
            Context context = (Context) this.bvZ.get();
            if (context != null && NetworkRuntimeBroadcastReceiverWorker.m10226cx(context) && message.what == 0) {
                boolean z = true;
                try {
                    if (BaseSocialNotify.checkNetworkPrefAndState(context, 1) != 0) {
                        z = false;
                    }
                    String activeNetworkName = BaseSocialNotify.getActiveNetworkName(context);
                    if (z && BaseSocialNotify.CONNECTIVITY_NAME_WIFI.equalsIgnoreCase(activeNetworkName)) {
                        LogUtilsV2.m14227d("handleMessage, start service");
                        NetworkRuntimeBroadcastReceiverWorker.m10227cy(context);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: cv */
    private static void m10225cv(Context context) {
        C8343b.m24053gO(context);
        C8356h.m24101gO(context);
        ICommunityService iCommunityService = (ICommunityService) BizServiceManager.getService(ICommunityService.class);
        if (iCommunityService != null) {
            iCommunityService.stopAllPublish(context);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cx */
    public static boolean m10226cx(Context context) {
        boolean gQ = C8345d.m24069gQ(context);
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceRunning:");
        sb.append(gQ);
        LogUtilsV2.m14227d(sb.toString());
        return gQ;
    }

    /* access modifiers changed from: private */
    /* renamed from: cy */
    public static void m10227cy(Context context) {
        C8356h.m24102gS(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054 A[Catch:{ Exception -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b A[ADDED_TO_REGION] */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m10229j(android.content.Context r7, android.content.Intent r8) {
        /*
            java.lang.Class<com.introvd.template.app.receiver.NetworkRuntimeBroadcastReceiverWorker> r8 = com.introvd.template.app.receiver.NetworkRuntimeBroadcastReceiverWorker.class
            monitor-enter(r8)
            java.lang.String r0 = "Jamin Network worker work: "
            com.introvd.template.common.LogUtilsV2.m14227d(r0)     // Catch:{ all -> 0x00dd }
            r0 = 0
            int r1 = com.introvd.template.datacenter.BaseSocialNotify.checkNetworkPrefAndState(r7, r0)     // Catch:{ Exception -> 0x00db }
            r2 = 1
            if (r1 != 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            java.lang.String r3 = com.introvd.template.datacenter.BaseSocialNotify.getActiveNetworkName(r7)     // Catch:{ Exception -> 0x00db }
            com.introvd.template.i r4 = com.introvd.template.C4681i.m12184Gp()     // Catch:{ Exception -> 0x00db }
            com.introvd.template.AppMiscListener r4 = r4.mo25016Gr()     // Catch:{ Exception -> 0x00db }
            if (r4 == 0) goto L_0x0024
            r4.onNetworkInfoChanged(r7, r3)     // Catch:{ Exception -> 0x00db }
        L_0x0024:
            if (r3 == 0) goto L_0x0047
            boolean r5 = r3.isEmpty()     // Catch:{ Exception -> 0x00db }
            if (r5 == 0) goto L_0x002d
            goto L_0x0047
        L_0x002d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00db }
            r5.<init>()     // Catch:{ Exception -> 0x00db }
            java.lang.String r6 = "current connection is: "
            r5.append(r6)     // Catch:{ Exception -> 0x00db }
            r5.append(r3)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00db }
            com.introvd.template.common.LogUtilsV2.m14227d(r5)     // Catch:{ Exception -> 0x00db }
            if (r4 == 0) goto L_0x004c
            r4.initPushClient(r7)     // Catch:{ Exception -> 0x00db }
            goto L_0x004c
        L_0x0047:
            java.lang.String r4 = "current connection is: empty"
            com.introvd.template.common.LogUtilsV2.m14227d(r4)     // Catch:{ Exception -> 0x00db }
        L_0x004c:
            java.lang.String r4 = "None"
            boolean r5 = m10226cx(r7)     // Catch:{ Exception -> 0x00db }
            if (r5 != 0) goto L_0x005b
            java.lang.String r7 = "App is not running"
            com.introvd.template.common.LogUtilsV2.m14227d(r7)     // Catch:{ Exception -> 0x00db }
            monitor-exit(r8)
            return
        L_0x005b:
            if (r1 == 0) goto L_0x0061
            if (r3 != 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r2 = 0
        L_0x0061:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00db }
            r1.<init>()     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "STOP service flag is: "
            r1.append(r5)     // Catch:{ Exception -> 0x00db }
            r1.append(r2)     // Catch:{ Exception -> 0x00db }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00db }
            com.introvd.template.common.LogUtilsV2.m14227d(r1)     // Catch:{ Exception -> 0x00db }
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ Exception -> 0x00db }
            android.os.Handler r5 = mHandler     // Catch:{ Exception -> 0x00db }
            if (r5 == 0) goto L_0x0085
            android.os.Handler r5 = mHandler     // Catch:{ Exception -> 0x00db }
            r5.removeMessages(r0)     // Catch:{ Exception -> 0x00db }
            r5 = 0
            mHandler = r5     // Catch:{ Exception -> 0x00db }
        L_0x0085:
            android.os.Handler r5 = mHandler     // Catch:{ Exception -> 0x00db }
            if (r5 != 0) goto L_0x0094
            com.introvd.template.app.receiver.NetworkRuntimeBroadcastReceiverWorker$a r5 = new com.introvd.template.app.receiver.NetworkRuntimeBroadcastReceiverWorker$a     // Catch:{ Exception -> 0x00db }
            android.os.Looper r6 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x00db }
            r5.<init>(r1, r6)     // Catch:{ Exception -> 0x00db }
            mHandler = r5     // Catch:{ Exception -> 0x00db }
        L_0x0094:
            com.introvd.template.app.C4388u.m11061bN(r7)     // Catch:{ Exception -> 0x00db }
            if (r2 == 0) goto L_0x00a2
            android.os.Handler r1 = mHandler     // Catch:{ Exception -> 0x00db }
            r1.removeMessages(r0)     // Catch:{ Exception -> 0x00db }
            m10225cv(r7)     // Catch:{ Exception -> 0x00db }
            goto L_0x00db
        L_0x00a2:
            java.lang.String r1 = "WIFI"
            boolean r1 = r1.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x00db }
            if (r1 == 0) goto L_0x00bf
            java.lang.String r1 = "MOBILE"
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x00db }
            if (r1 == 0) goto L_0x00bf
            java.lang.String r1 = "Switch to wifi from mobile"
            com.introvd.template.common.LogUtilsV2.m14227d(r1)     // Catch:{ Exception -> 0x00db }
            android.os.Handler r1 = mHandler     // Catch:{ Exception -> 0x00db }
            r1.removeMessages(r0)     // Catch:{ Exception -> 0x00db }
            m10225cv(r7)     // Catch:{ Exception -> 0x00db }
        L_0x00bf:
            if (r3 == 0) goto L_0x00db
            boolean r7 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x00db }
            if (r7 != 0) goto L_0x00db
            java.lang.String r7 = "WIFI"
            boolean r7 = r7.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x00db }
            if (r7 == 0) goto L_0x00db
            android.os.Handler r7 = mHandler     // Catch:{ Exception -> 0x00db }
            r7.removeMessages(r0)     // Catch:{ Exception -> 0x00db }
            android.os.Handler r7 = mHandler     // Catch:{ Exception -> 0x00db }
            r1 = 15000(0x3a98, double:7.411E-320)
            r7.sendEmptyMessageDelayed(r0, r1)     // Catch:{ Exception -> 0x00db }
        L_0x00db:
            monitor-exit(r8)
            return
        L_0x00dd:
            r7 = move-exception
            monitor-exit(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.receiver.NetworkRuntimeBroadcastReceiverWorker.m10229j(android.content.Context, android.content.Intent):void");
    }

    /* renamed from: oy */
    public C1208a mo9162oy() {
        m10229j(getApplicationContext(), null);
        return C1208a.SUCCESS;
    }
}
