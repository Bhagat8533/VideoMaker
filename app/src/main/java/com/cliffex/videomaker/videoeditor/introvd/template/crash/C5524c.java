package com.introvd.template.crash;

import com.introvd.template.C4681i;
import com.introvd.template.VivaBaseApplication;
import java.io.File;
import p037b.p050b.C1834l;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.crash.c */
public class C5524c {
    public static void aaS() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                try {
                    C5524c.aaT();
                } catch (Exception unused) {
                }
            }
        }).aTR();
    }

    /* access modifiers changed from: private */
    public static void aaT() throws Exception {
        VivaBaseApplication Gs = C4681i.m12184Gp().mo25017Gs();
        StringBuilder sb = new StringBuilder();
        sb.append("/data/data/");
        sb.append(Gs.getPackageName());
        sb.append("/shared_prefs");
        File file = new File(sb.toString());
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && !file2.isDirectory() && file2.length() > 10485760) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("fileName=");
                        sb2.append(file2.getName());
                        sb2.append(",size=");
                        sb2.append(file2.length() / 1024);
                        sb2.append("kb");
                        C5523b.logException(new C5526d(sb2.toString()));
                    }
                }
            }
        }
    }
}
