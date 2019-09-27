package com.introvd.template.router.community.svip;

import com.aiii.android.arouter.facade.template.C1949c;

public interface ISvipAPI extends C1949c {
    public static final String URL = "/VivaCommunity/ISvipAPI";

    boolean checkCommodityNeedLogin(String str);

    void saveCommodityInfo(String str, String str2, String str3);
}
