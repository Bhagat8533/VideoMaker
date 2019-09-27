package com.introvd.template.plugin.downloader;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.introvd.template.plugin.downloader.business.C8271b;
import com.introvd.template.plugin.downloader.business.DownloadService;
import com.introvd.template.plugin.downloader.business.DownloadService.C8269a;
import com.introvd.template.plugin.downloader.entity.C8312a;
import com.introvd.template.plugin.downloader.entity.C8313b;
import com.introvd.template.plugin.downloader.entity.C8313b.C8314a;
import com.introvd.template.plugin.downloader.entity.C8315c;
import com.introvd.template.plugin.downloader.entity.C8334g;
import com.introvd.template.plugin.downloader.p373d.C8304e;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.util.concurrent.Semaphore;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p074h.C1813a;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.plugin.downloader.a */
public class C8251a {
    /* access modifiers changed from: private */
    public static volatile boolean bound = false;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile C8251a dZL;
    private static final Object object = new Object();
    /* access modifiers changed from: private */
    public Context context;
    private int dZM = 5;
    /* access modifiers changed from: private */
    public Semaphore dZN;
    /* access modifiers changed from: private */
    public DownloadService dZO;
    /* access modifiers changed from: private */
    public C8271b dZP;

    /* renamed from: com.introvd.template.plugin.downloader.a$a */
    private interface C8260a {
        void aFZ() throws Exception;
    }

    /* renamed from: com.introvd.template.plugin.downloader.a$b */
    private interface C8261b {
        void aFZ();
    }

    static {
        C1813a.m5223i((C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                if (th instanceof InterruptedException) {
                    C8304e.log("Thread interrupted");
                } else if (th instanceof InterruptedIOException) {
                    C8304e.log("Io interrupted");
                } else if (th instanceof SocketException) {
                    C8304e.log("Socket error");
                }
            }
        });
    }

    private C8251a(Context context2) {
        this.context = context2.getApplicationContext();
        this.dZP = new C8271b(context2);
        this.dZN = new Semaphore(1);
    }

    /* renamed from: a */
    private C1834l<?> m23810a(final C8260a aVar) {
        return C1834l.m5254a((C1839n<T>) new C1839n<Object>() {
            /* renamed from: a */
            public void mo10177a(final C1838m<Object> mVar) throws Exception {
                if (!C8251a.bound) {
                    C8251a.this.dZN.acquire();
                    if (!C8251a.bound) {
                        C8251a.this.m23814a((C8261b) new C8261b() {
                            public void aFZ() {
                                C8251a.this.m23813a(aVar, mVar);
                                C8251a.this.dZN.release();
                            }
                        });
                        return;
                    }
                    C8251a.this.m23813a(aVar, mVar);
                    C8251a.this.dZN.release();
                    return;
                }
                C8251a.this.m23813a(aVar, mVar);
            }
        }).mo10157d(C1820a.aVi());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23813a(C8260a aVar, C1838m<Object> mVar) {
        if (aVar != null) {
            try {
                aVar.aFZ();
            } catch (Exception e) {
                mVar.onError(e);
            }
        }
        mVar.mo9791K(object);
        mVar.onComplete();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23814a(final C8261b bVar) {
        Intent intent = new Intent(this.context, DownloadService.class);
        intent.putExtra("quvideo_xiaoying_max_download_number", this.dZM);
        this.context.startService(intent);
        this.context.bindService(intent, new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                C8251a.this.dZO = ((C8269a) iBinder).aGb();
                C8251a.this.context.unbindService(this);
                C8251a.bound = true;
                bVar.aFZ();
            }

            public void onServiceDisconnected(ComponentName componentName) {
                C8251a.bound = false;
            }
        }, 1);
    }

    /* renamed from: gI */
    public static C8251a m23820gI(Context context2) {
        if (dZL == null) {
            synchronized (C8251a.class) {
                if (dZL == null) {
                    dZL = new C8251a(context2);
                }
            }
        }
        return dZL;
    }

    /* renamed from: a */
    public C1834l<?> mo33404a(final C8313b bVar) {
        return m23810a((C8260a) new C8260a() {
            public void aFZ() throws InterruptedException {
                C8251a.this.dZO.mo33430a((C8315c) new C8334g(C8251a.this.dZO, C8251a.this.dZP, bVar));
            }
        }).mo10152c(C1487a.aUa());
    }

    /* renamed from: mE */
    public C1834l<C8312a> mo33405mE(final String str) {
        return m23810a((C8260a) null).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Object, C1840o<C8312a>>() {
            /* renamed from: M */
            public C1840o<C8312a> apply(Object obj) throws Exception {
                return C8251a.this.dZO.mo33431mQ(str).aTS();
            }
        }).mo10152c(C1487a.aUa());
    }

    /* renamed from: mF */
    public C1834l<?> mo33406mF(final String str) {
        return m23810a((C8260a) new C8260a() {
            public void aFZ() {
                C8251a.this.dZO.mo33432mR(str);
            }
        }).mo10152c(C1487a.aUa());
    }

    /* renamed from: mG */
    public C1834l<?> mo33407mG(final String str) {
        return m23810a((C8260a) new C8260a() {
            public void aFZ() {
                C8251a.this.dZO.mo33437v(str, true);
            }
        }).mo10152c(C1487a.aUa());
    }

    /* renamed from: mH */
    public C1834l<Long> mo33408mH(String str) {
        return this.dZP.mo33442mL(str);
    }

    /* renamed from: t */
    public C1834l<?> mo33409t(String str, String str2, String str3) {
        return mo33404a(new C8314a(str).mo33519nm(str2).mo33520nn(str3).aGh());
    }

    /* renamed from: tl */
    public C8251a mo33410tl(int i) {
        this.dZP.mo33444tn(i);
        return this;
    }

    /* renamed from: tm */
    public C8251a mo33411tm(int i) {
        this.dZP.setMaxRetryCount(i);
        return this;
    }
}
