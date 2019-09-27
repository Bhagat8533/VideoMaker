package com.introvd.template.ads.versionhelper;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.support.p021v4.app.FragmentActivity;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.PlacementIdProvider;
import com.introvd.template.ads.spaceline.XYSPASdkMgr;
import com.introvd.template.ads.utils.VivaAdLog;
import com.introvd.template.ads.views.AdViewInflater;
import com.introvd.template.ads.xyadm.XYADMSdkMgr;
import com.introvd.template.ads.xyalt.XYALTSdkMgr;
import com.introvd.template.ads.xybai.XYBAISdkMgr;
import com.introvd.template.ads.xybat.XYBATSdkMgr;
import com.introvd.template.ads.xyfac.XYFACSdkMgr;
import com.introvd.template.ads.xyint.XYINTManager;
import com.introvd.template.ads.xyint.XYINTSdkMgr;
import com.introvd.template.ads.xymob.XYMOBSdkMgr;
import com.introvd.template.ads.xymop.XYMOPSdkMgr;
import com.introvd.template.ads.xypin.XYPINSdkMgr;
import com.introvd.template.ads.xyyea.XYYEASdkMgr;

public final class AdsVersionHelper {
    private static final String TAG = "AdsVersionHelper";

    public static boolean canLoadNextAd(String str) {
        try {
            return XYINTSdkMgr.canLoadNextAd(str);
        } catch (Throwable th) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("can XYINT load: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str2, sb.toString());
            return false;
        }
    }

    public static AdSdk getXYADMAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater, Bundle bundle) {
        try {
            return new XYADMSdkMgr(i, placementIdProvider, adViewInflater, bundle);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Get XYADM manager: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static AdSdk getXYALTAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater, Bundle bundle) {
        try {
            return new XYALTSdkMgr(i, placementIdProvider, adViewInflater);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Get XYALT manager: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static AdSdk getXYBAIAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater, Bundle bundle) {
        try {
            return new XYBAISdkMgr(i, placementIdProvider, adViewInflater);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Get XYBAI manager: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static AdSdk getXYBATAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater, Bundle bundle) {
        try {
            return new XYBATSdkMgr(i, placementIdProvider, adViewInflater, bundle);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Get XYBAT: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static AdSdk getXYFACAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater, Bundle bundle) {
        try {
            return new XYFACSdkMgr(i, placementIdProvider, adViewInflater);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("GET XYFAC manager: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static AdSdk getXYINTAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater, Bundle bundle) {
        try {
            return new XYINTSdkMgr(i, placementIdProvider);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("GET XYINT manager: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static AdSdk getXYMOBAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater, Bundle bundle) {
        try {
            return new XYMOBSdkMgr(i, placementIdProvider, adViewInflater, bundle);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Get XYMOB: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static AdSdk getXYMOPAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater, Bundle bundle) {
        try {
            return new XYMOPSdkMgr(i, placementIdProvider, adViewInflater, bundle);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Get XYMOP manager: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static AdSdk getXYPINAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater, Bundle bundle) {
        try {
            return new XYPINSdkMgr(i, placementIdProvider, adViewInflater);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("GET XYPIN manager: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static AdSdk getXYSPAAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater) {
        try {
            return new XYSPASdkMgr(i, placementIdProvider, adViewInflater);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Get XYSPA manager: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static AdSdk getXYYEAAdSdk(int i, PlacementIdProvider placementIdProvider, AdViewInflater adViewInflater, Bundle bundle) {
        try {
            return new XYYEASdkMgr(i);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("GET XYYEA manager: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
            return null;
        }
    }

    public static void grantXYALT(Context context, boolean z) {
        try {
            XYALTSdkMgr.enableSdk(context, z);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Grant XYALT: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
        }
    }

    public static void grantXYBAT(Context context, boolean z) {
        try {
            XYBATSdkMgr.grantSdk(context, z);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Grant XYBAT: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
        }
    }

    public static void grantXYYEA(Context context, boolean z) {
        try {
            XYYEASdkMgr.grantSdk(context, z);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Grant XYYEA manager: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
        }
    }

    public static void prepareLoad(Context context, String str) {
        try {
            XYINTSdkMgr.prepareLoad(context, str);
        } catch (Throwable th) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("prepare XYINT load: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str2, sb.toString());
        }
    }

    public static void registerXYINTSdk(FragmentActivity fragmentActivity, OnDismissListener onDismissListener, OnShowListener onShowListener) {
        try {
            XYINTManager.registerIntowowSdk(fragmentActivity, onDismissListener, onShowListener);
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("REGISTER XYINT: ");
            sb.append(th.getMessage());
            VivaAdLog.m8847e(str, sb.toString());
        }
    }
}
