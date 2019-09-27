package com.introvd.template.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import aoptest.chandler.com.vivarouter.R;
import com.aiii.android.arouter.facade.C1941a;
import com.introvd.template.router.lifecycle.BaseApplicationLifeCycle;

public class AppRouter extends BaseRouter {
    public static final String APP_LISTENER = "/app/AppListener";
    public static final String BIZAPP_BANNER = "/app/bannerinfo";
    public static final String BIZAPP_TODO_INTERCEPTOR = "/app/todoInterceptor";
    public static final String BIZ_APP_PRO_MAIN_FRAG = "/app/pro_fragment";
    private static final String MODULE_APP_GROUP = "/app/";
    public static final String PROXY_APPLICATION = "/app/application";
    public static final String PROXY_MAIN_ACTIVITY = "/app/main_activity";
    public static final String PROXY_USER_LIFECYCLE = "/app/user_lifecycle";
    public static final String VIVA_APP_PREF_FILENAME = "viva_biz_app";

    public class CommonWebPageParams {
        public static final String ACTION_FINISH_WEB_ACTIVITY = "com.introvd.template.finishweb";
        public static final String KEY_WEBVIEW_TITLE = "key_webview_title";
        public static final String KEY_WEBVIEW_URL = "key_webview_url";
        public static final String URL = "/appcore/CommonWebView";

        public CommonWebPageParams() {
        }
    }

    public class ExportResultPageParams {
        public static final String ACTIVITY_FROM = "from_tool";
        public static final String PROJECT_ITEM_COVER_URL = "project_item_cover_url";
        public static final String PROJECT_ITEM_EXPORT_URL = "project_item_export_url";
        public static final String URL = "/app/ExportResultPage";

        public ExportResultPageParams() {
        }
    }

    public class IntentHomeParams {
        public static final String URL = "/app/IntentHome";
        public static final String WATER_MARK_PREF = "water_mark";

        public IntentHomeParams() {
        }
    }

    public class TemplateParams {
        public static final String INTENT_EXTRA_KEY_PAGE_ITEM = "intent_extra_key_page_item";
        public static final String URL = "/app/TemplateListAct";

        public TemplateParams() {
        }
    }

    public class UserGradePageParam {
        public static final String INTENT_EXTRA_KEY_DEFAULT_PAGE_INDEX = "intent_extra_key_default_page_index";
        public static final int PAGE_INDEX_PRIVILEGE = 0;
        public static final int PAGE_INDEX_TASK = 1;
        public static final String URL = "/app/UserGradePage";

        public UserGradePageParam() {
        }
    }

    public class YoungerModeParams {
        public static final String INTENT_EXTRA_KEY_MODE_TYPE = "intent_extra_key_mode_type";
        public static final String RECEIVE_ACTION_YOUNGER_MODE_CLOSE = "action_younger_mode_close";
        public static final String RECEIVE_ACTION_YOUNGER_MODE_OPEN = "action_younger_mode_open";
        public static final int SETTING_YOUNGER_CLOSE = 5;
        public static final int SETTING_YOUNGER_OPEN = 1;
        public static final int SETTING_YOUNGER_PASSWORD_SURE = 2;
        public static final String URL = "/app/XYyoungerSettingActivity";
        public static final int YOUNGER_MORE_TIME_CONTINUE = 3;
        public static final int YOUNGER_TIME_LATER = 4;

        public YoungerModeParams() {
        }
    }

    public static void launchMarketSubscribe(Context context, String str) {
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append("https://play.google.com/store/account/subscriptions?sku=*");
        sb.append(str);
        sb.append("*&package=*");
        sb.append(packageName);
        sb.append("*");
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
        } catch (Exception e) {
            Toast.makeText(context, "can't find any app market", 0).show();
            e.printStackTrace();
        }
    }

    public static void startTemplateList(Context context, int i) {
        C1941a routerBuilder = getRouterBuilder(BaseApplicationLifeCycle.getApplication(), TemplateParams.URL);
        routerBuilder.mo10406h(TemplateParams.INTENT_EXTRA_KEY_PAGE_ITEM, i);
        routerBuilder.mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(context);
    }

    public static void startWebPage(Activity activity, String str, String str2) {
        C1941a f = getRouterBuilder(activity.getApplication(), CommonWebPageParams.URL).mo10399f(CommonWebPageParams.KEY_WEBVIEW_URL, str);
        if (!TextUtils.isEmpty(str2)) {
            f.mo10399f(CommonWebPageParams.KEY_WEBVIEW_TITLE, str2);
        }
        f.mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void startYoungerModeSetting(Context context, int i) {
        C1941a routerBuilder = getRouterBuilder(BaseApplicationLifeCycle.getApplication(), YoungerModeParams.URL);
        routerBuilder.mo10406h(YoungerModeParams.INTENT_EXTRA_KEY_MODE_TYPE, i);
        routerBuilder.mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(context);
    }
}
