package com.introvd.template.router.slide;

import android.app.Activity;
import aoptest.chandler.com.vivarouter.R;
import com.introvd.template.router.BaseRouter;

public class FunnySlideRouter extends BaseRouter {
    public static final String ACTION_FINISH_FUNNY_ACTIVITY = "com.introvd.template.finishfunny";
    public static final String ACTION_FINISH_FUNNY_INFO_ACTIVITY = "com.introvd.template.finishfunnyinfo";
    public static final String DELETE_FUNNY_VIDEO_FILE = "delete_funny_video_file";
    public static final String INTENT_KEY_APPLY_THEME_ID = "intent_key_apply_theme_id";
    public static final String INTENT_KEY_APPLY_THEME_NAME = "intent_key_apply_theme_name";
    public static final String INTENT_KEY_FUNNY_TEMPLATE_GROUP = "intent_key_funny_template_group";
    public static final String INTENT_KEY_FUNNY_TEMPLATE_ID = "intent_key_funny_template_ttid";
    public static final String INTENT_KEY_SHARE_FILE_PATH = "intent_key_share_file_path";
    public static final String INTENT_KEY_TODOCODE = "intent_key_todocode";
    public static final String URL_EDITOR = "/Funny/Editor";
    public static final String URL_SHARE = "/Funnyy/Share";
    public static final String URL_TEMPLATE_DETAIL = "/Funny/TemplateDetail";
    public static final String URL_TEMPLATE_INFO = "/Funny/TemplateInfo";
    public static final String URL_THEME_TEST = "/Funny/themeTest";

    public static void launchFunnyEdit(Activity activity, long j) {
        getRouterBuilder(activity.getApplication(), URL_EDITOR).mo10386a(INTENT_KEY_APPLY_THEME_ID, j).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void launchFunnyShare(Activity activity, String str, String str2) {
        getRouterBuilder(activity.getApplication(), URL_SHARE).mo10399f(INTENT_KEY_APPLY_THEME_ID, str).mo10399f(INTENT_KEY_APPLY_THEME_NAME, str2).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void launchSlideThemeTest(Activity activity) {
        getRouterBuilder(activity.getApplication(), URL_THEME_TEST).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void launchTemplateDetail(Activity activity, String str, String str2) {
        getRouterBuilder(activity.getApplication(), URL_TEMPLATE_DETAIL).mo10399f(INTENT_KEY_FUNNY_TEMPLATE_GROUP, str).mo10399f(INTENT_KEY_FUNNY_TEMPLATE_ID, str2).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void launchTemplateInfo(Activity activity, int i) {
        getRouterBuilder(activity.getApplication(), URL_TEMPLATE_INFO).mo10406h(INTENT_KEY_TODOCODE, i).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }
}
