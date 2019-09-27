package com.introvd.template.app.banner;

import android.content.Context;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.filecache.FileCache;
import com.introvd.template.common.filecache.FileCache.Builder;
import com.introvd.template.router.banner.BannerCacheData;
import com.introvd.template.router.banner.BannerInfo;
import java.util.List;
import p037b.p050b.C1834l;

/* renamed from: com.introvd.template.app.banner.a */
public class C3750a {
    private static volatile C3750a bjR;
    private FileCache<BannerCacheData> bjQ;
    private BannerCacheData bjS;

    /* renamed from: Ik */
    public static C3750a m9200Ik() {
        if (bjR == null) {
            synchronized (C3750a.class) {
                if (bjR == null) {
                    bjR = new C3750a();
                }
            }
        }
        return bjR;
    }

    /* renamed from: bS */
    private void m9201bS(Context context) {
        if (this.bjQ == null) {
            this.bjQ = new Builder(context.getApplicationContext(), BannerCacheData.class).setRelativeDir("banner_mgr_file").setFileSaveInternal(true).build();
        }
    }

    /* renamed from: Il */
    public C1834l<BannerCacheData> mo23201Il() {
        m9201bS(VivaBaseApplication.m8749FZ());
        return this.bjQ.getCache();
    }

    /* renamed from: b */
    public void mo23202b(Context context, List<BannerInfo> list) {
        if (list != null && list.size() != 0) {
            m9201bS(context);
            if (this.bjS == null) {
                this.bjS = new BannerCacheData();
            }
            this.bjS.mBannerCacheModelList = list;
            this.bjQ.saveCache(this.bjS);
        }
    }

    /* renamed from: bT */
    public List<BannerInfo> mo23203bT(Context context) {
        if (context == null) {
            return null;
        }
        m9201bS(context);
        this.bjS = (BannerCacheData) this.bjQ.getCacheSync();
        if (this.bjS == null) {
            this.bjS = new BannerCacheData();
        }
        return this.bjS.mBannerCacheModelList;
    }
}
