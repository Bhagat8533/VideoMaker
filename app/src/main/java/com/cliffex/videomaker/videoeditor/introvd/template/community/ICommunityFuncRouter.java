package com.introvd.template.community;

import android.app.Activity;
import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import java.util.Map;

public interface ICommunityFuncRouter extends C1949c {
    public static final String VIVA_ROUTER_COMMUNITY_FUNC = "/VivaRouter/CommunityFuncRouter";

    void doInstagramClick(Activity activity, String str);

    void executeEditorTodo(Activity activity, ModeItemInfo modeItemInfo);

    void feedback(Activity activity, long j);

    void handleIMNotificationStart(Context context, String str, String str2);

    boolean isFeedbackItemNew(Context context);

    boolean isReceiveIMNotification();

    void onRouterClientConfigure(Context context, String str, String str2);

    void recordEventWithAppFlyer(Context context, String str, Map map);

    void reloadWebPageUrl(Activity activity, String str);

    void setUserZoneInfo(Context context, String str, String str2);

    void showPublishPopWindows(Activity activity);

    void showRateDialog(Activity activity);
}
