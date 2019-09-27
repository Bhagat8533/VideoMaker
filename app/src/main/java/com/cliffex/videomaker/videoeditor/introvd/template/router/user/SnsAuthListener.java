package com.introvd.template.router.user;

import android.os.Bundle;

public interface SnsAuthListener {
    void onAuthCancel(int i);

    void onAuthComplete(int i, Bundle bundle);

    void onAuthFail(int i, int i2, String str);
}
