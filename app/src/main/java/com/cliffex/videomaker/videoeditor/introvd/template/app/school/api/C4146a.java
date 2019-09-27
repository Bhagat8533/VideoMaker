package com.introvd.template.app.school.api;

import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.api.model.TutorialVideoLabelResult;
import com.introvd.template.app.school.api.model.VideoListResult;
import okhttp3.C9798ab;
import p037b.p050b.C1848s;
import p469f.p474c.C9705a;
import p469f.p474c.C9719o;

/* renamed from: com.introvd.template.app.school.api.a */
public interface C4146a {
    @C9719o("getTutorialVideoLabelList")
    /* renamed from: c */
    C1848s<CommonResponseResult<TutorialVideoLabelResult>> mo23834c(@C9705a C9798ab abVar);

    @C9719o("getTutorialVideoList")
    /* renamed from: d */
    C1848s<CommonResponseResult<VideoListResult>> mo23835d(@C9705a C9798ab abVar);

    @C9719o("learnTutorialVideo")
    /* renamed from: e */
    C1848s<CommonResponseResult<String>> mo23836e(@C9705a C9798ab abVar);
}
