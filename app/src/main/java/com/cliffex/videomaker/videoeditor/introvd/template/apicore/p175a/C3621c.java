package com.introvd.template.apicore.p175a;

import android.util.Log;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.C9798ab;
import okhttp3.C9804ad;
import okhttp3.C9947v;
import p469f.C9730e;
import p469f.C9730e.C9731a;
import p469f.C9769n;
import p503cz.msebera.android.httpclient.protocol.HTTP;

/* renamed from: com.introvd.template.apicore.a.c */
public class C3621c extends C9731a {
    /* access modifiers changed from: private */
    public static final C9947v bhL = C9947v.m28445ts(HTTP.PLAIN_TEXT_TYPE);

    /* renamed from: a */
    public C9730e<C9804ad, String> mo22935a(Type type, Annotation[] annotationArr, C9769n nVar) {
        if (String.class.equals(type)) {
            return new C9730e<C9804ad, String>() {
                /* renamed from: d */
                public String convert(C9804ad adVar) throws IOException {
                    String string = adVar.string();
                    StringBuilder sb = new StringBuilder();
                    sb.append("value = ");
                    sb.append(adVar.getClass().getName());
                    Log.d("CommonAPI", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("value = ");
                    sb2.append(string);
                    Log.d("CommonAPI", sb2.toString());
                    return string;
                }
            };
        }
        return null;
    }

    /* renamed from: a */
    public C9730e<?, C9798ab> mo22936a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, C9769n nVar) {
        if (String.class.equals(type)) {
            return new C9730e<String, C9798ab>() {
                /* renamed from: dh */
                public C9798ab convert(String str) throws IOException {
                    return C9798ab.create(C3621c.bhL, str);
                }
            };
        }
        return null;
    }
}
