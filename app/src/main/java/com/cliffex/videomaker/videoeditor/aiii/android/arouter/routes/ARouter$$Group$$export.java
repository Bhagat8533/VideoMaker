package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.editor.export.IntlPublishActivity;
import com.introvd.template.router.editor.EditorRouter.ToolPublishParams;
import java.util.Map;

public class ARouter$$Group$$export implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(ToolPublishParams.URL, RouteMeta.build(C1945a.ACTIVITY, IntlPublishActivity.class, ToolPublishParams.URL, "export", null, -1, Integer.MIN_VALUE));
    }
}
