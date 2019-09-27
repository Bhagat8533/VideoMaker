package com.introvd.template.router.shell;

import android.app.Activity;
import com.aiii.android.arouter.facade.template.C1949c;

public interface IYYBProService extends C1949c {

    public interface AuthListener {
        void onAuthFailed(int i);

        void onAuthSuceed();
    }

    void yybAuthCheck(Activity activity, AuthListener authListener);
}
