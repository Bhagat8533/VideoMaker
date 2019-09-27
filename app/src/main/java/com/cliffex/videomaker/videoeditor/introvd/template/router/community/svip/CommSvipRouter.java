package com.introvd.template.router.community.svip;

import android.app.Activity;
import com.introvd.template.router.BaseRouter;

public class CommSvipRouter extends BaseRouter {
    private static final String ROUTER_GROUP = "/CommSvip/";

    public class UserWalletActivityRouter {
        public static final String URL = "/CommSvip/UserWalletActivity/entry";

        public UserWalletActivityRouter() {
        }
    }

    public static void launchUserWalletActivity(Activity activity) {
        getRouterBuilder(activity.getApplication(), UserWalletActivityRouter.URL).mo10382H(activity);
    }
}
