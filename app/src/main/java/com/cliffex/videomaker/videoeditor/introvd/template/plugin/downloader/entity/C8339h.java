package com.introvd.template.plugin.downloader.entity;

import android.text.TextUtils;
import com.introvd.template.plugin.downloader.p371b.C8263a;
import com.introvd.template.plugin.downloader.p372c.C8296a;
import com.introvd.template.plugin.downloader.p373d.C8301b;
import com.introvd.template.plugin.downloader.p373d.C8302c;
import com.introvd.template.plugin.downloader.p373d.C8304e;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import okhttp3.C9804ad;
import org.p489b.C9961b;
import p037b.p050b.C1485a;
import p037b.p050b.C1510d;
import p037b.p050b.C1512e;
import p037b.p050b.C1521f;
import p037b.p050b.p057e.C1518f;
import p469f.C9768m;

/* renamed from: com.introvd.template.plugin.downloader.entity.h */
public class C8339h {
    private long contentLength;
    private int dZW;
    /* access modifiers changed from: private */
    public C8296a dZZ;
    /* access modifiers changed from: private */
    public C8313b eaE;
    private String eaH;
    private String eaI;
    private String eaJ;
    private String eaK;
    private boolean eaL = false;
    private boolean eaM = false;
    private C8301b eaN;
    private C8263a eaa;
    private String filePath;
    private int maxRetryCount;

    public C8339h(C8313b bVar) {
        this.eaE = bVar;
    }

    /* renamed from: a */
    public void mo33561a(int i, int i2, String str, C8296a aVar, C8263a aVar2) {
        this.dZW = i;
        this.maxRetryCount = i2;
        this.dZZ = aVar;
        this.eaa = aVar2;
        this.eaN = new C8301b(i);
        if (TextUtils.isEmpty(this.eaE.aGg())) {
            this.eaE.mo33517nl(str);
        } else {
            str = this.eaE.aGg();
        }
        C8302c.m23964k(str, TextUtils.concat(new CharSequence[]{str, File.separator, ".cache"}).toString());
        String[] aO = C8302c.m23959aO(this.eaE.aGf(), str);
        this.filePath = aO[0];
        this.eaI = aO[1];
        this.eaJ = aO[2];
        this.eaH = aO[3];
    }

    /* renamed from: a */
    public void mo33562a(C1512e<DownloadStatus> eVar, int i, C9804ad adVar) throws IOException {
        this.eaN.mo33483a(eVar, i, aGC(), aGE(), file(), adVar);
    }

    /* renamed from: a */
    public void mo33563a(C1512e<DownloadStatus> eVar, C9768m<C9804ad> mVar) {
        this.eaN.mo33484a(eVar, aGE(), file(), mVar);
    }

    public boolean aGA() {
        return this.eaL;
    }

    public boolean aGB() {
        return this.eaM;
    }

    public File aGC() {
        return new File(this.eaI);
    }

    public File aGD() {
        return new File(this.eaJ);
    }

    public File aGE() {
        return new File(this.eaH);
    }

    public boolean aGF() {
        return aGE().length() == this.contentLength || file().exists();
    }

    public boolean aGG() throws IOException {
        return this.eaN.mo33488e(aGC(), this.contentLength);
    }

    public String aGH() throws IOException {
        return this.eaN.mo33482C(aGD());
    }

    public boolean aGI() throws IOException {
        return this.eaN.mo33481B(aGC());
    }

    public String aGf() {
        return this.eaE.aGf();
    }

    public void aGv() throws IOException, ParseException {
        this.eaN.mo33485a(aGD(), aGE(), this.contentLength, this.eaK);
    }

    public void aGw() throws IOException, ParseException {
        this.eaN.mo33486a(aGD(), aGC(), aGE(), this.contentLength, this.eaK);
    }

    public C1510d<C9768m<C9804ad>> aGx() {
        return this.dZZ.mo33476aL(null, this.eaE.getUrl());
    }

    public int aGy() {
        return this.maxRetryCount;
    }

    public int aGz() {
        return this.dZW;
    }

    public void cancel() {
        this.eaa.mo33418F(this.eaE.getUrl(), 9993);
    }

    public void complete() {
        this.eaa.mo33418F(this.eaE.getUrl(), 9994);
    }

    public void error() {
        this.eaa.mo33418F(this.eaE.getUrl(), 9995);
    }

    /* renamed from: f */
    public void mo33582f(DownloadStatus downloadStatus) {
        this.eaa.mo33423e(this.eaE.getUrl(), downloadStatus);
    }

    public File file() {
        return new File(this.filePath);
    }

    public void finish() {
    }

    public long getContentLength() {
        return this.contentLength;
    }

    /* renamed from: iY */
    public void mo33586iY(boolean z) {
        this.eaL = z;
    }

    /* renamed from: iZ */
    public void mo33587iZ(boolean z) {
        this.eaM = z;
    }

    /* renamed from: nk */
    public void mo33588nk(String str) {
        this.eaE.mo33516nk(str);
    }

    /* renamed from: no */
    public void mo33589no(String str) {
        this.eaK = str;
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public void start() {
        if (this.eaa.mo33424ng(this.eaE.getUrl())) {
            this.eaa.mo33419a(this.eaE, 9992);
        } else {
            this.eaa.mo33420a(this.eaE.getUrl(), this.eaE.aGf(), this.eaE.aGg(), 9992);
        }
    }

    /* renamed from: tr */
    public C8316d mo33592tr(int i) throws IOException {
        return this.eaN.mo33487d(aGC(), i);
    }

    /* renamed from: ts */
    public C1510d<C9768m<C9804ad>> mo33593ts(final int i) {
        return C1510d.m4705a((C1521f<T>) new C1521f<C8316d>() {
            /* renamed from: a */
            public void mo9850a(C1512e<C8316d> eVar) throws Exception {
                C8316d tr = C8339h.this.mo33592tr(i);
                if (tr.aGi()) {
                    eVar.mo9791K(tr);
                }
                eVar.onComplete();
            }
        }, C1485a.ERROR).mo9809a((C1518f<? super T, ? extends C9961b<? extends R>>) new C1518f<C8316d, C9961b<C9768m<C9804ad>>>() {
            /* renamed from: a */
            public C9961b<C9768m<C9804ad>> apply(C8316d dVar) throws Exception {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread: ");
                sb.append(Thread.currentThread().getName());
                sb.append("; ");
                sb.append("Range %d start download from [%d] to [%d]");
                C8304e.m23974f(sb.toString(), Integer.valueOf(i), Long.valueOf(dVar.start), Long.valueOf(dVar.end));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("bytes=");
                sb2.append(dVar.start);
                sb2.append("-");
                sb2.append(dVar.end);
                return C8339h.this.dZZ.mo33476aL(sb2.toString(), C8339h.this.eaE.getUrl());
            }
        });
    }
}
