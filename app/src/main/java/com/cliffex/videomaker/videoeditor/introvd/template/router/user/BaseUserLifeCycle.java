package com.introvd.template.router.user;

import android.content.Context;
import android.util.Log;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.lifecycle.BizAppLifeCycleManager;
import com.introvd.template.router.user.model.LoginErrorResponse;

public abstract class BaseUserLifeCycle implements C1949c {
    public final void init(Context context) {
    }

    public void onLoginFailed() {
    }

    public void onLoginSuccess(boolean z) {
        String str = BizAppLifeCycleManager.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onLoginSuccess register = ");
        sb.append(z);
        Log.d(str, sb.toString());
    }

    public void onLogoutSuccess() {
        String str = BizAppLifeCycleManager.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onLogoutSuccess = ");
        Log.d(str, sb.toString());
    }

    public void onTokenRefreshSuccess() {
        String str = BizAppLifeCycleManager.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onTokenRefreshSuccess = ");
        Log.d(str, sb.toString());
    }

    public void onUserZoneFailed(LoginErrorResponse loginErrorResponse) {
        String str = BizAppLifeCycleManager.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onUserZoneFailed = ");
        Log.d(str, sb.toString());
    }

    public void onUserZoneSuccess() {
    }
}
