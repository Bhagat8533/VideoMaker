package com.introvd.template.app.alarm;

import android.content.Context;
import com.ciii.android.job.C2611c;
import com.ciii.android.job.C2611c.C2613a;
import com.ciii.android.job.C2611c.C2614b;
import com.ciii.android.job.C2629h;
import com.ciii.android.job.C2634l.C2638b;
import com.ciii.android.job.p137a.p138a.C2598b;
import com.introvd.template.app.splash.C4361c;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.SnsConfigMgr;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p203b.C4584e;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.editor.IEditorService;
import com.p131c.p132a.C2561a;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/* renamed from: com.introvd.template.app.alarm.b */
public class C3725b extends C2611c {
    /* renamed from: Ii */
    private void m9063Ii() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            iEditorService.scanGallery();
        }
    }

    /* renamed from: Ij */
    private void m9064Ij() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            iEditorService.scanProject();
        }
    }

    /* renamed from: a */
    public static void m9065a(int i, String str, boolean z) throws Exception {
        int bd = C2629h.m7603yN().mo13010bd("AlarmReceiverJob");
        StringBuilder sb = new StringBuilder();
        sb.append("Jamin cancelAllForTag count = ");
        sb.append(bd);
        LogUtilsV2.m14227d(sb.toString());
        C2598b bVar = new C2598b();
        bVar.putInt("alarm_request_code", i);
        bVar.putString("alarm_notification_data", str);
        bVar.putBoolean("alarm_notification_click", z);
        new C2638b("AlarmReceiverJob").mo13066zm().mo13061a(bVar).mo13067zn().mo13058zi();
        LogUtilsV2.m14227d("Jamin schedule tag = AlarmReceiverJob");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2614b mo12943a(C2613a aVar) {
        C2598b yw = aVar.mo12971yw();
        int i = yw.getInt("alarm_request_code", -1);
        String string = yw.getString("alarm_notification_data", "");
        boolean z = yw.getBoolean("alarm_notification_click", false);
        StringBuilder sb = new StringBuilder();
        sb.append("Jamin onRunJob requestCode = ");
        sb.append(i);
        sb.append(", strData = ");
        sb.append(string);
        sb.append(", bNotiClick = ");
        sb.append(z);
        LogUtilsV2.m14227d(sb.toString());
        Context context = getContext();
        C3724a bR = C3724a.m9052bR(context);
        if (z) {
            bR.mo23083b(context, i, string);
            return C2614b.SUCCESS;
        }
        if (4097 == i) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "14 days");
            UserBehaviorLog.onKVEvent(context, "Dev_Event_Alarm_Receive", hashMap);
            bR.mo23082a(context, i, string);
            bR.mo23081a(bR.mo23086gq(i), i);
        } else if (4098 == i) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("type", "weekend");
            UserBehaviorLog.onKVEvent(context, "Dev_Event_Alarm_Receive", hashMap2);
            if (1 == C3724a.m9049a(C4584e.m11680c(new Date()))) {
                m9063Ii();
            }
            bR.mo23081a(bR.mo23086gq(i), i);
        } else if (4099 == i) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("type", "un exportPrj");
            UserBehaviorLog.onKVEvent(context, "Dev_Event_Alarm_Receive", hashMap3);
            m9064Ij();
            long time = C3724a.m9053c(C3724a.m9051b(C4584e.m11680c(new Date()), 1), 21).getTime();
            bR.mo23081a(time, i);
            long currentTimeMillis = (time - System.currentTimeMillis()) / 1000;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("REQUEST_CODE_VIDEO_UNCOMPLETE intervalTime ");
            sb2.append(currentTimeMillis);
            LogUtilsV2.m14230i(sb2.toString());
        } else if (4100 == i) {
            if (!C2561a.aON()) {
                if (!C4361c.m10973cK(context)) {
                    bR.mo23081a(new Date().getTime() + 1800000, 4100);
                } else {
                    bR.mo23081a(C3724a.m9051b(C4584e.m11680c(new Date()), 1).getTime() + ((long) new Random().nextInt(28800000)), 4100);
                }
            }
        } else if (4101 == i && !C2561a.aON()) {
            C4361c.m10975cM(context);
            C4361c.m10974cL(context);
            SnsConfigMgr.getSnsConfig(AppStateModel.getInstance().getCountryCode());
        }
        return C2614b.SUCCESS;
    }
}
