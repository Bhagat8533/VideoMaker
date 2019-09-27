package com.introvd.template.template.data.api;

import com.introvd.template.template.data.api.model.TemplateAudioCategoryList;
import com.introvd.template.template.data.api.model.TemplateAudioInfoList;
import com.introvd.template.template.data.api.model.TemplateCategoryInfo;
import com.introvd.template.template.data.api.model.TemplateDownloadInfo;
import com.introvd.template.template.data.api.model.TemplatePackageInfoList;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.data.api.model.TemplateResponseList;
import com.introvd.template.template.data.api.model.TemplateResponseRoll;
import java.util.List;
import java.util.Map;
import p037b.p050b.C1848s;
import p469f.C9768m;
import p469f.p474c.C9710f;
import p469f.p474c.C9725u;

/* renamed from: com.introvd.template.template.data.api.a */
public interface C8658a {
    @C9710f("ta")
    /* renamed from: O */
    C1848s<C9768m<List<TemplateCategoryInfo>>> mo34958O(@C9725u(baS = true) Map<String, String> map);

    @C9710f("tb")
    /* renamed from: P */
    C1848s<List<TemplateResponseInfo>> mo34959P(@C9725u(baS = true) Map<String, String> map);

    @C9710f("tc")
    /* renamed from: Q */
    C1848s<TemplateDownloadInfo> mo34960Q(@C9725u(baS = true) Map<String, String> map);

    @C9710f("tg")
    /* renamed from: R */
    C1848s<C9768m<TemplateResponseInfo>> mo34961R(@C9725u(baS = true) Map<String, String> map);

    @C9710f("ts")
    /* renamed from: S */
    C1848s<C9768m<TemplatePackageInfoList>> mo34962S(@C9725u(baS = true) Map<String, String> map);

    @C9710f("tu")
    /* renamed from: T */
    C1848s<C9768m<TemplateResponseList>> mo34963T(@C9725u(baS = true) Map<String, String> map);

    @C9710f("tz")
    /* renamed from: U */
    C1848s<List<TemplateResponseRoll>> mo34964U(@C9725u(baS = true) Map<String, String> map);

    @C9710f("taa")
    /* renamed from: V */
    C1848s<C9768m<TemplateAudioCategoryList>> mo34965V(@C9725u(baS = true) Map<String, String> map);

    @C9710f("tab")
    /* renamed from: W */
    C1848s<C9768m<TemplateAudioInfoList>> mo34966W(@C9725u(baS = true) Map<String, String> map);
}
