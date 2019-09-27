package com.introvd.template.router;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.C1941a;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.router.community.p378im.IIMFuncRouter;

public class IMRouter extends BaseRouter {
    public static final int IMCLIENT_TYPE_EASEMOB = 0;

    public class IMChatActivityParams {
        public static final String KEY_CHAT_AUID = "key_chat_auid";
        public static final String KEY_CHAT_AUTO_SHOW_IME = "key_chat_auto_show_ime";
        public static final String KEY_CHAT_AVATAR = "key_chat_avatar";
        public static final String KEY_CHAT_NICKNAME = "key_chat_nickname";
        public static final String URL = "/IM/ChatActivity";

        public IMChatActivityParams() {
        }
    }

    public class IMSettingActivityParams {
        public static final String URL = "/IM/IMSetting";

        public IMSettingActivityParams() {
        }
    }

    public static void enableReceiveNotification(boolean z) {
        IIMFuncRouter iIMFuncRouter = (IIMFuncRouter) C1919a.m5529sc().mo10356i(IIMFuncRouter.class);
        if (iIMFuncRouter != null) {
            iIMFuncRouter.enableReceiveNotification(z);
        }
    }

    public static void exitService() {
        IIMFuncRouter iIMFuncRouter = (IIMFuncRouter) C1919a.m5529sc().mo10356i(IIMFuncRouter.class);
        if (iIMFuncRouter != null) {
            iIMFuncRouter.exitService();
        }
    }

    public static void initIMClientInside(Context context, int i, boolean z) {
        IIMFuncRouter iIMFuncRouter = (IIMFuncRouter) C1919a.m5529sc().mo10356i(IIMFuncRouter.class);
        if (iIMFuncRouter != null) {
            iIMFuncRouter.initIMClientInside(context, i, z);
        }
    }

    public static void initIMService(Context context) {
        IIMFuncRouter iIMFuncRouter = (IIMFuncRouter) C1919a.m5529sc().mo10356i(IIMFuncRouter.class);
        if (iIMFuncRouter != null) {
            iIMFuncRouter.initIMService(context);
        }
    }

    public static void regiestrIMPushResult(Context context, String str, long j, String str2) {
        IIMFuncRouter iIMFuncRouter = (IIMFuncRouter) C1919a.m5529sc().mo10356i(IIMFuncRouter.class);
        if (iIMFuncRouter != null) {
            iIMFuncRouter.regiestrIMPushResult(context, str, j, str2);
        }
    }

    public static void setIMShowNotificationInBackgroud(boolean z) {
        IIMFuncRouter iIMFuncRouter = (IIMFuncRouter) C1919a.m5529sc().mo10356i(IIMFuncRouter.class);
        if (iIMFuncRouter != null) {
            iIMFuncRouter.setIMShowNotificationInBackgroud(z);
        }
    }

    public static void startIMChatActivity(Activity activity, String str, String str2, String str3, boolean z, int i, int i2) {
        if (activity != null && !activity.isFinishing()) {
            IIMFuncRouter iIMFuncRouter = (IIMFuncRouter) C1919a.m5529sc().mo10356i(IIMFuncRouter.class);
            if (iIMFuncRouter != null && iIMFuncRouter.checkIMServiceValid(activity)) {
                C1941a routerBuilder = getRouterBuilder((Application) activity.getApplicationContext(), IMChatActivityParams.URL);
                routerBuilder.mo10391a(IMChatActivityParams.KEY_CHAT_AUTO_SHOW_IME, z);
                if (!TextUtils.isEmpty(str)) {
                    routerBuilder.mo10399f(IMChatActivityParams.KEY_CHAT_AUID, str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    routerBuilder.mo10399f(IMChatActivityParams.KEY_CHAT_NICKNAME, str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    routerBuilder.mo10399f(IMChatActivityParams.KEY_CHAT_AVATAR, str3);
                }
                if (!(i == 0 || i2 == 0)) {
                    routerBuilder.mo10394aZ(i, i2);
                }
                routerBuilder.mo10382H(activity);
            }
        }
    }

    public static void uninitIMClient() {
        IIMFuncRouter iIMFuncRouter = (IIMFuncRouter) C1919a.m5529sc().mo10356i(IIMFuncRouter.class);
        if (iIMFuncRouter != null) {
            iIMFuncRouter.uninitIMClient();
        }
    }
}
