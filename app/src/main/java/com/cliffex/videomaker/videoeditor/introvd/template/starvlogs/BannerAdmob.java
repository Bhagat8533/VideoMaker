package com.introvd.template.starvlogs;

import android.app.Activity;
import android.util.Log;
import android.widget.LinearLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.introvd.base.utlisads.AdsConfig;

public class BannerAdmob {
    public static void setupDataBannerAdmob(Activity activity) {
        final LinearLayout ll = (LinearLayout) activity.findViewById(ToolsUtils.findViewId(activity, "banner_container_gg"));
        AdView adView = new AdView(activity);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(AdsConfig.bannerAdsmob1);
        ll.addView(adView);
        Log.d("setupDataBannerAdmob", "setupDataBannerAdmob");
        AdRequest adRequest = new Builder().build();
        adView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                ll.setVisibility(0);
                Log.d("setupDataBannerAdmob", "onAdLoaded");
            }

            public void onAdFailedToLoad(int errorCode) {
                Log.d("setupDataBannerAdmob", "onAdFailedToLoad");
            }

            public void onAdOpened() {
                Log.d("setupDataBannerAdmob", "onAdOpened");
            }

            public void onAdLeftApplication() {
                Log.d("setupDataBannerAdmob", "onAdLeftApplication");
            }

            public void onAdClosed() {
                Log.d("setupDataBannerAdmob", "onAdClosed");
            }
        });
        adView.loadAd(adRequest);
    }

    public static void setupDataBannerAdmob2(Activity activity) {
        final LinearLayout ll = (LinearLayout) activity.findViewById(ToolsUtils.findViewId(activity, "banner_container"));
        AdView adView = new AdView(activity);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(AdsConfig.bannerAdsmob2);
        ll.addView(adView);
        Log.d("setupDataBannerAdmob", "setupDataBannerAdmob");
        AdRequest adRequest = new Builder().build();
        adView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                ll.setVisibility(0);
                Log.d("setupDataBannerAdmob", "onAdLoaded");
            }

            public void onAdFailedToLoad(int errorCode) {
                Log.d("setupDataBannerAdmob", "onAdFailedToLoad");
            }

            public void onAdOpened() {
                Log.d("setupDataBannerAdmob", "onAdOpened");
            }

            public void onAdLeftApplication() {
                Log.d("setupDataBannerAdmob", "onAdLeftApplication");
            }

            public void onAdClosed() {
                Log.d("setupDataBannerAdmob", "onAdClosed");
            }
        });
        adView.loadAd(adRequest);
    }
}
