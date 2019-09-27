package com.introvd.template.module.p326ad;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.BadTokenException;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.PinkiePie;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.client.BannerAdsClient;
import com.introvd.template.ads.client.InterstitialAdsClient;
import com.introvd.template.ads.client.MediumAdsClient;
import com.introvd.template.ads.client.NativeAdsClient;
import com.introvd.template.ads.client.NativeBannerAdsClient;
import com.introvd.template.ads.client.SplashAdsClient;
import com.introvd.template.ads.client.VideoAdsClient;
import com.introvd.template.ads.listener.InterstitialAdsListener;
import com.introvd.template.ads.listener.RealAdActionListener;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.ads.utils.VivaAdLog;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p332f.C7641a;
import com.introvd.template.module.p326ad.p334h.C7661b;
import com.introvd.template.module.p326ad.p337i.C7668b;
import com.introvd.template.router.iap.IapServiceProxy;
import com.introvd.template.router.kiwi.LDPProtect;
import com.p131c.p132a.C2561a;

@LDPProtect
/* renamed from: com.introvd.template.module.ad.m */
class C7682m {
    private static final String TAG = "m";
    private static NativeAdsClient dMo = NativeAdsClient.getInstance();
    private static BannerAdsClient dMp = BannerAdsClient.getInstance();
    private static MediumAdsClient dMq = MediumAdsClient.getInstance();
    private static InterstitialAdsClient dMr = InterstitialAdsClient.getInstance();
    private static VideoAdsClient dMs = VideoAdsClient.getInstance();
    private static NativeBannerAdsClient dMt = NativeBannerAdsClient.getInstance();
    private static SplashAdsClient dMu = SplashAdsClient.getInstance();
    private static RealAdActionListener dMv = new RealAdActionListener() {
        public void onDoAction(int i, int i2, String str) {
            C7591a.m22372d(i, i2, str);
        }
    };

    static {
        dMo.setAdRealActionListener(dMv);
        dMp.setAdRealActionListener(dMv);
        dMq.setAdRealActionListener(dMv);
        dMr.setAdRealActionListener(dMv);
        dMs.setAdRealActionListener(dMv);
        dMt.setAdRealActionListener(dMv);
        dMu.setAdRealActionListener(dMv);
    }

    C7682m() {
    }

