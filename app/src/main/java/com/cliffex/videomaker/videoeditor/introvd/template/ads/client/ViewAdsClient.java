package com.introvd.template.ads.client;

import android.content.Context;
import android.view.View;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.ads.ViewAds;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import java.util.Iterator;

public abstract class ViewAdsClient extends BaseAdClient<ViewAds, ViewAdsListener> implements ViewAdsListener {
    ViewAdsClient(int i) {
        super(i);
    }

    @Deprecated
    public View getAdView(Context context, int i) {
        Iterator it = AdParamMgr.getProviderList(i).iterator();
        View view = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ViewAds viewAds = (ViewAds) getAdsFromCache(i, ((Integer) it.next()).intValue());
            if (viewAds != null) {
                view = viewAds.getAdView();
                if (view != null) {
                    view.setTag(viewAds.getAdFlag());
                    break;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: protected */
    public ViewAdsListener getExtendAdListener() {
        return this;
    }

    /* access modifiers changed from: protected */
    public Class<ViewAdsListener> getExtendAdListenerType() {
        return ViewAdsListener.class;
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
        informAction(z ? 1 : 2, adPositionInfoParam.position, String.valueOf(adPositionInfoParam.providerOrder));
    }
}
