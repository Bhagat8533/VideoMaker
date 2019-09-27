package com.introvd.template.router.banner;

import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;
import java.util.List;
import p037b.p050b.C1834l;

public interface IBannerService extends C1949c {
    List<BannerInfo> getBannerInfo(Context context, int i);

    C1834l<List<BannerInfo>> queryBannerInfo(Context context, int i);

    void saveBanner(Context context, List<BannerInfo> list);
}
