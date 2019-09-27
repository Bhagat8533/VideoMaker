package com.introvd.template.app.push.api;

import com.google.gson.JsonObject;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import java.util.Map;
import p037b.p050b.C1848s;
import p469f.p474c.C9708d;
import p469f.p474c.C9709e;
import p469f.p474c.C9719o;

/* renamed from: com.introvd.template.app.push.api.a */
public interface C4098a {
    @C9709e
    @C9719o("commontag")
    /* renamed from: D */
    C1848s<CommonResponseResult<String>> mo23779D(@C9708d Map<String, String> map);

    @C9709e
    @C9719o("saveRegisterIds")
    /* renamed from: E */
    C1848s<JsonObject> mo23780E(@C9708d Map<String, String> map);
}
