package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.editor.slideshow.SlideEditorActivity;
import com.introvd.template.editor.slideshow.story.SimpleCoverActivity;
import com.introvd.template.router.slide.SlideshowRouter;
import java.util.Map;

public class ARouter$$Group$$Slide implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(SlideshowRouter.URL_COVER, RouteMeta.build(C1945a.ACTIVITY, SimpleCoverActivity.class, "/slide/cover", "slide", null, -1, Integer.MIN_VALUE));
        map.put(SlideshowRouter.URL_SLIDE_EDITOR, RouteMeta.build(C1945a.ACTIVITY, SlideEditorActivity.class, "/slide/editor", "slide", null, -1, Integer.MIN_VALUE));
    }
}
