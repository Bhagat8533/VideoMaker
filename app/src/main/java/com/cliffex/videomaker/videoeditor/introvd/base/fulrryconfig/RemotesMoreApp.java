package com.introvd.base.fulrryconfig;

import android.app.Activity;
import android.util.Log;
import com.flurry.android.FlurryAgent.Builder;
import com.flurry.android.FlurryConfig;
import com.flurry.android.FlurryConfigListener;
import com.introvd.base.utlisads.CrashAll;

public class RemotesMoreApp {
    public static String TAG = "MoreAppRemoteConfig";
    public static DialogMoreAppsForRemote dialogMoreAppsForImovie;
    public static boolean isShow;

    public static void showMoreApp(Activity activity) {
        try {
            if (!isShow) {
                Log.d(TAG, "showMoreApp: " + activity + " " + isShow);
                CrashAll.loadAndshow(activity, "las_support_me");
            } else if (activity != null) {
                Log.d(TAG, "showMoreApp: " + activity + " " + isShow);
                dialogMoreAppsForImovie.show();
            }
        } catch (Exception e) {
            CrashAll.loadAndshow(activity, "las_support_me");
            e.printStackTrace();
        }
    }

    public static void getdataMoreApp(final Activity activity) {
        Log.d(TAG, "111111111111");
        new Builder().build(activity, "RQ43Z944JYMWMH52CQF9");
        final FlurryConfig mFlurryConfig = FlurryConfig.getInstance();
        mFlurryConfig.registerListener(new FlurryConfigListener() {
            public void onFetchSuccess() {
                mFlurryConfig.activateConfig();
                Log.e(RemotesMoreApp.TAG, "onFetchSuccess moreapp");
            }

            public void onFetchNoChange() {
            }

            public void onFetchError(boolean isRetrying) {
                Log.e(RemotesMoreApp.TAG, "onFetchError");
            }

            public void onActivateComplete(boolean isCache) {
                String app_name = mFlurryConfig.getString("app_name", "-1");
                String link_icon = mFlurryConfig.getString("link_icon", "-1");
                String sort_des = mFlurryConfig.getString("sort_des", "-1");
                String link_cover = mFlurryConfig.getString("link_cover", "-1");
                String pkg_name = mFlurryConfig.getString("pkg_name", "-1");
                String str = RemotesMoreApp.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onFetchSuccess notshow ");
                sb.append(app_name);
                Log.e(str, sb.toString());
                MoreApp moreApp = new MoreApp(pkg_name, link_icon, sort_des, link_cover, app_name, "1");
                if (ToolsAll.checkInstalled(pkg_name, activity) || app_name.equalsIgnoreCase("-1")) {
                    RemotesMoreApp.isShow = false;
                    Log.e(RemotesMoreApp.TAG, "onFetchSuccess notshow");
                    return;
                }
                Log.e(RemotesMoreApp.TAG, "onFetchSuccess okshow");
                RemotesMoreApp.isShow = true;
                RemotesMoreApp.dialogMoreAppsForImovie = new DialogMoreAppsForRemote(activity, moreApp);
            }
        });
        mFlurryConfig.fetchConfig();
    }
}
