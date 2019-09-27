package com.introvd.template.app;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.gson.Gson;
import com.introvd.template.C3569a;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.introduce.page.model.IntroduceModel;
import com.introvd.template.introduce.page.model.IntroduceModel.UrlArrayBean;
import com.quvideo.mobile.platform.p215a.C4815a;
import com.quvideo.mobile.platform.p215a.C4816b;
import com.quvideo.mobile.platform.report.C4842b;
import com.quvideo.mobile.platform.report.model.ReportChannelResponse;
import java.util.concurrent.atomic.AtomicBoolean;
import p037b.p050b.C1850u;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.i */
public class C3999i {
    public static AtomicBoolean biA = new AtomicBoolean(false);
    public static AtomicBoolean biB = new AtomicBoolean(false);
    public static String bix;
    public static String biy;
    public static Uri biz;
    public static String todoContent;

    /* renamed from: com.introvd.template.app.i$a */
    private static class C4002a {
        String bix;
        String todoContent;
        String url;

        private C4002a(String str, String str2, String str3) {
            this.url = str;
            this.bix = str2;
            this.todoContent = str3;
        }
    }

    /* renamed from: Ht */
    public static void m9884Ht() {
        if (AppStateModel.getInstance().isInChina()) {
            C4842b.m12446EM().mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) C4022j.biC).aTW().mo10188a((C1850u<? super T>) new C1810c<C4002a>() {
                /* renamed from: a */
                public void onSuccess(C4002a aVar) {
                    if (aVar != null) {
                        C3999i.biy = aVar.url;
                        C3999i.bix = aVar.bix;
                        C3999i.todoContent = aVar.todoContent;
                    }
                }

                public void onError(Throwable th) {
                    Log.e("XYMediaSource", "onError", th);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ C4002a m9885a(ReportChannelResponse reportChannelResponse) throws Exception {
        if (reportChannelResponse == null || reportChannelResponse.data == null || reportChannelResponse.data.extra == null) {
            return null;
        }
        IntroduceModel introduceModel = (IntroduceModel) new Gson().fromJson(reportChannelResponse.data.extra, IntroduceModel.class);
        if (introduceModel == null || introduceModel.getUrlArray() == null || introduceModel.getUrlArray().isEmpty()) {
            return null;
        }
        UrlArrayBean urlArrayBean = (UrlArrayBean) introduceModel.getUrlArray().get(0);
        if (urlArrayBean == null) {
            return null;
        }
        return new C4002a(urlArrayBean.getUrl(), reportChannelResponse.data.todocode, reportChannelResponse.data.todocontent);
    }

    public static void init(Context context) {
        C4815a.init(context, C3569a.m8772FK());
        StringBuilder sb = new StringBuilder();
        sb.append("XYMediaSource AppRuntime.isNewUser()=");
        sb.append(C3569a.m8772FK());
        LogUtilsV2.m14227d(sb.toString());
        C4815a.m12410a(new C4816b() {
        });
    }
}
