package com.introvd.template.app.ads;

import android.os.Bundle;
import android.util.SparseArray;
import com.introvd.template.C4681i;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.versionhelper.AdsVersionHelper;
import com.introvd.template.app.utils.C4390a;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.consent.gdpr.C5521b;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.p326ad.p329c.C7598a;
import com.introvd.template.module.p326ad.p329c.C7599b;
import com.introvd.template.module.p326ad.p331e.C7613f;
import com.introvd.template.module.p326ad.p331e.C7614g;
import com.introvd.template.module.p326ad.p331e.C7615h;
import com.introvd.template.module.p326ad.p331e.C7616i;
import com.introvd.template.module.p326ad.p331e.C7617j;
import com.introvd.template.module.p326ad.p331e.C7618k;
import com.introvd.template.module.p326ad.p331e.C7619l;
import com.introvd.template.module.p326ad.p331e.C7620m;
import com.introvd.template.module.p326ad.p331e.C7621n;
import com.introvd.template.module.p326ad.p331e.C7622o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.introvd.template.app.ads.d */
public class C3719d {
    /* renamed from: HT */
    private static List<AdSdk> m9021HT() {
        ArrayList arrayList = new ArrayList();
        VivaBaseApplication Gs = C4681i.m12184Gp().mo25017Gs();
        if (Gs != null) {
            Bundle bundle = new Bundle();
            bundle.putString("extra_app_id", Gs.getResources().getString(R.string.xymob_app_id));
            bundle.putString("extra_app_key", Gs.getResources().getString(R.string.xymob_app_key));
            arrayList.add(AdsVersionHelper.getXYMOBAdSdk(3, new C7619l(), new C7598a(), bundle));
            arrayList.add(AdsVersionHelper.getXYSPAAdSdk(22, new C7622o(), new C7598a()));
        }
        return arrayList;
    }

    /* renamed from: HU */
    static SparseArray<List<Integer>> m9022HU() {
        SparseArray<List<Integer>> sparseArray = new SparseArray<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(2));
        arrayList.addAll(Collections.singletonList(Integer.valueOf(7)));
        arrayList.addAll(C4390a.m11069bJ(9, 13));
        arrayList.addAll(C4390a.m11069bJ(15, 16));
        arrayList.addAll(Collections.singleton(Integer.valueOf(18)));
        arrayList.add(Integer.valueOf(20));
        arrayList.addAll(C4390a.m11069bJ(22, 32));
        arrayList.add(Integer.valueOf(34));
        arrayList.addAll(C4390a.m11069bJ(36, 37));
        sparseArray.put(0, arrayList);
        sparseArray.put(4, Arrays.asList(new Integer[]{Integer.valueOf(21), Integer.valueOf(43)}));
        sparseArray.put(2, Arrays.asList(new Integer[]{Integer.valueOf(30), Integer.valueOf(17)}));
        sparseArray.put(1, Arrays.asList(new Integer[]{Integer.valueOf(19), Integer.valueOf(42)}));
        return sparseArray;
    }

    /* renamed from: bD */
    static List<Integer> m9023bD(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
                if (i2 != 34 && i2 != 37 && i2 != 36) {
                    if (i2 != 32) {
                        arrayList.add(Integer.valueOf(1));
                    }
                    arrayList.add(Integer.valueOf(2));
                    break;
                } else {
                    arrayList.add(Integer.valueOf(10));
                    break;
                }
            case 1:
                arrayList.add(Integer.valueOf(3));
                break;
            case 2:
                arrayList.add(Integer.valueOf(1));
                arrayList.add(Integer.valueOf(2));
                break;
            case 4:
                arrayList.add(Integer.valueOf(14));
                if (i2 == 21) {
                    arrayList.add(Integer.valueOf(2));
                    break;
                }
                break;
            case 7:
                arrayList.add(Integer.valueOf(1));
                break;
            case 8:
                arrayList.add(Integer.valueOf(20));
                break;
        }
        return arrayList;
    }

    /* renamed from: bs */
    public static void m9024bs(boolean z) {
        AdsVersionHelper.grantXYALT(VivaBaseApplication.m8749FZ(), z);
        AdsVersionHelper.grantXYBAT(VivaBaseApplication.m8749FZ(), z);
        AdsVersionHelper.grantXYYEA(VivaBaseApplication.m8749FZ(), z);
    }

    static List<AdSdk> getSdkListInOthers() {
        return m9021HT();
    }

    static List<AdSdk> getSdkListInitInApplication() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AdsVersionHelper.getXYFACAdSdk(1, new C7617j(), new C7598a(), null));
        arrayList.add(AdsVersionHelper.getXYALTAdSdk(5, new C7614g(), new C7598a(), null));
        if (!C8048e.aBe().mo23629Mu()) {
            arrayList.add(AdsVersionHelper.getXYBAIAdSdk(10, new C7615h(), new C7598a(), null));
        }
        arrayList.add(AdsVersionHelper.getXYYEAAdSdk(90, null, null, null));
        arrayList.add(AdsVersionHelper.getXYPINAdSdk(4, new C7621n(), new C7598a(), null));
        VivaBaseApplication Gs = C4681i.m12184Gp().mo25017Gs();
        if (Gs != null) {
            Bundle bundle = new Bundle();
            String str = C8048e.aBe().mo23630Mv() ? Gs.getResources().getString(R.string.xyadm_app_id_google_lite) : C8048e.aBe().mo23629Mu() ? Gs.getResources().getString(R.string.xyadm_app_id_huawei_lite) : Gs.getResources().getString(R.string.xyadm_app_id);
            bundle.putString("XYADM_app_id", str);
            arrayList.add(AdsVersionHelper.getXYADMAdSdk(2, new C7613f(), new C7598a(), bundle));
            if (C8049f.aBf().aBj()) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("XYBAT.app.key", Gs.getString(R.string.xybat_appkey));
                arrayList.add(AdsVersionHelper.getXYBATAdSdk(14, new C7616i(), new C7598a(), bundle2));
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString("XYMOP_app_id", Gs.getString(R.string.xymop_id));
            arrayList.add(AdsVersionHelper.getXYMOPAdSdk(20, new C7620m(), new C7599b(), bundle3));
        }
        arrayList.add(AdsVersionHelper.getXYINTAdSdk(19, new C7618k(), null, null));
        return arrayList;
    }

    static List<AdSdk> getSdkListInitInMainActivity() {
        if (!AppStateModel.getInstance().isInEurope()) {
            C5521b.aaN();
            return m9021HT();
        } else if (C5521b.aaL()) {
            return m9021HT();
        } else {
            return null;
        }
    }
}
