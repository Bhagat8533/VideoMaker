package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.editor.slideshow.story.StoryEditActivity;
import com.introvd.template.editor.slideshow.story.StoryPreviewActivity;
import com.introvd.template.router.slide.SlideshowRouter;
import java.util.Map;

public class ARouter$$Group$$Story implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(SlideshowRouter.URL_EDITOR, RouteMeta.build(C1945a.ACTIVITY, StoryEditActivity.class, "/story/editor", "story", null, -1, Integer.MIN_VALUE));
        map.put(SlideshowRouter.URL_PREVIEW, RouteMeta.build(C1945a.ACTIVITY, StoryPreviewActivity.class, "/story/preview", "story", null, -1, Integer.MIN_VALUE));
    }
}
