package com.introvd.template.apicore;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* renamed from: com.introvd.template.apicore.g */
public class C3629g {
    private static volatile C3629g bht;
    private C3628f bhu;

    private C3629g() {
    }

    /* renamed from: GS */
    public static C3629g m8896GS() {
        if (bht == null) {
            synchronized (C3629g.class) {
                if (bht == null) {
                    bht = new C3629g();
                }
            }
        }
        return bht;
    }

    /* renamed from: db */
    public static String m8897db(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(IronSourceConstants.EVENTS_ERROR_CODE, (Number) Integer.valueOf(-2017));
        jsonObject.addProperty("errorMsg", str);
        return new Gson().toJson((JsonElement) jsonObject);
    }

    /* renamed from: GT */
    public C3628f mo22969GT() {
        return this.bhu;
    }

    /* renamed from: a */
    public void mo22970a(C3628f fVar) {
        this.bhu = fVar;
    }
}
