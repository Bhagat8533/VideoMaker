package com.introvd.template.app.banner;

import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.router.banner.BannerCacheData;
import com.introvd.template.router.banner.BannerInfo;
import com.introvd.template.router.banner.IBannerService;
import java.util.ArrayList;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.p055c.C1505b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/app/bannerinfo")
public class BannerServiceImpl implements IBannerService {
    public List<BannerInfo> getBannerInfo(Context context, int i) {
        List<BannerInfo> bT = C3750a.m9200Ik().mo23203bT(context);
        if (i == -1 || bT == null || bT.isEmpty()) {
            return bT;
        }
        ArrayList arrayList = new ArrayList();
        for (BannerInfo bannerInfo : bT) {
            if (bannerInfo.pageType == i) {
                arrayList.add(bannerInfo);
            }
        }
        return arrayList;
    }

    public void init(Context context) {
    }

    public C1834l<List<BannerInfo>> queryBannerInfo(Context context, final int i) {
        return C3750a.m9200Ik().mo23201Il().mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<BannerCacheData, List<BannerInfo>>() {
            /* renamed from: a */
            public List<BannerInfo> apply(BannerCacheData bannerCacheData) throws Exception {
                if (bannerCacheData == null || bannerCacheData.mBannerCacheModelList == null || bannerCacheData.mBannerCacheModelList.size() == 0) {
                    throw C1505b.m4703z(new Throwable("No Cache"));
                }
                List<BannerInfo> list = bannerCacheData.mBannerCacheModelList;
                if (i == -1) {
                    return list;
                }
                ArrayList arrayList = new ArrayList();
                for (BannerInfo bannerInfo : list) {
                    if (bannerInfo.pageType == i) {
                        arrayList.add(bannerInfo);
                    }
                }
                return arrayList;
            }
        });
    }

    public void saveBanner(Context context, List<BannerInfo> list) {
        C3750a.m9200Ik().mo23202b(context, list);
    }
}
