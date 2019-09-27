package com.introvd.template.app;

import android.content.Context;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.origin.route.C8145c;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.user.UserServiceProxy;
import com.quvideo.mobile.platform.httpcore.C4826c;
import com.quvideo.mobile.platform.httpcore.C4827d;
import com.quvideo.mobile.platform.httpcore.p216a.C4822a;
import com.quvideo.mobile.platform.httpcore.p216a.C4823b;
import com.quvideo.mobile.platform.httpcore.p216a.C4824c;

/* renamed from: com.introvd.template.app.l */
public class C4029l {
    /* access modifiers changed from: private */
    /* renamed from: Hu */
    public static C4826c m9998Hu() {
        if (C8145c.aFd().aFe() == null || C8145c.aFd().aFe().dXk == null || !C8145c.aFd().aFe().dXk.containsKey("medi")) {
            return null;
        }
        String str = (String) C8145c.aFd().aFe().dXk.get("medi");
        StringBuilder sb = new StringBuilder();
        sb.append("prepareDomain=");
        sb.append(str);
        LogUtilsV2.m14227d(sb.toString());
        return new C4826c(str);
    }

    public static void init(final Context context) {
        C4827d.m12429a(new C4822a() {
            /* renamed from: EH */
            public C4823b mo23686EH() {
                C4823b bVar = new C4823b();
                bVar.bdb = false;
                return bVar;
            }

            /* renamed from: cA */
            public C4824c mo23687cA(String str) {
                C4824c cVar = new C4824c();
                cVar.setUserId(UserServiceProxy.getUserId());
                cVar.mo25309cB(DeviceUserProxy.getDuid());
                cVar.mo25310cC(AppStateModel.getInstance().getAppProductId());
                cVar.mo25311cD(C5206b.m14212dV(context));
                C4826c Hv = C4029l.m9998Hu();
                if (Hv == null) {
                    int i = 4;
                    if (AppStateModel.ZONE_MIDDLE_EAST.equals(AppStateModel.getInstance().getZoneCode())) {
                        i = 7;
                    } else if (!AppStateModel.ZONE_BIG_CHINA.equals(AppStateModel.getInstance().getZoneCode())) {
                        if (AppStateModel.ZONE_EAST_AMERICAN.equals(AppStateModel.getInstance().getZoneCode())) {
                            i = 6;
                        } else if (AppStateModel.ZONE_EAST_ASIA.equals(AppStateModel.getInstance().getZoneCode())) {
                            i = 5;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("type=");
                    sb.append(i);
                    LogUtilsV2.m14227d(sb.toString());
                    Hv = new C4826c(i);
                }
                cVar.mo25308a(Hv);
                return cVar;
            }
        });
    }
}
