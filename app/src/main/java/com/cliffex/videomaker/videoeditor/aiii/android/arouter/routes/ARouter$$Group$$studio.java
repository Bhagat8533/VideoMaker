package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.editor.studio.StudioActivity;
import com.introvd.template.editor.studio.StudioFragment;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.editor.EditorRouter;
import java.util.Map;

public class ARouter$$Group$$studio implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(StudioRouter.URL, RouteMeta.build(C1945a.ACTIVITY, StudioActivity.class, StudioRouter.URL, EditorRouter.ENTRANCE_STUDIO, null, -1, Integer.MIN_VALUE));
        map.put(StudioRouter.FRAGMENT_URL, RouteMeta.build(C1945a.FRAGMENT, StudioFragment.class, StudioRouter.FRAGMENT_URL, EditorRouter.ENTRANCE_STUDIO, null, -1, Integer.MIN_VALUE));
    }
}
