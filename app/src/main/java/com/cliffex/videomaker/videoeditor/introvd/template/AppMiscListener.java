package com.introvd.template;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.support.p021v4.app.FragmentActivity;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.common.RootApiResultListener;
import com.introvd.template.router.todoCode.TODOParamModel;
import java.util.Map;

public interface AppMiscListener extends C1949c {
    void backToHome();

    void executeTodoCode(Activity activity, TODOParamModel tODOParamModel, Bundle bundle);

    boolean getIsUseSchoolCreation();

    void handle3rdApkTest(Context context, String str);

    void hideDownloadNotification(Context context, int i);

    void initPushClient(Context context);

    boolean isSettingAboutActivityInstance(Context context);

    void launchExportResult(Activity activity, String str, String str2, boolean z, int i);

    void launchStudioActivity(Activity activity, boolean z);

    void onNetworkInfoChanged(Context context, String str);

    void onRouterClientConfigure(Context context, boolean z, String str, String str2, RootApiResultListener rootApiResultListener);

    void onThemeBrowserCall(Activity activity, String str, Map<String, String> map);

    void recordEvtOnAppflyer(Context context, String str);

    void recordScanResultEvt(Context context, int i);

    void registerXYINTSdk(FragmentActivity fragmentActivity, OnDismissListener onDismissListener, OnShowListener onShowListener);

    void setNotificationProgress(Context context, int i, int i2, String str, String str2, String str3);

    void setPushTag(Context context, boolean z);

    void showDownloadNotification(Context context, int i, String str, int i2);

    boolean showPopupWindow(Activity activity, int i);

    void showRateDialog(Activity activity);

    void showRatingBarDialog(Activity activity);

    void showShareAppDialog(Activity activity);
}
