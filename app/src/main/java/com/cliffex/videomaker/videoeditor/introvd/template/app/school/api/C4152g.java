package com.introvd.template.app.school.api;

import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.app.school.api.model.TemplateListResult;
import com.introvd.template.app.school.api.model.VideoLabelInfoResult;
import okhttp3.C9798ab;
import p037b.p050b.C1848s;
import p469f.p474c.C9705a;
import p469f.p474c.C9719o;

/* renamed from: com.introvd.template.app.school.api.g */
public interface C4152g {
    @C9719o("getLabelList")
    /* renamed from: f */
    C1848s<CommonResponseResult<VideoLabelInfoResult>> mo23837f(@C9705a C9798ab abVar);

    @C9719o("getTemplateList")
    /* renamed from: g */
    C1848s<CommonResponseResult<TemplateListResult>> mo23838g(@C9705a C9798ab abVar);

    @C9719o("getRecommendTemplate")
    /* renamed from: h */
    C1848s<CommonResponseResult<TemplateListResult>> mo23839h(@C9705a C9798ab abVar);

    @C9719o("useTemplate")
    /* renamed from: i */
    C1848s<CommonResponseResult<Void>> mo23840i(@C9705a C9798ab abVar);

    @C9719o("getTemplateInfo")
    /* renamed from: j */
    C1848s<CommonResponseResult<TemplateInfo>> mo23841j(@C9705a C9798ab abVar);
}
