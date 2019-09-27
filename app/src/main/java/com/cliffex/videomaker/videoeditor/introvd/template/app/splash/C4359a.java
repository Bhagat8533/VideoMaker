package com.introvd.template.app.splash;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.app.ads.C3712c;
import com.introvd.template.app.model.SplashItemInfo;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7592b;

/* renamed from: com.introvd.template.app.splash.a */
class C4359a {
    private static volatile C4359a bEv;
    private String bEw = "";

    private C4359a() {
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: Qc */
    public static C4359a m10939Qc() {
        if (bEv == null) {
            synchronized (C4359a.class) {
                try {
                    if (bEv == null) {
                        bEv = new C4359a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return bEv;
    }

    /* renamed from: Qh */
    private String m10940Qh() {
        String str = "3";
        String str2 = "3";
        if (mo24416Qg()) {
            String str3 = "5";
            str2 = "5";
        }
        return str2;
    }

    /* renamed from: cJ */
    private View m10941cJ(Context context) {
        return mo24416Qg() ? C7589a.getAdView(context, 44) : C7589a.m22362gm(context);
    }

    /* renamed from: Qd */
    public SplashItemInfo mo24413Qd() {
        SplashItemInfo splashItemInfo = new SplashItemInfo();
        splashItemInfo.mStayTime = m10940Qh();
        String str = "AD";
        splashItemInfo.mTitle = "AD";
        return splashItemInfo;
    }

    /* renamed from: Qe */
    public void mo24414Qe() {
        if (TextUtils.isEmpty(this.bEw)) {
            String str = "klsadpApsShS__";
            C4386g.m11043R("Ad_Splash_Skip", this.bEw);
        }
    }

    /* renamed from: Qf */
    public int mo24415Qf() {
        if (mo24416Qg()) {
            return 44;
        }
        return C7589a.aAa();
    }

    /* renamed from: Qg */
    public boolean mo24416Qg() {
        return AdParamMgr.getAdType(44) == 5;
    }

    /* renamed from: a */
    public void mo24417a(Context context, ViewAdsListener viewAdsListener) {
        C3712c.m9010HP().mo23064HQ();
        if (!C8049f.aBf().aBm()) {
            if (C7589a.m22362gm(context) == null) {
                C7589a.m22361gl(context);
            }
            C7589a.m22359a(viewAdsListener);
            C7589a.m22360aj(context, 44);
            C7589a.m22363h(44, viewAdsListener);
        }
    }

    /* renamed from: a */
    public boolean mo24418a(Context context, ViewGroup viewGroup) {
        String str;
        View cJ = m10941cJ(context);
        if (cJ == null || viewGroup == null) {
            this.bEw = null;
        } else {
            int childCount = viewGroup.getChildCount() - 1;
            this.bEw = C7591a.m22370W(cJ.getTag());
            int Qf = m10939Qc().mo24415Qf();
            if (Qf == 44) {
                String str2 = "ho_maSSs_hpN_lwdC";
                C4386g.m11043R("Ad_Splash_CN_Show", C7591a.m22370W(Integer.valueOf(21)));
            } else {
                String str3 = "sAopo_SSh_awhd";
                C4386g.m11043R("Ad_Splash_Show", this.bEw);
            }
            if (AppStateModel.getInstance().isInChina()) {
                str = String.valueOf(Qf);
            } else {
                String str4 = "SpwsSbloAdhah_";
                str = "Ad_Splash_Show";
            }
            C7592b.m22379F(context, str, this.bEw);
            if (childCount < 0) {
                childCount = 0;
            }
            viewGroup.addView(cJ, childCount);
        }
        return cJ != null;
    }
}
