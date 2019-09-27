package com.introvd.template.router.user;

import android.util.Log;
import com.introvd.template.router.lifecycle.BizAppLifeCycleManager;
import com.introvd.template.router.lifecycle.LifeCycleConstant;
import com.introvd.template.router.user.model.LoginErrorResponse;
import java.util.List;

public class BizUserLifeCycleManager {
    private static volatile BizUserLifeCycleManager bizUserLifeCycleManager;
    private List<BaseUserLifeCycle> applicationList = LifeCycleConstant.getUserLifeCycleObList();

    private BizUserLifeCycleManager() {
    }

    public static BizUserLifeCycleManager getInstance() {
        if (bizUserLifeCycleManager == null) {
            synchronized (BizUserLifeCycleManager.class) {
                if (bizUserLifeCycleManager == null) {
                    bizUserLifeCycleManager = new BizUserLifeCycleManager();
                }
            }
        }
        return bizUserLifeCycleManager;
    }

    public void performOnLoginFailed() {
        for (BaseUserLifeCycle baseUserLifeCycle : this.applicationList) {
            if (baseUserLifeCycle != null) {
                long currentTimeMillis = System.currentTimeMillis();
                baseUserLifeCycle.onLoginFailed();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String str = BizAppLifeCycleManager.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(baseUserLifeCycle.getClass().getSimpleName());
                sb.append(" onLoginFailed cost = ");
                sb.append(currentTimeMillis2);
                sb.append("ms");
                Log.d(str, sb.toString());
            }
        }
    }

    public void performOnLoginSuccess(boolean z) {
        for (BaseUserLifeCycle baseUserLifeCycle : this.applicationList) {
            if (baseUserLifeCycle != null) {
                long currentTimeMillis = System.currentTimeMillis();
                baseUserLifeCycle.onLoginSuccess(z);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String str = BizAppLifeCycleManager.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(baseUserLifeCycle.getClass().getSimpleName());
                sb.append(" onLoginSuccess cost = ");
                sb.append(currentTimeMillis2);
                sb.append("ms");
                Log.d(str, sb.toString());
            }
        }
    }

    public void performOnLogoutSuccess() {
        for (BaseUserLifeCycle baseUserLifeCycle : this.applicationList) {
            if (baseUserLifeCycle != null) {
                long currentTimeMillis = System.currentTimeMillis();
                baseUserLifeCycle.onLogoutSuccess();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String str = BizAppLifeCycleManager.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(baseUserLifeCycle.getClass().getSimpleName());
                sb.append(" onLogoutSuccess cost = ");
                sb.append(currentTimeMillis2);
                sb.append("ms");
                Log.d(str, sb.toString());
            }
        }
    }

    public void performanceOnTokenRefreshSuccess() {
        for (BaseUserLifeCycle baseUserLifeCycle : this.applicationList) {
            if (baseUserLifeCycle != null) {
                long currentTimeMillis = System.currentTimeMillis();
                baseUserLifeCycle.onTokenRefreshSuccess();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String str = BizAppLifeCycleManager.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(baseUserLifeCycle.getClass().getSimpleName());
                sb.append(" onTokenRefreshSuccess cost = ");
                sb.append(currentTimeMillis2);
                sb.append("ms");
                Log.d(str, sb.toString());
            }
        }
    }

    public void performanceOnUserZoneFailed(LoginErrorResponse loginErrorResponse) {
        for (BaseUserLifeCycle baseUserLifeCycle : this.applicationList) {
            if (baseUserLifeCycle != null) {
                long currentTimeMillis = System.currentTimeMillis();
                baseUserLifeCycle.onUserZoneFailed(loginErrorResponse);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String str = BizAppLifeCycleManager.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(baseUserLifeCycle.getClass().getSimpleName());
                sb.append(" onUserZoneFailed cost = ");
                sb.append(currentTimeMillis2);
                sb.append("ms");
                Log.d(str, sb.toString());
            }
        }
    }
}
