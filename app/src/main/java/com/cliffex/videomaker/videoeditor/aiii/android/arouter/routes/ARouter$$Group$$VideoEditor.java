package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.editor.advance.AdvanceEditorPickCoverActivity;
import com.introvd.template.router.parammodels.PickCoverParams;
import java.util.Map;

public class ARouter$$Group$$VideoEditor implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(PickCoverParams.URL, RouteMeta.build(C1945a.ACTIVITY, AdvanceEditorPickCoverActivity.class, "/videoeditor/pickcover", "videoeditor", null, -1, Integer.MIN_VALUE));
    }
}
