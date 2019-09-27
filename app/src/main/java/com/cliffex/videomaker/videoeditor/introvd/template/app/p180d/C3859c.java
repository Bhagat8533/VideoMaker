package com.introvd.template.app.p180d;

import android.app.Activity;
import android.net.Uri;
import com.giii.aiii.biii.tasks.OnFailureListener;
import com.giii.aiii.biii.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.C3424a;
import com.google.firebase.dynamiclinks.C3425b;
import com.introvd.template.app.splash.SplashActivity;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.p131c.p132a.p135c.C2575a;

/* renamed from: com.introvd.template.app.d.c */
public class C3859c {
    /* renamed from: a */
    public static void m9504a(final SplashActivity splashActivity, final boolean z, final C3856a aVar) {
        C3424a.m8663AI().mo22347f(splashActivity.getIntent()).addOnSuccessListener((Activity) splashActivity, (OnSuccessListener<? super TResult>) new OnSuccessListener<C3425b>() {
            /* renamed from: a */
            public void onSuccess(C3425b bVar) {
                Uri uri;
                LogUtilsV2.m14228e("processDynamicLink onSuccess");
                if (bVar != null) {
                    uri = bVar.mo22348AJ();
                    StringBuilder sb = new StringBuilder();
                    sb.append("processDynamicLink deepLink : ");
                    sb.append(uri);
                    LogUtilsV2.m14230i(sb.toString());
                } else {
                    uri = null;
                }
                if (uri != null) {
                    if (uri.getPath() != null && uri.getPath().contains("vivavideo")) {
                        String lastPathSegment = uri.getLastPathSegment();
                        String queryParameter = uri.getQueryParameter(SocialConstDef.ONLINE_TASK_TODO_CONTENT);
                        TODOParamModel tODOParamModel = new TODOParamModel();
                        tODOParamModel.mJsonParam = queryParameter;
                        tODOParamModel.mTODOCode = C2575a.parseInt(lastPathSegment, 0);
                        if (aVar != null) {
                            aVar.mo23389c(splashActivity, tODOParamModel, z);
                        }
                    }
                } else if (aVar != null) {
                    aVar.mo23388a(splashActivity, z);
                }
            }
        }).addOnFailureListener((Activity) splashActivity, (OnFailureListener) new OnFailureListener() {
            public void onFailure(Exception exc) {
                if (aVar != null) {
                    aVar.mo23388a(splashActivity, z);
                }
            }
        });
    }
}
