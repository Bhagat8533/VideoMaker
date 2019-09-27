package com.introvd.template.apicore;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.C9804ad;
import p469f.C9730e;
import p469f.C9730e.C9731a;
import p469f.C9769n;

/* renamed from: com.introvd.template.apicore.i */
public class C3631i extends C9731a {
    /* renamed from: a */
    public C9730e<C9804ad, ?> mo22935a(Type type, Annotation[] annotationArr, C9769n nVar) {
        final C9730e a = nVar.mo37513a((C9731a) this, type, annotationArr);
        return new C9730e<C9804ad, Object>() {
            /* renamed from: c */
            public Object convert(C9804ad adVar) throws IOException {
                return adVar.contentLength() == 0 ? new JsonObject() : a.convert(adVar);
            }
        };
    }
}
