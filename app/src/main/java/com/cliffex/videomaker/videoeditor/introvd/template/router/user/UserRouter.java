package com.introvd.template.router.user;

import android.app.Activity;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.C1941a;
import com.introvd.template.router.BaseRouter;

public class UserRouter extends BaseRouter {
    public static final String BIZ_SNS_AUTH_SERVICE = "/biz_user/biz_sns_auth_service";
    public static final String BIZ_USER_SERVICE = "/biz_user/biz_user_service";
    public static final String BIZ_USER_TODO_INTERCEPTOR = "/biz_user/todoInterceptor";
    public static final String GROUP_NAME = "/biz_user/";
    public static boolean MODULE_ENABLE = false;
    public static final String PROXY_ACCOUNT_API = "/biz_user/account_api";
    public static final String PROXY_APPLICATION = "/biz_user/application";
    public static final String PROXY_MAIN_ACTIVITY = "/biz_user/main_activity";

    public class AccountBindActivityParam {
        public static final String URL = "/biz_user/AccountBindSettingAct/entry";

        public AccountBindActivityParam() {
        }
    }

    public class AccountInfoEditorParams {
        public static final String INTENT_EXTRA_KEY_ADDRESS = "address";
        public static final String INTENT_EXTRA_KEY_AVATAR_PATH = "account_info_editor_avatar_path";
        public static final String INTENT_EXTRA_KEY_EQUIPMENT = "equipment";
        public static final String INTENT_EXTRA_KEY_INTRODUCE = "introduce";
        public static final String INTENT_EXTRA_KEY_ISRENAMED = "account_info_editor_isrenamed";
        public static final String INTENT_EXTRA_KEY_MODE = "account_info_editor_mode";
        public static final String INTENT_EXTRA_KEY_NAME = "name";
        public static final String INTENT_EXTRA_KEY_NUMBERID = "numberId";
        public static final String INTENT_EXTRA_KEY_PAGE_FROM_INDIA_WELCOME = "intent_extra_key_page_from_india_welcome";
        public static final String INTENT_EXTRA_KEY_SEX = "sex";
        public static final String INTENT_EXTRA_KEY_UPLOAD_PATH = "account_info_editor_upload_path";
        public static final int MODE_REGISTER = 2;
        public static final int MODE_UPDATE = 1;
        public static final int REQUESTCODE_ACCOUNT_INFO = 200;
        public static final String URL = "/biz_user/AccountInfoEditor";

        public AccountInfoEditorParams() {
        }
    }

    public class BroadCastConstant {
        public static final String ACTION_LOGIN_CB_CANCEL = "action_login_cb_cancel";
        public static final String ACTION_LOGIN_CB_FAILED = "action_login_cb_failed";
        public static final String ACTION_LOGIN_CB_SUCCESS = "action_login_cb_success";
        public static final String ACTION_LOGOUT_SUCCESS = "action_logout_success";
        public static final String ACTION_REFRESH_ACCOUNT_INFO_FAILED = "action_refresh_account_info_failed";
        public static final String ACTION_REFRESH_ACCOUNT_INFO_SUCCESS = "action_refresh_account_info_success";
        public static final String EXTRA_ERROR_JSON_STR = "extra_error_json_str";
        public static final String EXTRA_UNIQUE_REQUEST_ID = "extra_unique_request_id";

        public BroadCastConstant() {
        }
    }

    public class PhoneVerifyActivityParams {
        public static final String EXTRA_KEY_FROM = "extra_key_from";
        public static final String EXTRA_KEY_MODE = "extra_key_mode";
        public static final String EXTRA_KEY_PHONE_NUM = "extra_key_phone_num";
        public static final String EXTRA_KEY_REQUESTPAGECODE = "extra_key_requestPageCode";
        public static final String EXTRA_KEY_UNIQUEREQUESTID = "extra_key_uniquerequestid";
        public static final int FROM_NORMAL = 2;
        public static final int FROM_REGISTER = 1;
        public static final int MODE_BIND = 2;
        public static final int MODE_LOGIN = 1;
        public static final int MODE_VERIFY = 3;
        public static final String URL = "/biz_user/PhoneVerifyActivity/entry";

        public PhoneVerifyActivityParams() {
        }
    }

    public static void launchAccountBindSettingActivity(Activity activity) {
        getRouterBuilder(activity.getApplication(), AccountBindActivityParam.URL).mo10382H(activity);
    }

    public static void launchPhoneVerifyActivity(Activity activity, int i, int i2, long j, long j2) {
        launchPhoneVerifyActivity(activity, i, i2, j, j2, "");
    }

    public static void launchPhoneVerifyActivity(Activity activity, int i, int i2, long j, long j2, String str) {
        C1941a h = getRouterBuilder(activity.getApplication(), PhoneVerifyActivityParams.URL).mo10406h(PhoneVerifyActivityParams.EXTRA_KEY_MODE, i).mo10386a(PhoneVerifyActivityParams.EXTRA_KEY_REQUESTPAGECODE, j2).mo10386a(PhoneVerifyActivityParams.EXTRA_KEY_UNIQUEREQUESTID, j).mo10406h(PhoneVerifyActivityParams.EXTRA_KEY_FROM, i2);
        if (!TextUtils.isEmpty(str)) {
            h.mo10399f(PhoneVerifyActivityParams.EXTRA_KEY_PHONE_NUM, str);
        }
        h.mo10382H(activity);
    }
}
