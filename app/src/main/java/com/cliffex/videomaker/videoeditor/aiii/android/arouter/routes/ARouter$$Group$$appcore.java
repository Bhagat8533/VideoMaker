package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.app.webview.CommonWebPage;
import com.introvd.template.router.AppRouter.CommonWebPageParams;
import java.util.Map;

public class ARouter$$Group$$appcore implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(CommonWebPageParams.URL, RouteMeta.build(C1945a.ACTIVITY, CommonWebPage.class, "/appcore/commonwebview", "appcore", null, -1, Integer.MIN_VALUE));
    }
}
