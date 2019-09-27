package com.introvd.template.router.app;

import android.app.Activity;
import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;
import com.google.gson.JsonObject;
import com.introvd.template.router.app.config.AppConfigObserver;
import com.introvd.template.router.app.device.DeviceLoginObserver;
import p037b.p050b.C1834l;

public interface IAppService extends C1949c {
    public static final String APP_SERVICE_GROUP = "/IAppServiceRouter/";
    public static final int REQUEST_CODE_NOTIFICATION_BASE = 4096;
    public static final int REQUEST_CODE_SCAN_GALLERY = 4098;
    public static final int REQUEST_CODE_UNEXPORT_PRJ = 4099;
    public static final String VIVA_ROUTER_APP_SERVICE = "/IAppServiceRouter/AppServiceRouter";

    String formatVivaUrl(String str, Context context);

    String getAppMediaSourceExtra();

    String getFAQUrl();

    boolean getLoginPopUIStyle();

    boolean isYoungerMode();

    void launchVideoFetcher(Activity activity);

    void onDeviceRegSuc();

    void registerAppConfigObserver(AppConfigObserver appConfigObserver);

    void registerDeviceObserver(DeviceLoginObserver deviceLoginObserver);

    C1834l<JsonObject> requestMapPlaceInfo(String str, int i, int i2, String str2, String str3);

    void setUpgradeReceiveMain(Activity activity);

    void showNotification(Context context, int i, String str);

    void showPrivacyTerms(Activity activity, int i);

    void startHybridPage(String str);
}