    /* renamed from: a */
    private static View m22533a(Context context, int i, View view) {
        int i2;
        ViewGroup viewGroup;
        if (view == 0) {
            return null;
        }
        if (3 != i && 2 != i && 32 != i) {
            return view;
        }
        if (i == 2) {
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.fl_close);
            i2 = R.id.nativeAdIcon;
            r9 = view;
            viewGroup = viewGroup2;
        } else if (i == 3) {
            ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.rl_draft_grid_root);
            i2 = R.id.rl_ad_container;
            r9 = view;
            viewGroup = viewGroup3;
        } else {
            ViewGroup relativeLayout = new RelativeLayout(context);
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            int P = C7661b.m22483P(4.0f);
            int P2 = C7661b.m22483P(9.5f);
            int P3 = C7661b.m22483P(15.0f);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(P);
                layoutParams.topMargin = P2;
                layoutParams.setMarginEnd(P3);
                layoutParams.bottomMargin = P3;
            } else {
                layoutParams.setMargins(P, P2, P3, P3);
            }
            relativeLayout.addView(view, layoutParams);
            i2 = R.id.layout_main_container;
            r9 = relativeLayout;
            viewGroup = relativeLayout;
        }
        View g = C7668b.m22494g(context, i, i2);
        if (g != null) {
            viewGroup.addView(g);
        }
        return r9;
    }

    /* renamed from: a */
    static void m22534a(Activity activity, int i, VideoRewardListener videoRewardListener) {
        if (!aAc() && 1 == AdParamMgr.getAdType(i)) {
            dMs.showVideoAds(activity, i, videoRewardListener);
        }
    }

    /* renamed from: a */
    static void m22535a(ViewAdsListener viewAdsListener) {
        int aAa = aAa();
        if (aAa == 47) {
            dMq.setAdListener(aAa, viewAdsListener);
        } else {
            dMo.setAdListener(aAa, viewAdsListener);
        }
    }

    static int aAa() {
        if (C7678j.aAd().isInChina()) {
            if (AdParamMgr.isAdConfigValid(38)) {
                return 38;
            }
            if (!AdParamMgr.isAdConfigValid(27) && AdParamMgr.isAdConfigValid(47)) {
                return 47;
            }
        } else if (AdParamMgr.isAdConfigValid(27)) {
            return 27;
        } else {
            if (AdParamMgr.isAdConfigValid(35)) {
                return 35;
            }
            if (AdParamMgr.isAdConfigValid(47)) {
                return 47;
            }
        }
        return 27;
    }

    static void aAb() {
        int aAa = aAa();
        if (aAa == 47) {
            dMq.releasePosition(aAa);
        } else {
            dMo.releasePosition(aAa);
        }
    }

    static boolean aAc() {
        if (!C7678j.aAd().isYoungerMode() && !C2561a.aOS()) {
            return ((Boolean) IapServiceProxy.execute(IapServiceProxy.isPurchasedAd, new Object[0])).booleanValue();
        }
        return true;
    }

    /* renamed from: aj */
    static void m22536aj(Context context, int i) {
        if (!aAc() && !C7590b.m22368rQ(i)) {
            switch (AdParamMgr.getAdType(i)) {
                case 0:
                case 3:
                    NativeAdsClient nativeAdsClient = dMo;
                    PinkiePie.DianePie();
                    break;
                case 1:
                    if (context instanceof Activity) {
                        VideoAdsClient videoAdsClient = dMs;
                        PinkiePie.DianePie();
                        break;
                    }
                    break;
                case 2:
                    try {
                        InterstitialAdsClient interstitialAdsClient = dMr;
                        PinkiePie.DianePie();
                        break;
                    } catch (IllegalStateException e) {
                        C7678j.aAd().logException(e);
                        break;
                    }
                case 4:
                    BannerAdsClient bannerAdsClient = dMp;
                    PinkiePie.DianePie();
                    break;
                case 5:
                    SplashAdsClient splashAdsClient = dMu;
                    PinkiePie.DianePie();
                    break;
                case 7:
                    NativeBannerAdsClient nativeBannerAdsClient = dMt;
                    PinkiePie.DianePie();
                    break;
                case 8:
                    MediumAdsClient mediumAdsClient = dMq;
                    PinkiePie.DianePie();
                    break;
            }
        }
    }

    /* renamed from: ak */
    static void m22537ak(Context context, int i) {
        if (!aAc() && !C7590b.m22368rQ(i) && 2 == AdParamMgr.getAdType(i)) {
            try {
                InterstitialAdsClient interstitialAdsClient = dMr;
                PinkiePie.DianePie();
            } catch (BadTokenException | IllegalStateException e) {
                C7678j.aAd().logException(e);
            }
        }
    }

    static View getAdView(Context context, int i) {
        View view = null;
        if (aAc() || C7590b.m22368rQ(i)) {
            return null;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        switch (AdParamMgr.getAdType(i)) {
            case 0:
            case 3:
                view = dMo.getAdView(context, i);
                break;
            case 4:
                view = dMp.getAdView(context, i);
                break;
            case 5:
                view = dMu.getAdView(context, i);
                break;
            case 7:
                view = dMt.getAdView(context, i);
                break;
            case 8:
                view = dMq.getAdView(context, i);
                break;
        }
        return m22533a(context, i, view);
    }

    /* renamed from: gl */
    static void m22538gl(Context context) {
        if (aAa() == 47) {
            MediumAdsClient mediumAdsClient = dMq;
            PinkiePie.DianePie();
            return;
        }
        NativeAdsClient nativeAdsClient = dMo;
        PinkiePie.DianePie();
    }

    /* renamed from: gm */
    static View m22539gm(Context context) {
        if (aAc()) {
            return null;
        }
        int aAa = aAa();
        return aAa == 47 ? C7641a.m22445go(context) : dMo.getAdView(context, aAa);
    }

    /* renamed from: h */
    static void m22540h(int i, Object obj) {
        if (!aAc() && !C7590b.m22368rQ(i)) {
            switch (AdParamMgr.getAdType(i)) {
                case 0:
                case 3:
                    dMo.setAdListener(i, (ViewAdsListener) obj);
                    break;
                case 1:
                    dMs.setAdListener(i, (VideoAdsListener) obj);
                    break;
                case 2:
                    dMr.setAdListener(i, (InterstitialAdsListener) obj);
                    break;
                case 4:
                    dMp.setAdListener(i, (ViewAdsListener) obj);
                    break;
                case 5:
                    dMu.setAdListener(i, (ViewAdsListener) obj);
                    break;
                case 7:
                    dMt.setAdListener(i, (ViewAdsListener) obj);
                    break;
                case 8:
                    try {
                        dMq.setAdListener(i, (ViewAdsListener) obj);
                        break;
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(TAG);
                        sb.append("===");
                        VivaAdLog.m8847e(sb.toString(), e.getMessage());
                        break;
                    }
            }
        }
    }

    static boolean isAdAvailable(Context context, int i) {
        boolean z = false;
        if (aAc() || C7590b.m22368rQ(i)) {
            return false;
        }
        switch (AdParamMgr.getAdType(i)) {
            case 0:
            case 3:
                z = dMo.isAdAvailable(i);
                break;
            case 1:
                if (context instanceof Activity) {
                    z = dMs.isAdAvailable(i);
                    break;
                }
                break;
            case 2:
                z = dMr.isAdAvailable(i);
                break;
            case 4:
                z = dMp.isAdAvailable(i);
                break;
            case 5:
                z = dMu.isAdAvailable(i);
                break;
            case 7:
                z = dMt.isAdAvailable(i);
                break;
            case 8:
                z = dMq.isAdAvailable(i);
                break;
        }
        return z;
    }

    /* renamed from: rS */
    static void m22541rS(int i) {
        dMp.releaseAds(i);
    }

    static void releasePosition(int i) {
        releasePosition(i, true);
    }

    static void releasePosition(int i, boolean z) {
        switch (AdParamMgr.getAdType(i)) {
            case 0:
            case 3:
                dMo.releasePosition(i, z);
                return;
            case 1:
                dMs.releasePosition(i, z);
                return;
            case 2:
                dMr.releasePosition(i, z);
                return;
            case 4:
                dMp.releasePosition(i, z);
                return;
            case 5:
                dMu.releasePosition(i, z);
                return;
            case 7:
                dMt.releasePosition(i, z);
                return;
            case 8:
                try {
                    dMq.releasePosition(i, z);
                    return;
                } catch (Exception unused) {
                    return;
                }
            default:
                return;
        }
    }
}
