package com.introvd.template;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p021v4.content.LocalBroadcastManager;
import com.introvd.template.datacenter.SocialServiceDef;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SocialServiceBroadcastReceiver extends BroadcastReceiver {
    C3555a bfK = null;
    private Map<Integer, Long> bfL = Collections.synchronizedMap(new LinkedHashMap());
    private boolean bfM;
    private final Context mContext;

    /* renamed from: com.introvd.template.SocialServiceBroadcastReceiver$a */
    public interface C3555a {
        /* renamed from: a */
        void mo22827a(String str, int i, int i2, int i3);
    }

    public SocialServiceBroadcastReceiver(Context context) {
        this.mContext = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0083  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8746a(android.content.Context r8, java.lang.String r9, int r10, long r11, long r13) {
        /*
            r7 = this;
            com.introvd.template.SocialServiceBroadcastReceiver$a r0 = r7.bfK
            if (r0 == 0) goto L_0x000c
            com.introvd.template.SocialServiceBroadcastReceiver$a r8 = r7.bfK
            int r11 = (int) r11
            int r12 = (int) r13
            r8.mo22827a(r9, r10, r11, r12)
            return
        L_0x000c:
            if (r10 != 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.String r9 = "SocialServiceBroadcastReceiver"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "ErrCode:"
            r13.append(r14)
            r13.append(r10)
            java.lang.String r14 = ",wParam:"
            r13.append(r14)
            r13.append(r11)
            java.lang.String r13 = r13.toString()
            com.introvd.template.common.LogUtils.m14222e(r9, r13)
            r9 = 0
            long r13 = java.lang.System.currentTimeMillis()
            r0 = 300000(0x493e0, double:1.482197E-318)
            r2 = 10
            r3 = 0
            r4 = 1
            if (r10 == r2) goto L_0x0073
            r2 = 105(0x69, float:1.47E-43)
            if (r10 == r2) goto L_0x006e
            r2 = 203(0xcb, float:2.84E-43)
            if (r10 == r2) goto L_0x006a
            switch(r10) {
                case 12: goto L_0x0073;
                case 13: goto L_0x0073;
                default: goto L_0x0046;
            }
        L_0x0046:
            int r11 = (int) r11
            r12 = 8193(0x2001, float:1.1481E-41)
            if (r11 == r12) goto L_0x0068
            r12 = 12289(0x3001, float:1.722E-41)
            if (r11 == r12) goto L_0x005e
            switch(r11) {
                case 4097: goto L_0x0068;
                case 4098: goto L_0x0053;
                case 4099: goto L_0x0068;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0068
        L_0x0053:
            android.content.res.Resources r9 = r8.getResources()
            int r11 = com.introvd.template.R.string.xiaoying_str_com_msg_communication_fail
            java.lang.String r9 = r9.getString(r11)
            goto L_0x0068
        L_0x005e:
            android.content.res.Resources r9 = r8.getResources()
            int r11 = com.introvd.template.R.string.xiaoying_str_com_new_version_checking_islast
            java.lang.String r9 = r9.getString(r11)
        L_0x0068:
            r11 = 0
            goto L_0x0075
        L_0x006a:
            r0 = 3600000(0x36ee80, double:1.7786363E-317)
            goto L_0x0070
        L_0x006e:
            r0 = 30000(0x7530, double:1.4822E-319)
        L_0x0070:
            r3 = r10
            r11 = 1
            goto L_0x0075
        L_0x0073:
            r3 = r10
            goto L_0x0068
        L_0x0075:
            java.util.Map<java.lang.Integer, java.lang.Long> r12 = r7.bfL
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Object r12 = r12.get(r2)
            java.lang.Long r12 = (java.lang.Long) r12
            if (r12 != 0) goto L_0x0089
            r5 = 0
            java.lang.Long r12 = java.lang.Long.valueOf(r5)
        L_0x0089:
            if (r9 == 0) goto L_0x00a5
            long r5 = r12.longValue()
            int r2 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x00a5
            com.introvd.template.common.ToastUtils.show(r8, r9, r4)
            java.util.Map<java.lang.Integer, java.lang.Long> r8 = r7.bfL
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            long r5 = r13 + r0
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            r8.put(r9, r2)
        L_0x00a5:
            if (r11 == 0) goto L_0x00d6
            long r8 = r12.longValue()
            int r8 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x00d6
            boolean r8 = r7.bfM
            if (r8 != 0) goto L_0x00c8
            android.content.Context r8 = r7.mContext
            boolean r8 = r8 instanceof com.introvd.template.XiaoYingActivity
            if (r8 == 0) goto L_0x00c8
            com.introvd.template.app.community.freeze.b r8 = com.introvd.template.app.community.freeze.C3763b.m9231Is()
            android.content.Context r9 = r7.mContext
            java.lang.String r11 = com.introvd.template.router.user.UserServiceProxy.getUserId()
            r8.mo23238f(r9, r11, r10)
            r7.bfM = r4
        L_0x00c8:
            java.util.Map<java.lang.Integer, java.lang.Long> r8 = r7.bfL
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            long r13 = r13 + r0
            java.lang.Long r10 = java.lang.Long.valueOf(r13)
            r8.put(r9, r10)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.SocialServiceBroadcastReceiver.m8746a(android.content.Context, java.lang.String, int, long, long):void");
    }

    /* renamed from: a */
    public void mo22823a(C3555a aVar) {
        this.bfK = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            String stringExtra = intent.getStringExtra("social_method");
            int intExtra = intent.getIntExtra("errCode", -1);
            long longExtra = intent.getLongExtra("wParam", -1);
            long longExtra2 = intent.getLongExtra("lParam", -1);
            if (SocialServiceDef.ACTION_SOCIAL_SERVICE_FEEDBACK.equals(action)) {
                m8746a(context, stringExtra, intExtra, longExtra, longExtra2);
            }
        }
    }

    public void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SocialServiceDef.ACTION_SOCIAL_SERVICE_FEEDBACK);
        intentFilter.addAction(SocialServiceDef.ACTION_SOCIAL_SERVICE_NETWORK_ERR_REPORT);
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this, intentFilter);
    }

    public void unregister() {
        LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this);
    }
}
