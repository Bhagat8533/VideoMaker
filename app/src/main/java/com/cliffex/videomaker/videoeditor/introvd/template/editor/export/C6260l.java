package com.introvd.template.editor.export;

import android.content.Context;
import android.view.View;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7592b;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.export.l */
class C6260l {
    private Context context;

    /* renamed from: com.introvd.template.editor.export.l$a */
    interface C6262a {
        /* renamed from: cG */
        void mo29196cG(View view);
    }

    C6260l(Context context2) {
        this.context = context2;
    }

    /* renamed from: cF */
    private HashMap<String, String> m17936cF(View view) {
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("platform", C7591a.m22370W(view.getTag()));
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29192a(final C6262a aVar) {
        C7589a.m22363h(46, new ViewAdsListener() {
            private View cQh;

            public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                if (!AdParamMgr.isAdConfigValid(43) && aVar != null) {
                    View adView = C6260l.this.getAdView();
                    this.cQh = adView;
                    if (adView != null) {
                        aVar.mo29196cG(this.cQh);
                    }
                }
            }
        });
        C7589a.m22360aj(this.context, 46);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cE */
    public void mo29193cE(View view) {
        HashMap cF = m17936cF(view);
        UserBehaviorLog.onKVEvent(this.context, "Ad_Export_B_Show", cF);
        C7592b.m22379F(this.context, "Ad_Export_B_Show", (String) cF.get("platform"));
    }

    /* access modifiers changed from: 0000 */
    public View getAdView() {
        return C7589a.getAdView(this.context, 46);
    }

    /* access modifiers changed from: 0000 */
    public void onRelease() {
        C7680l.aAe().releasePosition(46);
    }
}
