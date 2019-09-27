package com.introvd.template.template.category;

import com.introvd.template.VivaBaseApplication;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.R;
import com.introvd.template.template.data.api.model.TemplateCategoryInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.template.category.b */
public class C8644b {
    /* renamed from: a */
    private static C8640a m25185a(List<TemplateCategoryInfo> list, String str, int i, int i2) {
        C8640a aVar = new C8640a();
        aVar.tcid = str;
        aVar.title = VivaBaseApplication.m8749FZ().getString(i);
        aVar.ekm = i2;
        if (list == null) {
            return aVar;
        }
        for (TemplateCategoryInfo templateCategoryInfo : list) {
            if (templateCategoryInfo != null && aVar.tcid.equals(templateCategoryInfo.tcid)) {
                aVar.ekn = templateCategoryInfo.newCount;
                aVar.iconUrl = templateCategoryInfo.imageUrl;
            }
        }
        return aVar;
    }

    /* renamed from: cM */
    public static List<C8640a> m25186cM(List<TemplateCategoryInfo> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m25185a(list, C8399c.ecX, R.string.xiaoying_str_ve_theme_title_common, R.drawable.v5_xiaoying_materials_icon_theme));
        arrayList.add(m25185a(list, C8399c.edb, R.string.xiaoying_str_ve_subtitle_title, R.drawable.v5_xiaoying_materials_icon_subtitle));
        arrayList.add(m25185a(list, C8399c.edd, R.string.xiaoying_str_ve_animate_frame_title, R.drawable.v5_xiaoying_materials_icon_fx));
        arrayList.add(m25185a(list, C8399c.ecY, R.string.xiaoying_str_ve_effect_title, R.drawable.v5_xiaoying_materials_icon_filter));
        arrayList.add(m25185a(list, C8399c.ede, R.string.xiaoying_str_ve_sticker, R.drawable.v5_xiaoying_materials_icon_sticker));
        arrayList.add(m25185a(list, C8399c.ecZ, R.string.xiaoying_str_ve_transition_title, R.drawable.v5_xiaoying_materials_icon_transition));
        arrayList.add(m25185a(list, C8399c.edf, R.string.xiaoying_str_ve_font_title, R.drawable.v5_xiaoying_materials_icon_fonts));
        return arrayList;
    }
}
