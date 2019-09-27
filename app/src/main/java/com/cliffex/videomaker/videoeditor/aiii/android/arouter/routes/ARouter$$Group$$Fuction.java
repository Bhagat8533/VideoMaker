package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.editor.export.PrjExportVideoActivity;
import com.introvd.template.router.FuncExportRouter;
import java.util.Map;

public class ARouter$$Group$$Fuction implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(FuncExportRouter.FUNC_URL, RouteMeta.build(C1945a.ACTIVITY, PrjExportVideoActivity.class, "/fuction/video_export", "fuction", null, -1, Integer.MIN_VALUE));
    }
}
