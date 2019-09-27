package com.introvd.template.datacenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.introvd.template.p243e.C5542a;

public class SocialServiceInteractionNotify extends BaseSocialNotify {
    private static SocialServiceInteractionNotify INSTANCE;

    public static synchronized SocialServiceInteractionNotify getInstance() {
        SocialServiceInteractionNotify socialServiceInteractionNotify;
        synchronized (SocialServiceInteractionNotify.class) {
            if (INSTANCE == null) {
                INSTANCE = new SocialServiceInteractionNotify();
            }
            socialServiceInteractionNotify = INSTANCE;
        }
        return socialServiceInteractionNotify;
    }

    public synchronized void onHandleIntentFailed(Context context, Intent intent) {
    }

    public synchronized void onNotify(Context context, String str, Object obj, int i, int i2, Intent intent, C5542a aVar) {
        Bundle bundle;
        if (i != 0) {
            if (str != null) {
                if (intent != null) {
                    try {
                        bundle = intent.getExtras();
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    bundle = null;
                }
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString("social_method", str);
                fillFeedbackParam(bundle, str, i2, 0, 0);
                if (65536 == i && i2 != 0 && SocialExceptionHandler.handleErrCode(context, SocialServiceDef.ACTION_SOCIAL_SERVICE_INTERACTION, str, i2, null)) {
                    reportNetworkError(context, str, i2, 0, 0);
                }
                if (i != 131072) {
                    bundle.putInt(SocialExceptionHandler.KEY_SERVICE_ERROR_CODE, i2);
                }
                notifyAllListener(context, str, i, bundle, aVar);
            }
        }
    }
}
