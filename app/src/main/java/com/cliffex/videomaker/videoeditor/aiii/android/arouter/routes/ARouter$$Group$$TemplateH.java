package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.template.TemplateServiceImpl;
import com.introvd.template.template.TemplateTodoInterceptorImpl;
import java.util.Map;

public class ARouter$$Group$$TemplateH implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(TemplateRouter.URL_TEMPLATE_SERVICE, RouteMeta.build(C1945a.PROVIDER, TemplateServiceImpl.class, "/templateh/itemplateapi", "templateh", null, -1, Integer.MIN_VALUE));
        map.put(TemplateRouter.TEMPLATE_TODO_INTERCEPTOR, RouteMeta.build(C1945a.PROVIDER, TemplateTodoInterceptorImpl.class, "/templateh/todointerceptor", "templateh", null, -1, Integer.MIN_VALUE));
    }
}
