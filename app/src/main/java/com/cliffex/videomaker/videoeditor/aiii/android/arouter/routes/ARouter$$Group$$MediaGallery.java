package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.gallery.activity.GalleryPreviewActivity;
import com.introvd.template.gallery.activity.XYGalleryActivity;
import com.introvd.template.gallery.fragment.GalleryOthersFragment;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import java.util.Map;

public class ARouter$$Group$$MediaGallery implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(MediaGalleryRouter.OTHER_MEDIA_URL, RouteMeta.build(C1945a.FRAGMENT, GalleryOthersFragment.class, "/mediagallery/otheralbum", "mediagallery", null, -1, Integer.MIN_VALUE));
        map.put(MediaGalleryRouter.URL, RouteMeta.build(C1945a.ACTIVITY, XYGalleryActivity.class, "/mediagallery/entry", "mediagallery", null, -1, Integer.MIN_VALUE));
        map.put(MediaGalleryRouter.URL_PIC_PREVIEW, RouteMeta.build(C1945a.ACTIVITY, GalleryPreviewActivity.class, "/mediagallery/picpreview", "mediagallery", null, -1, Integer.MIN_VALUE));
    }
}
