package com.introvd.template.plugin.downloader.entity;

import com.introvd.template.plugin.downloader.business.C8270a;
import com.introvd.template.plugin.downloader.business.C8271b;
import com.introvd.template.plugin.downloader.business.DownloadService;
import com.introvd.template.plugin.downloader.p371b.C8263a;
import com.introvd.template.plugin.downloader.p373d.C8300a;
import com.introvd.template.plugin.downloader.p373d.C8302c;
import com.introvd.template.plugin.downloader.p373d.C8304e;
import com.introvd.template.plugin.downloader.p373d.C8305f;
import java.util.Map;
import java.util.concurrent.Semaphore;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1513a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p075i.C1815a;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.plugin.downloader.entity.g */
public class C8334g extends C8315c {
    private C1495b cTc;
    /* access modifiers changed from: private */
    public C8313b eaE;
    /* access modifiers changed from: private */
    public DownloadStatus eau;

    public C8334g(DownloadService downloadService, C8271b bVar, C8313b bVar2) {
        super(downloadService, bVar);
        this.eaE = bVar2;
    }

    /* renamed from: a */
    public void mo33521a(C8263a aVar) {
        if (aVar.mo33424ng(getUrl())) {
            aVar.mo33419a(this.eaE, 9991);
        } else {
            aVar.mo33418F(getUrl(), 9991);
        }
    }

    /* renamed from: a */
    public void mo33522a(C8263a aVar, boolean z) {
        if (z) {
            mo33525b(aVar);
            if (this.eas != null) {
                this.eas.mo9888K(C8270a.m23859a(getUrl(), null));
            }
        }
        C8317e ni = aVar.mo33426ni(getUrl());
        if (ni != null) {
            C8302c.m23963c(z ? C8302c.m23960aP(ni.aGf(), ni.aGg()) : C8302c.m23961aQ(ni.aGf(), ni.aGg()));
        }
        aVar.mo33425nh(getUrl());
    }

    /* renamed from: a */
    public void mo33523a(Map<String, C8315c> map, Map<String, C1815a<C8312a>> map2) {
        C8315c cVar = (C8315c) map.get(getUrl());
        if (cVar == null) {
            map.put(getUrl(), this);
        } else if (cVar.isCanceled()) {
            map.put(getUrl(), this);
        } else {
            throw new IllegalArgumentException(C8300a.m23946c("The url [%s] already exists.", getUrl()));
        }
        this.eas = C8305f.m23979c(getUrl(), map2);
    }

    /* renamed from: a */
    public void mo33524a(final Semaphore semaphore) throws InterruptedException {
        if (!isCanceled()) {
            semaphore.acquire();
            if (isCanceled()) {
                semaphore.release();
            } else {
                this.cTc = this.dZP.mo33441b(this.eaE).mo10157d(C1820a.aVi()).mo10154d((C1513a) new C1513a() {
                    public void run() throws Exception {
                        C8304e.log("finally and release...");
                        C8334g.this.mo33527iW(true);
                        semaphore.release();
                    }
                }).mo10129a((C1517e<? super T>) new C1517e<DownloadStatus>() {
                    /* renamed from: e */
                    public void accept(DownloadStatus downloadStatus) throws Exception {
                        C8334g.this.eau = downloadStatus;
                        C8334g.this.eas.mo9888K(C8270a.m23863c(C8334g.this.getUrl(), downloadStatus));
                    }
                }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
                    /* renamed from: m */
                    public void accept(Throwable th) throws Exception {
                        C8334g.this.eas.mo9888K(C8270a.m23860a(C8334g.this.getUrl(), C8334g.this.eau, th));
                    }
                }, (C1513a) new C1513a() {
                    public void run() throws Exception {
                        C8334g.this.dZO.mo33437v(C8334g.this.getUrl(), false);
                        C8334g.this.eas.mo9888K(C8270a.m23861a(C8334g.this.getUrl(), C8334g.this.eaE.aGf(), C8334g.this.eaE.aGg(), C8334g.this.eau));
                        C8334g.this.mo33528iX(true);
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public void mo33525b(C8263a aVar) {
        C8305f.m23980c(this.cTc);
        mo33527iW(true);
        if (this.eas != null && !isCompleted()) {
            this.eas.mo9888K(C8270a.m23864d(getUrl(), aVar.mo33427nj(getUrl())));
        }
    }

    /* renamed from: c */
    public void mo33526c(C8263a aVar) {
        this.eas.mo9888K(C8270a.m23862b(getUrl(), aVar.mo33427nj(getUrl())));
    }

    public String getUrl() {
        return this.eaE.getUrl();
    }
}
