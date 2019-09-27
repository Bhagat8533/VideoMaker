package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.app.crash.CrashFlavor;
import com.introvd.template.crash.ICrashFlavour;
import java.util.Map;

public class ARouter$$Group$$VivaBaseRouter implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(ICrashFlavour.VIVA_ROUTER_CRASH, RouteMeta.build(C1945a.PROVIDER, CrashFlavor.class, "/vivabaserouter/vivaroutercrash", "vivabaserouter", null, -1, Integer.MIN_VALUE));
    }
}
