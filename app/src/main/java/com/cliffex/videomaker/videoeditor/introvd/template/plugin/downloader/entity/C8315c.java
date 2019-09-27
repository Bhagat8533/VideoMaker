package com.introvd.template.plugin.downloader.entity;

import com.introvd.template.plugin.downloader.business.C8271b;
import com.introvd.template.plugin.downloader.business.DownloadService;
import com.introvd.template.plugin.downloader.p371b.C8263a;
import java.util.Map;
import java.util.concurrent.Semaphore;
import p037b.p050b.p075i.C1815a;

/* renamed from: com.introvd.template.plugin.downloader.entity.c */
public abstract class C8315c {
    private boolean canceled = false;
    protected DownloadService dZO;
    protected C8271b dZP;
    C1815a<C8312a> eas;
    private boolean eat = false;

    C8315c(DownloadService downloadService, C8271b bVar) {
        this.dZO = downloadService;
        this.dZP = bVar;
    }

    /* renamed from: a */
    public abstract void mo33521a(C8263a aVar);

    /* renamed from: a */
    public abstract void mo33522a(C8263a aVar, boolean z);

    /* renamed from: a */
    public abstract void mo33523a(Map<String, C8315c> map, Map<String, C1815a<C8312a>> map2);

    /* renamed from: a */
    public abstract void mo33524a(Semaphore semaphore) throws InterruptedException;

    /* renamed from: b */
    public abstract void mo33525b(C8263a aVar);

    /* renamed from: c */
    public abstract void mo33526c(C8263a aVar);

    /* renamed from: iW */
    public void mo33527iW(boolean z) {
        this.canceled = z;
    }

    /* renamed from: iX */
    public void mo33528iX(boolean z) {
        this.eat = z;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isCompleted() {
        return this.eat;
    }
}
