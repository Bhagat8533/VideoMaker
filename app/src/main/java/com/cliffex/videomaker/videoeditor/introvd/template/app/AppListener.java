package com.introvd.template.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.C1941a;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.AppMiscListener;
import com.introvd.template.R;
import com.introvd.template.XiaoYingActivity;
import com.introvd.template.ads.versionhelper.AdsVersionHelper;
import com.introvd.template.app.homepage.HomeView;
import com.introvd.template.app.homepage.pop.C3983b;
import com.introvd.template.app.manager.C4041a;
import com.introvd.template.app.manager.C4059d;
import com.introvd.template.app.notification.C4071a;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p190j.C4023a;
import com.introvd.template.app.p192l.C4031a;
import com.introvd.template.app.push.C4103b;
import com.introvd.template.app.setting.C4317a;
import com.introvd.template.app.setting.SettingAboutActivity;
import com.introvd.template.app.test.TestService;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.DftRootApiResultListenerImpl;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.RootApiResultListener;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.bitmapfun.ImageFetcher;
import com.introvd.template.common.bitmapfun.ImageFetcher.ImageFetcherHttpListener;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.origin.route.C8145c;
import com.introvd.template.p173a.C3582b;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.router.AppRouter.ExportResultPageParams;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.VivaCommunityRouter.FeedVideoActivityParams;
import com.introvd.template.router.community.VivaCommunityRouter.UserHomePageParams;
import com.introvd.template.router.community.event.UploadEvent;
import com.introvd.template.router.community.util.CommunityPageTabConstants;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.C10021c;

@C1942a(mo10417rZ = "/app/AppListener")
public class AppListener implements AppMiscListener {
    private static final String TAG = "AppListener";

    /* renamed from: com.introvd.template.app.AppListener$a */
    private static class C3653a implements ImageFetcherHttpListener {
        final Context bbr;
        final Handler mHandler;
        final HandlerThread mHandlerThread = new HandlerThread("ImageFetcher2", 10);

        public C3653a(Context context) {
            this.bbr = context;
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
        }
    }

    public AppListener(Context context) {
        ImageFetcher.setFetcherHttpListener(new C3653a(context));
    }

