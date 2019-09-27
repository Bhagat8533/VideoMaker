package com.introvd.template.ads.client.strategy;

import android.util.SparseBooleanArray;
import com.introvd.template.ads.ads.BaseAds;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.BaseAdListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public abstract class AdLoadStrategy<T extends BaseAds<U>, U extends BaseAdListener> implements BaseAdListener {
    protected AdsCreator<T, U> adsCreator;
    protected SparseBooleanArray isOverArray = new SparseBooleanArray();

    /* renamed from: com.introvd.template.ads.client.strategy.AdLoadStrategy$a */
    private class C3609a implements InvocationHandler {
        private U bgO;

        C3609a(U u) {
            this.bgO = u;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("onAdLoaded".equals(method.getName())) {
                    AdLoadStrategy.this.onAdLoaded(objArr[0], objArr[1].booleanValue(), String.valueOf(objArr[2]));
                }
                return method.invoke(this.bgO, objArr);
            } catch (UndeclaredThrowableException e) {
                throw e.getCause();
            }
        }
    }

    public abstract void handleAdsLoad(int i, AdStrategyResultListener adStrategyResultListener);

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
    }

    public void setAdsCreator(final AdsCreator<T, U> adsCreator2) {
        this.adsCreator = new AdsCreator<T, U>() {
            public T provideAds(int i, int i2) {
                T provideAds = adsCreator2.provideAds(i, i2);
                if (provideAds == null) {
                    return null;
                }
                if (provideClientListenerType() == null) {
                    return provideAds;
                }
                BaseAdListener provideClientListener = provideClientListener();
                if (provideClientListener == null) {
                    return provideAds;
                }
                provideAds.setAdListener((BaseAdListener) Proxy.newProxyInstance(provideClientListenerType().getClassLoader(), new Class[]{provideClientListenerType()}, new C3609a(provideClientListener)));
                return provideAds;
            }

            public U provideAppListener() {
                return adsCreator2.provideAppListener();
            }

            public U provideClientListener() {
                return adsCreator2.provideClientListener();
            }

            public Class<U> provideClientListenerType() {
                return adsCreator2.provideClientListenerType();
            }
        };
    }
}
