package com.introvd.template.plugin.downloader.business;

import android.content.Context;
import android.os.Environment;
import com.introvd.template.plugin.downloader.entity.C8313b;
import com.introvd.template.plugin.downloader.entity.C8318f;
import com.introvd.template.plugin.downloader.entity.C8339h;
import com.introvd.template.plugin.downloader.entity.DownloadStatus;
import com.introvd.template.plugin.downloader.p371b.C8263a;
import com.introvd.template.plugin.downloader.p372c.C8296a;
import com.introvd.template.plugin.downloader.p372c.C8297b;
import com.introvd.template.plugin.downloader.p373d.C8300a;
import com.introvd.template.plugin.downloader.p373d.C8304e;
import com.introvd.template.plugin.downloader.p373d.C8305f;
import java.io.IOException;
import java.text.ParseException;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p055c.C1500a;
import p037b.p050b.p057e.C1513a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9768m;

/* renamed from: com.introvd.template.plugin.downloader.business.b */
public class C8271b {
    /* access modifiers changed from: private */
    public int dZW = 3;
    /* access modifiers changed from: private */
    public boolean dZX = true;
    /* access modifiers changed from: private */
    public String dZY = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
    /* access modifiers changed from: private */
    public C8296a dZZ = ((C8296a) C8297b.aGJ().mo37510S(C8296a.class));
    /* access modifiers changed from: private */
    public C8263a eaa;
    /* access modifiers changed from: private */
    public C8295c eab = new C8295c();
    /* access modifiers changed from: private */
    public int maxRetryCount = 3;

