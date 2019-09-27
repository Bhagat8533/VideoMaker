package com.introvd.template.ads.ads;

public abstract class AbsInterstitialAds implements InterstitialAds {
    /* access modifiers changed from: protected */
    public abstract void doShowAdAction();

    public boolean isValid() {
        return true;
    }

    public boolean showAd() {
        boolean isAdAvailable = isAdAvailable();
        if (isAdAvailable) {
            doShowAdAction();
        }
        return isAdAvailable;
    }
}
