package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.editor.gallery.GalleryActivity;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import java.util.Map;

public class ARouter$$Group$$gallery implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(GalleryRouter.URL, RouteMeta.build(C1945a.ACTIVITY, GalleryActivity.class, GalleryRouter.URL, "gallery", null, -1, Integer.MIN_VALUE));
    }
}
