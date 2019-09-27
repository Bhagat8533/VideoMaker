package com.introvd.template.app.ads;

import android.content.Context;
import android.util.SparseArray;
import com.google.gson.reflect.TypeToken;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.ads.AbsAdGlobalMgr;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.AdParamMgr.DataAdapter;
import com.introvd.template.ads.entity.AdServerParam;
import com.introvd.template.ads.utils.VivaAdLog;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.filecache.FileCacheV2.Builder;
import com.introvd.template.module.p326ad.p330d.C7602b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.C1850u;
import p037b.p050b.p073g.C1810c;

/* renamed from: com.introvd.template.app.ads.c */
public final class C3712c extends AbsAdGlobalMgr {
    private boolean bji;

    /* renamed from: com.introvd.template.app.ads.c$a */
    private static class C3717a {
        static final C3712c bjl = new C3712c();
    }

    /* renamed from: com.introvd.template.app.ads.c$b */
    private static class C3718b {
        private static List<Integer> bjm = Arrays.asList(new Integer[]{Integer.valueOf(19), Integer.valueOf(49), Integer.valueOf(42), Integer.valueOf(17), Integer.valueOf(12), Integer.valueOf(16), Integer.valueOf(30), Integer.valueOf(4), Integer.valueOf(48), Integer.valueOf(2), Integer.valueOf(9), Integer.valueOf(13), Integer.valueOf(32), Integer.valueOf(21)});

        /* renamed from: gl */
        static int m9020gl(int i) {
            if (bjm.contains(Integer.valueOf(i))) {
                return 1;
            }
            int adType = AdParamMgr.getAdType(i);
            return (adType == 0 || adType == 7) ? 2 : 0;
        }
    }

    private C3712c() {
        VivaAdLog.setCanOutputLog(AppPreferencesSetting.getInstance().getAppSettingBoolean("key_pref_can_output_ad_log", false));
    }

    /* renamed from: HP */
    public static C3712c m9010HP() {
        return C3717a.bjl;
    }

    /* renamed from: HR */
    private List<C3720e> m9011HR() {
        LogUtilsV2.m14228e("-- ad --  getAdInfoListFromDB ------------- ");
        List<C3720e> list = (List) new Builder((Context) VivaBaseApplication.m8749FZ(), "AdConfig", new TypeToken<List<C3720e>>() {
        }.getType()).build().getCacheSync();
        return (list == null || list.isEmpty()) ? m9012HS() : list;
    }

    /* renamed from: HS */
    private List<C3720e> m9012HS() {
        ArrayList arrayList = new ArrayList();
        SparseArray HU = C3719d.m9022HU();
        arrayList.addAll(m9015e(0, (List) HU.get(0)));
        arrayList.addAll(m9015e(2, (List) HU.get(2)));
        arrayList.addAll(m9015e(4, (List) HU.get(4)));
        arrayList.addAll(m9015e(1, (List) HU.get(1)));
        arrayList.addAll(m9015e(7, (List) HU.get(7)));
        arrayList.addAll(m9015e(8, (List) HU.get(8)));
        return arrayList;
    }

    /* renamed from: bC */
    private C3720e m9014bC(int i, int i2) {
        List<Integer> bD = C3719d.m9023bD(i, i2);
        if (bD.isEmpty()) {
            return null;
        }
        C3720e eVar = new C3720e();
        eVar.mo23077gm(i);
        eVar.mo23078gn(i2);
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : bD) {
            int intValue2 = intValue.intValue();
            C3721a aVar = new C3721a();
            StringBuilder sb = new StringBuilder();
            sb.append(intValue2);
            sb.append("");
            aVar.bju = sb.toString();
            arrayList.add(aVar);
        }
        eVar.mo23073I(arrayList);
        return eVar;
    }

    /* renamed from: e */
    private List<C3720e> m9015e(int i, List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (Integer intValue : list) {
            C3720e bC = m9014bC(i, intValue.intValue());
            if (bC != null) {
                arrayList.add(bC);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m9016f(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("resultCode", String.valueOf(z));
        UserBehaviorLog.onKVEvent(context, "Ad_get_config", hashMap);
    }

    /* renamed from: HQ */
    public void mo23064HQ() {
        if (!this.bji) {
            List HR = m9011HR();
            this.bji = HR != null && !HR.isEmpty();
            AdParamMgr.updateConfig(HR, new DataAdapter<C3720e>() {
                /* renamed from: a */
                public AdServerParam onDataConvert(C3720e eVar) {
                    int HW = eVar.mo23069HW();
                    AdServerParam adServerParam = new AdServerParam(C3718b.m9020gl(HW), eVar.mo23068HV(), HW, eVar.mo23074Ia());
                    adServerParam.adCounts = eVar.mo23070HX();
                    adServerParam.waitTime = (long) (eVar.mo23075Ic() * 1000);
                    adServerParam.intervalTime = (long) eVar.mo23071HY();
                    adServerParam.adPositionInGroup = eVar.mo23072HZ();
                    adServerParam.extraJson = eVar.getExtraInfo();
                    return adServerParam;
                }
            });
            C7602b.aAs().mo32483SS();
        }
    }

    /* renamed from: bP */
    public void mo23065bP(final Context context) {
        C3706b.m9005HO().mo10188a((C1850u<? super T>) new C1810c<List<C3720e>>() {
            public void onError(Throwable th) {
                C3712c.this.m9016f(context.getApplicationContext(), false);
            }

            public void onSuccess(List<C3720e> list) {
                new Builder(context.getApplicationContext(), "AdConfig", new TypeToken<List<C3720e>>() {
                }.getType()).build().saveCache(list);
                C3712c.this.m9016f(context.getApplicationContext(), true);
            }
        });
    }

    /* access modifiers changed from: protected */
    public List<AdSdk> getSdkListInOthers() {
        return C3719d.getSdkListInOthers();
    }

    /* access modifiers changed from: protected */
    public List<AdSdk> getSdkListInitInApplication() {
        return C3719d.getSdkListInitInApplication();
    }

    /* access modifiers changed from: protected */
    public List<AdSdk> getSdkListInitInMainActivity() {
        return C3719d.getSdkListInitInMainActivity();
    }
}
