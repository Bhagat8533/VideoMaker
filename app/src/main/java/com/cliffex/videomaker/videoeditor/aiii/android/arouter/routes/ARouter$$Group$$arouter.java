package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.core.AutowiredServiceImpl;
import com.aiii.android.arouter.core.InterceptorServiceImpl;
import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import java.util.Map;

public class ARouter$$Group$$arouter implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/arouter/service/autowired", RouteMeta.build(C1945a.PROVIDER, AutowiredServiceImpl.class, "/arouter/service/autowired", "arouter", null, -1, Integer.MIN_VALUE));
        map.put("/arouter/service/interceptor", RouteMeta.build(C1945a.PROVIDER, InterceptorServiceImpl.class, "/arouter/service/interceptor", "arouter", null, -1, Integer.MIN_VALUE));
    }
}
