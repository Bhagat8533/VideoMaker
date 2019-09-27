package com.introvd.template.app.setting;

import android.content.Context;
import android.content.Intent;
import android.support.p021v4.content.LocalBroadcastManager;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.app.api.model.AppVersionInfo;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4586g;
import com.p131c.p132a.C2561a;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.setting.b */
public class C4322b {
    /* renamed from: hz */
    public static void m10843hz(final int i) {
        if (!C2561a.aOS()) {
            boolean dA = C4580b.m11646dA(VivaBaseApplication.m8749FZ());
            String Si = C4580b.m11635Si();
            String countryCode = AppStateModel.getInstance().getCountryCode();
            C3727b.m9082a(dA ? 1 : 0, DeviceInfo.getSDK(), DeviceInfo.getModule(), Si, countryCode).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<AppVersionInfo>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: a */
                public void onSuccess(AppVersionInfo appVersionInfo) {
                    Intent intent = new Intent("localbroadcast.action.ADK.upgradeDesc");
                    intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_VERSION, appVersionInfo.version);
                    intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_DESC, appVersionInfo.desc);
                    intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_SIZE, appVersionInfo.apkSize);
                    intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_URL, appVersionInfo.apkUrl);
                    intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_FORCE_FLAG, appVersionInfo.forceUpdateFlag);
                    intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_IS_SHOW_DIALOG, appVersionInfo.isShowDialog);
                    intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_FROM, i);
                    LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).sendBroadcast(intent);
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                    C4586g.m11695Sl();
                    ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), R.string.xiaoying_str_com_new_version_checking_failed, 0);
                }
            });
        }
    }
}
