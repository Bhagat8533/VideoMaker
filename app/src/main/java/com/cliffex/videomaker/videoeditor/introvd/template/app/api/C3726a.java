package com.introvd.template.app.api;

import com.google.gson.JsonObject;
import com.introvd.template.app.api.model.AppPopupInfoResult;
import com.introvd.template.app.api.model.AppVersionInfo;
import com.introvd.template.app.api.model.FeatureRequestResult;
import com.introvd.template.app.api.model.SnsConfigResult;
import com.introvd.template.app.api.model.SplashRequestResult;
import java.util.List;
import java.util.Map;
import p037b.p050b.C1848s;
import p469f.p474c.C9710f;
import p469f.p474c.C9725u;

/* renamed from: com.introvd.template.app.api.a */
public interface C3726a {
    @C9710f("sa")
    /* renamed from: q */
    C1848s<AppVersionInfo> mo23088q(@C9725u(baS = true) Map<String, String> map);

    @C9710f("sh")
    /* renamed from: r */
    C1848s<JsonObject> mo23089r(@C9725u(baS = true) Map<String, String> map);

    @C9710f("si")
    /* renamed from: s */
    C1848s<List<SplashRequestResult>> mo23090s(@C9725u(baS = true) Map<String, String> map);

    @C9710f("sj")
    /* renamed from: t */
    C1848s<JsonObject> mo23091t(@C9725u(baS = true) Map<String, String> map);

    @C9710f("sq")
    /* renamed from: u */
    C1848s<FeatureRequestResult> mo23092u(@C9725u(baS = true) Map<String, String> map);

    @C9710f("st")
    /* renamed from: v */
    C1848s<JsonObject> mo23093v(@C9725u(baS = true) Map<String, String> map);

    @C9710f("su")
    /* renamed from: w */
    C1848s<List<SnsConfigResult>> mo23094w(@C9725u(baS = true) Map<String, String> map);

    @C9710f("sv")
    /* renamed from: x */
    C1848s<List<AppPopupInfoResult>> mo23095x(@C9725u(baS = true) Map<String, String> map);

    @C9710f("configuration")
    /* renamed from: y */
    C1848s<JsonObject> mo23096y(@C9725u(baS = true) Map<String, String> map);

    @C9710f("uploadfilerecord")
    /* renamed from: z */
    C1848s<JsonObject> mo23097z(@C9725u(baS = true) Map<String, String> map);
}
