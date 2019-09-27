package com.introvd.template.router.user;

import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0069g;
import android.arch.lifecycle.C0078n;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p021v4.content.LocalBroadcastManager;
import com.introvd.template.router.lifecycle.BaseApplicationLifeCycle;
import com.introvd.template.router.user.UserRouter.BroadCastConstant;

public class LoginListenerWrapper implements C0068f {
    private Context context;
    /* access modifiers changed from: private */
    public OnLoginFailedListener loginFailedListener;
    /* access modifiers changed from: private */
    public OnLoginSuccessListener loginSuccessListener;
    /* access modifiers changed from: private */
    public OnLogoutCallbackListener logoutCallbackListener;
    private BroadcastReceiver mLoginCallbackBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra(BroadCastConstant.EXTRA_UNIQUE_REQUEST_ID, -1);
            if (BroadCastConstant.ACTION_LOGIN_CB_CANCEL.equals(intent.getAction()) && LoginListenerWrapper.this.loginFailedListener != null) {
                LoginListenerWrapper.this.loginFailedListener.onLoginCancel(intent, longExtra);
            } else if (BroadCastConstant.ACTION_LOGIN_CB_FAILED.equals(intent.getAction()) && LoginListenerWrapper.this.loginFailedListener != null) {
                LoginListenerWrapper.this.loginFailedListener.onLoginFailed(intent, longExtra);
            } else if (BroadCastConstant.ACTION_LOGIN_CB_SUCCESS.equals(intent.getAction()) && LoginListenerWrapper.this.loginSuccessListener != null) {
                LoginListenerWrapper.this.loginSuccessListener.onLoginSuccess(intent, longExtra);
            } else if (BroadCastConstant.ACTION_LOGOUT_SUCCESS.equals(intent.getAction()) && LoginListenerWrapper.this.logoutCallbackListener != null) {
                LoginListenerWrapper.this.logoutCallbackListener.onLogoutSuccess(intent, longExtra);
            }
        }
    };

    public interface OnLoginFailedListener {
        void onLoginCancel(Intent intent, long j);

        void onLoginFailed(Intent intent, long j);
    }

    public interface OnLoginSuccessListener {
        void onLoginSuccess(Intent intent, long j);
    }

    public interface OnLogoutCallbackListener {
        void onLogoutSuccess(Intent intent, long j);
    }

    private void registerLoginCallBackBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BroadCastConstant.ACTION_LOGIN_CB_CANCEL);
        intentFilter.addAction(BroadCastConstant.ACTION_LOGIN_CB_SUCCESS);
        intentFilter.addAction(BroadCastConstant.ACTION_LOGIN_CB_FAILED);
        intentFilter.addAction(BroadCastConstant.ACTION_LOGOUT_SUCCESS);
        LocalBroadcastManager.getInstance(this.context).registerReceiver(this.mLoginCallbackBroadcastReceiver, intentFilter);
    }

    private void unRegisterLoginCallBackBroadcastReceiver() {
        if (this.context != null) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.mLoginCallbackBroadcastReceiver);
        }
    }

    public static LoginListenerWrapper with(C0069g gVar) {
        LoginListenerWrapper loginListenerWrapper = new LoginListenerWrapper();
        loginListenerWrapper.context = BaseApplicationLifeCycle.getApplication();
        gVar.getLifecycle().mo152a(loginListenerWrapper);
        return loginListenerWrapper;
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_CREATE)
    public void onActivityCreate() {
        registerLoginCallBackBroadcastReceiver();
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onActivityDestroy() {
        unRegisterLoginCallBackBroadcastReceiver();
    }

    public LoginListenerWrapper setOnLoginFailedListener(OnLoginFailedListener onLoginFailedListener) {
        this.loginFailedListener = onLoginFailedListener;
        return this;
    }

    public LoginListenerWrapper setOnLoginSuccessListener(OnLoginSuccessListener onLoginSuccessListener) {
        this.loginSuccessListener = onLoginSuccessListener;
        return this;
    }

    public LoginListenerWrapper setOnLogoutSuccessListener(OnLogoutCallbackListener onLogoutCallbackListener) {
        this.logoutCallbackListener = onLogoutCallbackListener;
        return this;
    }
}
