package com.introvd.template.biz.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.biz.user.p206b.C4607a;
import com.introvd.template.biz.user.p206b.C4608b;
import com.introvd.template.router.user.ISnsAuthService;
import com.introvd.template.router.user.model.SnsAuthTransData.Builder;

@C1942a(mo10417rZ = "/biz_user/biz_sns_auth_service")
public class SnsAuthServiceImpl implements ISnsAuthService {
    public void auth(Activity activity, Builder builder) {
        C4608b.m11752ST().auth(activity, builder);
    }

    public void authorizeCallBack(Activity activity, int i, int i2, int i3, Intent intent) {
        C4608b.m11752ST().authorizeCallBack(activity, i, i2, i3, intent);
    }

    public String getScreenNameBySnsType(int i) {
        return C4607a.m11749SR().getScreenNameBySnsType(i);
    }

    public void init(Context context) {
        C4607a.m11749SR().init(context);
    }

    public boolean isAuthed(int i) {
        return C4607a.m11749SR().isAuthed(i);
    }

    public void unAuth(Context context, int i) {
        C4608b.m11752ST().unAuth(context, i);
    }

    public void unregisterAuthListener() {
        C4608b.m11752ST().unregisterAuthListener();
    }
}
