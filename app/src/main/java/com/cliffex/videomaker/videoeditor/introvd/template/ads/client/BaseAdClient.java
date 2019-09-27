package com.introvd.template.ads.client;

import android.content.Context;
import android.util.SparseArray;
import com.introvd.template.ads.AbsAdGlobalMgr;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.ads.BaseAds;
import com.introvd.template.ads.client.strategy.AdLoadStrategy;
import com.introvd.template.ads.client.strategy.AdStrategyResultListener;
import com.introvd.template.ads.client.strategy.AdsCreator;
import com.introvd.template.ads.client.strategy.LoadStrategyFactory;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.BaseAdListener;
import com.introvd.template.ads.listener.RealAdActionListener;
import com.introvd.template.ads.utils.VivaAdLog;

public abstract class BaseAdClient<T extends BaseAds<U>, U extends BaseAdListener> {
    protected final int adType;
    private final SparseArray<SparseArray<T>> bgB = new SparseArray<>();
    private final SparseArray<U> bgC = new SparseArray<>();
    private RealAdActionListener bgD;

    /* renamed from: com.introvd.template.ads.client.BaseAdClient$a */
    private interface C3595a<T> {
        /* renamed from: L */
        void mo22912L(T t);
    }

    BaseAdClient(int i) {
        this.adType = i;
    }

    /* renamed from: a */
    private SparseArray<T> m8822a(int i, C3595a<T> aVar) {
        SparseArray<T> gd = m8826gd(i);
        int size = gd.size();
        for (int i2 = 0; i2 < size; i2++) {
            BaseAds baseAds = (BaseAds) gd.get(gd.keyAt(i2));
            if (!(baseAds == null || aVar == null)) {
                aVar.mo22912L(baseAds);
            }
        }
        return gd;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8824a(int i, int i2, T t) {
        m8826gd(i).put(i2, t);
    }

    /* renamed from: gd */
    private SparseArray<T> m8826gd(int i) {
        SparseArray<T> sparseArray = (SparseArray) this.bgB.get(i);
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<T> sparseArray2 = new SparseArray<>();
        this.bgB.put(i, sparseArray2);
        return sparseArray2;
    }

    /* access modifiers changed from: private */
    /* renamed from: ge */
    public U m8827ge(int i) {
        return (BaseAdListener) this.bgC.get(i);
    }

    /* access modifiers changed from: protected */
    public U getAdListener(AdPositionInfoParam adPositionInfoParam) {
        return m8827ge(adPositionInfoParam.position);
    }

    /* access modifiers changed from: protected */
    public abstract T getAds(Context context, AdSdk adSdk, int i);

    /* access modifiers changed from: protected */
    public T getAdsFromCache(int i, int i2) {
        return (BaseAds) m8826gd(i).get(i2);
    }

    /* access modifiers changed from: protected */
    public abstract U getExtendAdListener();

    /* access modifiers changed from: protected */
    public abstract Class<U> getExtendAdListenerType();

    /* access modifiers changed from: protected */
    public void informAction(int i, int i2, String str) {
        if (this.bgD != null) {
            this.bgD.onDoAction(i, i2, str);
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(i));
            sb.append("/");
            sb.append(String.valueOf(i2));
            sb.append("/");
            sb.append(str);
            VivaAdLog.m8847e("====inform", sb.toString());
        }
    }

    public boolean isAdAvailable(int i) {
        return isAdAvailable(null, i);
    }

    @Deprecated
    public boolean isAdAvailable(Context context, int i) {
        boolean z = false;
        for (Integer intValue : AdParamMgr.getProviderList(i)) {
            BaseAds adsFromCache = getAdsFromCache(i, intValue.intValue());
            if (adsFromCache != null) {
                z = adsFromCache.isAdAvailable();
                if (z) {
                    break;
                }
            }
        }
        return z;
    }

    public void loadAds(final Context context, final int i) {
        AdLoadStrategy provideLoadStrategy = LoadStrategyFactory.provideLoadStrategy(i);
        provideLoadStrategy.setAdsCreator(new AdsCreator<T, U>() {
            public T provideAds(int i, int i2) {
                T adsFromCache = BaseAdClient.this.getAdsFromCache(i, i2);
                if (adsFromCache == null) {
                    AdSdk adSdk = AbsAdGlobalMgr.getAdSdk(i2);
                    if (adSdk == null) {
                        return null;
                    }
                    adsFromCache = BaseAdClient.this.getAds(context, adSdk, i);
                    if (adsFromCache != null) {
                        adsFromCache.setAdListener(provideClientListener());
                        BaseAdClient.this.m8824a(i, i2, adsFromCache);
                    }
                }
                return adsFromCache;
            }

            public U provideAppListener() {
                return BaseAdClient.this.m8827ge(i);
            }

            public U provideClientListener() {
                return BaseAdClient.this.getExtendAdListener();
            }

            public Class<U> provideClientListenerType() {
                return BaseAdClient.this.getExtendAdListenerType();
            }
        });
        provideLoadStrategy.handleAdsLoad(i, new AdStrategyResultListener() {
            public void onStrategyHandle(int i, String str) {
                BaseAdClient.this.informAction(i, i, str);
            }
        });
    }

    public void releasePosition(int i) {
        releasePosition(i, true);
    }

    public void releasePosition(final int i, boolean z) {
        LoadStrategyFactory.removeAdLoadStrategy(i);
        StringBuilder sb = new StringBuilder();
        sb.append("remove load strategy ");
        sb.append(i);
        VivaAdLog.m8847e("====release", sb.toString());
        removeAdListener(i);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("remove ad listener ");
        sb2.append(i);
        VivaAdLog.m8847e("====release", sb2.toString());
        if (!z) {
            m8822a(i, (C3595a<T>) new C3595a<T>() {
                /* renamed from: a */
                public void mo22912L(T t) {
                    t.setAdListener(BaseAdClient.this.getExtendAdListener());
                }
            });
            return;
        }
        m8822a(i, (C3595a<T>) new C3595a<T>() {
            /* renamed from: a */
            public void mo22912L(T t) {
                t.release();
                StringBuilder sb = new StringBuilder();
                sb.append("ads item release ");
                sb.append(i);
                sb.append("/");
                sb.append(t.getAdFlag());
                VivaAdLog.m8847e("====release", sb.toString());
            }
        }).clear();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("clear ads ");
        sb3.append(i);
        VivaAdLog.m8847e("====release", sb3.toString());
    }

    public void removeAdListener(int i) {
        this.bgC.remove(i);
    }

    public void setAdListener(int i, U u) {
        this.bgC.put(i, u);
    }

    public void setAdRealActionListener(RealAdActionListener realAdActionListener) {
        this.bgD = realAdActionListener;
    }
}
