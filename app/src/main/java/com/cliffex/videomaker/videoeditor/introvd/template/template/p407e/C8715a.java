package com.introvd.template.template.p407e;

import android.content.Context;
import com.introvd.template.plugin.downloader.C8251a;
import com.introvd.template.plugin.downloader.entity.C8312a;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.download.C8703d;
import com.introvd.template.template.download.C8708f;
import java.util.ArrayList;
import java.util.List;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;

/* renamed from: com.introvd.template.template.e.a */
public class C8715a {
    /* access modifiers changed from: private */
    public C8703d bOW;
    private Context context;
    private List<C1495b> esq = new ArrayList();
    private C8716a esr;
    /* access modifiers changed from: private */
    public C8717b ess;
    private int est;
    /* access modifiers changed from: private */
    public int esu;
    /* access modifiers changed from: private */
    public int esv;

    /* renamed from: com.introvd.template.template.e.a$a */
    class C8716a implements C1517e<C8312a> {
        C8716a() {
        }

        /* renamed from: a */
        public void accept(C8312a aVar) throws Exception {
            switch (aVar.getFlag()) {
                case 9992:
                    long aGl = aVar.aGe().aGl();
                    if (C8715a.this.ess != null) {
                        C8715a.this.ess.mo35100W(aVar.getUrl(), (int) aGl);
                        return;
                    }
                    return;
                case 9994:
                    C8715a.this.esu = C8715a.this.esu + 1;
                    if (C8715a.this.ess != null) {
                        C8717b a = C8715a.this.ess;
                        String url = aVar.getUrl();
                        StringBuilder sb = new StringBuilder();
                        sb.append(aVar.getPath());
                        sb.append(aVar.getName());
                        a.mo25876a(url, true, sb.toString());
                    }
                    C8715a.this.aLs();
                    return;
                case 9995:
                    C8715a.this.esv = C8715a.this.esv + 1;
                    if (C8715a.this.ess != null) {
                        C8717b a2 = C8715a.this.ess;
                        String url2 = aVar.getUrl();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(aVar.getPath());
                        sb2.append(aVar.getName());
                        a2.mo25876a(url2, false, sb2.toString());
                    }
                    C8715a.this.aLs();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.introvd.template.template.e.a$b */
    public interface C8717b {
        /* renamed from: W */
        void mo35100W(String str, int i);

        /* renamed from: a */
        void mo25876a(String str, boolean z, String str2);

        /* renamed from: cb */
        void mo25877cb(int i, int i2);

        void onXytDownloadProgress(long j, int i);

        void onXytDownloadResult(Long l, boolean z);
    }

    /* renamed from: com.introvd.template.template.e.a$c */
    class C8718c implements C8708f {
        C8718c() {
        }

        /* renamed from: b */
        public void mo24951b(Long l) {
        }

        /* renamed from: c */
        public void mo24952c(long j, int i) {
            if (C8715a.this.ess != null) {
                C8715a.this.ess.onXytDownloadProgress(j, i);
            }
        }

        /* renamed from: c */
        public void mo24953c(Long l) {
            C8715a.this.esu = C8715a.this.esu + 1;
            if (C8715a.this.ess != null) {
                C8715a.this.ess.onXytDownloadResult(l, true);
            }
            if (C8715a.this.bOW != null) {
                C8715a.this.bOW.mo35076VD();
                C8715a.this.bOW = null;
            }
            C8715a.this.aLs();
        }

        /* renamed from: o */
        public void mo27389o(Long l) {
        }

        /* renamed from: p */
        public void mo27390p(Long l) {
            C8715a.this.esv = C8715a.this.esv + 1;
            if (C8715a.this.ess != null) {
                C8715a.this.ess.onXytDownloadResult(l, false);
            }
            if (C8715a.this.bOW != null) {
                C8715a.this.bOW.mo35076VD();
                C8715a.this.bOW = null;
            }
            C8715a.this.aLs();
        }
    }

    /* renamed from: com.introvd.template.template.e.a$d */
    public static class C8719d implements C8717b {
        /* renamed from: W */
        public void mo35100W(String str, int i) {
        }

        /* renamed from: a */
        public void mo25876a(String str, boolean z, String str2) {
        }

        /* renamed from: cb */
        public void mo25877cb(int i, int i2) {
        }

        public void onXytDownloadProgress(long j, int i) {
        }

        public void onXytDownloadResult(Long l, boolean z) {
        }
    }

    public C8715a(Context context2, C8717b bVar) {
        this.context = context2;
        this.ess = bVar;
    }

    /* access modifiers changed from: private */
    public void aLs() {
        if ((this.esu + this.esv == this.est) && this.ess != null) {
            this.ess.mo25877cb(this.esu, this.est);
        }
    }

    /* renamed from: B */
    public void mo35094B(TemplateInfo templateInfo) {
        if (this.bOW == null) {
            this.bOW = new C8703d(this.context, new C8718c());
        }
        EffectInfoModel effectInfoModel = new EffectInfoModel();
        effectInfoModel.mTemplateId = Long.decode(templateInfo.ttid).longValue();
        effectInfoModel.setmUrl(templateInfo.strUrl);
        this.bOW.mo35077a(effectInfoModel, "xytTemplate");
        C8735f.aMf().mo35136D(templateInfo);
        this.est++;
    }

    /* renamed from: cZ */
    public void mo35095cZ(List<EffectInfoModel> list) {
        if (this.bOW == null) {
            this.bOW = new C8703d(this.context, new C8718c());
        }
        for (EffectInfoModel a : list) {
            this.bOW.mo35077a(a, "xytTemplate");
            this.est++;
        }
    }

    /* renamed from: k */
    public void mo35096k(long j, String str) {
        if (this.bOW == null) {
            this.bOW = new C8703d(this.context, new C8718c());
        }
        EffectInfoModel effectInfoModel = new EffectInfoModel();
        effectInfoModel.mTemplateId = j;
        effectInfoModel.setmUrl(str);
        this.bOW.mo35077a(effectInfoModel, "xytTemplate");
        this.est++;
    }

    public void release() {
        if (this.bOW != null) {
            this.bOW.mo35076VD();
        }
        if (this.esq.size() > 0) {
            for (C1495b dispose : this.esq) {
                dispose.dispose();
            }
        }
    }

    /* renamed from: z */
    public void mo35098z(String str, String str2, String str3) {
        if (this.esr == null) {
            this.esr = new C8716a();
        }
        C8251a.m23820gI(this.context).mo33410tl(1).mo33409t(str, str2, str3).aTR();
        this.esq.add(C8251a.m23820gI(this.context).mo33405mE(str).mo10168g((C1517e<? super T>) this.esr));
        this.est++;
    }
}
