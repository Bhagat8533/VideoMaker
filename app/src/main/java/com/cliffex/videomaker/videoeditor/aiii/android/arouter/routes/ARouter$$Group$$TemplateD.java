package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.template.download.web.WebTemplateDownloadFragment;
import java.util.Map;

public class ARouter$$Group$$TemplateD implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(TemplateRouter.URL_TEMPLATE_WEB_DOWNLOAD, RouteMeta.build(C1945a.FRAGMENT, WebTemplateDownloadFragment.class, "/templated/webdownload", "templated", null, -1, Integer.MIN_VALUE));
    }
}
