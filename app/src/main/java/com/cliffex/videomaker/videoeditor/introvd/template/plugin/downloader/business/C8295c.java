package com.introvd.template.plugin.downloader.business;

import android.text.TextUtils;
import com.introvd.template.plugin.downloader.entity.C8318f;
import com.introvd.template.plugin.downloader.entity.C8318f.C8326a;
import com.introvd.template.plugin.downloader.entity.C8318f.C8327b;
import com.introvd.template.plugin.downloader.entity.C8318f.C8330c;
import com.introvd.template.plugin.downloader.entity.C8318f.C8331d;
import com.introvd.template.plugin.downloader.entity.C8339h;
import com.introvd.template.plugin.downloader.p371b.C8263a;
import com.introvd.template.plugin.downloader.p372c.C8296a;
import com.introvd.template.plugin.downloader.p373d.C8303d;
import com.introvd.template.plugin.downloader.p373d.C8304e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p469f.C9768m;

/* renamed from: com.introvd.template.plugin.downloader.business.c */
public class C8295c {
    private Map<String, C8339h> map = new HashMap();

    /* renamed from: mV */
    private boolean m23920mV(String str) {
        return ((C8339h) this.map.get(str)).aGA();
    }

    /* renamed from: mW */
    private boolean m23921mW(String str) {
        return ((C8339h) this.map.get(str)).aGB();
    }

    /* renamed from: mX */
    private C8318f m23922mX(String str) {
        return m23920mV(str) ? new C8330c((C8339h) this.map.get(str)) : new C8331d((C8339h) this.map.get(str));
    }

    /* renamed from: mY */
    private C8318f m23923mY(String str) {
        return m23920mV(str) ? m23924mZ(str) : m23925na(str);
    }

    /* renamed from: mZ */
    private C8318f m23924mZ(String str) {
        if (m23928nd(str)) {
            return new C8330c((C8339h) this.map.get(str));
        }
        try {
            return m23926nb(str) ? new C8327b((C8339h) this.map.get(str)) : new C8326a((C8339h) this.map.get(str));
        } catch (IOException unused) {
            return new C8330c((C8339h) this.map.get(str));
        }
    }

    /* renamed from: na */
    private C8318f m23925na(String str) {
        return m23927nc(str) ? new C8331d((C8339h) this.map.get(str)) : new C8326a((C8339h) this.map.get(str));
    }

    /* renamed from: nb */
    private boolean m23926nb(String str) throws IOException {
        return ((C8339h) this.map.get(str)).aGI();
    }

    /* renamed from: nc */
    private boolean m23927nc(String str) {
        return !((C8339h) this.map.get(str)).aGF();
    }

    /* renamed from: nd */
    private boolean m23928nd(String str) {
        return m23930nf(str) || m23929ne(str);
    }

    /* renamed from: ne */
    private boolean m23929ne(String str) {
        try {
            return ((C8339h) this.map.get(str)).aGG();
        } catch (IOException unused) {
            C8304e.log("Record file may be damaged, so we will re-download");
            return true;
        }
    }

    /* renamed from: nf */
    private boolean m23930nf(String str) {
        return !((C8339h) this.map.get(str)).aGC().exists();
    }

    /* renamed from: a */
    public void mo33465a(String str, int i, int i2, String str2, C8296a aVar, C8263a aVar2) {
        ((C8339h) this.map.get(str)).mo33561a(i, i2, str2, aVar, aVar2);
    }

    /* renamed from: a */
    public void mo33466a(String str, C8339h hVar) {
        this.map.put(str, hVar);
    }

    /* renamed from: a */
    public void mo33467a(String str, C9768m<?> mVar, boolean z) {
        ((C8339h) this.map.get(str)).mo33586iY(z && !C8303d.m23968k(mVar));
    }

    /* renamed from: b */
    public void mo33468b(String str, C9768m<?> mVar) {
        C8339h hVar = (C8339h) this.map.get(str);
        if (TextUtils.isEmpty(hVar.aGf())) {
            hVar.mo33588nk(C8303d.m23965d(str, mVar));
        }
        hVar.setContentLength(C8303d.m23969l(mVar));
        hVar.mo33589no(C8303d.m23970m(mVar));
    }

    /* renamed from: c */
    public void mo33469c(String str, C9768m<Void> mVar) {
        if (mVar.aTm() == 304) {
            ((C8339h) this.map.get(str)).mo33587iZ(false);
        } else if (mVar.aTm() == 200) {
            ((C8339h) this.map.get(str)).mo33587iZ(true);
        }
    }

    public void delete(String str) {
        this.map.remove(str);
    }

    public boolean fileExists(String str) {
        return ((C8339h) this.map.get(str)).aGE().exists();
    }

    /* renamed from: gx */
    public boolean mo33472gx(String str) {
        return this.map.get(str) != null;
    }

    /* renamed from: mS */
    public C8318f mo33473mS(String str) {
        return m23922mX(str);
    }

    /* renamed from: mT */
    public C8318f mo33474mT(String str) {
        return m23921mW(str) ? m23922mX(str) : m23923mY(str);
    }

    /* renamed from: mU */
    public String mo33475mU(String str) {
        try {
            return ((C8339h) this.map.get(str)).aGH();
        } catch (IOException unused) {
            return "";
        }
    }
}
