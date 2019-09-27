package com.introvd.template.app.utils;

import android.app.Application;
import android.content.Context;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.ApplicationBase;
import com.introvd.template.app.C4388u;
import com.introvd.template.app.push.C4103b;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.SDCardManager;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.crash.C5523b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p363o.C8092b;
import com.quvideo.rescue.C4905b;
import com.vivavideo.component.permission.C9295b;
import p037b.p050b.C1834l;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.utils.b */
public class C4391b {
    /* access modifiers changed from: private */
    /* renamed from: cW */
    public void m11072cW(Context context) {
        if (context != null) {
            C4905b.m12539a((Application) VivaBaseApplication.m8749FZ());
            C4905b.m12545fQ(7);
            C4905b.setEnable(true);
            String dx = C4580b.m11651dx(context);
            if (dx == null || !dx.toLowerCase().contains("pt")) {
                C4905b.m12543bn(true);
                C4905b.m12544bo(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cX */
    public void m11073cX(Context context) {
    }

    /* renamed from: cV */
    public void mo24456cV(final Context context) {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                ApplicationBase.bit = true;
                StringBuilder sb = new StringBuilder();
                sb.append("Jamin AppInitWorker doWork currentThread().getId() = ");
                sb.append(Thread.currentThread().getId());
                sb.append(",getPriority = ");
                sb.append(Thread.currentThread().getPriority());
                LogUtilsV2.m14227d(sb.toString());
                boolean hasSDCard = SDCardManager.hasSDCard();
                if (C9295b.m26985b(VivaBaseApplication.m8749FZ(), C8092b.dXu) && hasSDCard) {
                    try {
                        C4388u.m11055HD().mo24453HG();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                C4391b.this.m11072cW(context);
                if (LogUtilsV2.Logable) {
                    LogUtilsV2.initLoggerWriterAdapter();
                }
                UserBehaviorUtils.recordCountrySimInfoEvent(context);
                if (AppStateModel.getInstance().isGDPRAgree()) {
                    C4391b.this.m11073cX(context);
                }
                try {
                    C4103b.initPushClient(VivaBaseApplication.m8749FZ());
                } catch (Exception e2) {
                    C5523b.logException(e2);
                }
                ApplicationBase.bir = true;
                ApplicationBase.bis = true;
            }
        }).aTR();
    }
}
