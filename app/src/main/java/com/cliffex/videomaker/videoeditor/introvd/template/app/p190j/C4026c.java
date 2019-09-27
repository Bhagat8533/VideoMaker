package com.introvd.template.app.p190j;

import android.support.p021v4.app.NotificationManagerCompat;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.C3879g;
import com.introvd.template.app.C3999i;
import com.introvd.template.app.manager.C4041a;
import com.introvd.template.app.utils.C4400d;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.origin.p364a.C8113b;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.device.DeviceLoginObserver;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.user.IAccountAPI;
import com.introvd.template.router.user.UserServiceProxy;
import com.quvideo.mobile.platform.p215a.C4815a;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.j.c */
public class C4026c extends DeviceLoginObserver {
    public void onChange(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("type = ");
        sb.append(i);
        LogUtilsV2.m14227d(sb.toString());
        C8113b.m23502iN(false);
        IAccountAPI iAccountAPI = (IAccountAPI) BizServiceManager.getService(IAccountAPI.class);
        if (iAccountAPI != null) {
            iAccountAPI.refreshUserToken(false);
        }
        C4400d.m11109QN();
        C4400d.m11110bT(true);
        try {
            String userId = UserServiceProxy.getUserId();
            long duidLong = DeviceUserProxy.getDuidLong();
            if (duidLong > 0) {
                UserBehaviorLog.updateAccount(userId, duidLong);
                C4041a.m10039MV();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("updateAccount userId=");
                sb2.append(userId);
                sb2.append(",duidLong=");
                sb2.append(duidLong);
                LogUtilsV2.m14227d(sb2.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 1) {
            C3879g.m9552Hr();
            C3879g.onDeviceRegSuc();
            C4815a.m12411bb(VivaBaseApplication.m8749FZ());
        } else if (i == 2) {
            C3879g.onDeviceRegSuc();
            C3879g.m9552Hr();
            C4815a.m12411bb(VivaBaseApplication.m8749FZ());
        }
        C3999i.m9884Ht();
        HashMap hashMap = new HashMap();
        hashMap.put("Status", NotificationManagerCompat.from(VivaBaseApplication.m8749FZ()).areNotificationsEnabled() ? "on" : "off");
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Status_Notification", hashMap);
    }
}
