package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.editor.slideshow.SlideThemeTestActivity;
import com.introvd.template.editor.slideshow.funny.FunnyEditActivity;
import com.introvd.template.editor.slideshow.funny.FunnyTemplateDetailActivity;
import com.introvd.template.editor.slideshow.funny.FunnyTemplateListActivity;
import com.introvd.template.router.slide.FunnySlideRouter;
import java.util.Map;

public class ARouter$$Group$$Funny implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(FunnySlideRouter.URL_EDITOR, RouteMeta.build(C1945a.ACTIVITY, FunnyEditActivity.class, "/funny/editor", "funny", null, -1, Integer.MIN_VALUE));
        map.put(FunnySlideRouter.URL_TEMPLATE_DETAIL, RouteMeta.build(C1945a.ACTIVITY, FunnyTemplateDetailActivity.class, "/funny/templatedetail", "funny", null, -1, Integer.MIN_VALUE));
        map.put(FunnySlideRouter.URL_TEMPLATE_INFO, RouteMeta.build(C1945a.ACTIVITY, FunnyTemplateListActivity.class, "/funny/templateinfo", "funny", null, -1, Integer.MIN_VALUE));
        map.put(FunnySlideRouter.URL_THEME_TEST, RouteMeta.build(C1945a.ACTIVITY, SlideThemeTestActivity.class, "/funny/themetest", "funny", null, -1, Integer.MIN_VALUE));
    }
}
