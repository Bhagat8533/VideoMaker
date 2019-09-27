package com.introvd.template.app.p180d;

import android.app.Activity;
import android.net.Uri;
import com.eiii.applinks.AppLinkData;
import com.eiii.applinks.AppLinkData.CompletionHandler;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.platform.p215a.C4815a;
import p000a.C0005c;

/* renamed from: com.introvd.template.app.d.b */
public class C3857b {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m9501a(Activity activity, boolean z, Uri uri, C3856a aVar) {
        if (uri == null) {
            if (aVar != null) {
                aVar.mo23388a(activity, z);
            }
            return;
        }
        if (uri.getPath() != null && uri.getPath().contains("vivavideo")) {
            String lastPathSegment = uri.getLastPathSegment();
            String queryParameter = uri.getQueryParameter(SocialConstDef.ONLINE_TASK_TODO_CONTENT);
            TODOParamModel tODOParamModel = new TODOParamModel();
            tODOParamModel.mJsonParam = queryParameter;
            tODOParamModel.mTODOCode = C2575a.parseInt(lastPathSegment, 0);
            if (aVar != null) {
                aVar.mo23389c(activity, tODOParamModel, z);
            }
        }
    }

    /* renamed from: a */
    public static void m9502a(final Activity activity, final boolean z, final C3856a aVar) {
        if (activity != null) {
            Uri b = C0005c.m2b(VivaBaseApplication.m8749FZ(), activity.getIntent());
            m9501a(activity, z, b, aVar);
            if (b == null && !C4815a.m12409EL()) {
                AppLinkData.fetchDeferredAppLinkData(VivaBaseApplication.m8749FZ(), new CompletionHandler() {
                    public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                        if (appLinkData != null) {
                            C3857b.m9501a(activity, z, appLinkData.getTargetUri(), aVar);
                        }
                    }
                });
            }
        }
    }
}
