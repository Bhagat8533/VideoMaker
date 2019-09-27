package com.introvd.template.router;

import android.app.Activity;
import android.support.p021v4.app.Fragment;
import com.aiii.android.arouter.p091c.C1919a;

public class StudioRouter extends BaseRouter {
    public static final String FRAGMENT_URL = "/studio/fragment";
    public static final String KEY_FROM = "key_from";
    public static final String KEY_IS_CUSTOM_PROJECT = "key_custom_project";
    public static final String KEY_IS_CUSTOM_TITLE = "key_custom_title";
    public static final String KEY_IS_PROJECT_SELECT_MODE = "key_is_project_select_mode";
    public static final String KEY_LIST_MODE = "key_list_mode";
    public static final String LOCAL_ACTION_SCAN_PROJECT_FINISH = "local_action_project_scan_finish";
    public static final String LOCAL_ACTION_SCAN_PROJECT_FINISH_INTENT_RESULT = "intent_extra_draft_scan_result";
    public static final int RECYCLER_MODE_GRID_COMMUNITY = 2;
    public static final int RECYCLER_MODE_GRID_TOOLS = 1;
    public static final int RECYCLER_MODE_LIST = 0;
    public static final int STUDIO_FROM_STUDIO_ACTIVITY = 0;
    public static final int STUDIO_FROM_USER = 1;
    public static final String URL = "/studio/entry";

    public static Fragment getStudioFragment(int i, int i2) {
        return (Fragment) C1919a.m5529sc().mo10355al(FRAGMENT_URL).mo10406h(KEY_FROM, i).mo10406h(KEY_LIST_MODE, i2).mo10412rX();
    }

    public static void launchStudioActivity(Activity activity) {
        launchStudioActivity(activity, null);
    }

    public static void launchStudioActivity(Activity activity, String str) {
        if (activity != null) {
            if (str == null) {
                getRouterBuilder(activity.getApplication(), URL).mo10382H(activity);
            } else {
                getRouterBuilder(activity.getApplication(), URL).mo10399f(KEY_IS_CUSTOM_PROJECT, str).mo10382H(activity);
            }
        }
    }

    public static void launchStudioActivity(Activity activity, boolean z, String str, int i, int i2) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), URL).mo10391a(KEY_IS_PROJECT_SELECT_MODE, z).mo10399f(KEY_IS_CUSTOM_TITLE, str).mo10394aZ(i, i2).mo10382H(activity);
        }
    }

    public static void launchStudioActivity(Activity activity, boolean z, String str, String str2, int i, int i2) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), URL).mo10391a(KEY_IS_PROJECT_SELECT_MODE, z).mo10399f(KEY_IS_CUSTOM_TITLE, str).mo10399f("activityID", str2).mo10394aZ(i, i2).mo10382H(activity);
        }
    }
}
