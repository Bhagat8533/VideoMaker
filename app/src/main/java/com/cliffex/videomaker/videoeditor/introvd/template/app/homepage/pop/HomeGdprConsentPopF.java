package com.introvd.template.app.homepage.pop;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0069g;
import android.arch.lifecycle.C0078n;
import com.introvd.template.app.homepage.C3958f;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.consent.gdpr.C5521b;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.VivaCommunityRouter.GdprPrivacyPageParams;
import com.quvideo.priority.p217a.C4892c;

public class HomeGdprConsentPopF extends C4892c {
    private ForGdprLifeCycleObserver bsw = new ForGdprLifeCycleObserver();

    private class ForGdprLifeCycleObserver implements C0068f {
        private C0069g bqs;
        private boolean bqt;

        private ForGdprLifeCycleObserver() {
            this.bqt = true;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public void m9844j(C0069g gVar) {
            this.bqs = gVar;
        }

        @C0078n(mo161n = C0062a.ON_PAUSE)
        public void onPause() {
            this.bqt = false;
        }

        @C0078n(mo161n = C0062a.ON_RESUME)
        public void onResume() {
            if (!this.bqt) {
                if (this.bqs != null) {
                    this.bqs.getLifecycle().mo153b(this);
                }
                HomeGdprConsentPopF.this.mo25344EW();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo23396p(Activity activity) {
        if (!(activity instanceof C0069g)) {
            return false;
        }
        if (C5521b.m14959dH(false) || AppStateModel.getInstance().isGDPRAgree()) {
            if (AppStateModel.getInstance().isGDPRAgree()) {
                LogUtilsV2.m14230i("GDPR enable userbehavior sdks");
                UserBehaviorLog.setEnable(true);
                C3958f.m9764cn(activity.getApplicationContext());
            } else {
                UserBehaviorLog.setEnable(false);
            }
            return false;
        }
        VivaRouter.getRouterBuilder(GdprPrivacyPageParams.URL).mo10391a(GdprPrivacyPageParams.INTENT_KEY_SETTING_MODE, false).mo10396b(activity, 9528);
        C0069g gVar = (C0069g) activity;
        this.bsw.m9844j(gVar);
        gVar.getLifecycle().mo152a(this.bsw);
        C3998h.m9883du("GDPR");
        return true;
    }
}
