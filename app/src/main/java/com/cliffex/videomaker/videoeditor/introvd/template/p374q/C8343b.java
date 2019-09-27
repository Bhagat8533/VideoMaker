package com.introvd.template.p374q;

import android.content.Context;
import android.content.Intent;
import com.introvd.template.datacenter.SocialServiceDef;
import com.xiaoying.p448a.C9561c;

/* renamed from: com.introvd.template.q.b */
public class C8343b {
    /* renamed from: gO */
    public static void m24053gO(Context context) {
        Intent intent = new Intent();
        intent.setAction(SocialServiceDef.ACTION_FILES_DOWNLOAD);
        intent.putExtra("stop", true);
        intent.putExtra("CtrlAll", true);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }
}
