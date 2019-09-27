package com.introvd.template.plugin.downloader.business;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.introvd.template.plugin.downloader.entity.C8312a;
import com.introvd.template.plugin.downloader.entity.C8315c;
import com.introvd.template.plugin.downloader.entity.C8317e;
import com.introvd.template.plugin.downloader.entity.C8334g;
import com.introvd.template.plugin.downloader.p371b.C8263a;
import com.introvd.template.plugin.downloader.p373d.C8302c;
import com.introvd.template.plugin.downloader.p373d.C8304e;
import com.introvd.template.plugin.downloader.p373d.C8305f;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p075i.C1815a;
import p037b.p050b.p076j.C1820a;

public class DownloadService extends Service {
    private C1495b cTc;
    /* access modifiers changed from: private */
    public Semaphore dZN;
    private C8263a eaa;
    private C8269a eaf;
    /* access modifiers changed from: private */
    public BlockingQueue<C8315c> eag;
    private Map<String, C8315c> eah;
    private Map<String, C1815a<C8312a>> eai;

    /* renamed from: com.introvd.template.plugin.downloader.business.DownloadService$a */
    public class C8269a extends Binder {
        public C8269a() {
        }

        public DownloadService aGb() {
            return DownloadService.this;
        }
    }

    private void aGa() {
        this.cTc = C1834l.m5254a((C1839n<T>) new C1839n<C8315c>() {
            /* renamed from: a */
            public void mo10177a(C1838m<C8315c> mVar) throws Exception {
                while (!mVar.aAy()) {
                    try {
                        C8304e.log("DownloadQueue waiting for mission come...");
                        C8315c cVar = (C8315c) DownloadService.this.eag.take();
                        C8304e.log("Mission coming!");
                        mVar.mo9791K(cVar);
                    } catch (InterruptedException unused) {
                        C8304e.log("Interrupt blocking queue.");
                    }
                }
                mVar.onComplete();
            }
        }).mo10157d(C1820a.aVi()).mo10128a((C1517e<? super T>) new C1517e<C8315c>() {
            /* renamed from: b */
            public void accept(C8315c cVar) throws Exception {
                cVar.mo33524a(DownloadService.this.dZN);
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C8304e.m23975v(th);
            }
        });
    }

    private void destroy() {
        C8305f.m23980c(this.cTc);
        for (C8315c b : this.eah.values()) {
            b.mo33525b(this.eaa);
        }
        this.eag.clear();
    }

    /* renamed from: a */
    public void mo33430a(C8315c cVar) throws InterruptedException {
        cVar.mo33523a(this.eah, this.eai);
        cVar.mo33521a(this.eaa);
        cVar.mo33526c(this.eaa);
        this.eag.put(cVar);
    }

    /* renamed from: mQ */
    public C1815a<C8312a> mo33431mQ(String str) {
        C1815a<C8312a> c = C8305f.m23979c(str, this.eai);
        if (((C8315c) this.eah.get(str)) == null) {
            C8317e ni = this.eaa.mo33426ni(str);
            if (ni == null) {
                c.mo9888K(C8270a.m23859a(str, null));
            } else if (C8302c.m23962b(C8302c.m23960aP(ni.aGf(), ni.aGg())).exists()) {
                c.mo9888K(C8270a.m23856a(ni.getFlag(), str, ni.aGj()));
            } else {
                c.mo9888K(C8270a.m23859a(str, null));
            }
        }
        return c;
    }

    /* renamed from: mR */
    public void mo33432mR(String str) {
        C8315c cVar = (C8315c) this.eah.get(str);
        if (cVar != null && (cVar instanceof C8334g)) {
            cVar.mo33525b(this.eaa);
        }
    }

    public IBinder onBind(Intent intent) {
        C8304e.log("bind Download Service");
        aGa();
        return this.eaf;
    }

    public void onCreate() {
        super.onCreate();
        this.eaf = new C8269a();
        this.eag = new LinkedBlockingQueue();
        this.eai = new ConcurrentHashMap();
        this.eah = new ConcurrentHashMap();
        this.eaa = C8263a.m23832gJ(getApplicationContext());
    }

    public void onDestroy() {
        super.onDestroy();
        C8304e.log("destroy Download Service");
        destroy();
        this.eaa.aGd();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C8304e.log("start Download Service");
        this.eaa.aGc();
        if (intent != null) {
            this.dZN = new Semaphore(intent.getIntExtra("quvideo_xiaoying_max_download_number", 5));
        }
        return super.onStartCommand(intent, i, i2);
    }

    /* renamed from: v */
    public void mo33437v(String str, boolean z) {
        C8315c cVar = (C8315c) this.eah.get(str);
        if (cVar == null || !(cVar instanceof C8334g)) {
            C8305f.m23979c(str, this.eai).mo9888K(C8270a.m23859a(str, null));
            C8317e ni = this.eaa.mo33426ni(str);
            if (ni != null) {
                C8302c.m23963c(z ? C8302c.m23960aP(ni.aGf(), ni.aGg()) : C8302c.m23961aQ(ni.aGf(), ni.aGg()));
            }
            this.eaa.mo33425nh(str);
            return;
        }
        cVar.mo33522a(this.eaa, z);
        this.eah.remove(str);
    }
}
