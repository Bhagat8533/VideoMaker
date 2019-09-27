package com.introvd.template.router.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.user.model.SnsAuthTransData.Builder;

public interface ISnsAuthService extends C1949c {
    void auth(Activity activity, Builder builder);

    void authorizeCallBack(Activity activity, int i, int i2, int i3, Intent intent);

    String getScreenNameBySnsType(int i);

    boolean isAuthed(int i);

    void unAuth(Context context, int i);

    void unregisterAuthListener();
}
