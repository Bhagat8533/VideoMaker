package com.introvd.template.router.sns;

import android.app.Activity;
import com.aiii.android.arouter.facade.C1941a;
import com.introvd.template.router.BaseRouter;

public class SnsRouter extends BaseRouter {
    private static final String GROUP_NAME = "/biz_sns/";

    public class SnapchatShareActivityRouter {
        public static final String KEY_VIDEO_VIEW_URL = "video_view_url";
        public static final String URL = "/biz_sns/SnapchatShareActivity";

        public SnapchatShareActivityRouter() {
        }
    }

    public static void gotoSnapchatShareActivity(Activity activity, String str) {
        C1941a routerBuilder = getRouterBuilder(activity.getApplication(), SnapchatShareActivityRouter.URL);
        routerBuilder.mo10399f(SnapchatShareActivityRouter.KEY_VIDEO_VIEW_URL, str);
        routerBuilder.mo10382H(activity);
    }
}
