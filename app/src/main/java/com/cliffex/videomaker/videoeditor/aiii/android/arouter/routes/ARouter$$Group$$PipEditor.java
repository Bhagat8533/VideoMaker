package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.editor.pip.AdvancePIPClipDesigner;
import com.introvd.template.router.editor.pip.PIPDesignerRouter;
import java.util.Map;

public class ARouter$$Group$$PipEditor implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(PIPDesignerRouter.URL, RouteMeta.build(C1945a.ACTIVITY, AdvancePIPClipDesigner.class, "/pipeditor/pipdesigner", "pipeditor", null, -1, Integer.MIN_VALUE));
    }
}
