package com.introvd.template.template.p400a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7592b;
import com.introvd.template.router.p377ad.AdServiceProxy;
import com.introvd.template.sdk.p383c.C8399c;
import java.util.HashMap;

/* renamed from: com.introvd.template.template.a.b */
public class C8624b {
    /* access modifiers changed from: private */
    public int bgQ = -1;
    /* access modifiers changed from: private */
    public View cSw;
    private int diS = -1;
    private String ekf;
    /* access modifiers changed from: private */
    public boolean ekg = false;
    /* access modifiers changed from: private */
    public Context mContext;

    public C8624b(Context context, String str) {
        this.mContext = context;
        this.ekf = str;
    }

    /* renamed from: a */
    public void mo34924a(final C8623a aVar) {
        if (!TextUtils.isEmpty(this.ekf)) {
            this.bgQ = -1;
            if (C8399c.ecX.equals(this.ekf)) {
                this.bgQ = 4;
                int positionInGroup = AdParamMgr.getPositionInGroup(this.bgQ);
                if (positionInGroup < 1) {
                    positionInGroup = 1;
                }
                this.diS = positionInGroup;
            }
            C7680l.aAe().mo32531h(this.bgQ, new ViewAdsListener() {
                public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                    if (z) {
                        View adView = C7680l.aAe().getAdView(C8624b.this.mContext, C8624b.this.bgQ);
                        if (!(adView == null || adView == C8624b.this.cSw)) {
                            C8624b.this.ekg = false;
                        }
                        C8624b.this.cSw = adView;
                    }
                    if (aVar != null) {
                        aVar.mo34923jz(z);
                    }
                }
            });
            C7680l.aAe().mo32526aj(this.mContext, this.bgQ);
        }
    }

    public void aKh() {
        if (C7680l.aAe().getAdView(this.mContext, this.bgQ) == null) {
            C7680l.aAe().mo32526aj(this.mContext, this.bgQ);
        }
    }

    public boolean aKi() {
        return this.ekg;
    }

    public View getAdView() {
        return this.cSw;
    }

    /* renamed from: jA */
    public void mo34928jA(boolean z) {
        this.ekg = z;
    }

    /* renamed from: jB */
    public void mo34929jB(boolean z) {
        String str;
        String str2;
        String str3 = "unknown";
        String str4 = null;
        if (C8399c.ecX.equals(this.ekf)) {
            str4 = "Ad_New_Theme_Show";
            str2 = "Ad_New_Theme_Click";
            str = "new_theme";
        } else {
            str = str3;
            str2 = null;
        }
        if (!z) {
            str2 = str4;
        }
        if (!TextUtils.isEmpty(str2) && this.cSw != null) {
            HashMap hashMap = new HashMap();
            String str5 = (String) AdServiceProxy.execute(AdServiceProxy.getAdProvider, this.cSw.getTag());
            hashMap.put("platform", str5);
            if (!z) {
                hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, AppPreferencesSetting.getInstance().getAppSettingStr("template_ad_from", "unknown"));
                C7592b.m22379F(this.mContext, str2, str5);
            } else {
                C7592b.m22380G(this.mContext, str, str5);
            }
            UserBehaviorLog.onKVEvent(this.mContext, str2, hashMap);
        }
    }
}
