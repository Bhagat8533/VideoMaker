package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.gallery.GalleryAppLifeCycleImpl;
import com.introvd.template.gallery.GalleryTodoInterceptorImpl;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import java.util.Map;

public class ARouter$$Group$$gallerySelf implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(GalleryRouter.PROXY_MAIN_APP, RouteMeta.build(C1945a.PROVIDER, GalleryAppLifeCycleImpl.class, "/galleryself/galleryapplifecycle", "galleryself", null, -1, Integer.MIN_VALUE));
        map.put(GalleryRouter.GALLERY_TODO_INTERCEPTOR, RouteMeta.build(C1945a.PROVIDER, GalleryTodoInterceptorImpl.class, "/galleryself/todointerceptor", "galleryself", null, -1, Integer.MIN_VALUE));
    }
}
