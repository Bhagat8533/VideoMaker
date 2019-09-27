package com.introvd.template.router.template;

import android.app.Activity;
import android.os.Parcelable;
import com.introvd.template.router.BaseRouter;
import com.introvd.template.router.todoCode.TodoConstants;

public class TemplateRouter extends BaseRouter {
    public static final String BUNDLE_SELF_APPLY_KEY = "self_apply_key";
    public static final String BUNDLE_TEMPLATE_DOWNLOAD_KEY = "bundle_template_download_url";
    public static final String EXTRA_KEY_NEED_ACTIVITY_RESULT = "key_templateInfoActivity_need_activity_result";
    public static final String EXTRA_KEY_TEMPLATE_CATEGORY_ID = "extra_key_template_category_id";
    public static final String EXTRA_KEY_TEMPLATE_CATEGORY_TITLE = "extra_key_template_category_title";
    public static final String EXTRA_KEY_TEMPLATE_PACKAGE_GROUPCODE = "extra_key_template_package_groupcode";
    public static final String INTENT_EXTRA_BOOLEAN_FROM_MATERIAL = "intent_extra_boolean_from_material";
    public static final String KEY_INTENT_TEMPLATE_SUB_TYPE = "key_intent_template_sub_type";
    public static final String KEY_TEMPLATE_CARD_PREVIEW_INTRO = "key_template_card_preview_intro";
    public static final String KEY_TEMPLATE_CARD_PREVIEW_STATE = "key_template_card_preview_state";
    public static final String KEY_TEMPLATE_CARD_PREVIEW_TITLE = "key_template_card_preview_title";
    public static final String KEY_TEMPLATE_CARD_PREVIEW_TTID = "key_template_card_preview_ttid";
    public static final String KEY_TEMPLATE_CARD_PREVIEW_TYPE = "key_template_card_preview_type";
    public static final String KEY_TEMPLATE_CARD_PREVIEW_URL = "key_template_card_preview_url";
    public static final String KEY_TEMPLATE_CARD_PREVIEW_VER = "key_template_card_preview_ver";
    public static final String KEY_TEMPLATE_ROLL_CODE = "key_template_roll_code";
    public static final String KEY_TEMPLATE_THEME_TYPE = "key_templateInfoActivity_template_theme_type";
    public static final int RATE_UNLOCK_REQUEST_CODE = 4369;
    public static final String TEMPLATE_CARD_PREVIEWTYPE_IAP_KEY = "template_card_previewtype_iap_key";
    public static final String TEMPLATE_TODO_INTERCEPTOR = "/TemplateH/todoInterceptor";
    public static final String URL_ANIMATE_FRAME_INFO = "/Template/AnimateFrame";
    public static final String URL_FILTER_DETAIL = "/Template/FilterDetail";
    public static final String URL_FILTER_INFO = "/Template/Filter";
    public static final String URL_TEMPLATE_CATEGORY = "/Template/Category";
    public static final String URL_TEMPLATE_FONT = "/Template/Font";
    public static final String URL_TEMPLATE_INFO = "/Template/Info";
    public static final String URL_TEMPLATE_PACKAGE = "/Template/Package";
    public static final String URL_TEMPLATE_PREVIEW = "/Template/Preview";
    public static final String URL_TEMPLATE_ROLL_DETAIL = "/Template/RollDetail";
    public static final String URL_TEMPLATE_SERVICE = "/TemplateH/ITemplateAPI";
    public static final String URL_TEMPLATE_WEB_DOWNLOAD = "/TemplateD/WebDownload";

    public static void launchAnimateFrameActivity(Activity activity, String str, Parcelable parcelable) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), URL_ANIMATE_FRAME_INFO).mo10399f(EXTRA_KEY_TEMPLATE_CATEGORY_ID, str).mo10387a(TodoConstants.KEY_TODOCODE_PARAM_MODEL, parcelable).mo10382H(activity);
        }
    }

    public static void launchAnimateFrameForResult(Activity activity, String str, int i) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), URL_ANIMATE_FRAME_INFO).mo10399f(EXTRA_KEY_TEMPLATE_CATEGORY_ID, str).mo10391a(EXTRA_KEY_NEED_ACTIVITY_RESULT, true).mo10396b(activity, i);
        }
    }

    public static void launchFilterActivity(Activity activity, String str, Parcelable parcelable) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), URL_FILTER_INFO).mo10399f(EXTRA_KEY_TEMPLATE_CATEGORY_ID, str).mo10387a(TodoConstants.KEY_TODOCODE_PARAM_MODEL, parcelable).mo10382H(activity);
        }
    }

    public static void launchFilterForResult(Activity activity, String str, int i) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), URL_FILTER_INFO).mo10399f(KEY_INTENT_TEMPLATE_SUB_TYPE, str).mo10391a(EXTRA_KEY_NEED_ACTIVITY_RESULT, true).mo10396b(activity, i);
        }
    }

    public static void launchFontActivity(Activity activity, String str, Parcelable parcelable) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), URL_TEMPLATE_FONT).mo10399f(EXTRA_KEY_TEMPLATE_CATEGORY_ID, str).mo10387a(TodoConstants.KEY_TODOCODE_PARAM_MODEL, parcelable).mo10382H(activity);
        }
    }

    public static void launchTemplateInfoActivity(Activity activity, String str, boolean z, Parcelable parcelable) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), URL_TEMPLATE_INFO).mo10399f(EXTRA_KEY_TEMPLATE_CATEGORY_ID, str).mo10387a(TodoConstants.KEY_TODOCODE_PARAM_MODEL, parcelable).mo10391a(INTENT_EXTRA_BOOLEAN_FROM_MATERIAL, z).mo10382H(activity);
        }
    }

    public static void startTemplateInfoActivity(Activity activity, String str) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), URL_TEMPLATE_INFO).mo10399f(EXTRA_KEY_TEMPLATE_CATEGORY_ID, str).mo10391a(EXTRA_KEY_NEED_ACTIVITY_RESULT, true).mo10396b(activity, 24580);
        }
    }

    public static void startTemplateInfoActivityByTheme(Activity activity, String str, int i) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), URL_TEMPLATE_INFO).mo10399f(EXTRA_KEY_TEMPLATE_CATEGORY_ID, str).mo10406h(KEY_TEMPLATE_THEME_TYPE, i).mo10391a(EXTRA_KEY_NEED_ACTIVITY_RESULT, true).mo10396b(activity, 24579);
        }
    }
}
