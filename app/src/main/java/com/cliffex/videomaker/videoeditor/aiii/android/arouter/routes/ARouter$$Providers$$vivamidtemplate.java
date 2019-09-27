package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1950d;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.template.TemplateServiceImpl;
import java.util.Map;

public class ARouter$$Providers$$vivamidtemplate implements C1950d {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.introvd.template.router.template.ITemplateService", RouteMeta.build(C1945a.PROVIDER, TemplateServiceImpl.class, TemplateRouter.URL_TEMPLATE_SERVICE, "TemplateH", null, -1, Integer.MIN_VALUE));
    }
}
