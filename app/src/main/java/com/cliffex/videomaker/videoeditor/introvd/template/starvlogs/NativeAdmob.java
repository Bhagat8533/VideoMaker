package com.introvd.template.starvlogs;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.introvd.base.utlisads.AdsConfig;

public class NativeAdmob {
    public static UnifiedNativeAd nativeAd;

    public static void populateUnifiedNativeAdView(Activity activity, UnifiedNativeAd nativeAd2, UnifiedNativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(ToolsUtils.findViewId(activity, "ad_media")));
        adView.setHeadlineView(adView.findViewById(ToolsUtils.findViewId(activity, "ad_headline")));
        adView.setBodyView(adView.findViewById(ToolsUtils.findViewId(activity, "ad_body")));
        adView.setCallToActionView(adView.findViewById(ToolsUtils.findViewId(activity, "ad_call_to_action")));
        adView.setIconView(adView.findViewById(ToolsUtils.findViewId(activity, "ad_app_icon")));
        adView.setPriceView(adView.findViewById(ToolsUtils.findViewId(activity, "ad_price")));
        adView.setStarRatingView(adView.findViewById(ToolsUtils.findViewId(activity, "ad_stars")));
        adView.setStoreView(adView.findViewById(ToolsUtils.findViewId(activity, "ad_store")));
        adView.setAdvertiserView(adView.findViewById(ToolsUtils.findViewId(activity, "ad_advertiser")));
        ((TextView) adView.getHeadlineView()).setText(nativeAd2.getHeadline());
        if (nativeAd2.getBody() == null) {
            adView.getBodyView().setVisibility(4);
        } else {
            adView.getBodyView().setVisibility(0);
            ((TextView) adView.getBodyView()).setText(nativeAd2.getBody());
        }
        if (nativeAd2.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(4);
        } else {
            adView.getCallToActionView().setVisibility(0);
            ((Button) adView.getCallToActionView()).setText(nativeAd2.getCallToAction());
        }
        if (nativeAd2.getIcon() == null) {
            adView.getIconView().setVisibility(8);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd2.getIcon().getDrawable());
            adView.getIconView().setVisibility(0);
        }
        if (nativeAd2.getPrice() == null) {
            adView.getPriceView().setVisibility(4);
        } else {
            adView.getPriceView().setVisibility(0);
            ((TextView) adView.getPriceView()).setText(nativeAd2.getPrice());
        }
        if (nativeAd2.getStore() == null) {
            adView.getStoreView().setVisibility(4);
        } else {
            adView.getStoreView().setVisibility(0);
            ((TextView) adView.getStoreView()).setText(nativeAd2.getStore());
        }
        if (nativeAd2.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(4);
        } else {
            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd2.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(0);
        }
        if (nativeAd2.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(4);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd2.getAdvertiser());
            adView.getAdvertiserView().setVisibility(0);
        }
        adView.setNativeAd(nativeAd2);
        VideoController vc = nativeAd2.getVideoController();
        if (vc.hasVideoContent()) {
            vc.setVideoLifecycleCallbacks(new VideoLifecycleCallbacks() {
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        }
    }

    public static void refreshAd(final Activity activity) {
        Builder builder = new Builder((Context) activity, AdsConfig.nativeAdmodb);
        builder.forUnifiedNativeAd(new OnUnifiedNativeAdLoadedListener() {
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                if (NativeAdmob.nativeAd != null) {
                    NativeAdmob.nativeAd.destroy();
                }
                NativeAdmob.nativeAd = unifiedNativeAd;
                FrameLayout frameLayout = (FrameLayout) activity.findViewById(ToolsUtils.findViewId(activity, "fl_adplaceholder"));
                UnifiedNativeAdView adView = (UnifiedNativeAdView) activity.getLayoutInflater().inflate(ToolsUtils.getIdLayout(activity, "ad_unified"), null);
                NativeAdmob.populateUnifiedNativeAdView(activity, unifiedNativeAd, adView);
                frameLayout.removeAllViews();
                frameLayout.addView(adView);
            }
        });
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(int errorCode) {
            }
        }).build().loadAd(new AdRequest.Builder().build());
    }
}
