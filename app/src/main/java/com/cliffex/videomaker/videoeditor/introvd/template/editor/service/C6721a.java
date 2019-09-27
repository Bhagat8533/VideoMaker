package com.introvd.template.editor.service;

import android.content.Context;
import android.os.Bundle;
import com.introvd.template.C4681i;
import com.introvd.template.common.LogUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p374q.C8350g.C8354a;

/* renamed from: com.introvd.template.editor.service.a */
public class C6721a implements C8354a {
    private static C6721a deM;

    public static C6721a aqC() {
        if (deM == null) {
            deM = new C6721a();
        }
        return deM;
    }

    /* renamed from: a */
    public void mo23009a(Context context, String str, int i, Bundle bundle) {
        LogUtils.m14223i("DownloadNotificationObserver", bundle.toString());
        int i2 = bundle.getInt(SocialConstDef.TASK_PROGRESS_1);
        int i3 = bundle.getInt("state");
        int i4 = bundle.getInt("_id");
        String string = bundle.getString(SocialConstDef.TASK_USER_DATA);
        if (i3 == 196608) {
            C4681i.m12184Gp().mo25016Gr().showDownloadNotification(context, i4 + 100, string, i2);
        } else {
            C4681i.m12184Gp().mo25016Gr().hideDownloadNotification(context, i4 + 100);
        }
    }
}
