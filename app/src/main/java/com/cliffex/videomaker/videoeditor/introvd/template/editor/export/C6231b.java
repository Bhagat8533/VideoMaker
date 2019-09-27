package com.introvd.template.editor.export;

import android.app.Activity;
import android.view.View;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.p326ad.p327a.C7589a;

/* renamed from: com.introvd.template.editor.export.b */
public class C6231b {
    /* access modifiers changed from: private */
    public C6234b cOc;
    private int cOd = 0;

    /* renamed from: com.introvd.template.editor.export.b$a */
    interface C6233a {
        void alj();

        /* renamed from: cD */
        void mo29134cD(View view);
    }

    /* renamed from: com.introvd.template.editor.export.b$b */
    interface C6234b {
        boolean isShowing();
    }

    C6231b(C6234b bVar) {
        this.cOc = bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: ao */
    public void m17883ao(Activity activity) {
        if (C3742b.m9111II().mo23155Jb() - this.cOd > 0) {
            this.cOd++;
            C7589a.m22360aj(activity, 43);
        }
    }

    /* renamed from: a */
    public void mo29131a(final Activity activity, final C6233a aVar) {
        C7589a.m22363h(43, new ViewAdsListener() {
            public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                if (C6231b.this.cOc.isShowing()) {
                    if (z) {
                        View adView = C7589a.getAdView(activity, 43);
                        if (adView != null) {
                            aVar.mo29134cD(adView);
                        } else {
                            aVar.alj();
                            C6231b.this.m17883ao(activity);
                        }
                    } else {
                        aVar.alj();
                        if (C8048e.aBe().mo23648dE(str)) {
                            C6231b.this.m17883ao(activity);
                        }
                    }
                }
            }
        });
        C7589a.m22360aj(activity, 43);
    }

    public void ali() {
        C7589a.m22363h(43, null);
        C7589a.m22364rT(43);
        this.cOd = 0;
    }
}
