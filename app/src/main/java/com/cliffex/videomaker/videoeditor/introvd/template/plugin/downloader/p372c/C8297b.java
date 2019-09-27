package com.introvd.template.plugin.downloader.p372c;

import com.introvd.template.plugin.downloader.p370a.C8262a;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.C9802ac;
import okhttp3.C9945u;
import okhttp3.C9945u.C9946a;
import okhttp3.C9951x;
import okhttp3.C9951x.C9953a;
import p469f.C9703c.C9704a;
import p469f.C9730e.C9731a;
import p469f.C9769n;
import p469f.C9769n.C9771a;
import p469f.p470a.p471a.C9698h;
import p469f.p472b.p473a.C9700a;

/* renamed from: com.introvd.template.plugin.downloader.c.b */
public class C8297b {
    /* access modifiers changed from: private */
    public static String eaP;

    /* renamed from: com.introvd.template.plugin.downloader.c.b$a */
    private static class C8298a {
        /* access modifiers changed from: private */
        public static final C9769n eaQ = aGK();

        private static C9769n aGK() {
            C9953a aWQ = new C9951x().aWQ();
            aWQ.mo38237m(10, TimeUnit.SECONDS);
            aWQ.mo38236l(10, TimeUnit.SECONDS);
            return new C9771a().mo37528ua(C8297b.eaP).mo37525a(aWQ.mo38232b((C9945u) new C9945u() {
                public C9802ac intercept(C9946a aVar) throws IOException {
                    return aVar.mo37939c(aVar.aVO()).aXi().aXm();
                }
            }).aWR()).mo37523a((C9731a) C9700a.baR()).mo37522a((C9704a) C9698h.baQ()).baM();
        }
    }

    public static C9769n aGJ() {
        return m23945nr(C8262a.eak);
    }

    /* renamed from: nr */
    public static C9769n m23945nr(String str) {
        eaP = str;
        return C8298a.eaQ;
    }
}
