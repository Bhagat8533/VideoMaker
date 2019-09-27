package com.introvd.template.ads;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.introvd.template.ads.ads.AbsBannerAds;
import com.introvd.template.ads.ads.AbsInterstitialAds;
import com.introvd.template.ads.ads.AbsNativeAds;
import com.introvd.template.ads.ads.AbsNativeBannerAds;
import com.introvd.template.ads.ads.AbsVideoAds;
import com.introvd.template.ads.utils.VivaAdLog;
import java.util.List;

public abstract class AbsAdGlobalMgr {
    /* access modifiers changed from: private */
    public static final String TAG = "AbsAdGlobalMgr";
    private static final SparseArray<AdSdk> bgw = new SparseArray<>();

    public static abstract class AdSdk {
        /* access modifiers changed from: private */
        public int providerOrder;

        public AbsBannerAds getBannerAds(Context context, int i) {
            return null;
        }

        public AbsInterstitialAds getInterstitialAds(Context context, int i) {
            return null;
        }

        public AbsBannerAds getMediumAds(Context context, int i) {
            return null;
        }

        public AbsNativeAds getNativeAds(Context context, int i) {
            return null;
        }

        public AbsNativeBannerAds getNativeBannerAds(Context context, int i) {
            return null;
        }

        public AbsBannerAds getSplashAds(Context context, int i) {
            return null;
        }

        public AbsVideoAds getVideoAds(Activity activity, int i) {
            return null;
        }

        /* access modifiers changed from: protected */
        public void initSdk(Activity activity) {
            initSdk(activity.getApplicationContext());
        }

        /* access modifiers changed from: protected */
        public void initSdk(Context context) {
        }
    }

    /* renamed from: com.introvd.template.ads.AbsAdGlobalMgr$a */
    private interface C3586a<U> {
        /* renamed from: a */
        void mo22866a(U u, AdSdk adSdk);
    }

    /* renamed from: a */
    private <T> void m8809a(T t, List<AdSdk> list, C3586a<T> aVar) {
        if (list == null || list.isEmpty()) {
            VivaAdLog.m8847e(TAG, "init null sdk");
            return;
        }
        for (AdSdk adSdk : list) {
            if (adSdk != null && bgw.indexOfKey(adSdk.providerOrder) > -1) {
                aVar.mo22866a(t, adSdk);
            }
        }
    }

    public static AdSdk getAdSdk(int i) {
        return (AdSdk) bgw.get(i);
    }

    /* access modifiers changed from: protected */
    public List<AdSdk> getSdkListInOthers() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract List<AdSdk> getSdkListInitInApplication();

    /* access modifiers changed from: protected */
    public abstract List<AdSdk> getSdkListInitInMainActivity();

    public void initSdkInApplication(Context context) {
        m8809a(context, getSdkListInitInApplication(), new C3586a<Context>() {
            /* renamed from: a */
            public void mo22866a(Context context, AdSdk adSdk) {
                try {
                    adSdk.initSdk(context);
                } catch (Throwable th) {
                    String access$000 = AbsAdGlobalMgr.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("application_init_error:");
                    sb.append(th.getMessage());
                    VivaAdLog.m8847e(access$000, sb.toString());
                }
                String access$0002 = AbsAdGlobalMgr.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("application_init:");
                sb2.append(adSdk.getClass().getSimpleName());
                VivaAdLog.m8847e(access$0002, sb2.toString());
            }
        });
    }

    public void initSdkInLauncherActivity(Activity activity) {
        m8809a(activity, getSdkListInitInMainActivity(), new C3586a<Activity>() {
            /* renamed from: a */
            public void mo22866a(Activity activity, AdSdk adSdk) {
                try {
                    adSdk.initSdk(activity);
                } catch (Throwable th) {
                    String access$000 = AbsAdGlobalMgr.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("activity_init_error:");
                    sb.append(th.getMessage());
                    VivaAdLog.m8847e(access$000, sb.toString());
                }
                String access$0002 = AbsAdGlobalMgr.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("activity_init:");
                sb2.append(adSdk.getClass().getSimpleName());
                VivaAdLog.m8847e(access$0002, sb2.toString());
            }
        });
    }

    public void initSdkInOthers(Activity activity) {
        m8809a(activity, getSdkListInOthers(), new C3586a<Activity>() {
            /* renamed from: a */
            public void mo22866a(Activity activity, AdSdk adSdk) {
                try {
                    adSdk.initSdk(activity);
                } catch (Throwable th) {
                    String access$000 = AbsAdGlobalMgr.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("others_init_error:");
                    sb.append(th.getMessage());
                    VivaAdLog.m8847e(access$000, sb.toString());
                }
                String access$0002 = AbsAdGlobalMgr.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("others_init:");
                sb2.append(adSdk.getClass().getSimpleName());
                VivaAdLog.m8847e(access$0002, sb2.toString());
            }
        });
    }
}
