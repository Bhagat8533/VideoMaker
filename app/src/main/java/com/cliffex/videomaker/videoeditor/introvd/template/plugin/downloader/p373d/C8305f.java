package com.introvd.template.plugin.downloader.p373d;

import com.introvd.template.plugin.downloader.entity.C8312a;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import org.p489b.C9961b;
import p037b.p050b.C1510d;
import p037b.p050b.C1812h;
import p037b.p050b.C1834l;
import p037b.p050b.C1840o;
import p037b.p050b.C1841p;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1516d;
import p037b.p050b.p075i.C1815a;
import p037b.p050b.p075i.C1816b;
import p469f.C9740h;

/* renamed from: com.introvd.template.plugin.downloader.d.f */
public class C8305f {
    /* renamed from: G */
    public static <U> C1841p<U, U> m23976G(final String str, final int i) {
        return new C1841p<U, U>() {
            /* renamed from: a */
            public C1840o<U> mo10178a(C1834l<U> lVar) {
                return lVar.mo10143b((C1516d<? super Integer, ? super Throwable>) new C1516d<Integer, Throwable>() {
                    /* renamed from: a */
                    public boolean test(Integer num, Throwable th) throws Exception {
                        return C8305f.m23978a(str, i, num, th).booleanValue();
                    }
                });
            }
        };
    }

    /* renamed from: H */
    public static <U> C1812h<U, U> m23977H(final String str, final int i) {
        return new C1812h<U, U>() {
            /* renamed from: a */
            public C9961b<U> mo10102a(C1510d<U> dVar) {
                return dVar.mo9806a((C1516d<? super Integer, ? super Throwable>) new C1516d<Integer, Throwable>() {
                    /* renamed from: a */
                    public boolean test(Integer num, Throwable th) throws Exception {
                        return C8305f.m23978a(str, i, num, th).booleanValue();
                    }
                });
            }
        };
    }

    /* renamed from: a */
    public static Boolean m23978a(String str, int i, Integer num, Throwable th) {
        if (th instanceof ProtocolException) {
            if (num.intValue() >= i + 1) {
                return Boolean.valueOf(false);
            }
            C8304e.m23974f("%s get [%s] error, now retry [%d] times", str, "ProtocolException", num);
            return Boolean.valueOf(true);
        } else if (th instanceof UnknownHostException) {
            if (num.intValue() >= i + 1) {
                return Boolean.valueOf(false);
            }
            C8304e.m23974f("%s get [%s] error, now retry [%d] times", str, "UnknownHostException", num);
            return Boolean.valueOf(true);
        } else if (th instanceof C9740h) {
            if (num.intValue() >= i + 1) {
                return Boolean.valueOf(false);
            }
            C8304e.m23974f("%s get [%s] error, now retry [%d] times", str, "HttpException", num);
            return Boolean.valueOf(true);
        } else if (th instanceof SocketTimeoutException) {
            if (num.intValue() >= i + 1) {
                return Boolean.valueOf(false);
            }
            C8304e.m23974f("%s get [%s] error, now retry [%d] times", str, "SocketTimeoutException", num);
            return Boolean.valueOf(true);
        } else if (th instanceof ConnectException) {
            if (num.intValue() >= i + 1) {
                return Boolean.valueOf(false);
            }
            C8304e.m23974f("%s get [%s] error, now retry [%d] times", str, "ConnectException", num);
            return Boolean.valueOf(true);
        } else if (!(th instanceof SocketException)) {
            return Boolean.valueOf(false);
        } else {
            if (num.intValue() >= i + 1) {
                return Boolean.valueOf(false);
            }
            C8304e.m23974f("%s get [%s] error, now retry [%d] times", str, "SocketException", num);
            return Boolean.valueOf(true);
        }
    }

    /* renamed from: c */
    public static C1815a<C8312a> m23979c(String str, Map<String, C1815a<C8312a>> map) {
        if (map.get(str) == null) {
            map.put(str, C1816b.aVg().aVf());
        }
        return (C1815a) map.get(str);
    }

    /* renamed from: c */
    public static void m23980c(C1495b bVar) {
        if (bVar != null && !bVar.aAy()) {
            bVar.dispose();
        }
    }
}
