package com.introvd.template.router;

import android.app.Activity;
import android.os.Parcelable;
import aoptest.chandler.com.vivarouter.R;
import com.introvd.template.router.todoCode.TodoConstants;

public class FuncExportRouter extends BaseRouter {
    public static final String FUNC_URL = "/Fuction/video_export";

    public static void launchFuncExportActivity(Activity activity, Parcelable parcelable) {
        getRouterBuilder(activity.getApplication(), FUNC_URL).mo10387a(TodoConstants.KEY_TODOCODE_PARAM_MODEL, parcelable).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }
}
