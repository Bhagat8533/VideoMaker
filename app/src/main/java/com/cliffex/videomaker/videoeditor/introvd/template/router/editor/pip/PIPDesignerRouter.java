package com.introvd.template.router.editor.pip;

import android.app.Activity;
import com.introvd.template.router.BaseRouter;
import com.introvd.template.router.common.CommonParams;

public class PIPDesignerRouter extends BaseRouter {
    public static final String URL = "/PipEditor/PIPDesigner";

    public static void launchPipDesigner(Activity activity, String str) {
        long longExtra = activity.getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0);
        getRouterBuilder(activity.getApplication(), URL).mo10386a(CommonParams.INTENT_MAGIC_CODE, longExtra).mo10399f("activityID", str).mo10406h("new_prj", activity.getIntent().getIntExtra("new_prj", 1)).mo10382H(activity);
    }
}
