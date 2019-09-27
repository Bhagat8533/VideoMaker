package com.introvd.template.router.community.p378im;

import android.app.Activity;
import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;

/* renamed from: com.introvd.template.router.community.im.IIMFuncRouter */
public interface IIMFuncRouter extends C1949c {
    public static final String URL = "/IM/IMFuncRouter";

    boolean checkIMServiceValid(Activity activity);

    void enableReceiveNotification(boolean z);

    void exitService();

    void initIMClientInside(Context context, int i, boolean z);

    void initIMService(Context context);

    void regiestrIMPushResult(Context context, String str, long j, String str2);

    void setIMShowNotificationInBackgroud(boolean z);

    void uninitIMClient();
}
