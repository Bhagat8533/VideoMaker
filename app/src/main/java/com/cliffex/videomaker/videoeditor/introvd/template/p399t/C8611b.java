package com.introvd.template.p399t;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.C9796aa;
import okhttp3.C9796aa.C9797a;
import okhttp3.C9802ac;
import okhttp3.C9934p.C9937a;
import okhttp3.C9945u;
import okhttp3.C9945u.C9946a;
import okhttp3.C9951x.C9953a;

/* renamed from: com.introvd.template.t.b */
public class C8611b {
    /* access modifiers changed from: private */
    public static long dVE = System.currentTimeMillis();
    /* access modifiers changed from: private */
    public static AtomicLong eBN = new AtomicLong(1);
    /* access modifiers changed from: private */
    public static String eBO;
    private static C8610a eBP;

    /* renamed from: com.introvd.template.t.b$a */
    public static final class C8613a {
        /* access modifiers changed from: private */
        public C8614b eBJ;
        /* access modifiers changed from: private */
        public String eBO;
        /* access modifiers changed from: private */
        public C9937a eBQ;

        /* renamed from: a */
        public C8613a mo34919a(C8614b bVar) {
            this.eBJ = bVar;
            return this;
        }

        /* renamed from: rl */
        public C8613a mo34920rl(String str) {
            this.eBO = str;
            return this;
        }
    }

    /* renamed from: com.introvd.template.t.b$b */
    public interface C8614b {
        /* renamed from: e */
        void mo23416e(String str, HashMap<String, String> hashMap);
    }

    /* renamed from: a */
    public static void m25143a(C9953a aVar) {
        if (eBP != null) {
            aVar.mo38228a((C9937a) eBP);
        }
        aVar.mo38229a((C9945u) new C9945u() {
            public C9802ac intercept(C9946a aVar) throws IOException {
                C9796aa aVO = aVar.aVO();
                C9797a b = aVar.aVO().aXa().mo37755b(aVO.aTz(), aVO.aWZ());
                if (!C8611b.m25145rk(aVO.aVr().aWl())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(C8611b.eBO);
                    sb.append("_");
                    sb.append(C8611b.dVE);
                    sb.append("_");
                    sb.append(C8611b.eBN.getAndIncrement());
                    b.mo37759bR("X-Xiaoying-Security-traceid", sb.toString());
                }
                return aVar.mo37939c(b.aXf());
            }
        });
    }

    /* renamed from: b */
    public static void m25144b(C8613a aVar) {
        if (aVar != null) {
            eBO = aVar.eBO;
            eBP = new C8610a(aVar.eBQ, aVar.eBJ);
        }
    }

    /* renamed from: rk */
    static boolean m25145rk(String str) {
        return (str != null && str.contains("127.0.0.1")) || str.contains("localhost");
    }
}
