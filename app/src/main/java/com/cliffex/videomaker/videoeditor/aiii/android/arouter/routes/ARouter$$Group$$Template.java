package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.template.category.TemplateCategoryActivity;
import com.introvd.template.template.info.AnimateFrameActivity;
import com.introvd.template.template.info.FontListActivity;
import com.introvd.template.template.info.TemplateInfoActivity;
import com.introvd.template.template.info.TemplatePackActivity;
import com.introvd.template.template.info.TemplatePreviewActivity;
import com.introvd.template.template.info.TemplateRollDetailActivity;
import com.introvd.template.template.info.filter.FilterActivity;
import com.introvd.template.template.info.filter.FilterDetailActivity;
import java.util.Map;

public class ARouter$$Group$$Template implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(TemplateRouter.URL_ANIMATE_FRAME_INFO, RouteMeta.build(C1945a.ACTIVITY, AnimateFrameActivity.class, "/template/animateframe", "template", null, -1, Integer.MIN_VALUE));
        map.put(TemplateRouter.URL_TEMPLATE_CATEGORY, RouteMeta.build(C1945a.ACTIVITY, TemplateCategoryActivity.class, "/template/category", "template", null, -1, Integer.MIN_VALUE));
        map.put(TemplateRouter.URL_FILTER_INFO, RouteMeta.build(C1945a.ACTIVITY, FilterActivity.class, "/template/filter", "template", null, -1, Integer.MIN_VALUE));
        map.put(TemplateRouter.URL_FILTER_DETAIL, RouteMeta.build(C1945a.ACTIVITY, FilterDetailActivity.class, "/template/filterdetail", "template", null, -1, Integer.MIN_VALUE));
        map.put(TemplateRouter.URL_TEMPLATE_FONT, RouteMeta.build(C1945a.ACTIVITY, FontListActivity.class, "/template/font", "template", null, -1, Integer.MIN_VALUE));
        map.put(TemplateRouter.URL_TEMPLATE_INFO, RouteMeta.build(C1945a.ACTIVITY, TemplateInfoActivity.class, "/template/info", "template", null, -1, Integer.MIN_VALUE));
        map.put(TemplateRouter.URL_TEMPLATE_PACKAGE, RouteMeta.build(C1945a.ACTIVITY, TemplatePackActivity.class, "/template/package", "template", null, -1, Integer.MIN_VALUE));
        map.put(TemplateRouter.URL_TEMPLATE_PREVIEW, RouteMeta.build(C1945a.ACTIVITY, TemplatePreviewActivity.class, "/template/preview", "template", null, -1, Integer.MIN_VALUE));
        map.put(TemplateRouter.URL_TEMPLATE_ROLL_DETAIL, RouteMeta.build(C1945a.ACTIVITY, TemplateRollDetailActivity.class, "/template/rolldetail", "template", null, -1, Integer.MIN_VALUE));
    }
}