    public C8271b(Context context) {
        this.eaa = C8263a.m23832gJ(context.getApplicationContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C1840o<DownloadStatus> m23869a(C8318f fVar) throws IOException, ParseException {
        fVar.aGm();
        return fVar.aGn();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C1840o<Object> m23870a(final String str, final C9768m<Void> mVar) {
        return C1834l.m5254a((C1839n<T>) new C1839n<Object>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Object> mVar) throws Exception {
                C8271b.this.eab.mo33468b(str, mVar);
                mVar.mo9791K(new Object());
                mVar.onComplete();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: aK */
    public C1840o<Object> m23874aK(final String str, String str2) {
        return this.dZZ.mo33478aN(str2, str).mo10161e((C1517e<? super T>) new C1517e<C9768m<Void>>() {
            /* renamed from: f */
            public void accept(C9768m<Void> mVar) throws Exception {
                C8271b.this.eab.mo33469c(str, mVar);
            }
        }).mo10167f((C1518f<? super T, ? extends R>) new C1518f<C9768m<Void>, Object>() {
            /* renamed from: e */
            public Object apply(C9768m<Void> mVar) throws Exception {
                return new Object();
            }
        }).mo10136a(C8305f.m23976G("Request", this.maxRetryCount));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m23879c(C8313b bVar) {
        if (!this.eab.mo33472gx(bVar.getUrl())) {
            this.eab.mo33466a(bVar.getUrl(), new C8339h(bVar));
        } else {
            throw new IllegalArgumentException(C8300a.m23946c("The url [%s] already exists.", bVar.getUrl()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mI */
    public C1834l<C8318f> m23888mI(final String str) {
        return C1834l.m5257ah(Boolean.valueOf(true)).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Boolean, C1840o<Object>>() {
            /* renamed from: h */
            public C1840o<Object> apply(Boolean bool) throws Exception {
                return C8271b.this.m23892mN(str);
            }
        }).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Object, C1840o<Object>>() {
            /* renamed from: M */
            public C1840o<Object> apply(Object obj) throws Exception {
                return C8271b.this.m23894mP(str);
            }
        }).mo10161e((C1517e<? super T>) new C1517e<Object>() {
            public void accept(Object obj) throws Exception {
                C8271b.this.eab.mo33465a(str, C8271b.this.dZW, C8271b.this.maxRetryCount, C8271b.this.dZY, C8271b.this.dZZ, C8271b.this.eaa);
            }
        }).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Object, C1840o<C8318f>>() {
            /* renamed from: M */
            public C1840o<C8318f> apply(Object obj) throws Exception {
                return C8271b.this.eab.fileExists(str) ? C8271b.this.m23890mK(str) : C8271b.this.m23889mJ(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: mJ */
    public C1834l<C8318f> m23889mJ(final String str) {
        return C1834l.m5257ah(Boolean.valueOf(true)).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Boolean, C1840o<C8318f>>() {
            /* renamed from: h */
            public C1840o<C8318f> apply(Boolean bool) throws Exception {
                return C1834l.m5257ah(C8271b.this.eab.mo33473mS(str));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: mK */
    public C1834l<C8318f> m23890mK(final String str) {
        return C1834l.m5257ah(Boolean.valueOf(true)).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, String>() {
            /* renamed from: w */
            public String apply(Boolean bool) throws Exception {
                return C8271b.this.eab.mo33475mU(str);
            }
        }).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<String, C1840o<Object>>() {
            /* renamed from: iM */
            public C1840o<Object> apply(String str) throws Exception {
                return C8271b.this.m23874aK(str, str);
            }
        }).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Object, C1840o<C8318f>>() {
            /* renamed from: M */
            public C1840o<C8318f> apply(Object obj) throws Exception {
                return C1834l.m5257ah(C8271b.this.eab.mo33474mT(str));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: mM */
    public C1834l<Long> m23891mM(final String str) {
        return this.dZZ.mo33480nq(str).mo10167f((C1518f<? super T, ? extends R>) new C1518f<C9768m<Void>, Long>() {
            /* renamed from: d */
            public Long apply(C9768m<Void> mVar) throws Exception {
                if (mVar != null && mVar.isSuccessful()) {
                    return Long.valueOf(Long.parseLong(mVar.aWY().get("Content-Length")));
                }
                throw new IllegalArgumentException(C8300a.m23946c("The url [%s] is illegal.", str));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: mN */
    public C1840o<Object> m23892mN(final String str) {
        return this.dZZ.mo33479np(str).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<C9768m<Void>, C1840o<Object>>() {
            /* renamed from: c */
            public C1840o<Object> apply(C9768m<Void> mVar) throws Exception {
                return !mVar.isSuccessful() ? C8271b.this.m23893mO(str) : C8271b.this.m23870a(str, mVar);
            }
        }).mo10136a(C8305f.m23976G("Request", this.maxRetryCount));
    }

    /* access modifiers changed from: private */
    /* renamed from: mO */
    public C1840o<Object> m23893mO(final String str) {
        return this.dZZ.mo33480nq(str).mo10161e((C1517e<? super T>) new C1517e<C9768m<Void>>() {
            /* renamed from: f */
            public void accept(C9768m<Void> mVar) throws Exception {
                if (mVar.isSuccessful()) {
                    C8271b.this.eab.mo33468b(str, mVar);
                } else {
                    throw new IllegalArgumentException(C8300a.m23946c("The url [%s] is illegal.", str));
                }
            }
        }).mo10167f((C1518f<? super T, ? extends R>) new C1518f<C9768m<Void>, Object>() {
            /* renamed from: e */
            public Object apply(C9768m<Void> mVar) throws Exception {
                return new Object();
            }
        }).mo10136a(C8305f.m23976G("Request", this.maxRetryCount));
    }

    /* access modifiers changed from: private */
    /* renamed from: mP */
    public C1840o<Object> m23894mP(final String str) {
        return this.dZZ.mo33477aM("bytes=0-", str).mo10161e((C1517e<? super T>) new C1517e<C9768m<Void>>() {
            /* renamed from: f */
            public void accept(C9768m<Void> mVar) throws Exception {
                C8271b.this.eab.mo33467a(str, mVar, C8271b.this.dZX);
            }
        }).mo10167f((C1518f<? super T, ? extends R>) new C1518f<C9768m<Void>, Object>() {
            /* renamed from: e */
            public Object apply(C9768m<Void> mVar) throws Exception {
                return new Object();
            }
        }).mo10136a(C8305f.m23976G("Request", this.maxRetryCount));
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m23895u(Throwable th) {
        if (th instanceof C1500a) {
            for (Throwable v : ((C1500a) th).aUd()) {
                C8304e.m23975v(v);
            }
            return;
        }
        C8304e.m23975v(th);
    }

    /* renamed from: b */
    public C1834l<DownloadStatus> mo33441b(final C8313b bVar) {
        return C1834l.m5257ah(Boolean.valueOf(true)).mo10166f((C1517e<? super C1495b>) new C1517e<C1495b>() {
            /* renamed from: b */
            public void accept(C1495b bVar) throws Exception {
                C8271b.this.m23879c(bVar);
            }
        }).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Boolean, C1840o<C8318f>>() {
            /* renamed from: h */
            public C1840o<C8318f> apply(Boolean bool) throws Exception {
                return C8271b.this.m23888mI(bVar.getUrl());
            }
        }).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<C8318f, C1840o<DownloadStatus>>() {
            /* renamed from: b */
            public C1840o<DownloadStatus> apply(C8318f fVar) throws Exception {
                return C8271b.this.m23869a(fVar);
            }
        }).mo10155d((C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C8271b.this.m23895u(th);
            }
        }).mo10154d((C1513a) new C1513a() {
            public void run() throws Exception {
                C8271b.this.eab.delete(bVar.getUrl());
            }
        });
    }

    /* renamed from: mL */
    public C1834l<Long> mo33442mL(final String str) {
        return this.dZZ.mo33479np(str).mo10157d(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<C9768m<Void>, C1840o<Long>>() {
            /* renamed from: c */
            public C1840o<Long> apply(C9768m<Void> mVar) throws Exception {
                return (mVar == null || !mVar.isSuccessful()) ? C8271b.this.m23891mM(str).mo10157d(C1820a.aVi()) : C1834l.m5257ah(Long.valueOf(Long.parseLong(mVar.aWY().get("Content-Length")))).mo10157d(C1820a.aVi());
            }
        });
    }

    public void setMaxRetryCount(int i) {
        this.maxRetryCount = i;
    }

    /* renamed from: tn */
    public void mo33444tn(int i) {
        this.dZW = i;
    }
}
