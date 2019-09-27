package com.introvd.template.apicore;

import com.google.gson.Gson;
import p469f.C9740h;

/* renamed from: com.introvd.template.apicore.u */
public class C3643u {
    /* renamed from: k */
    public static XYErrorResponse m8926k(Throwable th) {
        if (!(th instanceof C9740h)) {
            return null;
        }
        return (XYErrorResponse) new Gson().fromJson(((C9740h) th).baz().baJ().charStream(), XYErrorResponse.class);
    }
}
