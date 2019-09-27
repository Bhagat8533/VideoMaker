package com.introvd.template.router.p377ad;

import com.introvd.template.router.BizServiceManager;
import p037b.p050b.C1834l;

/* renamed from: com.introvd.template.router.ad.AdServiceProxy */
public class AdServiceProxy {
    public static final String flagInterstitial = "flagInterstitial";
    public static final String getAdPositionRewardVideo = "getAdPositionRewardVideo";
    public static final String getAdProvider = "getAdProvider";
    public static final String getAdView = "getAdView";
    public static final String getEncourageAdDialog = "getEncourageAdDialog";
    public static final String isAdAvailable = "isAdAvailable";
    public static final String loadAd = "loadAd";
    public static final String observableShowUnlockTemplate = "observableShowUnlockTemplate";
    public static final String recordAdTemplateClick = "recordAdTemplateClick";
    public static final String recordUnlockDialogClick = "recordUnlockDialogClick";
    public static final String releasePosition = "releasePosition";
    public static final String setAdListener = "setAdListener";
    public static final String setEncourageAdFromPrefix = "setEncourageAdFromPrefix";
    public static final String showVideoAd = "showVideoAd";

    public static Object execute(String str, Object... objArr) {
        IAdService iAdService = (IAdService) BizServiceManager.getService(IAdService.class);
        if (iAdService != null) {
            return iAdService.execute(str, objArr);
        }
        if (getAdProvider.equals(str) || getAdPositionRewardVideo.equals(str)) {
            return Integer.valueOf(-1);
        }
        if (isAdAvailable.equals(str)) {
            return Boolean.valueOf(false);
        }
        if (observableShowUnlockTemplate.equals(str)) {
            return C1834l.m5263w(new Exception("unknown"));
        }
        return null;
    }
}