    /* access modifiers changed from: private */
    public void clearCommunityFeeds(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_ACTIVITY_HOTEVENT);
            Uri tableUri2 = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_ACTIVITY_VIDEOLIST);
            Uri tableUri3 = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_USERS_VIDEOS);
            Uri tableUri4 = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_VIDEO_SHOW);
            Uri tableUri5 = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_ACTIVITY_LIST);
            contentResolver.delete(tableUri, null, null);
            contentResolver.delete(tableUri2, null, null);
            contentResolver.delete(tableUri3, null, null);
            contentResolver.delete(tableUri4, null, null);
            contentResolver.delete(tableUri5, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void gotoHomePageActivity(Activity activity, HashMap<String, Object> hashMap) {
        try {
            Intent intent = new Intent(activity, XiaoYingActivity.class);
            int i = 16384;
            boolean z = false;
            String str = null;
            int i2 = -1;
            if (hashMap != null) {
                Object obj = hashMap.get(C5527a.cnJ);
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                Object obj2 = hashMap.get(C5527a.cnK);
                if (obj2 instanceof String) {
                    str = (String) obj2;
                }
                Object obj3 = hashMap.get(GalleryRouter.EXTRA_INTENT_MODE_KEY);
                if (obj3 instanceof Integer) {
                    i2 = ((Integer) obj3).intValue();
                }
            }
            Bundle extras = activity.getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean(C5527a.cnJ, z);
            if (str != null) {
                extras.putString(C5527a.cnK, str);
                i = 134217728;
            }
            if (i2 >= 0) {
                intent.putExtra(GalleryRouter.EXTRA_INTENT_MODE_KEY, i2);
            }
            String action = activity.getIntent().getAction();
            if (!TextUtils.isEmpty(action)) {
                intent.setAction(action);
            }
            intent.setFlags(i);
            intent.putExtras(extras);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backToHome() {
        List Hh = C3740b.m9101He().mo23112Hh();
        for (int i = 0; i < Hh.size(); i++) {
            WeakReference weakReference = (WeakReference) Hh.get(i);
            if (weakReference != null) {
                Activity activity = (Activity) weakReference.get();
                if (activity != null && !(activity instanceof XiaoYingActivity)) {
                    activity.finish();
                }
            }
        }
    }

    public void executeTodoCode(Activity activity, TODOParamModel tODOParamModel, Bundle bundle) {
        if ((tODOParamModel.mTODOCode == 917 || tODOParamModel.mTODOCode == 940 || tODOParamModel.mTODOCode == 999) && MagicCode.getMagicParam(0, "XiaoYingActivityWeakRef", null) != null) {
            WeakReference Hf = C3740b.m9101He().mo23111Hf();
            if (Hf != null) {
                Activity activity2 = (Activity) Hf.get();
                if (activity2 instanceof XiaoYingActivity) {
                    ((XiaoYingActivity) activity2).mo22833Gm();
                } else {
                    backToHome();
                }
            } else {
                backToHome();
            }
        }
    }

    public boolean getIsUseSchoolCreation() {
        return C4023a.m9973MK().mo23677MP();
    }

    public void handle3rdApkTest(Context context, String str) {
        Intent intent = new Intent(context, TestService.class);
        intent.setFlags(268435456);
        Bundle bundle = new Bundle();
        bundle.putString("apk_local_url", str);
        intent.putExtras(bundle);
        C3582b.m8808k(context, intent);
    }

    public void hideDownloadNotification(Context context, int i) {
        C4071a.hideDownloadNotification(context, i);
    }

    public void init(Context context) {
    }

    public void initPushClient(Context context) {
        C4103b.initPushClient(context);
    }

    public boolean isSettingAboutActivityInstance(Context context) {
        return context instanceof SettingAboutActivity;
    }

    public void launchExportResult(Activity activity, String str, String str2, boolean z, int i) {
        C1941a routerBuilder = VivaRouter.getRouterBuilder(ExportResultPageParams.URL);
        if (!TextUtils.isEmpty(str)) {
            routerBuilder.mo10399f(ExportResultPageParams.PROJECT_ITEM_COVER_URL, str);
        }
        routerBuilder.mo10391a(ExportResultPageParams.ACTIVITY_FROM, z);
        if (!TextUtils.isEmpty(str2)) {
            routerBuilder.mo10399f(ExportResultPageParams.PROJECT_ITEM_EXPORT_URL, str2);
        }
        routerBuilder.mo10396b(activity, i);
    }

    public void launchStudioActivity(Activity activity, boolean z) {
        int i;
        if (z) {
            AppPreferencesSetting.getInstance().setAppSettingInt(C5527a.cnQ, 0);
            if (C3742b.m9111II().mo23138JF()) {
                i = 2;
                C10021c.aZH().mo38492aA(new UploadEvent(true));
            } else {
                i = 1;
            }
            AppPreferencesSetting.getInstance().setAppSettingInt(CommunityPageTabConstants.KEY_SAVED_TAB_ID, i);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append("");
            AppPreferencesSetting.getInstance().setAppSettingStr("key_saved_home_tab_time", sb.toString());
            return;
        }
        StudioRouter.launchStudioActivity(activity);
    }

    public void onNetworkInfoChanged(Context context, String str) {
        if (str == null || str.isEmpty()) {
            LogUtilsV2.m14230i("no network connect");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("network connect : ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
    }

    public void onRouterClientConfigure(Context context, boolean z, String str, String str2, RootApiResultListener rootApiResultListener) {
        C8145c aFd = C8145c.aFd();
        final RootApiResultListener rootApiResultListener2 = rootApiResultListener;
        final String str3 = str;
        final String str4 = str2;
        final Context context2 = context;
        final boolean z2 = z;
        C36521 r1 = new DftRootApiResultListenerImpl() {
            public void onError(Throwable th) {
                if (rootApiResultListener2 != null) {
                    rootApiResultListener2.onError(th);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x0075  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(java.lang.Boolean r8, java.lang.Object r9) {
                /*
                    r7 = this;
                    java.lang.String r0 = r4
                    java.lang.String r1 = r5
                    boolean r2 = android.text.TextUtils.isEmpty(r0)
                    r3 = 0
                    r4 = 1
                    if (r2 != 0) goto L_0x001c
                    java.lang.String r2 = r4
                    com.introvd.template.origin.route.c r5 = com.introvd.template.origin.route.C8145c.aFd()
                    java.lang.String r5 = r5.aFf()
                    boolean r2 = android.text.TextUtils.equals(r2, r5)
                    if (r2 != 0) goto L_0x007d
                L_0x001c:
                    boolean r2 = android.text.TextUtils.isEmpty(r0)
                    if (r2 == 0) goto L_0x003e
                    android.content.Context r2 = r6
                    java.lang.String[] r2 = com.introvd.template.origin.route.C8145c.m23570gz(r2)
                    r5 = r2[r3]
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L_0x003e
                    r5 = r2[r4]
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L_0x003e
                    r0 = r2[r3]
                    r1 = r2[r4]
                    r2 = 1
                    goto L_0x003f
                L_0x003e:
                    r2 = 0
                L_0x003f:
                    boolean r5 = android.text.TextUtils.isEmpty(r0)
                    if (r5 == 0) goto L_0x0066
                    com.introvd.template.router.user.model.LoginUserInfo r5 = com.introvd.template.router.user.UserServiceProxy.getUserInfo()
                    if (r5 == 0) goto L_0x0066
                    java.lang.String r6 = r5.auid
                    boolean r6 = android.text.TextUtils.isEmpty(r6)
                    if (r6 != 0) goto L_0x0066
                    java.lang.String r0 = r5.zone
                    if (r0 == 0) goto L_0x005a
                    java.lang.String r0 = r5.zone
                    goto L_0x005c
                L_0x005a:
                    java.lang.String r0 = "hz"
                L_0x005c:
                    java.lang.String r1 = r5.country
                    if (r1 == 0) goto L_0x0063
                    java.lang.String r1 = r5.country
                    goto L_0x0065
                L_0x0063:
                    java.lang.String r1 = "CN"
                L_0x0065:
                    r2 = 1
                L_0x0066:
                    if (r2 == 0) goto L_0x006f
                    com.introvd.template.origin.route.c r2 = com.introvd.template.origin.route.C8145c.aFd()
                    r2.mo33229aJ(r0, r1)
                L_0x006f:
                    boolean r1 = android.text.TextUtils.isEmpty(r0)
                    if (r1 == 0) goto L_0x007d
                    com.introvd.template.origin.route.c r0 = com.introvd.template.origin.route.C8145c.aFd()
                    java.lang.String r0 = r0.aFf()
                L_0x007d:
                    boolean r1 = com.introvd.template.C4561b.m11529FP()
                    if (r1 == 0) goto L_0x008e
                    java.lang.String r0 = "hz"
                    java.lang.String r1 = "CN"
                    com.introvd.template.origin.route.c r2 = com.introvd.template.origin.route.C8145c.aFd()
                    r2.mo33229aJ(r0, r1)
                L_0x008e:
                    android.content.Context r1 = r6
                    java.lang.String r1 = com.introvd.template.origin.route.C8145c.m23569gy(r1)
                    boolean r2 = android.text.TextUtils.isEmpty(r0)
                    if (r2 != 0) goto L_0x00e3
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L_0x00e3
                    boolean r2 = r0.equals(r1)
                    if (r2 != 0) goto L_0x00e3
                    java.lang.String r2 = "AppListener"
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r5 = "router from "
                    r3.append(r5)
                    r3.append(r1)
                    java.lang.String r5 = " switch to "
                    r3.append(r5)
                    r3.append(r0)
                    java.lang.String r3 = r3.toString()
                    com.introvd.template.common.LogUtils.m14223i(r2, r3)
                    android.content.Context r2 = r6
                    com.introvd.template.datacenter.SocialService.syncDeviceUnregister(r2)
                    android.content.Context r2 = r6
                    com.introvd.template.datacenter.SocialService.syncDeviceLogout(r2)
                    com.introvd.template.apicore.b r2 = com.introvd.template.apicore.C3624b.m8865GC()
                    r2.mo22944GF()
                    com.introvd.template.apicore.C3618a.m8852GB()
                    com.introvd.template.apicore.C3636m.m8911GX()
                    com.introvd.template.app.AppListener r2 = com.introvd.template.app.AppListener.this
                    android.content.Context r3 = r6
                    r2.clearCommunityFeeds(r3)
                    r3 = 1
                L_0x00e3:
                    boolean r2 = r7
                    if (r2 == 0) goto L_0x00f1
                    boolean r2 = r8.booleanValue()
                    if (r2 == 0) goto L_0x00f1
                    boolean r2 = com.introvd.template.app.ApplicationBase.bin
                    if (r2 != 0) goto L_0x00fa
                L_0x00f1:
                    com.introvd.template.origin.route.c r2 = com.introvd.template.origin.route.C8145c.aFd()
                    android.content.Context r4 = r6
                    r2.mo33230cf(r4, r0)
                L_0x00fa:
                    boolean r0 = android.text.TextUtils.isEmpty(r1)
                    if (r0 != 0) goto L_0x0102
                    if (r3 == 0) goto L_0x010d
                L_0x0102:
                    com.introvd.template.origin.route.c r0 = com.introvd.template.origin.route.C8145c.aFd()
                    java.lang.String r0 = r0.aFg()
                    com.introvd.template.common.SnsConfigMgr.getSnsConfig(r0)
                L_0x010d:
                    com.introvd.template.common.RootApiResultListener r0 = r3
                    if (r0 == 0) goto L_0x0116
                    com.introvd.template.common.RootApiResultListener r0 = r3
                    r0.onSuccess(r8, r9)
                L_0x0116:
                    com.introvd.template.router.lifecycle.BizAppLifeCycleManager r9 = new com.introvd.template.router.lifecycle.BizAppLifeCycleManager
                    com.introvd.template.VivaBaseApplication r0 = com.introvd.template.VivaBaseApplication.m8749FZ()
                    r9.<init>(r0)
                    boolean r8 = r8.booleanValue()
                    r9.performOnRouteConfigUpdated(r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.AppListener.C36521.onSuccess(java.lang.Boolean, java.lang.Object):void");
            }
        };
        aFd.mo33224a(context, z, r1);
    }

    public void onThemeBrowserCall(Activity activity, String str, Map<String, String> map) {
        if (str != null) {
            if (C5527a.cnO.endsWith(str)) {
                String str2 = (String) map.get(C5878a.TAG);
                String str3 = (String) map.get(C7234b.TAG);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("puid", str2);
                jsonObject.addProperty("pver", str3);
                VivaRouter.getRouterBuilder(FeedVideoActivityParams.URL).mo10399f(FeedVideoActivityParams.EXTRA_VIDEO_TYPE_SINGLE_JSON, new Gson().toJson((JsonElement) jsonObject)).mo10406h(FeedVideoActivityParams.EXTRA_VIDEO_PAGE_FROM, -1).mo10394aZ(R.anim.activity_right_enter_translate, R.anim.activity_left_exit_translate).mo10382H(activity);
            } else if (C5527a.cnP.endsWith(str)) {
                VivaRouter.getRouterBuilder(UserHomePageParams.URL).mo10399f(UserHomePageParams.EXTRA_USER_AUID, (String) map.get(C5878a.TAG)).mo10406h("extra_type_from", -1).mo10394aZ(R.anim.activity_right_enter_translate, R.anim.activity_left_exit_translate).mo10382H(activity);
            }
        }
    }

    public void recordEvtOnAppflyer(Context context, String str) {
        C4041a.m10046c(context, str, null);
    }

    public void recordScanResultEvt(Context context, int i) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", i > 0 ? "yes" : "no");
            UserBehaviorLog.onKVEvent(context, "Find_Draft_Result", hashMap);
        }
    }

    public void registerXYINTSdk(FragmentActivity fragmentActivity, OnDismissListener onDismissListener, OnShowListener onShowListener) {
        AdsVersionHelper.registerXYINTSdk(fragmentActivity, onDismissListener, onShowListener);
    }

    public void setNotificationProgress(Context context, int i, int i2, String str, String str2, String str3) {
        C4071a.setNotificationProgress(context, i, i2, str, str2, str3);
    }

    public void setPushTag(Context context, boolean z) {
        C4103b.setPushTag(context, z);
    }

    public void showDownloadNotification(Context context, int i, String str, int i2) {
        C4071a.showDownloadNotification(context, i, str, i2);
    }

    public boolean showPopupWindow(Activity activity, int i) {
        if ((activity instanceof XiaoYingActivity) && i >= 0) {
            XiaoYingActivity xiaoYingActivity = (XiaoYingActivity) activity;
            if (xiaoYingActivity.mo22832Ge() instanceof HomeView) {
                C3983b.m9860a((Activity) xiaoYingActivity, C4059d.m10111hg(i));
            }
        }
        return true;
    }

    public void showRateDialog(Activity activity) {
        C4317a.showRateDialog(activity);
    }

    public void showRatingBarDialog(Activity activity) {
        C4317a.showRatingBarDialog(activity);
    }

    public void showShareAppDialog(Activity activity) {
        C4031a.m10003N(activity);
    }
}
