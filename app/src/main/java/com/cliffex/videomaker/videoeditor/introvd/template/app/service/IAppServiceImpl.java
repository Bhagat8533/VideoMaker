package com.introvd.template.app.service;

import android.app.Activity;
import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.gson.JsonObject;
import com.introvd.template.app.AppTodoInterceptorImpl;
import com.introvd.template.app.C3999i;
import com.introvd.template.app.alarm.C3724a;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.app.manager.C4041a;
import com.introvd.template.app.p184h.C3886a;
import com.introvd.template.app.p190j.C4023a;
import com.introvd.template.app.p191k.C4028a;
import com.introvd.template.app.receiver.UpgradeBroadcastReceiver;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.origin.device.C8119a;
import com.introvd.template.origin.p364a.C8113b;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.app.config.AppConfigObserver;
import com.introvd.template.router.app.device.DeviceLoginObserver;
import p037b.p050b.C1834l;

@C1942a(mo10417rZ = "/IAppServiceRouter/AppServiceRouter")
public class IAppServiceImpl implements IAppService {
    public String formatVivaUrl(String str, Context context) {
        return AppTodoInterceptorImpl.formatVivaUrl(context, str);
    }

    public String getAppMediaSourceExtra() {
        return C3999i.biy;
    }

    public String getFAQUrl() {
        return C4395c.getFAQUrl();
    }

    public boolean getLoginPopUIStyle() {
        return C4023a.m9973MK().getLoginPopUIStyle();
    }

    public void init(Context context) {
    }

    public boolean isYoungerMode() {
        return C4560d.m11516RN().isYoungerMode();
    }

    public void launchVideoFetcher(Activity activity) {
        C4395c.m11078O(activity);
    }

    public void onDeviceRegSuc() {
        C4041a.m10039MV();
    }

    public void registerAppConfigObserver(AppConfigObserver appConfigObserver) {
        C8113b.m23501a(appConfigObserver);
    }

    public void registerDeviceObserver(DeviceLoginObserver deviceLoginObserver) {
        C8119a.registerObserver(deviceLoginObserver);
    }

    public C1834l<JsonObject> requestMapPlaceInfo(String str, int i, int i2, String str2, String str3) {
        return C3727b.m9083a(str, i, i2, str2, str3).aTS();
    }

    public void setUpgradeReceiveMain(Activity activity) {
        UpgradeBroadcastReceiver.m10244cA(activity).mo23797M(activity);
    }

    public void showNotification(Context context, int i, String str) {
        C3724a.m9052bR(context).mo23082a(context, i, str);
    }

    public void showPrivacyTerms(Activity activity, int i) {
        if (activity != null) {
            AppRouter.startWebPage(activity, C4028a.m9997hi(i), activity.getResources().getString(C4028a.m9996hh(i)));
        }
    }

    public void startHybridPage(String str) {
        C3886a.m9564dv(str);
    }
}
