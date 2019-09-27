package com.introvd.template.router.lvl;

import android.app.Activity;
import com.aiii.android.arouter.facade.template.C1949c;

public interface GoogleLicenseService extends C1949c {
    void checkLicense(Activity activity, GoogleLicenseErrorListener googleLicenseErrorListener, GoogleLicenseErrorListener googleLicenseErrorListener2);

    void followLastLicensingUrl(Activity activity);

    void release();
}
