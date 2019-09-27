package com.aiii.android.arouter.core;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.template.C1949c;
import com.aiii.android.arouter.facade.template.C1951e;
import com.aiii.android.arouter.facade.template.IInterceptor;
import com.aiii.android.arouter.p089a.C1915a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.aiii.android.arouter.core.b */
class C1929b {
    static Map<String, Class<? extends C1951e>> asV = new HashMap();
    static Map<String, RouteMeta> asW = new HashMap();
    static Map<Class, C1949c> asX = new HashMap();
    static Map<String, RouteMeta> asY = new HashMap();
    static Map<Integer, Class<? extends IInterceptor>> asZ = new C1915a("More than one interceptors use same priority [%s]");
    static List<IInterceptor> ata = new ArrayList();
}
