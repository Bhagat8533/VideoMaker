package com.introvd.template.router;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.router.user.UserRouter.BroadCastConstant;
import java.util.HashMap;
import java.util.Map;

public class LoginRouter {
    private static final String BASE_URL = "/Login/";
    /* access modifiers changed from: private */
    public static Map<Long, OnLoginListener> loginListenerMap = new HashMap();
    private static Map<Long, LoginReceiver> loginReceiverMap = new HashMap();

    public class LoginParams {
        public static final String INTENT_EXTRA_FROM = "intent_extra_from";
        public static final String INTENT_EXTRA_NEED_LAST_LOGIN = "intent_extra_need_last_login";
        public static final String INTENT_EXTRA_REQUEST_PAGE_CODE = "intent_extra_request_page_code";
        public static final String URL_SETTING_BIND = "/Login/SettingBindAcc";
        public static final String URL_SETTING_BIND_DIALOG = "/Login/SettingBindDialog";

        public LoginParams() {
        }
    }

    private static class LoginReceiver extends BroadcastReceiver {
        private LoginReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra(LoginParams.INTENT_EXTRA_REQUEST_PAGE_CODE, -1);
            if (longExtra >= 0) {
                OnLoginListener onLoginListener = (OnLoginListener) LoginRouter.loginListenerMap.get(Long.valueOf(longExtra));
                if (onLoginListener != null && BroadCastConstant.ACTION_LOGIN_CB_SUCCESS.equals(intent.getAction())) {
                    onLoginListener.onLoginSuccess();
                }
            }
        }
    }

    public interface OnLoginListener {
        void onLoginCancel();

        void onLoginFail();

        void onLoginSuccess();
    }

    private static void registerBroadcastReceiver(long j) {
        LoginReceiver loginReceiver = (LoginReceiver) loginReceiverMap.get(Long.valueOf(j));
        if (loginReceiver == null) {
            loginReceiver = new LoginReceiver();
            loginReceiverMap.put(Long.valueOf(j), loginReceiver);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BroadCastConstant.ACTION_LOGIN_CB_SUCCESS);
        LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).registerReceiver(loginReceiver, intentFilter);
    }

    public static void releaseAll() {
        loginListenerMap.clear();
        loginReceiverMap.clear();
    }

    public static void releaseResource(long j) {
        loginListenerMap.remove(Long.valueOf(j));
        LoginReceiver loginReceiver = (LoginReceiver) loginReceiverMap.get(Long.valueOf(j));
        if (loginReceiver != null) {
            LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).unregisterReceiver(loginReceiver);
        }
    }

    public static void startSettingBindAccountActivity(long j, OnLoginListener onLoginListener) {
        loginListenerMap.put(Long.valueOf(j), onLoginListener);
        registerBroadcastReceiver(j);
        VivaRouter.getRouterBuilder(LoginParams.URL_SETTING_BIND).mo10386a(LoginParams.INTENT_EXTRA_REQUEST_PAGE_CODE, j).mo10412rX();
    }

    public static void startSettingBindAccountActivity(Context context) {
        if (C3742b.m9111II().mo23152JT()) {
            startSettingBindDialog(context, null);
        } else {
            startSettingBindAct(context, null, true);
        }
    }

    public static void startSettingBindAccountActivity(Context context, String str) {
        if (C3742b.m9111II().mo23152JT()) {
            startSettingBindDialog(context, str);
        } else {
            startSettingBindAct(context, str, true);
        }
    }

    public static void startSettingBindAccountActivity(Context context, String str, boolean z) {
        if (C3742b.m9111II().mo23152JT()) {
            startSettingBindDialog(context, str);
        } else {
            startSettingBindAct(context, str, z);
        }
    }

    private static void startSettingBindAct(Context context, String str, boolean z) {
        VivaRouter.getRouterBuilder(LoginParams.URL_SETTING_BIND).mo10399f(LoginParams.INTENT_EXTRA_FROM, str).mo10391a(LoginParams.INTENT_EXTRA_NEED_LAST_LOGIN, z).mo10382H(context);
    }

    private static void startSettingBindDialog(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            VivaRouter.getRouterBuilder(LoginParams.URL_SETTING_BIND_DIALOG).mo10399f(LoginParams.INTENT_EXTRA_FROM, str).mo10382H(context);
        } else {
            VivaRouter.getRouterBuilder(LoginParams.URL_SETTING_BIND_DIALOG).mo10382H(context);
        }
    }
}
