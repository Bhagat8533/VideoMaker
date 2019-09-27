package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.core.AutowiredServiceImpl;
import com.aiii.android.arouter.core.InterceptorServiceImpl;
import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1950d;
import java.util.Map;

public class ARouter$$Providers$$arouterapi implements C1950d {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.aiii.android.arouter.facade.service.AutowiredService", RouteMeta.build(C1945a.PROVIDER, AutowiredServiceImpl.class, "/arouter/service/autowired", "arouter", null, -1, Integer.MIN_VALUE));
        map.put("com.aiii.android.arouter.facade.service.InterceptorService", RouteMeta.build(C1945a.PROVIDER, InterceptorServiceImpl.class, "/arouter/service/interceptor", "arouter", null, -1, Integer.MIN_VALUE));
    }
}
